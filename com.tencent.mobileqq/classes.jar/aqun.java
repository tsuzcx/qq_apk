import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqun
{
  public int a;
  
  public static aqun a(String paramString)
  {
    aqun localaqun = new aqun();
    try
    {
      localaqun.a = new JSONObject(paramString).optInt("preloadPskey", 0);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localaqun.toString());
      return localaqun;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localaqun;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqun
 * JD-Core Version:    0.7.0.1
 */