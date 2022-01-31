import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amyk
  extends amyi<amyj>
{
  public int a()
  {
    return 479;
  }
  
  @NonNull
  public amyj a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new amyj();
  }
  
  @NonNull
  public amyj a(@NonNull ampi[] paramArrayOfampi)
  {
    boolean bool = false;
    amyj localamyj = new amyj();
    try
    {
      if (paramArrayOfampi[0].a != null)
      {
        if (new JSONObject(paramArrayOfampi[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localamyj.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localamyj.a);
        }
      }
      return localamyj;
    }
    catch (Exception paramArrayOfampi)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfampi);
    }
    return localamyj;
  }
  
  public Class<amyj> a()
  {
    return amyj.class;
  }
  
  @NonNull
  public amyj b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new amyj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyk
 * JD-Core Version:    0.7.0.1
 */