import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class arei
  extends arac<areh>
{
  public static final String a = avln.a + "GameCenterMsgConfigProcessor";
  
  public static areh a()
  {
    return (areh)aran.a().a(608);
  }
  
  @NonNull
  public areh a(int paramInt)
  {
    QLog.i(a, 1, "[migrateOldOrDefaultContent] type:" + paramInt);
    areh.a();
    return new areh();
  }
  
  @Nullable
  public areh a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[onParsed]");
    }
    paramArrayOfaraj = areh.a(paramArrayOfaraj);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (paramArrayOfaraj != null)) {
      ((avld)localAppRuntime.getManager(358)).a(paramArrayOfaraj);
    }
    return paramArrayOfaraj;
  }
  
  public void a(areh paramareh)
  {
    QLog.i(a, 1, "[onUpdate]");
  }
  
  public Class<areh> clazz()
  {
    return areh.class;
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
 * Qualified Name:     arei
 * JD-Core Version:    0.7.0.1
 */