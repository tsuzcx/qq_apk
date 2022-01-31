package com.tencent.mobileqq.activity;

import addu;
import addv;
import amna;
import amnc;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import awdr;
import bdee;
import bepp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;

public class LoginVerifyCodeActivity2
  extends RegisterBaseActivity
  implements amna, TextWatcher, View.OnClickListener
{
  private int jdField_a_of_type_Int = 60;
  private amnc jdField_a_of_type_Amnc;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bepp jdField_a_of_type_Bepp;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LoginVerifyCodeActivity2.2(this);
  public SSOAccountObserver a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new addv(this);
  private int b;
  
  public LoginVerifyCodeActivity2()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new addu(this);
  }
  
  private void b()
  {
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379120)).setText(getString(2131717564, new Object[] { this.jdField_a_of_type_JavaLangString }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363687));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717532) + "(" + this.jdField_a_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363636));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371305));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717532) + "(" + this.jdField_a_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void d()
  {
    awdr.a().b(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void e()
  {
    a(2131717544);
    if (awdr.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      c();
      a();
    }
  }
  
  private void f()
  {
    Object localObject1 = "";
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject2 != null)
    {
      localObject2 = localObject2.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
    }
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      a(2131717453);
      if (awdr.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        c();
        a();
      }
      return;
    }
    a(2131717464, 0);
  }
  
  public void a()
  {
    a(2131719225, 1);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (QLog.isDevelopLevel())
      {
        paramIntent = new StringBuilder().append("doOnActivityResult, REQ_CODE_NOTIFICATION_LH  ");
        if (paramInt2 != -1) {
          break label64;
        }
      }
    }
    for (;;)
    {
      QLog.i("LoginVerifyCodeActivity", 4, bool);
      if (paramInt2 == -1) {
        finish();
      }
      return;
      label64:
      bool = false;
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new LoginVerifyCodeActivity2.6(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    if (!bdee.d(BaseApplication.getContext()))
    {
      a(2131692397, 0);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363636: 
      f();
      return;
    }
    e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2131561011));
    setTitle(2131717573);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_b_of_type_Int = getIntent().getIntExtra("key_req_src", -1);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    b();
    this.jdField_a_of_type_Amnc = new amnc(null);
    this.jdField_a_of_type_Amnc.a(this, this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (this.jdField_a_of_type_Amnc != null) {
      this.jdField_a_of_type_Amnc.a();
    }
    this.jdField_a_of_type_Amnc = null;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginVerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */