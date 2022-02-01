package com.tencent.mobileqq.activity;

import Override;
import afjx;
import afjy;
import afjz;
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
import anvx;
import azip;
import azir;
import azit;
import bisl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private Handler jdField_a_of_type_AndroidOsHandler = new afjx(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azip jdField_a_of_type_Azip = new afjz(this);
  private bisl jdField_a_of_type_Bisl;
  private String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new afjy(this);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler();
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private void b()
  {
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363850));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363969));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380305));
    try
    {
      if ((this.c != null) && (this.c.length() > 4))
      {
        String str = "***" + this.c.substring(this.c.length() - 4, this.c.length());
        str = getString(2131694578, new Object[] { this.jdField_a_of_type_JavaLangString, str, this.d });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.d);
    localIntent.putExtra("password", this.e);
    localIntent.putExtra("tab_index", MainFragment.b);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    azir.b(this.app, this.jdField_a_of_type_ArrayOfByte, this.d);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
    }
    azit.a().a(true);
    int i = azit.a().b(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyPhoneNumActivity", 4, "startLogin.GetStViaSMSVerifyLogin ret =" + i);
      }
      h();
      c();
    }
  }
  
  private void f()
  {
    Object localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.b);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new VerifyPhoneNumActivity.7(this));
  }
  
  private void h()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new VerifyPhoneNumActivity.8(this));
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new VerifyPhoneNumActivity.2(this));
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2131563039));
    setTitle(2131694612);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.c = getIntent().getStringExtra("key_register_binduin");
    this.d = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    this.e = getIntent().getStringExtra("key_register_password");
    this.app.registObserver(this.jdField_a_of_type_Azip);
    b();
    setRightButton(2131690697, this);
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
    if (isFinishing()) {
      return;
    }
    if (!azit.a().a())
    {
      QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
      return;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Azip);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_Azip);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.execute(new VerifyPhoneNumActivity.4(this));
      QQToast.a(BaseApplicationImpl.sApplication, anvx.a(2131715416), 0).a();
    }
    LoginActivity.a(this.app, this.app.getAccount());
    f();
    h();
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
      g();
      d();
      continue;
      g();
      e();
      continue;
      c();
      finish();
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
    a();
    this.app.unRegistObserver(this.jdField_a_of_type_Azip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */