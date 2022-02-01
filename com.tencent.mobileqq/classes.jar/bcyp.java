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

public class bcyp
{
  private static bcyp jdField_a_of_type_Bcyp;
  private static ConcurrentHashMap<Long, WeakReference<bcyq>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    beyq.a();
  }
  
  public static bcyp a()
  {
    if (jdField_a_of_type_Bcyp == null) {
      jdField_a_of_type_Bcyp = new bcyp();
    }
    return jdField_a_of_type_Bcyp;
  }
  
  public static void a(bcyo parambcyo)
  {
    if (parambcyo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, parambcyo);
    bdmc.a(BaseApplication.getContext()).a(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, bcym parambcym)
  {
    paramHashMap.put("param_des_bps", String.valueOf(parambcym.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(parambcym.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(parambcym.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(parambcym.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(parambcym.jdField_a_of_type_Int * parambcym.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, bcyo parambcyo)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(parambcyo.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(parambcyo.d));
    paramHashMap.put("param_src_bps", String.valueOf(parambcyo.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(parambcyo.e));
    paramHashMap.put("param_src_width", String.valueOf(parambcyo.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(parambcyo.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(parambcyo.jdField_a_of_type_Int * parambcyo.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, bcyo parambcyo, bcym parambcym, long paramLong2)
  {
    if ((parambcyo == null) || (parambcym == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, parambcyo);
      a(localHashMap, parambcym);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((parambcyo.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)parambcyo.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (parambcyo.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / parambcyo.d));
      }
      bdmc.a(BaseApplication.getContext()).a(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public bcyq a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localWeakReference != null) {
        return (bcyq)localWeakReference.get();
      }
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    bcyq localbcyq = a(paramLong);
    if (localbcyq != null) {
      localbcyq.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, bcyq parambcyq)
  {
    if (parambcyq != null)
    {
      parambcyq = new WeakReference(parambcyq);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambcyq);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)parambcyq.get(), new Void[0]);
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
    if ((localObject != null) && (((bcyq)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((bcyq)localObject).isCancelled())) {
      ((bcyq)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyp
 * JD-Core Version:    0.7.0.1
 */