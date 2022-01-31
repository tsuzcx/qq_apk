import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class bcec
  extends aofy<bceb>
{
  public int a()
  {
    return 590;
  }
  
  @NonNull
  public bceb a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bceb();
  }
  
  @Nullable
  public bceb a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return bceb.a(paramArrayOfaogf[0].a);
    }
    return null;
  }
  
  public Class<bceb> a()
  {
    return bceb.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bceb parambceb)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bcef)((QQAppInterface)localAppRuntime).getManager(355)).a(parambceb, false);
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
 * Qualified Name:     bcec
 * JD-Core Version:    0.7.0.1
 */