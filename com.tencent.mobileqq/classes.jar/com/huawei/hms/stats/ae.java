package com.huawei.hms.stats;

import android.text.TextUtils;

public class ae
{
  private static ae a = new ae();
  private ae.a b = new ae.a(this);
  
  public static ae a()
  {
    return a;
  }
  
  /* Error */
  private String f()
  {
    // Byte code:
    //   0: invokestatic 36	com/huawei/hms/stats/b:j	()Landroid/content/Context;
    //   3: invokevirtual 42	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: invokevirtual 48	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   9: ldc 50
    //   11: invokevirtual 56	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: invokestatic 61	com/huawei/hms/stats/ba:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   21: astore_3
    //   22: aload_2
    //   23: invokestatic 64	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   26: aload_3
    //   27: areturn
    //   28: astore_1
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: ldc 66
    //   35: ldc 68
    //   37: invokestatic 74	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokestatic 64	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   44: aconst_null
    //   45: areturn
    //   46: astore_1
    //   47: aconst_null
    //   48: astore_3
    //   49: aload_1
    //   50: astore_2
    //   51: aload_3
    //   52: invokestatic 64	com/huawei/hms/stats/ba:a	(Ljava/io/Closeable;)V
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: aload_1
    //   59: astore_3
    //   60: goto -9 -> 51
    //   63: astore_1
    //   64: goto -33 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	ae
    //   16	1	1	localObject1	Object
    //   28	1	1	localIOException1	java.io.IOException
    //   32	1	1	localObject2	Object
    //   46	13	1	localObject3	Object
    //   63	1	1	localIOException2	java.io.IOException
    //   14	42	2	localObject4	Object
    //   57	1	2	localObject5	Object
    //   21	39	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	28	java/io/IOException
    //   0	15	46	finally
    //   17	22	57	finally
    //   33	40	57	finally
    //   17	22	63	java/io/IOException
  }
  
  public void b()
  {
    long l1 = e();
    if (l1 == 0L)
    {
      l1 = System.currentTimeMillis();
      str1 = f();
      if (TextUtils.isEmpty(str1)) {
        af.c("hmsSdk", "get rsa pubkey config error");
      }
    }
    long l2;
    do
    {
      return;
      str2 = e.a().b(e.a.a);
      String str3 = e.a().a(e.a.b).b(str1, str2);
      this.b.a(str1);
      this.b.a(l1);
      this.b.b(str2);
      this.b.c(str3);
      return;
      l2 = System.currentTimeMillis();
    } while (l2 - l1 <= 43200000L);
    String str2 = this.b.a;
    String str1 = e.a().b(e.a.a);
    str2 = e.a().a(e.a.b).b(str2, str1);
    this.b.a(l2);
    this.b.b(str1);
    this.b.c(str2);
  }
  
  public String c()
  {
    return this.b.b;
  }
  
  public String d()
  {
    return this.b.c;
  }
  
  public long e()
  {
    return this.b.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.ae
 * JD-Core Version:    0.7.0.1
 */