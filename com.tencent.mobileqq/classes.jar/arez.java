import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class arez
  extends arac<arey>
{
  @NonNull
  public arey a(int paramInt)
  {
    return new arey();
  }
  
  @Nullable
  public arey a(araj[] paramArrayOfaraj)
  {
    QLog.i("MSFConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arey localarey = arey.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("MSFConfigProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localarey;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSFConfigProcessor", 2, "onParsed is null");
    }
    return new arey();
  }
  
  public void a(arey paramarey)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramarey = arey.a(paramarey);
      QLog.i("MSFConfigProcessor", 1, "[onUpdate], strConfig = " + paramarey);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramarey);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramarey)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSFConfigProcessor", 2, "update msf config, but throw t", paramarey);
    }
  }
  
  public Class<arey> clazz()
  {
    return arey.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("MSFConfigProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 661;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arez
 * JD-Core Version:    0.7.0.1
 */