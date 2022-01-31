import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bcgm
  extends aokh<bcgl>
{
  public int a()
  {
    return 544;
  }
  
  @NonNull
  public bcgl a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bcgl();
  }
  
  @Nullable
  public bcgl a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return bcgl.a(paramArrayOfaoko[0].a);
    }
    return null;
  }
  
  public Class<bcgl> a()
  {
    return bcgl.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bcgl parambcgl)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + parambcgl);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bcgc)((QQAppInterface)localAppRuntime).getManager(346)).a(parambcgl, false);
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
 * Qualified Name:     bcgm
 * JD-Core Version:    0.7.0.1
 */