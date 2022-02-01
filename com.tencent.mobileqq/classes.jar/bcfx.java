import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class bcfx
{
  private static bcfx jdField_a_of_type_Bcfx;
  private static ConcurrentHashMap<Long, WeakReference<bcfy>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    bdzx.b();
  }
  
  public static bcfx a()
  {
    if (jdField_a_of_type_Bcfx == null) {
      jdField_a_of_type_Bcfx = new bcfx();
    }
    return jdField_a_of_type_Bcfx;
  }
  
  public static void a(bcfw parambcfw)
  {
    if (parambcfw == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, parambcfw);
    bctj.a(BaseApplication.getContext()).a(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, bcfu parambcfu)
  {
    paramHashMap.put("param_des_bps", String.valueOf(parambcfu.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(parambcfu.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(parambcfu.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(parambcfu.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(parambcfu.jdField_a_of_type_Int * parambcfu.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, bcfw parambcfw)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(parambcfw.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(parambcfw.d));
    paramHashMap.put("param_src_bps", String.valueOf(parambcfw.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(parambcfw.e));
    paramHashMap.put("param_src_width", String.valueOf(parambcfw.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(parambcfw.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(parambcfw.jdField_a_of_type_Int * parambcfw.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, bcfw parambcfw, bcfu parambcfu, long paramLong2)
  {
    if ((parambcfw == null) || (parambcfu == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, parambcfw);
      a(localHashMap, parambcfu);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((parambcfw.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)parambcfw.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (parambcfw.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / parambcfw.d));
      }
      bctj.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public bcfy a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localWeakReference != null) {
        return (bcfy)localWeakReference.get();
      }
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    bcfy localbcfy = a(paramLong);
    if (localbcfy != null) {
      localbcfy.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, bcfy parambcfy)
  {
    if (parambcfy != null)
    {
      parambcfy = new WeakReference(parambcfy);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambcfy);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)parambcfy.get(), new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    ShortVideoTrimmer.a.set(false);
    Object localObject = ShortVideoTrimmer.a();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = a(paramLong);
    if ((localObject != null) && (((bcfy)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((bcfy)localObject).isCancelled())) {
      ((bcfy)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfx
 * JD-Core Version:    0.7.0.1
 */