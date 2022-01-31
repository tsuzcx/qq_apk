import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class azex
{
  private static azex jdField_a_of_type_Azex;
  private static ConcurrentHashMap<Long, azey> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    bayu.b();
  }
  
  public static azex a()
  {
    if (jdField_a_of_type_Azex == null) {
      jdField_a_of_type_Azex = new azex();
    }
    return jdField_a_of_type_Azex;
  }
  
  public static void a(azew paramazew)
  {
    if (paramazew == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramazew);
    azri.a(BaseApplication.getContext()).a(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, azeu paramazeu)
  {
    paramHashMap.put("param_des_bps", String.valueOf(paramazeu.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(paramazeu.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(paramazeu.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(paramazeu.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(paramazeu.jdField_a_of_type_Int * paramazeu.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, azew paramazew)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramazew.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(paramazew.d));
    paramHashMap.put("param_src_bps", String.valueOf(paramazew.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(paramazew.e));
    paramHashMap.put("param_src_width", String.valueOf(paramazew.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(paramazew.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(paramazew.jdField_a_of_type_Int * paramazew.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, azew paramazew, azeu paramazeu, long paramLong2)
  {
    if ((paramazew == null) || (paramazeu == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramazew);
      a(localHashMap, paramazeu);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramazew.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramazew.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (paramazew.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramazew.d));
      }
      azri.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public azey a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (azey)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    azey localazey = a(paramLong);
    if (localazey != null) {
      localazey.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, azey paramazey)
  {
    if (paramazey != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramazey);
      Utils.executeAsyncTaskOnSerialExcuter(paramazey, new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    ShortVideoTrimmer.a.set(false);
    Object localObject = ShortVideoTrimmer.a();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = (azey)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((azey)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((azey)localObject).isCancelled())) {
      ((azey)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azex
 * JD-Core Version:    0.7.0.1
 */