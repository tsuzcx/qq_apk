package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.PhoneUnityData;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

@RoutePage(desc="绑定手机号信息Activity", path="/base/phoneUnityBindInfo")
public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final String FROM_SCHEMA = "from_schema";
  public static final String KEY_FROM = "from";
  private static final String REPORT_T_FROM_SHEMA = "0X800B6BF";
  public static final int REQUEST_BIND_MIBAO = 1009;
  public static final int REQUEST_BIND_MIBAO_UNDER_REVIEW = 1010;
  public static final int REQUEST_CHANGE_BIND_MIBAO = 1011;
  public static final int REQUEST_PROCEED = 1008;
  public static final int REQUEST_VERIFY_PHONE = 1012;
  public static final int RESULT_CONTACT_STOP = 4002;
  public static final int RESULT_CONTACT_UNBIND = 4001;
  public static final String TAG = "PhoneUnityBindInfoActivity";
  public static final int WEB_CHANGE_PHONE_RESUEST = 1;
  public static final int WEB_UNITY_CHANGE_PHONE_RESUEST = 2;
  private final int STATE_IOT_PHONE = 3;
  private final int STATE_UNKNOWN = 0;
  private final int STATE_UNVERIFIED_PHONE = 1;
  private final int STATE_VERIFIED_PHONE = 2;
  public ContactBindObserver bindObserver;
  public ContactBindObserver disableMatchObserver;
  private boolean isReGetPhone = false;
  public ActionSheet mActionSheet;
  BroadcastReceiver mBindMiBaoReceiver = new PhoneUnityBindInfoActivity.1(this);
  private TextView mBindPhoneTv = null;
  private QQCustomDialog mBindPhoneVerifyDialog;
  private TextView mBindPhoneVerifyTv = null;
  private Button mChangeBindBtn = null;
  private int mChangePhoneNum = 0;
  public boolean mCloseThisActivity = true;
  private QQCustomDialog mContactSecurityDialog;
  private FormSwitchItem mContactSwitch;
  private int mCurrentState = 0;
  private DevlockInfo mDevlockInfo;
  private boolean mFetchingDevlockInfo = false;
  private Runnable mFinishRunnable;
  private Handler mHandler = new Handler();
  public boolean mInit = false;
  private boolean mIsUnBindedUnity = false;
  private FormSwitchItem mLoginSwitch;
  public QQCustomDialog mMobileAlreadyBindDialog;
  private QQCustomDialog mNoPwdUnbindLoginDialog;
  public QQCustomDialog mNotSetPasswordDialog;
  private PhoneUnityManager.PhoneUnityData mPhoneUnityData = new PhoneUnityManager.PhoneUnityData();
  public Bundle mPhoneUnityInfoBundle;
  public PhoneUnityManager mPhoneUnityManager;
  private QQProgressNotifier mProgressNotifier;
  SecSvcObserver mSecObserver = new PhoneUnityBindInfoActivity.2(this);
  public int mUnBindedNum = -1;
  private TipsBar mUnverifiedBar;
  public ContactBindObserver unbindObserver;
  
  private void countDownBindedNum()
  {
    if (this.mIsUnBindedUnity)
    {
      int i = this.mUnBindedNum;
      if (i > -1)
      {
        this.mUnBindedNum = (i - 1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("phone_unity_info, mUnBindedNum: ");
        localStringBuilder.append(this.mUnBindedNum);
        QLog.d("PhoneUnityBindInfoActivity", 1, localStringBuilder.toString());
      }
    }
  }
  
  public static SpannableStringBuilder createBoldText(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramString.length(), 18);
    return localSpannableStringBuilder;
  }
  
  private void fetchSecurePhoneNum()
  {
    if (this.mFetchingDevlockInfo)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, in progress");
      return;
    }
    this.mFetchingDevlockInfo = true;
    QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, start");
    WeakReference localWeakReference = new WeakReference(this);
    EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), new PhoneUnityBindInfoActivity.4(this, localWeakReference));
  }
  
  private void hideLoading()
  {
    this.mProgressNotifier.b();
  }
  
  private void initViews(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      this.mChangeBindBtn.setVisibility(0);
      this.mContactSwitch.setEnabled(true);
      this.mLoginSwitch.setEnabled(true);
      this.mPhoneUnityInfoBundle = paramBundle;
      initPhoneUnityInfo(paramBundle);
      int i;
      if (paramBundle.getInt("need_unify", 0) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if ((this.mPhoneUnityData.d == 3) && (i != 0))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B313", "0X800B313", 0, 0, "", "", "", "");
        if (!TextUtils.isEmpty(this.mPhoneUnityData.h)) {
          PhoneUnityManager.a(this, this.app, this.mPhoneUnityData.h, 1010);
        }
        sendUnityBroadcast();
        finish();
        return;
      }
      if ((paramBundle.getInt("check_result") == 1) && (TextUtils.isEmpty(paramBundle.getString("phone_unverified_number"))))
      {
        paramBundle = paramBundle.getString("mibao_set_url");
        if (!TextUtils.isEmpty(paramBundle)) {
          PhoneUnityManager.a(this, this.app, paramBundle, 1009);
        } else {
          QLog.e("PhoneUnityBindInfoActivity", 4, "mb set url is null.");
        }
        sendUnityBroadcast();
        finish();
        return;
      }
      updatePhoneBindUI(paramBundle);
      if (i != 0)
      {
        showUnityDialog(paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X800B322", "0X800B322", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800B314", "0X800B314", 0, 0, "", "", "", "");
      if (!((Boolean)SharedPreUtils.a(BaseApplicationImpl.getContext(), this.app.getAccount(), "phone_unity_banner_tips_need_show", Boolean.valueOf(false))).booleanValue()) {
        return;
      }
      QQToast.makeText(this, 2, getResources().getString(2131892482), 0).show();
      sendUnityBroadcast();
      return;
    }
    this.mChangeBindBtn.setVisibility(4);
    this.mContactSwitch.setEnabled(false);
    this.mLoginSwitch.setEnabled(false);
  }
  
  private boolean onClickChangeSecurePhone(String paramString)
  {
    return onClickWebView(paramString, 1011);
  }
  
  private boolean onClickWebView(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("PhoneUnityBindInfoActivity", 2, "url is null.");
      return false;
    }
    PhoneUnityManager.a(this, this.app, paramString, paramInt);
    return true;
  }
  
  private void onGetDevlockInfo(DevlockInfo paramDevlockInfo)
  {
    this.mFetchingDevlockInfo = false;
    if (paramDevlockInfo == null)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "onGetDevlockInfo, fail");
      return;
    }
    QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, success");
    this.mDevlockInfo = paramDevlockInfo;
    DevlockPhoneStatus.a().a(paramDevlockInfo.TransferInfo);
  }
  
  private void phoneUnitySuc()
  {
    if ((this.mIsUnBindedUnity) && (this.mUnBindedNum == 0))
    {
      this.mUnBindedNum = -1;
      this.mIsUnBindedUnity = false;
      dismissProgressDialog();
      if ((!this.mLoginSwitch.a()) && (!this.mContactSwitch.a()))
      {
        sendUnityBroadcast();
        QQToast.makeText(this, 2, getResources().getString(2131892482), 0).show(getTitleBarHeight());
        refreshServerData(1, null);
        ReportController.b(this.app, "dc00898", "", "", "0X800B324", "0X800B324", 0, 0, "", "", "", "");
        return;
      }
      QQToast.makeText(this, 1, getResources().getString(2131892470), 0).show(getTitleBarHeight());
      finish();
    }
  }
  
  private void sendUnityBroadcast()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    sendBroadcast(localIntent);
  }
  
  private void showBindContactPhoneDialog()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showBindContactPhoneDialog");
    if (this.mPhoneUnityInfoBundle == null) {
      return;
    }
    if (this.mContactSecurityDialog == null)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localQQCustomDialog.setTitle(2131892434);
      String str1 = this.mPhoneUnityInfoBundle.getString("phone");
      String str2 = getString(2131892432);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<font color=\"#FF8343\">");
      localStringBuilder.append(str1);
      localStringBuilder.append("</font>");
      localQQCustomDialog.setMessage(Html.fromHtml(String.format(str2, new Object[] { localStringBuilder.toString() })));
      localQQCustomDialog.setPositiveButton(2131892433, new PhoneUnityBindInfoActivity.16(this));
      localQQCustomDialog.setNegativeButton(2131892431, new PhoneUnityBindInfoActivity.17(this));
      this.mContactSecurityDialog = localQQCustomDialog;
    }
    if ((!this.mContactSecurityDialog.isShowing()) && (!isFinishing()))
    {
      this.mContactSecurityDialog.show();
      ReportController.b(this.app, "dc00898", "", "", "0X800B31C", "0X800B31C", 0, 0, "", "", "", "");
    }
  }
  
  private void showLoading()
  {
    this.mProgressNotifier.a(0, getString(2131892473), 0, new PhoneUnityBindInfoActivity.3(this));
  }
  
  private void showNoPwdUnbindLoginDialog()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showUnityUnderReviewDialog");
    if (this.mNoPwdUnbindLoginDialog == null)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.setTitle(2131892474);
      localQQCustomDialog.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localQQCustomDialog.setMessage(2131892478);
      localQQCustomDialog.setPositiveButton(2131892534, new PhoneUnityBindInfoActivity.14(this));
      this.mNoPwdUnbindLoginDialog = localQQCustomDialog;
    }
    if ((!this.mNoPwdUnbindLoginDialog.isShowing()) && (!isFinishing())) {
      this.mNoPwdUnbindLoginDialog.show();
    }
  }
  
  private void showUnityDialog(Bundle paramBundle)
  {
    String str = paramBundle.getString("phone");
    Object localObject3 = paramBundle.getParcelableArray("phone_info");
    Object localObject2 = "";
    if (localObject3 != null)
    {
      localObject1 = "";
      paramBundle = (Bundle)localObject1;
      int i = 0;
      while (i < localObject3.length)
      {
        localObject4 = (Bundle)localObject3[i];
        if (localObject4 != null)
        {
          int j = ((Bundle)localObject4).getInt("phone_type", 0);
          if (j != 1)
          {
            if (j != 2)
            {
              if (j == 3) {
                paramBundle = ((Bundle)localObject4).getString("phone");
              }
            }
            else {
              localObject2 = ((Bundle)localObject4).getString("phone");
            }
          }
          else
          {
            str = ((Bundle)localObject4).getString("phone");
            localObject1 = str;
          }
        }
        i += 1;
      }
    }
    else
    {
      localObject1 = "";
      paramBundle = (Bundle)localObject1;
    }
    localObject3 = this.mActionSheet;
    if (localObject3 != null) {
      ((ActionSheet)localObject3).dismiss();
    }
    this.mCloseThisActivity = true;
    localObject3 = (ActionSheet)ActionSheetHelper.b(this, null);
    ((ActionSheet)localObject3).setSupportBottomRadius(true);
    this.mActionSheet = ((ActionSheet)localObject3);
    Object localObject4 = LayoutInflater.from(this).inflate(2131625573, null);
    if (localObject4 != null)
    {
      ((View)localObject4).setOnClickListener(new PhoneUnityBindInfoActivity.6(this));
      Object localObject5 = (LinearLayout)((View)localObject4).findViewById(2131440040);
      if (localObject5 != null)
      {
        TextView localTextView = (TextView)((LinearLayout)localObject5).findViewById(2131440042);
        if ((localTextView != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          ((LinearLayout)localObject5).setVisibility(0);
          localTextView.setText((CharSequence)localObject2);
        }
      }
      localObject2 = (LinearLayout)((View)localObject4).findViewById(2131440030);
      if (localObject2 != null)
      {
        localObject5 = (TextView)((LinearLayout)localObject2).findViewById(2131440032);
        if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          ((LinearLayout)localObject2).setVisibility(0);
          ((TextView)localObject5).setText((CharSequence)localObject1);
        }
      }
      localObject1 = (LinearLayout)((View)localObject4).findViewById(2131440077);
      if (localObject1 != null)
      {
        localObject2 = (TextView)((View)localObject4).findViewById(2131440085);
        if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((TextView)localObject2).setText(paramBundle);
        }
      }
      ((View)localObject4).setBackgroundResource(2130853292);
      ((ActionSheet)localObject3).addViewCustomeTitle((View)localObject4);
    }
    ((ActionSheet)localObject3).addButton(createBoldText(String.format(super.getString(2131892428), new Object[] { str })), 9, "#03081A");
    ((ActionSheet)localObject3).addButton(createBoldText(getString(2131892427)), 9, "#03081A");
    ((ActionSheet)localObject3).addButton(createBoldText(getString(2131887648)), 9, "#03081A");
    ((ActionSheet)localObject3).setOnCancelListener(new PhoneUnityBindInfoActivity.7(this));
    ((ActionSheet)localObject3).setOnDismissListener(new PhoneUnityBindInfoActivity.8(this));
    ((ActionSheet)localObject3).setOnButtonClickListener(new PhoneUnityBindInfoActivity.9(this, (ActionSheet)localObject3));
    localObject2 = ((ActionSheet)localObject3).getActionContentView();
    Object localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    }
    paramBundle.addRule(12, 0);
    paramBundle.addRule(13, -1);
    paramBundle.setMargins(80, 0, 80, 0);
    ((RelativeLayout)localObject2).setLayoutParams(paramBundle);
    ((ActionSheet)localObject3).setCanceledOnTouchOutside(false);
    ((ActionSheet)localObject3).show();
  }
  
  private void showUnityUnderReviewDialog()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showUnityUnderReviewDialog");
    if (this.mBindPhoneVerifyDialog == null)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setCancelable(true);
      localQQCustomDialog.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localQQCustomDialog.setMessage(2131892485);
      localQQCustomDialog.setPositiveButton(2131892534, new PhoneUnityBindInfoActivity.15(this));
      this.mBindPhoneVerifyDialog = localQQCustomDialog;
    }
    if ((!this.mBindPhoneVerifyDialog.isShowing()) && (!isFinishing()))
    {
      this.mBindPhoneVerifyDialog.show();
      ReportController.b(this.app, "dc00898", "", "", "0X800B318", "0X800B318", 0, 0, "", "", "", "");
    }
  }
  
  private void updateIotOrUnverifiedPhoneUI(Button paramButton, View paramView, Bundle paramBundle)
  {
    paramButton.setText(2131892439);
    this.mBindPhoneVerifyTv.setText(paramBundle.getString("str_red_dot_tips"));
    this.mBindPhoneVerifyTv.setVisibility(0);
    this.mUnverifiedBar.setBarType(4);
    this.mUnverifiedBar.setTipsIcon(getActivity().getResources().getDrawable(2130838283));
    TipsBar localTipsBar = this.mUnverifiedBar;
    if (TextUtils.isEmpty(paramBundle.getString("str_hori_bar_tips"))) {
      paramButton = "";
    } else {
      paramButton = paramBundle.getString("str_hori_bar_tips");
    }
    localTipsBar.setTipsText(paramButton);
    this.mUnverifiedBar.setOnClickListener(this);
    this.mUnverifiedBar.setVisibility(0);
    paramView.setOnClickListener(this);
    if (this.mCurrentState == 3)
    {
      paramButton = new StringBuilder();
      paramButton.append(getResources().getString(2131892449));
      paramButton.append(paramBundle.getString("phone"));
      paramButton = paramButton.toString();
      this.mBindPhoneTv.setText(paramButton);
    }
    else
    {
      paramButton = new StringBuilder();
      paramButton.append(getResources().getString(2131892449));
      paramButton.append(paramBundle.getString("phone_unverified_number"));
      paramButton = paramButton.toString();
      this.mBindPhoneTv.setText(paramButton);
    }
    if (this.mPhoneUnityInfoBundle.getBoolean("phone_verified", true))
    {
      paramView.setVisibility(8);
      this.mContactSwitch.setOnCheckedChangeListener(null);
      this.mLoginSwitch.setOnCheckedChangeListener(null);
      if (this.mPhoneUnityData.a) {
        this.mLoginSwitch.setChecked(true);
      } else {
        this.mLoginSwitch.setChecked(false);
      }
      if ((this.mPhoneUnityData.c) && (this.mPhoneUnityData.b)) {
        this.mContactSwitch.setChecked(true);
      } else {
        this.mContactSwitch.setChecked(false);
      }
      this.mContactSwitch.setOnCheckedChangeListener(this);
      this.mLoginSwitch.setOnCheckedChangeListener(this);
      return;
    }
    paramView.setVisibility(0);
  }
  
  private String updatePhoneBindUI(Bundle paramBundle)
  {
    if (this.mBindPhoneTv != null)
    {
      Button localButton = (Button)findViewById(2131430468);
      String str = paramBundle.getString("phone");
      View localView = findViewById(2131429505);
      boolean bool1 = paramBundle.getBoolean("phone_verified", true);
      boolean bool2 = paramBundle.getBoolean("bool_is_IOT", false);
      if ((this.mCurrentState == 1) && (bool1)) {
        ReportController.b(this.app, "dc00898", "", "", "0X800BAEB", "0X800BAEB", 0, 0, "", "", "", "");
      }
      if (bool2)
      {
        this.mCurrentState = 3;
        updateIotOrUnverifiedPhoneUI(localButton, localView, paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X800BDA8", "0X800BDA8", 0, 0, "", "", "", "");
        return str;
      }
      if (!bool1)
      {
        updateIotOrUnverifiedPhoneUI(localButton, localView, paramBundle);
        ReportController.b(this.app, "dc00898", "", "", "0X800BAE3", "0X800BAE3", 0, 0, "", "", "", "");
        this.mCurrentState = 1;
        return str;
      }
      updateVerifiedPhoneUI(localButton, localView, str);
      this.mCurrentState = 2;
      return str;
    }
    return "";
  }
  
  private void updateVerifiedPhoneUI(Button paramButton, View paramView, String paramString)
  {
    this.mUnverifiedBar.setVisibility(8);
    this.mBindPhoneVerifyTv.setVisibility(8);
    paramView.setVisibility(8);
    if (!TextUtils.isEmpty(paramString))
    {
      paramView = new StringBuilder();
      paramView.append(getResources().getString(2131892479));
      paramView.append(paramString);
      paramView = paramView.toString();
      this.mBindPhoneTv.setText(paramView);
      this.mBindPhoneVerifyTv.setText(2131892466);
      if (this.mPhoneUnityData.d == 3)
      {
        this.mBindPhoneVerifyTv.setVisibility(0);
        paramButton.setText(2131892484);
      }
      else
      {
        this.mBindPhoneVerifyTv.setVisibility(8);
        paramButton.setText(2131892439);
      }
    }
    else
    {
      this.mBindPhoneTv.setText(2131892451);
      paramButton.setText(2131892425);
      this.mPhoneContactService.checkUpdateBindStateAndListIgnoreBindState(true, false, 17);
    }
    this.mContactSwitch.setOnCheckedChangeListener(null);
    this.mLoginSwitch.setOnCheckedChangeListener(null);
    if (this.mPhoneUnityData.a) {
      this.mLoginSwitch.setChecked(true);
    } else {
      this.mLoginSwitch.setChecked(false);
    }
    if ((this.mPhoneUnityData.c) && (this.mPhoneUnityData.b)) {
      this.mContactSwitch.setChecked(true);
    } else {
      this.mContactSwitch.setChecked(false);
    }
    this.mContactSwitch.setOnCheckedChangeListener(this);
    this.mLoginSwitch.setOnCheckedChangeListener(this);
  }
  
  private boolean verifyPhone()
  {
    if (this.mPhoneUnityInfoBundle.getBoolean("bool_is_IOT")) {
      return onClickWebView(this.mPhoneUnityInfoBundle.getString("verify_phone_url"), 1012);
    }
    if (!this.mPhoneUnityInfoBundle.getBoolean("phone_verified")) {
      return onClickWebView(this.mPhoneUnityInfoBundle.getString("verify_phone_url"), 1012);
    }
    return false;
  }
  
  public void bindContactsMobile()
  {
    if (this.mPhoneUnityInfoBundle == null) {
      return;
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    if (this.bindObserver == null)
    {
      this.bindObserver = new PhoneUnityBindInfoActivity.11(this);
      this.app.registObserver(this.bindObserver);
    }
    String str = this.mPhoneUnityInfoBundle.getString("country_code");
    byte[] arrayOfByte = getPhoneVasKey(3);
    if (arrayOfByte != null)
    {
      this.mPhoneContactService.sendBindMobileEncrypt(str, arrayOfByte, 0, true, false);
      return;
    }
    resetContactSwitch(false);
    QQToast.makeText(this, 1, getResources().getString(2131892470), 0).show(getTitleBarHeight());
    if (QLog.isColorLevel()) {
      QLog.e("PhoneUnityBindInfoActivity", 2, "sendBindMobileEncrypt contact vaskey is null.");
    }
  }
  
  public void bindPhoneNumLogin()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if ((localSecSvcHandler != null) && (this.mPhoneUnityInfoBundle != null))
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info_login, bindPhoneNumLogin");
      byte[] arrayOfByte = getPhoneVasKey(2);
      if (arrayOfByte != null)
      {
        localSecSvcHandler.a(arrayOfByte);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PhoneUnityBindInfoActivity", 2, "bindPhoneNumLogin contact vaskey is null.");
      }
    }
  }
  
  public void closeMobileMatch()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.e();
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnActivityResult requestCode = ");
      paramIntent.append(paramInt1);
      paramIntent.append(" resultCode = ");
      paramIntent.append(paramInt2);
      QLog.d("PhoneUnityBindInfoActivity", 2, paramIntent.toString());
    }
    switch (paramInt1)
    {
    case 1010: 
    default: 
      return;
    case 1009: 
    case 1011: 
    case 1012: 
      refreshServerData(1, null);
      return;
    }
    if ((paramInt2 != 0) && (paramInt2 == -1))
    {
      onBindSuc();
      return;
    }
    resetContactSwitch(false);
    QQToast.makeText(this, 1, getResources().getString(2131892470), 0).show(getTitleBarHeight());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mPhoneUnityInfoBundle = getIntent().getBundleExtra("kBindPhoneData");
    super.setContentView(2131627632);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    registerReceiver(this.mBindMiBaoReceiver, paramBundle);
    this.mPhoneUnityManager = ((PhoneUnityManager)this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER));
    this.mBindPhoneTv = ((TextView)super.findViewById(2131438162));
    this.mBindPhoneVerifyTv = ((TextView)super.findViewById(2131440074));
    this.mChangeBindBtn = ((Button)super.findViewById(2131430468));
    this.mContactSwitch = ((FormSwitchItem)super.findViewById(2131429499));
    this.mLoginSwitch = ((FormSwitchItem)super.findViewById(2131429501));
    this.mUnverifiedBar = ((TipsBar)super.findViewById(2131429506));
    this.mProgressNotifier = new QQProgressNotifier(this);
    paramBundle = super.findViewById(2131440029);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      paramBundle.setBackgroundColor(0);
    } else {
      paramBundle.setBackgroundColor(-1);
    }
    this.mChangeBindBtn.setOnClickListener(this);
    this.mBindPhoneVerifyTv.setOnClickListener(this);
    paramBundle = this.mPhoneUnityManager;
    if (paramBundle != null) {
      paramBundle.a = true;
    }
    super.addObserver(this.mSecObserver);
    refreshServerData(1, this.mPhoneUnityInfoBundle);
    if ("from_schema".equals(getIntent().getStringExtra("from"))) {
      ReportController.b(this.app, "dc00898", "", "", "0X800B6BF", "0X800B6BF", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.mSecObserver);
    unregisterReceiver(this.mBindMiBaoReceiver);
    Object localObject = this.mFinishRunnable;
    if (localObject != null) {
      this.mHandler.removeCallbacks((Runnable)localObject);
    }
    hideLoading();
    if (this.unbindObserver != null)
    {
      this.app.unRegistObserver(this.unbindObserver);
      this.unbindObserver = null;
    }
    if (this.bindObserver != null)
    {
      this.app.unRegistObserver(this.bindObserver);
      this.bindObserver = null;
    }
    if (this.disableMatchObserver != null)
    {
      this.app.unRegistObserver(this.disableMatchObserver);
      this.disableMatchObserver = null;
    }
    localObject = this.mActionSheet;
    if (localObject != null)
    {
      ((ActionSheet)localObject).superDismiss();
      this.mActionSheet = null;
    }
    localObject = this.mMobileAlreadyBindDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.mMobileAlreadyBindDialog = null;
    }
    localObject = this.mNotSetPasswordDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.mNotSetPasswordDialog = null;
    }
    localObject = this.mContactSecurityDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.mContactSecurityDialog = null;
    }
    localObject = this.mBindPhoneVerifyDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.mBindPhoneVerifyDialog = null;
    }
    localObject = this.mNoPwdUnbindLoginDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.mNoPwdUnbindLoginDialog = null;
    }
  }
  
  protected byte[] getPhoneVasKey(int paramInt)
  {
    return (byte[])this.mPhoneUnityData.i.get(paramInt);
  }
  
  protected void gotoBindVerify()
  {
    if (this.mPhoneUnityInfoBundle == null) {
      return;
    }
    byte[] arrayOfByte = getPhoneVasKey(3);
    if (arrayOfByte == null)
    {
      QLog.e("PhoneUnityBindInfoActivity", 2, "gotoBindVerify contact phoneVasKey is null.");
      return;
    }
    resetContactSwitch(false);
    String str1 = this.mPhoneUnityInfoBundle.getString("country_code");
    String str2 = this.mPhoneUnityInfoBundle.getString("phone");
    Intent localIntent = new Intent(this, BindVerifyActivity.class);
    localIntent.putExtra("kSrouce", 23);
    localIntent.putExtra("kBindType", 0);
    localIntent.putExtra("keyReqBindMode", 0);
    localIntent.putExtra("cmd_param_is_encrypt", true);
    localIntent.putExtra("cmd_param_encrypt_mobile", arrayOfByte);
    localIntent.putExtra("k_mask_number_forshow", str2);
    localIntent.putExtra("k_country_code", str1);
    localIntent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
    localIntent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
    localIntent.putExtra("cmd_param_is_from_uni", true);
    localIntent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
    localIntent.putExtra("cmd_param_is_from_change_bind", false);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    if (!isFinishing()) {
      startActivityForResult(localIntent, 1008);
    }
  }
  
  protected void initPhoneUnityInfo(Bundle paramBundle)
  {
    this.mPhoneUnityData.a();
    if (paramBundle != null)
    {
      this.mPhoneUnityData.g = paramBundle.getString("mibao_change_url");
      this.mPhoneUnityData.f = paramBundle.getString("mibao_set_url");
      this.mPhoneUnityData.h = paramBundle.getString("mibao_verify_url");
      paramBundle = paramBundle.getParcelableArray("phone_info");
      if (paramBundle != null)
      {
        int i = 0;
        while (i < paramBundle.length)
        {
          Bundle localBundle = (Bundle)paramBundle[i];
          if (localBundle != null)
          {
            int j = localBundle.getInt("phone_type");
            boolean bool2 = true;
            boolean bool1 = true;
            if (j != 1)
            {
              Object localObject;
              if (j != 2)
              {
                if (j == 3)
                {
                  this.mPhoneUnityData.c = (TextUtils.isEmpty(localBundle.getString("phone")) ^ true);
                  localObject = this.mPhoneUnityData;
                  if ((!((PhoneUnityManager.PhoneUnityData)localObject).c) || (localBundle.getInt("status") != 1)) {
                    bool1 = false;
                  }
                  ((PhoneUnityManager.PhoneUnityData)localObject).b = bool1;
                  this.mPhoneUnityData.i.put(j, localBundle.getByteArray("vaskey"));
                }
              }
              else
              {
                localObject = localBundle.getString("phone");
                PhoneUnityManager.PhoneUnityData localPhoneUnityData = this.mPhoneUnityData;
                if ((localBundle.getInt("status") == 1) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  bool1 = bool2;
                } else {
                  bool1 = false;
                }
                localPhoneUnityData.a = bool1;
                this.mPhoneUnityData.i.put(j, localBundle.getByteArray("vaskey"));
              }
            }
            else
            {
              this.mPhoneUnityData.e = localBundle.getString("phone");
              this.mPhoneUnityData.d = localBundle.getInt("status");
              this.mPhoneUnityData.i.put(j, localBundle.getByteArray("vaskey"));
            }
          }
          i += 1;
        }
      }
    }
  }
  
  protected void onBindSuc()
  {
    this.mPhoneUnityData.c = true;
    openMobileMatch();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ViewParent localViewParent = paramCompoundButton.getParent();
    if (this.mPhoneUnityData.d == 3)
    {
      showUnityUnderReviewDialog();
      if (localViewParent == this.mContactSwitch)
      {
        resetContactSwitch(paramBoolean ^ true);
        ReportController.b(this.app, "dc00898", "", "", "0X800BAE8", "0X800BAE8", 0, 0, "2", "", "", "");
      }
      else if (localViewParent == this.mLoginSwitch)
      {
        resetLoginSwitch(paramBoolean ^ true);
        ReportController.b(this.app, "dc00898", "", "", "0X800BAE7", "0X800BAE7", 0, 0, "2", "", "", "");
      }
    }
    else if (localViewParent == this.mContactSwitch)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
        resetContactSwitch(paramBoolean ^ true);
      }
      else
      {
        if (!this.mPhoneUnityData.c)
        {
          ReportController.b(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "2", "", "", "");
          showBindContactPhoneDialog();
        }
        else if (!this.mPhoneUnityData.b)
        {
          openMobileMatch();
          ReportController.b(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "1", "", "", "");
        }
        else
        {
          closeMobileMatch();
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800BAE8", "0X800BAE8", 0, 0, "2", "", "", "");
      }
    }
    else if (localViewParent == this.mLoginSwitch)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
        resetLoginSwitch(paramBoolean ^ true);
      }
      else if (!this.mPhoneUnityData.a)
      {
        bindPhoneNumLogin();
      }
      else
      {
        unbindPhoneNumLogin();
        this.mPhoneUnityData.a = false;
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800BAE7", "0X800BAE7", 0, 0, "2", "", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131440074: 
      localObject = this.mPhoneUnityInfoBundle;
      if ((localObject != null) && (((Bundle)localObject).getBoolean("bool_is_IOT"))) {
        ReportController.b(this.app, "dc00898", "", "", "0X800BDAA", "0X800BDAA", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.app, "dc00898", "", "", "0X800BAE5", "0X800BAE5", 0, 0, "", "", "", "");
      }
      verifyPhone();
      break;
    case 2131430468: 
      if ((this.mPhoneUnityData.d == 3) && (!TextUtils.isEmpty(this.mPhoneUnityData.h)))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B317", "0X800B317", 0, 0, "", "", "", "");
        PhoneUnityManager.a(this, this.app, this.mPhoneUnityData.h, 1010);
      }
      else if (!TextUtils.isEmpty(this.mPhoneUnityData.g))
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800B315", "0X800B315", 0, 0, "", "", "", "");
        this.mChangePhoneNum = 1;
        onClickChangeSecurePhone(this.mPhoneUnityData.g);
      }
      else
      {
        QLog.e("PhoneUnityBindInfoActivity", 2, "change bind phone error.");
      }
      localObject = this.mPhoneUnityInfoBundle;
      if ((localObject != null) && (((Bundle)localObject).getBoolean("bool_is_IOT"))) {
        ReportController.b(this.app, "dc00898", "", "", "0X800BDAB", "0X800BDAB", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.app, "dc00898", "", "", "0X800BAE6", "0X800BAE6", 0, 0, "", "", "", "");
      }
      break;
    case 2131429506: 
      localObject = this.mPhoneUnityInfoBundle;
      if ((localObject != null) && (((Bundle)localObject).getBoolean("bool_is_IOT"))) {
        ReportController.b(this.app, "dc00898", "", "", "0X800BDA9", "0X800BDA9", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.app, "dc00898", "", "", "0X800BAE4", "0X800BAE4", 0, 0, "", "", "", "");
      }
      verifyPhone();
      break;
    case 2131429505: 
      localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setTitle(getString(2131892438));
      ((QQCustomDialog)localObject).setMessage(getString(2131892436));
      PhoneUnityBindInfoActivity.5 local5 = new PhoneUnityBindInfoActivity.5(this);
      ((QQCustomDialog)localObject).setPositiveButton(getString(2131892437), local5);
      ((QQCustomDialog)localObject).setNegativeButton(getString(2131887626), local5);
      ((QQCustomDialog)localObject).show();
      ReportController.b(this.app, "dc00898", "", "", "0X800BAE9", "0X800BAE9", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onMobileBindUinNotSetPasswordError()
  {
    if (this.mMobileAlreadyBindDialog == null)
    {
      localObject = getString(2131892475);
      this.mMobileAlreadyBindDialog = DialogUtil.a(this, 230, getString(2131892474), (CharSequence)localObject, null, HardCodeUtil.a(2131899356), new PhoneUnityBindInfoActivity.12(this), null);
    }
    Object localObject = this.mMobileAlreadyBindDialog;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()) && (!isFinishing())) {
      this.mMobileAlreadyBindDialog.show();
    }
  }
  
  protected void onUinNotSetPasswordError()
  {
    if (this.mNotSetPasswordDialog == null) {
      this.mNotSetPasswordDialog = DialogUtil.a(this, 230, null, getString(2131892476), null, HardCodeUtil.a(2131899360), new PhoneUnityBindInfoActivity.13(this), null);
    }
    QQCustomDialog localQQCustomDialog = this.mNotSetPasswordDialog;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.mNotSetPasswordDialog.show();
    }
  }
  
  public void openMobileMatch()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.d();
    }
  }
  
  public void refreshServerData(int paramInt, Bundle paramBundle)
  {
    fetchSecurePhoneNum();
    if (paramBundle == null)
    {
      initViews(false, null);
      paramBundle = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      if (paramBundle != null)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "refreshServerData, getPhoneUnityInfo");
        paramBundle.a(paramInt);
        showLoading();
      }
    }
    else
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "init with prefetched bind phone data");
      initViews(true, paramBundle);
    }
  }
  
  protected void resetContactSwitch(boolean paramBoolean)
  {
    this.mContactSwitch.setOnCheckedChangeListener(null);
    this.mContactSwitch.setChecked(paramBoolean);
    this.mContactSwitch.setOnCheckedChangeListener(this);
  }
  
  protected void resetLoginSwitch(boolean paramBoolean)
  {
    this.mLoginSwitch.setOnCheckedChangeListener(null);
    this.mLoginSwitch.setChecked(paramBoolean);
    this.mLoginSwitch.setOnCheckedChangeListener(this);
  }
  
  public void unBindContactsMobile()
  {
    if (this.mPhoneUnityInfoBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhoneUnityBindInfoActivity", 2, "InfoBundle is null.");
      }
      return;
    }
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    if (this.unbindObserver == null)
    {
      this.unbindObserver = new PhoneUnityBindInfoActivity.10(this);
      this.app.registObserver(this.unbindObserver);
    }
    byte[] arrayOfByte = getPhoneVasKey(3);
    if (arrayOfByte != null)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unbindMobileEncrypt");
      this.mPhoneContactService.unbindMobileEncrypt(arrayOfByte, true, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PhoneUnityBindInfoActivity", 2, "unbindMobileEncrypt contact vaskey is null.");
    }
  }
  
  public void unbindPhoneNumLogin()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if ((localSecSvcHandler != null) && (this.mPhoneUnityInfoBundle != null))
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info_login, unbindPhoneNumLogin");
      byte[] arrayOfByte = getPhoneVasKey(2);
      if (arrayOfByte != null)
      {
        localSecSvcHandler.b(arrayOfByte);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PhoneUnityBindInfoActivity", 2, "unbindPhoneNumLogin contact vaskey is null.");
      }
    }
  }
  
  public void unbindPhoneNumLoginOnPhoneUnity()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
      return;
    }
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (localSecSvcHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhoneUnityBindInfoActivity", 2, "unbindPhoneNumLoginOnPhoneUnity contact.");
      }
      localSecSvcHandler.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity
 * JD-Core Version:    0.7.0.1
 */