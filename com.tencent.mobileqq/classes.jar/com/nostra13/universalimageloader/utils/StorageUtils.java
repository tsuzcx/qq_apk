package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class StorageUtils
{
  private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
  private static final String INDIVIDUAL_DIR_NAME = "uil-images";
  
  public static File getCacheDirectory(Context paramContext)
  {
    return getCacheDirectory(paramContext, true);
  }
  
  public static File getCacheDirectory(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = "";
    try
    {
      localObject2 = Environment.getExternalStorageState();
      localObject1 = localObject2;
    }
    catch (NullPointerException|IncompatibleClassChangeError localNullPointerException)
    {
      Object localObject2;
      label12:
      break label12;
    }
    if ((paramBoolean) && ("mounted".equals(localObject1)) && (hasExternalStoragePermission(paramContext))) {
      localObject2 = getExternalCacheDir(paramContext);
    } else {
      localObject2 = null;
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getCacheDir();
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/data/data/");
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append("/cache/");
      paramContext = ((StringBuilder)localObject1).toString();
      L.w("Can't define system cache directory! '%s' will be used.", new Object[] { paramContext });
      localObject2 = new File(paramContext);
    }
    return localObject2;
  }
  
  private static File getExternalCacheDir(Context paramContext)
  {
    paramContext = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), paramContext.getPackageName()), "cache");
    if (!paramContext.exists()) {
      if (!paramContext.mkdirs())
      {
        L.w("Unable to create external cache directory", new Object[0]);
        return null;
      }
    }
    try
    {
      new File(paramContext, ".nomedia").createNewFile();
      return paramContext;
    }
    catch (IOException localIOException)
    {
      label83:
      break label83;
    }
    L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
    return paramContext;
  }
  
  public static File getIndividualCacheDirectory(Context paramContext)
  {
    return getIndividualCacheDirectory(paramContext, "uil-images");
  }
  
  public static File getIndividualCacheDirectory(Context paramContext, String paramString)
  {
    paramContext = getCacheDirectory(paramContext);
    paramString = new File(paramContext, paramString);
    if ((!paramString.exists()) && (!paramString.mkdir())) {
      return paramContext;
    }
    return paramString;
  }
  
  public static File getOwnCacheDirectory(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (hasExternalStoragePermission(paramContext))) {
      paramString = new File(Environment.getExternalStorageDirectory(), paramString);
    } else {
      paramString = null;
    }
    Object localObject;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.exists())
      {
        localObject = paramString;
        if (paramString.mkdirs()) {}
      }
    }
    else
    {
      localObject = paramContext.getCacheDir();
    }
    return localObject;
  }
  
  public static File getOwnCacheDirectory(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ("mounted".equals(Environment.getExternalStorageState())) && (hasExternalStoragePermission(paramContext))) {
      paramString = new File(Environment.getExternalStorageDirectory(), paramString);
    } else {
      paramString = null;
    }
    Object localObject;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.exists())
      {
        localObject = paramString;
        if (paramString.mkdirs()) {}
      }
    }
    else
    {
      localObject = paramContext.getCacheDir();
    }
    return localObject;
  }
  
  private static boolean hasExternalStoragePermission(Context paramContext)
  {
    return paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.StorageUtils
 * JD-Core Version:    0.7.0.1
 */