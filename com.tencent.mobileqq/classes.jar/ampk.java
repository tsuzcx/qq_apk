import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ampk
{
  private static final HashMap<String, ampm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<ampn, ampt> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<ampt, ampn> b = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    b();
  }
  
  private static ampm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ampm)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private static ampt a(ampn paramampn)
  {
    boolean bool1 = false;
    ampm localampm = a(paramampn.businessId);
    if (localampm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramampn.businessId);
      }
      return null;
    }
    int i = localampm.a();
    int j = localampm.jdField_b_of_type_Int;
    boolean bool2 = localampm.jdField_b_of_type_Boolean;
    boolean bool3 = localampm.c;
    if (!localampm.d) {
      bool1 = true;
    }
    return new ampl(j, bool1, bool3, i, paramampn.observerOnUiThread, bool2, paramampn.businessId, paramampn);
  }
  
  public static SosoInterface.SosoLbsInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business id: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = a(paramString);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business info is null.");
    return null;
    if (paramString.d) {
      return SosoInterface.a(paramString.jdField_a_of_type_Boolean);
    }
    return SosoInterface.a(paramString.jdField_b_of_type_Int, paramString.jdField_a_of_type_Boolean);
  }
  
  public static String a()
  {
    return SosoInterface.a();
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      jdField_a_of_type_JavaUtilMap.clear();
      b.clear();
      return;
    }
  }
  
  public static void a(ampn paramampn)
  {
    if (paramampn == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramampn)) {
          break label129;
        }
        localampt = a(paramampn);
        if (localampt == null) {
          break label134;
        }
        jdField_a_of_type_JavaUtilMap.put(paramampn, localampt);
        b.put(localampt, paramampn);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localampt == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramampn.businessId);
          }
        }
        else
        {
          if (localampt == null) {
            break;
          }
          SosoInterface.a(localampt);
          return;
        }
      }
      boolean bool = false;
      continue;
      ampt localampt = null;
    }
  }
  
  public static boolean a()
  {
    return SosoInterface.a();
  }
  
  private static SosoInterface.SosoLbsInfo b(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return null;
      localObject = a(paramString);
    } while ((localObject == null) || (paramSosoLbsInfo == null));
    if (((ampm)localObject).d)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.jdField_a_of_type_ArrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((ampm)localObject).jdField_a_of_type_Boolean);
      }
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a();
      }
      localObject = new ArrayList();
      if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList);
      }
      paramString.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      localObject = new ArrayList();
      if (paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList);
      }
      paramString.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject);
      paramString.jdField_a_of_type_Long = paramSosoLbsInfo.jdField_a_of_type_Long;
      paramString.jdField_a_of_type_JavaLangString = paramSosoLbsInfo.jdField_a_of_type_JavaLangString;
      paramString.jdField_b_of_type_JavaLangString = paramSosoLbsInfo.jdField_b_of_type_JavaLangString;
      return paramString;
    }
    paramString = new SosoInterface.SosoLbsInfo();
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((ampm)localObject).jdField_b_of_type_Int, ((ampm)localObject).jdField_a_of_type_Boolean);
    return paramString;
  }
  
  public static String b()
  {
    return SosoInterface.b();
  }
  
  private static void b()
  {
    ampm localampm = new ampm("official_location", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("QQMapActivity", true, 5, 1, true, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("vas_red_point", false, 2, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_address_select", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_for_report", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_weather", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_live", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_say", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_photo_recommend", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_little_video_enter", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_request_server", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_h5", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qzone_other", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("gdt_tangram", true, 1, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("nearby_readinjoy", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("troop_handler", true, 2, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("troop_member_distance", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("webview", true, 3, 4, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qq_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qq_story_water_mark", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("readinjoy_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("LBSService.Point", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("Login.Guide", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("recommend_troop", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("vfuchong_bus_card", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("readinjoy_position", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
    localampm = new ampm("qqcircle", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localampm.jdField_a_of_type_JavaLangString, localampm);
  }
  
  public static void b(ampn paramampn)
  {
    if (paramampn == null) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(paramampn)) {
          break label120;
        }
        localampt = (ampt)jdField_a_of_type_JavaUtilMap.remove(paramampn);
        b.remove(localampt);
        if (QLog.isColorLevel())
        {
          paramampn = new StringBuilder().append("removeListener business id is: ").append(paramampn.businessId).append(" sosoLocationListener is null: ");
          if (localampt == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localampt == null) {
            break;
          }
          SosoInterface.b(localampt);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      ampt localampt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ampk
 * JD-Core Version:    0.7.0.1
 */