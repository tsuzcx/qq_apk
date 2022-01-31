import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amst
{
  public String a = "";
  
  public amst() {}
  
  public amst(String paramString)
  {
    this.a = paramString;
  }
  
  public static amst a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("ShowLocaleEntrance");
      if (QLog.isColorLevel()) {
        QLog.e("LocaleConfProcessor", 2, "manager parse, showEntrance: " + paramString);
      }
      paramString = new amst(paramString.trim());
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
 * Qualified Name:     amst
 * JD-Core Version:    0.7.0.1
 */