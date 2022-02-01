package com.tencent.mobileqq.ar.arengine;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class ARFaceDataCollector
{
  static ARFaceDataCollector a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public int g;
  public long h;
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportARFaceInit,initCost  = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",devType = ");
      ((StringBuilder)localObject).append(ARMapTracer.a());
      QLog.d("ARFaceDataCollector", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("device_type", String.valueOf(ARMapTracer.a()));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceInit", true, paramLong, 0L, (HashMap)localObject, "", true);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportARTrackStablity,duration  = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",count = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ARFaceDataCollector", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("device_type", String.valueOf(ARMapTracer.a()));
    ((HashMap)localObject).put("recoverCount", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceTrackStability", true, paramLong, 0L, (HashMap)localObject, "", true);
  }
  
  public static void a(ARCloudReqInfo paramARCloudReqInfo, ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorcode_mq", String.valueOf(paramARCloudRecogRspFaceResult.a));
    localHashMap.put("errorcode_yt", String.valueOf(paramARCloudRecogRspFaceResult.c));
    int i = paramARCloudRecogRspFaceResult.a;
    int j = 0;
    boolean bool;
    if ((i == 0) && (paramARCloudRecogRspFaceResult.c == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramARCloudReqInfo.i.b != null) {
        i = paramARCloudReqInfo.i.b.length;
      } else {
        i = 0;
      }
      if (paramARCloudRecogRspFaceResult.h != null) {
        j = paramARCloudRecogRspFaceResult.h.size();
      }
      localHashMap.put("send_person_count", String.valueOf(i));
      localHashMap.put("receive_star_count", String.valueOf(j));
    }
    else
    {
      i = 0;
      j = 0;
    }
    long l = System.currentTimeMillis() - paramARCloudReqInfo.q;
    localHashMap.put("upload_cost", String.valueOf(l));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceCloudResult", bool, 0L, 0L, localHashMap, "", true);
    if (QLog.isColorLevel())
    {
      paramARCloudReqInfo = new StringBuilder();
      paramARCloudReqInfo.append("reportARFaceCloudResult,sendPersonCount  = ");
      paramARCloudReqInfo.append(i);
      paramARCloudReqInfo.append(",starCount = ");
      paramARCloudReqInfo.append(j);
      paramARCloudReqInfo.append(",uploadCost = ");
      paramARCloudReqInfo.append(l);
      QLog.d("ARFaceDataCollector", 2, paramARCloudReqInfo.toString());
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportARSoLoadResult,libName  = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",result = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ARFaceDataCollector", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("libName", paramString);
    ((HashMap)localObject).put("loadResult", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceSoLoadResult", true, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  public static ARFaceDataCollector b()
  {
    try
    {
      if (a == null) {
        a = new ARFaceDataCollector();
      }
      return a;
    }
    finally {}
  }
  
  public static void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportARFaceDetect,cost  = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("ARFaceDataCollector", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("device_type", String.valueOf(ARMapTracer.a()));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceDetect", true, paramLong, 0L, (HashMap)localObject, "", true);
  }
  
  public static void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportARExtracFaceFeatrue,cost  = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("ARFaceDataCollector", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("device_type", String.valueOf(ARMapTracer.a()));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARExtractFaceFeatrue", true, paramLong, 0L, (HashMap)localObject, "", true);
  }
  
  public static void d()
  {
    ARFaceDataCollector localARFaceDataCollector = b();
    localARFaceDataCollector.c();
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    localHashMap.put("ppTotalCost", String.valueOf(localARFaceDataCollector.c));
    localHashMap.put("ppFaceDectectCost", String.valueOf(localARFaceDataCollector.d));
    localHashMap.put("upload_cost", String.valueOf(localARFaceDataCollector.e));
    localHashMap.put("ppExtractCost", String.valueOf(localARFaceDataCollector.f));
    localHashMap.put("ppExtractFaceCount", String.valueOf(localARFaceDataCollector.g));
    localHashMap.put("firstDrawUICost", String.valueOf(localARFaceDataCollector.h));
    long l3 = localARFaceDataCollector.c;
    long l1 = localARFaceDataCollector.f;
    long l2 = localARFaceDataCollector.e;
    if (l1 <= l2) {
      l1 = l2;
    }
    localHashMap.put("totalCost", String.valueOf(l3 + l1 + localARFaceDataCollector.h));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actFaceStepDuration", true, 0L, 0L, localHashMap, "", true);
    localARFaceDataCollector.a();
  }
  
  public void a()
  {
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.h = 0L;
  }
  
  public void c()
  {
    long l3 = this.c;
    long l1 = this.f;
    long l2 = this.e;
    if (l1 <= l2) {
      l1 = l2;
    }
    l2 = this.h;
    long l4 = System.currentTimeMillis();
    long l5 = this.b;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("printStepDuration preprocessTotalCost  = ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",preprocessFaceDetectCost = ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",picUploadCost = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",preprocessFeatureExtrctCost = ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(",preprocessFaceCount = ");
      localStringBuilder.append(this.g);
      localStringBuilder.append(",firstDrawUICost = ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(",totalCost = ");
      localStringBuilder.append(l3 + l1 + l2);
      localStringBuilder.append(",starTime = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",realCost = ");
      localStringBuilder.append(l4 - l5);
      QLog.d("ARFaceDataCollector", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARFaceDataCollector
 * JD-Core Version:    0.7.0.1
 */