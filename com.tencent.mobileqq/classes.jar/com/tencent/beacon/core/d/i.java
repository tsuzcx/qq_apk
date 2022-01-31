package com.tencent.beacon.core.d;

import android.content.Context;
import com.tencent.beacon.core.protocol.a.a;
import com.tencent.beacon.event.UserAction;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.http.util.EncodingUtils;

public final class i
{
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
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = paramInt1;
      }
    }
    catch (Throwable paramString)
    {
      b.a(paramString);
    }
    return paramInt1;
  }
  
  public static long a(long paramLong)
  {
    return new Date().getTime() + paramLong;
  }
  
  public static long a(String paramString, long paramLong)
  {
    long l2 = paramLong;
    if (paramString != null) {}
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      l2 = paramLong;
      if (l1 >= 1000L)
      {
        l2 = paramLong;
        if (l1 <= 20000L) {
          l2 = l1;
        }
      }
      return l2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        long l1 = paramLong;
      }
    }
    catch (Throwable paramString)
    {
      b.a(paramString);
    }
    return paramLong;
  }
  
  /* Error */
  public static Object a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifge +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 55	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 58	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_3
    //   20: new 60	java/io/ObjectInputStream
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 63	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 67	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 70	java/io/ObjectInputStream:close	()V
    //   40: aload_3
    //   41: invokevirtual 71	java/io/ByteArrayInputStream:close	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   51: aload_2
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   58: goto -18 -> 40
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: invokevirtual 75	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   76: iconst_0
    //   77: anewarray 4	java/lang/Object
    //   80: invokestatic 79	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 70	java/io/ObjectInputStream:close	()V
    //   91: aload_3
    //   92: invokevirtual 71	java/io/ByteArrayInputStream:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   109: goto -18 -> 91
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 70	java/io/ObjectInputStream:close	()V
    //   123: aload_3
    //   124: invokevirtual 71	java/io/ByteArrayInputStream:close	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore_0
    //   130: aload_0
    //   131: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   134: goto -11 -> 123
    //   137: astore_0
    //   138: aload_0
    //   139: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   142: goto -15 -> 127
    //   145: astore_1
    //   146: goto -31 -> 115
    //   149: astore_2
    //   150: goto -86 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramArrayOfByte	byte[]
    //   28	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   112	16	1	localObject1	Object
    //   145	1	1	localObject2	Object
    //   35	17	2	localObject3	Object
    //   61	12	2	localThrowable1	Throwable
    //   149	1	2	localThrowable2	Throwable
    //   19	105	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   40	44	46	java/io/IOException
    //   36	40	53	java/io/IOException
    //   20	29	61	java/lang/Throwable
    //   91	95	97	java/io/IOException
    //   87	91	104	java/io/IOException
    //   20	29	112	finally
    //   119	123	129	java/io/IOException
    //   123	127	137	java/io/IOException
    //   31	36	145	finally
    //   66	70	145	finally
    //   72	83	145	finally
    //   31	36	149	java/lang/Throwable
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
      b.a(localThrowable);
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str = com.tencent.beacon.core.b.c.a(paramContext).d();
      paramContext = "";
      com.tencent.beacon.core.b.b localb = com.tencent.beacon.core.b.b.a(UserAction.mContext);
      if (localb != null) {
        paramContext = localb.b();
      }
      int i = (int)(Math.random() * 2147483647.0D);
      paramContext = c(paramContext + "_" + str + "_" + new Date().getTime() + "_" + i);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    try
    {
      Object localObject = com.tencent.beacon.core.b.c.a(paramContext);
      paramContext = ((com.tencent.beacon.core.b.c)localObject).a();
      localObject = ((com.tencent.beacon.core.b.c)localObject).b();
      paramContext = c(paramContext + "_" + (String)localObject + "_" + new Date().getTime() + "_" + paramInt);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      b.d("get Rid error", new Object[] { paramContext });
    }
    return null;
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 159	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 160	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 166	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 170	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: new 172	java/io/BufferedReader
    //   22: dup
    //   23: new 174	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 180	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   31: invokespecial 181	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +44 -> 88
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: goto -16 -> 38
    //   57: astore 4
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 192	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 192	java/io/BufferedReader:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: new 172	java/io/BufferedReader
    //   91: dup
    //   92: new 174	java/io/InputStreamReader
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 195	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   100: invokespecial 181	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   103: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   106: astore_0
    //   107: aload_0
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: aload_0
    //   112: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +23 -> 142
    //   122: aload_0
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload 4
    //   128: aload 5
    //   130: invokevirtual 191	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -27 -> 107
    //   137: astore 4
    //   139: goto -78 -> 61
    //   142: aload_1
    //   143: invokevirtual 192	java/io/BufferedReader:close	()V
    //   146: aload_0
    //   147: invokevirtual 192	java/io/BufferedReader:close	()V
    //   150: aload 4
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   158: aload 4
    //   160: areturn
    //   161: astore_1
    //   162: aload_1
    //   163: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   166: goto -20 -> 146
    //   169: astore_1
    //   170: aload_1
    //   171: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   174: goto -96 -> 78
    //   177: astore_0
    //   178: aload_0
    //   179: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   182: goto -96 -> 86
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 192	java/io/BufferedReader:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 192	java/io/BufferedReader:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: astore_1
    //   207: aload_1
    //   208: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   211: goto -15 -> 196
    //   214: astore_1
    //   215: aload_1
    //   216: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   219: goto -15 -> 204
    //   222: astore_0
    //   223: goto -35 -> 188
    //   226: astore_0
    //   227: aload_2
    //   228: astore_1
    //   229: goto -41 -> 188
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_0
    //   236: aconst_null
    //   237: astore_1
    //   238: goto -177 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramArrayOfString	String[]
    //   37	106	1	localBufferedReader	java.io.BufferedReader
    //   161	2	1	localIOException1	java.io.IOException
    //   169	2	1	localIOException2	java.io.IOException
    //   187	6	1	localObject1	Object
    //   206	2	1	localIOException3	java.io.IOException
    //   214	2	1	localIOException4	java.io.IOException
    //   228	10	1	localObject2	Object
    //   42	186	2	localObject3	Object
    //   1	200	3	arrayOfString	String[]
    //   9	39	4	localArrayList	ArrayList
    //   57	70	4	localThrowable1	Throwable
    //   137	22	4	localThrowable2	Throwable
    //   232	1	4	localThrowable3	Throwable
    //   115	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   38	43	57	java/lang/Throwable
    //   47	54	57	java/lang/Throwable
    //   88	107	57	java/lang/Throwable
    //   111	117	137	java/lang/Throwable
    //   126	134	137	java/lang/Throwable
    //   146	150	153	java/io/IOException
    //   142	146	161	java/io/IOException
    //   74	78	169	java/io/IOException
    //   82	86	177	java/io/IOException
    //   11	38	185	finally
    //   192	196	206	java/io/IOException
    //   200	204	214	java/io/IOException
    //   38	43	222	finally
    //   47	54	222	finally
    //   88	107	222	finally
    //   65	70	226	finally
    //   111	117	226	finally
    //   126	134	226	finally
    //   11	38	232	java/lang/Throwable
  }
  
  public static Date a(String paramString)
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
      b.a(paramString);
    }
    return null;
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    int i = paramArrayList.size();
    if ((paramArrayList != null) && (i > 0))
    {
      HashSet localHashSet = new HashSet(i);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHashSet.add((String)paramArrayList.next());
      }
      return localHashSet;
    }
    return null;
  }
  
  public static void a(Throwable paramThrowable)
  {
    Object localObject = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localObject));
    paramThrowable = (paramThrowable.getMessage() + "\n" + ((StringWriter)localObject).getBuffer().toString()).replace("\t", " ");
    localObject = new HashMap();
    ((Map)localObject).put("A125", paramThrowable);
    UserAction.onUserAction("rqd_exception", true, 0L, 0L, (Map)localObject, true);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      try
      {
        if (paramString.toLowerCase().equals("y")) {
          return true;
        }
        boolean bool = paramString.toLowerCase().equals("n");
        if (bool) {
          return false;
        }
      }
      catch (Throwable paramString)
      {
        b.a(paramString);
      }
    }
    return paramBoolean;
  }
  
  /* Error */
  public static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 297
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 299	com/tencent/beacon/core/d/b:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +13 -> 24
    //   14: ldc_w 301
    //   17: aload_0
    //   18: invokevirtual 306	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifne +15 -> 36
    //   24: ldc_w 308
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 79	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 310	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 311	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 4
    //   45: new 313	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 316	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 320	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 323	java/io/ObjectOutputStream:flush	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 327	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 328	java/io/ObjectOutputStream:close	()V
    //   80: aload 4
    //   82: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   99: goto -19 -> 80
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: astore_1
    //   113: aload_3
    //   114: invokevirtual 75	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 79	com/tencent/beacon/core/d/b:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 328	java/io/ObjectOutputStream:close	()V
    //   132: aload 4
    //   134: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   151: goto -19 -> 132
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 328	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: invokevirtual 329	java/io/ByteArrayOutputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   177: goto -12 -> 165
    //   180: astore_1
    //   181: aload_1
    //   182: invokestatic 25	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   185: goto -15 -> 170
    //   188: astore_0
    //   189: goto -32 -> 157
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: goto -90 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramObject	Object
    //   56	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   94	2	1	localIOException2	java.io.IOException
    //   106	56	1	localObject	Object
    //   172	2	1	localIOException3	java.io.IOException
    //   180	2	1	localIOException4	java.io.IOException
    //   54	140	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   102	12	3	localThrowable1	Throwable
    //   192	1	3	localThrowable2	Throwable
    //   43	123	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/io/IOException
    //   76	80	94	java/io/IOException
    //   45	55	102	java/lang/Throwable
    //   132	137	139	java/io/IOException
    //   128	132	146	java/io/IOException
    //   45	55	154	finally
    //   161	165	172	java/io/IOException
    //   165	170	180	java/io/IOException
    //   57	62	188	finally
    //   64	68	188	finally
    //   70	76	188	finally
    //   107	111	188	finally
    //   113	124	188	finally
    //   57	62	192	java/lang/Throwable
    //   64	68	192	java/lang/Throwable
    //   70	76	192	java/lang/Throwable
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    b.b("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    ByteArrayOutputStream localByteArrayOutputStream;
    Object localObject;
    if (paramInt == 1) {
      try
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject = new ZipOutputStream(localByteArrayOutputStream);
        ZipEntry localZipEntry = new ZipEntry("zip");
        localZipEntry.setSize(paramArrayOfByte.length);
        ((ZipOutputStream)localObject).putNextEntry(localZipEntry);
        ((ZipOutputStream)localObject).write(paramArrayOfByte);
        ((ZipOutputStream)localObject).closeEntry();
        ((ZipOutputStream)localObject).close();
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        b.a(paramArrayOfByte);
        b.d("err zp : %s", new Object[] { paramArrayOfByte.toString() });
        return null;
      }
    }
    if (paramInt == 2)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).finish();
      ((GZIPOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(a(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      b.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    b.b("enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    try
    {
      paramArrayOfByte = com.tencent.beacon.core.protocol.a.c.b(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      b.a(paramArrayOfByte);
      b.d("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      str1 = str2;
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      str1 = str2;
      localFileInputStream.read(arrayOfByte);
      str1 = str2;
      str2 = EncodingUtils.getString(arrayOfByte, "UTF-8");
      str1 = str2;
      localFileInputStream.close();
      return str2;
    }
    catch (Exception localException)
    {
      b.d("Read file %s failed.", new Object[] { paramString });
    }
    return str1;
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    b.b("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    try
    {
      paramArrayOfByte = a.a(paramInt, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      b.a(paramArrayOfByte);
      b.d("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = b(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      b.a(paramArrayOfByte);
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
      paramArrayOfByte = com.tencent.beacon.core.protocol.a.c.a(paramInt, paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      b.a(paramArrayOfByte);
      b.d("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    String str = d(paramString);
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
  
  private static String d(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuffer localStringBuffer = new StringBuffer();
      int j = localObject.length;
      while (i < j)
      {
        int k = localObject[i] & 0xFF;
        if (k < 16) {
          localStringBuffer.append(0);
        }
        localStringBuffer.append(Integer.toHexString(k));
        i += 1;
      }
      localObject = localStringBuffer.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.d.i
 * JD-Core Version:    0.7.0.1
 */