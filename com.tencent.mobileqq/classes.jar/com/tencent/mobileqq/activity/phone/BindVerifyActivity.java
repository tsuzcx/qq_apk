package com.tencent.mobileqq.activity.phone;

import aihe;
import aihf;
import aihg;
import aihh;
import aihi;
import alpo;
import amna;
import amnc;
import android.content.Intent;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import aovo;
import awdn;
import azmj;
import bdal;
import bdcd;
import bdee;
import bdfq;
import bhow;
import bhuw;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements amna, Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, bhuw
{
  private int jdField_a_of_type_Int = 0;
  private amnc jdField_a_of_type_Amnc;
  private final Handler jdField_a_of_type_AndroidOsHandler = new bhow(Looper.getMainLooper(), this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awdn jdField_a_of_type_Awdn;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private awdn jdField_b_of_type_Awdn;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("kBindType", 0);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("k_number");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_country_code");
    setLeftViewName(2131690382);
    setTitle("");
    ((TextView)findViewById(2131371059)).setText(2131695197);
    paramIntent = this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
    String str = getString(2131695236, new Object[] { paramIntent });
    SpannableString localSpannableString = new SpannableString(str);
    int i = str.indexOf(paramIntent);
    localSpannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramIntent.length() + i, 17);
    ((TextView)findViewById(2131371057)).setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131379458));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131376341));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375647));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  private void b(String paramString)
  {
    c();
    a("dc00898", "0X8009F18", 0);
    if (!bdee.d(this)) {
      b(2131694829);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("BindVerifyActivity", 2, "doCommit cur: " + this.jdField_c_of_type_Boolean);
      }
    } while (this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Awdn == null)
    {
      this.jdField_a_of_type_Awdn = new aihf(this);
      this.app.registObserver(this.jdField_a_of_type_Awdn);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    a(2131719773, 1000L, true);
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
      azmj.b(this.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
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
    DenyRunnable localDenyRunnable = new DenyRunnable(this, new aihg(this));
    aovo.a(this, this.app, (Runnable)localObject, localDenyRunnable);
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
    localObject = getResources().getString(2131695212, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
    int i = ((String)localObject).indexOf(paramBundle);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramBundle.length() + i, 17);
    paramBundle = bdcd.a(this, 230, null, (CharSequence)localObject, getString(2131690648), getString(2131694951), new aihh(this), new aihi(this));
    if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
      paramBundle.show();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    azmj.b(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
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
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131701514));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131701518));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166975));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 60, 0), 1000L);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_b_of_type_Int == 10) {
      azmj.b(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
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
      azmj.b(localQQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", i, 0, "", "", "", "");
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
    setContentView(2131559418);
    if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+"))) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BindVerifyActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int) }));
      }
      a(getIntent());
      this.jdField_a_of_type_Amnc = new amnc(null, System.currentTimeMillis());
      this.jdField_a_of_type_Amnc.a(this, this);
      a("dc00898", "0X8009F17", 0);
      return true;
      paramBundle = (BounceScrollView)findViewById(2131363441);
      if (paramBundle != null) {
        paramBundle.setOnSizeChangeListener(this);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Awdn != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Awdn);
      this.jdField_a_of_type_Awdn = null;
    }
    if (this.jdField_b_of_type_Awdn != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_Awdn);
      this.jdField_b_of_type_Awdn = null;
    }
    if (this.jdField_a_of_type_Amnc != null) {
      this.jdField_a_of_type_Amnc.a();
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
    paramString1 = bdal.d(paramString1, paramString2);
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
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165826));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131701515));
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166975));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(alpo.a(2131701512), new Object[] { Integer.valueOf(i) }));
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, i, 0), 1000L);
        return true;
        this.jdField_a_of_type_AndroidWidgetEditText.setText((String)paramMessage.obj);
        return true;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        paramMessage = (BounceScrollView)findViewById(2131363441);
      } while (paramMessage == null);
      paramMessage.fullScroll(130);
      return true;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      b();
      a(1, getString(2131719221));
    } while (!QLog.isColorLevel());
    QLog.i("BindVerifyActivity", 2, "MSG_REQUEST_TIMEOUT");
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (b().length() > 0) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368613: 
      doOnBackPressed();
      return;
    case 2131375647: 
      if (this.jdField_b_of_type_Awdn == null)
      {
        this.jdField_b_of_type_Awdn = new aihe(this);
        this.app.registObserver(this.jdField_b_of_type_Awdn);
      }
      if (this.jdField_c_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      }
      for (;;)
      {
        a(2131719773, 1000L, true);
        a("dc00898", "0X8009F1A", 0);
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
    }
    b(b());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */