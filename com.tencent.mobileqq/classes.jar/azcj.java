import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class azcj
  extends alzl<azci>
{
  public int a()
  {
    return 544;
  }
  
  @NonNull
  public azci a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new azci();
  }
  
  @Nullable
  public azci a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return azci.a(paramArrayOfalzs[0].a);
    }
    return null;
  }
  
  public Class<azci> a()
  {
    return azci.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(azci paramazci)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + paramazci);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((azcd)((QQAppInterface)localAppRuntime).getManager(346)).a(paramazci, false);
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
 * Qualified Name:     azcj
 * JD-Core Version:    0.7.0.1
 */