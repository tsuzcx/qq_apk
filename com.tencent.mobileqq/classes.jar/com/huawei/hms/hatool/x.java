package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class x
{
  public static x b = new x();
  public x.a a = new x.a(this);
  
  public static x f()
  {
    return b;
  }
  
  public String a()
  {
    return this.a.c;
  }
  
  public long b()
  {
    return this.a.d;
  }
  
  public String c()
  {
    return this.a.b;
  }
  
  public void d()
  {
    long l1 = b();
    String str1;
    String str2;
    if (l1 == 0L)
    {
      l1 = System.currentTimeMillis();
      str1 = e();
      if (TextUtils.isEmpty(str1))
      {
        y.f("hmsSdk", "get rsa pubkey config error");
        return;
      }
      str2 = EncryptUtil.generateSecureRandomStr(16);
      String str3 = e.a(str1, str2);
      this.a.b(str1);
      this.a.a(l1);
      this.a.c(str2);
      this.a.a(str3);
      return;
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 43200000L)
    {
      str2 = this.a.a;
      str1 = EncryptUtil.generateSecureRandomStr(16);
      str2 = e.a(str2, str1);
      this.a.a(l2);
      this.a.c(str1);
      this.a.a(str2);
    }
  }
  
  /* Error */
  public final String e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 96	com/huawei/hms/hatool/b:f	()Landroid/content/Context;
    //   5: invokevirtual 102	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: invokevirtual 108	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   11: ldc 110
    //   13: invokevirtual 116	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_2
    //   20: invokestatic 121	com/huawei/hms/hatool/r0:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_2
    //   25: invokestatic 124	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   28: aload_3
    //   29: areturn
    //   30: astore_2
    //   31: goto +21 -> 52
    //   34: aconst_null
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: ldc 57
    //   40: ldc 126
    //   42: invokestatic 64	com/huawei/hms/hatool/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_2
    //   46: invokestatic 124	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   49: aconst_null
    //   50: areturn
    //   51: astore_2
    //   52: aload_1
    //   53: invokestatic 124	com/huawei/hms/hatool/r0:a	(Ljava/io/Closeable;)V
    //   56: aload_2
    //   57: athrow
    //   58: astore_1
    //   59: goto -25 -> 34
    //   62: astore_1
    //   63: goto -27 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	x
    //   1	52	1	localObject1	Object
    //   58	1	1	localIOException1	java.io.IOException
    //   62	1	1	localIOException2	java.io.IOException
    //   16	9	2	localInputStream	java.io.InputStream
    //   30	1	2	localObject2	Object
    //   35	11	2	localCloseable	java.io.Closeable
    //   51	6	2	localObject3	Object
    //   23	6	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	17	30	finally
    //   19	24	51	finally
    //   38	45	51	finally
    //   2	17	58	java/io/IOException
    //   19	24	62	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.x
 * JD-Core Version:    0.7.0.1
 */