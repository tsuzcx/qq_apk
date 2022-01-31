package com.tencent.mobileqq.activity.qwallet.preload;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ResUtil
{
  public static int a(String paramString)
  {
    int j = 0;
    SharedPreferences localSharedPreferences = a();
    int i = j;
    if (localSharedPreferences != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramString)) {
        i = localSharedPreferences.getInt("url_abnormal_retry_times" + paramString, 0);
      }
    }
    return i;
  }
  
  public static long a()
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("check_surplus_res_time", 0L);
    }
    return l;
  }
  
  public static long a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    long l = paramLong;
    if (localSharedPreferences != null)
    {
      l = paramLong;
      if (!TextUtils.isEmpty(paramString)) {
        l = localSharedPreferences.getLong("url_doneTime" + paramString, paramLong);
      }
    }
    return l;
  }
  
  private static SharedPreferences a()
  {
    if (BaseApplicationImpl.getApplication() != null) {
      return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_util", 4);
    }
    return null;
  }
  
  public static ResourceInfo a(String paramString, PreloadManager paramPreloadManager, boolean paramBoolean, int paramInt)
  {
    ResourceInfo localResourceInfo = new ResourceInfo();
    localResourceInfo.url = paramString;
    paramPreloadManager = paramPreloadManager.c(paramString);
    if (!TextUtils.isEmpty(paramPreloadManager))
    {
      localResourceInfo.filePath = paramPreloadManager;
      localResourceInfo.fileMd5 = b(paramString, paramPreloadManager);
      localResourceInfo.doneTime = a(paramString, 0L);
      if ((paramBoolean) || (PreloadResource.isNeedAutoUnzip(paramString, paramInt)))
      {
        paramString = PreloadResource.getFolderPathByMD5AndUrl(localResourceInfo.fileMd5, paramString);
        if (!PreloadResource.isFolderPathValid(paramString)) {
          break label92;
        }
        localResourceInfo.folderPath = paramString;
      }
    }
    label92:
    while (!PreloadResource.unzipAtomically(localResourceInfo.filePath, paramString)) {
      return localResourceInfo;
    }
    localResourceInfo.folderPath = paramString;
    return localResourceInfo;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = a();
    String str = paramString2;
    if (localSharedPreferences != null)
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1)) {
        str = localSharedPreferences.getString("url_md5" + paramString1, paramString2);
      }
    }
    return str;
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getAll().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getKey();
        if (str.startsWith("url_last_use_time")) {
          localArrayList.add(new ResUtil.ResTimeInfo(str.substring("url_last_use_time".length(), str.length()), ((Long)localEntry.getValue()).longValue()));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("check_surplus_res_time", paramLong).apply();
    }
  }
  
  public static void a(String paramString)
  {
    int i = a(paramString);
    SharedPreferences localSharedPreferences = a();
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putInt("url_abnormal_retry_times" + paramString, i + 1).apply();
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putLong("url_last_use_time" + paramString, paramLong).apply();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = a();
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      localSharedPreferences.edit().putString("url_md5" + paramString1, paramString2).apply();
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    a(paramString1, paramString2);
    b(paramString1, paramLong);
    a(paramString1, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("has_check_old_folder", paramBoolean).apply();
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = a();
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean("has_check_old_folder", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str2 = a(paramString1, "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString2))
      {
        str1 = str2;
        if (new File(paramString2).exists())
        {
          str1 = MD5Coding.encodeFile2HexStr(paramString2);
          a(paramString1, str1);
        }
      }
    }
    return str1;
  }
  
  public static void b(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      localSharedPreferences.edit().remove("url_doneTime" + paramString);
      localSharedPreferences.edit().remove("url_md5" + paramString);
      localSharedPreferences.edit().remove("url_last_use_time" + paramString);
      localSharedPreferences.edit().remove("url_abnormal_retry_times" + paramString).apply();
    }
  }
  
  public static void b(String paramString, long paramLong)
  {
    int j = 1;
    SharedPreferences localSharedPreferences = a();
    int i;
    if (localSharedPreferences != null)
    {
      i = 1;
      if (TextUtils.isEmpty(paramString)) {
        break label72;
      }
    }
    for (;;)
    {
      if ((i & j) != 0) {
        localSharedPreferences.edit().putLong("url_doneTime" + paramString, paramLong).apply();
      }
      return;
      i = 0;
      break;
      label72:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.ResUtil
 * JD-Core Version:    0.7.0.1
 */