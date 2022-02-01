import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class arbd
  extends arac<arbc>
{
  @NonNull
  public arbc a(int paramInt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new arbc();
  }
  
  @Nullable
  public arbc a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arbc.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(arbc paramarbc)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onUpdate, newConf = " + paramarbc);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
  }
  
  public Class<arbc> clazz()
  {
    return arbc.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 634;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbd
 * JD-Core Version:    0.7.0.1
 */