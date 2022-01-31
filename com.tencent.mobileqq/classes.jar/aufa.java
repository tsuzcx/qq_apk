import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aufa
{
  private boolean a;
  
  public static aufa a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      aufa localaufa = new aufa();
      if (new JSONObject(paramString).optInt("isChatMigrateEnable", 0) == 1) {}
      for (;;)
      {
        localaufa.a = bool;
        return localaufa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aufa
 * JD-Core Version:    0.7.0.1
 */