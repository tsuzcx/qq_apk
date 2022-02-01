package com.huawei.updatesdk.service.c;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.service.b.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class g
{
  protected static final d a = new d();
  private static final ExecutorService b = Executors.newFixedThreadPool(1);
  
  private static b a(String paramString, d.a parama)
  {
    paramString = a.a(paramString, parama);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Object localObject = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("INSTALL_STATE", paramInt1);
    localBundle.putInt("INSTALL_TYPE", paramInt2);
    ((Intent)localObject).putExtras(localBundle);
    localObject = com.huawei.updatesdk.a.b.c.b.a((Intent)localObject);
    c.a().c((com.huawei.updatesdk.a.b.c.b)localObject);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
  }
  
  private static b b(String paramString)
  {
    return a(paramString, d.a.a);
  }
  
  /* Error */
  private static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 76
    //   5: new 78	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   12: ldc 81
    //   14: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 87
    //   23: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 89
    //   32: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iconst_0
    //   36: invokevirtual 92	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 100	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifeq +14 -> 63
    //   52: ldc 76
    //   54: ldc 108
    //   56: invokestatic 111	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 2
    //   61: monitorexit
    //   62: return
    //   63: new 113	com/huawei/updatesdk/service/c/b
    //   66: dup
    //   67: aload_1
    //   68: aload_0
    //   69: invokespecial 115	com/huawei/updatesdk/service/c/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: astore_0
    //   73: aload_0
    //   74: getstatic 120	com/huawei/updatesdk/service/c/c$a:b	Lcom/huawei/updatesdk/service/c/c$a;
    //   77: invokevirtual 123	com/huawei/updatesdk/service/c/b:a	(Lcom/huawei/updatesdk/service/c/c$a;)V
    //   80: aload_0
    //   81: iconst_0
    //   82: invokevirtual 126	com/huawei/updatesdk/service/c/b:a	(Z)V
    //   85: getstatic 17	com/huawei/updatesdk/service/c/g:a	Lcom/huawei/updatesdk/service/c/d;
    //   88: aload_1
    //   89: aload_0
    //   90: invokevirtual 129	com/huawei/updatesdk/service/c/d:a	(Ljava/lang/String;Lcom/huawei/updatesdk/service/c/b;)Lcom/huawei/updatesdk/service/c/b;
    //   93: pop
    //   94: aload_0
    //   95: getstatic 134	com/huawei/updatesdk/service/c/c$b:a	Lcom/huawei/updatesdk/service/c/c$b;
    //   98: invokevirtual 137	com/huawei/updatesdk/service/c/b:a	(Lcom/huawei/updatesdk/service/c/c$b;)V
    //   101: new 78	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   108: ldc 139
    //   110: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: invokevirtual 141	com/huawei/updatesdk/service/c/b:c	()Ljava/lang/String;
    //   117: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 143
    //   122: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: invokevirtual 145	com/huawei/updatesdk/service/c/b:d	()Ljava/lang/String;
    //   129: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_1
    //   136: new 147	java/lang/Thread
    //   139: dup
    //   140: new 149	com/huawei/updatesdk/service/c/e
    //   143: dup
    //   144: invokestatic 154	com/huawei/updatesdk/a/b/a/a:a	()Lcom/huawei/updatesdk/a/b/a/a;
    //   147: invokevirtual 157	com/huawei/updatesdk/a/b/a/a:b	()Landroid/content/Context;
    //   150: aload_0
    //   151: invokespecial 160	com/huawei/updatesdk/service/c/e:<init>	(Landroid/content/Context;Lcom/huawei/updatesdk/service/c/b;)V
    //   154: invokespecial 163	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   157: astore_0
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual 167	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokevirtual 170	java/lang/Thread:start	()V
    //   167: goto -108 -> 59
    //   170: astore_0
    //   171: ldc 2
    //   173: monitorexit
    //   174: aload_0
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   3	59	170	finally
    //   63	167	170	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.g
 * JD-Core Version:    0.7.0.1
 */