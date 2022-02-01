package com.tencent.logcat;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.ThreadTraceHelper;
import java.io.File;
import java.io.IOException;

public class LogcatUtil
  implements Handler.Callback
{
  private static LogcatUtil jdField_a_of_type_ComTencentLogcatLogcatUtil = new LogcatUtil();
  private static final String jdField_a_of_type_JavaLangString;
  private static final String b;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  LogcatUtil.LogcatThread jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/tencent/MobileQQ/log/logcat");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/tencent/MobileQQ/private");
    b = localStringBuilder.toString();
  }
  
  private static void a()
  {
    QLog.e("LogcatUtil", 1, "get trace file begin");
    String str3 = ThreadTraceHelper.a(String.valueOf(100));
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("AdditionInfo:0|");
    String str2;
    try
    {
      BaseApplicationImpl.getApplication().getPackageManager();
      String str1 = ((QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null)).getAccount();
    }
    catch (Exception localException)
    {
      QLog.e("LogcatUtil", 1, "Exeption ", localException);
      str2 = "";
    }
    localStringBuilder.append(str2);
    localStringBuilder.append("|");
    localStringBuilder.append("");
    localStringBuilder.append("|");
    localStringBuilder.append("|");
    localStringBuilder.append("pub");
    localStringBuilder.append("|");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("|");
    localStringBuilder.append(100);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    int i = ThreadTraceHelper.a(BaseApplicationImpl.getContext(), str3, localStringBuilder.toString());
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.e("LogcatUtil", 1, new Object[] { "get trace file fileName = ", str3, ",get system trace status=", Boolean.valueOf(bool) });
    if (i != 1) {
      bool = ThreadTraceHelper.a(str3, localStringBuilder.toString());
    } else {
      bool = false;
    }
    QLog.e("LogcatUtil", 1, new Object[] { "get trace file fileName = ", str3, ",get java trace status=", Boolean.valueOf(bool) });
  }
  
  private static void a(File paramFile)
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isDirectory())
      {
        a(localFile);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("private file path :");
        localStringBuilder.append(localFile.getAbsolutePath());
        QLog.d("LogcatUtil", 1, localStringBuilder.toString());
      }
      i += 1;
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      LogcatUtil localLogcatUtil = jdField_a_of_type_ComTencentLogcatLogcatUtil;
      if ((localLogcatUtil != null) && (localLogcatUtil.a(paramString))) {
        jdField_a_of_type_ComTencentLogcatLogcatUtil.b(paramString);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString.equals("$logcat start")) || (paramString.equals("$logcat stop")) || (paramString.equals("$list private files")) || (paramString.startsWith("$get private file ")) || (paramString.startsWith("$get trace file"));
  }
  
  private void b(String paramString)
  {
    if (paramString.equals("$logcat start"))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
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
      paramString = paramString.substring(18);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("private fileName :");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("LogcatUtil", 1, ((StringBuilder)localObject).toString());
      localObject = Message.obtain();
      ((Message)localObject).obj = paramString;
      ((Message)localObject).what = 4;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    if (paramString.equals("$get trace file")) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
  }
  
  /* Error */
  private void c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: getstatic 245	java/io/File:separator	Ljava/lang/String;
    //   13: invokevirtual 249	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +583 -> 599
    //   19: aload_1
    //   20: iconst_0
    //   21: aload_1
    //   22: getstatic 245	java/io/File:separator	Ljava/lang/String;
    //   25: invokevirtual 253	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   28: invokevirtual 256	java/lang/String:substring	(II)Ljava/lang/String;
    //   31: pop
    //   32: aload_1
    //   33: aload_1
    //   34: getstatic 245	java/io/File:separator	Ljava/lang/String;
    //   37: invokevirtual 253	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   40: iconst_1
    //   41: iadd
    //   42: invokevirtual 217	java/lang/String:substring	(I)Ljava/lang/String;
    //   45: astore 4
    //   47: goto +3 -> 50
    //   50: invokestatic 148	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   53: invokevirtual 261	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   56: invokevirtual 264	java/io/File:getParentFile	()Ljava/io/File;
    //   59: astore 8
    //   61: new 16	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   68: astore 9
    //   70: aload 9
    //   72: ldc_w 266
    //   75: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 9
    //   81: aload 8
    //   83: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc 68
    //   92: iconst_1
    //   93: aload 9
    //   95: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: new 27	java/io/File
    //   104: dup
    //   105: aload 8
    //   107: aload_1
    //   108: invokespecial 269	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   111: astore_1
    //   112: new 16	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   119: astore 8
    //   121: aload 8
    //   123: ldc_w 271
    //   126: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 8
    //   132: aload_1
    //   133: invokevirtual 31	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   136: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: ldc 68
    //   142: iconst_1
    //   143: aload 8
    //   145: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_1
    //   152: invokevirtual 274	java/io/File:length	()J
    //   155: ldc2_w 275
    //   158: lcmp
    //   159: ifle +13 -> 172
    //   162: ldc 68
    //   164: iconst_1
    //   165: ldc_w 278
    //   168: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: return
    //   172: new 280	java/io/FileInputStream
    //   175: dup
    //   176: aload_1
    //   177: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   180: astore_1
    //   181: new 16	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   188: astore 5
    //   190: aload 5
    //   192: ldc_w 284
    //   195: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: aload_1
    //   202: invokevirtual 288	java/io/FileInputStream:available	()I
    //   205: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: ldc 68
    //   211: iconst_1
    //   212: aload 5
    //   214: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: new 27	java/io/File
    //   223: dup
    //   224: getstatic 46	com/tencent/logcat/LogcatUtil:b	Ljava/lang/String;
    //   227: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   230: astore 5
    //   232: aload 5
    //   234: invokevirtual 293	java/io/File:exists	()Z
    //   237: ifne +12 -> 249
    //   240: aload 5
    //   242: invokevirtual 296	java/io/File:mkdirs	()Z
    //   245: pop
    //   246: goto +41 -> 287
    //   249: aload 5
    //   251: invokevirtual 173	java/io/File:listFiles	()[Ljava/io/File;
    //   254: astore 6
    //   256: aload 6
    //   258: ifnull +29 -> 287
    //   261: aload 6
    //   263: arraylength
    //   264: istore_3
    //   265: iconst_0
    //   266: istore_2
    //   267: iload_2
    //   268: iload_3
    //   269: if_icmpge +18 -> 287
    //   272: aload 6
    //   274: iload_2
    //   275: aaload
    //   276: invokevirtual 299	java/io/File:delete	()Z
    //   279: pop
    //   280: iload_2
    //   281: iconst_1
    //   282: iadd
    //   283: istore_2
    //   284: goto -17 -> 267
    //   287: new 301	java/io/FileOutputStream
    //   290: dup
    //   291: new 27	java/io/File
    //   294: dup
    //   295: aload 5
    //   297: aload 4
    //   299: invokespecial 269	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   302: invokespecial 302	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   305: astore 4
    //   307: ldc_w 303
    //   310: newarray byte
    //   312: astore 5
    //   314: aload_1
    //   315: aload 5
    //   317: invokevirtual 307	java/io/FileInputStream:read	([B)I
    //   320: istore_2
    //   321: iload_2
    //   322: iconst_m1
    //   323: if_icmpeq +15 -> 338
    //   326: aload 4
    //   328: aload 5
    //   330: iconst_0
    //   331: iload_2
    //   332: invokevirtual 311	java/io/FileOutputStream:write	([BII)V
    //   335: goto -21 -> 314
    //   338: aload_1
    //   339: invokevirtual 314	java/io/FileInputStream:close	()V
    //   342: aload 4
    //   344: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   347: ldc 68
    //   349: iconst_1
    //   350: ldc_w 317
    //   353: invokestatic 184	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_1
    //   357: invokevirtual 314	java/io/FileInputStream:close	()V
    //   360: goto +8 -> 368
    //   363: astore_1
    //   364: aload_1
    //   365: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   368: aload 4
    //   370: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   373: return
    //   374: astore 5
    //   376: goto +18 -> 394
    //   379: astore 7
    //   381: goto +61 -> 442
    //   384: astore 7
    //   386: goto +109 -> 495
    //   389: astore 5
    //   391: aconst_null
    //   392: astore 4
    //   394: aload_1
    //   395: astore 6
    //   397: aload 5
    //   399: astore_1
    //   400: aload 6
    //   402: astore 5
    //   404: goto +147 -> 551
    //   407: astore 7
    //   409: aconst_null
    //   410: astore 4
    //   412: goto +30 -> 442
    //   415: astore 7
    //   417: aconst_null
    //   418: astore 4
    //   420: goto +75 -> 495
    //   423: astore_1
    //   424: aconst_null
    //   425: astore 4
    //   427: aload 7
    //   429: astore 5
    //   431: goto +120 -> 551
    //   434: astore 7
    //   436: aconst_null
    //   437: astore 4
    //   439: aload 5
    //   441: astore_1
    //   442: aload_1
    //   443: astore 5
    //   445: aload 4
    //   447: astore 6
    //   449: ldc 68
    //   451: iconst_1
    //   452: ldc_w 322
    //   455: aload 7
    //   457: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   460: aload_1
    //   461: ifnull +15 -> 476
    //   464: aload_1
    //   465: invokevirtual 314	java/io/FileInputStream:close	()V
    //   468: goto +8 -> 476
    //   471: astore_1
    //   472: aload_1
    //   473: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   476: aload 4
    //   478: ifnull +67 -> 545
    //   481: aload 4
    //   483: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   486: return
    //   487: astore 7
    //   489: aconst_null
    //   490: astore 4
    //   492: aload 6
    //   494: astore_1
    //   495: aload_1
    //   496: astore 5
    //   498: aload 4
    //   500: astore 6
    //   502: ldc 68
    //   504: iconst_1
    //   505: ldc_w 322
    //   508: aload 7
    //   510: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   513: aload_1
    //   514: ifnull +15 -> 529
    //   517: aload_1
    //   518: invokevirtual 314	java/io/FileInputStream:close	()V
    //   521: goto +8 -> 529
    //   524: astore_1
    //   525: aload_1
    //   526: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   529: aload 4
    //   531: ifnull +14 -> 545
    //   534: aload 4
    //   536: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   539: return
    //   540: astore_1
    //   541: aload_1
    //   542: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   545: return
    //   546: astore_1
    //   547: aload 6
    //   549: astore 4
    //   551: aload 5
    //   553: ifnull +18 -> 571
    //   556: aload 5
    //   558: invokevirtual 314	java/io/FileInputStream:close	()V
    //   561: goto +10 -> 571
    //   564: astore 5
    //   566: aload 5
    //   568: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   571: aload 4
    //   573: ifnull +18 -> 591
    //   576: aload 4
    //   578: invokevirtual 315	java/io/FileOutputStream:close	()V
    //   581: goto +10 -> 591
    //   584: astore 4
    //   586: aload 4
    //   588: invokevirtual 320	java/io/IOException:printStackTrace	()V
    //   591: goto +5 -> 596
    //   594: aload_1
    //   595: athrow
    //   596: goto -2 -> 594
    //   599: aload_1
    //   600: astore 4
    //   602: goto -552 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	LogcatUtil
    //   0	605	1	paramString	String
    //   266	66	2	i	int
    //   264	6	3	j	int
    //   45	532	4	localObject1	Object
    //   584	3	4	localIOException1	IOException
    //   600	1	4	str	String
    //   7	322	5	localObject2	Object
    //   374	1	5	localObject3	Object
    //   389	9	5	localObject4	Object
    //   402	155	5	localObject5	Object
    //   564	3	5	localIOException2	IOException
    //   1	547	6	localObject6	Object
    //   4	1	7	localObject7	Object
    //   379	1	7	localIOException3	IOException
    //   384	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   407	1	7	localIOException4	IOException
    //   415	13	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   434	22	7	localIOException5	IOException
    //   487	22	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   59	85	8	localObject8	Object
    //   68	26	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   356	360	363	java/io/IOException
    //   307	314	374	finally
    //   314	321	374	finally
    //   326	335	374	finally
    //   338	356	374	finally
    //   307	314	379	java/io/IOException
    //   314	321	379	java/io/IOException
    //   326	335	379	java/io/IOException
    //   338	356	379	java/io/IOException
    //   307	314	384	java/io/FileNotFoundException
    //   314	321	384	java/io/FileNotFoundException
    //   326	335	384	java/io/FileNotFoundException
    //   338	356	384	java/io/FileNotFoundException
    //   181	246	389	finally
    //   249	256	389	finally
    //   261	265	389	finally
    //   272	280	389	finally
    //   287	307	389	finally
    //   181	246	407	java/io/IOException
    //   249	256	407	java/io/IOException
    //   261	265	407	java/io/IOException
    //   272	280	407	java/io/IOException
    //   287	307	407	java/io/IOException
    //   181	246	415	java/io/FileNotFoundException
    //   249	256	415	java/io/FileNotFoundException
    //   261	265	415	java/io/FileNotFoundException
    //   272	280	415	java/io/FileNotFoundException
    //   287	307	415	java/io/FileNotFoundException
    //   9	47	423	finally
    //   50	171	423	finally
    //   172	181	423	finally
    //   9	47	434	java/io/IOException
    //   50	171	434	java/io/IOException
    //   172	181	434	java/io/IOException
    //   464	468	471	java/io/IOException
    //   9	47	487	java/io/FileNotFoundException
    //   50	171	487	java/io/FileNotFoundException
    //   172	181	487	java/io/FileNotFoundException
    //   517	521	524	java/io/IOException
    //   368	373	540	java/io/IOException
    //   481	486	540	java/io/IOException
    //   534	539	540	java/io/IOException
    //   449	460	546	finally
    //   502	513	546	finally
    //   556	561	564	java/io/IOException
    //   576	581	584	java/io/IOException
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return true;
            }
            a();
            return true;
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
        paramMessage = BaseApplicationImpl.getContext().getFilesDir();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("private root file path :");
        localStringBuilder.append(paramMessage.getAbsolutePath());
        QLog.d("LogcatUtil", 1, localStringBuilder.toString());
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
      paramMessage = this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread;
      if (paramMessage != null)
      {
        if (paramMessage.a != null) {
          this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.a.destroy();
        }
        if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.b != null) {
          this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.b.destroy();
        }
        this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread = null;
        return true;
      }
    }
    else if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread == null)
    {
      this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread = new LogcatUtil.LogcatThread();
      this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.start();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.logcat.LogcatUtil
 * JD-Core Version:    0.7.0.1
 */