import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amuf
{
  private int a;
  private int b;
  private int c;
  
  public static amuf a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amuf localamuf = new amuf();
        paramString = new JSONObject(paramString);
        localamuf.a = paramString.optInt("showVoiceToTextSwitch", -1);
        localamuf.b = paramString.optInt("grayTipShowPerThousand", -1);
        localamuf.c = paramString.optInt("mainSwitch", -1);
        return localamuf;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PttAutoChangeProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public int a()
  {
    return this.b;
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
 * Qualified Name:     amuf
 * JD-Core Version:    0.7.0.1
 */