import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

public class ardw
  extends aqwt<ardv>
{
  @NonNull
  public ardv a(int paramInt)
  {
    return new ardv();
  }
  
  @Nullable
  public ardv a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      ardv localardv = ardv.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localardv;
    }
    return new ardv();
  }
  
  public void a(ardv paramardv)
  {
    ((awtn)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER)).a(paramardv);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramardv);
    }
  }
  
  public Class<ardv> clazz()
  {
    return ardv.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 390;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardw
 * JD-Core Version:    0.7.0.1
 */