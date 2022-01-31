import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amcs
{
  public String a = "";
  
  public amcs() {}
  
  public amcs(String paramString)
  {
    this.a = paramString;
  }
  
  public static amcs a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("ShowLocaleEntrance");
      if (QLog.isColorLevel()) {
        QLog.e("LocaleConfProcessor", 2, "manager parse, showEntrance: " + paramString);
      }
      paramString = new amcs(paramString.trim());
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
 * Qualified Name:     amcs
 * JD-Core Version:    0.7.0.1
 */