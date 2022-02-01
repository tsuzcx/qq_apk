import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqyl
  extends aqwt<aqym>
{
  @NonNull
  public aqym a(int paramInt)
  {
    return new aqym();
  }
  
  @Nullable
  public aqym a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      aqym localaqym = aqym.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localaqym;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    alcz.a(true);
    return null;
  }
  
  public void a(aqym paramaqym)
  {
    if (paramaqym == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onUpdate " + paramaqym.toString());
    }
    alcz.a(true);
  }
  
  public Class<aqym> clazz()
  {
    return aqym.class;
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
    alcz.a(true);
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    alcz.a(true);
  }
  
  public int type()
  {
    return 597;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyl
 * JD-Core Version:    0.7.0.1
 */