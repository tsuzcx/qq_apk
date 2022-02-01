package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.VasResourceCheckUtil;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@KeepClassConstructor
public class UrlQRProcessor
  extends BaseQRScanResultProcessor
{
  public static String c = "addDisSource";
  public static int d = 1;
  
  public UrlQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 1)
    {
      paramString = "ConsumerQRcard";
    }
    else if (paramInt == 2)
    {
      paramString = "GroupQRcard";
    }
    else
    {
      if (paramInt == 3) {
        return;
      }
      if (QRUtils.g(paramString))
      {
        StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardurl", 1);
      }
      else
      {
        StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardtext", 1);
        if (QRUtils.i(paramString)) {
          StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardphone", 1);
        }
      }
      paramString = "ThirdpartyQRcard";
    }
    StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", paramString, 1);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject, UrlQRProcessor.ConcurrentReqManager paramConcurrentReqManager)
  {
    ((IQRDataApi)QRoute.api(IQRDataApi.class)).requestUrlDecode(paramQQAppInterface, paramString, paramJSONObject, null, paramConcurrentReqManager.a());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://aq.qq.com"))) {
      paramQQAppInterface.sendWirelessPswReq(3);
    }
  }
  
  private void a(String paramString, UrlQRProcessor.ConcurrentReqManager paramConcurrentReqManager)
  {
    boolean bool = URLUtil.isNetworkUrl(paramString);
    paramConcurrentReqManager.a(bool);
    if (bool) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).getAppInfoByLink(paramString, 3, paramConcurrentReqManager.b());
    }
  }
  
  public String a()
  {
    return "UrlQRProcessor";
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1 = paramString1.toLowerCase();
    return (a(paramInt)) && (QRUtils.h(paramString1));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (!(this.a instanceof QQAppInterface)) {
      return false;
    }
    paramString2 = (QQAppInterface)this.a;
    AppActivity localAppActivity = (AppActivity)this.b.d();
    String str = paramString1.toLowerCase();
    if (QRUtils.h(str))
    {
      if (QRUtils.b(str))
      {
        paramString2 = new Intent(localAppActivity, JoinDiscussionActivity.class);
        paramString2.putExtra("innerSig", paramString1);
        paramString2.putExtra(c, d);
        this.b.b();
        return true;
      }
      if (VasResourceCheckUtil.a(paramString1))
      {
        VasResourceCheckUtil.a(paramString2, localAppActivity, paramString1);
        return true;
      }
      this.b.a(true);
      paramScannerParams = new UrlQRProcessor.ConcurrentReqManager(paramString2, paramScannerParams, paramString1, this.b);
      a(paramString1, paramScannerParams);
      a(paramString2, paramString1, this.b.c(), paramScannerParams);
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.UrlQRProcessor
 * JD-Core Version:    0.7.0.1
 */