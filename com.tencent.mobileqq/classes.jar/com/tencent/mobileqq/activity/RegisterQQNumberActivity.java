package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import tnb;
import tnc;
import tnd;
import tne;
import tnf;
import tng;

public class RegisterQQNumberActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new tnd(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tne(this);
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new tnc(this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private byte[] b;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = true;
  
  private void a()
  {
    if (this.f) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    for (int i = 2131434266;; i = 2131434267)
    {
      c(i);
      b();
      a(100);
      localObject1 = (ImageView)findViewById(2131374747);
      ((ImageView)localObject1).setVisibility(0);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).rightMargin = ((int)(10.0F * getResources().getDisplayMetrics().density));
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      Object localObject4 = (ImageView)findViewById(2131374747);
      TextView localTextView = (TextView)findViewById(2131369992);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372039));
      localObject2 = (Button)findViewById(2131372041);
      ((Button)localObject2).setOnClickListener(this);
      localObject1 = (TextView)findViewById(2131372040);
      localObject3 = (TextView)findViewById(2131372042);
      if (this.f) {
        break;
      }
      ((ImageView)localObject4).setImageResource(2130843736);
      localTextView.setVisibility(8);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131372038);
      ((RelativeLayout.LayoutParams)localObject4).topMargin = ((int)(50.0F * getResources().getDisplayMetrics().density));
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject4).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131434268);
      ((TextView)localObject1).setVisibility(8);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131372039);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(50.0F * getResources().getDisplayMetrics().density));
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      ((Button)localObject2).setText(2131436303);
      ((TextView)localObject3).setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    if (this.e)
    {
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localObject2 = new SpannableString(String.format(getString(2131434305), new Object[] { this.jdField_d_of_type_JavaLangString }));
        ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 8, this.jdField_d_of_type_JavaLangString.length() + 8, 33);
        ((TextView)localObject1).setText((CharSequence)localObject2);
        return;
      }
      ((TextView)localObject1).setVisibility(8);
      return;
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject2 = "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString.substring(0, 3) + "-" + this.jdField_a_of_type_JavaLangString.substring(3, 7) + "-" + this.jdField_a_of_type_JavaLangString.substring(7);
      localObject3 = new SpannableString(String.format(getString(2131434304), new Object[] { localObject2 }));
      ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 9, ((String)localObject2).length() + 9, 33);
      ((TextView)localObject1).setText((CharSequence)localObject3);
      return;
    }
    ((TextView)localObject1).setVisibility(8);
  }
  
  private void b(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    if (this.e) {
      ReportController.a(this.app, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    if (!this.jdField_b_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("key_register_from_send_sms", false))
      {
        if (bool) {
          break;
        }
        ReportController.a(this.app, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
      }
      return;
      if (!this.jdField_c_of_type_Boolean) {
        ReportController.a(this.app, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
      } else if (!bool) {
        ReportController.a(this.app, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
      } else {
        ReportController.a(this.app, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
      }
    }
    ReportController.a(this.app, "dc00898", "", "", paramString, paramString, 7, 0, "", "", "", "");
  }
  
  private void d()
  {
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.a);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
    localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
  }
  
  private void e()
  {
    PhoneNumLoginImpl.a().a(true);
    PhoneNumLoginImpl.a().b(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tnf(this));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tng(this));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged success");
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      if (this.e)
      {
        this.app = ((QQAppInterface)getAppRuntime());
        LoginActivity.a(this.app, this.app.getAccount());
      }
      d();
      g();
    }
    do
    {
      return;
      if (PhoneNumLoginImpl.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged not phonenum login");
    return;
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.a(new tnb(this));
      QQToast.a(BaseApplicationImpl.sApplication, "特征码匹配中。", 0).a();
    }
    LoginActivity.a(this.app, this.app.getAccount());
    d();
    g();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8006655", "0X8006655", 0, 0, "", "", "", "");
    if (this.f)
    {
      ReportController.a(this.app, "dc00898", "", "", "0X8007CCB", "0X8007CCB", 0, 0, "", "", "", "");
      b("0X8007CCB");
      if (this.e) {
        ReportController.a(this.app, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
      }
      if (!NetworkUtil.d(BaseApplication.getContext())) {
        a(2131432992, 0);
      }
    }
    else
    {
      finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    f();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label276;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
    }
    while (this.jdField_d_of_type_Boolean)
    {
      getAppRuntime().login(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
      label276:
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = null");
      }
    }
    ContactBindServlet.a(this.app, this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_JavaLangString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130970874);
    this.e = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    if (this.e) {
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("key_register_secret_phone");
    }
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    paramBundle = getIntent().getStringExtra("key_register_password");
    if (paramBundle != null) {
      this.jdField_b_of_type_ArrayOfByte = MD5.toMD5Byte(paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onCreate ,pwd = " + paramBundle + ",mPassByte = " + this.jdField_b_of_type_ArrayOfByte);
    }
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("key_register_unbind", false);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.f = getIntent().getBooleanExtra("key_register_result", true);
    a();
    paramBundle = this.app.getHandler(RegisterChooseLoginActivity.class);
    if (paramBundle != null) {
      paramBundle.sendEmptyMessage(105);
    }
    paramBundle = this.app.getHandler(RegisterSendUpSms.class);
    if (paramBundle != null) {
      paramBundle.sendEmptyMessage(107);
    }
    paramBundle = this.app.getHandler(RegisterVerifyCodeActivity.class);
    if (paramBundle != null) {
      paramBundle.sendEmptyMessage(106);
    }
    paramBundle = this.app.getHandler(RegisterPhoneNumActivity.class);
    if (paramBundle != null) {
      paramBundle.sendEmptyMessage(103);
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8006654", "0X8006654", 0, 0, "", "", "", "");
    QQAppInterface localQQAppInterface = this.app;
    if (this.f)
    {
      paramBundle = "0X800735F";
      if (!this.f) {
        break label443;
      }
    }
    label443:
    for (String str = "0X800735F";; str = "0X8007CCA")
    {
      ReportController.a(localQQAppInterface, "dc00898", "", "", paramBundle, str, 0, 0, "", "", "", "");
      b("0X800735F");
      return;
      paramBundle = "0X8007CCA";
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    c();
    g();
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity
 * JD-Core Version:    0.7.0.1
 */