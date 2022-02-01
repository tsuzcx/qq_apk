import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqfb
  implements apts<String>
{
  public String a;
  public boolean a;
  public String b = "";
  public String c = "{}";
  
  public aqfb()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.c = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("actionSwitch")) {
        this.jdField_a_of_type_Boolean = paramString.getBoolean("actionSwitch");
      }
      if (paramString.has("actionHint")) {
        this.jdField_a_of_type_JavaLangString = paramString.getString("actionHint");
      }
      if (paramString.has("actionYYBDownloadUrl")) {
        this.b = paramString.getString("actionYYBDownloadUrl");
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileAppStorePromoteConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqfb
 * JD-Core Version:    0.7.0.1
 */