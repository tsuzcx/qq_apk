package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Configuration;
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
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.OnSizeChangeListener;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class BindNumberActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener, OnSizeChangeListener
{
  private int jdField_a_of_type_Int = -1;
  private final Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  protected ViewGroup a;
  protected Button a;
  protected CheckBox a;
  protected EditText a;
  protected TextView a;
  protected FriendListObserver a;
  protected ContactBindObserver a;
  public QQCustomDialog a;
  protected String a;
  protected boolean a;
  protected ContactBindObserver b;
  public QQCustomDialog b;
  protected String b;
  protected boolean b;
  public QQCustomDialog c;
  protected String c;
  protected boolean c;
  protected boolean d;
  protected boolean e = false;
  protected boolean f = false;
  
  public BindNumberActivity()
  {
    this.jdField_a_of_type_JavaLangString = "+86";
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131701345);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("finish2 [%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    super.finish();
    if (a()) {
      overridePendingTransition(2130772004, 2130772344);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString2);
    paramString1 = ((StringBuilder)localObject).toString();
    localObject = new Rect();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramString1, 0, paramString1.length(), (Rect)localObject);
    int i = getResources().getDimensionPixelSize(2131297529);
    int j = getResources().getDimensionPixelSize(2131297528);
    if (((Rect)localObject).right > i - j * 2) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (AppSetting.d)
    {
      paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
      paramString2 = new StringBuilder();
      paramString2.append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramString2.append(HardCodeUtil.a(2131701347));
      paramString1.setContentDescription(paramString2.toString());
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new BindNumberActivity.1(this), 300L);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Boolean) {
      a("dc00898", "0X8009EC3", 0);
    }
    a("dc00898", "0X8009F12", 0);
    if (this.d)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, HardCodeUtil.a(2131701354), getString(2131690728), getString(2131694583), new BindNumberActivity.2(this), new BindNumberActivity.3(this));
      }
      QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
    }
    else
    {
      i();
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      showToast(HardCodeUtil.a(2131701355));
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("+86")) && (this.jdField_c_of_type_JavaLangString.length() != 11))
    {
      showToast(2131694820);
      return;
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131694475);
      return;
    }
    if (this.d)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  protected void a()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null)
    {
      EditText localEditText = this.jdField_a_of_type_AndroidWidgetEditText;
      if (localEditText == null) {
        return;
      }
      boolean bool1 = this.f;
      boolean bool2 = false;
      if (bool1)
      {
        localButton.setEnabled(false);
        return;
      }
      bool1 = bool2;
      if (localEditText.getText().toString().trim().length() > 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          bool1 = true;
        }
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
    }
  }
  
  protected void a(int paramInt, List<String> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramList == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(paramList.size());
      }
      QLog.i("BindNumberActivity", 2, String.format("updateFrdInPhoneContact [%s, %s]", new Object[] { Integer.valueOf(paramInt), localObject }));
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367220);
    int[] arrayOfInt;
    if ((paramInt >= 10) && (paramList != null) && (paramList.size() >= 3))
    {
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131371789)).setText(String.format(getString(2131694793), new Object[] { Integer.valueOf(paramInt) }));
      arrayOfInt = new int[3];
      int[] tmp137_135 = arrayOfInt;
      tmp137_135[0] = 2131368034;
      int[] tmp143_137 = tmp137_135;
      tmp143_137[1] = 2131368035;
      int[] tmp149_143 = tmp143_137;
      tmp149_143[2] = 2131368036;
      tmp149_143;
      paramInt = 0;
    }
    while (paramInt < arrayOfInt.length)
    {
      ImageView localImageView = (ImageView)localView.findViewById(arrayOfInt[paramInt]);
      if (localImageView != null)
      {
        if (paramInt < paramList.size()) {
          localObject = (String)paramList.get(paramInt);
        } else {
          localObject = null;
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localImageView.setVisibility(8);
        }
        else
        {
          localImageView.setVisibility(0);
          localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject));
          if ((localImageView instanceof ThemeImageView)) {
            ((ThemeImageView)localImageView).setSupportMaskView(true);
          }
        }
      }
      paramInt += 1;
      continue;
      localView.setVisibility(8);
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramIntent == null) {
      paramIntent = null;
    } else {
      paramIntent = paramIntent.getStringExtra("check_permission_result");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBindSuc src: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", per: ");
      localStringBuilder.append(paramIntent);
      QLog.i("BindMsgConstant", 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 10)
    {
      paramIntent = new Intent(this, SplashActivity.class);
      paramIntent.putExtra("main_tab_id", 1);
      paramIntent.setFlags(603979776);
      startActivity(paramIntent);
    }
    else if (i != 21)
    {
      if (i == 22)
      {
        QQToast.a(this, 2131694819, 1).a();
      }
      else if (this.jdField_c_of_type_Boolean)
      {
        paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
        paramIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
        paramIntent.putExtra("kBindNew", true);
        startActivity(paramIntent);
      }
      else if ((!"permission_denied".equals(paramIntent)) && (!"permission_denied_by_user".equals(paramIntent)))
      {
        if ("permission_granted".equals(paramIntent))
        {
          ContactBindedActivity.a(this.app, this.jdField_a_of_type_Int, 1, localIntent);
          localIntent.putExtra("check_permission_result", paramIntent);
        }
      }
      else
      {
        localIntent.putExtra("check_permission_result", paramIntent);
        paramIntent = new Intent(this, GuideBindPhoneActivity.class);
        paramIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
        paramIntent.putExtra("fromKeyForContactBind", 1);
        startActivity(paramIntent);
      }
    }
    setResult(-1, localIntent);
    a(paramInt);
    if (this.jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "dc00898", "", "", "0X8009EC4", "0X8009EC4", 0, 0, "", "", "", "");
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    a("dc00898", "0X8009F14", 0);
    Object localObject = paramBundle.getString("k_uin");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramBundle = this.jdField_c_of_type_JavaLangString;
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      paramBundle.append(" ");
      paramBundle.append(this.jdField_c_of_type_JavaLangString);
      paramBundle = paramBundle.toString();
    }
    localObject = getResources().getString(2131694826, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
    int i = ((String)localObject).indexOf(paramBundle);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramBundle.length() + i, 17);
    paramBundle = DialogUtil.a(this, 230, null, (CharSequence)localObject, getString(2131690728), getString(2131694583), new BindNumberActivity.6(this), new BindNumberActivity.7(this));
    if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
      paramBundle.show();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  protected boolean a()
  {
    if (!this.e)
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != 9) && (i != 11) && (i != 10)) {
        return false;
      }
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    a();
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this, BindVerifyActivity.class);
    localIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
    localIntent.putExtra("kBindType", 0);
    localIntent.putExtra("keyReqBindMode", 0);
    localIntent.putExtra("k_number", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("k_country_code", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
    localIntent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
    localIntent.putExtra("cmd_param_is_from_uni", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
    localIntent.putExtra("cmd_param_is_from_change_bind", this.jdField_b_of_type_Boolean);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    if (!isFinishing()) {
      startActivityForResult(localIntent, 2);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 10)
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 1);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    else
    {
      localObject = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((IPhoneContactService)localObject).getSelfBindInfo();
      if ((!((IPhoneContactService)localObject).isAutoUploadContacts()) && (localRespondQueryQQBindingStat != null) && (!localRespondQueryQQBindingStat.isStopFindMatch))
      {
        localObject = new Intent(this, PhoneMatchActivity.class);
        ((Intent)localObject).putExtra("key_from_contact_first", true);
        startActivity((Intent)localObject);
      }
    }
    setResult(-1);
    a(3);
  }
  
  protected void d()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, HardCodeUtil.a(2131701346), new BindNumberActivity.8(this), null);
    }
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_name");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("+");
        localStringBuilder.append(paramIntent.getStringExtra("k_code"));
        this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
    }
    else if ((paramInt1 == 2) && (paramInt2 != 0))
    {
      setResult(paramInt2, paramIntent);
      if (paramInt2 == -1)
      {
        a(paramIntent, 3);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramInt1 == 7) {
          ReportController.b(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
        } else if (paramInt1 == 12) {
          ReportController.b(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_Int == 11) {
          ReportController.b(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
        }
      }
      else
      {
        a(3);
      }
    }
  }
  
  public void doOnBackPressed()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = false;
    if ((i != 10) && (i != 11))
    {
      if (getIntent().getBooleanExtra("k_is_block", false)) {
        ReportController.b(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
      }
      super.doOnBackPressed();
      return;
    }
    if (this.jdField_a_of_type_Int == 10) {
      bool = true;
    }
    showConfirmSkipDialog(bool);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    paramBundle = getIntent();
    int i = 0;
    this.d = paramBundle.getBooleanExtra("kNeedUnbind", false);
    this.e = getIntent().getBooleanExtra("key_is_modal_pop", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kUnityWebBind", false);
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    getWindow().setSoftInputMode(18);
    setContentView(2131559539);
    if ((!Build.MANUFACTURER.equalsIgnoreCase("Letv")) || (!Build.MODEL.equalsIgnoreCase("X900+")))
    {
      paramBundle = (BounceScrollView)findViewById(2131363786);
      if (paramBundle != null) {
        paramBundle.setOnSizeChangeListener(this);
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131371786));
    this.jdField_a_of_type_AndroidViewViewGroup.getRootView().setBackgroundDrawable(getResources().getDrawable(2130838739));
    Object localObject = getResources();
    if (this.jdField_b_of_type_Boolean)
    {
      paramBundle = ((Resources)localObject).getString(2131694796);
    }
    else
    {
      j = this.jdField_a_of_type_Int;
      if ((j != 12) && (j != 14)) {
        paramBundle = ((Resources)localObject).getString(2131694795);
      } else {
        paramBundle = ((Resources)localObject).getString(2131694794);
      }
    }
    setTitle("", "");
    if (a())
    {
      setLeftButton(2131690874, null);
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      setRightButton(2131690874, this);
    }
    else
    {
      setLeftViewName(2131690529);
    }
    ((TextView)findViewById(2131371790)).setText(paramBundle);
    paramBundle = ((Resources)localObject).getString(2131694791);
    if (this.jdField_b_of_type_Boolean) {
      paramBundle = ((Resources)localObject).getString(2131694792);
    }
    ((TextView)findViewById(2131371788)).setText(paramBundle);
    f();
    paramBundle = PhoneCodeUtils.b(this);
    if (!"86".equals(paramBundle))
    {
      this.jdField_b_of_type_JavaLangString = "";
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('+');
      ((StringBuilder)localObject).append(paramBundle);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365274));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131379059));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131701356));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372044));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_JavaLangString.length());
    }
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364997));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a();
    findViewById(2131379060).setOnClickListener(this);
    findViewById(2131379062).setOnClickListener(this);
    int j = this.jdField_a_of_type_Int;
    if (j != -1)
    {
      if (j != 1)
      {
        if (j != 9)
        {
          if (j != 17)
          {
            if (j == 11) {
              break label752;
            }
            if (j != 12)
            {
              if (j != 14)
              {
                if (j != 15) {
                  break label765;
                }
              }
              else
              {
                i = 2;
                break label765;
              }
            }
            else
            {
              i = 3;
              break label765;
            }
          }
          i = 4;
          break label765;
        }
        label752:
        i = 5;
      }
      else
      {
        i = 1;
      }
    }
    else {
      i = 6;
    }
    label765:
    a("dc00898", "0X8009F11", i);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    localQQCustomDialog = this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      g();
    }
  }
  
  protected void e()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8005B77", "0X8005B77", 0, 0, "", "", "", "");
    if (this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, HardCodeUtil.a(2131701352), null, HardCodeUtil.a(2131701350), new BindNumberActivity.9(this), null);
    }
    QQCustomDialog localQQCustomDialog = this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected void f()
  {
    int i = this.jdField_a_of_type_Int;
    int j = 0;
    if ((i != 10) && (i != 11) && (i != 15) && (i != 17) && (i != 1) && (i != 12) && (i != 14)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject = null;
    if (i == 0)
    {
      a(0, null);
      return;
    }
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    i = j;
    if (localIPhoneContactService != null)
    {
      localObject = localIPhoneContactService.getFriendHasBindPhone();
      i = ((Integer)localObject[0]).intValue();
      localObject = (List)localObject[1];
    }
    a(i, (List)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new BindNumberActivity.10(this);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    localObject = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localObject != null) {
      ((FriendListHandler)localObject).getFriendsHasBindPhone(3);
    }
  }
  
  public void finish()
  {
    a(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if ((i != 2) && (i != 3))
      {
        if (i == 4)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
          paramMessage = (BounceScrollView)findViewById(2131363786);
          if (paramMessage != null)
          {
            paramMessage.fullScroll(130);
            return true;
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown message: ");
          localStringBuilder.append(paramMessage.what);
          throw new RuntimeException(localStringBuilder.toString());
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new BindNumberActivity.5(this);
          this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
        }
        this.f = true;
        a();
        this.mPhoneContactService.sendBindMobile(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
        if (3 != paramMessage.what)
        {
          showProgressDialog(2131718766, 1000L, true);
          return true;
        }
      }
    }
    else
    {
      if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new BindNumberActivity.4(this);
        this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      }
      paramMessage = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
      showProgressDialog(2131718766, 1000L, true);
      paramMessage.unbindMobile(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    }
    return true;
  }
  
  protected boolean onBackEvent()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = false;
    if ((i != 10) && (i != 11))
    {
      a("dc00898", "0X8009F13", 0);
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_user_cancel", 1);
      setResult(0, (Intent)localObject);
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        localObject = (InputMethodManager)getSystemService("input_method");
        if (localObject != null) {
          ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
        }
      }
      finish();
      return true;
    }
    if (this.jdField_a_of_type_Int == 10) {
      bool = true;
    }
    showConfirmSkipDialog(bool);
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131701357));
    } else {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131701353));
    }
    a();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    boolean bool = false;
    Object localObject;
    switch (i)
    {
    default: 
      this.app.logout(true);
      RouteUtils.a(this, new Intent(), "/base/login");
      a(1);
      a("CliOper", "0X80053D3", 0);
      break;
    case 2131379062: 
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://qq-web.cdn-go.cn/agreement/latest/mqq/bindphone.html");
      startActivity((Intent)localObject);
      break;
    case 2131379060: 
      localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
      ((CheckBox)localObject).setChecked(((CheckBox)localObject).isChecked() ^ true);
      break;
    case 2131369202: 
    case 2131369204: 
    case 2131369233: 
      i = this.jdField_a_of_type_Int;
      if ((i != 10) && (i != 11))
      {
        setResult(0);
        finish();
      }
      else
      {
        if (this.jdField_a_of_type_Int == 10) {
          bool = true;
        }
        showConfirmSkipDialog(bool);
      }
      break;
    case 2131365274: 
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      break;
    case 2131364997: 
      h();
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
    if ((paramView == this.jdField_a_of_type_AndroidWidgetEditText) && (66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      i();
      return true;
    }
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    if ((paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4) && (paramInt1 == paramInt3)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 100L);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity
 * JD-Core Version:    0.7.0.1
 */