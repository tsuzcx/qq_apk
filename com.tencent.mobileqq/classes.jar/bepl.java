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
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bepl
{
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bepn(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bepm(this);
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private bepp jdField_a_of_type_Bepp;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bepl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (!b()) {
      this.jdField_a_of_type_AndroidOsMessenger = new Messenger(new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback));
    }
    c();
  }
  
  private void a(int paramInt, Bundle paramBundle, MiniAppInfo paramMiniAppInfo, ResultReceiver paramResultReceiver)
  {
    betc.b("minisdk-start_AppBrandProxy", "Messenger handleCmdFromMainProcess cmd=" + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBundle == null)
    {
      betc.c("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore MESSENGER_CMD_SHARE. bundle is null");
      a(paramResultReceiver, -1, paramBundle);
      return;
    }
    a(paramBundle.getInt("id"), paramMiniAppInfo, paramBundle, paramResultReceiver);
  }
  
  private static void a(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    if (paramResultReceiver == null) {
      return;
    }
    paramResultReceiver.send(paramInt, paramBundle);
  }
  
  private void b()
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
          String str1 = beqb.a().a();
          if (!a()) {
            continue;
          }
          betc.c("minisdk-start_AppBrandProxy", "Sync Process Status=" + this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Bepp.a(1, str1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_AndroidOsBundle);
          if (this.jdField_a_of_type_Int != 3) {
            break label123;
          }
          this.jdField_a_of_type_Bepp.a(3, str1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null);
        }
        catch (Throwable localThrowable)
        {
          betc.d("minisdk-start_AppBrandProxy", "onAppStart exception.", localThrowable);
        }
        continue;
        if (this.jdField_a_of_type_Int != 2) {
          continue;
        }
      }
      finally {}
      label123:
      this.jdField_a_of_type_Bepp.a(2, str2, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null);
    }
  }
  
  private boolean b()
  {
    return beqb.a().a();
  }
  
  private void c()
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
      betc.d("minisdk-start_AppBrandProxy", "doAfterServiceConnected exception!", localThrowable);
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
    //   5: invokespecial 49	bepl:b	()Z
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
    //   20: getfield 74	bepl:jdField_a_of_type_Bepp	Lbepp;
    //   23: ifnull +8 -> 31
    //   26: iconst_1
    //   27: istore_1
    //   28: goto -13 -> 15
    //   31: iload_2
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 131	bepl:jdField_a_of_type_Boolean	Z
    //   37: ifne -22 -> 15
    //   40: iload_2
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 74	bepl:jdField_a_of_type_Bepp	Lbepp;
    //   46: ifnonnull -31 -> 15
    //   49: ldc 78
    //   51: ldc 196
    //   53: invokestatic 103	betc:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 198	android/content/Intent
    //   59: dup
    //   60: aload_0
    //   61: getfield 46	bepl:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   64: ldc 200
    //   66: invokespecial 203	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   69: astore_3
    //   70: aload_3
    //   71: ldc 205
    //   73: invokestatic 140	beqb:a	()Lbeqb;
    //   76: invokevirtual 142	beqb:a	()Ljava/lang/String;
    //   79: invokevirtual 209	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   82: pop
    //   83: aload_3
    //   84: ldc 211
    //   86: aload_0
    //   87: getfield 67	bepl:jdField_a_of_type_AndroidOsMessenger	Landroid/os/Messenger;
    //   90: invokevirtual 214	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   93: pop
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 131	bepl:jdField_a_of_type_Boolean	Z
    //   99: aload_0
    //   100: getfield 46	bepl:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   103: aload_3
    //   104: aload_0
    //   105: getfield 44	bepl:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   108: iconst_1
    //   109: invokevirtual 220	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   112: pop
    //   113: iload_2
    //   114: istore_1
    //   115: goto -100 -> 15
    //   118: astore_3
    //   119: ldc 78
    //   121: ldc 222
    //   123: aload_3
    //   124: invokestatic 224	betc:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   0	137	0	this	bepl
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
  
  /* Error */
  public bepp a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	bepl:jdField_a_of_type_Bepp	Lbepp;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 74	bepl:jdField_a_of_type_Bepp	Lbepp;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokespecial 70	bepl:c	()Z
    //   22: pop
    //   23: aload_0
    //   24: getfield 74	bepl:jdField_a_of_type_Bepp	Lbepp;
    //   27: astore_1
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	bepl
    //   13	15	1	localbepp	bepp
    //   31	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	31	finally
    //   18	28	31	finally
  }
  
  protected void a()
  {
    betc.c("minisdk-start_AppBrandProxy", "releaseService.");
    try
    {
      if (this.jdField_a_of_type_Bepp != null)
      {
        this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_a_of_type_Bepp = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.c("minisdk-start_AppBrandProxy", "exception when releaseService.");
    }
  }
  
  public void a(int paramInt, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    paramMiniAppInfo = beqf.a().a(paramMiniAppInfo);
    if (paramMiniAppInfo == null)
    {
      betc.c("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime loader is null");
      a(paramResultReceiver, -1, paramBundle);
      return;
    }
    paramMiniAppInfo = paramMiniAppInfo.getRuntime();
    if (paramMiniAppInfo == null)
    {
      betc.c("minisdk-start_AppBrandProxy", "handleCmdFromMainProcess. Ignore, runtime is null");
      a(paramResultReceiver, -1, paramBundle);
      return;
    }
    switch (paramInt)
    {
    default: 
      betc.b("minisdk-start_AppBrandProxy", "handleCmdShare. SHARE_OTHER");
      paramMiniAppInfo.a(bekm.a(14, paramBundle));
      return;
    case 1: 
      betc.b("minisdk-start_AppBrandProxy", "handleCmdShare. SHARE_QQ");
      paramMiniAppInfo.a(bekm.a(2));
      return;
    case 2: 
      betc.b("minisdk-start_AppBrandProxy", "handleCmdShare. SHARE_QZONE");
      paramMiniAppInfo.a(bekm.a(6));
      return;
    case 3: 
      betc.b("minisdk-start_AppBrandProxy", "handleCmdShare. SHARE_WX_FRIEND");
      paramMiniAppInfo.a(bekm.a(7));
      return;
    case 4: 
      betc.b("minisdk-start_AppBrandProxy", "handleCmdShare. SHARE_WX_MOMENT");
      paramMiniAppInfo.a(bekm.a(8));
      return;
    }
    betc.b("minisdk-start_AppBrandProxy", "handleCmdShare. SHARE_QQ_CHAT");
    paramMiniAppInfo.a(bekm.a(13, paramBundle));
  }
  
  public void a(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, Bundle paramBundle)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Int < 1) {
        this.jdField_a_of_type_Int = 1;
      }
      if (a() == null)
      {
        this.b = true;
        this.jdField_a_of_type_AndroidOsBundle = paramBundle;
        betc.d("minisdk-start_AppBrandProxy", "onAppStart IAppBrandService Connection is Null.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        betc.b("minisdk-start_AppBrandProxy", "notify onAppStart");
        this.jdField_a_of_type_Bepp.a(1, paramString, paramMiniAppInfo, paramBundle);
        if (paramMiniAppInfo == null) {
          continue;
        }
        betc.b("minisdk-start_AppBrandProxy", "notify onAppForeground after onAppStart");
        this.jdField_a_of_type_Bepp.a(2, paramString, paramMiniAppInfo, paramBundle);
        return;
      }
      catch (Throwable paramString)
      {
        betc.d("minisdk-start_AppBrandProxy", "onAppStart exception.", paramString);
        return;
      }
      this.jdField_a_of_type_Int = paramInt;
      if (a() == null)
      {
        betc.d("minisdk-start_AppBrandProxy", "onAppLifecycle IAppBrandService Connection is Null. lifecycle:" + paramInt);
        return;
      }
      try
      {
        betc.b("minisdk-start_AppBrandProxy", "notify lifecycle:" + paramInt);
        this.jdField_a_of_type_Bepp.a(paramInt, paramString, paramMiniAppInfo, paramBundle);
        if (paramInt == 4)
        {
          a();
          return;
        }
      }
      catch (Throwable paramString)
      {
        betc.d("minisdk-start_AppBrandProxy", "onAppLifecycle exception. lifecycle:" + paramInt, paramString);
      }
    }
  }
  
  public void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (a() == null)
    {
      betc.d("minisdk-start_AppBrandProxy", "startMiniApp IAppBrandService Connection is Null.");
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.4(this, paramMiniAppInfo, paramBundle, paramResultReceiver, paramActivity));
      return;
    }
    try
    {
      this.jdField_a_of_type_Bepp.a(paramMiniAppInfo, paramBundle, new AppBrandProxyImpl.5(this, new Handler(Looper.getMainLooper()), paramResultReceiver, paramActivity));
      return;
    }
    catch (Throwable paramActivity)
    {
      betc.d("minisdk-start_AppBrandProxy", "startMiniApp exception.", paramActivity);
    }
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    bepp localbepp = a();
    paramMiniAppInfo = new AppBrandProxyImpl.3(this, localbepp, paramMiniAppInfo);
    if (localbepp != null)
    {
      paramMiniAppInfo.run();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramMiniAppInfo);
  }
  
  public void a(String paramString, Bundle paramBundle, bepu parambepu)
  {
    if (a() == null)
    {
      betc.d("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null. cmd=" + paramString);
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.6(this, paramString, parambepu, paramBundle));
      return;
    }
    try
    {
      this.jdField_a_of_type_Bepp.a(paramString, beqb.a().a(), paramBundle, parambepu);
      return;
    }
    catch (Throwable paramString)
    {
      betc.d("minisdk-start_AppBrandProxy", "sendCmd exception.", paramString);
    }
  }
  
  public boolean a()
  {
    bool2 = false;
    if (a() == null)
    {
      betc.d("minisdk-start_AppBrandProxy", "queryiIsMiniProcess IAppBrandService Connection is Null.");
      return false;
    }
    try
    {
      Bundle localBundle = this.jdField_a_of_type_Bepp.a("query_mini_process", beqb.a().a(), null);
      bool1 = bool2;
      if (localBundle != null) {
        bool1 = localBundle.getBoolean("key_result");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        betc.d("minisdk-start_AppBrandProxy", "queryiIsMiniProcess exception.", localThrowable);
        boolean bool1 = bool2;
      }
    }
    betc.b("minisdk-start_AppBrandProxy", "queryiIsMiniProcess " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bepl
 * JD-Core Version:    0.7.0.1
 */