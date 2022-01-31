import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asyc
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
  
  public asyc()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private static asyc a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    asyc localasyc = new asyc();
    localasyc.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localasyc.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localasyc.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localasyc.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localasyc.d = paramJSONObject.optLong("last_action_time");
    localasyc.e = paramJSONObject.optLong("last_change_time");
    localasyc.jdField_f_of_type_Long = paramJSONObject.optLong("icon_status");
    localasyc.g = paramJSONObject.optLong("icon_status_end_time");
    localasyc.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localasyc.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localasyc.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localasyc.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localasyc.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
    return localasyc;
  }
  
  public static String a(ConcurrentHashMap<Long, asyc> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((asyc)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, asyc> a(String paramString)
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
        asyc localasyc = a(paramString.getJSONObject(i));
        if (localasyc != null) {
          localConcurrentHashMap.put(Long.valueOf(localasyc.jdField_a_of_type_Long), localasyc);
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
  
  public boolean a(acwa paramacwa, long paramLong)
  {
    boolean bool = true;
    if (paramacwa.jdField_a_of_type_Acwc != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.d > 0L) && (paramacwa.jdField_a_of_type_Acwc.jdField_c_of_type_Long < this.d))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramacwa.jdField_a_of_type_Acwc.jdField_c_of_type_Long + " last_action_time:" + this.d);
        }
        return false;
      }
      this.jdField_a_of_type_Long = paramacwa.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramacwa.jdField_a_of_type_Acwc.jdField_b_of_type_Long;
      if (paramacwa.jdField_a_of_type_Acwc.jdField_c_of_type_Long > 0L) {
        this.d = paramacwa.jdField_a_of_type_Acwc.jdField_c_of_type_Long;
      }
      if (paramacwa.jdField_a_of_type_Acwc.d > 0L) {
        this.e = paramacwa.jdField_a_of_type_Acwc.d;
      }
      this.jdField_c_of_type_Long = paramacwa.jdField_a_of_type_Acwc.jdField_a_of_type_Int;
      this.jdField_f_of_type_Long = paramacwa.jdField_a_of_type_Acwc.jdField_f_of_type_Long;
      if (paramLong == 11002L) {
        this.g = paramacwa.jdField_a_of_type_Acwc.g;
      }
      if (this.jdField_f_of_type_Long != 2L) {
        this.g = 0L;
      }
      this.jdField_a_of_type_JavaLangString = paramacwa.jdField_a_of_type_Acwc.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramacwa.jdField_a_of_type_Acwc.jdField_c_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramacwa.jdField_a_of_type_Acwc.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramacwa.jdField_a_of_type_Acwc.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(asyd paramasyd)
  {
    this.jdField_a_of_type_Long = paramasyd.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramasyd.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramasyd.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramasyd.jdField_c_of_type_Long;
    this.d = paramasyd.d;
    this.jdField_f_of_type_Long = paramasyd.jdField_f_of_type_Long;
    this.g = paramasyd.g;
    this.jdField_a_of_type_JavaLangString = paramasyd.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramasyd.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramasyd.e;
    this.jdField_a_of_type_Boolean = paramasyd.jdField_a_of_type_Boolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asyc
 * JD-Core Version:    0.7.0.1
 */