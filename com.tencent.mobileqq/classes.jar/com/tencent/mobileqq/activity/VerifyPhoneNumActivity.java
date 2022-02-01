package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class VerifyPhoneNumActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected Dialog a;
  WtloginObserver b = new VerifyPhoneNumActivity.5(this);
  private ViewGroup c;
  private Button d;
  private Button e;
  private TextView f;
  private String g;
  private String h;
  private String i;
  private String j;
  private byte[] k = null;
  private String l = null;
  private boolean m = false;
  private Handler n = new VerifyPhoneNumActivity.1(this);
  private ContactBindObserver o = new VerifyPhoneNumActivity.6(this);
  private Handler p = new Handler();
  private QQProgressDialog q;
  
  private void b()
  {
    this.leftView.setVisibility(8);
    this.d = ((Button)this.c.findViewById(2131429820));
    this.d.setOnClickListener(this);
    this.e = ((Button)this.c.findViewById(2131429944));
    this.e.setOnClickListener(this);
    this.f = ((TextView)this.c.findViewById(2131448920));
    try
    {
      if ((this.i != null) && (this.i.length() > 4))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("***");
        ((StringBuilder)localObject).append(this.i.substring(this.i.length() - 4, this.i.length()));
        localObject = ((StringBuilder)localObject).toString();
        localObject = getString(2131892488, new Object[] { this.g, localObject, this.j });
        this.f.setText((CharSequence)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.j);
    localIntent.putExtra("password", this.l);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.addFlags(131072);
    RouteUtils.a(this, localIntent, "/base/login");
    finish();
  }
  
  private void d()
  {
    ContactBindServlet.a(this.app, this.k, this.j);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
    }
    PhoneNumLoginImpl.a().a(true);
    int i1 = PhoneNumLoginImpl.a().b(this.app, this.h, this.g, this.b);
    if (i1 != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLogin.GetStViaSMSVerifyLogin ret =");
        localStringBuilder.append(i1);
        QLog.d("VerifyPhoneNumActivity", 4, localStringBuilder.toString());
      }
      h();
      c();
    }
  }
  
  private void f()
  {
    Object localObject = this.app.getHandler(LoginProgressClazz.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(2004);
    }
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void g()
  {
    this.p.post(new VerifyPhoneNumActivity.7(this));
  }
  
  private void h()
  {
    this.p.post(new VerifyPhoneNumActivity.8(this));
  }
  
  protected void a()
  {
    try
    {
      this.n.post(new VerifyPhoneNumActivity.2(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
    this.c = ((ViewGroup)setContentViewB(2131629628));
    setTitle(2131892537);
    this.g = getIntent().getStringExtra("phonenum");
    this.h = getIntent().getStringExtra("key");
    this.i = getIntent().getStringExtra("key_register_binduin");
    this.j = getIntent().getStringExtra("uin");
    this.k = getIntent().getByteArrayExtra("key_register_sign");
    this.l = getIntent().getStringExtra("key_register_password");
    this.app.registObserver(this.o);
    b();
    setRightButton(2131887648, this);
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
    if (isFinishing()) {
      return;
    }
    if (!PhoneNumLoginImpl.a().b())
    {
      QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
      return;
    }
    this.app.unRegistObserver(this.o);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.o);
    if (this.m)
    {
      this.app.execute(new VerifyPhoneNumActivity.4(this));
      QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131913262), 0).show();
    }
    BusinessUtils.a(this.app, this.app.getAccount());
    f();
    h();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429820)
    {
      if (i1 != 2131429944)
      {
        if (i1 == 2131436211)
        {
          c();
          finish();
        }
      }
      else
      {
        g();
        e();
      }
    }
    else
    {
      g();
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a();
    this.app.unRegistObserver(this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */