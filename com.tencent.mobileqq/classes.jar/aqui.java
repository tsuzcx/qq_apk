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

public class aqui
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
  
  public aqui()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public static aqui a(appoint_define.StrangerInfo paramStrangerInfo)
  {
    Object localObject;
    if ((paramStrangerInfo == null) || (paramStrangerInfo.uint64_tinyid.get() == 0L)) {
      localObject = null;
    }
    aqui localaqui;
    do
    {
      return localObject;
      localaqui = new aqui();
      if (paramStrangerInfo.uint64_tinyid.has()) {
        localaqui.jdField_a_of_type_Long = paramStrangerInfo.uint64_tinyid.get();
      }
      if (paramStrangerInfo.uint32_age.has()) {
        localaqui.jdField_a_of_type_Int = paramStrangerInfo.uint32_age.get();
      }
      if (paramStrangerInfo.uint32_gender.has()) {
        localaqui.jdField_b_of_type_Int = paramStrangerInfo.uint32_gender.get();
      }
      if (paramStrangerInfo.bytes_nickname.has()) {
        localaqui.jdField_a_of_type_JavaLangString = paramStrangerInfo.bytes_nickname.get().toStringUtf8();
      }
      if (paramStrangerInfo.uint32_dating.has()) {
        localaqui.jdField_c_of_type_Int = paramStrangerInfo.uint32_dating.get();
      }
      if (paramStrangerInfo.uint32_list_idx.has()) {
        localaqui.f = paramStrangerInfo.uint32_list_idx.get();
      }
      if (paramStrangerInfo.str_constellation.has()) {
        localaqui.jdField_b_of_type_JavaLangString = paramStrangerInfo.str_constellation.get();
      }
      if (paramStrangerInfo.uint32_profession.has()) {
        localaqui.d = paramStrangerInfo.uint32_profession.get();
      }
      if (paramStrangerInfo.uint32_marriage.has()) {
        localaqui.e = paramStrangerInfo.uint32_marriage.get();
      }
      localObject = localaqui;
    } while (!paramStrangerInfo.str_vipinfo.has());
    localaqui.jdField_c_of_type_JavaLangString = paramStrangerInfo.str_vipinfo.get();
    return localaqui;
  }
  
  public static aqui a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    localaqui = new aqui();
    for (;;)
    {
      try
      {
        localaqui.jdField_a_of_type_Long = paramJSONObject.getLong("open_id");
        localaqui.jdField_a_of_type_JavaLangString = paramJSONObject.getString("nickname");
        localaqui.jdField_a_of_type_Int = paramJSONObject.getInt("age");
        localaqui.jdField_b_of_type_Int = paramJSONObject.getInt("gender");
        localaqui.jdField_c_of_type_Int = paramJSONObject.getInt("state");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = null;
        continue;
      }
      try
      {
        localaqui.jdField_b_of_type_JavaLangString = paramJSONObject.getString("constellation");
        localaqui.d = paramJSONObject.getInt("profession");
        localaqui.e = paramJSONObject.getInt("emotion");
        localaqui.f = paramJSONObject.getInt("listIdx");
        localaqui.jdField_c_of_type_JavaLangString = paramJSONObject.getString("vip");
        paramJSONObject = localaqui;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        paramJSONObject = localaqui;
      }
    }
    return paramJSONObject;
  }
  
  public static String a(List<aqui> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      JSONObject localJSONObject = a((aqui)paramList.next());
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
  
  public static JSONObject a(aqui paramaqui)
  {
    if (paramaqui == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("open_id", paramaqui.jdField_a_of_type_Long);
      localJSONObject.put("nickname", paramaqui.jdField_a_of_type_JavaLangString);
      localJSONObject.put("age", paramaqui.jdField_a_of_type_Int);
      localJSONObject.put("gender", paramaqui.jdField_b_of_type_Int);
      localJSONObject.put("state", paramaqui.jdField_c_of_type_Int);
      localJSONObject.put("constellation", paramaqui.jdField_b_of_type_JavaLangString);
      localJSONObject.put("profession", paramaqui.d);
      localJSONObject.put("emotion", paramaqui.e);
      localJSONObject.put("listIdx", paramaqui.f);
      localJSONObject.put("vip", paramaqui.jdField_c_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException paramaqui)
    {
      paramaqui.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<aqui> paramList, String paramString)
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
          aqui localaqui = a(paramString.getJSONObject(i));
          if (localaqui != null) {
            paramList.add(localaqui);
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
    if (((aqui)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long) {}
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
 * Qualified Name:     aqui
 * JD-Core Version:    0.7.0.1
 */