package com.tencent.luggage.wxa.nq;

import android.os.Build.VERSION;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rt.i;

public class g
{
  public static String a(c paramc, String paramString)
  {
    if (af.c(paramString))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.WxaAudioUtils", "src is empty");
      return "";
    }
    if (paramString.startsWith("wxfile://"))
    {
      if (paramc.getFileSystem() == null)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.WxaAudioUtils", "getFileSystem() is null");
        return "";
      }
      paramc = paramc.getFileSystem().g(paramString);
      if ((paramc != null) && (paramc.j()))
      {
        paramString = paramc.l();
        paramc = paramString;
        if (paramString != null)
        {
          paramc = paramString;
          if (!paramString.startsWith("file://"))
          {
            paramc = new StringBuilder();
            paramc.append("file://");
            paramc.append(paramString);
            paramc = paramc.toString();
          }
        }
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { paramc });
        return paramc;
      }
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.WxaAudioUtils", "localFile is null");
      return "";
    }
    if (paramString.length() <= 250) {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.WxaAudioUtils", "getRealSrc:src:%s", new Object[] { paramString });
    }
    return paramString;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 59	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 90
    //   11: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 93	java/lang/String:hashCode	()I
    //   20: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore_1
    //   29: new 47	com/tencent/luggage/wxa/rt/i
    //   32: dup
    //   33: invokestatic 101	com/tencent/luggage/wxa/gw/a:a	()Lcom/tencent/luggage/wxa/rt/i;
    //   36: aload_1
    //   37: invokespecial 104	com/tencent/luggage/wxa/rt/i:<init>	(Lcom/tencent/luggage/wxa/rt/i;Ljava/lang/String;)V
    //   40: astore 4
    //   42: aload 4
    //   44: invokevirtual 51	com/tencent/luggage/wxa/rt/i:j	()Z
    //   47: ifeq +16 -> 63
    //   50: ldc 14
    //   52: ldc 106
    //   54: invokestatic 108	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 4
    //   59: invokevirtual 55	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   62: areturn
    //   63: aconst_null
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_0
    //   68: iconst_0
    //   69: invokestatic 114	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   72: astore_0
    //   73: goto +18 -> 91
    //   76: astore_0
    //   77: ldc 24
    //   79: aload_0
    //   80: ldc 116
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 119	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +65 -> 157
    //   95: aload_0
    //   96: arraylength
    //   97: ifne +6 -> 103
    //   100: ldc 24
    //   102: areturn
    //   103: aload 4
    //   105: invokestatic 124	com/tencent/luggage/wxa/rt/k:b	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/OutputStream;
    //   108: astore_3
    //   109: aload_3
    //   110: astore_1
    //   111: aload_3
    //   112: astore_2
    //   113: aload_3
    //   114: aload_0
    //   115: invokevirtual 130	java/io/OutputStream:write	([B)V
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 133	java/io/OutputStream:close	()V
    //   126: aload 4
    //   128: invokevirtual 55	com/tencent/luggage/wxa/rt/i:l	()Ljava/lang/String;
    //   131: areturn
    //   132: astore_0
    //   133: goto +14 -> 147
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 133	java/io/OutputStream:close	()V
    //   144: ldc 24
    //   146: areturn
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 133	java/io/OutputStream:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: ldc 24
    //   159: areturn
    //   160: astore_0
    //   161: goto -25 -> 136
    //   164: astore_0
    //   165: goto -39 -> 126
    //   168: astore_0
    //   169: ldc 24
    //   171: areturn
    //   172: astore_1
    //   173: goto -18 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString	String
    //   7	145	1	localObject1	Object
    //   172	1	1	localIOException	java.io.IOException
    //   64	77	2	localObject2	Object
    //   108	15	3	localOutputStream	java.io.OutputStream
    //   40	87	4	locali	i
    // Exception table:
    //   from	to	target	type
    //   67	73	76	java/lang/Exception
    //   103	109	132	finally
    //   113	118	132	finally
    //   103	109	160	java/lang/Exception
    //   113	118	160	java/lang/Exception
    //   122	126	164	java/io/IOException
    //   140	144	168	java/io/IOException
    //   151	155	172	java/io/IOException
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT <= 19;
  }
  
  public static String b(c paramc, String paramString)
  {
    if (af.c(paramString))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
      return paramString;
    }
    if (paramc.getFileSystem() == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
      return paramString;
    }
    paramc = paramc.getFileSystem().g(paramString);
    if ((paramc != null) && (paramc.j()))
    {
      paramc = paramc.l();
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.Audio.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", new Object[] { paramc });
      return paramc;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.Audio.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nq.g
 * JD-Core Version:    0.7.0.1
 */