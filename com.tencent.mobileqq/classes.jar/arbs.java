import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbs
  extends arac<arbt>
{
  @NonNull
  public arbt a(int paramInt)
  {
    return new arbt();
  }
  
  @Nullable
  public arbt a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arbt localarbt = arbt.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarbt;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    aljo.a(true);
    return null;
  }
  
  public void a(arbt paramarbt)
  {
    if (paramarbt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + paramarbt.toString());
    }
    aljo.a(true);
  }
  
  public Class<arbt> clazz()
  {
    return arbt.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
      QLog.d("AppletNotificationConfProcessor", 2, "migrateOldVersion");
    }
    aljo.a(true);
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    aljo.a(true);
  }
  
  public int type()
  {
    return 597;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbs
 * JD-Core Version:    0.7.0.1
 */