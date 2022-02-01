package com.tencent.luggage.wxa.hz;

import android.content.Context;
import android.os.Environment;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.w;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/loader/stub/CConstants;", "", "()V", "CONST_COMPATIBLE_INFO_FILENAME", "", "CONST_DEFAULT_EXTERNAL_DATA_DIR", "CONST_DEVICE_HARDWARE_ID", "", "CONST_DEVICE_ID", "CONST_DEVICE_IMEI", "CONST_DEVICE_TYPE", "CONST_STORAGE_CAMERA", "CONST_STORAGE_DOWNLOAD", "CONST_STORAGE_TEMP", "CONST_STORAGE_USE_OLD_SDCARD_ROOT", "DATAROOT_DEFAULT_SDCARD_CAMERA_PATH", "getDATAROOT_DEFAULT_SDCARD_CAMERA_PATH", "()Ljava/lang/String;", "DATAROOT_MOBILEMEM_PATH", "DATAROOT_NEW_SDCARD_PATH", "DATAROOT_PUBLIC_PATH", "DATAROOT_SDCARD_CAMERA_PATH", "DATAROOT_SDCARD_DOWNLOAD_PATH", "DATAROOT_SDCARD_PATH", "DATAROOT_SDCARD_PATH_VAL", "", "[Ljava/lang/String;", "DATAROOT_SDCARD_TEMP_PATH", "DATA_ROOT", "DATA_ROOT_VAL", "DEFAULT_SDCARD_ROOT", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "NEW_SDCARD_CAMERA_PATH", "getNEW_SDCARD_CAMERA_PATH", "NEW_SDCARD_ROOT", "SDCARD_ROOT_VAL", "STORAGE_NAMESPACE", "TAG", "WMPF_APK_NAMESPACE", "SDCARD_ROOT", "init", "", "namespace", "wechat-sdk-alternative_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  private static String b = "luggage";
  private static final String[] c = new String[1];
  private static final String[] d = new String[1];
  private static final String[] e = new String[1];
  
  @JvmStatic
  @JvmName(name="DEFAULT_SDCARD_ROOT")
  @NotNull
  public static final String a()
  {
    Object localObject = Environment.getExternalStorageDirectory();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Environment.getExternalStorageDirectory()");
    localObject = ((File)localObject).getAbsolutePath();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Environment.getExternalS…eDirectory().absolutePath");
    return localObject;
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "namespace");
    b = paramString;
  }
  
  @JvmStatic
  @JvmName(name="NEW_SDCARD_ROOT")
  @Nullable
  public static final String b()
  {
    Object localObject = r.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getExternalCacheDir();
    if (localObject != null)
    {
      localObject = ((File)localObject).getParentFile();
      if (localObject != null) {
        return ((File)localObject).getAbsolutePath();
      }
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final String c()
  {
    for (;;)
    {
      synchronized (c)
      {
        Object localObject1;
        if (c[0] != null)
        {
          localObject1 = c[0];
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          return localObject1;
        }
        if (a.k().getBoolean("CONST_STORAGE_USE_OLD_SDCARD_ROOT", false))
        {
          o.d("Luggage.CConstants", "SDCARD_ROOT=default, by MMKV");
          localObject1 = a();
        }
        else
        {
          if (Intrinsics.areEqual("wmpf", b))
          {
            localObject1 = new File(a(), "/tencent/MicroMsg/luggage/");
            if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory()) || (!((File)localObject1).canWrite())) {
              break label201;
            }
            i = 1;
            if (i != 0)
            {
              o.d("Luggage.CConstants", "SDCARD_ROOT=default, by existed directory");
              a.k().putBoolean("CONST_STORAGE_USE_OLD_SDCARD_ROOT", true);
              localObject1 = a();
              continue;
            }
          }
          localObject1 = b();
          if (localObject1 == null) {
            localObject1 = a();
          }
        }
        c[0] = localObject1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SDCARD_ROOT_VAL[0] = ");
        localStringBuilder.append((String)localObject1);
        o.d("Luggage.CConstants", localStringBuilder.toString());
        return localObject1;
      }
      label201:
      int i = 0;
    }
  }
  
  @JvmStatic
  @JvmName(name="DATAROOT_SDCARD_PATH")
  @NotNull
  public static final String d()
  {
    synchronized (d)
    {
      if (d[0] != null)
      {
        localObject1 = d[0];
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        return localObject1;
      }
      Object localObject1 = c();
      if (Intrinsics.areEqual(localObject1, a()))
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append((String)localObject1);
        localStringBuilder1.append("/tencent/MicroMsg/luggage/");
        localObject1 = localStringBuilder1.toString();
        return localObject1;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("files/");
      localStringBuilder2.append(b);
      localObject1 = new File((String)localObject1, localStringBuilder2.toString());
      ((File)localObject1).mkdirs();
      localStringBuilder1.append(((File)localObject1).getAbsolutePath());
      localStringBuilder1.append("/");
      localObject1 = localStringBuilder1.toString();
      d[0] = localObject1;
      return localObject1;
    }
  }
  
  @JvmStatic
  @JvmName(name="DATAROOT_SDCARD_DOWNLOAD_PATH")
  @NotNull
  public static final String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("Download/");
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @JvmName(name="DATAROOT_SDCARD_CAMERA_PATH")
  @NotNull
  public static final String f()
  {
    if (Intrinsics.areEqual(c(), b())) {
      return a.m();
    }
    return a.l();
  }
  
  @JvmStatic
  @JvmName(name="DATAROOT_SDCARD_TEMP_PATH")
  @NotNull
  public static final String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("Temp/");
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @JvmName(name="DATA_ROOT")
  @NotNull
  public static final String h()
  {
    synchronized (e)
    {
      if (e[0] == null)
      {
        Object localObject3 = r.a();
        if (localObject3 != null)
        {
          localObject1 = e;
          StringBuilder localStringBuilder = new StringBuilder();
          localObject3 = ((Context)localObject3).getFilesDir();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "context.filesDir");
          localObject3 = ((File)localObject3).getParentFile();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "context.filesDir.parentFile");
          localStringBuilder.append(((File)localObject3).getAbsolutePath());
          localStringBuilder.append("/");
          localObject1[0] = localStringBuilder.toString();
        }
        else
        {
          throw ((Throwable)new IllegalStateException("MMApplicationContext not initialized.".toString()));
        }
      }
      Object localObject1 = e[0];
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      return localObject1;
    }
  }
  
  @JvmStatic
  @JvmName(name="DATAROOT_MOBILEMEM_PATH")
  @NotNull
  public static final String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h());
    localStringBuilder.append(b);
    localStringBuilder.append('/');
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  @JvmName(name="DATAROOT_PUBLIC_PATH")
  @NotNull
  public static final String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h());
    localStringBuilder.append("files/public/");
    return localStringBuilder.toString();
  }
  
  private final w k()
  {
    w localw = w.a("__luggage_stub_CConstants.cfg");
    Intrinsics.checkExpressionValueIsNotNull(localw, "MultiProcessMMKV.getMMKV…age_stub_CConstants.cfg\")");
    return localw;
  }
  
  private final String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d());
    localStringBuilder.append("Camera/");
    return localStringBuilder.toString();
  }
  
  private final String m()
  {
    Object localObject1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    Object localObject2 = (File)null;
    if (localObject1 != null)
    {
      localObject1 = new File((File)localObject1, "tencent/wxa/");
    }
    else
    {
      localObject1 = b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Pictures/");
      ((StringBuilder)localObject2).append("tencent/wxa/");
      localObject2 = new File((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        localObject1 = localObject2;
        if (!((File)localObject2).mkdirs()) {
          localObject1 = new File(l());
        }
      }
    }
    try
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getCanonicalPath());
      ((StringBuilder)localObject2).append("/");
      localObject2 = ((StringBuilder)localObject2).toString();
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      label133:
      break label133;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append("/");
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hz.a
 * JD-Core Version:    0.7.0.1
 */