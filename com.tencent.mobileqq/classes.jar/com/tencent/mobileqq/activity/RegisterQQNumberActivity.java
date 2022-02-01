package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.loginregister.ContactProxy;
import com.tencent.mobileqq.loginregister.IRegisterView;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class RegisterQQNumberActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener, IRegisterView
{
  WtloginObserver a = new RegisterQQNumberActivity.1(this);
  private TextView b;
  private String c = null;
  private byte[] d = null;
  private byte[] e = null;
  private boolean f = false;
  private boolean g = false;
  private QQProgressDialog h;
  private boolean i = false;
  private String j = null;
  private boolean k = true;
  private boolean l = true;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private RegisterLiangHaoHelper p = null;
  private ContactProxy q;
  private AccountObserver r = new RegisterQQNumberActivity.2(this);
  
  private void a()
  {
    int i1;
    if (this.k) {
      i1 = 2131914109;
    } else {
      i1 = 2131914028;
    }
    setTitleText(i1);
    setBackListener();
    setBarProgress(100);
    Object localObject1 = (ImageView)findViewById(2131442851);
    ((ImageView)localObject1).setVisibility(0);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).rightMargin = ((int)(getResources().getDisplayMetrics().density * 10.0F));
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    Object localObject5 = (ImageView)findViewById(2131442851);
    Object localObject3 = (TextView)findViewById(2131448962);
    this.b = ((TextView)findViewById(2131448952));
    Object localObject4 = (Button)findViewById(2131429915);
    ((Button)localObject4).setOnClickListener(this);
    localObject2 = (TextView)findViewById(2131440087);
    localObject1 = (TextView)findViewById(2131439401);
    View localView = findViewById(2131435901);
    if (!this.k)
    {
      ((ImageView)localObject5).setImageResource(2130848779);
      ((TextView)localObject3).setVisibility(8);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131442846);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(getResources().getDisplayMetrics().density * 50.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      this.b.setTextSize(2, 20.0F);
      this.b.setText(2131914029);
      ((TextView)localObject2).setVisibility(8);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131448952);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(getResources().getDisplayMetrics().density * 50.0F));
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(getResources().getDisplayMetrics().density * 27.5F));
      ((Button)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((Button)localObject4).setText(2131897869);
      ((TextView)localObject1).setVisibility(8);
      return;
    }
    this.b.setText(this.c);
    if (this.i)
    {
      if (!TextUtils.isEmpty(this.j))
      {
        localObject4 = new SpannableString(String.format(getString(2131914098), new Object[] { this.j }));
        ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 8, this.j.length() + 8, 33);
        ((TextView)localObject2).setText((CharSequence)localObject4);
      }
      else
      {
        ((TextView)localObject2).setVisibility(8);
      }
    }
    else if (!this.g)
    {
      localObject4 = new StringBuilder("+");
      ((StringBuilder)localObject4).append(this.countryCode);
      ((StringBuilder)localObject4).append(" ");
      ((StringBuilder)localObject4).append(this.phoneNum.substring(0, 3));
      ((StringBuilder)localObject4).append("-");
      ((StringBuilder)localObject4).append(this.phoneNum.substring(3, 7));
      ((StringBuilder)localObject4).append("-");
      ((StringBuilder)localObject4).append(this.phoneNum.substring(7));
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new SpannableString(String.format(getString(2131914055), new Object[] { localObject4 }));
      ((SpannableString)localObject5).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 9, ((String)localObject4).length() + 9, 33);
      ((TextView)localObject2).setText((CharSequence)localObject5);
    }
    else
    {
      ((TextView)localObject2).setVisibility(8);
    }
    if (this.l)
    {
      ((TextView)localObject3).setText(2131914063);
      ((TextView)localObject1).setVisibility(8);
      return;
    }
    ((TextView)localObject3).setText(2131914062);
    ((TextView)localObject1).setVisibility(0);
    if (!TextUtils.isEmpty(this.inviteCode)) {
      localView.setVisibility(0);
    }
  }
  
  private void a(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    if (this.i) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 1, 0, "", "", "", "");
    }
    if (!this.mIsPhoneNumRegistered) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 2, 0, "", "", "", "");
    } else if (!this.mHasPwd) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 3, 0, "", "", "", "");
    } else if (!bool) {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 4, 0, "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 5, 0, "", "", "", "");
    }
    if (getIntent().getBooleanExtra("key_register_from_send_sms", false))
    {
      if (!bool)
      {
        ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 6, 0, "", "", "", "");
        return;
      }
      ReportController.a(this.mRuntime, "dc00898", "", "", paramString, paramString, 7, 0, "", "", "", "");
    }
  }
  
  private void b()
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("tab_index", 0);
    ((Intent)localObject).putExtra("fragment_id", 1);
    ((Intent)localObject).addFlags(67108864);
    LoginUtils.a(this, (Intent)localObject, "/base/start/splash");
    finish();
    if (!(this.mRuntime instanceof AppInterface))
    {
      QLog.e("RegisterQQNumberActivity", 1, "closeAllActs, app is not appinterface");
      return;
    }
    localObject = ((AppInterface)this.mRuntime).getHandler(LoginProgressClazz.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(2004);
    }
  }
  
  private void c()
  {
    PhoneNumLoginImpl.a().a(true);
    PhoneNumLoginImpl.a().b(this.mRuntime, this.countryCode, this.phoneNum, this.a);
  }
  
  private void d()
  {
    this.handler.post(new RegisterQQNumberActivity.3(this));
  }
  
  private void e()
  {
    this.handler.post(new RegisterQQNumberActivity.4(this));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (!paramString.equals(this.c)) {
        return;
      }
      this.m = paramBoolean;
      if ((!this.m) && (this.n))
      {
        e();
        notifyToast(2131914061, 0);
      }
      else if ((this.m) && (this.n))
      {
        if (this.g) {
          getAppRuntime().login(this.c, this.e, this.r);
        } else {
          this.q.a(this.mRuntime, this.d, this.c);
        }
      }
      this.n = false;
      this.o = false;
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
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void m()
  {
    c();
  }
  
  public void n()
  {
    e();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged success");
    }
    if (this.g)
    {
      this.mRuntime.unRegistObserver(this.q.a(this));
      if (this.i)
      {
        this.mRuntime = getAppRuntime();
        this.q.a(this.mRuntime, this.c);
      }
      b();
      e();
      return;
    }
    if (!PhoneNumLoginImpl.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged not phonenum login");
      }
      return;
    }
    this.mRuntime.unRegistObserver(this.q.a(this));
    this.mRuntime = getAppRuntime();
    this.mRuntime.registObserver(this.q.a(this));
    this.q.a(this.mRuntime);
    this.q.a(this.mRuntime, this.c);
    b();
    e();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131429915)
    {
      ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006655", "0X8006655", 0, 0, "", "", "", "");
      ReportController.a(this.mRuntime, "new_reg", "result_page", "login_clk", "", 1, "", this.c, "", "", "", "", "", "", " ");
      if (this.k)
      {
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CCB", "0X8007CCB", 0, 0, "", "", "", "");
        a("0X8007CCB");
        if (this.i) {
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          notifyToast(2131889169, 0);
        }
        else if ((this.l) && (!this.m))
        {
          if (!this.o)
          {
            this.o = true;
            if (this.p == null) {
              this.p = new RegisterLiangHaoHelper(this, null);
            }
            this.p.a(this.c, new RegisterQQNumberActivity.LHCallback(this));
          }
          this.n = true;
          d();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("RegisterQQNumberActivity", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
          }
          d();
          if (QLog.isColorLevel()) {
            if (this.d != null)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("swz mSign = ");
                localStringBuilder.append(HexUtil.bytes2HexStr(this.d));
                QLog.d("RegisterQQNumberActivity", 2, localStringBuilder.toString());
              }
            }
            else if (QLog.isColorLevel()) {
              QLog.d("RegisterQQNumberActivity", 2, "swz mSign = null");
            }
          }
          if (this.g)
          {
            getAppRuntime().login(this.c, this.e, this.r);
          }
          else
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("RegisterQQNumberActivity", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.c, com.tencent.qphone.base.util.MD5.toMD5(this.d) }));
            }
            this.q.a(this.mRuntime, this.d, this.c);
          }
        }
      }
      else
      {
        finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131628274);
    this.q = new ContactProxy();
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    this.i = getIntent().getBooleanExtra("key_register_from_quick_register", false);
    if (this.i) {
      this.j = getIntent().getStringExtra("key_register_secret_phone");
    }
    this.phoneNum = getIntent().getStringExtra("phonenum");
    this.inviteCode = getIntent().getStringExtra("invite_code");
    this.countryCode = getIntent().getStringExtra("key");
    this.mIsPhoneNumRegistered = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.mHasPwd = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.c = getIntent().getStringExtra("uin");
    this.d = getIntent().getByteArrayExtra("key_register_sign");
    Object localObject1;
    if (QLog.isDevelopLevel())
    {
      localObject1 = Locale.getDefault();
      localObject2 = this.c;
      String str = com.tencent.qphone.base.util.MD5.toMD5(this.d);
      if (this.inviteCode == null) {
        paramBundle = "";
      } else {
        paramBundle = this.inviteCode;
      }
      QLog.d("RegisterQQNumberActivity", 4, String.format((Locale)localObject1, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { localObject2, str, paramBundle }));
    }
    paramBundle = getIntent().getStringExtra("key_register_password");
    if (paramBundle != null) {
      this.e = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte(paramBundle);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCreate ,pwd = ");
      ((StringBuilder)localObject1).append(paramBundle);
      ((StringBuilder)localObject1).append(",mPassByte = ");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("RegisterQQNumberActivity", 2, ((StringBuilder)localObject1).toString());
    }
    this.g = getIntent().getBooleanExtra("key_register_unbind", false);
    if (this.mRuntime == null)
    {
      QLog.d("RegisterQQNumberActivity", 2, "onCreate app is null");
      finish();
      return;
    }
    this.mRuntime.registObserver(this.q.a(this));
    this.k = getIntent().getBooleanExtra("key_register_result", true);
    this.l = getIntent().getBooleanExtra("key_register_is_lh", false);
    if ((this.k) && (this.l))
    {
      this.n = false;
      this.o = true;
      this.p = new RegisterLiangHaoHelper(this, null);
      this.p.a(this.c, new RegisterQQNumberActivity.LHCallback(this));
    }
    a();
    closeAllActs(true);
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006654", "0X8006654", 0, 0, "", "", "", "");
    Object localObject2 = this.mRuntime;
    if (this.k) {
      paramBundle = "0X800735F";
    } else {
      paramBundle = "0X8007CCA";
    }
    if (this.k) {
      localObject1 = "0X800735F";
    } else {
      localObject1 = "0X8007CCA";
    }
    ReportController.a((AppRuntime)localObject2, "dc00898", "", "", paramBundle, (String)localObject1, 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "new_reg", "result_page", "page_exp", "", 1, "", this.c, "", "", "", "", "", "", "");
    a("0X800735F");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mRuntime != null) {
      this.mRuntime.unRegistObserver(this.q.a(this));
    }
    closeDialog();
    e();
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((this.h != null) && (this.h.isShowing()))
      {
        this.h.dismiss();
        this.h.cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity
 * JD-Core Version:    0.7.0.1
 */