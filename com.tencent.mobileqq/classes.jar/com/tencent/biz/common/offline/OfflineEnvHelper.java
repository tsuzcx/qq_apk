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
  private static String jdField_a_of_type_JavaLangString;
  private static final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private static String jdField_b_of_type_JavaLangString;
  private static final ReentrantLock jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private static String c;
  private static String d;
  
  public static String a()
  {
    if (TextUtils.isEmpty(c))
    {
      SLog.d("OfflineEnvHelper", "getInnerOfflineDir, initEnv");
      a();
    }
    return c;
  }
  
  public static String a(String paramString)
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
  
  private static void a()
  {
    int k = 1;
    String str = PreDownloadScheduleUtil.getPreDownloadPathStatic("offline", "app", true);
    Object localObject1;
    Object localObject2;
    boolean bool;
    long l;
    Object localObject7;
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
          bool = jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock();
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
                  if (!HtmlOffline.a.a()) {
                    break label1018;
                  }
                  HtmlOffline.a.a("HtmlCheckUpdate", 2, "sd move error");
                  break label1018;
                }
              }
              else
              {
                if (!HtmlOffline.a.a()) {
                  break label1018;
                }
                HtmlOffline.a.a("HtmlCheckUpdate", 2, "sd no old data");
                break label1018;
              }
              localObject3 = HtmlOffline.a;
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("sd move old data, cost=");
              ((StringBuilder)localObject7).append(System.currentTimeMillis() - l);
              ((StringBuilder)localObject7).append(", move=");
              ((StringBuilder)localObject7).append(bool);
              ((ILog)localObject3).a("HtmlCheckUpdate", 1, ((StringBuilder)localObject7).toString());
            }
            finally
            {
              jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
            }
          } else {
            HtmlOffline.a.a("HtmlCheckUpdate", 1, "sd move lock failed");
          }
        }
      }
      catch (Exception localException1)
      {
        if (HtmlOffline.a.a())
        {
          localObject7 = HtmlOffline.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sd move error: ");
          localStringBuilder.append(localException1.toString());
          ((ILog)localObject7).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
        }
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
        if (HtmlOffline.a.a()) {
          HtmlOffline.a.a("HtmlCheckUpdate", 2, "no sd");
        }
      }
      else
      {
        jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath((String)localObject1);
        jdField_b_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(str);
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
          bool = jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock();
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
                  if (!HtmlOffline.a.a()) {
                    break label1023;
                  }
                  HtmlOffline.a.a("HtmlCheckUpdate", 2, "data move error");
                  break label1023;
                }
              }
              else
              {
                if (!HtmlOffline.a.a()) {
                  break label1023;
                }
                HtmlOffline.a.a("HtmlCheckUpdate", 2, "data no old data");
                break label1023;
              }
              localObject5 = HtmlOffline.a;
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("data move old data, cost=");
              ((StringBuilder)localObject7).append(System.currentTimeMillis() - l);
              ((StringBuilder)localObject7).append(", move=");
              ((StringBuilder)localObject7).append(bool);
              ((ILog)localObject5).a("HtmlCheckUpdate", 1, ((StringBuilder)localObject7).toString());
            }
            finally
            {
              jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
            }
          } else {
            HtmlOffline.a.a("HtmlCheckUpdate", 1, "data move lock failed");
          }
        }
      }
      catch (Exception localException2)
      {
        if (HtmlOffline.a.a())
        {
          localObject7 = HtmlOffline.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("data move error: ");
          localStringBuilder.append(localException2.toString());
          ((ILog)localObject7).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
        }
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
        if (HtmlOffline.a.a()) {
          HtmlOffline.a.a("HtmlCheckUpdate", 2, "no data dir");
        }
      }
      else
      {
        c = (String)localObject1;
        d = str;
      }
      return;
      label1018:
      bool = false;
      break;
      label1023:
      bool = false;
    }
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
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "initEnv NumberFormatException");
    }
    return true;
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      SLog.d("OfflineEnvHelper", "getSDOfflineDir, initEnv");
      a();
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (a(paramString)) {
      return d();
    }
    return c();
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(d)) {
      a();
    }
    return d;
  }
  
  public static String d()
  {
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
      a();
    }
    return jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineEnvHelper
 * JD-Core Version:    0.7.0.1
 */