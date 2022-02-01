import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bggu
  extends arac<bggt>
{
  @NonNull
  public bggt a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bggt();
  }
  
  @Nullable
  public bggt a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return bggt.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(bggt parambggt)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + parambggt);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bggj)((QQAppInterface)localAppRuntime).getManager(346)).a(parambggt, false);
    }
  }
  
  public Class<bggt> clazz()
  {
    return bggt.class;
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
 * Qualified Name:     bggu
 * JD-Core Version:    0.7.0.1
 */