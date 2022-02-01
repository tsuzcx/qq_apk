import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axtk
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
  public long i;
  
  public axtk()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private static axtk a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    axtk localaxtk = new axtk();
    localaxtk.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localaxtk.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localaxtk.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localaxtk.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localaxtk.jdField_d_of_type_Long = paramJSONObject.optLong("last_action_time");
    localaxtk.e = paramJSONObject.optLong("last_change_time");
    localaxtk.f = paramJSONObject.optLong("icon_status");
    localaxtk.jdField_g_of_type_Long = paramJSONObject.optLong("icon_status_end_time");
    localaxtk.h = paramJSONObject.optLong("sub_level");
    localaxtk.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localaxtk.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localaxtk.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localaxtk.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localaxtk.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
    return localaxtk;
  }
  
  public static String a(ConcurrentHashMap<Long, axtk> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((axtk)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, axtk> a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkInfo", 1, "parseFrom json_str:" + paramString);
    }
    localConcurrentHashMap = new ConcurrentHashMap();
    try
    {
      paramString = new JSONArray(paramString);
      int j = 0;
      while (j < paramString.length())
      {
        axtk localaxtk = a(paramString.getJSONObject(j));
        if (localaxtk != null) {
          localConcurrentHashMap.put(Long.valueOf(localaxtk.jdField_a_of_type_Long), localaxtk);
        }
        j += 1;
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
      localJSONObject.put("last_action_time", this.jdField_d_of_type_Long);
      localJSONObject.put("last_change_time", this.e);
      localJSONObject.put("icon_status", this.f);
      localJSONObject.put("icon_status_end_time", this.jdField_g_of_type_Long);
      localJSONObject.put("sub_level", this.h);
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
  
  public boolean a(agia paramagia, long paramLong)
  {
    boolean bool2 = true;
    if (paramagia.jdField_a_of_type_Agic != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.jdField_d_of_type_Long > 0L) && (paramagia.jdField_a_of_type_Agic.jdField_c_of_type_Long < this.jdField_d_of_type_Long))
      {
        QLog.i("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramagia.jdField_a_of_type_Agic.jdField_c_of_type_Long + " last_action_time:" + this.jdField_d_of_type_Long);
        return false;
      }
      this.jdField_a_of_type_Long = paramagia.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramagia.jdField_a_of_type_Agic.jdField_b_of_type_Long;
      if (paramagia.jdField_a_of_type_Agic.jdField_c_of_type_Long > 0L) {
        this.jdField_d_of_type_Long = paramagia.jdField_a_of_type_Agic.jdField_c_of_type_Long;
      }
      if (paramagia.jdField_a_of_type_Agic.jdField_d_of_type_Long > 0L) {
        this.e = paramagia.jdField_a_of_type_Agic.jdField_d_of_type_Long;
      }
      this.jdField_c_of_type_Long = paramagia.jdField_a_of_type_Agic.jdField_a_of_type_Int;
      this.f = paramagia.jdField_a_of_type_Agic.f;
      if (paramLong == 11002L) {
        this.jdField_g_of_type_Long = paramagia.jdField_a_of_type_Agic.jdField_g_of_type_Long;
      }
      if (this.f != 2L) {
        this.jdField_g_of_type_Long = 0L;
      }
      this.h = paramagia.jdField_a_of_type_Agic.h;
      this.jdField_a_of_type_JavaLangString = paramagia.jdField_a_of_type_Agic.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramagia.jdField_a_of_type_Agic.jdField_d_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramagia.jdField_a_of_type_Agic.jdField_g_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramagia.jdField_a_of_type_Agic.jdField_a_of_type_Boolean;
      bool1 = bool2;
      if (this.jdField_a_of_type_Long == 17L)
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_Long > 0L)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            QLog.i("MutualMarkInfo", 1, "mergeFrom push info resource invalid: " + this);
          }
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean a(axtl paramaxtl)
  {
    this.jdField_a_of_type_Long = paramaxtl.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramaxtl.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramaxtl.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramaxtl.jdField_c_of_type_Long;
    this.jdField_d_of_type_Long = paramaxtl.jdField_d_of_type_Long;
    this.f = paramaxtl.f;
    this.jdField_g_of_type_Long = paramaxtl.jdField_g_of_type_Long;
    this.h = paramaxtl.h;
    this.jdField_a_of_type_JavaLangString = paramaxtl.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramaxtl.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramaxtl.e;
    this.jdField_a_of_type_Boolean = paramaxtl.jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_Long == 17L) && (this.jdField_b_of_type_Long > 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      QLog.i("MutualMarkInfo", 1, "mergeFrom pull info resource invalid: " + this);
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkInfo{");
    localStringBuilder.append("type=").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", level=").append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", count=").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", continue_days=").append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", last_action_time=").append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", last_change_time=").append(this.e);
    localStringBuilder.append(", icon_status=").append(this.f);
    localStringBuilder.append(", icon_status_end_time=").append(this.jdField_g_of_type_Long);
    localStringBuilder.append(", sub_level=").append(this.h);
    localStringBuilder.append(", hasRemindInContact=").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", remindAnimStartTime=").append(this.i);
    localStringBuilder.append(", icon_static_url='").append(this.jdField_a_of_type_JavaLangString).append("'");
    localStringBuilder.append(", icon_dynamic_url='").append(this.jdField_b_of_type_JavaLangString).append("'");
    localStringBuilder.append(", icon_name='").append(this.jdField_c_of_type_JavaLangString).append("'");
    localStringBuilder.append(", user_close_flag=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtk
 * JD-Core Version:    0.7.0.1
 */