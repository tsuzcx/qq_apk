package com.tencent.mobileqq.activity;

import Override;
import aede;
import aedf;
import amtj;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import azvs;
import azvu;
import azvw;
import azvy;
import azvz;
import bcef;
import bgpv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class RegisterSendUpSms
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private azvu jdField_a_of_type_Azvu;
  private azvw jdField_a_of_type_Azvw;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RegisterSendUpSms.2(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aedf(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aede(this);
  private int b;
  private int c;
  private int jdField_d_of_type_Int = 10;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public RegisterSendUpSms()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
  }
  
  private void a()
  {
    bcef.a(this.app, "new_reg", "send_msg", "next_clk", "", 1, "");
    boolean bool = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    if (!TextUtils.isEmpty(this.i)) {}
    for (int j = 1; bool; j = 0)
    {
      if (this.jdField_a_of_type_Azvw == null) {
        this.jdField_a_of_type_Azvw = new azvw(this);
      }
      getIntent().putExtra("key_register_smscode", this.jdField_d_of_type_JavaLangString);
      getIntent().putExtra("key_register_autologin", true);
      this.jdField_a_of_type_Azvw.a(getIntent());
      return;
    }
    if (j != 0)
    {
      azvy localazvy = new azvz().a(this.jdField_a_of_type_JavaLangString).b(this.jdField_b_of_type_JavaLangString).c(this.jdField_d_of_type_JavaLangString).a(true).b(false).d(this.jdField_c_of_type_JavaLangString).a(4).e("").f("").c(true).d(true).a();
      azvs.a().a(this, this.i, localazvy);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_JavaLangString, 4, "", "", true);
  }
  
  private void a(String paramString)
  {
    int j = 0;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_d_of_type_JavaLangString = paramString.getString("upmsg");
      Object localObject;
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localObject = (TextView)super.findViewById(2131380003);
        if (localObject != null) {
          ((TextView)localObject).setText(this.jdField_d_of_type_JavaLangString);
        }
      }
      this.e = paramString.getString("upnum");
      if (!TextUtils.isEmpty(this.e))
      {
        paramString = (TextView)super.findViewById(2131380005);
        if (paramString != null)
        {
          localObject = new StringBuilder();
          int m = this.e.length() / 4;
          int k = 0;
          while (j < m)
          {
            ((StringBuilder)localObject).append(this.e.substring(k, k + 4));
            ((StringBuilder)localObject).append(" ");
            k += 4;
            j += 1;
          }
          ((StringBuilder)localObject).append(this.e.substring(k));
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
      bcef.a(this.app, "new_reg_805", "send_msg", "send_clk", "", 1, "");
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
    setContentView(2131562725);
    c(2131716121);
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
        this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
        this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
        this.f = getIntent().getStringExtra("key_register_binded_qq");
      }
      if (QLog.isDevelopLevel()) {
        bgpv.a(getClass().getSimpleName(), getIntent());
      }
      this.jdField_d_of_type_JavaLangString = super.getString(2131716122);
      this.e = super.getString(2131716123);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363938));
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
      bcef.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        break label404;
      }
      bcef.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 1, 0, "", "", "", "");
      label307:
      if (!TextUtils.isEmpty(this.f)) {
        bcef.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 3, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Int != 7) {
        break label444;
      }
      bcef.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      a(50);
      break;
      label404:
      if (this.jdField_b_of_type_Boolean) {
        break label307;
      }
      bcef.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 2, 0, "", "", "", "");
      break label307;
      label444:
      bcef.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Azvw != null) {
      this.jdField_a_of_type_Azvw.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "doOnResume mState: %s, mQuerySMSStatusRetCode: %s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_b_of_type_Int != 0))
    {
      AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
      if (localAccountManager != null) {
        localAccountManager.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131712452) + "(" + this.jdField_d_of_type_Int + "s)");
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    if (this.jdField_a_of_type_Azvw != null) {
      this.jdField_a_of_type_Azvw.b();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Azvw != null) {
      this.jdField_a_of_type_Azvw.d();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "onClick mState: %s, mQuerySMSStatusRetCode: %s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if (this.jdField_c_of_type_Int == 0)
    {
      b(this.e, this.jdField_d_of_type_JavaLangString);
      this.jdField_b_of_type_Int = -1;
      this.jdField_c_of_type_Int = 1;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_c_of_type_Int == 1) {
        if (this.jdField_b_of_type_Int == 0)
        {
          a();
        }
        else
        {
          AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
          if (localAccountManager != null) {
            localAccountManager.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131712454) + "(" + this.jdField_d_of_type_Int + "s)");
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.removeHandler(RegisterSendUpSms.class);
    if (this.jdField_a_of_type_Azvu != null) {
      this.jdField_a_of_type_Azvu.a();
    }
    this.jdField_a_of_type_Azvu = null;
    if (this.jdField_a_of_type_Azvw != null) {
      this.jdField_a_of_type_Azvw.a();
    }
    this.jdField_a_of_type_Azvw = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */