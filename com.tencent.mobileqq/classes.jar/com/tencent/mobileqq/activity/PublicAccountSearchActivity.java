package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import java.util.HashMap;

public class PublicAccountSearchActivity
{
  public static void a(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    if ((paramActivity instanceof BaseActivity)) {
      localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).getCurrentAccountUin());
    }
    if (WebViewPluginFactory.a.containsKey("PublicAccountJs")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "PublicAccountJs" });
    }
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hideRightButton", true);
    localIntent.putExtra("leftViewText", paramActivity.getString(2131892898));
    localIntent.putExtra("assignBackText", paramActivity.getString(2131892898));
    if (TextUtils.isEmpty(paramString))
    {
      localIntent.putExtra("url", ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCategoryUrl());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://find.mp.qq.com/search/index?_wv=67109947&keyword=");
      localStringBuilder.append(paramString);
      localIntent.putExtra("url", localStringBuilder.toString());
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    if (TextUtils.isEmpty(paramString2))
    {
      if ((paramActivity instanceof BaseActivity)) {
        localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramActivity).getAppRuntime()).getCurrentAccountUin());
      }
    }
    else {
      localIntent.putExtra("uin", paramString2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      localIntent.putExtra("leftViewText", paramString1);
      localIntent.putExtra("assignBackText", paramString1);
    }
    if (WebViewPluginFactory.a.containsKey("PublicAccountJs")) {
      localIntent.putExtra("insertPluginsArray", new String[] { "PublicAccountJs" });
    }
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "https://dyzx.mp.qq.com/static/v8/page/subscribeindex.html?_wv=67109947&_bid=2278&_wwv=1";
    }
    localIntent.putExtra("fromLocalUrl", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("hideRightButton", true);
    paramActivity.startActivity(localIntent);
  }
  
  private static void b(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", "");
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra(ClassificationSearchActivity.p, ClassificationSearchActivity.m);
    localIntent.setClass(paramActivity, ClassificationSearchActivity.class);
    ClassificationSearchActivity.a(paramActivity, localIntent, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountSearchActivity
 * JD-Core Version:    0.7.0.1
 */