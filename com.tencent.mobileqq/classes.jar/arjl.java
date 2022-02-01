import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arjl
  extends arjj<arjk>
{
  @NonNull
  public arjk a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new arjk();
  }
  
  @NonNull
  public arjk a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    boolean bool = false;
    arjk localarjk = new arjk();
    try
    {
      if (paramArrayOfaqxa[0].a != null)
      {
        if (new JSONObject(paramArrayOfaqxa[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localarjk.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localarjk.a);
        }
      }
      return localarjk;
    }
    catch (Exception paramArrayOfaqxa)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfaqxa);
    }
    return localarjk;
  }
  
  @NonNull
  public arjk b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new arjk();
  }
  
  public Class<arjk> clazz()
  {
    return arjk.class;
  }
  
  public int type()
  {
    return 479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjl
 * JD-Core Version:    0.7.0.1
 */