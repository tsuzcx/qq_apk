package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import tvc;
import tvd;
import tve;
import tvf;
import tvg;

public class RegisterVerifyCodeActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, SMSBodyObserver
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131370420, 2131370421, 2131370422, 2131370423, 2131370424, 2131370425 };
  private int jdField_a_of_type_Int = 60;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private Runnable jdField_a_of_type_JavaLangRunnable = new tvc(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tve(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new tvd(this);
  private boolean jdField_a_of_type_Boolean = true;
  private EditText[] jdField_a_of_type_ArrayOfAndroidWidgetEditText = new EditText[6];
  private int jdField_b_of_type_Int = 60;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String f;
  private String g;
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "v1:" + paramString1 + " v2:" + paramString2);
    }
    String[] arrayOfString = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int j;
    int k;
    if (arrayOfString.length > paramString2.length)
    {
      j = arrayOfString.length;
      k = 0;
    }
    for (;;)
    {
      if (k >= j) {
        break label141;
      }
      int i;
      int m;
      for (;;)
      {
        try
        {
          i = Integer.parseInt(arrayOfString[k]);
        }
        catch (Exception paramString1)
        {
          i = 0;
        }
        try
        {
          m = Integer.parseInt(paramString2[k]);
          if (i <= m) {
            break label124;
          }
          return 1;
        }
        catch (Exception paramString1)
        {
          break label114;
        }
        j = paramString2.length;
        break;
        label114:
        paramString1.printStackTrace();
        m = 0;
      }
      label124:
      if (i < m) {
        return -1;
      }
      k += 1;
    }
    label141:
    return 0;
  }
  
  private void d()
  {
    c(2131434290);
    b();
    a(50);
    TextView localTextView = (TextView)findViewById(2131370078);
    String str1 = "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
    String str2 = getString(2131434292, new Object[] { str1 });
    SpannableString localSpannableString = new SpannableString(str2);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-881592);
    int i = str2.indexOf(str1);
    int j = str2.indexOf(str1);
    localSpannableString.setSpan(localForegroundColorSpan, i, str1.length() + j, 33);
    localTextView.setText(localSpannableString);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370080));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434293) + "(" + this.jdField_a_of_type_Int + "s)");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    i = 0;
    while (i < 6)
    {
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i] = ((EditText)findViewById(jdField_a_of_type_ArrayOfInt[i]).findViewById(2131375008));
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].addTextChangedListener(this);
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].setOnKeyListener(this);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131372240));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364958));
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372244));
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131372243));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372242));
    } while (getResources().getDisplayMetrics().heightPixels < 480);
    new RegisterVerifyCodeActivity.RegDevLockCfgDownloadTask(this).execute(new Void[0]);
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131434293) + "(" + this.jdField_a_of_type_Int + "s)");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void e()
  {
    try
    {
      this.g = null;
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      b(2131434247);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2131433023, 0);
      return;
    }
    Object localObject = new StringBuilder("");
    int i = 0;
    while (i < 6)
    {
      Editable localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
      if (localEditable != null) {
        ((StringBuilder)localObject).append(localEditable.toString());
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (localObject != null) {
      localObject = ((String)localObject).trim();
    }
    for (;;)
    {
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        try
        {
          ((AccountManager)this.app.getManager(0)).sendRegisterByCommitSmsVerifycode((String)localObject, this.jdField_a_of_type_MqqObserverAccountObserver);
          b(2131434251);
          ReportController.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 0, 0, "", "", "", "");
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked()))
          {
            ReportController.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 1, 0, "", "", "", "");
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) && ((this.jdField_b_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)))
        {
          ReportController.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 4, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetCheckBox != null) && (!this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked())) {
          ReportController.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 2, 0, "", "", "", "");
        }
        if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) || (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {
          break;
        }
        ReportController.a(this.app, "dc00898", "", "", "0X8007CC8", "0X8007CC8", 3, 0, "", "", "", "");
        return;
      }
      a(2131434291, 0);
      return;
    }
  }
  
  public void a()
  {
    PhoneNumLoginImpl.a().a(this.app, this.jdField_e_of_type_Boolean);
    Object localObject1 = new StringBuilder("");
    int i = 0;
    while (i < 6)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[i].getText();
      if (localObject2 != null) {
        ((StringBuilder)localObject1).append(localObject2.toString());
      }
      i += 1;
    }
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = new Intent(this, RegisterChooseLoginActivity.class);
      ((Intent)localObject2).putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_register_smscode", (String)localObject1);
      ((Intent)localObject2).putExtra("key_register_binded_qq", this.jdField_c_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_register_binded_qq_nick", this.jdField_d_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_register_binded_qq_face_url", this.jdField_e_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
      ((Intent)localObject2).putExtra("key_register_chose_bind_phone", this.jdField_a_of_type_Boolean);
      startActivity((Intent)localObject2);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      RegisterPersonalInfoActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1, false, true);
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (String)localObject1, false, this.jdField_c_of_type_Boolean, true);
  }
  
  public void a(Bundle paramBundle)
  {
    this.app.runOnUiThread(new tvg(this, paramBundle));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = 1;
    int j = 0;
    Editable localEditable;
    if (j < 6)
    {
      localEditable = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[j].getText();
      if (localEditable == null) {
        break label163;
      }
    }
    label135:
    label163:
    for (int k = localEditable.toString().length();; k = 0)
    {
      View localView = findViewById(jdField_a_of_type_ArrayOfInt[j]).findViewById(2131375009);
      if ((localEditable != null) && (localEditable == paramEditable))
      {
        if (k <= 0) {
          break label135;
        }
        localView.setBackgroundColor(-9474193);
        if (j < 5)
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].requestFocus();
          this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(j + 1)].length());
        }
      }
      label116:
      if ((localEditable == null) || (k <= 0)) {
        i = 0;
      }
      for (;;)
      {
        j += 1;
        break;
        if (k != 0) {
          break label116;
        }
        localView.setBackgroundColor(-2170912);
        break label116;
        if (i != 0) {
          f();
        }
        return;
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970942);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key");
    int i = getIntent().getIntExtra("key_register_left_time", 0);
    long l = getIntent().getLongExtra("key_register_exit_time", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "onCreate countryCode=" + this.jdField_b_of_type_JavaLangString + ", phoneNum=" + this.jdField_a_of_type_JavaLangString + ", leftTime=" + i + ", exitTime=" + l);
    }
    if ((i > 0) && (i < 60) && (l > 0L))
    {
      l = System.currentTimeMillis() - l;
      if ((l > 0L) && (l < i * 1000L)) {
        this.jdField_a_of_type_Int = (i - (int)(l / 1000L));
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "onCreate interval=" + l + ", second=" + this.jdField_a_of_type_Int);
      }
    }
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("key_register_binded_qq");
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    d();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null, getIntent().getLongExtra("register_verify_code_start_time", 0L));
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
    ReportController.b(this.app, "CliOper", "", "", "0X8006656", "0X8006656", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 0, 0, "", "", "", "");
    if (!this.jdField_b_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if (!this.jdField_c_of_type_Boolean) {
        ReportController.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 2, 0, "", "", "", "");
      } else {
        ReportController.a(this.app, "dc00898", "", "", "0X8007361", "0X8007361", 3, 0, "", "", "", "");
      }
    }
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new tvf(this, paramString1, paramString2));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "onBackEvent second=" + this.jdField_a_of_type_Int + ", curTime=" + System.currentTimeMillis());
      }
      getIntent().putExtra("key_register_left_time", this.jdField_a_of_type_Int);
      getIntent().putExtra("key_register_exit_time", System.currentTimeMillis());
      setResult(-1, getIntent());
    }
    finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131372243) {
      this.jdField_e_of_type_Boolean = paramBoolean;
    }
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8006657", "0X8006657", 0, 0, "", "", "", "");
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(true);
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_b_of_type_AndroidWidgetCheckBox == null);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(null);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2131433023, 0);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370080: 
      e();
      return;
    }
    f();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0) && ((paramView instanceof EditText)))
    {
      paramView = ((EditText)paramView).getText();
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt < 6)
      {
        paramKeyEvent = this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[paramInt].getText();
        if ((paramKeyEvent == null) || (paramKeyEvent != paramView)) {
          break label159;
        }
        if ((paramInt <= 0) || (paramInt >= 6) || (paramKeyEvent.toString().length() > 0)) {
          break label125;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].setText("");
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].requestFocus();
        this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].setSelection(this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[(paramInt - 1)].length());
      }
      label125:
      while ((paramInt < 0) || (paramInt >= 6) || (paramKeyEvent.toString().length() <= 0)) {
        return false;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetEditText[paramInt].setText("");
      return false;
      label159:
      paramInt += 1;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */