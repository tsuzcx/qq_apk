import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

public class aocu
{
  static SimpleDateFormat a;
  
  public static long a(String paramString)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l1 = -1L;
    try
    {
      long l2 = a.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_Utils", 2, "", paramString);
    }
    return l1;
    return -1L;
  }
  
  public static String a()
  {
    if (a()) {
      return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_Utils", 2, "no_sdcard");
    }
    float f = FileUtils.getAvailableInnernalMemorySize();
    if ((f < 15728640.0F) && (QLog.isColorLevel())) {
      QLog.i("ArConfig_Utils", 2, "inner memory avail may not enough : " + f);
    }
    return BaseApplicationImpl.sApplication.getFilesDir().getAbsolutePath() + File.separator;
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return str;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 57
    //   10: iconst_2
    //   11: new 94	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   18: ldc 155
    //   20: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 159	com/tencent/commonsdk/zip/QZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 162	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 166	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 6
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: invokeinterface 171 1 0
    //   64: ifeq +330 -> 394
    //   67: aload 6
    //   69: invokeinterface 175 1 0
    //   74: checkcast 177	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 180	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +410 -> 496
    //   89: aload_0
    //   90: ldc 182
    //   92: invokevirtual 187	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto -41 -> 57
    //   101: new 94	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 127	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 5
    //   128: invokevirtual 190	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +27 -> 158
    //   134: new 121	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 194	java/io/File:exists	()Z
    //   147: ifne +352 -> 499
    //   150: aload_0
    //   151: invokevirtual 197	java/io/File:mkdir	()Z
    //   154: pop
    //   155: goto +344 -> 499
    //   158: aload_0
    //   159: getstatic 127	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 201	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 205	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: aload_0
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 208	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc 210
    //   183: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   186: ifeq +6 -> 192
    //   189: goto -132 -> 57
    //   192: new 121	java/io/File
    //   195: dup
    //   196: aload 8
    //   198: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: aload 8
    //   205: invokevirtual 194	java/io/File:exists	()Z
    //   208: ifne +9 -> 217
    //   211: aload 8
    //   213: invokevirtual 197	java/io/File:mkdir	()Z
    //   216: pop
    //   217: new 121	java/io/File
    //   220: dup
    //   221: new 94	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   228: aload_0
    //   229: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 216
    //   234: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   243: astore 8
    //   245: new 121	java/io/File
    //   248: dup
    //   249: aload_0
    //   250: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: astore 9
    //   255: aload 8
    //   257: invokevirtual 194	java/io/File:exists	()Z
    //   260: ifeq +9 -> 269
    //   263: aload 8
    //   265: invokevirtual 219	java/io/File:delete	()Z
    //   268: pop
    //   269: new 221	java/io/FileOutputStream
    //   272: dup
    //   273: aload 8
    //   275: invokespecial 224	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   278: astore_0
    //   279: aload 4
    //   281: aload 5
    //   283: invokevirtual 228	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   286: astore 5
    //   288: aload 5
    //   290: aload 7
    //   292: iconst_0
    //   293: aload 7
    //   295: arraylength
    //   296: invokevirtual 234	java/io/InputStream:read	([BII)I
    //   299: istore_2
    //   300: iload_2
    //   301: iconst_m1
    //   302: if_icmpeq +52 -> 354
    //   305: aload_0
    //   306: aload 7
    //   308: iconst_0
    //   309: iload_2
    //   310: invokevirtual 238	java/io/FileOutputStream:write	([BII)V
    //   313: goto -25 -> 288
    //   316: astore 6
    //   318: aload 5
    //   320: astore_1
    //   321: aload_0
    //   322: astore_3
    //   323: aload 6
    //   325: astore_0
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 242	java/io/InputStream:close	()V
    //   342: aload 4
    //   344: ifnull +8 -> 352
    //   347: aload 4
    //   349: invokevirtual 243	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   352: aload_0
    //   353: athrow
    //   354: aload_0
    //   355: invokevirtual 246	java/io/FileOutputStream:flush	()V
    //   358: aload_0
    //   359: invokevirtual 241	java/io/FileOutputStream:close	()V
    //   362: aload 5
    //   364: invokevirtual 242	java/io/InputStream:close	()V
    //   367: aload 8
    //   369: aload 9
    //   371: invokestatic 250	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   374: ifne +125 -> 499
    //   377: aload 8
    //   379: aload 9
    //   381: invokestatic 253	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   384: pop
    //   385: goto +114 -> 499
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: goto -65 -> 326
    //   394: iconst_0
    //   395: ifeq +11 -> 406
    //   398: new 255	java/lang/NullPointerException
    //   401: dup
    //   402: invokespecial 256	java/lang/NullPointerException:<init>	()V
    //   405: athrow
    //   406: iconst_0
    //   407: ifeq +11 -> 418
    //   410: new 255	java/lang/NullPointerException
    //   413: dup
    //   414: invokespecial 256	java/lang/NullPointerException:<init>	()V
    //   417: athrow
    //   418: aload 4
    //   420: ifnull +8 -> 428
    //   423: aload 4
    //   425: invokevirtual 243	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   428: return
    //   429: astore_0
    //   430: aload_0
    //   431: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   434: goto -28 -> 406
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   442: goto -24 -> 418
    //   445: astore_0
    //   446: aload_0
    //   447: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   450: return
    //   451: astore_3
    //   452: aload_3
    //   453: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   456: goto -122 -> 334
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   464: goto -122 -> 342
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   472: goto -120 -> 352
    //   475: astore_0
    //   476: aconst_null
    //   477: astore 4
    //   479: aconst_null
    //   480: astore_1
    //   481: goto -155 -> 326
    //   484: astore 5
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_0
    //   489: astore_3
    //   490: aload 5
    //   492: astore_0
    //   493: goto -167 -> 326
    //   496: goto -439 -> 57
    //   499: goto -442 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	502	0	paramString1	String
    //   0	502	1	paramString2	String
    //   165	145	2	i	int
    //   1	330	3	str1	String
    //   451	2	3	localIOException	java.io.IOException
    //   489	1	3	str2	String
    //   41	437	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   77	286	5	localObject1	Object
    //   484	7	5	localObject2	Object
    //   48	20	6	localEnumeration	java.util.Enumeration
    //   316	8	6	localObject3	Object
    //   55	252	7	arrayOfByte	byte[]
    //   172	206	8	localObject4	Object
    //   253	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   288	300	316	finally
    //   305	313	316	finally
    //   354	367	316	finally
    //   43	57	388	finally
    //   57	85	388	finally
    //   89	98	388	finally
    //   101	155	388	finally
    //   158	189	388	finally
    //   192	217	388	finally
    //   217	269	388	finally
    //   269	279	388	finally
    //   367	385	388	finally
    //   398	406	429	java/io/IOException
    //   410	418	437	java/io/IOException
    //   423	428	445	java/io/IOException
    //   330	334	451	java/io/IOException
    //   338	342	459	java/io/IOException
    //   347	352	467	java/io/IOException
    //   33	43	475	finally
    //   279	288	484	finally
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ar_client_download_report", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (paramBoolean2) {
        bool1 = true;
      }
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean1)
    {
      str = "1";
      localHashMap.put("ar_feature", str);
      if (!paramBoolean2) {
        break label136;
      }
      str = "1";
      label57:
      localHashMap.put("ar_model", str);
      if (!bool1) {
        break label144;
      }
      str = "1";
      label77:
      localHashMap.put("ar_all_resource", str);
      if (!bool1) {
        break label152;
      }
    }
    label136:
    label144:
    label152:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_FailCode", str);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "olympic_ar_pre_download", bool1, 0L, 0L, localHashMap, null);
      return;
      str = "0";
      break;
      str = "0";
      break label57;
      str = "0";
      break label77;
    }
  }
  
  @TargetApi(18)
  public static boolean a()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static void b(String paramString, boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "olympic_ar_config", paramBoolean, 0L, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocu
 * JD-Core Version:    0.7.0.1
 */