import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aosi
{
  public int a;
  
  public static aosi a(String paramString)
  {
    aosi localaosi = new aosi();
    try
    {
      localaosi.a = new JSONObject(paramString).optInt("preloadPskey", 0);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localaosi.toString());
      return localaosi;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localaosi;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosi
 * JD-Core Version:    0.7.0.1
 */