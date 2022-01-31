package com.tencent.logcat;

import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
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
    return (paramString.equals("$logcat start")) || (paramString.equals("$logcat stop")) || (paramString.equals("$list private files")) || (paramString.startsWith("$get private file "));
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
    } while (!paramString.startsWith("$get private file "));
    paramString = paramString.substring("$get private file ".length());
    QLog.d("LogcatUtil", 1, "private fileName :" + paramString);
    Message localMessage = Message.obtain();
    localMessage.obj = paramString;
    localMessage.what = 4;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: iconst_0
    //   13: istore_2
    //   14: aload_1
    //   15: getstatic 151	java/io/File:separator	Ljava/lang/String;
    //   18: invokevirtual 155	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +154 -> 175
    //   24: aload_1
    //   25: iconst_0
    //   26: aload_1
    //   27: getstatic 151	java/io/File:separator	Ljava/lang/String;
    //   30: invokevirtual 159	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   33: invokevirtual 162	java/lang/String:substring	(II)Ljava/lang/String;
    //   36: pop
    //   37: aload_1
    //   38: aload_1
    //   39: getstatic 151	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 159	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   45: iconst_1
    //   46: iadd
    //   47: invokevirtual 123	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: astore 4
    //   52: invokestatic 168	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: invokevirtual 173	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   58: invokevirtual 176	java/io/File:getParentFile	()Ljava/io/File;
    //   61: astore 6
    //   63: ldc 77
    //   65: iconst_1
    //   66: new 16	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   73: ldc 178
    //   75: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload 6
    //   80: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: new 27	java/io/File
    //   95: dup
    //   96: aload 6
    //   98: aload_1
    //   99: invokespecial 181	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   102: astore_1
    //   103: ldc 77
    //   105: iconst_1
    //   106: new 16	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   113: ldc 183
    //   115: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   122: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_1
    //   132: invokevirtual 186	java/io/File:length	()J
    //   135: ldc2_w 187
    //   138: lcmp
    //   139: ifle +56 -> 195
    //   142: ldc 77
    //   144: iconst_1
    //   145: ldc 190
    //   147: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iconst_0
    //   151: ifeq +11 -> 162
    //   154: new 192	java/lang/NullPointerException
    //   157: dup
    //   158: invokespecial 193	java/lang/NullPointerException:<init>	()V
    //   161: athrow
    //   162: iconst_0
    //   163: ifeq +11 -> 174
    //   166: new 192	java/lang/NullPointerException
    //   169: dup
    //   170: invokespecial 193	java/lang/NullPointerException:<init>	()V
    //   173: athrow
    //   174: return
    //   175: aload_1
    //   176: astore 4
    //   178: goto -126 -> 52
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   186: goto -24 -> 162
    //   189: astore_1
    //   190: aload_1
    //   191: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   194: return
    //   195: new 198	java/io/FileInputStream
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 200	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   203: astore_1
    //   204: aload 9
    //   206: astore 5
    //   208: aload_1
    //   209: astore 6
    //   211: ldc 77
    //   213: iconst_1
    //   214: new 16	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   221: ldc 202
    //   223: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: invokevirtual 205	java/io/FileInputStream:available	()I
    //   230: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload 9
    //   241: astore 5
    //   243: aload_1
    //   244: astore 6
    //   246: new 27	java/io/File
    //   249: dup
    //   250: getstatic 46	com/tencent/logcat/LogcatUtil:b	Ljava/lang/String;
    //   253: invokespecial 210	java/io/File:<init>	(Ljava/lang/String;)V
    //   256: astore 11
    //   258: aload 9
    //   260: astore 5
    //   262: aload_1
    //   263: astore 6
    //   265: aload 11
    //   267: invokevirtual 213	java/io/File:exists	()Z
    //   270: ifne +118 -> 388
    //   273: aload 9
    //   275: astore 5
    //   277: aload_1
    //   278: astore 6
    //   280: aload 11
    //   282: invokevirtual 216	java/io/File:mkdirs	()Z
    //   285: pop
    //   286: aload 9
    //   288: astore 5
    //   290: aload_1
    //   291: astore 6
    //   293: new 218	java/io/FileOutputStream
    //   296: dup
    //   297: new 27	java/io/File
    //   300: dup
    //   301: aload 11
    //   303: aload 4
    //   305: invokespecial 181	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   308: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   311: astore 4
    //   313: ldc 220
    //   315: newarray byte
    //   317: astore 5
    //   319: aload_1
    //   320: aload 5
    //   322: invokevirtual 224	java/io/FileInputStream:read	([B)I
    //   325: istore_2
    //   326: iload_2
    //   327: iconst_m1
    //   328: if_icmpeq +117 -> 445
    //   331: aload 4
    //   333: aload 5
    //   335: iconst_0
    //   336: iload_2
    //   337: invokevirtual 228	java/io/FileOutputStream:write	([BII)V
    //   340: goto -21 -> 319
    //   343: astore 6
    //   345: aload 4
    //   347: astore 5
    //   349: aload 6
    //   351: astore 4
    //   353: ldc 77
    //   355: iconst_1
    //   356: ldc 230
    //   358: aload 4
    //   360: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   363: aload_1
    //   364: ifnull +7 -> 371
    //   367: aload_1
    //   368: invokevirtual 237	java/io/FileInputStream:close	()V
    //   371: aload 5
    //   373: ifnull -199 -> 174
    //   376: aload 5
    //   378: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   381: return
    //   382: astore_1
    //   383: aload_1
    //   384: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   387: return
    //   388: aload 9
    //   390: astore 5
    //   392: aload_1
    //   393: astore 6
    //   395: aload 11
    //   397: invokevirtual 69	java/io/File:listFiles	()[Ljava/io/File;
    //   400: astore 10
    //   402: aload 10
    //   404: ifnull -118 -> 286
    //   407: aload 9
    //   409: astore 5
    //   411: aload_1
    //   412: astore 6
    //   414: aload 10
    //   416: arraylength
    //   417: istore_3
    //   418: iload_2
    //   419: iload_3
    //   420: if_icmpge -134 -> 286
    //   423: aload 9
    //   425: astore 5
    //   427: aload_1
    //   428: astore 6
    //   430: aload 10
    //   432: iload_2
    //   433: aaload
    //   434: invokevirtual 241	java/io/File:delete	()Z
    //   437: pop
    //   438: iload_2
    //   439: iconst_1
    //   440: iadd
    //   441: istore_2
    //   442: goto -24 -> 418
    //   445: aload_1
    //   446: invokevirtual 237	java/io/FileInputStream:close	()V
    //   449: aload 4
    //   451: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   454: ldc 77
    //   456: iconst_1
    //   457: ldc 243
    //   459: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_1
    //   463: ifnull +7 -> 470
    //   466: aload_1
    //   467: invokevirtual 237	java/io/FileInputStream:close	()V
    //   470: aload 4
    //   472: ifnull -298 -> 174
    //   475: aload 4
    //   477: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   480: return
    //   481: astore_1
    //   482: aload_1
    //   483: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   486: return
    //   487: astore_1
    //   488: aload_1
    //   489: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   492: goto -22 -> 470
    //   495: astore_1
    //   496: aload_1
    //   497: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   500: goto -129 -> 371
    //   503: astore 7
    //   505: aconst_null
    //   506: astore_1
    //   507: aload 8
    //   509: astore 4
    //   511: aload 4
    //   513: astore 5
    //   515: aload_1
    //   516: astore 6
    //   518: ldc 77
    //   520: iconst_1
    //   521: ldc 230
    //   523: aload 7
    //   525: invokestatic 234	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   528: aload_1
    //   529: ifnull +7 -> 536
    //   532: aload_1
    //   533: invokevirtual 237	java/io/FileInputStream:close	()V
    //   536: aload 4
    //   538: ifnull -364 -> 174
    //   541: aload 4
    //   543: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   546: return
    //   547: astore_1
    //   548: aload_1
    //   549: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   552: return
    //   553: astore_1
    //   554: aload_1
    //   555: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   558: goto -22 -> 536
    //   561: astore 4
    //   563: aconst_null
    //   564: astore_1
    //   565: aload_1
    //   566: ifnull +7 -> 573
    //   569: aload_1
    //   570: invokevirtual 237	java/io/FileInputStream:close	()V
    //   573: aload 5
    //   575: ifnull +8 -> 583
    //   578: aload 5
    //   580: invokevirtual 238	java/io/FileOutputStream:close	()V
    //   583: aload 4
    //   585: athrow
    //   586: astore_1
    //   587: aload_1
    //   588: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   591: goto -18 -> 573
    //   594: astore_1
    //   595: aload_1
    //   596: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   599: goto -16 -> 583
    //   602: astore 4
    //   604: aload 6
    //   606: astore_1
    //   607: goto -42 -> 565
    //   610: astore 6
    //   612: aload 4
    //   614: astore 5
    //   616: aload 6
    //   618: astore 4
    //   620: goto -55 -> 565
    //   623: astore 4
    //   625: goto -60 -> 565
    //   628: astore 7
    //   630: aload 8
    //   632: astore 4
    //   634: goto -123 -> 511
    //   637: astore 7
    //   639: goto -128 -> 511
    //   642: astore 4
    //   644: aconst_null
    //   645: astore_1
    //   646: aload 7
    //   648: astore 5
    //   650: goto -297 -> 353
    //   653: astore 4
    //   655: aload 7
    //   657: astore 5
    //   659: goto -306 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	LogcatUtil
    //   0	662	1	paramString	String
    //   13	429	2	i	int
    //   417	4	3	j	int
    //   50	492	4	localObject1	Object
    //   561	23	4	localObject2	Object
    //   602	11	4	localObject3	Object
    //   618	1	4	localObject4	Object
    //   623	1	4	localObject5	Object
    //   632	1	4	localObject6	Object
    //   642	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   653	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   4	654	5	localObject7	Object
    //   61	231	6	localObject8	Object
    //   343	7	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   393	212	6	str	String
    //   610	7	6	localObject9	Object
    //   10	1	7	localObject10	Object
    //   503	21	7	localIOException1	IOException
    //   628	1	7	localIOException2	IOException
    //   637	19	7	localIOException3	IOException
    //   1	630	8	localObject11	Object
    //   7	417	9	localObject12	Object
    //   400	31	10	arrayOfFile	File[]
    //   256	140	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   154	162	181	java/io/IOException
    //   166	174	189	java/io/IOException
    //   313	319	343	java/io/FileNotFoundException
    //   319	326	343	java/io/FileNotFoundException
    //   331	340	343	java/io/FileNotFoundException
    //   445	462	343	java/io/FileNotFoundException
    //   376	381	382	java/io/IOException
    //   475	480	481	java/io/IOException
    //   466	470	487	java/io/IOException
    //   367	371	495	java/io/IOException
    //   14	52	503	java/io/IOException
    //   52	150	503	java/io/IOException
    //   195	204	503	java/io/IOException
    //   541	546	547	java/io/IOException
    //   532	536	553	java/io/IOException
    //   14	52	561	finally
    //   52	150	561	finally
    //   195	204	561	finally
    //   569	573	586	java/io/IOException
    //   578	583	594	java/io/IOException
    //   211	239	602	finally
    //   246	258	602	finally
    //   265	273	602	finally
    //   280	286	602	finally
    //   293	313	602	finally
    //   395	402	602	finally
    //   414	418	602	finally
    //   430	438	602	finally
    //   518	528	602	finally
    //   313	319	610	finally
    //   319	326	610	finally
    //   331	340	610	finally
    //   445	462	610	finally
    //   353	363	623	finally
    //   211	239	628	java/io/IOException
    //   246	258	628	java/io/IOException
    //   265	273	628	java/io/IOException
    //   280	286	628	java/io/IOException
    //   293	313	628	java/io/IOException
    //   395	402	628	java/io/IOException
    //   414	418	628	java/io/IOException
    //   430	438	628	java/io/IOException
    //   313	319	637	java/io/IOException
    //   319	326	637	java/io/IOException
    //   331	340	637	java/io/IOException
    //   445	462	637	java/io/IOException
    //   14	52	642	java/io/FileNotFoundException
    //   52	150	642	java/io/FileNotFoundException
    //   195	204	642	java/io/FileNotFoundException
    //   211	239	653	java/io/FileNotFoundException
    //   246	258	653	java/io/FileNotFoundException
    //   265	273	653	java/io/FileNotFoundException
    //   280	286	653	java/io/FileNotFoundException
    //   293	313	653	java/io/FileNotFoundException
    //   395	402	653	java/io/FileNotFoundException
    //   414	418	653	java/io/FileNotFoundException
    //   430	438	653	java/io/FileNotFoundException
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
    }
    paramMessage = (String)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage))
    {
      c(paramMessage);
      return true;
    }
    QLog.e("LogcatUtil", 1, "private fileName is null");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.logcat.LogcatUtil
 * JD-Core Version:    0.7.0.1
 */