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

public class aoor
{
  private static final HashMap<String, aoot> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<aoou, aopa> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<aopa, aoou> b = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    b();
  }
  
  private static aoot a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aoot)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private static aopa a(aoou paramaoou)
  {
    boolean bool1 = false;
    aoot localaoot = a(paramaoou.businessId);
    if (localaoot == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramaoou.businessId);
      }
      return null;
    }
    int i = localaoot.a();
    int j = localaoot.jdField_b_of_type_Int;
    boolean bool2 = localaoot.jdField_b_of_type_Boolean;
    boolean bool3 = localaoot.c;
    if (!localaoot.d) {
      bool1 = true;
    }
    return new aoos(j, bool1, bool3, i, paramaoou.observerOnUiThread, bool2, paramaoou.businessId, paramaoou);
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
  
  public static void a(aoou paramaoou)
  {
    if (paramaoou == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramaoou)) {
          break label129;
        }
        localaopa = a(paramaoou);
        if (localaopa == null) {
          break label134;
        }
        jdField_a_of_type_JavaUtilMap.put(paramaoou, localaopa);
        b.put(localaopa, paramaoou);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localaopa == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramaoou.businessId);
          }
        }
        else
        {
          if (localaopa == null) {
            break;
          }
          SosoInterface.a(localaopa);
          return;
        }
      }
      boolean bool = false;
      continue;
      aopa localaopa = null;
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
    if (((aoot)localObject).d)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.jdField_a_of_type_ArrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((aoot)localObject).jdField_a_of_type_Boolean);
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
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((aoot)localObject).jdField_b_of_type_Int, ((aoot)localObject).jdField_a_of_type_Boolean);
    return paramString;
  }
  
  public static String b()
  {
    return SosoInterface.b();
  }
  
  private static void b()
  {
    aoot localaoot = new aoot("official_location", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("QQMapActivity", true, 5, 1, true, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("vas_red_point", false, 2, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_address_select", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_for_report", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_weather", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_live", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_say", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_photo_recommend", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_little_video_enter", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_request_server", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_h5", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qzone_other", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("gdt_tangram", true, 1, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("nearby_readinjoy", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("troop_handler", true, 2, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("troop_member_distance", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("webview", true, 3, 4, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qq_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qq_story_water_mark", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("readinjoy_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("LBSService.Point", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("Login.Guide", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("recommend_troop", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("vfuchong_bus_card", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("readinjoy_position", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("qqcircle", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
    localaoot = new aoot("extend_friend", true, 1, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localaoot.jdField_a_of_type_JavaLangString, localaoot);
  }
  
  public static void b(aoou paramaoou)
  {
    if (paramaoou == null) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(paramaoou)) {
          break label120;
        }
        localaopa = (aopa)jdField_a_of_type_JavaUtilMap.remove(paramaoou);
        b.remove(localaopa);
        if (QLog.isColorLevel())
        {
          paramaoou = new StringBuilder().append("removeListener business id is: ").append(paramaoou.businessId).append(" sosoLocationListener is null: ");
          if (localaopa == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localaopa == null) {
            break;
          }
          SosoInterface.b(localaopa);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      aopa localaopa = null;
    }
  }
  
  public static String c()
  {
    return SosoInterface.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoor
 * JD-Core Version:    0.7.0.1
 */