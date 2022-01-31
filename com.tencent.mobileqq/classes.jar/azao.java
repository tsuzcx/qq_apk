import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class azao
{
  private static azao jdField_a_of_type_Azao;
  private static ConcurrentHashMap<Long, azap> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    baul.b();
  }
  
  public static azao a()
  {
    if (jdField_a_of_type_Azao == null) {
      jdField_a_of_type_Azao = new azao();
    }
    return jdField_a_of_type_Azao;
  }
  
  public static void a(azan paramazan)
  {
    if (paramazan == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramazan);
    azmz.a(BaseApplication.getContext()).a(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, azal paramazal)
  {
    paramHashMap.put("param_des_bps", String.valueOf(paramazal.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(paramazal.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(paramazal.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(paramazal.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(paramazal.jdField_a_of_type_Int * paramazal.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, azan paramazan)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramazan.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(paramazan.d));
    paramHashMap.put("param_src_bps", String.valueOf(paramazan.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(paramazan.e));
    paramHashMap.put("param_src_width", String.valueOf(paramazan.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(paramazan.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(paramazan.jdField_a_of_type_Int * paramazan.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, azan paramazan, azal paramazal, long paramLong2)
  {
    if ((paramazan == null) || (paramazal == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramazan);
      a(localHashMap, paramazal);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramazan.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramazan.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (paramazan.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramazan.d));
      }
      azmz.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public azap a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      return (azap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    azap localazap = a(paramLong);
    if (localazap != null) {
      localazap.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, azap paramazap)
  {
    if (paramazap != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramazap);
      Utils.executeAsyncTaskOnSerialExcuter(paramazap, new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    ShortVideoTrimmer.a.set(false);
    Object localObject = ShortVideoTrimmer.a();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = (azap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if ((localObject != null) && (((azap)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((azap)localObject).isCancelled())) {
      ((azap)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azao
 * JD-Core Version:    0.7.0.1
 */