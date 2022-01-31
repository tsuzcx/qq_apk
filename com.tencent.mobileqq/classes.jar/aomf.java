import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aomf
{
  public aomg a = new aomg(this);
  
  public static aomf a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aomf localaomf = new aomf();
        paramString = new JSONObject(paramString).optJSONObject("webbundle");
        if (paramString != null)
        {
          paramString = paramString.optJSONObject("qqcomic");
          if (paramString != null)
          {
            localaomf.a.jdField_a_of_type_Boolean = paramString.optBoolean("enable", false);
            localaomf.a.jdField_a_of_type_JavaLangString = paramString.optString("preload_url", "");
          }
        }
        QLog.d("ConfBean", 2, "confBean = " + localaomf.toString());
        return localaomf;
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
 * Qualified Name:     aomf
 * JD-Core Version:    0.7.0.1
 */