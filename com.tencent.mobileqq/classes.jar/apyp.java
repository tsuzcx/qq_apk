import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class apyp
  extends aptq<apyo>
{
  @NonNull
  public apyo a(int paramInt)
  {
    return new apyo();
  }
  
  @Nullable
  public apyo a(aptx[] paramArrayOfaptx)
  {
    QLog.i("MSFConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      apyo localapyo = apyo.a(paramArrayOfaptx[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("MSFConfigProcessor", 2, "onParsed " + paramArrayOfaptx[0].a);
      }
      return localapyo;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSFConfigProcessor", 2, "onParsed is null");
    }
    return new apyo();
  }
  
  public void a(apyo paramapyo)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramapyo = apyo.a(paramapyo);
      QLog.i("MSFConfigProcessor", 1, "[onUpdate], strConfig = " + paramapyo);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramapyo);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramapyo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSFConfigProcessor", 2, "update msf config, but throw t", paramapyo);
    }
  }
  
  public Class<apyo> clazz()
  {
    return apyo.class;
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
 * Qualified Name:     apyp
 * JD-Core Version:    0.7.0.1
 */