package com.tencent.biz.flatbuffers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import bdcb;
import bdcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import mqq.app.AppRuntime;
import myl;

public class FlatBuffersParser
{
  public static volatile boolean a = true;
  public static volatile boolean b;
  public static volatile boolean c;
  
  public static long a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("flatbuffers_pref", 4).getLong("lastCrash", 0L);
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "FlatBuffers" + File.separator;
  }
  
  public static void a()
  {
    if (!b()) {
      myl.a(false).b();
    }
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    label271:
    label293:
    label306:
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        long l2 = IOUtil.getCRC32Value(paramFile);
        long l3 = System.currentTimeMillis();
        QLog.i("FlatBuffersParser", 1, "so file size: " + paramFile.length() + " crc32: " + Long.toHexString(l2) + " crcSpent: " + (l3 - l1));
        l2 = a();
        if (l1 - l2 < 86400000L)
        {
          QLog.i("FlatBuffersParser", 1, "FlatBuffers loadLibrary have lastCrash " + l2);
          return;
        }
        if (l2 != 0L)
        {
          QLog.i("FlatBuffersParser", 1, "FlatBuffers lastCrash " + l2 + " is out of date, try deleteFlatbuffers.");
          d();
          g();
          f();
          continue;
        }
        if (!paramFile.exists()) {
          continue;
        }
      }
      finally {}
      if (paramBoolean) {
        c();
      }
      try
      {
        QLog.i("FlatBuffersParser", 1, "FlatBuffers loadLibrary startLoad stl");
        QLog.flushLog();
        if (!SoLoadUtil.a(BaseApplicationImpl.getContext(), "stlport_shared", 0, false)) {
          break label293;
        }
        QLog.i("FlatBuffersParser", 1, "FlatBuffers loadLibrary startLoad FlatBuffers");
        System.load(paramFile.getAbsolutePath());
        if ((!paramBoolean) || (new FlatBuffersParser().a("{x:1,y:2}", "table Pos {\n\tx:float;\n\ty:float;\n}\nroot_type Pos;") != null)) {
          break label271;
        }
        QLog.e("FlatBuffersParser", 1, "FlatBuffers test parser failed.");
      }
      catch (Throwable paramFile)
      {
        QLog.e("FlatBuffersParser", 1, "", paramFile);
      }
      continue;
      QLog.i("FlatBuffersParser", 1, "FlatBuffers loadLibrary success");
      for (c = true;; c = false)
      {
        if (!paramBoolean) {
          break label306;
        }
        d();
        break;
        QLog.i("FlatBuffersParser", 1, "FlatBuffers load stl failed");
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("flatbuffers_pref", 4).edit();
    a = paramBoolean;
    QLog.i("FlatBuffersParser", 1, "FlatBuffersParser setEnable : " + a);
    localEditor.putBoolean("isEnabled", a);
    localEditor.commit();
    a();
  }
  
  public static boolean a()
  {
    return (b()) && (c);
  }
  
  public static void b()
  {
    a = BaseApplicationImpl.getApplication().getSharedPreferences("flatbuffers_pref", 4).getBoolean("isEnabled", true);
    QLog.i("FlatBuffersParser", 1, "FlatBuffersParser updateEnable : " + a);
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
    QLog.i("FlatBuffersParser", 1, "FlatBuffersParser setRuntimeDisable : " + b);
    a();
  }
  
  public static boolean b()
  {
    return (!b) && (a);
  }
  
  public static void c()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("flatbuffers_pref", 4).edit();
    localEditor.putLong("lastCrash", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static boolean c()
  {
    boolean bool1 = VideoEnvironment.c();
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        String[] arrayOfString = Build.SUPPORTED_ABIS;
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          String str = arrayOfString[i];
          bool2 = bool1;
          if (!TextUtils.isEmpty(str))
          {
            bool2 = bool1;
            if (str.toLowerCase().contains("x86")) {
              bool2 = true;
            }
          }
          i += 1;
          bool1 = bool2;
        }
      }
    }
    if (!bool2)
    {
      QLog.d("FlatBuffersParser", 1, "os.arch: " + System.getProperty("os.arch"));
      QLog.d("FlatBuffersParser", 1, "DeviceInfoUtil#getCpuType: " + bdcb.g());
      QLog.d("FlatBuffersParser", 1, "Build.CPU_ABI: " + Build.CPU_ABI);
      QLog.d("FlatBuffersParser", 1, "Build.CPU_ABI2: " + Build.CPU_ABI2);
      QLog.d("FlatBuffersParser", 1, "isX86: " + bool2);
      if (Build.VERSION.SDK_INT >= 21) {
        QLog.d("FlatBuffersParser", 1, "Build.SUPPORTED_ABIS: " + Arrays.toString(Build.SUPPORTED_ABIS));
      }
    }
    return bool2;
  }
  
  public static void d()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("flatbuffers_pref", 4).edit();
    localEditor.remove("lastCrash");
    localEditor.commit();
  }
  
  public static void e()
  {
    boolean bool = true;
    String str3;
    Object localObject;
    try
    {
      String str1 = a();
      QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip start, rootPath = " + str1);
      str3 = str1 + "libFlatBuffersParser.zip";
      if (!new File(str3).exists()) {
        break label349;
      }
      localObject = str1 + "unzip" + File.separator;
      QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip real start");
      try
      {
        bdcs.a(str3, (String)localObject, false);
        QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip success");
        localObject = new File((String)localObject + "libFlatBuffersParser.so");
        if (((File)localObject).exists()) {
          break label189;
        }
        QLog.e("FlatBuffersParser", 1, "FlatBuffersParser.unzip failed, unzipFile not exist");
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          QLog.e("FlatBuffersParser", 1, "FlatBuffersParser.unzip failed", localIOException);
        }
      }
      return;
    }
    finally {}
    label189:
    QLog.i("FlatBuffersParser", 1, "zipFileLen " + new File(str3).length() + " unzipFileLen " + ((File)localObject).length());
    File localFile = new File(str2 + "libFlatBuffersParser.so");
    if (localFile.exists())
    {
      bool = localFile.delete();
      QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip already have so file, delete return " + bool);
    }
    if (bool)
    {
      bool = ((File)localObject).renameTo(localFile);
      QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip unzipFile rename to soFile return " + bool);
    }
    for (;;)
    {
      d();
      f();
      break;
      label349:
      QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip failed no zip file found");
    }
  }
  
  public static void f()
  {
    
    if ((b()) && (!c))
    {
      if (!c()) {
        break label35;
      }
      QLog.d("FlatBuffersParser", 1, "is x86 cpu, not support.");
      b(true);
    }
    label35:
    File localFile;
    AppRuntime localAppRuntime;
    boolean bool;
    do
    {
      return;
      localFile = new File(a() + "libFlatBuffersParser.so");
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      bool = localAppRuntime instanceof QQAppInterface;
      if (localFile.exists()) {
        break;
      }
    } while (!bool);
    QLog.i("FlatBuffersParser", 1, "loadLibrary: libFlatBuffersParser.so not exist, try to download.");
    VasQuickUpdateManager.getFileFromLocal(localAppRuntime, 1004L, "libFlatBuffersParser", a() + "libFlatBuffersParser.zip", true, null);
    return;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      a(localFile, bool);
      return;
    }
    ThreadManager.post(new FlatBuffersParser.1(localFile, bool), 5, null, false);
  }
  
  public static void g()
  {
    String str = a();
    boolean bool1 = new File(str + "libFlatBuffersParser.zip").delete();
    boolean bool2 = new File(str + "libFlatBuffersParser.so").delete();
    QLog.i("FlatBuffersParser", 1, "zipDeleted: " + bool1 + " soDeleted: " + bool2);
  }
  
  private native byte[] parseJsonNative(String paramString1, String paramString2);
  
  public ByteBuffer a(String paramString1, String paramString2)
  {
    paramString1 = parseJsonNative(paramString1, paramString2);
    if (paramString1 == null) {
      return null;
    }
    return ByteBuffer.wrap(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.FlatBuffersParser
 * JD-Core Version:    0.7.0.1
 */