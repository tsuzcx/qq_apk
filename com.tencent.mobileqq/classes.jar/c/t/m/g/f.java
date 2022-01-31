package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLException;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends PhoneStateListener
{
  volatile boolean a;
  private final da b;
  private CellLocation c = null;
  private SignalStrength d = null;
  private ServiceState e = null;
  private long f;
  private HandlerThread g;
  private Handler h;
  
  public f(da paramda)
  {
    this.b = paramda;
  }
  
  private void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.b.c();
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException)
    {
      a.a("TxCellProvider", "listenCellState: failed! flags=" + paramInt, localException);
    }
  }
  
  private boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    try
    {
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)paramCellLocation;
      if (localGsmCellLocation.getCid() == 0)
      {
        int i = localGsmCellLocation.getLac();
        if (i == 0) {
          return false;
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      if (en.a(paramCellLocation) < 0) {
        return false;
      }
      if (en.a(this.c, paramCellLocation)) {
        return false;
      }
      paramCellLocation = ea.a(this.b, paramCellLocation, null);
      if (paramCellLocation == null) {}
      for (boolean bool = true; bool; bool = en.a(paramCellLocation)) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      if (this.c != null)
      {
        long l = System.currentTimeMillis();
        if (l - this.f > 2000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.f = l;
          ea localea = ea.a(this.b, this.c, this.d);
          try
          {
            if ((this.h != null) && (localea != null))
            {
              c localc = new c(this.b);
              localc.a(localea);
              this.h.post(localc);
            }
            return;
          }
          finally {}
        }
      }
    }
  }
  
  public final void a()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.g = new HandlerThread("CellProvider");
    this.g.start();
    this.h = new b(this.g.getLooper(), (byte)0);
    this.h.sendEmptyMessageDelayed(0, 3000L);
    CellLocation localCellLocation = en.a(this.b);
    if (a(localCellLocation))
    {
      ea localea = ea.a(this.b, localCellLocation, null);
      if (localea != null)
      {
        this.c = localCellLocation;
        this.b.b(localea);
      }
    }
    a(273);
    a.a("TxCellProvider", "startup: state=[start]");
  }
  
  public final void b()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    a(0);
    try
    {
      if (this.h != null)
      {
        this.h.removeCallbacksAndMessages(null);
        this.h = null;
      }
      this.g.quit();
      this.g = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = 0L;
      a.a("TxCellProvider", "shutdown: state=[shutdown]");
      return;
    }
    finally {}
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    try
    {
      if (a(paramCellLocation))
      {
        this.c = paramCellLocation;
        c();
        return;
      }
      a.b("TxCellProvider", "onCellLocationChanged: illegal cell or same cell " + paramCellLocation);
      return;
    }
    catch (Throwable paramCellLocation) {}
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int j = 1;
    int m = 0;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    for (;;)
    {
      return;
      try
      {
        ServiceState localServiceState = this.e;
        if ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState())) {
          continue;
        }
        this.e = paramServiceState;
        if (!this.a) {
          continue;
        }
        int i;
        boolean bool;
        if (this.e != null) {
          if (this.e.getState() == 0)
          {
            i = 1;
            paramServiceState = this.b.c();
            bool = en.a(this.b.a);
            if (paramServiceState == null) {
              break label175;
            }
            if (paramServiceState.getSimState() != 5) {
              break label164;
            }
            break label177;
          }
        }
        for (;;)
        {
          paramServiceState = new Message();
          paramServiceState.what = 12999;
          paramServiceState.arg1 = 12003;
          paramServiceState.arg2 = k;
          this.b.b(paramServiceState);
          return;
          i = this.e.getState();
          if (i == 1)
          {
            i = 0;
            break;
          }
          i = -1;
          break;
          label164:
          j = 0;
          label175:
          label177:
          do
          {
            k = i;
            break;
            j = 0;
            k = m;
            if (bool) {
              break;
            }
          } while (j != 0);
          int k = m;
        }
        return;
      }
      catch (Throwable paramServiceState) {}
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    for (;;)
    {
      return;
      try
      {
        SignalStrength localSignalStrength = this.d;
        int i = this.b.i().b;
        if ((localSignalStrength == null) || (en.a(i, localSignalStrength, paramSignalStrength)))
        {
          this.d = paramSignalStrength;
          c();
          return;
        }
      }
      catch (Throwable paramSignalStrength) {}
    }
  }
  
  public final class a
  {
    public a() {}
    
    private static double a(double paramDouble)
    {
      return 3.141592653589793D * paramDouble / 180.0D;
    }
    
    public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
    {
      paramDouble1 = a(paramDouble1);
      paramDouble3 = a(paramDouble3);
      paramDouble2 = a(paramDouble2);
      paramDouble4 = a(paramDouble4);
      double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
      return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D * 1000.0D;
    }
    
    public static double a(double paramDouble, int paramInt)
    {
      try
      {
        if (Double.isNaN(paramDouble)) {
          return 0.0D;
        }
        paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
        return paramDouble;
      }
      catch (Exception localException) {}
      return 0.0D;
    }
    
    @SuppressLint({"MissingPermission"})
    private static int a(WifiManager paramWifiManager)
    {
      if (paramWifiManager == null) {
        return 4;
      }
      try
      {
        int i = paramWifiManager.getWifiState();
        return i;
      }
      catch (Throwable paramWifiManager) {}
      return 4;
    }
    
    @SuppressLint({"MissingPermission"})
    public static cs a(Context paramContext)
    {
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localConnectivityManager == null) {}
        for (paramContext = null; (paramContext == null) || (!paramContext.isConnected()); paramContext = localConnectivityManager.getActiveNetworkInfo()) {
          return cs.a;
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (localConnectivityManager.isActiveNetworkMetered()) {
            return cs.b;
          }
          return cs.c;
        }
        if (1 == paramContext.getType()) {
          return cs.c;
        }
        paramContext = cs.b;
        return paramContext;
      }
      catch (Throwable paramContext) {}
      return cs.a;
    }
    
    public static String a(ea paramea, boolean paramBoolean)
    {
      if (paramea == null) {
        return "[]";
      }
      int j = paramea.b;
      int k = paramea.c;
      int m = paramea.a;
      Object localObject1 = new ArrayList();
      Object localObject2 = paramea.a();
      int i;
      int n;
      int i1;
      if (en.a(m, j, k, paramea.d, paramea.e))
      {
        i = paramea.d;
        int i2 = paramea.e;
        int i3 = paramea.f;
        n = paramea.g;
        i1 = paramea.h;
        paramea = new StringBuilder();
        paramea.append("{");
        paramea.append("\"mcc\":");
        paramea.append(j);
        paramea.append(",\"mnc\":");
        paramea.append(k);
        paramea.append(",\"lac\":");
        paramea.append(i);
        paramea.append(",\"cellid\":");
        paramea.append(i2);
        paramea.append(",\"rss\":");
        paramea.append(i3);
        paramea.append(",\"seed\":");
        if (paramBoolean)
        {
          i = 1;
          paramea.append(i);
          if ((n != 2147483647) && (i1 != 2147483647))
          {
            paramea.append(",\"stationLat\":");
            paramea.append(String.format("%.6f", new Object[] { Float.valueOf(n / 14400.0F) }));
            paramea.append(",\"stationLng\":");
            paramea.append(String.format("%.6f", new Object[] { Float.valueOf(i1 / 14400.0F) }));
          }
          paramea.append("}");
          ((ArrayList)localObject1).add(paramea.toString());
        }
      }
      for (;;)
      {
        try
        {
          paramea = ((List)localObject2).iterator();
          if (paramea.hasNext())
          {
            localObject2 = (NeighboringCellInfo)paramea.next();
            i = ((NeighboringCellInfo)localObject2).getLac();
            n = ((NeighboringCellInfo)localObject2).getCid();
            if (!en.a(m, j, k, i, n)) {
              break label565;
            }
            i1 = ((NeighboringCellInfo)localObject2).getRssi();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("{");
            ((StringBuilder)localObject2).append("\"mcc\":");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(",\"mnc\":");
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append(",\"lac\":");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(",\"cellid\":");
            ((StringBuilder)localObject2).append(n);
            ((StringBuilder)localObject2).append(",\"rss\":");
            ((StringBuilder)localObject2).append((i1 << 1) - 113);
            ((StringBuilder)localObject2).append("}");
            ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
            continue;
          }
          i = 0;
        }
        catch (Exception paramea)
        {
          paramea = new StringBuilder("[");
          localObject2 = new ep(",");
          localObject1 = ((Iterable)localObject1).iterator();
          paramea.append(((ep)localObject2).a(new StringBuilder(), (Iterator)localObject1).toString());
          paramea.append("]");
          return paramea.toString();
        }
        break;
        a("illeagal main cell! ", j, k, m, paramea.d, paramea.e);
        continue;
        label565:
        a("illeagal neighboringCell! ", j, k, m, i, n);
      }
    }
    
    public static String a(eb parameb)
    {
      if (parameb == null) {
        return "{}";
      }
      Location localLocation = parameb.a;
      StringBuilder localStringBuilder = new StringBuilder();
      double d1 = a(localLocation.getLatitude(), 6);
      double d2 = a(localLocation.getLongitude(), 6);
      double d3 = a(localLocation.getAltitude(), 1);
      double d4 = a(localLocation.getAccuracy(), 1);
      double d5 = a(localLocation.getBearing(), 1);
      double d6 = a(localLocation.getSpeed(), 1);
      localStringBuilder.append("{");
      localStringBuilder.append("\"latitude\":");
      localStringBuilder.append(d1);
      localStringBuilder.append(",\"longitude\":");
      localStringBuilder.append(d2);
      localStringBuilder.append(",\"additional\":");
      localStringBuilder.append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + parameb.b + "\"");
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public static String a(ee paramee)
    {
      if (paramee == null) {}
      for (paramee = null; paramee == null; paramee = paramee.a()) {
        return "[]";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      if (paramee.size() <= 0)
      {
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      Iterator localIterator = paramee.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        ScanResult localScanResult = (ScanResult)localIterator.next();
        paramee.size();
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("{\"mac\":\"").append(localScanResult.BSSID).append("\",");
        localStringBuilder.append("\"rssi\":").append(localScanResult.level).append("}");
        i += 1;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
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
    
    private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      boolean bool = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCellInfoWithJsonFormat: ");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.append("isGsm=");
      if (paramInt3 == 1) {}
      for (;;)
      {
        paramString.append(bool);
        localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
        localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
        return;
        bool = false;
      }
    }
    
    private static void a(String paramString1, int paramInt, String paramString2)
    {
      Object localObject = TencentExtraKeys.getTencentLogs();
      if (paramString2 != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TencentLog)((Iterator)localObject).next()).println(paramString1, paramInt, paramString2);
        }
      }
    }
    
    public static void a(String paramString1, String paramString2)
    {
      a(paramString1, 4, paramString2);
    }
    
    public static void a(String paramString1, String paramString2, Throwable paramThrowable)
    {
      a(paramString1, 6, paramString2 + " exception: " + Log.getStackTraceString(paramThrowable));
    }
    
    public static void a(String paramString, byte[] paramArrayOfByte, cp.1.a parama, int paramInt)
    {
      for (;;)
      {
        try
        {
          HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
          localHttpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
          localHttpURLConnection.setRequestMethod("POST");
          localHttpURLConnection.setConnectTimeout(10000);
          localHttpURLConnection.setDoOutput(true);
          localHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
          Object localObject = localHttpURLConnection.getOutputStream();
          ((OutputStream)localObject).write(paramArrayOfByte);
          ((OutputStream)localObject).flush();
          ((OutputStream)localObject).close();
          int i = localHttpURLConnection.getResponseCode();
          switch (i)
          {
          case 200: 
            cp.1.a.a("net sdk error: " + i);
            localHttpURLConnection.disconnect();
            return;
            localObject = g(localHttpURLConnection.getHeaderField("content-type"));
            new String(a(localHttpURLConnection.getInputStream()), (String)localObject);
            parama.a();
          }
        }
        catch (Throwable localThrowable)
        {
          if ((paramInt <= 0) && (((localThrowable instanceof GeneralSecurityException)) || ((localThrowable instanceof SSLException))))
          {
            paramString = paramString.replaceAll("https:", "http:");
            paramInt += 1;
          }
          else
          {
            cp.1.a.a(paramInt + "," + paramString + "," + Log.getStackTraceString(localThrowable));
            return;
          }
        }
      }
    }
    
    public static boolean a(int paramInt)
    {
      return paramInt == 0;
    }
    
    public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
    {
      int n = (int)(paramLocation.getLatitude() * 1000000.0D);
      int i1 = (int)(paramLocation.getLongitude() * 1000000.0D);
      paramLocation = e("tencent_loc_lib");
      int k = 0;
      int m = 0;
      while (k < paramLocation.length())
      {
        int i2 = paramLocation.charAt(k);
        int j = 256;
        int i = j;
        if (i2 >= 65)
        {
          i = j;
          if (i2 <= 90) {
            i = i2 - 65;
          }
        }
        j = i;
        if (i2 >= 97)
        {
          j = i;
          if (i2 <= 122) {
            j = i2 - 97 + 64;
          }
        }
        i = j;
        if (i2 >= 48)
        {
          i = j;
          if (i2 <= 57) {
            i = i2 + 128 - 48;
          }
        }
        m += i;
        k += 1;
      }
      paramLocation = new double[2];
      try
      {
        e.b(n ^ m, m ^ i1, paramLocation);
        label169:
        paramArrayOfDouble[0] = paramLocation[0];
        paramArrayOfDouble[1] = paramLocation[1];
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        break label169;
      }
    }
    
    public static boolean a(Object paramObject)
    {
      return paramObject == null;
    }
    
    public static boolean a(Object paramObject1, Object paramObject2)
    {
      return (paramObject1 == null) || (paramObject2 == null);
    }
    
    public static boolean a(Object paramObject, Object... paramVarArgs)
    {
      if ((paramVarArgs == null) && (paramObject == null)) {}
      for (int i = 1; i == 0; i = 0) {
        return false;
      }
      int j = paramVarArgs.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label44;
        }
        if (paramVarArgs[i] != null) {
          break;
        }
        i += 1;
      }
      label44:
      return true;
    }
    
    public static boolean a(List paramList)
    {
      return (paramList == null) || (paramList.size() == 0);
    }
    
    public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
    {
      if ((paramList1 == null) || (paramList2 == null)) {
        return false;
      }
      int n = paramList1.size();
      int i1 = paramList2.size();
      if ((n == 0) && (i1 == 0)) {
        return true;
      }
      if ((n == 0) || (i1 == 0)) {
        return false;
      }
      int m;
      int j;
      int i;
      label79:
      Object localObject;
      label161:
      int k;
      if (paramList1.size() > paramList2.size())
      {
        paramList2 = paramList2.iterator();
        m = 1;
        j = 0;
        i = 0;
        if (!paramList2.hasNext()) {
          break label233;
        }
        localObject = (ScanResult)paramList2.next();
        Iterator localIterator = paramList1.iterator();
        for (;;)
        {
          if (localIterator.hasNext()) {
            if (((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject).BSSID)) {
              if ((m == 1) && (((ScanResult)localObject).level > -50))
              {
                i += 1;
                k = i;
                if (m == 2)
                {
                  k = i;
                  if (((ScanResult)localObject).level > -60) {
                    k = i + 1;
                  }
                }
                if ((m == 3) && (((ScanResult)localObject).level > -60))
                {
                  i = k + 1;
                  label209:
                  j += 1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        m += 1;
        break label79;
        localObject = paramList1;
        paramList1 = paramList2;
        paramList2 = (List<ScanResult>)localObject;
        break;
        label233:
        if (i == 3)
        {
          a("TxWifiChange", 4, "big 3 is similar");
          return false;
        }
        i = n + i1;
        if ((j << 1 < i * 0.85D) || (j < 13)) {}
        for (boolean bool = true;; bool = false)
        {
          a("TxWifiChange", "isDiffrent:c=" + n + ",k=" + j + ",f=" + i + ",r=0.85,s=" + bool);
          return bool;
        }
        i = k;
        break label209;
        break label161;
      }
    }
    
    public static boolean a(byte[] paramArrayOfByte)
    {
      return (paramArrayOfByte == null) || (paramArrayOfByte.length == 0);
    }
    
    /* Error */
    public static byte[] a(java.io.File paramFile)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 538	java/io/File:exists	()Z
      //   4: ifeq +12 -> 16
      //   7: aload_0
      //   8: invokevirtual 541	java/io/File:length	()J
      //   11: lconst_0
      //   12: lcmp
      //   13: ifne +7 -> 20
      //   16: iconst_0
      //   17: newarray byte
      //   19: areturn
      //   20: new 543	java/io/ByteArrayOutputStream
      //   23: dup
      //   24: invokespecial 544	java/io/ByteArrayOutputStream:<init>	()V
      //   27: astore 4
      //   29: sipush 4096
      //   32: newarray byte
      //   34: astore_3
      //   35: new 546	java/io/BufferedInputStream
      //   38: dup
      //   39: new 548	java/io/FileInputStream
      //   42: dup
      //   43: aload_0
      //   44: invokespecial 551	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   47: invokespecial 554	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   50: astore_2
      //   51: aload_2
      //   52: astore_0
      //   53: aload_2
      //   54: aload_3
      //   55: invokevirtual 558	java/io/BufferedInputStream:read	([B)I
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
      //   71: invokevirtual 561	java/io/ByteArrayOutputStream:write	([BII)V
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
      //   90: invokestatic 563	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
      //   93: aload 4
      //   95: invokestatic 563	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
      //   98: aload_0
      //   99: athrow
      //   100: aload_2
      //   101: astore_0
      //   102: aload 4
      //   104: invokevirtual 567	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   107: astore_3
      //   108: aload_2
      //   109: invokestatic 563	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
      //   112: aload 4
      //   114: invokestatic 563	c/t/m/g/f$a:a	(Ljava/io/Closeable;)V
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
      //   0	131	0	paramFile	java.io.File
      //   58	13	1	i	int
      //   50	72	2	localObject1	Object
      //   125	1	2	localIOException1	IOException
      //   34	35	3	arrayOfByte1	byte[]
      //   77	4	3	localIOException2	IOException
      //   84	4	3	localObject2	Object
      //   107	11	3	arrayOfByte2	byte[]
      //   27	86	4	localByteArrayOutputStream	ByteArrayOutputStream
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
    
    private static byte[] a(InputStream paramInputStream)
      throws IOException
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(256);
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramInputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    
    public static int b(Context paramContext)
    {
      try
      {
        int i = a((WifiManager)paramContext.getSystemService("wifi"));
        return i;
      }
      catch (Throwable paramContext) {}
      return 4;
    }
    
    public static <T> T b(T paramT, Object paramObject)
    {
      if (paramT == null) {
        throw new NullPointerException(String.valueOf(paramObject));
      }
      return paramT;
    }
    
    public static void b(String paramString)
    {
      a("#", 4, paramString);
    }
    
    public static void b(String paramString1, String paramString2)
    {
      a(paramString1, 6, paramString2);
    }
    
    public static boolean b(Object paramObject)
    {
      return paramObject != null;
    }
    
    public static byte[] b(byte[] paramArrayOfByte)
    {
      byte[] arrayOfByte = c(paramArrayOfByte);
      int i = arrayOfByte.length;
      paramArrayOfByte = new byte[i];
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i);
      int k = i % 5 + 7;
      i = 0;
      while ((k << 1) + i < paramArrayOfByte.length)
      {
        int m = Integer.valueOf(i).byteValue();
        int j = 0;
        while (j < k)
        {
          int n = paramArrayOfByte[(i + j)];
          paramArrayOfByte[(i + j)] = ((byte)(paramArrayOfByte[(i + k + j)] ^ m));
          paramArrayOfByte[(i + k + j)] = ((byte)(n ^ m));
          j += 1;
        }
        i += (k << 1);
      }
      arrayOfByte = new byte[paramArrayOfByte.length + 4];
      i = paramArrayOfByte.length;
      arrayOfByte[0] = Integer.valueOf(i >> 8).byteValue();
      arrayOfByte[1] = Integer.valueOf(i >> 24).byteValue();
      arrayOfByte[2] = Integer.valueOf(i >> 16).byteValue();
      arrayOfByte[3] = Integer.valueOf(i).byteValue();
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, i);
      return arrayOfByte;
    }
    
    @SuppressLint({"MissingPermission"})
    public static String c(Context paramContext)
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
              break label236;
            }
            int i = paramContext.getRssi();
            if ((i < -100) || (i > -20)) {
              break label240;
            }
            paramContext = paramContext.getSSID().replace("\"", "").replace("|", "");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("{");
            ((StringBuilder)localObject2).append("\"mac\":\"");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("\",\"rssi\":");
            ((StringBuilder)localObject2).append(i);
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
      label236:
      return "{}";
      label240:
      return "{}";
    }
    
    public static String c(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      return str;
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
    
    public static String d(Context paramContext)
    {
      int i = f(paramContext);
      if (i != -1)
      {
        if (i == 0) {
          return "mobile";
        }
        if (i == 1) {
          return "wifi";
        }
      }
      return "none";
    }
    
    public static HashMap<String, String> d()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("https", "true");
      localHashMap.put("up_apps", "true");
      localHashMap.put("start_daemon", "true");
      localHashMap.put("up_daemon_delay", "600000");
      localHashMap.put("gps_kalman", "false");
      localHashMap.put("min_wifi_scan_interval", "8000");
      localHashMap.put("f_coll_item", "0");
      localHashMap.put("f_coll_up_net", "w");
      return localHashMap;
    }
    
    public static boolean d(String paramString)
    {
      do
      {
        JSONObject localJSONObject;
        do
        {
          try
          {
            localJSONObject = new JSONObject(paramString);
            if (paramString.contains("latitude")) {
              return true;
            }
          }
          catch (Exception paramString)
          {
            return false;
          }
          paramString = localJSONObject.optJSONArray("cells");
        } while ((paramString != null) && (paramString.length() > 0));
        paramString = localJSONObject.optJSONArray("wifis");
      } while ((paramString != null) && (paramString.length() > 0));
      return false;
    }
    
    @Nullable
    public static byte[] d(byte[] paramArrayOfByte)
    {
      int i = 0;
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
          int j = localInflaterInputStream.read(arrayOfByte2);
          if (j > 0)
          {
            i += j;
            byte[] arrayOfByte1 = new byte[i];
            System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, j);
            paramArrayOfByte = arrayOfByte1;
            if (j <= 0) {
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
    
    public static String e(String paramString)
    {
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        localObject = ((MessageDigest)localObject).digest();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localStringBuilder.append(Integer.toHexString(localObject[i] & 0xFF)).append("");
          i += 1;
        }
        localObject = localStringBuilder.toString();
        return localObject;
      }
      catch (Exception localException) {}
      return paramString;
    }
    
    public static boolean e(Context paramContext)
    {
      int i;
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null) {
          break label62;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        NetworkInfo.State localState;
        return false;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        paramContext = paramContext.getState();
        localState = NetworkInfo.State.CONNECTED;
        if (paramContext == localState) {
          return true;
        }
      }
      return false;
      while (i != 0)
      {
        return false;
        label62:
        i = 0;
      }
    }
    
    private static int f(Context paramContext)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {}
      for (int i = 1; i != 0; i = 0) {
        return -1;
      }
      try
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null)
        {
          i = paramContext.getType();
          return i;
        }
      }
      catch (Exception paramContext) {}
      return -1;
    }
    
    public static int f(String paramString)
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
    
    private static String g(String paramString)
    {
      String str2 = "GBK";
      String str1 = str2;
      int j;
      int i;
      if (paramString != null)
      {
        paramString = paramString.split(";");
        j = paramString.length;
        i = 0;
      }
      for (;;)
      {
        str1 = str2;
        if (i < j)
        {
          str1 = paramString[i].trim();
          int k = str1.indexOf("charset=");
          if (-1 != k) {
            str1 = str1.substring(k + 8, str1.length());
          }
        }
        else
        {
          return str1;
        }
        i += 1;
      }
    }
    
    public final int a()
    {
      return f.this.a;
    }
    
    public final String a(String paramString)
    {
      return f.this.a(paramString);
    }
    
    public final int b()
    {
      return f.this.c;
    }
    
    public final byte[] c()
    {
      return f.this.d;
    }
  }
  
  final class b
    extends Handler
  {
    private b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!f.this.a) {
        return;
      }
      sendEmptyMessageDelayed(0, 30000L);
      paramMessage = en.a(f.a(f.this));
      f.a(f.this, paramMessage);
    }
  }
  
  static final class c
    implements Runnable
  {
    private da a;
    private ea b;
    
    public c(da paramda)
    {
      this.a = paramda;
    }
    
    public final void a(ea paramea)
    {
      this.b = paramea;
    }
    
    public final void run()
    {
      da localda = this.a;
      ea localea = this.b;
      if (localea != null)
      {
        localea.a(en.b(localda));
        localda.b(localea);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.f
 * JD-Core Version:    0.7.0.1
 */