import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amzk
  extends amyp<amzj>
{
  public int a()
  {
    return 465;
  }
  
  @NonNull
  public amzj a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new amzj();
  }
  
  @NonNull
  public amzj a(@NonNull amph[] paramArrayOfamph)
  {
    amzj localamzj = new amzj();
    try
    {
      localamzj.a = new JSONObject(paramArrayOfamph[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localamzj.a);
      }
      return localamzj;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfamph);
    }
    return localamzj;
  }
  
  public Class<amzj> a()
  {
    return amzj.class;
  }
  
  @NonNull
  public amzj b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new amzj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amzk
 * JD-Core Version:    0.7.0.1
 */