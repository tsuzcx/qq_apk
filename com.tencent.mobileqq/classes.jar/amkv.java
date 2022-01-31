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

public class amkv
{
  private static final HashMap<String, amkx> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<amky, amle> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<amle, amky> b = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    b();
  }
  
  private static amkx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (amkx)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private static amle a(amky paramamky)
  {
    boolean bool1 = false;
    amkx localamkx = a(paramamky.businessId);
    if (localamkx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramamky.businessId);
      }
      return null;
    }
    int i = localamkx.a();
    int j = localamkx.jdField_b_of_type_Int;
    boolean bool2 = localamkx.jdField_b_of_type_Boolean;
    boolean bool3 = localamkx.c;
    if (!localamkx.d) {
      bool1 = true;
    }
    return new amkw(j, bool1, bool3, i, paramamky.observerOnUiThread, bool2, paramamky.businessId, paramamky);
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
  
  public static void a(amky paramamky)
  {
    if (paramamky == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramamky)) {
          break label129;
        }
        localamle = a(paramamky);
        if (localamle == null) {
          break label134;
        }
        jdField_a_of_type_JavaUtilMap.put(paramamky, localamle);
        b.put(localamle, paramamky);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localamle == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramamky.businessId);
          }
        }
        else
        {
          if (localamle == null) {
            break;
          }
          SosoInterface.a(localamle);
          return;
        }
      }
      boolean bool = false;
      continue;
      amle localamle = null;
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
    if (((amkx)localObject).d)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.jdField_a_of_type_ArrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((amkx)localObject).jdField_a_of_type_Boolean);
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
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((amkx)localObject).jdField_b_of_type_Int, ((amkx)localObject).jdField_a_of_type_Boolean);
    return paramString;
  }
  
  public static String b()
  {
    return SosoInterface.b();
  }
  
  private static void b()
  {
    amkx localamkx = new amkx("official_location", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("QQMapActivity", true, 5, 1, true, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("vas_red_point", false, 2, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_address_select", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_for_report", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_weather", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_live", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_say", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_photo_recommend", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_little_video_enter", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_request_server", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_h5", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qzone_other", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("gdt_tangram", true, 1, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("nearby_readinjoy", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("troop_handler", true, 2, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("troop_member_distance", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("webview", true, 3, 4, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qq_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qq_story_water_mark", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("readinjoy_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("LBSService.Point", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("Login.Guide", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("recommend_troop", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("vfuchong_bus_card", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("readinjoy_position", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
    localamkx = new amkx("qqcircle", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localamkx.jdField_a_of_type_JavaLangString, localamkx);
  }
  
  public static void b(amky paramamky)
  {
    if (paramamky == null) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(paramamky)) {
          break label120;
        }
        localamle = (amle)jdField_a_of_type_JavaUtilMap.remove(paramamky);
        b.remove(localamle);
        if (QLog.isColorLevel())
        {
          paramamky = new StringBuilder().append("removeListener business id is: ").append(paramamky.businessId).append(" sosoLocationListener is null: ");
          if (localamle == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localamle == null) {
            break;
          }
          SosoInterface.b(localamle);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      amle localamle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amkv
 * JD-Core Version:    0.7.0.1
 */