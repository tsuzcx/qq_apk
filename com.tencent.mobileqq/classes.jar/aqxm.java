import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqxm
  extends aqwr<aqxl>
{
  @NonNull
  public aqxl a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new aqxl();
  }
  
  @NonNull
  public aqxl a(@NonNull aqlg[] paramArrayOfaqlg)
  {
    aqxl localaqxl = new aqxl();
    try
    {
      localaqxl.a = new JSONObject(paramArrayOfaqlg[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localaqxl.a);
      }
      return localaqxl;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfaqlg);
    }
    return localaqxl;
  }
  
  @NonNull
  public aqxl b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new aqxl();
  }
  
  public Class<aqxl> clazz()
  {
    return aqxl.class;
  }
  
  public int type()
  {
    return 465;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqxm
 * JD-Core Version:    0.7.0.1
 */