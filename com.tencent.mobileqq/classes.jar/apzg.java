import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apzg
  extends aptq<apzf>
{
  @NonNull
  public apzf a(int paramInt)
  {
    return new apzf();
  }
  
  @Nullable
  public apzf a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      apzf localapzf = apzf.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapzf;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed is null");
    }
    return new apzf();
  }
  
  public void a(apzf paramapzf)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    axvk localaxvk = (axvk)localQQAppInterface.getManager(369);
    axwc localaxwc = localaxvk.a();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "[status][parser] onUpdate try startDetector conf: " + paramapzf.toString());
    }
    if (axvj.a(localQQAppInterface.getOnlineStatus(), localQQAppInterface.getExtOnlineStatus())) {
      localaxwc.a("configUpdate");
    }
    localaxvk.c(localQQAppInterface.getExtOnlineStatus());
    localaxvk.b(localQQAppInterface.getExtOnlineStatus());
  }
  
  public Class<apzf> clazz()
  {
    return apzf.class;
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
 * Qualified Name:     apzg
 * JD-Core Version:    0.7.0.1
 */