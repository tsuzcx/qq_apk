import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amew
{
  public amex a = new amex(this);
  
  public static amew a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amew localamew = new amew();
        paramString = new JSONObject(paramString).optJSONObject("webbundle");
        if (paramString != null)
        {
          paramString = paramString.optJSONObject("qqcomic");
          if (paramString != null)
          {
            localamew.a.jdField_a_of_type_Boolean = paramString.optBoolean("enable", false);
            localamew.a.jdField_a_of_type_JavaLangString = paramString.optString("preload_url", "");
          }
        }
        QLog.d("ConfBean", 2, "confBean = " + localamew.toString());
        return localamew;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("qqComicConfig:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amew
 * JD-Core Version:    0.7.0.1
 */