import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aqxw
  extends aqwt<aqxv>
{
  @NonNull
  public aqxv a(int paramInt)
  {
    QLog.d("TroopNotificationEntryConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new aqxv();
  }
  
  @Nullable
  public aqxv a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aqxv.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(aqxv paramaqxv)
  {
    QLog.d("TroopNotificationEntryConfigProcessor", 1, "onUpdate, newConf = " + paramaqxv);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (ajfn)((AppRuntime)localObject).getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER);
      if (localObject != null)
      {
        QLog.d("TroopNotificationEntryConfigProcessor", 1, "call troopNotificationManager.onTroopNotificationConfigUpdate(newConf)");
        ((ajfn)localObject).a(paramaqxv);
      }
    }
  }
  
  public Class<aqxv> clazz()
  {
    return aqxv.class;
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
 * Qualified Name:     aqxw
 * JD-Core Version:    0.7.0.1
 */