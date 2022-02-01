package com.tencent.mobileqq.activity;

import Override;
import SecurityAccountServer.RespondQueryQQBindingStat;
import aenb;
import ajco;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import awyz;
import azip;
import bdla;
import bkzi;
import bkzz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneUnityChangeActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private int a;
  public Button a;
  public awyz a;
  public azip a;
  public bkzi a;
  public QQCustomDialog a;
  public String a;
  public azip b;
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      this.jdField_a_of_type_Bkzi.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Bkzi.a(anvx.a(2131707483), 3);
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.a(new aenb(this));
      this.jdField_a_of_type_Bkzi.c(2131690697);
    }
    if ((this.jdField_a_of_type_Bkzi != null) && (!this.jdField_a_of_type_Bkzi.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bkzi.show();
    }
  }
  
  public boolean a()
  {
    Object localObject1 = (awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    int i = ((awyz)localObject1).d();
    localObject1 = ((awyz)localObject1).a();
    if ((1 != i) && (5 != i)) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = ("" + ((RespondQueryQQBindingStat)localObject1).mobileNo);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        super.finish();
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneUnityChangeActivity", 2, "" + i, localException);
        }
      }
      super.setTitle(anvx.a(2131707494));
      Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", ajco.a(this.jdField_a_of_type_JavaLangString));
      ((TextView)findViewById(2131379824)).setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363854));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject2 = (ImageView)findViewById(2131369245);
      ((ImageView)localObject2).setVisibility(0);
      if (AppSetting.c) {
        ((ImageView)localObject2).setContentDescription(getString(2131694561));
      }
      i = 2130843770;
      if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        i = 2130840365;
      }
      ((ImageView)localObject2).setImageResource(i);
      ((ImageView)localObject2).setOnClickListener(this);
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      super.setResult(paramInt2);
      super.finish();
      return;
    }
    a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent() == null) {
      super.finish();
    }
    do
    {
      return true;
      super.setContentView(2131559596);
      this.jdField_a_of_type_Awyz = ((awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    } while (a());
    super.finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Azip != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Azip);
      this.jdField_a_of_type_Azip = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_a_of_type_Bkzi != null)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      this.jdField_a_of_type_Bkzi = null;
    }
    this.app.removeHandler(PhoneUnityChangeActivity.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      continue;
      if (NetworkUtil.isNetSupport(this)) {
        break;
      }
      a(2131694305);
    }
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("kNeedUnbind", true);
    localIntent.putExtra("cmd_param_is_from_uni", true);
    localIntent.putExtra("cmd_param_is_from_change_bind", true);
    if (this.jdField_a_of_type_Int != -1) {}
    for (int i = this.jdField_a_of_type_Int;; i = 1)
    {
      localIntent.putExtra("kSrouce", i);
      localIntent.putExtra("kFPhoneChange", true);
      startActivityForResult(localIntent, 1001);
      bdla.b(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      ContactUtils.setBindPath(1);
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity
 * JD-Core Version:    0.7.0.1
 */