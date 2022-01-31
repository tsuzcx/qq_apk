import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class axfi
{
  private static axfi jdField_a_of_type_Axfi;
  private static ConcurrentHashMap<Long, axfj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    aywm.b();
  }
  
  public static axfi a()
  {
    if (jdField_a_of_type_Axfi == null) {
      jdField_a_of_type_Axfi = new axfi();
    }
    return jdField_a_of_type_Axfi;
  }
  
  public static void a(axfh paramaxfh)
  {
    if (paramaxfh == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramaxfh);
    axrn.a(BaseApplication.getContext()).a(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, axff paramaxff)
  {
    paramHashMap.put("param_des_bps", String.valueOf(paramaxff.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(paramaxff.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(paramaxff.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(paramaxff.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(paramaxff.jdField_a_of_type_Int * paramaxff.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, axfh paramaxfh)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramaxfh.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(paramaxfh.d));
    paramHashMap.put("param_src_bps", String.valueOf(paramaxfh.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(paramaxfh.e));
    paramHashMap.put("param_src_width", String.valueOf(paramaxfh.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(paramaxfh.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(paramaxfh.jdField_a_of_type_Int * paramaxfh.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, axfh paramaxfh, axff paramaxff, long paramLong2)
  {
    if ((paramaxfh == null) || (paramaxff == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramaxfh);
      a(localHashMap, paramaxff);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramaxfh.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramaxfh.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (paramaxfh.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramaxfh.d));
      }
      axrn.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public axfj a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (axfj)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    axfj localaxfj = a(paramLong);
    if (localaxfj != null) {
      localaxfj.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, axfj paramaxfj)
  {
    if (paramaxfj != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramaxfj);
      Utils.executeAsyncTaskOnSerialExcuter(paramaxfj, new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    ShortVideoTrimmer.a.set(false);
    Object localObject = ShortVideoTrimmer.a();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = (axfj)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((axfj)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((axfj)localObject).isCancelled())) {
      ((axfj)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axfi
 * JD-Core Version:    0.7.0.1
 */