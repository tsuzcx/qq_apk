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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emosm.DataFactory.EmojiPayReqData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.IPayBridge;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.IPayLogic;

@RoutePage(desc="支付sdk桥梁activity", path="/base/payBridge")
public class PayBridgeActivity
  extends QBaseActivity
  implements IPayBridge
{
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
    if (getIntent() != null) {
      return getIntent().getIntExtra("pay_requestcode", -1);
    }
    return -1;
  }
  
  public static boolean isPaying()
  {
    return ((IPayLogic)QRoute.api(IPayLogic.class)).isPaying();
  }
  
  public static Bundle newPay(AppInterface paramAppInterface, Activity paramActivity, ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    return ((IPayLogic)QRoute.api(IPayLogic.class)).newPay(paramAppInterface, paramActivity, paramResultReceiver, paramInt, paramBundle);
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startEmojimallPaycallbackid:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("appid:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("userId:");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append("userKey:");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append("zoneId:");
      ((StringBuilder)localObject).append(paramString5);
      ((StringBuilder)localObject).append("pf:");
      ((StringBuilder)localObject).append(paramString6);
      ((StringBuilder)localObject).append("pfKey:");
      ((StringBuilder)localObject).append(paramString7);
      ((StringBuilder)localObject).append("tokenUrl:");
      ((StringBuilder)localObject).append(paramString8);
      ((StringBuilder)localObject).append("drmInfo:");
      ((StringBuilder)localObject).append(paramString9);
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString8)))
    {
      localObject = new Intent(paramActivity, PayBridgeActivity.class);
      ((Intent)localObject).putExtras(new DataFactory.EmojiPayReqData(paramString1, paramString2, paramString3, paramString4, "uin", "skey", paramString5, paramString6, paramString7, paramString8, paramString9).a());
      ((Intent)localObject).putExtra("pay_requestcode", 1);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).addFlags(536870912);
      paramActivity.startActivityForResult((Intent)localObject, 1);
      return true;
    }
    return false;
  }
  
  public static boolean startGoldCharge(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean startOpenQQReaderVip(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      Intent localIntent = new Intent(paramActivity, PayBridgeActivity.class);
      localIntent.putExtras(paramBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean startTenpay(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if ((paramContext != null) && (paramBundle != null))
    {
      Intent localIntent = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("pay_requestcode", paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PayBridgeActivity tenpay startActivity and request=");
        localStringBuilder.append(paramBundle.toString());
        localStringBuilder.append(",requestCode=");
        localStringBuilder.append(paramInt);
        QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
      }
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      }
      else
      {
        localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
      }
      return true;
    }
    return false;
  }
  
  public static boolean tenpay(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    return tenpay(paramActivity, paramInt, paramBundle, null);
  }
  
  public static boolean tenpay(Activity paramActivity, int paramInt, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      if (paramResultReceiver != null) {
        paramBundle.putParcelable("receiver", paramResultReceiver);
      }
      paramResultReceiver = new Intent(BaseApplication.getContext(), PayBridgeActivity.class);
      paramResultReceiver.putExtras(paramBundle);
      paramResultReceiver.putExtra("pay_requestcode", paramInt);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tenpay startActivity and request=");
        localStringBuilder.append(paramBundle.toString());
        localStringBuilder.append(",requestCode=");
        localStringBuilder.append(paramInt);
        QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
      }
      paramActivity.startActivityForResult(paramResultReceiver, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean tenpay(Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    if ((paramActivity != null) && (paramString1 != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("json", paramString1);
      localBundle.putString("callbackSn", paramString2);
      return tenpay(paramActivity, paramInt, localBundle);
    }
    return false;
  }
  
  private void unRegisterPluginLoadedReceiver()
  {
    try
    {
      if (this.mPluginLoadedReceiver != null)
      {
        unregisterReceiver(this.mPluginLoadedReceiver);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if ((paramMotionEvent.getAction() == 1) && (this.mIsResume) && (!isFinishing()))
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = this.mLastResumeTime;
      if ((l1 > l2) && (l1 - l2 > 10000L))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isPluginloaded=");
        localStringBuilder.append(this.mIsPluginLoaded);
        localStringBuilder.append("&reqcode=");
        localStringBuilder.append(getRequestCode());
        localStringBuilder.append("&json=");
        localStringBuilder.append(getJson());
        VACDReportUtil.a(null, "qqwallet", "PayBridge", "click.mobileqq", localStringBuilder.toString(), 0, null);
        this.payLogic.end();
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnActivityResult@ requestCode: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", data: ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.payLogic;
    if (localObject != null) {
      ((IPayLogic)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(17170445);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnCreate@");
      localStringBuilder.append(hashCode());
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
    }
    if ((paramBundle != null) && (paramBundle.containsKey("save_instance_logic_tag")))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnCreate from reboot@");
        localStringBuilder.append(hashCode());
        QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
      }
      int i = paramBundle.getInt("save_instance_logic_tag");
      this.payLogic = ((IPayLogic)QRoute.api(IPayLogic.class)).getLogic(i);
      paramBundle = this.payLogic;
      if ((paramBundle != null) && (paramBundle.tryDoOnActivityResult(this))) {
        return false;
      }
      finish();
      return false;
    }
    this.payLogic = ((IPayLogic)QRoute.api(IPayLogic.class));
    if (!this.payLogic.init(getIntent(), getAppRuntime(), this))
    {
      this.payLogic.end();
      return false;
    }
    this.payLogic.exec();
    registerPluginLoadedReceiver();
    return false;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDestroy@");
      ((StringBuilder)localObject).append(hashCode());
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, ((StringBuilder)localObject).toString());
    }
    super.doOnDestroy();
    Object localObject = this.payLogic;
    if (localObject != null) {
      ((IPayLogic)localObject).onDestroy();
    }
    unRegisterPluginLoadedReceiver();
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause@");
      localStringBuilder.append(hashCode());
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
    }
    super.doOnPause();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnRestoreInstanceState@");
      localStringBuilder.append(hashCode());
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
    }
    super.doOnRestoreInstanceState(paramBundle);
    this.payLogic.doOnRestoreInstanceState(paramBundle);
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnResume@");
      localStringBuilder.append(hashCode());
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
    }
    this.mIsResume = true;
    this.mLastResumeTime = NetConnInfoCenter.getServerTimeMillis();
    super.doOnResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnSaveInstanceState@");
      localStringBuilder.append(hashCode());
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
    }
    super.doOnSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      paramBundle.putInt("save_instance_logic_tag", this.payLogic.getTag());
    }
    this.payLogic.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnStop@");
      localStringBuilder.append(hashCode());
      QLog.i("Q.qwallet.pay.PayBridgeActivity", 2, localStringBuilder.toString());
    }
    super.doOnStop();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PayBridgeActivity
 * JD-Core Version:    0.7.0.1
 */