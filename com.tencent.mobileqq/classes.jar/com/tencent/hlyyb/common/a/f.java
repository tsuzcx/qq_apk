package com.tencent.hlyyb.common.a;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.hlyyb.downloader.d.b;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Random;

public class f
{
  public int a = 0;
  public String b = "";
  
  public f(int paramInt, String paramString)
  {
    this.a = paramInt;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    this.b = str;
  }
  
  public static int a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ((!"HLConnEvent".equals(paramString)) && (!"HLSecurityEvent".equals(paramString)) && (!"HLDisconnEvent".equals(paramString)) && (!"HLReqRspEvent".equals(paramString)) && (!"HLHttpAgent".equals(paramString)) && (!"HLHttpDirect".equals(paramString)) && (!"HLPushEvent".equals(paramString)) && (!"B_DLSDK_Result".equals(paramString)) && (!"HLDownTiny".equals(paramString))) {
      paramInt = -1;
    } else {
      paramInt = 0;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 100;
    }
    return i;
  }
  
  public static long a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return l * i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        i = paramString1.indexOf("filename=");
        if (-1 != i)
        {
          int k = i + 9;
          int j = paramString1.indexOf(";", k);
          i = j;
          if (j == -1) {
            i = paramString1.length();
          }
          paramString1 = paramString1.substring(k, i);
        }
      }
    }
    catch (Exception paramString1)
    {
      int i;
      String str1;
      label68:
      label79:
      label109:
      paramString1.printStackTrace();
    }
    try
    {
      str1 = URLDecoder.decode(paramString1, "utf-8");
      paramString1 = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      break label68;
    }
    try
    {
      str1 = URLDecoder.decode(paramString1, "gbk");
      paramString1 = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      break label79;
      String str2 = paramString1;
      break label109;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      i = paramString1.lastIndexOf("/") + 1;
      if (i > 0)
      {
        str1 = paramString1.substring(i);
        if (!TextUtils.isEmpty(str1))
        {
          paramString1 = c(paramString1, paramString2);
          return paramString1;
        }
        return str1;
      }
    }
    else
    {
      return null;
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = a(paramString3, paramString4);
    paramString3 = str;
    if (str == null)
    {
      paramString1 = b(paramString1, paramString4);
      paramString3 = paramString1;
      if (paramString1 == null)
      {
        paramString1 = new StringBuilder("downloadfile");
        paramString1.append(paramString4);
        paramString3 = paramString1.toString();
        paramString1 = paramString3;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1 = paramString3;
          if (paramString2.equalsIgnoreCase("application/vnd.android.package-archive"))
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramString3);
            paramString1.append(".apk");
            paramString1 = paramString1.toString();
          }
        }
        paramString3 = paramString1;
      }
    }
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString3.replace("?", "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "");
    }
    return paramString1;
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    boolean bool = false;
    int i = a(paramString1, paramInt2, false);
    if (a(i))
    {
      if ((i > 0) && (i < 100))
      {
        paramMap2 = new StringBuilder();
        paramMap2.append(i);
        paramMap1.put("B9", paramMap2.toString());
      }
      paramMap2 = new StringBuilder();
      paramMap2.append(paramInt2);
      paramMap1.put("B7", paramMap2.toString());
      paramMap2 = new StringBuilder();
      paramMap2.append(com.tencent.hlyyb.common.a.e());
      paramMap1.put("B1", paramMap2.toString());
      paramMap2 = new StringBuilder();
      paramMap2.append(com.tencent.hlyyb.common.a.a);
      paramMap1.put("B2", paramMap2.toString());
      paramMap2 = new StringBuilder();
      paramMap2.append(paramInt1);
      paramMap1.put("B3", paramMap2.toString());
      paramMap2 = com.tencent.hlyyb.common.a.g();
      if (!TextUtils.isEmpty(paramMap2)) {
        paramMap1.put("B4", paramMap2);
      }
      paramMap2 = a.c();
      if (!TextUtils.isEmpty(paramMap2)) {
        paramMap1.put("B29", paramMap2);
      }
      paramMap2 = new StringBuilder();
      paramMap2.append(a.b());
      paramMap1.put("B6", paramMap2.toString());
      if (!TextUtils.isEmpty(paramString2)) {
        paramMap1.put("B8", paramString2);
      }
      paramMap1.put("D1", com.tencent.hlyyb.common.a.c());
      paramString2 = new StringBuilder();
      paramString2.append(com.tencent.hlyyb.common.a.d());
      paramMap1.put("D2", paramString2.toString());
      if (paramInt2 == 0) {
        bool = true;
      }
      a(paramString1, bool, paramMap1);
    }
  }
  
  public static void a(String paramString, long paramLong, b paramb, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    if ((paramInt > 0) && (paramInt < 100))
    {
      if (new Random().nextInt(100) <= paramInt) {
        return true;
      }
    }
    else
    {
      if (paramInt == -1) {
        return bool;
      }
      if (paramInt == 100) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public static boolean a(Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      paramException = paramException.getMessage();
      if ((paramException != null) && ((paramException.contains("ENOSPC")) || (paramException.contains("No space left on device")))) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 266	java/net/Socket
    //   9: dup
    //   10: invokespecial 267	java/net/Socket:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: new 269	java/net/InetSocketAddress
    //   20: dup
    //   21: aload_0
    //   22: bipush 80
    //   24: invokespecial 272	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   27: sipush 5000
    //   30: invokevirtual 276	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   33: aload 5
    //   35: invokevirtual 280	java/net/Socket:isConnected	()Z
    //   38: istore_3
    //   39: aload 5
    //   41: invokevirtual 283	java/net/Socket:close	()V
    //   44: iload_3
    //   45: ireturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   51: iload_3
    //   52: ireturn
    //   53: astore_0
    //   54: aload 5
    //   56: astore 4
    //   58: goto +50 -> 108
    //   61: astore 4
    //   63: aload 5
    //   65: astore_0
    //   66: aload 4
    //   68: astore 5
    //   70: goto +12 -> 82
    //   73: astore_0
    //   74: goto +34 -> 108
    //   77: astore 5
    //   79: aload 6
    //   81: astore_0
    //   82: aload_0
    //   83: astore 4
    //   85: aload 5
    //   87: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   90: aload_0
    //   91: ifnull +15 -> 106
    //   94: aload_0
    //   95: invokevirtual 283	java/net/Socket:close	()V
    //   98: goto +8 -> 106
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 4
    //   110: ifnull +18 -> 128
    //   113: aload 4
    //   115: invokevirtual 283	java/net/Socket:close	()V
    //   118: goto +10 -> 128
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 82	java/lang/Throwable:printStackTrace	()V
    //   128: aload_0
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   0	130	1	paramInt1	int
    //   0	130	2	paramInt2	int
    //   38	14	3	bool	boolean
    //   4	53	4	localObject1	Object
    //   61	6	4	localThrowable1	Throwable
    //   83	31	4	str	String
    //   121	3	4	localThrowable2	Throwable
    //   13	56	5	localObject2	Object
    //   77	9	5	localThrowable3	Throwable
    //   1	79	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	44	46	java/lang/Throwable
    //   15	39	53	finally
    //   15	39	61	java/lang/Throwable
    //   6	15	73	finally
    //   85	90	73	finally
    //   6	15	77	java/lang/Throwable
    //   94	98	101	java/lang/Throwable
    //   113	118	121	java/lang/Throwable
  }
  
  public static boolean a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      paramBoolean = b(paramString, paramBoolean, paramMap);
      return paramBoolean;
    }
    catch (Throwable paramString)
    {
      label9:
      break label9;
    }
    return false;
  }
  
  public static long b()
  {
    try
    {
      String str = com.tencent.hlyyb.common.a.a().getFilesDir().getAbsolutePath();
      StatFs localStatFs = new StatFs(str);
      localStatFs.restat(str);
      long l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      return l * i;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return -1L;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        String str = Uri.decode(paramString1);
        if (str == null) {
          break label82;
        }
        int i = str.indexOf('?');
        paramString1 = str;
        if (i > 0) {
          paramString1 = str.substring(0, i);
        }
        if (paramString1.endsWith("/")) {
          break label82;
        }
        i = paramString1.lastIndexOf('/') + 1;
        if (i <= 0) {
          break label82;
        }
        paramString1 = paramString1.substring(i);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = c(paramString1, paramString2);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return null;
      label82:
      paramString1 = null;
    }
  }
  
  private static boolean b(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    try
    {
      paramBoolean = UserAction.onUserAction(paramString, paramBoolean, 0L, 0L, paramMap, true);
      return paramBoolean;
    }
    catch (Throwable paramString)
    {
      label12:
      break label12;
    }
    return false;
  }
  
  private static String c(String paramString1, String paramString2)
  {
    int i = paramString1.lastIndexOf(".");
    String str;
    if ((i > 0) && (paramString1.length() > i + 1))
    {
      str = paramString1.substring(0, i);
      paramString1 = paramString1.substring(i);
    }
    else
    {
      localObject = "";
      str = paramString1;
      paramString1 = (String)localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(paramString1);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.f
 * JD-Core Version:    0.7.0.1
 */