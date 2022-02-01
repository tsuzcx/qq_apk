import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apur
  extends aptq<apuq>
{
  @NonNull
  public apuq a(int paramInt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new apuq();
  }
  
  @Nullable
  public apuq a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return apuq.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(apuq paramapuq)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onUpdate, newConf = " + paramapuq);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
  }
  
  public Class<apuq> clazz()
  {
    return apuq.class;
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
 * Qualified Name:     apur
 * JD-Core Version:    0.7.0.1
 */