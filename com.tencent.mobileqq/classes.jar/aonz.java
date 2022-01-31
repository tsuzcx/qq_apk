import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aonz
{
  public int a;
  
  public static aonz a(String paramString)
  {
    aonz localaonz = new aonz();
    try
    {
      localaonz.a = new JSONObject(paramString).optInt("preloadPskey", 0);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localaonz.toString());
      return localaonz;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localaonz;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonz
 * JD-Core Version:    0.7.0.1
 */