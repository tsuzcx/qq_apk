package com.tencent.gdtad.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.gdtad.statistics.GdtTraceReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.FileUtils;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;

public class GdtAppOpenUtil
{
  private static Intent a(String paramString)
  {
    return BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(paramString);
  }
  
  private static Intent a(String paramString, Uri paramUri)
  {
    Intent localIntent = new Intent();
    if (paramUri != null) {
      localIntent.setData(paramUri);
    }
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.setPackage(paramString);
    }
    return localIntent;
  }
  
  public static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      Object localObject = paramString;
      if (i >= 0) {
        localObject = paramString.substring(i + 1);
      }
      paramString = ((String)localObject).split("&");
      if (paramString != null)
      {
        int j = paramString.length;
        i = 0;
        while (i < j)
        {
          localObject = paramString[i].split("=");
          if (localObject.length > 1)
          {
            String str = URLDecoder.decode(localObject[1]);
            localHashMap.put(localObject[0], str);
          }
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    StartAppCheckHandler.a("scheme", paramString1, paramString2, "4", "gdtAppAd", paramContext.getClass().getName());
  }
  
  public static void a(Bundle paramBundle)
  {
    Common.a();
    Object localObject1 = paramBundle.getString("schemaUrl");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("&"))) {
      if (!((String)localObject1).startsWith("http://")) {}
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        String str = new URL((String)localObject1).getQuery();
        Object localObject5 = Common.a(str);
        localObject4 = (String)((HashMap)localObject5).get("appid");
        localObject1 = localObject4;
        localObject3 = str;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = (String)((HashMap)localObject5).get(DownloadConstants.a);
          localObject3 = str;
        }
        str = Common.g() + File.separator + "qapp_center_detail.htm";
        localObject4 = new File(str);
        if (!((File)localObject4).exists()) {
          FileUtils.a("Page/system", Common.h());
        }
        localObject5 = new Intent();
        Bundle localBundle = new Bundle();
        if (!((File)localObject4).exists()) {
          break label417;
        }
        str = "file:///" + str;
        localObject4 = "&from=-10&id=" + (String)localObject1 + "&channelId=" + "2410";
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(localObject1))) {
          break label448;
        }
        localObject1 = localObject4;
        localObject3 = localObject1;
        if ("1".equals((String)Common.a(paramBundle.getString("schemaUrl")).get("auto_download")))
        {
          localObject3 = localObject1;
          if (!((String)localObject1).contains("auto_download")) {
            localObject3 = (String)localObject1 + "&auto_download=1";
          }
        }
        ((Intent)localObject5).setClass(CommonDataAdapter.a().a(), QZoneAppListActivity.class);
        localBundle.putString("APP_URL", str);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString("APP_PARAMS", (String)localObject3);
        localBundle.putInt("goto_type", 2);
        if (paramBundle.getInt("process_id") == 2) {
          localBundle.putInt("process_id", 2);
        }
        ((Intent)localObject5).putExtras(localBundle);
        ((Intent)localObject5).putExtra("adapter_action", "action_app_detail");
        ((Intent)localObject5).addFlags(872415232);
        CommonDataAdapter.a().a().startActivity((Intent)localObject5);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
      Object localObject2 = localObject1;
      continue;
      Object localObject3 = localObject1;
      continue;
      label417:
      localObject2 = Common.m() + File.separator + "qapp_center_detail.htm";
      continue;
      label448:
      localObject1 = (String)localObject4 + "&" + (String)localObject3;
    }
  }
  
  public static void a(GdtBaseAdItem paramGdtBaseAdItem)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      ((GdtAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(110)).a(BaseApplicationImpl.getContext(), paramGdtBaseAdItem);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("gdtBaseAdItem", paramGdtBaseAdItem);
    QIPCClientHelper.getInstance().callServer("gdt_ipc", "do_app_jump", localBundle, null);
  }
  
  public static boolean a(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    if (!c(paramContext, paramGdtBaseAdItem)) {
      return b(paramContext, paramGdtBaseAdItem);
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = Uri.parse(paramString2);
          bool1 = bool2;
          if (!"http".equalsIgnoreCase(paramString2.getScheme()))
          {
            bool1 = bool2;
            if (!"https".equalsIgnoreCase(paramString2.getScheme()))
            {
              paramString1 = a(paramString1, paramString2);
              bool1 = bool2;
              if (paramContext.getPackageManager().resolveActivity(paramString1, 65536) != null) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (!"http".equalsIgnoreCase(paramString.getScheme()))
      {
        bool1 = bool2;
        if (!"https".equalsIgnoreCase(paramString.getScheme())) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean b(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramGdtBaseAdItem.packageName))
      {
        localIntent = a(paramGdtBaseAdItem.packageName);
        bool1 = bool2;
        if (localIntent != null) {
          bool1 = bool3;
        }
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      bool3 = true;
      bool2 = true;
      bool1 = bool3;
      GdtTraceReporter.a(138, paramGdtBaseAdItem.traceId, paramGdtBaseAdItem.productId);
      bool1 = bool3;
      a(paramContext, paramGdtBaseAdItem.downloadScheme, paramGdtBaseAdItem.packageName);
      bool1 = bool3;
      GdtLog.a("GdtAppOpenUtil", "launchAPPMain report " + paramGdtBaseAdItem.toString());
      bool1 = bool2;
      return bool1;
    }
    catch (Exception paramContext)
    {
      GdtLog.d("GdtAppOpenUtil", "launchApp failed", paramContext);
    }
    return bool1;
  }
  
  private static boolean c(Context paramContext, GdtBaseAdItem paramGdtBaseAdItem)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (a(paramContext, paramGdtBaseAdItem.packageName, paramGdtBaseAdItem.deepLinkUrl))
    {
      Object localObject = Uri.parse(paramGdtBaseAdItem.deepLinkUrl);
      localObject = a(paramGdtBaseAdItem.packageName, (Uri)localObject);
      if (localObject != null) {
        bool1 = bool2;
      }
      try
      {
        paramContext.startActivity((Intent)localObject);
        boolean bool3 = true;
        bool2 = true;
        bool1 = bool3;
        GdtTraceReporter.a(137, paramGdtBaseAdItem.traceId, paramGdtBaseAdItem.productId);
        bool1 = bool3;
        a(paramContext, paramGdtBaseAdItem.downloadScheme, paramGdtBaseAdItem.packageName);
        bool1 = bool3;
        GdtLog.a("GdtAppOpenUtil", "launchAPPDeepLink report " + paramGdtBaseAdItem.toString());
        bool1 = bool2;
        return bool1;
      }
      catch (Exception paramContext)
      {
        GdtLog.d("GdtAppOpenUtil", "launchAPPDeepLink failed", paramContext);
        return bool1;
      }
    }
    GdtLog.a("GdtAppOpenUtil", "launchAPPDeepLink isDLURISupported false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtAppOpenUtil
 * JD-Core Version:    0.7.0.1
 */