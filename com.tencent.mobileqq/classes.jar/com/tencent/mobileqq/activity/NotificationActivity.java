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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.LhHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.PatternLockUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@RoutePage(desc="通知类弹框activity", path="/base/notification")
public class NotificationActivity
  extends BaseActivity
  implements Handler.Callback
{
  private static final String DEFAULT_NIGHT_COLOR = "#FFFFFF";
  public static final String DEFAULT_UNBLOCK_URL = "https://accounts.qq.com/007";
  public static final int DIALOG_ACCOUNT_EXCEPTION_ALERT = 11;
  public static final int DIALOG_ANOTHER_TERMINAL_LOGIN = 5;
  public static final int DIALOG_CRASH = 3;
  public static final int DIALOG_GRAY = 2;
  public static final int DIALOG_IDENTITY_EXPIRED = 1;
  public static final int DIALOG_LOGIN_FAILED = 8;
  public static final int DIALOG_MEMORY_ALERT = 10;
  public static final int DIALOG_PACKAGE_INVALID = 9;
  public static final int DIALOG_SDK_SUSPENDED = 4;
  public static final int DIALOG_SECURITY_SCAN = 7;
  public static final int DIALOG_SSO_TIPS = 6;
  public static final String FUND_PROTECT_TAG_URL = "你也可以对帐号进行<TITLE=\"资金管理\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">。";
  public static final String FUND_PROTECT_URL = "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027";
  public static final String KEY_ALIAS = "alias";
  public static final String KEY_ERROR = "error";
  public static final String KEY_ERROR_TITLE = "errortitle";
  public static final String KEY_ERROR_URL = "errorUrl";
  public static final String KEY_ERROR_VER = "errorver";
  public static final String KEY_FROM_ADD_ACCOUNT = "keyFromAddAccount";
  public static final String KEY_FROM_LOGIN_VIEW = "keyFromLoginView";
  public static final String KEY_IS_FROM_LH_LOGIN_VERIFY_CODE = "lh_is_from_login_verify_code";
  public static final String KEY_LAST_ERROR = "lastError";
  public static final String KEY_LOGIN_ALIAS = "loginalias";
  public static final String KEY_LOGIN_RET = "loginret";
  public static final String KEY_MSG = "msg";
  public static final String KEY_RET = "ret";
  public static final String KEY_TIPS_SCENES_ID = "keyTipsScenesId";
  public static final String KEY_TLV_ERROR = "tlverror";
  public static final String KEY_TYPE = "type";
  private static final int LOGIN_FAILED_CODE = 40;
  public static final String MSG = "msg";
  public static final String PASSWORD = "password";
  public static final String REASON = "reason";
  private static final String REPORT_TVALUE_NOTIFICATION_LOGIN_SHEET_CANCEL_CLICK = "0X800AA32";
  private static final String REPORT_TVALUE_NOTIFICATION_LOGIN_SHEET_FUND_CLICK = "0X800AA31";
  private static final String REPORT_TVALUE_NOTIFICATION_LOGIN_SHEET_SHOW = "0X800AA2F";
  private static final String REPORT_TVALUE_NOTIFICATION_LOGIN_SHEET_UNBLOCK_CLICK = "0X800AA30";
  public static final ArrayList<String> REPORT_TVALUE_NOTIFICATION_LOGIN_TVALUES = new ArrayList(Arrays.asList(new String[] { "0X800AA2F", "0X800AA30", "0X800AA31", "0X800AA32" }));
  private static final String SEC_TAG = "sec_sig_tag";
  private static final String TAG = "NotificationActivity";
  private static final int TIPS_SENEDES_ID_DEFAULT = 0;
  public static final String TITLE = "title";
  public static NotificationActivity instance = null;
  private final String LH_PAY_SN = "lhPaySn";
  private final int MSG_CARD_STATUS_ERROR = 3;
  private final int MSG_CARD_STATUS_NO = 2;
  private final int MSG_CARD_STATUS_OK = 1;
  private final int MSG_LH_RECEIVE_FAIL = 6;
  private final int MSG_LH_RECEIVE_START = 4;
  private final int MSG_LH_RECEIVE_SUCCESS = 5;
  private final int REQ_CODE_PAY = 1;
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
  
  private void buyoutLh()
  {
    int i = this.lhHelper.b();
    int j = this.lhHelper.a();
    if ((j == -1) || (i == -1))
    {
      QQToast.a(this, HardCodeUtil.a(2131707614), 0).a();
      finish();
      return;
    }
    String str = j + "";
    if (i == 2) {}
    for (boolean bool = true;; bool = false)
    {
      gotoPay(str, "mvip.p.lh.pay_over", bool, false);
      return;
    }
  }
  
  private void checkSetResult(int paramInt)
  {
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("lh_is_from_login_verify_code", false))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("NotificationActivity", 4, String.format(Locale.getDefault(), "checkSetResult, isFromLH: %s, resultCode: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) }));
      }
      if (bool)
      {
        localIntent = new Intent();
        localIntent.putExtra("lh_is_from_login_verify_code", true);
        setResult(paramInt, localIntent);
      }
      return;
    }
  }
  
  private Dialog createDialog()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2131559634);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131365822);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131365821);
    localObject = (TextView)((Window)localObject).findViewById(2131365844);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131698387) + "8.5.5" + getString(2131698386));
    localButton1.setOnClickListener(new NotificationActivity.33(this));
    localButton2.setOnClickListener(new NotificationActivity.34(this));
    return localAlertDialog;
  }
  
  private CharSequence getHtmlSpannedText(String paramString, boolean paramBoolean)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    String str1 = getString(2131698891);
    paramString = getString(2131693902);
    String str2 = str1 + paramString + "。";
    int i = ((String)localObject).length();
    i = str1.length() + i;
    localObject = new SpannableString((String)localObject + str2);
    ((SpannableString)localObject).setSpan(new NotificationActivity.32(this, paramBoolean), i, paramString.length() + i, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-11692801), i, paramString.length() + i, 33);
    return localObject;
  }
  
  private String getTargetUin(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      paramMap = "";
    }
    String str;
    do
    {
      return paramMap;
      str = (String)paramMap.get("uin");
      paramMap = str;
    } while (!TextUtils.isEmpty(str));
    return this.loginAlias;
  }
  
  private void gotoPay(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.expiredSig == null)
    {
      paramString1 = "https://haoma.qq.com/m/expire.html?num=" + this.loginAlias;
      paramString2 = new Intent(this, QQBrowserActivity.class);
      paramString2.putExtra("url", paramString1);
      startActivity(paramString2);
      checkSetResult(0);
      finish();
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("unit", HardCodeUtil.a(2131707604));
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
          paramString1 = new Intent(this, PayBridgeActivity.class);
          paramString2 = new Bundle();
          paramString2.putString("json", localJSONObject.toString());
          paramString2.putString("callbackSn", "lhPaySn");
          paramString1.putExtras(paramString2);
          paramString1.putExtra("payparmas_from_is_login_state", false);
          paramString1.putExtra("pay_requestcode", 4);
          startActivityForResult(paramString1, 1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        checkSetResult(0);
        finish();
        return;
      }
      localJSONObject.put("serviceCode", "LTMCLUB");
      localJSONObject.put("serviceName", "QQ会员");
    }
  }
  
  private void handleFrozenStyle(boolean paramBoolean)
  {
    if (paramBoolean) {
      handleUnifyFrozenStyle();
    }
    for (;;)
    {
      if (this.dialog != null) {
        this.dialog.setCancelable(true);
      }
      return;
      handleUnUnifyFrozenStyle();
    }
  }
  
  private void handleLhExpire()
  {
    ThreadManagerV2.excute(new NotificationActivity.36(this), 16, null, true);
  }
  
  private void handleMiniAppFeature()
  {
    Object localObject = MiniAppSecurityUtil.getArgumentsFromURL(this.mErrorUrl);
    if (localObject == null) {
      QLog.e("handleMiniAppFeature", 1, "paramMap == null");
    }
    String str;
    do
    {
      return;
      str = (String)((Map)localObject).get("forbid_token");
      this.mForbidStatus = ((String)((Map)localObject).get("forbid_status"));
    } while ((TextUtils.isEmpty(str)) || (this.mErrorVersion != 1));
    this.mHandleByMiniApp = true;
    localObject = getTargetUin((Map)localObject);
    MiniAppSecurityUtil.updateLoginMiniAppUin(BaseApplicationImpl.sApplication, (String)localObject);
    MiniAppSecurityUtil.updateLoginMiniAppForbidToken(BaseApplicationImpl.sApplication, (String)localObject, str);
  }
  
  private void handleUnUnifyFrozenStyle()
  {
    Object localObject;
    String str1;
    if (this.mHandleByMiniApp)
    {
      ReportController.a(this.app, "dc00898", "", "", "0X800AA15", "0X800AA15", 0, 0, "", "", this.mForbidStatus, "");
      str3 = this.title;
      if (isIMBlock())
      {
        localObject = getHtmlSpannedText(this.msg, true);
        if (!isIMBlock()) {
          break label187;
        }
        str1 = getString(2131693901);
        label77:
        if (!isIMBlock()) {
          break label198;
        }
      }
      label187:
      label198:
      for (str2 = getString(2131693904);; str2 = getString(2131693902))
      {
        this.dialog = DialogUtil.a(this, 0, str3, (CharSequence)localObject, str1, str2, getString(2131693905), new NotificationActivity.26(this), new NotificationActivity.27(this), new NotificationActivity.28(this));
        setDialogTextColor((QQCustomDialog)this.dialog);
        if (isIMBlock())
        {
          ((QQCustomDialog)this.dialog).getMessageTextView().setMovementMethod(LinkMovementMethod.getInstance());
          reportIMBlock("0X800B653");
        }
        return;
        localObject = this.msg;
        break;
        str1 = getString(2131693903);
        break label77;
      }
    }
    String str3 = this.title;
    if (isIMBlock())
    {
      localObject = getHtmlSpannedText(this.msg, false);
      label232:
      if (!isIMBlock()) {
        break label318;
      }
      str1 = getString(2131693901);
      label247:
      if (!isIMBlock()) {
        break label329;
      }
    }
    label318:
    label329:
    for (String str2 = getString(2131693904);; str2 = getString(2131693902))
    {
      this.dialog = DialogUtil.a(this, 0, str3, (CharSequence)localObject, str1, str2, getString(2131693905), new NotificationActivity.29(this), new NotificationActivity.30(this), new NotificationActivity.31(this));
      break;
      localObject = this.msg;
      break label232;
      str1 = getString(2131693906);
      break label247;
    }
  }
  
  private void handleUnifyFrozenStyle()
  {
    FrozenNotifyDlgHelper.a().a(this.app, this.mUnifyFrozenScene, 0, this.msg);
    int i = FrozenNotifyDlgHelper.a().a(this.msg, this.mUnifyFrozenScene, 0);
    CharSequence localCharSequence = FrozenNotifyDlgHelper.a().a(this.msg + "你也可以对帐号进行<TITLE=\"资金管理\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">。", this, i);
    if (this.mUnifyFrozenScene == 2) {
      this.mMiniAppScene = 2201;
    }
    i = FrozenNotifyDlgHelper.a().a(this.mUnifyFrozenScene);
    this.dialog = DialogUtil.a(this, 230, this.mErrorTitle, localCharSequence, 2131690800, i, new NotificationActivity.24(this), new NotificationActivity.25(this));
  }
  
  private void hideProgressDialog()
  {
    if ((this.mLoadingDialog != null) && (this.mLoadingDialog.isShowing())) {
      this.mLoadingDialog.dismiss();
    }
  }
  
  private boolean isIMBlock()
  {
    return this.mTipsScenesId == 1;
  }
  
  private void kickedLogin(boolean paramBoolean)
  {
    String str = null;
    Object localObject1 = this.app.getApplication().getAllAccounts();
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = this.app.getAccount();
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject3 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (SimpleAccount)((Iterator)localObject3).next();
        } while (!((String)localObject2).equals(((SimpleAccount)localObject1).getUin()));
      }
    }
    for (;;)
    {
      finish();
      this.app.setKickIntent(null);
      if (localObject1 != null)
      {
        SharedPreUtils.a(getApplication().getApplicationContext(), ((SimpleAccount)localObject1).getUin(), true);
        if (paramBoolean)
        {
          new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new NotificationActivity.35(this, (SimpleAccount)localObject1), 500L);
          return;
        }
        this.app.login((SimpleAccount)localObject1);
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("password", null);
      if (!PhoneNumLoginImpl.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        this.app.updateSubAccountLogin(this.app.getCurrentAccountUin(), false);
        this.app.getApplication().refreAccountList();
      }
      localObject3 = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      localObject1 = str;
      if (localObject3 != null) {
        localObject1 = ((SubAccountManager)localObject3).a();
      }
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          str = (String)((Iterator)localObject1).next();
          if (!PhoneNumLoginImpl.a().a(this.app, str))
          {
            this.app.updateSubAccountLogin(str, false);
            this.app.getApplication().refreAccountList();
          }
        }
      }
      RouteUtils.a(this, new Intent().putExtras((Bundle)localObject2).addFlags(67108864), "/base/login");
      return;
      localObject1 = null;
    }
  }
  
  private void myShowDialog(int paramInt)
  {
    QLog.i("NotificationActivity", 1, "myShowDialog: invoked.  id: " + paramInt);
    if ((this.dialog != null) && (this.dialog.isShowing())) {}
    label469:
    Object localObject1;
    try
    {
      this.dialog.dismiss();
      this.dialog = null;
      switch (paramInt)
      {
      default: 
        sendBroadcast(new Intent("before_account_change"));
        showDialog(false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("NotificationActivity", 1, "myShowDialog: invoked.  throwable: " + localThrowable);
        continue;
        ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
        this.title = getString(2131719592);
        this.msg = getString(2131719591);
        this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new NotificationActivity.7(this));
        continue;
        TextView localTextView = new TextView(this);
        localTextView.setLinksClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setTextSize(getResources().getInteger(2131427336));
        localTextView.setTextColor(getResources().getColor(2131165497));
        if ((this.title != null) && (this.title.equals("true"))) {}
        for (;;)
        {
          try
          {
            String str1 = getPackageName();
            localTextView.setText(this.msg);
            this.dialog = DialogUtil.a(this, 230).setMessage(this.msg).addView(localTextView).setPositiveButton(2131699697, new NotificationActivity.8(this, str1), false);
            paramInt = 1;
            if (paramInt != 0) {
              break;
            }
            if (TextUtils.isEmpty(this.msg)) {
              break label469;
            }
            localTextView.setText(Html.fromHtml(this.msg));
            this.dialog = DialogUtil.a(this, 230).setMessage(this.msg).addView(localTextView).setPositiveButton(2131692161, new NotificationActivity.9(this));
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
          paramInt = 0;
          continue;
          localTextView.setText(Html.fromHtml(getString(2131693036)));
        }
        try
        {
          this.dialog = createDialog();
        }
        catch (Exception localException1)
        {
          exitApp();
        }
      }
      if ((TextUtils.isEmpty(this.msg)) && (TextUtils.isEmpty(this.title)))
      {
        localObject1 = this.app.getKickIntent();
        if (localObject1 != null)
        {
          this.title = ((Intent)localObject1).getStringExtra("title");
          this.msg = ((Intent)localObject1).getStringExtra("msg");
          this.mReason = ((Constants.LogoutReason)((Intent)localObject1).getSerializableExtra("reason"));
        }
      }
      if (QQPlayerService.a()) {
        sendBroadcast(new Intent("qqplayer_exit_action"));
      }
      GameRoomAVController.a().d();
      if (this.mReason == Constants.LogoutReason.kicked) {}
    }
    for (int i = 2131694541;; i = 2131694615)
    {
      for (;;)
      {
        paramInt = 0;
        if (FrozenNotifyDlgHelper.a().a(this.msg))
        {
          ReportController.a(null, "dc00898", "", "", "0X800B427", "0X800B427", 0, 0, "", "", "", "");
          paramInt = 1;
        }
        if (FrozenNotifyDlgHelper.a().b(this.msg))
        {
          ReportController.a(null, "dc00898", "", "", "0X800B5E4", "0X800B5E4", 0, 0, "", "", "", "");
          paramInt = 4;
        }
        localObject1 = FrozenNotifyDlgHelper.a().a(this.msg, this, paramInt);
        this.dialog = DialogUtil.a(this, 230, this.title, (CharSequence)localObject1, i, 2131694615, null, new NotificationActivity.10(this));
        if (this.mReason != Constants.LogoutReason.kicked)
        {
          if ((getIntent() == null) || (!getIntent().getBooleanExtra("isSameDevice", false)) || (isInMultiWindow())) {
            break label806;
          }
          this.dialog = null;
          kickedLogin(true);
        }
        for (;;)
        {
          this.app.setKickIntent(null);
          break;
          label806:
          ((QQCustomDialog)this.dialog).setPositiveButton(2131692684, new NotificationActivity.11(this));
          localObject1 = new Intent("com.tencent.tim.kickedLogin.otherDevice");
          ((Intent)localObject1).putExtra("kickedUin", this.app.getAccount());
          ((Intent)localObject1).putExtra("msg", this.msg);
          ((Intent)localObject1).setPackage("com.tencent.tim");
          sendBroadcast((Intent)localObject1);
        }
        this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new NotificationActivity.12(this));
        break;
        this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(17039370, new NotificationActivity.13(this));
        break;
        this.dialog = DialogUtil.a(this, 230).setTitle(getString(2131693899)).setMessage(getString(2131718970)).setPositiveButton(getString(2131718972), new NotificationActivity.15(this)).setNegativeButton(getString(2131718969), new NotificationActivity.14(this));
        break;
        if (this.loginRet == 40)
        {
          ReportController.a(this.app, "dc00898", "", this.loginAlias, "0X800AA2F", "0X800AA2F", 0, 0, "", "", "", this.msg);
          localObject1 = getIntent();
          if (localObject1 == null) {
            break;
          }
          parseIntentErrorData((Intent)localObject1);
          handleFrozenStyle(this.mUnifyFrozenStyle);
          break;
        }
        switch (this.loginRet)
        {
        default: 
          this.dialog = DialogUtil.b(this, 230).setMessageWithUrl(this.msg).setTitle(getString(2131699104)).setPositiveButton(17039370, new NotificationActivity.17(this));
          break;
        case 41: 
        case 116: 
          localObject1 = (Long)LhHelper.a.get(this.loginAlias);
          if ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() < 30000L))
          {
            this.dialog = DialogUtil.a(this, 230).setTitle(HardCodeUtil.a(2131707603)).setMessage(HardCodeUtil.a(2131707601)).setNegativeButton(HardCodeUtil.a(2131707610), new NotificationActivity.16(this));
            break;
          }
          handleLhExpire();
          break;
          Object localObject2 = getIntent().getExtras();
          localObject1 = ((Bundle)localObject2).getString("dlg_title");
          String str2 = ((Bundle)localObject2).getString("dlg_content");
          String str3 = ((Bundle)localObject2).getString("dlg_lbutton");
          String str4 = ((Bundle)localObject2).getString("dlg_rbutton");
          localObject2 = ((Bundle)localObject2).getString("dlg_url");
          this.dialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setPositiveButton(str4, new NotificationActivity.19(this, (String)localObject2)).setNegativeButton(str3, new NotificationActivity.18(this));
          break;
          localObject1 = getResources().getString(2131693946);
          str2 = getResources().getString(2131693945);
          str3 = getResources().getString(2131693942);
          str4 = getResources().getString(2131693944);
          Object localObject3 = getResources().getString(2131693943);
          localObject2 = new CheckBox(this);
          ((CheckBox)localObject2).setText((CharSequence)localObject3);
          ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131427336));
          ((CheckBox)localObject2).setTextColor(getResources().getColor(2131165497));
          localObject3 = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
          boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
          ((CheckBox)localObject2).setChecked(bool);
          this.dialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setView((View)localObject2).setPositiveButton(str4, new NotificationActivity.21(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str3, new NotificationActivity.20(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
          break;
          try
          {
            localObject3 = getIntent().getExtras();
            localObject1 = ((Bundle)localObject3).getString("dlg_title", "");
            str2 = ((Bundle)localObject3).getString("dlg_content", "");
            str3 = ((Bundle)localObject3).getString("dlg_lbutton", "");
            str4 = ((Bundle)localObject3).getString("dlg_rbutton", "");
            localObject2 = ((Bundle)localObject3).getString("dlg_url", "");
            paramInt = ((Bundle)localObject3).getInt("dlg_lbtnid", 0);
            i = ((Bundle)localObject3).getInt("dlg_rbtnid", 0);
            localObject3 = String.format("%d", new Object[] { Integer.valueOf(((Bundle)localObject3).getInt("dlg_seccmd", 0)) });
            this.dialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2);
            if (this.dialog == null) {
              break;
            }
            if (!TextUtils.isEmpty(str4)) {
              ((QQCustomDialog)this.dialog).setPositiveButton(str4, new NotificationActivity.22(this, (String)localObject2, i, (String)localObject3));
            }
            if (!TextUtils.isEmpty(str3)) {
              ((QQCustomDialog)this.dialog).setNegativeButton(str3, new NotificationActivity.23(this, paramInt, (String)localObject3));
            }
            ReportController.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007534", "0X8007534", 0, 0, (String)localObject3, "", "", "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      break;
    }
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
      ReportController.a(this.app, "dc00898", "", "", "0X800B292", "0X800B292", 0, 0, "", "", this.msg, "");
    }
    for (;;)
    {
      this.mErrorUrl = paramIntent.getStringExtra("errorUrl");
      this.mErrorVersion = paramIntent.getIntExtra("errorver", 0);
      this.mIsLoginWithMask = paramIntent.getBooleanExtra("is_need_login_with_mask", false);
      this.mUnifyFrozenStyle = FrozenNotifyDlgHelper.a().a(paramIntent.getByteArrayExtra("tlverror"));
      this.mErrorTitle = paramIntent.getStringExtra("errortitle");
      this.mUnifyFrozenScene = FrozenNotifyDlgHelper.a().a(paramIntent.getByteArrayExtra("tlverror"));
      if (TextUtils.isEmpty(this.mErrorUrl)) {
        break;
      }
      handleMiniAppFeature();
      return;
      if (paramIntent.getBooleanExtra("keyFromAddAccount", false)) {
        ReportController.a(this.app, "dc00898", "", "", "0X800B294", "0X800B294", 0, 0, "", "", this.msg, "");
      }
    }
  }
  
  private void payExpiredAccount(int paramInt)
  {
    if ((paramInt != 41) && (paramInt != 116)) {
      return;
    }
    if (paramInt == 116) {}
    for (boolean bool = true;; bool = false)
    {
      gotoPay("3", "mvip.gongneng.android.haoma_03", bool, true);
      return;
    }
  }
  
  private void receiveLhCard()
  {
    ThreadManagerV2.excute(new NotificationActivity.39(this), 16, null, true);
  }
  
  private void reportIMBlock(String paramString)
  {
    if (isIMBlock())
    {
      localObject = getIntent();
      if (localObject != null) {
        break label44;
      }
    }
    label44:
    for (Object localObject = "";; localObject = ((Intent)localObject).getStringExtra("uin"))
    {
      ReportController.b(null, "dc00898", "", (String)localObject, paramString, paramString, 0, 0, "", "", this.msg, "");
      return;
    }
  }
  
  private void sendAccountBroadcast()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
    this.app.getApp().sendBroadcast(localIntent);
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
    paramQQCustomDialog = (TextView)paramQQCustomDialog.findViewById(2131365786);
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
    QLog.i("NotificationActivity", 1, "showDialog: invoked.  inResume: " + paramBoolean + " isDialogShow: " + this.isDialogShow);
    if (this.isDialogShow) {}
    while (((!paramBoolean) && (Build.VERSION.SDK_INT >= 28)) || (this.dialog == null) || (this.dialog.isShowing()) || (isFinishing())) {
      return;
    }
    if ((this.dlgType == 8) && (this.loginRet == 40))
    {
      this.dialog.setCancelable(true);
      this.dialog.setOnCancelListener(new NotificationActivity.5(this));
    }
    try
    {
      for (;;)
      {
        this.dialog.show();
        this.isDialogShow = true;
        return;
        this.dialog.setCancelable(false);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("NotificationActivity", 1, "showDialog: invoked.  t: " + localThrowable);
      }
    }
  }
  
  private void showProgressDialog()
  {
    if (this.mLoadingDialog == null) {
      this.mLoadingDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    if (!this.mLoadingDialog.isShowing())
    {
      this.mLoadingDialog.a(HardCodeUtil.a(2131707605));
      this.mLoadingDialog.show();
    }
  }
  
  private void stopUpgrade()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    if (localConfigHandler != null) {
      localConfigHandler.b();
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
      if (Utils.a(paramIntent) != 0) {
        break label24;
      }
    }
    label24:
    for (paramInt1 = -1;; paramInt1 = 0)
    {
      checkSetResult(paramInt1);
      finish();
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131559628);
    Object localObject = "";
    paramBundle = (Bundle)localObject;
    try
    {
      this.dlgType = getIntent().getIntExtra("type", 0);
      paramBundle = (Bundle)localObject;
      localObject = getIntent().getAction();
      paramBundle = (Bundle)localObject;
      if (QLog.isColorLevel())
      {
        paramBundle = (Bundle)localObject;
        QLog.d("NotificationActivity", 2, "NotificationActivity action = " + (String)localObject);
      }
      paramBundle = (Bundle)localObject;
      if (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(localObject)) {
        break label356;
      }
      paramBundle = (Bundle)localObject;
      this.dlgType = 1;
      paramBundle = (Bundle)localObject;
      stopUpgrade();
    }
    catch (Exception localException)
    {
      try
      {
        do
        {
          for (;;)
          {
            String str;
            paramBundle.mergeFrom((byte[])localObject);
            if (paramBundle.has()) {
              break label491;
            }
            return false;
            paramBundle = (Bundle)localObject;
            if ("mqq.intent.action.ACCOUNT_TIPS".equals(localObject))
            {
              paramBundle = (Bundle)localObject;
              this.dlgType = 6;
              continue;
              localException = localException;
              localObject = paramBundle;
              paramBundle = (Bundle)localObject;
              if (QLog.isColorLevel())
              {
                QLog.e("NotificationActivity", 2, "doOnCreate exception", localException);
                paramBundle = (Bundle)localObject;
              }
            }
            else
            {
              paramBundle = (Bundle)localObject;
              if ("mqq.intent.action.ACCOUNT_KICKED".equals(localObject))
              {
                paramBundle = (Bundle)localObject;
                sendAccountBroadcast();
                paramBundle = (Bundle)localObject;
                stopUpgrade();
                paramBundle = (Bundle)localObject;
                this.dlgType = 5;
              }
              else
              {
                paramBundle = (Bundle)localObject;
                if (!"mqq.intent.action.GRAY".equals(localObject)) {
                  break;
                }
                paramBundle = (Bundle)localObject;
                this.dlgType = 2;
              }
            }
          }
          paramBundle = (Bundle)localObject;
        } while (!"mqq.intent.action.SUSPEND".equals(localObject));
        paramBundle = (Bundle)localObject;
        this.dlgType = 4;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if ((paramBundle.str_packname.has()) && (paramBundle.u32_check_result.has()) && (paramBundle.str_right_button.has()) && (paramBundle.str_url.has())) {
          break label548;
        }
        if (!QLog.isColorLevel()) {
          break label546;
        }
        QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
        return false;
        ThreadManager.post(new NotificationActivity.2(this, paramBundle.u32_check_result.get(), paramBundle.u32_cache_time.get()), 5, null, false);
        this.dialog = DialogUtil.a(this, 230).setTitle(this.title).setMessage(this.msg).setPositiveButton(paramBundle.str_right_button.get(), new NotificationActivity.3(this, paramBundle));
        if (!paramBundle.str_left_button.has()) {
          break label656;
        }
        ((QQCustomDialog)this.dialog).setNegativeButton(paramBundle.str_left_button.get(), new NotificationActivity.4(this));
        showDialog(false);
        return true;
      }
    }
    paramBundle = (Bundle)localObject;
    this.title = getIntent().getStringExtra("title");
    paramBundle = (Bundle)localObject;
    this.msg = getIntent().getStringExtra("msg");
    paramBundle = (Bundle)localObject;
    this.loginAlias = getIntent().getStringExtra("loginalias");
    paramBundle = (Bundle)localObject;
    this.expiredSig = getIntent().getByteArrayExtra("expiredSig");
    paramBundle = (Bundle)localObject;
    this.loginRet = getIntent().getIntExtra("loginret", 0);
    paramBundle = (Bundle)localObject;
    this.mTipsScenesId = getIntent().getIntExtra("keyTipsScenesId", 0);
    paramBundle = (Bundle)localObject;
    this.mReason = ((Constants.LogoutReason)getIntent().getSerializableExtra("reason"));
    paramBundle = (Bundle)localObject;
    str = getIntent().getStringExtra("securityScan");
    if (str != null)
    {
      paramBundle = (Bundle)localObject;
      if ("security_scan".equals(str))
      {
        paramBundle = (Bundle)localObject;
        this.dlgType = 7;
      }
    }
    paramBundle = (Bundle)localObject;
    QLog.d("NotificationActivity", 1, "notification activity type:" + this.dlgType);
    label546:
    label548:
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramBundle))
    {
      if (this.mReason == Constants.LogoutReason.secKicked)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:sec kick");
        }
        localObject = getIntent().getByteArrayExtra("data");
        paramBundle = new signature.SignatureKickData();
      }
      label356:
      label491:
      PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
    }
    label656:
    this.lhHelper = new LhHelper(this.loginAlias);
    myShowDialog(this.dlgType);
    registerReceiver(this.mReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
    return true;
  }
  
  public void doOnDestroy()
  {
    QLog.i("NotificationActivity", 1, "doOnDestroy: invoked.  isDialogShow: " + this.isDialogShow);
    try
    {
      unregisterReceiver(this.mReceiver);
      if ((this.dialog == null) || (!this.dialog.isShowing())) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.dialog.dismiss();
        this.dialog = null;
        super.doOnDestroy();
        if (instance == this) {
          instance = null;
        }
        return;
        localThrowable1 = localThrowable1;
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.i("NotificationActivity", 1, "doOnDestroy: invoked.  t: " + localThrowable2);
        }
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    showDialog(true);
    if ((this.isAlreadyAuthorized) && (this.dialog != null) && (this.dialog.isShowing())) {
      ((QQCustomDialog)this.dialog).setPositiveButton(2131699696, new NotificationActivity.1(this));
    }
    if ((this.mJumpLoginBackFromFund) && (this.dlgType == 5))
    {
      this.mJumpLoginBackFromFund = false;
      kickToLoginActivity();
    }
  }
  
  public void doOnUserLeaveHint()
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
  
  void exitApp()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.exit(false);
  }
  
  public void finish()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
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
    case 1: 
      this.dialog = DialogUtil.a(this, getResources().getString(2131693660), getResources().getString(2131693650), getResources().getString(2131693646), this.receiveClickListener, HardCodeUtil.a(2131707613), this.receiveClickListener, this.myClickListener);
      this.dialog.show();
      return true;
    case 2: 
      this.dialog = DialogUtil.a(this, getResources().getString(2131693660), getResources().getString(2131693649), getResources().getString(2131693647), this.renewalClickListener, getResources().getString(2131693645), this.renewalClickListener, this.myClickListener);
      this.dialog.show();
      return true;
    case 3: 
      if (this.loginRet == 41) {}
      for (paramMessage = getString(2131695002);; paramMessage = getString(2131695001))
      {
        String str = getString(2131695000);
        this.dialog = DialogUtil.a(this, 230).setMessage(paramMessage).setTitle(str).setNegativeButton(2131694999, new NotificationActivity.38(this)).setPositiveButton(2131694998, new NotificationActivity.37(this));
        this.dialog.setCancelable(false);
        this.dialog.show();
        return true;
      }
    case 4: 
      showProgressDialog();
      return true;
    case 5: 
      hideProgressDialog();
      QQToast.a(this, 2, HardCodeUtil.a(2131707608), 0).b(getTitleBarHeight());
      LhHelper.a.put(this.loginAlias, Long.valueOf(System.currentTimeMillis()));
      finish();
      return true;
    }
    hideProgressDialog();
    QQToast.a(this, 1, HardCodeUtil.a(2131707607), 0).b(getTitleBarHeight());
    finish();
    return true;
  }
  
  public void kickToLoginActivity()
  {
    Object localObject1 = null;
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
    if (!PhoneNumLoginImpl.a().a(this.app, this.app.getCurrentAccountUin()))
    {
      this.app.updateSubAccountLogin(this.app.getCurrentAccountUin(), false);
      this.app.getApplication().refreAccountList();
    }
    Object localObject2 = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject2 != null) {
      localObject1 = ((SubAccountManager)localObject2).a();
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!PhoneNumLoginImpl.a().a(this.app, (String)localObject2))
        {
          this.app.updateSubAccountLogin((String)localObject2, false);
          this.app.getApplication().refreAccountList();
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    instance = this;
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity
 * JD-Core Version:    0.7.0.1
 */