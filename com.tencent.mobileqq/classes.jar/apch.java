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

public class apch
{
  private static final HashMap<String, apcj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<apck, apcq> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(8, 0.75F);
  private static Map<apcq, apck> b = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    b();
  }
  
  private static apcj a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (apcj)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private static apcq a(apck paramapck)
  {
    boolean bool1 = false;
    apcj localapcj = a(paramapck.businessId);
    if (localapcj == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramapck.businessId);
      }
      return null;
    }
    int i = localapcj.a();
    int j = localapcj.jdField_b_of_type_Int;
    boolean bool2 = localapcj.jdField_b_of_type_Boolean;
    boolean bool3 = localapcj.c;
    if (!localapcj.d) {
      bool1 = true;
    }
    return new apci(j, bool1, bool3, i, paramapck.observerOnUiThread, bool2, paramapck.businessId, paramapck);
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
  
  public static void a(apck paramapck)
  {
    if (paramapck == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramapck)) {
          break label129;
        }
        localapcq = a(paramapck);
        if (localapcq == null) {
          break label134;
        }
        jdField_a_of_type_JavaUtilMap.put(paramapck, localapcq);
        b.put(localapcq, paramapck);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (localapcq == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramapck.businessId);
          }
        }
        else
        {
          if (localapcq == null) {
            break;
          }
          SosoInterface.a(localapcq);
          return;
        }
      }
      boolean bool = false;
      continue;
      apcq localapcq = null;
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
    if (((apcj)localObject).d)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.jdField_a_of_type_ArrayOfByte = paramSosoLbsInfo.jdField_a_of_type_ArrayOfByte;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((apcj)localObject).jdField_a_of_type_Boolean);
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
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((apcj)localObject).jdField_b_of_type_Int, ((apcj)localObject).jdField_a_of_type_Boolean);
    return paramString;
  }
  
  public static String b()
  {
    return SosoInterface.b();
  }
  
  private static void b()
  {
    apcj localapcj = new apcj("official_location", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("QQMapActivity", true, 5, 1, true, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("vas_red_point", false, 2, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_address_select", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_for_report", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_weather", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_live", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_say", true, 5, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_photo_recommend", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_little_video_enter", true, 3, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_request_server", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_h5", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qzone_other", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("gdt_tangram", true, 1, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("nearby_readinjoy", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("troop_handler", true, 2, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("troop_member_distance", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("webview", true, 3, 4, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qq_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qq_story_water_mark", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("readinjoy_weather", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("LBSService.Point", true, 5, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("Login.Guide", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("recommend_troop", true, 2, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("vfuchong_bus_card", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("readinjoy_position", false, 3, 3, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("qqcircle", true, 4, 0, false, false, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
    localapcj = new apcj("extend_friend", true, 1, 0, false, true, false);
    jdField_a_of_type_JavaUtilHashMap.put(localapcj.jdField_a_of_type_JavaLangString, localapcj);
  }
  
  public static void b(apck paramapck)
  {
    if (paramapck == null) {
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(paramapck)) {
          break label120;
        }
        localapcq = (apcq)jdField_a_of_type_JavaUtilMap.remove(paramapck);
        b.remove(localapcq);
        if (QLog.isColorLevel())
        {
          paramapck = new StringBuilder().append("removeListener business id is: ").append(paramapck.businessId).append(" sosoLocationListener is null: ");
          if (localapcq == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (localapcq == null) {
            break;
          }
          SosoInterface.b(localapcq);
          return;
        }
      }
      boolean bool = false;
      continue;
      label120:
      apcq localapcq = null;
    }
  }
  
  public static String c()
  {
    return SosoInterface.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apch
 * JD-Core Version:    0.7.0.1
 */