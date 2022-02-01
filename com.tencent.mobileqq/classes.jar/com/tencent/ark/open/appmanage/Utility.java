package com.tencent.ark.open.appmanage;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility
{
  static final Pattern PATTERN_VALID_APPID = Pattern.compile("^[\\w\\d]+(\\.[\\w\\d]+)+$");
  private static final String TAG = "ArkApp.ArkAppMgr";
  
  public static String QueryAppRetCodeToString(int paramInt)
  {
    if (paramInt != -8)
    {
      if (paramInt != -7)
      {
        if (paramInt != -6)
        {
          if (paramInt != -3)
          {
            if (paramInt != -2)
            {
              if (paramInt != -1)
              {
                if (paramInt != 0)
                {
                  if (paramInt != 5)
                  {
                    if (paramInt != 6)
                    {
                      if (paramInt != 7)
                      {
                        if (paramInt > 0) {
                          return "服务端其他错误";
                        }
                        return "未知错误";
                      }
                      return "应用更新失败";
                    }
                    return "请将QQ升级到最新版本后查看";
                  }
                  return "应用未上架";
                }
                return "成功";
              }
              return "客户端其他错误";
            }
            return "网络异常，点击重试";
          }
          return "应用组件更新失败";
        }
        return "应用组件加载中。";
      }
      return "加载超时";
    }
    return "无效的视图";
  }
  
  public static int compareVersionString(String paramString1, String paramString2)
  {
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    Logger.logI("ArkApp.ArkAppMgr", new Object[] { "compareVersionString: ver1=", paramString1, ",ver2=", paramString2 });
    int i = 0;
    if (i < 4) {}
    for (;;)
    {
      try
      {
        if (arrayOfString1.length <= i) {
          break label141;
        }
        j = Integer.parseInt(arrayOfString1[i]);
        int k;
        if (arrayOfString2.length > i) {
          k = Integer.parseInt(arrayOfString2[i]);
        } else {
          k = 0;
        }
        if (j > k) {
          return 1;
        }
        if (j < k) {
          return -1;
        }
        i += 1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        Logger.logI("ArkApp.ArkAppMgr", new Object[] { "compareVersionString: Exception:", paramString1.getMessage() });
      }
      return 0;
      label141:
      int j = 0;
    }
  }
  
  public static boolean deleteFile(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (paramFile.isFile())
      {
        if (!paramFile.delete())
        {
          paramFile.deleteOnExit();
          return false;
        }
        return true;
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          while (i < j)
          {
            deleteFile(arrayOfFile[i]);
            i += 1;
          }
        }
        return paramFile.delete();
      }
    }
    return false;
  }
  
  public static String getAppDirByNameAndVersion(String paramString)
  {
    return String.format("%s/%s", new Object[] { ArkEnvironmentManager.getInstance().getAppInstallDirectory(), paramString });
  }
  
  public static String getAppPathByNameAndVersion(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s/%s.%s", new Object[] { getAppDirByNameAndVersion(paramString1), paramString2, paramString3 });
  }
  
  public static boolean isValidAppName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return PATTERN_VALID_APPID.matcher(paramString).find();
  }
  
  public static boolean isValidAppVersion(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (paramString.matches("^\\d+(\\.\\d+){0,3}$")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.Utility
 * JD-Core Version:    0.7.0.1
 */