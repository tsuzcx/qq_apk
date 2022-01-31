import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amue
{
  private int a;
  private int b;
  private int c;
  
  public static amue a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amue localamue = new amue();
        paramString = new JSONObject(paramString);
        localamue.a = paramString.optInt("showVoiceToTextSwitch", -1);
        localamue.b = paramString.optInt("grayTipShowPerThousand", -1);
        localamue.c = paramString.optInt("mainSwitch", -1);
        return localamue;
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
 * Qualified Name:     amue
 * JD-Core Version:    0.7.0.1
 */