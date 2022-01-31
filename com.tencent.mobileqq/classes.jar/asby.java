import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asby
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
  
  public asby()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private static asby a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    asby localasby = new asby();
    localasby.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localasby.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localasby.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localasby.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localasby.d = paramJSONObject.optLong("last_action_time");
    localasby.e = paramJSONObject.optLong("last_change_time");
    localasby.jdField_f_of_type_Long = paramJSONObject.optLong("icon_status");
    localasby.g = paramJSONObject.optLong("icon_status_end_time");
    localasby.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localasby.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localasby.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localasby.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localasby.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
    return localasby;
  }
  
  public static String a(ConcurrentHashMap<Long, asby> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((asby)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, asby> a(String paramString)
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
        asby localasby = a(paramString.getJSONObject(i));
        if (localasby != null) {
          localConcurrentHashMap.put(Long.valueOf(localasby.jdField_a_of_type_Long), localasby);
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
  
  public boolean a(aclh paramaclh, long paramLong)
  {
    boolean bool = true;
    if (paramaclh.jdField_a_of_type_Aclj != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.d > 0L) && (paramaclh.jdField_a_of_type_Aclj.jdField_c_of_type_Long < this.d))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramaclh.jdField_a_of_type_Aclj.jdField_c_of_type_Long + " last_action_time:" + this.d);
        }
        return false;
      }
      this.jdField_a_of_type_Long = paramaclh.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramaclh.jdField_a_of_type_Aclj.jdField_b_of_type_Long;
      if (paramaclh.jdField_a_of_type_Aclj.jdField_c_of_type_Long > 0L) {
        this.d = paramaclh.jdField_a_of_type_Aclj.jdField_c_of_type_Long;
      }
      if (paramaclh.jdField_a_of_type_Aclj.d > 0L) {
        this.e = paramaclh.jdField_a_of_type_Aclj.d;
      }
      this.jdField_c_of_type_Long = paramaclh.jdField_a_of_type_Aclj.jdField_a_of_type_Int;
      this.jdField_f_of_type_Long = paramaclh.jdField_a_of_type_Aclj.jdField_f_of_type_Long;
      if (paramLong == 11002L) {
        this.g = paramaclh.jdField_a_of_type_Aclj.g;
      }
      if (this.jdField_f_of_type_Long != 2L) {
        this.g = 0L;
      }
      this.jdField_a_of_type_JavaLangString = paramaclh.jdField_a_of_type_Aclj.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramaclh.jdField_a_of_type_Aclj.jdField_c_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramaclh.jdField_a_of_type_Aclj.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramaclh.jdField_a_of_type_Aclj.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(asbz paramasbz)
  {
    this.jdField_a_of_type_Long = paramasbz.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramasbz.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramasbz.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramasbz.jdField_c_of_type_Long;
    this.d = paramasbz.d;
    this.jdField_f_of_type_Long = paramasbz.jdField_f_of_type_Long;
    this.g = paramasbz.g;
    this.jdField_a_of_type_JavaLangString = paramasbz.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramasbz.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramasbz.e;
    this.jdField_a_of_type_Boolean = paramasbz.jdField_a_of_type_Boolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asby
 * JD-Core Version:    0.7.0.1
 */