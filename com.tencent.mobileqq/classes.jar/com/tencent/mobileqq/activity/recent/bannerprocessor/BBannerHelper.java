package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerIconCollection;
import com.tencent.mobileqq.kandian.biz.video.feedback.api.IReadInJoyVideoInteract;
import com.tencent.mobileqq.qroute.QRoute;
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
    if (paramIntent.hasExtra("banner_businessCategory"))
    {
      if (!paramIntent.hasExtra("banner_wording")) {
        return;
      }
      String str1 = paramIntent.getStringExtra("banner_businessCategory");
      String str2 = paramIntent.getStringExtra("banner_wording");
      String str3 = paramIntent.getStringExtra("banner_webViewUrl");
      String str4 = paramIntent.getStringExtra("banner_activityName");
      String str5 = paramIntent.getStringExtra("banner_fragmentName");
      int i = paramIntent.getIntExtra("banner_iconIdx", -1);
      int j = paramIntent.getIntExtra("banner_activityFlag", 0);
      PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("banner_pendingIntent");
      Bundle localBundle = paramIntent.getBundleExtra("banner_webview_extra");
      boolean bool1 = paramIntent.getBooleanExtra("force_no_reload", false);
      boolean bool2 = TextUtils.isEmpty(str3);
      if (str5 != null)
      {
        a(str5, paramIntent, paramQQAppInterface, str1, str2);
        return;
      }
      if ((bool2 ^ true))
      {
        a(paramQQAppInterface, str1, str2, str3, str4, i, j, localBundle, bool1);
        return;
      }
      if (str1.equals("readinjoy_video_feeds"))
      {
        ((IReadInJoyVideoInteract)QRoute.api(IReadInJoyVideoInteract.class)).handleReadinjoyVideoIntent(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
        return;
      }
      if (localPendingIntent == null)
      {
        a(paramQQAppInterface, paramIntent, str1, str2, str4);
        return;
      }
      a(paramQQAppInterface, paramIntent, localPendingIntent, str1, str2);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, PendingIntent paramPendingIntent, String paramString1, String paramString2)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((paramPendingIntent != null) && (i >= 0) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramIntent = new BBannerHelper.PendingIntentInteract(paramPendingIntent, paramQQAppInterface);
      paramIntent.a(a(paramQQAppInterface, i, paramString1, paramString2, paramIntent));
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("invalid intent extra from pendingIntent, ");
    paramQQAppInterface.append(paramString1);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramString2);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramPendingIntent);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(i);
    QLog.e("Q.recent.banner", 1, paramQQAppInterface.toString());
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("banner_plguinType", -1);
    String str1 = paramIntent.getStringExtra("banner_pluginId");
    String str2 = paramIntent.getStringExtra("banner_pluginName");
    String str3 = paramIntent.getStringExtra("banner_pluginProxyActivityName");
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("banner_pluginIntent");
    int j = paramIntent.getIntExtra("banner_iconIdx", -1);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (i >= 0) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (localIntent != null) && (j >= 0))
    {
      paramIntent = new BBannerHelper.PluginBannerInteract(paramQQAppInterface, paramString3, str3, str1, str2, localIntent, paramQQAppInterface.getCurrentUin(), i);
      paramIntent.a(a(paramQQAppInterface, j, paramString1, paramString2, paramIntent));
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("invalid intent extra from plugin, ");
    paramQQAppInterface.append(paramString1);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramString2);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramString3);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(i);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(str1);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(str2);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(str3);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(localIntent);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(j);
    QLog.e("Q.recent.banner", 1, paramQQAppInterface.toString());
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      String str2;
      try
      {
        String str1 = new URL(paramString3).getHost();
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        str2 = "";
      }
      paramString3 = new BBannerHelper.WebViewBannerInteract(paramString3, paramQQAppInterface, paramString4, paramInt2, paramBundle, paramBoolean);
      if (paramInt1 < 0) {
        paramInt1 = BannerIconCollection.a(str2);
      }
      paramString3.a(a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramString3));
      return;
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("invalid intent extra from webview, ");
    paramQQAppInterface.append(paramString1);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramString2);
    paramQQAppInterface.append(" / ");
    paramQQAppInterface.append(paramString3);
    QLog.e("Q.recent.banner", 1, paramQQAppInterface.toString());
  }
  
  private static void a(String paramString1, Intent paramIntent, QQAppInterface paramQQAppInterface, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("banner_iconIdx", -1);
    paramString1 = new BBannerHelper.FragmentBannerInteract(paramString1, paramQQAppInterface);
    paramString1.a(a(paramQQAppInterface, i, paramString2, paramString3, paramString1));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BBannerHelper.MessageToShowBanner paramMessageToShowBanner)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideGeneralBannerInB with: ");
      ((StringBuilder)localObject).append(paramMessageToShowBanner);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.obtainMessage(1134201);
      ((Message)localObject).obj = paramMessageToShowBanner;
      paramQQAppInterface.sendMessage((Message)localObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper
 * JD-Core Version:    0.7.0.1
 */