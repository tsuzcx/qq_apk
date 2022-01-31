import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class awgj
{
  private boolean a = true;
  
  public static awgj a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      awgj localawgj = new awgj();
      if (new JSONObject(paramString).optInt("enable", 1) == 1) {}
      for (;;)
      {
        localawgj.a = bool;
        return localawgj;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("ScreenShotConfigProcessor", 2, "ScreenShotConfigData parse error", paramString);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ScreenShotConfigData [mSwitchEnable = " + this.a + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgj
 * JD-Core Version:    0.7.0.1
 */