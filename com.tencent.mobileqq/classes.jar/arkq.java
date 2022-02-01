import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class arkq
{
  private static String jdField_a_of_type_JavaLangString;
  public static HashMap<String, String> a;
  private static String b;
  public static final HashMap<String, Integer> b;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangString = "skin_leba_tongyong_bg";
    jdField_b_of_type_JavaLangString = "https://zb.vip.qq.com/v2/pages/themeMall?_wv=16778243&from=themeIcon";
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_fujin_bg", Integer.valueOf(2130850229));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xingqubuluo_bg", Integer.valueOf(2130850248));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_youxi_bg", Integer.valueOf(2130850251));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_wanyiwan_bg", Integer.valueOf(2130850244));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_weishi_bg", Integer.valueOf(2130850245));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_gouwu_bg", Integer.valueOf(2130850230));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_bodongdongman_bg", Integer.valueOf(2130850227));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_zhibo_bg", Integer.valueOf(2130850253));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiedianjing_bg", Integer.valueOf(2130850233));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_pupudushu_bg", Integer.valueOf(2130850232));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yinyue_bg", Integer.valueOf(2130850250));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yingyongbao_bg", Integer.valueOf(2130850249));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tanbaishuo_bg", Integer.valueOf(2130850238));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yundong_bg", Integer.valueOf(2130850252));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_chihewanle_bg", Integer.valueOf(2130850228));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tongchengfuwu_bg", Integer.valueOf(2130850242));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunxinwen_bg", Integer.valueOf(2130850240));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunketang_bg", Integer.valueOf(2130850239));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiefudao_bg", Integer.valueOf(2130850234));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xiaoyuankuolie_bg", Integer.valueOf(2130850247));
  }
  
  @NonNull
  public static arkq a(String paramString)
  {
    arkq localarkq = new arkq();
    if (TextUtils.isEmpty(paramString))
    {
      localarkq.jdField_a_of_type_Boolean = false;
      return localarkq;
    }
    localarkq.jdField_a_of_type_Boolean = true;
    a(paramString);
    return localarkq;
  }
  
  private static void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("android");
      JSONObject localJSONObject = paramString.getJSONObject("backgroundIconConfig");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          jdField_a_of_type_JavaUtilHashMap.put(str, localJSONObject.getString(str));
        }
      }
      jdField_a_of_type_JavaLangString = paramString.getString("defaultIconName");
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    jdField_b_of_type_JavaLangString = paramString.getString("themeStoreUrl");
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public String a()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = jdField_a_of_type_JavaLangString;
    }
    return paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkq
 * JD-Core Version:    0.7.0.1
 */