package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInjoyVideoInteract;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerIconCollection;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class BBannerHelper
{
  @Nullable
  public static BBannerHelper.MessageToShowBanner a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, BBannerHelper.IBannerInteract paramIBannerInteract)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      paramString1 = new BBannerHelper.MessageToShowBanner(1, paramString1, paramInt, paramString2, paramIBannerInteract);
      paramString2 = paramQQAppInterface.obtainMessage(1134200);
      paramString2.obj = paramString1;
      paramQQAppInterface.sendMessage(paramString2);
      return paramString1;
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int i = 0;
    if ((!paramIntent.hasExtra("banner_businessCategory")) || (!paramIntent.hasExtra("banner_wording"))) {
      return;
    }
    String str1 = paramIntent.getStringExtra("banner_businessCategory");
    String str2 = paramIntent.getStringExtra("banner_wording");
    String str3 = paramIntent.getStringExtra("banner_webViewUrl");
    String str4 = paramIntent.getStringExtra("banner_activityName");
    String str5 = paramIntent.getStringExtra("banner_fragmentName");
    int j = paramIntent.getIntExtra("banner_iconIdx", -1);
    int k = paramIntent.getIntExtra("banner_activityFlag", 0);
    PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("banner_pendingIntent");
    Bundle localBundle = paramIntent.getBundleExtra("banner_webview_extra");
    boolean bool = paramIntent.getBooleanExtra("force_no_reload", false);
    if (!TextUtils.isEmpty(str3)) {
      i = 1;
    }
    if (str5 != null)
    {
      a(str5, paramIntent, paramQQAppInterface, str1, str2);
      return;
    }
    if (i != 0)
    {
      a(paramQQAppInterface, str1, str2, str3, str4, j, k, localBundle, bool);
      return;
    }
    if (str1.equals("readinjoy_video_feeds"))
    {
      ReadInjoyVideoInteract.a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
      return;
    }
    if (localPendingIntent == null)
    {
      a(paramQQAppInterface, paramIntent, str1, str2, str4);
      return;
    }
    a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent == null) || (i < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from pendingIntent, " + paramString1 + " / " + paramString2 + " / " + paramPendingIntent + " / " + i);
      return;
    }
    paramIntent = new BBannerHelper.PendingIntentInteract(paramPendingIntent, paramQQAppInterface);
    paramIntent.a(a(paramQQAppInterface, i, paramString1, paramString2, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("banner_plguinType", -1);
    String str1 = paramIntent.getStringExtra("banner_pluginId");
    String str2 = paramIntent.getStringExtra("banner_pluginName");
    String str3 = paramIntent.getStringExtra("banner_pluginProxyActivityName");
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("banner_pluginIntent");
    int j = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (i < 0) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (localIntent == null) || (j < 0))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from plugin, " + paramString1 + " / " + paramString2 + " / " + paramString3 + " / " + i + " / " + str1 + " / " + str2 + " / " + str3 + " / " + localIntent + " / " + j);
      return;
    }
    paramIntent = new BBannerHelper.PluginBannerInteract(paramQQAppInterface, paramString3, str3, str1, str2, localIntent, paramQQAppInterface.getCurrentUin(), i);
    paramIntent.a(a(paramQQAppInterface, j, paramString1, paramString2, paramIntent));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      QLog.e("Q.recent.banner", 1, "invalid intent extra from webview, " + paramString1 + " / " + paramString2 + " / " + paramString3);
      return;
    }
    try
    {
      String str1 = new URL(paramString3).getHost();
      paramString3 = new BBannerHelper.WebViewBannerInteract(paramString3, paramQQAppInterface, paramString4, paramInt2, paramBundle, paramBoolean);
      paramInt2 = paramInt1;
      if (paramInt1 < 0) {
        paramInt2 = BannerIconCollection.a(str1);
      }
      paramString3.a(a(paramQQAppInterface, paramInt2, paramString1, paramString2, paramString3));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        localMalformedURLException.printStackTrace();
        String str2 = "";
      }
    }
  }
  
  private static void a(String paramString1, Intent paramIntent, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    paramString1 = new BBannerHelper.FragmentBannerInteract(paramString1, paramQQAppInterface);
    paramString1.a(a(paramQQAppInterface, i, paramString2, paramString3, paramString1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "hideGeneralBannerInB with: " + paramMessageToShowBanner);
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = paramQQAppInterface.obtainMessage(1134201);
      localMessage.obj = paramMessageToShowBanner;
      paramQQAppInterface.sendMessage(localMessage);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper
 * JD-Core Version:    0.7.0.1
 */