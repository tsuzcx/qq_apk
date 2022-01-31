import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amyr
  extends amyp<amyq>
{
  public int a()
  {
    return 479;
  }
  
  @NonNull
  public amyq a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new amyq();
  }
  
  @NonNull
  public amyq a(@NonNull amph[] paramArrayOfamph)
  {
    boolean bool = false;
    amyq localamyq = new amyq();
    try
    {
      if (paramArrayOfamph[0].a != null)
      {
        if (new JSONObject(paramArrayOfamph[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localamyq.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localamyq.a);
        }
      }
      return localamyq;
    }
    catch (Exception paramArrayOfamph)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfamph);
    }
    return localamyq;
  }
  
  public Class<amyq> a()
  {
    return amyq.class;
  }
  
  @NonNull
  public amyq b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new amyq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyr
 * JD-Core Version:    0.7.0.1
 */