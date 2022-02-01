package com.tencent.falco.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class DevOptUtil
{
  private static final String LITE_SDK = "lite_sdk";
  private static final String PLAYER_SIGN = "player";
  private static final String SIGN_FILE_FOLDER = "dev_opts";
  private static final String TEST_ENV_SIGN = "test_env";
  private static String sTargetTestEnvStr;
  
  public static String getLiteSdkFilePath(Context paramContext)
  {
    return getSignFileRootPath(paramContext) + "/" + "dev_opts" + "/" + "lite_sdk";
  }
  
  public static String getPlayerFilePath(Context paramContext)
  {
    return getSignFileRootPath(paramContext) + "/" + "dev_opts" + "/" + "player";
  }
  
  private static String getSignFileRootPath(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  public static String getTargetTestEnvStr(Context paramContext)
  {
    if (TextUtils.isEmpty(sTargetTestEnvStr)) {
      return "";
    }
    if (paramContext != null)
    {
      sTargetTestEnvStr = FileUtil.readString(getTestEnvFilePath(paramContext));
      return sTargetTestEnvStr;
    }
    return "";
  }
  
  public static String getTestEnvFilePath(Context paramContext)
  {
    return getSignFileRootPath(paramContext) + "/" + "dev_opts" + "/" + "test_env";
  }
  
  public static boolean isLiteSDK(Context paramContext)
  {
    return FileUtil.exists(getLiteSdkFilePath(paramContext));
  }
  
  public static boolean isTestEnv(Context paramContext)
  {
    return FileUtil.exists(getTestEnvFilePath(paramContext));
  }
  
  public static void setTargetTestEnv(Context paramContext, String paramString)
  {
    sTargetTestEnvStr = paramString;
    FileUtil.writeString(getTestEnvFilePath(paramContext), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.DevOptUtil
 * JD-Core Version:    0.7.0.1
 */