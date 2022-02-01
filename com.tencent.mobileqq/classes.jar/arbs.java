import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class arbs
  extends aqwt<arbr>
{
  @NonNull
  public arbr a(int paramInt)
  {
    return new arbr();
  }
  
  @Nullable
  public arbr a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("MSFConfigProcessor", 1, "[onParsed] config");
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arbr localarbr = arbr.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("MSFConfigProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localarbr;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSFConfigProcessor", 2, "onParsed is null");
    }
    return new arbr();
  }
  
  public void a(arbr paramarbr)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {}
    try
    {
      paramarbr = arbr.a(paramarbr);
      QLog.i("MSFConfigProcessor", 1, "[onUpdate], strConfig = " + paramarbr);
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 2214);
      localNewIntent.putExtra("manager_config", paramarbr);
      localAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Throwable paramarbr)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSFConfigProcessor", 2, "update msf config, but throw t", paramarbr);
    }
  }
  
  public Class<arbr> clazz()
  {
    return arbr.class;
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
 * Qualified Name:     arbs
 * JD-Core Version:    0.7.0.1
 */