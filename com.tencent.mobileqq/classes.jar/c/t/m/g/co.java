package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class co
{
  private byte[] a = new byte[0];
  private Context b;
  private cr c;
  private volatile Location d;
  private volatile Location e;
  private volatile List<cw> f;
  private volatile cw g;
  private long h = 0L;
  private long i = 0L;
  private long j = 0L;
  
  public co(Context paramContext)
  {
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getApplicationContext())
    {
      this.b = paramContext;
      if (this.b != null) {
        break;
      }
      throw new IllegalArgumentException("context cannot be null!");
    }
    try
    {
      paramContext = this.b.getExternalFilesDir("data").getAbsolutePath();
      if (!TextUtils.isEmpty(paramContext)) {
        this.c = new cr(this.b, paramContext);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      this.c = null;
    }
  }
  
  @SuppressLint({"MissingPermission"})
  private static int a(WifiManager paramWifiManager)
  {
    if (paramWifiManager == null) {
      return 4;
    }
    try
    {
      int k = paramWifiManager.getWifiState();
      return k;
    }
    catch (Throwable paramWifiManager) {}
    return 4;
  }
  
  public static int a(String paramString)
  {
    if ((paramString.startsWith("fc4")) || (paramString.startsWith("dc4"))) {
      return 4;
    }
    if ((paramString.startsWith("fc3")) || (paramString.startsWith("dc3"))) {
      return 3;
    }
    if ((paramString.startsWith("fc2")) || (paramString.startsWith("dc2"))) {
      return 2;
    }
    if ((paramString.startsWith("fc1")) || (paramString.startsWith("fc")) || (paramString.startsWith("dc"))) {
      return 1;
    }
    return -1;
  }
  
  private static Location a(Location paramLocation1, Location paramLocation2)
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
  
  @SuppressLint({"MissingPermission"})
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "{}";
    }
    try
    {
      Object localObject1 = (WifiManager)paramContext.getSystemService("wifi");
      Object localObject2 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramContext = ((WifiManager)localObject1).getConnectionInfo();
        localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
        if ((paramContext != null) && (localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject1 = paramContext.getBSSID();
          if ((localObject1 == null) || (((String)localObject1).equals("000000000000")) || (((String)localObject1).equals("00-00-00-00-00-00")) || (((String)localObject1).equals("00:00:00:00:00:00"))) {
            break label220;
          }
          int k = paramContext.getRssi();
          if ((k < -100) || (k > -20)) {
            break label223;
          }
          paramContext = paramContext.getSSID().replace("\"", "").replace("|", "");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{");
          ((StringBuilder)localObject2).append("\"mac\":\"");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("\",\"rssi\":");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(",\"ssid\":\"");
          ((StringBuilder)localObject2).append(paramContext);
          ((StringBuilder)localObject2).append("\"}");
          paramContext = ((StringBuilder)localObject2).toString();
          return paramContext;
        }
        return "{}";
      }
    }
    catch (Throwable paramContext)
    {
      return "{}";
    }
    return "{}";
    label220:
    return "{}";
    label223:
    return "{}";
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
  }
  
  private static boolean a(Object... paramVarArgs)
  {
    int k = 0;
    while (k < 2)
    {
      if (paramVarArgs[k] == null) {
        return false;
      }
      k += 1;
    }
    return true;
  }
  
  /* Error */
  public static byte[] a(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 219	java/io/File:exists	()Z
    //   4: ifeq +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 223	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +7 -> 20
    //   16: iconst_0
    //   17: newarray byte
    //   19: areturn
    //   20: new 225	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 226	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 4
    //   29: sipush 4096
    //   32: newarray byte
    //   34: astore_3
    //   35: new 228	java/io/BufferedInputStream
    //   38: dup
    //   39: new 230	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 233	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 236	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_0
    //   53: aload_2
    //   54: aload_3
    //   55: invokevirtual 240	java/io/BufferedInputStream:read	([B)I
    //   58: istore_1
    //   59: iload_1
    //   60: iconst_m1
    //   61: if_icmpeq +39 -> 100
    //   64: aload_2
    //   65: astore_0
    //   66: aload 4
    //   68: aload_3
    //   69: iconst_0
    //   70: iload_1
    //   71: invokevirtual 244	java/io/ByteArrayOutputStream:write	([BII)V
    //   74: goto -23 -> 51
    //   77: astore_3
    //   78: aload_2
    //   79: astore_0
    //   80: aload_3
    //   81: astore_2
    //   82: aload_2
    //   83: athrow
    //   84: astore_3
    //   85: aload_0
    //   86: astore_2
    //   87: aload_3
    //   88: astore_0
    //   89: aload_2
    //   90: invokestatic 246	c/t/m/g/co:a	(Ljava/io/Closeable;)V
    //   93: aload 4
    //   95: invokestatic 246	c/t/m/g/co:a	(Ljava/io/Closeable;)V
    //   98: aload_0
    //   99: athrow
    //   100: aload_2
    //   101: astore_0
    //   102: aload 4
    //   104: invokevirtual 250	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: astore_3
    //   108: aload_2
    //   109: invokestatic 246	c/t/m/g/co:a	(Ljava/io/Closeable;)V
    //   112: aload 4
    //   114: invokestatic 246	c/t/m/g/co:a	(Ljava/io/Closeable;)V
    //   117: aload_3
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_2
    //   122: goto -33 -> 89
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_0
    //   128: goto -46 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	File
    //   58	13	1	k	int
    //   50	72	2	localObject1	Object
    //   125	1	2	localIOException1	IOException
    //   34	35	3	arrayOfByte1	byte[]
    //   77	4	3	localIOException2	IOException
    //   84	4	3	localObject2	Object
    //   107	11	3	arrayOfByte2	byte[]
    //   27	86	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   53	59	77	java/io/IOException
    //   66	74	77	java/io/IOException
    //   102	108	77	java/io/IOException
    //   53	59	84	finally
    //   66	74	84	finally
    //   82	84	84	finally
    //   102	108	84	finally
    //   35	51	119	finally
    //   35	51	125	java/io/IOException
  }
  
  private static int b(Context paramContext)
  {
    try
    {
      int k = a((WifiManager)paramContext.getSystemService("wifi"));
      return k;
    }
    catch (Throwable paramContext) {}
    return 4;
  }
  
  public static String b()
  {
    return "1.2.8_180224";
  }
  
  public static boolean b(List paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  private void c()
  {
    if ((!a(new Object[] { this.c, this.d })) || (b(this.f))) {}
    long l;
    do
    {
      do
      {
        return;
      } while ((this.c.d) && (b(this.b) == 3));
      l = System.currentTimeMillis();
    } while (l - this.h >= 30000L);
    this.j = l;
    this.e = a(this.e, this.d);
    this.c.a(this.d, null, this.f);
  }
  
  private boolean d()
  {
    if (this.c == null) {
      return false;
    }
    return this.c.a();
  }
  
  private void e()
  {
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      cr localcr;
      if ((this.c != null) && (this.c.a())) {
        localcr = this.c;
      }
      synchronized (localcr.b)
      {
        if (!localcr.a)
        {
          e();
          return;
        }
        localcr.a = false;
        localcr.b();
      }
    }
  }
  
  public final void a(Location paramLocation)
  {
    synchronized (this.a)
    {
      if (!d()) {
        return;
      }
      if ((paramLocation == null) || (!"gps".equals(paramLocation.getProvider())) || (paramLocation.getAltitude() == 0.0D)) {
        break label128;
      }
      if ((Build.VERSION.SDK_INT >= 18) && (paramLocation.isFromMockProvider())) {
        return;
      }
    }
    this.d = a(this.d, paramLocation);
    if ((this.e == null) || ((this.d != null) && (this.d.distanceTo(this.e) >= 50.0F) && (System.currentTimeMillis() - this.j >= 5000L))) {
      c();
    }
    label128:
  }
  
  public final void a(Looper paramLooper)
  {
    synchronized (this.a)
    {
      e();
      cr localcr;
      if (this.c != null) {
        localcr = this.c;
      }
      synchronized (localcr.b)
      {
        if (localcr.a) {
          return;
        }
        localcr.a = true;
        localcr.a(paramLooper);
      }
    }
  }
  
  public final void a(cv paramcv)
  {
    synchronized (this.a)
    {
      if (this.c != null)
      {
        if (paramcv != null) {
          paramcv.a = this.b;
        }
        this.c.c = paramcv;
        cp.a("TxCoreDC", "appInfo:1.2.8," + cv.a(paramcv.c) + "_" + cv.a(paramcv.b) + "," + cv.a(Build.MANUFACTURER) + "," + cv.a(Build.MODEL));
      }
      return;
    }
  }
  
  public final void a(cw paramcw, List<cw> paramList)
  {
    synchronized (this.a)
    {
      if (!d()) {
        return;
      }
      this.f = paramList;
      this.h = System.currentTimeMillis();
      if (!paramcw.equals(this.g))
      {
        this.g = paramcw;
        c();
      }
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    int k = 0;
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.c != null)
        {
          if (paramString2 != null) {
            if (paramString2.length() != 0) {
              break label453;
            }
          }
        }
        else {
          return;
        }
      }
      label453:
      do
      {
        try
        {
          if ("D_CH_ID".equals(paramString1)) {
            ct.a(paramString2);
          }
          for (;;)
          {
            return;
            paramString1 = finally;
            throw paramString1;
            if (!"D_FC_SRC".equals(paramString1)) {
              break;
            }
            ct.b(paramString2);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cp.a("TxCoreDC", "set data[" + paramString1 + "," + paramString2 + "] error.", localThrowable);
            continue;
            cr localcr = this.c;
            if ("D_UP_NET".equals(paramString1))
            {
              if ("m".equals(paramString2.toLowerCase())) {
                localcr.d = true;
              } else if ("w".equals(paramString2.toLowerCase())) {
                localcr.d = false;
              }
            }
            else if ("D_UP_INTERVAL".equals(paramString1)) {
              localcr.f = Math.max(900000L, Long.parseLong(paramString2));
            } else if ("D_MAX_1F_SIZE".equals(paramString1)) {
              localcr.e = cr.a(Long.parseLong(paramString2), 20480L, 512000L);
            } else if ("D_NUM_UP".equals(paramString1)) {
              localcr.g = ((int)cr.a(Long.parseLong(paramString2), 1L, 5L));
            } else if ("D_MAX_BUF_WF".equals(paramString1)) {
              localcr.h = ((int)cr.a(Long.parseLong(paramString2), 5120L, 51200L));
            } else if ("D_MAX_FOLDER_SIZE".equals(paramString1)) {
              localcr.i = cr.a(Long.parseLong(paramString2), 10240L, 209715200L);
            } else if ("D_MAX_SIZE_UP_1DAY".equals(paramString1)) {
              localcr.j = Math.max(Long.parseLong(paramString2), 0L);
            } else if ("D_MAX_DAY_RENAME".equals(paramString1)) {
              localcr.k = (cr.a(Long.parseLong(paramString2), 1L, 5L) * 24L * 60L * 60L * 1000L);
            } else if ("D_MAX_DAY_DELETE".equals(paramString1)) {
              localcr.l = (cr.a(Long.parseLong(paramString2), 1L, 30L) * 24L * 60L * 60L * 1000L);
            }
          }
        }
        k = 1;
      } while (k == 0);
    }
  }
  
  public final void a(List<ScanResult> paramList)
  {
    synchronized (this.a)
    {
      if (!d()) {
        return;
      }
      if ((this.c == null) || (this.d == null) || (b(paramList))) {
        break label243;
      }
      if (paramList.size() == 1)
      {
        if (!"123456789abc".equals(((ScanResult)paramList.get(0)).BSSID.toLowerCase())) {
          break label174;
        }
        return;
      }
    }
    if (paramList.size() > 1)
    {
      if (paramList == null) {
        break label253;
      }
      if (paramList.size() <= 1) {
        break label253;
      }
    }
    for (;;)
    {
      Object localObject;
      if (k != 0)
      {
        return;
        localObject = ((ScanResult)paramList.get(0)).BSSID;
        k = 1;
      }
      for (;;)
      {
        if (k >= paramList.size()) {
          break label265;
        }
        if (!((String)localObject).equals(((ScanResult)paramList.get(k)).BSSID))
        {
          k = 0;
          break;
          label174:
          long l = System.currentTimeMillis();
          if ((this.c.d) && (l - this.i < 5000L)) {
            return;
          }
          this.i = l;
          if (l - this.h < 30000L) {}
          for (localObject = this.f;; localObject = null)
          {
            this.c.a(this.d, paramList, (List)localObject);
            label243:
            return;
          }
          label253:
          k = 1;
          break;
        }
        k += 1;
      }
      label265:
      int k = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.co
 * JD-Core Version:    0.7.0.1
 */