package com.tencent.luggage.wxa.mn;

import android.text.TextUtils;
import com.tencent.luggage.wxa.rt.k;
import java.util.ArrayList;

public class a
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return c(b(paramString));
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if ((paramArrayOfString[i] != null) && (paramArrayOfString[i].startsWith("data:image/"))) {
        arrayOfString[i] = a(paramArrayOfString[i]);
      } else {
        arrayOfString[i] = paramArrayOfString[i];
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      if ((paramArrayOfString1[i] != null) && (paramArrayOfString2[i] != null) && (!paramArrayOfString1[i].equals(paramArrayOfString2[i]))) {
        localArrayList.add(paramArrayOfString1[i]);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  private static String b(String paramString)
  {
    return paramString.substring(paramString.indexOf("base64,") + 7).trim();
  }
  
  public static void b(String[] paramArrayOfString)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length) {}
      try
      {
        k.i(paramArrayOfString[i]);
        label15:
        i += 1;
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label15;
      }
    }
  }
  
  /* Error */
  private static String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: iconst_0
    //   6: invokestatic 86	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   9: astore_1
    //   10: goto +18 -> 28
    //   13: astore_1
    //   14: ldc 14
    //   16: aload_1
    //   17: ldc 88
    //   19: iconst_0
    //   20: anewarray 4	java/lang/Object
    //   23: invokestatic 93	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +133 -> 162
    //   32: aload_1
    //   33: arraylength
    //   34: ifne +6 -> 40
    //   37: ldc 14
    //   39: areturn
    //   40: new 95	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   47: astore 4
    //   49: aload 4
    //   51: ldc 98
    //   53: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   62: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: ldc 113
    //   70: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 4
    //   76: aload_0
    //   77: invokevirtual 116	java/lang/String:hashCode	()I
    //   80: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 4
    //   86: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_0
    //   90: new 124	com/tencent/luggage/wxa/rt/i
    //   93: dup
    //   94: invokestatic 129	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   97: invokevirtual 135	android/content/Context:getCacheDir	()Ljava/io/File;
    //   100: aload_0
    //   101: invokespecial 138	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   104: astore 4
    //   106: aload_3
    //   107: astore_0
    //   108: aload 4
    //   110: invokestatic 141	com/tencent/luggage/wxa/rt/k:b	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/OutputStream;
    //   113: astore_3
    //   114: aload_3
    //   115: astore_0
    //   116: aload_3
    //   117: astore_2
    //   118: aload_3
    //   119: aload_1
    //   120: invokevirtual 147	java/io/OutputStream:write	([B)V
    //   123: aload_3
    //   124: ifnull +7 -> 131
    //   127: aload_3
    //   128: invokevirtual 150	java/io/OutputStream:close	()V
    //   131: aload 4
    //   133: invokevirtual 153	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   136: areturn
    //   137: astore_1
    //   138: goto +14 -> 152
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 150	java/io/OutputStream:close	()V
    //   149: ldc 14
    //   151: areturn
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 150	java/io/OutputStream:close	()V
    //   160: aload_1
    //   161: athrow
    //   162: ldc 14
    //   164: areturn
    //   165: astore_0
    //   166: goto -25 -> 141
    //   169: astore_0
    //   170: goto -39 -> 131
    //   173: astore_0
    //   174: ldc 14
    //   176: areturn
    //   177: astore_0
    //   178: goto -18 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramString	String
    //   9	1	1	arrayOfByte1	byte[]
    //   13	4	1	localException	Exception
    //   27	93	1	arrayOfByte2	byte[]
    //   137	24	1	localObject1	Object
    //   1	145	2	localObject2	Object
    //   3	125	3	localOutputStream	java.io.OutputStream
    //   47	85	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	10	13	java/lang/Exception
    //   108	114	137	finally
    //   118	123	137	finally
    //   108	114	165	java/lang/Exception
    //   118	123	165	java/lang/Exception
    //   127	131	169	java/io/IOException
    //   145	149	173	java/io/IOException
    //   156	160	177	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.a
 * JD-Core Version:    0.7.0.1
 */