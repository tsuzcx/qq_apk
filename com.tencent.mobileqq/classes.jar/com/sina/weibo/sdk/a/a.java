package com.sina.weibo.sdk.a;

import android.content.Context;
import com.sina.weibo.sdk.c.c;
import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo;
import com.weibo.ssosdk.WeiboSsoSdkConfig;

public final class a
{
  public String c = "";
  
  private static void a(Context paramContext, String paramString)
  {
    WeiboSsoSdkConfig localWeiboSsoSdkConfig = new WeiboSsoSdkConfig();
    localWeiboSsoSdkConfig.setContext(paramContext.getApplicationContext());
    localWeiboSsoSdkConfig.setAppKey(paramString);
    localWeiboSsoSdkConfig.setFrom("1478195010");
    localWeiboSsoSdkConfig.setWm("1000_0001");
    WeiboSsoSdk.initConfig(localWeiboSsoSdkConfig);
  }
  
  public static a b()
  {
    try
    {
      a locala = a.a.c();
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_2
    //   4: invokestatic 60	com/sina/weibo/sdk/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   7: invokestatic 64	com/weibo/ssosdk/WeiboSsoSdk:getInstance	()Lcom/weibo/ssosdk/WeiboSsoSdk;
    //   10: new 66	com/sina/weibo/sdk/a/a$1
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 69	com/sina/weibo/sdk/a/a$1:<init>	(Lcom/sina/weibo/sdk/a/a;)V
    //   18: invokevirtual 73	com/weibo/ssosdk/WeiboSsoSdk:visitorLogin	(Lcom/weibo/ssosdk/VisitorLoginListener;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: ldc 75
    //   27: aload_1
    //   28: invokevirtual 79	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   31: invokestatic 84	com/sina/weibo/sdk/c/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: goto -13 -> 21
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	a
    //   0	42	1	paramContext	Context
    //   0	42	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   7	21	24	java/lang/Exception
    //   2	7	37	finally
    //   7	21	37	finally
    //   25	34	37	finally
  }
  
  public final String c(Context paramContext, String paramString)
  {
    a(paramContext, paramString);
    try
    {
      this.c = WeiboSsoSdk.getInstance().visitorLogin().getAid();
      return this.c;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        c.b("AidManager", paramContext.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */