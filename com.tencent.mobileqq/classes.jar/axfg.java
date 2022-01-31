import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class axfg
{
  private static axfg jdField_a_of_type_Axfg;
  private static ConcurrentHashMap<Long, axfh> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    aywk.b();
  }
  
  public static axfg a()
  {
    if (jdField_a_of_type_Axfg == null) {
      jdField_a_of_type_Axfg = new axfg();
    }
    return jdField_a_of_type_Axfg;
  }
  
  public static void a(axff paramaxff)
  {
    if (paramaxff == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramaxff);
    axrl.a(BaseApplication.getContext()).a(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, axfd paramaxfd)
  {
    paramHashMap.put("param_des_bps", String.valueOf(paramaxfd.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(paramaxfd.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(paramaxfd.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(paramaxfd.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(paramaxfd.jdField_a_of_type_Int * paramaxfd.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, axff paramaxff)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramaxff.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(paramaxff.d));
    paramHashMap.put("param_src_bps", String.valueOf(paramaxff.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(paramaxff.e));
    paramHashMap.put("param_src_width", String.valueOf(paramaxff.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(paramaxff.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(paramaxff.jdField_a_of_type_Int * paramaxff.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, axff paramaxff, axfd paramaxfd, long paramLong2)
  {
    if ((paramaxff == null) || (paramaxfd == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramaxff);
      a(localHashMap, paramaxfd);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramaxff.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramaxff.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (paramaxff.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramaxff.d));
      }
      axrl.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public axfh a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (axfh)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    axfh localaxfh = a(paramLong);
    if (localaxfh != null) {
      localaxfh.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, axfh paramaxfh)
  {
    if (paramaxfh != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramaxfh);
      Utils.executeAsyncTaskOnSerialExcuter(paramaxfh, new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    ShortVideoTrimmer.a.set(false);
    Object localObject = ShortVideoTrimmer.a();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = (axfh)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((axfh)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((axfh)localObject).isCancelled())) {
      ((axfh)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axfg
 * JD-Core Version:    0.7.0.1
 */