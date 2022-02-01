package com.tencent.mobileqq.activity;

import Override;
import aeuj;
import aeuk;
import aeul;
import aeum;
import aeun;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import bbby;
import bbca;
import bbcc;
import bbce;
import bbcf;
import bdla;
import biaf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopBaseProxyActivity;
import java.util.Locale;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterSendUpSms
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbca jdField_a_of_type_Bbca;
  private bbcc jdField_a_of_type_Bbcc;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aeuk(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aeuj(this);
  private int jdField_b_of_type_Int = 0;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private String d;
  private String e;
  private String f;
  private String g;
  
  private CharSequence a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("RegisterSendUpSms", 1, "src is empty");
      return null;
    }
    if (paramString2 == null)
    {
      QLog.d("RegisterSendUpSms", 1, "value is null");
      return paramString1;
    }
    int i = paramString1.indexOf("%s");
    if (i == -1)
    {
      QLog.d("RegisterSendUpSms", 1, "getColorSpan, no %s tag");
      return paramString1;
    }
    paramString1 = new SpannableString(String.format(paramString1, new Object[] { paramString2 }));
    paramString1.setSpan(new ForegroundColorSpan(-16777216), i, paramString2.length() + i, 17);
    paramString1.setSpan(new StyleSpan(1), i, paramString2.length() + i, 17);
    return paramString1;
  }
  
  private String a(String paramString, aeun paramaeun)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("RegisterSendUpSms", 1, "insertSpace charSequence is null");
      return null;
    }
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramString.charAt(i));
      if (paramaeun.a(i)) {
        localStringBuilder.append(" ");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      this.jdField_b_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(getActivity());
      this.jdField_b_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131372740)).setText(2131700655);
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.d = paramString.getString("upmsg");
      this.e = paramString.getString("upnum");
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)))
      {
        QLog.e("RegisterSendUpSms", 1, new Object[] { "initView, data is unexpected, phoneNum : ", this.jdField_a_of_type_JavaLangString, " upMsg : ", this.d, " upNum : ", this.e });
        return;
      }
      paramString = (TextView)findViewById(2131380072);
      TextView localTextView1 = (TextView)findViewById(2131380166);
      TextView localTextView2 = (TextView)findViewById(2131380106);
      String str1 = a(this.jdField_a_of_type_JavaLangString, new aeum(null));
      String str2 = a(this.e, new aeul(null));
      paramString.setText(a(getString(2131716467), str1));
      localTextView1.setText(a(getString(2131716468), this.d));
      localTextView2.setText(a(getString(2131716466), str2));
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("RegisterSendUpSms", 1, new Object[] { "initView error : ", paramString.getMessage() });
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
      bdla.a(this.app, "new_reg_805", "send_msg", "send_clk", "", 1, "");
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
  
  private void d()
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      QLog.d("RegisterSendUpSms", 1, "hide loading dialog, but dialog is null");
      return;
    }
    this.jdField_b_of_type_AndroidAppDialog.dismiss();
  }
  
  private void e()
  {
    AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
    if (localAccountManager != null)
    {
      localAccountManager.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      a();
      this.jdField_b_of_type_Int = 2;
    }
  }
  
  private void f()
  {
    bdla.a(this.app, "new_reg", "send_msg", "next_clk", "", 1, "");
    boolean bool = getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false);
    if (!TextUtils.isEmpty(this.g)) {}
    for (int i = 1; bool; i = 0)
    {
      if (this.jdField_a_of_type_Bbcc == null) {
        this.jdField_a_of_type_Bbcc = new bbcc(this);
      }
      getIntent().putExtra("key_register_smscode", this.d);
      getIntent().putExtra("key_register_autologin", true);
      this.jdField_a_of_type_Bbcc.a(getIntent());
      return;
    }
    if (i != 0)
    {
      bbce localbbce = new bbcf().a(this.jdField_a_of_type_JavaLangString).b(this.jdField_b_of_type_JavaLangString).c(this.d).a(true).b(false).d(this.c).a(4).e("").f("").c(true).d(true).e(false).a();
      bbby.a().a(this, this.g, localbbce);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.d, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.c, 4, "", "", true, false);
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
    setContentView(2131562796);
    c(2131716474);
    b();
    if (getIntent().getBooleanExtra("key_register_from_fail_pay_lh", false))
    {
      a(90);
      this.app.setHandler(RegisterSendUpSms.class, this.jdField_a_of_type_MqqOsMqqHandler);
      Intent localIntent = super.getIntent();
      if (localIntent != null)
      {
        this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("phonenum");
        this.c = localIntent.getStringExtra("invite_code");
        this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("key");
        this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
        this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
        this.f = getIntent().getStringExtra("key_register_binded_qq");
      }
      if (QLog.isDevelopLevel()) {
        biaf.a(getClass().getSimpleName(), getIntent());
      }
      this.d = super.getString(2131716475);
      this.e = super.getString(2131716476);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364012));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379826));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramBundle = "";
      if (localIntent != null) {
        paramBundle = localIntent.getStringExtra("key_register_prompt_info");
      }
      if (!TextUtils.isEmpty(paramBundle)) {
        a(paramBundle);
      }
      bdla.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      if (this.jdField_a_of_type_Boolean) {
        break label452;
      }
      bdla.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 1, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      label338:
      if (!TextUtils.isEmpty(this.f)) {
        bdla.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 3, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      }
      if (this.jdField_a_of_type_Int != 7) {
        break label499;
      }
      bdla.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "1", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return true;
      a(50);
      break;
      label452:
      if (this.jdField_b_of_type_Boolean) {
        break label338;
      }
      bdla.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 2, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      break label338;
      label499:
      bdla.a(this.app, "new_reg_805", "send_msg", "page_exp", "", 1, "", "2", "", "", "", "", "", "", "");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Bbcc != null) {
      this.jdField_a_of_type_Bbcc.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "doOnResume mState: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if (this.jdField_b_of_type_Int == 1) {
      e();
    }
    if (this.jdField_a_of_type_Bbcc != null) {
      this.jdField_a_of_type_Bbcc.b();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_a_of_type_Bbcc != null) {
      this.jdField_a_of_type_Bbcc.d();
    }
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
      bdla.a(this.app, "dc00898", "", "", "0X800B4BA", "0X800B4BA", 0, 0, "", "", "", "");
      if (this.jdField_b_of_type_Int == 2)
      {
        QLog.d("RegisterSendUpSms", 1, "check sms, but is querying");
      }
      else
      {
        e();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("RegisterSendUpSms", 2, String.format(Locale.getDefault(), "onClick mState: %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
        }
        bdla.a(this.app, "dc00898", "", "", "0X800B4B9", "0X800B4B9", 0, 0, "", "", "", "");
        b(this.e, this.d);
        this.jdField_b_of_type_Int = 1;
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
    if (this.jdField_a_of_type_Bbca != null) {
      this.jdField_a_of_type_Bbca.a();
    }
    this.jdField_a_of_type_Bbca = null;
    if (this.jdField_a_of_type_Bbcc != null) {
      this.jdField_a_of_type_Bbcc.a();
    }
    this.jdField_a_of_type_Bbcc = null;
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */