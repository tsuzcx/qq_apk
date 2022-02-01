import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arae
{
  public int a;
  public String a;
  public JSONObject a;
  
  public arae()
  {
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
  }
  
  public static arae a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      arae localarae = new arae();
      localarae.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString).optJSONObject("loverAIOPush");
      return localarae;
    }
    catch (Exception paramString)
    {
      QLog.e("C2CLovePushGrayConfBean", 2, "C2CLovePushGrayConfBean onParsed erro " + paramString.toString());
    }
    return null;
  }
  
  public arae b(String paramString)
  {
    arae localarae = new arae();
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        paramString = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(paramString);
        if (paramString != null)
        {
          localarae.jdField_a_of_type_Int = paramString.optInt("linkType", 1);
          localarae.jdField_a_of_type_JavaLangString = paramString.optString("linkURL", "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1");
          return localarae;
        }
        localarae.jdField_a_of_type_Int = 1;
        localarae.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
        return localarae;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CLovePushGrayProcessor", 2, "getC2CLovePushGrayConfBean Exception :", paramString);
      }
      localarae.jdField_a_of_type_Int = 1;
      localarae.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
    }
    return localarae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arae
 * JD-Core Version:    0.7.0.1
 */