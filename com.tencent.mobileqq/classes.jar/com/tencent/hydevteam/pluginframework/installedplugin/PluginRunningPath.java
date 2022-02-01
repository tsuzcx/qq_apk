package com.tencent.hydevteam.pluginframework.installedplugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hydevteam.common.annotation.API;
import java.io.File;

@API
public class PluginRunningPath
{
  @API
  public static String getPluginDataDir(Context paramContext, String paramString)
  {
    paramContext = getPluginRootDir(paramContext, paramString) + "data" + File.separator;
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static String getPluginLibDir(Context paramContext, String paramString1, String paramString2)
  {
    String str = "lib";
    if (!TextUtils.isEmpty(paramString2)) {
      str = "lib" + "_" + paramString2;
    }
    paramContext = getPluginRootDir(paramContext, paramString1) + str + File.separator;
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static String getPluginNewLibDir(Context paramContext, String paramString1, String paramString2)
  {
    return getPluginLibDir(paramContext, paramString1, paramString2);
  }
  
  @API
  public static String getPluginOptDexDir(Context paramContext, String paramString1, String paramString2)
  {
    String str = "optDex";
    if (!TextUtils.isEmpty(paramString2)) {
      str = "optDex" + "_" + paramString2;
    }
    paramContext = getPluginRootDir(paramContext, paramString1) + str + File.separator;
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static String getPluginRootDir(Context paramContext, String paramString)
  {
    paramContext = paramContext.getDir("HYDTPlugins", 0).getAbsolutePath() + File.separator + paramString + File.separator;
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static String getPluginTmpDir(Context paramContext, String paramString1, String paramString2)
  {
    String str = "tmp";
    if (!TextUtils.isEmpty(paramString2)) {
      str = "tmp" + "_" + paramString2;
    }
    paramContext = getPluginRootDir(paramContext, paramString1) + str + File.separator;
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static boolean isPreOdexFileExists(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return new File(getPluginOptDexDir(paramContext, paramString1, paramString2), paramString3 + ".preload").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath
 * JD-Core Version:    0.7.0.1
 */