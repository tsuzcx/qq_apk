import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aopy
  extends aopw<aopx>
{
  public int a()
  {
    return 479;
  }
  
  @NonNull
  public aopx a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new aopx();
  }
  
  @NonNull
  public aopx a(@NonNull aogf[] paramArrayOfaogf)
  {
    boolean bool = false;
    aopx localaopx = new aopx();
    try
    {
      if (paramArrayOfaogf[0].a != null)
      {
        if (new JSONObject(paramArrayOfaogf[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localaopx.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localaopx.a);
        }
      }
      return localaopx;
    }
    catch (Exception paramArrayOfaogf)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfaogf);
    }
    return localaopx;
  }
  
  public Class<aopx> a()
  {
    return aopx.class;
  }
  
  @NonNull
  public aopx b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new aopx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aopy
 * JD-Core Version:    0.7.0.1
 */