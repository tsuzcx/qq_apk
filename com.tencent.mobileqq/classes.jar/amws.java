import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amws
{
  public int a;
  
  public static amws a(String paramString)
  {
    amws localamws = new amws();
    try
    {
      localamws.a = new JSONObject(paramString).optInt("preloadPskey", 0);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localamws.toString());
      return localamws;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localamws;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amws
 * JD-Core Version:    0.7.0.1
 */