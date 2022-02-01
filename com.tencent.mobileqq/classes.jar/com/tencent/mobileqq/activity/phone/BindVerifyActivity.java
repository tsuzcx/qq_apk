package com.tencent.mobileqq.activity.phone;

import Override;
import ajca;
import akcn;
import akco;
import akcp;
import akcq;
import akcr;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import anni;
import aoqg;
import aoqi;
import aywi;
import bcst;
import bgjw;
import bglp;
import bgnt;
import bgpa;
import bkgm;
import bkmo;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, aoqg, bkmo
{
  private int jdField_a_of_type_Int = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler = new bkgm(Looper.getMainLooper(), this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoqi jdField_a_of_type_Aoqi;
  private aywi jdField_a_of_type_Aywi;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private aywi jdField_b_of_type_Aywi;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("kBindType", 0);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("k_number");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_country_code");
    setLeftViewName(2131690389);
    setTitle("");
    ((TextView)findViewById(2131371639)).setText(2131694237);
    paramIntent = this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
    String str = getString(2131694256, new Object[] { paramIntent });
    SpannableString localSpannableString = new SpannableString(str);
    int i = str.indexOf(paramIntent);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramIntent.length() + i, 17);
    ((TextView)findViewById(2131371637)).setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131380451));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377184));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376424));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  private void b(String paramString)
  {
    c();
    a("dc00898", "0X8009F18", 0);
    if (!bgnt.d(this)) {
      a(2131693991);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("BindVerifyActivity", 2, "doCommit cur: " + this.jdField_c_of_type_Boolean);
      }
    } while (this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aywi == null)
    {
      this.jdField_a_of_type_Aywi = new akco(this);
      this.app.registObserver(this.jdField_a_of_type_Aywi);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    a(2131717771, 1000L, true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 30000L);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new BindVerifyActivity.7(this), 300L);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      bcst.b(this.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
    }
    if (getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("bind_mobile", a());
      ((Intent)localObject).putExtra("check_permission_result", "");
      setResult(-1, (Intent)localObject);
      finish();
      return;
    }
    if (this.jdField_b_of_type_Int == 10)
    {
      setResult(-1, null);
      finish();
      return;
    }
    if (this.jdField_b_of_type_Int == 21)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("bind_mobile", a());
      setResult(-1, (Intent)localObject);
      finish();
      return;
    }
    Object localObject = new BindVerifyActivity.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this, new akcp(this));
    ajca.a(this, this.app, (Runnable)localObject, localDenyRunnable);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 100L);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("k_uin");
    paramBundle = a();
    localObject = getResources().getString(2131694249, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
    int i = ((String)localObject).indexOf(paramBundle);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramBundle.length() + i, 17);
    paramBundle = bglp.a(this, 230, null, (CharSequence)localObject, getString(2131690582), getString(2131694081), new akcq(this), new akcr(this));
    if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
      paramBundle.show();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    bcst.b(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public String b()
  {
    String str = "";
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject != null) {
      str = localObject.toString();
    }
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(anni.a(2131699950));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131699954));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167060));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 60, 0), 1000L);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_b_of_type_Int == 10) {
      bcst.b(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
    }
    QQAppInterface localQQAppInterface;
    if (getIntent().getBooleanExtra("k_is_block", false))
    {
      localQQAppInterface = this.app;
      if (b().length() < 4) {
        break label107;
      }
    }
    label107:
    for (int i = 1;; i = 0)
    {
      bcst.b(localQQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", i, 0, "", "", "", "");
      setResult(0);
      super.doOnBackPressed();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("keyReqBindMode", 0);
    getWindow().setSoftInputMode(18);
    setContentView(2131559547);
    if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BindVerifyActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      a(getIntent());
      this.jdField_a_of_type_Aoqi = new aoqi(null, System.currentTimeMillis());
      this.jdField_a_of_type_Aoqi.a(this, this);
      a("dc00898", "0X8009F17", 0);
      return true;
      paramBundle = (BounceScrollView)findViewById(2131363636);
      if (paramBundle != null) {
        paramBundle.setOnSizeChangeListener(this);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aywi != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Aywi);
      this.jdField_a_of_type_Aywi = null;
    }
    if (this.jdField_b_of_type_Aywi != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_Aywi);
      this.jdField_b_of_type_Aywi = null;
    }
    if (this.jdField_a_of_type_Aoqi != null) {
      this.jdField_a_of_type_Aoqi.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setKeyListener(null);
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnPause");
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnResume");
    }
    if (b().length() == 0) {
      c();
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = bgjw.d(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString1).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        int i = paramMessage.arg1 - 1;
        paramMessage.arg1 = i;
        if (i <= 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165880));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131699951));
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167060));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(anni.a(2131699948), new Object[] { Integer.valueOf(i) }));
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, i, 0), 1000L);
        return true;
        this.jdField_a_of_type_AndroidWidgetEditText.setText((String)paramMessage.obj);
        return true;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        paramMessage = (BounceScrollView)findViewById(2131363636);
      } while (paramMessage == null);
      paramMessage.fullScroll(130);
      return true;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      b();
      a(1, getString(2131717326));
    } while (!QLog.isColorLevel());
    QLog.i("BindVerifyActivity", 2, "MSG_REQUEST_TIMEOUT");
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (b().length() <= 0) {
        break label31;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label31:
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
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
      doOnBackPressed();
      continue;
      if (this.jdField_b_of_type_Aywi == null)
      {
        this.jdField_b_of_type_Aywi = new akcn(this);
        this.app.registObserver(this.jdField_b_of_type_Aywi);
      }
      if (this.jdField_c_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      }
      for (;;)
      {
        a(2131717771, 1000L, true);
        a("dc00898", "0X8009F1A", 0);
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
      b(b());
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (b().length() >= 4)) {
      b(b());
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */