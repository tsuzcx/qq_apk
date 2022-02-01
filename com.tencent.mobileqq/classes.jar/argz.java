import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class argz
{
  public int a = 1;
  public int b = 1;
  
  public static argz a(String paramString)
  {
    argz localargz = new argz();
    try
    {
      paramString = new JSONObject(paramString);
      localargz.a = paramString.optInt("preloadPskey", 1);
      localargz.b = paramString.optInt("enableFTSMerge", 1);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localargz.toString());
      return localargz;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localargz;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argz
 * JD-Core Version:    0.7.0.1
 */