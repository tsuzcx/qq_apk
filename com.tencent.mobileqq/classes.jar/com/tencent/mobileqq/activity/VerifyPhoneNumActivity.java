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
  private Handler jdField_a_of_type_AndroidOsHandler = new VerifyPhoneNumActivity.1(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new VerifyPhoneNumActivity.6(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new VerifyPhoneNumActivity.5(this);
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler();
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e = null;
  
  private void b()
  {
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363872));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363987));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380016));
    try
    {
      if ((this.c != null) && (this.c.length() > 4))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("***");
        ((StringBuilder)localObject).append(this.c.substring(this.c.length() - 4, this.c.length()));
        localObject = ((StringBuilder)localObject).toString();
        localObject = getString(2131694785, new Object[] { this.jdField_a_of_type_JavaLangString, localObject, this.d });
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
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
    localIntent.putExtra("uin", this.d);
    localIntent.putExtra("password", this.e);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.addFlags(131072);
    RouteUtils.a(this, localIntent, "/base/login");
    finish();
  }
  
  private void d()
  {
    ContactBindServlet.a(this.app, this.jdField_a_of_type_ArrayOfByte, this.d);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
    }
    PhoneNumLoginImpl.a().a(true);
    int i = PhoneNumLoginImpl.a().b(this.app, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLogin.GetStViaSMSVerifyLogin ret =");
        localStringBuilder.append(i);
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
    this.jdField_b_of_type_AndroidOsHandler.post(new VerifyPhoneNumActivity.7(this));
  }
  
  private void h()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new VerifyPhoneNumActivity.8(this));
  }
  
  protected void a()
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2131563020));
    setTitle(2131694834);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    this.c = getIntent().getStringExtra("key_register_binduin");
    this.d = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    this.e = getIntent().getStringExtra("key_register_password");
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    b();
    setRightButton(2131690728, this);
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
    if (!PhoneNumLoginImpl.a().a())
    {
      QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
      return;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.execute(new VerifyPhoneNumActivity.4(this));
      QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131715805), 0).a();
    }
    BusinessUtils.a(this.app, this.app.getAccount());
    f();
    h();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363872)
    {
      if (i != 2131363987)
      {
        if (i == 2131369233)
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
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */