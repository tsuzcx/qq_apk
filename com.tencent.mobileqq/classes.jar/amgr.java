import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amgr
{
  public int a;
  public int b;
  
  public static amgr a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amgr localamgr = new amgr();
        paramString = new JSONObject(paramString);
        localamgr.a = paramString.optInt("switch", 0);
        localamgr.b = paramString.optInt("stoppreload", 0);
        QLog.d("ConfBean", 2, "confBean = " + localamgr.a);
        return localamgr;
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
 * Qualified Name:     amgr
 * JD-Core Version:    0.7.0.1
 */