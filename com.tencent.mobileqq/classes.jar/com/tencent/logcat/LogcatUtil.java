package com.tencent.logcat;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import bdmp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class LogcatUtil
  implements Handler.Callback
{
  private static LogcatUtil jdField_a_of_type_ComTencentLogcatLogcatUtil = new LogcatUtil();
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/log/logcat";
  private static final String b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/private";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  LogcatUtil.LogcatThread jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread;
  
  private static void a()
  {
    QLog.e("LogcatUtil", 1, "get trace file begin");
    String str2 = bdmp.a(String.valueOf(100));
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("AdditionInfo:0|");
    String str1 = "";
    localObject3 = str1;
    try
    {
      PackageManager localPackageManager = BaseApplicationImpl.getApplication().getPackageManager();
      localObject1 = str1;
      if ("" == null)
      {
        localObject3 = str1;
        localObject1 = localPackageManager.getPackageInfo("com.tencent.mobileqq", 128);
        localObject3 = str1;
        localObject1 = ((PackageInfo)localObject1).versionName + "." + ((PackageInfo)localObject1).versionCode;
      }
      localObject3 = localObject1;
      str1 = ((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getAccount();
      localObject3 = str1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        QLog.e("LogcatUtil", 1, "Exeption ", localException);
        Object localObject2 = localObject3;
        localObject3 = "";
        continue;
        boolean bool = false;
        continue;
        bool = false;
      }
    }
    localStringBuilder.append((String)localObject3).append("|").append((String)localObject1).append("|");
    localStringBuilder.append("|").append("pub").append("|").append(System.currentTimeMillis());
    localStringBuilder.append("|").append(100).append("|").append(Build.MODEL).append("|").append(Build.VERSION.RELEASE);
    i = bdmp.a(BaseApplicationImpl.getContext(), str2, localStringBuilder.toString());
    if (i == 1)
    {
      bool = true;
      QLog.e("LogcatUtil", 1, new Object[] { "get trace file fileName = ", str2, ",get system trace status=", Boolean.valueOf(bool) });
      if (i == 1) {
        break label332;
      }
      bool = bdmp.a(str2, localStringBuilder.toString());
      QLog.e("LogcatUtil", 1, new Object[] { "get trace file fileName = ", str2, ",get java trace status=", Boolean.valueOf(bool) });
    }
  }
  
  private static void a(File paramFile)
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory()) {
        a(localFile);
      }
      for (;;)
      {
        i += 1;
        break;
        QLog.d("LogcatUtil", 1, "private file path :" + localFile.getAbsolutePath());
      }
    }
  }
  
  public static void a(String paramString)
  {
    if ((QLog.isColorLevel()) && (jdField_a_of_type_ComTencentLogcatLogcatUtil != null) && (jdField_a_of_type_ComTencentLogcatLogcatUtil.a(paramString))) {
      jdField_a_of_type_ComTencentLogcatLogcatUtil.b(paramString);
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString.equals("$logcat start")) || (paramString.equals("$logcat stop")) || (paramString.equals("$list private files")) || (paramString.startsWith("$get private file ")) || (paramString.startsWith("$get trace file"));
  }
  
  private void b(String paramString)
  {
    if (paramString.equals("$logcat start")) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    do
    {
      return;
      if (paramString.equals("$logcat stop"))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        return;
      }
      if (paramString.equals("$list private files"))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (paramString.startsWith("$get private file "))
      {
        paramString = paramString.substring("$get private file ".length());
        QLog.d("LogcatUtil", 1, "private fileName :" + paramString);
        Message localMessage = Message.obtain();
        localMessage.obj = paramString;
        localMessage.what = 4;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
      }
    } while (!paramString.equals("$get trace file"));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_1
    //   15: getstatic 267	java/io/File:separator	Ljava/lang/String;
    //   18: invokevirtual 271	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +157 -> 178
    //   24: aload_1
    //   25: iconst_0
    //   26: aload_1
    //   27: getstatic 267	java/io/File:separator	Ljava/lang/String;
    //   30: invokevirtual 275	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   33: invokevirtual 278	java/lang/String:substring	(II)Ljava/lang/String;
    //   36: pop
    //   37: aload_1
    //   38: aload_1
    //   39: getstatic 267	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 275	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   45: iconst_1
    //   46: iadd
    //   47: invokevirtual 240	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: astore 4
    //   52: invokestatic 162	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 283	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   58: invokevirtual 286	java/io/File:getParentFile	()Ljava/io/File;
    //   61: astore 6
    //   63: ldc 68
    //   65: iconst_1
    //   66: new 16	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 288
    //   76: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   84: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: new 27	java/io/File
    //   96: dup
    //   97: aload 6
    //   99: aload_1
    //   100: invokespecial 291	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   103: astore_1
    //   104: ldc 68
    //   106: iconst_1
    //   107: new 16	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 293
    //   117: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_1
    //   134: invokevirtual 295	java/io/File:length	()J
    //   137: ldc2_w 296
    //   140: lcmp
    //   141: ifle +57 -> 198
    //   144: ldc 68
    //   146: iconst_1
    //   147: ldc_w 299
    //   150: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: iconst_0
    //   154: ifeq +11 -> 165
    //   157: new 301	java/lang/NullPointerException
    //   160: dup
    //   161: invokespecial 302	java/lang/NullPointerException:<init>	()V
    //   164: athrow
    //   165: iconst_0
    //   166: ifeq +11 -> 177
    //   169: new 301	java/lang/NullPointerException
    //   172: dup
    //   173: invokespecial 302	java/lang/NullPointerException:<init>	()V
    //   176: athrow
    //   177: return
    //   178: aload_1
    //   179: astore 4
    //   181: goto -129 -> 52
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   189: goto -24 -> 165
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   197: return
    //   198: new 307	java/io/FileInputStream
    //   201: dup
    //   202: aload_1
    //   203: invokespecial 309	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   206: astore_1
    //   207: aload 9
    //   209: astore 5
    //   211: aload_1
    //   212: astore 6
    //   214: ldc 68
    //   216: iconst_1
    //   217: new 16	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 311
    //   227: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: invokevirtual 314	java/io/FileInputStream:available	()I
    //   234: invokevirtual 126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 9
    //   245: astore 5
    //   247: aload_1
    //   248: astore 6
    //   250: new 27	java/io/File
    //   253: dup
    //   254: getstatic 46	com/tencent/logcat/LogcatUtil:b	Ljava/lang/String;
    //   257: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: astore 10
    //   262: aload 9
    //   264: astore 5
    //   266: aload_1
    //   267: astore 6
    //   269: aload 10
    //   271: invokevirtual 319	java/io/File:exists	()Z
    //   274: ifne +120 -> 394
    //   277: aload 9
    //   279: astore 5
    //   281: aload_1
    //   282: astore 6
    //   284: aload 10
    //   286: invokevirtual 322	java/io/File:mkdirs	()Z
    //   289: pop
    //   290: aload 9
    //   292: astore 5
    //   294: aload_1
    //   295: astore 6
    //   297: new 324	java/io/FileOutputStream
    //   300: dup
    //   301: new 27	java/io/File
    //   304: dup
    //   305: aload 10
    //   307: aload 4
    //   309: invokespecial 291	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   312: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   315: astore 4
    //   317: ldc_w 326
    //   320: newarray byte
    //   322: astore 5
    //   324: aload_1
    //   325: aload 5
    //   327: invokevirtual 330	java/io/FileInputStream:read	([B)I
    //   330: istore_2
    //   331: iload_2
    //   332: iconst_m1
    //   333: if_icmpeq +118 -> 451
    //   336: aload 4
    //   338: aload 5
    //   340: iconst_0
    //   341: iload_2
    //   342: invokevirtual 334	java/io/FileOutputStream:write	([BII)V
    //   345: goto -21 -> 324
    //   348: astore 6
    //   350: aload 4
    //   352: astore 5
    //   354: aload 6
    //   356: astore 4
    //   358: ldc 68
    //   360: iconst_1
    //   361: ldc_w 336
    //   364: aload 4
    //   366: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 339	java/io/FileInputStream:close	()V
    //   377: aload 5
    //   379: ifnull -202 -> 177
    //   382: aload 5
    //   384: invokevirtual 340	java/io/FileOutputStream:close	()V
    //   387: return
    //   388: astore_1
    //   389: aload_1
    //   390: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   393: return
    //   394: aload 9
    //   396: astore 5
    //   398: aload_1
    //   399: astore 6
    //   401: aload 10
    //   403: invokevirtual 192	java/io/File:listFiles	()[Ljava/io/File;
    //   406: astore 11
    //   408: aload 11
    //   410: ifnull -120 -> 290
    //   413: aload 9
    //   415: astore 5
    //   417: aload_1
    //   418: astore 6
    //   420: aload 11
    //   422: arraylength
    //   423: istore_3
    //   424: iload_2
    //   425: iload_3
    //   426: if_icmpge -136 -> 290
    //   429: aload 9
    //   431: astore 5
    //   433: aload_1
    //   434: astore 6
    //   436: aload 11
    //   438: iload_2
    //   439: aaload
    //   440: invokevirtual 343	java/io/File:delete	()Z
    //   443: pop
    //   444: iload_2
    //   445: iconst_1
    //   446: iadd
    //   447: istore_2
    //   448: goto -24 -> 424
    //   451: aload_1
    //   452: invokevirtual 339	java/io/FileInputStream:close	()V
    //   455: aload 4
    //   457: invokevirtual 340	java/io/FileOutputStream:close	()V
    //   460: ldc 68
    //   462: iconst_1
    //   463: ldc_w 345
    //   466: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_1
    //   470: ifnull +7 -> 477
    //   473: aload_1
    //   474: invokevirtual 339	java/io/FileInputStream:close	()V
    //   477: aload 4
    //   479: ifnull -302 -> 177
    //   482: aload 4
    //   484: invokevirtual 340	java/io/FileOutputStream:close	()V
    //   487: return
    //   488: astore_1
    //   489: aload_1
    //   490: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   493: return
    //   494: astore_1
    //   495: aload_1
    //   496: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   499: goto -22 -> 477
    //   502: astore_1
    //   503: aload_1
    //   504: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   507: goto -130 -> 377
    //   510: astore 4
    //   512: aconst_null
    //   513: astore_1
    //   514: aload 7
    //   516: astore 5
    //   518: aload_1
    //   519: astore 6
    //   521: ldc 68
    //   523: iconst_1
    //   524: ldc_w 336
    //   527: aload 4
    //   529: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   532: aload_1
    //   533: ifnull +7 -> 540
    //   536: aload_1
    //   537: invokevirtual 339	java/io/FileInputStream:close	()V
    //   540: aload 7
    //   542: ifnull -365 -> 177
    //   545: aload 7
    //   547: invokevirtual 340	java/io/FileOutputStream:close	()V
    //   550: return
    //   551: astore_1
    //   552: aload_1
    //   553: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   556: return
    //   557: astore_1
    //   558: aload_1
    //   559: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   562: goto -22 -> 540
    //   565: astore 4
    //   567: aconst_null
    //   568: astore_1
    //   569: aload_1
    //   570: ifnull +7 -> 577
    //   573: aload_1
    //   574: invokevirtual 339	java/io/FileInputStream:close	()V
    //   577: aload 5
    //   579: ifnull +8 -> 587
    //   582: aload 5
    //   584: invokevirtual 340	java/io/FileOutputStream:close	()V
    //   587: aload 4
    //   589: athrow
    //   590: astore_1
    //   591: aload_1
    //   592: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   595: goto -18 -> 577
    //   598: astore_1
    //   599: aload_1
    //   600: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   603: goto -16 -> 587
    //   606: astore 4
    //   608: aload 6
    //   610: astore_1
    //   611: goto -42 -> 569
    //   614: astore 6
    //   616: aload 4
    //   618: astore 5
    //   620: aload 6
    //   622: astore 4
    //   624: goto -55 -> 569
    //   627: astore 4
    //   629: goto -60 -> 569
    //   632: astore 4
    //   634: goto -120 -> 514
    //   637: astore 5
    //   639: aload 4
    //   641: astore 7
    //   643: aload 5
    //   645: astore 4
    //   647: goto -133 -> 514
    //   650: astore 4
    //   652: aconst_null
    //   653: astore_1
    //   654: aload 8
    //   656: astore 5
    //   658: goto -300 -> 358
    //   661: astore 4
    //   663: aload 8
    //   665: astore 5
    //   667: goto -309 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	this	LogcatUtil
    //   0	670	1	paramString	String
    //   13	435	2	i	int
    //   423	4	3	j	int
    //   50	433	4	localObject1	Object
    //   510	18	4	localIOException1	IOException
    //   565	23	4	localObject2	Object
    //   606	11	4	localObject3	Object
    //   622	1	4	localObject4	Object
    //   627	1	4	localObject5	Object
    //   632	8	4	localIOException2	IOException
    //   645	1	4	localIOException3	IOException
    //   650	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   661	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   4	615	5	localObject6	Object
    //   637	7	5	localIOException4	IOException
    //   656	10	5	localObject7	Object
    //   61	235	6	localObject8	Object
    //   348	7	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   399	210	6	str	String
    //   614	7	6	localObject9	Object
    //   1	641	7	localObject10	Object
    //   10	654	8	localObject11	Object
    //   7	423	9	localObject12	Object
    //   260	142	10	localFile	File
    //   406	31	11	arrayOfFile	File[]
    // Exception table:
    //   from	to	target	type
    //   157	165	184	java/io/IOException
    //   169	177	192	java/io/IOException
    //   317	324	348	java/io/FileNotFoundException
    //   324	331	348	java/io/FileNotFoundException
    //   336	345	348	java/io/FileNotFoundException
    //   451	469	348	java/io/FileNotFoundException
    //   382	387	388	java/io/IOException
    //   482	487	488	java/io/IOException
    //   473	477	494	java/io/IOException
    //   373	377	502	java/io/IOException
    //   14	52	510	java/io/IOException
    //   52	153	510	java/io/IOException
    //   198	207	510	java/io/IOException
    //   545	550	551	java/io/IOException
    //   536	540	557	java/io/IOException
    //   14	52	565	finally
    //   52	153	565	finally
    //   198	207	565	finally
    //   573	577	590	java/io/IOException
    //   582	587	598	java/io/IOException
    //   214	243	606	finally
    //   250	262	606	finally
    //   269	277	606	finally
    //   284	290	606	finally
    //   297	317	606	finally
    //   401	408	606	finally
    //   420	424	606	finally
    //   436	444	606	finally
    //   521	532	606	finally
    //   317	324	614	finally
    //   324	331	614	finally
    //   336	345	614	finally
    //   451	469	614	finally
    //   358	369	627	finally
    //   214	243	632	java/io/IOException
    //   250	262	632	java/io/IOException
    //   269	277	632	java/io/IOException
    //   284	290	632	java/io/IOException
    //   297	317	632	java/io/IOException
    //   401	408	632	java/io/IOException
    //   420	424	632	java/io/IOException
    //   436	444	632	java/io/IOException
    //   317	324	637	java/io/IOException
    //   324	331	637	java/io/IOException
    //   336	345	637	java/io/IOException
    //   451	469	637	java/io/IOException
    //   14	52	650	java/io/FileNotFoundException
    //   52	153	650	java/io/FileNotFoundException
    //   198	207	650	java/io/FileNotFoundException
    //   214	243	661	java/io/FileNotFoundException
    //   250	262	661	java/io/FileNotFoundException
    //   269	277	661	java/io/FileNotFoundException
    //   284	290	661	java/io/FileNotFoundException
    //   297	317	661	java/io/FileNotFoundException
    //   401	408	661	java/io/FileNotFoundException
    //   420	424	661	java/io/FileNotFoundException
    //   436	444	661	java/io/FileNotFoundException
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return true;
        } while (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread != null);
        this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread = new LogcatUtil.LogcatThread();
        this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.start();
        return true;
      } while (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread == null);
      if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.a != null) {
        this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.a.destroy();
      }
      if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.b != null) {
        this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.b.destroy();
      }
      this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread = null;
      return true;
    case 3: 
      paramMessage = BaseApplicationImpl.getContext().getFilesDir();
      QLog.d("LogcatUtil", 1, "private root file path :" + paramMessage.getAbsolutePath());
      try
      {
        a(paramMessage.getParentFile());
        return true;
      }
      catch (IOException paramMessage)
      {
        paramMessage.printStackTrace();
        return true;
      }
    case 4: 
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        c(paramMessage);
        return true;
      }
      QLog.e("LogcatUtil", 1, "private fileName is null");
      return true;
    }
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.logcat.LogcatUtil
 * JD-Core Version:    0.7.0.1
 */