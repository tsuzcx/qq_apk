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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
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
    this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131701204);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("finish2 [%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    super.finish();
    if (a()) {
      overridePendingTransition(2130771992, 2130772316);
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + " " + paramString2;
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().getTextBounds(paramString1, 0, paramString1.length(), localRect);
    int i = getResources().getDimensionPixelSize(2131297538);
    int j = getResources().getDimensionPixelSize(2131297537);
    if (localRect.right > i - j * 2) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    for (;;)
    {
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + HardCodeUtil.a(2131701206));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
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
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, HardCodeUtil.a(2131701213), getString(2131690800), getString(2131694615), new BindNumberActivity.2(this), new BindNumberActivity.3(this));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    i();
  }
  
  private void i()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      a(HardCodeUtil.a(2131701214));
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("+86")) && (this.jdField_c_of_type_JavaLangString.length() != 11))
    {
      a(2131694833);
      return;
    }
    if (!NetworkUtil.d(this))
    {
      a(2131694510);
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
    boolean bool2 = false;
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetEditText == null)) {
      return;
    }
    if (this.f)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().length() > 0)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        bool1 = true;
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
  }
  
  protected void a(int paramInt, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      if (paramList != null) {
        break label81;
      }
    }
    View localView;
    label81:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i("BindNumberActivity", 2, String.format("updateFrdInPhoneContact [%s, %s]", new Object[] { Integer.valueOf(paramInt), localObject }));
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367462);
      if ((paramInt >= 10) && (paramList != null) && (paramList.size() >= 3)) {
        break;
      }
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    ((TextView)localView.findViewById(2131372205)).setText(String.format(getString(2131694807), new Object[] { Integer.valueOf(paramInt) }));
    int[] arrayOfInt = new int[3];
    int[] tmp142_140 = arrayOfInt;
    tmp142_140[0] = 2131368282;
    int[] tmp148_142 = tmp142_140;
    tmp148_142[1] = 2131368283;
    int[] tmp154_148 = tmp148_142;
    tmp154_148[2] = 2131368284;
    tmp154_148;
    paramInt = 0;
    label163:
    ImageView localImageView;
    if (paramInt < arrayOfInt.length)
    {
      localImageView = (ImageView)localView.findViewById(arrayOfInt[paramInt]);
      if (localImageView != null) {
        break label196;
      }
    }
    for (;;)
    {
      paramInt += 1;
      break label163;
      break;
      label196:
      if (paramInt < paramList.size()) {}
      for (localObject = (String)paramList.get(paramInt);; localObject = null)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label239;
        }
        localImageView.setVisibility(8);
        break;
      }
      label239:
      localImageView.setVisibility(0);
      localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, (String)localObject));
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setSupportMaskView(true);
      }
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramIntent == null)
    {
      paramIntent = null;
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "onBindSuc src: " + this.jdField_a_of_type_Int + ", per: " + paramIntent);
      }
      if (this.jdField_a_of_type_Int != 10) {
        break label168;
      }
      paramIntent = new Intent(this, SplashActivity.class);
      paramIntent.putExtra("main_tab_id", 1);
      paramIntent.setFlags(603979776);
      startActivity(paramIntent);
    }
    for (;;)
    {
      setResult(-1, localIntent);
      b(paramInt);
      if (this.jdField_b_of_type_Boolean) {
        ReportController.b(this.app, "dc00898", "", "", "0X8009EC4", "0X8009EC4", 0, 0, "", "", "", "");
      }
      return;
      paramIntent = paramIntent.getStringExtra("check_permission_result");
      break;
      label168:
      if (this.jdField_a_of_type_Int != 21) {
        if (this.jdField_a_of_type_Int == 22)
        {
          QQToast.a(this, 2131694832, 1).a();
        }
        else if (this.jdField_c_of_type_Boolean)
        {
          paramIntent = new Intent(this, PhoneUnityBindInfoActivity.class);
          paramIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
          paramIntent.putExtra("kBindNew", true);
          startActivity(paramIntent);
        }
        else if (("permission_denied".equals(paramIntent)) || ("permission_denied_by_user".equals(paramIntent)))
        {
          localIntent.putExtra("check_permission_result", paramIntent);
          paramIntent = new Intent(this, GuideBindPhoneActivity.class);
          paramIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
          paramIntent.putExtra("fromKeyForContactBind", 1);
          startActivity(paramIntent);
        }
        else if ("permission_granted".equals(paramIntent))
        {
          ContactBindedActivity.a(this.app, this.jdField_a_of_type_Int, 1, localIntent);
          localIntent.putExtra("check_permission_result", paramIntent);
        }
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    a("dc00898", "0X8009F14", 0);
    Object localObject = paramBundle.getString("k_uin");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (paramBundle = this.jdField_c_of_type_JavaLangString;; paramBundle = this.jdField_a_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString)
    {
      localObject = getResources().getString(2131694839, new Object[] { paramBundle, localObject, this.app.getCurrentAccountUin() });
      int i = ((String)localObject).indexOf(paramBundle);
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), i, paramBundle.length() + i, 17);
      paramBundle = DialogUtil.a(this, 230, null, (CharSequence)localObject, getString(2131690800), getString(2131694615), new BindNumberActivity.6(this), new BindNumberActivity.7(this));
      if ((paramBundle != null) && (!paramBundle.isShowing()) && (!isFinishing())) {
        paramBundle.show();
      }
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ReportController.b(this.app, paramString1, "", "", paramString2, paramString2, paramInt, 0, "", "", "", "");
  }
  
  protected boolean a()
  {
    boolean bool = false;
    if ((this.e) || (this.jdField_a_of_type_Int == 9) || (this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 10)) {
      bool = true;
    }
    return bool;
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
    for (;;)
    {
      setResult(-1);
      b(3);
      return;
      localObject = (PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManagerImp)localObject).a();
      if ((!((PhoneContactManagerImp)localObject).f()) && (localRespondQueryQQBindingStat != null) && (!localRespondQueryQQBindingStat.isStopFindMatch))
      {
        localObject = new Intent(this, PhoneMatchActivity.class);
        ((Intent)localObject).putExtra("key_from_contact_first", true);
        startActivity((Intent)localObject);
      }
    }
  }
  
  protected void d()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8005B78", "0X8005B78", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, "该手机号码已绑定一个无密码的QQ号，需给原QQ号设置密码后才能解绑并绑定新QQ号。", null, HardCodeUtil.a(2131701205), new BindNumberActivity.8(this), null);
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_name");
        this.jdField_a_of_type_JavaLangString = ("+" + paramIntent.getStringExtra("k_code"));
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 2) && (paramInt2 != 0))
      {
        setResult(paramInt2, paramIntent);
        if (paramInt2 != -1) {
          break;
        }
        a(paramIntent, 3);
        if (this.jdField_a_of_type_Int == 7) {
          ReportController.b(this.app, "CliOper", "", "", "0X80053E2", "0X80053E2", 0, 0, "", "", "", "");
        }
        while (this.jdField_a_of_type_Int == 11)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8006EFA", "0X8006EFA", 0, 0, "", "", "", "");
          return;
          if (this.jdField_a_of_type_Int == 12) {
            ReportController.b(this.app, "CliOper", "", "", "0X80053DC", "0X80053DC", 0, 0, "", "", "", "");
          }
        }
      }
    }
    b(3);
  }
  
  public void doOnBackPressed()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11))
    {
      if (this.jdField_a_of_type_Int == 10) {
        bool = true;
      }
      c(bool);
      return;
    }
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80053D4", "0X80053D4", 0, 0, "", "", "", "");
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.d = getIntent().getBooleanExtra("kNeedUnbind", false);
    this.e = getIntent().getBooleanExtra("key_is_modal_pop", false);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kUnityWebBind", false);
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, String.format("onCreate [%s, %s, %s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    getWindow().setSoftInputMode(18);
    setContentView(2131559661);
    Resources localResources;
    if ((Build.MANUFACTURER.equalsIgnoreCase("Letv")) && (Build.MODEL.equalsIgnoreCase("X900+")))
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372202));
      this.jdField_a_of_type_AndroidViewViewGroup.getRootView().setBackgroundDrawable(getResources().getDrawable(2130838979));
      localResources = getResources();
      if (!this.jdField_b_of_type_Boolean) {
        break label705;
      }
      paramBundle = localResources.getString(2131694810);
      label242:
      setTitle("", "");
      if (!a()) {
        break label745;
      }
      setLeftButton(2131690946, null);
      if (this.leftViewNotBack != null) {
        this.leftViewNotBack.setVisibility(8);
      }
      setRightButton(2131690946, this);
      label291:
      ((TextView)findViewById(2131372206)).setText(paramBundle);
      paramBundle = localResources.getString(2131694805);
      if (!this.jdField_b_of_type_Boolean) {
        break label834;
      }
      paramBundle = localResources.getString(2131694806);
    }
    label705:
    label834:
    for (;;)
    {
      ((TextView)findViewById(2131372204)).setText(paramBundle);
      f();
      label378:
      int i;
      if (0 != 0)
      {
        this.jdField_b_of_type_JavaLangString = "";
        new StringBuilder().append('+');
        throw new NullPointerException();
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365409));
        this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131379720));
        this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131701215));
        this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372461));
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
        this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_c_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_JavaLangString.length());
        }
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365117));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        a();
        findViewById(2131379721).setOnClickListener(this);
        findViewById(2131379723).setOnClickListener(this);
        switch (this.jdField_a_of_type_Int)
        {
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 13: 
        case 16: 
        default: 
          i = 0;
        }
      }
      for (;;)
      {
        a("dc00898", "0X8009F11", i);
        return true;
        paramBundle = (BounceScrollView)findViewById(2131363858);
        if (paramBundle == null) {
          break;
        }
        paramBundle.setOnSizeChangeListener(this);
        break;
        if ((this.jdField_a_of_type_Int == 12) || (this.jdField_a_of_type_Int == 14))
        {
          paramBundle = localResources.getString(2131694808);
          break label242;
        }
        paramBundle = localResources.getString(2131694809);
        break label242;
        label745:
        setLeftViewName(2131690601);
        break label291;
        paramBundle = PhoneCodeUtils.b(this);
        if ("86".equals(paramBundle)) {
          break label378;
        }
        this.jdField_b_of_type_JavaLangString = "";
        this.jdField_a_of_type_JavaLangString = ('+' + paramBundle);
        break label378;
        i = 2;
        continue;
        i = 3;
        continue;
        i = 1;
        continue;
        i = 4;
        continue;
        i = 5;
        continue;
        i = 6;
      }
    }
  }
  
  public void doOnDestroy()
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
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
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
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
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, null, HardCodeUtil.a(2131701211), null, HardCodeUtil.a(2131701209), new BindNumberActivity.9(this), null);
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 15) || (this.jdField_a_of_type_Int == 17) || (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 12) || (this.jdField_a_of_type_Int == 14)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        a(0, null);
        return;
      }
      Object localObject = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (localObject != null)
      {
        localObject = ((PhoneContactManager)localObject).a();
        i = ((Integer)localObject[0]).intValue();
        localObject = (List)localObject[1];
      }
      for (;;)
      {
        a(i, (List)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new BindNumberActivity.10(this);
          this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        }
        localObject = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (localObject == null) {
          break;
        }
        ((FriendListHandler)localObject).getFriendsHasBindPhone(3);
        return;
        localObject = null;
        i = 0;
      }
    }
  }
  
  public void finish()
  {
    b(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 0: 
      if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new BindNumberActivity.4(this);
        this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      paramMessage = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      a(2131719050, 1000L, true);
      paramMessage.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    }
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new BindNumberActivity.5(this);
          this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        }
        this.f = true;
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      } while (3 == paramMessage.what);
      a(2131719050, 1000L, true);
      return true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      paramMessage = (BounceScrollView)findViewById(2131363858);
    } while (paramMessage == null);
    paramMessage.fullScroll(130);
    return true;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11))
    {
      if (this.jdField_a_of_type_Int == 10) {}
      for (boolean bool = true;; bool = false)
      {
        c(bool);
        return true;
      }
    }
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
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131701216));
    }
    for (;;)
    {
      a();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setContentDescription(HardCodeUtil.a(2131701212));
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    default: 
      this.app.logout(true);
      RouteUtils.a(this, new Intent(), "/base/login");
      b(1);
      a("CliOper", "0X80053D3", 0);
    case 2131365409: 
    case 2131369487: 
    case 2131369489: 
    case 2131369518: 
    case 2131365117: 
    case 2131379723: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        startActivityForResult(new Intent(this, CountryActivity.class), 1);
        continue;
        if ((this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 11))
        {
          if (this.jdField_a_of_type_Int == 10) {}
          for (;;)
          {
            c(bool1);
            break;
            bool1 = false;
          }
        }
        setResult(0);
        finish();
        continue;
        h();
        continue;
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", "https://qq-web.cdn-go.cn/agreement/latest/mqq/bindphone.html");
        startActivity((Intent)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((CheckBox)localObject).setChecked(bool1);
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity
 * JD-Core Version:    0.7.0.1
 */