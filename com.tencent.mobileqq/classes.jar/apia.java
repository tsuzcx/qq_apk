import android.text.TextUtils;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apia
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public int e;
  public int f;
  
  public apia()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static apia a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    apia localapia;
    do
    {
      return localObject;
      localapia = new apia();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localapia.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localapia.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localapia.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localapia.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localapia.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localapia.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localapia.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localapia.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localapia.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localapia;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localapia.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localapia;
  }
  
  public static apia a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localapia = new apia();
    for (;;)
    {
      try
      {
        localapia.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localapia.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localapia.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localapia.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localapia.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localapia.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localapia.d = paramJSONObject.getInt("profession");
        localapia.e = paramJSONObject.getInt("emotion");
        localapia.f = paramJSONObject.getInt("listIdx");
        localapia.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localapia;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localapia;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<apia> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((apia)paramList.next());
      if (localJSONObject == null) {
        break label83;
      }
      localJSONArray.put(localJSONObject);
      i += 1;
    }
    label83:
    for (;;)
    {
      if (i >= 20) {
        return localJSONArray.toString();
      }
      break;
    }
  }
  
  public static JSONObject a(apia paramapia)
  {
    if (paramapia == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramapia.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramapia.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramapia.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramapia.jdField_b_of_type_Int);
      localJSONObject.put("state", paramapia.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramapia.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramapia.d);
      localJSONObject.put("emotion", paramapia.e);
      localJSONObject.put("listIdx", paramapia.f);
      localJSONObject.put("vip", paramapia.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramapia)
    {
      paramapia.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<apia> paramList, String paramString)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          apia localapia = a(paramString.getJSONObject(i));
          if (localapia != null) {
            paramList.add(localapia);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    if (((apia)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_Long).append(",").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_Int).append(",").append(this.jdField_b_of_type_Int).append(",").append(this.jdField_c_of_type_Int).append(",").append(this.jdField_b_of_type_JavaLangString).append(",").append(this.d).append(",").append(this.e).append(",").append(this.f).append(",").append(this.jdField_c_of_type_JavaLangString).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apia
 * JD-Core Version:    0.7.0.1
 */