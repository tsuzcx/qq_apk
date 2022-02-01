package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class h
{
  private static final String a = "h";
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 24	com/huawei/secure/android/common/ssl/util/c:a	()Landroid/content/Context;
    //   3: astore_1
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: ldc 26
    //   10: areturn
    //   11: aload_1
    //   12: invokevirtual 32	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: aload_0
    //   16: iconst_0
    //   17: invokevirtual 38	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   20: getfield 43	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: areturn
    //   26: getstatic 45	com/huawei/secure/android/common/ssl/util/h:a	Ljava/lang/String;
    //   29: ldc 47
    //   31: invokestatic 53	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: ldc 26
    //   36: areturn
    //   37: astore_0
    //   38: getstatic 45	com/huawei/secure/android/common/ssl/util/h:a	Ljava/lang/String;
    //   41: astore_1
    //   42: new 55	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   49: astore_2
    //   50: aload_2
    //   51: ldc 58
    //   53: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 66	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   62: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: aload_2
    //   68: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 53	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: ldc 26
    //   76: areturn
    //   77: astore_0
    //   78: getstatic 45	com/huawei/secure/android/common/ssl/util/h:a	Ljava/lang/String;
    //   81: astore_1
    //   82: new 55	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: ldc 71
    //   93: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_2
    //   98: aload_0
    //   99: invokevirtual 72	android/content/pm/PackageManager$NameNotFoundException:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_1
    //   107: aload_2
    //   108: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 53	com/huawei/secure/android/common/ssl/util/g:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: ldc 26
    //   116: areturn
    //   117: astore_0
    //   118: goto -92 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString	String
    //   3	104	1	localObject	Object
    //   49	59	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	24	37	java/lang/Exception
    //   11	24	77	android/content/pm/PackageManager$NameNotFoundException
    //   11	24	117	finally
  }
  
  public static int b(String paramString)
  {
    Object localObject = c.a();
    if (localObject == null) {
      return 0;
    }
    try
    {
      int i = ((Context)localObject).getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (Exception paramString)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVersion: ");
      localStringBuilder.append(paramString.getMessage());
      g.b((String)localObject, localStringBuilder.toString());
      return 0;
      g.b(a, "getVersion NameNotFoundException");
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label64:
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.h
 * JD-Core Version:    0.7.0.1
 */