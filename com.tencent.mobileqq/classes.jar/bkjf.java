import NS_KING_PUBLIC.stAuth;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.ilive.IliveShadowImpl.1;
import java.util.concurrent.ExecutorService;

public class bkjf
  implements IShadow
{
  private static bkjf jdField_a_of_type_Bkjf;
  private bkjh jdField_a_of_type_Bkjh;
  private PluginManager jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  private bkjf()
  {
    setILoggerFactory();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = ThreadManagerExecutor.getSingleThreadExecutorService(192);
  }
  
  public static bkjf a()
  {
    if (jdField_a_of_type_Bkjf == null) {}
    try
    {
      if (jdField_a_of_type_Bkjf == null) {
        jdField_a_of_type_Bkjf = new bkjf();
      }
      return jdField_a_of_type_Bkjf;
    }
    finally {}
  }
  
  private PluginManager a(Context paramContext, String paramString)
  {
    if (bkiz.a().a()) {
      return new DynamicPluginManager(bkiz.a().a());
    }
    return new DynamicPluginManager(new bkis());
  }
  
  private void a(Context paramContext, long paramLong, PluginManager paramPluginManager, Bundle paramBundle, stAuth paramstAuth, EnterCallback paramEnterCallback)
  {
    bkkd.a("IliveLaunch enterWithAuth");
    Bundle localBundle2 = paramBundle.getBundle("KEY_EXTRAS");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    if (QLog.isColorLevel()) {
      QLog.e("IliveAuthShadowImpl", 2, "start enterWithAuth  , uid = " + paramstAuth.sUid);
    }
    localBundle1.putString("openID", paramstAuth.sUid);
    localBundle1.putString("token", paramstAuth.sSessionKey);
    localBundle1.putInt("auth_type", 0);
    paramBundle.putBundle("KEY_EXTRAS", localBundle1);
    try
    {
      paramPluginManager.enter(paramContext, paramLong, paramBundle, new bkjg(this, paramEnterCallback, paramLong));
      bkkd.b("IliveLaunch enterWithAuth");
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.e("IliveAuthShadowImpl", 1, "enterWithAuth exception , e = " + paramContext.getMessage());
      }
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    try
    {
      paramString2 = getPluginManager(paramContext, paramString1, paramString2);
      bkvd.c("IliveAuthShadowImpl", "enter: " + paramLong + ", frameVersion = " + "1");
      bkkd.a("stAuth");
      if (paramString2 != null)
      {
        long l = System.currentTimeMillis();
        paramBundle.putString("hostuid", paramString1);
        paramBundle.putString("hostVersion", "8.4.8");
        paramBundle.putInt("key_frame_version", Integer.valueOf("1").intValue());
        paramBundle.putLong("entryTime", l);
        if (!bkiz.a().a())
        {
          paramBundle.putString("pluginZipPath", bkiz.a().c());
          paramBundle.putString("pluginZipMD5", bkiz.a().d());
        }
        paramBundle.putBoolean("isDebugVersion", false);
        paramBundle.putString("qqVersion", AppSetting.a);
        paramString1 = bkju.a().a();
        if (paramString1 != null)
        {
          QLog.e("IliveAuthShadowImpl", 1, "[enterWithAuth] use local auth !");
          a(paramContext, paramLong, paramString2, paramBundle, paramString1, paramEnterCallback);
          return;
        }
        QLog.e("IliveAuthShadowImpl", 1, "[enterWithAuth] start request getStAuth");
        this.jdField_a_of_type_Bkjh = new bkjh(this, paramString2, paramLong, paramContext, paramBundle, paramEnterCallback);
        bkju.a().a(this.jdField_a_of_type_Bkjh);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      QLog.e("IliveAuthShadowImpl", 1, "enter exception ", paramContext);
      return;
    }
    QLog.e("IliveAuthShadowImpl", 1, "[enter] pluginManager is null !");
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new IliveShadowImpl.1(this, paramContext, paramString1, paramString2, paramLong, paramBundle, paramEnterCallback));
  }
  
  public PluginManager getPluginManager(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager = a(paramContext, paramString1);
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager;
  }
  
  public boolean hasPluginManager()
  {
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManager != null;
  }
  
  public void setILoggerFactory()
  {
    try
    {
      LoggerFactory.setILoggerFactory(aulz.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjf
 * JD-Core Version:    0.7.0.1
 */