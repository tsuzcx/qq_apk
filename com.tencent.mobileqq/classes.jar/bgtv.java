import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Messenger;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.3;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.4;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.5;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.6;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.7;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.8;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.ipc.IAppMainService;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bgtv
{
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bgtx(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bgtw(this);
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private IAppMainService jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bgtv(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (!b()) {
      this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback));
    }
    c();
  }
  
  private void a(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    QMLog.i("minisdk-start_AppBrandProxy", "Messenger handleCmdFromMainProcess cmd=" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBundle == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_SHARE_RESULT. bundle is null");
      a(paramResultReceiver, -1, paramBundle);
      return;
    }
    a(paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  private static void a(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    if (paramResultReceiver == null) {
      return;
    }
    paramResultReceiver.send(paramInt, paramBundle);
  }
  
  private boolean b()
  {
    return AppLoaderFactory.g().isMainProcess();
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.b;
        if (!bool) {
          return;
        }
        this.b = false;
        try
        {
          String str1 = AppLoaderFactory.g().getCurrentProcessName();
          if (!a()) {
            continue;
          }
          QMLog.w("minisdk-start_AppBrandProxy", "Sync Process Status=" + this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.onAppLifecycle(1, str1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_AndroidOsBundle);
          if (this.jdField_a_of_type_Int != 3) {
            break label123;
          }
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.onAppLifecycle(3, str1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null);
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("minisdk-start_AppBrandProxy", "onAppStart exception.", localThrowable);
        }
        continue;
        if (this.jdField_a_of_type_Int != 2) {
          continue;
        }
      }
      finally {}
      label123:
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.onAppLifecycle(2, str2, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null);
    }
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 49	bgtv:b	()Z
    //   8: istore_1
    //   9: iload_1
    //   10: ifeq +9 -> 19
    //   13: iload_2
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 74	bgtv:jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   23: ifnull +8 -> 31
    //   26: iconst_1
    //   27: istore_1
    //   28: goto -13 -> 15
    //   31: iload_2
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 126	bgtv:jdField_a_of_type_Boolean	Z
    //   37: ifne -22 -> 15
    //   40: iload_2
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 74	bgtv:jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   46: ifnonnull -31 -> 15
    //   49: ldc 78
    //   51: ldc 168
    //   53: invokestatic 105	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 170	android/content/Intent
    //   59: dup
    //   60: aload_0
    //   61: getfield 46	bgtv:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   64: ldc 172
    //   66: invokespecial 175	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   69: astore_3
    //   70: aload_3
    //   71: ldc 177
    //   73: invokestatic 134	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:g	()Lcom/tencent/qqmini/sdk/launcher/AppLoaderFactory;
    //   76: invokevirtual 144	com/tencent/qqmini/sdk/launcher/AppLoaderFactory:getCurrentProcessName	()Ljava/lang/String;
    //   79: invokevirtual 181	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_3
    //   84: ldc 183
    //   86: aload_0
    //   87: getfield 67	bgtv:jdField_a_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   90: invokevirtual 186	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   93: pop
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 126	bgtv:jdField_a_of_type_Boolean	Z
    //   99: aload_0
    //   100: getfield 46	bgtv:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   103: aload_3
    //   104: aload_0
    //   105: getfield 44	bgtv:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   108: iconst_1
    //   109: invokevirtual 192	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   112: pop
    //   113: iload_2
    //   114: istore_1
    //   115: goto -100 -> 15
    //   118: astore_3
    //   119: ldc 78
    //   121: ldc 194
    //   123: aload_3
    //   124: invokestatic 196	com/tencent/qqmini/sdk/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: iload_2
    //   128: istore_1
    //   129: goto -114 -> 15
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	bgtv
    //   8	121	1	bool1	boolean
    //   1	127	2	bool2	boolean
    //   69	35	3	localIntent	android.content.Intent
    //   118	6	3	localThrowable	Throwable
    //   132	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   99	113	118	java/lang/Throwable
    //   4	9	132	finally
    //   19	26	132	finally
    //   33	40	132	finally
    //   42	99	132	finally
    //   99	113	132	finally
    //   119	127	132	finally
  }
  
  private void d()
  {
    try
    {
      Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "doAfterServiceConnected exception!", localThrowable);
    }
  }
  
  /* Error */
  public IAppMainService a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	bgtv:jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 74	bgtv:jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokespecial 70	bgtv:c	()Z
    //   22: pop
    //   23: aload_0
    //   24: getfield 74	bgtv:jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService	Lcom/tencent/qqmini/sdk/launcher/ipc/IAppMainService;
    //   27: astore_1
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	bgtv
    //   13	15	1	localIAppMainService	IAppMainService
    //   31	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	31	finally
    //   18	28	31	finally
  }
  
  protected void a()
  {
    QMLog.w("minisdk-start_AppBrandProxy", "releaseService.");
    try
    {
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService != null)
      {
        this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "exception when releaseService.");
    }
  }
  
  public void a(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Int < 1) {
        this.jdField_a_of_type_Int = 1;
      }
      if (a() == null)
      {
        this.b = true;
        this.jdField_a_of_type_AndroidOsBundle = paramBundle;
        QMLog.e("minisdk-start_AppBrandProxy", "onAppStart IAppBrandService Connection is Null.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        QMLog.i("minisdk-start_AppBrandProxy", "notify onAppStart");
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.onAppLifecycle(1, paramString, paramMiniAppInfo, paramBundle);
        if (paramMiniAppInfo == null) {
          continue;
        }
        QMLog.i("minisdk-start_AppBrandProxy", "notify onAppForeground after onAppStart");
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.onAppLifecycle(2, paramString, paramMiniAppInfo, paramBundle);
        return;
      }
      catch (Throwable paramString)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppStart exception.", paramString);
        return;
      }
      this.jdField_a_of_type_Int = paramInt;
      if (a() == null)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppLifecycle IAppBrandService Connection is Null. lifecycle:" + paramInt);
        return;
      }
      try
      {
        QMLog.i("minisdk-start_AppBrandProxy", "notify lifecycle:" + paramInt);
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.onAppLifecycle(paramInt, paramString, paramMiniAppInfo, paramBundle);
        if (paramInt == 4)
        {
          a();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "onAppLifecycle exception. lifecycle:" + paramInt, paramString);
      }
    }
  }
  
  public void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (a() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp IAppBrandService Connection is Null.");
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.4(this, paramMiniAppInfo, paramBundle, paramResultReceiver, paramActivity));
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.startMiniApp(paramMiniAppInfo, paramBundle, new AppBrandProxyImpl.5(this, new Handler(Looper.getMainLooper()), paramResultReceiver, paramActivity));
      return;
    }
    catch (Throwable paramActivity)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "startMiniApp exception.", paramActivity);
    }
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    IAppMainService localIAppMainService = a();
    paramMiniAppInfo = new AppBrandProxyImpl.3(this, localIAppMainService, paramMiniAppInfo);
    if (localIAppMainService != null)
    {
      paramMiniAppInfo.run();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramMiniAppInfo);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    paramMiniAppInfo = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(paramMiniAppInfo);
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      a(paramResultReceiver, -1, paramBundle);
      return;
    }
    paramMiniAppInfo = paramMiniAppInfo.getRuntime();
    if (paramMiniAppInfo == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      a(paramResultReceiver, -1, paramBundle);
      return;
    }
    bglu localbglu = paramMiniAppInfo.a();
    if (localbglu == null)
    {
      QMLog.w("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, jsService is null");
      a(paramResultReceiver, -1, paramBundle);
      return;
    }
    paramResultReceiver = bgmj.a(paramMiniAppInfo);
    if (paramBundle.getInt("key_share_result") == 0) {}
    for (paramMiniAppInfo = bgop.a(paramResultReceiver.shareEvent, null);; paramMiniAppInfo = bgop.b(paramResultReceiver.shareEvent, null))
    {
      localbglu.a(paramResultReceiver.shareCallbackId, paramMiniAppInfo.toString());
      return;
    }
  }
  
  public void a(String paramString, Bundle paramBundle, MiniCmdCallback paramMiniCmdCallback)
  {
    if (a() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null. cmd=" + paramString);
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.8(this, paramString, paramMiniCmdCallback, paramBundle));
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.sendCmd(paramString, AppLoaderFactory.g().getCurrentProcessName(), paramBundle, paramMiniCmdCallback);
      return;
    }
    catch (Throwable paramString)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "sendCmd exception.", paramString);
    }
  }
  
  public boolean a()
  {
    bool2 = false;
    if (a() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "queryiIsMiniProcess IAppBrandService Connection is Null.");
      return false;
    }
    try
    {
      Bundle localBundle = this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.requestAync("query_mini_process", AppLoaderFactory.g().getCurrentProcessName(), null);
      bool1 = bool2;
      if (localBundle != null) {
        bool1 = localBundle.getBoolean("key_result");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("minisdk-start_AppBrandProxy", "queryiIsMiniProcess exception.", localThrowable);
        boolean bool1 = bool2;
      }
    }
    QMLog.i("minisdk-start_AppBrandProxy", "queryiIsMiniProcess " + bool1);
    return bool1;
  }
  
  public void b()
  {
    if (a() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopAllMiniApp IAppBrandService Connection is Null.");
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.7(this));
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.stopAllMiniApp();
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", localThrowable);
    }
  }
  
  public void b(MiniAppInfo paramMiniAppInfo)
  {
    if (a() == null)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp IAppBrandService Connection is Null.");
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.6(this, paramMiniAppInfo));
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherIpcIAppMainService.stopMiniApp(paramMiniAppInfo);
      return;
    }
    catch (Throwable paramMiniAppInfo)
    {
      QMLog.e("minisdk-start_AppBrandProxy", "stopMiniApp exception.", paramMiniAppInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtv
 * JD-Core Version:    0.7.0.1
 */