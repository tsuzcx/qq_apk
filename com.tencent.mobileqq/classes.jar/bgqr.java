import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.core.proxy.MiniCodeProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.shell.ILaunchManager.MiniProcessorConfig;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bgqr
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bgql jdField_a_of_type_Bgql;
  private Class jdField_a_of_type_JavaLangClass;
  private Method jdField_a_of_type_JavaLangReflectMethod;
  private Class b;
  
  private static bgql a(Context paramContext)
  {
    bgql localbgql = new bgqn(paramContext).a();
    paramContext = localbgql;
    if (!a(localbgql))
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "Failed to create invalid configuration");
      paramContext = null;
    }
    return paramContext;
  }
  
  private static void a(Context paramContext, List<ILaunchManager.MiniProcessorConfig> paramList)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "registerProcessInfo");
    AppLoaderFactory.g().getLaunchManager().registerProcessInfo(paramList);
    AppLoaderFactory.g().getLaunchManager().init(paramContext);
  }
  
  private static boolean a(bgql parambgql)
  {
    return (parambgql != null) && (parambgql.a != null) && (parambgql.a.size() > 0);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bgql == null)
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "processConfiguration with Configuration is null!");
      return;
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      QMLog.e("minisdk-start_MiniSDKImpl", "processConfiguration with Context is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Bgql.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bgqo)localIterator.next();
      localObject = new ILaunchManager.MiniProcessorConfig(((bgqo)localObject).jdField_a_of_type_ComTencentQqminiSdkLauncherShellProcessType, ((bgqo)localObject).jdField_a_of_type_JavaLangString, ((bgqo)localObject).jdField_a_of_type_JavaLangClass, ((bgqo)localObject).b);
      QMLog.i("minisdk-start_MiniSDKImpl", "createConfiguration. Add processor config: " + localObject);
      localArrayList.add(localObject);
    }
    a(this.jdField_a_of_type_AndroidContentContext, localArrayList);
  }
  
  public Class a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      this.jdField_a_of_type_JavaLangClass = AppLoaderFactory.g().findClass("com.tencent.qqmini.sdk.launcher.MiniAppInfoLoadingFragment");
    }
    return this.jdField_a_of_type_JavaLangClass;
  }
  
  public String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    try
    {
      if (this.b == null) {
        this.b = AppLoaderFactory.g().findClass("com.tencent.qqmini.sdk.core.proxy.ProxyManager");
      }
      if (this.b != null)
      {
        if (this.jdField_a_of_type_JavaLangReflectMethod == null) {
          this.jdField_a_of_type_JavaLangReflectMethod = this.b.getMethod("get", new Class[] { Class.class });
        }
        if (this.jdField_a_of_type_JavaLangReflectMethod != null)
        {
          Object localObject = this.jdField_a_of_type_JavaLangReflectMethod.invoke(null, new Object[] { MiniCodeProxy.class });
          if ((localObject != null) && ((localObject instanceof MiniCodeProxy)))
          {
            paramArrayOfByte = ((MiniCodeProxy)localObject).decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
            return paramArrayOfByte;
          }
        }
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      return "";
    }
    return "";
  }
  
  public void a()
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "stopAllMiniApp");
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().stopAllMiniApp();
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().stopAllMiniApp();
  }
  
  public void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "startMiniApp miniappInfo:" + paramMiniAppInfo);
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().startMiniApp(paramActivity, paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        QMLog.e("minisdk-start_MiniSDKImpl", "Failed to init MiniSDK. context is null");
        return;
      }
      finally {}
      if (this.jdField_a_of_type_Bgql == null) {
        this.jdField_a_of_type_Bgql = a(paramContext);
      }
      if (this.jdField_a_of_type_AndroidContentContext == null)
      {
        QMLog.i("minisdk-start_MiniSDKImpl", "MiniSDK init context.");
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        AppLoaderFactory.g().init(paramContext, this.jdField_a_of_type_Bgql);
        c();
      }
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "preloadMiniApp");
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().preloadMiniApp(paramBundle);
      return;
    }
    QMLog.e("minisdk-start_MiniSDKImpl", "preloadMiniApp should be called only in main process!!!");
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    QMLog.i("minisdk-start_MiniSDKImpl", "stopMiniApp");
    if (AppLoaderFactory.g().isMainProcess())
    {
      AppLoaderFactory.g().getLaunchManager().stopMiniApp(paramMiniAppInfo);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().stopMiniApp(paramMiniAppInfo);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (AppLoaderFactory.g().isMainProcess())
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      AppLoaderFactory.g().getLaunchManager().sendCmdToMiniProcess(1001, localBundle, paramMiniAppInfo, paramResultReceiver);
      return;
    }
    AppLoaderFactory.g().getAppBrandProxy().notifyShareResult(paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  public void b()
  {
    AppLoaderFactory.g().getLaunchManager().onHostAppBackground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqr
 * JD-Core Version:    0.7.0.1
 */