package com.tencent.mobileqq.activity;

import Override;
import aehy;
import aehz;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import azit;
import bdla;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class LoginPhoneNumActivity2
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aehz(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aehy(this);
  private String c;
  
  private String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.b)) {
          break label147;
        }
        if ("853".equals(this.b))
        {
          break label147;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        if (paramString.startsWith("1")) {
          break label137;
        }
        bool = "86".equals(this.b);
        if (!bool) {
          break label137;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label120;
        i = j;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.b);
      if (bool)
      {
        i = 9;
        continue;
        label120:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label137:
        continue;
        label147:
        i = 6;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      a(2131716447, 1);
      bool = false;
    }
    return bool;
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + " " + paramString2;
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramString1, 0, paramString1.length(), localRect);
    int i = getResources().getDimensionPixelSize(2131297471);
    int j = getResources().getDimensionPixelSize(2131297470);
    if (localRect.right > i - j)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380310));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b(getString(2131716405), "+" + this.b);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372159));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131363964));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void e()
  {
    if (!a()) {}
    do
    {
      return;
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        a(2131692125, 0);
        return;
      }
      a(2131716489);
      if (QLog.isColorLevel()) {
        QLog.d("LoginPhoneNumActivity", 2, "-->startQueryAccount--CheckSMSVerifyLoginAccount, countryCode = " + this.b + "phoneNum = " + this.jdField_a_of_type_JavaLangString);
      }
    } while (azit.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    c();
    a(getString(2131716463), 1);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity2.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key", this.b);
    localIntent.putExtra("key_req_src", this.jdField_a_of_type_Int);
    localIntent.putExtra("appid", this.c);
    startActivityForResult(localIntent, 10000);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (a(paramEditable.toString()) != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void b()
  {
    a(2131718059, 1);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginPhoneNumActivity", 2, "-->onActivityResult--reqCode = " + paramInt1 + ", resCode = " + paramInt2);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra("last_account");
      str2 = paramIntent.getStringExtra("wtTicket");
      localIntent = new Intent();
      localIntent.putExtra("last_account", str1);
      localIntent.putExtra("wtTicket", str2);
      localIntent.putExtra("ssobundle", paramIntent.getBundleExtra("ssobundle"));
      setResult(-1, localIntent);
      finish();
    }
    while ((paramInt1 != 1) || (paramInt2 != -1))
    {
      String str2;
      Intent localIntent;
      return;
    }
    String str1 = paramIntent.getStringExtra("k_name");
    this.b = paramIntent.getStringExtra("k_code");
    b(str1, "+" + this.b);
    try
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      continue;
      e();
    }
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2131561215));
    setTitle(2131719897);
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_req_src", -1);
    this.c = paramBundle.getStringExtra("appid");
    if (QLog.isColorLevel()) {
      QLog.d("LoginPhoneNumActivity", 2, "-->onCreate--mReqSrc = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    d();
    bdla.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    bdla.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 4, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.removeHandler(getClass());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity2
 * JD-Core Version:    0.7.0.1
 */