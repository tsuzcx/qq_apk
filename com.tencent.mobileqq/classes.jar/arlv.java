import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arlv
  implements arae<String>
{
  public String a;
  public boolean a;
  
  public arlv()
  {
    this.jdField_a_of_type_JavaLangString = "{}";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("QFileFileReaderConfigBean<QFile>", 1, "onParse: but configContent is null!");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("barShowSwitch")) {
        this.jdField_a_of_type_Boolean = paramString.getBoolean("barShowSwitch");
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("QFileFileReaderConfigBean<QFile>", 1, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlv
 * JD-Core Version:    0.7.0.1
 */