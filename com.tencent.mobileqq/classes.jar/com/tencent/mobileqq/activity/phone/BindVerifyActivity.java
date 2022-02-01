package com.tencent.mobileqq.activity.phone;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.OnSizeChangeListener;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, SMSBodyObserver, OnSizeChangeListener
{
  private int jdField_a_of_type_Int = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = -1;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
  private void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("kBindType", 0);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("k_number");
    this.jdField_a_of_type_ArrayOfByte = paramIntent.getByteArrayExtra("cmd_param_encrypt_mobile");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_mask_number_forshow");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("k_country_code");
    setLeftViewName(2131690529);
    setTitle("");
    TextView localTextView = (TextView)findViewById(2131371790);
    Object localObject = (TextView)findViewById(2131380406);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377197));
    String str = a();
    if (this.jdField_b_of_type_Int == 23)
    {
      paramIntent = getString(2131694832, new Object[] { str });
      localTextView.setText(2131694833);
      ((TextView)localObject).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131694824));
    }
    else
    {
      localTextView.setText(2131694797);
      paramIntent = getString(2131694835, new Object[] { str });
      ((TextView)localObject).setVisibility(8);
    }
    localObject = new SpannableString(paramIntent);
    int i = paramIntent.indexOf(str);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, str.length() + i, 17);
    ((TextView)findViewById(2131371788)).setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131380401));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376461));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b();
  }
  
  private void a(String paramString)
  {
    e();
    a("dc00898", "0X8009F18", 0);
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131694475);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCommit cur: ");
      localStringBuilder.append(this.d);
      QLog.i("BindVerifyActivity", 2, localStringBuilder.toString());
    }
    if (this.d) {
      return;
    }
    this.d = true;
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new BindVerifyActivity.2(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    }
    this.mPhoneContactService.sendVerifySmsCode(paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    showProgressDialog(2131718766, 1000L, true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 30000L);
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      d();
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.mPhoneContactService.sendBindMobileEncrypt(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      return;
    }
    this.mPhoneContactService.sendBindMobile(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.mPhoneContactService.sendRebindMobileEncrypt(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      return;
    }
    this.mPhoneContactService.sendRebindMobile(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new BindVerifyActivity.7(this), 300L);
  }
  
  protected String a()
  {
    StringBuilder localStringBuilder;
    String str;
    if (this.jdField_c_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(" ");
      str = this.jdField_b_of_type_JavaLangString;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(" ");
      str = this.jdField_a_of_type_JavaLangString;
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
    }
    Intent localIntent;
    if (getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
    {
      localIntent = new Intent();
      localIntent.putExtra("bind_mobile", a());
      localIntent.putExtra("check_permission_result", "");
      setResult(-1, localIntent);
      finish();
      return;
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 10)
    {
      setResult(-1, null);
      finish();
      return;
    }
    if (i == 21)
    {
      localIntent = new Intent();
      localIntent.putExtra("bind_mobile", a());
      setResult(-1, localIntent);
      finish();
      return;
    }
    PermissionChecker.a(this, new BindVerifyActivity.3(this), new DenyRunnable(this, new BindVerifyActivity.4(this)));
  }
  
  protected void a(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("k_uin");
    paramBundle = a();
    localObject = getResources().getString(2131694826, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
    int i = ((String)localObject).indexOf(paramBundle);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramBundle.length() + i, 17);
    paramBundle = DialogUtil.a(this, 230, null, (CharSequence)localObject, getString(2131690728), getString(2131694583), new BindVerifyActivity.5(this), new BindVerifyActivity.6(this));
    if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
      paramBundle.show();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
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
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject1 != null) {
      localObject1 = localObject1.toString();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  protected void b()
  {
    this.d = false;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131701362));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701366));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167138));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(1, 60, 0), 1000L);
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_b_of_type_Int == 10) {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
    }
    if (getIntent().getBooleanExtra("k_is_block", false))
    {
      QQAppInterface localQQAppInterface = this.app;
      int i;
      if (b().length() >= 4) {
        i = 1;
      } else {
        i = 0;
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", i, 0, "", "", "", "");
    }
    setResult(0);
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_encrypt", false);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("keyReqBindMode", 0);
    getWindow().setSoftInputMode(18);
    setContentView(2131559541);
    if ((!Build.MANUFACTURER.equalsIgnoreCase("Letv")) || (!Build.MODEL.equalsIgnoreCase("X900+")))
    {
      paramBundle = (BounceScrollView)findViewById(2131363786);
      if (paramBundle != null) {
        paramBundle.setOnSizeChangeListener(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    a(getIntent());
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
    a("dc00898", "0X8009F17", 0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = null;
    }
    SmsContent localSmsContent = this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
    if (localSmsContent != null) {
      localSmsContent.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setKeyListener(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnPause");
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.i("BindVerifyActivity", 2, "doOnResume");
    }
    if (b().length() == 0) {
      e();
    }
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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return true;
          }
          this.d = false;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
          dismissProgressDialog();
          showToast(1, getString(2131718218));
          if (QLog.isColorLevel())
          {
            QLog.i("BindVerifyActivity", 2, "MSG_REQUEST_TIMEOUT");
            return true;
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
          paramMessage = (BounceScrollView)findViewById(2131363786);
          if (paramMessage != null)
          {
            paramMessage.fullScroll(130);
            return true;
          }
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText((String)paramMessage.obj);
        return true;
      }
    }
    else
    {
      i = paramMessage.arg1 - 1;
      paramMessage.arg1 = i;
      if (i <= 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131165915));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701363));
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        return true;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167138));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131701360), new Object[] { Integer.valueOf(i) }));
      paramMessage = this.jdField_a_of_type_AndroidOsHandler;
      paramMessage.sendMessageDelayed(paramMessage.obtainMessage(1, i, 0), 1000L);
    }
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (b().length() > 0) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369202)
    {
      if (i != 2131376461)
      {
        if (i == 2131377197) {
          a(b());
        }
      }
      else
      {
        if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null)
        {
          this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new BindVerifyActivity.1(this);
          this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
        }
        c();
        showProgressDialog(2131718766, 1000L, true);
        a("dc00898", "0X8009F1A", 0);
      }
    }
    else {
      doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
      a(b());
    }
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 100L);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity
 * JD-Core Version:    0.7.0.1
 */