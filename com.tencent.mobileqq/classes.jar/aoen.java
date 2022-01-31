import android.text.TextUtils;
import org.json.JSONObject;

public class aoen
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  
  public static aoen a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aoen localaoen = new aoen();
    try
    {
      paramString = new JSONObject(paramString);
      localaoen.jdField_a_of_type_JavaLangString = paramString.optString("strGroupUin");
      localaoen.jdField_b_of_type_JavaLangString = paramString.optString("strSendUin");
      localaoen.jdField_a_of_type_Int = paramString.optInt("nTopicId");
      localaoen.jdField_b_of_type_Int = paramString.optInt("nBGType");
      localaoen.jdField_c_of_type_Int = paramString.optInt("nConfessorSex");
      localaoen.jdField_c_of_type_JavaLangString = paramString.optString("strRecNick");
      localaoen.jdField_d_of_type_Int = paramString.optInt("nRecNickType");
      localaoen.jdField_d_of_type_JavaLangString = paramString.optString("strRecUin");
      localaoen.jdField_e_of_type_JavaLangString = paramString.optString("strConfessorUin");
      localaoen.f = paramString.optString("strConfessorDesc");
      localaoen.g = paramString.optString("strConfessorNick");
      localaoen.jdField_e_of_type_Int = paramString.optInt("flag");
      localaoen.jdField_a_of_type_Long = paramString.optInt("confessTime");
      localaoen.jdField_a_of_type_Boolean = paramString.optBoolean("isRandomShmsgseq");
      return localaoen;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("strGroupUin", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("strSendUin", this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("nTopicId", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("nBGType", this.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("nConfessorSex", this.jdField_c_of_type_Int);
      ((JSONObject)localObject).put("strRecNick", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject).put("nRecNickType", this.jdField_d_of_type_Int);
      ((JSONObject)localObject).put("strRecUin", this.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorUin", this.jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("strConfessorDesc", this.f);
      ((JSONObject)localObject).put("strConfessorNick", this.g);
      ((JSONObject)localObject).put("flag", this.jdField_e_of_type_Int);
      ((JSONObject)localObject).put("confessTime", this.jdField_a_of_type_Long);
      ((JSONObject)localObject).put("isRandomShmsgseq", this.jdField_a_of_type_Boolean);
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
 * Qualified Name:     aoen
 * JD-Core Version:    0.7.0.1
 */