import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arna
  extends armf<armz>
{
  @NonNull
  public armz a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new armz();
  }
  
  @NonNull
  public armz a(@NonNull araj[] paramArrayOfaraj)
  {
    armz localarmz = new armz();
    try
    {
      localarmz.a = new JSONObject(paramArrayOfaraj[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localarmz.a);
      }
      return localarmz;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfaraj);
    }
    return localarmz;
  }
  
  @NonNull
  public armz b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new armz();
  }
  
  public Class<armz> clazz()
  {
    return armz.class;
  }
  
  public int type()
  {
    return 465;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arna
 * JD-Core Version:    0.7.0.1
 */