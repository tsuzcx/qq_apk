package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONArray;
import org.json.JSONObject;

@RoutePage(desc="设备验证", path="/base/safe/authDevOpenActivity")
public class AuthDevOpenUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String H5_CALL_ME = "AUTH_DEV_OPEN_UG_ACTIVITY";
  public static final String KEY_ALLOW_SET = "allow_set";
  public static final String KEY_AUTH_DEV_OPEN = "auth_dev_open";
  public static final String KEY_COUNTRY_CODE = "country_code";
  public static final String KEY_DEVLOCK_INFO = "DevlockInfo";
  public static final String KEY_IS_FROM_LOGIN = "from_login";
  public static final String KEY_PHONE_NUM = "phone_num";
  public static final String KEY_USER_GUIDE = "user_guide";
  public static final String KEY_USER_UIN = "user_uin";
  public static final String KEY_VERIFY_SEQ = "seq";
  public static final int REQUEST_CODE_OPEN_AUTH_DEV = 1001;
  public static final int REQUEST_CODE_SET_MOBILE = 1003;
  public static final int REQUEST_CODE_VERIFY_AUTH_DEV = 1002;
  public static final int REQUEST_CODE_VERIFY_PASSWD = 1004;
  private static final String TAG = "Q.devlock.AuthDevOpenUgActivity";
  private static boolean isH5Jump = false;
  private static final String mManually = "Manually";
  private static final String mUserBehavior = "UserBehavior";
  private Button mBottomBtn;
  private DevlockInfo mDevlockInfo = null;
  private String mFromWhere;
  private boolean mIsFromLogin = false;
  private String mMainAccount;
  private boolean mShowAuthDevList = true;
  private String mUin;
  VerifyDevLockManager.VerifyDevLockObserver mVerifyObserver = new AuthDevOpenUgActivity.2(this);
  private int mVerifySeq;
  private WtloginObserver mWtLoginObserver = new AuthDevOpenUgActivity.1(this);
  private int nGuideImageResID = 0;
  private String strBottomBtnText;
  private String strConfirmPageParaDown;
  private String strConfirmPageParaUp;
  private String strDlgPcItemText;
  private String strDlgPhoneItemText;
  private String strDlgTitleText;
  private String strGuideContent;
  private String strJumpText;
  
  private boolean checkIsH5CallMe(Bundle paramBundle)
  {
    return "true".equals(paramBundle.getString("AUTH_DEV_OPEN_UG_ACTIVITY"));
  }
  
  private void doClickOpenDevLockBtn(DevlockInfo paramDevlockInfo)
  {
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 3);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Object localObject = DevlockPhoneStatus.a();
    if ((localObject != null) && (((DevlockPhoneStatus)localObject).b() == DevlockPhoneStatus.d))
    {
      if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.Mobile))) {
        paramDevlockInfo = paramDevlockInfo.Mobile;
      } else {
        paramDevlockInfo = "";
      }
      ((DevlockPhoneStatus)localObject).a(this, paramDevlockInfo);
      return;
    }
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.Mobile)))
    {
      if ((paramDevlockInfo.AllowSet == 1) && (paramDevlockInfo.DevSetup != 1))
      {
        if (EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), "", null, this.mWtLoginObserver) != 0) {
          QQToast.makeText(getApplicationContext(), getString(2131888988), 0).show(getTitleBarHeight());
        }
        if (isH5Jump)
        {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "BIND_AND_CREDIT_NOT_OPEN_DEVLOCK" });
          EquipmentLockImpl.a().b(null, this.app.getCurrentAccountUin(), 9);
          finish();
          startActivity(new Intent(this, LoginInfoActivity.class));
        }
      }
      else if (paramDevlockInfo.DevSetup == 1)
      {
        if (isH5Jump)
        {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "OPENED_DEVLOCK" });
          finish();
          startActivity(new Intent(this, LoginInfoActivity.class));
        }
      }
      else
      {
        if (isH5Jump)
        {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "BIND_BUT_CREDIT_NOT_OPEN_DEVLOCK" });
          EquipmentLockImpl.a().b(null, this.app.getCurrentAccountUin(), 7);
        }
        localObject = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
        if (getIntent() != null) {
          ((Intent)localObject).putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
        }
        ((Intent)localObject).putExtra("ParaTextUp", this.strConfirmPageParaUp);
        ((Intent)localObject).putExtra("ParaTextDown", this.strConfirmPageParaDown);
        ((Intent)localObject).putExtra("PhoneNO", paramDevlockInfo.Mobile);
        ((Intent)localObject).putExtra("mainaccount", this.mMainAccount);
        ((Intent)localObject).putExtra("uin", this.mUin);
        ((Intent)localObject).putExtra("from_where", this.mFromWhere);
        ((Intent)localObject).putExtra("DevlockInfo", paramDevlockInfo);
        startActivityForResult((Intent)localObject, 1001);
        overridePendingTransition(0, 2130772014);
      }
    }
    else
    {
      if (isH5Jump)
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "NO_BIND_AND_NO_CREDIT_NOT_OPEN_DEVLOCK" });
        EquipmentLockImpl.a().b(null, this.app.getCurrentAccountUin(), 6);
      }
      EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.c, 1003, null);
    }
  }
  
  public static boolean getIsH5Jump()
  {
    return isH5Jump;
  }
  
  private void initUI(String paramString)
  {
    Object localObject = (TextView)findViewById(2131434517);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setVisibility(8);
    } else {
      ((TextView)localObject).setText(paramString);
    }
    localObject = this.mBottomBtn;
    if (!TextUtils.isEmpty(this.strBottomBtnText)) {
      paramString = this.strBottomBtnText;
    } else {
      paramString = getString(2131888982);
    }
    ((Button)localObject).setText(paramString);
    this.mBottomBtn.setContentDescription(getString(2131888951));
    if (!TextUtils.isEmpty(this.strDlgTitleText)) {
      setTitle(this.strDlgTitleText);
    }
    if (this.nGuideImageResID != 0)
    {
      paramString = (ImageView)findViewById(2131434501);
      if (paramString != null) {
        paramString.setImageResource(this.nGuideImageResID);
      }
    }
    if (!TextUtils.isEmpty(this.strJumpText))
    {
      paramString = (Button)findViewById(2131434502);
      if (paramString != null)
      {
        paramString.setVisibility(0);
        paramString.setText(this.strJumpText);
        paramString.setOnClickListener(this);
      }
    }
    EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 1);
  }
  
  private void parseJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.strGuideContent = paramString.getString("title");
      this.strBottomBtnText = paramString.getString("smallTitle");
      this.strDlgTitleText = paramString.getString("guideTitle");
      paramString = paramString.getJSONArray("guideArray");
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i = 0;
        while (i < paramString.length())
        {
          String str = paramString.getString(i);
          if (i == 0) {
            this.strDlgPcItemText = str;
          } else if (i == 1) {
            this.strDlgPhoneItemText = str;
          } else if (i == 2) {
            this.strConfirmPageParaUp = str;
          } else if (i == 3) {
            this.strConfirmPageParaDown = str;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "parseJson error.");
      }
    }
  }
  
  private void tryBroadcastDevlockStatus(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = getIntent();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Intent)localObject1).getExtras();
    if (localObject1 == null) {
      return;
    }
    if (!((Bundle)localObject1).containsKey("devlock_need_broadcast")) {
      return;
    }
    if (!((Bundle)localObject1).getBoolean("devlock_need_broadcast")) {
      return;
    }
    localObject1 = new Intent();
    ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
    ((Intent)localObject1).putExtra("auth_dev_open", paramBoolean);
    ((Intent)localObject1).putExtra("auth_dev_open_cb_reason", paramInt);
    if (paramBoolean)
    {
      Object localObject2 = (WtloginManager)this.app.getManager(1);
      if (localObject2 != null)
      {
        localObject2 = ((WtloginManager)localObject2).getLocalTicket(this.app.getCurrentAccountUin(), 16L, 33554432);
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("devlock_roam_sig", ((Ticket)localObject2)._sig);
        }
      }
    }
    sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
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
    Object localObject;
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getExtras().getInt("requestCode") == 1002))
        {
          finishSelf(-1, paramIntent);
          return;
        }
        DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
        tryBroadcastDevlockStatus(true, 0);
        if (EquipmentLockImpl.a().f())
        {
          paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
          localObject = this.mDevlockInfo;
          if (localObject != null)
          {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            paramIntent.putExtra("country_code", this.mDevlockInfo.CountryCode);
          }
          if (isH5Jump) {
            paramIntent.putExtra("h5_flag", true);
          }
          startActivity(paramIntent);
        }
        else if (this.mShowAuthDevList)
        {
          paramIntent = new Intent();
          localObject = this.mDevlockInfo;
          if (localObject != null)
          {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            paramIntent.putExtra("country_code", this.mDevlockInfo.CountryCode);
          }
          if (getIntent() != null) {
            paramIntent.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
          }
          paramIntent.putExtra("auth_dev_open", true);
          if (isH5Jump) {
            paramIntent.putExtra("h5_flag", true);
          }
          RouteUtils.a(this, paramIntent, "/base/safe/authDevActivity");
        }
        paramIntent = new Intent();
        paramIntent.putExtra("allow_set", true);
        localObject = this.mDevlockInfo;
        if (localObject != null) {
          paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
        }
        finishSelf(-1, paramIntent);
      }
    }
    else if (paramInt1 == 1002)
    {
      if (paramInt2 == -1) {
        finish();
      }
    }
    else if (paramInt1 == 1003)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onActivityResult.resultCode= RESULT_OK  resultState =");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt1 == 2)
        {
          localObject = paramIntent.getExtras().getString("resultMobileMask");
          boolean bool = paramIntent.getExtras().getBoolean("resultSetMobile");
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("onActivityResult.resultCode= RESULT_OK  resultMobileMask =");
            paramIntent.append((String)localObject);
            paramIntent.append(" openSuccess=");
            paramIntent.append(bool);
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, paramIntent.toString());
          }
          paramIntent = this.mDevlockInfo;
          if (paramIntent != null) {
            paramIntent.Mobile = ((String)localObject);
          }
          if (!bool) {
            return;
          }
          EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
          tryBroadcastDevlockStatus(true, 0);
          bool = EquipmentLockImpl.a().f();
          paramIntent = new Intent(getIntent());
          localObject = this.mDevlockInfo;
          if (localObject != null)
          {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
            paramIntent.putExtra("country_code", this.mDevlockInfo.CountryCode);
          }
          if (bool)
          {
            paramIntent.setClass(this, AuthDevEnableCompleteActivity.class);
            startActivity(paramIntent);
          }
          else if (this.mShowAuthDevList)
          {
            paramIntent.putExtra("auth_dev_open", true);
            RouteUtils.a(this, paramIntent, "/base/safe/authDevActivity");
          }
          QQToast.makeText(getApplicationContext(), 2, getString(2131888947), 0).show(getTitleBarHeight());
          paramIntent = new Intent();
          paramIntent.putExtra("auth_dev_open", true);
          paramIntent.putExtra("allow_set", true);
          localObject = this.mDevlockInfo;
          if (localObject != null) {
            paramIntent.putExtra("phone_num", ((DevlockInfo)localObject).Mobile);
          }
          finishSelf(-1, paramIntent);
        }
      }
      else if ((paramInt2 == 0) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onActivityResult.resultCode= RESULT_CANCELED resultState =");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject).toString());
        }
        if (paramInt1 == 2)
        {
          paramIntent = paramIntent.getExtras().getString("resultMobileMask");
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =");
            ((StringBuilder)localObject).append(paramIntent);
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject).toString());
          }
          if (!TextUtils.isEmpty(paramIntent)) {
            EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), null);
          }
          localObject = this.mDevlockInfo;
          if (localObject != null) {
            ((DevlockInfo)localObject).Mobile = paramIntent;
          }
        }
      }
    }
    else if (paramInt1 == 1004)
    {
      if (paramInt2 == 3000)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd failed");
        }
        tryBroadcastDevlockStatus(false, 3);
        finish();
        overridePendingTransition(2130771994, 2130771995);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd succ");
      }
      paramIntent = this.mDevlockInfo;
      if (paramIntent == null)
      {
        EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), this.mWtLoginObserver);
        return;
      }
      doClickOpenDevLockBtn(paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = super.getIntent();
    if (localObject1 == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    Bundle localBundle = ((Intent)localObject1).getExtras();
    if (localBundle == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    isH5Jump = checkIsH5CallMe(localBundle);
    EquipmentLockImpl.a().a(false);
    Object localObject2 = localBundle.getString("devlock_open_source");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "Manually";
    }
    EquipmentLockImpl.a().b((String)localObject1);
    this.mIsFromLogin = localBundle.getBoolean("from_login");
    this.mVerifySeq = localBundle.getInt("seq");
    this.mDevlockInfo = ((DevlockInfo)localBundle.get("DevlockInfo"));
    this.mUin = localBundle.getString("uin");
    this.mFromWhere = localBundle.getString("from_where");
    this.mMainAccount = localBundle.getString("mainaccount");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate mIsFromLogin = ");
      ((StringBuilder)localObject2).append(this.mIsFromLogin);
      ((StringBuilder)localObject2).append(" mVerifySeq=");
      ((StringBuilder)localObject2).append(this.mVerifySeq);
      ((StringBuilder)localObject2).append(" mUin=");
      ((StringBuilder)localObject2).append(this.mUin);
      ((StringBuilder)localObject2).append(" mFromWhere=");
      ((StringBuilder)localObject2).append(this.mFromWhere);
      ((StringBuilder)localObject2).append(" mMainAccount=");
      ((StringBuilder)localObject2).append(this.mMainAccount);
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject2).toString());
      if (this.mDevlockInfo != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onCreate DevlockInfo devSetup:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.DevSetup);
        ((StringBuilder)localObject2).append(" countryCode:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.CountryCode);
        ((StringBuilder)localObject2).append(" mobile:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.Mobile);
        ((StringBuilder)localObject2).append(" MbItemSmsCodeStatus:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.MbItemSmsCodeStatus);
        ((StringBuilder)localObject2).append(" TimeLimit:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.TimeLimit);
        ((StringBuilder)localObject2).append(" AvailableMsgCount:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.AvailableMsgCount);
        ((StringBuilder)localObject2).append(" AllowSet:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.AllowSet);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DevlockInfo.ProtectIntro:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.ProtectIntro);
        ((StringBuilder)localObject2).append("  info.MbGuideType:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.MbGuideType);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DevlockInfo.MbGuideMsg:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.MbGuideMsg);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DevlockInfo.MbGuideInfoType:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.MbGuideInfoType);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DevlockInfo.MbGuideInfo:");
        ((StringBuilder)localObject2).append(this.mDevlockInfo.MbGuideInfo);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject2).toString());
      }
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131627393);
    super.setTitle(2131888985);
    if (this.app == null) {
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    if (TextUtils.equals((CharSequence)localObject1, "PhoneUnity")) {
      this.leftView.setText(2131897269);
    }
    this.mBottomBtn = ((Button)findViewById(2131449023));
    this.mBottomBtn.setOnClickListener(this);
    this.mShowAuthDevList = localBundle.getBoolean("devlock_show_auth_dev_list", true);
    paramBundle = localBundle.getString("devlock_guide_config");
    if (!TextUtils.isEmpty(paramBundle))
    {
      try
      {
        paramBundle = new JSONObject(paramBundle);
        this.strDlgTitleText = paramBundle.getString("title");
        this.strGuideContent = paramBundle.getString("wording");
        this.nGuideImageResID = paramBundle.getInt("image_res_id");
        this.strBottomBtnText = paramBundle.getString("btn_text");
        this.strJumpText = paramBundle.getString("jump_text");
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    else
    {
      paramBundle = this.mDevlockInfo;
      if (paramBundle != null) {
        parseJson(paramBundle.ProtectIntro);
      }
    }
    if (TextUtils.isEmpty(this.strGuideContent)) {
      this.strGuideContent = getString(2131888981);
    }
    if (TextUtils.isEmpty(this.strDlgPcItemText)) {
      this.strDlgPcItemText = getString(2131888964);
    }
    if (TextUtils.isEmpty(this.strDlgPhoneItemText)) {
      this.strDlgPhoneItemText = getString(2131888965);
    }
    if (TextUtils.isEmpty(this.strConfirmPageParaUp)) {
      this.strConfirmPageParaUp = getString(2131888961);
    }
    if (TextUtils.isEmpty(this.strConfirmPageParaDown)) {
      this.strConfirmPageParaDown = getString(2131888962);
    }
    if (TextUtils.isEmpty(this.strDlgTitleText)) {
      this.strDlgTitleText = getString(2131888966);
    }
    initUI(this.strGuideContent);
    this.mVerifyObserver.setSeq(this.mVerifySeq);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, LoginInfoActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public void finishSelf(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    if (getIntent().getBooleanExtra("open_devlock_from_roam", false))
    {
      finish();
      overridePendingTransition(2130771994, 2130771995);
      return;
    }
    finish();
  }
  
  protected boolean onBackEvent()
  {
    tryBroadcastDevlockStatus(false, 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    DevlockInfo localDevlockInfo = this.mDevlockInfo;
    if ((localDevlockInfo != null) && (!TextUtils.isEmpty(localDevlockInfo.Mobile))) {
      localIntent.putExtra("phone_num", this.mDevlockInfo.Mobile);
    }
    finishSelf(0, localIntent);
    if (isH5Jump) {
      startActivity(new Intent(this, LoginInfoActivity.class));
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131434502)
    {
      Object localObject;
      if (i != 2131436211)
      {
        if (i == 2131449023)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A71F", "0X800A71F", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("DevRpt", 2, "点击打开设备锁上报！0X800A71F");
          }
          if (getIntent().getBooleanExtra("open_devlock_verify_passwd", false))
          {
            localObject = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", "https://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "open_devlock"));
            startActivityForResult((Intent)localObject, 1004);
          }
          else
          {
            localObject = this.mDevlockInfo;
            if (localObject == null) {
              EquipmentLockImpl.a().a(this.app, this.app.getCurrentAccountUin(), this.mWtLoginObserver);
            } else {
              doClickOpenDevLockBtn((DevlockInfo)localObject);
            }
          }
          localObject = getIntent().getStringExtra("devlock_open_source");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).equals("RoamMsg")) || (((String)localObject).equals("RoamMsgWeb")))) {
            VipUtils.a(this.app, "chat_history", "LockSet", "Clk_buttonUse", 1, 0, new String[0]);
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onClick.cancelVerifyCode mVerifyObserver.seq=");
          ((StringBuilder)localObject).append(this.mVerifyObserver.getSeq());
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, ((StringBuilder)localObject).toString());
        }
        EquipmentLockImpl.a().a(this.app, this.mVerifyObserver);
        this.mVerifyObserver = null;
        finish();
        overridePendingTransition(0, 2130772018);
      }
    }
    else
    {
      tryBroadcastDevlockStatus(false, 2);
      finish();
      overridePendingTransition(2130771994, 2130771995);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevOpenUgActivity
 * JD-Core Version:    0.7.0.1
 */