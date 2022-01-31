import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amiz
  extends amie<amiy>
{
  public int a()
  {
    return 465;
  }
  
  @NonNull
  public amiy a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new amiy();
  }
  
  @NonNull
  public amiy a(@NonNull alzs[] paramArrayOfalzs)
  {
    amiy localamiy = new amiy();
    try
    {
      localamiy.a = new JSONObject(paramArrayOfalzs[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localamiy.a);
      }
      return localamiy;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfalzs);
    }
    return localamiy;
  }
  
  public Class<amiy> a()
  {
    return amiy.class;
  }
  
  @NonNull
  public amiy b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new amiy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amiz
 * JD-Core Version:    0.7.0.1
 */