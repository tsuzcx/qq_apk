package com.tencent.biz.pubaccount.weishi_new.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;

public class AppMarketUtils
{
  public static Intent a(String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.setPackage(paramString2);
    }
    paramString1.setFlags(536870912);
    paramString1.putExtra("big_brother_source_key", "biz_src_jc_gzh_weishi");
    return paramString1;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      WSLog.d("AppMarketUtils", "tryGoAppMarket:activity = null");
      return false;
    }
    paramActivity = WSGlobalConfig.a().j();
    String str = WSGlobalConfig.a().h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("goAppMarket:\nappStorePackageName = ");
    localStringBuilder.append(str);
    localStringBuilder.append("\nappStoreVendorId =");
    localStringBuilder.append(WSGlobalConfig.a().i());
    localStringBuilder.append("\nappStoreScheme =");
    localStringBuilder.append(paramActivity);
    WSLog.c("AppMarketUtils", localStringBuilder.toString());
    return (!TextUtils.isEmpty(paramActivity)) && (!paramActivity.startsWith("http"));
  }
  
  public static void b(Activity paramActivity)
  {
    Object localObject = WSGlobalConfig.a().j();
    String str = WSGlobalConfig.a().h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("goAppMarket :\npackageName = ");
    localStringBuilder.append(str);
    localStringBuilder.append("\nurl = ");
    localStringBuilder.append((String)localObject);
    WSLog.d("AppMarketUtils", localStringBuilder.toString());
    try
    {
      paramActivity.startActivity(a((String)localObject, str));
      return;
    }
    catch (Exception paramActivity)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("goAppMarket error messaage = ");
      ((StringBuilder)localObject).append(paramActivity.getMessage());
      WSLog.d("AppMarketUtils", ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.AppMarketUtils
 * JD-Core Version:    0.7.0.1
 */