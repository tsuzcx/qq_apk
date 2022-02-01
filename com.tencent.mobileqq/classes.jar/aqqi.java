import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqqi
  extends aqkz<aqqh>
{
  @NonNull
  public aqqh a(int paramInt)
  {
    return new aqqh();
  }
  
  @Nullable
  public aqqh a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqqh localaqqh = aqqh.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqqh;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed is null");
    }
    return new aqqh();
  }
  
  public void a(aqqh paramaqqh)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    aypj localaypj = (aypj)localQQAppInterface.getManager(369);
    ayqb localayqb = localaypj.a();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "[status][parser] onUpdate try startDetector conf: " + paramaqqh.toString());
    }
    if (aypi.a(localQQAppInterface.getOnlineStatus(), localQQAppInterface.getExtOnlineStatus())) {
      localayqb.a("configUpdate");
    }
    localaypj.c(localQQAppInterface.getExtOnlineStatus());
    localaypj.b(localQQAppInterface.getExtOnlineStatus());
  }
  
  public Class<aqqh> clazz()
  {
    return aqqh.class;
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
 * Qualified Name:     aqqi
 * JD-Core Version:    0.7.0.1
 */