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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
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
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  private static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
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
    if (paramString.equalsIgnoreCase("2G")) {
      return 2;
    }
    return 0;
  }
  
  public static long a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(b);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long a(String paramString)
  {
    long l;
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
      localSimpleDateFormat.setCalendar(new GregorianCalendar());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = localSimpleDateFormat.parse(paramString).getTime();
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseTime exception: ");
      localStringBuilder.append(localException);
      QLog.e("springHb_Utils", 1, localStringBuilder.toString());
      l = 0L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("springHb_Utils", 2, String.format("parseTime timeStr=%s timeMillis=%s", new Object[] { paramString, Long.valueOf(l) }));
    }
    return l;
  }
  
  public static Drawable a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramAppRuntime != null)
    {
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)paramAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      if (localSpringFestivalEntryManager != null)
      {
        paramString2 = localSpringFestivalEntryManager.a(paramString1, paramString2);
        if (paramString2 != null)
        {
          paramAppRuntime = new BitmapDrawable(paramAppRuntime.getApp().getResources(), paramString2);
          break label58;
        }
      }
    }
    paramAppRuntime = null;
    label58:
    if (paramAppRuntime != null) {
      return paramAppRuntime;
    }
    paramAppRuntime = a(paramString1, paramInt1, paramInt2, false);
    if (paramAppRuntime != null) {
      paramAppRuntime.startDownload();
    }
    return paramAppRuntime;
  }
  
  private static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a(new ColorDrawable(7));
    localApngOptions.a(true);
    localApngOptions.b(paramInt1);
    localApngOptions.c(paramInt2);
    String str = SpringHbHelper.a(paramString);
    if (!FileUtils.isEmptyFile(str)) {
      return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", localApngOptions, str);
    }
    if (paramString.startsWith("https://")) {
      return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, localApngOptions);
    }
    return null;
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramBoolean) {
        return a(paramString, paramInt1, paramInt2);
      }
      Object localObject = a(paramString);
      if (localObject != null)
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mUseApngImage = false;
        paramString.mUseMemoryCache = true;
        paramString.mRequestWidth = paramInt1;
        paramString.mRequestHeight = paramInt2;
        paramString.mLoadingDrawable = new ColorDrawable(7);
        return URLDrawable.getDrawable((URL)localObject, paramString);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resource url parse error:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HBEntryBannerView", 2, "loadUrlDrawable input params error");
    }
    return null;
  }
  
  private static URL a(String paramString)
  {
    Object localObject = null;
    try
    {
      String str = SpringHbHelper.a(paramString);
      boolean bool = FileUtils.isEmptyFile(str);
      if (!bool)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resource url is file:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject).toString());
        }
        return new URI(Uri.fromFile(new File(str)).toString()).toURL();
      }
      if (paramString.startsWith("https://"))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resource url is network:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new URL(paramString);
      }
      return localObject;
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(b);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = paramString.split("\\|");
    int j = NetworkUtil.getSystemNetwork(paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("current net type: ");
      paramContext.append(j);
      QLog.d("SpringFestivalRedpakcet", 2, paramContext.toString());
    }
    int k = paramString.length;
    int i = 0;
    while (i < k)
    {
      if (a(paramString[i]) == j) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    JSONObject localJSONObject = HtmlOffline.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString);
    paramString = HtmlOffline.a(paramString);
    int i;
    if (localJSONObject != null) {
      i = localJSONObject.optInt("version", 0);
    } else {
      i = 0;
    }
    int j;
    if (paramString != null) {
      j = paramString.optInt("version", 0);
    } else {
      j = 0;
    }
    return (i != 0) || (j != 0);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!StringUtil.a(paramString2))
    {
      paramString2 = paramString2.split("\\|");
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        if (paramString2[i].equals(paramString1)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.Utils
 * JD-Core Version:    0.7.0.1
 */