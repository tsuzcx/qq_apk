import android.text.TextUtils;
import org.json.JSONObject;

public class aoiv
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
  
  public static aoiv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aoiv localaoiv = new aoiv();
    try
    {
      paramString = new JSONObject(paramString);
      localaoiv.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localaoiv.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localaoiv.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localaoiv.jdField_a_of_type_JavaLangString = paramString.optString("strRecNick");
      localaoiv.jdField_b_of_type_JavaLangString = paramString.optString("strRecUin");
      localaoiv.jdField_c_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localaoiv.jdField_d_of_type_JavaLangString = paramString.optString("strConfessorDesc");
      localaoiv.jdField_e_of_type_JavaLangString = paramString.optString("strConfessorNick");
      localaoiv.g = paramString.optInt("flag");
      localaoiv.jdField_a_of_type_Long = paramString.optInt("confessTime");
      localaoiv.jdField_d_of_type_Int = paramString.optInt("nConfessNum");
      localaoiv.jdField_e_of_type_Int = paramString.optInt("nGetConfessSex");
      localaoiv.f = paramString.optInt("nBizType");
      return localaoiv;
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
 * Qualified Name:     aoiv
 * JD-Core Version:    0.7.0.1
 */