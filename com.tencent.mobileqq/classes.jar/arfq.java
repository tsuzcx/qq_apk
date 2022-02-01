import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arfq
  extends arac<arfp>
{
  @NonNull
  public arfp a(int paramInt)
  {
    return new arfp();
  }
  
  @Nullable
  public arfp a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arfp localarfp = arfp.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarfp;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed is null");
    }
    return new arfp();
  }
  
  public void a(arfp paramarfp)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    azic localazic = (azic)localQQAppInterface.getManager(369);
    aziu localaziu = localazic.a();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "[status][parser] onUpdate try startDetector conf: " + paramarfp.toString());
    }
    if (azib.a(localQQAppInterface.getOnlineStatus(), localQQAppInterface.getExtOnlineStatus())) {
      localaziu.a("configUpdate");
    }
    localazic.c(localQQAppInterface.getExtOnlineStatus());
    localazic.b(localQQAppInterface.getExtOnlineStatus());
  }
  
  public Class<arfp> clazz()
  {
    return arfp.class;
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
    QLog.d("OnlineAutoStatusConfProcessor", 1, "isNeedUpgradeReset ");
    return true;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 652;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfq
 * JD-Core Version:    0.7.0.1
 */