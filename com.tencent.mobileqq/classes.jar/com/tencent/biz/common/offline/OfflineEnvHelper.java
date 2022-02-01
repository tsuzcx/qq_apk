package com.tencent.biz.common.offline;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

public class OfflineEnvHelper
{
  private static String a;
  private static String b;
  private static String c;
  private static String d;
  private static final ReentrantLock e = new ReentrantLock();
  private static final ReentrantLock f = new ReentrantLock();
  
  public static String a()
  {
    if (TextUtils.isEmpty(c))
    {
      SLog.d("OfflineEnvHelper", "getInnerOfflineDir, initEnv");
      e();
    }
    return c;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      if (i >= 1000)
      {
        if (i >= 2000) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    catch (NumberFormatException paramString)
    {
      label41:
      break label41;
    }
    if (HtmlOffline.f.a()) {
      HtmlOffline.f.a("HtmlCheckUpdate", 2, "initEnv NumberFormatException");
    }
    return true;
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(a))
    {
      SLog.d("OfflineEnvHelper", "getSDOfflineDir, initEnv");
      e();
    }
    return a;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (a(paramString))
    {
      SLog.d("OfflineEnvHelper", "getOfflineDir, isStoreInSD true");
      return b();
    }
    return a();
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(d)) {
      e();
    }
    return d;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (a(paramString)) {
      return d();
    }
    return c();
  }
  
  public static String d()
  {
    if (TextUtils.isEmpty(b)) {
      e();
    }
    return b;
  }
  
  private static void d(String paramString)
  {
    if (HtmlOffline.f.a()) {
      HtmlOffline.f.a("HtmlCheckUpdate", 2, paramString);
    }
  }
  
  private static void e()
  {
    int k = 1;
    String str = PreDownloadScheduleUtil.getPreDownloadPathStatic("offline", "app", true);
    Object localObject1;
    Object localObject2;
    boolean bool;
    long l;
    StringBuilder localStringBuilder;
    int i;
    int j;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("/html5/");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("/tmp/");
      str = ((StringBuilder)localObject2).toString();
      localObject2 = new File((String)localObject1);
      try
      {
        if (!((File)localObject2).exists())
        {
          bool = e.tryLock();
          if (bool) {
            try
            {
              l = System.currentTimeMillis();
              Object localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(Environment.getExternalStorageDirectory().getAbsolutePath());
              ((StringBuilder)localObject3).append("/tencent/MobileQQ/qbiz/html5/");
              localObject3 = new File(((StringBuilder)localObject3).toString());
              if (((File)localObject3).exists())
              {
                ((File)localObject2).mkdirs();
                if (((File)localObject3).renameTo((File)localObject2))
                {
                  bool = true;
                }
                else
                {
                  d("sd move error");
                  break label858;
                }
              }
              else
              {
                d("sd no old data");
                break label858;
              }
              localObject3 = HtmlOffline.f;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("sd move old data, cost=");
              localStringBuilder.append(System.currentTimeMillis() - l);
              localStringBuilder.append(", move=");
              localStringBuilder.append(bool);
              ((ILog)localObject3).a("HtmlCheckUpdate", 1, localStringBuilder.toString());
            }
            finally
            {
              e.unlock();
            }
          } else {
            HtmlOffline.f.a("HtmlCheckUpdate", 1, "sd move lock failed");
          }
        }
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sd move error: ");
        localStringBuilder.append(localException1.toString());
        d(localStringBuilder.toString());
      }
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
        i = 1;
      } else {
        i = 0;
      }
      localObject2 = new File(str);
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i | j) != 0)
      {
        d("no sd");
      }
      else
      {
        a = VFSAssistantUtils.getSDKPrivatePath((String)localObject1);
        b = VFSAssistantUtils.getSDKPrivatePath(str);
      }
    }
    str = PreDownloadScheduleUtil.getPreDownloadPathStatic("offline", "app", false);
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("/html5/");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("/tmp/");
      str = ((StringBuilder)localObject2).toString();
      localObject2 = new File((String)localObject1);
    }
    for (;;)
    {
      try
      {
        if (!((File)localObject2).exists())
        {
          bool = f.tryLock();
          if (bool) {
            try
            {
              l = System.currentTimeMillis();
              Object localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
              ((StringBuilder)localObject5).append("/qbiz/html5/");
              localObject5 = new File(((StringBuilder)localObject5).toString());
              if (((File)localObject5).exists())
              {
                ((File)localObject2).mkdirs();
                if (((File)localObject5).renameTo((File)localObject2))
                {
                  bool = true;
                }
                else
                {
                  d("data move error");
                  break label863;
                }
              }
              else
              {
                d("data no old data");
                break label863;
              }
              localObject5 = HtmlOffline.f;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("data move old data, cost=");
              localStringBuilder.append(System.currentTimeMillis() - l);
              localStringBuilder.append(", move=");
              localStringBuilder.append(bool);
              ((ILog)localObject5).a("HtmlCheckUpdate", 1, localStringBuilder.toString());
            }
            finally
            {
              f.unlock();
            }
          } else {
            HtmlOffline.f.a("HtmlCheckUpdate", 1, "data move lock failed");
          }
        }
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("data move error: ");
        localStringBuilder.append(localException2.toString());
        d(localStringBuilder.toString());
      }
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
        i = 1;
      } else {
        i = 0;
      }
      localObject2 = new File(str);
      if ((!((File)localObject2).exists()) && (!((File)localObject2).mkdirs())) {
        j = k;
      } else {
        j = 0;
      }
      if ((i | j) != 0)
      {
        d("no data dir");
        return;
      }
      c = (String)localObject1;
      d = str;
      return;
      label858:
      bool = false;
      break;
      label863:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineEnvHelper
 * JD-Core Version:    0.7.0.1
 */