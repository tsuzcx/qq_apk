import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bade
  extends ampb<badd>
{
  public int a()
  {
    return 544;
  }
  
  @NonNull
  public badd a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new badd();
  }
  
  @Nullable
  public badd a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return badd.a(paramArrayOfampi[0].a);
    }
    return null;
  }
  
  public Class<badd> a()
  {
    return badd.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(badd parambadd)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + parambadd);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bacv)((QQAppInterface)localAppRuntime).getManager(346)).a(parambadd, false);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bade
 * JD-Core Version:    0.7.0.1
 */