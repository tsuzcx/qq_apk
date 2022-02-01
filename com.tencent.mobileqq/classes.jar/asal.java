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

public class asal
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
  
  public asal()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static asal a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    asal localasal;
    do
    {
      return localObject;
      localasal = new asal();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localasal.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localasal.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localasal.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localasal.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localasal.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localasal.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localasal.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localasal.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localasal.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localasal;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localasal.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localasal;
  }
  
  public static asal a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localasal = new asal();
    for (;;)
    {
      try
      {
        localasal.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localasal.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localasal.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localasal.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localasal.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localasal.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localasal.d = paramJSONObject.getInt("profession");
        localasal.e = paramJSONObject.getInt("emotion");
        localasal.f = paramJSONObject.getInt("listIdx");
        localasal.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localasal;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localasal;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<asal> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((asal)paramList.next());
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
  
  public static JSONObject a(asal paramasal)
  {
    if (paramasal == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramasal.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramasal.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramasal.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramasal.jdField_b_of_type_Int);
      localJSONObject.put("state", paramasal.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramasal.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramasal.d);
      localJSONObject.put("emotion", paramasal.e);
      localJSONObject.put("listIdx", paramasal.f);
      localJSONObject.put("vip", paramasal.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramasal)
    {
      paramasal.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<asal> paramList, String paramString)
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
          asal localasal = a(paramString.getJSONObject(i));
          if (localasal != null) {
            paramList.add(localasal);
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
    if (((asal)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
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
 * Qualified Name:     asal
 * JD-Core Version:    0.7.0.1
 */