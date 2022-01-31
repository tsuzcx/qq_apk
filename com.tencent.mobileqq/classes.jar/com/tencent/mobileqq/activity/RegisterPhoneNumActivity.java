package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import tmu;
import tmv;
import tmw;
import tmx;
import tmy;
import tmz;

public class RegisterPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ConfigClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tmz(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new tmu(this);
  private boolean jdField_a_of_type_Boolean = true;
  private TextView b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView d;
  
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
        if ("852".equals(this.jdField_b_of_type_JavaLangString)) {
          break label170;
        }
        if ("853".equals(this.jdField_b_of_type_JavaLangString))
        {
          break label170;
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
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.jdField_b_of_type_JavaLangString)) {
            i = 0;
          }
        }
        if (!"86".equals(this.jdField_b_of_type_JavaLangString)) {
          break label162;
        }
        j = paramString.length();
        if (j == 11) {
          break label162;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label145;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_b_of_type_JavaLangString);
      if (bool)
      {
        i = 9;
        continue;
        label145:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        i = 6;
      }
    }
  }
  
  @TargetApi(11)
  private void a()
  {
    c(2131434316);
    b();
    a(25);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372023));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131434255) + getString(2131427457));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372025));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131434256) + getString(2131427457));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370263));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131434300));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370264));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d = ((TextView)findViewById(2131370266));
    this.d.setText("+" + this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131365409));
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setCustomSelectionActionModeCallback(new tmv(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370268));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setOnCreateContextMenuListener(new tmw(this));
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString());
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      a(2131434232, 1);
      bool = false;
    }
    return bool;
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(this, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_register_prompt_info", paramString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("key_register_binded_qq", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("selfSet_leftViewText", "返回");
    startActivity(localIntent);
  }
  
  private void c(String paramString)
  {
    if (!a()) {
      return;
    }
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, Long.valueOf(AppSetting.jdField_a_of_type_Int), null);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d()
  {
    if (!a()) {
      return;
    }
    String str = this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if ((localObject != null) && ((localObject instanceof RegisterPhoneNumActivity.UserRegTimeInfo)))
      {
        localObject = (RegisterPhoneNumActivity.UserRegTimeInfo)localObject;
        if ((((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int > 0) && (((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long > 0L))
        {
          long l = System.currentTimeMillis() - ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("RegisterPhoneNumActivity", 2, "startQueryAccount countryCode=" + this.jdField_b_of_type_JavaLangString + ", phoneNum=" + this.jdField_a_of_type_JavaLangString + ", leftTime=" + ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int + ", exitTime=" + ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long + ", interval=" + l);
          }
          if ((l > 0L) && (l < ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int * 1000L))
          {
            a(((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Int, ((RegisterPhoneNumActivity.UserRegTimeInfo)localObject).jdField_a_of_type_Long);
            return;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      a(2131432992, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "RegisterPhoneNumActivity.startQueryAccount countryCode=" + this.jdField_b_of_type_JavaLangString + " phoneNum=" + this.jdField_a_of_type_JavaLangString);
      }
      ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, null);
      b(2131434214);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new tmy(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
    localIntent.putExtra("key_register_binded_qq", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key_register_left_time", paramInt);
    localIntent.putExtra("key_register_exit_time", paramLong);
    localIntent.putExtra("register_verify_code_start_time", System.currentTimeMillis());
    localIntent.putExtra("selfSet_leftViewText", "返回");
    if (QLog.isColorLevel()) {
      QLog.d("RegisterPhoneNumActivity", 2, "go2next countryCode=" + this.jdField_b_of_type_JavaLangString + ", phoneNum=" + this.jdField_a_of_type_JavaLangString + ", leftTime=" + paramInt + ", exitTime=" + paramLong);
    }
    startActivityForResult(localIntent, 2);
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
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1;
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra("k_name");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
      this.d.setText("+" + this.jdField_b_of_type_JavaLangString);
      try
      {
        if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString()) != null)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      String str2 = paramIntent.getStringExtra("phonenum");
      String str3 = paramIntent.getStringExtra("key");
      str1 = str3 + str2;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str1)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str1);
      }
      paramInt1 = paramIntent.getIntExtra("key_register_left_time", 0);
      long l = paramIntent.getLongExtra("key_register_exit_time", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("RegisterPhoneNumActivity", 2, "doOnActivityResult countryCode=" + str3 + ", phoneNum=" + str2 + ", leftTime=" + paramInt1 + ", exitTime=" + l);
      }
      if ((paramInt1 > 0) && (l > 0L))
      {
        paramIntent = new RegisterPhoneNumActivity.UserRegTimeInfo(this);
        paramIntent.jdField_a_of_type_Int = paramInt1;
        paramIntent.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramIntent);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970871);
    if (this.app == null)
    {
      paramBundle = getAppRuntime();
      if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
        this.app = ((QQAppInterface)paramBundle);
      }
    }
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    a();
    ReportController.b(this.app, "CliOper", "", "", "0X8006650", "0X8006650", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", getIntent().getIntExtra("key_report_extra_from", 0), 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    c();
    this.app.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.app.removeHandler(getClass());
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      startActivityForResult(new Intent(this, NewStyleCountryActivity.class), 1);
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X8006651", "0X8006651", 0, 0, "", "", "", "");
      ReportController.a(this.app, "dc00898", "", "", "0X8007CC7", "0X8007CC7", 0, 0, "", "", "", "");
      paramView = this.jdField_c_of_type_AndroidWidgetTextView.getText().toString();
      localObject = this.app;
      if ((!TextUtils.isEmpty(paramView)) && (paramView.equals(getString(2131434299)))) {}
      for (int i = 1;; i = 2)
      {
        ReportController.a((QQAppInterface)localObject, "dc00898", "", "", "0X8007CC7", "0X8007CC7", i, 0, "", "", "", "");
        d();
        return;
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new tmx(this), 1000L);
    Object localObject = new Intent(this, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
    ((Intent)localObject).putExtra("ba_is_login", false);
    if (paramView.getId() == 2131372023) {}
    for (paramView = "http://zc.qq.com/chs/agreement1_chs.html";; paramView = "http://www.qq.com/privacy.htm")
    {
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("selfSet_leftViewText", "返回");
      startActivity((Intent)localObject);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */