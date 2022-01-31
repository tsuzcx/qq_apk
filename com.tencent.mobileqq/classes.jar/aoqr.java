import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoqr
  extends aopw<aoqq>
{
  public int a()
  {
    return 465;
  }
  
  @NonNull
  public aoqq a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new aoqq();
  }
  
  @NonNull
  public aoqq a(@NonNull aogf[] paramArrayOfaogf)
  {
    aoqq localaoqq = new aoqq();
    try
    {
      localaoqq.a = new JSONObject(paramArrayOfaogf[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localaoqq.a);
      }
      return localaoqq;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfaogf);
    }
    return localaoqq;
  }
  
  public Class<aoqq> a()
  {
    return aoqq.class;
  }
  
  @NonNull
  public aoqq b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new aoqq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoqr
 * JD-Core Version:    0.7.0.1
 */