import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class anbz
{
  static anbz a;
  public int a;
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  
  public static anbz a()
  {
    try
    {
      if (jdField_a_of_type_Anbz == null) {
        jdField_a_of_type_Anbz = new anbz();
      }
      return jdField_a_of_type_Anbz;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARFaceInit,initCost  = " + paramLong + ",devType = " + ARMapTracer.a());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    azri.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceInit", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARTrackStablity,duration  = " + paramLong + ",count = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    localHashMap.put("recoverCount", String.valueOf(paramInt));
    azri.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceTrackStability", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void a(anbr paramanbr, anbo paramanbo)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorcode_mq", String.valueOf(paramanbo.jdField_a_of_type_Int));
    localHashMap.put("errorcode_yt", String.valueOf(paramanbo.b));
    if ((paramanbo.jdField_a_of_type_Int == 0) && (paramanbo.b == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      int i = 0;
      int m = 0;
      int j = 0;
      int k = 0;
      if (bool)
      {
        i = m;
        if (paramanbr.a.a != null) {
          i = paramanbr.a.a.length;
        }
        j = k;
        if (paramanbo.jdField_a_of_type_JavaUtilArrayList != null) {
          j = paramanbo.jdField_a_of_type_JavaUtilArrayList.size();
        }
        localHashMap.put("send_person_count", String.valueOf(i));
        localHashMap.put("receive_star_count", String.valueOf(j));
      }
      long l = System.currentTimeMillis() - paramanbr.c;
      localHashMap.put("upload_cost", String.valueOf(l));
      azri.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceCloudResult", bool, 0L, 0L, localHashMap, "", true);
      if (QLog.isColorLevel()) {
        QLog.d("ARFaceDataCollector", 2, "reportARFaceCloudResult,sendPersonCount  = " + i + ",starCount = " + j + ",uploadCost = " + l);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARSoLoadResult,libName  = " + paramString + ",result = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("libName", paramString);
    localHashMap.put("loadResult", String.valueOf(paramInt));
    azri.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceSoLoadResult", true, 0L, 0L, localHashMap, "", true);
  }
  
  public static void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARFaceDetect,cost  = " + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    azri.a(BaseApplicationImpl.getApplication()).a(null, "actARFaceDetect", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void c()
  {
    anbz localanbz = a();
    localanbz.b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    localHashMap.put("ppTotalCost", String.valueOf(localanbz.b));
    localHashMap.put("ppFaceDectectCost", String.valueOf(localanbz.c));
    localHashMap.put("upload_cost", String.valueOf(localanbz.d));
    localHashMap.put("ppExtractCost", String.valueOf(localanbz.e));
    localHashMap.put("ppExtractFaceCount", String.valueOf(localanbz.jdField_a_of_type_Int));
    localHashMap.put("firstDrawUICost", String.valueOf(localanbz.f));
    long l2 = localanbz.b;
    if (localanbz.e > localanbz.d) {}
    for (long l1 = localanbz.e;; l1 = localanbz.d)
    {
      localHashMap.put("totalCost", String.valueOf(l1 + l2 + localanbz.f));
      azri.a(BaseApplicationImpl.getApplication()).a(null, "actFaceStepDuration", true, 0L, 0L, localHashMap, "", true);
      localanbz.a();
      return;
    }
  }
  
  public static void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARExtracFaceFeatrue,cost  = " + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.a()));
    azri.a(BaseApplicationImpl.getApplication()).a(null, "actARExtractFaceFeatrue", true, paramLong, 0L, localHashMap, "", true);
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
    long l2 = this.b;
    if (this.e > this.d) {}
    for (long l1 = this.e;; l1 = this.d)
    {
      long l3 = this.f;
      long l4 = System.currentTimeMillis();
      long l5 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("ARFaceDataCollector", 2, "printStepDuration preprocessTotalCost  = " + this.b + ",preprocessFaceDetectCost = " + this.c + ",picUploadCost = " + this.d + ",preprocessFeatureExtrctCost = " + this.e + ",preprocessFaceCount = " + this.jdField_a_of_type_Int + ",firstDrawUICost = " + this.f + ",totalCost = " + (l1 + l2 + l3) + ",starTime = " + this.jdField_a_of_type_Long + ",realCost = " + (l4 - l5));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbz
 * JD-Core Version:    0.7.0.1
 */