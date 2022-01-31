import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class asob
{
  private boolean a;
  
  public static asob a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      asob localasob = new asob();
      if (new JSONObject(paramString).optInt("isChatMigrateEnable", 0) == 1) {}
      for (;;)
      {
        localasob.a = bool;
        return localasob;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     asob
 * JD-Core Version:    0.7.0.1
 */