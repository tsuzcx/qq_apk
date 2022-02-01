import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class azen
{
  private static HashMap<Integer, String> a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(100), "openreadinjoy");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(101), "scan");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(102), "qassistantnearby");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(103), "qsettings");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(104), "searchpage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(105), "ecchat");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(106), "weishi");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(107), "qinterest");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(108), "confessmsg");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(109), "qqgame");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(110), "conversation");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(111), "contact");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(112), "leba");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(113), "qzone");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(114), "wezone");
  }
  
  public static azem a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return new azem();
    }
    Object localObject;
    if ((paramString.equalsIgnoreCase("qinterest")) || (paramString.equalsIgnoreCase("qqgame"))) {
      localObject = new azeq();
    }
    for (;;)
    {
      ((azem)localObject).f = paramString;
      return localObject;
      if ((paramString.equalsIgnoreCase("conversation")) || (paramString.equalsIgnoreCase("contact")) || (paramString.equalsIgnoreCase("leba"))) {
        localObject = new azeo();
      } else {
        localObject = new azem();
      }
    }
  }
  
  public static final String a(int paramInt)
  {
    return (String)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public static List<azem> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b("openreadinjoy"));
    localArrayList.add(b("scan"));
    localArrayList.add(b("qassistantnearby"));
    localArrayList.add(b("qsettings"));
    localArrayList.add(b("searchpage"));
    localArrayList.add(b("ecchat"));
    localArrayList.add(b("weishi"));
    localArrayList.add(b("qinterest"));
    localArrayList.add(b("confessmsg"));
    localArrayList.add(b("qqgame"));
    localArrayList.add(b("conversation"));
    localArrayList.add(b("contact"));
    localArrayList.add(b("leba"));
    localArrayList.add(b("qzone"));
    localArrayList.add(b("wezone"));
    return localArrayList;
  }
  
  public static azem b(String paramString)
  {
    if (paramString.equalsIgnoreCase("openreadinjoy"))
    {
      paramString = new azeq();
      paramString.jdField_a_of_type_JavaLangString = "Open_看点页面跳转——Server版";
      paramString.c = "readinjoy";
      paramString.d = "open";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "openreadinjoy";
      paramString.jdField_a_of_type_JavaUtilHashMap.put("target", "2001");
      paramString.jdField_a_of_type_JavaUtilHashMap.put("from", "1");
      return paramString;
    }
    if (paramString.equalsIgnoreCase("scan"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_扫一扫页面跳转——Server版";
      paramString.c = "scanforqassistant";
      paramString.d = "gotoScannerTorchActivity";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "scan";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qassistantnearby"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_附近的人页面跳转——Server版";
      paramString.c = "nearbyforqassistant";
      paramString.d = "open";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "qassistantnearby";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qsettings"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_设置页面跳转——Server版";
      paramString.c = "settingsforqassistant";
      paramString.d = "open";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "qsettings";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("searchpage"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_搜索页面跳转——Server版";
      paramString.c = "searchforqassistant";
      paramString.d = "open";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "searchpage";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("ecchat"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_扩列页面跳转——Server版";
      paramString.c = "qechatforqassistant";
      paramString.d = "open";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "ecchat";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("weishi"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_扩列页面跳转——Server版";
      paramString.c = "weishiforqassistant";
      paramString.d = "open";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "weishi";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qinterest"))
    {
      paramString = new azeq();
      paramString.jdField_a_of_type_JavaLangString = "Open_兴趣部落页面跳转——Scheme版";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "qinterest";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("confessmsg"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_坦白说页面跳转——Server版";
      paramString.c = "confiessmsgforqassistant";
      paramString.d = "open";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "confessmsg";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qqgame"))
    {
      paramString = new azeq();
      paramString.jdField_a_of_type_JavaLangString = "Open_游戏中心页面跳转——Scheme版";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "qqgame";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("conversation"))
    {
      paramString = new azeo();
      paramString.jdField_a_of_type_JavaLangString = "Open_主界面tab_消息列表";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "conversation";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("contact"))
    {
      paramString = new azeo();
      paramString.jdField_a_of_type_JavaLangString = "Open_主界面tab_联系人";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "contact";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("leba"))
    {
      paramString = new azeo();
      paramString.jdField_a_of_type_JavaLangString = "Open_主界面tab_动态";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "leba";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qzone"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_好友动态跳转";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "qzone";
      paramString.c = "qzoneforqassistant";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("wezone"))
    {
      paramString = new azem();
      paramString.jdField_a_of_type_JavaLangString = "Open_小世界跳转";
      paramString.jdField_a_of_type_Boolean = true;
      paramString.f = "wezone";
      paramString.c = "weqzoneforqassistant";
      return paramString;
    }
    return new azeq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azen
 * JD-Core Version:    0.7.0.1
 */