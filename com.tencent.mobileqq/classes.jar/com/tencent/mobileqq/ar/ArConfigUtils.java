package com.tencent.mobileqq.ar;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
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
import java.util.zip.InflaterInputStream;

public class ArConfigUtils
{
  static SimpleDateFormat a;
  
  public static long a(String paramString)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      long l = a.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_Utils", 2, "", paramString);
      }
    }
    return -1L;
  }
  
  public static String a()
  {
    if (b()) {
      return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_Utils", 2, "no_sdcard");
    }
    float f = FileUtils.getAvailableInnernalMemorySize();
    if ((f < 15728640.0F) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("inner memory avail may not enough : ");
      localStringBuilder.append(f);
      QLog.i("ArConfig_Utils", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 99	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 135
    //   17: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 60
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: astore 4
    //   40: new 139	com/tencent/commonsdk/zip/QZipFile
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 142	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 146	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 6
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore 7
    //   62: aload 6
    //   64: invokeinterface 151 1 0
    //   69: ifeq +336 -> 405
    //   72: aload 6
    //   74: invokeinterface 155 1 0
    //   79: checkcast 157	java/util/zip/ZipEntry
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull -29 -> 62
    //   94: aload 5
    //   96: ldc 162
    //   98: invokevirtual 168	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +6 -> 107
    //   104: goto -42 -> 62
    //   107: new 99	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   114: astore 8
    //   116: aload 8
    //   118: aload_1
    //   119: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 8
    //   125: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   128: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 8
    //   134: aload 5
    //   136: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 8
    //   142: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: aload_0
    //   148: invokevirtual 171	java/util/zip/ZipEntry:isDirectory	()Z
    //   151: ifeq +28 -> 179
    //   154: new 124	java/io/File
    //   157: dup
    //   158: aload 5
    //   160: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 175	java/io/File:exists	()Z
    //   168: ifne -106 -> 62
    //   171: aload_0
    //   172: invokevirtual 178	java/io/File:mkdir	()Z
    //   175: pop
    //   176: goto -114 -> 62
    //   179: aload 5
    //   181: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   184: invokevirtual 182	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload 5
    //   190: iconst_0
    //   191: iload_2
    //   192: invokevirtual 186	java/lang/String:substring	(II)Ljava/lang/String;
    //   195: astore 8
    //   197: aload 5
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 189	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: ldc 191
    //   207: invokevirtual 195	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   210: ifeq +6 -> 216
    //   213: goto -151 -> 62
    //   216: new 124	java/io/File
    //   219: dup
    //   220: aload 8
    //   222: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: astore 8
    //   227: aload 8
    //   229: invokevirtual 175	java/io/File:exists	()Z
    //   232: ifne +9 -> 241
    //   235: aload 8
    //   237: invokevirtual 178	java/io/File:mkdir	()Z
    //   240: pop
    //   241: new 99	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   248: astore 8
    //   250: aload 8
    //   252: aload 5
    //   254: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 8
    //   260: ldc 197
    //   262: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: new 124	java/io/File
    //   269: dup
    //   270: aload 8
    //   272: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   278: astore 8
    //   280: new 124	java/io/File
    //   283: dup
    //   284: aload 5
    //   286: invokespecial 172	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 9
    //   291: aload 8
    //   293: invokevirtual 175	java/io/File:exists	()Z
    //   296: ifeq +9 -> 305
    //   299: aload 8
    //   301: invokevirtual 200	java/io/File:delete	()Z
    //   304: pop
    //   305: new 202	java/io/FileOutputStream
    //   308: dup
    //   309: aload 8
    //   311: invokespecial 205	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   314: astore 5
    //   316: aload_3
    //   317: aload_0
    //   318: invokevirtual 209	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   321: astore_0
    //   322: aload_0
    //   323: aload 7
    //   325: iconst_0
    //   326: aload 7
    //   328: arraylength
    //   329: invokevirtual 215	java/io/InputStream:read	([BII)I
    //   332: istore_2
    //   333: iload_2
    //   334: iconst_m1
    //   335: if_icmpeq +15 -> 350
    //   338: aload 5
    //   340: aload 7
    //   342: iconst_0
    //   343: iload_2
    //   344: invokevirtual 219	java/io/FileOutputStream:write	([BII)V
    //   347: goto -25 -> 322
    //   350: aload 5
    //   352: invokevirtual 222	java/io/FileOutputStream:flush	()V
    //   355: aload 5
    //   357: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   360: aload_0
    //   361: invokevirtual 226	java/io/InputStream:close	()V
    //   364: aload 8
    //   366: aload 9
    //   368: invokestatic 230	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   371: ifne -309 -> 62
    //   374: aload 8
    //   376: aload 9
    //   378: invokestatic 233	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   381: pop
    //   382: goto -320 -> 62
    //   385: astore 4
    //   387: aload_0
    //   388: astore_1
    //   389: aload 4
    //   391: astore_0
    //   392: goto +6 -> 398
    //   395: astore_0
    //   396: aconst_null
    //   397: astore_1
    //   398: aload 5
    //   400: astore 4
    //   402: goto +25 -> 427
    //   405: aload_3
    //   406: invokevirtual 234	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   409: return
    //   410: astore_0
    //   411: aload_0
    //   412: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   415: return
    //   416: astore_0
    //   417: aconst_null
    //   418: astore_1
    //   419: goto +8 -> 427
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_3
    //   425: aload_3
    //   426: astore_1
    //   427: aload 4
    //   429: ifnull +18 -> 447
    //   432: aload 4
    //   434: invokevirtual 225	java/io/FileOutputStream:close	()V
    //   437: goto +10 -> 447
    //   440: astore 4
    //   442: aload 4
    //   444: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   447: aload_1
    //   448: ifnull +15 -> 463
    //   451: aload_1
    //   452: invokevirtual 226	java/io/InputStream:close	()V
    //   455: goto +8 -> 463
    //   458: astore_1
    //   459: aload_1
    //   460: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   463: aload_3
    //   464: ifnull +15 -> 479
    //   467: aload_3
    //   468: invokevirtual 234	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   471: goto +8 -> 479
    //   474: astore_1
    //   475: aload_1
    //   476: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   479: goto +5 -> 484
    //   482: aload_0
    //   483: athrow
    //   484: goto -2 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramString1	String
    //   0	487	1	paramString2	String
    //   187	157	2	i	int
    //   13	455	3	localObject1	Object
    //   38	1	4	localObject2	Object
    //   385	5	4	localObject3	Object
    //   400	33	4	localObject4	Object
    //   440	3	4	localIOException	java.io.IOException
    //   87	312	5	localObject5	Object
    //   53	20	6	localEnumeration	java.util.Enumeration
    //   60	281	7	arrayOfByte	byte[]
    //   114	261	8	localObject6	Object
    //   289	88	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   322	333	385	finally
    //   338	347	385	finally
    //   350	364	385	finally
    //   316	322	395	finally
    //   405	409	410	java/io/IOException
    //   49	62	416	finally
    //   62	89	416	finally
    //   94	104	416	finally
    //   107	176	416	finally
    //   179	213	416	finally
    //   216	241	416	finally
    //   241	305	416	finally
    //   305	316	416	finally
    //   364	382	416	finally
    //   40	49	422	finally
    //   432	437	440	java/io/IOException
    //   451	455	458	java/io/IOException
    //   467	471	474	java/io/IOException
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "ar_client_download_report", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if ((paramBoolean1) && (paramBoolean2)) {
      bool = true;
    } else {
      bool = false;
    }
    HashMap localHashMap = new HashMap();
    String str2 = "1";
    String str1;
    if (paramBoolean1) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("ar_feature", str1);
    if (paramBoolean2) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("ar_model", str1);
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localHashMap.put("ar_all_resource", str1);
    if (bool) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("param_FailCode", str1);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "olympic_ar_pre_download", bool, 0L, 0L, localHashMap, null);
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
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static void b(String paramString, boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "olympic_ar_config", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  @TargetApi(18)
  public static boolean b()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArConfigUtils
 * JD-Core Version:    0.7.0.1
 */