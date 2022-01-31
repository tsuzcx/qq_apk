package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TelephonyUtils;
import com.tencent.widget.OnSizeChangeListener;
import wtg;
import wth;
import wti;
import wtj;
import wtk;
import wtl;

public class BindNumberActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, OnSizeChangeListener
{
  private int jdField_a_of_type_Int = -100000;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public Button a;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  public EditText a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public QQCustomDialog a;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public QQCustomDialog b;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public QQCustomDialog c;
  private String jdField_c_of_type_JavaLangString = "中国大陆";
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public BindNumberActivity()
  {
    this.jdField_a_of_type_JavaLangString = "+86";
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, "更换手机号码", "QQ更换绑定新的手机号码前，需要将当前的绑定关系解除，请确定是否更换。", "确定", "取消", new wti(this), new wtj(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      if (getIntent().getBooleanExtra("k_is_block", false)) {
        ReportController.b(this.app, "CliOper", "", "", "0X80053D6", "0X80053D6", 0, 0, "", "", "", "");
      }
      if (this.jdField_b_of_type_Int != 0) {
        break label196;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005B76", "0X8005B76", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.g) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005D0E", "0X8005D0E", 0, 0, "", "", "", "");
      }
      return;
      b();
      break;
      label196:
      if (this.jdField_b_of_type_Int == 1) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005B76", "0X8005B76", 2, 0, "", "", "", "");
      } else if (this.jdField_b_of_type_Int == 8) {
        ReportController.b(this.app, "dc00898", "", "", "0X800650C", "0X800650C", 1, 0, this.app.c(), "", "", "");
      } else if (this.jdField_b_of_type_Int == 10) {
        ReportController.b(this.app, "dc00898", "", "", "0X8006AA3", "0X8006AA3", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "finish2, reason = " + paramInt + ", isReqBlock = " + this.jdField_b_of_type_Boolean);
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(10);
    if ((paramInt == 0) && (!this.jdField_b_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      localPhoneContactManagerImp.a(bool);
      super.finish();
      if (this.jdField_c_of_type_Boolean) {
        overridePendingTransition(2131034131, 2131034382);
      }
      return;
    }
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      b("请输入手机号码");
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("+86")) && (this.jdField_b_of_type_JavaLangString.length() != 11))
    {
      b(2131428426);
      return;
    }
    if (!NetworkUtil.d(this))
    {
      b(2131434613);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + " " + paramString2;
    Rect localRect = new Rect();
    this.jdField_b_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramString1, 0, paramString1.length(), localRect);
    int i = getResources().getDimensionPixelSize(2131559665);
    int j = getResources().getDimensionPixelSize(2131559666);
    if (localRect.right > i - j) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    for (;;)
    {
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + "按钮");
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(5, 100L);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable.length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())) {}
    for (boolean bool = true; (this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17); bool = false) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("k_name");
      this.jdField_a_of_type_JavaLangString = ("+" + paramIntent.getStringExtra("k_code"));
      b(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    while ((paramInt1 != 2) || (paramInt2 == 0)) {
      return;
    }
    setResult(paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (this.jdField_b_of_type_Int != 7) {
        break label211;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 11) {
        ReportController.b(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
      }
      if (this.f)
      {
        paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
        paramIntent.putExtra("kSrouce", this.jdField_b_of_type_Int);
        paramIntent.putExtra("kBindNew", true);
        startActivity(paramIntent);
      }
      a(3);
      return;
      label211:
      if (this.jdField_b_of_type_Int == 12) {
        ReportController.b(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnBackPressed()
  {
    boolean bool = false;
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11))
    {
      if (this.jdField_b_of_type_Int == 10) {
        bool = true;
      }
      a(bool);
    }
    do
    {
      return;
      if ((this.leftViewNotBack == null) || (this.leftView == null))
      {
        super.doOnBackPressed();
        return;
      }
    } while ((this.leftViewNotBack.getVisibility() != 0) && (this.leftView.getVisibility() != 0));
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    if (this.jdField_b_of_type_Int == 10) {
      ReportController.b(this.app, "dc00898", "", "", "0X8006E3B", "0X8006E3B", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doOnCreate ,mSource = " + this.jdField_b_of_type_Int);
    }
    label312:
    int i;
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17))
    {
      getWindow().setSoftInputMode(18);
      setContentView(2130969156);
      if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+")))
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
        this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("kNeedUnbind", false);
        this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_is_modal_pop", false);
        this.d = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
        this.e = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
        this.f = getIntent().getBooleanExtra("kUnityWebBind", false);
        this.g = getIntent().getBooleanExtra("key_is_from_qav_multi_call", false);
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365428));
        if (!getIntent().getBooleanExtra("key_change_number", false)) {
          break label806;
        }
        setTitle("更改手机号码", "请输入手机号码");
        if ((this.jdField_b_of_type_Int != 10) && (this.jdField_b_of_type_Int != 11)) {
          break label825;
        }
        setTitle("绑定手机号码", "绑定手机号码");
        if (this.jdField_b_of_type_Int != 11) {
          break label818;
        }
        i = 2131434937;
        label353:
        setLeftButton(i, this);
        setRightButton(2131434754, this);
        label367:
        if (!getIntent().getBooleanExtra("key_is_qqwifi", false)) {
          break label958;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText("首次使用QQWiFi功能时，需要验证你的手机号码并推荐绑定通讯录。");
        label391:
        if (this.d)
        {
          setTitle("绑定手机号码", "请输入手机号码");
          this.jdField_c_of_type_AndroidWidgetTextView.setText("绑定手机号码需要通过短信验证。");
          this.jdField_c_of_type_AndroidWidgetTextView.setGravity(1);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.rgb(74, 74, 74));
          this.leftView.setText(2131432414);
        }
        paramBundle = TelephonyUtils.a(this);
        if (paramBundle == null) {
          break label1142;
        }
        this.jdField_c_of_type_JavaLangString = "";
        this.jdField_a_of_type_JavaLangString = ('+' + paramBundle[0]);
        this.jdField_b_of_type_JavaLangString = paramBundle[1];
        label498:
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365430));
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        b(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364065));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365432));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        if ((this.jdField_b_of_type_Int != 10) && (this.jdField_b_of_type_Int != 11) && (this.jdField_b_of_type_Int != 15) && (this.jdField_b_of_type_Int != 17)) {
          break label1189;
        }
        this.jdField_b_of_type_JavaLangString = LoginWelcomeManager.a(this.app).jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365431));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_b_of_type_JavaLangString.length());
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131365433);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365434));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.g) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005D0D", "0X8005D0D", 0, 0, "", "", "", "");
      }
      return true;
      ((BounceScrollView)findViewById(2131363451)).setOnSizeChangeListener(this);
      break;
      setContentView(2130969155);
      break;
      label806:
      setTitle("验证手机号码", "请输入手机号码");
      break label312;
      label818:
      i = 2131436302;
      break label353;
      label825:
      if ((this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17))
      {
        setTitle("绑定手机号码", "绑定手机号码");
        if (this.leftView != null) {
          this.leftView.setText("新朋友");
        }
        setRightButton(2131434754, this);
        break label367;
      }
      if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 12) || (this.jdField_b_of_type_Int == 14) || (this.jdField_b_of_type_Int == 9))
      {
        this.leftView.setText(2131433698);
        break label367;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        setLeftButton(2131434937, null);
        break label367;
      }
      setLeftButton(2131433698, null);
      break label367;
      label958:
      if (getIntent().getBooleanExtra("k_is_block", false))
      {
        this.jdField_b_of_type_Boolean = true;
        this.leftViewNotBack.setVisibility(8);
        this.leftViewNotBack.setOnClickListener(new wtg(this));
        this.jdField_a_of_type_Int = getIntent().getIntExtra("k_block_time", -100000);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(getIntent().getStringExtra("k_block_msg"));
        setRightButton(2131435644, this);
        break label391;
      }
      if (this.g)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429507);
        this.rightViewText.setVisibility(8);
        break label391;
      }
      if (getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("首次使用QQ Wi-Fi需要通过短信验证。");
        this.jdField_c_of_type_AndroidWidgetTextView.setGravity(1);
        break label391;
      }
      paramBundle = ((PhoneContactManagerImp)this.app.getManager(10)).c();
      if (StringUtil.a(paramBundle)) {
        break label391;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramBundle);
      break label391;
      label1142:
      paramBundle = PhoneCodeUtils.b(this);
      if ("86".equals(paramBundle)) {
        break label498;
      }
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_JavaLangString = ('+' + paramBundle);
      break label498;
      label1189:
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new wth(this), 300L);
    }
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    }
    while (this.jdField_a_of_type_Int == -100000) {
      return;
    }
    this.leftViewNotBack.setVisibility(0);
  }
  
  public void finish()
  {
    a(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 0: 
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new wtk(this);
      this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      paramMessage = (PhoneContactManager)this.app.getManager(10);
      a(2131434453, 1000L, true);
      paramMessage.b(this.d, this.e);
    case 2: 
    case 3: 
    case 4: 
      do
      {
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new wtl(this);
          this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        }
        if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11) || (this.jdField_b_of_type_Int == 15) || (this.jdField_b_of_type_Int == 17)) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0, this.d, this.e);
          if (3 == paramMessage.what) {
            break;
          }
          a(2131434453, 1000L, true);
          return true;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        int i = this.jdField_a_of_type_Int - 1;
        this.jdField_a_of_type_Int = i;
        if (i >= 0) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() != 0);
      this.leftViewNotBack.setVisibility(0);
      return true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
    ((BounceScrollView)findViewById(2131363451)).fullScroll(130);
    return true;
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_user_cancel", 1);
    setResult(0, localIntent);
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
    finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() > 0) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
    {
      paramBoolean = true;
      if ((this.jdField_b_of_type_Int != 10) && (this.jdField_b_of_type_Int != 11) && (this.jdField_b_of_type_Int != 15) && (this.jdField_b_of_type_Int != 17)) {
        break label93;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label104;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("已同意");
      return;
      paramBoolean = false;
      break;
      label93:
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    }
    label104:
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription("未同意");
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramView.getId())
    {
    default: 
      this.app.logout(true);
      startActivity(new Intent(this, LoginActivity.class));
      a(1);
      ReportController.b(this.app, "CliOper", "", "", "0X80053D3", "0X80053D3", 0, 0, "", "", "", "");
    case 2131365430: 
    case 2131363245: 
    case 2131363473: 
    case 2131363428: 
      do
      {
        do
        {
          do
          {
            return;
            startActivityForResult(new Intent(this, CountryActivity.class), 1);
            return;
            if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11))
            {
              if (this.jdField_b_of_type_Int == 10) {
                bool1 = true;
              }
              a(bool1);
              return;
            }
          } while ((this.jdField_b_of_type_Int != 15) && (this.jdField_b_of_type_Int != 17));
          finish();
          return;
          if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 11))
          {
            if (this.jdField_b_of_type_Int == 10) {}
            for (bool1 = bool2;; bool1 = false)
            {
              a(bool1);
              return;
            }
          }
        } while ((this.jdField_b_of_type_Int != 15) && (this.jdField_b_of_type_Int != 17));
        finish();
        return;
        if (this.g)
        {
          finish();
          return;
        }
      } while ((this.jdField_b_of_type_Int != 10) && (this.jdField_b_of_type_Int != 11) && (this.jdField_b_of_type_Int != 15) && (this.jdField_b_of_type_Int != 17));
      a();
      return;
    case 2131365432: 
      a();
      return;
    case 2131365434: 
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", "http://vac.qq.com/hall/phone/phone_tos.html?_wv=3");
      startActivity(paramView);
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (bool1 = bool3;; bool1 = false)
    {
      paramView.setChecked(bool1);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      paramCharSequence = this.leftViewNotBack;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() <= 0) {
        break label41;
      }
    }
    label41:
    for (paramInt1 = 8;; paramInt1 = 0)
    {
      paramCharSequence.setVisibility(paramInt1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity
 * JD-Core Version:    0.7.0.1
 */