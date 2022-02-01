package com.tencent.mobileqq.activity;

import Override;
import SecurityAccountServer.RespondQueryQQBindingStat;
import afde;
import ajng;
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
import anzj;
import axfr;
import azov;
import bdll;
import bhlg;
import bhnv;
import bhpc;
import blir;
import blji;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneUnityChangeActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private int a;
  public Button a;
  public axfr a;
  public azov a;
  public bhpc a;
  public blir a;
  public String a;
  public azov b;
  
  public void a()
  {
    if (this.jdField_a_of_type_Blir == null)
    {
      this.jdField_a_of_type_Blir = ((blir)blji.a(this, null));
      this.jdField_a_of_type_Blir.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Blir.a(anzj.a(2131706904), 3);
      this.jdField_a_of_type_Blir.c(2131690580);
      this.jdField_a_of_type_Blir.a(new afde(this));
      this.jdField_a_of_type_Blir.c(2131690580);
    }
    if ((this.jdField_a_of_type_Blir != null) && (!this.jdField_a_of_type_Blir.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Blir.show();
    }
  }
  
  public boolean a()
  {
    Object localObject1 = (axfr)this.app.getManager(11);
    int i = ((axfr)localObject1).d();
    localObject1 = ((axfr)localObject1).a();
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
      super.setTitle(anzj.a(2131706915));
      Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", ajng.a(this.jdField_a_of_type_JavaLangString));
      ((TextView)findViewById(2131379731)).setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363753));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject2 = (ImageView)findViewById(2131369056);
      ((ImageView)localObject2).setVisibility(0);
      if (AppSetting.c) {
        ((ImageView)localObject2).setContentDescription(getString(2131694246));
      }
      i = 2130843670;
      if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        i = 2130840291;
      }
      ((ImageView)localObject2).setImageResource(i);
      ((ImageView)localObject2).setOnClickListener(this);
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      super.setContentView(2131559561);
      this.jdField_a_of_type_Axfr = ((axfr)this.app.getManager(11));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    } while (a());
    super.finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Azov != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Azov);
      this.jdField_a_of_type_Azov = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
    }
    if (this.jdField_a_of_type_Blir != null)
    {
      this.jdField_a_of_type_Blir.dismiss();
      this.jdField_a_of_type_Blir = null;
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
      if (bhnv.d(this)) {
        break;
      }
      a(2131694008);
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
      bdll.b(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      bhlg.a(1);
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