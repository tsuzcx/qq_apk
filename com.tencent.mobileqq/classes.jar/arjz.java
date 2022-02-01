import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arjz
{
  public int a = 1;
  public int b = 1;
  
  public static arjz a(String paramString)
  {
    arjz localarjz = new arjz();
    try
    {
      paramString = new JSONObject(paramString);
      localarjz.a = paramString.optInt("preloadPskey", 1);
      localarjz.b = paramString.optInt("enableFTSMerge", 1);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localarjz.toString());
      return localarjz;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localarjz;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjz
 * JD-Core Version:    0.7.0.1
 */