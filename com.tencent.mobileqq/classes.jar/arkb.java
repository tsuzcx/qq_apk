import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arkb
{
  public int a;
  public int b;
  
  public static arkb a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        arkb localarkb = new arkb();
        paramString = new JSONObject(paramString);
        localarkb.a = paramString.optInt("switch", 0);
        localarkb.b = paramString.optInt("stoppreload", 0);
        QLog.d("ConfBean", 2, "confBean = " + localarkb.a);
        return localarkb;
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
 * Qualified Name:     arkb
 * JD-Core Version:    0.7.0.1
 */