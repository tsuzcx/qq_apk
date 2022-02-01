import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class bcys
{
  private static bcys jdField_a_of_type_Bcys;
  private static ConcurrentHashMap<Long, WeakReference<bcyt>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
  }
  
  public static bcys a()
  {
    if (jdField_a_of_type_Bcys == null) {
      jdField_a_of_type_Bcys = new bcys();
    }
    return jdField_a_of_type_Bcys;
  }
  
  public static void a(bcyr parambcyr)
  {
    if (parambcyr == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, parambcyr);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, bcyp parambcyp)
  {
    paramHashMap.put("param_des_bps", String.valueOf(parambcyp.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(parambcyp.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(parambcyp.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(parambcyp.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(parambcyp.jdField_a_of_type_Int * parambcyp.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, bcyr parambcyr)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(parambcyr.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(parambcyr.d));
    paramHashMap.put("param_src_bps", String.valueOf(parambcyr.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(parambcyr.e));
    paramHashMap.put("param_src_width", String.valueOf(parambcyr.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(parambcyr.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(parambcyr.jdField_a_of_type_Int * parambcyr.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, bcyr parambcyr, bcyp parambcyp, long paramLong2)
  {
    if ((parambcyr == null) || (parambcyp == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, parambcyr);
      a(localHashMap, parambcyp);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((parambcyr.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)parambcyr.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (parambcyr.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / parambcyr.d));
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public bcyt a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localWeakReference != null) {
        return (bcyt)localWeakReference.get();
      }
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    bcyt localbcyt = a(paramLong);
    if (localbcyt != null) {
      localbcyt.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, bcyt parambcyt)
  {
    if (parambcyt != null)
    {
      parambcyt = new WeakReference(parambcyt);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambcyt);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)parambcyt.get(), new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    ShortVideoTrimmer.needCompress.set(false);
    Object localObject = ShortVideoTrimmer.getProcess();
    if (localObject != null) {
      ((Process)localObject).destroy();
    }
    localObject = a(paramLong);
    if ((localObject != null) && (((bcyt)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((bcyt)localObject).isCancelled())) {
      ((bcyt)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcys
 * JD-Core Version:    0.7.0.1
 */