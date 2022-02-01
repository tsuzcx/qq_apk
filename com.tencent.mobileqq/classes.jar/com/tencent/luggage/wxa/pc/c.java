package com.tencent.luggage.wxa.pc;

import android.content.res.AssetManager;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class c
{
  public static String a()
  {
    return a.d();
  }
  
  /* Error */
  public static String a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 17	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 21	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_2
    //   9: ldc 22
    //   11: newarray char
    //   13: astore_3
    //   14: new 24	java/io/StringWriter
    //   17: dup
    //   18: invokespecial 27	java/io/StringWriter:<init>	()V
    //   21: astore 4
    //   23: aload_2
    //   24: aload_3
    //   25: invokevirtual 31	java/io/InputStreamReader:read	([C)I
    //   28: istore_1
    //   29: iconst_m1
    //   30: iload_1
    //   31: if_icmpeq +14 -> 45
    //   34: aload 4
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_1
    //   39: invokevirtual 35	java/io/StringWriter:write	([CII)V
    //   42: goto -19 -> 23
    //   45: aload_2
    //   46: invokestatic 40	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   49: aload_0
    //   50: invokestatic 40	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   53: aload 4
    //   55: invokevirtual 43	java/io/StringWriter:toString	()Ljava/lang/String;
    //   58: areturn
    //   59: astore_3
    //   60: goto +33 -> 93
    //   63: astore_3
    //   64: ldc 45
    //   66: ldc 47
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_3
    //   75: invokevirtual 50	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 56	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_2
    //   83: invokestatic 40	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   86: aload_0
    //   87: invokestatic 40	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   90: ldc 58
    //   92: areturn
    //   93: aload_2
    //   94: invokestatic 40	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   97: aload_0
    //   98: invokestatic 40	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   101: goto +5 -> 106
    //   104: aload_3
    //   105: athrow
    //   106: goto -2 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramInputStream	InputStream
    //   28	11	1	i	int
    //   8	86	2	localInputStreamReader	java.io.InputStreamReader
    //   13	24	3	arrayOfChar	char[]
    //   59	1	3	localObject	Object
    //   63	42	3	localException	Exception
    //   21	33	4	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   23	29	59	finally
    //   34	42	59	finally
    //   64	82	59	finally
    //   23	29	63	java/lang/Exception
    //   34	42	63	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    Object localObject = r.e();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, af.a(localException) });
      paramString = null;
    }
    if (paramString == null) {
      return "";
    }
    return a(paramString);
  }
  
  /* Error */
  public static byte[] a(InputStream paramInputStream, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: new 81	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 82	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 9
    //   9: sipush 16384
    //   12: newarray byte
    //   14: astore 10
    //   16: aload_0
    //   17: invokevirtual 88	java/io/InputStream:available	()I
    //   20: istore 5
    //   22: iload 5
    //   24: ifge +53 -> 77
    //   27: iconst_0
    //   28: newarray byte
    //   30: astore 9
    //   32: aload_0
    //   33: invokevirtual 91	java/io/InputStream:close	()V
    //   36: aload 9
    //   38: areturn
    //   39: astore_0
    //   40: new 93	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   47: astore 10
    //   49: aload 10
    //   51: ldc 96
    //   53: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 10
    //   59: aload_0
    //   60: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: ldc 45
    //   66: aload 10
    //   68: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 107	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 9
    //   76: areturn
    //   77: lload_1
    //   78: lload_3
    //   79: ladd
    //   80: lconst_1
    //   81: lsub
    //   82: iload 5
    //   84: iconst_1
    //   85: isub
    //   86: i2l
    //   87: lcmp
    //   88: ifle +53 -> 141
    //   91: iconst_0
    //   92: newarray byte
    //   94: astore 9
    //   96: aload_0
    //   97: invokevirtual 91	java/io/InputStream:close	()V
    //   100: aload 9
    //   102: areturn
    //   103: astore_0
    //   104: new 93	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   111: astore 10
    //   113: aload 10
    //   115: ldc 96
    //   117: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 10
    //   123: aload_0
    //   124: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 45
    //   130: aload 10
    //   132: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 107	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload 9
    //   140: areturn
    //   141: iload 5
    //   143: i2l
    //   144: lstore 7
    //   146: lload_3
    //   147: lconst_0
    //   148: lcmp
    //   149: iflt +6 -> 155
    //   152: goto +6 -> 158
    //   155: lload 7
    //   157: lstore_3
    //   158: aload_0
    //   159: lload_1
    //   160: invokevirtual 111	java/io/InputStream:skip	(J)J
    //   163: pop2
    //   164: iconst_0
    //   165: istore 5
    //   167: iload 5
    //   169: i2l
    //   170: lstore_1
    //   171: lload_1
    //   172: lload_3
    //   173: lcmp
    //   174: ifge +53 -> 227
    //   177: aload_0
    //   178: aload 10
    //   180: iconst_0
    //   181: aload 10
    //   183: arraylength
    //   184: invokevirtual 114	java/io/InputStream:read	([BII)I
    //   187: istore 6
    //   189: iload 6
    //   191: iconst_m1
    //   192: if_icmpeq +35 -> 227
    //   195: iload 6
    //   197: i2l
    //   198: lload_3
    //   199: lload_1
    //   200: lsub
    //   201: invokestatic 120	java/lang/Math:min	(JJ)J
    //   204: l2i
    //   205: istore 6
    //   207: aload 9
    //   209: aload 10
    //   211: iconst_0
    //   212: iload 6
    //   214: invokevirtual 123	java/io/ByteArrayOutputStream:write	([BII)V
    //   217: iload 5
    //   219: iload 6
    //   221: iadd
    //   222: istore 5
    //   224: goto -57 -> 167
    //   227: aload 9
    //   229: invokevirtual 126	java/io/ByteArrayOutputStream:flush	()V
    //   232: aload_0
    //   233: invokevirtual 91	java/io/InputStream:close	()V
    //   236: goto +38 -> 274
    //   239: astore_0
    //   240: new 93	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   247: astore 10
    //   249: aload 10
    //   251: ldc 96
    //   253: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 10
    //   259: aload_0
    //   260: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 45
    //   266: aload 10
    //   268: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 107	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload 9
    //   276: invokevirtual 130	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   279: areturn
    //   280: astore 9
    //   282: goto +90 -> 372
    //   285: astore 9
    //   287: new 93	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   294: astore 10
    //   296: aload 10
    //   298: ldc 132
    //   300: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 10
    //   306: aload 9
    //   308: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: ldc 45
    //   314: aload 10
    //   316: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 107	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: iconst_0
    //   323: newarray byte
    //   325: astore 9
    //   327: aload_0
    //   328: invokevirtual 91	java/io/InputStream:close	()V
    //   331: aload 9
    //   333: areturn
    //   334: astore_0
    //   335: new 93	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   342: astore 10
    //   344: aload 10
    //   346: ldc 96
    //   348: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 10
    //   354: aload_0
    //   355: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: ldc 45
    //   361: aload 10
    //   363: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 107	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 9
    //   371: areturn
    //   372: aload_0
    //   373: invokevirtual 91	java/io/InputStream:close	()V
    //   376: goto +38 -> 414
    //   379: astore_0
    //   380: new 93	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   387: astore 10
    //   389: aload 10
    //   391: ldc 96
    //   393: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 10
    //   399: aload_0
    //   400: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: ldc 45
    //   406: aload 10
    //   408: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 107	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: goto +6 -> 420
    //   417: aload 9
    //   419: athrow
    //   420: goto -3 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	paramInputStream	InputStream
    //   0	423	1	paramLong1	long
    //   0	423	3	paramLong2	long
    //   20	203	5	i	int
    //   187	35	6	j	int
    //   144	12	7	l	long
    //   7	268	9	localObject1	Object
    //   280	1	9	localObject2	Object
    //   285	22	9	localException	Exception
    //   325	93	9	arrayOfByte	byte[]
    //   14	393	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	36	39	java/lang/Exception
    //   96	100	103	java/lang/Exception
    //   232	236	239	java/lang/Exception
    //   16	22	280	finally
    //   27	32	280	finally
    //   91	96	280	finally
    //   158	164	280	finally
    //   177	189	280	finally
    //   195	217	280	finally
    //   227	232	280	finally
    //   287	327	280	finally
    //   16	22	285	java/lang/Exception
    //   27	32	285	java/lang/Exception
    //   91	96	285	java/lang/Exception
    //   158	164	285	java/lang/Exception
    //   177	189	285	java/lang/Exception
    //   195	217	285	java/lang/Exception
    //   227	232	285	java/lang/Exception
    //   327	331	334	java/lang/Exception
    //   372	376	379	java/lang/Exception
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return new byte[0];
    }
    if (!paramByteBuffer.isDirect()) {
      return paramByteBuffer.array();
    }
    int i = paramByteBuffer.position();
    paramByteBuffer.position(0);
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    paramByteBuffer.position(i);
    return arrayOfByte;
  }
  
  public static byte[] b(InputStream paramInputStream)
  {
    return a(paramInputStream, 0L, -1L);
  }
  
  public static byte[] b(String paramString)
  {
    Object localObject = r.e();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString);
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, af.a(localException) });
      paramString = null;
    }
    if (paramString == null) {
      return new byte[0];
    }
    return b(paramString);
  }
  
  public static boolean c(String paramString)
  {
    return (!af.c(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.c
 * JD-Core Version:    0.7.0.1
 */