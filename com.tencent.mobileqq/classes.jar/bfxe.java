import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bfxe
  extends aqwt<bfxd>
{
  @NonNull
  public bfxd a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfxd();
  }
  
  @Nullable
  public bfxd a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return bfxd.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(bfxd parambfxd)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + parambfxd);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bfwu)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).a(parambfxd, false);
    }
  }
  
  public Class<bfxd> clazz()
  {
    return bfxd.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 544;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxe
 * JD-Core Version:    0.7.0.1
 */