import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class awfy
{
  private static awfy jdField_a_of_type_Awfy;
  private static ConcurrentHashMap<Long, awfz> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    axwd.b();
  }
  
  public static awfy a()
  {
    if (jdField_a_of_type_Awfy == null) {
      jdField_a_of_type_Awfy = new awfy();
    }
    return jdField_a_of_type_Awfy;
  }
  
  public static void a(awfx paramawfx)
  {
    if (paramawfx == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramawfx);
    awrn.a(BaseApplication.getContext()).a(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, awfv paramawfv)
  {
    paramHashMap.put("param_des_bps", String.valueOf(paramawfv.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(paramawfv.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(paramawfv.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(paramawfv.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(paramawfv.jdField_a_of_type_Int * paramawfv.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, awfx paramawfx)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramawfx.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(paramawfx.d));
    paramHashMap.put("param_src_bps", String.valueOf(paramawfx.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(paramawfx.e));
    paramHashMap.put("param_src_width", String.valueOf(paramawfx.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(paramawfx.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(paramawfx.jdField_a_of_type_Int * paramawfx.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, awfx paramawfx, awfv paramawfv, long paramLong2)
  {
    if ((paramawfx == null) || (paramawfv == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramawfx);
      a(localHashMap, paramawfv);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramawfx.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramawfx.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (paramawfx.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramawfx.d));
      }
      awrn.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public awfz a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (awfz)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    awfz localawfz = a(paramLong);
    if (localawfz != null) {
      localawfz.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, awfz paramawfz)
  {
    if (paramawfz != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramawfz);
      Utils.executeAsyncTaskOnSerialExcuter(paramawfz, new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    ShortVideoTrimmer.a.set(false);
    Object localObject = ShortVideoTrimmer.a();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = (awfz)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((awfz)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((awfz)localObject).isCancelled())) {
      ((awfz)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awfy
 * JD-Core Version:    0.7.0.1
 */