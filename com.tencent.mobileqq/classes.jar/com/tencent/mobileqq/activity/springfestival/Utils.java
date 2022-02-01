package com.tencent.mobileqq.activity.springfestival;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class Utils
{
  public static String a = "spring_festival_hb_offline_donwload_cnt";
  public static String b = "spring_festival_hb_offline_donwload_ts";
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1 + "_" + a + "_" + paramString2, 0);
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("WiFi")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("5G")) {
        return 6;
      }
      if (paramString.equalsIgnoreCase("4G")) {
        return 4;
      }
      if (paramString.equalsIgnoreCase("3G")) {
        return 3;
      }
    } while (!paramString.equalsIgnoreCase("2G"));
    return 2;
  }
  
  public static long a(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString1 + "_" + b + "_" + paramString2, 0L);
  }
  
  public static long a(String paramString)
  {
    long l1 = 0L;
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
      localSimpleDateFormat.setCalendar(new GregorianCalendar());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      long l2 = localSimpleDateFormat.parse(paramString).getTime();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("springHb_Utils", 1, "parseTime exception: " + localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("springHb_Utils", 2, String.format("parseTime timeStr=%s timeMillis=%s", new Object[] { paramString, Long.valueOf(l1) }));
    }
    return l1;
  }
  
  public static Drawable a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramAppRuntime != null)
    {
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)paramAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (localSpringFestivalEntryManager != null)
      {
        paramString2 = localSpringFestivalEntryManager.a(paramString1, paramString2);
        if (paramString2 == null) {}
      }
    }
    for (paramAppRuntime = new BitmapDrawable(paramAppRuntime.getApp().getResources(), paramString2);; paramAppRuntime = null)
    {
      if (paramAppRuntime != null) {}
      do
      {
        return paramAppRuntime;
        paramString1 = a(paramString1, paramInt1, paramInt2, false);
        paramAppRuntime = paramString1;
      } while (paramString1 == null);
      paramString1.startDownload();
      return paramString1;
    }
  }
  
  private static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    VasApngFactory.Options localOptions = new VasApngFactory.Options();
    localOptions.a(new ColorDrawable(7));
    localOptions.a(true);
    localOptions.b(paramInt1);
    localOptions.c(paramInt2);
    URLDrawable localURLDrawable = null;
    String str = SpringHbHelper.a(paramString);
    if (!FileUtils.d(str)) {
      localURLDrawable = VasApngFactory.a("", localOptions, str);
    }
    while (!paramString.startsWith("https://")) {
      return localURLDrawable;
    }
    return VasApngFactory.a(paramString, localOptions);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "loadUrlDrawable input params error");
      }
    }
    do
    {
      return null;
      if (paramBoolean) {
        return a(paramString, paramInt1, paramInt2);
      }
      URL localURL = a(paramString);
      if (localURL != null)
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mUseApngImage = false;
        paramString.mUseMemoryCache = true;
        paramString.mRequestWidth = paramInt1;
        paramString.mRequestHeight = paramInt2;
        paramString.mLoadingDrawable = new ColorDrawable(7);
        return URLDrawable.getDrawable(localURL, paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("HBEntryBannerView", 2, "resource url parse error:" + paramString);
    return null;
  }
  
  private static URL a(String paramString)
  {
    try
    {
      String str = SpringHbHelper.a(paramString);
      if (!FileUtils.d(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HBEntryBannerView", 2, "resource url is file:" + paramString);
        }
        paramString = new URI(Uri.fromFile(new File(str)).toString()).toURL();
      }
      else if (paramString.startsWith("https://"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HBEntryBannerView", 2, "resource url is network:" + paramString);
        }
        paramString = new URL(paramString);
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    paramString = null;
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + a + "_" + paramString2, paramInt);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString1 + "_" + b + "_" + paramString2, paramLong);
    paramContext.apply();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = NetworkUtil.a(paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("SpringFestivalRedpakcet", 2, "current net type: " + j);
    }
    int k = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label84;
      }
      if (a(paramString[i]) == j) {
        break;
      }
      i += 1;
    }
    label84:
    return false;
  }
  
  public static boolean a(String paramString)
  {
    JSONObject localJSONObject = HtmlOffline.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString);
    paramString = HtmlOffline.a(paramString);
    if (localJSONObject != null) {}
    for (int i = localJSONObject.optInt("version", 0);; i = 0)
    {
      if (paramString != null) {}
      for (int j = paramString.optInt("version", 0);; j = 0) {
        return (i != 0) || (j != 0);
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (!StringUtil.a(paramString2))
    {
      paramString2 = paramString2.split("\\|");
      j = paramString2.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString2[i].equals(paramString1)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.Utils
 * JD-Core Version:    0.7.0.1
 */