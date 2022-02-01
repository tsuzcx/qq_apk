package com.tencent.common.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinEngineLog;
import com.tencent.theme.SkinEngineHandler;
import java.util.HashMap;

public class OOMHandler
  implements ISkinEngineLog, SkinEngineHandler
{
  private int jdField_a_of_type_Int = -1;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  
  public OOMHandler(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public boolean onDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((ActivityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    paramOutOfMemoryError = new StringBuffer("decode resources oom, fileName: ");
    paramOutOfMemoryError.append(paramString);
    paramOutOfMemoryError.append(", is skin file: ");
    paramOutOfMemoryError.append(paramBoolean);
    paramOutOfMemoryError.append(", memory used:");
    paramOutOfMemoryError.append(l);
    paramOutOfMemoryError.append(" , heap size: ");
    paramOutOfMemoryError.append(this.jdField_a_of_type_Int);
    paramOutOfMemoryError.append(", api level:");
    paramOutOfMemoryError.append(Build.VERSION.SDK_INT);
    if (GlobalImageCache.a != null)
    {
      paramOutOfMemoryError.append(", imageCache size:");
      paramOutOfMemoryError.append(GlobalImageCache.a.size());
    }
    QLog.e("res-OOM", 1, paramOutOfMemoryError.toString());
    paramOutOfMemoryError = new HashMap(4);
    paramOutOfMemoryError.put("param_FailCode", Integer.toString(89100));
    paramOutOfMemoryError.put("param_heapSize", Integer.toString(this.jdField_a_of_type_Int));
    paramOutOfMemoryError.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramOutOfMemoryError.put("param_cacheUsed", Long.toString(l));
    try
    {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, paramOutOfMemoryError, "");
      if (GlobalImageCache.a != null) {
        GlobalImageCache.a.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramOutOfMemoryError)
    {
      for (;;)
      {
        paramOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public boolean onDecodeReturnNullBitmap(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((ActivityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    StringBuffer localStringBuffer = new StringBuffer("decode resources return null, fileName: ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(", is skin file: ");
    localStringBuffer.append(paramBoolean);
    localStringBuffer.append(", memory used:");
    localStringBuffer.append(l);
    localStringBuffer.append(" , heap size: ");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", api level:");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    if (GlobalImageCache.a != null)
    {
      localStringBuffer.append(", imageCache size:");
      localStringBuffer.append(GlobalImageCache.a.size());
    }
    paramString = new HashMap(4);
    paramString.put("param_FailCode", Integer.toString(89102));
    paramString.put("param_heapSize", Integer.toString(this.jdField_a_of_type_Int));
    paramString.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramString.put("param_cacheUsed", Long.toString(l));
    try
    {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, paramString, "");
      QLog.e("res-OOM", 1, localStringBuffer.toString());
      if (GlobalImageCache.a != null) {
        GlobalImageCache.a.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean onSecondDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((ActivityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    StringBuffer localStringBuffer = new StringBuffer("decode resources second oom, fileName: ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(", is skin file: ");
    localStringBuffer.append(paramBoolean);
    localStringBuffer.append(", memory used:");
    localStringBuffer.append(l);
    localStringBuffer.append(" , heap size: ");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", api level:");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    if (GlobalImageCache.a != null)
    {
      localStringBuffer.append(", imageCache size:");
      localStringBuffer.append(GlobalImageCache.a.size());
    }
    paramString = new HashMap(4);
    paramString.put("param_FailCode", Integer.toString(89101));
    paramString.put("param_heapSize", Integer.toString(this.jdField_a_of_type_Int));
    paramString.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramString.put("param_cacheUsed", Long.toString(l));
    try
    {
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, paramString, "");
      QLog.e("res-OOM", 1, localStringBuffer.toString(), paramOutOfMemoryError);
      if (GlobalImageCache.a != null) {
        GlobalImageCache.a.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void trace(int paramInt1, String paramString1, int paramInt2, String paramString2, Throwable paramThrowable)
  {
    if ((1 == paramInt2) || (QLog.isColorLevel())) {}
    switch (paramInt1)
    {
    case 4: 
    default: 
      QLog.i(paramString1, paramInt2, paramString2, paramThrowable);
      return;
    case 5: 
      QLog.w(paramString1, paramInt2, paramString2, paramThrowable);
      return;
    case 6: 
      QLog.e(paramString1, paramInt2, paramString2, paramThrowable);
      return;
    }
    QLog.d(paramString1, paramInt2, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.OOMHandler
 * JD-Core Version:    0.7.0.1
 */