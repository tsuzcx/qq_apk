import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arpb
  extends arac<arpc>
{
  @NonNull
  public arpc a(int paramInt)
  {
    return new arpc();
  }
  
  @Nullable
  public arpc a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      arpc localarpc = arpc.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfaraj[0].a);
      }
      return localarpc;
    }
    return new arpc();
  }
  
  public void a(arpc paramarpc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<arpc> clazz()
  {
    return arpc.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public int type()
  {
    return 589;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arpb
 * JD-Core Version:    0.7.0.1
 */