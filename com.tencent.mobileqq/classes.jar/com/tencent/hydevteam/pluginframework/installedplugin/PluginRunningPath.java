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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getPluginRootDir(paramContext, paramString));
    localStringBuilder.append("data");
    localStringBuilder.append(File.separator);
    paramContext = localStringBuilder.toString();
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static String getPluginLibDir(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    Object localObject = "lib";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lib");
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(getPluginRootDir(paramContext, paramString1));
    paramString2.append((String)localObject);
    paramString2.append(File.separator);
    paramContext = paramString2.toString();
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
    boolean bool = TextUtils.isEmpty(paramString2);
    Object localObject = "optDex";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("optDex");
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(getPluginRootDir(paramContext, paramString1));
    paramString2.append((String)localObject);
    paramString2.append(File.separator);
    paramContext = paramString2.toString();
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static String getPluginRootDir(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getDir("HYDTPlugins", 0).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    paramContext = localStringBuilder.toString();
    paramString = new File(paramContext);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static String getPluginTmpDir(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    Object localObject = "tmp";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tmp");
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(getPluginRootDir(paramContext, paramString1));
    paramString2.append((String)localObject);
    paramString2.append(File.separator);
    paramContext = paramString2.toString();
    paramString1 = new File(paramContext);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    return paramContext;
  }
  
  @API
  public static boolean isPreOdexFileExists(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = getPluginOptDexDir(paramContext, paramString1, paramString2);
    paramString1 = new StringBuilder();
    paramString1.append(paramString3);
    paramString1.append(".preload");
    return new File(paramContext, paramString1.toString()).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath
 * JD-Core Version:    0.7.0.1
 */