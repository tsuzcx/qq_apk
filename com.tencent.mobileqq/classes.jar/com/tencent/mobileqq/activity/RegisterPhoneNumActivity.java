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
  private LinearLayout mLayoutCheckClause;
  protected LoginUserPrivateHelper mLoginUserPrivateHelper;
  private QueryAccount mQueryAccount = null;
  private boolean mUserConfirmPrivacyPolicy;
  private Vibrator mVibrator;
  private String strCountryName = HardCodeUtil.a(2131716898);
  private TextView txtCountryCode;
  private TextView txtPrivacy;
  private TextView txtUsage;
  
  private boolean checkInputValid()
  {
    int i = 0;
    try
    {
      String str = this.editText.getText().toString();
      str = this.mQueryAccount.a(str);
      if (str != null) {
        i = 1;
      }
      return 0x1 & i;
    }
    catch (Exception localException)
    {
      QLog.d("RegisterPhoneNumActivity", 1, new Object[] { "checkInputValid error : ", localException.getMessage() });
    }
    return true;
  }
  
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
      if (this.mVibrator != null) {
        this.mVibrator.vibrate(50L);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RegisterPhoneNumActivity", 1, "exception when doVibrate.", localException);
    }
  }
  
  public static void expandViewTouchDelegate(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new RegisterPhoneNumActivity.8(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  private void fillPhoneNum()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {
      QLog.d("RegisterPhoneNumActivity", 1, "fillPhoneNum null == intent");
    }
    int i;
    do
    {
      return;
      i = localIntent.getIntExtra("key_register_from", 0);
      QLog.d("RegisterPhoneNumActivity", 1, new Object[] { "fillPhoneNum from=", Integer.valueOf(i) });
    } while (i != 9);
    this.editText.setText(localIntent.getStringExtra("key_phone_num"));
  }
  
  @TargetApi(11)
  private void initViews()
  {
    this.mLayoutCheckClause = ((LinearLayout)findViewById(2131370090));
    this.mCheckClause = ((CheckBox)findViewById(2131364715));
    int i = (int)DisplayUtils.a(this, 20.0F);
    expandViewTouchDelegate(this.mCheckClause, i, i, i, i);
    setTitleText(2131716971);
    setBackListener();
    setBarProgress(33);
    findViewById(2131373437).setOnClickListener(this);
    this.txtUsage = ((TextView)findViewById(2131380794));
    this.txtUsage.setOnClickListener(this);
    this.txtUsage.setContentDescription(getString(2131716996) + getString(2131691194));
    this.txtPrivacy = ((TextView)findViewById(2131380780));
    this.txtPrivacy.setOnClickListener(this);
    this.txtPrivacy.setContentDescription(getString(2131716944) + getString(2131691194));
    this.txtCountryCode = ((TextView)findViewById(2131380753));
    this.txtCountryCode.setText("+" + this.countryCode);
    this.txtCountryCode.setOnClickListener(this);
    setPressStateShow(this.txtCountryCode);
    this.editText = ((ConfigClearableEditText)findViewById(2131372461));
    this.editText.addTextChangedListener(this);
    clearTextSelMenu(this.editText);
    fillPhoneNum();
    this.btnNextStep = ((Button)findViewById(2131364061));
    this.btnNextStep.setOnClickListener(this);
  }
  
  private static final boolean isNeedHideSoftkey(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        localPoint = new Point();
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        paramContext.getRealSize(localPoint);
        j = localPoint.y;
        if (j >= 1920) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        Point localPoint;
        int j;
        QLog.e("RegisterPhoneNumActivity", 2, "isNeedHideSoftkey", paramContext);
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterPhoneNumActivity", 2, "isNeedHideSoftkey, result=" + bool + ", mRealSizeHeight=" + i);
      }
      return bool;
      paramContext.getSize(localPoint);
    }
  }
  
  private void setPressStateShow(View paramView)
  {
    paramView.setOnTouchListener(new RegisterPhoneNumActivity.3(this));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.btnNextStep != null)
    {
      this.btnNextStep.setEnabled(checkInputValid());
      RegisterManager.a().a(1);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean checkAgreementIsOk()
  {
    if (this.mCheckClause != null) {
      return this.mCheckClause.isChecked();
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
      this.txtCountryCode.setText("+" + this.countryCode);
      this.mCountryEnglishName = paramIntent.getStringExtra("k_english_name");
      RegisterOverseaHelper.a().a(this.mCountryEnglishName);
      this.btnNextStep.setEnabled(checkInputValid());
    }
    this.mQueryAccount.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (isNeedHideSoftkey(this)) {
      getWindow().setSoftInputMode(2);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131562023);
    if (this.mRuntime == null) {
      this.mRuntime = getAppRuntime();
    }
    if (this.mRuntime == null)
    {
      QLog.d("RegisterPhoneNumActivity", 1, "doOnCreate app == null");
      finish();
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
    if ((this.mFrom == 2) || (this.mFrom == 3))
    {
      this.mFromType = 1;
      ReportController.a(this.mRuntime, "dc00898", "", "", "0X800B530", "0X800B530", this.mFromType, 0, "", "", "", "");
      if (this.mFrom != -1) {
        break label420;
      }
      ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      this.mLoginUserPrivateHelper = new LoginUserPrivateHelper();
      paramBundle = new RegisterPhoneNumActivity.1(this);
      this.mLoginUserPrivateHelper.a(paramBundle);
      return true;
      if (this.mFrom != 1) {
        break;
      }
      this.mFromType = 2;
      break;
      label420:
      ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "page_exp", "", 1, "", Integer.toString(this.mFrom), "", "", "", "", "", "", "");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.mQueryAccount.a();
    LoginUtils.a(this.mRuntime, getClass());
    ViewGroup localViewGroup = (ViewGroup)this.editText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.editText);
    }
    this.btnNextStep.clearAnimation();
    RegisterManager.a().b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.btnNextStep.setEnabled(checkInputValid());
    RegisterManager.a().a(2);
  }
  
  public String getEditPhoneNum()
  {
    return this.editText.getText().toString();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = paramView.getId();
    Object localObject;
    if (j == 2131380753)
    {
      localObject = new Intent(this, NewStyleCountryActivity.class);
      ((Intent)localObject).putExtra("k_code", this.countryCode);
      ((Intent)localObject).putExtra("k_name", this.strCountryName);
      startActivityForResult((Intent)localObject, 1);
    }
    label341:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (j == 2131364061)
        {
          ReportController.b(this.mRuntime, "CliOper", "", "", "0X8006651", "0X8006651", 0, 0, "", "", "", "");
          ReportController.a(this.mRuntime, "dc00898", "", "", "0X8007CC7", "0X8007CC7", 0, 0, "", "", "", "");
          localObject = this.mRuntime;
          if ((!TextUtils.isEmpty(this.strCountryName)) && (this.strCountryName.equals(getString(2131716897)))) {}
          for (i = 1;; i = 2)
          {
            ReportController.a((AppRuntime)localObject, "dc00898", "", "", "0X8007CC7", "0X8007CC7", i, 0, "", "", "", "");
            ReportController.b(this.mRuntime, "dc00898", "", "", "0X800B531", "0X800B531", this.mFromType, 0, "", "", getEditPhoneNum(), "");
            ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "next_clk", "", 1, "", "", "", "", "", "", "", "", "");
            if (checkAgreementIsOk()) {
              break label341;
            }
            localObject = AnimationUtils.loadAnimation(this, 2130772348);
            this.mLayoutCheckClause.startAnimation((Animation)localObject);
            doVibrate();
            break;
          }
          if (this.mUserConfirmPrivacyPolicy)
          {
            if (this.mLoginUserPrivateHelper.a(this, false)) {
              this.mQueryAccount.b();
            }
          }
          else
          {
            localObject = new RegisterPhoneNumActivity.6(this, this);
            PrivacyPolicyHelper.a(this, "", (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject).show();
          }
        }
        else
        {
          if ((j != 2131380794) && (j != 2131380780)) {
            break;
          }
          if (this.canGotoBrowser)
          {
            this.canGotoBrowser = false;
            this.handler.postDelayed(new RegisterPhoneNumActivity.7(this), 1000L);
            for (;;)
            {
              try
              {
                if (paramView.getId() != 2131380794) {
                  continue;
                }
                localObject = "https://ti.qq.com/agreement/index.html";
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)localObject)));
              }
              catch (Exception localException)
              {
                QLog.d("RegisterPhoneNumActivity", 1, "no system browser exp=", localException);
                continue;
              }
              if (i != 2131380794) {
                break label558;
              }
              ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "terms_clk", "", 1, "", "", "", "", "", "", "", "", "");
              break;
              localObject = "https://ti.qq.com/agreement/privacy/index.html";
            }
            if (i == 2131380780) {
              ReportController.a(this.mRuntime, "new_reg_805", "reg_page", "privacy_clk", "", 1, "", "", "", "", "", "", "", "", "");
            }
          }
        }
      }
    } while (j != 2131373437);
    label558:
    CheckBox localCheckBox = this.mCheckClause;
    if (!this.mCheckClause.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      localCheckBox.setChecked(bool);
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */