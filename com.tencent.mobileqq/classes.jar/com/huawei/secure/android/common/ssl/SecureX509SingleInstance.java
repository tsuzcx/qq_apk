package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.g;
import java.io.InputStream;

public class SecureX509SingleInstance
{
  private static volatile SecureX509TrustManager B;
  private static final String TAG = SecureX509SingleInstance.class.getSimpleName();
  
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
    //   18: getstatic 42	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   21: ifnonnull +123 -> 144
    //   24: ldc 2
    //   26: monitorenter
    //   27: getstatic 42	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   30: ifnonnull +111 -> 141
    //   33: aload_0
    //   34: invokestatic 48	com/huawei/secure/android/common/ssl/util/BksUtil:getFilesBksIS	(Landroid/content/Context;)Ljava/io/InputStream;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnonnull +109 -> 148
    //   42: getstatic 18	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:TAG	Ljava/lang/String;
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
    //   67: invokespecial 77	com/huawei/secure/android/common/ssl/SecureX509TrustManager:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   70: putstatic 42	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   73: getstatic 42	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   76: ifnull +43 -> 119
    //   79: getstatic 42	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   82: invokevirtual 81	com/huawei/secure/android/common/ssl/SecureX509TrustManager:getAcceptedIssuers	()[Ljava/security/cert/X509Certificate;
    //   85: ifnull +34 -> 119
    //   88: getstatic 18	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:TAG	Ljava/lang/String;
    //   91: new 83	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   98: ldc 86
    //   100: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: getstatic 42	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   106: invokevirtual 81	com/huawei/secure/android/common/ssl/SecureX509TrustManager:getAcceptedIssuers	()[Ljava/security/cert/X509Certificate;
    //   109: arraylength
    //   110: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 99	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: new 101	com/huawei/secure/android/common/ssl/util/d
    //   122: dup
    //   123: invokespecial 102	com/huawei/secure/android/common/ssl/util/d:<init>	()V
    //   126: getstatic 108	android/os/AsyncTask:THREAD_POOL_EXECUTOR	Ljava/util/concurrent/Executor;
    //   129: iconst_1
    //   130: anewarray 58	android/content/Context
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: aastore
    //   137: invokevirtual 112	com/huawei/secure/android/common/ssl/util/d:executeOnExecutor	(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   140: pop
    //   141: ldc 2
    //   143: monitorexit
    //   144: getstatic 42	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:B	Lcom/huawei/secure/android/common/ssl/SecureX509TrustManager;
    //   147: areturn
    //   148: getstatic 18	com/huawei/secure/android/common/ssl/SecureX509SingleInstance:TAG	Ljava/lang/String;
    //   151: ldc 114
    //   153: invokestatic 56	com/huawei/secure/android/common/ssl/util/g:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -96 -> 60
    //   159: astore_0
    //   160: ldc 2
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramContext	android.content.Context
    //   37	28	1	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   27	38	159	finally
    //   42	60	159	finally
    //   60	119	159	finally
    //   119	141	159	finally
    //   141	144	159	finally
    //   148	156	159	finally
    //   160	163	159	finally
  }
  
  public static void updateBks(InputStream paramInputStream)
  {
    g.c(TAG, "update bks");
    if ((paramInputStream != null) && (B != null))
    {
      B = new SecureX509TrustManager(paramInputStream, "");
      SecureSSLSocketFactory.a(B);
      SecureApacheSSLSocketFactory.a(B);
      if ((B != null) && (B.getAcceptedIssuers() != null)) {
        g.b(TAG, "after updata bks , ca size is : " + B.getAcceptedIssuers().length);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.SecureX509SingleInstance
 * JD-Core Version:    0.7.0.1
 */