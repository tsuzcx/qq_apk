import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhi
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
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_fujin_bg", Integer.valueOf(2130850127));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xingqubuluo_bg", Integer.valueOf(2130850146));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_youxi_bg", Integer.valueOf(2130850149));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_wanyiwan_bg", Integer.valueOf(2130850142));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_weishi_bg", Integer.valueOf(2130850143));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_gouwu_bg", Integer.valueOf(2130850128));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_bodongdongman_bg", Integer.valueOf(2130850125));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_zhibo_bg", Integer.valueOf(2130850151));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiedianjing_bg", Integer.valueOf(2130850131));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_pupudushu_bg", Integer.valueOf(2130850130));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yinyue_bg", Integer.valueOf(2130850148));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yingyongbao_bg", Integer.valueOf(2130850147));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tanbaishuo_bg", Integer.valueOf(2130850136));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yundong_bg", Integer.valueOf(2130850150));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_chihewanle_bg", Integer.valueOf(2130850126));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tongchengfuwu_bg", Integer.valueOf(2130850140));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunxinwen_bg", Integer.valueOf(2130850138));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunketang_bg", Integer.valueOf(2130850137));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiefudao_bg", Integer.valueOf(2130850132));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xiaoyuankuolie_bg", Integer.valueOf(2130850145));
  }
  
  @NonNull
  public static aqhi a(String paramString)
  {
    aqhi localaqhi = new aqhi();
    if (TextUtils.isEmpty(paramString))
    {
      localaqhi.jdField_a_of_type_Boolean = false;
      return localaqhi;
    }
    localaqhi.jdField_a_of_type_Boolean = true;
    a(paramString);
    return localaqhi;
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
 * Qualified Name:     aqhi
 * JD-Core Version:    0.7.0.1
 */