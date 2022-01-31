import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ancf
{
  public String a;
  public boolean a;
  public String[] a;
  public String b;
  public String c;
  
  public ancf(JSONObject paramJSONObject)
  {
    try
    {
      String str = paramJSONObject.getString("extension");
      if (str != null) {
        this.jdField_a_of_type_ArrayOfJavaLangString = str.split("\\|");
      }
      this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("text");
      this.b = paramJSONObject.getString("tShow");
      this.c = paramJSONObject.getString("tPress");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      bool1 = bool2;
      if (paramString != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (paramString.equals(this.jdField_a_of_type_ArrayOfJavaLangString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancf
 * JD-Core Version:    0.7.0.1
 */