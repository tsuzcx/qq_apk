import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axmt
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
  
  public axmt()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  private static axmt a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    axmt localaxmt = new axmt();
    localaxmt.jdField_a_of_type_Long = paramJSONObject.optLong("type");
    localaxmt.jdField_b_of_type_Long = paramJSONObject.optLong("level");
    localaxmt.jdField_a_of_type_Float = ((float)paramJSONObject.optDouble("count", 0.0D));
    localaxmt.jdField_c_of_type_Long = paramJSONObject.optLong("continue_days");
    localaxmt.jdField_d_of_type_Long = paramJSONObject.optLong("last_action_time");
    localaxmt.e = paramJSONObject.optLong("last_change_time");
    localaxmt.f = paramJSONObject.optLong("icon_status");
    localaxmt.jdField_g_of_type_Long = paramJSONObject.optLong("icon_status_end_time");
    localaxmt.h = paramJSONObject.optLong("sub_level");
    localaxmt.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("hasRemindInContact");
    localaxmt.jdField_a_of_type_JavaLangString = paramJSONObject.optString("icon_static_url");
    localaxmt.jdField_b_of_type_JavaLangString = paramJSONObject.optString("icon_dynamic_url");
    localaxmt.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_name");
    localaxmt.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("user_close_flag");
    return localaxmt;
  }
  
  public static String a(ConcurrentHashMap<Long, axmt> paramConcurrentHashMap)
  {
    JSONArray localJSONArray = new JSONArray();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramConcurrentHashMap.next();
      if (localEntry.getValue() != null) {
        localJSONArray.put(((axmt)localEntry.getValue()).a());
      }
    }
    if (localJSONArray.length() > 0) {
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static ConcurrentHashMap<Long, axmt> a(String paramString)
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
        axmt localaxmt = a(paramString.getJSONObject(j));
        if (localaxmt != null) {
          localConcurrentHashMap.put(Long.valueOf(localaxmt.jdField_a_of_type_Long), localaxmt);
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
  
  public boolean a(afsi paramafsi, long paramLong)
  {
    boolean bool2 = true;
    if (paramafsi.jdField_a_of_type_Afsk != null)
    {
      if (((paramLong == 11002L) || (paramLong == 11001L)) && (this.jdField_d_of_type_Long > 0L) && (paramafsi.jdField_a_of_type_Afsk.jdField_c_of_type_Long < this.jdField_d_of_type_Long))
      {
        QLog.i("MutualMarkInfo", 1, "ignore mergeFrom now.last_action_time:" + paramafsi.jdField_a_of_type_Afsk.jdField_c_of_type_Long + " last_action_time:" + this.jdField_d_of_type_Long);
        return false;
      }
      this.jdField_a_of_type_Long = paramafsi.jdField_a_of_type_Int;
      this.jdField_b_of_type_Long = paramafsi.jdField_a_of_type_Afsk.jdField_b_of_type_Long;
      if (paramafsi.jdField_a_of_type_Afsk.jdField_c_of_type_Long > 0L) {
        this.jdField_d_of_type_Long = paramafsi.jdField_a_of_type_Afsk.jdField_c_of_type_Long;
      }
      if (paramafsi.jdField_a_of_type_Afsk.jdField_d_of_type_Long > 0L) {
        this.e = paramafsi.jdField_a_of_type_Afsk.jdField_d_of_type_Long;
      }
      this.jdField_c_of_type_Long = paramafsi.jdField_a_of_type_Afsk.jdField_a_of_type_Int;
      this.f = paramafsi.jdField_a_of_type_Afsk.f;
      if (paramLong == 11002L) {
        this.jdField_g_of_type_Long = paramafsi.jdField_a_of_type_Afsk.jdField_g_of_type_Long;
      }
      if (this.f != 2L) {
        this.jdField_g_of_type_Long = 0L;
      }
      this.h = paramafsi.jdField_a_of_type_Afsk.h;
      this.jdField_a_of_type_JavaLangString = paramafsi.jdField_a_of_type_Afsk.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramafsi.jdField_a_of_type_Afsk.jdField_d_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = paramafsi.jdField_a_of_type_Afsk.jdField_g_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = paramafsi.jdField_a_of_type_Afsk.jdField_a_of_type_Boolean;
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
  
  public boolean a(axmu paramaxmu)
  {
    this.jdField_a_of_type_Long = paramaxmu.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramaxmu.jdField_b_of_type_Long;
    this.jdField_a_of_type_Float = paramaxmu.jdField_a_of_type_Float;
    this.jdField_c_of_type_Long = paramaxmu.jdField_c_of_type_Long;
    this.jdField_d_of_type_Long = paramaxmu.jdField_d_of_type_Long;
    this.f = paramaxmu.f;
    this.jdField_g_of_type_Long = paramaxmu.jdField_g_of_type_Long;
    this.h = paramaxmu.h;
    this.jdField_a_of_type_JavaLangString = paramaxmu.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramaxmu.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramaxmu.e;
    this.jdField_a_of_type_Boolean = paramaxmu.jdField_a_of_type_Boolean;
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
 * Qualified Name:     axmt
 * JD-Core Version:    0.7.0.1
 */