package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import aoiu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MonitorSocketDownload
  extends AsyncStep
  implements INetEngine.INetEngineListener
{
  protected static INetEngine.IBreakDownFix a;
  private long a;
  private final String b = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
  private final String c = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
  private int d = -1;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new aoiu();
  }
  
  private void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    try
    {
      String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/monitor_config.properties";
      localObject = ((QQAppInterface)localObject).getNetEngine(0);
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = this;
      localHttpNetReq.mReqUrl = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = str;
      localHttpNetReq.mPrioty = 0;
      localHttpNetReq.mBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
      ((INetEngine)localObject).sendReq(localHttpNetReq);
      if (QLog.isColorLevel()) {
        QLog.d("MonitorSocketDownload", 2, "download MS config");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MonitorSocketDownload", 1, "" + localException);
    }
  }
  
  private int b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      try
      {
        if (QLog.isColorLevel())
        {
          int i = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_socket_config", 0).getInt("version", -1);
          QLog.d("MonitorSocketDownload", 2, "checkVersion currentVersion: " + i);
        }
        String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/com.tencent.mobileqq_checkurl";
        localObject = ((QQAppInterface)localObject).getNetEngine(0);
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.mCallback = this;
        localHttpNetReq.mReqUrl = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
        localHttpNetReq.mHttpMethod = 0;
        localHttpNetReq.mOutPath = str;
        localHttpNetReq.mPrioty = 0;
        localHttpNetReq.mBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
        ((INetEngine)localObject).sendReq(localHttpNetReq);
        if (QLog.isColorLevel()) {
          QLog.d("MonitorSocketDownload", 2, "send request to check version and decide whether to download MS config");
        }
        return 7;
      }
      catch (Exception localException)
      {
        QLog.d("MonitorSocketDownload", 1, "" + localException);
        return 6;
      }
    }
    return 7;
  }
  
  public int a()
  {
    return b();
  }
  
  /* Error */
  public void onResp(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: getfield 164	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   10: ifne +222 -> 232
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_1
    //   16: getfield 168	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   19: checkcast 77	com/tencent/mobileqq/transfile/HttpNetReq
    //   22: astore_3
    //   23: new 58	java/io/File
    //   26: dup
    //   27: aload_3
    //   28: getfield 91	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   31: invokespecial 171	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 6
    //   36: iload_2
    //   37: ifeq +551 -> 588
    //   40: aload_3
    //   41: getfield 85	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   44: ldc 31
    //   46: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +280 -> 329
    //   52: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +32 -> 87
    //   58: ldc 111
    //   60: iconst_2
    //   61: new 51	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   68: ldc 179
    //   70: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 6
    //   75: invokevirtual 182	java/io/File:exists	()Z
    //   78: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   81: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: new 187	java/io/FileInputStream
    //   90: dup
    //   91: aload 6
    //   93: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: astore 4
    //   98: new 192	java/io/BufferedReader
    //   101: dup
    //   102: new 194	java/io/InputStreamReader
    //   105: dup
    //   106: aload 4
    //   108: invokespecial 197	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   111: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +92 -> 213
    //   124: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +10 -> 137
    //   130: ldc 111
    //   132: iconst_2
    //   133: aload_1
    //   134: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_1
    //   138: ldc 205
    //   140: invokevirtual 209	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   143: iconst_1
    //   144: aaload
    //   145: invokestatic 215	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   148: istore_2
    //   149: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   152: ldc 132
    //   154: iconst_0
    //   155: invokevirtual 136	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   158: ldc 138
    //   160: iconst_m1
    //   161: invokeinterface 144 3 0
    //   166: iload_2
    //   167: if_icmpne +70 -> 237
    //   170: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +40 -> 213
    //   176: ldc 111
    //   178: iconst_2
    //   179: new 51	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   186: ldc 217
    //   188: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   194: aload_0
    //   195: getfield 130	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:jdField_a_of_type_Long	J
    //   198: lsub
    //   199: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: ldc 222
    //   204: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_3
    //   214: ifnull +7 -> 221
    //   217: aload_3
    //   218: invokevirtual 225	java/io/BufferedReader:close	()V
    //   221: aload 4
    //   223: ifnull +8 -> 231
    //   226: aload 4
    //   228: invokevirtual 226	java/io/FileInputStream:close	()V
    //   231: return
    //   232: iconst_0
    //   233: istore_2
    //   234: goto -219 -> 15
    //   237: aload_0
    //   238: invokespecial 228	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:a	()V
    //   241: aload_0
    //   242: iload_2
    //   243: putfield 35	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:d	I
    //   246: goto -33 -> 213
    //   249: astore 5
    //   251: aload 4
    //   253: astore_1
    //   254: aload 5
    //   256: astore 4
    //   258: ldc 111
    //   260: iconst_1
    //   261: new 51	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   268: ldc 118
    //   270: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload 4
    //   275: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_3
    //   285: ifnull +7 -> 292
    //   288: aload_3
    //   289: invokevirtual 225	java/io/BufferedReader:close	()V
    //   292: aload_1
    //   293: ifnull -62 -> 231
    //   296: aload_1
    //   297: invokevirtual 226	java/io/FileInputStream:close	()V
    //   300: return
    //   301: astore_1
    //   302: return
    //   303: astore_1
    //   304: aconst_null
    //   305: astore_3
    //   306: aconst_null
    //   307: astore 4
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 225	java/io/BufferedReader:close	()V
    //   317: aload 4
    //   319: ifnull +8 -> 327
    //   322: aload 4
    //   324: invokevirtual 226	java/io/FileInputStream:close	()V
    //   327: aload_1
    //   328: athrow
    //   329: aload_3
    //   330: getfield 85	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   333: ldc 27
    //   335: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq -107 -> 231
    //   341: invokestatic 43	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   344: ldc 132
    //   346: iconst_0
    //   347: invokevirtual 136	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   350: invokeinterface 232 1 0
    //   355: ldc 138
    //   357: aload_0
    //   358: getfield 35	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:d	I
    //   361: invokeinterface 238 3 0
    //   366: invokeinterface 241 1 0
    //   371: pop
    //   372: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq -144 -> 231
    //   378: ldc 111
    //   380: iconst_2
    //   381: new 51	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   388: ldc 243
    //   390: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: getfield 35	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:d	I
    //   397: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: new 187	java/io/FileInputStream
    //   409: dup
    //   410: aload 6
    //   412: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   415: astore_1
    //   416: new 192	java/io/BufferedReader
    //   419: dup
    //   420: new 194	java/io/InputStreamReader
    //   423: dup
    //   424: aload_1
    //   425: invokespecial 197	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   428: invokespecial 200	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   431: astore_3
    //   432: aload_3
    //   433: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   436: astore 5
    //   438: aload_3
    //   439: astore 6
    //   441: aload_1
    //   442: astore 4
    //   444: aload 5
    //   446: ifnull +94 -> 540
    //   449: ldc 111
    //   451: iconst_2
    //   452: new 51	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   459: ldc 245
    //   461: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload 5
    //   466: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 247
    //   471: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   477: aload_0
    //   478: getfield 130	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:jdField_a_of_type_Long	J
    //   481: lsub
    //   482: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   485: ldc 222
    //   487: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload_3
    //   497: invokevirtual 203	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   500: astore 5
    //   502: goto -64 -> 438
    //   505: astore_3
    //   506: aconst_null
    //   507: astore_1
    //   508: ldc 111
    //   510: iconst_1
    //   511: new 51	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   518: ldc 118
    //   520: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_3
    //   524: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload 4
    //   535: astore 6
    //   537: aload_1
    //   538: astore 4
    //   540: aload 4
    //   542: ifnull +8 -> 550
    //   545: aload 4
    //   547: invokevirtual 226	java/io/FileInputStream:close	()V
    //   550: aload 6
    //   552: ifnull -321 -> 231
    //   555: aload 6
    //   557: invokevirtual 225	java/io/BufferedReader:close	()V
    //   560: return
    //   561: astore_1
    //   562: ldc 111
    //   564: iconst_1
    //   565: new 51	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   572: ldc 118
    //   574: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_1
    //   578: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   581: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   587: return
    //   588: ldc 111
    //   590: iconst_1
    //   591: new 51	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   598: ldc 249
    //   600: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_1
    //   604: getfield 164	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   607: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: return
    //   617: astore_1
    //   618: goto -397 -> 221
    //   621: astore_1
    //   622: return
    //   623: astore_3
    //   624: goto -332 -> 292
    //   627: astore_3
    //   628: goto -311 -> 317
    //   631: astore_3
    //   632: goto -305 -> 327
    //   635: astore_3
    //   636: goto -128 -> 508
    //   639: astore 5
    //   641: aload_3
    //   642: astore 4
    //   644: aload 5
    //   646: astore_3
    //   647: goto -139 -> 508
    //   650: astore_1
    //   651: aconst_null
    //   652: astore_3
    //   653: goto -344 -> 309
    //   656: astore_1
    //   657: goto -348 -> 309
    //   660: astore 5
    //   662: aload_1
    //   663: astore 4
    //   665: aload 5
    //   667: astore_1
    //   668: goto -359 -> 309
    //   671: astore 4
    //   673: aconst_null
    //   674: astore_3
    //   675: aload 5
    //   677: astore_1
    //   678: goto -420 -> 258
    //   681: astore 5
    //   683: aconst_null
    //   684: astore_3
    //   685: aload 4
    //   687: astore_1
    //   688: aload 5
    //   690: astore 4
    //   692: goto -434 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	695	0	this	MonitorSocketDownload
    //   0	695	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   14	229	2	i	int
    //   22	475	3	localObject1	Object
    //   505	19	3	localException1	Exception
    //   623	1	3	localIOException1	java.io.IOException
    //   627	1	3	localIOException2	java.io.IOException
    //   631	1	3	localIOException3	java.io.IOException
    //   635	7	3	localException2	Exception
    //   646	39	3	localException3	Exception
    //   1	663	4	localObject2	Object
    //   671	15	4	localException4	Exception
    //   690	1	4	localObject3	Object
    //   4	1	5	localObject4	Object
    //   249	6	5	localException5	Exception
    //   436	65	5	str	String
    //   639	6	5	localException6	Exception
    //   660	16	5	localObject5	Object
    //   681	8	5	localException7	Exception
    //   34	522	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   115	120	249	java/lang/Exception
    //   124	137	249	java/lang/Exception
    //   137	213	249	java/lang/Exception
    //   237	246	249	java/lang/Exception
    //   296	300	301	java/io/IOException
    //   87	98	303	finally
    //   406	416	505	java/lang/Exception
    //   545	550	561	java/io/IOException
    //   555	560	561	java/io/IOException
    //   217	221	617	java/io/IOException
    //   226	231	621	java/io/IOException
    //   288	292	623	java/io/IOException
    //   313	317	627	java/io/IOException
    //   322	327	631	java/io/IOException
    //   416	432	635	java/lang/Exception
    //   432	438	639	java/lang/Exception
    //   449	502	639	java/lang/Exception
    //   98	115	650	finally
    //   115	120	656	finally
    //   124	137	656	finally
    //   137	213	656	finally
    //   237	246	656	finally
    //   258	284	660	finally
    //   87	98	671	java/lang/Exception
    //   98	115	681	java/lang/Exception
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */