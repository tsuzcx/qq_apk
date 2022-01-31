import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amrz
{
  private boolean a;
  
  public static amrz a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      amrz localamrz = new amrz();
      if (new JSONObject(paramString).optInt("isDefaultOpen", 1) == 1) {}
      for (;;)
      {
        localamrz.a = bool;
        return localamrz;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("DarkModeConfigProcessor", 2, "DarkModeConfigBean parse error", paramString);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrz
 * JD-Core Version:    0.7.0.1
 */