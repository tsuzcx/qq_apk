package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import adnj;
import alud;
import alys;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aufv;
import awhw;
import azqs;
import bdgc;
import bdin;
import bdjz;
import bhuf;
import bhus;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PhoneUnityChangeActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private int a;
  public Button a;
  public aufv a;
  public awhw a;
  public bdjz a;
  public bhuf a;
  public String a;
  public awhw b;
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhuf == null)
    {
      this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this, null));
      this.jdField_a_of_type_Bhuf.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_Bhuf.a(alud.a(2131708418), 3);
      this.jdField_a_of_type_Bhuf.c(2131690648);
      this.jdField_a_of_type_Bhuf.a(new adnj(this));
      this.jdField_a_of_type_Bhuf.c(2131690648);
    }
    if ((this.jdField_a_of_type_Bhuf != null) && (!this.jdField_a_of_type_Bhuf.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bhuf.show();
    }
  }
  
  public boolean a()
  {
    Object localObject1 = (aufv)this.app.getManager(11);
    int i = ((aufv)localObject1).d();
    localObject1 = ((aufv)localObject1).a();
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
      super.setTitle(alud.a(2131708429));
      Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", alys.a(this.jdField_a_of_type_JavaLangString));
      ((TextView)findViewById(2131378697)).setText((CharSequence)localObject2);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363530));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localObject2 = (ImageView)findViewById(2131368638);
      ((ImageView)localObject2).setVisibility(0);
      if (AppSetting.c) {
        ((ImageView)localObject2).setContentDescription(getString(2131695180));
      }
      ((ImageView)localObject2).setBackgroundResource(2130840102);
      ((ImageView)localObject2).setOnClickListener(this);
    }
    return true;
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
      super.setContentView(2131559427);
      this.jdField_a_of_type_Aufv = ((aufv)this.app.getManager(11));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    } while (a());
    super.finish();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Awhw != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Awhw);
      this.jdField_a_of_type_Awhw = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    if (this.jdField_a_of_type_Bhuf != null)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      this.jdField_a_of_type_Bhuf = null;
    }
    this.app.removeHandler(PhoneUnityChangeActivity.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368638: 
      a();
      return;
    }
    if (!bdin.d(this))
    {
      b(2131694831);
      return;
    }
    paramView = new Intent(this, BindNumberActivity.class);
    paramView.putExtra("kNeedUnbind", true);
    paramView.putExtra("cmd_param_is_from_uni", true);
    paramView.putExtra("cmd_param_is_from_change_bind", true);
    if (this.jdField_a_of_type_Int != -1) {}
    for (int i = this.jdField_a_of_type_Int;; i = 1)
    {
      paramView.putExtra("kSrouce", i);
      paramView.putExtra("kFPhoneChange", true);
      startActivityForResult(paramView, 1001);
      azqs.b(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      bdgc.a(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity
 * JD-Core Version:    0.7.0.1
 */