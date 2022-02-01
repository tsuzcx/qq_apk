import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class arca
  extends aqwt<arbz>
{
  @NonNull
  public arbz a(int paramInt)
  {
    return new arbz();
  }
  
  @Nullable
  public arbz a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("MultiChannelReportProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      localarbz = arbz.a(paramArrayOfaqxa[0].a);
      localObject = localarbz;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiChannelReportProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
        localObject = localarbz;
      }
    }
    while (!QLog.isColorLevel())
    {
      arbz localarbz;
      return localObject;
    }
    QLog.d("MultiChannelReportProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(arbz paramarbz)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramarbz = arbz.a(paramarbz);
      QLog.i("MultiChannelReportProcessor", 1, "[onUpdate], strConfig = " + paramarbz);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramarbz);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramarbz)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiChannelReportProcessor", 2, "update msf config, but throw t", paramarbz);
    }
  }
  
  public Class<arbz> clazz()
  {
    return arbz.class;
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
 * Qualified Name:     arca
 * JD-Core Version:    0.7.0.1
 */