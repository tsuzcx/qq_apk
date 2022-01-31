import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amrw
{
  public int a;
  public String a;
  public JSONObject a;
  
  public amrw()
  {
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
  }
  
  public static amrw a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      amrw localamrw = new amrw();
      localamrw.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString).optJSONObject("loverAIOPush");
      return localamrw;
    }
    catch (Exception paramString)
    {
      QLog.e("C2CLovePushGrayConfBean", 2, "C2CLovePushGrayConfBean onParsed erro " + paramString.toString());
    }
    return null;
  }
  
  public amrw b(String paramString)
  {
    amrw localamrw = new amrw();
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        paramString = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(paramString);
        if (paramString != null)
        {
          localamrw.jdField_a_of_type_Int = paramString.optInt("linkType", 1);
          localamrw.jdField_a_of_type_JavaLangString = paramString.optString("linkURL", "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1");
          return localamrw;
        }
        localamrw.jdField_a_of_type_Int = 1;
        localamrw.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
        return localamrw;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CLovePushGrayProcessor", 2, "getC2CLovePushGrayConfBean Exception :", paramString);
      }
      localamrw.jdField_a_of_type_Int = 1;
      localamrw.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
    }
    return localamrw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrw
 * JD-Core Version:    0.7.0.1
 */