import android.content.Intent;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bpii
{
  public static long a;
  public static String a;
  public static Map<String, apgu> a;
  public static boolean a;
  public static long b;
  public static String b;
  public static boolean b;
  public static long c;
  public static String c;
  private static long d;
  private static long e;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaLangString = ".photo";
    jdField_c_of_type_JavaLangString = ".openCamera";
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    d = 0L;
    e = 0L;
    jdField_c_of_type_Long = 0L;
  }
  
  public static long a(Intent paramIntent)
  {
    return paramIntent.getLongExtra("start_intent_time", 0L);
  }
  
  public static void a()
  {
    if (jdField_b_of_type_Boolean)
    {
      a("first frame from camera");
      jdField_b_of_type_Boolean = false;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("start_intent_time", jdField_a_of_type_Long);
  }
  
  public static void a(Camera.Parameters paramParameters, String paramString)
  {
    int j = 1;
    if (paramParameters == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("open_custom_camera", 2, paramString + "   model compatibility");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("camera_type", paramString);
    paramString = "";
    String str = paramString;
    int i;
    if (paramParameters != null)
    {
      localObject = paramParameters.getSupportedFlashModes();
      str = paramString;
      if (localObject != null)
      {
        str = paramString;
        if (((List)localObject).size() > 0)
        {
          paramString = (String)((List)localObject).get(0);
          i = 1;
          for (;;)
          {
            str = paramString;
            if (i >= ((List)localObject).size()) {
              break;
            }
            paramString = paramString + "#";
            paramString = paramString + (String)((List)localObject).get(i);
            i += 1;
          }
        }
      }
    }
    Object localObject = "";
    paramString = (String)localObject;
    if (paramParameters != null)
    {
      List localList = paramParameters.getSupportedFocusModes();
      paramString = (String)localObject;
      if (localList != null)
      {
        paramString = (String)localObject;
        if (localList.size() > 0)
        {
          paramParameters = (String)localList.get(0);
          i = j;
          for (;;)
          {
            paramString = paramParameters;
            if (i >= localList.size()) {
              break;
            }
            paramParameters = paramParameters + "#";
            paramParameters = paramParameters + (String)localList.get(i);
            i += 1;
          }
        }
      }
    }
    localHashMap.put("supported_focus_mode", paramString);
    localHashMap.put("supported_flash_mode", str);
    a(null, "sv_model_compatibility", localHashMap);
  }
  
  public static void a(String paramString)
  {
    a(paramString, jdField_a_of_type_Long);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d(jdField_b_of_type_JavaLangString, 2, paramString + ";" + (l - paramLong));
      jdField_a_of_type_Long = l;
    }
  }
  
  private static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (QLog.isColorLevel())) {
      QLog.d("open_custom_camera", 2, paramString1);
    }
    if (paramHashMap == null) {}
    for (paramString1 = new HashMap();; paramString1 = paramHashMap)
    {
      paramString1.put("MANUFACTURER", Build.MANUFACTURER);
      paramString1.put("MODEL", Build.MODEL);
      paramString1.put("DEVICE_TYPE_NAME", aqmx.a().a());
      a(paramString1, "open_custom_camera", paramString2);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, paramString2, true, 0L, 0L, paramString1, null);
      return;
    }
  }
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    for (paramMap = "事件Code : " + paramString2 + "   上报内容 ----------  \n"; localIterator.hasNext(); paramMap = paramMap + "\n")
    {
      paramString2 = (Map.Entry)localIterator.next();
      paramMap = paramMap + (String)paramString2.getKey();
      paramMap = paramMap + "   :   ";
      paramMap = paramMap + (String)paramString2.getValue();
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramMap);
    }
  }
  
  public static void b()
  {
    a("custom photo send", "sv_custom_photo_send", null);
  }
  
  public static void c()
  {
    a("capture photo send", "sv_capture_photo_send", null);
  }
  
  public static void d()
  {
    a("system photo send", "sv_system_photo_send", null);
  }
  
  public static void e()
  {
    a("photo taken by custom", "sv_photo_taken_by_custom", null);
  }
  
  public static void f()
  {
    a("photo taken by capture", "sv_photo_taken_by_capture", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpii
 * JD-Core Version:    0.7.0.1
 */