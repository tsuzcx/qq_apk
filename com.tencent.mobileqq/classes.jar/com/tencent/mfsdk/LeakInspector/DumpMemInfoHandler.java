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
    //   0: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   3: ldc 104
    //   5: invokestatic 109	com/tencent/mobileqq/utils/TimeFormatterUtils:a	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore_3
    //   9: new 67	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   16: getstatic 13	com/tencent/mfsdk/LeakInspector/DumpMemInfoHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 111
    //   24: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 113
    //   33: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: invokestatic 119	java/lang/Thread:activeCount	()I
    //   44: istore_2
    //   45: iload_2
    //   46: ifne +6 -> 52
    //   49: ldc 11
    //   51: areturn
    //   52: iload_2
    //   53: anewarray 115	java/lang/Thread
    //   56: astore_3
    //   57: aload_3
    //   58: invokestatic 123	java/lang/Thread:enumerate	([Ljava/lang/Thread;)I
    //   61: pop
    //   62: new 67	java/lang/StringBuilder
    //   65: dup
    //   66: iload_2
    //   67: sipush 1024
    //   70: imul
    //   71: invokespecial 126	java/lang/StringBuilder:<init>	(I)V
    //   74: astore 5
    //   76: iconst_0
    //   77: istore_0
    //   78: iload_0
    //   79: iload_2
    //   80: if_icmpge +123 -> 203
    //   83: aload_3
    //   84: iload_0
    //   85: aaload
    //   86: astore 4
    //   88: aload 4
    //   90: ifnonnull +10 -> 100
    //   93: iload_0
    //   94: iconst_1
    //   95: iadd
    //   96: istore_0
    //   97: goto -19 -> 78
    //   100: aload 4
    //   102: invokevirtual 129	java/lang/Thread:isAlive	()Z
    //   105: ifeq +87 -> 192
    //   108: aload 5
    //   110: ldc 131
    //   112: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 5
    //   118: aload 4
    //   120: invokevirtual 134	java/lang/Thread:getName	()Ljava/lang/String;
    //   123: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 5
    //   129: ldc 136
    //   131: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 4
    //   137: invokevirtual 140	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   140: astore 4
    //   142: aload 4
    //   144: ifnull +48 -> 192
    //   147: iconst_0
    //   148: istore_1
    //   149: iload_1
    //   150: aload 4
    //   152: arraylength
    //   153: if_icmpge +39 -> 192
    //   156: aload 5
    //   158: ldc 142
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 5
    //   166: aload 4
    //   168: iload_1
    //   169: aaload
    //   170: invokevirtual 145	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   173: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 5
    //   179: ldc 136
    //   181: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: istore_1
    //   189: goto -40 -> 149
    //   192: aload 5
    //   194: ldc 136
    //   196: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -107 -> 93
    //   203: new 147	java/io/FileWriter
    //   206: dup
    //   207: aload 6
    //   209: iconst_0
    //   210: invokespecial 150	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   213: astore 4
    //   215: aload 4
    //   217: astore_3
    //   218: aload 4
    //   220: aload 5
    //   222: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokevirtual 153	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 156	java/io/FileWriter:close	()V
    //   238: aload 6
    //   240: areturn
    //   241: astore 5
    //   243: aconst_null
    //   244: astore 4
    //   246: aload 4
    //   248: astore_3
    //   249: aload 5
    //   251: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   254: aload 4
    //   256: ifnull -18 -> 238
    //   259: aload 4
    //   261: invokevirtual 156	java/io/FileWriter:close	()V
    //   264: goto -26 -> 238
    //   267: astore_3
    //   268: goto -30 -> 238
    //   271: astore 4
    //   273: aconst_null
    //   274: astore_3
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 156	java/io/FileWriter:close	()V
    //   283: aload 4
    //   285: athrow
    //   286: astore_3
    //   287: goto -49 -> 238
    //   290: astore_3
    //   291: goto -8 -> 283
    //   294: astore 4
    //   296: goto -21 -> 275
    //   299: astore 5
    //   301: goto -55 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   77	20	0	i	int
    //   148	41	1	j	int
    //   44	37	2	k	int
    //   8	241	3	localObject1	Object
    //   267	1	3	localIOException1	IOException
    //   274	6	3	localObject2	Object
    //   286	1	3	localIOException2	IOException
    //   290	1	3	localIOException3	IOException
    //   86	174	4	localObject3	Object
    //   271	13	4	localObject4	Object
    //   294	1	4	localObject5	Object
    //   74	147	5	localStringBuilder	java.lang.StringBuilder
    //   241	9	5	localIOException4	IOException
    //   299	1	5	localIOException5	IOException
    //   39	200	6	str	String
    // Exception table:
    //   from	to	target	type
    //   203	215	241	java/io/IOException
    //   259	264	267	java/io/IOException
    //   203	215	271	finally
    //   233	238	286	java/io/IOException
    //   279	283	290	java/io/IOException
    //   218	228	294	finally
    //   249	254	294	finally
    //   218	228	299	java/io/IOException
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
    localArrayList.add(AppConstants.aO + "log.txt");
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
          break label308;
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
          label308:
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
    //   0: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   3: ldc 104
    //   5: invokestatic 109	com/tencent/mobileqq/utils/TimeFormatterUtils:a	(JLjava/lang/String;)Ljava/lang/String;
    //   8: astore 7
    //   10: new 67	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   17: getstatic 13	com/tencent/mfsdk/LeakInspector/DumpMemInfoHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 256
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 204
    //   35: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload 7
    //   40: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 300
    //   46: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore 7
    //   54: new 302	java/io/BufferedOutputStream
    //   57: dup
    //   58: new 304	java/io/FileOutputStream
    //   61: dup
    //   62: new 49	java/io/File
    //   65: dup
    //   66: aload 7
    //   68: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: invokespecial 307	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 310	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   77: astore_1
    //   78: new 312	java/util/zip/ZipOutputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 313	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore 8
    //   88: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   91: lstore_3
    //   92: aload_0
    //   93: invokeinterface 317 1 0
    //   98: astore 9
    //   100: aload 9
    //   102: invokeinterface 322 1 0
    //   107: ifeq +321 -> 428
    //   110: new 49	java/io/File
    //   113: dup
    //   114: aload 9
    //   116: invokeinterface 326 1 0
    //   121: checkcast 15	java/lang/String
    //   124: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: astore 10
    //   129: aload 10
    //   131: invokevirtual 86	java/io/File:exists	()Z
    //   134: ifeq -34 -> 100
    //   137: aload 8
    //   139: new 328	java/util/zip/ZipEntry
    //   142: dup
    //   143: aload 10
    //   145: invokevirtual 329	java/io/File:getName	()Ljava/lang/String;
    //   148: invokespecial 330	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   151: invokevirtual 334	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   154: aload 8
    //   156: bipush 9
    //   158: invokevirtual 337	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   161: new 339	java/io/FileInputStream
    //   164: dup
    //   165: aload 10
    //   167: invokespecial 340	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   170: astore 10
    //   172: sipush 8192
    //   175: newarray byte
    //   177: astore 11
    //   179: aload 10
    //   181: aload 11
    //   183: iconst_0
    //   184: sipush 8192
    //   187: invokevirtual 344	java/io/FileInputStream:read	([BII)I
    //   190: istore_2
    //   191: iload_2
    //   192: iconst_m1
    //   193: if_icmpeq +158 -> 351
    //   196: aload 8
    //   198: aload 11
    //   200: iconst_0
    //   201: iload_2
    //   202: invokevirtual 347	java/util/zip/ZipOutputStream:write	([BII)V
    //   205: goto -26 -> 179
    //   208: astore 9
    //   210: aload 10
    //   212: ifnull +8 -> 220
    //   215: aload 10
    //   217: invokevirtual 348	java/io/FileInputStream:close	()V
    //   220: aload 8
    //   222: invokevirtual 351	java/util/zip/ZipOutputStream:flush	()V
    //   225: aload 8
    //   227: invokevirtual 354	java/util/zip/ZipOutputStream:closeEntry	()V
    //   230: aload 9
    //   232: athrow
    //   233: astore 9
    //   235: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +14 -> 252
    //   241: ldc 237
    //   243: iconst_2
    //   244: ldc_w 356
    //   247: aload 9
    //   249: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload 8
    //   254: ifnull +8 -> 262
    //   257: aload 8
    //   259: invokevirtual 359	java/util/zip/ZipOutputStream:close	()V
    //   262: aload_1
    //   263: ifnull +393 -> 656
    //   266: aload_1
    //   267: invokevirtual 360	java/io/BufferedOutputStream:close	()V
    //   270: iconst_0
    //   271: istore 5
    //   273: iload 5
    //   275: istore 6
    //   277: iload 6
    //   279: ifeq +359 -> 638
    //   282: aload_0
    //   283: invokeinterface 317 1 0
    //   288: astore_0
    //   289: aload_0
    //   290: invokeinterface 322 1 0
    //   295: ifeq +343 -> 638
    //   298: aload_0
    //   299: invokeinterface 326 1 0
    //   304: checkcast 15	java/lang/String
    //   307: astore_1
    //   308: aload_1
    //   309: ldc 206
    //   311: invokevirtual 65	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   314: ifne -25 -> 289
    //   317: aload_1
    //   318: ldc_w 362
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
    //   344: invokevirtual 365	java/io/File:delete	()Z
    //   347: pop
    //   348: goto -59 -> 289
    //   351: aload 10
    //   353: ifnull +8 -> 361
    //   356: aload 10
    //   358: invokevirtual 348	java/io/FileInputStream:close	()V
    //   361: aload 8
    //   363: invokevirtual 351	java/util/zip/ZipOutputStream:flush	()V
    //   366: aload 8
    //   368: invokevirtual 354	java/util/zip/ZipOutputStream:closeEntry	()V
    //   371: goto -271 -> 100
    //   374: astore 9
    //   376: aload 8
    //   378: ifnull +8 -> 386
    //   381: aload 8
    //   383: invokevirtual 359	java/util/zip/ZipOutputStream:close	()V
    //   386: aload_1
    //   387: ifnull +7 -> 394
    //   390: aload_1
    //   391: invokevirtual 360	java/io/BufferedOutputStream:close	()V
    //   394: aload 9
    //   396: athrow
    //   397: astore_1
    //   398: iconst_0
    //   399: istore 5
    //   401: iload 5
    //   403: istore 6
    //   405: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq -131 -> 277
    //   411: ldc 237
    //   413: iconst_2
    //   414: ldc_w 356
    //   417: aload_1
    //   418: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   421: iload 5
    //   423: istore 6
    //   425: goto -148 -> 277
    //   428: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +54 -> 485
    //   434: ldc 237
    //   436: iconst_2
    //   437: new 67	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 367
    //   447: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   453: lload_3
    //   454: lsub
    //   455: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   458: ldc_w 369
    //   461: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: invokeinterface 372 1 0
    //   470: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: ldc_w 377
    //   476: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload 8
    //   487: ifnull +8 -> 495
    //   490: aload 8
    //   492: invokevirtual 359	java/util/zip/ZipOutputStream:close	()V
    //   495: aload_1
    //   496: ifnull +166 -> 662
    //   499: aload_1
    //   500: invokevirtual 360	java/io/BufferedOutputStream:close	()V
    //   503: iconst_1
    //   504: istore 5
    //   506: goto -233 -> 273
    //   509: astore 8
    //   511: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq -19 -> 495
    //   517: ldc 237
    //   519: iconst_2
    //   520: ldc_w 356
    //   523: aload 8
    //   525: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   528: goto -33 -> 495
    //   531: astore_1
    //   532: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   535: ifeq +13 -> 548
    //   538: ldc 237
    //   540: iconst_2
    //   541: ldc_w 356
    //   544: aload_1
    //   545: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   548: iconst_1
    //   549: istore 5
    //   551: goto -278 -> 273
    //   554: astore 8
    //   556: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq -297 -> 262
    //   562: ldc 237
    //   564: iconst_2
    //   565: ldc_w 356
    //   568: aload 8
    //   570: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   573: goto -311 -> 262
    //   576: astore_1
    //   577: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +95 -> 675
    //   583: ldc 237
    //   585: iconst_2
    //   586: ldc_w 356
    //   589: aload_1
    //   590: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   593: goto +82 -> 675
    //   596: astore 8
    //   598: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq -215 -> 386
    //   604: ldc 237
    //   606: iconst_2
    //   607: ldc_w 356
    //   610: aload 8
    //   612: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   615: goto -229 -> 386
    //   618: astore_1
    //   619: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq -228 -> 394
    //   625: ldc 237
    //   627: iconst_2
    //   628: ldc_w 356
    //   631: aload_1
    //   632: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   635: goto -241 -> 394
    //   638: iconst_2
    //   639: anewarray 4	java/lang/Object
    //   642: dup
    //   643: iconst_0
    //   644: iload 6
    //   646: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.mfsdk.LeakInspector.DumpMemInfoHandler
 * JD-Core Version:    0.7.0.1
 */