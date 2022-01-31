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

public class anmf
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
  
  public anmf()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static anmf a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    anmf localanmf;
    do
    {
      return localObject;
      localanmf = new anmf();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localanmf.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localanmf.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localanmf.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localanmf.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localanmf.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localanmf.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localanmf.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localanmf.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localanmf.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localanmf;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localanmf.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localanmf;
  }
  
  public static anmf a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localanmf = new anmf();
    for (;;)
    {
      try
      {
        localanmf.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localanmf.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localanmf.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localanmf.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localanmf.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localanmf.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localanmf.d = paramJSONObject.getInt("profession");
        localanmf.e = paramJSONObject.getInt("emotion");
        localanmf.f = paramJSONObject.getInt("listIdx");
        localanmf.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localanmf;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localanmf;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<anmf> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((anmf)paramList.next());
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
  
  public static JSONObject a(anmf paramanmf)
  {
    if (paramanmf == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramanmf.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramanmf.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramanmf.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramanmf.jdField_b_of_type_Int);
      localJSONObject.put("state", paramanmf.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramanmf.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramanmf.d);
      localJSONObject.put("emotion", paramanmf.e);
      localJSONObject.put("listIdx", paramanmf.f);
      localJSONObject.put("vip", paramanmf.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramanmf)
    {
      paramanmf.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<anmf> paramList, String paramString)
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
          anmf localanmf = a(paramString.getJSONObject(i));
          if (localanmf != null) {
            paramList.add(localanmf);
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
    if (((anmf)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
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
 * Qualified Name:     anmf
 * JD-Core Version:    0.7.0.1
 */