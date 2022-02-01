import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class arcl
  extends aqwt<arck>
{
  @NonNull
  public arck a(int paramInt)
  {
    return new arck();
  }
  
  @Nullable
  public arck a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arck localarck = arck.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarck;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arck paramarck)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onUpdate " + paramarck.toString());
    }
    paramarck = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramarck == null) {
      return;
    }
    ((azbv)paramarck.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).d(paramarck.getExtOnlineStatus());
  }
  
  public Class<arck> clazz()
  {
    return arck.class;
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
 * Qualified Name:     arcl
 * JD-Core Version:    0.7.0.1
 */