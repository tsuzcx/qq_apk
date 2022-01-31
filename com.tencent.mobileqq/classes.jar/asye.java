import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asye
{
  public float a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  
  public asye()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private static asye a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    asye localasye = new asye();
    localasye.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localasye.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localasye.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localasye.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localasye.d = paramJSONObject.optLong("last_action_time");
    localasye.e = paramJSONObject.optLong("last_change_time");
    localasye.jdField_f_of_type_Long = paramJSONObject.optLong("icon_status");
    localasye.g = paramJSONObject.optLong("icon_status_end_time");
    localasye.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localasye.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localasye.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localasye.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localasye.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
    return localasye;
  }
  
  public static String a(ConcurrentHashMap<Long, asye> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((asye)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, asye> a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkInfo", 1, "parseFrom json_str:" + paramString);
    }
    localConcurrentHashMap = new ConcurrentHashMap();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        asye localasye = a(paramString.getJSONObject(i));
        if (localasye != null) {
          localConcurrentHashMap.put(Long.valueOf(localasye.jdField_a_of_type_Long), localasye);
        }
        i += 1;
      }
      return localConcurrentHashMap;
    }
    catch (JSONException paramString)
    {
      QLog.e("MutualMarkInfo", 1, "toJsonString error:" + paramString.getMessage());
    }
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.jdField_a_of_type_Long);
      localJSONObject.put("level", this.jdField_b_of_type_Long);
      localJSONObject.put("count", this.jdField_a_of_type_Float);
      localJSONObject.put("continue_days", this.jdField_c_of_type_Long);
      localJSONObject.put("last_action_time", this.d);
      localJSONObject.put("last_change_time", this.e);
      localJSONObject.put("icon_status", this.jdField_f_of_type_Long);
      localJSONObject.put("icon_status_end_time", this.g);
      localJSONObject.put("hasRemindInContact", this.jdField_b_of_type_Boolean);
      localJSONObject.put("icon_static_url", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("icon_dynamic_url", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("icon_name", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("user_close_flag", this.jdField_a_of_type_Boolean);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("MutualMarkInfo", 1, "toJsonForStore error:" + localJSONException.getMessage());
    }
    return localJSONObject;
  }
  
  public boolean a(acvw paramacvw, long paramLong)
  {
    boolean bool = true;
    if (paramacvw.jdField_a_of_type_Acvy != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.d > 0L) && (paramacvw.jdField_a_of_type_Acvy.jdField_c_of_type_Long < this.d))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramacvw.jdField_a_of_type_Acvy.jdField_c_of_type_Long + " last_action_time:" + this.d);
        }
        return false;
      }
      this.jdField_a_of_type_Long = paramacvw.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramacvw.jdField_a_of_type_Acvy.jdField_b_of_type_Long;
      if (paramacvw.jdField_a_of_type_Acvy.jdField_c_of_type_Long > 0L) {
        this.d = paramacvw.jdField_a_of_type_Acvy.jdField_c_of_type_Long;
      }
      if (paramacvw.jdField_a_of_type_Acvy.d > 0L) {
        this.e = paramacvw.jdField_a_of_type_Acvy.d;
      }
      this.jdField_c_of_type_Long = paramacvw.jdField_a_of_type_Acvy.jdField_a_of_type_Int;
      this.jdField_f_of_type_Long = paramacvw.jdField_a_of_type_Acvy.jdField_f_of_type_Long;
      if (paramLong == 11002L) {
        this.g = paramacvw.jdField_a_of_type_Acvy.g;
      }
      if (this.jdField_f_of_type_Long != 2L) {
        this.g = 0L;
      }
      this.jdField_a_of_type_JavaLangString = paramacvw.jdField_a_of_type_Acvy.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramacvw.jdField_a_of_type_Acvy.jdField_c_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramacvw.jdField_a_of_type_Acvy.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramacvw.jdField_a_of_type_Acvy.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(asyf paramasyf)
  {
    this.jdField_a_of_type_Long = paramasyf.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramasyf.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramasyf.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramasyf.jdField_c_of_type_Long;
    this.d = paramasyf.d;
    this.jdField_f_of_type_Long = paramasyf.jdField_f_of_type_Long;
    this.g = paramasyf.g;
    this.jdField_a_of_type_JavaLangString = paramasyf.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramasyf.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramasyf.e;
    this.jdField_a_of_type_Boolean = paramasyf.jdField_a_of_type_Boolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asye
 * JD-Core Version:    0.7.0.1
 */