package com.tencent.biz.flatbuffers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FlatBuffersParser
{
  public static volatile boolean a = true;
  public static volatile boolean b = false;
  public static volatile boolean c;
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = IOUtil.getCRC32Value(paramFile);
      long l3 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("so file size: ");
      localStringBuilder.append(paramFile.length());
      localStringBuilder.append(" crc32: ");
      localStringBuilder.append(Long.toHexString(l2));
      localStringBuilder.append(" crcSpent: ");
      localStringBuilder.append(l3 - l1);
      QLog.i("FlatBuffersParser", 1, localStringBuilder.toString());
      l2 = g();
      if (l1 - l2 < 86400000L)
      {
        paramFile = new StringBuilder();
        paramFile.append("FlatBuffers loadLibrary have lastCrash ");
        paramFile.append(l2);
        QLog.i("FlatBuffersParser", 1, paramFile.toString());
        return;
      }
      if (l2 != 0L)
      {
        paramFile = new StringBuilder();
        paramFile.append("FlatBuffers lastCrash ");
        paramFile.append(l2);
        paramFile.append(" is out of date, try deleteFlatbuffers.");
        QLog.i("FlatBuffersParser", 1, paramFile.toString());
        f();
        k();
        j();
        return;
      }
      boolean bool = paramFile.exists();
      if (!bool) {
        return;
      }
      if (paramBoolean) {
        e();
      }
      try
      {
        QLog.i("FlatBuffersParser", 1, "FlatBuffers loadLibrary startLoad stl");
        QLog.flushLog();
        if (SoLoadUtil.a(MobileQQ.getContext(), "stlport_shared", 0, false))
        {
          QLog.i("FlatBuffersParser", 1, "FlatBuffers loadLibrary startLoad FlatBuffers");
          System.load(paramFile.getAbsolutePath());
          if ((paramBoolean) && (new FlatBuffersParser().a("{x:1,y:2}", "table Pos {\n\tx:float;\n\ty:float;\n}\nroot_type Pos;") == null))
          {
            QLog.e("FlatBuffersParser", 1, "FlatBuffers test parser failed.");
            return;
          }
          QLog.i("FlatBuffersParser", 1, "FlatBuffers loadLibrary success");
          c = true;
        }
        else
        {
          QLog.i("FlatBuffersParser", 1, "FlatBuffers load stl failed");
          c = false;
        }
        if (paramBoolean) {
          f();
        }
      }
      catch (Throwable paramFile)
      {
        QLog.e("FlatBuffersParser", 1, "", paramFile);
      }
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("flatbuffers_pref", 4).edit();
    a = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlatBuffersParser setEnable : ");
    localStringBuilder.append(a);
    QLog.i("FlatBuffersParser", 1, localStringBuilder.toString());
    localEditor.putBoolean("isEnabled", a);
    localEditor.commit();
    b();
  }
  
  public static boolean a()
  {
    return (d()) && (c);
  }
  
  public static void b()
  {
    if (!d()) {
      AuthorizeConfig.a(false).d();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlatBuffersParser setRuntimeDisable : ");
    localStringBuilder.append(b);
    QLog.i("FlatBuffersParser", 1, localStringBuilder.toString());
    b();
  }
  
  public static void c()
  {
    a = MobileQQ.getContext().getSharedPreferences("flatbuffers_pref", 4).getBoolean("isEnabled", true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FlatBuffersParser updateEnable : ");
    localStringBuilder.append(a);
    QLog.i("FlatBuffersParser", 1, localStringBuilder.toString());
  }
  
  public static boolean d()
  {
    return (!b) && (a);
  }
  
  public static void e()
  {
    SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("flatbuffers_pref", 4).edit();
    localEditor.putLong("lastCrash", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void f()
  {
    SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("flatbuffers_pref", 4).edit();
    localEditor.remove("lastCrash");
    localEditor.commit();
  }
  
  public static long g()
  {
    return MobileQQ.getContext().getSharedPreferences("flatbuffers_pref", 4).getLong("lastCrash", 0L);
  }
  
  public static String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("FlatBuffers");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static void i()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = h();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("FlatBuffersParser.unzip start, rootPath = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("FlatBuffersParser", 1, ((StringBuilder)localObject3).toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("libFlatBuffersParser.zip");
        localObject3 = ((StringBuilder)localObject3).toString();
        if (new File((String)localObject3).exists())
        {
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append("unzip");
          ((StringBuilder)localObject4).append(File.separator);
          localObject4 = ((StringBuilder)localObject4).toString();
          QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip real start");
          try
          {
            FileUtils.uncompressZip((String)localObject3, (String)localObject4, false);
            QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip success");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject4);
            localStringBuilder.append("libFlatBuffersParser.so");
            localObject4 = new File(localStringBuilder.toString());
            if (!((File)localObject4).exists())
            {
              QLog.e("FlatBuffersParser", 1, "FlatBuffersParser.unzip failed, unzipFile not exist");
              return;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("zipFileLen ");
            localStringBuilder.append(new File((String)localObject3).length());
            localStringBuilder.append(" unzipFileLen ");
            localStringBuilder.append(((File)localObject4).length());
            QLog.i("FlatBuffersParser", 1, localStringBuilder.toString());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append("libFlatBuffersParser.so");
            localObject1 = new File(((StringBuilder)localObject3).toString());
            if (!((File)localObject1).exists()) {
              break label419;
            }
            bool = ((File)localObject1).delete();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("FlatBuffersParser.unzip already have so file, delete return ");
            ((StringBuilder)localObject3).append(bool);
            QLog.i("FlatBuffersParser", 1, ((StringBuilder)localObject3).toString());
            if (!bool) {
              continue;
            }
            bool = ((File)localObject4).renameTo((File)localObject1);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("FlatBuffersParser.unzip unzipFile rename to soFile return ");
            ((StringBuilder)localObject1).append(bool);
            QLog.i("FlatBuffersParser", 1, ((StringBuilder)localObject1).toString());
          }
          catch (IOException localIOException)
          {
            QLog.e("FlatBuffersParser", 1, "FlatBuffersParser.unzip failed", localIOException);
            return;
          }
        }
        else
        {
          QLog.i("FlatBuffersParser", 1, "FlatBuffersParser.unzip failed no zip file found");
        }
        f();
        j();
        return;
      }
      finally {}
      label419:
      boolean bool = true;
    }
  }
  
  public static void j()
  {
    
    if ((d()) && (!c))
    {
      if (DeviceInfoUtil.N())
      {
        QLog.d("FlatBuffersParser", 1, "is x86 cpu, not support.");
        b(true);
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(h());
      ((StringBuilder)localObject1).append("libFlatBuffersParser.so");
      Object localObject2 = new File(((StringBuilder)localObject1).toString());
      localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (!((File)localObject2).exists())
      {
        QLog.i("FlatBuffersParser", 1, "loadLibrary: libFlatBuffersParser.so not exist, try to download.");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(h());
        ((StringBuilder)localObject2).append("libFlatBuffersParser.zip");
        VasUpdateUtil.a((AppRuntime)localObject1, 1004L, "libFlatBuffersParser", ((StringBuilder)localObject2).toString(), true, null);
        return;
      }
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        a((File)localObject2, true);
        return;
      }
      ThreadManager.post(new FlatBuffersParser.1((File)localObject2), 5, null, false);
    }
  }
  
  public static void k()
  {
    Object localObject = h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("libFlatBuffersParser.zip");
    boolean bool1 = new File(localStringBuilder.toString()).delete();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("libFlatBuffersParser.so");
    boolean bool2 = new File(localStringBuilder.toString()).delete();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("zipDeleted: ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" soDeleted: ");
    ((StringBuilder)localObject).append(bool2);
    QLog.i("FlatBuffersParser", 1, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.FlatBuffersParser
 * JD-Core Version:    0.7.0.1
 */