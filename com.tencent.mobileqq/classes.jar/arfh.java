import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class arfh
  extends arac<arfg>
{
  @NonNull
  public arfg a(int paramInt)
  {
    return new arfg();
  }
  
  @Nullable
  public arfg a(araj[] paramArrayOfaraj)
  {
    QLog.i("MultiChannelReportProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      localarfg = arfg.a(paramArrayOfaraj[0].a);
      localObject = localarfg;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiChannelReportProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
        localObject = localarfg;
      }
    }
    while (!QLog.isColorLevel())
    {
      arfg localarfg;
      return localObject;
    }
    QLog.d("MultiChannelReportProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(arfg paramarfg)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramarfg = arfg.a(paramarfg);
      QLog.i("MultiChannelReportProcessor", 1, "[onUpdate], strConfig = " + paramarfg);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramarfg);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramarfg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiChannelReportProcessor", 2, "update msf config, but throw t", paramarfg);
    }
  }
  
  public Class<arfg> clazz()
  {
    return arfg.class;
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
 * Qualified Name:     arfh
 * JD-Core Version:    0.7.0.1
 */