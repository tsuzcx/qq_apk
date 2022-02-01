package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.identification.FaceContext;
import com.tencent.mobileqq.identification.FaceLoginHelper;
import com.tencent.mobileqq.identification.IFaceStrategy;
import com.tencent.mobileqq.identification.UnusableStrategy;
import com.tencent.mobileqq.identification.UsableStrategy;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollListener;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.mqp.app.sec.SecCenterConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.SystemBarCompact;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

@RoutePage(desc="设置-账号安全页", path="/base/safe/loginInfo")
public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ScrollListener
{
  private static final int BG_COLOR_DANGOUS = -31676;
  private static final int BG_COLOR_SAFE = -15550475;
  public static final int CHANGING_SCANNING_TIP_TEXT = 20170210;
  public static volatile int DIALOG_SHOW_TIME_INTERVAL = 86400000;
  private static final int DIALOG_TYPE_GETDEVLIST = 0;
  private static final int DIALOG_TYPE_KICKDEV = 1;
  private static final int FG_COLOR_TEXTVIEW = -1;
  private static final int GRAY_VIEW_ID = 1;
  private static final int GRAY_VIEW_PHONE_GUIDE_ID = 2;
  public static final String KEY_FACE_APPID = "faceAppId";
  public static final String KEY_FACE_TMPKEY = "faceTmpKey";
  public static final String KEY_SECURE_STATE = "secureState";
  public static final String KEY_SECURITY_TYPE = "securityType";
  public static final String KEY_SHOW_GRAY = "showGroy";
  public static String LAST_DIALOG_SHOW_TIME;
  private static final String MODIFY_PWD_DEFAULT_URL = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
  public static final int MSG_CLOSE_LOGIN_DEV_GRAY_GUIDE = 20200313;
  public static final int MSG_STOPPING_ANIMATION = 20170211;
  public static final String MSG_TAG_IS_SAFE = "bSafe";
  public static final String MSG_TAG_TIP_TEXT = "TipText";
  private static final int PIM_PICKPROOF_SWITCH_ON = 1;
  private static final int PIM_SECURE_DETECT_SWITCH_ON = 2;
  private static final int PIM_SECURITY_SCAN_SWITCH_ON = 4;
  private static int QQPIM_OK = 0;
  private static int QQPIM_SUSPENED = 1;
  private static int QQPIM_UNSTALLED = 2;
  private static final String QQ_SAFE_CENTER_URL = "mqqapi://miniapp/open?_atype=0&_mappid=1109907872&_mvid=&_vt=3&via=4010&_sig=1596013484";
  public static final int REFRESH_DEVLOCK_NAME = 1;
  public static final int REFRESH_DEVLOCK_STATUS = 20140331;
  public static final String REPORT_T_ACCOUNT_RELEASE_CLICK = "0X800B843";
  public static final String REPORT_T_ACCOUNT_RELEASE_SHOW = "0X800B7DF";
  public static final String REPORT_T_DEV_MANAGE_CLICK = "0X800B840";
  public static final String REPORT_T_DEV_MANAGE_SHOW = "0X800B7DC";
  public static final String REPORT_T_FACE_RECOGNIZE_CLICK = "0X800B83F";
  public static final String REPORT_T_FACE_RECOGNIZE_SHOW = "0X800B7DB";
  public static final String REPORT_T_HAND_PASS_CLICK = "0X800B841";
  public static final String REPORT_T_HAND_PASS_SHOW = "0X800B7DD";
  public static final String REPORT_T_PASSWORD_CHANGE_CLICK = "0X800B83E";
  public static final String REPORT_T_PASSWORD_CHANGE_SHOW = "0X800B7DA";
  public static final String REPORT_T_QQ_SAFE_CENTER_CLICK = "0X800B842";
  public static final String REPORT_T_QQ_SAFE_CENTER_SHOW = "0X800B7DE";
  static final int REQUEST_ACCOUNT_RELEASE = 4;
  static final int REQUEST_CODE_QQPIM_SECURE = 2;
  static final int REQUEST_CODE_RISK_DETAILS = 3;
  static final int REQUEST_CODE_SET_GESTUREPWD = 1;
  public static final int SEC_SCANNING_FRAME_DURATION = 300;
  public static final int SEC_STOPPING_ANIMATION_DURATION = 2000;
  private static final int SHOW_GRAY = 1;
  public static final int SHOW_NEW_PAGE = 0;
  public static final String STATE_SECURE_ERROR = "secureStateError";
  public static final String STATE_SECURE_OK = "secureStateOk";
  public static final String STATE_SECURE_UNKNOWN = "secureStateUNKNOWN";
  private static final String TAG = "LoginInfoActivity.AccDevSec";
  private static final String T_DEV_MANAGE_CLICK_TOAST_SHOW = "0X800ACBF";
  private static final String T_DEV_MANAGE_GUIDE_VIEW_SHOW = "0X800AC59";
  private static final String T_FACE_SET_OUT_ENTRANCE_CLICK = "0X800AA7B";
  private static final String T_FACE_SET_OUT_ENTRANCE_SHOW = "0X800AA7A";
  private static final String T_REPORT_DEV_ENTRANCE_CLICK = "0X800AC51";
  private static final String T_REPORT_DEV_ENTRANCE_SHOW = "0X800AC50";
  private static final String T_SECURITY_MODIFY_PWD_CLICK = "0X800B29C";
  private static final String T_SECURITY_MODIFY_PWD_SHOW = "0X800B29B";
  private static final int mFrameCount = 4;
  private boolean bBeingScanning = false;
  private boolean bBeingStopping = false;
  private FormSimpleItem mAccountLogoutItem;
  private String mAccountReleaseUrl;
  private boolean mBeingFingerDown = false;
  private boolean mBeingScrollDown = false;
  private FormSwitchItem mBothOnline;
  private RedTouch mChangePwdRedTouch;
  private SystemBarCompact mCompactBackup;
  private int mCurFrame = 0;
  private boolean mCurrentSafeBG = true;
  private RedTouch mDevLockRedTouch;
  private TextView mDevProtectTv = null;
  private DevlockInfo mDevlockInfo = null;
  private ImageView mDevlockStatusIconView;
  private ImageView mDunImageView = null;
  private RelativeLayout mFaceLoginLayout;
  private oidb_0x5e1.RspBody mFaceStatusInfo;
  private float mFingerDownX = 0.0F;
  private float mFingerDownY = 0.0F;
  private FriendListObserver mFriendObserver = new LoginInfoActivity.11(this);
  private GameCenterObserver mGameCenterObserver = new LoginInfoActivity.1(this);
  private int mGesturePasswordState = 0;
  private FormSimpleItem mGesturePwdLayout;
  private ImageView mGouImageView = null;
  private MqqHandler mHandler = new LoginInfoActivity.2(this);
  private boolean mHasGuideView = false;
  private ImageView mInfoImageView = null;
  private ImageView mInnerCircleImageView = null;
  private boolean mIsClickReleaseItem = false;
  private boolean mIsClickSafetyCenterItem = false;
  private boolean mIsGrayAccount = true;
  private boolean mLastResultIsSafe = true;
  private boolean mLastSafeBG = true;
  private LinearLayout mLoginDevLayout = null;
  private List<SvcDevLoginInfo> mNowList = null;
  private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new LoginInfoActivity.17(this);
  private ImageView mOuterCircleImageView = null;
  private String mPageName = "";
  private ProgressBar mPbFace;
  private FormSimpleItem mPickproof;
  private QQProgressDialog mProDialog;
  private RelativeLayout mProtectDevLayout = null;
  private int mQQPimsecureStatus = QQPIM_OK;
  private ImageView mQieImageView = null;
  private TextView mRecentLoginDevTv = null;
  private ImageView mRightSelectorImageView = null;
  private ArrayList<RiskInfoItem> mRiskInfoItems = new ArrayList();
  private LinearLayout mRiskInfoLayout = null;
  private TextView mRiskScanningTv = null;
  private TextView mRiskSummaryTv = null;
  private FormSimpleItem mSafetyCenterItem;
  private Dialog mSafetyRiskDialog;
  private ImageView mScanningLineImageView = null;
  private ImageView mScanningProgressImageView = null;
  private BounceScrollView mScrollView = null;
  private boolean mScrollViewBGChanged = false;
  private FaceSecureCheck.SecureCheckResponse mSecureInfo;
  private ProgressBar mStatusLoadingView = null;
  private TextView mStatusView = null;
  private boolean mTestResultIsSafe = false;
  private FormSwitchItem mTestResultSafe = null;
  private RelativeLayout mTipTextLayout = null;
  private String mTipTextNoRisks = "";
  private String mTipTextWithRisks = "";
  private TextView mTvFaceStatus;
  private TextView mTvFaceTips;
  private WtloginObserver mWtLoginObserver = new LoginInfoActivity.12(this);
  private FormSimpleItem qqpimsecureDetectLayout;
  private FormSwitchItem securityScanCheckBox;
  private View updateQQPassword;
  
  static
  {
    LAST_DIALOG_SHOW_TIME = "last_safety_risk_dialog_time";
  }
  
  private void changeScrollViewBG()
  {
    if (!this.mScrollViewBGChanged) {
      if (this.mCurrentSafeBG)
      {
        this.mScrollView.setBackgroundColor(-15550475);
        this.mScrollViewBGChanged = true;
      }
    }
    while (this.mLastSafeBG == this.mCurrentSafeBG) {
      for (;;)
      {
        return;
        this.mScrollView.setBackgroundColor(-31676);
      }
    }
    if (this.mCurrentSafeBG) {
      this.mScrollView.setBackgroundColor(-15550475);
    }
    for (;;)
    {
      this.mScrollViewBGChanged = true;
      return;
      this.mScrollView.setBackgroundColor(-31676);
    }
  }
  
  private void dismissLoginDevGrayView(View paramView)
  {
    paramView.setVisibility(8);
    SharedPreUtils.d(this, getCurrentAccountUin(), true);
  }
  
  private boolean getShowTime()
  {
    try
    {
      SharedPreferences localSharedPreferences = getSharedPreferences(md5sum(getCurrentAccountUin()) + "_" + LAST_DIALOG_SHOW_TIME, 0);
      int i = DIALOG_SHOW_TIME_INTERVAL;
      long l1 = localSharedPreferences.getLong(LAST_DIALOG_SHOW_TIME, 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 < i) {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private String getUpdatePwdUrl(String paramString)
  {
    SecCenterConfig localSecCenterConfig = (SecCenterConfig)ScConfigManager.a().a("SecCenterConfig", false);
    if (localSecCenterConfig != null) {
      return localSecCenterConfig.a("ModifyPwdUrls", paramString);
    }
    return null;
  }
  
  private void handleLoginDevManageIntent()
  {
    Intent localIntent = new Intent(this, AuthDevActivity.class);
    localIntent.putExtra("phone_num", this.mDevlockInfo.Mobile);
    localIntent.putExtra("country_code", this.mDevlockInfo.CountryCode);
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("DevlockInfo", this.mDevlockInfo);
    localIntent.putExtra("auth_dev_gray_switch", this.mIsGrayAccount);
    startActivityForResult(localIntent, 0);
  }
  
  private void hideProgerssDialog()
  {
    this.mHandler.post(new LoginInfoActivity.9(this));
  }
  
  private void initAccountReleaseEntrance()
  {
    this.mAccountLogoutItem = ((FormSimpleItem)findViewById(2131361918));
    if (SharedPreUtils.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_entrance", false))
    {
      this.mAccountLogoutItem.setVisibility(0);
      String str = SharedPreUtils.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_url", "");
      if (TextUtils.isEmpty(str)) {}
      for (this.mAccountReleaseUrl = "https://ti.qq.com/qqcancel/index.html";; this.mAccountReleaseUrl = str)
      {
        this.mAccountLogoutItem.setOnClickListener(this);
        ReportController.a(this.app, "0X800B7DF");
        return;
      }
    }
    this.mAccountLogoutItem.setVisibility(8);
  }
  
  private void initImmersiveTitle(int paramInt)
  {
    this.mCompactBackup = this.mSystemBarComp;
    this.mSystemBarComp = null;
    new SystemBarCompact(this, true, paramInt).init();
  }
  
  private void initSafetyCenterEntrance()
  {
    this.mSafetyCenterItem = ((FormSimpleItem)findViewById(2131374772));
    this.mSafetyCenterItem.setVisibility(0);
    this.mSafetyCenterItem.setOnClickListener(this);
    ReportController.a(this.app, "0X800B7DE");
  }
  
  private void logout()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = SharedPreUtils.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_success_text", "");
    String str = SharedPreUtils.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_bold_text", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("is_from_account_release", true);
    localIntent.putExtra("release_account_uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("release_success_text", (String)localObject);
    localIntent.putExtra("release_bold_text", str);
    ThemeUiPlugin.destroy(this.app);
    ChatBackgroundManager.b();
    localObject = this.app.getApp().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject).commit();
    this.app.logout(true);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    int i = QQSettingUtil.a(this, this.app.getCurrentAccountUin());
    QQSettingUtil.a(this, this.app.getCurrentAccountUin(), i + 1);
    RouteUtils.a(this, localIntent, "/base/login");
    if (QQPlayerService.a())
    {
      localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      sendBroadcast(localIntent);
    }
    long l2 = System.currentTimeMillis();
    QLog.d("LoginInfoActivity.AccDevSec", 1, "logout: costTime = " + (l2 - l1));
  }
  
  public static String md5sum(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      while (i < j)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[i] & 0xFF) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void onGetDevLockShowDialog(DevlockInfo paramDevlockInfo)
  {
    int i = 1;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup != 1) {
        break label34;
      }
    }
    for (;;)
    {
      if ((i == 0) && (getShowTime()))
      {
        setShowTime();
        showSafetyRiskDialog();
      }
      return;
      label34:
      i = 0;
    }
  }
  
  private void onGetDevLockStatus(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    this.mProtectDevLayout.setClickable(true);
    this.mStatusLoadingView.setVisibility(4);
    this.mStatusView.setVisibility(0);
    this.mDevlockStatusIconView.setVisibility(0);
    int i;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        localTextView = this.mStatusView;
        if (this.mIsGrayAccount)
        {
          paramDevlockInfo = getString(2131692050);
          label115:
          localTextView.setText(paramDevlockInfo);
          paramDevlockInfo = this.mDevlockStatusIconView;
          if (!this.mIsGrayAccount) {
            break label162;
          }
        }
        label162:
        for (i = 2130845214;; i = 2130845213)
        {
          paramDevlockInfo.setImageResource(i);
          updateDevLockRedTouch();
          return;
          i = 0;
          break;
          paramDevlockInfo = getString(2131692061);
          break label115;
        }
      }
      EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
      TextView localTextView = this.mStatusView;
      if (this.mIsGrayAccount)
      {
        paramDevlockInfo = getString(2131692059);
        label209:
        localTextView.setText(paramDevlockInfo);
        paramDevlockInfo = this.mDevlockStatusIconView;
        if (!this.mIsGrayAccount) {
          break label249;
        }
      }
      label249:
      for (i = 2130845211;; i = 2130845212)
      {
        paramDevlockInfo.setImageResource(i);
        break;
        paramDevlockInfo = getString(2131692064);
        break label209;
      }
      i = 0;
    }
  }
  
  private void onGetDevLockStatusFail()
  {
    this.mProtectDevLayout.setClickable(true);
    this.mDevProtectTv.setTextColor(getResources().getColorStateList(2131167038));
    this.mStatusLoadingView.setVisibility(4);
  }
  
  private void refreshGesturePWDState()
  {
    this.mGesturePasswordState = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.mGesturePasswordState)
    {
    default: 
      return;
    case 2: 
      this.mGesturePwdLayout.setRightText(getResources().getString(2131692932));
      return;
    case 1: 
      this.mGesturePwdLayout.setRightText(getResources().getString(2131692923));
      return;
    }
    this.mGesturePwdLayout.setRightText(getResources().getString(2131692931));
  }
  
  private void refreshQQPimStatus()
  {
    ThreadManager.postImmediately(new LoginInfoActivity.CheckPIMStatus(this, this.qqpimsecureDetectLayout), null, true);
  }
  
  private void refreshUserFaceState(int paramInt)
  {
    if ((this.mFaceStatusInfo != null) && (this.mFaceStatusInfo.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.mFaceStatusInfo.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      TextView localTextView = this.mTvFaceStatus;
      if (paramInt == 1) {}
      for (String str = getString(2131692219);; str = getString(2131692225))
      {
        localTextView.setText(str);
        return;
      }
    }
    QLog.e("LoginInfoActivity.AccDevSec", 1, "refreshUserFaceState mFAceStateRsp is null or rpt_msg_uin_data is empty");
  }
  
  private void removeChangePwdRedTouch()
  {
    Object localObject = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    ((RedTouchManager)localObject).b("100190.100199");
    ((RedTouchManager)localObject).b("100190.100199.100199002");
    localObject = ((RedTouchManager)localObject).a("100190.100199.100199002");
    this.mChangePwdRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void removeDevLockRedTouch()
  {
    Object localObject = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    ((RedTouchManager)localObject).b("100190.100199");
    ((RedTouchManager)localObject).b("100190.100199.100199001");
    localObject = ((RedTouchManager)localObject).a("100190.100199.100199001");
    this.mDevLockRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void reportModifyPwdData(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00899", "Safe_SecCenter", "", "ModifyPwd", paramString, paramInt, 0, "", "", "", "");
  }
  
  private void setBackground(boolean paramBoolean1, boolean paramBoolean2)
  {
    setTitleTextColor(-1);
    if (!paramBoolean1)
    {
      initImmersiveTitle(-31676);
      if (!paramBoolean2)
      {
        this.mDunImageView.setImageResource(2130847379);
        if (!paramBoolean1) {
          break label108;
        }
      }
    }
    label108:
    for (int i = 2130847386;; i = 2130847376)
    {
      this.mLastSafeBG = this.mCurrentSafeBG;
      this.mCurrentSafeBG = paramBoolean1;
      this.mRiskInfoLayout.setBackgroundResource(i);
      getTitleBarView().setBackgroundResource(i);
      this.mScrollView.setBackgroundResource(i);
      return;
      this.mDunImageView.setImageResource(2130847377);
      break;
      initImmersiveTitle(-15550475);
      this.mDunImageView.setImageResource(2130847378);
      break;
    }
  }
  
  private void setFormItemBgType(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if ((paramRelativeLayout instanceof FormSimpleItem)) {
      ((FormSimpleItem)paramRelativeLayout).setBgType(paramInt);
    }
    while (!(paramRelativeLayout instanceof FormSwitchItem)) {
      return;
    }
    ((FormSwitchItem)paramRelativeLayout).setBgType(paramInt);
  }
  
  private void setLoginDevData(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.mLoginDevLayout.setVisibility(8);
    }
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.mLoginDevLayout.removeAllViews();
      this.mLoginDevLayout.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2131559446, this.mLoginDevLayout, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131369361);
    label119:
    Object localObject2;
    TextView localTextView1;
    Button localButton;
    TextView localTextView2;
    ImageView localImageView;
    if (j == 1)
    {
      ((RelativeLayout)localObject1).setBackgroundResource(2130839575);
      getResources().getString(2131694409);
      localObject2 = getResources().getString(2131694411);
      localTextView1 = (TextView)localView.findViewById(2131369992);
      localButton = (Button)localView.findViewById(2131369994);
      if (AppSetting.d)
      {
        localTextView1.setContentDescription(getString(2131694411));
        localButton.setContentDescription(getString(2131694409));
      }
      localTextView2 = (TextView)localView.findViewById(2131372115);
      localObject1 = (TextView)localView.findViewById(2131369051);
      localImageView = (ImageView)localView.findViewById(2131368603);
      if (i != 0) {
        break label470;
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130840804);
      label275:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label558;
      }
      localTextView2.setText(2131694414);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject2).length() > 0) {
        ((TextView)localObject1).setText(((StringBuffer)localObject2).toString());
      }
      this.mLoginDevLayout.addView(localView);
      break;
      if (i == 0)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839591);
        break label119;
      }
      if (i == j - 1)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839582);
        break label119;
      }
      ((RelativeLayout)localObject1).setBackgroundResource(2130839585);
      break label119;
      label470:
      if (localSvcDevLoginInfo.iProductType == 1L)
      {
        localTextView1.setVisibility(8);
        localButton.setVisibility(8);
        localImageView.setImageResource(2130840802);
        break label275;
      }
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130840803);
      localButton.setOnClickListener(new LoginInfoActivity.10(this, localButton, i));
      break label275;
      label558:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void setShowTime()
  {
    try
    {
      SharedPreferences.Editor localEditor = getSharedPreferences(md5sum(getCurrentAccountUin()) + "_" + LAST_DIALOG_SHOW_TIME, 0).edit();
      localEditor.putLong(LAST_DIALOG_SHOW_TIME, System.currentTimeMillis());
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void setTitleTextColor(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(2130850524);
      this.leftView.setBackgroundDrawable(localDrawable);
    }
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setTextColor(paramInt);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
    if (this.rightViewText != null) {
      this.rightViewText.setTextColor(paramInt);
    }
    if (this.rightHighLView != null) {
      this.rightHighLView.setTextColor(paramInt);
    }
  }
  
  private void showGrayView()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
    Object localObject1 = new int[2];
    Object localObject2 = this.mStatusView;
    ((View)localObject2).getLocationOnScreen((int[])localObject1);
    int i = localObject1[1];
    int j = ((View)localObject2).getHeight();
    localObject1 = new TextView(this);
    ((TextView)localObject1).setBackgroundResource(2130845204);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setClickable(false);
    ((TextView)localObject1).setText(getString(2131692054));
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(12.0F);
    int k = AIOUtils.a(6.0F, getResources());
    int m = AIOUtils.a(6.0F, getResources());
    ((TextView)localObject1).setPadding(k, AIOUtils.a(6.0F, getResources()), m, AIOUtils.a(12.0F, getResources()));
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(20.0F, getResources());
    ((FrameLayout.LayoutParams)localObject2).gravity = 5;
    ((FrameLayout.LayoutParams)localObject2).topMargin = (i - j - AIOUtils.a(19.0F, getResources()));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout(this);
    ((FrameLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject2).addView((View)localObject1);
    ((FrameLayout)localObject2).setId(1);
    localFrameLayout.addView((View)localObject2);
    ((FrameLayout)localObject2).setOnTouchListener(new LoginInfoActivity.5(this, (FrameLayout)localObject2));
    this.mHandler.sendEmptyMessageDelayed(20200313, 3000L);
  }
  
  private void showProgressDialog(int paramInt)
  {
    this.mHandler.post(new LoginInfoActivity.8(this, paramInt));
  }
  
  private void startGetFaceDataStatus()
  {
    this.mPbFace.setVisibility(0);
    LoginVerifyServlet.a(this.app, getCurrentAccountUin(), new LoginInfoActivity.6(this));
    LoginVerifyServlet.a(this.app, getCurrentAccountUin(), new LoginInfoActivity.7(this));
  }
  
  private void startSecurityChecking()
  {
    if (this.bBeingScanning) {
      return;
    }
    this.bBeingScanning = true;
    this.bBeingStopping = false;
    this.mRiskScanningTv.setVisibility(0);
    this.mRiskSummaryTv.setVisibility(4);
    this.mRightSelectorImageView.setVisibility(4);
    setBackground(this.mLastResultIsSafe, false);
    this.mQieImageView.setVisibility(0);
    this.mGouImageView.setVisibility(4);
    this.mInfoImageView.setVisibility(4);
    this.mHandler.sendEmptyMessageDelayed(20170210, 300L);
    Object localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(333L);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    this.mScanningProgressImageView.startAnimation((Animation)localObject);
    localObject = new TranslateAnimation(0, 0.0F, 0, 0.0F, 2, -0.25F, 2, 0.9F);
    ((Animation)localObject).setDuration(1000L);
    ((Animation)localObject).setRepeatMode(1);
    ((Animation)localObject).setRepeatCount(-1);
    this.mScanningLineImageView.startAnimation((Animation)localObject);
  }
  
  private void stopRotatingCircle(boolean paramBoolean, String paramString)
  {
    if (!this.bBeingScanning) {
      return;
    }
    this.bBeingStopping = true;
    Object localObject = new TranslateAnimation(0, 0.0F, 0, 0.0F, 2, -0.25F, 2, 0.9F);
    ((Animation)localObject).setDuration(1500L);
    ((Animation)localObject).setRepeatMode(1);
    this.mScanningLineImageView.startAnimation((Animation)localObject);
    ((Animation)localObject).setAnimationListener(new LoginInfoActivity.21(this));
    localObject = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 1620.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1500L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1500L);
    ((AnimationSet)localObject).addAnimation(localRotateAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    this.mScanningProgressImageView.startAnimation((Animation)localObject);
    ((AnimationSet)localObject).setAnimationListener(new LoginInfoActivity.22(this, paramBoolean, paramString));
  }
  
  private void stopSecurityChecking(boolean paramBoolean, String paramString)
  {
    if (!this.bBeingStopping) {
      return;
    }
    Object localObject1 = new AnimationSet(false);
    Object localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 2, 1.0F);
    ((Animation)localObject2).setDuration(500L);
    Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject3).setDuration(500L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    this.mRiskScanningTv.startAnimation((Animation)localObject1);
    ((AnimationSet)localObject1).setAnimationListener(new LoginInfoActivity.19(this));
    this.mRiskSummaryTv.setVisibility(0);
    this.mRiskSummaryTv.setText(paramString);
    if (AppSetting.d) {
      this.mRiskSummaryTv.setContentDescription(paramString);
    }
    paramString = new AnimationSet(false);
    localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, -1.0F, 2, 0.0F);
    ((Animation)localObject1).setDuration(500L);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject2).setDuration(500L);
    paramString.addAnimation((Animation)localObject1);
    paramString.addAnimation((Animation)localObject2);
    this.mRiskSummaryTv.startAnimation(paramString);
    localObject1 = this.mRiskSummaryTv;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      ((TextView)localObject1).setClickable(bool);
      if (!paramBoolean)
      {
        this.mRightSelectorImageView.setVisibility(0);
        this.mRightSelectorImageView.startAnimation(paramString);
      }
      paramString = this.mRightSelectorImageView;
      if (paramBoolean) {
        break label551;
      }
      bool = true;
      label252:
      paramString.setClickable(bool);
      this.mDunImageView.setImageResource(2130847377);
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      this.mQieImageView.startAnimation(paramString);
      paramString.setAnimationListener(new LoginInfoActivity.20(this));
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((Animation)localObject2).setDuration(500L);
      localObject3 = new RotateAnimation(90.0F, -5.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject3).setDuration(500L);
      RotateAnimation localRotateAnimation = new RotateAnimation(-5.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L / 10L);
      localRotateAnimation.setStartOffset(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      paramString.addAnimation((Animation)localObject3);
      paramString.addAnimation(localRotateAnimation);
      if (!paramBoolean) {
        break label556;
      }
      this.mGouImageView.setVisibility(0);
      this.mGouImageView.startAnimation(paramString);
    }
    for (;;)
    {
      setBackground(paramBoolean, true);
      this.bBeingScanning = false;
      this.bBeingStopping = false;
      return;
      bool = false;
      break;
      label551:
      bool = false;
      break label252;
      label556:
      this.mInfoImageView.setVisibility(0);
      this.mInfoImageView.startAnimation(paramString);
    }
  }
  
  private void updateChangePwdRedTouch()
  {
    if (this.mDevLockRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100199.100199002");
      this.mChangePwdRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void updateDevLockRedTouch()
  {
    if (this.mDevLockRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100199.100199001");
      this.mDevLockRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void updateQPIMButtons(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x1) != 0)
    {
      this.mPickproof.setVisibility(0);
      localArrayList.add(this.mPickproof);
      if ((paramInt & 0x2) == 0) {
        break label123;
      }
      this.qqpimsecureDetectLayout.setVisibility(0);
      localArrayList.add(this.qqpimsecureDetectLayout);
      label58:
      if ((paramInt & 0x4) == 0) {
        break label135;
      }
      this.securityScanCheckBox.setVisibility(0);
      localArrayList.add(this.securityScanCheckBox);
      label83:
      paramInt = localArrayList.size();
      if (paramInt != 1) {
        break label147;
      }
      setFormItemBgType((RelativeLayout)localArrayList.get(0), 0);
    }
    label123:
    do
    {
      return;
      this.mPickproof.setVisibility(8);
      break;
      this.qqpimsecureDetectLayout.setVisibility(8);
      break label58;
      this.securityScanCheckBox.setVisibility(8);
      break label83;
      if (paramInt == 2)
      {
        setFormItemBgType((RelativeLayout)localArrayList.get(0), 1);
        setFormItemBgType((RelativeLayout)localArrayList.get(1), 3);
        return;
      }
    } while (paramInt != 3);
    label135:
    label147:
    setFormItemBgType((RelativeLayout)localArrayList.get(0), 1);
    setFormItemBgType((RelativeLayout)localArrayList.get(1), 2);
    setFormItemBgType((RelativeLayout)localArrayList.get(2), 3);
  }
  
  private void writeSecurityStatus(long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_qs_settings", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qsec_status_expired_time" + this.app.getCurrentAccountUin(), paramLong).putString("qsec_status_tip_text" + this.app.getCurrentAccountUin(), paramString).putLong("qsec_status_update_last_time" + this.app.getCurrentAccountUin(), new Date().getTime()).commit();
    }
  }
  
  void dismissSafetyRiskDialog()
  {
    if ((this.mSafetyRiskDialog == null) || (this.mSafetyRiskDialog.isShowing())) {}
    try
    {
      this.mSafetyRiskDialog.dismiss();
      label24:
      this.mSafetyRiskDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.mDevlockInfo != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        if (this.mDevlockInfo.DevSetup == 1)
        {
          bool1 = true;
          bool1 = localBundle.getBoolean("auth_dev_open", bool1);
          String str = localBundle.getString("phone_num");
          if (this.mDevlockInfo.AllowSet == 1) {}
          boolean bool2 = localBundle.getBoolean("allow_set");
          if (!bool1) {
            break label190;
          }
          this.mDevlockInfo.DevSetup = 1;
          label114:
          if (!TextUtils.isEmpty(str)) {
            this.mDevlockInfo.Mobile = str;
          }
          if (!bool2) {
            break label201;
          }
          this.mDevlockInfo.AllowSet = 1;
          label144:
          onGetDevLockStatus(this.mDevlockInfo);
          requestRisksInfo();
        }
      }
      else if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("faceStateKey");
        if (!TextUtils.isEmpty(paramIntent)) {
          refreshUserFaceState(Integer.parseInt(paramIntent));
        }
      }
    }
    label190:
    label201:
    do
    {
      return;
      bool1 = false;
      break;
      this.mDevlockInfo.DevSetup = 0;
      break label114;
      this.mDevlockInfo.AllowSet = 0;
      break label144;
      if (paramInt1 == 1)
      {
        refreshGesturePWDState();
        return;
      }
      if (paramInt1 == 2)
      {
        refreshQQPimStatus();
        return;
      }
      if (paramInt1 == 3)
      {
        requestRisksInfo();
        return;
      }
      if (paramInt1 == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginInfoActivity.AccDevSec", 2, String.format("doOnActivityResult, resultCode: %s", new Object[] { Integer.valueOf(paramInt2) }));
        }
        if (paramInt2 == -1)
        {
          this.mAccountLogoutItem.postDelayed(new LoginInfoActivity.16(this), 50L);
          ReportController.a(this.app, "dc00898", "", "", "0X800989B", "0X800989B", 0, 0, "", "", "", "");
          return;
        }
        ReportController.a(this.app, "dc00898", "", "", "0X800989A", "0X800989A", 0, 0, "", "", "", "");
        return;
      }
      if ((paramInt1 == 11) || (paramInt1 == 21))
      {
        QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, resultCode is ", Integer.valueOf(paramInt2) });
        if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
        {
          refreshUserFaceState(1);
          return;
        }
        if (paramIntent == null) {}
        for (bool1 = true;; bool1 = false)
        {
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, data == null ? ", Boolean.valueOf(bool1) });
          if (paramIntent == null) {
            break;
          }
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, KEY_FACE_SCAN_RESULT is ", Boolean.valueOf(paramIntent.getBooleanExtra("key_face_scan_result", false)) });
          return;
        }
      }
    } while ((paramInt1 != 12) || (paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("key_face_scan_result", false)));
    refreshUserFaceState(0);
    QQToast.a(this, getString(2131692090), 0).a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559445);
    setTitle(2131699113);
    setTitleTextColor(-1);
    paramBundle = SharedPreUtils.j(this, getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramBundle)) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      if (paramBundle.optInt("securityType", 0) != 0) {
        break label1443;
      }
      bool2 = true;
    }
    catch (Exception paramBundle)
    {
      try
      {
        for (;;)
        {
          boolean bool3;
          boolean bool1;
          this.mPageName = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
          if (!this.mIsGrayAccount) {
            break;
          }
          this.mDevProtectTv.setText(getString(2131692052));
          this.mBothOnline.setVisibility(8);
          this.mLoginDevLayout.setVisibility(8);
          this.mRecentLoginDevTv.setVisibility(8);
          findViewById(2131370825).setVisibility(0);
          if (this.mHasGuideView)
          {
            ReportController.b(null, "dc00898", "", "", "0X800AC59", "0X800AC59", 0, 0, "", "", "", "");
            this.mDevProtectTv.post(new LoginInfoActivity.4(this));
          }
          ReportController.b(null, "dc00898", "", "", "0X800AC50", "0X800AC50", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "packName = " + this.mPageName);
          }
          setLoginDevData(null);
          if (QLog.isColorLevel()) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate begin to getLoginDevList");
          }
          if (!NetworkUtil.d(this)) {
            break label1531;
          }
          if (!this.mIsGrayAccount)
          {
            bool2 = EquipmentLockImpl.a().a(this.app, this.mPageName, 0L);
            if (!bool2) {
              QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onCreate getLoginDevList failed ret=", Boolean.valueOf(bool2) });
            }
          }
          paramBundle = FaceContext.a().a();
          if (paramBundle != null) {
            paramBundle.a(new View[] { this.mFaceLoginLayout, this.mTvFaceTips });
          }
          if (!(paramBundle instanceof UsableStrategy)) {
            break label1554;
          }
          startGetFaceDataStatus();
          startGetDevLockStatus();
          refreshGesturePWDState();
          refreshQQPimStatus();
          requestRisksInfo();
          initAccountReleaseEntrance();
          initSafetyCenterEntrance();
          this.app.registObserver(this.mGameCenterObserver);
          return true;
          boolean bool2 = false;
          continue;
          bool2 = false;
          continue;
          int i = 0;
          continue;
          paramBundle = paramBundle;
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "parse dev gray switch error : ", paramBundle.getMessage() });
        }
        this.mDevLockRedTouch = new RedTouch(this, this.mProtectDevLayout).d(27).a();
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          addObserver(this.mFriendObserver);
          continue;
          QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
          continue;
          if ((paramBundle instanceof UnusableStrategy)) {
            ReportController.a(null, "dc00898", "", "", "0X800B0EC", "0X800B0EC", 0, 0, "", "", "", "");
          }
        }
      }
    }
    this.mIsGrayAccount = bool2;
    if (paramBundle.optInt("showGroy", 0) == 1)
    {
      bool2 = true;
      this.mHasGuideView = bool2;
      bool2 = SharedPreUtils.e(this, getCurrentAccountUin());
      bool3 = this.mHasGuideView;
      if (bool2) {
        break label1453;
      }
      bool1 = true;
      this.mHasGuideView = (bool1 & bool3);
      QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "mIsGrayAccount : ", Boolean.valueOf(this.mIsGrayAccount), " showGory : ", Boolean.valueOf(this.mHasGuideView) });
      this.mScrollView = ((BounceScrollView)findViewById(2131377144));
      this.mScrollView.setScrollListener(this);
      this.mScrollView.setPadding(0, 0, 0, 0);
      this.mLoginDevLayout = ((LinearLayout)findViewById(2131371992));
      this.mRiskInfoLayout = ((LinearLayout)findViewById(2131377140));
      paramBundle = (RelativeLayout)findViewById(2131377133);
      this.mQieImageView = ((ImageView)findViewById(2131377142));
      this.mGouImageView = ((ImageView)findViewById(2131377135));
      this.mInfoImageView = ((ImageView)findViewById(2131377137));
      this.mDunImageView = ((ImageView)findViewById(2131377134));
      this.mOuterCircleImageView = ((ImageView)findViewById(2131377147));
      this.mInnerCircleImageView = ((ImageView)findViewById(2131377141));
      this.mScanningProgressImageView = ((ImageView)findViewById(2131377148));
      this.mScanningLineImageView = ((ImageView)findViewById(2131377136));
      this.mTipTextLayout = ((RelativeLayout)findViewById(2131377146));
      this.mRiskSummaryTv = ((TextView)findViewById(2131377145));
      this.mRiskScanningTv = ((TextView)findViewById(2131377143));
      this.mRightSelectorImageView = ((ImageView)findViewById(2131377131));
      if (AppSetting.d) {
        this.mRightSelectorImageView.setContentDescription(getString(2131717071));
      }
      this.mRiskSummaryTv.setClickable(false);
      this.mRiskSummaryTv.setOnClickListener(this);
      this.mRightSelectorImageView.setClickable(false);
      this.mRightSelectorImageView.setOnClickListener(this);
      this.mProtectDevLayout = ((RelativeLayout)findViewById(2131370824));
      ReportController.a(this.app, "0X800B7DC");
      if (!this.mIsGrayAccount) {
        break label1485;
      }
      this.mProtectDevLayout.post(new LoginInfoActivity.3(this));
      this.mRecentLoginDevTv = ((TextView)findViewById(2131371993));
      this.mProtectDevLayout.setOnClickListener(this);
      this.mRecentLoginDevTv.setOnClickListener(this);
      this.mDevProtectTv = ((TextView)findViewById(2131365741));
      this.mFaceLoginLayout = ((RelativeLayout)findViewById(2131366545));
      ReportController.a(this.app, "0X800B7DB");
      this.mTvFaceStatus = ((TextView)findViewById(2131380342));
      this.mPbFace = ((ProgressBar)findViewById(2131366565));
      this.mTvFaceTips = ((TextView)findViewById(2131370827));
      this.mFaceLoginLayout.setOnClickListener(this);
      this.mGesturePwdLayout = ((FormSimpleItem)findViewById(2131367858));
      this.mGesturePwdLayout.setOnClickListener(this);
      ReportController.a(this.app, "0X800B7DD");
      this.mBothOnline = ((FormSwitchItem)findViewById(2131363768));
      if (AppSetting.d) {
        this.mBothOnline.setContentDescription(getString(2131693321));
      }
      this.updateQQPassword = findViewById(2131380953);
      this.updateQQPassword.setOnClickListener(this);
      ReportController.a(this.app, "0X800B7DA");
      this.mChangePwdRedTouch = new RedTouch(this, this.updateQQPassword).d(27).a();
      ReportController.a(null, "dc00898", "", "", "0X800B29B", "0X800B29B", 0, 0, "", "", "", "");
      this.mPickproof = ((FormSimpleItem)findViewById(2131373168));
      this.mPickproof.setOnClickListener(this);
      this.qqpimsecureDetectLayout = ((FormSimpleItem)findViewById(2131374904));
      this.qqpimsecureDetectLayout.setOnClickListener(this);
      if (AppSetting.d) {
        this.qqpimsecureDetectLayout.setContentDescription(getString(2131718954));
      }
      this.securityScanCheckBox = ((FormSwitchItem)findViewById(2131377686));
      if (AppSetting.d) {
        this.securityScanCheckBox.setContentDescription(getString(2131718971));
      }
      this.app.setHandler(getClass(), this.mHandler);
      bool2 = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
      this.mBothOnline.setChecked(bool2);
      this.mBothOnline.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
      bool2 = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
      this.securityScanCheckBox.setChecked(bool2);
      this.securityScanCheckBox.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
      if (!EquipmentLockImpl.a().b()) {
        this.mProtectDevLayout.setVisibility(8);
      }
      this.mRecentLoginDevTv.setMovementMethod(LinkMovementMethod.getInstance());
      paramBundle = new SpannableString(getResources().getString(2131694412));
      this.mStatusView = ((TextView)findViewById(2131365739));
      this.mStatusLoadingView = ((ProgressBar)findViewById(2131373581));
      this.mDevlockStatusIconView = ((ImageView)findViewById(2131365740));
      i = paramBundle.length();
      paramBundle.setSpan(new LoginInfoActivity.NoLineClickableSpan(this, null), 0, i, 33);
      paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131167045)), 0, i, 33);
      this.mRecentLoginDevTv.setText(paramBundle);
    }
  }
  
  public void doOnDestroy()
  {
    this.bBeingScanning = false;
    this.bBeingStopping = false;
    if (this.mCompactBackup != null) {
      this.mSystemBarComp = this.mCompactBackup;
    }
    super.doOnDestroy();
    hideProgerssDialog();
    removeObserver(this.mFriendObserver);
    this.mHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    setTitleTextColor(-1);
    startGetDevLockStatus();
    refreshGesturePWDState();
    refreshQQPimStatus();
    updateDevLockRedTouch();
    updateChangePwdRedTouch();
    this.mIsClickReleaseItem = false;
    this.mIsClickSafetyCenterItem = false;
    this.mFaceLoginLayout.setClickable(true);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, QQSettingSettingActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public void fling(View paramView, int paramInt) {}
  
  public boolean onBackEvent()
  {
    boolean bool2 = true;
    Intent localIntent;
    boolean bool1;
    if (this.mDevlockInfo != null)
    {
      localIntent = new Intent();
      if (this.mDevlockInfo.DevSetup != 1) {
        break label71;
      }
      bool1 = true;
      if (this.mDevlockInfo.AllowSet != 1) {
        break label76;
      }
    }
    for (;;)
    {
      localIntent.putExtra("auth_dev_open", bool1);
      localIntent.putExtra("allow_set", bool2);
      setResult(0, localIntent);
      finish();
      return false;
      label71:
      bool1 = false;
      break;
      label76:
      bool2 = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mIsGrayAccount) {
        ReportController.b(null, "dc00898", "", "", "0X800AC51", "0X800AC51", 0, 0, "", "", "", "");
      }
      removeDevLockRedTouch();
      ReportController.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
      ReportController.a(this.app, "0X800B840");
      if (this.mDevlockInfo == null)
      {
        if (!NetworkUtil.d(this))
        {
          QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
        }
        else
        {
          ReportController.b(null, "dc00898", "", "", "0X800ACBF", "0X800ACBF", 0, 0, "", "", "", "");
          QQToast.a(this, getString(2131692049), 0).a();
          startGetDevLockStatus();
        }
      }
      else
      {
        Object localObject3;
        Object localObject1;
        if (this.mDevlockInfo.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          localObject3 = new Intent(this, AuthDevActivity.class);
          ((Intent)localObject3).putExtra("phone_num", this.mDevlockInfo.Mobile);
          ((Intent)localObject3).putExtra("country_code", this.mDevlockInfo.CountryCode);
          ((Intent)localObject3).putExtra("auth_dev_open", true);
          ((Intent)localObject3).putExtra("auth_dev_gray_switch", this.mIsGrayAccount);
          if (this.mSecureInfo == null)
          {
            ((Intent)localObject3).putExtra("secureState", "secureStateUNKNOWN");
            startActivityForResult((Intent)localObject3, 0);
          }
          else
          {
            if (this.mSecureInfo.bool_sec_pass.get()) {}
            for (localObject1 = "secureStateOk";; localObject1 = "secureStateError")
            {
              ((Intent)localObject3).putExtra("secureState", (String)localObject1);
              if (!this.mSecureInfo.bool_sec_pass.get()) {
                break;
              }
              ((Intent)localObject3).putExtra("faceAppId", this.mSecureInfo.str_openid.get());
              ((Intent)localObject3).putExtra("faceTmpKey", this.mSecureInfo.str_tmpkey.get());
              break;
            }
          }
        }
        else
        {
          this.app.sendWirelessMeibaoReq(1);
          if (TextUtils.isEmpty(this.mDevlockInfo.Mobile))
          {
            if (this.mIsGrayAccount)
            {
              handleLoginDevManageIntent();
            }
            else
            {
              localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
              ((Intent)localObject1).putExtra("DevlockInfo", this.mDevlockInfo);
              startActivityForResult((Intent)localObject1, 0);
            }
          }
          else if (this.mDevlockInfo.AllowSet == 0)
          {
            if (this.mIsGrayAccount)
            {
              handleLoginDevManageIntent();
            }
            else
            {
              localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
              ((Intent)localObject1).putExtra("DevlockInfo", this.mDevlockInfo);
              startActivityForResult((Intent)localObject1, 0);
            }
          }
          else if (this.mDevlockInfo.AllowSet == 1)
          {
            handleLoginDevManageIntent();
            continue;
            try
            {
              dismissSafetyRiskDialog();
              ReportController.b(null, "dc00898", "", "", "0X800A5D0", "0X800A5D0", 0, 0, "", "", "", "");
              localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
              ((Intent)localObject1).putExtra("DevlockInfo", this.mDevlockInfo);
              startActivityForResult((Intent)localObject1, 0);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            continue;
            if (this.mFaceStatusInfo == null)
            {
              if (!NetworkUtil.d(this)) {
                QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
              }
              QLog.e("LoginInfoActivity.AccDevSec", 1, "face_login_layout click error : mFaceStateRsp is null");
            }
            else if (this.mFaceStatusInfo.rpt_msg_uin_data.isEmpty())
            {
              QLog.e("LoginInfoActivity.AccDevSec", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
            }
            else
            {
              this.mFaceLoginLayout.setClickable(false);
              localObject3 = this.app;
              if (this.mDevlockInfo == null)
              {
                localObject2 = "";
                label820:
                FaceLoginHelper.a((QQAppInterface)localObject3, this, (String)localObject2, this.mFaceStatusInfo, this.mSecureInfo, new LoginInfoActivity.14(this));
                if (((oidb_0x5e1.UdcUinData)this.mFaceStatusInfo.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
                  break label923;
                }
              }
              label923:
              for (Object localObject2 = "1";; localObject2 = "0")
              {
                ReportController.b(null, "dc00898", "", "", "0X800AA7B", "0X800AA7B", 0, 0, (String)localObject2, "", "", "");
                ReportController.a(this.app, "0X800B83F");
                break;
                localObject2 = this.mDevlockInfo.Mobile;
                break label820;
              }
              ReportController.b(null, "dc00898", "", "", "0X800A5D1", "0X800A5D1", 0, 0, "", "", "", "");
              dismissSafetyRiskDialog();
              continue;
              startActivity(new Intent(this, SecurityPickproofActivity.class));
              ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof", "enter pickproof page", 0, 0, "", "", "", "");
              continue;
              if (!NetworkUtil.d(this))
              {
                QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
              }
              else
              {
                ReportController.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
                startActivity(new Intent(this, RecentLoginDevActivity.class));
                continue;
                startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
                ReportController.a(this.app, "0X800B841");
                continue;
                removeChangePwdRedTouch();
                ReportController.a(this.app, "0X800B83E");
                ReportController.a(null, "dc00898", "", "", "0X800B29C", "0X800B29C", 0, 0, "", "", "", "");
                int i;
                if (PhoneNumLoginImpl.a().a(this.app, this.app.getCurrentAccountUin()))
                {
                  localObject3 = new Intent(this, QQBrowserActivity.class);
                  ((Intent)localObject3).putExtra("uin", this.app.getCurrentAccountUin());
                  localObject2 = getUpdatePwdUrl("HasSetPwdUrl");
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    i = 1;
                    label1243:
                    if (i == 0) {
                      localObject2 = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
                    }
                    if (((String)localObject2).indexOf("?") != -1) {
                      break label1341;
                    }
                  }
                  label1341:
                  for (localObject2 = (String)localObject2 + "?uin=" + this.app.getCurrentAccountUin();; localObject2 = (String)localObject2 + "&uin=" + this.app.getCurrentAccountUin())
                  {
                    startActivity(((Intent)localObject3).putExtra("url", (String)localObject2));
                    this.app.sendWirelessPswReq(1);
                    if (i == 0) {
                      reportModifyPwdData("FetchUrl", 1);
                    }
                    reportModifyPwdData("ClkModifyPwd", 1);
                    break;
                    i = 0;
                    break label1243;
                  }
                }
                localObject2 = this.app.getCurrentAccountUin();
                localObject3 = getUpdatePwdUrl("RegNewUrl");
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  i = 1;
                  label1402:
                  if (i == 0) {
                    break label1445;
                  }
                  PwdSetUtil.a((String)localObject3, (String)localObject2, this, this.app);
                }
                for (;;)
                {
                  if (i == 0) {
                    reportModifyPwdData("FetchUrl", 2);
                  }
                  reportModifyPwdData("ClkModifyPwd", 2);
                  break;
                  i = 0;
                  break label1402;
                  label1445:
                  PwdSetUtil.a((String)localObject2, this, this.app);
                }
                startActivityForResult(new Intent(this, SecurityProtectActivity.class), 2);
                ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on qqpimsecure_detect", 0, 0, "", "", "", "");
                continue;
                if ((this.mRiskInfoItems != null) && (!this.mRiskInfoItems.isEmpty()))
                {
                  localObject2 = new Intent(this, RiskInfoActivity.class);
                  ((Intent)localObject2).putParcelableArrayListExtra("data", this.mRiskInfoItems);
                  ((Intent)localObject2).putExtra("DevlockInfo", this.mDevlockInfo);
                  startActivityForResult((Intent)localObject2, 3);
                  ReportController.b(this.app, "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
                  ReportController.b(null, "dc00898", "", "", "0X800A718", "0X800A718", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel())
                  {
                    QLog.d("DevRpt", 2, "帐号安全页顶部风险提示区域点击“发现XXX等N项风险”文字进入安全风险页！0X800A718");
                    continue;
                    if (!this.mIsClickSafetyCenterItem)
                    {
                      this.mIsClickSafetyCenterItem = true;
                      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this, "mqqapi://miniapp/open?_atype=0&_mappid=1109907872&_mvid=&_vt=3&via=4010&_sig=1596013484", 4010, null);
                      ReportController.b(this.app, "dc00899", "QQSafetyCenter", this.app.getCurrentAccountUin(), "clickQQSafetyCenter", "qq_safety_center_item", 0, 1, "", "", "", "");
                      ReportController.b(null, "dc00898", "", "", "0X800A719", "0X800A719", 0, 0, "", "", "", "");
                      ReportController.a(this.app, "0X800B842");
                      if (QLog.isColorLevel())
                      {
                        QLog.d("DevRpt", 2, "帐号安全页点击“QQ安全中心”用户数、次数！0X800A719");
                        continue;
                        if (!this.mIsClickReleaseItem)
                        {
                          this.mIsClickReleaseItem = true;
                          localObject2 = new Intent(this, QQBrowserActivity.class);
                          ((Intent)localObject2).putExtra("url", this.mAccountReleaseUrl);
                          ((Intent)localObject2).putExtra("is_release_account", true);
                          startActivityForResult((Intent)localObject2, 4);
                          ReportController.b(this.app, "dc00898", "", "", "0X8009899", "0X8009899", 0, 0, "", "", "", "");
                          ReportController.a(this.app, "0X800B843");
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFingerDown(View paramView, float paramFloat1, float paramFloat2)
  {
    this.mBeingFingerDown = true;
    this.mFingerDownX = paramFloat1;
    this.mFingerDownY = paramFloat2;
  }
  
  public void onFingerUpOrCancel(View paramView, float paramFloat1, float paramFloat2)
  {
    if (this.mBeingFingerDown)
    {
      this.mBeingFingerDown = false;
      if ((paramFloat2 - this.mFingerDownY > 600.0F) && (this.mBeingScrollDown)) {
        requestRisksInfo();
      }
    }
  }
  
  public void onScrollChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 > 0)
    {
      this.mBeingScrollDown = false;
      this.mScrollView.setBackgroundResource(2130838979);
      this.mScrollViewBGChanged = false;
      return;
    }
    this.mBeingScrollDown = true;
    changeScrollViewBG();
  }
  
  protected void requestRisksInfo()
  {
    if ((this.bBeingScanning) || (this.bBeingStopping)) {
      return;
    }
    startSecurityChecking();
    this.mRiskInfoItems = null;
    this.mRiskInfoItems = new ArrayList();
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(QPMiscUtils.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    ProtoUtils.a(this.app, new LoginInfoActivity.18(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  void showSafetyRiskDialog()
  {
    try
    {
      dismissSafetyRiskDialog();
      ReportDialog localReportDialog = new ReportDialog(this, 2131755842);
      localReportDialog.setContentView(2131559060);
      TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365811);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131692128));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131365807);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131692125));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131365796);
      if (localTextView1 != null) {
        localTextView1.setText(2131692126);
      }
      TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365802);
      if (localTextView2 != null) {
        localTextView2.setText(2131692127);
      }
      localReportDialog.setOnDismissListener(new LoginInfoActivity.13(this));
      if (localTextView1 != null) {
        localTextView1.setOnClickListener(this);
      }
      if (localTextView2 != null) {
        localTextView2.setOnClickListener(this);
      }
      this.mSafetyRiskDialog = localReportDialog;
      this.mSafetyRiskDialog.show();
      ReportController.b(null, "dc00898", "", "", "0X800A5CF", "0X800A5CF", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startGetDevLockStatus()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    this.mProtectDevLayout.setClickable(false);
    this.mStatusLoadingView.setVisibility(0);
    this.mStatusView.setVisibility(4);
    this.mDevlockStatusIconView.setVisibility(4);
    String str = this.app.getCurrentAccountUin();
    int i = EquipmentLockImpl.a().a(this.app, str, this.mWtLoginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      onGetDevLockStatusFail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */