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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  protected DragFrameLayout a;
  private TempMsgBoxObserver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  protected boolean a;
  private boolean b = true;
  
  private List<RecentBaseData> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).iterator();
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
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    int i = 0;
    while (i < localArrayList.size())
    {
      localObject1 = (MessageRecord)localArrayList.get(i);
      String str = ((MessageRecord)localObject1).senderuin;
      int j = ((MessageRecord)localObject1).istroop;
      localRecentUser = localRecentUserProxy.b(str, j);
      localObject1 = localRecentUser;
      if (localRecentUser == null) {
        localObject1 = new RecentUser(str, j);
      }
      localObject1 = new RecentFilterMsgBoxDataItem((RecentUser)localObject1);
      ((RecentFilterMsgBoxDataItem)localObject1).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
      ((List)localObject2).add(localObject1);
      i += 1;
    }
    return localObject2;
  }
  
  private void a(int paramInt, String paramString)
  {
    TextView localTextView;
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      localTextView = this.mLeftBackText;
    } else {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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
      int i = -1;
      if ((paramRecentBaseData instanceof RecentFilterMsgBoxDataItem))
      {
        paramRecentBaseData = (RecentFilterMsgBoxDataItem)paramRecentBaseData;
        localRecentUser = paramRecentBaseData.a();
        i = paramRecentBaseData.mPosition;
      }
      if (localRecentUser != null) {
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, i);
      }
    }
  }
  
  private void b()
  {
    List localList = a();
    getBaseActivity().runOnUiThread(new FilterMsgBoxFragment.2(this, localList));
  }
  
  private void c()
  {
    setTitle(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692479));
    this.rightViewText.setText(2131718190);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(new FilterMsgBoxFragment.3(this));
    e();
  }
  
  private void d()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.setMainTitle(2131718192);
    localActionSheet.addButton(2131718191, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new FilterMsgBoxFragment.4(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void e()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      f();
      return;
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.runOnUiThread(new FilterMsgBoxFragment.5(this));
  }
  
  private void f()
  {
    if ((this.leftView != null) && (this.mLeftBackText != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      if (!isAdded()) {
        return;
      }
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setContentDescription(HardCodeUtil.a(2131714984));
        AIOUtils.a(this.mLeftBackText, 0, 0, 0, (int)(this.mDensity * 30.0F + 0.5F));
      }
      else
      {
        this.leftView.setVisibility(0);
        Object localObject = getResources().getColorStateList(2131167053);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
        GradientDrawable localGradientDrawable = (GradientDrawable)this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
        if (localGradientDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            localGradientDrawable.setColor((ColorStateList)localObject);
          } else {
            localGradientDrawable.setColor(((ColorStateList)localObject).getDefaultColor());
          }
          localGradientDrawable.setAlpha(46);
        }
        if (!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(28.0F, getResources());
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          localObject = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(5.0F, getResources());
          this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      }
      ThreadManager.post(new FilterMsgBoxFragment.6(this), 8, null, true);
    }
  }
  
  private void g()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b() + QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str;
    if (i > 99) {
      str = "99+";
    } else if (i <= 0) {
      str = "";
    } else {
      str = String.valueOf(i);
    }
    getBaseActivity().runOnUiThread(new FilterMsgBoxFragment.7(this, i, str));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)this.mContentView.findViewById(2131366840));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setVisibility(0);
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559119, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addHeaderView(localView);
    localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558896, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 14);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(22);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  public void a()
  {
    ThreadManager.excute(new FilterMsgBoxFragment.8(this), 32, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != -1))
    {
      this.jdField_a_of_type_Int = (paramInt | this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF));
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    String str = paramRecentBaseData.getRecentUserUin();
    int i = paramRecentBaseData.getRecentUserType();
    if ((str != null) && (str.length() != 0) && (localRecentUserProxy != null))
    {
      paramString = localRecentUserProxy.b(str, i);
      paramRecentBaseData = paramString;
      if (paramString == null) {
        paramRecentBaseData = new RecentUser(str, i);
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean a(int paramInt)
  {
    return (!b()) && ((this.jdField_a_of_type_Int & paramInt) == paramInt);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.jdField_a_of_type_AndroidViewGestureDetector;
    if ((localGestureDetector != null) && (localGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Float = (ViewConfiguration.get(getBaseActivity()).getScaledDoubleTapSlop() * 2);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, this);
    paramLayoutInflater = this.mContentView.findViewById(2131366841);
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setOnTouchListener(this);
      paramLayoutInflater.setLongClickable(true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.titleRoot.findViewById(2131369240));
    h();
    c();
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
  }
  
  protected int getContentLayoutId()
  {
    return 2131559118;
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
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver = new FilterMsgBoxFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    if (QLog.isColorLevel()) {
      QLog.e("FilterMessageBoxFragment", 2, new Object[] { "doOnCreate ", this.jdField_a_of_type_AndroidContentContext });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
    if (localObject != null) {
      ((FPSSwipListView)localObject).setAdapter(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!a())
    {
      if (b()) {
        return false;
      }
      if (paramMotionEvent1 != null)
      {
        if (paramMotionEvent2 == null) {
          return false;
        }
        paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
        paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
        if (a(1))
        {
          if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.5F))
          {
            a(-1);
            if (this.b)
            {
              getBaseActivity().finish();
              return true;
            }
            this.b = true;
            return false;
          }
        }
        else if ((a(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
        {
          a(-1);
          this.b = false;
        }
      }
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    if (Utils.a(paramString1, localResources.getString(2131691260))) {
      a(paramRecentBaseData, paramString2, false);
    } else if (Utils.a(paramString1, localResources.getString(2131691263))) {
      a(paramRecentBaseData, paramString2, true);
    }
    e();
    b();
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if ((paramRecentBaseData instanceof RecentFilterMsgBoxDataItem))
    {
      paramView = ((RecentFilterMsgBoxDataItem)paramRecentBaseData).a();
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
      RecentUtil.a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 3, paramRecentBaseData, localBundle, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B5C8", "0X800B5C8", 0, 0, "", "", "", "");
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(paramRecentBaseData);
      return;
    }
    paramString = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    if ((paramString != null) && (paramRecentBaseData != null)) {}
    try
    {
      paramString.b(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
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
    e();
    b();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (b()) {
      return false;
    }
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
      if (a())
      {
        if (Math.abs(paramFloat2) > this.jdField_a_of_type_Float)
        {
          if ((paramFloat1 < 0.0F) && (f < 0.5F))
          {
            a(1);
            return true;
          }
          if ((paramFloat1 > 0.0F) && (f < 0.5F))
          {
            a(2);
            return true;
          }
        }
      }
      else if (a(1))
      {
        if ((paramFloat1 > 0.0F) || (f >= 0.5F))
        {
          a(-1);
          return false;
        }
      }
      else if ((a(2)) && ((paramFloat1 < 0.0F) || (f >= 0.5F))) {
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
    paramView = this.jdField_a_of_type_AndroidViewGestureDetector;
    return (paramView != null) && (paramView.onTouchEvent(paramMotionEvent));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    e();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment
 * JD-Core Version:    0.7.0.1
 */