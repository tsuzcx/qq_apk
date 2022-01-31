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

public class apdr
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
  
  public apdr()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static apdr a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    apdr localapdr;
    do
    {
      return localObject;
      localapdr = new apdr();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localapdr.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localapdr.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localapdr.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localapdr.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localapdr.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localapdr.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localapdr.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localapdr.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localapdr.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localapdr;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localapdr.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localapdr;
  }
  
  public static apdr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localapdr = new apdr();
    for (;;)
    {
      try
      {
        localapdr.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localapdr.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localapdr.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localapdr.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localapdr.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localapdr.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localapdr.d = paramJSONObject.getInt("profession");
        localapdr.e = paramJSONObject.getInt("emotion");
        localapdr.f = paramJSONObject.getInt("listIdx");
        localapdr.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localapdr;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localapdr;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<apdr> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((apdr)paramList.next());
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
  
  public static JSONObject a(apdr paramapdr)
  {
    if (paramapdr == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramapdr.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramapdr.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramapdr.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramapdr.jdField_b_of_type_Int);
      localJSONObject.put("state", paramapdr.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramapdr.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramapdr.d);
      localJSONObject.put("emotion", paramapdr.e);
      localJSONObject.put("listIdx", paramapdr.f);
      localJSONObject.put("vip", paramapdr.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramapdr)
    {
      paramapdr.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<apdr> paramList, String paramString)
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
          apdr localapdr = a(paramString.getJSONObject(i));
          if (localapdr != null) {
            paramList.add(localapdr);
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
    if (((apdr)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
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
 * Qualified Name:     apdr
 * JD-Core Version:    0.7.0.1
 */