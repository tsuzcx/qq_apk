package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.wx_msg_opt.ReqBody;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.identity.IDevListView;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
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
  extends QIphoneTitleBarActivity
  implements View.OnClickListener, IDevListView
{
  private static final String FROM_QQ_SAFE_MINIAPP = "app_qq_safe_center";
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
  private IFriendObserver mDevListObserver;
  private DevlockInfo mDevLockInfo;
  private BusinessObserver mDevLockObserver;
  private boolean mEnableOpenAllowsetDev = false;
  private oidb_0x5e1.RspBody mFaceStateRsp;
  private String mFrom;
  private Handler mHandler = new Handler();
  private List<SvcDevLoginInfo> mHistoryList = new ArrayList();
  private boolean mIsAllowSet = false;
  private boolean mIsAuthDevOpen = false;
  private boolean mIsGrayAccount;
  private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new AuthDevActivity.1(this);
  private List<SvcDevLoginInfo> mOnLineList = new ArrayList();
  private FormSwitchItem mOpenCloseButton = null;
  private String mPageName = "";
  private String mPhoneNum = null;
  private QQProgressDialog mProDialog;
  private ActionSheet mRenameDevSheet = null;
  private Dialog mRiskDialog;
  private ISafeApi mSafeApi;
  private FaceSecureCheck.SecureCheckResponse mSecureRsp;
  private String mSecureState;
  private int mSeq;
  private String mTmpKey;
  private TextView mTvBottomTips;
  private TextView mWXSyncQQMsgDesc = null;
  private FormSwitchItem mWXSyncQQMsgLayout = null;
  private WtloginObserver mWtLoginObserver = new AuthDevActivity.6(this);
  
  private ToServiceMsg buildWxSyncReq(BusinessHandler paramBusinessHandler)
  {
    wx_msg_opt.ReqBody localReqBody = new wx_msg_opt.ReqBody();
    localReqBody.uint64_uin.set(this.mRuntime.getLongAccountUin());
    localReqBody.uint32_cmd.set(1);
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_seq;
    int i = this.mSeq;
    this.mSeq = (i + 1);
    localPBUInt32Field.set(i);
    localReqBody.uint32_opt.set(1);
    paramBusinessHandler = paramBusinessHandler.createToServiceMsg("DevLockAuthSvc.WxMsgOpt");
    paramBusinessHandler.putWupBuffer(localReqBody.toByteArray());
    return paramBusinessHandler;
  }
  
  private Dialog createRiskDialog()
  {
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
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(new AuthDevActivity.7(this));
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(new AuthDevActivity.8(this));
    }
    return localReportDialog;
  }
  
  private void dismissSafetyRiskDialog()
  {
    Dialog localDialog = this.mRiskDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.mRiskDialog.dismiss();
    }
  }
  
  private void getDevLockInfoError()
  {
    this.mOpenCloseButton.setEnabled(false);
    this.mAuthDevLoadingView.setVisibility(8);
    this.mBothOnlineButton.setEnabled(false);
  }
  
  private MqqHandler getHandler(Class<?> paramClass)
  {
    if (!(this.mRuntime instanceof AppInterface)) {
      return null;
    }
    return ((AppInterface)this.mRuntime).getHandler(paramClass);
  }
  
  private void hideProgerssDialog()
  {
    this.mHandler.post(new AuthDevActivity.11(this));
  }
  
  private void initPageUI()
  {
    this.mOpenCloseButton.setChecked(this.mIsAuthDevOpen);
    this.mOpenCloseButton.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    Object localObject;
    if ((this.mRuntime instanceof AppInterface))
    {
      localObject = (AppInterface)this.mRuntime;
      localObject = getHandler(this.mSafeApi.getLoginInfoActivity());
    }
    else
    {
      localObject = null;
    }
    if (localObject != null) {
      if (this.mIsAuthDevOpen) {
        ((MqqHandler)localObject).obtainMessage(20140331, 1, 0).sendToTarget();
      } else {
        ((MqqHandler)localObject).obtainMessage(20140331, 0, 0).sendToTarget();
      }
    }
    if (this.mIsAuthDevOpen)
    {
      this.mSafeApi.getWxMsgOptions(this.mRuntime);
      startGetAuthDevList();
      return;
    }
    if ((this.mIsAllowSet) && ((this.mSafeApi.getIsPushRecommandDevLock(this.mRuntime)) || (this.mEnableOpenAllowsetDev))) {
      onClickOpenCloseDevLockBtn();
    } else if (this.mIsGrayAccount) {
      startGetRecentDevList();
    } else {
      this.mAuthDevLoadingView.setVisibility(8);
    }
    if ("app_qq_safe_center".equals(this.mFrom))
    {
      if (this.mRiskDialog == null) {
        this.mRiskDialog = createRiskDialog();
      }
      this.mRiskDialog.show();
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
  
  private void onBothOnlineStatusChanged(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void onClickOpenCloseDevLockBtn()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
      return;
    }
    if (this.mIsAuthDevOpen)
    {
      ReportController.b(this.mRuntime, "CliOper", "", "", "My_eq_lock", "My_eq_lock_close", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A71C", "0X800A71C", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DevRpt", 2, "登录保护页点击开关，关闭登录保护的用户数、次数！0X800A71C");
      }
      QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to close dev lock");
      showConfirmCloseDialog();
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "onClick.begin to CheckDevLockSms");
    Object localObject = (DevlockInfo)getIntent().getParcelableExtra("DevlockInfo");
    if ((!TextUtils.isEmpty(this.mPhoneNum)) && ((localObject == null) || (((DevlockInfo)localObject).AllowSet != 0)))
    {
      if (DevlockPhoneStatus.a().b() == 2)
      {
        DevlockPhoneStatus.a().a(this, this.mPhoneNum);
        return;
      }
      ReportController.b(this.mRuntime, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "0", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A71B", "0X800A71B", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DevRpt", 2, "登录保护页点击开关，开启登录保护的用户数、次数！0X800A71B");
      }
      if (!this.mCanOpenOrClose)
      {
        localObject = this.mProDialog;
        if ((localObject == null) || (!((QQProgressDialog)localObject).isShowing())) {
          showProgressDialog();
        }
        return;
      }
      showProgressDialog();
      this.mCanOpenOrClose = false;
      localObject = this.mRuntime.getCurrentAccountUin();
      int i = this.mSafeApi.checkDevLockSms(this.mRuntime, (String)localObject, "", null, this.mWtLoginObserver);
      if (i != 0)
      {
        this.mCanOpenOrClose = true;
        hideProgerssDialog();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick.CheckDevLockSms fail ret=");
        ((StringBuilder)localObject).append(i);
        QLog.d("Q.devlock.AuthDevActivity", 1, ((StringBuilder)localObject).toString());
        QQToast.makeText(getApplicationContext(), getString(2131888988), 0).show(getTitleBarHeight());
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("DevlockInfo", (Parcelable)localObject);
    startActivityForResult(localIntent, 0);
    RouteUtils.a(this, localIntent, "/base/safe/authDevOpenActivity", 0);
  }
  
  private void onDevlockStatusChanged()
  {
    if (this.mOpenCloseButton.a()) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    ReportController.b(null, "dc00898", "", "", "0X800AC54", "0X800AC54", 0, 0, (String)localObject, "", "", "");
    this.mOpenCloseButton.setOnCheckedChangeListener(null);
    Object localObject = this.mOpenCloseButton;
    ((FormSwitchItem)localObject).setChecked(((FormSwitchItem)localObject).a() ^ true);
    this.mOpenCloseButton.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    onClickOpenCloseDevLockBtn();
  }
  
  private void onWxMsgStatusChanged()
  {
    this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(null);
    FormSwitchItem localFormSwitchItem = this.mWXSyncQQMsgLayout;
    localFormSwitchItem.setChecked(localFormSwitchItem.a() ^ true);
    this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
      return;
    }
    this.mSafeApi.setWXSyncQQMsgOption(this.mRuntime, this.mWXSyncQQMsgLayout.a() ^ true);
  }
  
  private void showDelDevActionSheet(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = getResources().getString(2131892057);
    }
    this.mDelDevSheet = ((ActionSheet)ActionSheetHelper.b(this, null));
    if (paramBoolean1) {
      paramString1 = getString(2131888971, new Object[] { paramString1 });
    } else {
      paramString1 = getString(2131888969, new Object[] { paramString1 });
    }
    this.mDelDevSheet.setMainTitle(paramString1);
    this.mDelDevSheet.addRadioButton(getResources().getString(2131888968), 3, false);
    this.mDelDevSheet.addCancelButton(2131887648);
    this.mDelDevSheet.setOnButtonClickListener(new AuthDevActivity.5(this, paramString2, paramArrayList, paramInt, paramBoolean2, paramLong));
    this.mDelDevSheet.show();
  }
  
  private void showProgressDialog()
  {
    this.mHandler.post(new AuthDevActivity.10(this));
  }
  
  private void showRenameDevActionSheet(String paramString1, ArrayList<DeviceItemDes> paramArrayList, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, boolean paramBoolean3, SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    this.mRenameDevSheet = ((ActionSheet)ActionSheetHelper.b(this, null));
    LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131624754, this.mRenameDevSheet.getRootView(), false);
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131427561);
    boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, paramArrayOfByte);
    boolean bool2 = isOnlineDevice(paramSvcDevLoginInfo);
    if (this.mIsAuthDevOpen)
    {
      paramSvcDevLoginInfo = getString(2131888942);
      paramArrayOfByte = getString(2131888942);
      if (paramLong2 > 0L)
      {
        paramArrayOfByte = new Date(1000L * paramLong2);
        paramSvcDevLoginInfo = getString(2131888937, new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(paramArrayOfByte) });
        paramArrayOfByte = getString(2131888937, new Object[] { new SimpleDateFormat("yyyy年MM月dd日 HH点mm分", Locale.getDefault()).format(paramArrayOfByte) });
      }
      else
      {
        QLog.e("Q.devlock.AuthDevActivity", 1, "format login time error: time <= 0");
      }
      if ((bool1) || (bool2)) {
        paramSvcDevLoginInfo = getString(2131888944);
      }
      localTextView.setText(paramSvcDevLoginInfo);
      if ((bool1) || (bool2)) {
        paramArrayOfByte = getString(2131888944);
      }
      localTextView.setContentDescription(paramArrayOfByte);
    }
    else
    {
      if (bool1) {
        paramArrayOfByte = getString(2131888932);
      } else {
        paramArrayOfByte = getString(2131888970, new Object[] { paramString1 });
      }
      localTextView.setText(paramArrayOfByte);
    }
    this.mRenameDevSheet.addView(localLinearLayout);
    if (this.mIsAuthDevOpen) {
      this.mRenameDevSheet.addButton(getResources().getString(2131889007), 5, 0);
    }
    if ((!bool1) || (this.mIsAuthDevOpen)) {
      this.mRenameDevSheet.addButton(getResources().getString(2131888443), 3, 1);
    }
    this.mRenameDevSheet.addCancelButton(2131887648);
    this.mRenameDevSheet.setOnButtonClickListener(new AuthDevActivity.4(this, paramString2, paramLong1, paramString1, paramInt, paramBoolean3, paramArrayList, paramBoolean1, paramBoolean2));
    this.mRenameDevSheet.show();
  }
  
  private void startGetAuthDevList()
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "startGetAuthDevList.begin to getAuthLoginDevList");
    boolean bool = this.mSafeApi.getAuthLoginDevList(this.mRuntime, this.mPageName, 0L);
    if (bool)
    {
      this.mAuthListDesc.setVisibility(0);
      this.mAuthListDesc.setText(getString(2131889010));
      this.mAuthDevLoadingView.setVisibility(0);
      this.mTvBottomTips.setText(getString(2131888949));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startGetAuthDevList getAuthLoginDevList failed ret =");
    localStringBuilder.append(bool);
    QLog.d("Q.devlock.AuthDevActivity", 1, localStringBuilder.toString());
  }
  
  private void startGetRecentDevList()
  {
    boolean bool1 = this.mSafeApi.getRecentLoginDevList(this.mRuntime, this.mPageName, 0L);
    boolean bool2 = this.mSafeApi.getLoginDevList(this.mRuntime, this.mPageName, 0L);
    if ((bool1) && (bool2))
    {
      this.mHistoryList.clear();
      this.mAuthListDesc.setVisibility(0);
      this.mAuthListDesc.setText(getString(2131889015));
      this.mAuthDevLoadingView.setVisibility(0);
      this.mTvBottomTips.setText(getString(2131888948));
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onCreate getRecentLoginDevList failed recentLoginRet=", Boolean.valueOf(bool1), " loginDevRet=", Boolean.valueOf(bool2) });
  }
  
  private void updateHistoryListUI(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.mAuthListLayout.removeAllViews();
      this.mAuthListLayout.setVisibility(0);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null)
        {
          View localView = getLayoutInflater().inflate(2131627387, this.mAuthListLayout, false);
          RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131436054);
          if (j == 1) {
            localRelativeLayout.setBackgroundResource(2130839622);
          } else if (i == 0) {
            localRelativeLayout.setBackgroundResource(2130839638);
          } else if (i == j - 1) {
            localRelativeLayout.setBackgroundResource(2130839629);
          } else {
            localRelativeLayout.setBackgroundResource(2130839632);
          }
          TextView localTextView2 = (TextView)localView.findViewById(2131439121);
          TextView localTextView1 = (TextView)localView.findViewById(2131435692);
          Object localObject2 = localSvcDevLoginInfo.strDeviceName;
          Object localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = getResources().getString(2131892057);
          }
          localObject2 = null;
          boolean bool1 = Arrays.equals(NetConnInfoCenter.GUID, localSvcDevLoginInfo.vecGuid);
          boolean bool2 = isOnlineDevice(localSvcDevLoginInfo);
          if (bool1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("（");
            ((StringBuilder)localObject2).append(getResources().getString(2131892054));
            ((StringBuilder)localObject2).append("）");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localSpannableStringBuilder.append((CharSequence)localObject2);
            AuthDevActivity.2 local2 = new AuthDevActivity.2(this);
            int k = ((String)localObject1).length();
            localSpannableStringBuilder.setSpan(local2, k, ((String)localObject2).length() + k, 33);
          }
          localTextView2.setText(localSpannableStringBuilder);
          localObject1 = new StringBuilder();
          localObject2 = new StringBuilder();
          if (bool2)
          {
            ((StringBuilder)localObject2).append(getString(2131888943));
            ((StringBuilder)localObject2).append(" ");
            ((StringBuilder)localObject2).append(localSvcDevLoginInfo.strDeviceName);
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
          if ((bool2) && (!this.mIsAuthDevOpen)) {
            localTextView1.setText(((StringBuilder)localObject2).toString());
          } else if (((StringBuilder)localObject1).length() > 0) {
            localTextView1.setText(((StringBuilder)localObject1).toString());
          }
          localRelativeLayout.setClickable(true);
          localRelativeLayout.setTag(localSvcDevLoginInfo);
          localRelativeLayout.setOnClickListener(new AuthDevActivity.3(this, paramList, localRelativeLayout, i, localSvcDevLoginInfo));
          this.mAuthListLayout.addView(localView);
        }
        i += 1;
      }
      paramList = this.mAuthListDesc;
      if (this.mAuthListLayout.getChildCount() == 0) {
        i = 4;
      } else {
        i = 0;
      }
      paramList.setVisibility(i);
      return;
    }
    this.mAuthListDesc.setVisibility(4);
    this.mAuthListLayout.setVisibility(8);
  }
  
  void dismissConfirmCloseDialog()
  {
    Dialog localDialog = this.mConfirmDialog;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.mConfirmDialog.dismiss();
      label23:
      this.mConfirmDialog = null;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131627386);
    this.mSafeApi = ((ISafeApi)QRoute.api(ISafeApi.class));
    this.mAuthListLayout = ((LinearLayout)super.findViewById(2131428893));
    this.mAuthDevLoadingView = ((ProgressBar)super.findViewById(2131440771));
    this.mTvBottomTips = ((TextView)findViewById(2131448272));
    this.mOpenCloseButton = ((FormSwitchItem)super.findViewById(2131428901));
    this.mBothOnlineButton = ((FormSwitchItem)findViewById(2131429614));
    this.mAuthListDesc = ((TextView)super.findViewById(2131428895));
    this.mAuthListDesc.setVisibility(4);
    this.mWXSyncQQMsgLayout = ((FormSwitchItem)super.findViewById(2131450320));
    this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    this.mWXSyncQQMsgLayout.setVisibility(8);
    this.mWXSyncQQMsgDesc = ((TextView)super.findViewById(2131450319));
    this.mWXSyncQQMsgDesc.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131890677);
    this.rightViewText.setOnClickListener(this);
    paramBundle = super.getIntent();
    if (TextUtils.equals(paramBundle.getExtras().getString("devlock_open_source"), "PhoneUnity")) {
      this.leftView.setText(2131897269);
    }
    if (this.mRuntime == null)
    {
      finish();
      QLog.e("Q.devlock.AuthDevActivity", 1, "error : app is null");
      return false;
    }
    boolean bool = SettingCloneUtil.readValue(this, this.mRuntime.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
    this.mBothOnlineButton.setChecked(bool);
    this.mBothOnlineButton.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    if (AppSetting.e)
    {
      this.mOpenCloseButton.setContentDescription(getString(2131888985));
      this.rightViewText.setContentDescription(getString(2131888953));
      this.mBothOnlineButton.setContentDescription(getString(2131890824));
    }
    try
    {
      this.mPageName = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("packName = ");
      localStringBuilder.append(this.mPageName);
      QLog.d("Q.devlock.AuthDevActivity", 2, localStringBuilder.toString());
    }
    this.mDevLockObserver = this.mSafeApi.getDevLockObserver(this);
    this.mDevListObserver = this.mSafeApi.getDevListObserver(this);
    addObserver(this.mDevLockObserver);
    addObserver(this.mDevListObserver);
    this.mFrom = paramBundle.getStringExtra("from");
    if ("app_qq_safe_center".equals(this.mFrom))
    {
      paramBundle = (String)BaseSharedPreUtil.a(this, this.mRuntime.getCurrentAccountUin(), "device_manage_switch", "");
      if (TextUtils.isEmpty(paramBundle)) {}
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramBundle).optInt("securityType", 0) != 0) {
          break label832;
        }
        bool = true;
        this.mIsGrayAccount = bool;
      }
      catch (Exception paramBundle)
      {
        QLog.e("Q.devlock.AuthDevActivity", 1, new Object[] { "parse dev gray switch error : ", paramBundle.getMessage() });
      }
      startGetDevLockStatus();
      break label771;
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
      label771:
      if (!this.mIsGrayAccount)
      {
        this.mBothOnlineButton.setVisibility(8);
        return false;
      }
      super.setTitle(2131888938);
      this.rightViewText.setVisibility(8);
      ReportController.b(null, "dc00898", "", "", "0X800AC52", "0X800AC52", 0, 0, "", "", "", "");
      return false;
      label832:
      bool = false;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent();
      localIntent.putExtra("from_risk_hint", true);
      RouteUtils.a(this, localIntent, "/base/safe/loginInfo");
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onActivityResult requestCode is 0, resultCode is : ", Integer.valueOf(paramInt2) });
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.mDevLockInfo != null))
      {
        paramIntent = paramIntent.getExtras();
        boolean bool1;
        if (this.mDevLockInfo.DevSetup == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = paramIntent.getBoolean("auth_dev_open", bool1);
        String str = paramIntent.getString("phone_num");
        if (this.mDevLockInfo.AllowSet == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool3 = paramIntent.getBoolean("allow_set");
        QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "status is ", Boolean.valueOf(bool1), "open is ", Boolean.valueOf(bool2), " status is ", Boolean.valueOf(bool1), " allowSet is ", Boolean.valueOf(bool3) });
        if (bool2) {
          this.mDevLockInfo.DevSetup = 1;
        } else {
          this.mDevLockInfo.DevSetup = 0;
        }
        this.mIsAuthDevOpen = bool2;
        if (!TextUtils.isEmpty(str))
        {
          this.mDevLockInfo.Mobile = str;
          this.mPhoneNum = str;
        }
        this.mAllowSet = bool3;
        if (bool3) {
          this.mDevLockInfo.AllowSet = 1;
        } else {
          this.mDevLockInfo.AllowSet = 0;
        }
        if (this.mIsAuthDevOpen)
        {
          this.mOpenCloseButton.setOnCheckedChangeListener(null);
          this.mOpenCloseButton.setChecked(true);
          this.mOpenCloseButton.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
          startGetAuthDevList();
          paramIntent = getHandler(this.mSafeApi.getLoginInfoActivity());
          if (paramIntent != null) {
            paramIntent.obtainMessage(20140331, 1, 0).sendToTarget();
          }
        }
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getExtras();
      if ((localObject1 != null) && (((Bundle)localObject1).containsKey("devlock_need_broadcast")))
      {
        bool = ((Bundle)localObject1).getBoolean("devlock_need_broadcast");
        break label41;
      }
    }
    boolean bool = false;
    label41:
    if (bool)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
      ((Intent)localObject1).putExtra("auth_dev_open", this.mIsAuthDevOpen);
      if (this.mIsAuthDevOpen)
      {
        localObject2 = (WtloginManager)this.mRuntime.getManager(1);
        if (localObject2 != null)
        {
          localObject2 = ((WtloginManager)localObject2).getLocalTicket(this.mRuntime.getCurrentAccountUin(), 16L, 33554432);
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
    Object localObject2 = this.mFaceStateRsp;
    if ((localObject2 != null) && (!((oidb_0x5e1.RspBody)localObject2).rpt_msg_uin_data.isEmpty())) {
      ((Intent)localObject1).putExtra("faceStateKey", String.valueOf(((oidb_0x5e1.UdcUinData)this.mFaceStateRsp.rpt_msg_uin_data.get(0)).user_login_guard_face.get()));
    }
    setResult(0, (Intent)localObject1);
    if ((this.mSafeApi.isH5Jump()) && (this.isH5_logic))
    {
      finish();
      RouteUtils.a(this, new Intent(), "/base/safe/loginInfo");
    }
    finish();
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    if (i == 2131436211)
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
      ((Intent)localObject1).putExtra("hide_more_button", true);
      startActivity((Intent)localObject1);
      RouteUtils.a(this, (Intent)localObject1, "/base/browser");
      ReportController.b(null, "dc00898", "", "", "0X800A720", "0X800A720", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DevRpt", 2, "点击帮助！0X800A720");
      }
    }
    else if (i == 2131428901)
    {
      onClickOpenCloseDevLockBtn();
    }
    else if (i == 2131431870)
    {
      dismissConfirmCloseDialog();
      ReportController.b(this.mRuntime, "dc00899", "DevLockSwitchDialog", this.mRuntime.getCurrentAccountUin(), "clickCancel", "dialogRightBtn", 0, 1, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800A71E", "0X800A71E", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击取消！0X800A71E");
      }
    }
    else if (i == 2131431864)
    {
      try
      {
        dismissConfirmCloseDialog();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Utils.m(this.mRuntime.getCurrentAccountUin()));
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append("last_safety_risk_dialog_time");
        localObject1 = getSharedPreferences(((StringBuilder)localObject1).toString(), 0).edit();
        ((SharedPreferences.Editor)localObject1).putLong("last_safety_risk_dialog_time", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject1).commit();
        ReportController.b(null, "dc00898", "", "", "0X800A71D", "0X800A71D", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("DevRpt", 2, "登录保护页关闭登录保护时的确认弹窗中点击关闭！0X800A71D");
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ReportController.b(this.mRuntime, "dc00899", "DevLockSwitchDialog", this.mRuntime.getCurrentAccountUin(), "clickClose", "dialogLeftBtn", 0, 2, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevActivity", 2, "onClick.begin to CloseDevLock");
      }
      Object localObject2;
      if (!this.mCanOpenOrClose)
      {
        localObject2 = this.mProDialog;
        if ((localObject2 == null) || (!((QQProgressDialog)localObject2).isShowing())) {
          showProgressDialog();
        }
      }
      else
      {
        showProgressDialog();
        this.mCanOpenOrClose = false;
        localObject2 = this.mRuntime.getCurrentAccountUin();
        i = this.mSafeApi.closeDevLock(this.mRuntime, (String)localObject2, this.mWtLoginObserver);
        if (i != 0)
        {
          hideProgerssDialog();
          this.mCanOpenOrClose = true;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onClick.CloseDevLock fail ret =");
            ((StringBuilder)localObject2).append(i);
            QLog.d("Q.devlock.AuthDevActivity", 2, ((StringBuilder)localObject2).toString());
          }
          QQToast.makeText(getApplicationContext(), getString(2131888954), 0).show(getTitleBarHeight());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = false;
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onDelAuthDevResult.isSuccess=", Boolean.valueOf(paramBoolean), " errorMsg=", paramString, " index=", Integer.valueOf(paramInt) });
    hideProgerssDialog();
    Object localObject;
    if (this.mIsAuthDevOpen) {
      localObject = this.mAuthList;
    } else {
      localObject = this.mHistoryList;
    }
    if (paramBoolean)
    {
      if ((paramInt > -1) && (paramInt < ((List)localObject).size()))
      {
        paramString = (SvcDevLoginInfo)((List)localObject).get(paramInt);
        if (Arrays.equals(NetConnInfoCenter.GUID, paramString.vecGuid))
        {
          this.mRuntime.updateSubAccountLogin(this.mRuntime.getCurrentAccountUin(), false);
          this.mRuntime.getApplication().refreAccountList();
          ((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).logout(this, this.mRuntime, true);
          paramString = this.mRuntime.getManager(1);
          paramBoolean = bool;
          if (paramString == null) {
            paramBoolean = true;
          }
          QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "clear login sig, manage is null : [", Boolean.valueOf(paramBoolean), "]" });
          if (paramString != null)
          {
            paramString = (WtloginManager)paramString;
            localObject = this.mRuntime.getAccount();
            paramString.clearUserFastLoginData((String)localObject, 16L);
            paramString.clearUserFastLoginData((String)localObject, 1600001540L);
            paramString.refreshMemorySig();
          }
          return;
        }
        if (paramInt < ((List)localObject).size())
        {
          ((List)localObject).remove(paramInt);
          updateHistoryListUI((List)localObject);
        }
      }
      QQToast.makeText(getApplicationContext(), 2, getString(2131888973), 0).show(getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(getApplicationContext(), 1, getString(2131888972), 0).show(getTitleBarHeight());
      return;
    }
    QQToast.makeText(getApplicationContext(), 1, paramString, 0).show(getTitleBarHeight());
  }
  
  public void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDelHistoryDevResult isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" errorMsg=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" index=");
    localStringBuilder.append(paramInt);
    QLog.d("Q.devlock.AuthDevActivity", 1, localStringBuilder.toString());
    hideProgerssDialog();
    if (paramBoolean)
    {
      ReportController.b(this.mRuntime, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if (paramInt > -1)
      {
        paramString = this.mHistoryList;
        if ((paramString != null) && (paramInt < paramString.size()))
        {
          this.mHistoryList.remove(paramInt);
          updateHistoryListUI(this.mHistoryList);
        }
      }
      QQToast.makeText(getApplicationContext(), 2, getString(2131888973), 0).show(getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(getApplicationContext(), 1, getString(2131892051), 0).show(getTitleBarHeight());
      return;
    }
    QQToast.makeText(getApplicationContext(), 1, paramString, 0).show(getTitleBarHeight());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    hideProgerssDialog();
    dismissSafetyRiskDialog();
    removeObserver(this.mDevListObserver);
    removeObserver(this.mDevLockObserver);
  }
  
  public void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    this.mAuthDevLoadingView.setVisibility(8);
    if (!this.mIsAuthDevOpen) {
      return;
    }
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.success");
      this.mAuthList = paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = this.mAuthList.iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          localObject = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("SvcDevLoginInfo.iAppId=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iAppId);
            localStringBuilder.append(" iLoginTime=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iLoginTime);
            localStringBuilder.append(" strLoginLocation=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strLoginLocation);
            localStringBuilder.append(" iLoginPlatform=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iLoginPlatform);
            localStringBuilder.append(" strDeviceName=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strDeviceName);
            localStringBuilder.append(" strDeviceTypeInfo");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strDeviceTypeInfo);
            QLog.d("Q.devlock.AuthDevActivity", 2, localStringBuilder.toString());
          }
        }
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
      }
      updateHistoryListUI(this.mAuthList);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetAuthDevResult.isSuccess=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("Q.devlock.AuthDevActivity", 1, ((StringBuilder)localObject).toString());
    if (paramSvcRspGetDevLoginInfo == null)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.data is null");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetAuthDevResult.data.iResult=");
      ((StringBuilder)localObject).append(paramSvcRspGetDevLoginInfo.iResult);
      QLog.d("Q.devlock.AuthDevActivity", 1, ((StringBuilder)localObject).toString());
    }
    this.mAuthListDesc.setVisibility(4);
    QQToast.makeText(this, 1, getString(2131888984), 0).show(getTitleBarHeight());
  }
  
  public void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    this.mAuthDevLoadingView.setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetHistoryDevResult success");
      this.mHistoryList.addAll(paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      updateHistoryListUI(this.mHistoryList);
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null) {
      str = "";
    } else {
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
    }
    boolean bool;
    if (paramSvcRspGetDevLoginInfo == null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetHistoryDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
    QQToast.makeText(getActivity(), 1, getString(2131888984), 0).show(getTitleBarHeight());
  }
  
  public void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    this.mAuthDevLoadingView.setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetLoginDevResult success");
      this.mOnLineList = paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo;
      this.mHistoryList.addAll(0, this.mOnLineList);
      updateHistoryListUI(this.mHistoryList);
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null) {
      str = "";
    } else {
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
    }
    boolean bool;
    if (paramSvcRspGetDevLoginInfo == null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetLoginDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
    QQToast.makeText(getActivity(), 1, getString(2131888984), 0).show(getTitleBarHeight());
  }
  
  public void onRenameAuthDev(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    if (paramBoolean)
    {
      Object localObject = this.mAuthList;
      if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        localObject = (SvcDevLoginInfo)this.mAuthList.get(paramInt);
        if (Arrays.equals(((SvcDevLoginInfo)localObject).stDeviceItemDes.vecItemDes, paramArrayOfByte))
        {
          ((SvcDevLoginInfo)localObject).strDeviceName = paramString;
          updateHistoryListUI(this.mAuthList);
        }
        localObject = getHandler(this.mSafeApi.getLoginInfoActivity());
        if (localObject != null)
        {
          localObject = ((MqqHandler)localObject).obtainMessage(1);
          Bundle localBundle = new Bundle();
          localBundle.putString("target_name", paramString);
          localBundle.putByteArray("target_desc", paramArrayOfByte);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).sendToTarget();
        }
      }
    }
  }
  
  public void onWXSyncQQMsgOption(int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    boolean bool2 = true;
    boolean bool1 = true;
    paramInt = paramBundle.getInt("cmd", 1);
    int i = paramBundle.getInt("opt", 2);
    int j = paramBundle.getInt("ret", -1);
    paramBundle = (String)paramBundle.get("wording");
    FormSwitchItem localFormSwitchItem;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (j == 0)
      {
        this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(null);
        localFormSwitchItem = this.mWXSyncQQMsgLayout;
        if (i != 1) {
          bool1 = false;
        }
        localFormSwitchItem.setChecked(bool1);
        this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        this.mWXSyncQQMsgDesc.setText(paramBundle);
        return;
      }
      this.mWXSyncQQMsgLayout.setVisibility(8);
      this.mWXSyncQQMsgDesc.setVisibility(8);
      QQToast.makeText(this, paramBundle, 0).show(getTitleBarHeight());
      return;
    }
    if (j == 0)
    {
      this.mWXSyncQQMsgLayout.setVisibility(0);
      this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(null);
      localFormSwitchItem = this.mWXSyncQQMsgLayout;
      if (i == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localFormSwitchItem.setChecked(bool1);
      this.mWXSyncQQMsgLayout.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
      this.mWXSyncQQMsgDesc.setVisibility(0);
      this.mWXSyncQQMsgDesc.setText(paramBundle);
      return;
    }
    this.mWXSyncQQMsgLayout.setVisibility(8);
    this.mWXSyncQQMsgDesc.setVisibility(8);
  }
  
  void showConfirmCloseDialog()
  {
    dismissConfirmCloseDialog();
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131624587);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431880);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131888956));
    }
    localTextView1 = (TextView)localReportDialog.findViewById(2131431876);
    if (localTextView1 != null) {
      localTextView1.setText(getString(2131888947));
    }
    localTextView1 = (TextView)localReportDialog.findViewById(2131431864);
    if (localTextView1 != null) {
      localTextView1.setText(2131887812);
    }
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431870);
    if (localTextView2 != null) {
      localTextView2.setText(2131887648);
    }
    localReportDialog.setOnDismissListener(new AuthDevActivity.9(this));
    if (localTextView1 != null) {
      localTextView1.setOnClickListener(this);
    }
    if (localTextView2 != null) {
      localTextView2.setOnClickListener(this);
    }
    this.mConfirmDialog = localReportDialog;
    this.mConfirmDialog.show();
  }
  
  public void startGetDevLockStatus()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    Object localObject = this.mRuntime.getCurrentAccountUin();
    int i = this.mSafeApi.checkDevLockStatus(this.mRuntime, (String)localObject, this.mWtLoginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startGetDevLockStatus CheckDevLockStatus failed. ret=");
        ((StringBuilder)localObject).append(i);
        QLog.d("Q.devlock.AuthDevActivity", 2, ((StringBuilder)localObject).toString());
      }
      getDevLockInfoError();
      QQToast.makeText(this, getString(2131892106), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity
 * JD-Core Version:    0.7.0.1
 */