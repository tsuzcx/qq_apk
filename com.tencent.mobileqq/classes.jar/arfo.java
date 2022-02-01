import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfo
  extends arac<arfn>
{
  public static arfn a()
  {
    return (arfn)aran.a().a(572);
  }
  
  @NonNull
  public arfn a(int paramInt)
  {
    return new arfn();
  }
  
  @Nullable
  public arfn a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      new arfn();
      return arfn.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arfn paramarfn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + paramarfn.toString());
    }
  }
  
  public Class<arfn> clazz()
  {
    return arfn.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 572;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfo
 * JD-Core Version:    0.7.0.1
 */