package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import wqm;
import wqn;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, SMSBodyObserver
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
  public BindVerifyActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("kBindType", 0);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("kShowAgree", false);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("k_number");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_country_code");
    paramIntent = this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
    Object localObject;
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17))
    {
      localObject = getString(2131428427, new Object[] { paramIntent });
      SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
      ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-881592);
      int i = ((String)localObject).indexOf(paramIntent);
      int j = ((String)localObject).indexOf(paramIntent);
      localSpannableString.setSpan(localForegroundColorSpan, i, paramIntent.length() + j, 33);
      ((TextView)findViewById(2131365421)).setText(localSpannableString);
      setTitle("输入短信验证码");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        findViewById(2131365420).setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("重新发送");
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 60, 0), 1000L);
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject = new SpannableStringBuilder(getString(2131428427, new Object[] { paramIntent }));
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-31676), 12, paramIntent.length() + 12, 33);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      else if (1 == this.jdField_a_of_type_Int)
      {
        localObject = new SpannableStringBuilder(getString(2131428428, new Object[] { paramIntent }));
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-31676), 12, paramIntent.length() + 12, 33);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
  }
  
  private void b()
  {
    if (!NetworkUtil.d(this))
    {
      b(2131434596);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new wqn(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80056B5", "0X80056B5", 0, 0, "", "", "", "");
    }
    if ((getIntent() != null) && (getIntent().getBooleanExtra("key_is_from_qav_multi_call", false))) {
      ReportController.b(this.app, "CliOper", "", "", "0X8005D0F", "0X8005D0F", 0, 0, "", "", "", "");
    }
    if (this.jdField_b_of_type_Int == 10) {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA7", "0X8006AA7", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    a(2131434436, 1000L, true);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() >= 4))
    {
      if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17))
      {
        this.rightViewText.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17))
    {
      this.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != 0)
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_b_of_type_Int == 10) {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
    }
    QQAppInterface localQQAppInterface;
    if (getIntent().getBooleanExtra("k_is_block", false))
    {
      localQQAppInterface = this.app;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() < 4) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", i, 0, "", "", "", "");
      super.doOnBackPressed();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("keyReqBindMode", 0);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doOnCreate ,mSource = " + this.jdField_b_of_type_Int + ",mReqBindMode = " + this.jdField_c_of_type_Int);
    }
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17))
    {
      getWindow().setSoftInputMode(16);
      setContentView(2130969160);
      setRightButton(2131434517, this);
      setLeftViewName(2131432397);
      this.leftView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365417));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365418));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365410));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364041));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365412));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365419));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      if (!this.jdField_b_of_type_Boolean) {
        break label412;
      }
      setTitle("输入短信验证码");
      ReportController.b(this.app, "CliOper", "", "", "0X8005B79", "0X8005B79", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a(getIntent());
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
      return true;
      setContentView(2130969159);
      break;
      label412:
      setTitle("验证手机号码");
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = Utils.d(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString1).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      int i = paramMessage.arg1 - 1;
      paramMessage.arg1 = i;
      if (i <= 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setText("重新发送");
        return true;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("重新发送(" + i + ")");
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, i, 0), 1000L);
      return true;
    }
    paramMessage = (String)paramMessage.obj;
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramMessage);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramMessage.length());
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) {
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131363227: 
    case 2131363410: 
      do
      {
        return;
        doOnBackPressed();
        return;
      } while ((this.jdField_b_of_type_Int != 10) && (this.jdField_b_of_type_Int != 11) && (this.jdField_b_of_type_Int != 15) && (this.jdField_b_of_type_Int != 17));
      b();
      return;
    case 2131365410: 
      b();
      return;
    case 2131365419: 
      if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new wqm(this);
        this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17))
      {
        this.rightViewText.setEnabled(false);
        if (this.jdField_c_of_type_Int != 1) {
          break label281;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("k_is_block", false)) {
          ReportController.b(this.app, "CliOper", "", "", "0X800568C", "0X800568C", 1, 0, "", "", "", "");
        }
        a(2131434436, 1000L, true);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        break;
        label281:
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
    }
    paramView = new Intent(this, TosActivity.class);
    paramView.putExtra("frombusiness", 0);
    startActivity(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */