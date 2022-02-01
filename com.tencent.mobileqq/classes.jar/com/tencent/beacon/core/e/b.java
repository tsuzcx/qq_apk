package com.tencent.beacon.core.e;

import android.content.Context;
import com.tencent.beacon.core.a.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class b
{
  private static final Random a = new Random();
  private static final AtomicInteger b = new AtomicInteger(0);
  private static String c;
  
  public static int a(int paramInt)
  {
    return a.nextInt(paramInt);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1;
    if (paramString != null) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      j = paramInt1;
      if (i >= paramInt2)
      {
        j = paramInt1;
        if (i <= paramInt3) {
          j = i;
        }
      }
      return j;
    }
    catch (Throwable paramString)
    {
      d.a(paramString);
      return paramInt1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = paramInt1;
      }
    }
  }
  
  public static long a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    long l2 = paramLong1;
    if (paramString != null) {}
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      l2 = paramLong1;
      if (l1 >= paramLong2)
      {
        l2 = paramLong1;
        if (l1 <= paramLong3) {
          l2 = l1;
        }
      }
      return l2;
    }
    catch (Throwable paramString)
    {
      d.a(paramString);
      return paramLong1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        long l1 = paramLong1;
      }
    }
  }
  
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 64	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 67	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_2
    //   15: new 69	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 72	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 76	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   28: astore_1
    //   29: aload_0
    //   30: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   33: aload_2
    //   34: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: aconst_null
    //   41: astore_0
    //   42: aload_1
    //   43: invokestatic 51	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   46: aload_1
    //   47: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 86	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload_0
    //   58: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   61: aload_2
    //   62: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: aload_0
    //   69: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   72: aload_2
    //   73: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: goto -37 -> 42
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_0
    //   85: goto -17 -> 68
    //   88: astore_1
    //   89: goto -21 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramArrayOfByte	byte[]
    //   28	10	1	localObject1	Object
    //   39	8	1	localThrowable1	Throwable
    //   67	10	1	localObject2	Object
    //   78	1	1	localThrowable2	Throwable
    //   82	1	1	localObject3	Object
    //   88	1	1	localObject4	Object
    //   14	59	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   15	24	39	java/lang/Throwable
    //   24	29	67	finally
    //   24	29	78	java/lang/Throwable
    //   15	24	82	finally
    //   42	57	88	finally
  }
  
  public static String a()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      d.a(localThrowable);
    }
    return "";
  }
  
  public static String a(long paramLong)
  {
    try
    {
      Object localObject = new Date(paramLong);
      localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format((Date)localObject);
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str2 = com.tencent.beacon.core.info.c.a(paramContext).a();
      String str1 = "";
      com.tencent.beacon.core.info.b localb = com.tencent.beacon.core.info.b.b(paramContext);
      paramContext = str1;
      if (localb != null) {
        paramContext = localb.a();
      }
      int i = a.nextInt(2147473647);
      paramContext = new StringBuilder().append(paramContext);
      paramContext = paramContext.append("_").append(str2);
      paramContext = paramContext.append("_").append(new Date().getTime());
      paramContext = b("_" + (i + 1000));
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      paramContext = com.tencent.beacon.core.info.c.a(paramContext).a();
      paramContext = b(String.format("%1$s_%2$s_%3$s_%4$s_%5$s", new Object[] { paramContext, paramString, Long.valueOf(new Date().getTime()), Integer.valueOf(b.addAndGet(1)), Integer.valueOf(paramInt) }));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      d.b("get Rid error", new Object[] { paramContext });
    }
    return null;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      paramThrowable = "";
    }
    Object localObject;
    do
    {
      return paramThrowable;
      localObject = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
      localObject = (paramThrowable.getMessage() + "\n" + ((StringWriter)localObject).getBuffer().toString()).replace("\t", " ").replace("\n", "").replace("$", "-");
      paramThrowable = (Throwable)localObject;
    } while (((String)localObject).length() <= 1024);
    return ((String)localObject).substring(0, 1024);
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 214	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 215	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 221	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 225	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual 231	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   23: astore_1
    //   24: new 233	java/io/BufferedReader
    //   27: dup
    //   28: new 235	java/io/InputStreamReader
    //   31: dup
    //   32: aload_1
    //   33: ldc 237
    //   35: invokestatic 243	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   38: invokespecial 246	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   41: invokespecial 249	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual 252	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +36 -> 87
    //   54: aload 4
    //   56: aload_3
    //   57: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: goto -16 -> 45
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_1
    //   69: astore_2
    //   70: aload_0
    //   71: astore_3
    //   72: aload 4
    //   74: invokestatic 51	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   77: aload_1
    //   78: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   81: aload_0
    //   82: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   85: aconst_null
    //   86: areturn
    //   87: aload_0
    //   88: invokevirtual 259	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   91: astore_0
    //   92: new 233	java/io/BufferedReader
    //   95: dup
    //   96: new 235	java/io/InputStreamReader
    //   99: dup
    //   100: aload_0
    //   101: ldc 237
    //   103: invokestatic 243	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   106: invokespecial 246	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   109: invokespecial 249	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   112: astore_0
    //   113: aload_1
    //   114: astore_2
    //   115: aload_0
    //   116: astore_3
    //   117: aload_0
    //   118: invokevirtual 252	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore 5
    //   123: aload 5
    //   125: ifnull +23 -> 148
    //   128: aload_1
    //   129: astore_2
    //   130: aload_0
    //   131: astore_3
    //   132: aload 4
    //   134: aload 5
    //   136: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   139: pop
    //   140: goto -27 -> 113
    //   143: astore 4
    //   145: goto -77 -> 68
    //   148: aload_1
    //   149: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   152: aload_0
    //   153: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   156: aload 4
    //   158: areturn
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   166: aload_2
    //   167: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   170: aload_0
    //   171: athrow
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_0
    //   178: goto -110 -> 68
    //   181: astore_0
    //   182: aload_2
    //   183: astore_1
    //   184: aload_3
    //   185: astore_2
    //   186: goto -24 -> 162
    //   189: astore_0
    //   190: goto -28 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramArrayOfString	String[]
    //   23	161	1	localObject1	Object
    //   1	185	2	localObject2	Object
    //   49	136	3	localObject3	Object
    //   9	46	4	localArrayList	ArrayList
    //   64	69	4	localThrowable1	Throwable
    //   143	14	4	localThrowable2	Throwable
    //   172	1	4	localThrowable3	Throwable
    //   121	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   45	50	64	java/lang/Throwable
    //   54	61	64	java/lang/Throwable
    //   87	92	64	java/lang/Throwable
    //   92	113	64	java/lang/Throwable
    //   117	123	143	java/lang/Throwable
    //   132	140	143	java/lang/Throwable
    //   11	24	159	finally
    //   24	45	159	finally
    //   11	24	172	java/lang/Throwable
    //   24	45	172	java/lang/Throwable
    //   72	77	181	finally
    //   117	123	181	finally
    //   132	140	181	finally
    //   45	50	189	finally
    //   54	61	189	finally
    //   87	92	189	finally
    //   92	113	189	finally
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
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return a(paramInt2) + 1 <= paramInt1;
  }
  
  public static boolean a(String paramString)
  {
    return paramString.startsWith("rqd_");
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      try
      {
        String str = paramString.toLowerCase();
        if (str.equals("y")) {
          return true;
        }
        paramString = paramString.toLowerCase();
        boolean bool = paramString.equals("n");
        if (bool) {
          return false;
        }
      }
      catch (Throwable paramString)
      {
        d.a(paramString);
      }
    }
    return paramBoolean;
  }
  
  public static boolean a(Set<String> paramSet, ArrayList<String> paramArrayList)
  {
    paramArrayList = a(paramArrayList);
    paramSet = (String[])paramSet.toArray(new String[0]);
    paramArrayList = (String[])paramArrayList.toArray(new String[0]);
    Arrays.sort(paramSet);
    Arrays.sort(paramSet);
    return Arrays.equals(paramSet, paramArrayList);
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc_w 327
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 329	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: aload_0
    //   13: ifnull +13 -> 26
    //   16: ldc_w 331
    //   19: aload_0
    //   20: invokevirtual 336	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   23: ifne +15 -> 38
    //   26: ldc_w 338
    //   29: iconst_0
    //   30: anewarray 4	java/lang/Object
    //   33: invokestatic 86	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: aconst_null
    //   37: areturn
    //   38: new 340	java/io/ByteArrayOutputStream
    //   41: dup
    //   42: invokespecial 341	java/io/ByteArrayOutputStream:<init>	()V
    //   45: astore 4
    //   47: new 343	java/io/ObjectOutputStream
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 346	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: aload_0
    //   61: invokevirtual 350	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   64: aload_2
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 353	java/io/ObjectOutputStream:flush	()V
    //   70: aload_2
    //   71: astore_1
    //   72: aload 4
    //   74: invokevirtual 357	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: astore_0
    //   78: aload_2
    //   79: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   82: aload 4
    //   84: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   87: aload_0
    //   88: areturn
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_0
    //   92: aload_0
    //   93: astore_1
    //   94: aload_3
    //   95: invokestatic 51	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   98: aload_0
    //   99: astore_1
    //   100: aload_3
    //   101: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 86	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aload_0
    //   112: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   115: aload 4
    //   117: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: aload_1
    //   124: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   127: aload 4
    //   129: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: goto -12 -> 123
    //   138: astore_3
    //   139: aload_2
    //   140: astore_0
    //   141: goto -49 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramObject	Object
    //   1	123	1	localObject	Object
    //   56	84	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   89	12	3	localThrowable1	Throwable
    //   138	1	3	localThrowable2	Throwable
    //   45	83	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	57	89	java/lang/Throwable
    //   59	64	122	finally
    //   66	70	122	finally
    //   72	78	122	finally
    //   94	98	122	finally
    //   100	111	122	finally
    //   47	57	134	finally
    //   59	64	138	java/lang/Throwable
    //   66	70	138	java/lang/Throwable
    //   72	78	138	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    d.a("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = com.tencent.beacon.core.c.a.a.b(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      d.a(paramArrayOfByte);
      d.b("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
    }
    return null;
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
      d.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    d.a("enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    try
    {
      paramArrayOfByte = com.tencent.beacon.core.c.a.c.b(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      d.a(paramArrayOfByte);
      d.b("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static long b(long paramLong)
  {
    return new Date().getTime() + paramLong;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      if (j.b(c))
      {
        String str = "on_app_first_install_time_" + com.tencent.beacon.core.info.a.c(paramContext);
        long l2 = f.a(paramContext).a(str, 0L);
        long l1 = l2;
        if (l2 == 0L)
        {
          l1 = new Date().getTime();
          com.tencent.beacon.core.a.d.a().a(new a(paramContext, str, l1));
        }
        c = String.valueOf(l1);
        d.a("[cover] process: %s, getAppFirstInstallTime: %s", new Object[] { str, c });
      }
      d.a("[cover] getAppFirstInstallTime: %s", new Object[] { c });
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static String b(String paramString)
  {
    String str = c(paramString);
    paramString = str;
    if (str != null) {}
    try
    {
      paramString = str.substring(8, 24);
      return paramString;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    d.a("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = com.tencent.beacon.core.c.a.a.a(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      d.a(paramArrayOfByte);
      d.b("err zp : %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
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
      d.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    try
    {
      paramArrayOfByte = com.tencent.beacon.core.c.a.c.a(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      d.a(paramArrayOfByte);
      d.b("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      localObject = ((MessageDigest)localObject).digest(paramString.getBytes(Charset.forName("UTF-8")));
      StringBuilder localStringBuilder = new StringBuilder();
      int j = localObject.length;
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
      d.a(localException);
    }
    return paramString;
  }
  
  public static Date d(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      d.a(paramString);
    }
    return null;
  }
  
  /* Error */
  public static String e(String paramString)
  {
    // Byte code:
    //   0: ldc 108
    //   2: astore 4
    //   4: aconst_null
    //   5: astore_2
    //   6: new 474	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 477	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: astore_2
    //   17: aload_3
    //   18: invokevirtual 480	java/io/FileInputStream:available	()I
    //   21: newarray byte
    //   23: astore 5
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: aload 5
    //   30: invokevirtual 484	java/io/FileInputStream:read	([B)I
    //   33: istore_1
    //   34: aload 4
    //   36: astore_2
    //   37: iload_1
    //   38: ifle +17 -> 55
    //   41: aload_3
    //   42: astore_2
    //   43: aload 5
    //   45: ldc 237
    //   47: invokestatic 490	org/apache/http/util/EncodingUtils:getString	([BLjava/lang/String;)Ljava/lang/String;
    //   50: astore 4
    //   52: aload 4
    //   54: astore_2
    //   55: aload_3
    //   56: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_3
    //   64: aload_3
    //   65: astore_2
    //   66: ldc_w 492
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: aastore
    //   77: invokestatic 86	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_3
    //   81: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   84: ldc 108
    //   86: areturn
    //   87: astore_0
    //   88: aload_2
    //   89: invokestatic 79	com/tencent/beacon/core/e/b:a	(Ljava/io/Closeable;)V
    //   92: aload_0
    //   93: athrow
    //   94: astore_0
    //   95: goto -7 -> 88
    //   98: astore_2
    //   99: goto -35 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramString	String
    //   33	5	1	i	int
    //   5	55	2	localObject1	Object
    //   61	1	2	localException1	Exception
    //   65	24	2	localObject2	Object
    //   98	1	2	localException2	Exception
    //   14	67	3	localFileInputStream	java.io.FileInputStream
    //   2	51	4	str	String
    //   23	21	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	15	61	java/lang/Exception
    //   17	25	87	finally
    //   27	34	87	finally
    //   43	52	87	finally
    //   66	80	87	finally
    //   6	15	94	finally
    //   17	25	98	java/lang/Exception
    //   27	34	98	java/lang/Exception
    //   43	52	98	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.b
 * JD-Core Version:    0.7.0.1
 */