package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class c
{
  public static final String a = "c";
  public static RootKeyUtil b;
  public static Map<String, String> c = new HashMap();
  public static final Object d = new Object();
  
  public static String a()
  {
    return "2A57086C86EF54970C1E6EB37BFC72B1";
  }
  
  public static String a(String paramString)
  {
    String str = (String)c.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: getstatic 50	com/huawei/hms/opendevice/c:a	Ljava/lang/String;
    //   3: ldc 52
    //   5: invokestatic 58	com/huawei/hms/support/log/HMSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aconst_null
    //   9: astore_3
    //   10: new 60	java/io/File
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokestatic 68	com/huawei/hms/opendevice/s:a	(Ljava/io/File;)V
    //   23: new 70	java/io/FileOutputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 72	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_2
    //   32: new 74	java/io/OutputStreamWriter
    //   35: dup
    //   36: aload_2
    //   37: ldc 76
    //   39: invokespecial 79	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   42: astore_2
    //   43: new 81	java/io/BufferedWriter
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 84	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   51: astore 4
    //   53: aload 4
    //   55: aload_1
    //   56: invokevirtual 87	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   59: aload 4
    //   61: invokevirtual 90	java/io/BufferedWriter:flush	()V
    //   64: getstatic 23	com/huawei/hms/opendevice/c:c	Ljava/util/Map;
    //   67: aload_0
    //   68: aload_1
    //   69: invokeinterface 94 3 0
    //   74: pop
    //   75: aload_2
    //   76: invokestatic 99	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   79: aload 4
    //   81: invokestatic 99	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   84: return
    //   85: astore_0
    //   86: aload 4
    //   88: astore_1
    //   89: goto +14 -> 103
    //   92: astore_0
    //   93: aload_3
    //   94: astore_1
    //   95: goto +8 -> 103
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_3
    //   102: astore_1
    //   103: aload_2
    //   104: invokestatic 99	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   107: aload_1
    //   108: invokestatic 99	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   111: aload_0
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramString1	String
    //   0	113	1	paramString2	String
    //   0	113	2	paramString3	String
    //   9	93	3	localObject	Object
    //   51	36	4	localBufferedWriter	java.io.BufferedWriter
    // Exception table:
    //   from	to	target	type
    //   53	75	85	finally
    //   43	53	92	finally
    //   10	32	98	finally
    //   32	43	98	finally
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Context paramContext)
  {
    paramContext = p.a(paramContext.getApplicationContext());
    if (!TextUtils.isEmpty(paramContext)) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/files/math/m");
      a("m", paramString1, localStringBuilder.toString());
      paramString1 = new StringBuilder();
      paramString1.append(paramContext);
      paramString1.append("/files/panda/p");
      a("p", paramString2, paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(paramContext);
      paramString1.append("/files/panda/d");
      a("d", paramString3, paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(paramContext);
      paramString1.append("/files/math/t");
      a("t", paramString4, paramString1.toString());
      paramString1 = new StringBuilder();
      paramString1.append(paramContext);
      paramString1.append("/files/s");
      a("s", paramString5, paramString1.toString());
      return;
    }
    catch (IOException paramString1)
    {
      label184:
      break label184;
    }
    HMSLog.e(a, "save key IOException.");
  }
  
  public static byte[] a(Context paramContext)
  {
    byte[] arrayOfByte1 = a.a(paramContext.getString(2131695294));
    paramContext = a.a(paramContext.getString(2131695293));
    byte[] arrayOfByte2 = a.a(a());
    return a(a(a(arrayOfByte1, paramContext), arrayOfByte2));
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      while (i < paramArrayOfByte.length)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] >> 2));
        i += 1;
      }
      return paramArrayOfByte;
    }
    return new byte[0];
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2.length != 0))
    {
      int j = paramArrayOfByte1.length;
      if (j != paramArrayOfByte2.length) {
        return new byte[0];
      }
      byte[] arrayOfByte = new byte[j];
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
        i += 1;
      }
      return arrayOfByte;
    }
    return new byte[0];
  }
  
  public static RootKeyUtil b(Context paramContext)
  {
    if (b == null) {
      if (g())
      {
        b = RootKeyUtil.newInstance(c(), d(), b(), f());
      }
      else
      {
        HMSLog.w(a, "root key util is null, init root key.");
        d(paramContext);
      }
    }
    return b;
  }
  
  public static String b()
  {
    return a("d");
  }
  
  public static String c()
  {
    return a("m");
  }
  
  public static String c(Context paramContext)
  {
    if (!g())
    {
      HMSLog.i(a, "work key is empty, execute init.");
      d(paramContext);
    }
    return WorkKeyCryptUtil.decryptWorkKey(e(), b(paramContext));
  }
  
  public static String d()
  {
    return a("p");
  }
  
  public static void d(Context paramContext)
  {
    synchronized (d)
    {
      e(paramContext.getApplicationContext());
      if (g())
      {
        paramContext = a;
        HMSLog.i(paramContext, "The local secret is already in separate file mode.");
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(p.a(paramContext.getApplicationContext()));
      ((StringBuilder)localObject2).append("/shared_prefs/LocalAvengers.xml");
      localObject2 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject2).exists())
      {
        IOUtil.deleteSecure((File)localObject2);
        localObject2 = a;
        HMSLog.i((String)localObject2, "destroy C, delete file LocalAvengers.xml.");
      }
      Object localObject3 = EncryptUtil.generateSecureRandom(32);
      Object localObject5 = EncryptUtil.generateSecureRandom(32);
      Object localObject4 = EncryptUtil.generateSecureRandom(32);
      localObject2 = EncryptUtil.generateSecureRandom(32);
      localObject3 = a.a((byte[])localObject3);
      localObject5 = a.a((byte[])localObject5);
      localObject4 = a.a((byte[])localObject4);
      b = RootKeyUtil.newInstance((String)localObject3, (String)localObject5, (String)localObject4, (byte[])localObject2);
      String str = WorkKeyCryptUtil.encryptWorkKey(a.a(EncryptUtil.generateSecureRandom(32)), b);
      a((String)localObject3, (String)localObject5, (String)localObject4, a.a((byte[])localObject2), str, paramContext);
      paramContext = a;
      HMSLog.i(paramContext, "generate D.");
      return;
    }
  }
  
  public static String e()
  {
    return a("s");
  }
  
  public static void e(Context paramContext)
  {
    if (g())
    {
      HMSLog.i(a, "secretKeyCache not empty.");
      return;
    }
    c.clear();
    paramContext = p.a(paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append("/files/math/m");
      localObject1 = s.a(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append("/files/panda/p");
      localObject2 = s.a(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramContext);
      ((StringBuilder)localObject3).append("/files/panda/d");
      localObject3 = s.a(((StringBuilder)localObject3).toString());
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramContext);
      ((StringBuilder)localObject4).append("/files/math/t");
      localObject4 = s.a(((StringBuilder)localObject4).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/files/s");
      paramContext = s.a(localStringBuilder.toString());
      if (t.a(new String[] { localObject1, localObject2, localObject3, localObject4, paramContext }))
      {
        c.put("m", localObject1);
        c.put("p", localObject2);
        c.put("d", localObject3);
        c.put("t", localObject4);
        c.put("s", paramContext);
      }
    }
  }
  
  public static String f()
  {
    return a("t");
  }
  
  public static boolean g()
  {
    return TextUtils.isEmpty(e()) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.opendevice.c
 * JD-Core Version:    0.7.0.1
 */