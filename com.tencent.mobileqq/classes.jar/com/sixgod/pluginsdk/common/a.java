package com.sixgod.pluginsdk.common;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getDir("SixGodPlugin", 0).getAbsolutePath() + File.separator + paramString + File.separator;
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = new File(b(paramContext, paramString1, paramString2)).listFiles();
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramString1 = paramContext[i];
      if (paramString1.getName().endsWith(".dex"))
      {
        paramString2 = paramString1.getName();
        if (Pattern.compile("classes[\\d]+\\.dex").matcher(paramString2).matches()) {
          localStringBuilder.append(paramString1.getAbsolutePath()).append(File.pathSeparator);
        }
      }
      i += 1;
    }
    if (localStringBuilder.toString().endsWith(File.pathSeparator))
    {
      i = localStringBuilder.length() - 1;
      localStringBuilder.delete(i, i);
    }
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString) + "data" + File.separator;
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = a(paramContext, paramString1) + File.separator + "multi_dexes";
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    paramContext = paramContext + File.separator + paramString2;
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2)
  {
    String str = "optDex";
    if (!TextUtils.isEmpty(paramString2)) {
      str = "optDex" + "_" + paramString2;
    }
    return a(paramContext, paramString1) + str + File.separator;
  }
  
  public static String d(Context paramContext, String paramString1, String paramString2)
  {
    String str = "lib";
    if (!TextUtils.isEmpty(paramString2)) {
      str = "lib" + "_" + paramString2;
    }
    paramContext = a(paramContext, paramString1) + str + File.separator;
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.common.a
 * JD-Core Version:    0.7.0.1
 */