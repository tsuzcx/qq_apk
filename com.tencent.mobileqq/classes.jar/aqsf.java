import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqsf
{
  public aqsg a = new aqsg(this);
  
  public static aqsf a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqsf localaqsf = new aqsf();
        paramString = new JSONObject(paramString).optJSONObject("webbundle");
        if (paramString != null)
        {
          paramString = paramString.optJSONObject("qqcomic");
          if (paramString != null)
          {
            localaqsf.a.jdField_a_of_type_Boolean = paramString.optBoolean("enable", false);
            localaqsf.a.jdField_a_of_type_JavaLangString = paramString.optString("preload_url", "");
          }
        }
        QLog.d("ConfBean", 2, "confBean = " + localaqsf.toString());
        return localaqsf;
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
 * Qualified Name:     aqsf
 * JD-Core Version:    0.7.0.1
 */