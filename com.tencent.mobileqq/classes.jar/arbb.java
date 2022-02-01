import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class arbb
  extends aqwt<arba>
{
  public static final String a = avec.a + "GameCenterMsgConfigProcessor";
  
  public static arba a()
  {
    return (arba)aqxe.a().a(608);
  }
  
  @NonNull
  public arba a(int paramInt)
  {
    QLog.i(a, 1, "[migrateOldOrDefaultContent] type:" + paramInt);
    arba.a();
    return new arba();
  }
  
  @Nullable
  public arba a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "[onParsed]");
    }
    paramArrayOfaqxa = arba.a(paramArrayOfaqxa);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (paramArrayOfaqxa != null)) {
      ((avds)localAppRuntime.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(paramArrayOfaqxa);
    }
    return paramArrayOfaqxa;
  }
  
  public void a(arba paramarba)
  {
    QLog.i(a, 1, "[onUpdate]");
  }
  
  public Class<arba> clazz()
  {
    return arba.class;
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
 * Qualified Name:     arbb
 * JD-Core Version:    0.7.0.1
 */