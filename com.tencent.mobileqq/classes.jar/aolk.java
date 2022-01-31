import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aolk
{
  private int a;
  
  public static aolk a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aolk localaolk = new aolk();
        localaolk.a = new JSONObject(paramString).optInt("pttWithTextSwitch", -1);
        return localaolk;
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
 * Qualified Name:     aolk
 * JD-Core Version:    0.7.0.1
 */