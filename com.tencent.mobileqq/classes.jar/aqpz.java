import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class aqpz
  extends aqkz<aqpy>
{
  @NonNull
  public aqpy a(int paramInt)
  {
    return new aqpy();
  }
  
  @Nullable
  public aqpy a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("MultiChannelReportProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      localaqpy = aqpy.a(paramArrayOfaqlg[0].a);
      localObject = localaqpy;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiChannelReportProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
        localObject = localaqpy;
      }
    }
    while (!QLog.isColorLevel())
    {
      aqpy localaqpy;
      return localObject;
    }
    QLog.d("MultiChannelReportProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(aqpy paramaqpy)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramaqpy = aqpy.a(paramaqpy);
      QLog.i("MultiChannelReportProcessor", 1, "[onUpdate], strConfig = " + paramaqpy);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramaqpy);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramaqpy)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiChannelReportProcessor", 2, "update msf config, but throw t", paramaqpy);
    }
  }
  
  public Class<aqpy> clazz()
  {
    return aqpy.class;
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
    QLog.i("MultiChannelReportProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpz
 * JD-Core Version:    0.7.0.1
 */