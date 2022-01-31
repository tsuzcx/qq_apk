import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class bafc
  extends ampb<bafb>
{
  public int a()
  {
    return 590;
  }
  
  @NonNull
  public bafb a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bafb();
  }
  
  @Nullable
  public bafb a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return bafb.a(paramArrayOfampi[0].a);
    }
    return null;
  }
  
  public Class<bafb> a()
  {
    return bafb.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bafb parambafb)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((baff)((QQAppInterface)localAppRuntime).getManager(355)).a(parambafb, false);
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
 * Qualified Name:     bafc
 * JD-Core Version:    0.7.0.1
 */