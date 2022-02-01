import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class aqpr
  extends aqkz<aqpq>
{
  @NonNull
  public aqpq a(int paramInt)
  {
    return new aqpq();
  }
  
  @Nullable
  public aqpq a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("MSFConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqpq localaqpq = aqpq.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("MSFConfigProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaqpq;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSFConfigProcessor", 2, "onParsed is null");
    }
    return new aqpq();
  }
  
  public void a(aqpq paramaqpq)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramaqpq = aqpq.a(paramaqpq);
      QLog.i("MSFConfigProcessor", 1, "[onUpdate], strConfig = " + paramaqpq);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramaqpq);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramaqpq)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSFConfigProcessor", 2, "update msf config, but throw t", paramaqpq);
    }
  }
  
  public Class<aqpq> clazz()
  {
    return aqpq.class;
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
 * Qualified Name:     aqpr
 * JD-Core Version:    0.7.0.1
 */