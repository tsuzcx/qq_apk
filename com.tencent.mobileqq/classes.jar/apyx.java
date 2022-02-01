import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class apyx
  extends aptq<apyw>
{
  @NonNull
  public apyw a(int paramInt)
  {
    return new apyw();
  }
  
  @Nullable
  public apyw a(aptx[] paramArrayOfaptx)
  {
    QLog.i("MultiChannelReportProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      localapyw = apyw.a(paramArrayOfaptx[0].a);
      localObject = localapyw;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiChannelReportProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
        localObject = localapyw;
      }
    }
    while (!QLog.isColorLevel())
    {
      apyw localapyw;
      return localObject;
    }
    QLog.d("MultiChannelReportProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(apyw paramapyw)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramapyw = apyw.a(paramapyw);
      QLog.i("MultiChannelReportProcessor", 1, "[onUpdate], strConfig = " + paramapyw);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramapyw);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramapyw)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiChannelReportProcessor", 2, "update msf config, but throw t", paramapyw);
    }
  }
  
  public Class<apyw> clazz()
  {
    return apyw.class;
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
 * Qualified Name:     apyx
 * JD-Core Version:    0.7.0.1
 */