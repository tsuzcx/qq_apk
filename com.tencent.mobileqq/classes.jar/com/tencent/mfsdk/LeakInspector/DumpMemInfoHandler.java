package com.tencent.mfsdk.LeakInspector;

import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DumpMemInfoHandler
{
  private static String a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    String str = Environment.getExternalStorageDirectory().getPath();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = str;
      if (!str.endsWith("/")) {
        localObject = str + "/";
      }
      jdField_a_of_type_JavaLangString = (String)localObject + "/Tencent/MobileQQ/log/";
      localObject = new File(jdField_a_of_type_JavaLangString);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3: ldc 106
    //   5: invokestatic 111	com/tencent/mobileqq/utils/TimeFormatterUtils:a	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore_3
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   16: getstatic 13	com/tencent/mfsdk/LeakInspector/DumpMemInfoHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 113
    //   24: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 115
    //   33: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: invokestatic 121	java/lang/Thread:activeCount	()I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +8 -> 54
    //   49: ldc 11
    //   51: astore_3
    //   52: aload_3
    //   53: areturn
    //   54: new 123	java/io/BufferedWriter
    //   57: dup
    //   58: new 125	java/io/FileWriter
    //   61: dup
    //   62: aload 6
    //   64: iconst_0
    //   65: invokespecial 128	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   68: invokespecial 131	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: iload_2
    //   77: anewarray 117	java/lang/Thread
    //   80: astore 5
    //   82: aload 4
    //   84: astore_3
    //   85: aload 5
    //   87: invokestatic 135	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: new 67	java/lang/StringBuilder
    //   97: dup
    //   98: iload_2
    //   99: sipush 1024
    //   102: imul
    //   103: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   106: astore 7
    //   108: iconst_0
    //   109: istore_0
    //   110: goto +300 -> 410
    //   113: aload 4
    //   115: astore_3
    //   116: aload 8
    //   118: invokevirtual 141	java/lang/Thread:isAlive	()Z
    //   121: ifeq +111 -> 232
    //   124: aload 4
    //   126: astore_3
    //   127: aload 7
    //   129: ldc 143
    //   131: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 4
    //   137: astore_3
    //   138: aload 7
    //   140: aload 8
    //   142: invokevirtual 146	java/lang/Thread:getName	()Ljava/lang/String;
    //   145: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 4
    //   151: astore_3
    //   152: aload 7
    //   154: ldc 148
    //   156: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: astore_3
    //   163: aload 8
    //   165: invokevirtual 152	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   168: astore 8
    //   170: aload 8
    //   172: ifnull +60 -> 232
    //   175: iconst_0
    //   176: istore_1
    //   177: aload 4
    //   179: astore_3
    //   180: iload_1
    //   181: aload 8
    //   183: arraylength
    //   184: if_icmpge +48 -> 232
    //   187: aload 4
    //   189: astore_3
    //   190: aload 7
    //   192: ldc 154
    //   194: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: astore_3
    //   201: aload 7
    //   203: aload 8
    //   205: iload_1
    //   206: aaload
    //   207: invokevirtual 157	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   210: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 4
    //   216: astore_3
    //   217: aload 7
    //   219: ldc 148
    //   221: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: iload_1
    //   226: iconst_1
    //   227: iadd
    //   228: istore_1
    //   229: goto -52 -> 177
    //   232: aload 4
    //   234: astore_3
    //   235: aload 7
    //   237: ldc 148
    //   239: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 4
    //   245: astore_3
    //   246: aload 4
    //   248: aload 7
    //   250: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokevirtual 160	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   256: aload 4
    //   258: astore_3
    //   259: aload 4
    //   261: invokevirtual 163	java/io/BufferedWriter:flush	()V
    //   264: aload 4
    //   266: astore_3
    //   267: aload 7
    //   269: iconst_0
    //   270: invokevirtual 166	java/lang/StringBuilder:setLength	(I)V
    //   273: goto +153 -> 426
    //   276: astore 5
    //   278: aload 4
    //   280: astore_3
    //   281: aload 5
    //   283: invokevirtual 169	java/io/IOException:printStackTrace	()V
    //   286: aload 6
    //   288: astore_3
    //   289: aload 4
    //   291: ifnull -239 -> 52
    //   294: aload 4
    //   296: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   299: aload 6
    //   301: areturn
    //   302: astore_3
    //   303: aload 6
    //   305: areturn
    //   306: aload 6
    //   308: astore_3
    //   309: aload 4
    //   311: ifnull -259 -> 52
    //   314: aload 4
    //   316: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   319: aload 6
    //   321: areturn
    //   322: astore_3
    //   323: aload 6
    //   325: areturn
    //   326: astore 5
    //   328: aconst_null
    //   329: astore 4
    //   331: aload 4
    //   333: astore_3
    //   334: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +16 -> 353
    //   340: aload 4
    //   342: astore_3
    //   343: ldc 179
    //   345: iconst_2
    //   346: ldc 181
    //   348: aload 5
    //   350: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload 6
    //   355: astore_3
    //   356: aload 4
    //   358: ifnull -306 -> 52
    //   361: aload 4
    //   363: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   366: aload 6
    //   368: areturn
    //   369: astore_3
    //   370: aload 6
    //   372: areturn
    //   373: astore 4
    //   375: aconst_null
    //   376: astore_3
    //   377: aload_3
    //   378: ifnull +7 -> 385
    //   381: aload_3
    //   382: invokevirtual 172	java/io/BufferedWriter:close	()V
    //   385: aload 4
    //   387: athrow
    //   388: astore_3
    //   389: goto -4 -> 385
    //   392: astore 4
    //   394: goto -17 -> 377
    //   397: astore 5
    //   399: goto -68 -> 331
    //   402: astore 5
    //   404: aconst_null
    //   405: astore 4
    //   407: goto -129 -> 278
    //   410: iload_0
    //   411: iload_2
    //   412: if_icmpge -106 -> 306
    //   415: aload 5
    //   417: iload_0
    //   418: aaload
    //   419: astore 8
    //   421: aload 8
    //   423: ifnonnull -310 -> 113
    //   426: iload_0
    //   427: iconst_1
    //   428: iadd
    //   429: istore_0
    //   430: goto -20 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   109	321	0	i	int
    //   176	53	1	j	int
    //   44	369	2	k	int
    //   8	281	3	localObject1	Object
    //   302	1	3	localIOException1	IOException
    //   308	1	3	localObject2	Object
    //   322	1	3	localIOException2	IOException
    //   333	23	3	localObject3	Object
    //   369	1	3	localIOException3	IOException
    //   376	6	3	localObject4	Object
    //   388	1	3	localIOException4	IOException
    //   71	291	4	localBufferedWriter	java.io.BufferedWriter
    //   373	13	4	localObject5	Object
    //   392	1	4	localObject6	Object
    //   405	1	4	localObject7	Object
    //   80	6	5	arrayOfThread	Thread[]
    //   276	6	5	localIOException5	IOException
    //   326	23	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   397	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   402	14	5	localIOException6	IOException
    //   39	332	6	str	String
    //   106	162	7	localStringBuilder	java.lang.StringBuilder
    //   116	306	8	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   76	82	276	java/io/IOException
    //   85	91	276	java/io/IOException
    //   94	108	276	java/io/IOException
    //   116	124	276	java/io/IOException
    //   127	135	276	java/io/IOException
    //   138	149	276	java/io/IOException
    //   152	160	276	java/io/IOException
    //   163	170	276	java/io/IOException
    //   180	187	276	java/io/IOException
    //   190	198	276	java/io/IOException
    //   201	214	276	java/io/IOException
    //   217	225	276	java/io/IOException
    //   235	243	276	java/io/IOException
    //   246	256	276	java/io/IOException
    //   259	264	276	java/io/IOException
    //   267	273	276	java/io/IOException
    //   294	299	302	java/io/IOException
    //   314	319	322	java/io/IOException
    //   54	73	326	java/lang/OutOfMemoryError
    //   361	366	369	java/io/IOException
    //   54	73	373	finally
    //   381	385	388	java/io/IOException
    //   76	82	392	finally
    //   85	91	392	finally
    //   94	108	392	finally
    //   116	124	392	finally
    //   127	135	392	finally
    //   138	149	392	finally
    //   152	160	392	finally
    //   163	170	392	finally
    //   180	187	392	finally
    //   190	198	392	finally
    //   201	214	392	finally
    //   217	225	392	finally
    //   235	243	392	finally
    //   246	256	392	finally
    //   259	264	392	finally
    //   267	273	392	finally
    //   281	286	392	finally
    //   334	340	392	finally
    //   343	353	392	finally
    //   76	82	397	java/lang/OutOfMemoryError
    //   85	91	397	java/lang/OutOfMemoryError
    //   94	108	397	java/lang/OutOfMemoryError
    //   116	124	397	java/lang/OutOfMemoryError
    //   127	135	397	java/lang/OutOfMemoryError
    //   138	149	397	java/lang/OutOfMemoryError
    //   152	160	397	java/lang/OutOfMemoryError
    //   163	170	397	java/lang/OutOfMemoryError
    //   180	187	397	java/lang/OutOfMemoryError
    //   190	198	397	java/lang/OutOfMemoryError
    //   201	214	397	java/lang/OutOfMemoryError
    //   217	225	397	java/lang/OutOfMemoryError
    //   235	243	397	java/lang/OutOfMemoryError
    //   246	256	397	java/lang/OutOfMemoryError
    //   259	264	397	java/lang/OutOfMemoryError
    //   267	273	397	java/lang/OutOfMemoryError
    //   54	73	402	java/io/IOException
  }
  
  public static String a(long paramLong)
  {
    String str1 = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/";
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = TimeFormatterUtils.a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(BaseApplicationImpl.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    localArrayList.add(a(l));
    localArrayList.add(a(l - 3600000L));
    localArrayList.add(AppConstants.aP + "log.txt");
    return localArrayList;
  }
  
  public static Object[] a(String paramString)
  {
    Object localObject = "";
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "ReportLog dumpHprof : " + paramString);
    }
    String str2 = TimeFormatterUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject = new File(Environment.getExternalStorageDirectory().getPath() + "/Tencent/MobileQQ/log/");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str1 = ((File)localObject).getAbsolutePath();
      localObject = str1;
      if (!str1.endsWith("/")) {
        localObject = str1 + "/";
      }
    }
    for (paramString = (String)localObject + "dump_" + paramString + "_" + str2 + ".hprof";; paramString = localException)
    {
      try
      {
        long l = System.currentTimeMillis();
        if ((SystemUtil.a() * 1024L <= Runtime.getRuntime().totalMemory()) || (!"mounted".equals(Environment.getExternalStorageState()))) {
          break label310;
        }
        Debug.dumpHprofData(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("LeakInspector", 2, "dump used " + (System.currentTimeMillis() - l) + " ms");
        }
        bool = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LeakInspector", 2, "generateHprof", localException);
          }
          bool = false;
          continue;
          label310:
          bool = false;
        }
      }
      return new Object[] { Boolean.valueOf(bool), paramString };
      boolean bool = false;
    }
  }
  
  /* Error */
  public static Object[] a(List paramList, String paramString)
  {
    // Byte code:
    //   0: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3: ldc 106
    //   5: invokestatic 111	com/tencent/mobileqq/utils/TimeFormatterUtils:a	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore 7
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 13	com/tencent/mfsdk/LeakInspector/DumpMemInfoHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 275
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 230
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload 7
    //   40: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 313
    //   46: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 7
    //   54: new 315	java/io/BufferedOutputStream
    //   57: dup
    //   58: new 317	java/io/FileOutputStream
    //   61: dup
    //   62: new 49	java/io/File
    //   65: dup
    //   66: aload 7
    //   68: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: invokespecial 320	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 323	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   77: astore_1
    //   78: new 325	java/util/zip/ZipOutputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 326	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore 8
    //   88: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   91: lstore_3
    //   92: aload_0
    //   93: invokeinterface 330 1 0
    //   98: astore 9
    //   100: aload 9
    //   102: invokeinterface 335 1 0
    //   107: ifeq +321 -> 428
    //   110: new 49	java/io/File
    //   113: dup
    //   114: aload 9
    //   116: invokeinterface 339 1 0
    //   121: checkcast 15	java/lang/String
    //   124: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: astore 10
    //   129: aload 10
    //   131: invokevirtual 86	java/io/File:exists	()Z
    //   134: ifeq -34 -> 100
    //   137: aload 8
    //   139: new 341	java/util/zip/ZipEntry
    //   142: dup
    //   143: aload 10
    //   145: invokevirtual 342	java/io/File:getName	()Ljava/lang/String;
    //   148: invokespecial 343	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   151: invokevirtual 347	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   154: aload 8
    //   156: bipush 9
    //   158: invokevirtual 350	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   161: new 352	java/io/FileInputStream
    //   164: dup
    //   165: aload 10
    //   167: invokespecial 353	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   170: astore 10
    //   172: sipush 8192
    //   175: newarray byte
    //   177: astore 11
    //   179: aload 10
    //   181: aload 11
    //   183: iconst_0
    //   184: sipush 8192
    //   187: invokevirtual 357	java/io/FileInputStream:read	([BII)I
    //   190: istore_2
    //   191: iload_2
    //   192: iconst_m1
    //   193: if_icmpeq +158 -> 351
    //   196: aload 8
    //   198: aload 11
    //   200: iconst_0
    //   201: iload_2
    //   202: invokevirtual 360	java/util/zip/ZipOutputStream:write	([BII)V
    //   205: goto -26 -> 179
    //   208: astore 9
    //   210: aload 10
    //   212: ifnull +8 -> 220
    //   215: aload 10
    //   217: invokevirtual 361	java/io/FileInputStream:close	()V
    //   220: aload 8
    //   222: invokevirtual 362	java/util/zip/ZipOutputStream:flush	()V
    //   225: aload 8
    //   227: invokevirtual 365	java/util/zip/ZipOutputStream:closeEntry	()V
    //   230: aload 9
    //   232: athrow
    //   233: astore 9
    //   235: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +14 -> 252
    //   241: ldc 179
    //   243: iconst_2
    //   244: ldc_w 367
    //   247: aload 9
    //   249: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload 8
    //   254: ifnull +8 -> 262
    //   257: aload 8
    //   259: invokevirtual 370	java/util/zip/ZipOutputStream:close	()V
    //   262: aload_1
    //   263: ifnull +393 -> 656
    //   266: aload_1
    //   267: invokevirtual 371	java/io/BufferedOutputStream:close	()V
    //   270: iconst_0
    //   271: istore 5
    //   273: iload 5
    //   275: istore 6
    //   277: iload 6
    //   279: ifeq +359 -> 638
    //   282: aload_0
    //   283: invokeinterface 330 1 0
    //   288: astore_0
    //   289: aload_0
    //   290: invokeinterface 335 1 0
    //   295: ifeq +343 -> 638
    //   298: aload_0
    //   299: invokeinterface 339 1 0
    //   304: checkcast 15	java/lang/String
    //   307: astore_1
    //   308: aload_1
    //   309: ldc 232
    //   311: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   314: ifne -25 -> 289
    //   317: aload_1
    //   318: ldc_w 373
    //   321: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   324: ifne -35 -> 289
    //   327: new 49	java/io/File
    //   330: dup
    //   331: aload_1
    //   332: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 86	java/io/File:exists	()Z
    //   340: ifeq -51 -> 289
    //   343: aload_1
    //   344: invokevirtual 376	java/io/File:delete	()Z
    //   347: pop
    //   348: goto -59 -> 289
    //   351: aload 10
    //   353: ifnull +8 -> 361
    //   356: aload 10
    //   358: invokevirtual 361	java/io/FileInputStream:close	()V
    //   361: aload 8
    //   363: invokevirtual 362	java/util/zip/ZipOutputStream:flush	()V
    //   366: aload 8
    //   368: invokevirtual 365	java/util/zip/ZipOutputStream:closeEntry	()V
    //   371: goto -271 -> 100
    //   374: astore 9
    //   376: aload 8
    //   378: ifnull +8 -> 386
    //   381: aload 8
    //   383: invokevirtual 370	java/util/zip/ZipOutputStream:close	()V
    //   386: aload_1
    //   387: ifnull +7 -> 394
    //   390: aload_1
    //   391: invokevirtual 371	java/io/BufferedOutputStream:close	()V
    //   394: aload 9
    //   396: athrow
    //   397: astore_1
    //   398: iconst_0
    //   399: istore 5
    //   401: iload 5
    //   403: istore 6
    //   405: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq -131 -> 277
    //   411: ldc 179
    //   413: iconst_2
    //   414: ldc_w 367
    //   417: aload_1
    //   418: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   421: iload 5
    //   423: istore 6
    //   425: goto -148 -> 277
    //   428: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +54 -> 485
    //   434: ldc 179
    //   436: iconst_2
    //   437: new 67	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 378
    //   447: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   453: lload_3
    //   454: lsub
    //   455: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   458: ldc_w 380
    //   461: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: invokeinterface 383 1 0
    //   470: invokevirtual 386	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: ldc_w 388
    //   476: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload 8
    //   487: ifnull +8 -> 495
    //   490: aload 8
    //   492: invokevirtual 370	java/util/zip/ZipOutputStream:close	()V
    //   495: aload_1
    //   496: ifnull +166 -> 662
    //   499: aload_1
    //   500: invokevirtual 371	java/io/BufferedOutputStream:close	()V
    //   503: iconst_1
    //   504: istore 5
    //   506: goto -233 -> 273
    //   509: astore 8
    //   511: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq -19 -> 495
    //   517: ldc 179
    //   519: iconst_2
    //   520: ldc_w 367
    //   523: aload 8
    //   525: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   528: goto -33 -> 495
    //   531: astore_1
    //   532: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +13 -> 548
    //   538: ldc 179
    //   540: iconst_2
    //   541: ldc_w 367
    //   544: aload_1
    //   545: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   548: iconst_1
    //   549: istore 5
    //   551: goto -278 -> 273
    //   554: astore 8
    //   556: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq -297 -> 262
    //   562: ldc 179
    //   564: iconst_2
    //   565: ldc_w 367
    //   568: aload 8
    //   570: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   573: goto -311 -> 262
    //   576: astore_1
    //   577: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +95 -> 675
    //   583: ldc 179
    //   585: iconst_2
    //   586: ldc_w 367
    //   589: aload_1
    //   590: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   593: goto +82 -> 675
    //   596: astore 8
    //   598: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq -215 -> 386
    //   604: ldc 179
    //   606: iconst_2
    //   607: ldc_w 367
    //   610: aload 8
    //   612: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   615: goto -229 -> 386
    //   618: astore_1
    //   619: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq -228 -> 394
    //   625: ldc 179
    //   627: iconst_2
    //   628: ldc_w 367
    //   631: aload_1
    //   632: invokestatic 369	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   635: goto -241 -> 394
    //   638: iconst_2
    //   639: anewarray 4	java/lang/Object
    //   642: dup
    //   643: iconst_0
    //   644: iload 6
    //   646: invokestatic 310	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   649: aastore
    //   650: dup
    //   651: iconst_1
    //   652: aload 7
    //   654: aastore
    //   655: areturn
    //   656: iconst_0
    //   657: istore 5
    //   659: goto -386 -> 273
    //   662: iconst_1
    //   663: istore 5
    //   665: goto -392 -> 273
    //   668: astore_1
    //   669: iconst_1
    //   670: istore 5
    //   672: goto -271 -> 401
    //   675: iconst_0
    //   676: istore 5
    //   678: goto -405 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	681	0	paramList	List
    //   0	681	1	paramString	String
    //   190	12	2	i	int
    //   91	363	3	l	long
    //   271	406	5	bool1	boolean
    //   275	370	6	bool2	boolean
    //   8	645	7	str	String
    //   86	405	8	localZipOutputStream	java.util.zip.ZipOutputStream
    //   509	15	8	localIOException1	IOException
    //   554	15	8	localIOException2	IOException
    //   596	15	8	localIOException3	IOException
    //   98	17	9	localIterator	java.util.Iterator
    //   208	23	9	localObject1	Object
    //   233	15	9	localIOException4	IOException
    //   374	21	9	localObject2	Object
    //   127	230	10	localObject3	Object
    //   177	22	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   172	179	208	finally
    //   179	191	208	finally
    //   196	205	208	finally
    //   88	100	233	java/io/IOException
    //   100	172	233	java/io/IOException
    //   215	220	233	java/io/IOException
    //   220	233	233	java/io/IOException
    //   356	361	233	java/io/IOException
    //   361	371	233	java/io/IOException
    //   428	485	233	java/io/IOException
    //   88	100	374	finally
    //   100	172	374	finally
    //   215	220	374	finally
    //   220	233	374	finally
    //   235	252	374	finally
    //   356	361	374	finally
    //   361	371	374	finally
    //   428	485	374	finally
    //   54	88	397	java/lang/Exception
    //   257	262	397	java/lang/Exception
    //   266	270	397	java/lang/Exception
    //   381	386	397	java/lang/Exception
    //   390	394	397	java/lang/Exception
    //   394	397	397	java/lang/Exception
    //   556	573	397	java/lang/Exception
    //   577	593	397	java/lang/Exception
    //   598	615	397	java/lang/Exception
    //   619	635	397	java/lang/Exception
    //   490	495	509	java/io/IOException
    //   499	503	531	java/io/IOException
    //   257	262	554	java/io/IOException
    //   266	270	576	java/io/IOException
    //   381	386	596	java/io/IOException
    //   390	394	618	java/io/IOException
    //   490	495	668	java/lang/Exception
    //   499	503	668	java/lang/Exception
    //   511	528	668	java/lang/Exception
    //   532	548	668	java/lang/Exception
  }
  
  public static String b()
  {
    String str1 = TimeFormatterUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    str1 = "trace_mobileqq" + str1 + ".trace";
    int i = 0;
    for (int j = 0;; j = k)
    {
      if ((i >= 3) || (j != 0)) {
        break label137;
      }
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        Runtime.getRuntime().exec("kill -3 " + Process.myPid());
        k = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int k = j;
          if (QLog.isColorLevel())
          {
            QLog.d("LeakInspector", 2, "generateTraces", localIOException);
            k = j;
          }
        }
      }
      i += 1;
    }
    label137:
    if (j != 0)
    {
      i = 0;
      boolean bool = false;
      for (;;)
      {
        if ((i < 3) && (!bool))
        {
          String str2 = FileUtils.a(new File("/data/anr/traces.txt"));
          if (str2 != null) {
            bool = FileUtils.a(jdField_a_of_type_JavaLangString, str1, str2);
          }
          if (!bool) {}
          try
          {
            Thread.sleep(1000L);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LeakInspector", 2, "InterruptedException", localInterruptedException);
              }
            }
          }
        }
      }
    }
    return jdField_a_of_type_JavaLangString + str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */