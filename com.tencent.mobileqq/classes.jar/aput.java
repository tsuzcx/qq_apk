import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aput
  extends aptq<apus>
{
  @NonNull
  public apus a(int paramInt)
  {
    QLog.d("TroopNotificationEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new apus();
  }
  
  @Nullable
  public apus a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return apus.a(paramArrayOfaptx[0].a);
    }
    return null;
  }
  
  public void a(apus paramapus)
  {
    QLog.d("TroopNotificationEntryConfigProcessor", 1, "onUpdate, newConf = " + paramapus);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (aikq)((AppRuntime)localObject).getManager(383);
      if (localObject != null)
      {
        QLog.d("TroopNotificationEntryConfigProcessor", 1, "call troopNotificationManager.onTroopNotificationConfigUpdate(newConf)");
        ((aikq)localObject).b(paramapus);
      }
    }
  }
  
  public Class<apus> clazz()
  {
    return apus.class;
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
    QLog.d("TroopNotificationEntryConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 691;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aput
 * JD-Core Version:    0.7.0.1
 */