import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class avzi
  extends WebViewPlugin
{
  public static PowerManager.WakeLock a;
  public static boolean a;
  private String jdField_a_of_type_JavaLangString = "";
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public avzi()
  {
    this.mPluginNameSpace = "device";
  }
  
  private int a()
  {
    return DeviceInfoUtil.getCpuNumber();
  }
  
  public static void a(boolean paramBoolean1, Context paramContext, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
        jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(10, "VasWakeLock");
      }
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
      jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      if ((jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
        jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      }
    } while (paramBoolean2);
    jdField_a_of_type_Boolean = false;
  }
  
  public long a()
  {
    ActivityManager localActivityManager = (ActivityManager)this.mRuntime.a().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem / 1024L;
  }
  
  public final String a()
  {
    try
    {
      str = BaseApplicationImpl.getApplication().getResources().getConfiguration().toString();
      QLog.e("DeviceApiPlugin", 1, "getConfiguration ", localThrowable1);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("DeviceApiPlugin", 2, new Object[] { "getConfiguration:", str });
        }
        return str;
      }
      catch (Throwable localThrowable2)
      {
        String str;
        break label44;
      }
      localThrowable1 = localThrowable1;
      str = "";
    }
    label44:
    return str;
  }
  
  /* Error */
  public long b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: lconst_0
    //   9: lstore_1
    //   10: new 144	java/io/BufferedReader
    //   13: dup
    //   14: new 146	java/io/FileReader
    //   17: dup
    //   18: ldc 148
    //   20: invokespecial 151	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   23: bipush 8
    //   25: invokespecial 154	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore 4
    //   30: aload 4
    //   32: astore_3
    //   33: aload 4
    //   35: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 7
    //   40: aload 5
    //   42: astore_3
    //   43: aload 7
    //   45: ifnull +6 -> 51
    //   48: aload 7
    //   50: astore_3
    //   51: aload_3
    //   52: astore 5
    //   54: aload 4
    //   56: ifnull +11 -> 67
    //   59: aload 4
    //   61: invokevirtual 160	java/io/BufferedReader:close	()V
    //   64: aload_3
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +32 -> 101
    //   72: aload 5
    //   74: aload 5
    //   76: bipush 58
    //   78: invokevirtual 166	java/lang/String:indexOf	(I)I
    //   81: iconst_1
    //   82: iadd
    //   83: aload 5
    //   85: bipush 107
    //   87: invokevirtual 166	java/lang/String:indexOf	(I)I
    //   90: invokevirtual 170	java/lang/String:substring	(II)Ljava/lang/String;
    //   93: invokevirtual 173	java/lang/String:trim	()Ljava/lang/String;
    //   96: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: i2l
    //   100: lstore_1
    //   101: lload_1
    //   102: lreturn
    //   103: astore 4
    //   105: aload 4
    //   107: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   110: aload_3
    //   111: astore 5
    //   113: goto -46 -> 67
    //   116: astore 5
    //   118: aconst_null
    //   119: astore 4
    //   121: aload 4
    //   123: astore_3
    //   124: aload 5
    //   126: invokevirtual 183	java/io/FileNotFoundException:printStackTrace	()V
    //   129: aload 6
    //   131: astore 5
    //   133: aload 4
    //   135: ifnull -68 -> 67
    //   138: aload 4
    //   140: invokevirtual 160	java/io/BufferedReader:close	()V
    //   143: aload 6
    //   145: astore 5
    //   147: goto -80 -> 67
    //   150: astore_3
    //   151: aload_3
    //   152: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   155: aload 6
    //   157: astore 5
    //   159: goto -92 -> 67
    //   162: astore 5
    //   164: aconst_null
    //   165: astore 4
    //   167: aload 4
    //   169: astore_3
    //   170: aload 5
    //   172: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   175: aload 6
    //   177: astore 5
    //   179: aload 4
    //   181: ifnull -114 -> 67
    //   184: aload 4
    //   186: invokevirtual 160	java/io/BufferedReader:close	()V
    //   189: aload 6
    //   191: astore 5
    //   193: goto -126 -> 67
    //   196: astore_3
    //   197: aload_3
    //   198: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   201: aload 6
    //   203: astore 5
    //   205: goto -138 -> 67
    //   208: astore 5
    //   210: aload_3
    //   211: astore 4
    //   213: aload 5
    //   215: astore_3
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 160	java/io/BufferedReader:close	()V
    //   226: aload_3
    //   227: athrow
    //   228: astore 4
    //   230: aload 4
    //   232: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   235: goto -9 -> 226
    //   238: astore 5
    //   240: aload_3
    //   241: astore 4
    //   243: aload 5
    //   245: astore_3
    //   246: goto -30 -> 216
    //   249: astore 5
    //   251: goto -84 -> 167
    //   254: astore 5
    //   256: goto -135 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	avzi
    //   9	93	1	l	long
    //   4	120	3	localObject1	Object
    //   150	2	3	localIOException1	IOException
    //   169	1	3	localObject2	Object
    //   196	15	3	localIOException2	IOException
    //   215	31	3	localObject3	Object
    //   28	32	4	localBufferedReader	java.io.BufferedReader
    //   103	3	4	localIOException3	IOException
    //   119	103	4	localIOException4	IOException
    //   228	3	4	localIOException5	IOException
    //   241	1	4	localObject4	Object
    //   6	106	5	localObject5	Object
    //   116	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   131	27	5	localObject6	Object
    //   162	9	5	localIOException6	IOException
    //   177	27	5	localObject7	Object
    //   208	6	5	localObject8	Object
    //   238	6	5	localObject9	Object
    //   249	1	5	localIOException7	IOException
    //   254	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	201	6	localObject10	Object
    //   38	11	7	str	String
    // Exception table:
    //   from	to	target	type
    //   59	64	103	java/io/IOException
    //   10	30	116	java/io/FileNotFoundException
    //   138	143	150	java/io/IOException
    //   10	30	162	java/io/IOException
    //   184	189	196	java/io/IOException
    //   10	30	208	finally
    //   221	226	228	java/io/IOException
    //   33	40	238	finally
    //   124	129	238	finally
    //   170	175	238	finally
    //   33	40	249	java/io/IOException
    //   33	40	254	java/io/FileNotFoundException
  }
  
  public String b()
  {
    return String.valueOf(DeviceInfoUtil.getCpuMaxFreq());
  }
  
  public String c()
  {
    String str1 = "";
    try
    {
      InputStream localInputStream = new ProcessBuilder(new String[] { "/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq" }).start().getInputStream();
      byte[] arrayOfByte = new byte[24];
      while (localInputStream.read(arrayOfByte) != -1) {
        str1 = str1 + new String(arrayOfByte);
      }
      localInputStream.close();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        String str2 = "N/A";
      }
    }
    return str1.trim();
  }
  
  /* Error */
  public String d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_2
    //   10: ldc 230
    //   12: astore 6
    //   14: new 146	java/io/FileReader
    //   17: dup
    //   18: ldc 232
    //   20: invokespecial 151	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload 4
    //   26: astore_3
    //   27: aload_1
    //   28: astore 4
    //   30: new 144	java/io/BufferedReader
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 235	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_2
    //   39: aload_2
    //   40: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_3
    //   44: aload_1
    //   45: invokevirtual 236	java/io/FileReader:close	()V
    //   48: aload_2
    //   49: invokevirtual 160	java/io/BufferedReader:close	()V
    //   52: aload_3
    //   53: invokevirtual 173	java/lang/String:trim	()Ljava/lang/String;
    //   56: astore_3
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 236	java/io/FileReader:close	()V
    //   65: aload_3
    //   66: astore 4
    //   68: aload_2
    //   69: ifnull +10 -> 79
    //   72: aload_2
    //   73: invokevirtual 160	java/io/BufferedReader:close	()V
    //   76: aload_3
    //   77: astore 4
    //   79: aload 4
    //   81: areturn
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   95: aload_3
    //   96: areturn
    //   97: astore_3
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_3
    //   101: invokevirtual 183	java/io/FileNotFoundException:printStackTrace	()V
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 236	java/io/FileReader:close	()V
    //   112: aload 6
    //   114: astore 4
    //   116: aload_1
    //   117: ifnull -38 -> 79
    //   120: aload_1
    //   121: invokevirtual 160	java/io/BufferedReader:close	()V
    //   124: ldc 230
    //   126: areturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   132: ldc 230
    //   134: areturn
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   140: goto -28 -> 112
    //   143: astore 5
    //   145: aconst_null
    //   146: astore_1
    //   147: aload 7
    //   149: astore_2
    //   150: aload_2
    //   151: astore_3
    //   152: aload_1
    //   153: astore 4
    //   155: aload 5
    //   157: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 236	java/io/FileReader:close	()V
    //   168: aload 6
    //   170: astore 4
    //   172: aload_2
    //   173: ifnull -94 -> 79
    //   176: aload_2
    //   177: invokevirtual 160	java/io/BufferedReader:close	()V
    //   180: ldc 230
    //   182: areturn
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   188: ldc 230
    //   190: areturn
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   196: goto -28 -> 168
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 236	java/io/FileReader:close	()V
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 160	java/io/BufferedReader:close	()V
    //   218: aload_2
    //   219: athrow
    //   220: astore_1
    //   221: aload_1
    //   222: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   225: goto -15 -> 210
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   233: goto -15 -> 218
    //   236: astore_2
    //   237: aload 4
    //   239: astore_1
    //   240: goto -38 -> 202
    //   243: astore 4
    //   245: aload_2
    //   246: astore_3
    //   247: aload 4
    //   249: astore_2
    //   250: goto -48 -> 202
    //   253: astore_3
    //   254: aload_2
    //   255: astore 4
    //   257: aload_3
    //   258: astore_2
    //   259: aload_1
    //   260: astore_3
    //   261: aload 4
    //   263: astore_1
    //   264: goto -62 -> 202
    //   267: astore 5
    //   269: aload 7
    //   271: astore_2
    //   272: goto -122 -> 150
    //   275: astore 5
    //   277: goto -127 -> 150
    //   280: astore_3
    //   281: aconst_null
    //   282: astore 4
    //   284: aload_1
    //   285: astore_2
    //   286: aload 4
    //   288: astore_1
    //   289: goto -189 -> 100
    //   292: astore_3
    //   293: aload_1
    //   294: astore 4
    //   296: aload_2
    //   297: astore_1
    //   298: aload 4
    //   300: astore_2
    //   301: goto -201 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	avzi
    //   23	39	1	localFileReader	java.io.FileReader
    //   82	2	1	localIOException1	IOException
    //   90	2	1	localIOException2	IOException
    //   99	22	1	localObject1	Object
    //   127	2	1	localIOException3	IOException
    //   146	19	1	localObject2	Object
    //   183	2	1	localIOException4	IOException
    //   191	2	1	localIOException5	IOException
    //   201	6	1	localObject3	Object
    //   220	2	1	localIOException6	IOException
    //   228	2	1	localIOException7	IOException
    //   239	59	1	localObject4	Object
    //   9	100	2	localBufferedReader	java.io.BufferedReader
    //   135	2	2	localIOException8	IOException
    //   149	28	2	localObject5	Object
    //   199	20	2	localObject6	Object
    //   236	10	2	localObject7	Object
    //   249	52	2	localObject8	Object
    //   4	92	3	localObject9	Object
    //   97	4	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   151	96	3	localObject10	Object
    //   253	5	3	localObject11	Object
    //   260	1	3	localObject12	Object
    //   280	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   292	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   6	232	4	localObject13	Object
    //   243	5	4	localObject14	Object
    //   255	44	4	localObject15	Object
    //   143	13	5	localIOException9	IOException
    //   267	1	5	localIOException10	IOException
    //   275	1	5	localIOException11	IOException
    //   12	157	6	str	String
    //   1	269	7	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	82	java/io/IOException
    //   72	76	90	java/io/IOException
    //   14	24	97	java/io/FileNotFoundException
    //   120	124	127	java/io/IOException
    //   108	112	135	java/io/IOException
    //   14	24	143	java/io/IOException
    //   176	180	183	java/io/IOException
    //   164	168	191	java/io/IOException
    //   14	24	199	finally
    //   206	210	220	java/io/IOException
    //   214	218	228	java/io/IOException
    //   30	39	236	finally
    //   155	160	236	finally
    //   39	57	243	finally
    //   100	104	253	finally
    //   30	39	267	java/io/IOException
    //   39	57	275	java/io/IOException
    //   30	39	280	java/io/FileNotFoundException
    //   39	57	292	java/io/FileNotFoundException
  }
  
  /* Error */
  public String e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 146	java/io/FileReader
    //   6: dup
    //   7: ldc 238
    //   9: invokespecial 151	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: new 144	java/io/BufferedReader
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 235	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 5
    //   23: aload 5
    //   25: astore 4
    //   27: aload_2
    //   28: astore_3
    //   29: aload 5
    //   31: invokevirtual 157	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: ldc 240
    //   36: iconst_2
    //   37: invokevirtual 244	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   40: astore 6
    //   42: iconst_0
    //   43: istore_1
    //   44: aload 5
    //   46: astore 4
    //   48: aload_2
    //   49: astore_3
    //   50: iload_1
    //   51: aload 6
    //   53: arraylength
    //   54: if_icmpge +10 -> 64
    //   57: iload_1
    //   58: iconst_1
    //   59: iadd
    //   60: istore_1
    //   61: goto -17 -> 44
    //   64: aload 6
    //   66: iconst_1
    //   67: aaload
    //   68: astore_3
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 236	java/io/FileReader:close	()V
    //   77: aload_3
    //   78: astore_2
    //   79: aload 5
    //   81: ifnull +10 -> 91
    //   84: aload 5
    //   86: invokevirtual 160	java/io/BufferedReader:close	()V
    //   89: aload_3
    //   90: astore_2
    //   91: aload_2
    //   92: areturn
    //   93: astore_2
    //   94: aload_2
    //   95: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   98: goto -21 -> 77
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   106: aload_3
    //   107: areturn
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 5
    //   113: aconst_null
    //   114: astore_2
    //   115: aload 5
    //   117: astore 4
    //   119: aload_2
    //   120: astore_3
    //   121: aload 6
    //   123: invokevirtual 183	java/io/FileNotFoundException:printStackTrace	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 236	java/io/FileReader:close	()V
    //   134: aload 7
    //   136: astore_2
    //   137: aload 5
    //   139: ifnull -48 -> 91
    //   142: aload 5
    //   144: invokevirtual 160	java/io/BufferedReader:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   161: goto -27 -> 134
    //   164: astore 6
    //   166: aconst_null
    //   167: astore 5
    //   169: aconst_null
    //   170: astore_2
    //   171: aload 5
    //   173: astore 4
    //   175: aload_2
    //   176: astore_3
    //   177: aload 6
    //   179: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 236	java/io/FileReader:close	()V
    //   190: aload 7
    //   192: astore_2
    //   193: aload 5
    //   195: ifnull -104 -> 91
    //   198: aload 5
    //   200: invokevirtual 160	java/io/BufferedReader:close	()V
    //   203: aconst_null
    //   204: areturn
    //   205: astore_2
    //   206: aload_2
    //   207: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore_2
    //   213: aload_2
    //   214: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   217: goto -27 -> 190
    //   220: astore 5
    //   222: aconst_null
    //   223: astore 4
    //   225: aconst_null
    //   226: astore_2
    //   227: aload_2
    //   228: ifnull +7 -> 235
    //   231: aload_2
    //   232: invokevirtual 236	java/io/FileReader:close	()V
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 160	java/io/BufferedReader:close	()V
    //   245: aload 5
    //   247: athrow
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   253: goto -18 -> 235
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   261: goto -16 -> 245
    //   264: astore 5
    //   266: aconst_null
    //   267: astore 4
    //   269: goto -42 -> 227
    //   272: astore 5
    //   274: aload_3
    //   275: astore_2
    //   276: goto -49 -> 227
    //   279: astore 6
    //   281: aconst_null
    //   282: astore 5
    //   284: goto -113 -> 171
    //   287: astore 6
    //   289: goto -118 -> 171
    //   292: astore 6
    //   294: aconst_null
    //   295: astore 5
    //   297: goto -182 -> 115
    //   300: astore 6
    //   302: goto -187 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	avzi
    //   43	18	1	i	int
    //   12	80	2	localObject1	Object
    //   93	2	2	localIOException1	IOException
    //   101	2	2	localIOException2	IOException
    //   114	23	2	localObject2	Object
    //   149	2	2	localIOException3	IOException
    //   156	2	2	localIOException4	IOException
    //   170	23	2	localObject3	Object
    //   205	2	2	localIOException5	IOException
    //   212	2	2	localIOException6	IOException
    //   226	6	2	localObject4	Object
    //   248	2	2	localIOException7	IOException
    //   256	2	2	localIOException8	IOException
    //   275	1	2	localObject5	Object
    //   28	247	3	localObject6	Object
    //   25	243	4	localBufferedReader1	java.io.BufferedReader
    //   21	178	5	localBufferedReader2	java.io.BufferedReader
    //   220	26	5	localObject7	Object
    //   264	1	5	localObject8	Object
    //   272	1	5	localObject9	Object
    //   282	14	5	localObject10	Object
    //   40	25	6	arrayOfString	String[]
    //   108	14	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   164	14	6	localIOException9	IOException
    //   279	1	6	localIOException10	IOException
    //   287	1	6	localIOException11	IOException
    //   292	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   300	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	190	7	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   73	77	93	java/io/IOException
    //   84	89	101	java/io/IOException
    //   3	13	108	java/io/FileNotFoundException
    //   142	147	149	java/io/IOException
    //   130	134	156	java/io/IOException
    //   3	13	164	java/io/IOException
    //   198	203	205	java/io/IOException
    //   186	190	212	java/io/IOException
    //   3	13	220	finally
    //   231	235	248	java/io/IOException
    //   240	245	256	java/io/IOException
    //   13	23	264	finally
    //   29	42	272	finally
    //   50	57	272	finally
    //   121	126	272	finally
    //   177	182	272	finally
    //   13	23	279	java/io/IOException
    //   29	42	287	java/io/IOException
    //   50	57	287	java/io/IOException
    //   13	23	292	java/io/FileNotFoundException
    //   29	42	300	java/io/FileNotFoundException
    //   50	57	300	java/io/FileNotFoundException
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceApiPlugin", 2, "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString1 == null) || (!"device".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceApiPlugin", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    int i;
    try
    {
      if (paramString2.has("callback"))
      {
        paramJsBridgeListener = paramString2.getString("callback");
      }
      else
      {
        i = paramString1.indexOf("#");
        if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
          break label1066;
        }
        paramJsBridgeListener = paramString1.substring(i + 1);
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceApiPlugin", 2, "Failed to parse callbackid,json=" + paramString2);
      }
      paramJsBridgeListener = null;
    }
    if ("setScreenStatus".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        if (!paramString2.has("status")) {
          break label1054;
        }
        i = paramString2.getInt("status");
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DeviceApiPlugin", 2, "Failed to setScreenStatus:" + paramString1.getMessage());
        callJs(paramJsBridgeListener, new String[] { "{'result':-1,'message':" + paramString1.getMessage() + "}" });
        break label1080;
      }
      a(bool, this.mRuntime.a().getApplicationContext(), false);
      if (jdField_a_of_type_Boolean)
      {
        paramString1 = "{'result':1,'message':'light'}";
        callJs(paramJsBridgeListener, new String[] { paramString1 });
      }
      else
      {
        paramString1 = "{'result':0,'message':'dim'}";
        continue;
        if ("getWebpDecoderVersion".equals(paramString3))
        {
          paramString1 = new JSONObject();
          try
          {
            paramString1.put("result", -1);
            if (this.jdField_a_of_type_ArrayOfInt != null)
            {
              paramString1.put("result", 0);
              paramString1.put("type", this.jdField_a_of_type_JavaLangString);
              paramString1.put("version", String.format("%d.%d.%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[0]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[2]) }));
            }
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        else
        {
          if ("canInstallThirdPartyApp".equals(paramString3))
          {
            paramString1 = this.mRuntime.a();
            if (paramString1 != null) {
              i = Settings.Secure.getInt(paramString1.getContentResolver(), "install_non_market_apps", 0);
            }
            for (paramString1 = "{'result':" + i + "}";; paramString1 = "{'result':-1,'message':'Context is null!'}")
            {
              callJs(paramJsBridgeListener, new String[] { paramString1 });
              break;
            }
          }
          if ("getCPUInfo".equals(paramString3)) {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("maxFreq", b());
              paramString1.put("minFreq", c());
              paramString1.put("curFreq", d());
              paramString1.put("CPUName", e());
              paramString1 = paramString1.toString();
              QLog.i("DeviceApiPlugin", 2, "getCPUInfo : " + paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString1 });
              return true;
            }
            catch (JSONException paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          if ("getMemInfo".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("idleMem", a());
              paramString1.put("totalMem", b());
              paramString1 = paramString1.toString();
              QLog.i("DeviceApiPlugin", 2, "getMemInfo : " + paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString1 });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if ("getCPUCoreNum".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("count", a());
              paramString1 = paramString1.toString();
              QLog.i("DeviceApiPlugin", 2, "getCPUCoreNum : " + paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString1 });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if ("getConfiguration".equals(paramString3))
          {
            try
            {
              paramString1 = new JSONObject();
              paramString1.put("config", a());
              paramString1 = paramString1.toString();
              QLog.i("DeviceApiPlugin", 1, "getConfiguration : " + paramString1);
              callJs(paramJsBridgeListener, new String[] { paramString1 });
            }
            catch (JSONException paramJsBridgeListener)
            {
              QLog.e("DeviceApiPlugin", 1, new Object[] { "getConfiguration ", paramJsBridgeListener.toString() });
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.w("DeviceApiPlugin", 2, "NOT support method " + paramString3 + " yet!!");
            }
            return false;
            label1054:
            i = 0;
            break label1068;
            if (paramJsBridgeListener != null) {
              break;
            }
            return false;
            label1066:
            return false;
            label1068:
            if (i != 1) {
              break label1082;
            }
            bool = true;
            continue;
          }
        }
      }
      label1080:
      return true;
      label1082:
      boolean bool = false;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    if (jdField_a_of_type_Boolean) {
      a(false, null, false);
    }
    if ((jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld())) {
      jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    super.onDestroy();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if ((paramCustomWebView != null) && (paramCustomWebView.getX5WebViewExtension() != null))
    {
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 3, 0, 0 };
      this.jdField_a_of_type_JavaLangString = "QQBrowser";
    }
    do
    {
      return;
      this.jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
    } while (this.jdField_a_of_type_ArrayOfInt == null);
    if (WebpSoLoader.jdField_a_of_type_ArrayOfInt != null)
    {
      this.jdField_a_of_type_JavaLangString = "Hook";
      return;
    }
    this.jdField_a_of_type_JavaLangString = "System";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzi
 * JD-Core Version:    0.7.0.1
 */