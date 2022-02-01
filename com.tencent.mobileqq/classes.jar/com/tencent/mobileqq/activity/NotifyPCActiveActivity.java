package com.tencent.mobileqq.activity;

import Override;
import aeko;
import aekp;
import aekq;
import aekr;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import anri;
import ansg;
import bdla;
import bhdj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NotifyPCActiveActivity
  extends BaseActivity
{
  public static NotifyPCActiveActivity a;
  private int jdField_a_of_type_Int;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aekr(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  
  private void a()
  {
    ansg localansg = (ansg)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    if (localansg != null) {
      localansg.b();
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      Object localObject1 = (anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      Object localObject3 = getIntent().getExtras();
      Object localObject2 = ((Bundle)localObject3).getString("Message");
      String str = ((Bundle)localObject3).getString("lButton");
      localObject3 = ((Bundle)localObject3).getString("rButton");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131559019);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(null).setMessage((CharSequence)localObject2).setPositiveButton((String)localObject3, new aekp(this, (anri)localObject1)).setNegativeButton(str, new aeko(this));
      continue;
      localObject2 = getIntent().getExtras();
      localObject1 = ((Bundle)localObject2).getString("Message");
      localObject2 = ((Bundle)localObject2).getString("button");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230).setMessage((CharSequence)localObject1).setPositiveButton((String)localObject2, new aekq(this));
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559556);
    jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = this;
    this.jdField_a_of_type_Int = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationActivity", 2, "NotificationActivity action = " + paramBundle);
    }
    if ("mqq.intent.action.PCACTIVE_TIPS".equals(paramBundle))
    {
      bdla.b(null, "CliOper", "", "", "0X8004975", "0X8004975", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Int = 1;
      a();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Int);
      return false;
      if ("mqq.intent.action.NOTICE_ON_PCACTIVE".equals(paramBundle)) {
        this.jdField_a_of_type_Int = 2;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    super.doOnDestroy();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity != null) {
      jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotifyPCActiveActivity", 2, "Running in doOnDestroy()");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    super.finish();
    jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity
 * JD-Core Version:    0.7.0.1
 */