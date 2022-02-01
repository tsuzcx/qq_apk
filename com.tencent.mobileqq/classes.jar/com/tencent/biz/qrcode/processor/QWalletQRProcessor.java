package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@KeepClassConstructor
public class QWalletQRProcessor
  extends BaseQRScanResultProcessor
{
  public QWalletQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "QWalletQRProcessor";
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optString("exec_code", "-1");
        paramString = ((JSONObject)localObject2).optString("url", "");
        localObject2 = ((JSONObject)localObject2).optString("uin", "");
        int i = Integer.valueOf((String)localObject1).intValue();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return;
            }
            if (TextUtils.isEmpty(paramString)) {
              return;
            }
            localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramString);
            ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
            paramActivity.startActivity((Intent)localObject1);
            paramActivity.finish();
            return;
          }
          paramString = new Intent(paramActivity, SplashActivity.class);
          paramString.putExtra("tab_index", FrameControllerUtil.a);
          paramString.setFlags(67108864);
          paramActivity.startActivity(paramString);
          paramActivity.finish();
          return;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        paramString = new StringBuilder();
        paramString.append("mqqapi://im/chat?src_type=web&uin=");
        paramString.append((String)localObject2);
        paramString.append("&attach_content=&version=1&chat_type=c2c");
        paramString = paramString.toString();
        localObject1 = new Intent(paramActivity, JumpActivity.class);
        ((Intent)localObject1).setData(Uri.parse(paramString));
        paramActivity.startActivity((Intent)localObject1);
        paramActivity.finish();
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return 1 == paramInt1;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1 = paramString1.toLowerCase();
    return (a(paramInt)) && ((QRUtils.d(paramString1)) || (QRUtils.e(paramString1)) || (QRUtils.f(paramString1)));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (!(this.a instanceof QQAppInterface)) {
      return false;
    }
    paramString2 = (QQAppInterface)this.a;
    paramScannerParams = (Activity)this.b.d();
    String str = paramString1.toLowerCase();
    if (QRUtils.d(str))
    {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).doQWalletQRCode(paramString2, paramScannerParams, paramString1);
      return true;
    }
    if (QRUtils.e(str))
    {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).doQRCodePay(paramString2, paramScannerParams, paramString1, this.b);
      return true;
    }
    if (QRUtils.f(str))
    {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).doF2FRedpack(paramString2, paramScannerParams, paramString1);
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return super.b();
  }
  
  protected boolean c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("retdata");
      if (!TextUtils.isEmpty(paramIntent)) {
        a((Activity)this.b.d(), paramIntent);
      }
    }
    this.b.b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.QWalletQRProcessor
 * JD-Core Version:    0.7.0.1
 */