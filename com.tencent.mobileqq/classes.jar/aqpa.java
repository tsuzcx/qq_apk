import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aqpa
  extends aqkz<aqoz>
{
  public static final String a = autn.a + "GameCenterMsgConfigProcessor";
  
  public static aqoz a()
  {
    return (aqoz)aqlk.a().a(608);
  }
  
  @NonNull
  public aqoz a(int paramInt)
  {
    QLog.i(a, 1, "[migrateOldOrDefaultContent] type:" + paramInt);
    aqoz.a();
    return new aqoz();
  }
  
  @Nullable
  public aqoz a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[onParsed]");
    }
    paramArrayOfaqlg = aqoz.a(paramArrayOfaqlg);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (paramArrayOfaqlg != null)) {
      ((autd)localAppRuntime.getManager(358)).a(paramArrayOfaqlg);
    }
    return paramArrayOfaqlg;
  }
  
  public void a(aqoz paramaqoz)
  {
    QLog.i(a, 1, "[onUpdate]");
  }
  
  public Class<aqoz> clazz()
  {
    return aqoz.class;
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
 * Qualified Name:     aqpa
 * JD-Core Version:    0.7.0.1
 */