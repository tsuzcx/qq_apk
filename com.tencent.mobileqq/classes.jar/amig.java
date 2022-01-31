import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amig
  extends amie<amif>
{
  public int a()
  {
    return 479;
  }
  
  @NonNull
  public amif a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new amif();
  }
  
  @NonNull
  public amif a(@NonNull alzs[] paramArrayOfalzs)
  {
    boolean bool = false;
    amif localamif = new amif();
    try
    {
      if (paramArrayOfalzs[0].a != null)
      {
        if (new JSONObject(paramArrayOfalzs[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localamif.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localamif.a);
        }
      }
      return localamif;
    }
    catch (Exception paramArrayOfalzs)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfalzs);
    }
    return localamif;
  }
  
  public Class<amif> a()
  {
    return amif.class;
  }
  
  @NonNull
  public amif b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new amif();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amig
 * JD-Core Version:    0.7.0.1
 */