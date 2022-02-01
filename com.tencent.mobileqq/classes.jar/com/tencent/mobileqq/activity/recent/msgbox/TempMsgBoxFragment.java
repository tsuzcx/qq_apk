package com.tencent.mobileqq.activity.recent.msgbox;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.ConversationProxyObserver;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.data.RecentTempMsgBoxItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class TempMsgBoxFragment
  extends IphoneTitleBarFragment
  implements GestureDetector.OnGestureListener, View.OnTouchListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  protected BaseActivity a;
  protected QQAppInterface b;
  GestureDetector c;
  protected boolean d;
  protected TextView e;
  private float f;
  private XListView g;
  private RecentAdapter h;
  private DragFrameLayout i;
  private boolean j = true;
  private TempMsgBoxObserver k;
  private ConversationProxyObserver l;
  private int m;
  
  private void a(int paramInt, String paramString)
  {
    TextView localTextView;
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      localTextView = this.mLeftBackText;
    } else {
      localTextView = this.e;
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
  
  private void a(QQMessageFacade paramQQMessageFacade)
  {
    int n = paramQQMessageFacade.w() + QCallFacade.a(this.b) - ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempMsgBoxUnread(this.b);
    if (n > 99) {
      paramQQMessageFacade = "99+";
    } else if (n <= 0) {
      paramQQMessageFacade = "";
    } else {
      paramQQMessageFacade = String.valueOf(n);
    }
    this.a.runOnUiThread(new TempMsgBoxFragment.7(this, n, paramQQMessageFacade));
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    int n;
    if ((paramRecentBaseData instanceof RecentTempMsgBoxItem))
    {
      RecentTempMsgBoxItem localRecentTempMsgBoxItem = (RecentTempMsgBoxItem)paramRecentBaseData;
      paramRecentBaseData = localRecentTempMsgBoxItem.e();
      n = localRecentTempMsgBoxItem.mPosition;
    }
    else
    {
      paramRecentBaseData = null;
      n = -1;
    }
    if (paramRecentBaseData != null) {
      RecentUtil.a(this.b, paramRecentBaseData, n);
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUser localRecentUser = this.b.getRecentUserProxy().b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("enter_from_temp_msg_box", true);
    localBundle.putBoolean("need_to_show_unread_num", true);
    localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
    RecentUtil.a(this.a, this.b, localRecentUser, paramString, paramBoolean, 3, paramRecentBaseData, localBundle, null);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, "initData() called");
    }
    a();
    this.b.getMessageFacade().addObserver(this);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, "initTitleBar");
    }
    setTitle(this.a.getString(2131897431));
    ImageView localImageView = this.rightViewImg;
    localImageView.setImageResource(2130852264);
    localImageView.setContentDescription(getString(2131897429));
    localImageView.setOnClickListener(new TempMsgBoxFragment.4(this));
    localImageView.setVisibility(0);
    g();
    this.titleRoot.setBackgroundResource(2130852228);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, "initContentView");
    }
    this.g = ((XListView)this.mContentView.findViewById(2131446974));
    this.g.setVisibility(0);
    View localView = View.inflate(this.a, 2131624518, null);
    this.g.addFooterView(localView);
    this.h = new RecentAdapter(this.a, this.b, this.g, this, 15);
    this.h.a(23);
    this.g.setAdapter(this.h);
    if (this.i == null)
    {
      this.i = DragFrameLayout.a(this.a);
      this.i.a(this, false);
    }
    this.h.a(this.i);
  }
  
  private void g()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      h();
      return;
    }
    BaseActivity localBaseActivity = this.a;
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.runOnUiThread(new TempMsgBoxFragment.5(this));
  }
  
  private void h()
  {
    if ((this.leftView != null) && (this.mLeftBackText != null) && (this.e != null))
    {
      if (!isAdded()) {
        return;
      }
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.e.setVisibility(8);
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131901576));
        AIOUtils.a(this.mLeftBackText, 0, 0, 0, (int)(this.mDensity * 30.0F + 0.5F));
      }
      else
      {
        this.leftView.setVisibility(0);
        localObject = getResources().getColorStateList(2131167990);
        this.e.setTextColor((ColorStateList)localObject);
        GradientDrawable localGradientDrawable = (GradientDrawable)this.e.getBackground();
        if (localGradientDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            localGradientDrawable.setColor((ColorStateList)localObject);
          } else {
            localGradientDrawable.setColor(((ColorStateList)localObject).getDefaultColor());
          }
          localGradientDrawable.setAlpha(46);
        }
        if (!ThemeUtil.isNowThemeIsSimple(this.b, false, null))
        {
          localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(28.0F, getResources());
          this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          localObject = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(5.0F, getResources());
          this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
        localObject = this.e;
      }
      Object localObject = this.b.getMessageFacade();
      if (localObject == null) {
        return;
      }
      ThreadManager.post(new TempMsgBoxFragment.6(this, (QQMessageFacade)localObject), 8, null, true);
    }
  }
  
  public void a()
  {
    Object localObject1 = ((ITempMsgBoxManager)this.b.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshTempMsgBoxList() called ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("TempMsgBoxFragment", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ArrayList(((List)localObject1).size());
    int n = 0;
    while (n < ((List)localObject1).size())
    {
      Object localObject3 = (RecentUser)((List)localObject1).get(n);
      if (localObject3 != null)
      {
        localObject3 = new RecentTempMsgBoxItem((RecentUser)localObject3);
        ((RecentTempMsgBoxItem)localObject3).update(this.b, this.a);
        ((List)localObject2).add(localObject3);
      }
      n += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshTempMsgBoxList() after sort ");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.d("TempMsgBoxFragment", 2, ((StringBuilder)localObject1).toString());
    }
    this.a.runOnUiThread(new TempMsgBoxFragment.3(this, (List)localObject2));
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -1))
    {
      this.m = (paramInt | this.m & (paramInt ^ 0xFFFFFFFF));
      return;
    }
    this.m = paramInt;
  }
  
  public boolean b()
  {
    return this.m == 0;
  }
  
  public boolean b(int paramInt)
  {
    return (!c()) && ((this.m & paramInt) == paramInt);
  }
  
  public boolean c()
  {
    return this.m == -1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.c;
    if ((localGestureDetector != null) && (localGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.c = new GestureDetector(this);
    this.f = (ViewConfiguration.get(getBaseActivity()).getScaledDoubleTapSlop() * 2);
    paramLayoutInflater = (LinearLayout)this.mContentView.findViewById(2131446975);
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setOnTouchListener(this);
      paramLayoutInflater.setLongClickable(true);
    }
    this.e = ((TextView)this.titleRoot.findViewById(2131436218));
    f();
    e();
    d();
  }
  
  protected int getContentLayoutId()
  {
    return 2131629385;
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
    this.a = getBaseActivity();
    this.b = ((QQAppInterface)this.a.getAppInterface());
    this.k = new TempMsgBoxFragment.1(this);
    this.l = new TempMsgBoxFragment.2(this);
    this.b.registObserver(this.k);
    this.b.registObserver(this.l);
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, new Object[] { "doOnCreate ", this.a });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.h;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
    localObject = this.g;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    localObject = this.i;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    this.b.unRegistObserver(this.k);
    this.b.unRegistObserver(this.l);
    this.h = null;
    localObject = this.b.getMessageFacade();
    if (localObject != null) {
      ((QQMessageFacade)localObject).deleteObserver(this);
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
            if (this.j)
            {
              this.a.finish();
              return true;
            }
            this.j = true;
            return false;
          }
        }
        else if ((b(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
        {
          a(-1);
          this.j = false;
        }
      }
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(" data ");
      paramString2.append(paramRecentBaseData);
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "menuItem clicked ", paramString1, paramString2.toString(), " uin ", paramRecentBaseData.getRecentUserUin(), " type ", Integer.valueOf(paramRecentBaseData.getRecentUserType()) });
    }
    if (Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[3]))) {
      ((ITempMsgBoxManager)this.b.getRuntimeService(ITempMsgBoxManager.class, "")).updateIsTop(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), true);
    } else if (Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[2]))) {
      ((ITempMsgBoxManager)this.b.getRuntimeService(ITempMsgBoxManager.class, "")).updateIsTop(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), false);
    }
    a();
    g();
  }
  
  public void onPause()
  {
    super.onPause();
    ((ITempMsgBoxManager)this.b.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(true);
    this.b.getConversationFacade().b(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "click tempMsgBox item: ", paramString, ", recentDataUin: ", paramRecentBaseData.getRecentUserUin(), ", recentDataType: ", Integer.valueOf(paramRecentBaseData.getRecentUserType()) });
    }
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.getRecentUserType() == 10012)
    {
      paramView = new Intent();
      PublicFragmentActivity.a(getBaseActivity(), paramView, FilterMsgBoxFragment.class);
      paramView = Integer.valueOf(10000);
    }
    else
    {
      if (paramRecentBaseData.getUnreadNum() > 0) {
        this.d = true;
      }
      paramView = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getServiceIdMap().get(Integer.valueOf(paramRecentBaseData.getRecentUserType()));
      a(paramRecentBaseData, paramString, paramBoolean);
    }
    if ((paramView != null) && (paramView.intValue() >= 0)) {
      ReportController.b(this.b, "dc00898", "", "", "0X800B1C0", "0X800B1C0", paramView.intValue(), 0, "", "", "", "");
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData);
    paramString = ((ITempMsgBoxManager)this.b.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecentBaseDataDelete() called with: data = [");
      localStringBuilder.append(paramRecentBaseData);
      localStringBuilder.append("], msgBoxRecentUsers = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("TempMsgBoxFragment", 2, localStringBuilder.toString());
    }
    if (paramString.isEmpty())
    {
      paramRecentBaseData = this.b.getRecentUserProxy().b(AppConstants.TEMP_MSG_BOX_UIN, 10011);
      this.b.getRecentUserProxy().a(paramRecentBaseData, false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    g();
    ((ITempMsgBoxManager)this.b.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(true);
    this.b.getConversationFacade().b(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
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
        if (Math.abs(paramFloat2) > this.f)
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
    paramView = this.c;
    return (paramView != null) && (paramView.onTouchEvent(paramMotionEvent));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "updateMsg called ", paramObject });
    }
    a();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment
 * JD-Core Version:    0.7.0.1
 */