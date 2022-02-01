package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.security.RegisterOverseaHelper;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.register.QueryAccount;
import com.tencent.mobileqq.register.RegisterManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@RoutePage(desc="注册输入手机号码", path="/base/register/registerPhoneNumber")
public class RegisterPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final int FROM_TYPE_ADD_ACCOUNT = 2;
  private static final int FROM_TYPE_DEFAULT = 0;
  private static final int FROM_TYPE_MAIN = 1;
  private static final String REPORT_ACTION_NEXT = "0X800B531";
  private static final String REPORT_ACTION_SHOW = "0X800B530";
  public static final int REQUEST_LOCATION = 1;
  private static final String TAG = "RegisterPhoneNumActivity";
  private Button btnNextStep;
  private boolean canGotoBrowser = true;
  private MqqHandler closeHandler = new RegisterPhoneNumActivity.2(this);
  private ConfigClearableEditText editText;
  private CheckBox mCheckClause;
  private int mFromType = 0;
  private boolean mIsBeforeFinish;
  private boolean mIsValidPhoneNum = false;
  private LinearLayout mLayoutCheckClause;
  protected LoginUserPrivateHelper mLoginUserPrivateHelper;
  private QueryAccount mQueryAccount = null;
  private boolean mUserConfirmPrivacyPolicy;
  private Vibrator mVibrator;
  private String strCountryName = HardCodeUtil.a(2131716551);
  private TextView txtCountryCode;
  private TextView txtPrivacy;
  private TextView txtUsage;
  
  private void clearTextSelMenu(EditText paramEditText)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramEditText.setCustomSelectionActionModeCallback(new RegisterPhoneNumActivity.4(this));
      return;
    }
    paramEditText.setOnCreateContextMenuListener(new RegisterPhoneNumActivity.5(this));
  }
  
  private void doVibrate()
  {
    try
    {
      if (this.mVibrator == null) {
        this.mVibrator = ((Vibrator)getSystemService("vibrator"));
      }
      if (this.mVibrator != null)
      {
        this.mVibrator.vibrate(50L);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("RegisterPhoneNumActivity", 1, "exception when doVibrate.", localException);
    }
  }
  
  public static void expandViewTouchDelegate(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.post(new RegisterPhoneNumActivity.8(paramView, paramInt));
  }
  
  private void fillPhoneNum()
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      QLog.d("RegisterPhoneNumActivity", 1, "fillPhoneNum null == intent");
      return;
    }
    int i = localIntent.getIntExtra("key_register_from", 0);
    QLog.d("RegisterPhoneNumActivity", 1, new Object[] { "fillPhoneNum from=", Integer.valueOf(i) });
    if (i == 9) {
      this.editText.setText(localIntent.getStringExtra("key_phone_num"));
    }
  }
  
  @TargetApi(11)
  private void initViews()
  {
    this.mLayoutCheckClause = ((LinearLayout)findViewById(2131369768));
    this.mCheckClause = ((CheckBox)findViewById(2131364602));
    int i = (int)DisplayUtils.a(this, 20.0F);
    expandViewTouchDelegate(this.mCheckClause, i);
    setTitleText(2131716624);
    setBackListener();
    setBarProgress(33);
    findViewById(2131373016).setOnClickListener(this);
    this.txtUsage = ((TextView)findViewById(2131380057));
    this.txtUsage.setOnClickListener(this);
    TextView localTextView = this.txtUsage;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131716649));
    localStringBuilder.append(getString(2131691115));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.txtPrivacy = ((TextView)findViewById(2131380043));
    this.txtPrivacy.setOnClickListener(this);
    localTextView = this.txtPrivacy;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131716597));
    localStringBuilder.append(getString(2131691115));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.txtCountryCode = ((TextView)findViewById(2131380021));
    localTextView = this.txtCountryCode;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(this.countryCode);
    localTextView.setText(localStringBuilder.toString());
    this.txtCountryCode.setOnClickListener(this);
    setPressStateShow(this.txtCountryCode);
    this.editText = ((ConfigClearableEditText)findViewById(2131372044));
    this.editText.addTextChangedListener(this);
    clearTextSelMenu(this.editText);
    fillPhoneNum();
    this.btnNextStep = ((Button)findViewById(2131363982));
    this.btnNextStep.setOnClickListener(this);
    findViewById(2131369768).setVisibility(0);
  }
  
  private static final boolean isNeedHideSoftkey(Context paramContext)
  {
    boolean bool = false;
    int i;
    try
    {
      paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      Point localPoint = new Point();
      if (Build.VERSION.SDK_INT >= 19) {
        paramContext.getRealSize(localPoint);
      } else {
        paramContext.getSize(localPoint);
      }
      int j = localPoint.y;
      i = j;
      if (j < 1920)
      {
        bool = true;
        i = j;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("RegisterPhoneNumActivity", 2, "isNeedHideSoftkey", paramContext);
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isNeedHideSoftkey, result=");
      paramContext.append(bool);
      paramContext.append(", mRealSizeHeight=");
      paramContext.append(i);
      QLog.d("RegisterPhoneNumActivity", 2, paramContext.toString());
    }
    return bool;
  }
  
  private void setPressStateShow(View paramView)
  {
    paramView.setOnTouchListener(new RegisterPhoneNumActivity.3(this));
  }
  
  private void updateNextStepButton()
  {
    Object localObject = this.editText;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ConfigClearableEditText)localObject).getText();
    }
    this.mIsValidPhoneNum = checkPhoneNumLength((Editable)localObject);
    if (this.mIsValidPhoneNum)
    {
      this.btnNextStep.setBackgroundResource(2130841441);
      this.btnNextStep.setEnabled(true);
      return;
    }
    this.btnNextStep.setBackgroundResource(2130841442);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.phoneNum = this.editText.getText().toString();
    if (this.btnNextStep != null)
    {
      updateNextStepButton();
      RegisterManager.a().a(1);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean checkAgreementIsOk()
  {
    CheckBox localCheckBox = this.mCheckClause;
    if (localCheckBox != null) {
      return localCheckBox.isChecked();
    }
    return true;
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
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.strCountryName = paramIntent.getStringExtra("k_name");
      this.countryCode = paramIntent.getStringExtra("k_code");
      TextView localTextView = this.txtCountryCode;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(this.countryCode);
      localTextView.setText(localStringBuilder.toString());
      this.mCountryEnglishName = paramIntent.getStringExtra("k_english_name");
      RegisterOverseaHelper.a().a(this.mCountryEnglishName);
      updateNextStepButton();
    }
    this.mQueryAccount.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (isNeedHideSoftkey(this)) {
      getWindow().setSoftInputMode(2);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131559092);
    if (this.mRuntime == null) {
      this.mRuntime = getAppRuntime();
    }
    if (this.mRuntime == null)
    {
      QLog.d("RegisterPhoneNumActivity", 1, "doOnCreate app == null");
      finish();
      this.mIsBeforeFinish = true;
      return true;
    }
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), getIntent());
    }
    this.mQueryAccount = new QueryAccount(this);
    LoginUtils.a(this.mRuntime, getClass(), this.closeHandler);
    this.mQueryAccount.a(getApplicationContext());
    initViews();
    RegisterOverseaHelper.a().a(this.mCountryEnglishName);
    RegisterManager.a().a();
    ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006650", "0X8006650", 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007360", "0X8007360", getIntent().getIntExtra("key_report_extra_from", 0), 0, "", "", "", "");
    if ((this.mFrom != 2) && (this.mFrom != 3))
    {
      if (this.mFrom == 1) {
        this.mFromType = 2;
      }
    }
    else {
      this.mFromType = 1;
    }
    ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B530", "0X800B530", this.mFromType, 0, "", "", "", "");
    if (this.mFrom == -1) {
      ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
    } else {
      ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "page_exp", "", 1, "", Integer.toString(this.mFrom), "", "", "", "", "", "", "");
    }
    this.mLoginUserPrivateHelper = new LoginUserPrivateHelper();
    paramBundle = new RegisterPhoneNumActivity.1(this);
    this.mLoginUserPrivateHelper.a(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mIsBeforeFinish)
    {
      QLog.e("RegisterPhoneNumActivity", 1, "runtime is null");
      return;
    }
    this.mQueryAccount.a();
    LoginUtils.a(this.mRuntime, getClass());
    ViewGroup localViewGroup = (ViewGroup)this.editText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.editText);
    }
    this.btnNextStep.clearAnimation();
    RegisterManager.a().b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    updateNextStepButton();
    RegisterManager.a().a(2);
  }
  
  public String getEditPhoneNum()
  {
    return this.editText.getText().toString();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = paramView.getId();
    Object localObject1;
    if ((j != 2131380021) && (j != 2131362980))
    {
      if (j == 2131363982)
      {
        ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006651", "0X8006651", 0, 0, "", "", "", "");
        ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CC7", "0X8007CC7", 0, 0, "", "", "", "");
        localObject1 = this.mRuntime;
        if ((!TextUtils.isEmpty(this.strCountryName)) && (this.strCountryName.equals(getString(2131716550)))) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.a((AppRuntime)localObject1, "dc00898", "", "", "0X8007CC7", "0X8007CC7", i, 0, "", "", "", "");
        ReportController.b(this.mRuntime, "dc00898", "", "", "0X800B531", "0X800B531", this.mFromType, 0, "", "", getEditPhoneNum(), "");
        ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "next_clk", "", 1, "", "", "", "", "", "", "", "", "");
        if (!this.mIsValidPhoneNum)
        {
          QQToast.a(this, 1, 2131694818, 0).a();
          break label665;
        }
        if (!checkAgreementIsOk())
        {
          localObject1 = AnimationUtils.loadAnimation(this, 2130772380);
          this.mLayoutCheckClause.startAnimation((Animation)localObject1);
          doVibrate();
          break label665;
        }
        if (this.mUserConfirmPrivacyPolicy)
        {
          if (!this.mLoginUserPrivateHelper.a(this, false)) {
            break label665;
          }
          this.mQueryAccount.b();
          break label665;
        }
        localObject1 = new RegisterPhoneNumActivity.6(this, this);
        PrivacyPolicyHelper.a(this, "", (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1).show();
        break label665;
      }
      if ((j != 2131380057) && (j != 2131380043))
      {
        if (j != 2131373016) {
          break label665;
        }
        localObject1 = this.mCheckClause;
        ((CheckBox)localObject1).setChecked(((CheckBox)localObject1).isChecked() ^ true);
        break label665;
      }
      if (!this.canGotoBrowser) {
        break label665;
      }
      this.canGotoBrowser = false;
      this.handler.postDelayed(new RegisterPhoneNumActivity.7(this), 1000L);
    }
    for (;;)
    {
      try
      {
        if (paramView.getId() != 2131380057) {
          break label673;
        }
        localObject1 = "https://ti.qq.com/agreement/index.html";
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1)));
      }
      catch (Exception localException)
      {
        QLog.d("RegisterPhoneNumActivity", 1, "no system browser exp=", localException);
      }
      if (i == 2131380057)
      {
        ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "terms_clk", "", 1, "", "", "", "", "", "", "", "", "");
      }
      else if (i == 2131380043)
      {
        ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "privacy_clk", "", 1, "", "", "", "", "", "", "", "", "");
        break label665;
        localObject2 = new Intent(this, NewStyleCountryActivity.class);
        ((Intent)localObject2).putExtra("k_code", this.countryCode);
        ((Intent)localObject2).putExtra("k_name", this.strCountryName);
        startActivityForResult((Intent)localObject2, 1);
      }
      label665:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label673:
      Object localObject2 = "https://ti.qq.com/agreement/privacy/index.html";
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */