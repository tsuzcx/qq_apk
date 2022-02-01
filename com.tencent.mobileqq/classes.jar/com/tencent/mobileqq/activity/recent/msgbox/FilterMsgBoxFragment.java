package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentFilterMsgBoxDataItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class FilterMsgBoxFragment
  extends IphoneTitleBarFragment
  implements GestureDetector.OnGestureListener, View.OnTouchListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  FPSSwipListView a;
  RecentAdapter b;
  protected DragFrameLayout c;
  GestureDetector d;
  protected boolean e;
  private Context f;
  private QQAppInterface g;
  private float h;
  private boolean i = true;
  private TempMsgBoxObserver j;
  private TextView k;
  private int l;
  
  private void a(int paramInt, String paramString)
  {
    TextView localTextView;
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      localTextView = this.mLeftBackText;
    } else {
      localTextView = this.k;
    }
    if (localTextView == null) {
      return;
    }
    if (paramInt <= 0)
    {
      localTextView.setVisibility(4);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
    localTextView.setContentDescription(paramString);
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData != null)
    {
      RecentUser localRecentUser = null;
      int m = -1;
      if ((paramRecentBaseData instanceof RecentFilterMsgBoxDataItem))
      {
        paramRecentBaseData = (RecentFilterMsgBoxDataItem)paramRecentBaseData;
        localRecentUser = paramRecentBaseData.e();
        m = paramRecentBaseData.mPosition;
      }
      if (localRecentUser != null) {
        RecentUtil.a(this.g, localRecentUser, m);
      }
    }
  }
  
  private void d()
  {
    List localList = e();
    getBaseActivity().runOnUiThread(new FilterMsgBoxFragment.2(this, localList));
  }
  
  private List<RecentBaseData> e()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(this.g).iterator();
    RecentUser localRecentUser;
    while (((Iterator)localObject1).hasNext())
    {
      localRecentUser = (RecentUser)((Iterator)localObject1).next();
      localObject2 = new MessageRecord();
      ((MessageRecord)localObject2).istroop = localRecentUser.getType();
      ((MessageRecord)localObject2).senderuin = localRecentUser.uin;
      localArrayList.add(localObject2);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fillData() called ");
      ((StringBuilder)localObject1).append(localArrayList);
      QLog.d("FilterMessageBoxFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new ArrayList();
    RecentUserProxy localRecentUserProxy = this.g.getProxyManager().g();
    int m = 0;
    while (m < localArrayList.size())
    {
      localObject1 = (MessageRecord)localArrayList.get(m);
      String str = ((MessageRecord)localObject1).senderuin;
      int n = ((MessageRecord)localObject1).istroop;
      localRecentUser = localRecentUserProxy.c(str, n);
      localObject1 = localRecentUser;
      if (localRecentUser == null) {
        localObject1 = new RecentUser(str, n);
      }
      localObject1 = new RecentFilterMsgBoxDataItem((RecentUser)localObject1);
      ((RecentFilterMsgBoxDataItem)localObject1).update(this.g, this.f);
      ((List)localObject2).add(localObject1);
      m += 1;
    }
    return localObject2;
  }
  
  private void f()
  {
    setTitle(this.f.getResources().getString(2131889467));
    this.rightViewText.setText(2131915670);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(new FilterMsgBoxFragment.3(this));
    h();
  }
  
  private void g()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.f, null);
    localActionSheet.setMainTitle(2131915672);
    localActionSheet.addButton(2131915671, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new FilterMsgBoxFragment.4(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void h()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      i();
      return;
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.runOnUiThread(new FilterMsgBoxFragment.5(this));
  }
  
  private void i()
  {
    if ((this.leftView != null) && (this.mLeftBackText != null) && (this.k != null))
    {
      if (!isAdded()) {
        return;
      }
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.k.setVisibility(8);
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131901576));
        AIOUtils.a(this.mLeftBackText, 0, 0, 0, (int)(this.mDensity * 30.0F + 0.5F));
      }
      else
      {
        this.leftView.setVisibility(0);
        Object localObject = getResources().getColorStateList(2131167990);
        this.k.setTextColor((ColorStateList)localObject);
        GradientDrawable localGradientDrawable = (GradientDrawable)this.k.getBackground();
        if (localGradientDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            localGradientDrawable.setColor((ColorStateList)localObject);
          } else {
            localGradientDrawable.setColor(((ColorStateList)localObject).getDefaultColor());
          }
          localGradientDrawable.setAlpha(46);
        }
        if (!ThemeUtil.isNowThemeIsSimple(this.g, false, null))
        {
          localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(28.0F, getResources());
          this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
          localObject = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(5.0F, getResources());
          this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
        localObject = this.k;
      }
      ThreadManager.post(new FilterMsgBoxFragment.6(this), 8, null, true);
    }
  }
  
  private void j()
  {
    int m = this.g.getMessageFacade().w() + QCallFacade.a(this.g);
    String str;
    if (m > 99) {
      str = "99+";
    } else if (m <= 0) {
      str = "";
    } else {
      str = String.valueOf(m);
    }
    getBaseActivity().runOnUiThread(new FilterMsgBoxFragment.7(this, m, str));
  }
  
  private void k()
  {
    this.a = ((FPSSwipListView)this.mContentView.findViewById(2131433166));
    this.a.setVisibility(0);
    View localView = View.inflate(this.f, 2131624780, null);
    this.a.addHeaderView(localView);
    localView = View.inflate(this.f, 2131624518, null);
    this.a.addFooterView(localView);
    this.b = new RecentAdapter(this.f, this.g, this.a, this, 14);
    this.b.a(22);
    this.a.setAdapter(this.b);
    if (this.c == null)
    {
      this.c = DragFrameLayout.a(getBaseActivity());
      this.c.a(this, false);
    }
    this.b.a(this.c);
  }
  
  public void a()
  {
    ThreadManager.excute(new FilterMsgBoxFragment.8(this), 32, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -1))
    {
      this.l = (paramInt | this.l & (paramInt ^ 0xFFFFFFFF));
      return;
    }
    this.l = paramInt;
  }
  
  protected void a(RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.g.getProxyManager().g();
    String str = paramRecentBaseData.getRecentUserUin();
    int m = paramRecentBaseData.getRecentUserType();
    if ((str != null) && (str.length() != 0) && (localRecentUserProxy != null))
    {
      paramString = localRecentUserProxy.c(str, m);
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = new RecentUser(str, m);
      }
      if (paramBoolean) {
        paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);
      } else {
        paramRecentBaseData.showUpTime = 0L;
      }
      localRecentUserProxy.b(paramRecentBaseData);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("onMenuItemClick error, %s ");
      boolean bool = true;
      if (str == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramRecentBaseData.append(paramBoolean);
      paramRecentBaseData.append(" ");
      if (localRecentUserProxy == null) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      paramRecentBaseData.append(paramBoolean);
      QLog.d("FilterMessageBoxFragment", 2, paramRecentBaseData.toString());
    }
  }
  
  public boolean b()
  {
    return this.l == 0;
  }
  
  public boolean b(int paramInt)
  {
    return (!c()) && ((this.l & paramInt) == paramInt);
  }
  
  public boolean c()
  {
    return this.l == -1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.d;
    if ((localGestureDetector != null) && (localGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.h = (ViewConfiguration.get(getBaseActivity()).getScaledDoubleTapSlop() * 2);
    this.e = true;
    this.d = new GestureDetector(this.f, this);
    paramLayoutInflater = this.mContentView.findViewById(2131433167);
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setOnTouchListener(this);
      paramLayoutInflater.setLongClickable(true);
    }
    this.k = ((TextView)this.titleRoot.findViewById(2131436218));
    k();
    f();
    d();
    this.g.getMessageFacade().addObserver(this);
  }
  
  protected int getContentLayoutId()
  {
    return 2131624779;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout) {}
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = getBaseActivity();
    this.g = getBaseActivity().app;
    this.j = new FilterMsgBoxFragment.1(this);
    this.g.registObserver(this.j);
    if (QLog.isColorLevel()) {
      QLog.e("FilterMessageBoxFragment", 2, new Object[] { "doOnCreate ", this.f });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.b;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
    localObject = this.a;
    if (localObject != null) {
      ((FPSSwipListView)localObject).setAdapter(null);
    }
    localObject = this.c;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    this.g.unRegistObserver(this.j);
    this.b = null;
    if (this.g.getMessageFacade() != null) {
      this.g.getMessageFacade().deleteObserver(this);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!b())
    {
      if (c()) {
        return false;
      }
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent2 == null) {
          return false;
        }
        paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
        paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
        if (b(1))
        {
          if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.5F))
          {
            a(-1);
            if (this.i)
            {
              getBaseActivity().finish();
              return true;
            }
            this.i = true;
            return false;
          }
        }
        else if ((b(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
        {
          a(-1);
          this.i = false;
        }
      }
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    if (Utils.a(paramString1, localResources.getString(2131888206))) {
      a(paramRecentBaseData, paramString2, false);
    } else if (Utils.a(paramString1, localResources.getString(2131888211))) {
      a(paramRecentBaseData, paramString2, true);
    }
    h();
    d();
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if ((paramRecentBaseData instanceof RecentFilterMsgBoxDataItem))
    {
      paramView = ((RecentFilterMsgBoxDataItem)paramRecentBaseData).e();
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
      RecentUtil.a(getBaseActivity(), this.g, paramView, paramString, paramBoolean, 3, paramRecentBaseData, localBundle, null);
      ReportController.b(this.g, "dc00898", "", "", "0X800B5C8", "0X800B5C8", 0, 0, "", "", "", "");
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.e)
    {
      a(paramRecentBaseData);
      return;
    }
    paramString = (QCallFacade)this.g.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if ((paramString != null) && (paramRecentBaseData != null)) {}
    try
    {
      paramString.d(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
      return;
    }
    catch (Exception paramRecentBaseData)
    {
      label48:
      break label48;
    }
    QLog.e("FilterMessageBoxFragment", 1, "delRecentCallByUin Error");
  }
  
  public void onResume()
  {
    super.onResume();
    h();
    d();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (c()) {
      return false;
    }
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f1 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
      if (b())
      {
        if (Math.abs(paramFloat2) > this.h)
        {
          if ((paramFloat1 < 0.0F) && (f1 < 0.5F))
          {
            a(1);
            return true;
          }
          if ((paramFloat1 > 0.0F) && (f1 < 0.5F))
          {
            a(2);
            return true;
          }
        }
      }
      else if (b(1))
      {
        if ((paramFloat1 > 0.0F) || (f1 >= 0.5F))
        {
          a(-1);
          return false;
        }
      }
      else if ((b(2)) && ((paramFloat1 < 0.0F) || (f1 >= 0.5F))) {
        a(-1);
      }
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a(-1);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.d;
    return (paramView != null) && (paramView.onTouchEvent(paramMotionEvent));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    h();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment
 * JD-Core Version:    0.7.0.1
 */