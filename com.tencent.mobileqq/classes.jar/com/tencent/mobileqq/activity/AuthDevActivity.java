package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
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
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

@RoutePage(desc="设备管理页面", path="/base/safe/authDevActivity")
public class AuthDevActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int FACE_DATA_STATE_HAS_SET = 1;
  public static final int FACE_DATA_STATE_NOT_SET = 0;
  private static final String FROM_QQ_SAFE_MINIAPP = "app_qq_safe_center";
  public static final String KEY_FACE_STATE = "faceStateKey";
  public static final String KEY_FROM = "from";
  public static final int REQ_IDENTIFICATION = 22;
  public static final int REQ_LEGACY = 21;
  public static final int SERVICE_TYPE_SET_FACE = 2;
  private static final String TAG = "Q.devlock.AuthDevActivity";
  private static final String T_ALLOW_BOTH_ONLINE_CLICK = "0X800AC53";
  private static final String T_DEV_MANAGE_PAGE_SHOW = "0X800AC52";
  private static final String T_LOGIN_DEV_PROTECT_CLICK = "0X800AC54";
  private static final String T_PASSED_DEV_CLICK = "0X800AC57";
  private static final String T_PASSED_DEV_DELETE = "0X800AC58";
  private static final String T_RECENT_DEV_CLICK = "0X800AC55";
  private static final String T_RECENT_DEV_DELETE = "0X800AC56";
  private boolean isH5_logic = false;
  private boolean mAllowSet = true;
  private String mAppId;
  private ProgressBar mAuthDevLoadingView;
  private List<SvcDevLoginInfo> mAuthList = null;
  private TextView mAuthListDesc = null;
  private LinearLayout mAuthListLayout = null;
  private FormSwitchItem mBothOnlineButton = null;
  private boolean mCanOpenOrClose = true;
  private Dialog mConfirmDialog;
  private ActionSheet mDelDevSheet = null;
  private DevlockInfo mDevLockInfo;
  private boolean mEnableOpenAllowsetDev = false;
  private oidb_0x5e1.RspBody mFaceStateRsp;
  private FriendListObserver mFriendObserver = new AuthDevActivity.7(this);
  private String mFrom;
  private Handler mHandler = new AuthDevActivity.1(this);
  private List<SvcDevLoginInfo> mHistoryList = new ArrayList();
  private boolean mIsAllowSet = false;
  private boolean mIsAuthDevOpen = false;
  private boolean mIsGrayAccount;
  private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new AuthDevActivity.2(this);
  private List<SvcDevLoginInfo> mOnLineList = new ArrayList();
  private FormSwitchItem mOpenCloseButton = null;
  private String mPageName = "";
  private String mPhoneNum = null;
  private QQProgressDialog mProDialog;
  private ActionSheet mRenameDevSheet = null;
  private Dialog mRiskDialog;
  private SecSvcObserver mSecSvcObserver = new AuthDevActivity.11(this);
  private FaceSecureCheck.SecureCheckResponse mSecureRsp;
  private String mSecureState;
  private String mTmpKey;
  private TextView mTvBottomTips;
  private TextView mWXSyncQQMsgDesc = null;
  private FormSwitchItem mWXSyncQQMsgLayout = null;
  private WtloginObserver mWtLoginObserver = new AuthDevActivity.8(this);
  
  private Dialog createRiskDialog()
  {
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
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(new AuthDevActivity.9(this));
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(new AuthDevActivity.10(this));
    }
    return localReportDialog;
  }
  
  private void dismissSafetyRiskDialog()
  {
    if ((this.mRiskDialog != null) && (this.mRiskDialog.isShowing())) {
      this.mRiskDialog.dismiss();
    }
  }
  
  private void getDevLockInfoError()
  {
    this.mOpenCloseButton.setEnabled(false);
    this.mAuthDevLoadingView.setVisibility(8);
    this.mBothOnlineButton.setEnabled(false);
  }
  
  private void hideProgerssDialog()
  {
    this.mHandler.post(new AuthDevActivity.14(this));
  }
  
  private void initPageUI()
  {
    this.mOpenCloseButton.setChecked(this.mIsAuthDevOpen);
    this.mOpenCloseButton.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    Object localObject = this.app.getHandler(LoginInfoActivity.class);
    if (localObject != null)
    {
      if (this.mIsAuthDevOpen) {
        ((MqqHandler)localObject).obtainMessage(20140331, 1, 0).sendToTarget();
      }
    }
    else
    {
      if (!this.mIsAuthDevOpen) {
        break label105;
      }
      localObject = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
      if (localObject != null) {
        ((SecSvcHandler)localObject).a();
      }
      startGetAuthDevList();
    }
    for (;;)
    {
      return;
      ((MqqHandler)localObject).obtainMessage(20140331, 0, 0).sendToTarget();
      break;
      label105:
      if ((this.mIsAllowSet) && ((EquipmentLockImpl.a().c()) || (this.mEnableOpenAllowsetDev))) {
        onClickOpenCloseDevLockBtn();
      }
      while ("app_qq_safe_center".equals(this.mFrom))
      {
        if (this.mRiskDialog == null) {
          this.mRiskDialog = createRiskDialog();
        }
        this.mRiskDialog.show();
        return;
        if (this.mIsGrayAccount) {
          startGetRecentDevList();
        } else {
          this.mAuthDevLoadingView.setVisibility(8);
        }
      }
    }
  }
  
  private boolean isOnlineDevice(SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    if (paramSvcDevLoginInfo == null) {
      return false;
    }
    Iterator localIterator = this.mOnLineList.iterator();
    while (localIterator.hasNext()) {
      if (Arrays.equals(((SvcDevLoginInfo)localIterator.next()).vecGuid, paramSvcDevLoginInfo.vecGuid)) {
        return true;
      }
    }
    return false;
  }
  
  private void onClickOpenCloseDevLockBtn()
  {
    if (!NetworkUtil.d(this)) {
      QQToast.a(this, getString(2131692257), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      do
      {
        return;
        if (this.mIsAuthDevOpen)
        {
          ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
          ReportController.b(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("DevRpt", 2, "登录保护页点击开关，关闭登录保护的用户数、次数！0X800A71C");
          }
          QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to close dev lock");
          showConfirmCloseDialog();
          return;
        }
        QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to CheckDevLockSms");
        localObject = (DevlockInfo)getIntent().getParcelableExtra("DevlockInfo");
        if ((TextUtils.isEmpty(this.mPhoneNum)) || ((localObject != null) && (((DevlockInfo)localObject).AllowSet == 0)))
        {
          Intent localIntent = new Intent(this, AuthDevOpenUgActivity.class);
          localIntent.putExtra("DevlockInfo", (Parcelable)localObject);
          startActivityForResult(localIntent, 0);
          return;
        }
        if (DevlockPhoneStatus.a().a() == DevlockPhoneStatus.d)
        {
          DevlockPhoneStatus.a().a(this, this.mPhoneNum);
          return;
        }
        ReportController.b(this.app, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
        }
        if (this.mCanOpenOrClose) {
          break;
        }
      } while ((this.mProDialog != null) && (this.mProDialog.isShowing()));
      showProgressDialog();
      return;
      showProgressDialog();
      this.mCanOpenOrClose = false;
      Object localObject = this.app.getCurrentAccountUin();
      i = EquipmentLockImpl.a().a(this.app, (String)localObject, "", null, this.mWtLoginObserver);
    } while (i == 0);
    this.mCanOpenOrClose = true;
    hideProgerssDialog();
    QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.CheckDevLockSms fail ret=" + i);
    QQToast.a(getApplicationContext(), getString(2131692102), 0).b(getTitleBarHeight());
  }
  
  private void showDelDevActionSheet(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131694414);
    }
    this.mDelDevSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    if (paramBoolean1) {}
    for (paramString1 = getString(2131692085, new Object[] { str });; paramString1 = getString(2131692083, new Object[] { str }))
    {
      this.mDelDevSheet.setMainTitle(paramString1);
      this.mDelDevSheet.addRadioButton(getResources().getString(2131692082), 3, false);
      this.mDelDevSheet.addCancelButton(2131690800);
      this.mDelDevSheet.setOnButtonClickListener(new AuthDevActivity.6(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
      this.mDelDevSheet.show();
      return;
    }
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevActivity.13(this));
  }
  
  private void showRenameDevActionSheet(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean3, SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    this.mRenameDevSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131559215, this.mRenameDevSheet.getRootView(), false);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131361984);
    boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, paramArrayOfByte);
    boolean bool2 = isOnlineDevice(paramSvcDevLoginInfo);
    if (this.mIsAuthDevOpen)
    {
      paramSvcDevLoginInfo = getString(2131692056);
      paramArrayOfByte = getString(2131692056);
      if (paramLong2 > 0L)
      {
        paramArrayOfByte = new Date(1000L * paramLong2);
        paramSvcDevLoginInfo = getString(2131692051, new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(paramArrayOfByte) });
        paramArrayOfByte = getString(2131692051, new Object[] { new SimpleDateFormat("yyyy年MM月dd日 HH点mm分", Locale.getDefault()).format(paramArrayOfByte) });
        if ((bool1) || (bool2)) {
          paramSvcDevLoginInfo = getString(2131692058);
        }
        localTextView.setText(paramSvcDevLoginInfo);
        if ((!bool1) && (!bool2)) {
          break label357;
        }
        paramArrayOfByte = getString(2131692058);
      }
      label357:
      for (;;)
      {
        localTextView.setContentDescription(paramArrayOfByte);
        this.mRenameDevSheet.addView(localLinearLayout);
        if (this.mIsAuthDevOpen) {
          this.mRenameDevSheet.addButton(getResources().getString(2131692121), 5, 0);
        }
        if ((!bool1) || (this.mIsAuthDevOpen)) {
          this.mRenameDevSheet.addButton(getResources().getString(2131691563), 3, 1);
        }
        this.mRenameDevSheet.addCancelButton(2131690800);
        this.mRenameDevSheet.setOnButtonClickListener(new AuthDevActivity.5(this, paramString2, paramLong1, paramString1, paramInt, paramBoolean3, paramArrayList, paramBoolean1, paramBoolean2));
        this.mRenameDevSheet.show();
        return;
        QLog.e("Q.devlock.AuthDevActivity", 1, "format login time error: time <= 0");
        break;
      }
    }
    if (bool1) {}
    for (paramArrayOfByte = getString(2131692046);; paramArrayOfByte = getString(2131692084, new Object[] { paramString1 }))
    {
      localTextView.setText(paramArrayOfByte);
      break;
    }
  }
  
  private void startGetAuthDevList()
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList.begin to getAuthLoginDevList");
    boolean bool = EquipmentLockImpl.a().c(this.app, this.mPageName, 0L);
    if (bool)
    {
      this.mAuthListDesc.setVisibility(0);
      this.mAuthListDesc.setText(getString(2131692124));
      this.mAuthDevLoadingView.setVisibility(0);
      this.mTvBottomTips.setText(getString(2131692063));
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList getAuthLoginDevList failed ret =" + bool);
  }
  
  private void startGetRecentDevList()
  {
    boolean bool1 = EquipmentLockImpl.a().b(this.app, this.mPageName, 0L);
    boolean bool2 = EquipmentLockImpl.a().a(this.app, this.mPageName, 0L);
    if ((bool1) && (bool2))
    {
      this.mHistoryList.clear();
      this.mAuthListDesc.setVisibility(0);
      this.mAuthListDesc.setText(getString(2131692129));
      this.mAuthDevLoadingView.setVisibility(0);
      this.mTvBottomTips.setText(getString(2131692062));
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onCreate getRecentLoginDevList failed recentLoginRet=", Boolean.valueOf(bool1), " loginDevRet=", Boolean.valueOf(bool2) });
  }
  
  private void updateHistoryListUI(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.mAuthListDesc.setVisibility(4);
      this.mAuthListLayout.setVisibility(8);
      return;
    }
    this.mAuthListLayout.removeAllViews();
    this.mAuthListLayout.setVisibility(0);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
      if (localSvcDevLoginInfo == null)
      {
        i += 1;
      }
      else
      {
        View localView = getLayoutInflater().inflate(2131561182, this.mAuthListLayout, false);
        RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131369361);
        label127:
        TextView localTextView1;
        Object localObject1;
        if (j == 1)
        {
          localRelativeLayout.setBackgroundResource(2130839575);
          TextView localTextView2 = (TextView)localView.findViewById(2131372115);
          localTextView1 = (TextView)localView.findViewById(2131369051);
          Object localObject2 = localSvcDevLoginInfo.strDeviceName;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getResources().getString(2131694414);
          }
          localObject2 = null;
          boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid);
          boolean bool2 = isOnlineDevice(localSvcDevLoginInfo);
          if (bool1) {
            localObject2 = "（" + getResources().getString(2131694411) + "）";
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localSpannableStringBuilder.append((CharSequence)localObject2);
            AuthDevActivity.3 local3 = new AuthDevActivity.3(this);
            int k = ((String)localObject1).length();
            localSpannableStringBuilder.setSpan(local3, k, ((String)localObject2).length() + k, 33);
          }
          localTextView2.setText(localSpannableStringBuilder);
          localObject1 = new StringBuilder();
          localObject2 = new StringBuilder();
          if (bool2) {
            ((StringBuilder)localObject2).append(getString(2131692057)).append(" ").append(localSvcDevLoginInfo.strDeviceName);
          }
          if ((localSvcDevLoginInfo.iLoginTime > 0L) && (!this.mIsAuthDevOpen)) {
            ((StringBuilder)localObject1).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "yyyy-MM-dd "));
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation)) {
            ((StringBuilder)localObject1).append(localSvcDevLoginInfo.strLoginLocation);
          }
          if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
          {
            if (((StringBuilder)localObject1).length() > 0) {
              ((StringBuilder)localObject1).append(" ");
            }
            ((StringBuilder)localObject1).append(localSvcDevLoginInfo.strDeviceTypeInfo);
          }
          if ((!bool2) || (this.mIsAuthDevOpen)) {
            break label579;
          }
          localTextView1.setText(((StringBuilder)localObject2).toString());
        }
        for (;;)
        {
          localRelativeLayout.setClickable(true);
          localRelativeLayout.setTag(localSvcDevLoginInfo);
          localRelativeLayout.setOnClickListener(new AuthDevActivity.4(this, paramList, localRelativeLayout, i, localSvcDevLoginInfo));
          this.mAuthListLayout.addView(localView);
          break;
          if (i == 0)
          {
            localRelativeLayout.setBackgroundResource(2130839591);
            break label127;
          }
          if (i == j - 1)
          {
            localRelativeLayout.setBackgroundResource(2130839582);
            break label127;
          }
          localRelativeLayout.setBackgroundResource(2130839585);
          break label127;
          label579:
          if (((StringBuilder)localObject1).length() > 0) {
            localTextView1.setText(((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    paramList = this.mAuthListDesc;
    if (this.mAuthListLayout.getChildCount() == 0) {}
    for (i = 4;; i = 0)
    {
      paramList.setVisibility(i);
      return;
    }
  }
  
  void dismissConfirmCloseDialog()
  {
    if ((this.mConfirmDialog == null) || (this.mConfirmDialog.isShowing())) {}
    try
    {
      this.mConfirmDialog.dismiss();
      label24:
      this.mConfirmDialog = null;
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
  
  public void doOnResume()
  {
    super.doOnResume();
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt1 == 0)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode is 0, resultCode is : ", Integer.valueOf(paramInt2) });
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.mDevLockInfo != null))
      {
        paramIntent = paramIntent.getExtras();
        if (this.mDevLockInfo.DevSetup != 1) {
          break label319;
        }
        bool1 = true;
        boolean bool2 = paramIntent.getBoolean("auth_dev_open", bool1);
        String str = paramIntent.getString("phone_num");
        if (this.mDevLockInfo.AllowSet != 1) {
          break label325;
        }
        bool1 = true;
        label114:
        boolean bool3 = paramIntent.getBoolean("allow_set");
        QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "status is ", Boolean.valueOf(bool1), "open is ", Boolean.valueOf(bool2), " status is ", Boolean.valueOf(bool1), " allowSet is ", Boolean.valueOf(bool3) });
        if (!bool2) {
          break label331;
        }
        this.mDevLockInfo.DevSetup = 1;
        label205:
        this.mIsAuthDevOpen = bool2;
        if (!TextUtils.isEmpty(str))
        {
          this.mDevLockInfo.Mobile = str;
          this.mPhoneNum = str;
        }
        this.mAllowSet = bool3;
        if (!bool3) {
          break label342;
        }
      }
    }
    label319:
    label325:
    label331:
    label342:
    for (this.mDevLockInfo.AllowSet = 1;; this.mDevLockInfo.AllowSet = 0)
    {
      if (this.mIsAuthDevOpen)
      {
        this.mOpenCloseButton.setOnCheckedChangeListener(null);
        this.mOpenCloseButton.setChecked(true);
        this.mOpenCloseButton.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        startGetAuthDevList();
        paramIntent = this.app.getHandler(LoginInfoActivity.class);
        if (paramIntent != null) {
          paramIntent.obtainMessage(20140331, 1, 0).sendToTarget();
        }
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label114;
      this.mDevLockInfo.DevSetup = 0;
      break label205;
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getExtras();
      if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("devlock_need_broadcast"))) {}
    }
    for (boolean bool = ((Bundle)localObject1).getBoolean("devlock_need_broadcast");; bool = false)
    {
      if (bool)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
        ((Intent)localObject1).putExtra("auth_dev_open", this.mIsAuthDevOpen);
        if (this.mIsAuthDevOpen)
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
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("auth_dev_open", this.mIsAuthDevOpen);
      ((Intent)localObject1).putExtra("allow_set", this.mAllowSet);
      ((Intent)localObject1).putExtra("phone_num", this.mPhoneNum);
      if ((this.mFaceStateRsp != null) && (!this.mFaceStateRsp.rpt_msg_uin_data.isEmpty())) {
        ((Intent)localObject1).putExtra("faceStateKey", String.valueOf(((oidb_0x5e1.UdcUinData)this.mFaceStateRsp.rpt_msg_uin_data.get(0)).user_login_guard_face.get()));
      }
      setResult(0, (Intent)localObject1);
      if ((AuthDevOpenUgActivity.a()) && (this.isH5_logic))
      {
        finish();
        startActivity(new Intent(this, LoginInfoActivity.class));
      }
      finish();
      return false;
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
      Object localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
      ((Intent)localObject).putExtra("hide_more_button", true);
      startActivity((Intent)localObject);
      ReportController.b(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        QLog.d("DevRpt", 2, "点击帮助！0X800A720");
        continue;
        onClickOpenCloseDevLockBtn();
        continue;
        dismissConfirmCloseDialog();
        ReportController.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
        if (QLog.isColorLevel())
        {
          QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击取消！0X800A71E");
          continue;
          int i;
          try
          {
            dismissConfirmCloseDialog();
            localObject = getSharedPreferences(LoginInfoActivity.md5sum(getCurrentAccountUin()) + "_" + LoginInfoActivity.LAST_DIALOG_SHOW_TIME, 0).edit();
            ((SharedPreferences.Editor)localObject).putLong(LoginInfoActivity.LAST_DIALOG_SHOW_TIME, System.currentTimeMillis());
            ((SharedPreferences.Editor)localObject).commit();
            ReportController.b(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
            }
            ReportController.b(this.app, "dc00899", "DevLockSwitchDialog", this.app.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
            }
            if (!this.mCanOpenOrClose)
            {
              if ((this.mProDialog != null) && (this.mProDialog.isShowing())) {
                continue;
              }
              showProgressDialog();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            showProgressDialog();
            this.mCanOpenOrClose = false;
            String str = this.app.getCurrentAccountUin();
            i = EquipmentLockImpl.a().a(this.app, str, this.mWtLoginObserver);
          }
          if (i != 0)
          {
            hideProgerssDialog();
            this.mCanOpenOrClose = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.CloseDevLock fail ret =" + i);
            }
            QQToast.a(getApplicationContext(), getString(2131692068), 0).b(getTitleBarHeight());
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131561181);
    this.mAuthListLayout = ((LinearLayout)super.findViewById(2131363119));
    this.mAuthDevLoadingView = ((ProgressBar)super.findViewById(2131373581));
    this.mTvBottomTips = ((TextView)findViewById(2131380205));
    this.mOpenCloseButton = ((FormSwitchItem)super.findViewById(2131363127));
    this.mBothOnlineButton = ((FormSwitchItem)findViewById(2131363768));
    this.mAuthListDesc = ((TextView)super.findViewById(2131363121));
    this.mAuthListDesc.setVisibility(4);
    this.mWXSyncQQMsgLayout = ((FormSwitchItem)super.findViewById(2131382069));
    this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    this.mWXSyncQQMsgLayout.setVisibility(8);
    this.mWXSyncQQMsgDesc = ((TextView)super.findViewById(2131382068));
    this.mWXSyncQQMsgDesc.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131693178);
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
      this.leftView.setText(2131699149);
    }
    if (this.app == null)
    {
      QLog.e("Q.devlock.AuthDevActivity", 1, "app is null, refresh app");
      this.app = ((QQAppInterface)getAppRuntime());
    }
    if (this.app == null)
    {
      finish();
      QLog.e("Q.devlock.AuthDevActivity", 1, "error : app is null");
      return;
    }
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
    this.mBothOnlineButton.setChecked(bool);
    this.mBothOnlineButton.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    if (AppSetting.d)
    {
      this.mOpenCloseButton.setContentDescription(getString(2131692099));
      this.rightViewText.setContentDescription(getString(2131692067));
      this.mBothOnlineButton.setContentDescription(getString(2131693321));
    }
    try
    {
      this.mPageName = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "packName = " + this.mPageName);
      }
      addObserver(this.mFriendObserver);
      addObserver(this.mSecSvcObserver);
      this.mFrom = paramBundle.getStringExtra("from");
      if ("app_qq_safe_center".equals(this.mFrom))
      {
        paramBundle = SharedPreUtils.j(this, getCurrentAccountUin());
        if (!TextUtils.isEmpty(paramBundle)) {}
        try
        {
          if (new JSONObject(paramBundle).optInt("securityType", 0) != 0) {
            break label517;
          }
          bool = true;
          this.mIsGrayAccount = bool;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "parse dev gray switch error : ", paramBundle.getMessage() });
          }
        }
        startGetDevLockStatus();
        if (this.mIsGrayAccount) {
          break label756;
        }
        this.mBothOnlineButton.setVisibility(8);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        continue;
        label517:
        bool = false;
        continue;
        this.mIsGrayAccount = paramBundle.getExtras().getBoolean("auth_dev_gray_switch");
        this.mIsAuthDevOpen = paramBundle.getExtras().getBoolean("auth_dev_open");
        this.mPhoneNum = paramBundle.getExtras().getString("phone_num");
        this.mIsAllowSet = paramBundle.getExtras().getBoolean("allow_set");
        this.mEnableOpenAllowsetDev = paramBundle.getExtras().getBoolean("enable_open_allowset_dev");
        this.isH5_logic = paramBundle.getExtras().getBoolean("h5_flag");
        this.mSecureState = paramBundle.getExtras().getString("secureState", "secureStateUNKNOWN");
        this.mDevLockInfo = ((DevlockInfo)paramBundle.getParcelableExtra("DevlockInfo"));
        if ("secureStateOk".equals(this.mSecureState))
        {
          this.mAppId = paramBundle.getStringExtra("faceAppId");
          this.mTmpKey = paramBundle.getStringExtra("faceTmpKey");
          this.mSecureRsp = new FaceSecureCheck.SecureCheckResponse();
          this.mSecureRsp.bool_sec_pass.set(true);
          this.mSecureRsp.str_tmpkey.set(this.mTmpKey);
          this.mSecureRsp.str_openid.set(this.mAppId);
        }
        initPageUI();
      }
      label756:
      super.setTitle(2131692052);
      this.rightViewText.setVisibility(8);
      ReportController.b(null, "dc00898", "", "", "0X800AC52", "0X800AC52", 0, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    hideProgerssDialog();
    dismissSafetyRiskDialog();
    removeObserver(this.mFriendObserver);
    removeObserver(this.mSecSvcObserver);
  }
  
  void showConfirmCloseDialog()
  {
    dismissConfirmCloseDialog();
    ReportDialog localReportDialog = new ReportDialog(this, 2131755842);
    localReportDialog.setContentView(2131559060);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365811);
    if (localTextView != null) {
      localTextView.setText(getString(2131692070));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365807);
    if (localTextView != null)
    {
      localObject = (MessageRoamManager)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      if ((localObject != null) && (((MessageRoamManager)localObject).h()) && (((MessageRoamManager)localObject).b() == 1)) {}
      localTextView.setText(getString(2131692061));
    }
    localTextView = (TextView)localReportDialog.findViewById(2131365796);
    if (localTextView != null) {
      localTextView.setText(2131690946);
    }
    Object localObject = (TextView)localReportDialog.findViewById(2131365802);
    if (localObject != null) {
      ((TextView)localObject).setText(2131690800);
    }
    localReportDialog.setOnDismissListener(new AuthDevActivity.12(this));
    if (localTextView != null) {
      localTextView.setOnClickListener(this);
    }
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(this);
    }
    this.mConfirmDialog = localReportDialog;
    this.mConfirmDialog.show();
  }
  
  public void startGetDevLockStatus()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.app.getCurrentAccountUin();
    int i = EquipmentLockImpl.a().a(this.app, str, this.mWtLoginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      getDevLockInfoError();
      QQToast.a(this, getString(2131694461), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */