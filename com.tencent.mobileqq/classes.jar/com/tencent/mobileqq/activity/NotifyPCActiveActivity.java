package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NotifyPCActiveActivity
  extends BaseActivity
{
  public static NotifyPCActiveActivity a;
  private int jdField_a_of_type_Int;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new NotifyPCActiveActivity.4(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  
  private void a()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    if (localConfigHandler != null) {
      localConfigHandler.b();
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject1 != null) && (((QQCustomDialog)localObject1).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    Object localObject2;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localObject2 = getIntent().getExtras();
        localObject1 = ((Bundle)localObject2).getString("Message");
        localObject2 = ((Bundle)localObject2).getString("button");
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setMessage((CharSequence)localObject1).setPositiveButton((String)localObject2, new NotifyPCActiveActivity.3(this));
      }
    }
    else
    {
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      localObject1 = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      Object localObject3 = getIntent().getExtras();
      localObject2 = ((Bundle)localObject3).getString("Message");
      String str = ((Bundle)localObject3).getString("lButton");
      localObject3 = ((Bundle)localObject3).getString("rButton");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131558954);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(null).setMessage((CharSequence)localObject2).setPositiveButton((String)localObject3, new NotifyPCActiveActivity.2(this, (CardHandler)localObject1)).setNegativeButton(str, new NotifyPCActiveActivity.1(this));
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject1 != null)
    {
      ((QQCustomDialog)localObject1).setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
    super.setContentView(2131559505);
    jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = this;
    this.jdField_a_of_type_Int = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationActivity action = ");
      localStringBuilder.append(paramBundle);
      QLog.d("NotificationActivity", 2, localStringBuilder.toString());
    }
    if ("mqq.intent.action.PCACTIVE_TIPS".equals(paramBundle))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004975", "0X8004975", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Int = 1;
      a();
    }
    else if ("mqq.intent.action.NOTICE_ON_PCACTIVE".equals(paramBundle))
    {
      this.jdField_a_of_type_Int = 2;
    }
    a(this.jdField_a_of_type_Int);
    return false;
  }
  
  protected void doOnDestroy()
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
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  protected void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity
 * JD-Core Version:    0.7.0.1
 */