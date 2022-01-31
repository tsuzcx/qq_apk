import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoli
{
  private int a;
  private int b;
  private int c;
  
  public static aoli a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aoli localaoli = new aoli();
        paramString = new JSONObject(paramString);
        localaoli.a = paramString.optInt("showVoiceToTextSwitch", -1);
        localaoli.b = paramString.optInt("grayTipShowPerThousand", -1);
        localaoli.c = paramString.optInt("mainSwitch", -1);
        return localaoli;
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
 * Qualified Name:     aoli
 * JD-Core Version:    0.7.0.1
 */