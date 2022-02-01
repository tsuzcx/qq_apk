import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class axjf
{
  private boolean a;
  
  public static axjf a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      axjf localaxjf = new axjf();
      if (new JSONObject(paramString).optInt("isChatMigrateEnable", 0) == 1) {}
      for (;;)
      {
        localaxjf.a = bool;
        return localaxjf;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("MsgBackupConfigProcessor", 2, "MsgBackupConfigData parse error", paramString);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjf
 * JD-Core Version:    0.7.0.1
 */