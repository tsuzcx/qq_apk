import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bads
  extends ampa<badr>
{
  public int a()
  {
    return 544;
  }
  
  @NonNull
  public badr a(int paramInt)
  {
    QLog.d("TroopHonor.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new badr();
  }
  
  @Nullable
  public badr a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return badr.a(paramArrayOfamph[0].a);
    }
    return null;
  }
  
  public Class<badr> a()
  {
    return badr.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopHonor.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(badr parambadr)
  {
    QLog.d("TroopHonor.config", 1, "onUpdate, newConf = " + parambadr);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((badj)((QQAppInterface)localAppRuntime).getManager(346)).a(parambadr, false);
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
 * Qualified Name:     bads
 * JD-Core Version:    0.7.0.1
 */