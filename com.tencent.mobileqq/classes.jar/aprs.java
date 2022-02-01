import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aprs
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d = aprr.a();
  
  public aprs()
  {
    this.jdField_a_of_type_JavaLangString = "android";
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("app", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("url", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("result", this.jdField_a_of_type_Int);
      localJSONObject.put("scene", this.jdField_b_of_type_Int);
      localJSONObject.put("type", this.jdField_c_of_type_Int);
      localJSONObject.put("ver", this.d);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("ArkApp.ArkSecurityReporter", 1, "ArkSafe.report exception=", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprs
 * JD-Core Version:    0.7.0.1
 */