import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class apxy
  extends aptq<apxx>
{
  public static final String a = atyn.a + "GameCenterMsgConfigProcessor";
  
  public static apxx a()
  {
    return (apxx)apub.a().a(608);
  }
  
  @NonNull
  public apxx a(int paramInt)
  {
    QLog.i(a, 1, "[migrateOldOrDefaultContent] type:" + paramInt);
    apxx.a();
    return new apxx();
  }
  
  @Nullable
  public apxx a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[onParsed]");
    }
    paramArrayOfaptx = apxx.a(paramArrayOfaptx);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (paramArrayOfaptx != null)) {
      ((atyd)localAppRuntime.getManager(358)).a(paramArrayOfaptx);
    }
    return paramArrayOfaptx;
  }
  
  public void a(apxx paramapxx)
  {
    QLog.i(a, 1, "[onUpdate]");
  }
  
  public Class<apxx> clazz()
  {
    return apxx.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt) {}
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReqNoReceive: type=" + type());
    }
  }
  
  public int type()
  {
    return 608;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apxy
 * JD-Core Version:    0.7.0.1
 */