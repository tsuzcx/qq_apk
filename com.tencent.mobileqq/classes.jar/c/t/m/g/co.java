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
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
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
    //   34: ifnonnull +8 -> 42
    //   37: aconst_null
    //   38: astore_3
    //   39: goto +8 -> 47
    //   42: aload_1
    //   43: invokevirtual 55	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   46: astore_3
    //   47: aload_0
    //   48: aload_3
    //   49: putfield 57	c/t/m/g/co:l	Landroid/content/Context;
    //   52: aload_0
    //   53: getfield 57	c/t/m/g/co:l	Landroid/content/Context;
    //   56: ifnull +200 -> 256
    //   59: aload_1
    //   60: invokestatic 61	c/t/m/g/dp:a	(Landroid/content/Context;)V
    //   63: aload_0
    //   64: new 63	android/util/LruCache
    //   67: dup
    //   68: bipush 100
    //   70: invokespecial 66	android/util/LruCache:<init>	(I)V
    //   73: putfield 68	c/t/m/g/co:n	Landroid/util/LruCache;
    //   76: ldc 70
    //   78: astore_1
    //   79: getstatic 75	c/t/m/g/cu:a	Z
    //   82: istore_2
    //   83: getstatic 77	c/t/m/g/cu:b	Z
    //   86: istore_2
    //   87: aload_0
    //   88: getfield 57	c/t/m/g/co:l	Landroid/content/Context;
    //   91: ldc 79
    //   93: invokevirtual 83	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   96: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   99: astore_3
    //   100: aload_3
    //   101: astore_1
    //   102: aload_3
    //   103: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +116 -> 222
    //   109: new 97	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   116: astore_1
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 57	c/t/m/g/co:l	Landroid/content/Context;
    //   122: invokevirtual 102	android/content/Context:getFilesDir	()Ljava/io/File;
    //   125: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_1
    //   133: ldc 108
    //   135: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_1
    //   140: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore_1
    //   144: goto +78 -> 222
    //   147: astore_1
    //   148: ldc 70
    //   150: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifeq +33 -> 186
    //   156: new 97	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   163: astore_3
    //   164: aload_3
    //   165: aload_0
    //   166: getfield 57	c/t/m/g/co:l	Landroid/content/Context;
    //   169: invokevirtual 102	android/content/Context:getFilesDir	()Ljava/io/File;
    //   172: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   175: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_3
    //   180: ldc 108
    //   182: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_1
    //   187: athrow
    //   188: ldc 70
    //   190: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifeq +29 -> 222
    //   196: new 97	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   203: astore_1
    //   204: aload_1
    //   205: aload_0
    //   206: getfield 57	c/t/m/g/co:l	Landroid/content/Context;
    //   209: invokevirtual 102	android/content/Context:getFilesDir	()Ljava/io/File;
    //   212: invokevirtual 89	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   215: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: goto -87 -> 132
    //   222: aload_1
    //   223: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne +23 -> 249
    //   229: aload_0
    //   230: new 113	c/t/m/g/cq
    //   233: dup
    //   234: aload_0
    //   235: getfield 57	c/t/m/g/co:l	Landroid/content/Context;
    //   238: aload_1
    //   239: invokespecial 116	c/t/m/g/cq:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   242: putfield 118	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   245: aload_0
    //   246: invokespecial 120	c/t/m/g/co:f	()V
    //   249: return
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 118	c/t/m/g/co:b	Lc/t/m/g/cq;
    //   255: return
    //   256: new 122	java/lang/IllegalArgumentException
    //   259: dup
    //   260: ldc 124
    //   262: invokespecial 127	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   265: astore_1
    //   266: goto +5 -> 271
    //   269: aload_1
    //   270: athrow
    //   271: goto -2 -> 269
    //   274: astore_1
    //   275: goto -25 -> 250
    //   278: astore_3
    //   279: goto -91 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	co
    //   0	282	1	paramContext	Context
    //   82	5	2	bool	boolean
    //   38	142	3	localObject	Object
    //   278	1	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   79	100	147	finally
    //   102	132	274	java/lang/Throwable
    //   132	144	274	java/lang/Throwable
    //   148	186	274	java/lang/Throwable
    //   186	188	274	java/lang/Throwable
    //   188	219	274	java/lang/Throwable
    //   222	249	274	java/lang/Throwable
    //   79	100	278	java/lang/Throwable
  }
  
  private static double a(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
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
    Object localObject;
    if (paramContext == null)
    {
      localObject = null;
    }
    else
    {
      try
      {
        localObject = (WifiManager)paramContext.getSystemService("wifi");
      }
      catch (Throwable paramContext)
      {
        return null;
      }
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      break label124;
    }
    label124:
    do
    {
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
      int i1 = 1;
      paramContext = paramContext.getNetworkInfo(1);
      if ((localObject != null) && (paramContext != null))
      {
        if (!paramContext.isConnected()) {
          return null;
        }
        paramContext = ((WifiInfo)localObject).getBSSID();
        if ((paramContext != null) && (!paramContext.equals("000000000000")) && (!paramContext.equals("00-00-00-00-00-00")))
        {
          boolean bool = paramContext.equals("00:00:00:00:00:00");
          if (!bool) {}
        }
        else
        {
          i1 = 0;
        }
        if (i1 == 0) {
          return null;
        }
        return localObject;
      }
      do
      {
        return null;
        if (paramContext != null) {
          break;
        }
        paramContext = null;
      } while (localObject == null);
    } while (paramContext != null);
    return null;
  }
  
  public static <T> T a(T paramT1, T paramT2)
  {
    a(paramT2);
    if (paramT1 == null) {
      return paramT2;
    }
    return paramT1;
  }
  
  public static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      localObject = MessageDigest.getInstance(paramString);
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
        localStringBuilder.append(paramArrayOfByte);
        localStringBuilder.append("");
        i1 += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      Object localObject;
      if (e())
      {
        localObject = new StringBuilder("getMessageDigest[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("] error.");
        a(((StringBuilder)localObject).toString(), paramArrayOfByte);
      }
    }
    return "abcdefgh";
  }
  
  private static void a(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new NullPointerException("object is null.");
  }
  
  public static void a(String paramString)
  {
    b(paramString, null);
    if (dh.a() != null) {
      dh.a();
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    try
    {
      b(paramString, paramThrowable);
      if (dh.a() != null) {
        dh.a();
      }
      return;
    }
    catch (Throwable paramThrowable)
    {
      while ((!(paramThrowable instanceof OutOfMemoryError)) && (e())) {
        paramString = "";
      }
    }
  }
  
  public static boolean a(Handler paramHandler)
  {
    if (paramHandler == null) {
      paramHandler = null;
    } else {
      paramHandler = paramHandler.getLooper();
    }
    return (paramHandler != null) && (paramHandler.getThread().isAlive());
  }
  
  public static boolean a(Handler paramHandler, int paramInt, long paramLong)
  {
    Message localMessage;
    if (paramHandler == null) {
      localMessage = null;
    } else {
      localMessage = paramHandler.obtainMessage(paramInt);
    }
    return a(paramHandler, localMessage, paramLong);
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
      dt.a(paramFile);
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
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return false;
      }
      int i6 = paramList1.size();
      int i7 = paramList2.size();
      if ((i6 == 0) && (i7 == 0)) {
        return true;
      }
      bool1 = bool3;
      if (i6 != 0)
      {
        if (i7 == 0) {
          return false;
        }
        Object localObject = paramList1;
        List<ScanResult> localList = paramList2;
        if (paramList1.size() > paramList2.size())
        {
          localList = paramList1;
          localObject = paramList2;
        }
        paramList1 = ((List)localObject).iterator();
        int i1 = 0;
        int i4 = 0;
        int i5 = 1;
        while (paramList1.hasNext())
        {
          paramList2 = (ScanResult)paramList1.next();
          localObject = localList.iterator();
          do
          {
            i3 = i1;
            i2 = i4;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (!((ScanResult)((Iterator)localObject).next()).BSSID.equals(paramList2.BSSID));
          int i2 = i1;
          if (i5 == 1)
          {
            i2 = i1;
            if (paramList2.level > -50) {
              i2 = i1 + 1;
            }
          }
          int i3 = i2;
          if (i5 == 2)
          {
            i3 = i2;
            if (paramList2.level > -60) {
              i3 = i2 + 1;
            }
          }
          i1 = i3;
          if (i5 == 3)
          {
            i1 = i3;
            if (paramList2.level > -60) {
              i1 = i3 + 1;
            }
          }
          i2 = i4 + 1;
          i3 = i1;
          i5 += 1;
          i1 = i3;
          i4 = i2;
        }
        if (i1 == 3) {
          return false;
        }
        i1 = i7 + i6;
        double d1 = i4 << 1;
        double d2 = i1;
        Double.isNaN(d2);
        if (d1 >= d2 * 0.85D)
        {
          bool1 = bool2;
          if (i4 >= 13) {}
        }
        else
        {
          bool1 = true;
        }
        paramList1 = new StringBuilder("isDiffrent:c=");
        paramList1.append(i6);
        paramList1.append(",k=");
        paramList1.append(i4);
        paramList1.append(",f=");
        paramList1.append(i1);
        paramList1.append(",r=0.85,s=");
        paramList1.append(bool1);
      }
    }
    return bool1;
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
    //   1: invokevirtual 369	java/io/File:exists	()Z
    //   4: ifeq +163 -> 167
    //   7: aload_0
    //   8: invokevirtual 372	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +6 -> 19
    //   16: goto +151 -> 167
    //   19: new 374	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 375	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_2
    //   32: invokestatic 380	c/t/m/g/dn:a	()Lc/t/m/g/dn;
    //   35: sipush 2048
    //   38: invokevirtual 383	c/t/m/g/dn:a	(I)[B
    //   41: astore 5
    //   43: new 385	java/io/BufferedInputStream
    //   46: dup
    //   47: new 387	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 390	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: invokespecial 393	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   58: astore_0
    //   59: aload_0
    //   60: aload 5
    //   62: invokevirtual 397	java/io/BufferedInputStream:read	([B)I
    //   65: istore_1
    //   66: iload_1
    //   67: iconst_m1
    //   68: if_icmpeq +15 -> 83
    //   71: aload 4
    //   73: aload 5
    //   75: iconst_0
    //   76: iload_1
    //   77: invokevirtual 400	java/io/ByteArrayOutputStream:write	([BII)V
    //   80: goto -21 -> 59
    //   83: aload 4
    //   85: invokevirtual 403	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   88: astore_2
    //   89: invokestatic 380	c/t/m/g/dn:a	()Lc/t/m/g/dn;
    //   92: aload 5
    //   94: invokevirtual 405	c/t/m/g/dn:a	([B)V
    //   97: aload_0
    //   98: invokestatic 308	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   101: aload_2
    //   102: astore_0
    //   103: aload 4
    //   105: invokestatic 308	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   108: aload_0
    //   109: areturn
    //   110: astore_3
    //   111: aload_0
    //   112: astore_2
    //   113: aload_3
    //   114: astore_0
    //   115: goto +33 -> 148
    //   118: goto +7 -> 125
    //   121: astore_0
    //   122: goto +26 -> 148
    //   125: aload_0
    //   126: astore_2
    //   127: getstatic 408	c/t/m/g/do:a	[B
    //   130: astore_3
    //   131: invokestatic 380	c/t/m/g/dn:a	()Lc/t/m/g/dn;
    //   134: aload 5
    //   136: invokevirtual 405	c/t/m/g/dn:a	([B)V
    //   139: aload_0
    //   140: invokestatic 308	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   143: aload_3
    //   144: astore_0
    //   145: goto -42 -> 103
    //   148: invokestatic 380	c/t/m/g/dn:a	()Lc/t/m/g/dn;
    //   151: aload 5
    //   153: invokevirtual 405	c/t/m/g/dn:a	([B)V
    //   156: aload_2
    //   157: invokestatic 308	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   160: aload 4
    //   162: invokestatic 308	c/t/m/g/dt:a	(Ljava/io/Closeable;)V
    //   165: aload_0
    //   166: athrow
    //   167: getstatic 408	c/t/m/g/do:a	[B
    //   170: areturn
    //   171: astore_0
    //   172: aload_3
    //   173: astore_0
    //   174: goto -49 -> 125
    //   177: astore_2
    //   178: goto -60 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramFile	File
    //   65	12	1	i1	int
    //   31	126	2	localObject1	Object
    //   177	1	2	localThrowable	Throwable
    //   29	1	3	localObject2	Object
    //   110	4	3	localObject3	Object
    //   130	43	3	arrayOfByte1	byte[]
    //   26	135	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   41	111	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   59	66	110	finally
    //   71	80	110	finally
    //   83	89	110	finally
    //   43	59	121	finally
    //   127	131	121	finally
    //   43	59	171	java/lang/Throwable
    //   59	66	177	java/lang/Throwable
    //   71	80	177	java/lang/Throwable
    //   83	89	177	java/lang/Throwable
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte);
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
    return do.a;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("UTF-8");
    }
    catch (Throwable paramString1)
    {
      label11:
      break label11;
    }
    paramString1 = null;
    return a(paramString1, paramString2);
  }
  
  public static void b(String paramString)
  {
    b(paramString, null);
    if (dh.a() != null) {
      dh.a();
    }
  }
  
  private static void b(String paramString, Throwable paramThrowable)
  {
    if ((dh.b()) && (paramThrowable != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(". exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    }
  }
  
  public static boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }
  
  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
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
        localStringBuilder.append(Integer.toHexString(localObject[i1] & 0xFF));
        localStringBuilder.append("");
        i1 += 1;
      }
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  @Nullable
  public static byte[] d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
    byte[] arrayOfByte2 = new byte[1024];
    paramArrayOfByte = new byte[0];
    int i1 = 0;
    try
    {
      int i3;
      byte[] arrayOfByte1;
      do
      {
        i3 = localInflaterInputStream.read(arrayOfByte2);
        int i2 = i1;
        arrayOfByte1 = paramArrayOfByte;
        if (i3 > 0)
        {
          i2 = i1 + i3;
          arrayOfByte1 = new byte[i2];
          System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, i3);
        }
        i1 = i2;
        paramArrayOfByte = arrayOfByte1;
      } while (i3 > 0);
      localByteArrayInputStream.close();
      localInflaterInputStream.close();
      return arrayOfByte1;
    }
    catch (Exception|IOException paramArrayOfByte) {}
    return null;
  }
  
  public static String e(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean e()
  {
    return (dh.b()) || (dh.a() != null);
  }
  
  private void f()
  {
    Iterator localIterator = cu.b().entrySet().iterator();
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
      if (this.c != null)
      {
        ds.a("th_loc_extra", 300L);
        this.c = null;
      }
      d();
      a("shutdown");
      return;
    }
  }
  
  public final void a(cp paramcp, List<cp> paramList)
  {
    label473:
    label481:
    synchronized (this.a)
    {
      if (!c()) {
        return;
      }
      a("setCellInfos");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = this;
        boolean bool = localIterator.hasNext();
        if (bool) {
          try
          {
            cp localcp = (cp)localIterator.next();
            if (ct.a(localcp.f, localcp.a, localcp.b, localcp.c, localcp.d))
            {
              Object localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(localcp.c);
              ((StringBuilder)localObject1).append("_");
              ((StringBuilder)localObject1).append(localcp.d);
              localObject1 = ((StringBuilder)localObject1).toString();
              Object localObject2 = paramList.d;
              if ((!c((String)localObject1)) && (localObject2 != null) && (((Location)localObject2).getLatitude() != 0.0D) && (((Location)localObject2).getLongitude() != 0.0D))
              {
                Pair localPair = (Pair)paramList.n.get(localObject1);
                if (localPair == null)
                {
                  localObject2 = Pair.create(Double.valueOf(((Location)localObject2).getLatitude()), Double.valueOf(((Location)localObject2).getLongitude()));
                  paramList.n.put(localObject1, localObject2);
                }
                double d1;
                do
                {
                  i1 = 1;
                  break;
                  double d2 = ((Location)localObject2).getLatitude();
                  double d3 = ((Location)localObject2).getLongitude();
                  double d4 = ((Double)localPair.first).doubleValue();
                  d1 = ((Double)localPair.second).doubleValue();
                  d2 = a(d2);
                  d4 = a(d4);
                  d3 = a(d3);
                  d1 = a(d1);
                  long l1 = Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((d2 - d4) / 2.0D), 2.0D) + Math.cos(d2) * Math.cos(d4) * Math.pow(Math.sin((d3 - d1) / 2.0D), 2.0D))) * 2.0D * 6378.1369999999997D * 10000.0D);
                  d1 = l1;
                  Double.isNaN(d1);
                } while (d1 / 10000.0D * 1000.0D < 6000.0D);
              }
              int i1 = 0;
              if (i1 != 0) {
                localArrayList.add(localcp);
              }
            }
          }
          finally
          {
            break label473;
          }
        }
      }
      paramList.f = localArrayList;
      paramList.i = System.currentTimeMillis();
      if (!paramcp.equals(paramList.m))
      {
        paramList.m = paramcp;
        b();
      }
      return;
      break label481;
      throw paramcp;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.b != null)
        {
          boolean bool = c(paramString2);
          if (!bool)
          {
            try
            {
              Object localObject = new StringBuilder("setSetting(");
              ((StringBuilder)localObject).append(paramString1);
              ((StringBuilder)localObject).append(",");
              ((StringBuilder)localObject).append(paramString2);
              ((StringBuilder)localObject).append(")");
              a(((StringBuilder)localObject).toString());
              if ("D_CH_ID".equals(paramString1))
              {
                cv.a(paramString2);
              }
              else if ("D_FC_SRC".equals(paramString1))
              {
                cv.b(paramString2);
              }
              else if ("D_POS_COLL".equals(paramString1))
              {
                cu.c = Boolean.parseBoolean(paramString2.toLowerCase());
              }
              else if ("D_WRITE_MAC".equals(paramString1))
              {
                cu.d = Boolean.parseBoolean(paramString2.toLowerCase());
              }
              else if ("D_UP_NET".equals(paramString1))
              {
                if ("m".equals(paramString2.toLowerCase()))
                {
                  cu.f = true;
                }
                else if ("w".equals(paramString2.toLowerCase()))
                {
                  cu.f = false;
                  cu.g = false;
                }
                else if ("w_m1".equals(paramString2.toLowerCase()))
                {
                  cu.f = false;
                  cu.g = true;
                }
              }
              else if ("D_EXTRA_SET_SN".equals(paramString1))
              {
                if (!c(paramString2)) {
                  break label677;
                }
                localObject = "";
                cx.a = (String)localObject;
              }
              else
              {
                localObject = this.b;
                if ("D_UP_INTERVAL".equals(paramString1)) {
                  ((cq)localObject).b = Math.max(900000L, Long.parseLong(paramString2));
                } else if ("D_UP_USE_HTTPS".equals(paramString1)) {
                  cu.e = Boolean.parseBoolean(paramString2);
                } else if ("D_MAX_1F_SIZE".equals(paramString1)) {
                  ((cq)localObject).a = cq.a(Long.parseLong(paramString2), 10240L, 512000L);
                } else if ("D_NUM_UP".equals(paramString1)) {
                  ((cq)localObject).c = ((int)cq.a(Long.parseLong(paramString2), 1L, 5L));
                } else if ("D_MAX_BUF_WF".equals(paramString1)) {
                  ((cq)localObject).d = ((int)cq.a(Long.parseLong(paramString2), 5120L, 51200L));
                } else if ("D_MAX_FOLDER_SIZE".equals(paramString1)) {
                  ((cq)localObject).e = cq.a(Long.parseLong(paramString2), 10485760L, 209715200L);
                } else if ("D_MAX_SIZE_UP_1DAY".equals(paramString1)) {
                  ((cq)localObject).f = Math.max(Long.parseLong(paramString2), 0L);
                } else if ("D_MAX_DAY_RENAME".equals(paramString1)) {
                  ((cq)localObject).g = (cq.a(Long.parseLong(paramString2), 1L, 5L) * 24L * 60L * 60L * 1000L);
                } else if ("D_MAX_DAY_DELETE".equals(paramString1)) {
                  ((cq)localObject).h = (cq.a(Long.parseLong(paramString2), 1L, 30L) * 24L * 60L * 60L * 1000L);
                } else if ("D_UP_WF_INFO".equals(paramString1)) {
                  ((cq)localObject).i = Boolean.parseBoolean(paramString2);
                } else if ("D_UP_U_TRACK_INFO".equals(paramString1)) {
                  ((cq)localObject).j = Boolean.parseBoolean(paramString2);
                }
              }
            }
            catch (Throwable localThrowable)
            {
              StringBuilder localStringBuilder = new StringBuilder("set setting data[");
              localStringBuilder.append(paramString1);
              localStringBuilder.append(",");
              localStringBuilder.append(paramString2);
              localStringBuilder.append("] error.");
              a(localStringBuilder.toString(), localThrowable);
            }
            return;
          }
        }
        return;
      }
      label677:
      String str = paramString2;
    }
  }
  
  public final void b()
  {
    if (a(new Object[] { this.b, this.d }))
    {
      if (a(this.f)) {
        return;
      }
      if ((cu.f) && (cy.a(this.l) == 3)) {
        return;
      }
      long l1 = System.currentTimeMillis();
      if (l1 - this.i < this.h)
      {
        this.k = l1;
        this.e = a(this.e, this.d);
        this.b.a(this.d, null, this.f);
      }
    }
  }
  
  public final boolean c()
  {
    cq localcq = this.b;
    if (localcq == null) {
      return false;
    }
    return localcq.d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.co
 * JD-Core Version:    0.7.0.1
 */