import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bddd
{
  private static String jdField_a_of_type_JavaLangString;
  private static List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private static List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private static Map<String, Map<String, Integer>> jdField_b_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    b();
    c();
    d();
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
    jdField_b_of_type_JavaUtilMap.clear();
    d();
  }
  
  public static void a(List<SecondApiRightInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SecondApiRightInfo localSecondApiRightInfo = (SecondApiRightInfo)paramList.next();
        if (localSecondApiRightInfo != null) {
          if (jdField_b_of_type_JavaUtilMap.containsKey(localSecondApiRightInfo.apiName))
          {
            if (bdnw.a()) {
              bdnw.a("AuthFilterList", "config apiName : " + localSecondApiRightInfo.apiName + ", secondName: " + localSecondApiRightInfo.secondName);
            }
            ((Map)jdField_b_of_type_JavaUtilMap.get(localSecondApiRightInfo.apiName)).put(localSecondApiRightInfo.secondName, Integer.valueOf(localSecondApiRightInfo.right));
          }
          else
          {
            if (bdnw.a()) {
              bdnw.a("AuthFilterList", "init config apiName : " + localSecondApiRightInfo.apiName + ", secondName: " + localSecondApiRightInfo.secondName);
            }
            HashMap localHashMap = new HashMap();
            localHashMap.put(localSecondApiRightInfo.secondName, Integer.valueOf(localSecondApiRightInfo.right));
            jdField_b_of_type_JavaUtilMap.put(localSecondApiRightInfo.apiName, localHashMap);
          }
        }
      }
    }
  }
  
  public static void a(List<String> paramList1, List<String> paramList2)
  {
    Map localMap = jdField_a_of_type_JavaUtilMap;
    if (paramList1 != null)
    {
      try
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          String str = (String)paramList1.next();
          if (!TextUtils.isEmpty(str))
          {
            bdnw.a("AuthFilterList", "whiteList eventName : " + str);
            jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(0));
          }
        }
        if (paramList2 == null) {
          break label167;
        }
      }
      finally {}
    }
    else
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!TextUtils.isEmpty(paramList2))
        {
          bdnw.a("AuthFilterList", "whiteList eventName : " + paramList2);
          jdField_a_of_type_JavaUtilMap.put(paramList2, Integer.valueOf(1));
        }
      }
    }
    label167:
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilList.contains(paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(paramString1))
    {
      if (((Integer)jdField_a_of_type_JavaUtilMap.get(paramString1)).intValue() == 0)
      {
        bdnw.a("AuthFilterList_isEventNameRight", "false, 一级黑名单 : " + paramString1);
        return false;
      }
      if (((Integer)jdField_a_of_type_JavaUtilMap.get(paramString1)).intValue() == 1)
      {
        bdnw.a("AuthFilterList_isEventNameRight", "true, 一级白名单 : " + paramString1);
        return true;
      }
    }
    if (jdField_b_of_type_JavaUtilMap.containsKey(paramString1))
    {
      if ((((Map)jdField_b_of_type_JavaUtilMap.get(paramString1)).containsKey(paramString2)) && (((Integer)((Map)jdField_b_of_type_JavaUtilMap.get(paramString1)).get(paramString2)).intValue() == 1))
      {
        bdnw.a("AuthFilterList_isEventNameRight", "true, 二级白名单 : " + paramString1 + " " + paramString2);
        return true;
      }
      bdnw.a("AuthFilterList_isEventNameRight", "false, 二级黑名单或未配置 : " + paramString1 + " " + paramString2);
      return false;
    }
    if (jdField_b_of_type_JavaUtilList.contains(paramString1))
    {
      bdnw.a("AuthFilterList_isEventNameRight", "false, 本地黑名单 : " + paramString1);
      return false;
    }
    bdnw.a("AuthFilterList_isEventNameRight", "true, 无限制api : " + paramString1);
    return true;
  }
  
  private static void b()
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      String str1 = bdhg.a("MiniApp", "MiniAppAuthWhiteList", "1108292102");
      if ((str1 != null) && (!str1.equals(jdField_a_of_type_JavaLangString)))
      {
        jdField_a_of_type_JavaUtilList.clear();
        try
        {
          String[] arrayOfString = str1.split(",");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str2 = arrayOfString[i];
              if (!bdhe.a(str2)) {
                jdField_a_of_type_JavaUtilList.add(str2);
              }
              i += 1;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          bdnw.d("AuthFilterList", "initAuthWhiteList error,", localThrowable);
          jdField_a_of_type_JavaLangString = str1;
        }
      }
      return;
    }
  }
  
  public static boolean b(String paramString)
  {
    return jdField_b_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  private static void c()
  {
    synchronized (jdField_b_of_type_JavaUtilList)
    {
      jdField_b_of_type_JavaUtilList.clear();
      jdField_b_of_type_JavaUtilList.add("requestPayment");
      jdField_b_of_type_JavaUtilList.add("requestMidasPayment");
      jdField_b_of_type_JavaUtilList.add("requestPaymentToBank");
      jdField_b_of_type_JavaUtilList.add("reportSubmitForm");
      jdField_b_of_type_JavaUtilList.add("insertHTMLWebView");
      jdField_b_of_type_JavaUtilList.add("updateHTMLWebView");
      jdField_b_of_type_JavaUtilList.add("removeHTMLWebView");
      jdField_b_of_type_JavaUtilList.add("onWebInvokeAppService");
      jdField_b_of_type_JavaUtilList.add("insertLivePusher");
      jdField_b_of_type_JavaUtilList.add("updateLivePusher");
      jdField_b_of_type_JavaUtilList.add("removeLivePusher");
      jdField_b_of_type_JavaUtilList.add("operateLivePusher");
      jdField_b_of_type_JavaUtilList.add("onLivePusherEvent");
      jdField_b_of_type_JavaUtilList.add("onLivePusherNetStatus");
      jdField_b_of_type_JavaUtilList.add("insertLivePlayer");
      jdField_b_of_type_JavaUtilList.add("updateLivePlayer");
      jdField_b_of_type_JavaUtilList.add("removeLivePlayer");
      jdField_b_of_type_JavaUtilList.add("operateLivePlayer");
      jdField_b_of_type_JavaUtilList.add("onLivePlayerEvent");
      jdField_b_of_type_JavaUtilList.add("onLivePlayerFullScreenChange");
      jdField_b_of_type_JavaUtilList.add("onLivePlayerNetStatus");
      jdField_b_of_type_JavaUtilList.add("shareAppPictureMessage");
      jdField_b_of_type_JavaUtilList.add("shareAppPictureMessageDirectly");
      jdField_b_of_type_JavaUtilList.add("insertMap");
      jdField_b_of_type_JavaUtilList.add("updateMap");
      jdField_b_of_type_JavaUtilList.add("removeMap");
      jdField_b_of_type_JavaUtilList.add("updateMapCovers");
      jdField_b_of_type_JavaUtilList.add("addMapLines");
      jdField_b_of_type_JavaUtilList.add("addMapPolygons");
      jdField_b_of_type_JavaUtilList.add("addMapCircles");
      jdField_b_of_type_JavaUtilList.add("getMapCenterLocation");
      jdField_b_of_type_JavaUtilList.add("moveToMapLocation");
      jdField_b_of_type_JavaUtilList.add("translateMapMarker");
      jdField_b_of_type_JavaUtilList.add("includeMapPoints");
      jdField_b_of_type_JavaUtilList.add("getMapScale");
      jdField_b_of_type_JavaUtilList.add("getMapRegion");
      jdField_b_of_type_JavaUtilList.add("addMapMarkers");
      jdField_b_of_type_JavaUtilList.add("removeMapMarkers");
      jdField_b_of_type_JavaUtilList.add("addMapControls");
      jdField_b_of_type_JavaUtilList.add("wnsRequest");
      jdField_b_of_type_JavaUtilList.add("getQua");
      jdField_b_of_type_JavaUtilList.add("notifyNative");
      jdField_b_of_type_JavaUtilList.add("openUrl");
      jdField_b_of_type_JavaUtilList.add("getUserInfoExtra");
      jdField_b_of_type_JavaUtilList.add("openScheme");
      jdField_b_of_type_JavaUtilList.add("Personalize");
      jdField_b_of_type_JavaUtilList.add("invokeNativePlugin");
      jdField_b_of_type_JavaUtilList.add("startDownloadAppTask");
      jdField_b_of_type_JavaUtilList.add("cancelDownloadAppTask");
      jdField_b_of_type_JavaUtilList.add("queryDownloadAppTask");
      jdField_b_of_type_JavaUtilList.add("queryAppInfo");
      jdField_b_of_type_JavaUtilList.add("installApp");
      jdField_b_of_type_JavaUtilList.add("startApp");
      return;
    }
  }
  
  private static void d()
  {
    synchronized (jdField_b_of_type_JavaUtilMap)
    {
      jdField_b_of_type_JavaUtilMap.clear();
      jdField_b_of_type_JavaUtilMap.put("openScheme", new HashMap());
      jdField_b_of_type_JavaUtilMap.put("Personalize", new HashMap());
      jdField_b_of_type_JavaUtilMap.put("invokeNativePlugin", new HashMap());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bddd
 * JD-Core Version:    0.7.0.1
 */