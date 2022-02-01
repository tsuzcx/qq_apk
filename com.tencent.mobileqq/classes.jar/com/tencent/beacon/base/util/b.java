package com.tencent.beacon.base.util;

import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.c.a;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  private static final Random a = new Random();
  private static final AtomicInteger b = new AtomicInteger(0);
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString != null)
    {
      int i;
      try
      {
        i = Integer.parseInt(paramString);
      }
      catch (Exception paramString)
      {
        c.a(paramString);
        i = paramInt1;
      }
      if ((i >= paramInt2) && (i <= paramInt3)) {
        return i;
      }
    }
    return paramInt1;
  }
  
  public static long a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    long l2 = paramLong1;
    if (paramString != null)
    {
      long l1;
      try
      {
        l1 = Long.parseLong(paramString);
      }
      catch (Exception paramString)
      {
        c.a(paramString);
        l1 = paramLong1;
      }
      l2 = paramLong1;
      if (l1 >= paramLong2)
      {
        l2 = paramLong1;
        if (l1 <= paramLong3) {
          l2 = l1;
        }
      }
    }
    return l2;
  }
  
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 51	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 54	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 56	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 59	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 63	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   30: astore_2
    //   31: iconst_1
    //   32: anewarray 65	java/io/Closeable
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   42: iconst_1
    //   43: anewarray 65	java/io/Closeable
    //   46: dup
    //   47: iconst_0
    //   48: aload_3
    //   49: aastore
    //   50: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: goto +59 -> 115
    //   59: astore_2
    //   60: goto +12 -> 72
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_0
    //   66: goto +49 -> 115
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokevirtual 72	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 75	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: iconst_1
    //   92: anewarray 65	java/io/Closeable
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   102: iconst_1
    //   103: anewarray 65	java/io/Closeable
    //   106: dup
    //   107: iconst_0
    //   108: aload_3
    //   109: aastore
    //   110: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   113: aconst_null
    //   114: areturn
    //   115: iconst_1
    //   116: anewarray 65	java/io/Closeable
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: aastore
    //   123: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   126: iconst_1
    //   127: anewarray 65	java/io/Closeable
    //   130: dup
    //   131: iconst_0
    //   132: aload_3
    //   133: aastore
    //   134: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayOfByte	byte[]
    //   23	15	1	localObjectInputStream	java.io.ObjectInputStream
    //   55	1	1	localObject1	Object
    //   63	1	1	localObject2	Object
    //   71	67	1	localObject3	Object
    //   30	24	2	localObject4	Object
    //   59	1	2	localThrowable1	Throwable
    //   69	12	2	localThrowable2	Throwable
    //   14	119	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   26	31	55	finally
    //   74	78	55	finally
    //   80	91	55	finally
    //   26	31	59	java/lang/Throwable
    //   15	24	63	finally
    //   15	24	69	java/lang/Throwable
  }
  
  public static String a()
  {
    String str = f.p().e();
    Object localObject = com.tencent.beacon.a.c.c.d();
    if (localObject != null) {
      localObject = ((com.tencent.beacon.a.c.c)localObject).f();
    } else {
      localObject = "";
    }
    int i = a.nextInt(2147473647);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(new Date().getTime());
    localStringBuilder.append("_");
    localStringBuilder.append(i + 1000);
    return b(localStringBuilder.toString());
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append("\n");
    localStringBuilder.append(((StringWriter)localObject).getBuffer().toString());
    localObject = localStringBuilder.toString().replace("\t", " ").replace("\n", " ").replace("$", "-");
    paramThrowable = (Throwable)localObject;
    if (((String)localObject).length() > 10240) {
      paramThrowable = ((String)localObject).substring(0, 10240);
    }
    return paramThrowable;
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 175	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 176	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: invokestatic 182	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: aload_0
    //   12: invokevirtual 186	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   15: astore_1
    //   16: new 188	java/io/BufferedReader
    //   19: dup
    //   20: new 190	java/io/InputStreamReader
    //   23: dup
    //   24: aload_1
    //   25: invokevirtual 196	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   28: ldc 198
    //   30: invokestatic 204	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   33: invokespecial 207	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   36: invokespecial 210	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 213	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +12 -> 58
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 217	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: goto -15 -> 40
    //   58: new 188	java/io/BufferedReader
    //   61: dup
    //   62: new 190	java/io/InputStreamReader
    //   65: dup
    //   66: aload_1
    //   67: invokevirtual 220	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   70: ldc 198
    //   72: invokestatic 204	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   75: invokespecial 207	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   78: invokespecial 210	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   81: astore 4
    //   83: aload_0
    //   84: astore_1
    //   85: aload 4
    //   87: astore_2
    //   88: aload 4
    //   90: invokevirtual 213	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: astore 5
    //   95: aload 5
    //   97: ifnull +18 -> 115
    //   100: aload_0
    //   101: astore_1
    //   102: aload 4
    //   104: astore_2
    //   105: aload_3
    //   106: aload 5
    //   108: invokevirtual 217	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   111: pop
    //   112: goto -29 -> 83
    //   115: iconst_1
    //   116: anewarray 65	java/io/Closeable
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: aastore
    //   123: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   126: iconst_1
    //   127: anewarray 65	java/io/Closeable
    //   130: dup
    //   131: iconst_0
    //   132: aload 4
    //   134: aastore
    //   135: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   138: aload_3
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: astore_3
    //   143: aload 4
    //   145: astore_0
    //   146: aload_1
    //   147: astore 4
    //   149: goto +34 -> 183
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_2
    //   155: goto +64 -> 219
    //   158: astore 4
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_0
    //   163: astore_3
    //   164: aload_1
    //   165: astore_0
    //   166: goto +17 -> 183
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_0
    //   172: aload_0
    //   173: astore_2
    //   174: goto +45 -> 219
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_3
    //   181: aload_3
    //   182: astore_0
    //   183: aload_3
    //   184: astore_1
    //   185: aload_0
    //   186: astore_2
    //   187: aload 4
    //   189: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   192: iconst_1
    //   193: anewarray 65	java/io/Closeable
    //   196: dup
    //   197: iconst_0
    //   198: aload_3
    //   199: aastore
    //   200: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   203: iconst_1
    //   204: anewarray 65	java/io/Closeable
    //   207: dup
    //   208: iconst_0
    //   209: aload_0
    //   210: aastore
    //   211: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_3
    //   217: aload_1
    //   218: astore_0
    //   219: iconst_1
    //   220: anewarray 65	java/io/Closeable
    //   223: dup
    //   224: iconst_0
    //   225: aload_0
    //   226: aastore
    //   227: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   230: iconst_1
    //   231: anewarray 65	java/io/Closeable
    //   234: dup
    //   235: iconst_0
    //   236: aload_2
    //   237: aastore
    //   238: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   241: goto +5 -> 246
    //   244: aload_3
    //   245: athrow
    //   246: goto -2 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramArrayOfString	String[]
    //   15	87	1	localObject1	Object
    //   140	7	1	localThrowable1	Throwable
    //   161	57	1	localObject2	Object
    //   44	193	2	localObject3	Object
    //   7	136	3	localObject4	Object
    //   152	1	3	localObject5	Object
    //   163	1	3	arrayOfString	String[]
    //   169	1	3	localObject6	Object
    //   180	19	3	localObject7	Object
    //   216	29	3	localObject8	Object
    //   81	67	4	localObject9	Object
    //   158	1	4	localThrowable2	Throwable
    //   177	11	4	localThrowable3	Throwable
    //   93	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   88	95	140	java/lang/Throwable
    //   105	112	140	java/lang/Throwable
    //   40	45	152	finally
    //   49	55	152	finally
    //   58	83	152	finally
    //   40	45	158	java/lang/Throwable
    //   49	55	158	java/lang/Throwable
    //   58	83	158	java/lang/Throwable
    //   8	40	169	finally
    //   8	40	177	java/lang/Throwable
    //   88	95	216	finally
    //   105	112	216	finally
    //   187	192	216	finally
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      HashSet localHashSet = new HashSet(paramArrayList.size());
      localHashSet.addAll(paramArrayList);
      return localHashSet;
    }
    return null;
  }
  
  public static void a(Closeable... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Closeable localCloseable = paramVarArgs[i];
      if (localCloseable != null) {
        try
        {
          localCloseable.close();
        }
        catch (Exception localException)
        {
          c.a(localException);
        }
      }
      i += 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    return paramString.startsWith("rqd_");
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      if (paramString.toLowerCase().equals("y")) {
        return true;
      }
      bool = paramBoolean;
      if (paramString.toLowerCase().equals("n")) {
        bool = false;
      }
    }
    return bool;
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 257
    //   4: ifne +15 -> 19
    //   7: ldc_w 259
    //   10: iconst_0
    //   11: anewarray 4	java/lang/Object
    //   14: invokestatic 75	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aconst_null
    //   18: areturn
    //   19: new 261	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 262	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_3
    //   27: new 264	java/io/ObjectOutputStream
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 267	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: aload_0
    //   40: invokevirtual 271	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 274	java/io/ObjectOutputStream:flush	()V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_3
    //   52: invokevirtual 278	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   55: astore_0
    //   56: iconst_1
    //   57: anewarray 65	java/io/Closeable
    //   60: dup
    //   61: iconst_0
    //   62: aload_2
    //   63: aastore
    //   64: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   67: iconst_1
    //   68: anewarray 65	java/io/Closeable
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: aastore
    //   75: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   78: aload_0
    //   79: areturn
    //   80: astore_0
    //   81: goto +63 -> 144
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: astore_2
    //   89: goto +12 -> 101
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: goto +49 -> 144
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_0
    //   101: aload_0
    //   102: astore_1
    //   103: aload_2
    //   104: invokestatic 39	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: astore_1
    //   109: aload_2
    //   110: invokevirtual 72	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 75	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: iconst_1
    //   121: anewarray 65	java/io/Closeable
    //   124: dup
    //   125: iconst_0
    //   126: aload_0
    //   127: aastore
    //   128: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   131: iconst_1
    //   132: anewarray 65	java/io/Closeable
    //   135: dup
    //   136: iconst_0
    //   137: aload_3
    //   138: aastore
    //   139: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   142: aconst_null
    //   143: areturn
    //   144: iconst_1
    //   145: anewarray 65	java/io/Closeable
    //   148: dup
    //   149: iconst_0
    //   150: aload_1
    //   151: aastore
    //   152: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   155: iconst_1
    //   156: anewarray 65	java/io/Closeable
    //   159: dup
    //   160: iconst_0
    //   161: aload_3
    //   162: aastore
    //   163: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramObject	Object
    //   37	14	1	localObject1	Object
    //   84	4	1	localThrowable1	Throwable
    //   94	57	1	localObject2	Object
    //   35	54	2	localObject3	Object
    //   98	12	2	localThrowable2	Throwable
    //   26	136	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   38	43	80	finally
    //   45	49	80	finally
    //   51	56	80	finally
    //   103	107	80	finally
    //   109	120	80	finally
    //   38	43	84	java/lang/Throwable
    //   45	49	84	java/lang/Throwable
    //   51	56	84	java/lang/Throwable
    //   27	36	92	finally
    //   27	36	98	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = paramArrayOfByte;
    byte[] arrayOfByte2;
    if (paramArrayOfByte != null)
    {
      if (paramInt == -1) {
        return paramArrayOfByte;
      }
      c.a("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
      try
      {
        arrayOfByte1 = a.b(paramInt, paramArrayOfByte);
        return arrayOfByte1;
      }
      catch (Throwable localThrowable)
      {
        d locald = d.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unzipData length: ");
        localStringBuilder.append(paramArrayOfByte.length);
        localStringBuilder.append(",type:");
        localStringBuilder.append(paramInt);
        locald.a("509", localStringBuilder.toString(), localThrowable);
        c.a(localThrowable);
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("err unzp}");
        paramArrayOfByte.append(localThrowable.toString());
        c.b(paramArrayOfByte.toString(), new Object[0]);
        arrayOfByte2 = null;
      }
    }
    return arrayOfByte2;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = a(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    byte[] arrayOfByte1 = paramArrayOfByte;
    byte[] arrayOfByte2;
    if (paramArrayOfByte != null)
    {
      if (paramInt == -1) {
        return paramArrayOfByte;
      }
      c.a("CoreUtils", "encry data length:%d type: %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
      try
      {
        arrayOfByte1 = com.tencent.beacon.base.net.c.c.b(paramInt, paramString, paramArrayOfByte);
        return arrayOfByte1;
      }
      catch (Throwable localThrowable)
      {
        c.a(localThrowable);
        d locald = d.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("data length: ");
        localStringBuilder.append(paramArrayOfByte.length);
        localStringBuilder.append(",type:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",key: ");
        localStringBuilder.append(paramString);
        locald.a("507", localStringBuilder.toString(), localThrowable);
        arrayOfByte2 = null;
      }
    }
    return arrayOfByte2;
  }
  
  public static long b()
  {
    return new Date().getTime() + com.tencent.beacon.a.c.c.d().j();
  }
  
  public static String b(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      try
      {
        String str = paramString.substring(8, 24);
        return str;
      }
      catch (Exception localException)
      {
        c.a(localException);
      }
    }
    return paramString;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = paramArrayOfByte;
    byte[] arrayOfByte2;
    if (paramArrayOfByte != null)
    {
      if (paramInt == -1) {
        return paramArrayOfByte;
      }
      c.a("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
      try
      {
        arrayOfByte1 = a.a(paramInt, paramArrayOfByte);
        return arrayOfByte1;
      }
      catch (Throwable localThrowable)
      {
        d locald = d.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("zipData length: ");
        localStringBuilder.append(paramArrayOfByte.length);
        localStringBuilder.append(",type:");
        localStringBuilder.append(paramInt);
        locald.a("509", localStringBuilder.toString(), localThrowable);
        c.a(localThrowable);
        c.b("err zp : %s", new Object[] { localThrowable.toString() });
        arrayOfByte2 = null;
      }
    }
    return arrayOfByte2;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(b(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      c.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    byte[] arrayOfByte1 = paramArrayOfByte;
    byte[] arrayOfByte2;
    if (paramArrayOfByte != null)
    {
      arrayOfByte1 = paramArrayOfByte;
      if (paramArrayOfByte.length > 0)
      {
        if (paramInt == -1) {
          return paramArrayOfByte;
        }
        try
        {
          arrayOfByte1 = com.tencent.beacon.base.net.c.c.a(paramInt, paramString, paramArrayOfByte);
          return arrayOfByte1;
        }
        catch (Throwable localThrowable)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("data length: ");
          ((StringBuilder)localObject).append(paramArrayOfByte.length);
          ((StringBuilder)localObject).append(",type:");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(",key: ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(",error: ");
          ((StringBuilder)localObject).append(localThrowable.getMessage());
          c.e(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = d.b();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("data length: ");
          localStringBuilder.append(paramArrayOfByte.length);
          localStringBuilder.append(",type:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(",key: ");
          localStringBuilder.append(paramString);
          ((d)localObject).a("508", localStringBuilder.toString(), localThrowable);
          arrayOfByte2 = null;
        }
      }
    }
    return arrayOfByte2;
  }
  
  public static String c()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      localObject = ((MessageDigest)localObject).digest(paramString.getBytes(Charset.forName("UTF-8")));
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = localObject[i] & 0xFF;
        if (k < 16) {
          localStringBuilder.append(0);
        }
        localStringBuilder.append(Integer.toHexString(k));
        i += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      c.a(localException);
    }
    return paramString;
  }
  
  public static Date d(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().length() <= 0) {
        return null;
      }
      try
      {
        paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(paramString);
        return paramString;
      }
      catch (ParseException paramString)
      {
        c.a(paramString);
      }
    }
    return null;
  }
  
  /* Error */
  public static String e(String paramString)
  {
    // Byte code:
    //   0: ldc 95
    //   2: astore_3
    //   3: aconst_null
    //   4: astore_1
    //   5: aconst_null
    //   6: astore 4
    //   8: new 409	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 412	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 415	java/io/FileInputStream:available	()I
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_3
    //   26: astore_1
    //   27: aload_2
    //   28: aload 4
    //   30: invokevirtual 419	java/io/FileInputStream:read	([B)I
    //   33: ifle +15 -> 48
    //   36: new 156	java/lang/String
    //   39: dup
    //   40: aload 4
    //   42: ldc 198
    //   44: invokespecial 422	java/lang/String:<init>	([BLjava/lang/String;)V
    //   47: astore_1
    //   48: iconst_1
    //   49: anewarray 65	java/io/Closeable
    //   52: dup
    //   53: iconst_0
    //   54: aload_2
    //   55: aastore
    //   56: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   59: aload_1
    //   60: areturn
    //   61: astore_0
    //   62: goto +45 -> 107
    //   65: goto +8 -> 73
    //   68: aload_1
    //   69: astore_2
    //   70: goto +37 -> 107
    //   73: aload_2
    //   74: astore_1
    //   75: ldc_w 424
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: invokestatic 75	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: iconst_1
    //   90: anewarray 65	java/io/Closeable
    //   93: dup
    //   94: iconst_0
    //   95: aload_2
    //   96: aastore
    //   97: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   100: ldc 95
    //   102: areturn
    //   103: astore_0
    //   104: goto -36 -> 68
    //   107: iconst_1
    //   108: anewarray 65	java/io/Closeable
    //   111: dup
    //   112: iconst_0
    //   113: aload_2
    //   114: aastore
    //   115: invokestatic 68	com/tencent/beacon/base/util/b:a	([Ljava/io/Closeable;)V
    //   118: goto +5 -> 123
    //   121: aload_0
    //   122: athrow
    //   123: goto -2 -> 121
    //   126: astore_1
    //   127: aload 4
    //   129: astore_2
    //   130: goto -57 -> 73
    //   133: astore_1
    //   134: goto -69 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   4	71	1	localObject1	Object
    //   126	1	1	localException1	Exception
    //   133	1	1	localException2	Exception
    //   16	114	2	localObject2	Object
    //   2	24	3	str	String
    //   6	122	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	25	61	finally
    //   27	36	61	finally
    //   36	48	61	finally
    //   8	17	103	finally
    //   75	89	103	finally
    //   8	17	126	java/lang/Exception
    //   17	25	133	java/lang/Exception
    //   27	36	133	java/lang/Exception
    //   36	48	133	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.util.b
 * JD-Core Version:    0.7.0.1
 */