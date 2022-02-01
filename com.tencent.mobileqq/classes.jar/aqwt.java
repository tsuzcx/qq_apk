import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqwt
  extends aqwr<aqws>
{
  @NonNull
  public aqws a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new aqws();
  }
  
  @NonNull
  public aqws a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    boolean bool = false;
    aqws localaqws = new aqws();
    try
    {
      if (paramArrayOfaqlg[0].a != null)
      {
        if (new JSONObject(paramArrayOfaqlg[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localaqws.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localaqws.a);
        }
      }
      return localaqws;
    }
    catch (Exception paramArrayOfaqlg)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfaqlg);
    }
    return localaqws;
  }
  
  @NonNull
  public aqws b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new aqws();
  }
  
  public Class<aqws> clazz()
  {
    return aqws.class;
  }
  
  public int type()
  {
    return 479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwt
 * JD-Core Version:    0.7.0.1
 */