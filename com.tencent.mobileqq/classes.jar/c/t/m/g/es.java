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

public final class es
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
    //   43: ifne +26 -> 69
    //   46: ldc 49
    //   48: new 51	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 53
    //   54: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 70	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: areturn
    //   69: invokestatic 76	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   72: astore 5
    //   74: aload_0
    //   75: astore_3
    //   76: aload_0
    //   77: astore 4
    //   79: aload 5
    //   81: invokeinterface 82 1 0
    //   86: ifeq +263 -> 349
    //   89: aload_0
    //   90: astore_3
    //   91: aload_0
    //   92: astore 4
    //   94: aload 5
    //   96: invokeinterface 86 1 0
    //   101: checkcast 72	java/net/NetworkInterface
    //   104: astore 7
    //   106: aload 7
    //   108: ifnull -34 -> 74
    //   111: aload_0
    //   112: astore_3
    //   113: aload_0
    //   114: astore 4
    //   116: aload 7
    //   118: invokevirtual 89	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   121: ldc 91
    //   123: invokevirtual 97	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   126: ifeq -52 -> 74
    //   129: aload_0
    //   130: astore_3
    //   131: aload_0
    //   132: astore 4
    //   134: aload 7
    //   136: invokevirtual 101	java/net/NetworkInterface:getHardwareAddress	()[B
    //   139: astore 8
    //   141: aload 8
    //   143: ifnull -69 -> 74
    //   146: aload_0
    //   147: astore_3
    //   148: aload_0
    //   149: astore 4
    //   151: aload 8
    //   153: arraylength
    //   154: ifeq -80 -> 74
    //   157: aload_0
    //   158: astore_3
    //   159: aload_0
    //   160: astore 4
    //   162: new 51	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   169: astore 9
    //   171: aload_0
    //   172: astore_3
    //   173: aload_0
    //   174: astore 4
    //   176: aload 8
    //   178: arraylength
    //   179: istore_2
    //   180: iconst_0
    //   181: istore_1
    //   182: iload_1
    //   183: iload_2
    //   184: if_icmpge +40 -> 224
    //   187: aload_0
    //   188: astore_3
    //   189: aload_0
    //   190: astore 4
    //   192: aload 9
    //   194: ldc 105
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload 8
    //   204: iload_1
    //   205: baload
    //   206: invokestatic 111	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   209: aastore
    //   210: invokestatic 115	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   213: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: iload_1
    //   218: iconst_1
    //   219: iadd
    //   220: istore_1
    //   221: goto -39 -> 182
    //   224: aload_0
    //   225: astore_3
    //   226: aload_0
    //   227: astore 4
    //   229: aload 9
    //   231: invokevirtual 119	java/lang/StringBuilder:length	()I
    //   234: ifle +21 -> 255
    //   237: aload_0
    //   238: astore_3
    //   239: aload_0
    //   240: astore 4
    //   242: aload 9
    //   244: aload 9
    //   246: invokevirtual 119	java/lang/StringBuilder:length	()I
    //   249: iconst_1
    //   250: isub
    //   251: invokevirtual 123	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_0
    //   256: astore_3
    //   257: aload_0
    //   258: astore 4
    //   260: aload 9
    //   262: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: astore_0
    //   266: aload_0
    //   267: astore_3
    //   268: aload_0
    //   269: astore 4
    //   271: aload 6
    //   273: invokeinterface 127 1 0
    //   278: ldc 35
    //   280: aload_0
    //   281: invokeinterface 133 3 0
    //   286: invokeinterface 136 1 0
    //   291: aload_0
    //   292: astore_3
    //   293: aload_0
    //   294: astore 4
    //   296: ldc 49
    //   298: new 51	java/lang/StringBuilder
    //   301: dup
    //   302: ldc 138
    //   304: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   307: aload 7
    //   309: invokevirtual 89	java/net/NetworkInterface:getName	()Ljava/lang/String;
    //   312: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc 140
    //   317: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_0
    //   321: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 70	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: goto -256 -> 74
    //   333: astore 4
    //   335: aload_3
    //   336: astore_0
    //   337: ldc 49
    //   339: aload 4
    //   341: invokevirtual 141	java/lang/Exception:toString	()Ljava/lang/String;
    //   344: invokestatic 70	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: areturn
    //   349: aload_0
    //   350: areturn
    //   351: astore_3
    //   352: aload 4
    //   354: astore_0
    //   355: ldc 49
    //   357: aload_3
    //   358: invokevirtual 142	java/lang/Error:toString	()Ljava/lang/String;
    //   361: invokestatic 70	c/t/m/g/f$a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload_0
    //   365: areturn
    //   366: astore_3
    //   367: goto -12 -> 355
    //   370: astore 4
    //   372: goto -35 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramContext	Context
    //   181	40	1	i	int
    //   179	6	2	j	int
    //   6	330	3	localObject1	Object
    //   351	7	3	localError1	java.lang.Error
    //   366	1	3	localError2	java.lang.Error
    //   9	286	4	localObject2	Object
    //   333	20	4	localException1	Exception
    //   370	1	4	localException2	Exception
    //   2	93	5	localObject3	Object
    //   18	254	6	localSharedPreferences	android.content.SharedPreferences
    //   104	204	7	localNetworkInterface	java.net.NetworkInterface
    //   139	64	8	arrayOfByte	byte[]
    //   169	92	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	20	333	java/lang/Exception
    //   27	39	333	java/lang/Exception
    //   79	89	333	java/lang/Exception
    //   94	106	333	java/lang/Exception
    //   116	129	333	java/lang/Exception
    //   134	141	333	java/lang/Exception
    //   151	157	333	java/lang/Exception
    //   162	171	333	java/lang/Exception
    //   176	180	333	java/lang/Exception
    //   192	217	333	java/lang/Exception
    //   229	237	333	java/lang/Exception
    //   242	255	333	java/lang/Exception
    //   260	266	333	java/lang/Exception
    //   271	291	333	java/lang/Exception
    //   296	330	333	java/lang/Exception
    //   11	20	351	java/lang/Error
    //   27	39	351	java/lang/Error
    //   79	89	351	java/lang/Error
    //   94	106	351	java/lang/Error
    //   116	129	351	java/lang/Error
    //   134	141	351	java/lang/Error
    //   151	157	351	java/lang/Error
    //   162	171	351	java/lang/Error
    //   176	180	351	java/lang/Error
    //   192	217	351	java/lang/Error
    //   229	237	351	java/lang/Error
    //   242	255	351	java/lang/Error
    //   260	266	351	java/lang/Error
    //   271	291	351	java/lang/Error
    //   296	330	351	java/lang/Error
    //   39	67	366	java/lang/Error
    //   69	74	366	java/lang/Error
    //   39	67	370	java/lang/Exception
    //   69	74	370	java/lang/Exception
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
          break label64;
        }
        bool1 = bool2;
        f.a.b("Wifis", "start scan");
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
          label64:
          a = true;
        }
      }
      finally {}
      return bool1;
      bool1 = bool2;
      bool2 = c;
    }
  }
  
  public static boolean a(da paramda)
  {
    boolean bool2 = false;
    try
    {
      paramda = paramda.d();
      boolean bool1 = bool2;
      if (paramda != null)
      {
        boolean bool3 = paramda.isWifiEnabled();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramda)
    {
      f.a.b("Wifis", paramda.toString());
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
        f.a.b("Wifis", "cannot getScanResults");
        a = true;
      }
    }
    paramWifiManager = (WifiManager)localObject1;
    if (localObject1 == null)
    {
      paramWifiManager = Collections.emptyList();
      f.a.b("Wifis", "cannot getScanResults");
    }
    return paramWifiManager;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean b(da paramda)
  {
    paramda = paramda.d();
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramda != null) {}
    try
    {
      boolean bool3 = paramda.isWifiEnabled();
      bool1 = bool3;
      if (!bool3)
      {
        bool1 = bool3;
        bool2 = bool3;
        if (Build.VERSION.SDK_INT >= 18)
        {
          bool2 = bool3;
          bool1 = paramda.isScanAlwaysAvailable();
        }
      }
      return bool1;
    }
    catch (Throwable paramda) {}
    return bool2;
  }
  
  public static String c(da paramda)
  {
    Object localObject = paramda.a;
    if (localObject == null) {
      return "{}";
    }
    try
    {
      paramda = (WifiManager)((Context)localObject).getSystemService("wifi");
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((paramda != null) && (localObject != null))
      {
        paramda = paramda.getConnectionInfo();
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if ((paramda != null) && (localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          localObject = paramda.getBSSID();
          if ((localObject == null) || (((String)localObject).equals("000000000000")) || (((String)localObject).equals("00-00-00-00-00-00")) || (((String)localObject).equals("00:00:00:00:00:00"))) {
            break label231;
          }
          int i = paramda.getRssi();
          if ((i < -100) || (i > -20)) {
            break label234;
          }
          paramda = paramda.getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append(paramda);
          localStringBuilder.append("\"}");
          paramda = localStringBuilder.toString();
          return paramda;
        }
        return "{}";
      }
    }
    catch (Exception paramda)
    {
      return "{}";
    }
    return "{}";
    label231:
    return "{}";
    label234:
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.es
 * JD-Core Version:    0.7.0.1
 */