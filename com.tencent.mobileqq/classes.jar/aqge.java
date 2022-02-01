import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqge
  extends aqgc<aqgd>
{
  @NonNull
  public aqgd a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new aqgd();
  }
  
  @NonNull
  public aqgd a(@NonNull aptx[] paramArrayOfaptx)
  {
    boolean bool = false;
    aqgd localaqgd = new aqgd();
    try
    {
      if (paramArrayOfaptx[0].a != null)
      {
        if (new JSONObject(paramArrayOfaptx[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localaqgd.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localaqgd.a);
        }
      }
      return localaqgd;
    }
    catch (Exception paramArrayOfaptx)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfaptx);
    }
    return localaqgd;
  }
  
  @NonNull
  public aqgd b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new aqgd();
  }
  
  public Class<aqgd> clazz()
  {
    return aqgd.class;
  }
  
  public int type()
  {
    return 479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqge
 * JD-Core Version:    0.7.0.1
 */