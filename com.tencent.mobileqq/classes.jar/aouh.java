import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aouh
  extends aouf<aoug>
{
  public int a()
  {
    return 479;
  }
  
  @NonNull
  public aoug a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new aoug();
  }
  
  @NonNull
  public aoug a(@NonNull aoko[] paramArrayOfaoko)
  {
    boolean bool = false;
    aoug localaoug = new aoug();
    try
    {
      if (paramArrayOfaoko[0].a != null)
      {
        if (new JSONObject(paramArrayOfaoko[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localaoug.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localaoug.a);
        }
      }
      return localaoug;
    }
    catch (Exception paramArrayOfaoko)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfaoko);
    }
    return localaoug;
  }
  
  public Class<aoug> a()
  {
    return aoug.class;
  }
  
  @NonNull
  public aoug b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new aoug();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aouh
 * JD-Core Version:    0.7.0.1
 */