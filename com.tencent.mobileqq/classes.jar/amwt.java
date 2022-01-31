import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amwt
{
  public int a;
  
  public static amwt a(String paramString)
  {
    amwt localamwt = new amwt();
    try
    {
      localamwt.a = new JSONObject(paramString).optInt("preloadPskey", 0);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localamwt.toString());
      return localamwt;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localamwt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwt
 * JD-Core Version:    0.7.0.1
 */