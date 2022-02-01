package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MonitorSocketDownload
  extends AsyncStep
  implements INetEngineListener
{
  private final String a = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
  private final String b = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
  private long c = 0L;
  private int d = -1;
  
  private int a()
  {
    this.c = System.currentTimeMillis();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      try
      {
        if (QLog.isColorLevel())
        {
          int i = BaseApplicationImpl.getApplication().getSharedPreferences("monitor_socket_config", 0).getInt("version", -1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkVersion currentVersion: ");
          ((StringBuilder)localObject2).append(i);
          QLog.d("MonitorSocketDownload", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject2).append("/com.tencent.mobileqq_checkurl");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = (IHttpEngineService)((QQAppInterface)localObject1).getRuntimeService(IHttpEngineService.class, "all");
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.mCallback = this;
        localHttpNetReq.mReqUrl = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorversion.txt";
        localHttpNetReq.mHttpMethod = 0;
        localHttpNetReq.mOutPath = ((String)localObject2);
        localHttpNetReq.mPrioty = 0;
        localHttpNetReq.mSupportBreakResume = true;
        ((IHttpEngineService)localObject1).sendReq(localHttpNetReq);
        if (QLog.isColorLevel()) {
          QLog.d("MonitorSocketDownload", 2, "send request to check version and decide whether to download MS config");
        }
        return 7;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(localException);
        QLog.d("MonitorSocketDownload", 1, ((StringBuilder)localObject2).toString());
        return 6;
      }
    }
    return 7;
  }
  
  private void b()
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject1).append("/monitor_config.properties");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = (IHttpEngineService)((QQAppInterface)localObject2).getRuntimeService(IHttpEngineService.class, "all");
        HttpNetReq localHttpNetReq = new HttpNetReq();
        localHttpNetReq.mCallback = this;
        localHttpNetReq.mReqUrl = "https://dl.url.cn/myapp/iosqq_luaplg/tmp_video/msf/monitor/monitorconfig.txt";
        localHttpNetReq.mHttpMethod = 0;
        localHttpNetReq.mOutPath = ((String)localObject1);
        localHttpNetReq.mPrioty = 0;
        localHttpNetReq.mSupportBreakResume = true;
        ((IHttpEngineService)localObject2).sendReq(localHttpNetReq);
        if (QLog.isColorLevel())
        {
          QLog.d("MonitorSocketDownload", 2, "download MS config");
          return;
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(localException);
        QLog.d("MonitorSocketDownload", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  protected int doStep()
  {
    return a();
  }
  
  /* Error */
  public void onResp(com.tencent.mobileqq.transfile.NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 161	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   4: ifne +8 -> 12
    //   7: iconst_1
    //   8: istore_2
    //   9: goto +5 -> 14
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_1
    //   15: getfield 165	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   18: checkcast 113	com/tencent/mobileqq/transfile/HttpNetReq
    //   21: astore 6
    //   23: new 98	java/io/File
    //   26: dup
    //   27: aload 6
    //   29: getfield 127	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   32: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 4
    //   37: iload_2
    //   38: ifeq +717 -> 755
    //   41: aload 6
    //   43: getfield 121	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   46: ldc 23
    //   48: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   51: istore_3
    //   52: aconst_null
    //   53: astore 7
    //   55: aconst_null
    //   56: astore 5
    //   58: iload_3
    //   59: ifeq +371 -> 430
    //   62: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +38 -> 103
    //   68: new 73	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   75: astore_1
    //   76: aload_1
    //   77: ldc 176
    //   79: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_1
    //   84: aload 4
    //   86: invokevirtual 179	java/io/File:exists	()Z
    //   89: invokevirtual 182	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 85
    //   95: iconst_2
    //   96: aload_1
    //   97: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: new 184	java/io/FileInputStream
    //   106: dup
    //   107: aload 4
    //   109: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   112: astore_1
    //   113: aload_1
    //   114: astore 4
    //   116: new 189	java/io/BufferedReader
    //   119: dup
    //   120: new 191	java/io/InputStreamReader
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 194	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   128: invokespecial 197	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   131: astore 6
    //   133: aload 6
    //   135: invokevirtual 200	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: ifnull +119 -> 261
    //   145: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +11 -> 159
    //   151: ldc 85
    //   153: iconst_2
    //   154: aload 4
    //   156: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 4
    //   161: ldc 202
    //   163: invokevirtual 206	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   166: iconst_1
    //   167: aaload
    //   168: invokestatic 212	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   171: istore_2
    //   172: invokestatic 45	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   175: ldc 59
    //   177: iconst_0
    //   178: invokevirtual 63	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   181: ldc 65
    //   183: iconst_m1
    //   184: invokeinterface 71 3 0
    //   189: iload_2
    //   190: if_icmpne +62 -> 252
    //   193: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +65 -> 261
    //   199: new 73	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   206: astore 4
    //   208: aload 4
    //   210: ldc 214
    //   212: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   221: aload_0
    //   222: getfield 27	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:c	J
    //   225: lsub
    //   226: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 4
    //   232: ldc 219
    //   234: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: ldc 85
    //   240: iconst_2
    //   241: aload 4
    //   243: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: goto +12 -> 261
    //   252: aload_0
    //   253: invokespecial 221	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:b	()V
    //   256: aload_0
    //   257: iload_2
    //   258: putfield 29	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:d	I
    //   261: aload 6
    //   263: invokevirtual 224	java/io/BufferedReader:close	()V
    //   266: aload_1
    //   267: invokevirtual 225	java/io/FileInputStream:close	()V
    //   270: return
    //   271: astore 5
    //   273: goto +133 -> 406
    //   276: astore 4
    //   278: aload 6
    //   280: astore 7
    //   282: aload 4
    //   284: astore 6
    //   286: goto +36 -> 322
    //   289: astore_1
    //   290: aload 5
    //   292: astore 6
    //   294: aload_1
    //   295: astore 5
    //   297: aload 4
    //   299: astore_1
    //   300: goto +106 -> 406
    //   303: astore 6
    //   305: goto +17 -> 322
    //   308: astore 5
    //   310: aconst_null
    //   311: astore_1
    //   312: aload_1
    //   313: astore 6
    //   315: goto +91 -> 406
    //   318: astore 6
    //   320: aconst_null
    //   321: astore_1
    //   322: aload 7
    //   324: astore 5
    //   326: aload_1
    //   327: astore 4
    //   329: new 73	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   336: astore 8
    //   338: aload 7
    //   340: astore 5
    //   342: aload_1
    //   343: astore 4
    //   345: aload 8
    //   347: ldc 142
    //   349: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 7
    //   355: astore 5
    //   357: aload_1
    //   358: astore 4
    //   360: aload 8
    //   362: aload 6
    //   364: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 7
    //   370: astore 5
    //   372: aload_1
    //   373: astore 4
    //   375: ldc 85
    //   377: iconst_1
    //   378: aload 8
    //   380: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 7
    //   388: ifnull +11 -> 399
    //   391: aload 7
    //   393: invokevirtual 224	java/io/BufferedReader:close	()V
    //   396: goto +3 -> 399
    //   399: aload_1
    //   400: ifnull +393 -> 793
    //   403: goto -137 -> 266
    //   406: aload 6
    //   408: ifnull +11 -> 419
    //   411: aload 6
    //   413: invokevirtual 224	java/io/BufferedReader:close	()V
    //   416: goto +3 -> 419
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 225	java/io/FileInputStream:close	()V
    //   427: aload 5
    //   429: athrow
    //   430: aload 6
    //   432: getfield 121	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   435: ldc 19
    //   437: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   440: ifeq +353 -> 793
    //   443: invokestatic 45	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   446: ldc 59
    //   448: iconst_0
    //   449: invokevirtual 63	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   452: invokeinterface 229 1 0
    //   457: ldc 65
    //   459: aload_0
    //   460: getfield 29	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:d	I
    //   463: invokeinterface 235 3 0
    //   468: invokeinterface 238 1 0
    //   473: pop
    //   474: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +316 -> 793
    //   480: new 73	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   487: astore_1
    //   488: aload_1
    //   489: ldc 240
    //   491: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_1
    //   496: aload_0
    //   497: getfield 29	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:d	I
    //   500: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: ldc 85
    //   506: iconst_2
    //   507: aload_1
    //   508: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: new 184	java/io/FileInputStream
    //   517: dup
    //   518: aload 4
    //   520: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   523: astore 5
    //   525: new 189	java/io/BufferedReader
    //   528: dup
    //   529: new 191	java/io/InputStreamReader
    //   532: dup
    //   533: aload 5
    //   535: invokespecial 194	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   538: invokespecial 197	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   541: astore_1
    //   542: aload_1
    //   543: invokevirtual 200	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   546: astore 4
    //   548: aload_1
    //   549: astore 7
    //   551: aload 5
    //   553: astore 6
    //   555: aload 4
    //   557: ifnull +141 -> 698
    //   560: new 73	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   567: astore 6
    //   569: aload 6
    //   571: ldc 242
    //   573: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 6
    //   579: aload 4
    //   581: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 6
    //   587: ldc 244
    //   589: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 6
    //   595: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   598: aload_0
    //   599: getfield 27	com/tencent/mobileqq/app/automator/step/MonitorSocketDownload:c	J
    //   602: lsub
    //   603: invokevirtual 217	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 6
    //   609: ldc 219
    //   611: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: ldc 85
    //   617: iconst_2
    //   618: aload 6
    //   620: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   626: aload_1
    //   627: invokevirtual 200	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   630: astore 4
    //   632: goto -84 -> 548
    //   635: astore 4
    //   637: goto +18 -> 655
    //   640: astore 4
    //   642: aconst_null
    //   643: astore_1
    //   644: goto +11 -> 655
    //   647: astore 4
    //   649: aconst_null
    //   650: astore 5
    //   652: aload 5
    //   654: astore_1
    //   655: new 73	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   662: astore 6
    //   664: aload 6
    //   666: ldc 142
    //   668: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 6
    //   674: aload 4
    //   676: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: ldc 85
    //   682: iconst_1
    //   683: aload 6
    //   685: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload 5
    //   693: astore 6
    //   695: aload_1
    //   696: astore 7
    //   698: aload 6
    //   700: ifnull +11 -> 711
    //   703: aload 6
    //   705: invokevirtual 225	java/io/FileInputStream:close	()V
    //   708: goto +3 -> 711
    //   711: aload 7
    //   713: ifnull +80 -> 793
    //   716: aload 7
    //   718: invokevirtual 224	java/io/BufferedReader:close	()V
    //   721: return
    //   722: new 73	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   729: astore_1
    //   730: aload_1
    //   731: ldc 142
    //   733: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload_1
    //   738: aload 4
    //   740: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: ldc 85
    //   746: iconst_1
    //   747: aload_1
    //   748: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: return
    //   755: new 73	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   762: astore 4
    //   764: aload 4
    //   766: ldc 246
    //   768: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload 4
    //   774: aload_1
    //   775: getfield 161	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   778: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: ldc 85
    //   784: iconst_1
    //   785: aload 4
    //   787: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: return
    //   794: astore 4
    //   796: goto -530 -> 266
    //   799: astore_1
    //   800: return
    //   801: astore 4
    //   803: goto -404 -> 399
    //   806: astore 4
    //   808: goto -389 -> 419
    //   811: astore_1
    //   812: goto -385 -> 427
    //   815: astore 4
    //   817: goto -95 -> 722
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	820	0	this	MonitorSocketDownload
    //   0	820	1	paramNetResp	com.tencent.mobileqq.transfile.NetResp
    //   8	250	2	i	int
    //   51	8	3	bool	boolean
    //   35	207	4	localObject1	Object
    //   276	22	4	localException1	Exception
    //   327	304	4	localObject2	Object
    //   635	1	4	localException2	Exception
    //   640	1	4	localException3	Exception
    //   647	92	4	localException4	Exception
    //   762	24	4	localStringBuilder1	StringBuilder
    //   794	1	4	localIOException1	java.io.IOException
    //   801	1	4	localIOException2	java.io.IOException
    //   806	1	4	localIOException3	java.io.IOException
    //   815	1	4	localIOException4	java.io.IOException
    //   56	1	5	localObject3	Object
    //   271	20	5	localObject4	Object
    //   295	1	5	localNetResp1	com.tencent.mobileqq.transfile.NetResp
    //   308	1	5	localObject5	Object
    //   324	368	5	localObject6	Object
    //   21	272	6	localObject7	Object
    //   303	1	6	localException5	Exception
    //   313	1	6	localNetResp2	com.tencent.mobileqq.transfile.NetResp
    //   318	113	6	localException6	Exception
    //   553	151	6	localObject8	Object
    //   53	664	7	localObject9	Object
    //   336	43	8	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   133	140	271	finally
    //   145	159	271	finally
    //   159	249	271	finally
    //   252	261	271	finally
    //   133	140	276	java/lang/Exception
    //   145	159	276	java/lang/Exception
    //   159	249	276	java/lang/Exception
    //   252	261	276	java/lang/Exception
    //   116	133	289	finally
    //   329	338	289	finally
    //   345	353	289	finally
    //   360	368	289	finally
    //   375	386	289	finally
    //   116	133	303	java/lang/Exception
    //   103	113	308	finally
    //   103	113	318	java/lang/Exception
    //   542	548	635	java/lang/Exception
    //   560	632	635	java/lang/Exception
    //   525	542	640	java/lang/Exception
    //   514	525	647	java/lang/Exception
    //   261	266	794	java/io/IOException
    //   266	270	799	java/io/IOException
    //   391	396	801	java/io/IOException
    //   411	416	806	java/io/IOException
    //   423	427	811	java/io/IOException
    //   703	708	815	java/io/IOException
    //   716	721	815	java/io/IOException
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.MonitorSocketDownload
 * JD-Core Version:    0.7.0.1
 */