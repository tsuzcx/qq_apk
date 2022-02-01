import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqri
{
  private int a;
  private int b;
  private int c;
  
  public static aqri a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqri localaqri = new aqri();
        paramString = new JSONObject(paramString);
        localaqri.a = paramString.optInt("showVoiceToTextSwitch", -1);
        localaqri.b = paramString.optInt("grayTipShowPerThousand", -1);
        localaqri.c = paramString.optInt("mainSwitch", -1);
        return localaqri;
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
 * Qualified Name:     aqri
 * JD-Core Version:    0.7.0.1
 */