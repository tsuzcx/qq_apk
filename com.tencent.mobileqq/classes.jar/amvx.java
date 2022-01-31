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

public class amvx
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
  
  public amvx()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static amvx a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    amvx localamvx;
    do
    {
      return localObject;
      localamvx = new amvx();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localamvx.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localamvx.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localamvx.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localamvx.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localamvx.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localamvx.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localamvx.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localamvx.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localamvx.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localamvx;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localamvx.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localamvx;
  }
  
  public static amvx a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localamvx = new amvx();
    for (;;)
    {
      try
      {
        localamvx.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localamvx.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localamvx.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localamvx.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localamvx.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localamvx.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localamvx.d = paramJSONObject.getInt("profession");
        localamvx.e = paramJSONObject.getInt("emotion");
        localamvx.f = paramJSONObject.getInt("listIdx");
        localamvx.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localamvx;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localamvx;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<amvx> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((amvx)paramList.next());
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
  
  public static JSONObject a(amvx paramamvx)
  {
    if (paramamvx == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramamvx.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramamvx.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramamvx.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramamvx.jdField_b_of_type_Int);
      localJSONObject.put("state", paramamvx.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramamvx.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramamvx.d);
      localJSONObject.put("emotion", paramamvx.e);
      localJSONObject.put("listIdx", paramamvx.f);
      localJSONObject.put("vip", paramamvx.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramamvx)
    {
      paramamvx.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<amvx> paramList, String paramString)
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
          amvx localamvx = a(paramString.getJSONObject(i));
          if (localamvx != null) {
            paramList.add(localamvx);
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
    if (((amvx)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amvx
 * JD-Core Version:    0.7.0.1
 */