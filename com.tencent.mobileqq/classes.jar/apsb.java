import android.text.TextUtils;
import org.json.JSONObject;

public class apsb
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public int g;
  
  public static apsb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    apsb localapsb = new apsb();
    try
    {
      paramString = new JSONObject(paramString);
      localapsb.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localapsb.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localapsb.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localapsb.jdField_a_of_type_JavaLangString = paramString.optString("strRecNick");
      localapsb.jdField_b_of_type_JavaLangString = paramString.optString("strRecUin");
      localapsb.jdField_c_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localapsb.jdField_d_of_type_JavaLangString = paramString.optString("strConfessorDesc");
      localapsb.jdField_e_of_type_JavaLangString = paramString.optString("strConfessorNick");
      localapsb.g = paramString.optInt("flag");
      localapsb.jdField_a_of_type_Long = paramString.optInt("confessTime");
      localapsb.jdField_d_of_type_Int = paramString.optInt("nConfessNum");
      localapsb.jdField_e_of_type_Int = paramString.optInt("nGetConfessSex");
      localapsb.f = paramString.optInt("nBizType");
      return localapsb;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("nTopicId", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("nBGType", this.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("nConfessorSex", this.jdField_c_of_type_Int);
      ((JSONObject)localObject).put("strRecNick", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("strRecUin", this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorUin", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorDesc", this.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorNick", this.jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("flag", this.g);
      ((JSONObject)localObject).put("confessTime", this.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("nConfessNum", this.jdField_d_of_type_Int);
      ((JSONObject)localObject).put("nGetConfessSex", this.jdField_e_of_type_Int);
      ((JSONObject)localObject).put("nBizType", this.f);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsb
 * JD-Core Version:    0.7.0.1
 */