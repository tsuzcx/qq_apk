import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bfha
  extends aqkz<bfgz>
{
  @NonNull
  public bfgz a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bfgz();
  }
  
  @Nullable
  public bfgz a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return bfgz.a(paramArrayOfaqlg[0].a);
    }
    return null;
  }
  
  public void a(bfgz parambfgz)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + parambfgz);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bfgp)((QQAppInterface)localAppRuntime).getManager(346)).a(parambfgz, false);
    }
  }
  
  public Class<bfgz> clazz()
  {
    return bfgz.class;
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
 * Qualified Name:     bfha
 * JD-Core Version:    0.7.0.1
 */