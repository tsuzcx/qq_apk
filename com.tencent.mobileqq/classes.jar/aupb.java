import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aupb
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
  
  public aupb()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private static aupb a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    aupb localaupb = new aupb();
    localaupb.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localaupb.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localaupb.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localaupb.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localaupb.d = paramJSONObject.optLong("last_action_time");
    localaupb.e = paramJSONObject.optLong("last_change_time");
    localaupb.jdField_f_of_type_Long = paramJSONObject.optLong("icon_status");
    localaupb.g = paramJSONObject.optLong("icon_status_end_time");
    localaupb.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localaupb.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localaupb.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localaupb.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localaupb.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
    return localaupb;
  }
  
  public static String a(ConcurrentHashMap<Long, aupb> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((aupb)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, aupb> a(String paramString)
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
        aupb localaupb = a(paramString.getJSONObject(i));
        if (localaupb != null) {
          localConcurrentHashMap.put(Long.valueOf(localaupb.jdField_a_of_type_Long), localaupb);
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
  
  public boolean a(aeng paramaeng, long paramLong)
  {
    boolean bool = true;
    if (paramaeng.jdField_a_of_type_Aeni != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.d > 0L) && (paramaeng.jdField_a_of_type_Aeni.jdField_c_of_type_Long < this.d))
      {
        if (QLog.isColorLevel()) {
          QLog.e("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramaeng.jdField_a_of_type_Aeni.jdField_c_of_type_Long + " last_action_time:" + this.d);
        }
        return false;
      }
      this.jdField_a_of_type_Long = paramaeng.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramaeng.jdField_a_of_type_Aeni.jdField_b_of_type_Long;
      if (paramaeng.jdField_a_of_type_Aeni.jdField_c_of_type_Long > 0L) {
        this.d = paramaeng.jdField_a_of_type_Aeni.jdField_c_of_type_Long;
      }
      if (paramaeng.jdField_a_of_type_Aeni.d > 0L) {
        this.e = paramaeng.jdField_a_of_type_Aeni.d;
      }
      this.jdField_c_of_type_Long = paramaeng.jdField_a_of_type_Aeni.jdField_a_of_type_Int;
      this.jdField_f_of_type_Long = paramaeng.jdField_a_of_type_Aeni.jdField_f_of_type_Long;
      if (paramLong == 11002L) {
        this.g = paramaeng.jdField_a_of_type_Aeni.g;
      }
      if (this.jdField_f_of_type_Long != 2L) {
        this.g = 0L;
      }
      this.jdField_a_of_type_JavaLangString = paramaeng.jdField_a_of_type_Aeni.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramaeng.jdField_a_of_type_Aeni.jdField_c_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramaeng.jdField_a_of_type_Aeni.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramaeng.jdField_a_of_type_Aeni.jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(aupc paramaupc)
  {
    this.jdField_a_of_type_Long = paramaupc.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramaupc.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramaupc.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramaupc.jdField_c_of_type_Long;
    this.d = paramaupc.d;
    this.jdField_f_of_type_Long = paramaupc.jdField_f_of_type_Long;
    this.g = paramaupc.g;
    this.jdField_a_of_type_JavaLangString = paramaupc.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramaupc.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramaupc.e;
    this.jdField_a_of_type_Boolean = paramaupc.jdField_a_of_type_Boolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupb
 * JD-Core Version:    0.7.0.1
 */