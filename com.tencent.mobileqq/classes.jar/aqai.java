import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqai
{
  private int a;
  private int b;
  private int c;
  
  public static aqai a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqai localaqai = new aqai();
        paramString = new JSONObject(paramString);
        localaqai.a = paramString.optInt("showVoiceToTextSwitch", -1);
        localaqai.b = paramString.optInt("grayTipShowPerThousand", -1);
        localaqai.c = paramString.optInt("mainSwitch", -1);
        return localaqai;
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
 * Qualified Name:     aqai
 * JD-Core Version:    0.7.0.1
 */