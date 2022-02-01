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
import com.tencent.mobileqq.app.utils.IdentificationUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.identification.FaceAreaManager;
import com.tencent.mobileqq.identification.IFaceAreaStrategy;
import com.tencent.mobileqq.identification.UnusableAreaStrategy;
import com.tencent.mobileqq.identification.UsableAreaStrategy;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.manager.QSafeConfigManager;
import com.tencent.mobileqq.manager.QSafeManagerBean;
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
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
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
import mqq.app.AppRuntime;
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
  private static final int DIALOG_TYPE_GETDEVLIST = 0;
  private static final int DIALOG_TYPE_KICKDEV = 1;
  private static final int FG_COLOR_TEXTVIEW = -1;
  private static final int GRAY_VIEW_ID = 1;
  private static final int GRAY_VIEW_PHONE_GUIDE_ID = 2;
  public static final String KEY_HAS_UNVERIFIED_PHONE = "has_unverified_phone";
  private static final String MODIFY_PWD_DEFAULT_URL = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
  private static final int PIM_PICKPROOF_SWITCH_ON = 1;
  private static final int PIM_SECURE_DETECT_SWITCH_ON = 2;
  private static final int PIM_SECURITY_SCAN_SWITCH_ON = 4;
  private static int QQPIM_OK = 0;
  private static int QQPIM_SUSPENED = 1;
  private static int QQPIM_UNSTALLED = 2;
  private static final String QQ_SAFE_CENTER_URL = "mqqapi://miniapp/open?_atype=0&_mappid=1109907872&_mvid=&_vt=3&via=4010&_sig=1596013484";
  public static final String REPORT_T_ACCOUNT_RELEASE_CLICK = "0X800B843";
  public static final String REPORT_T_ACCOUNT_RELEASE_SHOW = "0X800B7DF";
  public static final String REPORT_T_ANTI_THEFT_CLICK = "0X800BBA6";
  public static final String REPORT_T_ANTI_THEFT_SHOW = "0X800BBA5";
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
  public static final String REPORT_T_SAFE_PROTECT_CLICK = "0X800BBA8";
  public static final String REPORT_T_SAFE_PROTECT_SHOW = "0X800BBA7";
  static final int REQUEST_ACCOUNT_RELEASE = 4;
  static final int REQUEST_CODE_QQPIM_SECURE = 2;
  static final int REQUEST_CODE_RISK_DETAILS = 3;
  static final int REQUEST_CODE_SET_GESTUREPWD = 1;
  public static final int SEC_SCANNING_FRAME_DURATION = 300;
  public static final int SEC_STOPPING_ANIMATION_DURATION = 2000;
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
  private volatile int DIALOG_SHOW_TIME_INTERVAL = 86400000;
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
  private boolean mHasUnverifiedPhone = false;
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
  
  private void changeScrollViewBG()
  {
    if (!this.mScrollViewBGChanged)
    {
      if (this.mCurrentSafeBG) {
        this.mScrollView.setBackgroundColor(-15550475);
      } else {
        this.mScrollView.setBackgroundColor(-31676);
      }
      this.mScrollViewBGChanged = true;
      return;
    }
    boolean bool1 = this.mLastSafeBG;
    boolean bool2 = this.mCurrentSafeBG;
    if (bool1 != bool2)
    {
      if (bool2) {
        this.mScrollView.setBackgroundColor(-15550475);
      } else {
        this.mScrollView.setBackgroundColor(-31676);
      }
      this.mScrollViewBGChanged = true;
    }
  }
  
  private void dismissLoginDevGrayView(View paramView)
  {
    paramView.setVisibility(8);
    SharedPreUtils.c(this, getCurrentAccountUin(), true);
  }
  
  private boolean getShowTime()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(md5sum(getCurrentAccountUin()));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("last_safety_risk_dialog_time");
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0);
      int i = this.DIALOG_SHOW_TIME_INTERVAL;
      long l1 = ((SharedPreferences)localObject).getLong("last_safety_risk_dialog_time", 0L);
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
    Intent localIntent = new Intent();
    localIntent.putExtra("phone_num", this.mDevlockInfo.Mobile);
    localIntent.putExtra("country_code", this.mDevlockInfo.CountryCode);
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("DevlockInfo", this.mDevlockInfo);
    localIntent.putExtra("auth_dev_gray_switch", this.mIsGrayAccount);
    RouteUtils.a(this, localIntent, "/base/safe/authDevActivity", 0);
  }
  
  private void hideProgerssDialog()
  {
    this.mHandler.post(new LoginInfoActivity.9(this));
  }
  
  private void initAccountReleaseEntrance()
  {
    this.mAccountLogoutItem = ((FormSimpleItem)findViewById(2131427478));
    if (SharedPreUtils.c(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_entrance", false))
    {
      this.mAccountLogoutItem.setVisibility(0);
      String str = SharedPreUtils.c(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_url", "");
      if (TextUtils.isEmpty(str)) {
        this.mAccountReleaseUrl = "https://ti.qq.com/qqcancel/index.html";
      } else {
        this.mAccountReleaseUrl = str;
      }
      this.mAccountLogoutItem.setOnClickListener(this);
      ReportController.a(this.app, "0X800B7DF");
      return;
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
    this.mSafetyCenterItem = ((FormSimpleItem)findViewById(2131442471));
    this.mSafetyCenterItem.setVisibility(0);
    this.mSafetyCenterItem.setOnClickListener(this);
    ReportController.a(this.app, "0X800B7DE");
  }
  
  private void initVerifiedPhone()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.mHasUnverifiedPhone = localIntent.getBooleanExtra("has_unverified_phone", false);
    }
  }
  
  private void logout()
  {
    long l1 = System.currentTimeMillis();
    Object localObject2 = SharedPreUtils.c(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_success_text", "");
    String str = SharedPreUtils.c(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_bold_text", "");
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("logout_intent", true);
    ((Intent)localObject1).putExtra("tab_index", FrameControllerUtil.a);
    ((Intent)localObject1).putExtra("is_from_account_release", true);
    ((Intent)localObject1).putExtra("release_account_uin", this.app.getCurrentAccountUin());
    ((Intent)localObject1).putExtra("release_success_text", (String)localObject2);
    ((Intent)localObject1).putExtra("release_bold_text", str);
    ThemeUiPlugin.destroy(this.app);
    ChatBackgroundManager.j();
    localObject2 = this.app.getApp().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject2).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject2).commit();
    this.app.logout(true);
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    int i = QQSettingUtil.a(this, this.app.getCurrentAccountUin());
    QQSettingUtil.a(this, this.app.getCurrentAccountUin(), i + 1);
    RouteUtils.a(this, (Intent)localObject1, "/base/login");
    if (QQPlayerService.b())
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setAction("qqplayer_exit_action");
      sendBroadcast((Intent)localObject1);
    }
    long l2 = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("logout: costTime = ");
    ((StringBuilder)localObject1).append(l2 - l1);
    QLog.d("LoginInfoActivity.AccDevSec", 1, ((StringBuilder)localObject1).toString());
  }
  
  public static String md5sum(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      int i = 0;
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
    if (paramDevlockInfo != null)
    {
      int j = paramDevlockInfo.DevSetup;
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      if ((i == 0) && (getShowTime()))
      {
        setShowTime();
        showSafetyRiskDialog();
      }
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
    if ((paramDevlockInfo != null) && (paramDevlockInfo.DevSetup == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
      paramDevlockInfo = this.mStatusView;
      if (this.mIsGrayAccount) {
        i = 2131888936;
      } else {
        i = 2131888947;
      }
      paramDevlockInfo.setText(getString(i));
      paramDevlockInfo = this.mDevlockStatusIconView;
      if (this.mIsGrayAccount) {
        i = 2130846528;
      } else {
        i = 2130846527;
      }
      paramDevlockInfo.setImageResource(i);
    }
    else
    {
      EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
      paramDevlockInfo = this.mStatusView;
      if (this.mIsGrayAccount) {
        i = 2131888945;
      } else {
        i = 2131888950;
      }
      paramDevlockInfo.setText(getString(i));
      paramDevlockInfo = this.mDevlockStatusIconView;
      if (this.mIsGrayAccount) {
        i = 2130846525;
      } else {
        i = 2130846526;
      }
      paramDevlockInfo.setImageResource(i);
    }
    updateDevLockRedTouch();
  }
  
  private void onGetDevLockStatusFail()
  {
    this.mProtectDevLayout.setClickable(true);
    this.mDevProtectTv.setTextColor(getResources().getColorStateList(2131167999));
    this.mStatusLoadingView.setVisibility(4);
  }
  
  private void refreshGesturePWDState()
  {
    this.mGesturePasswordState = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    int i = this.mGesturePasswordState;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.mGesturePwdLayout.setRightText(getResources().getString(2131890003));
        return;
      }
      this.mGesturePwdLayout.setRightText(getResources().getString(2131889994));
      return;
    }
    this.mGesturePwdLayout.setRightText(getResources().getString(2131890002));
  }
  
  private void refreshUserFaceState(int paramInt)
  {
    Object localObject = this.mFaceStatusInfo;
    if ((localObject != null) && (((oidb_0x5e1.RspBody)localObject).rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.mFaceStatusInfo.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      localObject = this.mTvFaceStatus;
      if (paramInt == 1) {
        paramInt = 2131889128;
      } else {
        paramInt = 2131889137;
      }
      ((TextView)localObject).setText(getString(paramInt));
      return;
    }
    QLog.e("LoginInfoActivity.AccDevSec", 1, "refreshUserFaceState mFAceStateRsp is null or rpt_msg_uin_data is empty");
  }
  
  private void removeChangePwdRedTouch()
  {
    Object localObject = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
    ((IRedTouchManager)localObject).onRedTouchItemClick("100190.100199");
    ((IRedTouchManager)localObject).onRedTouchItemClick("100190.100199.100199002");
    localObject = ((IRedTouchManager)localObject).getAppInfoByPath("100190.100199.100199002");
    this.mChangePwdRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void removeDevLockRedTouch()
  {
    Object localObject = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
    ((IRedTouchManager)localObject).onRedTouchItemClick("100190.100199");
    ((IRedTouchManager)localObject).onRedTouchItemClick("100190.100199.100199001");
    localObject = ((IRedTouchManager)localObject).getAppInfoByPath("100190.100199.100199001");
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
      if (!paramBoolean2) {
        this.mDunImageView.setImageResource(2130848834);
      } else {
        this.mDunImageView.setImageResource(2130848832);
      }
    }
    else
    {
      initImmersiveTitle(-15550475);
      this.mDunImageView.setImageResource(2130848833);
    }
    int i;
    if (paramBoolean1) {
      i = 2130848841;
    } else {
      i = 2130848831;
    }
    this.mLastSafeBG = this.mCurrentSafeBG;
    this.mCurrentSafeBG = paramBoolean1;
    this.mRiskInfoLayout.setBackgroundResource(i);
    getTitleBarView().setBackgroundResource(i);
    this.mScrollView.setBackgroundResource(i);
  }
  
  private void setFormItemBgType(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if ((paramRelativeLayout instanceof FormSimpleItem))
    {
      ((FormSimpleItem)paramRelativeLayout).setBgType(paramInt);
      return;
    }
    if ((paramRelativeLayout instanceof FormSwitchItem)) {
      ((FormSwitchItem)paramRelativeLayout).setBgType(paramInt);
    }
  }
  
  private void setLoginDevData(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.mLoginDevLayout.removeAllViews();
      this.mLoginDevLayout.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null)
        {
          View localView = getLayoutInflater().inflate(2131625269, this.mLoginDevLayout, false);
          Object localObject = (RelativeLayout)localView.findViewById(2131436054);
          if (j == 1) {
            ((RelativeLayout)localObject).setBackgroundResource(2130839622);
          } else if (i == 0) {
            ((RelativeLayout)localObject).setBackgroundResource(2130839638);
          } else if (i == j - 1) {
            ((RelativeLayout)localObject).setBackgroundResource(2130839629);
          } else {
            ((RelativeLayout)localObject).setBackgroundResource(2130839632);
          }
          getResources().getString(2131892052);
          String str = getResources().getString(2131892054);
          TextView localTextView2 = (TextView)localView.findViewById(2131436788);
          Button localButton = (Button)localView.findViewById(2131436790);
          if (AppSetting.e)
          {
            localTextView2.setContentDescription(getString(2131892054));
            localButton.setContentDescription(getString(2131892052));
          }
          localObject = (TextView)localView.findViewById(2131439121);
          TextView localTextView1 = (TextView)localView.findViewById(2131435692);
          ImageView localImageView = (ImageView)localView.findViewById(2131435219);
          if (i == 0)
          {
            localTextView2.setText(str);
            localTextView2.setClickable(false);
            localButton.setVisibility(8);
            localTextView2.setVisibility(0);
            localImageView.setImageResource(2130841456);
          }
          else if (localSvcDevLoginInfo.iProductType == 1L)
          {
            localTextView2.setVisibility(8);
            localButton.setVisibility(8);
            localImageView.setImageResource(2130841454);
          }
          else
          {
            localTextView2.setVisibility(8);
            localButton.setVisibility(0);
            localButton.setTag(localSvcDevLoginInfo);
            localButton.setClickable(true);
            localImageView.setImageResource(2130841455);
            localButton.setOnClickListener(new LoginInfoActivity.10(this, localButton, i));
          }
          if (TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
            ((TextView)localObject).setText(2131892057);
          } else {
            ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
          }
          localObject = new StringBuffer();
          if (localSvcDevLoginInfo.iLoginTime > 0L) {
            ((StringBuffer)localObject).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
          {
            ((StringBuffer)localObject).append(" ");
            ((StringBuffer)localObject).append(localSvcDevLoginInfo.strLoginLocation);
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
          {
            ((StringBuffer)localObject).append(" ");
            ((StringBuffer)localObject).append(localSvcDevLoginInfo.strDeviceTypeInfo);
          }
          if (((StringBuffer)localObject).length() > 0) {
            localTextView1.setText(((StringBuffer)localObject).toString());
          }
          this.mLoginDevLayout.addView(localView);
        }
        i += 1;
      }
      return;
    }
    this.mLoginDevLayout.setVisibility(8);
  }
  
  private void setShowTime()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(md5sum(getCurrentAccountUin()));
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append("last_safety_risk_dialog_time");
      localObject = getSharedPreferences(((StringBuilder)localObject).toString(), 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_safety_risk_dialog_time", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
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
      Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(2130852246);
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
    ((TextView)localObject1).setBackgroundResource(2130846518);
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setClickable(false);
    ((TextView)localObject1).setText(getString(2131888940));
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(12.0F);
    int k = AIOUtils.b(6.0F, getResources());
    int m = AIOUtils.b(6.0F, getResources());
    ((TextView)localObject1).setPadding(k, AIOUtils.b(6.0F, getResources()), m, AIOUtils.b(12.0F, getResources()));
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(20.0F, getResources());
    ((FrameLayout.LayoutParams)localObject2).gravity = 5;
    ((FrameLayout.LayoutParams)localObject2).topMargin = (i - j - AIOUtils.b(19.0F, getResources()));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout(this);
    ((FrameLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject2).addView((View)localObject1);
    ((FrameLayout)localObject2).setId(1);
    localFrameLayout.addView((View)localObject2);
    ((FrameLayout)localObject2).setOnTouchListener(new LoginInfoActivity.5(this, (FrameLayout)localObject2));
    this.mHandler.sendEmptyMessageDelayed(20200313, 3000L);
  }
  
  private boolean showPickProof(int paramInt, String paramString)
  {
    return ((paramInt & 0x1) != 0) && (!TextUtils.isEmpty(paramString));
  }
  
  private void showProgressDialog(int paramInt)
  {
    this.mHandler.post(new LoginInfoActivity.8(this, paramInt));
  }
  
  private boolean showSecureDetect(int paramInt, String paramString)
  {
    return ((paramInt & 0x2) != 0) && (!TextUtils.isEmpty(paramString));
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
    if (AppSetting.e) {
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
    this.mRiskSummaryTv.setClickable(paramBoolean ^ true);
    if (!paramBoolean)
    {
      this.mRightSelectorImageView.setVisibility(0);
      this.mRightSelectorImageView.startAnimation(paramString);
    }
    this.mRightSelectorImageView.setClickable(paramBoolean ^ true);
    this.mDunImageView.setImageResource(2130848832);
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
    localRotateAnimation.setDuration(50L);
    localRotateAnimation.setStartOffset(500L);
    paramString.addAnimation((Animation)localObject1);
    paramString.addAnimation((Animation)localObject2);
    paramString.addAnimation((Animation)localObject3);
    paramString.addAnimation(localRotateAnimation);
    if (paramBoolean)
    {
      this.mGouImageView.setVisibility(0);
      this.mGouImageView.startAnimation(paramString);
    }
    else
    {
      this.mInfoImageView.setVisibility(0);
      this.mInfoImageView.startAnimation(paramString);
    }
    setBackground(paramBoolean, true);
    this.bBeingScanning = false;
    this.bBeingStopping = false;
  }
  
  private void updateChangePwdRedTouch()
  {
    if (this.mDevLockRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100199.100199002");
      this.mChangePwdRedTouch.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  private void updateDevLockRedTouch()
  {
    if (this.mDevLockRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100199.100199001");
      this.mDevLockRedTouch.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  private void updateQPIMButtons(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    QSafeManagerBean localQSafeManagerBean = QSafeConfigManager.a().b();
    String str2 = "";
    String str1;
    if (localQSafeManagerBean == null) {
      str1 = "";
    } else {
      str1 = localQSafeManagerBean.a();
    }
    if (showPickProof(paramInt, str1))
    {
      this.mPickproof.setVisibility(0);
      localArrayList.add(this.mPickproof);
      ReportController.a(this.app, "0X800BBA5");
    }
    else
    {
      this.mPickproof.setVisibility(8);
    }
    if (localQSafeManagerBean == null) {
      str1 = str2;
    } else {
      str1 = localQSafeManagerBean.b();
    }
    if (showSecureDetect(paramInt, str1))
    {
      this.qqpimsecureDetectLayout.setVisibility(0);
      localArrayList.add(this.qqpimsecureDetectLayout);
      ReportController.a(this.app, "0X800BBA7");
    }
    else
    {
      this.qqpimsecureDetectLayout.setVisibility(8);
    }
    if ((paramInt & 0x4) != 0)
    {
      this.securityScanCheckBox.setVisibility(0);
      localArrayList.add(this.securityScanCheckBox);
    }
    else
    {
      this.securityScanCheckBox.setVisibility(8);
    }
    paramInt = localArrayList.size();
    if (paramInt == 1)
    {
      setFormItemBgType((RelativeLayout)localArrayList.get(0), 0);
      return;
    }
    if (paramInt == 2)
    {
      setFormItemBgType((RelativeLayout)localArrayList.get(0), 1);
      setFormItemBgType((RelativeLayout)localArrayList.get(1), 3);
      return;
    }
    if (paramInt == 3)
    {
      setFormItemBgType((RelativeLayout)localArrayList.get(0), 1);
      setFormItemBgType((RelativeLayout)localArrayList.get(1), 2);
      setFormItemBgType((RelativeLayout)localArrayList.get(2), 3);
    }
  }
  
  private void writeSecurityStatus(long paramLong, String paramString)
  {
    Object localObject = getSharedPreferences("sp_qs_settings", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qsec_status_expired_time");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      localObject = ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qsec_status_tip_text");
      localStringBuilder.append(this.app.getCurrentAccountUin());
      paramString = ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("qsec_status_update_last_time");
      ((StringBuilder)localObject).append(this.app.getCurrentAccountUin());
      paramString.putLong(((StringBuilder)localObject).toString(), new Date().getTime()).commit();
    }
  }
  
  void dismissSafetyRiskDialog()
  {
    Dialog localDialog = this.mSafetyRiskDialog;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.mSafetyRiskDialog.dismiss();
      label23:
      this.mSafetyRiskDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
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
    boolean bool1;
    if (paramInt1 == 0)
    {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.mDevlockInfo != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        if (this.mDevlockInfo.DevSetup == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool1 = localBundle.getBoolean("auth_dev_open", bool1);
        String str = localBundle.getString("phone_num");
        paramInt1 = this.mDevlockInfo.AllowSet;
        boolean bool2 = localBundle.getBoolean("allow_set");
        if (bool1) {
          this.mDevlockInfo.DevSetup = 1;
        } else {
          this.mDevlockInfo.DevSetup = 0;
        }
        if (!TextUtils.isEmpty(str)) {
          this.mDevlockInfo.Mobile = str;
        }
        if (bool2) {
          this.mDevlockInfo.AllowSet = 1;
        } else {
          this.mDevlockInfo.AllowSet = 0;
        }
        onGetDevLockStatus(this.mDevlockInfo);
        requestRisksInfo();
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("faceStateKey");
        if (!TextUtils.isEmpty(paramIntent)) {
          refreshUserFaceState(Integer.parseInt(paramIntent));
        }
      }
    }
    else
    {
      if (paramInt1 == 1)
      {
        refreshGesturePWDState();
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
      if ((paramInt1 != 11) && (paramInt1 != 21))
      {
        if ((paramInt1 == 12) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
        {
          refreshUserFaceState(0);
          QQToast.makeText(this, getString(2131888976), 0).show();
        }
      }
      else
      {
        QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, resultCode is ", Integer.valueOf(paramInt2) });
        if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
        {
          refreshUserFaceState(1);
          return;
        }
        if (paramIntent == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, data == null ? ", Boolean.valueOf(bool1) });
        if (paramIntent != null) {
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, KEY_FACE_SCAN_RESULT is ", Boolean.valueOf(paramIntent.getBooleanExtra("key_face_scan_result", false)) });
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131625268);
    setTitle(2131897233);
    setTitleTextColor(-1);
    paramBundle = SharedPreUtils.aw(this, getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramBundle)) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        if (paramBundle.optInt("securityType", 0) != 0) {
          break label1601;
        }
        bool2 = true;
        this.mIsGrayAccount = bool2;
        if (paramBundle.optInt("showGroy", 0) != 1) {
          break label1606;
        }
        bool2 = true;
        this.mHasGuideView = bool2;
        bool2 = SharedPreUtils.ax(this, getCurrentAccountUin());
        boolean bool3 = this.mHasGuideView;
        if (bool2) {
          break label1611;
        }
        boolean bool1 = true;
        this.mHasGuideView = (bool1 & bool3);
        QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "mIsGrayAccount : ", Boolean.valueOf(this.mIsGrayAccount), " showGory : ", Boolean.valueOf(this.mHasGuideView) });
      }
      catch (Exception paramBundle)
      {
        QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "parse dev gray switch error : ", paramBundle.getMessage() });
      }
      initVerifiedPhone();
      this.mScrollView = ((BounceScrollView)findViewById(2131444879));
      this.mScrollView.setScrollListener(this);
      this.mScrollView.setPadding(0, 0, 0, 0);
      this.mLoginDevLayout = ((LinearLayout)findViewById(2131439007));
      this.mRiskInfoLayout = ((LinearLayout)findViewById(2131444875));
      paramBundle = (RelativeLayout)findViewById(2131444868);
      this.mQieImageView = ((ImageView)findViewById(2131444877));
      this.mGouImageView = ((ImageView)findViewById(2131444870));
      this.mInfoImageView = ((ImageView)findViewById(2131444872));
      this.mDunImageView = ((ImageView)findViewById(2131444869));
      this.mOuterCircleImageView = ((ImageView)findViewById(2131444882));
      this.mInnerCircleImageView = ((ImageView)findViewById(2131444876));
      this.mScanningProgressImageView = ((ImageView)findViewById(2131444883));
      this.mScanningLineImageView = ((ImageView)findViewById(2131444871));
      this.mTipTextLayout = ((RelativeLayout)findViewById(2131444881));
      this.mRiskSummaryTv = ((TextView)findViewById(2131444880));
      this.mRiskScanningTv = ((TextView)findViewById(2131444878));
      this.mRightSelectorImageView = ((ImageView)findViewById(2131444866));
      if (AppSetting.e) {
        this.mRightSelectorImageView.setContentDescription(getString(2131914202));
      }
      this.mRiskSummaryTv.setClickable(false);
      this.mRiskSummaryTv.setOnClickListener(this);
      this.mRightSelectorImageView.setClickable(false);
      this.mRightSelectorImageView.setOnClickListener(this);
      this.mProtectDevLayout = ((RelativeLayout)findViewById(2131437725));
      ReportController.a(this.app, "0X800B7DC");
      if (this.mIsGrayAccount) {
        this.mProtectDevLayout.post(new LoginInfoActivity.3(this));
      } else {
        this.mDevLockRedTouch = new RedTouch(this, this.mProtectDevLayout).b(27.0F).a();
      }
      this.mRecentLoginDevTv = ((TextView)findViewById(2131439008));
      this.mProtectDevLayout.setOnClickListener(this);
      this.mRecentLoginDevTv.setOnClickListener(this);
      this.mDevProtectTv = ((TextView)findViewById(2131431806));
      this.mFaceLoginLayout = ((RelativeLayout)findViewById(2131432736));
      ReportController.a(this.app, "0X800B7DB");
      this.mTvFaceStatus = ((TextView)findViewById(2131448439));
      this.mPbFace = ((ProgressBar)findViewById(2131432758));
      this.mTvFaceTips = ((TextView)findViewById(2131437730));
      this.mFaceLoginLayout.setOnClickListener(this);
      this.mGesturePwdLayout = ((FormSimpleItem)findViewById(2131434169));
      this.mGesturePwdLayout.setOnClickListener(this);
      ReportController.a(this.app, "0X800B7DD");
      this.mBothOnline = ((FormSwitchItem)findViewById(2131429614));
      if (AppSetting.e) {
        this.mBothOnline.setContentDescription(getString(2131890824));
      }
      this.updateQQPassword = findViewById(2131449137);
      this.updateQQPassword.setOnClickListener(this);
      ReportController.a(this.app, "0X800B7DA");
      this.mChangePwdRedTouch = new RedTouch(this, this.updateQQPassword).b(27.0F).a();
      ReportController.a(null, "dc00898", "", "", "0X800B29B", "0X800B29B", 0, 0, "", "", "", "");
      this.mPickproof = ((FormSimpleItem)findViewById(2131440294));
      this.mPickproof.setOnClickListener(this);
      this.qqpimsecureDetectLayout = ((FormSimpleItem)findViewById(2131442610));
      this.qqpimsecureDetectLayout.setOnClickListener(this);
      if (AppSetting.e) {
        this.qqpimsecureDetectLayout.setContentDescription(getString(2131916171));
      }
      this.securityScanCheckBox = ((FormSwitchItem)findViewById(2131445493));
      if (AppSetting.e) {
        this.securityScanCheckBox.setContentDescription(getString(2131916188));
      }
      this.app.setHandler(getClass(), this.mHandler);
      boolean bool2 = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
      this.mBothOnline.setChecked(bool2);
      this.mBothOnline.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
      bool2 = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
      this.securityScanCheckBox.setChecked(bool2);
      this.securityScanCheckBox.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
      if (!EquipmentLockImpl.a().h()) {
        this.mProtectDevLayout.setVisibility(8);
      }
      this.mRecentLoginDevTv.setMovementMethod(LinkMovementMethod.getInstance());
      paramBundle = new SpannableString(getResources().getString(2131892055));
      this.mStatusView = ((TextView)findViewById(2131431804));
      this.mStatusLoadingView = ((ProgressBar)findViewById(2131440771));
      this.mDevlockStatusIconView = ((ImageView)findViewById(2131431805));
      int i = paramBundle.length();
      paramBundle.setSpan(new LoginInfoActivity.NoLineClickableSpan(this, null), 0, i, 33);
      paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131168008)), 0, i, 33);
      this.mRecentLoginDevTv.setText(paramBundle);
      try
      {
        this.mPageName = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        paramBundle.printStackTrace();
      }
      if (this.mIsGrayAccount)
      {
        this.mDevProtectTv.setText(getString(2131888938));
        this.mBothOnline.setVisibility(8);
        this.mLoginDevLayout.setVisibility(8);
        this.mRecentLoginDevTv.setVisibility(8);
        findViewById(2131437726).setVisibility(0);
        if (this.mHasGuideView)
        {
          ReportController.b(null, "dc00898", "", "", "0X800AC59", "0X800AC59", 0, 0, "", "", "", "");
          this.mDevProtectTv.post(new LoginInfoActivity.4(this));
        }
        ReportController.b(null, "dc00898", "", "", "0X800AC50", "0X800AC50", 0, 0, "", "", "", "");
      }
      else
      {
        addObserver(this.mFriendObserver);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("packName = ");
        paramBundle.append(this.mPageName);
        QLog.d("LoginInfoActivity.AccDevSec", 2, paramBundle.toString());
      }
      setLoginDevData(null);
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate begin to getLoginDevList");
      }
      if (NetworkUtil.isNetSupport(this))
      {
        if (!this.mIsGrayAccount)
        {
          bool2 = EquipmentLockImpl.a().a(this.app, this.mPageName, 0L);
          if (!bool2) {
            QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onCreate getLoginDevList failed ret=", Boolean.valueOf(bool2) });
          }
        }
      }
      else {
        QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
      }
      paramBundle = FaceAreaManager.a().c();
      if (paramBundle != null) {
        paramBundle.a(new View[] { this.mFaceLoginLayout, this.mTvFaceTips });
      }
      if ((paramBundle instanceof UsableAreaStrategy)) {
        startGetFaceDataStatus();
      } else if ((paramBundle instanceof UnusableAreaStrategy)) {
        ReportController.a(null, "dc00898", "", "", "0X800B0EC", "0X800B0EC", 0, 0, "", "", "", "");
      }
      startGetDevLockStatus();
      refreshGesturePWDState();
      requestRisksInfo();
      initAccountReleaseEntrance();
      initSafetyCenterEntrance();
      this.app.registObserver(this.mGameCenterObserver);
      return true;
      label1601:
      bool2 = false;
      continue;
      label1606:
      bool2 = false;
      continue;
      label1611:
      i = 0;
    }
  }
  
  protected void doOnDestroy()
  {
    this.bBeingScanning = false;
    this.bBeingStopping = false;
    SystemBarCompact localSystemBarCompact = this.mCompactBackup;
    if (localSystemBarCompact != null) {
      this.mSystemBarComp = localSystemBarCompact;
    }
    super.doOnDestroy();
    hideProgerssDialog();
    removeObserver(this.mFriendObserver);
    this.mHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    setTitleTextColor(-1);
    startGetDevLockStatus();
    refreshGesturePWDState();
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
  
  protected boolean onBackEvent()
  {
    if (this.mDevlockInfo != null)
    {
      Intent localIntent = new Intent();
      int i = this.mDevlockInfo.DevSetup;
      boolean bool2 = true;
      boolean bool1;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (this.mDevlockInfo.AllowSet != 1) {
        bool2 = false;
      }
      localIntent.putExtra("auth_dev_open", bool1);
      localIntent.putExtra("allow_set", bool2);
      setResult(0, localIntent);
    }
    finish();
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1 = "";
    Object localObject2;
    Object localObject3;
    switch (i)
    {
    default: 
      break;
    case 2131449137: 
      removeChangePwdRedTouch();
      ReportController.a(this.app, "0X800B83E");
      ReportController.a(null, "dc00898", "", "", "0X800B29C", "0X800B29C", 0, 0, "", "", "", "");
      boolean bool;
      if (PhoneNumLoginImpl.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        localObject1 = getUpdatePwdUrl("HasSetPwdUrl");
        bool = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
        if (!bool) {
          localObject1 = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
        }
        if (((String)localObject1).indexOf("?") == -1)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("?uin=");
          ((StringBuilder)localObject3).append(this.app.getCurrentAccountUin());
          localObject1 = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("&uin=");
          ((StringBuilder)localObject3).append(this.app.getCurrentAccountUin());
          localObject1 = ((StringBuilder)localObject3).toString();
        }
        startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
        this.app.sendWirelessPswReq(1);
        if (!bool) {
          reportModifyPwdData("FetchUrl", 1);
        }
        reportModifyPwdData("ClkModifyPwd", 1);
      }
      else
      {
        localObject1 = this.app.getCurrentAccountUin();
        localObject2 = getUpdatePwdUrl("RegNewUrl");
        bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
        if (bool) {
          PwdSetUtil.a((String)localObject2, (String)localObject1, this, this.app);
        } else {
          PwdSetUtil.a((String)localObject1, this, this.app);
        }
        if (!bool) {
          reportModifyPwdData("FetchUrl", 2);
        }
        reportModifyPwdData("ClkModifyPwd", 2);
      }
      break;
    case 2131444866: 
    case 2131444880: 
      localObject1 = this.mRiskInfoItems;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = new Intent(this, RiskInfoActivity.class);
        ((Intent)localObject1).putParcelableArrayListExtra("data", this.mRiskInfoItems);
        ((Intent)localObject1).putExtra("DevlockInfo", this.mDevlockInfo);
        startActivityForResult((Intent)localObject1, 3);
        ReportController.b(this.app, "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800A718", "0X800A718", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "帐号安全页顶部风险提示区域点击“发现XXX等N项风险”文字进入安全风险页！0X800A718");
        }
      }
      break;
    case 2131442610: 
      localObject2 = new Intent();
      localObject3 = QSafeConfigManager.a().b();
      if (localObject3 != null) {
        localObject1 = ((QSafeManagerBean)localObject3).b();
      }
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      RouteUtils.a(this, (Intent)localObject2, "/base/browser", 2);
      ReportController.a(this.app, "0X800BBA8");
      break;
    case 2131442471: 
      if (!this.mIsClickSafetyCenterItem)
      {
        this.mIsClickSafetyCenterItem = true;
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this, "mqqapi://miniapp/open?_atype=0&_mappid=1109907872&_mvid=&_vt=3&via=4010&_sig=1596013484", 4010, null);
        ReportController.b(this.app, "dc00899", "QQSafetyCenter", this.app.getCurrentAccountUin(), "clickQQSafetyCenter", "qq_safety_center_item", 0, 1, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800A719", "0X800A719", 0, 0, "", "", "", "");
        ReportController.a(this.app, "0X800B842");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "帐号安全页点击“QQ安全中心”用户数、次数！0X800A719");
        }
      }
      break;
    case 2131440294: 
      localObject2 = new Intent();
      localObject3 = QSafeConfigManager.a().b();
      if (localObject3 != null) {
        localObject1 = ((QSafeManagerBean)localObject3).a();
      }
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      RouteUtils.a(this, (Intent)localObject2, "/base/browser");
      ReportController.a(this.app, "0X800BBA6");
      break;
    case 2131439008: 
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
      }
      else
      {
        ReportController.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
        startActivity(new Intent(this, RecentLoginDevActivity.class));
      }
      break;
    case 2131437725: 
      if (this.mIsGrayAccount) {
        ReportController.b(null, "dc00898", "", "", "0X800AC51", "0X800AC51", 0, 0, "", "", "", "");
      }
      removeDevLockRedTouch();
      ReportController.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
      ReportController.a(this.app, "0X800B840");
      localObject1 = this.mDevlockInfo;
      if (localObject1 == null)
      {
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
        }
        else
        {
          ReportController.b(null, "dc00898", "", "", "0X800ACBF", "0X800ACBF", 0, 0, "", "", "", "");
          QQToast.makeText(this, getString(2131888935), 0).show();
          startGetDevLockStatus();
        }
      }
      else if (((DevlockInfo)localObject1).DevSetup == 1)
      {
        this.app.sendWirelessMeibaoReq(1);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("phone_num", this.mDevlockInfo.Mobile);
        ((Intent)localObject2).putExtra("country_code", this.mDevlockInfo.CountryCode);
        ((Intent)localObject2).putExtra("auth_dev_open", true);
        ((Intent)localObject2).putExtra("auth_dev_gray_switch", this.mIsGrayAccount);
        localObject1 = this.mSecureInfo;
        if (localObject1 == null)
        {
          ((Intent)localObject2).putExtra("secureState", "secureStateUNKNOWN");
        }
        else
        {
          if (((FaceSecureCheck.SecureCheckResponse)localObject1).bool_sec_pass.get()) {
            localObject1 = "secureStateOk";
          } else {
            localObject1 = "secureStateError";
          }
          ((Intent)localObject2).putExtra("secureState", (String)localObject1);
          if (this.mSecureInfo.bool_sec_pass.get())
          {
            ((Intent)localObject2).putExtra("faceAppId", this.mSecureInfo.str_openid.get());
            ((Intent)localObject2).putExtra("faceTmpKey", this.mSecureInfo.str_tmpkey.get());
          }
        }
        RouteUtils.a(this, (Intent)localObject2, "/base/safe/authDevActivity", 0);
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
        else if (this.mDevlockInfo.AllowSet == 1) {
          handleLoginDevManageIntent();
        }
      }
      break;
    case 2131434169: 
      startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
      ReportController.a(this.app, "0X800B841");
      break;
    case 2131432736: 
      localObject1 = this.mFaceStatusInfo;
      if (localObject1 == null)
      {
        if (!NetworkUtil.isNetSupport(this)) {
          QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
        }
        QLog.e("LoginInfoActivity.AccDevSec", 1, "face_login_layout click error : mFaceStateRsp is null");
      }
      else if (((oidb_0x5e1.RspBody)localObject1).rpt_msg_uin_data.isEmpty())
      {
        QLog.e("LoginInfoActivity.AccDevSec", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
      }
      else
      {
        this.mFaceLoginLayout.setClickable(false);
        localObject3 = this.app;
        localObject1 = this.mDevlockInfo;
        if (localObject1 == null) {
          localObject1 = "";
        } else {
          localObject1 = ((DevlockInfo)localObject1).Mobile;
        }
        localObject2 = this.mDevlockInfo;
        if (localObject2 == null) {
          localObject2 = "";
        } else {
          localObject2 = ((DevlockInfo)localObject2).CountryCode;
        }
        IdentificationUtils.a((AppRuntime)localObject3, this, (String)localObject1, (String)localObject2, this.mHasUnverifiedPhone, this.mFaceStatusInfo, this.mSecureInfo, new LoginInfoActivity.14(this));
        if (((oidb_0x5e1.UdcUinData)this.mFaceStatusInfo.rpt_msg_uin_data.get(0)).user_login_guard_face.get() == 1) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        ReportController.b(null, "dc00898", "", "", "0X800AA7B", "0X800AA7B", 0, 0, (String)localObject1, "", "", "");
        ReportController.a(this.app, "0X800B83F");
      }
      break;
    case 2131431870: 
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
    case 2131431864: 
      ReportController.b(null, "dc00898", "", "", "0X800A5D1", "0X800A5D1", 0, 0, "", "", "", "");
      dismissSafetyRiskDialog();
      break;
    case 2131427478: 
      if (!this.mIsClickReleaseItem)
      {
        this.mIsClickReleaseItem = true;
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("url", this.mAccountReleaseUrl);
        localIntent.putExtra("is_release_account", true);
        startActivityForResult(localIntent, 4);
        ReportController.b(this.app, "dc00898", "", "", "0X8009899", "0X8009899", 0, 0, "", "", "", "");
        ReportController.a(this.app, "0X800B843");
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
      this.mScrollView.setBackgroundResource(2130838958);
      this.mScrollViewBGChanged = false;
      return;
    }
    this.mBeingScrollDown = true;
    changeScrollViewBG();
  }
  
  protected void requestRisksInfo()
  {
    if (!this.bBeingScanning)
    {
      if (this.bBeingStopping) {
        return;
      }
      startSecurityChecking();
      this.mRiskInfoItems = null;
      this.mRiskInfoItems = new ArrayList();
      QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
      localQQProtectRisksRequest.uint32_sec_cmd.set(1);
      localQQProtectRisksRequest.str_package_name.set(QPMiscUtils.a());
      localQQProtectRisksRequest.uint32_app_id.set(AppSetting.d());
      ProtoUtils.a(this.app, new LoginInfoActivity.18(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
    }
  }
  
  void showSafetyRiskDialog()
  {
    try
    {
      dismissSafetyRiskDialog();
      ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
      localReportDialog.setContentView(2131624587);
      TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431880);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131889014));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131431876);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131889011));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131431864);
      if (localTextView1 != null) {
        localTextView1.setText(2131889012);
      }
      TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431870);
      if (localTextView2 != null) {
        localTextView2.setText(2131889013);
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
    Object localObject = this.app.getCurrentAccountUin();
    int i = EquipmentLockImpl.a().a(this.app, (String)localObject, this.mWtLoginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGetDevLockStatus CheckDevLockStatus failed. ret=");
        ((StringBuilder)localObject).append(i);
        QLog.d("LoginInfoActivity.AccDevSec", 2, ((StringBuilder)localObject).toString());
      }
      onGetDevLockStatusFail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */