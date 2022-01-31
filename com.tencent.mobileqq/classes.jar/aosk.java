import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aosk
{
  public int a;
  public int b;
  
  public static aosk a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aosk localaosk = new aosk();
        paramString = new JSONObject(paramString);
        localaosk.a = paramString.optInt("switch", 0);
        localaosk.b = paramString.optInt("stoppreload", 0);
        QLog.d("ConfBean", 2, "confBean = " + localaosk.a);
        return localaosk;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("ConfBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("result:").append(this.a);
    localStringBuilder.append(" stoppreload:").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosk
 * JD-Core Version:    0.7.0.1
 */