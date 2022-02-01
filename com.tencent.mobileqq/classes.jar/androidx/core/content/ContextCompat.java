package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;

public class ContextCompat
{
  private static final String TAG = "ContextCompat";
  private static final Object sLock = new Object();
  private static TypedValue sTempValue;
  
  public static int checkSelfPermission(@NonNull Context paramContext, @NonNull String paramString)
  {
    if (paramString != null) {
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
    }
    throw new IllegalArgumentException("permission is null");
  }
  
  @Nullable
  public static Context createDeviceProtectedStorageContext(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.createDeviceProtectedStorageContext();
    }
    return null;
  }
  
  private static File createFilesDir(File paramFile)
  {
    try
    {
      if ((!paramFile.exists()) && (!paramFile.mkdirs()))
      {
        boolean bool = paramFile.exists();
        if (bool) {
          return paramFile;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to create files subdir ");
        localStringBuilder.append(paramFile.getPath());
        Log.w("ContextCompat", localStringBuilder.toString());
        return null;
      }
      return paramFile;
    }
    finally {}
  }
  
  public static File getCodeCacheDir(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getCodeCacheDir();
    }
    return createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "code_cache"));
  }
  
  @ColorInt
  public static int getColor(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  @Nullable
  public static ColorStateList getColorStateList(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  @Nullable
  public static File getDataDir(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.getDataDir();
    }
    paramContext = paramContext.getApplicationInfo().dataDir;
    if (paramContext != null) {
      return new File(paramContext);
    }
    return null;
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    synchronized (sLock)
    {
      if (sTempValue == null) {
        sTempValue = new TypedValue();
      }
      paramContext.getResources().getValue(paramInt, sTempValue, true);
      paramInt = sTempValue.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    }
  }
  
  @NonNull
  public static File[] getExternalCacheDirs(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  @NonNull
  public static File[] getExternalFilesDirs(@NonNull Context paramContext, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(paramString);
    }
    return new File[] { paramContext.getExternalFilesDir(paramString) };
  }
  
  public static Executor getMainExecutor(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramContext.getMainExecutor();
    }
    return new ContextCompat.MainHandlerExecutor(new Handler(paramContext.getMainLooper()));
  }
  
  @Nullable
  public static File getNoBackupFilesDir(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getNoBackupFilesDir();
    }
    return createFilesDir(new File(paramContext.getApplicationInfo().dataDir, "no_backup"));
  }
  
  @NonNull
  public static File[] getObbDirs(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getObbDirs();
    }
    return new File[] { paramContext.getObbDir() };
  }
  
  @Nullable
  public static <T> T getSystemService(@NonNull Context paramContext, @NonNull Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getSystemService(paramClass);
    }
    paramClass = getSystemServiceName(paramContext, paramClass);
    if (paramClass != null) {
      return paramContext.getSystemService(paramClass);
    }
    return null;
  }
  
  @Nullable
  public static String getSystemServiceName(@NonNull Context paramContext, @NonNull Class<?> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getSystemServiceName(paramClass);
    }
    return (String)ContextCompat.LegacyServiceMapHolder.SERVICES.get(paramClass);
  }
  
  public static boolean isDeviceProtectedStorage(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.isDeviceProtectedStorage();
    }
    return false;
  }
  
  public static boolean startActivities(@NonNull Context paramContext, @NonNull Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }
  
  public static boolean startActivities(@NonNull Context paramContext, @NonNull Intent[] paramArrayOfIntent, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivities(paramArrayOfIntent, paramBundle);
    } else {
      paramContext.startActivities(paramArrayOfIntent);
    }
    return true;
  }
  
  public static void startActivity(@NonNull Context paramContext, @NonNull Intent paramIntent, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramContext.startActivity(paramIntent, paramBundle);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void startForegroundService(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramContext.startForegroundService(paramIntent);
      return;
    }
    paramContext.startService(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.ContextCompat
 * JD-Core Version:    0.7.0.1
 */