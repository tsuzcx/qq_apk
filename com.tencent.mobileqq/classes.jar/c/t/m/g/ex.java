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

public final class ex
{
  public static boolean a = false;
  private static long b = 0L;
  private static boolean c = false;
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 25
    //   2: astore 5
    //   4: aload 5
    //   6: astore_3
    //   7: aload 5
    //   9: astore 4
    //   11: aload_0
    //   12: ldc 27
    //   14: iconst_0
    //   15: invokevirtual 33	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore 6
    //   20: aload 5
    //   22: astore_3
    //   23: aload 5
    //   25: astore 4
    //   27: aload 6
    //   29: ldc 35
    //   31: ldc 25
    //   33: invokeinterface 41 3 0
    //   38: astore_0
    //   39: aload_0
    //   40: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +21 -> 64
    //   46: ldc 49
    //   48: bipush 6
    //   50: ldc 51
    //   52: aload_0
    //   53: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   56: invokevirtual 61	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokestatic 66	c/t/m/g/ev:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: areturn
    //   64: invokestatic 72	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   67: astore 5
    //   69: aload_0
    //   70: astore_3
    //   71: aload_0
    //   72: astore 4
    //   74: aload 5
    //   76: invokeinterface 78 1 0
    //   81: ifeq +263 -> 344
    //   84: aload_0
    //   85: astore_3
    //   86: aload_0
    //   87: astore 4
    //   89: aload 5
    //   91: invokeinterface 82 1 0
    //   96: checkcast 68	java/net/NetworkInterface
    //   99: astore 7
    //   101: aload 7
    //   103: ifnull -34 -> 69
    //   106: aload_0
    //   107: astore_3
    //   108: aload_0
    //   109: astore 4
    //   111: aload 7
    //   113: invokevirtual 86	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   116: ldc 88
    //   118: invokevirtual 92	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   121: ifeq -52 -> 69
    //   124: aload_0
    //   125: astore_3
    //   126: aload_0
    //   127: astore 4
    //   129: aload 7
    //   131: invokevirtual 96	java/net/NetworkInterface:getHardwareAddress	()[B
    //   134: astore 8
    //   136: aload 8
    //   138: ifnull -69 -> 69
    //   141: aload_0
    //   142: astore_3
    //   143: aload_0
    //   144: astore 4
    //   146: aload 8
    //   148: arraylength
    //   149: ifeq -80 -> 69
    //   152: aload_0
    //   153: astore_3
    //   154: aload_0
    //   155: astore 4
    //   157: new 98	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   164: astore 9
    //   166: aload_0
    //   167: astore_3
    //   168: aload_0
    //   169: astore 4
    //   171: aload 8
    //   173: arraylength
    //   174: istore_2
    //   175: iconst_0
    //   176: istore_1
    //   177: iload_1
    //   178: iload_2
    //   179: if_icmpge +40 -> 219
    //   182: aload_0
    //   183: astore_3
    //   184: aload_0
    //   185: astore 4
    //   187: aload 9
    //   189: ldc 103
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload 8
    //   199: iload_1
    //   200: baload
    //   201: invokestatic 108	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   204: aastore
    //   205: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: iload_1
    //   213: iconst_1
    //   214: iadd
    //   215: istore_1
    //   216: goto -39 -> 177
    //   219: aload_0
    //   220: astore_3
    //   221: aload_0
    //   222: astore 4
    //   224: aload 9
    //   226: invokevirtual 120	java/lang/StringBuilder:length	()I
    //   229: ifle +21 -> 250
    //   232: aload_0
    //   233: astore_3
    //   234: aload_0
    //   235: astore 4
    //   237: aload 9
    //   239: aload 9
    //   241: invokevirtual 120	java/lang/StringBuilder:length	()I
    //   244: iconst_1
    //   245: isub
    //   246: invokevirtual 124	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_0
    //   251: astore_3
    //   252: aload_0
    //   253: astore 4
    //   255: aload 9
    //   257: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore_0
    //   261: aload_0
    //   262: astore_3
    //   263: aload_0
    //   264: astore 4
    //   266: aload 6
    //   268: invokeinterface 131 1 0
    //   273: ldc 35
    //   275: aload_0
    //   276: invokeinterface 137 3 0
    //   281: invokeinterface 140 1 0
    //   286: aload_0
    //   287: astore_3
    //   288: aload_0
    //   289: astore 4
    //   291: ldc 49
    //   293: new 98	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 142
    //   299: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload 7
    //   304: invokevirtual 86	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   307: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 147
    //   312: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 150	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -256 -> 69
    //   328: astore 4
    //   330: aload_3
    //   331: astore_0
    //   332: ldc 49
    //   334: aload 4
    //   336: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   339: invokestatic 150	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_0
    //   343: areturn
    //   344: aload_0
    //   345: areturn
    //   346: astore_3
    //   347: aload 4
    //   349: astore_0
    //   350: ldc 49
    //   352: aload_3
    //   353: invokevirtual 152	java/lang/Error:toString	()Ljava/lang/String;
    //   356: invokestatic 150	c/t/m/g/ev:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: aload_0
    //   360: areturn
    //   361: astore_3
    //   362: goto -12 -> 350
    //   365: astore 4
    //   367: goto -35 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramContext	Context
    //   176	40	1	i	int
    //   174	6	2	j	int
    //   6	325	3	localObject1	Object
    //   346	7	3	localError1	java.lang.Error
    //   361	1	3	localError2	java.lang.Error
    //   9	281	4	localObject2	Object
    //   328	20	4	localException1	Exception
    //   365	1	4	localException2	Exception
    //   2	88	5	localObject3	Object
    //   18	249	6	localSharedPreferences	android.content.SharedPreferences
    //   99	204	7	localNetworkInterface	java.net.NetworkInterface
    //   134	64	8	arrayOfByte	byte[]
    //   164	92	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	20	328	java/lang/Exception
    //   27	39	328	java/lang/Exception
    //   74	84	328	java/lang/Exception
    //   89	101	328	java/lang/Exception
    //   111	124	328	java/lang/Exception
    //   129	136	328	java/lang/Exception
    //   146	152	328	java/lang/Exception
    //   157	166	328	java/lang/Exception
    //   171	175	328	java/lang/Exception
    //   187	212	328	java/lang/Exception
    //   224	232	328	java/lang/Exception
    //   237	250	328	java/lang/Exception
    //   255	261	328	java/lang/Exception
    //   266	286	328	java/lang/Exception
    //   291	325	328	java/lang/Exception
    //   11	20	346	java/lang/Error
    //   27	39	346	java/lang/Error
    //   74	84	346	java/lang/Error
    //   89	101	346	java/lang/Error
    //   111	124	346	java/lang/Error
    //   129	136	346	java/lang/Error
    //   146	152	346	java/lang/Error
    //   157	166	346	java/lang/Error
    //   171	175	346	java/lang/Error
    //   187	212	346	java/lang/Error
    //   224	232	346	java/lang/Error
    //   237	250	346	java/lang/Error
    //   255	261	346	java/lang/Error
    //   266	286	346	java/lang/Error
    //   291	325	346	java/lang/Error
    //   39	62	361	java/lang/Error
    //   64	69	361	java/lang/Error
    //   39	62	365	java/lang/Exception
    //   64	69	365	java/lang/Exception
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
          break label66;
        }
        bool1 = bool2;
        ev.a("Wifis", 6, "start scan");
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
          label66:
          a = true;
        }
      }
      finally {}
      return bool1;
      bool1 = bool2;
      bool2 = c;
    }
  }
  
  public static boolean a(de paramde)
  {
    boolean bool2 = false;
    try
    {
      paramde = paramde.g;
      boolean bool1 = bool2;
      if (paramde != null)
      {
        boolean bool3 = paramde.isWifiEnabled();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramde)
    {
      ev.a("Wifis", 6, paramde.toString());
    }
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
        ev.a("Wifis", 6, "cannot getScanResults");
        a = true;
      }
    }
    paramWifiManager = (WifiManager)localObject1;
    if (localObject1 == null)
    {
      paramWifiManager = Collections.emptyList();
      ev.a("Wifis", 6, "cannot getScanResults");
    }
    return paramWifiManager;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean b(de paramde)
  {
    paramde = paramde.g;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramde != null) {}
    try
    {
      boolean bool3 = paramde.isWifiEnabled();
      bool1 = bool3;
      if (!bool3)
      {
        bool1 = bool3;
        bool2 = bool3;
        if (Build.VERSION.SDK_INT >= 18)
        {
          bool2 = bool3;
          bool1 = paramde.isScanAlwaysAvailable();
        }
      }
      return bool1;
    }
    catch (Throwable paramde) {}
    return bool2;
  }
  
  public static String c(de paramde)
  {
    Object localObject = paramde.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      paramde = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((paramde != null) && (localObject != null))
      {
        paramde = paramde.getConnectionInfo();
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((paramde != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = paramde.getBSSID();
          if ((localObject == null) || (((String)localObject).equals("000000000000")) || (((String)localObject).equals("00-00-00-00-00-00")) || (((String)localObject).equals("00:00:00:00:00:00"))) {
            break label232;
          }
          int i = paramde.getRssi();
          if ((i < -100) || (i > -20)) {
            break label235;
          }
          paramde = paramde.getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append(paramde);
          localStringBuilder.append("\"}");
          paramde = localStringBuilder.toString();
          return paramde;
        }
        return "{}";
      }
    }
    catch (Exception paramde)
    {
      return "{}";
    }
    return "{}";
    label232:
    return "{}";
    label235:
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ex
 * JD-Core Version:    0.7.0.1
 */