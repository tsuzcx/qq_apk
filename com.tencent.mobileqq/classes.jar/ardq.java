import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ardq
  extends arac<ardp>
{
  @NonNull
  public ardp a(int paramInt)
  {
    return new ardp();
  }
  
  @Nullable
  public ardp a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      ardp localardp = ardp.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DeviceManageConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localardp;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(ardp paramardp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceManageConfProcessor", 2, "onUpdate " + paramardp.toString());
    }
  }
  
  public Class<ardp> clazz()
  {
    return ardp.class;
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
 * Qualified Name:     ardq
 * JD-Core Version:    0.7.0.1
 */