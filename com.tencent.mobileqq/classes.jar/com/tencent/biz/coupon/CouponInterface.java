package com.tencent.biz.coupon;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;

public class CouponInterface
  extends WebViewPlugin
{
  public CouponInterface()
  {
    this.mPluginNameSpace = "coupon";
  }
  
  public void a(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity instanceof CouponActivity))
    {
      Object localObject = (CouponActivity)localActivity;
      int i = ((CouponActivity)localObject).a;
      if ((i & 0x8) != 0)
      {
        paramString = new Intent();
        paramString.putExtra("toPage", 2);
        ((CouponActivity)localObject).setResult(-1, paramString);
        ((CouponActivity)localObject).superFinish();
        return;
      }
      localObject = new Intent(localActivity, CouponActivity.class);
      ((Intent)localObject).putExtra("from", (i | 0xA) & 0xE);
      if (!TextUtils.isEmpty(paramString)) {
        ((Intent)localObject).putExtra("jsonParams", paramString);
      }
      localActivity.startActivity((Intent)localObject);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("coupon".equals(paramString2))
    {
      if (("goToCouponHomePage".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        a(paramVarArgs[0]);
        paramJsBridgeListener.a(null);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.coupon.CouponInterface
 * JD-Core Version:    0.7.0.1
 */