import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.net.NetworkInterface;

public class bihc
{
  public static int a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if ((paramContext == null) || (paramContext.getSimState() == 1)) {
      return 3;
    }
    paramContext = paramContext.getNetworkOperator();
    if ((paramContext.equals("46000")) || (paramContext.equals("46002")) || (paramContext.equals("46007"))) {
      return 0;
    }
    if (paramContext.equals("46001")) {
      return 1;
    }
    if (paramContext.equals("46003")) {
      return 2;
    }
    return 3;
  }
  
  public static String a()
  {
    do
    {
      try
      {
        String str3 = bkfy.c("f5cc92");
        str2 = str3;
        String str4;
        String str1 = str2;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (!TextUtils.isEmpty(str3))
          {
            str1 = str3;
            str2 = str3;
            if (!"02:00:00:00:00:00".equals(str3)) {}
          }
          else
          {
            str2 = str3;
            str1 = a("wifi.interface");
            str4 = str1;
            str2 = str3;
            if (TextUtils.isEmpty(str1)) {
              str4 = "wlan0";
            }
            str2 = str3;
            str3 = c(str4);
            str2 = str3;
            if (!TextUtils.isEmpty(str3))
            {
              str1 = str3;
              str2 = str3;
              if (!"02:00:00:00:00:00".equals(str3)) {}
            }
            else
            {
              str2 = str3;
              str1 = d(str4);
            }
          }
          return str1;
        }
        catch (Throwable localThrowable2)
        {
          String str2;
          continue;
        }
        localThrowable1 = localThrowable1;
        str2 = "";
      }
    } while (!QLog.isColorLevel());
    QLog.i("WifiSdk", 2, "getMac exception: " + localThrowable1.getMessage());
    return str2;
  }
  
  public static String a(long paramLong)
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = ((int)(paramLong >> 24 & 0xFF));
    arrayOfInt[1] = ((int)(paramLong >> 16 & 0xFF));
    arrayOfInt[2] = ((int)(paramLong >> 8 & 0xFF));
    arrayOfInt[3] = ((int)(paramLong & 0xFF));
    return Integer.toString(arrayOfInt[3]) + "." + Integer.toString(arrayOfInt[2]) + "." + Integer.toString(arrayOfInt[1]) + "." + Integer.toString(arrayOfInt[0]);
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    try
    {
      localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { paramString });
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localObject = "";
        paramString = (String)localObject;
      } while (!QLog.isColorLevel());
      QLog.i("WifiSdk", 2, "getSysPropByReflect exception: " + localThrowable.getMessage());
    }
    return paramString;
    return localObject;
  }
  
  /* Error */
  public static java.util.List<String> a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 140	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 141	java/util/ArrayList:<init>	()V
    //   12: astore 6
    //   14: new 143	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_0
    //   23: new 148	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 151	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: astore_1
    //   32: new 153	java/io/BufferedReader
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 156	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore 4
    //   42: aload 4
    //   44: invokevirtual 159	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +88 -> 137
    //   52: aload 6
    //   54: aload_2
    //   55: invokeinterface 164 2 0
    //   60: pop
    //   61: goto -19 -> 42
    //   64: astore 5
    //   66: aload_0
    //   67: astore_2
    //   68: aload_1
    //   69: astore_3
    //   70: aload 4
    //   72: astore_1
    //   73: aload 5
    //   75: astore_0
    //   76: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +31 -> 110
    //   82: ldc 79
    //   84: iconst_2
    //   85: new 81	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   92: ldc 166
    //   94: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokevirtual 94	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 101	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 169	java/io/FileInputStream:close	()V
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 171	java/io/BufferedReader:close	()V
    //   134: aload 6
    //   136: areturn
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 169	java/io/FileInputStream:close	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   153: aload 4
    //   155: ifnull -21 -> 134
    //   158: aload 4
    //   160: invokevirtual 171	java/io/BufferedReader:close	()V
    //   163: aload 6
    //   165: areturn
    //   166: astore_0
    //   167: aload_0
    //   168: invokevirtual 174	java/lang/Throwable:printStackTrace	()V
    //   171: aload 6
    //   173: areturn
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 174	java/lang/Throwable:printStackTrace	()V
    //   179: aload 6
    //   181: areturn
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_2
    //   188: ifnull +7 -> 195
    //   191: aload_2
    //   192: invokevirtual 169	java/io/FileInputStream:close	()V
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 171	java/io/BufferedReader:close	()V
    //   211: aload_0
    //   212: athrow
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 174	java/lang/Throwable:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore 4
    //   223: aconst_null
    //   224: astore_1
    //   225: aload_0
    //   226: astore_2
    //   227: aload 4
    //   229: astore_0
    //   230: goto -43 -> 187
    //   233: astore 5
    //   235: aconst_null
    //   236: astore 4
    //   238: aload_1
    //   239: astore_3
    //   240: aload_0
    //   241: astore_2
    //   242: aload 5
    //   244: astore_0
    //   245: aload 4
    //   247: astore_1
    //   248: goto -61 -> 187
    //   251: astore 5
    //   253: aload_1
    //   254: astore_3
    //   255: aload_0
    //   256: astore_2
    //   257: aload 5
    //   259: astore_0
    //   260: aload 4
    //   262: astore_1
    //   263: goto -76 -> 187
    //   266: astore_0
    //   267: goto -80 -> 187
    //   270: astore_0
    //   271: aconst_null
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_2
    //   275: aload 4
    //   277: astore_3
    //   278: goto -202 -> 76
    //   281: astore_3
    //   282: aconst_null
    //   283: astore_1
    //   284: aload_0
    //   285: astore_2
    //   286: aload_3
    //   287: astore_0
    //   288: aload 4
    //   290: astore_3
    //   291: goto -215 -> 76
    //   294: astore 5
    //   296: aconst_null
    //   297: astore 4
    //   299: aload_1
    //   300: astore_3
    //   301: aload_0
    //   302: astore_2
    //   303: aload 5
    //   305: astore_0
    //   306: aload 4
    //   308: astore_1
    //   309: goto -233 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramFile	File
    //   31	177	1	localObject1	Object
    //   213	2	1	localThrowable1	Throwable
    //   224	85	1	localObject2	Object
    //   47	256	2	localObject3	Object
    //   1	277	3	localObject4	Object
    //   281	6	3	localThrowable2	Throwable
    //   290	11	3	localObject5	Object
    //   3	156	4	localBufferedReader	java.io.BufferedReader
    //   221	7	4	localObject6	Object
    //   236	71	4	localObject7	Object
    //   64	10	5	localThrowable3	Throwable
    //   233	10	5	localObject8	Object
    //   251	7	5	localObject9	Object
    //   294	10	5	localThrowable4	Throwable
    //   12	168	6	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   42	48	64	java/lang/Throwable
    //   52	61	64	java/lang/Throwable
    //   141	145	166	java/lang/Throwable
    //   149	153	166	java/lang/Throwable
    //   158	163	166	java/lang/Throwable
    //   114	118	174	java/lang/Throwable
    //   122	126	174	java/lang/Throwable
    //   130	134	174	java/lang/Throwable
    //   14	23	182	finally
    //   191	195	213	java/lang/Throwable
    //   199	203	213	java/lang/Throwable
    //   207	211	213	java/lang/Throwable
    //   23	32	221	finally
    //   32	42	233	finally
    //   42	48	251	finally
    //   52	61	251	finally
    //   76	110	266	finally
    //   14	23	270	java/lang/Throwable
    //   23	32	281	java/lang/Throwable
    //   32	42	294	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      boolean bool = ((WifiManager)paramContext.getSystemService("wifi")).isWifiEnabled();
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 189	java/io/BufferedInputStream
    //   6: dup
    //   7: new 143	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: invokespecial 190	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: new 192	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 193	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_0
    //   27: aload_0
    //   28: astore 4
    //   30: aload_2
    //   31: astore_3
    //   32: sipush 1024
    //   35: newarray byte
    //   37: astore 5
    //   39: aload_0
    //   40: astore 4
    //   42: aload_2
    //   43: astore_3
    //   44: aload_2
    //   45: aload 5
    //   47: invokevirtual 197	java/io/BufferedInputStream:read	([B)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +90 -> 143
    //   56: aload_0
    //   57: astore 4
    //   59: aload_2
    //   60: astore_3
    //   61: aload_0
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_1
    //   66: invokevirtual 201	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -30 -> 39
    //   72: astore 5
    //   74: aload_0
    //   75: astore 4
    //   77: aload_2
    //   78: astore_3
    //   79: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +37 -> 119
    //   85: aload_0
    //   86: astore 4
    //   88: aload_2
    //   89: astore_3
    //   90: ldc 79
    //   92: iconst_2
    //   93: new 81	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   100: ldc 203
    //   102: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 5
    //   107: invokevirtual 94	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 101	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: ifnull +7 -> 127
    //   123: aload_0
    //   124: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   127: aload 6
    //   129: astore_0
    //   130: aload_2
    //   131: ifnull +10 -> 141
    //   134: aload_2
    //   135: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   138: aload 6
    //   140: astore_0
    //   141: aload_0
    //   142: areturn
    //   143: aload_0
    //   144: astore 4
    //   146: aload_2
    //   147: astore_3
    //   148: aload_0
    //   149: invokevirtual 209	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   152: astore 5
    //   154: aload 5
    //   156: astore_3
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   165: aload_3
    //   166: astore_0
    //   167: aload_2
    //   168: ifnull -27 -> 141
    //   171: aload_2
    //   172: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   175: aload_3
    //   176: areturn
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   182: aload_3
    //   183: areturn
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   189: goto -24 -> 165
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   197: goto -70 -> 127
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   205: aconst_null
    //   206: areturn
    //   207: astore_0
    //   208: aconst_null
    //   209: astore 4
    //   211: aconst_null
    //   212: astore_2
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 204	java/io/ByteArrayOutputStream:close	()V
    //   223: aload_2
    //   224: ifnull +7 -> 231
    //   227: aload_2
    //   228: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   231: aload_0
    //   232: athrow
    //   233: astore_3
    //   234: aload_3
    //   235: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   238: goto -15 -> 223
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   246: goto -15 -> 231
    //   249: astore_0
    //   250: aconst_null
    //   251: astore 4
    //   253: goto -40 -> 213
    //   256: astore_0
    //   257: aload_3
    //   258: astore_2
    //   259: goto -46 -> 213
    //   262: astore 5
    //   264: aconst_null
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_2
    //   268: goto -194 -> 74
    //   271: astore 5
    //   273: aconst_null
    //   274: astore_0
    //   275: goto -201 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramFile	File
    //   50	16	1	i	int
    //   18	210	2	localBufferedInputStream	java.io.BufferedInputStream
    //   241	2	2	localIOException1	java.io.IOException
    //   258	10	2	localObject1	Object
    //   31	152	3	localObject2	Object
    //   233	25	3	localIOException2	java.io.IOException
    //   28	224	4	localFile	File
    //   37	26	5	arrayOfByte1	byte[]
    //   72	34	5	localThrowable1	Throwable
    //   152	3	5	arrayOfByte2	byte[]
    //   262	1	5	localThrowable2	Throwable
    //   271	1	5	localThrowable3	Throwable
    //   1	138	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	39	72	java/lang/Throwable
    //   44	51	72	java/lang/Throwable
    //   61	69	72	java/lang/Throwable
    //   148	154	72	java/lang/Throwable
    //   171	175	177	java/io/IOException
    //   161	165	184	java/io/IOException
    //   123	127	192	java/io/IOException
    //   134	138	200	java/io/IOException
    //   3	19	207	finally
    //   218	223	233	java/io/IOException
    //   227	231	241	java/io/IOException
    //   19	27	249	finally
    //   32	39	256	finally
    //   44	51	256	finally
    //   61	69	256	finally
    //   79	85	256	finally
    //   90	119	256	finally
    //   148	154	256	finally
    //   3	19	262	java/lang/Throwable
    //   19	27	271	java/lang/Throwable
  }
  
  public static int b(Context paramContext)
  {
    if (!bgnt.g(paramContext)) {
      return 0;
    }
    switch (biii.a(paramContext))
    {
    case 0: 
    default: 
      return 5;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 1;
  }
  
  public static String b()
  {
    String str2 = "";
    try
    {
      byte[] arrayOfByte = a(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/.tmfs/sk_v.dat"));
      str1 = str2;
      if (arrayOfByte != null) {
        str1 = b(new String(arrayOfByte));
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        String str1 = str2;
      } while (!QLog.isColorLevel());
      QLog.i("WifiSdk", 2, "getVidInSD exception: " + localThrowable.getMessage());
    }
    return str1;
    return "";
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      paramString = bihe.a(bigh.a(paramString, 0), bihe.a());
      if (paramString != null)
      {
        paramString = new String(paramString, "gbk");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "getDecodeString exception: " + paramString.getMessage());
      }
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return true;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", paramContext.getPackageName()) != 0)
        {
          int i = localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", paramContext.getPackageName());
          if (i != 0) {
            return false;
          }
        }
      }
      catch (Throwable paramContext) {}
    }
    return false;
  }
  
  private static String c(String paramString)
  {
    int i = 0;
    try
    {
      paramString = NetworkInterface.getByName(paramString).getHardwareAddress();
      if (paramString == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramString.length;
      while (i < j)
      {
        localStringBuilder.append(String.format("%02x:", new Object[] { Byte.valueOf(paramString[i]) }));
        i += 1;
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WifiSdk", 2, "getMacByAPI exception: " + paramString.getMessage());
      }
    }
    return "";
  }
  
  @TargetApi(19)
  public static boolean c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    for (;;)
    {
      return true;
      try
      {
        int i = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode");
        if (i == 0) {
          return false;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  /* Error */
  private static String d(String paramString)
  {
    // Byte code:
    //   0: new 222	java/io/File
    //   3: dup
    //   4: ldc_w 338
    //   7: iconst_1
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: aastore
    //   15: invokestatic 311	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokespecial 236	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokestatic 340	bihc:a	(Ljava/io/File;)Ljava/util/List;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +87 -> 113
    //   29: aload_0
    //   30: invokeinterface 343 1 0
    //   35: iconst_1
    //   36: if_icmpne +77 -> 113
    //   39: aload_0
    //   40: iconst_0
    //   41: invokeinterface 346 2 0
    //   46: checkcast 28	java/lang/String
    //   49: astore_1
    //   50: aload_1
    //   51: astore_0
    //   52: aload_1
    //   53: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +8 -> 64
    //   59: aload_1
    //   60: invokevirtual 349	java/lang/String:trim	()Ljava/lang/String;
    //   63: astore_0
    //   64: aload_0
    //   65: areturn
    //   66: astore_2
    //   67: ldc 71
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq -11 -> 64
    //   78: ldc 79
    //   80: iconst_2
    //   81: new 81	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 351
    //   91: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 94	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 101	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_1
    //   108: areturn
    //   109: astore_2
    //   110: goto -40 -> 70
    //   113: ldc 71
    //   115: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   49	59	1	str	String
    //   66	29	2	localThrowable1	Throwable
    //   109	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	25	66	java/lang/Throwable
    //   29	50	66	java/lang/Throwable
    //   52	64	109	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bihc
 * JD-Core Version:    0.7.0.1
 */