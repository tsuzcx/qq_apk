import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aret
{
  public String a = "";
  
  public aret() {}
  
  public aret(String paramString)
  {
    this.a = paramString;
  }
  
  public static aret a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("ShowLocaleEntrance");
      if (QLog.isColorLevel()) {
        QLog.e("LocaleConfProcessor", 2, "manager parse, showEntrance: " + paramString);
      }
      paramString = new aret(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aret
 * JD-Core Version:    0.7.0.1
 */