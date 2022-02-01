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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected TextView a;
  private ConversationProxyObserver jdField_a_of_type_ComTencentImcoreMessageConversationProxyObserver;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private TempMsgBoxObserver jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver;
  protected BaseActivity a;
  protected QQAppInterface a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected boolean a;
  private boolean b = true;
  
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
  
  private void a(QQMessageFacade paramQQMessageFacade)
  {
    int i = paramQQMessageFacade.b() + QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) - ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getTempMsgBoxUnread(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i > 99) {
      paramQQMessageFacade = "99+";
    } else if (i <= 0) {
      paramQQMessageFacade = "";
    } else {
      paramQQMessageFacade = String.valueOf(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new TempMsgBoxFragment.7(this, i, paramQQMessageFacade));
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    int i;
    if ((paramRecentBaseData instanceof RecentTempMsgBoxItem))
    {
      RecentTempMsgBoxItem localRecentTempMsgBoxItem = (RecentTempMsgBoxItem)paramRecentBaseData;
      paramRecentBaseData = localRecentTempMsgBoxItem.a();
      i = localRecentTempMsgBoxItem.mPosition;
    }
    else
    {
      paramRecentBaseData = null;
      i = -1;
    }
    if (paramRecentBaseData != null) {
      RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, i);
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUser localRecentUser = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().a(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("enter_from_temp_msg_box", true);
    localBundle.putBoolean("need_to_show_unread_num", true);
    localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
    RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, paramString, paramBoolean, 3, paramRecentBaseData, localBundle, null);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, "initData() called");
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, "initTitleBar");
    }
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699400));
    ImageView localImageView = this.rightViewImg;
    localImageView.setImageResource(2130850468);
    localImageView.setContentDescription(getString(2131699398));
    localImageView.setOnClickListener(new TempMsgBoxFragment.4(this));
    localImageView.setVisibility(0);
    e();
    this.titleRoot.setBackgroundResource(2130850433);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, "initContentView");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131378375));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558896, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this, 15);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(23);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  private void e()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      f();
      return;
    }
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.runOnUiThread(new TempMsgBoxFragment.5(this));
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
        localObject = getResources().getColorStateList(2131167053);
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localObject == null) {
        return;
      }
      ThreadManager.post(new TempMsgBoxFragment.6(this, (QQMessageFacade)localObject), 8, null, true);
    }
  }
  
  public void a()
  {
    Object localObject1 = ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshTempMsgBoxList() called ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("TempMsgBoxFragment", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ArrayList(((List)localObject1).size());
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject3 = (RecentUser)((List)localObject1).get(i);
      if (localObject3 != null)
      {
        localObject3 = new RecentTempMsgBoxItem((RecentUser)localObject3);
        ((RecentTempMsgBoxItem)localObject3).update(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        ((List)localObject2).add(localObject3);
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshTempMsgBoxList() after sort ");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.d("TempMsgBoxFragment", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new TempMsgBoxFragment.3(this, (List)localObject2));
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
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this);
    this.jdField_a_of_type_Float = (ViewConfiguration.get(getBaseActivity()).getScaledDoubleTapSlop() * 2);
    paramLayoutInflater = (LinearLayout)this.mContentView.findViewById(2131378376);
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setOnTouchListener(this);
      paramLayoutInflater.setLongClickable(true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.titleRoot.findViewById(2131369240));
    d();
    c();
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131562925;
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver = new TempMsgBoxFragment.1(this);
    this.jdField_a_of_type_ComTencentImcoreMessageConversationProxyObserver = new TempMsgBoxFragment.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentImcoreMessageConversationProxyObserver);
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, new Object[] { "doOnCreate ", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgboxTempMsgBoxObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentImcoreMessageConversationProxyObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
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
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
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
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(" data ");
      paramString2.append(paramRecentBaseData);
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "menuItem clicked ", paramString1, paramString2.toString(), " uin ", paramRecentBaseData.getRecentUserUin(), " type ", Integer.valueOf(paramRecentBaseData.getRecentUserType()) });
    }
    if (Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[3]))) {
      ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).updateIsTop(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), true);
    } else if (Utils.a(paramString1, getResources().getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[2]))) {
      ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).updateIsTop(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), false);
    }
    a();
    e();
  }
  
  public void onPause()
  {
    super.onPause();
    ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
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
        this.jdField_a_of_type_Boolean = true;
      }
      paramView = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getServiceIdMap().get(Integer.valueOf(paramRecentBaseData.getRecentUserType()));
      a(paramRecentBaseData, paramString, paramBoolean);
    }
    if ((paramView != null) && (paramView.intValue() >= 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1C0", "0X800B1C0", paramView.intValue(), 0, "", "", "", "");
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData);
    paramString = ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers();
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
      paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().a(AppConstants.TEMP_MSG_BOX_UIN, 10011);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().a(paramRecentBaseData, false);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    e();
    ((ITempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
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
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "updateMsg called ", paramObject });
    }
    a();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment
 * JD-Core Version:    0.7.0.1
 */