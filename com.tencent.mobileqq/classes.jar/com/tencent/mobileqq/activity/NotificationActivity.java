package com.tencent.mobileqq.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qqsec.api.FrozenKickUtils;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import com.tencent.mobileqq.qqsec.api.QQSecBlockInjectUtil;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.LhHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@RoutePage(desc="通知类弹框activity", path="/base/notification")
public class NotificationActivity
  extends QBaseActivity
  implements Handler.Callback
{
  private static final String DEFAULT_NIGHT_COLOR = "#FFFFFF";
  public static final int DIALOG_ANOTHER_TERMINAL_LOGIN = 5;
  public static final int DIALOG_IDENTITY_EXPIRED = 1;
  public static final int DIALOG_SDK_SUSPENDED = 4;
  public static final int DIALOG_SECURITY_SCAN = 7;
  public static final int DIALOG_SSO_TIPS = 6;
  public static final String DLG_CONTENT = "dlg_content";
  public static final String DLG_LBUTTON = "dlg_lbutton";
  public static final String DLG_RBUTTON = "dlg_rbutton";
  public static final String DLG_TITLE = "dlg_title";
  public static final String DLG_URL = "dlg_url";
  public static final String KEY_ALIAS = "alias";
  public static final String KEY_ERROR = "error";
  public static final String KEY_IS_FROM_LH_LOGIN_VERIFY_CODE = "lh_is_from_login_verify_code";
  public static final String KEY_LAST_ERROR = "lastError";
  private static final int LOGIN_FAILED_CODE = 40;
  public static final String PASSWORD = "password";
  public static final int PAYRESULT_SUCC = 0;
  public static final String REASON = "reason";
  private static final String SEC_TAG = "sec_sig_tag";
  private static final String TAG = "NotificationActivity";
  private static final int TIPS_SENEDES_ID_DEFAULT = 0;
  public static NotificationActivity instance = null;
  private static ISecControllerInterface sSecControllerInjectInterface;
  private final int MSG_CARD_STATUS_ERROR = 3;
  private final int MSG_CARD_STATUS_NO = 2;
  private final int MSG_CARD_STATUS_OK = 1;
  private final int MSG_LH_RECEIVE_FAIL = 6;
  private final int MSG_LH_RECEIVE_START = 4;
  private final int MSG_LH_RECEIVE_SUCCESS = 5;
  private Dialog dialog = null;
  private int dlgType;
  private byte[] expiredSig;
  private boolean isAlreadyAuthorized = false;
  private boolean isDialogShow;
  private LhHelper lhHelper;
  private String loginAlias = "";
  private int loginRet;
  private String mErrorTitle = "";
  private String mErrorUrl = null;
  private int mErrorVersion = 0;
  private String mForbidStatus = null;
  private boolean mHandleByMiniApp = false;
  private boolean mIsLoginWithMask;
  private boolean mJumpLoginBackFromFund = false;
  private QQProgressDialog mLoadingDialog;
  private int mMiniAppScene;
  private Constants.LogoutReason mReason = Constants.LogoutReason.tips;
  private BroadcastReceiver mReceiver = new NotificationActivity.6(this);
  private int mTipsScenesId;
  private int mUnifyFrozenScene;
  private boolean mUnifyFrozenStyle = false;
  private String msg = null;
  private NotificationActivity.MyClickListener myClickListener = new NotificationActivity.MyClickListener(this);
  private NotificationActivity.MyDialogClickListener receiveClickListener = new NotificationActivity.MyDialogClickListener(this, 1);
  private NotificationActivity.MyDialogClickListener renewalClickListener = new NotificationActivity.MyDialogClickListener(this, 2);
  private String title = null;
  private MqqHandler uiHandler = new MqqHandler(Looper.getMainLooper(), this);
  
  static
  {
    try
    {
      if (QQSecBlockInjectUtil.a.size() > 0)
      {
        sSecControllerInjectInterface = (ISecControllerInterface)((Class)QQSecBlockInjectUtil.a.get(0)).newInstance();
        QLog.d("NotificationActivity", 1, "NotificationActivity newInstance");
      }
    }
    catch (Exception localException)
    {
      QLog.e("NotificationActivity", 1, "NotificationActivity static statement: ", localException);
    }
  }
  
  private void buyoutLh()
  {
    int i = this.lhHelper.b();
    int j = this.lhHelper.a();
    if ((j != -1) && (i != -1))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      gotoPay((String)localObject, "mvip.p.lh.pay_over", bool, false);
      return;
    }
    QQToast.a(this, HardCodeUtil.a(2131707639), 0).a();
    finish();
  }
  
  private void checkSetResult(int paramInt)
  {
    Intent localIntent = getIntent();
    boolean bool;
    if ((localIntent != null) && (localIntent.getBooleanExtra("lh_is_from_login_verify_code", false))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("NotificationActivity", 4, String.format(Locale.getDefault(), "checkSetResult, isFromLH: %s, resultCode: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
    }
    if (bool)
    {
      localIntent = new Intent();
      localIntent.putExtra("lh_is_from_login_verify_code", true);
      setResult(paramInt, localIntent);
    }
  }
  
  private Dialog createDialog()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2131559511);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131365659);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131365658);
    localObject = (TextView)((Window)localObject).findViewById(2131365680);
    if ((localButton1 != null) && (localObject != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131698452));
      localStringBuilder.append("8.7.0");
      localStringBuilder.append(getString(2131698451));
      ((TextView)localObject).setText(localStringBuilder.toString());
      localButton1.setOnClickListener(new NotificationActivity.33(this));
      localButton2.setOnClickListener(new NotificationActivity.34(this));
      return localAlertDialog;
    }
    return null;
  }
  
  private CharSequence getHtmlSpannedText(String paramString, boolean paramBoolean)
  {
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    Object localObject2 = getString(2131698970);
    paramString = getString(2131693856);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("。");
    localObject3 = ((StringBuilder)localObject3).toString();
    int i = ((String)localObject1).length() + ((String)localObject2).length();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append((String)localObject3);
    localObject1 = new SpannableString(((StringBuilder)localObject2).toString());
    ((SpannableString)localObject1).setSpan(new NotificationActivity.32(this, paramBoolean), i, paramString.length() + i, 33);
    ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-11692801), i, paramString.length() + i, 33);
    return localObject1;
  }
  
  private String getTargetUin(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    String str = (String)paramMap.get("uin");
    paramMap = str;
    if (TextUtils.isEmpty(str)) {
      paramMap = this.loginAlias;
    }
    return paramMap;
  }
  
  private void gotoPay(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.expiredSig == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("https://haoma.qq.com/m/expire.html?num=");
      paramString1.append(this.loginAlias);
      paramString1 = paramString1.toString();
      paramString2 = new Intent();
      paramString2.putExtra("url", paramString1);
      RouteUtils.a(this, paramString2, "/base/browser");
      checkSetResult(0);
      finish();
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("unit", HardCodeUtil.a(2131707629));
      localJSONObject.put("userId", this.loginAlias);
      localJSONObject.put("openMonth", paramString1);
      localJSONObject.put("offerId", "1450000833");
      localJSONObject.put("aid", paramString2);
      localJSONObject.put("ticketValue", SecUtil.toHexString(this.expiredSig));
      localJSONObject.put("ticketName", "vask_27");
      localJSONObject.put("isCanChange", paramBoolean2);
      if (paramBoolean1)
      {
        localJSONObject.put("serviceCode", "CJCLUBT");
        localJSONObject.put("serviceName", "QQ超级会员");
      }
      else
      {
        localJSONObject.put("serviceCode", "LTMCLUB");
        localJSONObject.put("serviceName", "QQ会员");
      }
      sSecControllerInjectInterface.a(this, localJSONObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      checkSetResult(0);
      finish();
    }
  }
  
  private void handleFrozenStyle(boolean paramBoolean)
  {
    if (paramBoolean) {
      handleUnifyFrozenStyle();
    } else {
      handleUnUnifyFrozenStyle();
    }
    Dialog localDialog = this.dialog;
    if (localDialog != null) {
      localDialog.setCancelable(true);
    }
  }
  
  private void handleLhExpire()
  {
    ThreadManagerV2.excute(new NotificationActivity.36(this), 16, null, true);
  }
  
  private void handleMiniAppFeature()
  {
    Object localObject = MiniAppSecurityUtil.getArgumentsFromURL(this.mErrorUrl);
    if (localObject == null)
    {
      QLog.e("handleMiniAppFeature", 1, "paramMap == null");
      return;
    }
    String str = (String)((Map)localObject).get("forbid_token");
    this.mForbidStatus = ((String)((Map)localObject).get("forbid_status"));
    if (!TextUtils.isEmpty(str))
    {
      if (this.mErrorVersion != 1) {
        return;
      }
      this.mHandleByMiniApp = true;
      localObject = getTargetUin((Map)localObject);
      MiniAppSecurityUtil.updateLoginMiniAppUin(BaseApplication.getContext(), (String)localObject);
      MiniAppSecurityUtil.updateLoginMiniAppForbidToken(BaseApplication.getContext(), (String)localObject, str);
    }
  }
  
  private void handleUnUnifyFrozenStyle()
  {
    String str3;
    Object localObject;
    String str1;
    String str2;
    if (this.mHandleByMiniApp)
    {
      ReportController.a(getAppRuntime(), "dc00898", "", "", "0X800AA15", "0X800AA15", 0, 0, "", "", this.mForbidStatus, "");
      str3 = this.title;
      if (isIMBlock()) {
        localObject = getHtmlSpannedText(this.msg, true);
      } else {
        localObject = this.msg;
      }
      if (isIMBlock()) {
        str1 = getString(2131693855);
      } else {
        str1 = getString(2131693857);
      }
      if (isIMBlock()) {
        str2 = getString(2131693858);
      } else {
        str2 = getString(2131693856);
      }
      this.dialog = DialogUtil.a(this, 0, str3, (CharSequence)localObject, str1, str2, getString(2131693859), new NotificationActivity.26(this), new NotificationActivity.27(this), new NotificationActivity.28(this));
    }
    else
    {
      str3 = this.title;
      if (isIMBlock()) {
        localObject = getHtmlSpannedText(this.msg, false);
      } else {
        localObject = this.msg;
      }
      if (isIMBlock()) {
        str1 = getString(2131693855);
      } else {
        str1 = getString(2131693860);
      }
      if (isIMBlock()) {
        str2 = getString(2131693858);
      } else {
        str2 = getString(2131693856);
      }
      this.dialog = DialogUtil.a(this, 0, str3, (CharSequence)localObject, str1, str2, getString(2131693859), new NotificationActivity.29(this), new NotificationActivity.30(this), new NotificationActivity.31(this));
    }
    setDialogTextColor((QQCustomDialog)this.dialog);
    if (isIMBlock())
    {
      ((QQCustomDialog)this.dialog).getMessageTextView().setMovementMethod(LinkMovementMethod.getInstance());
      reportIMBlock("0X800B653");
    }
  }
  
  private void handleUnifyFrozenStyle()
  {
    FrozenNotifyDlgHelper.a().a((BaseQQAppInterface)getAppRuntime(), this.mUnifyFrozenScene, 0, this.msg);
    int i = FrozenNotifyDlgHelper.a().a(this.msg, this.mUnifyFrozenScene, 0);
    Object localObject = FrozenNotifyDlgHelper.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.msg);
    localStringBuilder.append("你也可以对帐号进行<TITLE=\"资金管理\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">。");
    localObject = ((FrozenNotifyDlgHelper)localObject).a(localStringBuilder.toString(), this, i);
    if (this.mUnifyFrozenScene == 2) {
      this.mMiniAppScene = 2201;
    }
    i = FrozenNotifyDlgHelper.a().a(this.mUnifyFrozenScene);
    this.dialog = DialogUtil.a(this, 230, this.mErrorTitle, (CharSequence)localObject, 2131690728, i, new NotificationActivity.24(this), new NotificationActivity.25(this));
  }
  
  private void hideProgressDialog()
  {
    QQProgressDialog localQQProgressDialog = this.mLoadingDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.mLoadingDialog.dismiss();
    }
  }
  
  private boolean isIMBlock()
  {
    return this.mTipsScenesId == 1;
  }
  
  private void kickedLogin(boolean paramBoolean)
  {
    Object localObject1 = getAppRuntime().getApplication().getAllAccounts();
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = getAppRuntime().getAccount();
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = (SimpleAccount)((Iterator)localObject3).next();
          if (((String)localObject2).equals(((SimpleAccount)localObject1).getUin())) {
            break label88;
          }
        }
      }
    }
    localObject1 = null;
    label88:
    finish();
    getAppRuntime().setKickIntent(null);
    if (localObject1 != null)
    {
      FrozenKickUtils.a(getApplication().getApplicationContext(), ((SimpleAccount)localObject1).getUin(), true);
      if (paramBoolean)
      {
        new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new NotificationActivity.35(this, (SimpleAccount)localObject1), 500L);
        return;
      }
      getAppRuntime().login((SimpleAccount)localObject1);
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("password", null);
    if (!PhoneNumLoginImpl.a().a(getAppRuntime(), getAppRuntime().getCurrentAccountUin()))
    {
      getAppRuntime().updateSubAccountLogin(getAppRuntime().getCurrentAccountUin(), false);
      getAppRuntime().getApplication().refreAccountList();
    }
    Object localObject2 = sSecControllerInjectInterface.a((BaseQQAppInterface)getAppRuntime());
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (!PhoneNumLoginImpl.a().a(getAppRuntime(), (String)localObject3))
        {
          getAppRuntime().updateSubAccountLogin((String)localObject3, false);
          getAppRuntime().getApplication().refreAccountList();
        }
      }
    }
    RouteUtils.a(this, new Intent().putExtras((Bundle)localObject1).addFlags(67108864), "/base/login");
  }
  
  private void myShowDialog(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("myShowDialog: invoked.  id: ");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 1;
    QLog.i("NotificationActivity", 1, (String)localObject1);
    localObject1 = this.dialog;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
      try
      {
        this.dialog.dismiss();
      }
      catch (Throwable localThrowable)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("myShowDialog: invoked.  throwable: ");
        ((StringBuilder)localObject3).append(localThrowable);
        QLog.i("NotificationActivity", 1, ((StringBuilder)localObject3).toString());
      }
    }
    this.dialog = null;
    Object localObject5;
    String str2;
    String str3;
    Object localObject4;
    switch (paramInt)
    {
    default: 
      break;
    case 11: 
      try
      {
        localObject5 = getIntent().getExtras();
        String str1 = ((Bundle)localObject5).getString("dlg_title", "");
        localObject3 = ((Bundle)localObject5).getString("dlg_content", "");
        str2 = ((Bundle)localObject5).getString("dlg_lbutton", "");
        str3 = ((Bundle)localObject5).getString("dlg_rbutton", "");
        localObject4 = ((Bundle)localObject5).getString("dlg_url", "");
        paramInt = ((Bundle)localObject5).getInt("dlg_lbtnid", 0);
        i = ((Bundle)localObject5).getInt("dlg_rbtnid", 0);
        localObject5 = String.format("%d", new Object[] { Integer.valueOf(((Bundle)localObject5).getInt("dlg_seccmd", 0)) });
        this.dialog = DialogUtil.a(this, 230).setTitle(str1).setMessage((CharSequence)localObject3);
        if (this.dialog != null)
        {
          if (!TextUtils.isEmpty(str3)) {
            ((QQCustomDialog)this.dialog).setPositiveButton(str3, new NotificationActivity.22(this, (String)localObject4, i, (String)localObject5));
          }
          if (!TextUtils.isEmpty(str2)) {
            ((QQCustomDialog)this.dialog).setNegativeButton(str2, new NotificationActivity.23(this, paramInt, (String)localObject5));
          }
          ReportController.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007534", "0X8007534", 0, 0, (String)localObject5, "", "", "");
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    case 10: 
      localObject2 = getResources().getString(2131693901);
      localObject3 = getResources().getString(2131693900);
      str2 = getResources().getString(2131693897);
      str3 = getResources().getString(2131693899);
      localObject5 = getResources().getString(2131693898);
      localObject4 = new CheckBox(this);
      ((CheckBox)localObject4).setText((CharSequence)localObject5);
      ((CheckBox)localObject4).setTextSize(getResources().getInteger(2131427340));
      ((CheckBox)localObject4).setTextColor(getResources().getColor(2131165473));
      localObject5 = getAppRuntime().getApp().getSharedPreferences(getAppRuntime().getAccount(), 0);
      boolean bool = ((SharedPreferences)localObject5).getBoolean("MemoryAlertAutoClear", false);
      ((CheckBox)localObject4).setChecked(bool);
      this.dialog = DialogUtil.a(this, 230).setTitle((String)localObject2).setMessage((CharSequence)localObject3).setView((View)localObject4).setPositiveButton(str3, new NotificationActivity.21(this, (CheckBox)localObject4, bool, (SharedPreferences)localObject5)).setNegativeButton(str2, new NotificationActivity.20(this, (CheckBox)localObject4, bool, (SharedPreferences)localObject5));
      break;
    case 9: 
      localObject4 = getIntent().getExtras();
      localObject2 = ((Bundle)localObject4).getString("dlg_title");
      localObject3 = ((Bundle)localObject4).getString("dlg_content");
      str2 = ((Bundle)localObject4).getString("dlg_lbutton");
      str3 = ((Bundle)localObject4).getString("dlg_rbutton");
      localObject4 = ((Bundle)localObject4).getString("dlg_url");
      this.dialog = DialogUtil.a(this, 230).setTitle((String)localObject2).setMessage((CharSequence)localObject3).setPositiveButton(str3, new NotificationActivity.19(this, (String)localObject4)).setNegativeButton(str2, new NotificationActivity.18(this));
      break;
    case 8: 
      paramInt = this.loginRet;
      if (paramInt == 40)
      {
        ReportController.a(getAppRuntime(), "dc00898", "", this.loginAlias, "0X800AA2F", "0X800AA2F", 0, 0, "", "", "", this.msg);
        localObject2 = getIntent();
        if (localObject2 != null)
        {
          parseIntentErrorData((Intent)localObject2);
          handleFrozenStyle(this.mUnifyFrozenStyle);
        }
      }
      else if ((paramInt != 41) && (paramInt != 116))
      {
        this.dialog = DialogUtil.b(this, 230).setMessageWithUrl(this.msg).setTitle(getString(2131699208)).setPositiveButton(17039370, new NotificationActivity.17(this));
      }
      else
      {
        localObject2 = (Long)LhHelper.a.get(this.loginAlias);
        if ((localObject2 != null) && (System.currentTimeMillis() - ((Long)localObject2).longValue() < 30000L)) {
          this.dialog = DialogUtil.a(this, 230).setTitle(HardCodeUtil.a(2131707628)).setMessage(HardCodeUtil.a(2131707626)).setNegativeButton(HardCodeUtil.a(2131707635), new NotificationActivity.16(this));
        } else {
          handleLhExpire();
        }
      }
      break;
    case 7: 
      this.dialog = DialogUtil.a(this, 230).setTitle(getString(2131693853)).setMessage(getString(2131718686)).setPositiveButton(getString(2131718688), new NotificationActivity.15(this)).setNegativeButton(getString(2131718685), new NotificationActivity.14(this));
      break;
    case 6: 
      this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new NotificationActivity.12(this));
      break;
    case 5: 
      if ((TextUtils.isEmpty(this.msg)) && (TextUtils.isEmpty(this.title)))
      {
        localObject2 = getAppRuntime().getKickIntent();
        if (localObject2 != null)
        {
          this.title = ((Intent)localObject2).getStringExtra("title");
          this.msg = ((Intent)localObject2).getStringExtra("msg");
          this.mReason = ((Constants.LogoutReason)((Intent)localObject2).getSerializableExtra("reason"));
        }
      }
      sSecControllerInjectInterface.a(this, true, true);
      if (this.mReason != Constants.LogoutReason.kicked) {
        i = 2131694506;
      } else {
        i = 2131694583;
      }
      if (FrozenNotifyDlgHelper.a().a(this.msg))
      {
        ReportController.a(null, "dc00898", "", "", "0X800B427", "0X800B427", 0, 0, "", "", "", "");
        paramInt = 1;
      }
      else
      {
        paramInt = 0;
      }
      if (FrozenNotifyDlgHelper.a().b(this.msg))
      {
        ReportController.a(null, "dc00898", "", "", "0X800B5E4", "0X800B5E4", 0, 0, "", "", "", "");
        paramInt = 4;
      }
      localObject2 = FrozenNotifyDlgHelper.a().a(this.msg, this, paramInt);
      this.dialog = DialogUtil.a(this, 230, this.title, (CharSequence)localObject2, i, 2131694583, null, new NotificationActivity.10(this));
      if (this.mReason != Constants.LogoutReason.kicked) {
        if ((getIntent() != null) && (getIntent().getBooleanExtra("isSameDevice", false)) && (!isInMultiWindow()))
        {
          this.dialog = null;
          kickedLogin(true);
        }
        else
        {
          ((QQCustomDialog)this.dialog).setPositiveButton(2131692641, new NotificationActivity.11(this));
          localObject2 = new Intent("com.tencent.tim.kickedLogin.otherDevice");
          ((Intent)localObject2).putExtra("kickedUin", getAppRuntime().getAccount());
          ((Intent)localObject2).putExtra("msg", this.msg);
          ((Intent)localObject2).setPackage("com.tencent.tim");
          sendBroadcast((Intent)localObject2);
        }
      }
      getAppRuntime().setKickIntent(null);
      break;
    case 4: 
      this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new NotificationActivity.13(this));
      break;
    }
    try
    {
      this.dialog = createDialog();
    }
    catch (Exception localException2)
    {
      label1508:
      break label1508;
    }
    exitApp();
    break label1833;
    Object localObject2 = new TextView(this);
    ((TextView)localObject2).setLinksClickable(true);
    ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
    ((TextView)localObject2).setTextSize(getResources().getInteger(2131427340));
    ((TextView)localObject2).setTextColor(getResources().getColor(2131165473));
    Object localObject3 = this.title;
    if ((localObject3 != null) && (((String)localObject3).equals("true"))) {
      try
      {
        localObject3 = getPackageName();
        ((TextView)localObject2).setText(this.msg);
        this.dialog = DialogUtil.a(this, 230).setMessage(this.msg).addView((View)localObject2).setPositiveButton(2131699830, new NotificationActivity.8(this, (String)localObject3), false);
        paramInt = i;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      if (!TextUtils.isEmpty(this.msg)) {
        ((TextView)localObject2).setText(Html.fromHtml(this.msg));
      } else {
        ((TextView)localObject2).setText(Html.fromHtml(getString(2131692996)));
      }
      this.dialog = DialogUtil.a(this, 230).setMessage(this.msg).addView((View)localObject2).setPositiveButton(2131692081, new NotificationActivity.9(this));
      break label1833;
      ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
      this.title = getString(2131719311);
      this.msg = getString(2131719310);
      this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new NotificationActivity.7(this));
    }
    label1833:
    sendBroadcast(new Intent("before_account_change"));
    showDialog(false);
  }
  
  private void parseIntentErrorData(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.e("parseIntentErrorData", 1, "loginFailedIntent == null");
      return;
    }
    this.mErrorUrl = "";
    this.mErrorVersion = 0;
    this.mForbidStatus = "";
    this.mHandleByMiniApp = false;
    this.mUnifyFrozenStyle = false;
    this.mErrorTitle = "";
    this.mUnifyFrozenScene = -1;
    this.mMiniAppScene = 2098;
    if (paramIntent.getBooleanExtra("keyFromLoginView", false)) {
      ReportController.a(getAppRuntime(), "dc00898", "", "", "0X800B292", "0X800B292", 0, 0, "", "", this.msg, "");
    } else if (paramIntent.getBooleanExtra("keyFromAddAccount", false)) {
      ReportController.a(getAppRuntime(), "dc00898", "", "", "0X800B294", "0X800B294", 0, 0, "", "", this.msg, "");
    } else if (paramIntent.getBooleanExtra("keyFromBindAccount", false)) {
      ReportController.a(getAppRuntime(), "dc00898", "", "", "0X800B296", "0X800B296", 0, 0, "", "", this.msg, "");
    }
    this.mErrorUrl = paramIntent.getStringExtra("errorUrl");
    this.mErrorVersion = paramIntent.getIntExtra("errorver", 0);
    this.mIsLoginWithMask = paramIntent.getBooleanExtra("is_need_login_with_mask", false);
    this.mUnifyFrozenStyle = FrozenNotifyDlgHelper.a().a(paramIntent.getByteArrayExtra("tlverror"));
    this.mErrorTitle = paramIntent.getStringExtra("errortitle");
    this.mUnifyFrozenScene = FrozenNotifyDlgHelper.a().a(paramIntent.getByteArrayExtra("tlverror"));
    if (!TextUtils.isEmpty(this.mErrorUrl)) {
      handleMiniAppFeature();
    }
  }
  
  private void payExpiredAccount(int paramInt)
  {
    if ((paramInt != 41) && (paramInt != 116)) {
      return;
    }
    boolean bool;
    if (paramInt == 116) {
      bool = true;
    } else {
      bool = false;
    }
    gotoPay("3", "mvip.gongneng.android.haoma_03", bool, true);
  }
  
  private void receiveLhCard()
  {
    ThreadManagerV2.excute(new NotificationActivity.39(this), 16, null, true);
  }
  
  private void reportIMBlock(String paramString)
  {
    if (isIMBlock())
    {
      Object localObject = getIntent();
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((Intent)localObject).getStringExtra("uin");
      }
      ReportController.b(null, "dc00898", "", (String)localObject, paramString, paramString, 0, 0, "", "", this.msg, "");
    }
  }
  
  private void sendAccountBroadcast()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
    getAppRuntime().getApp().sendBroadcast(localIntent);
  }
  
  private void setDialogTextColor(QQCustomDialog paramQQCustomDialog)
  {
    if (!"1103".equals(ThemeUtil.getCurrentThemeId())) {
      return;
    }
    TextView localTextView1 = paramQQCustomDialog.getTitleTextView();
    TextView localTextView2 = paramQQCustomDialog.getMessageTextView();
    TextView localTextView3 = paramQQCustomDialog.getBtnLeft();
    TextView localTextView4 = paramQQCustomDialog.getBtnight();
    paramQQCustomDialog = (TextView)paramQQCustomDialog.findViewById(2131365623);
    try
    {
      int i = Color.parseColor("#FFFFFF");
      setTextColor(i, new TextView[] { localTextView1, localTextView2, localTextView3, localTextView4, paramQQCustomDialog });
      return;
    }
    catch (Exception paramQQCustomDialog)
    {
      QLog.e("NotificationActivity", 1, "setDialogTextColor: parseColor error", paramQQCustomDialog);
    }
  }
  
  private void setTextColor(int paramInt, TextView... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      TextView localTextView = paramVarArgs[i];
      if (localTextView != null) {
        localTextView.setTextColor(paramInt);
      }
      i += 1;
    }
  }
  
  private void showDialog(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showDialog: invoked.  inResume: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" isDialogShow: ");
    ((StringBuilder)localObject).append(this.isDialogShow);
    QLog.i("NotificationActivity", 1, ((StringBuilder)localObject).toString());
    if (this.isDialogShow) {
      return;
    }
    if ((!paramBoolean) && (Build.VERSION.SDK_INT >= 28)) {
      return;
    }
    localObject = this.dialog;
    if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!isFinishing()))
    {
      if ((this.dlgType == 8) && (this.loginRet == 40))
      {
        this.dialog.setCancelable(true);
        this.dialog.setOnCancelListener(new NotificationActivity.5(this));
      }
      else
      {
        this.dialog.setCancelable(false);
      }
      try
      {
        this.dialog.show();
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showDialog: invoked.  t: ");
        localStringBuilder.append(localThrowable);
        QLog.i("NotificationActivity", 1, localStringBuilder.toString());
      }
      this.isDialogShow = true;
    }
  }
  
  private void showProgressDialog()
  {
    if (this.mLoadingDialog == null) {
      this.mLoadingDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    if (!this.mLoadingDialog.isShowing())
    {
      this.mLoadingDialog.a(HardCodeUtil.a(2131707630));
      this.mLoadingDialog.show();
    }
  }
  
  private void stopUpgrade()
  {
    sSecControllerInjectInterface.a((BaseQQAppInterface)getAppRuntime());
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
      if (Utils.a(paramIntent) == 0) {
        paramInt1 = -1;
      } else {
        paramInt1 = 0;
      }
      checkSetResult(paramInt1);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559505);
    Object localObject = "";
    paramBundle = (Bundle)localObject;
    try
    {
      this.dlgType = getIntent().getIntExtra("type", 0);
      paramBundle = (Bundle)localObject;
      String str1 = getIntent().getAction();
      paramBundle = str1;
      if (QLog.isColorLevel())
      {
        paramBundle = str1;
        localObject = new StringBuilder();
        paramBundle = str1;
        ((StringBuilder)localObject).append("NotificationActivity action = ");
        paramBundle = str1;
        ((StringBuilder)localObject).append(str1);
        paramBundle = str1;
        QLog.d("NotificationActivity", 2, ((StringBuilder)localObject).toString());
      }
      paramBundle = str1;
      if ("mqq.intent.action.ACCOUNT_EXPIRED".equals(str1))
      {
        paramBundle = str1;
        this.dlgType = 1;
        paramBundle = str1;
        stopUpgrade();
      }
      else
      {
        paramBundle = str1;
        if ("mqq.intent.action.ACCOUNT_TIPS".equals(str1))
        {
          paramBundle = str1;
          this.dlgType = 6;
        }
        else
        {
          paramBundle = str1;
          if ("mqq.intent.action.ACCOUNT_KICKED".equals(str1))
          {
            paramBundle = str1;
            sendAccountBroadcast();
            paramBundle = str1;
            stopUpgrade();
            paramBundle = str1;
            this.dlgType = 5;
          }
          else
          {
            paramBundle = str1;
            if ("mqq.intent.action.GRAY".equals(str1))
            {
              paramBundle = str1;
              this.dlgType = 2;
            }
            else
            {
              paramBundle = str1;
              if ("mqq.intent.action.SUSPEND".equals(str1))
              {
                paramBundle = str1;
                this.dlgType = 4;
              }
            }
          }
        }
      }
      paramBundle = str1;
      this.title = getIntent().getStringExtra("title");
      paramBundle = str1;
      this.msg = getIntent().getStringExtra("msg");
      paramBundle = str1;
      this.loginAlias = getIntent().getStringExtra("loginalias");
      paramBundle = str1;
      this.expiredSig = getIntent().getByteArrayExtra("expiredSig");
      paramBundle = str1;
      this.loginRet = getIntent().getIntExtra("loginret", 0);
      paramBundle = str1;
      this.mTipsScenesId = getIntent().getIntExtra("keyTipsScenesId", 0);
      paramBundle = str1;
      this.mReason = ((Constants.LogoutReason)getIntent().getSerializableExtra("reason"));
      paramBundle = str1;
      String str2 = getIntent().getStringExtra("securityScan");
      localObject = str1;
      if (str2 != null)
      {
        paramBundle = str1;
        localObject = str1;
        if ("security_scan".equals(str2))
        {
          paramBundle = str1;
          this.dlgType = 7;
          localObject = str1;
        }
      }
    }
    catch (Exception localException)
    {
      localObject = paramBundle;
      if (QLog.isColorLevel())
      {
        QLog.e("NotificationActivity", 2, "doOnCreate exception", localException);
        localObject = paramBundle;
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("notification activity type:");
    paramBundle.append(this.dlgType);
    QLog.d("NotificationActivity", 1, paramBundle.toString());
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(localObject))
    {
      if (this.mReason == Constants.LogoutReason.secKicked)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:sec kick");
        }
        localObject = getIntent().getByteArrayExtra("data");
        paramBundle = new signature.SignatureKickData();
        try
        {
          paramBundle.mergeFrom((byte[])localObject);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (!paramBundle.has()) {
          return false;
        }
        if ((paramBundle.str_packname.has()) && (paramBundle.u32_check_result.has()) && (paramBundle.str_right_button.has()) && (paramBundle.str_url.has()))
        {
          ThreadManager.post(new NotificationActivity.2(this, paramBundle.u32_check_result.get(), paramBundle.u32_cache_time.get()), 5, null, false);
          this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(paramBundle.str_right_button.get(), new NotificationActivity.3(this, paramBundle));
          if (paramBundle.str_left_button.has()) {
            ((QQCustomDialog)this.dialog).setNegativeButton(paramBundle.str_left_button.get(), new NotificationActivity.4(this));
          }
          showDialog(false);
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
        }
        return false;
      }
      sSecControllerInjectInterface.a(this, getAppRuntime().getAccount());
    }
    this.lhHelper = new LhHelper(this.loginAlias);
    myShowDialog(this.dlgType);
    registerReceiver(this.mReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
    return true;
  }
  
  protected void doOnDestroy()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("doOnDestroy: invoked.  isDialogShow: ");
    localStringBuilder1.append(this.isDialogShow);
    QLog.i("NotificationActivity", 1, localStringBuilder1.toString());
    try
    {
      unregisterReceiver(this.mReceiver);
    }
    catch (Throwable localThrowable1)
    {
      localThrowable1.printStackTrace();
    }
    Dialog localDialog = this.dialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      try
      {
        this.dialog.dismiss();
      }
      catch (Throwable localThrowable2)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("doOnDestroy: invoked.  t: ");
        localStringBuilder2.append(localThrowable2);
        QLog.i("NotificationActivity", 1, localStringBuilder2.toString());
      }
    }
    this.dialog = null;
    super.doOnDestroy();
    if (instance == this) {
      instance = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    showDialog(true);
    if (this.isAlreadyAuthorized)
    {
      Dialog localDialog = this.dialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        ((QQCustomDialog)this.dialog).setPositiveButton(2131699829, new NotificationActivity.1(this));
      }
    }
    if ((this.mJumpLoginBackFromFund) && (this.dlgType == 5))
    {
      this.mJumpLoginBackFromFund = false;
      kickToLoginActivity();
    }
  }
  
  protected void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
    if (this.dlgType == 3) {
      exitApp();
    }
  }
  
  public void enableJumpLoginFromFund()
  {
    this.mJumpLoginBackFromFund = true;
  }
  
  public void exitApp()
  {
    sSecControllerInjectInterface.a(this, false, false);
    finish();
    if (getAppRuntime() != null) {
      getAppRuntime().exit(false);
    }
  }
  
  public void finish()
  {
    Dialog localDialog = this.dialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.dialog.dismiss();
    }
    this.dialog = null;
    super.finish();
    if (instance == this) {
      instance = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 6: 
      hideProgressDialog();
      QQToast.a(this, 1, HardCodeUtil.a(2131707632), 0).b(getTitleBarHeight());
      finish();
      return true;
    case 5: 
      hideProgressDialog();
      QQToast.a(this, 2, HardCodeUtil.a(2131707633), 0).b(getTitleBarHeight());
      LhHelper.a.put(this.loginAlias, Long.valueOf(System.currentTimeMillis()));
      finish();
      return true;
    case 4: 
      showProgressDialog();
      return true;
    case 3: 
      int i;
      if (this.loginRet == 41) {
        i = 2131694992;
      } else {
        i = 2131694991;
      }
      paramMessage = getString(i);
      String str = getString(2131694990);
      this.dialog = DialogUtil.a(this, 230).setMessage(paramMessage).setTitle(str).setNegativeButton(2131694989, new NotificationActivity.38(this)).setPositiveButton(2131694988, new NotificationActivity.37(this));
      this.dialog.setCancelable(false);
      this.dialog.show();
      return true;
    case 2: 
      this.dialog = DialogUtil.a(this, getResources().getString(2131693613), getResources().getString(2131693602), getResources().getString(2131693600), this.renewalClickListener, getResources().getString(2131693598), this.renewalClickListener, this.myClickListener);
      this.dialog.show();
      return true;
    }
    this.dialog = DialogUtil.a(this, getResources().getString(2131693613), getResources().getString(2131693603), getResources().getString(2131693599), this.receiveClickListener, HardCodeUtil.a(2131707638), this.receiveClickListener, this.myClickListener);
    this.dialog.show();
    return true;
  }
  
  public void kickToLoginActivity()
  {
    if (FrozenNotifyDlgHelper.a().a(this.msg)) {
      ReportController.a(null, "dc00898", "", "", "0X800B42A", "0X800B42A", 0, 0, "", "", "", "");
    }
    if (FrozenNotifyDlgHelper.a().b(this.msg)) {
      ReportController.a(null, "dc00898", "", "", "0X800B5E6", "0X800B5E6", 0, 0, "", "", "", "");
    }
    finish();
    Bundle localBundle = new Bundle();
    localBundle.putString("password", null);
    localBundle.putBoolean("is_from_account_another_login_exit", true);
    if (!PhoneNumLoginImpl.a().a(getAppRuntime(), getAppRuntime().getCurrentAccountUin()))
    {
      getAppRuntime().updateSubAccountLogin(getAppRuntime().getCurrentAccountUin(), false);
      getAppRuntime().getApplication().refreAccountList();
    }
    Object localObject = sSecControllerInjectInterface.a((BaseQQAppInterface)getAppRuntime());
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!PhoneNumLoginImpl.a().a(getAppRuntime(), str))
        {
          getAppRuntime().updateSubAccountLogin(str, false);
          getAppRuntime().getApplication().refreAccountList();
        }
      }
    }
    RouteUtils.a(this, new Intent().putExtras(localBundle).addFlags(67108864), "/base/login");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    instance = this;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */