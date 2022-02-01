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
  public int a;
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public static ARFaceDataCollector a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqArArengineARFaceDataCollector == null) {
        jdField_a_of_type_ComTencentMobileqqArArengineARFaceDataCollector = new ARFaceDataCollector();
      }
      return jdField_a_of_type_ComTencentMobileqqArArengineARFaceDataCollector;
    }
    finally {}
  }
  
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
    localHashMap.put("errorcode_mq", String.valueOf(paramARCloudRecogRspFaceResult.jdField_a_of_type_Int));
    localHashMap.put("errorcode_yt", String.valueOf(paramARCloudRecogRspFaceResult.b));
    int i = paramARCloudRecogRspFaceResult.jdField_a_of_type_Int;
    int j = 0;
    boolean bool;
    if ((i == 0) && (paramARCloudRecogRspFaceResult.b == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramARCloudReqInfo.a.a != null) {
        i = paramARCloudReqInfo.a.a.length;
      } else {
        i = 0;
      }
      if (paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList != null) {
        j = paramARCloudRecogRspFaceResult.jdField_a_of_type_JavaUtilArrayList.size();
      }
      localHashMap.put("send_person_count", String.valueOf(i));
      localHashMap.put("receive_star_count", String.valueOf(j));
    }
    else
    {
      i = 0;
      j = 0;
    }
    long l = System.currentTimeMillis() - paramARCloudReqInfo.c;
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
  
  public static void c()
  {
    ARFaceDataCollector localARFaceDataCollector = a();
    localARFaceDataCollector.b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    localHashMap.put("ppTotalCost", String.valueOf(localARFaceDataCollector.b));
    localHashMap.put("ppFaceDectectCost", String.valueOf(localARFaceDataCollector.c));
    localHashMap.put("upload_cost", String.valueOf(localARFaceDataCollector.d));
    localHashMap.put("ppExtractCost", String.valueOf(localARFaceDataCollector.e));
    localHashMap.put("ppExtractFaceCount", String.valueOf(localARFaceDataCollector.jdField_a_of_type_Int));
    localHashMap.put("firstDrawUICost", String.valueOf(localARFaceDataCollector.f));
    long l3 = localARFaceDataCollector.b;
    long l1 = localARFaceDataCollector.e;
    long l2 = localARFaceDataCollector.d;
    if (l1 <= l2) {
      l1 = l2;
    }
    localHashMap.put("totalCost", String.valueOf(l3 + l1 + localARFaceDataCollector.f));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actFaceStepDuration", true, 0L, 0L, localHashMap, "", true);
    localARFaceDataCollector.a();
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
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
  }
  
  public void b()
  {
    long l3 = this.b;
    long l1 = this.e;
    long l2 = this.d;
    if (l1 <= l2) {
      l1 = l2;
    }
    l2 = this.f;
    long l4 = System.currentTimeMillis();
    long l5 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("printStepDuration preprocessTotalCost  = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",preprocessFaceDetectCost = ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",picUploadCost = ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(",preprocessFeatureExtrctCost = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",preprocessFaceCount = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",firstDrawUICost = ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(",totalCost = ");
      localStringBuilder.append(l3 + l1 + l2);
      localStringBuilder.append(",starTime = ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(",realCost = ");
      localStringBuilder.append(l4 - l5);
      QLog.d("ARFaceDataCollector", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARFaceDataCollector
 * JD-Core Version:    0.7.0.1
 */