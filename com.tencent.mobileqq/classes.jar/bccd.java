import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bccd
  extends aofy<bccc>
{
  public int a()
  {
    return 544;
  }
  
  @NonNull
  public bccc a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bccc();
  }
  
  @Nullable
  public bccc a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return bccc.a(paramArrayOfaogf[0].a);
    }
    return null;
  }
  
  public Class<bccc> a()
  {
    return bccc.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bccc parambccc)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + parambccc);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bcbt)((QQAppInterface)localAppRuntime).getManager(346)).a(parambccc, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccd
 * JD-Core Version:    0.7.0.1
 */