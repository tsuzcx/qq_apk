import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bbxg
{
  private boolean a = true;
  
  public static bbxg a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      bbxg localbbxg = new bbxg();
      if (new JSONObject(paramString).optInt("enable", 1) == 1) {}
      for (;;)
      {
        localbbxg.a = bool;
        return localbbxg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxg
 * JD-Core Version:    0.7.0.1
 */