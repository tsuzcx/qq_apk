package com.tencent.mobileqq.activity;

import Override;
import SecurityAccountServer.RespondQueryQQBindingStat;
import aeua;
import ajby;
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
import anni;
import awmz;
import aywi;
import bcst;
import bglf;
import bgnt;
import bgpa;
import bkho;
import bkif;
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
  public awmz a;
  public aywi a;
  public bgpa a;
  public bkho a;
  public String a;
  public aywi b;
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkho == null)
    {
      this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this, null));
      this.jdField_a_of_type_Bkho.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Bkho.a(anni.a(2131706795), 3);
      this.jdField_a_of_type_Bkho.c(2131690582);
      this.jdField_a_of_type_Bkho.a(new aeua(this));
      this.jdField_a_of_type_Bkho.c(2131690582);
    }
    if ((this.jdField_a_of_type_Bkho != null) && (!this.jdField_a_of_type_Bkho.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bkho.show();
    }
  }
  
  public boolean a()
  {
    Object localObject1 = (awmz)this.app.getManager(11);
    int i = ((awmz)localObject1).d();
    localObject1 = ((awmz)localObject1).a();
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
      super.setTitle(anni.a(2131706806));
      Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", ajby.a(this.jdField_a_of_type_JavaLangString));
      ((TextView)findViewById(2131379559)).setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363727));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject2 = (ImageView)findViewById(2131368961);
      ((ImageView)localObject2).setVisibility(0);
      if (AppSetting.c) {
        ((ImageView)localObject2).setContentDescription(getString(2131694221));
      }
      i = 2130843652;
      if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
        i = 2130840281;
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
      super.setContentView(2131559556);
      this.jdField_a_of_type_Awmz = ((awmz)this.app.getManager(11));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    } while (a());
    super.finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aywi != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Aywi);
      this.jdField_a_of_type_Aywi = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    if (this.jdField_a_of_type_Bgpa != null)
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      this.jdField_a_of_type_Bgpa = null;
    }
    if (this.jdField_a_of_type_Bkho != null)
    {
      this.jdField_a_of_type_Bkho.dismiss();
      this.jdField_a_of_type_Bkho = null;
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
      if (bgnt.d(this)) {
        break;
      }
      a(2131693991);
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
      bcst.b(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      bglf.a(1);
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