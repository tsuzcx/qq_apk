package com.tencent.mobileqq.activity;

import abzc;
import abzd;
import ajya;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import avqc;
import avqe;
import axqy;
import bbyl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class RegisterSendUpSms
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private avqc jdField_a_of_type_Avqc;
  private avqe jdField_a_of_type_Avqe;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RegisterSendUpSms.2(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new abzd(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new abzc(this);
  private int c;
  private int jdField_d_of_type_Int = 10;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public RegisterSendUpSms()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  private void a()
  {
    axqy.a(this.app, "new_reg", "send_msg", "next_clk", "", 1, "");
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      if (this.jdField_a_of_type_Avqe == null) {
        this.jdField_a_of_type_Avqe = new avqe(this);
      }
      getIntent().putExtra("key_register_smscode", this.jdField_d_of_type_JavaLangString);
      getIntent().putExtra("key_register_autologin", true);
      this.jdField_a_of_type_Avqe.a(getIntent());
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, RegisterChooseLoginActivity.class);
      localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("invite_code", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("key", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_register_smscode", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("key_register_binded_qq", this.f);
      localIntent.putExtra("key_register_binded_qq_nick", this.g);
      localIntent.putExtra("key_register_binded_qq_face_url", this.h);
      localIntent.putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
      localIntent.putExtra("key_register_from", 4);
      startActivity(localIntent);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, false, false, this.jdField_c_of_type_JavaLangString, 4, "", "", true);
  }
  
  private void a(String paramString)
  {
    int i = 0;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_d_of_type_JavaLangString = paramString.getString("upmsg");
      Object localObject;
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localObject = (TextView)super.findViewById(2131378498);
        if (localObject != null) {
          ((TextView)localObject).setText(this.jdField_d_of_type_JavaLangString);
        }
      }
      this.e = paramString.getString("upnum");
      if (!TextUtils.isEmpty(this.e))
      {
        paramString = (TextView)super.findViewById(2131378500);
        if (paramString != null)
        {
          localObject = new StringBuilder();
          int k = this.e.length() / 4;
          int j = 0;
          while (i < k)
          {
            ((StringBuilder)localObject).append(this.e.substring(j, j + 4));
            ((StringBuilder)localObject).append(" ");
            j += 4;
            i += 1;
          }
          ((StringBuilder)localObject).append(this.e.substring(j));
          paramString.setText(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setData(Uri.parse("smsto:"));
      localIntent1.setType("vnd.android-dir/mms-sms");
      localIntent1.putExtra("address", paramString1);
      localIntent1.putExtra("sms_body", paramString2);
      startActivity(localIntent1);
      if (QLog.isColorLevel()) {
        QLog.d("RegisterSendUpSms", 2, String.format("sendSMS phoneNum:%s, msgBody:%s", new Object[] { paramString1, paramString2 }));
      }
      axqy.a(this.app, "new_reg_805", "send_msg", "send_clk", "", 1, "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Intent localIntent2 = new Intent("android.intent.action.SENDTO");
        localIntent2.setData(Uri.parse("smsto:" + paramString1));
        localIntent2.putExtra("sms_body", paramString2);
        startActivity(localIntent2);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131562352);
    c(2131717155);
    b();
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      a(90);
      this.app.setHandler(RegisterSendUpSms.class, this.jdField_a_of_type_MqqOsMqqHandler);
      Intent localIntent = super.getIntent();
      if (localIntent != null)
      {
        this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("phonenum");
        this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("invite_code");
        this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("key");
        this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
        this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
        this.f = getIntent().getStringExtra("key_register_binded_qq");
      }
      if (QLog.isDevelopLevel()) {
        bbyl.a(getClass().getSimpleName(), getIntent());
      }
      this.jdField_d_of_type_JavaLangString = super.getString(2131717156);
      this.e = super.getString(2131717157);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363630));
      if (this.jdField_a_of_type_AndroidWidgetButton != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      paramBundle = "";
      if (localIntent != null) {
        paramBundle = localIntent.getStringExtra("key_register_prompt_info");
      }
      if (!TextUtils.isEmpty(paramBundle)) {
        a(paramBundle);
      }
      axqy.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Boolean) {
        break label399;
      }
      axqy.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 1, 0, "", "", "", "");
      label302:
      if (!TextUtils.isEmpty(this.f)) {
        axqy.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 3, 0, "", "", "", "");
      }
      if (this.jdField_b_of_type_Int != 7) {
        break label439;
      }
      axqy.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      a(50);
      break;
      label399:
      if (this.jdField_c_of_type_Boolean) {
        break label302;
      }
      axqy.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 2, 0, "", "", "", "");
      break label302;
      label439:
      axqy.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Avqe != null) {
      this.jdField_a_of_type_Avqe.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "doOnResume mState: %s, mQuerySMSStatusRetCode: %s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Int != 0))
    {
      AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
      if (localAccountManager != null) {
        localAccountManager.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131713348) + "(" + this.jdField_d_of_type_Int + "s)");
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    if (this.jdField_a_of_type_Avqe != null) {
      this.jdField_a_of_type_Avqe.b();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Avqe != null) {
      this.jdField_a_of_type_Avqe.d();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "onClick mState: %s, mQuerySMSStatusRetCode: %s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if (this.jdField_c_of_type_Int == 0)
    {
      b(this.e, this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_Int = -1;
      this.jdField_c_of_type_Int = 1;
    }
    while (this.jdField_c_of_type_Int != 1) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      a();
      return;
    }
    paramView = (AccountManager)this.app.getManager(0);
    if (paramView != null) {
      paramView.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131713350) + "(" + this.jdField_d_of_type_Int + "s)");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.removeHandler(RegisterSendUpSms.class);
    if (this.jdField_a_of_type_Avqc != null) {
      this.jdField_a_of_type_Avqc.a();
    }
    this.jdField_a_of_type_Avqc = null;
    if (this.jdField_a_of_type_Avqe != null) {
      this.jdField_a_of_type_Avqe.a();
    }
    this.jdField_a_of_type_Avqe = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */