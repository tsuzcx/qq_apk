import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arfs
  extends arac<arfr>
{
  @NonNull
  public arfr a(int paramInt)
  {
    return new arfr();
  }
  
  @Nullable
  public arfr a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arfr localarfr = arfr.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarfr;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arfr paramarfr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onUpdate " + paramarfr.toString());
    }
    paramarfr = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramarfr == null) {
      return;
    }
    ((azic)paramarfr.getManager(369)).d(paramarfr.getExtOnlineStatus());
  }
  
  public Class<arfr> clazz()
  {
    return arfr.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    QLog.d("OnlineStatusConfProcessor", 1, "isNeedUpgradeReset ");
    return true;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 578;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfs
 * JD-Core Version:    0.7.0.1
 */