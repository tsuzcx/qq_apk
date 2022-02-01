import android.text.TextUtils;
import org.json.JSONObject;

public class arqg
{
  public String a;
  public String[] a;
  public String b;
  public String[] b;
  
  public arqg(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("words");
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_ArrayOfJavaLangString = str.split("\\/");
    }
    str = paramJSONObject.optString("overlay");
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_ArrayOfJavaLangString = str.split("\\/");
    }
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("optString");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("aioTips");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arqg
 * JD-Core Version:    0.7.0.1
 */