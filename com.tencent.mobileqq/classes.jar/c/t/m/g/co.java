package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;

public final class co
{
  public byte[] a;
  public cq b;
  public HandlerThread c;
  public volatile Location d;
  public volatile Location e;
  public volatile List<cp> f;
  public volatile List<ScanResult> g;
  public long h;
  public long i;
  public long j;
  public long k;
  private Context l;
  private volatile cp m;
  private LruCache<String, Pair<Double, Double>> n;
  
  /* Error */
  public co(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 37	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: newarray byte
    //   8: putfield 39	c/t/m/g/co:a	[B
    //   11: aload_0
    //   12: ldc2_w 40
    //   15: putfield 43	c/t/m/g/co:h	J
    //   18: aload_0
    //   19: lconst_0
    //   20: putfield 45	c/t/m/g/co:i	J
    //   23: aload_0
    //   24: lconst_0
    //   25: putfield 47	c/t/m/g/co:j	J
    //   28: aload_0
    //   29: lconst_0
    //   30: putfield 49	c/t/m/g/co:k	J
    //   33: aload_1
    //   34: ifnonnull +27 -> 61
    //   37: aconst_null
    //   38: astore_3
    //   39: aload_0
    //   40: aload_3
    //   41: putfield 51	c/t/m/g/co:l	Landroid/content/Context;
    //   44: aload_0
    //   45: getfield 51	c/t/m/g/co:l	Landroid/content/Context;
    //   48: ifnonnull +21 -> 69
    //   51: new 53	java/lang/IllegalArgumentException
    //   54: dup
    //   55: ldc 55
    //   57: invokespecial 58	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: aload_1
    //   62: invokevirtual 64	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   65: astore_3
    //   66: goto -27 -> 39
    //   69: aload_1
    //   70: invokestatic 68	c/t/m/g/do:a	(Landroid/content/Context;)V
    //   73: aload_0
    //   74: new 70	android/util/LruCache
    //   77: dup
    //   78: bipush 100
    //   80: invokespecial 73	android/util/LruCache:<init>	(I)V
    //   83: putfield 75	c/t/m/g/co:n	Landroid/util/LruCache;
    //   86: getstatic 80	c/t/m/g/ct:a	Z
    //   89: istore_2
    //   90: getstatic 82	c/t/m/g/ct:b	Z
    //   93: istore_2
    //   94: aload_0
    //   95: getfield 51	c/t/m/g/co:l	Landroid/content/Context;
    //   98: ldc 84
    //   100: invokevirtual 88	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   103: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: astore_3
    //   107: aload_3
    //   108: astore_1
    //   109: aload_3
    //   110: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +32 -> 145
    //   116: new 102	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   123: aload_0
    //   124: getfield 51	c/t/m/g/co:l	Landroid/content/Context;
    //   127: invokevirtual 107	android/content/Context:getFilesDir	()Ljava/io/File;
    //   130: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   133: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 113
    //   138: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_1
    //   145: aload_1
    //   146: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   149: ifne +115 -> 264
    //   152: aload_0
    //   153: new 118	c/t/m/g/cq
    //   156: dup
    //   157: aload_0
    //   158: getfield 51	c/t/m/g/co:l	Landroid/content/Context;
    //   161: aload_1
    //   162: invokespecial 121	c/t/m/g/cq:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   165: putfield 123	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   168: aload_0
    //   169: invokespecial 125	c/t/m/g/co:f	()V
    //   172: return
    //   173: astore_1
    //   174: ldc 127
    //   176: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifeq +79 -> 258
    //   182: new 102	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   189: aload_0
    //   190: getfield 51	c/t/m/g/co:l	Landroid/content/Context;
    //   193: invokevirtual 107	android/content/Context:getFilesDir	()Ljava/io/File;
    //   196: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   199: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 113
    //   204: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore_1
    //   211: goto -66 -> 145
    //   214: astore_1
    //   215: ldc 127
    //   217: invokestatic 100	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +29 -> 249
    //   223: new 102	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   230: aload_0
    //   231: getfield 51	c/t/m/g/co:l	Landroid/content/Context;
    //   234: invokevirtual 107	android/content/Context:getFilesDir	()Ljava/io/File;
    //   237: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   240: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 113
    //   245: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_1
    //   250: athrow
    //   251: astore_1
    //   252: aload_0
    //   253: aconst_null
    //   254: putfield 123	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   257: return
    //   258: ldc 127
    //   260: astore_1
    //   261: goto -116 -> 145
    //   264: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	co
    //   0	265	1	paramContext	Context
    //   89	5	2	bool	boolean
    //   38	72	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   86	107	173	java/lang/Throwable
    //   86	107	214	finally
    //   109	145	251	java/lang/Throwable
    //   145	172	251	java/lang/Throwable
    //   174	211	251	java/lang/Throwable
    //   215	249	251	java/lang/Throwable
    //   249	251	251	java/lang/Throwable
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static Location a(Location paramLocation1, Location paramLocation2)
  {
    Location localLocation = paramLocation1;
    if (paramLocation1 == null) {
      localLocation = new Location("gps");
    }
    if (paramLocation2 != null) {
      localLocation.set(paramLocation2);
    }
    return localLocation;
  }
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  public static WifiInfo a(Context paramContext)
  {
    int i1 = 1;
    Object localObject;
    if (paramContext == null)
    {
      localObject = null;
      if (paramContext != null) {
        break label39;
      }
      paramContext = null;
      label14:
      if ((localObject != null) && (paramContext != null)) {
        break label52;
      }
      paramContext = null;
    }
    label39:
    label52:
    do
    {
      for (;;)
      {
        return paramContext;
        try
        {
          localObject = (WifiManager)paramContext.getSystemService("wifi");
        }
        catch (Throwable paramContext)
        {
          boolean bool;
          return null;
        }
      }
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      break label14;
      localObject = ((WifiManager)localObject).getConnectionInfo();
      paramContext = paramContext.getNetworkInfo(1);
      if ((localObject == null) || (paramContext == null) || (!paramContext.isConnected())) {
        break label132;
      }
      paramContext = ((WifiInfo)localObject).getBSSID();
      if ((paramContext != null) && (!paramContext.equals("000000000000")) && (!paramContext.equals("00-00-00-00-00-00")))
      {
        bool = paramContext.equals("00:00:00:00:00:00");
        if (!bool) {}
      }
      else
      {
        i1 = 0;
      }
      paramContext = (Context)localObject;
    } while (i1 != 0);
    return null;
    label132:
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance(paramString);
      ((MessageDigest)localObject).update(paramArrayOfByte);
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = arrayOfByte.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = Integer.toHexString(arrayOfByte[i1] & 0xFF);
        paramArrayOfByte = (byte[])localObject;
        if (((String)localObject).length() != 2) {
          paramArrayOfByte = "0".concat(String.valueOf(localObject));
        }
        localStringBuilder.append(paramArrayOfByte).append("");
        i1 += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (e()) {
        a("getMessageDigest[" + paramString + "] error.", paramArrayOfByte);
      }
    }
    return "abcdefgh";
  }
  
  public static void a(String paramString)
  {
    b(paramString, null);
    if (dg.a() != null) {
      dg.a();
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        b(paramString, paramThrowable);
        if (dg.a() != null) {
          dg.a();
        }
        return;
      }
      catch (Throwable paramThrowable)
      {
        if ((!(paramThrowable instanceof OutOfMemoryError)) && (e())) {
          paramString = "";
        }
      }
    }
  }
  
  private static boolean a(Handler paramHandler)
  {
    if (paramHandler == null) {}
    for (paramHandler = null; (paramHandler != null) && (paramHandler.getThread().isAlive()); paramHandler = paramHandler.getLooper()) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Handler paramHandler, int paramInt, long paramLong)
  {
    if (paramHandler == null) {}
    for (Message localMessage = null;; localMessage = paramHandler.obtainMessage(paramInt)) {
      return a(paramHandler, localMessage, paramLong);
    }
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    if ((paramMessage != null) && (a(paramHandler))) {
      return paramHandler.sendMessageDelayed(paramMessage, paramLong);
    }
    return false;
  }
  
  public static boolean a(File paramFile, byte[] paramArrayOfByte)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile, false);
      paramFile.write(paramArrayOfByte);
      cx.a(paramFile);
      return true;
    }
    catch (Throwable paramFile) {}
    return false;
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() == 0);
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    int i5 = paramList1.size();
    int i6 = paramList2.size();
    if ((i5 == 0) && (i6 == 0)) {
      return true;
    }
    if ((i5 == 0) || (i6 == 0)) {
      return false;
    }
    int i4;
    int i2;
    int i1;
    label79:
    Object localObject;
    label161:
    int i3;
    if (paramList1.size() > paramList2.size())
    {
      paramList2 = paramList2.iterator();
      i4 = 1;
      i2 = 0;
      i1 = 0;
      if (!paramList2.hasNext()) {
        break label233;
      }
      localObject = (ScanResult)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject).BSSID)) {
            if ((i4 == 1) && (((ScanResult)localObject).level > -50))
            {
              i1 += 1;
              i3 = i1;
              if (i4 == 2)
              {
                i3 = i1;
                if (((ScanResult)localObject).level > -60) {
                  i3 = i1 + 1;
                }
              }
              if ((i4 == 3) && (((ScanResult)localObject).level > -60))
              {
                i1 = i3 + 1;
                label209:
                i2 += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i4 += 1;
      break label79;
      localObject = paramList1;
      paramList1 = paramList2;
      paramList2 = (List<ScanResult>)localObject;
      break;
      label233:
      if (i1 == 3) {
        return false;
      }
      i1 = i5 + i6;
      if ((i2 << 1 < i1 * 0.85D) || (i2 < 13)) {}
      for (boolean bool = true;; bool = false)
      {
        new StringBuilder("isDiffrent:c=").append(i5).append(",k=").append(i2).append(",f=").append(i1).append(",r=0.85,s=").append(bool);
        return bool;
      }
      i1 = i3;
      break label209;
      break label161;
    }
  }
  
  private static boolean a(Object... paramVarArgs)
  {
    int i1 = 0;
    while (i1 < 2)
    {
      if (paramVarArgs[i1] == null) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 351	java/io/File:exists	()Z
    //   4: ifeq +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 354	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +7 -> 20
    //   16: getstatic 357	c/t/m/g/dn:a	[B
    //   19: areturn
    //   20: new 359	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 360	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 4
    //   29: invokestatic 365	c/t/m/g/dm:a	()Lc/t/m/g/dm;
    //   32: sipush 2048
    //   35: invokevirtual 368	c/t/m/g/dm:a	(I)[B
    //   38: astore 5
    //   40: new 370	java/io/BufferedInputStream
    //   43: dup
    //   44: new 372	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 375	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 378	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_2
    //   56: aload_2
    //   57: astore_0
    //   58: aload_2
    //   59: aload 5
    //   61: invokevirtual 382	java/io/BufferedInputStream:read	([B)I
    //   64: istore_1
    //   65: iload_1
    //   66: iconst_m1
    //   67: if_icmpeq +43 -> 110
    //   70: aload_2
    //   71: astore_0
    //   72: aload 4
    //   74: aload 5
    //   76: iconst_0
    //   77: iload_1
    //   78: invokevirtual 385	java/io/ByteArrayOutputStream:write	([BII)V
    //   81: goto -25 -> 56
    //   84: astore_0
    //   85: aload_2
    //   86: astore_0
    //   87: getstatic 357	c/t/m/g/dn:a	[B
    //   90: astore_3
    //   91: invokestatic 365	c/t/m/g/dm:a	()Lc/t/m/g/dm;
    //   94: aload 5
    //   96: invokevirtual 387	c/t/m/g/dm:a	([B)V
    //   99: aload_2
    //   100: invokestatic 295	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   103: aload 4
    //   105: invokestatic 295	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   108: aload_3
    //   109: areturn
    //   110: aload_2
    //   111: astore_0
    //   112: aload 4
    //   114: invokevirtual 390	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: astore_3
    //   118: invokestatic 365	c/t/m/g/dm:a	()Lc/t/m/g/dm;
    //   121: aload 5
    //   123: invokevirtual 387	c/t/m/g/dm:a	([B)V
    //   126: aload_2
    //   127: invokestatic 295	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   130: aload 4
    //   132: invokestatic 295	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   135: aload_3
    //   136: areturn
    //   137: astore_0
    //   138: aconst_null
    //   139: astore_3
    //   140: aload_0
    //   141: astore_2
    //   142: invokestatic 365	c/t/m/g/dm:a	()Lc/t/m/g/dm;
    //   145: aload 5
    //   147: invokevirtual 387	c/t/m/g/dm:a	([B)V
    //   150: aload_3
    //   151: invokestatic 295	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   154: aload 4
    //   156: invokestatic 295	c/t/m/g/cx:a	(Ljava/io/Closeable;)V
    //   159: aload_2
    //   160: athrow
    //   161: astore_2
    //   162: aload_0
    //   163: astore_3
    //   164: goto -22 -> 142
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -85 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile	File
    //   64	14	1	i1	int
    //   55	105	2	localObject1	Object
    //   161	1	2	localObject2	Object
    //   169	1	2	localObject3	Object
    //   90	74	3	localObject4	Object
    //   27	128	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   38	108	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   58	65	84	java/lang/Throwable
    //   72	81	84	java/lang/Throwable
    //   112	118	84	java/lang/Throwable
    //   40	56	137	finally
    //   58	65	161	finally
    //   72	81	161	finally
    //   87	91	161	finally
    //   112	118	161	finally
    //   40	56	167	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("object is null.");
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (e()) {
        a("compressGzip failed.", paramArrayOfByte);
      }
    }
    return dn.a;
  }
  
  public static void b(String paramString)
  {
    b(paramString, null);
    if (dg.a() != null) {
      dg.a();
    }
  }
  
  private static void b(String paramString, Throwable paramThrowable)
  {
    if ((dg.b()) && (paramThrowable != null)) {
      new StringBuilder().append(paramString).append(". exception: ").append(Log.getStackTraceString(paramThrowable));
    }
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(Integer.toHexString(localObject[i1] & 0xFF)).append("");
        i1 += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localDeflaterOutputStream.finish();
      localDeflaterOutputStream.flush();
      localDeflaterOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  @Nullable
  public static byte[] d(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
    paramArrayOfByte = new byte[0];
    byte[] arrayOfByte2 = new byte[1024];
    for (;;)
    {
      try
      {
        int i2 = localInflaterInputStream.read(arrayOfByte2);
        if (i2 > 0)
        {
          i1 += i2;
          byte[] arrayOfByte1 = new byte[i1];
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, i2);
          paramArrayOfByte = arrayOfByte1;
          if (i2 <= 0) {
            try
            {
              localByteArrayInputStream.close();
              localInflaterInputStream.close();
              return paramArrayOfByte;
            }
            catch (IOException paramArrayOfByte)
            {
              return null;
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
  }
  
  public static boolean e()
  {
    return (dg.b()) || (dg.a() != null);
  }
  
  private static boolean e(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  private void f()
  {
    Iterator localIterator = ct.b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      if ((this.b != null) && (this.b.d())) {
        this.b.e();
      }
      dr.a(this.c, null, 300L);
      this.c = null;
      d();
      a("shutdown");
      return;
    }
  }
  
  public final void a(cp paramcp, List<cp> paramList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      String str;
      Object localObject;
      int i1;
      synchronized (this.a)
      {
        if (!c()) {
          return;
        }
        a("setCellInfos");
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label414;
        }
        cp localcp = (cp)paramList.next();
        if (!cs.a(localcp.f, localcp.a, localcp.b, localcp.c, localcp.d)) {
          continue;
        }
        str = localcp.c + "_" + localcp.d;
        localObject = this.d;
        if ((e(str)) || (localObject == null) || (((Location)localObject).getLatitude() == 0.0D)) {
          break label451;
        }
        if (((Location)localObject).getLongitude() == 0.0D)
        {
          break label451;
          if (i1 == 0) {
            continue;
          }
          localArrayList.add(localcp);
        }
      }
      Pair localPair = (Pair)this.n.get(str);
      if (localPair == null)
      {
        localObject = Pair.create(Double.valueOf(((Location)localObject).getLatitude()), Double.valueOf(((Location)localObject).getLongitude()));
        this.n.put(str, localObject);
        i1 = 1;
      }
      else
      {
        double d1 = ((Location)localObject).getLatitude();
        double d3 = ((Location)localObject).getLongitude();
        double d2 = ((Double)localPair.first).doubleValue();
        double d4 = ((Double)localPair.second).doubleValue();
        d1 = a(d1);
        d2 = a(d2);
        d3 = a(d3);
        d4 = a(d4);
        double d5 = Math.pow(Math.sin((d1 - d2) / 2.0D), 2.0D);
        d1 = Math.cos(d1);
        d2 = Math.cos(d2);
        if (Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((d3 - d4) / 2.0D), 2.0D) * (d1 * d2) + d5)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D * 1000.0D < 6000.0D)
        {
          i1 = 1;
          continue;
          label414:
          this.f = localArrayList;
          this.i = System.currentTimeMillis();
          if (!paramcp.equals(this.m))
          {
            this.m = paramcp;
            b();
          }
          return;
          label451:
          i1 = 0;
        }
        else
        {
          i1 = 0;
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    int i1 = 1;
    synchronized (this.a)
    {
      if ((this.b == null) || (e(paramString2))) {
        return;
      }
    }
    Object localObject;
    for (;;)
    {
      try
      {
        a("setSetting(" + paramString1 + "," + paramString2 + ")");
        if ("D_CH_ID".equals(paramString1))
        {
          cu.a(paramString2);
          return;
          paramString1 = finally;
          throw paramString1;
        }
        if ("D_FC_SRC".equals(paramString1))
        {
          cu.b(paramString2);
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        a("set setting data[" + paramString1 + "," + paramString2 + "] error.", localThrowable);
        continue;
        if ("D_POS_COLL".equals(paramString1))
        {
          ct.c = Boolean.parseBoolean(paramString2.toLowerCase());
          continue;
        }
        if ("D_WRITE_MAC".equals(paramString1))
        {
          ct.d = Boolean.parseBoolean(paramString2.toLowerCase());
          continue;
        }
        if ("D_UP_NET".equals(paramString1))
        {
          if ("m".equals(paramString2.toLowerCase()))
          {
            ct.f = true;
            continue;
          }
          if ("w".equals(paramString2.toLowerCase()))
          {
            ct.f = false;
            ct.g = false;
            continue;
          }
          if (!"w_m1".equals(paramString2.toLowerCase())) {
            continue;
          }
          ct.f = false;
          ct.g = true;
          continue;
        }
        if (!"D_HUAWEI_SET_SN".equals(paramString1)) {
          break label301;
        }
      }
      if (!e(paramString2)) {
        break label745;
      }
      localObject = "";
      label293:
      cw.a = (String)localObject;
      continue;
      label301:
      localObject = this.b;
      if ("D_UP_INTERVAL".equals(paramString1))
      {
        ((cq)localObject).c = Math.max(900000L, Long.parseLong(paramString2));
      }
      else if ("D_UP_USE_HTTPS".equals(paramString1))
      {
        ct.e = Boolean.parseBoolean(paramString2);
      }
      else if ("D_MAX_1F_SIZE".equals(paramString1))
      {
        ((cq)localObject).b = cq.a(Long.parseLong(paramString2), 10240L, 512000L);
      }
      else if ("D_NUM_UP".equals(paramString1))
      {
        ((cq)localObject).d = ((int)cq.a(Long.parseLong(paramString2), 1L, 5L));
      }
      else if ("D_MAX_BUF_WF".equals(paramString1))
      {
        ((cq)localObject).e = ((int)cq.a(Long.parseLong(paramString2), 5120L, 51200L));
      }
      else if ("D_MAX_FOLDER_SIZE".equals(paramString1))
      {
        ((cq)localObject).f = cq.a(Long.parseLong(paramString2), 10485760L, 209715200L);
      }
      else if ("D_MAX_SIZE_UP_1DAY".equals(paramString1))
      {
        ((cq)localObject).g = Math.max(Long.parseLong(paramString2), 0L);
      }
      else if ("D_MAX_DAY_RENAME".equals(paramString1))
      {
        ((cq)localObject).h = (cq.a(Long.parseLong(paramString2), 1L, 5L) * 24L * 60L * 60L * 1000L);
      }
      else if ("D_MAX_DAY_DELETE".equals(paramString1))
      {
        ((cq)localObject).i = (cq.a(Long.parseLong(paramString2), 1L, 30L) * 24L * 60L * 60L * 1000L);
      }
      else
      {
        if (!"D_UP_WF_INFO".equals(paramString1)) {
          break;
        }
        ((cq)localObject).j = Boolean.parseBoolean(paramString2);
      }
    }
    if ("D_CHEJI_ALLOW_UPLOAD_GPS".equals(paramString1)) {
      if (Integer.parseInt(paramString2) != 1) {
        break label751;
      }
    }
    for (;;)
    {
      ((cq)localObject).k = i1;
      break;
      if ("D_CHEJI_UPLOAD_GPS_INTERVAL".equals(paramString1))
      {
        ((cq)localObject).l = cq.a(Long.parseLong(paramString2), 20000L, 60000L);
        break;
      }
      if ("D_CHEJI_COLL_GPS_INTERVAL".equals(paramString1))
      {
        ((cq)localObject).m = cq.a(Long.parseLong(paramString2), 1000L, 5000L);
        break;
      }
      if ("D_CHEJI_SET_STATUS".equals(paramString1))
      {
        Integer.parseInt(paramString2);
        break;
      }
      if ("D_CHEJI_SET_LOC_SDK_VER".equals(paramString1)) {
        break;
      }
      "D_CHEJI_SET_LOC_SDK_APPKEY".equals(paramString1);
      break;
      label745:
      localObject = paramString2;
      break label293;
      label751:
      i1 = 0;
    }
  }
  
  public final void b()
  {
    if ((!a(new Object[] { this.b, this.d })) || (a(this.f))) {}
    long l1;
    do
    {
      do
      {
        return;
      } while ((ct.f) && (cx.a(this.l) == 3));
      l1 = System.currentTimeMillis();
    } while (l1 - this.i >= this.h);
    this.k = l1;
    this.e = a(this.e, this.d);
    this.b.a(this.d, null, this.f);
  }
  
  public final boolean c()
  {
    if (this.b == null) {
      return false;
    }
    return this.b.d();
  }
  
  public final void d()
  {
    this.d = null;
    this.e = null;
    this.f = null;
    this.m = null;
    this.g = null;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.n.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.co
 * JD-Core Version:    0.7.0.1
 */