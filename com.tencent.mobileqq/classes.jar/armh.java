import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class armh
  extends armf<armg>
{
  @NonNull
  public armg a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new armg();
  }
  
  @NonNull
  public armg a(@NonNull araj[] paramArrayOfaraj)
  {
    boolean bool = false;
    armg localarmg = new armg();
    try
    {
      if (paramArrayOfaraj[0].a != null)
      {
        if (new JSONObject(paramArrayOfaraj[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localarmg.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localarmg.a);
        }
      }
      return localarmg;
    }
    catch (Exception paramArrayOfaraj)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfaraj);
    }
    return localarmg;
  }
  
  @NonNull
  public armg b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new armg();
  }
  
  public Class<armg> clazz()
  {
    return armg.class;
  }
  
  public int type()
  {
    return 479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     armh
 * JD-Core Version:    0.7.0.1
 */