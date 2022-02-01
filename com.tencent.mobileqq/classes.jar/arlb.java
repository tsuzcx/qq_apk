import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arlb
{
  public String a;
  public boolean a;
  
  public arlb()
  {
    this.jdField_a_of_type_JavaLangString = "https://club.vip.qq.com/qid/mine?_wv=16777218&_proxy=1";
  }
  
  public static arlb a(String paramString)
  {
    arlb localarlb = new arlb();
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("QVipQidConfig", 2, "QID_LOG,configContent,empty");
      }
    }
    do
    {
      return localarlb;
      try
      {
        paramString = new JSONObject(paramString);
        localarlb.jdField_a_of_type_Boolean = paramString.optBoolean("isEnable", false);
        localarlb.jdField_a_of_type_JavaLangString = paramString.optString("homePageUrl", "https://club.vip.qq.com/qid/mine?_wv=16777218&_proxy=1");
        return localarlb;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QVipQidConfig", 2, "QID_LOG,configContent,error:" + paramString);
    return localarlb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlb
 * JD-Core Version:    0.7.0.1
 */