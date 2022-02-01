import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class arcj
  extends aqwt<arci>
{
  @NonNull
  public arci a(int paramInt)
  {
    return new arci();
  }
  
  @Nullable
  public arci a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arci localarci = arci.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarci;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed is null");
    }
    return new arci();
  }
  
  public void a(arci paramarci)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    azbv localazbv = (azbv)localQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    azco localazco = localazbv.a();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "[status][parser] onUpdate try startDetector conf: " + paramarci.toString());
    }
    if (azbu.a(localQQAppInterface.getOnlineStatus(), localQQAppInterface.getExtOnlineStatus())) {
      localazco.a("configUpdate");
    }
    localazbv.c(localQQAppInterface.getExtOnlineStatus());
    localazbv.b(localQQAppInterface.getExtOnlineStatus());
  }
  
  public Class<arci> clazz()
  {
    return arci.class;
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
 * Qualified Name:     arcj
 * JD-Core Version:    0.7.0.1
 */