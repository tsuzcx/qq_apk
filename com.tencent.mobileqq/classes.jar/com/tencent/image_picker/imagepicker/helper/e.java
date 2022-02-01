package com.tencent.image_picker.imagepicker.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.util.Locale;

public class e
{
  private static String a;
  
  public static Context a(Context paramContext)
  {
    Locale localLocale = new Locale(a());
    Locale.setDefault(localLocale);
    Resources localResources = paramContext.getResources();
    Configuration localConfiguration = new Configuration(localResources.getConfiguration());
    if (Build.VERSION.SDK_INT >= 17)
    {
      localConfiguration.setLocale(localLocale);
      return paramContext.createConfigurationContext(localConfiguration);
    }
    localConfiguration.locale = localLocale;
    localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
    return paramContext;
  }
  
  private static String a()
  {
    String str = a;
    if ((str != null) && (!str.isEmpty())) {
      return a;
    }
    return Locale.getDefault().getLanguage();
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.helper.e
 * JD-Core Version:    0.7.0.1
 */