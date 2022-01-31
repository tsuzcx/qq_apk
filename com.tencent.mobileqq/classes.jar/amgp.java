import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amgp
{
  public int a;
  
  public static amgp a(String paramString)
  {
    amgp localamgp = new amgp();
    try
    {
      localamgp.a = new JSONObject(paramString).optInt("preloadPskey", 0);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localamgp.toString());
      return localamgp;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localamgp;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgp
 * JD-Core Version:    0.7.0.1
 */