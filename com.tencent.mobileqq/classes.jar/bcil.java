import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import mqq.app.AppRuntime;

public class bcil
  extends aokh<bcik>
{
  public int a()
  {
    return 590;
  }
  
  @NonNull
  public bcik a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new bcik();
  }
  
  @Nullable
  public bcik a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return bcik.a(paramArrayOfaoko[0].a);
    }
    return null;
  }
  
  public Class<bcik> a()
  {
    return bcik.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopShortcutBarConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(bcik parambcik)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((bcio)((QQAppInterface)localAppRuntime).getManager(355)).a(parambcik, false);
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
 * Qualified Name:     bcil
 * JD-Core Version:    0.7.0.1
 */