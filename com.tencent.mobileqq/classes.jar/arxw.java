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

public class arxw
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
  
  public arxw()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static arxw a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    arxw localarxw;
    do
    {
      return localObject;
      localarxw = new arxw();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localarxw.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localarxw.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localarxw.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localarxw.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localarxw.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localarxw.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localarxw.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localarxw.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localarxw.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localarxw;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localarxw.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localarxw;
  }
  
  public static arxw a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localarxw = new arxw();
    for (;;)
    {
      try
      {
        localarxw.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localarxw.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localarxw.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localarxw.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localarxw.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localarxw.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localarxw.d = paramJSONObject.getInt("profession");
        localarxw.e = paramJSONObject.getInt("emotion");
        localarxw.f = paramJSONObject.getInt("listIdx");
        localarxw.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localarxw;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localarxw;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<arxw> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((arxw)paramList.next());
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
  
  public static JSONObject a(arxw paramarxw)
  {
    if (paramarxw == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramarxw.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramarxw.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramarxw.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramarxw.jdField_b_of_type_Int);
      localJSONObject.put("state", paramarxw.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramarxw.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramarxw.d);
      localJSONObject.put("emotion", paramarxw.e);
      localJSONObject.put("listIdx", paramarxw.f);
      localJSONObject.put("vip", paramarxw.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramarxw)
    {
      paramarxw.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<arxw> paramList, String paramString)
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
          arxw localarxw = a(paramString.getJSONObject(i));
          if (localarxw != null) {
            paramList.add(localarxw);
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
    if (((arxw)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
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
 * Qualified Name:     arxw
 * JD-Core Version:    0.7.0.1
 */