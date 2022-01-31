import android.text.TextUtils;
import org.json.JSONObject;

public class amno
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
  
  public static amno a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    amno localamno = new amno();
    try
    {
      paramString = new JSONObject(paramString);
      localamno.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localamno.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localamno.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localamno.jdField_a_of_type_JavaLangString = paramString.optString("strRecNick");
      localamno.jdField_b_of_type_JavaLangString = paramString.optString("strRecUin");
      localamno.jdField_c_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localamno.jdField_d_of_type_JavaLangString = paramString.optString("strConfessorDesc");
      localamno.jdField_e_of_type_JavaLangString = paramString.optString("strConfessorNick");
      localamno.g = paramString.optInt("flag");
      localamno.jdField_a_of_type_Long = paramString.optInt("confessTime");
      localamno.jdField_d_of_type_Int = paramString.optInt("nConfessNum");
      localamno.jdField_e_of_type_Int = paramString.optInt("nGetConfessSex");
      localamno.f = paramString.optInt("nBizType");
      return localamno;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amno
 * JD-Core Version:    0.7.0.1
 */