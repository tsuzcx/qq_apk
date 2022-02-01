import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aqxu
  extends aqwt<aqxt>
{
  @NonNull
  public aqxt a(int paramInt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new aqxt();
  }
  
  @Nullable
  public aqxt a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aqxt.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(aqxt paramaqxt)
  {
    QLog.d("TroopNotificationConfigProcessor.config", 1, "onUpdate, newConf = " + paramaqxt);
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
  }
  
  public Class<aqxt> clazz()
  {
    return aqxt.class;
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
 * Qualified Name:     aqxu
 * JD-Core Version:    0.7.0.1
 */