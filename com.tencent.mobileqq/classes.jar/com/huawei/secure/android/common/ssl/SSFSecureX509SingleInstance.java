package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.g;
import java.io.InputStream;

public class SSFSecureX509SingleInstance
{
  private static volatile SecureX509TrustManager B;
  private static final String TAG = SSFSecureX509SingleInstance.class.getSimpleName();
  
  /* Error */
  @android.support.annotation.RequiresApi(api=11)
  public static SecureX509TrustManager getInstance(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 29	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 31
    //   10: invokespecial 34	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_0
    //   15: invokestatic 40	com/huawei/secure/android/common/ssl/util/c:setContext	(Landroid/content/Context;)V
    //   18: getstatic 42	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   21: ifnonnull +124 -> 145
    //   24: ldc 2
    //   26: monitorenter
    //   27: getstatic 42	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   30: ifnonnull +112 -> 142
    //   33: aload_0
    //   34: invokestatic 48	com/huawei/secure/android/common/ssl/util/BksUtil:getFilesBksIS	(Landroid/content/Context;)Ljava/io/InputStream;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnonnull +110 -> 149
    //   42: getstatic 18	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:TAG	Ljava/lang/String;
    //   45: ldc 50
    //   47: invokestatic 56	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 62	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   54: ldc 64
    //   56: invokevirtual 70	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: astore_1
    //   60: new 72	com/huawei/secure/android/common/ssl/SecureX509TrustManager
    //   63: dup
    //   64: aload_1
    //   65: ldc 74
    //   67: iconst_1
    //   68: invokespecial 77	com/huawei/secure/android/common/ssl/SecureX509TrustManager:<init>	(Ljava/io/InputStream;Ljava/lang/String;Z)V
    //   71: putstatic 42	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   74: getstatic 42	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   77: ifnull +43 -> 120
    //   80: getstatic 42	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   83: invokevirtual 81	com/huawei/secure/android/common/ssl/SecureX509TrustManager:getAcceptedIssuers	()[Ljava/security/cert/X509Certificate;
    //   86: ifnull +34 -> 120
    //   89: getstatic 18	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:TAG	Ljava/lang/String;
    //   92: new 83	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   99: ldc 86
    //   101: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: getstatic 42	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   107: invokevirtual 81	com/huawei/secure/android/common/ssl/SecureX509TrustManager:getAcceptedIssuers	()[Ljava/security/cert/X509Certificate;
    //   110: arraylength
    //   111: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 56	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: new 98	com/huawei/secure/android/common/ssl/util/e
    //   123: dup
    //   124: invokespecial 99	com/huawei/secure/android/common/ssl/util/e:<init>	()V
    //   127: getstatic 105	android/os/AsyncTask:THREAD_POOL_EXECUTOR	Ljava/util/concurrent/Executor;
    //   130: iconst_1
    //   131: anewarray 58	android/content/Context
    //   134: dup
    //   135: iconst_0
    //   136: aload_0
    //   137: aastore
    //   138: invokevirtual 109	com/huawei/secure/android/common/ssl/util/e:executeOnExecutor	(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   141: pop
    //   142: ldc 2
    //   144: monitorexit
    //   145: getstatic 42	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   148: areturn
    //   149: getstatic 18	com/huawei/secure/android/common/ssl/SSFSecureX509SingleInstance:TAG	Ljava/lang/String;
    //   152: ldc 111
    //   154: invokestatic 56	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: goto -97 -> 60
    //   160: astore_0
    //   161: ldc 2
    //   163: monitorexit
    //   164: aload_0
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramContext	android.content.Context
    //   37	28	1	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   27	38	160	finally
    //   42	60	160	finally
    //   60	120	160	finally
    //   120	142	160	finally
    //   142	145	160	finally
    //   149	157	160	finally
    //   161	164	160	finally
  }
  
  public static void updateBks(InputStream paramInputStream)
  {
    g.c(TAG, "update bks");
    if ((paramInputStream != null) && (B != null))
    {
      B = new SecureX509TrustManager(paramInputStream, "", true);
      SSFCompatiableSystemCA.a(B);
      SASFCompatiableSystemCA.a(B);
      if ((B != null) && (B.getAcceptedIssuers() != null)) {
        g.b(TAG, "after updata bks , ca size is : " + B.getAcceptedIssuers().length);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SSFSecureX509SingleInstance
 * JD-Core Version:    0.7.0.1
 */