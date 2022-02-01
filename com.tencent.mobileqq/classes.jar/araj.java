import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class araj
  extends aqwt<arai>
{
  @NonNull
  public arai a(int paramInt)
  {
    return new arai();
  }
  
  @Nullable
  public arai a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arai localarai = arai.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceManageConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarai;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arai paramarai)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onUpdate " + paramarai.toString());
    }
  }
  
  public Class<arai> clazz()
  {
    return arai.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 528;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     araj
 * JD-Core Version:    0.7.0.1
 */