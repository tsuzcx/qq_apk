import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbo
  extends aqwt<arbn>
{
  @NonNull
  public arbn a(int paramInt)
  {
    return new arbn();
  }
  
  @Nullable
  public arbn a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arbn localarbn = arbn.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocationEasterEggConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarbn;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arbn paramarbn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onUpdate " + paramarbn.toString());
    }
  }
  
  public Class<arbn> clazz()
  {
    return arbn.class;
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
      QLog.d("LocationEasterEggConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 575;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbo
 * JD-Core Version:    0.7.0.1
 */