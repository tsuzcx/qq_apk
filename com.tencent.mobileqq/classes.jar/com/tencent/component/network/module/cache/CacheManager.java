package com.tencent.component.network.module.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.cache.file.FileStorageHandler;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import java.io.File;
import java.util.HashMap;
import pii;
import pij;

public class CacheManager
{
  private static final FileStorageHandler jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileStorageHandler = new FileStorageHandler(new pii());
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static FileCacheService a(Context paramContext)
  {
    String str2 = "tmp";
    String str3 = Utils.getCurrentProcessName(paramContext);
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.contains(":"))
      {
        int i = str3.lastIndexOf(":");
        str1 = str2;
        if (i > 0) {
          str1 = "tmp" + "_" + str3.substring(i + 1);
        }
      }
    }
    return a(paramContext, str1, 500, 200);
  }
  
  public static FileCacheService a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramString, paramInt1, paramInt2, false);
  }
  
  public static FileCacheService a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      synchronized (jdField_a_of_type_JavaUtilHashMap)
      {
        FileCacheService localFileCacheService2 = (FileCacheService)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        FileCacheService localFileCacheService1 = localFileCacheService2;
        if (localFileCacheService2 == null)
        {
          localFileCacheService1 = new FileCacheService(paramContext, paramString, paramInt1, paramInt2, paramBoolean);
          localFileCacheService1.a(jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileStorageHandler);
          jdField_a_of_type_JavaUtilHashMap.put(paramString, localFileCacheService1);
        }
        return localFileCacheService1;
      }
    }
  }
  
  public static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = b(paramContext, paramBoolean);
    if (str == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = str;
    } while (TextUtils.isEmpty(paramString));
    paramContext = new File(str + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtils.delete(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramContext.getCacheDir().getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + "cache";
  }
  
  public static boolean a()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static String b(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = a(paramContext, paramBoolean);
    if (TextUtils.isEmpty(paramString)) {
      return paramContext;
    }
    paramContext = new File(paramContext + File.separator + paramString);
    if (paramContext.isFile()) {
      FileUtils.delete(paramContext);
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  private static String b(Context paramContext, boolean paramBoolean)
  {
    if (!a()) {}
    for (;;)
    {
      return null;
      if (!paramBoolean) {}
      for (paramContext = pij.a(paramContext, false); paramContext != null; paramContext = pij.a(paramContext, "cache", false)) {
        return paramContext.getAbsolutePath();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */