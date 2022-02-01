import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class argu
{
  private int a;
  
  public static argu a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        argu localargu = new argu();
        localargu.a = new JSONObject(paramString).optInt("pttWithTextSwitch", -1);
        return localargu;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PttWithTextSwitchBean", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public String toString()
  {
    return "open:" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argu
 * JD-Core Version:    0.7.0.1
 */