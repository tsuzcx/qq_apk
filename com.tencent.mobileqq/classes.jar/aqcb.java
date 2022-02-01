import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqcb
{
  public int a;
  public String a;
  public String b = "";
  public String c = "";
  public String d = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
  
  public aqcb()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aqcb a(String paramString)
  {
    aqcb localaqcb = new aqcb();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localaqcb.jdField_a_of_type_JavaLangString = localJSONObject.optString("kQQPASearchDiscoverPageUrl");
      localaqcb.b = localJSONObject.optString("kQQPASearchListTitleIconUrl");
      localaqcb.c = localJSONObject.optString("kQQPAClickAssociationalWordWebUrl");
      localaqcb.jdField_a_of_type_Int = localJSONObject.optInt("kQQPAClickAssociationalWordToWebSearch", 1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, new Object[] { "loadConfig292Data json = ", paramString });
      }
      localaqcb.d = localJSONObject.optString("kQQPASearchJumpUrl", "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySearchJumpurlConfBean", 2, "loadConfig292Data(). readinjoy_search_jump_url=" + localaqcb.d + ", discoveryPageUrl = " + localaqcb.jdField_a_of_type_JavaLangString);
      }
    }
    catch (Exception paramString)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInjoySearchJumpurlConfBean", 2, "loadPublicAccountCenterUrlConfig error", paramString);
        }
        localaqcb.d = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
      } while (!QLog.isColorLevel());
      QLog.d("ReadInjoySearchJumpurlConfBean", 2, "loadConfig292Data(). use the default url. exception=" + paramString.getStackTrace());
    }
    return localaqcb;
    return localaqcb;
  }
  
  public String toString()
  {
    return "kQQPASearchDiscoverPageUrl = " + this.jdField_a_of_type_JavaLangString + "kQQPASearchListTitleIconUrl = " + this.b + "kQQPAClickAssociationalWordWebUrl = " + this.c + "kQQPAClickAssociationalWordToWebSearch = " + this.jdField_a_of_type_Int + "kQQPASearchJumpUrl = " + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqcb
 * JD-Core Version:    0.7.0.1
 */