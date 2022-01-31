import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class bafq
  extends ampa<bafp>
{
  public int a()
  {
    return 590;
  }
  
  @NonNull
  public bafp a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bafp();
  }
  
  @Nullable
  public bafp a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return bafp.a(paramArrayOfamph[0].a);
    }
    return null;
  }
  
  public Class<bafp> a()
  {
    return bafp.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bafp parambafp)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((baft)((QQAppInterface)localAppRuntime).getManager(355)).a(parambafp, false);
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
 * Qualified Name:     bafq
 * JD-Core Version:    0.7.0.1
 */