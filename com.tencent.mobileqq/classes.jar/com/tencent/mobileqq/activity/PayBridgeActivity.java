package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.impl.PayLogicImpl;

@RoutePage(desc="支付sdk桥梁activity", path="/base/payBridge")
public class PayBridgeActivity
  extends BaseActivity
{
  public static final int BIZ_COME_FROM_PUBLIC_ACCOUNT = 1;
  public static final int BIZ_COME_FROM_QQ_NATIVE_INSIDE = 2;
  public static final int BIZ_COME_FROM_QR_CODE = 3;
  public static final int BIZ_COME_FROM_THIRD_APP = 4;
  public static final int COME_FROM_MINI = 9;
  public static final int COME_FROM_THIRD_APP = 4;
  public static final String EXTRA_KEY_EXT_DATA = "extra_ext_data";
  public static final String EXTRA_KEY_EXT_F2FREDPACK_IS_ANIM = "extra_ext_f2fredpack_is_anim";
  public static final String EXTRA_KEY_EXT_TYPE = "extra_ext_data_type";
  public static final int EXTRA_KEY_EXT_TYPE_F2FREDPACK = 1;
  public static final String EXTRA_KEY_PAY_DATA = "extra_pay_data";
  public static final int OPEN_QZONE_VIP_OPEN_SERVICE_EXCEPTION = -5;
  public static final String PAYENV = "release";
  public static final String PAYENV_TEST = "test";
  public static final String PAYJSON_KEY_MINI_APP_VERTYPE_STR = "miniAppVertypeStr";
  public static final String PAYJSON_KEY_SET_MIDAS_ENV = "setMidasEnv";
  public static final String PAYPARAMS_KEY_FROM_PCPUSH = "payparmas_from_pcpush";
  public static final String PAYPARAMS_KEY_IS_LOGIN_STATE = "payparmas_from_is_login_state";
  public static final int PAYRESULT_CANCEL = 2;
  public static final int PAYRESULT_ERROR = -1;
  public static final int PAYRESULT_PARAMERROR = 3;
  public static final int PAYRESULT_SUCC = 0;
  public static final String PAY_CALLBACK_SN_EXTRA_KEY = "payparmas_callback_sn";
  public static final String PAY_H5_COMMON_REDPACKET_DOMAIN_KEY = "h5_common_redpacket_domain";
  public static final String PAY_H5_START_EXTRA_KEY = "payparmas_h5_start";
  public static final String PAY_H5_URL_EXTRA_KEY = "payparmas_h5_url";
  public static final String PAY_IS_LOCK_WITHDRAW = "payparmas_is_lock_withdraw";
  public static final String PAY_JSON_EXTRA_KEY = "payparmas_json";
  public static final int PAY_TYPE_BUILDIN_H5 = 1;
  public static final String PAY_TYPE_EXTRA_KEY = "payparmas_paytype";
  public static final int PAY_TYPE_NATIVE = 5;
  public static final int PAY_TYPE_OPENPAY_APP = 4;
  public static final int PAY_TYPE_OPENPAY_H5 = 3;
  public static final int PAY_TYPE_PC_PUSH = 2;
  public static final int PAY_TYPE_PUBACC_APP = 7;
  public static final int PAY_TYPE_PUBACC_H5 = 6;
  public static final int PAY_TYPE_PUBACC_QUICK = 9;
  public static final int PAY_TYPE_QRCODE = 8;
  public static final String PAY_URL_APPINFO_EXTRA_KEY = "payparmas_url_appinfo";
  public static final String PUBACC_QWALLET = "2711679534";
  public static final String REPORT_KEY_SEQ = "vacreport_key_seq";
  public static final int REQUEST_CODE_BUY_GOODS = 7;
  public static final int REQUEST_CODE_CHECK_PERMISSION = 13;
  public static final int REQUEST_CODE_EMOJI_PAY = 1;
  public static final int REQUEST_CODE_F2FREDPACK_ERROR = 200;
  public static final int REQUEST_CODE_GOLD_CHARGE = 2;
  public static final String REQUEST_CODE_KEY = "pay_requestcode";
  public static final int REQUEST_CODE_NOTIFY_PCPUSH = 12;
  public static final int REQUEST_CODE_OPEN_QQREADER_VIP = 3;
  public static final int REQUEST_CODE_OPEN_QZONE_VIP = 10;
  public static final int REQUEST_CODE_OPEN_SERVICE = 4;
  public static final int REQUEST_CODE_OPEN_SVIP = 11;
  public static final int REQUEST_CODE_OPEN_TENPAY_VIEW = 5;
  public static final int REQUEST_CODE_PAY = 9;
  public static final int REQUEST_CODE_QWALLET_CRASH = 201;
  public static final int REQUEST_CODE_RECHARGE_GAME_CURRENCY = 6;
  public static final int REQUEST_CODE_RECHARGE_QB = 8;
  public static final int REQUEST_CODE_SUBSCRIBE_MONTH_CARD = 14;
  public static final String SAVE_INSTANCE_KEY_LOGIC_TAG = "save_instance_logic_tag";
  public static final int SET_MIDAS_ENV_VAL_RELEASE = 0;
  public static final int SET_MIDAS_ENV_VAL_TEST = 1;
  public static final String tag = "Q.qwallet.pay.PayBridgeActivity";
  public boolean mIsPluginLoaded = false;
  protected boolean mIsResume = false;
  protected long mLastResumeTime;
  private PayBridgeActivity.MyPluginLoadedReceiver mPluginLoadedReceiver;
  private IPayLogic payLogic;
  
  private String getJson()
  {
    if (getIntent() != null) {
      getIntent().getStringExtra("json");
    }
    return null;
  }
  
  private int getRequestCode()
  {
    int i = -1;
    if (getIntent() != null) {
      i = getIntent().getIntExtra("pay_requestcode", -1);
    }
    return i;
  }
  
  public static boolean isPaying()
  {
    return PayLogicImpl.isPaying();
  }
  
  public static Bundle newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    return PayLogicImpl.newPay(paramAppInterface, paramActivity, paramResultReceiver, paramInt, paramBundle);
  }
  
  private void registerPluginLoadedReceiver()
  {
    try
    {
      this.mPluginLoadedReceiver = new PayBridgeActivity.MyPluginLoadedReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter("action_launch_completed");
      registerReceiver(this.mPluginLoadedReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static boolean startEmojimallPay(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "startEmojimallPaycallbackid:" + paramString1 + "appid:" + paramString2 + "userId:" + paramString3 + "userKey:" + paramString4 + "zoneId:" + paramString5 + "pf:" + paramString6 + "pfKey:" + paramString7 + "tokenUrl:" + paramString8 + "drmInfo:" + paramString9);
    }
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString8))) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(new DataFactory.EmojiPayReqData(paramString1, paramString2, paramString3, paramString4, "uin", "skey", paramString5, paramString6, paramString7, paramString8, paramString9).a());
    localIntent.putExtra("pay_requestcode", 1);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    paramActivity.startActivityForResult(localIntent, 1);
    return true;
  }
  
  public static boolean startGoldCharge(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean startOpenQQReaderVip(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
    return true;
  }
  
  public static boolean startTenpay(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramBundle == null)) {
      return false;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("pay_requestcode", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "PayBridgeActivity tenpay startActivity and request=" + paramBundle.toString() + ",requestCode=" + paramInt);
    }
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
    }
    for (;;)
    {
      return true;
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static boolean tenpay(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    return tenpay(paramActivity, paramInt, paramBundle, null);
  }
  
  public static boolean tenpay(Activity paramActivity, int paramInt, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if ((paramActivity == null) || (paramBundle == null)) {
      return false;
    }
    if (paramResultReceiver != null) {
      paramBundle.putParcelable("receiver", paramResultReceiver);
    }
    paramResultReceiver = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
    paramResultReceiver.putExtras(paramBundle);
    paramResultReceiver.putExtra("pay_requestcode", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "tenpay startActivity and request=" + paramBundle.toString() + ",requestCode=" + paramInt);
    }
    paramActivity.startActivityForResult(paramResultReceiver, paramInt);
    return true;
  }
  
  public static boolean tenpay(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity == null) || (paramString1 == null)) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("json", paramString1);
    localBundle.putString("callbackSn", paramString2);
    return tenpay(paramActivity, paramInt, localBundle);
  }
  
  private void unRegisterPluginLoadedReceiver()
  {
    try
    {
      if (this.mPluginLoadedReceiver != null) {
        unregisterReceiver(this.mPluginLoadedReceiver);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
      return bool;
      if ((this.mIsResume) && (!isFinishing()))
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        if ((l > this.mLastResumeTime) && (l - this.mLastResumeTime > 10000L))
        {
          VACDReportUtil.a(null, "qqwallet", "PayBridge", "click.mobileqq", "isPluginloaded=" + this.mIsPluginLoaded + "&reqcode=" + getRequestCode() + "&json=" + getJson(), 0, null);
          this.payLogic.end();
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167305);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnCreate@" + hashCode());
    }
    if ((paramBundle != null) && (paramBundle.containsKey("save_instance_logic_tag")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnCreate from reboot@" + hashCode());
      }
      this.payLogic = PayLogicImpl.getLogic(paramBundle.getInt("save_instance_logic_tag"));
      if ((this.payLogic != null) && (this.payLogic.tryDoOnActivityResult(this))) {
        return false;
      }
      finish();
      return false;
    }
    this.payLogic = ((IPayLogic)QRoute.api(IPayLogic.class));
    if (!this.payLogic.init(getIntent(), this.app, this))
    {
      this.payLogic.end();
      return false;
    }
    this.payLogic.exec();
    registerPluginLoadedReceiver();
    return false;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnDestroy@" + hashCode());
    }
    super.doOnDestroy();
    if (this.payLogic != null) {
      this.payLogic.onDestroy();
    }
    unRegisterPluginLoadedReceiver();
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnPause@" + hashCode());
    }
    super.doOnPause();
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnRestoreInstanceState@" + hashCode());
    }
    super.doOnRestoreInstanceState(paramBundle);
    this.payLogic.doOnRestoreInstanceState(paramBundle);
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnResume@" + hashCode());
    }
    this.mIsResume = true;
    this.mLastResumeTime = NetConnInfoCenter.getServerTimeMillis();
    super.doOnResume();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnSaveInstanceState@" + hashCode());
    }
    super.doOnSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      paramBundle.putInt("save_instance_logic_tag", this.payLogic.getTag());
    }
    this.payLogic.doOnSaveInstanceState(paramBundle);
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "doOnStop@" + hashCode());
    }
    super.doOnStop();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, "onActivityResult@" + hashCode());
    }
    this.payLogic.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PayBridgeActivity
 * JD-Core Version:    0.7.0.1
 */