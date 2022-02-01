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

public class arkv
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
  
  public arkv()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static arkv a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    arkv localarkv;
    do
    {
      return localObject;
      localarkv = new arkv();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localarkv.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localarkv.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localarkv.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localarkv.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localarkv.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localarkv.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localarkv.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localarkv.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localarkv.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localarkv;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localarkv.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localarkv;
  }
  
  public static arkv a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localarkv = new arkv();
    for (;;)
    {
      try
      {
        localarkv.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localarkv.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localarkv.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localarkv.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localarkv.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localarkv.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localarkv.d = paramJSONObject.getInt("profession");
        localarkv.e = paramJSONObject.getInt("emotion");
        localarkv.f = paramJSONObject.getInt("listIdx");
        localarkv.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localarkv;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localarkv;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<arkv> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((arkv)paramList.next());
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
  
  public static JSONObject a(arkv paramarkv)
  {
    if (paramarkv == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramarkv.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramarkv.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramarkv.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramarkv.jdField_b_of_type_Int);
      localJSONObject.put("state", paramarkv.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramarkv.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramarkv.d);
      localJSONObject.put("emotion", paramarkv.e);
      localJSONObject.put("listIdx", paramarkv.f);
      localJSONObject.put("vip", paramarkv.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramarkv)
    {
      paramarkv.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<arkv> paramList, String paramString)
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
          arkv localarkv = a(paramString.getJSONObject(i));
          if (localarkv != null) {
            paramList.add(localarkv);
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
    if (((arkv)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
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
 * Qualified Name:     arkv
 * JD-Core Version:    0.7.0.1
 */