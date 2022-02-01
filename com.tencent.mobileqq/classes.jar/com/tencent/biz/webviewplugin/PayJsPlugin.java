package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.net.URL;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class PayJsPlugin
  extends JsWebViewPlugin
{
  Activity a;
  AppInterface b;
  protected PayJsPlugin.MyResultRecevicer c;
  protected Bundle d;
  protected long e;
  public long f;
  private boolean g = false;
  private final String h = "pay";
  private final String i = "openTenpayView";
  private final String j = "openService";
  private final String k = "buyGoods";
  private final String l = "rechargeGameCurrency";
  private final String m = "rechargeQb";
  private final String n = "preparePay";
  private final String o = "subscribeMonthCardPay";
  private final String p = "getQBRecord";
  private final String q = "closeFullWindow";
  private final String r = "launchWechatPaySign";
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("url");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    Intent localIntent = new Intent("cn.abel.action.broadcast");
    localIntent.putExtra("isOpen", TextUtils.isEmpty(paramString) ^ true);
    BaseApplicationImpl.sApplication.sendBroadcast(localIntent);
    if (!TextUtils.isEmpty(paramString))
    {
      localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.a.startActivity(localIntent);
      if (QWalletHelperDelegate.sFullWindowActivitySource == 1) {
        ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "index.layila.intopage", 0, 0, "", "", "", "");
      }
      if (QWalletHelperDelegate.sFullWndCurType == 0)
      {
        paramString = new StringBuilder();
        paramString.append(QWalletHelperDelegate.sFullWndCurID);
        paramString.append("");
        VACDReportUtil.b(paramString.toString(), "qqwallet", "screenReport", null, null, 0, null);
        return;
      }
      if (QWalletHelperDelegate.sFullWndCurType == 1)
      {
        paramString = new StringBuilder();
        paramString.append(QWalletHelperDelegate.sFullWndCurID);
        paramString.append("");
        VACDReportUtil.b(paramString.toString(), "qqwallet", "pullReport", null, null, 0, null);
      }
    }
  }
  
  private void c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 16);
    String str = this.b.getCurrentAccountUin();
    Object localObject = (TicketManager)this.b.getManager(2);
    if (localObject != null) {
      localObject = ((TicketManager)localObject).getSkey(str);
    } else {
      localObject = "";
    }
    localBundle.putString("uin", str);
    localBundle.putString("skey", (String)localObject);
    localBundle.putString("reqData", paramString);
    if (this.c != null)
    {
      paramString = Parcel.obtain();
      this.c.writeToParcel(paramString, 0);
      paramString.setDataPosition(0);
      localObject = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString);
      paramString.recycle();
      localBundle.putParcelable("_qwallet_payresult_receiver", (Parcelable)localObject);
    }
    QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, localBundle);
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("pay".equals(paramString)) {
      return "pay-h5";
    }
    if ("openService".equals(paramString)) {
      return "openService";
    }
    if ("buyGoods".equals(paramString)) {
      return "buyGoods";
    }
    if ("rechargeGameCurrency".equals(paramString)) {
      return "rechargeGameCurrency";
    }
    if ("rechargeQb".equals(paramString)) {
      return "rechargeQb";
    }
    if ("subscribeMonthCardPay".equals(paramString)) {
      return "monthCardPay";
    }
    if ("launchWechatPaySign".equals(paramString)) {
      return "wechatPaySign";
    }
    return null;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "pay requet preparePay");
    }
    if (this.mRuntime != null)
    {
      if (this.mRuntime.d() == null) {
        return;
      }
      if (QWalletHelperDelegate.isQWalletProcessExist(this.mRuntime.d())) {
        return;
      }
      Intent localIntent = new Intent("cooperation.qwallet.QWALLET_PRELOAD");
      AppRuntime localAppRuntime = ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime();
      if (localAppRuntime != null)
      {
        localObject = null;
        TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
        if (localTicketManager != null) {
          localObject = localTicketManager.getSkey(localAppRuntime.getCurrentAccountUin());
        }
        localIntent.putExtra("uin", localAppRuntime.getCurrentAccountUin());
        localIntent.putExtra("qqskey", (String)localObject);
      }
      Object localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).d = "qwallet_plugin.apk";
      ((IPluginManager.PluginParams)localObject).g = "Wallet";
      ((IPluginManager.PluginParams)localObject).h = "com.qwallet.receiver.QWallPreloadReceiver";
      ((IPluginManager.PluginParams)localObject).j = localIntent;
      IPluginManager.b(this.mRuntime.d(), (IPluginManager.PluginParams)localObject);
    }
  }
  
  protected void a(int paramInt, String paramString, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject1 = this.mRuntime.a();
    if (localObject1 != null) {
      localObject1 = ((CustomWebView)localObject1).getUrl();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
      }
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      if (QLog.isDevelopLevel())
      {
        localException.printStackTrace();
        localObject2 = localObject1;
      }
    }
    paramJsBridgeListener = String.valueOf(paramJsBridgeListener.b());
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("payparmas_callback_sn", paramJsBridgeListener);
    ((Bundle)localObject1).putString("payparmas_json", paramString);
    ((Bundle)localObject1).putInt("payparmas_paytype", 1);
    ((Bundle)localObject1).putLong("payparmas_h5_start", this.e);
    ((Bundle)localObject1).putLong("vacreport_key_seq", this.f);
    ((Bundle)localObject1).putString("payparmas_h5_url", (String)localObject2);
    this.d = PayBridgeActivity.newPay(this.b, this.a, this.c, paramInt, (Bundle)localObject1);
    if (this.d.getInt("retCode", -1) != 0)
    {
      paramString = this.d.getString("retJson");
      if (paramString != null) {
        callJs(paramJsBridgeListener, new String[] { paramString });
      }
      VACDReportUtil.endReport(this.f, "parseurl", null, 668801, paramString);
    }
  }
  
  protected void a(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openTenpayView requet params json=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, ((StringBuilder)localObject1).toString());
    }
    CustomWebView localCustomWebView = this.mRuntime.a();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localCustomWebView != null) {
      try
      {
        localObject1 = new URL(localCustomWebView.getUrl()).getHost();
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("json", paramString);
    ((Bundle)localObject2).putString("callbackSn", String.valueOf(paramJsBridgeListener.b()));
    ((Bundle)localObject2).putInt("payparmas_paytype", 1);
    ((Bundle)localObject2).putLong("payparmas_h5_start", this.e);
    ((Bundle)localObject2).putString("h5_common_redpacket_domain", (String)localObject1);
    PayBridgeActivity.tenpay(this.a, 5, (Bundle)localObject2);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback('");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("',{'r':0,'result':");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("});");
    super.callJs(localStringBuilder.toString());
  }
  
  protected void b(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pay requet params json=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.g)
    {
      this.g = true;
      localObject1 = this.mRuntime.a();
      if (localObject1 != null) {
        localObject1 = ((CustomWebView)localObject1).getUrl();
      } else {
        localObject1 = "";
      }
      Object localObject2 = localObject1;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject2 = localObject1;
        }
      }
      localObject1 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getAppInfoFromHistory();
      String str = String.valueOf(paramJsBridgeListener.b());
      try
      {
        paramJsBridgeListener = new Bundle();
        paramJsBridgeListener.putString("json", paramString);
        paramJsBridgeListener.putString("callbackSn", str);
        paramJsBridgeListener.putLong("vacreport_key_seq", this.f);
        paramJsBridgeListener.putString("payparmas_h5_url", (String)localObject2);
        paramJsBridgeListener.putString("payparmas_url_appinfo", (String)localObject1);
        paramJsBridgeListener.putString("payparmas_callback_sn", str);
        paramJsBridgeListener.putInt("payparmas_paytype", 1);
        if (this.c != null)
        {
          paramString = Parcel.obtain();
          this.c.writeToParcel(paramString, 0);
          paramString.setDataPosition(0);
          localObject1 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramString);
          paramString.recycle();
          paramJsBridgeListener.putParcelable("_qwallet_payresult_receiver", (Parcelable)localObject1);
        }
        PayBridgeActivity.tenpay(this.a, 9, paramJsBridgeListener);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      this.g = false;
    }
  }
  
  protected void c(String paramString, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pay requet params json=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.g)
    {
      this.g = true;
      localObject1 = this.mRuntime.a();
      if (localObject1 != null) {
        localObject1 = ((CustomWebView)localObject1).getUrl();
      } else {
        localObject1 = "";
      }
      Object localObject2 = localObject1;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = URLEncoder.encode((String)localObject1, "utf-8");
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          localObject2 = localObject1;
        }
      }
      localObject1 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getAppInfoFromHistory();
      paramJsBridgeListener = String.valueOf(paramJsBridgeListener.b());
      Bundle localBundle = new Bundle();
      localBundle.putString("payparmas_callback_sn", paramJsBridgeListener);
      localBundle.putString("payparmas_json", paramString);
      localBundle.putInt("payparmas_paytype", 1);
      localBundle.putLong("payparmas_h5_start", this.e);
      localBundle.putString("payparmas_url_appinfo", (String)localObject1);
      localBundle.putLong("vacreport_key_seq", this.f);
      localBundle.putString("payparmas_h5_url", (String)localObject2);
      this.d = PayBridgeActivity.newPay(this.b, this.a, this.c, 9, localBundle);
      if (this.d.getInt("retCode", -1) != 0)
      {
        paramString = this.d.getString("retJson");
        if (paramString != null) {
          callJs(paramJsBridgeListener, new String[] { paramString });
        }
        VACDReportUtil.endReport(this.f, "parseurl", null, 668801, paramString);
      }
      this.g = false;
    }
  }
  
  protected String getNameSpace()
  {
    return "pay";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!getNameSpace().equals(paramString2)) {
      return false;
    }
    paramString1 = a(paramString3);
    if (paramString1 != null) {
      this.f = VACDReportUtil.a(null, "qqwallet", paramString1, "payinvoke", null, 0, null);
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0]))) {
      paramString1 = paramVarArgs[0];
    } else {
      paramString1 = "";
    }
    this.e = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("");
      paramString2.append(this.e);
      paramString2.append(" PayJsPlugin.handleJsRequest params:");
      paramString2.append(paramString1);
      QLog.i("Q.qwallet.pay", 2, paramString2.toString());
    }
    if ((paramString1 != null) && ("pay".equals(paramString3)))
    {
      paramString2 = this.b;
      if ((paramString2 != null) && (!paramString2.isLogin())) {
        b(paramString1, paramJsBridgeListener);
      } else {
        c(paramString1, paramJsBridgeListener);
      }
    }
    else if ((paramString1 != null) && ("openTenpayView".equals(paramString3)))
    {
      a(paramString1, paramJsBridgeListener);
    }
    else if ((paramString1 != null) && ("openService".equals(paramString3)))
    {
      a(4, paramString1, paramJsBridgeListener);
    }
    else if ((paramString1 != null) && ("buyGoods".equals(paramString3)))
    {
      a(7, paramString1, paramJsBridgeListener);
    }
    else if ((paramString1 != null) && ("rechargeGameCurrency".equals(paramString3)))
    {
      a(6, paramString1, paramJsBridgeListener);
    }
    else if ((paramString1 != null) && ("rechargeQb".equals(paramString3)))
    {
      a(8, paramString1, paramJsBridgeListener);
    }
    else if ((paramString1 != null) && ("subscribeMonthCardPay".equals(paramString3)))
    {
      a(14, paramString1, paramJsBridgeListener);
    }
    else if ((paramString1 != null) && ("launchWechatPaySign".equals(paramString3)))
    {
      a(17, paramString1, paramJsBridgeListener);
    }
    else if ("preparePay".equals(paramString3))
    {
      a();
    }
    else if ((paramString1 != null) && ("getQBRecord".equals(paramString3)))
    {
      c(paramString1);
    }
    else
    {
      if (!"closeFullWindow".equals(paramString3)) {
        break label411;
      }
      b(paramString1);
    }
    return true;
    label411:
    return false;
  }
  
  public void onCreate()
  {
    this.a = this.mRuntime.d();
    this.b = this.mRuntime.b();
    this.c = new PayJsPlugin.MyResultRecevicer(this, new Handler());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PayJsPlugin
 * JD-Core Version:    0.7.0.1
 */