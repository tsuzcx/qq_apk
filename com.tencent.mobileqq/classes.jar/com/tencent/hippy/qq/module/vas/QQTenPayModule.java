package com.tencent.hippy.qq.module.vas;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import cooperation.qwallet.plugin.IQWalletHelper;

@HippyNativeModule(name="QQTenPayModule")
public class QQTenPayModule
  extends QQBaseModule
{
  static final String TAG = "QQTenPayModule";
  private final String METHOD_BUYGOODS = "buyGoods";
  private final String METHOD_OPENSERVICE = "openService";
  private final String METHOD_PAY_SUBSCRIBE = "paySubscribe";
  
  public QQTenPayModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void invokeNewPay(String paramString1, String paramString2, Promise paramPromise, int paramInt, String paramString3)
  {
    long l1;
    if (!TextUtils.isEmpty(paramString3)) {
      l1 = VACDReportUtil.a(null, "qqwallet", paramString3, "payinvoke", null, 0, null);
    } else {
      l1 = 0L;
    }
    long l2 = System.currentTimeMillis();
    paramString3 = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInfoFromHistory(null);
    Bundle localBundle = new Bundle();
    localBundle.putString("payparmas_callback_sn", paramPromise.getCallId());
    localBundle.putString("payparmas_json", paramString1);
    localBundle.putInt("payparmas_paytype", 1);
    localBundle.putLong("payparmas_h5_start", l2);
    localBundle.putString("payparmas_url_appinfo", paramString3);
    localBundle.putLong("vacreport_key_seq", l1);
    localBundle.putString("payparmas_h5_url", paramString2);
    paramString1 = PayBridgeActivity.newPay(getAppInterface(), getActivity(), new QQTenPayModule.VasHippyResultRecevicer(paramPromise, new Handler()), paramInt, localBundle);
    if (paramString1.getInt("retCode", -1) != 0)
    {
      paramString1 = paramString1.getString("retJson");
      if (paramString1 != null) {
        paramPromise.resolve(paramString1);
      }
      VACDReportUtil.endReport(l1, "parseurl", null, 668801, paramString1);
    }
  }
  
  @HippyMethod(name="buyGoods")
  public void buyGoods(String paramString1, String paramString2, Promise paramPromise)
  {
    invokeNewPay(paramString1, paramString2, paramPromise, 7, "buyGoods");
  }
  
  @HippyMethod(name="openService")
  public void openService(String paramString1, String paramString2, Promise paramPromise)
  {
    invokeNewPay(paramString1, paramString2, paramPromise, 4, "openService");
  }
  
  @HippyMethod(name="paySubscribe")
  public void paySubscribe(String paramString1, String paramString2, Promise paramPromise)
  {
    invokeNewPay(paramString1, paramString2, paramPromise, 14, "paySubscribe");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.vas.QQTenPayModule
 * JD-Core Version:    0.7.0.1
 */