package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.List;

public final class fn
{
  public static boolean a = false;
  private static long b = 0L;
  private static boolean c = false;
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 23
    //   2: astore_3
    //   3: aload_3
    //   4: astore_2
    //   5: ldc 25
    //   7: invokestatic 30	c/t/m/g/dv:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   10: astore 4
    //   12: aload_3
    //   13: astore_2
    //   14: aload 4
    //   16: ldc 32
    //   18: ldc 23
    //   20: invokestatic 35	c/t/m/g/dv:b	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 37	java/lang/String
    //   26: astore_3
    //   27: aload_3
    //   28: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +5 -> 36
    //   34: aload_3
    //   35: areturn
    //   36: invokestatic 49	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   39: astore 5
    //   41: aload_3
    //   42: astore_2
    //   43: aload 5
    //   45: invokeinterface 55 1 0
    //   50: ifeq +195 -> 245
    //   53: aload_3
    //   54: astore_2
    //   55: aload 5
    //   57: invokeinterface 59 1 0
    //   62: checkcast 45	java/net/NetworkInterface
    //   65: astore 6
    //   67: aload 6
    //   69: ifnull -28 -> 41
    //   72: aload_3
    //   73: astore_2
    //   74: aload 6
    //   76: invokevirtual 62	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   79: ldc 64
    //   81: invokevirtual 68	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   84: ifeq -43 -> 41
    //   87: aload_3
    //   88: astore_2
    //   89: aload 6
    //   91: invokevirtual 72	java/net/NetworkInterface:getHardwareAddress	()[B
    //   94: astore 7
    //   96: aload 7
    //   98: ifnull -57 -> 41
    //   101: aload_3
    //   102: astore_2
    //   103: aload 7
    //   105: arraylength
    //   106: ifeq -65 -> 41
    //   109: aload_3
    //   110: astore_2
    //   111: new 74	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   118: astore 8
    //   120: aload_3
    //   121: astore_2
    //   122: aload 7
    //   124: arraylength
    //   125: istore_1
    //   126: iconst_0
    //   127: istore_0
    //   128: iload_0
    //   129: iload_1
    //   130: if_icmpge +37 -> 167
    //   133: aload_3
    //   134: astore_2
    //   135: aload 8
    //   137: ldc 79
    //   139: iconst_1
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload 7
    //   147: iload_0
    //   148: baload
    //   149: invokestatic 85	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   152: aastore
    //   153: invokestatic 89	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: iload_0
    //   161: iconst_1
    //   162: iadd
    //   163: istore_0
    //   164: goto -36 -> 128
    //   167: aload_3
    //   168: astore_2
    //   169: aload 8
    //   171: invokevirtual 97	java/lang/StringBuilder:length	()I
    //   174: ifle +18 -> 192
    //   177: aload_3
    //   178: astore_2
    //   179: aload 8
    //   181: aload 8
    //   183: invokevirtual 97	java/lang/StringBuilder:length	()I
    //   186: iconst_1
    //   187: isub
    //   188: invokevirtual 101	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: astore_2
    //   194: aload 8
    //   196: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: astore_3
    //   200: aload_3
    //   201: astore_2
    //   202: aload 4
    //   204: ldc 32
    //   206: aload_3
    //   207: invokestatic 107	c/t/m/g/dv:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   210: aload_3
    //   211: astore_2
    //   212: new 74	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 109
    //   218: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload 6
    //   223: invokevirtual 62	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   226: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 114
    //   231: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_3
    //   235: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: goto -198 -> 41
    //   242: astore_3
    //   243: aload_2
    //   244: areturn
    //   245: aload_3
    //   246: areturn
    //   247: astore_2
    //   248: aload_3
    //   249: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   127	37	0	i	int
    //   125	6	1	j	int
    //   4	240	2	str1	String
    //   247	1	2	localThrowable1	Throwable
    //   2	233	3	str2	String
    //   242	7	3	localThrowable2	Throwable
    //   10	193	4	localSharedPreferences	android.content.SharedPreferences
    //   39	17	5	localEnumeration	java.util.Enumeration
    //   65	157	6	localNetworkInterface	java.net.NetworkInterface
    //   94	52	7	arrayOfByte	byte[]
    //   118	77	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	12	242	java/lang/Throwable
    //   14	27	242	java/lang/Throwable
    //   43	53	242	java/lang/Throwable
    //   55	67	242	java/lang/Throwable
    //   74	87	242	java/lang/Throwable
    //   89	96	242	java/lang/Throwable
    //   103	109	242	java/lang/Throwable
    //   111	120	242	java/lang/Throwable
    //   122	126	242	java/lang/Throwable
    //   135	160	242	java/lang/Throwable
    //   169	177	242	java/lang/Throwable
    //   179	192	242	java/lang/Throwable
    //   194	200	242	java/lang/Throwable
    //   202	210	242	java/lang/Throwable
    //   212	239	242	java/lang/Throwable
    //   27	34	247	java/lang/Throwable
    //   36	41	247	java/lang/Throwable
  }
  
  public static boolean a(WifiManager paramWifiManager)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramWifiManager != null) {}
    for (bool1 = bool2;; bool1 = bool2)
    {
      try
      {
        if (System.currentTimeMillis() - b <= 4000L) {
          break label55;
        }
        bool1 = bool2;
        bool2 = paramWifiManager.startScan();
        bool1 = bool2;
        c = bool2;
        bool1 = bool2;
        b = System.currentTimeMillis();
        bool1 = bool2;
      }
      catch (Exception paramWifiManager)
      {
        for (;;)
        {
          label55:
          a = true;
        }
      }
      finally {}
      return bool1;
      bool1 = bool2;
      bool2 = c;
    }
  }
  
  public static boolean a(dx paramdx)
  {
    boolean bool2 = false;
    try
    {
      paramdx = paramdx.g;
      boolean bool1 = bool2;
      if (paramdx != null)
      {
        boolean bool3 = paramdx.isWifiEnabled();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramdx) {}
    return false;
  }
  
  public static List<ScanResult> b(WifiManager paramWifiManager)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramWifiManager != null) {
      localObject1 = localObject2;
    }
    try
    {
      paramWifiManager = paramWifiManager.getScanResults();
      localObject1 = paramWifiManager;
      a = false;
      localObject1 = paramWifiManager;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
        a = true;
      }
    }
    paramWifiManager = (WifiManager)localObject1;
    if (localObject1 == null) {
      paramWifiManager = Collections.emptyList();
    }
    return paramWifiManager;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean b(dx paramdx)
  {
    paramdx = paramdx.g;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramdx != null) {}
    try
    {
      boolean bool3 = paramdx.isWifiEnabled();
      bool1 = bool3;
      if (!bool3)
      {
        bool1 = bool3;
        bool2 = bool3;
        if (Build.VERSION.SDK_INT >= 18)
        {
          bool2 = bool3;
          bool1 = paramdx.isScanAlwaysAvailable();
        }
      }
      return bool1;
    }
    catch (Throwable paramdx) {}
    return bool2;
  }
  
  public static String c(dx paramdx)
  {
    Object localObject = paramdx.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      paramdx = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((paramdx != null) && (localObject != null))
      {
        paramdx = paramdx.getConnectionInfo();
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((paramdx != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = paramdx.getBSSID();
          if ((localObject == null) || (((String)localObject).equals("000000000000")) || (((String)localObject).equals("00-00-00-00-00-00")) || (((String)localObject).equals("00:00:00:00:00:00"))) {
            break label225;
          }
          int i = paramdx.getRssi();
          if ((i < -100) || (i > -20)) {
            break label228;
          }
          paramdx = paramdx.getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append(paramdx);
          localStringBuilder.append("\"}");
          paramdx = localStringBuilder.toString();
          return paramdx;
        }
        return "{}";
      }
    }
    catch (Exception paramdx)
    {
      return "{}";
    }
    return "{}";
    label225:
    return "{}";
    label228:
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.fn
 * JD-Core Version:    0.7.0.1
 */