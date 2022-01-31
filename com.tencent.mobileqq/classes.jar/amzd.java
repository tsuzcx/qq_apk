import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amzd
  extends amyi<amzc>
{
  public int a()
  {
    return 465;
  }
  
  @NonNull
  public amzc a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new amzc();
  }
  
  @NonNull
  public amzc a(@NonNull ampi[] paramArrayOfampi)
  {
    amzc localamzc = new amzc();
    try
    {
      localamzc.a = new JSONObject(paramArrayOfampi[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localamzc.a);
      }
      return localamzc;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfampi);
    }
    return localamzc;
  }
  
  public Class<amzc> a()
  {
    return amzc.class;
  }
  
  @NonNull
  public amzc b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new amzc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzd
 * JD-Core Version:    0.7.0.1
 */