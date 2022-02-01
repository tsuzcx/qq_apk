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

public class bbry
{
  private static bbry jdField_a_of_type_Bbry;
  private static ConcurrentHashMap<Long, WeakReference<bbrz>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
  }
  
  public static bbry a()
  {
    if (jdField_a_of_type_Bbry == null) {
      jdField_a_of_type_Bbry = new bbry();
    }
    return jdField_a_of_type_Bbry;
  }
  
  public static void a(bbrx parambbrx)
  {
    if (parambbrx == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, parambbrx);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, bbrv parambbrv)
  {
    paramHashMap.put("param_des_bps", String.valueOf(parambbrv.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(parambbrv.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(parambbrv.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(parambbrv.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(parambbrv.jdField_a_of_type_Int * parambbrv.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, bbrx parambbrx)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(parambbrx.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(parambbrx.d));
    paramHashMap.put("param_src_bps", String.valueOf(parambbrx.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(parambbrx.e));
    paramHashMap.put("param_src_width", String.valueOf(parambbrx.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(parambbrx.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(parambbrx.jdField_a_of_type_Int * parambbrx.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, bbrx parambbrx, bbrv parambbrv, long paramLong2)
  {
    if ((parambbrx == null) || (parambbrv == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, parambbrx);
      a(localHashMap, parambbrv);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((parambbrx.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)parambbrx.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (parambbrx.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / parambbrx.d));
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public bbrz a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localWeakReference != null) {
        return (bbrz)localWeakReference.get();
      }
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    bbrz localbbrz = a(paramLong);
    if (localbbrz != null) {
      localbbrz.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, bbrz parambbrz)
  {
    if (parambbrz != null)
    {
      parambbrz = new WeakReference(parambbrz);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), parambbrz);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)parambbrz.get(), new Void[0]);
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
    if ((localObject != null) && (((bbrz)localObject).getStatus() != AsyncTask.Status.FINISHED) && (!((bbrz)localObject).isCancelled())) {
      ((bbrz)localObject).cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbry
 * JD-Core Version:    0.7.0.1
 */