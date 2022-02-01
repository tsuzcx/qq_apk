package com.tencent.mobileqq.activity.recent.msgbox;

import acmw;
import acmz;
import alfv;
import algc;
import alik;
import alje;
import almd;
import alme;
import almf;
import almg;
import almi;
import almj;
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
import anvx;
import aoxz;
import bapk;
import bdla;
import bhbx;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class TempMsgBoxFragment
  extends IphoneTitleBarFragment
  implements alfv, alje, GestureDetector.OnGestureListener, View.OnTouchListener, Observer
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private acmz jdField_a_of_type_Acmz;
  private algc jdField_a_of_type_Algc;
  private almi jdField_a_of_type_Almi;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected TextView a;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected boolean a;
  private boolean b = true;
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, "initData() called");
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {}
    for (TextView localTextView = this.mLeftBackText; localTextView == null; localTextView = this.jdField_a_of_type_AndroidWidgetTextView) {
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
    int i = paramQQMessageFacade.getUnreadMsgsNum() + bapk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) - almj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i > 99) {
      paramQQMessageFacade = "99+";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new TempMsgBoxFragment.7(this, i, paramQQMessageFacade));
      return;
      if (i <= 0) {
        paramQQMessageFacade = "";
      } else {
        paramQQMessageFacade = String.valueOf(i);
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    RecentUser localRecentUser = null;
    int i = -1;
    if ((paramRecentBaseData instanceof RecentTempMsgBoxItem))
    {
      paramRecentBaseData = (RecentTempMsgBoxItem)paramRecentBaseData;
      localRecentUser = paramRecentBaseData.a();
      i = paramRecentBaseData.mPosition;
    }
    if (localRecentUser != null) {
      alik.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, i);
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUser localRecentUser = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().findRecentUserByUin(paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType());
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_OPEN_AIO_INTENT_CLASS_NAME", ChatActivity.class.getName());
    alik.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser, paramString, paramBoolean, 3, paramRecentBaseData, localBundle, null);
  }
  
  private void b()
  {
    List localList = ((almg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, "refreshTempMsgBoxList() called " + localList);
    }
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    if (i < localList.size())
    {
      Object localObject = (RecentUser)localList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = new RecentTempMsgBoxItem((RecentUser)localObject);
        ((RecentTempMsgBoxItem)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        localArrayList.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, "refreshTempMsgBoxList() after sort " + localArrayList);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new TempMsgBoxFragment.3(this, localArrayList));
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, "initTitleBar");
    }
    setTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698949));
    ImageView localImageView = this.rightViewImg;
    localImageView.setImageResource(2130850144);
    localImageView.setContentDescription(getString(2131698947));
    localImageView.setOnClickListener(new almf(this));
    localImageView.setVisibility(0);
    e();
    this.titleRoot.setBackgroundResource(2130850109);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, "initContentView");
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131378567));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    View localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131558961, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView);
    this.jdField_a_of_type_Algc = new algc(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, this, 15);
    this.jdField_a_of_type_Algc.a(23);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Algc);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_Algc.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
  }
  
  private void e()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      f();
    }
    BaseActivity localBaseActivity;
    do
    {
      return;
      localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    } while (localBaseActivity == null);
    localBaseActivity.runOnUiThread(new TempMsgBoxFragment.5(this));
  }
  
  private void f()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null)) {}
    label86:
    do
    {
      return;
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackIcon.setContentDescription(anvx.a(2131714566));
      localObject = this.mLeftBackText;
      AIOUtils.expandViewTouchDelegate((View)localObject, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
      if (localObject == null) {
        break label282;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    } while (localObject == null);
    ThreadManager.post(new TempMsgBoxFragment.6(this, (QQMessageFacade)localObject), 8, null, true);
    return;
    this.leftView.setVisibility(0);
    Object localObject = getResources().getColorStateList(2131167023);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject);
    GradientDrawable localGradientDrawable = (GradientDrawable)this.jdField_a_of_type_AndroidWidgetTextView.getBackground();
    if (localGradientDrawable != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label284;
      }
      localGradientDrawable.setColor((ColorStateList)localObject);
    }
    for (;;)
    {
      localGradientDrawable.setAlpha(46);
      if (!ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(28.0F, getResources());
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(5.0F, getResources());
        this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      break label86;
      label282:
      break;
      label284:
      localGradientDrawable.setColor(((ColorStateList)localObject).getDefaultColor());
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "click tempMsgBox item: ", paramString, ", recentDataUin: ", paramRecentBaseData.getRecentUserUin(), ", recentDataType: ", Integer.valueOf(paramRecentBaseData.getRecentUserType()) });
    }
    if (paramRecentBaseData == null) {}
    for (;;)
    {
      return;
      if (paramRecentBaseData.getRecentUserType() == 10012)
      {
        paramView = new Intent();
        PublicFragmentActivity.a(getActivity(), paramView, FilterMessageBoxFragment.class);
        paramView = Integer.valueOf(10000);
      }
      while ((paramView != null) && (paramView.intValue() >= 0))
      {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1C0", "0X800B1C0", paramView.intValue(), 0, "", "", "", "");
        return;
        if (paramRecentBaseData.getUnreadNum() > 0) {
          this.jdField_a_of_type_Boolean = true;
        }
        paramView = (Integer)almj.b().get(Integer.valueOf(paramRecentBaseData.getRecentUserType()));
        a(paramRecentBaseData, paramString, paramBoolean);
      }
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {}
    do
    {
      return;
      a(paramRecentBaseData);
      paramString = ((almg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("TempMsgBoxFragment", 2, "onRecentBaseDataDelete() called with: data = [" + paramRecentBaseData + "], msgBoxRecentUsers = [" + paramString + "]");
      }
    } while (!paramString.isEmpty());
    paramRecentBaseData = (RecentUser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().findRecentUserByUin(AppConstants.TEMP_MSG_BOX_UIN, 10011);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().removeCache(paramRecentBaseData);
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "menuItem clicked ", paramString1, " data " + paramRecentBaseData, " uin ", paramRecentBaseData.getRecentUserUin(), " type ", Integer.valueOf(paramRecentBaseData.getRecentUserType()) });
    }
    if (bhbx.a(paramString1, getResources().getString(alhd.a[3]))) {
      ((almg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), true);
    }
    for (;;)
    {
      b();
      e();
      return;
      if (bhbx.a(paramString1, getResources().getString(alhd.a[2]))) {
        ((almg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getRecentUserType(), false);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout) {}
  
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
    if ((this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this);
    this.jdField_a_of_type_Float = (ViewConfiguration.get(getActivity()).getScaledDoubleTapSlop() * 2);
    paramLayoutInflater = (LinearLayout)this.mContentView.findViewById(2131378568);
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setOnTouchListener(this);
      paramLayoutInflater.setLongClickable(true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.titleRoot.findViewById(2131369269));
    d();
    c();
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131562948;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    this.jdField_a_of_type_Almi = new almd(this);
    this.jdField_a_of_type_Acmz = new alme(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Almi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Acmz);
    if (QLog.isColorLevel()) {
      QLog.e("TempMsgBoxFragment", 2, new Object[] { "doOnCreate ", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Algc != null) {
      this.jdField_a_of_type_Algc.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Almi);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Acmz);
    this.jdField_a_of_type_Algc = null;
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localQQMessageFacade != null) {
      localQQMessageFacade.deleteObserver(this);
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((a()) || (b())) {
      return false;
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
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
      return false;
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public void onPause()
  {
    super.onPause();
    ((almg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    e();
    ((almg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(AppConstants.TEMP_MSG_BOX_UIN, 10011, 0);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (b()) {}
    float f;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null));
            paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
            f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
            if (!a()) {
              break;
            }
          } while (Math.abs(paramFloat2) <= this.jdField_a_of_type_Float);
          if ((paramFloat1 < 0.0F) && (f < 0.5F))
          {
            a(1);
            return true;
          }
        } while ((paramFloat1 <= 0.0F) || (f >= 0.5F));
        a(2);
        return true;
        if (!a(1)) {
          break;
        }
      } while ((paramFloat1 <= 0.0F) && (f < 0.5F));
      a(-1);
      return false;
    } while ((!a(2)) || ((paramFloat1 >= 0.0F) && (f < 0.5F)));
    a(-1);
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
    return (this.jdField_a_of_type_AndroidViewGestureDetector != null) && (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempMsgBoxFragment", 2, new Object[] { "updateMsg called ", paramObject });
    }
    b();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment
 * JD-Core Version:    0.7.0.1
 */