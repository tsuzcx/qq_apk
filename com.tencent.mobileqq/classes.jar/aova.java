import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aova
  extends aouf<aouz>
{
  public int a()
  {
    return 465;
  }
  
  @NonNull
  public aouz a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new aouz();
  }
  
  @NonNull
  public aouz a(@NonNull aoko[] paramArrayOfaoko)
  {
    aouz localaouz = new aouz();
    try
    {
      localaouz.a = new JSONObject(paramArrayOfaoko[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localaouz.a);
      }
      return localaouz;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfaoko);
    }
    return localaouz;
  }
  
  public Class<aouz> a()
  {
    return aouz.class;
  }
  
  @NonNull
  public aouz b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new aouz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aova
 * JD-Core Version:    0.7.0.1
 */