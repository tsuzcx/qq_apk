import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aybm
{
  private boolean a = true;
  
  public static aybm a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      aybm localaybm = new aybm();
      if (new JSONObject(paramString).optInt("enable", 1) == 1) {}
      for (;;)
      {
        localaybm.a = bool;
        return localaybm;
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
 * Qualified Name:     aybm
 * JD-Core Version:    0.7.0.1
 */