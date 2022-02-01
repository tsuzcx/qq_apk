import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arke
  extends arjj<arkd>
{
  @NonNull
  public arkd a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new arkd();
  }
  
  @NonNull
  public arkd a(@NonNull aqxa[] paramArrayOfaqxa)
  {
    arkd localarkd = new arkd();
    try
    {
      localarkd.a = new JSONObject(paramArrayOfaqxa[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localarkd.a);
      }
      return localarkd;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfaqxa);
    }
    return localarkd;
  }
  
  @NonNull
  public arkd b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new arkd();
  }
  
  public Class<arkd> clazz()
  {
    return arkd.class;
  }
  
  public int type()
  {
    return 465;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arke
 * JD-Core Version:    0.7.0.1
 */