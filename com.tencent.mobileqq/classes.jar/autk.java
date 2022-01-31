import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class autk
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
  
  public autk()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private static autk a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    autk localautk = new autk();
    localautk.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localautk.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localautk.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localautk.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localautk.d = paramJSONObject.optLong("last_action_time");
    localautk.e = paramJSONObject.optLong("last_change_time");
    localautk.jdField_f_of_type_Long = paramJSONObject.optLong("icon_status");
    localautk.g = paramJSONObject.optLong("icon_status_end_time");
    localautk.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localautk.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localautk.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localautk.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localautk.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
    return localautk;
  }
  
  public static String a(ConcurrentHashMap<Long, autk> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((autk)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, autk> a(String paramString)
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
        autk localautk = a(paramString.getJSONObject(i));
        if (localautk != null) {
          localConcurrentHashMap.put(Long.valueOf(localautk.jdField_a_of_type_Long), localautk);
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
  
  public boolean a(aerv paramaerv, long paramLong)
  {
    boolean bool = true;
    if (paramaerv.jdField_a_of_type_Aerx != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.d > 0L) && (paramaerv.jdField_a_of_type_Aerx.jdField_c_of_type_Long < this.d))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramaerv.jdField_a_of_type_Aerx.jdField_c_of_type_Long + " last_action_time:" + this.d);
        }
        return false;
      }
      this.jdField_a_of_type_Long = paramaerv.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramaerv.jdField_a_of_type_Aerx.jdField_b_of_type_Long;
      if (paramaerv.jdField_a_of_type_Aerx.jdField_c_of_type_Long > 0L) {
        this.d = paramaerv.jdField_a_of_type_Aerx.jdField_c_of_type_Long;
      }
      if (paramaerv.jdField_a_of_type_Aerx.d > 0L) {
        this.e = paramaerv.jdField_a_of_type_Aerx.d;
      }
      this.jdField_c_of_type_Long = paramaerv.jdField_a_of_type_Aerx.jdField_a_of_type_Int;
      this.jdField_f_of_type_Long = paramaerv.jdField_a_of_type_Aerx.jdField_f_of_type_Long;
      if (paramLong == 11002L) {
        this.g = paramaerv.jdField_a_of_type_Aerx.g;
      }
      if (this.jdField_f_of_type_Long != 2L) {
        this.g = 0L;
      }
      this.jdField_a_of_type_JavaLangString = paramaerv.jdField_a_of_type_Aerx.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramaerv.jdField_a_of_type_Aerx.jdField_c_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramaerv.jdField_a_of_type_Aerx.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramaerv.jdField_a_of_type_Aerx.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(autl paramautl)
  {
    this.jdField_a_of_type_Long = paramautl.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramautl.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramautl.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramautl.jdField_c_of_type_Long;
    this.d = paramautl.d;
    this.jdField_f_of_type_Long = paramautl.jdField_f_of_type_Long;
    this.g = paramautl.g;
    this.jdField_a_of_type_JavaLangString = paramautl.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramautl.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramautl.e;
    this.jdField_a_of_type_Boolean = paramautl.jdField_a_of_type_Boolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     autk
 * JD-Core Version:    0.7.0.1
 */