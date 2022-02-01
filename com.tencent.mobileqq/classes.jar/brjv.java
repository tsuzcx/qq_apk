import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class brjv
{
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("crashKind", "" + paramInt);
    bdmc.a(VideoEnvironment.a()).a(null, "sv_filter_egl_crash_exp", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("time", "" + paramLong);
    localHashMap.put("filter_id", brjw.jdField_a_of_type_JavaLangString);
    localHashMap.put("front_camera", String.valueOf(brjw.jdField_a_of_type_Boolean));
    bdmc.a(VideoEnvironment.a()).a(null, paramString, true, paramLong, brij.c, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("PerformenceDataTag", 2, "reportPerformance : tag = " + paramString + " ; duration = " + paramLong + " ; filter_id = " + brjw.jdField_a_of_type_JavaLangString + " ; front_camera = " + brjw.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brjv
 * JD-Core Version:    0.7.0.1
 */