package com.tencent.mobileqq.activity;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.SigCommentSessionListAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class SigCommentListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  SigCommentSessionListAdapter jdField_a_of_type_ComTencentMobileqqAdapterSigCommentSessionListAdapter;
  SignatureObserver jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = new SigCommentListActivity.1(this);
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167144)));
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException1.toString());
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713981));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167144)));
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SigCommentListActivity", 2, localException2.toString());
      }
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850811);
    if (paramInt == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713982));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713978));
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131166548)));
    }
    catch (Exception localException3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SigCommentListActivity", 2, localException3.toString());
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new SigCommentListActivity.2(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SigCommentListActivity.3(this));
  }
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
    if ((localSystemBarCompact != null) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      if (ThemeUtil.isInNightMode(getAppRuntime()))
      {
        if ((!SystemUtil.b()) && (!SystemUtil.d()))
        {
          localSystemBarCompact.setStatusBarColor(-7829368);
          return;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
        localSystemBarCompact.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        localSystemBarCompact.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.d())
      {
        localSystemBarCompact.setStatusBarColor(-2368549);
        return;
      }
      localSystemBarCompact.setStatusBarColor(-1);
      localSystemBarCompact.setStatusBarDarkMode(true);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(1);
    Object localObject;
    if (NetworkUtil.isNetSupport(this))
    {
      localObject = (SignatureHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (localObject != null) {
        ((SignatureHandler)localObject).a(paramBoolean2);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(1, 1, 0);
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessageDelayed((Message)localObject, 1000L);
      this.jdField_a_of_type_ComTencentMobileqqAdapterSigCommentSessionListAdapter.a(2131719144);
    }
    if (paramBoolean1) {
      startTitleProgress();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562044);
    super.setTitle(HardCodeUtil.a(2131713979));
    this.leftView.setTextColor(getResources().getColor(2131165327));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840342));
    this.centerView.setTextColor(getResources().getColor(2131165327));
    a();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562855, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366218));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366229));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377588));
    this.jdField_a_of_type_ComTencentWidgetXListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentMobileqqAdapterSigCommentSessionListAdapter = new SigCommentSessionListAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSigCommentSessionListAdapter);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.app.setHandler(SigCommentListActivity.class, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler);
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null) {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
    }
    paramBundle = this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.obtainMessage(0, 1, 1);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendMessageDelayed(paramBundle, 500L);
    a(1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppSignatureObserver = null;
    }
    this.app.removeHandler(SigCommentListActivity.class);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool2 = false;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      stopTitleProgress();
      if (1 == paramMessage.arg1)
      {
        if (isResume()) {
          QQToast.a(this, 0, getResources().getString(2131719145), 0).b(getTitleBarHeight());
        }
        a(2);
        return true;
      }
    }
    else
    {
      boolean bool1;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramMessage.arg2 == 1) {
        bool2 = true;
      }
      a(bool1, bool2);
    }
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity
 * JD-Core Version:    0.7.0.1
 */