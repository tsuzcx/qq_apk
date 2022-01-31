import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.2;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.3;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.4;
import com.tencent.qqmini.sdk.ipc.AppBrandProxyImpl.5;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdkr
{
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bdks(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private bdku jdField_a_of_type_Bdku;
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private List<Runnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public bdkr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
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
          String str1 = bdle.a().a();
          if (!a()) {
            continue;
          }
          bdnw.c("minisdk-start_AppBrandProxy", "Sync Process Status=" + this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Bdku.a(1, str1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, this.jdField_a_of_type_AndroidOsBundle);
          if (this.jdField_a_of_type_Int != 3) {
            break label123;
          }
          this.jdField_a_of_type_Bdku.a(3, str1, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null);
        }
        catch (Throwable localThrowable)
        {
          bdnw.d("minisdk-start_AppBrandProxy", "onAppStart exception.", localThrowable);
        }
        continue;
        if (this.jdField_a_of_type_Int != 2) {
          continue;
        }
      }
      finally {}
      label123:
      this.jdField_a_of_type_Bdku.a(2, str2, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, null);
    }
  }
  
  private boolean b()
  {
    return bdle.a().a();
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
      bdnw.d("minisdk-start_AppBrandProxy", "doAfterServiceConnected exception!", localThrowable);
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
    //   5: invokespecial 138	bdkr:b	()Z
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
    //   20: getfield 46	bdkr:jdField_a_of_type_Bdku	Lbdku;
    //   23: ifnull +8 -> 31
    //   26: iconst_1
    //   27: istore_1
    //   28: goto -13 -> 15
    //   31: iload_2
    //   32: istore_1
    //   33: aload_0
    //   34: getfield 52	bdkr:jdField_a_of_type_Boolean	Z
    //   37: ifne -22 -> 15
    //   40: iload_2
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 46	bdkr:jdField_a_of_type_Bdku	Lbdku;
    //   46: ifnonnull -31 -> 15
    //   49: ldc 68
    //   51: ldc 140
    //   53: invokestatic 90	bdnw:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: new 142	android/content/Intent
    //   59: dup
    //   60: invokespecial 143	android/content/Intent:<init>	()V
    //   63: astore_3
    //   64: aload_3
    //   65: new 145	android/content/ComponentName
    //   68: dup
    //   69: aload_0
    //   70: getfield 39	bdkr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   73: ldc 147
    //   75: invokespecial 150	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   78: invokevirtual 154	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   81: pop
    //   82: aload_3
    //   83: ldc 156
    //   85: invokestatic 61	bdle:a	()Lbdle;
    //   88: invokevirtual 64	bdle:a	()Ljava/lang/String;
    //   91: invokevirtual 160	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   94: pop
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 52	bdkr:jdField_a_of_type_Boolean	Z
    //   100: aload_0
    //   101: getfield 39	bdkr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   104: aload_3
    //   105: aload_0
    //   106: getfield 37	bdkr:jdField_a_of_type_AndroidContentServiceConnection	Landroid/content/ServiceConnection;
    //   109: iconst_1
    //   110: invokevirtual 166	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   113: pop
    //   114: iload_2
    //   115: istore_1
    //   116: goto -101 -> 15
    //   119: astore_3
    //   120: ldc 68
    //   122: ldc 168
    //   124: aload_3
    //   125: invokestatic 170	bdnw:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: iload_2
    //   129: istore_1
    //   130: goto -115 -> 15
    //   133: astore_3
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	bdkr
    //   8	122	1	bool1	boolean
    //   1	128	2	bool2	boolean
    //   63	42	3	localIntent	android.content.Intent
    //   119	6	3	localThrowable	Throwable
    //   133	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   100	114	119	java/lang/Throwable
    //   4	9	133	finally
    //   19	26	133	finally
    //   33	40	133	finally
    //   42	100	133	finally
    //   100	114	133	finally
    //   120	128	133	finally
  }
  
  /* Error */
  public bdku a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	bdkr:jdField_a_of_type_Bdku	Lbdku;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 46	bdkr:jdField_a_of_type_Bdku	Lbdku;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokespecial 43	bdkr:c	()Z
    //   22: pop
    //   23: aload_0
    //   24: getfield 46	bdkr:jdField_a_of_type_Bdku	Lbdku;
    //   27: astore_1
    //   28: goto -14 -> 14
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	bdkr
    //   13	15	1	localbdku	bdku
    //   31	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	31	finally
    //   18	28	31	finally
  }
  
  protected void a()
  {
    bdnw.c("minisdk-start_AppBrandProxy", "releaseService.");
    try
    {
      if (this.jdField_a_of_type_Bdku != null)
      {
        this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_a_of_type_Bdku = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bdnw.c("minisdk-start_AppBrandProxy", "exception when releaseService.");
    }
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
        bdnw.d("minisdk-start_AppBrandProxy", "onAppStart IAppBrandService Connection is Null.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        bdnw.b("minisdk-start_AppBrandProxy", "notify onAppStart");
        this.jdField_a_of_type_Bdku.a(1, paramString, paramMiniAppInfo, paramBundle);
        if (paramMiniAppInfo == null) {
          continue;
        }
        bdnw.b("minisdk-start_AppBrandProxy", "notify onAppForeground after onAppStart");
        this.jdField_a_of_type_Bdku.a(2, paramString, paramMiniAppInfo, paramBundle);
        return;
      }
      catch (Throwable paramString)
      {
        bdnw.d("minisdk-start_AppBrandProxy", "onAppStart exception.", paramString);
        return;
      }
      this.jdField_a_of_type_Int = paramInt;
      if (a() == null)
      {
        bdnw.d("minisdk-start_AppBrandProxy", "onAppLifecycle IAppBrandService Connection is Null. lifecycle:" + paramInt);
        return;
      }
      try
      {
        bdnw.b("minisdk-start_AppBrandProxy", "notify lifecycle:" + paramInt);
        this.jdField_a_of_type_Bdku.a(paramInt, paramString, paramMiniAppInfo, paramBundle);
        if (paramInt == 4)
        {
          a();
          return;
        }
      }
      catch (Throwable paramString)
      {
        bdnw.d("minisdk-start_AppBrandProxy", "onAppLifecycle exception. lifecycle:" + paramInt, paramString);
      }
    }
  }
  
  public void a(Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    if (a() == null)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "startMiniApp IAppBrandService Connection is Null.");
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.3(this, paramMiniAppInfo, paramBundle, paramResultReceiver, paramActivity));
      return;
    }
    try
    {
      this.jdField_a_of_type_Bdku.a(paramMiniAppInfo, paramBundle, new AppBrandProxyImpl.4(this, new Handler(Looper.getMainLooper()), paramResultReceiver, paramActivity));
      return;
    }
    catch (Throwable paramActivity)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "startMiniApp exception.", paramActivity);
    }
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    bdku localbdku = a();
    paramMiniAppInfo = new AppBrandProxyImpl.2(this, localbdku, paramMiniAppInfo);
    if (localbdku != null)
    {
      paramMiniAppInfo.run();
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramMiniAppInfo);
  }
  
  public void a(String paramString, Bundle paramBundle, bdkz parambdkz)
  {
    if (a() == null)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "sendCmd IAppBrandService Connection is Null. cmd=" + paramString);
      this.jdField_a_of_type_JavaUtilList.add(new AppBrandProxyImpl.5(this, paramString, parambdkz, paramBundle));
      return;
    }
    try
    {
      this.jdField_a_of_type_Bdku.a(paramString, bdle.a().a(), paramBundle, parambdkz);
      return;
    }
    catch (Throwable paramString)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "sendCmd exception.", paramString);
    }
  }
  
  public boolean a()
  {
    bool2 = false;
    if (a() == null)
    {
      bdnw.d("minisdk-start_AppBrandProxy", "queryiIsMiniProcess IAppBrandService Connection is Null.");
      return false;
    }
    try
    {
      Bundle localBundle = this.jdField_a_of_type_Bdku.a("query_mini_process", bdle.a().a(), null);
      bool1 = bool2;
      if (localBundle != null) {
        bool1 = localBundle.getBoolean("key_result");
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bdnw.d("minisdk-start_AppBrandProxy", "queryiIsMiniProcess exception.", localThrowable);
        boolean bool1 = bool2;
      }
    }
    bdnw.b("minisdk-start_AppBrandProxy", "queryiIsMiniProcess " + bool1);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdkr
 * JD-Core Version:    0.7.0.1
 */