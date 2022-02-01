package com.tencent.mobileqq.activity.springfestival.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class SpringFestivalRedpacketConfProcessor
{
  private volatile SpringFestivalRedpacketPopBannerConfBean jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketPopBannerConfBean;
  private volatile EntryConfigBean jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public SpringFestivalRedpacketConfProcessor(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private EntryConfigBean a(int paramInt1, int paramInt2, int paramInt3, String paramString, List<Integer> paramList, SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 2, String.format("handleGetEntryConfig ver=%d pVer=%d delayList=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), a(paramList) }));
    }
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramString != null)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = new EntryConfigBean();
        try
        {
          paramString.parseJson((JSONObject)localObject1);
          paramString.onGetPopBannerConfig(paramSpringFestivalRedpacketPopBannerConfBean);
          paramString.validate();
        }
        catch (Exception paramSpringFestivalRedpacketPopBannerConfBean) {}catch (JSONException paramSpringFestivalRedpacketPopBannerConfBean) {}
        SpringHbMonitorReporter.a(308, paramSpringFestivalRedpacketPopBannerConfBean, new String[0]);
      }
      catch (Exception paramSpringFestivalRedpacketPopBannerConfBean)
      {
        paramString = localObject2;
        SpringHbMonitorReporter.a(309, paramSpringFestivalRedpacketPopBannerConfBean, new String[0]);
        QLog.d("shua2021_SpringFestivalRedpacketConfProcessor", 1, paramSpringFestivalRedpacketPopBannerConfBean.getMessage(), paramSpringFestivalRedpacketPopBannerConfBean);
      }
      catch (JSONException paramSpringFestivalRedpacketPopBannerConfBean)
      {
        paramString = localObject3;
      }
      QLog.d("shua2021_SpringFestivalRedpacketConfProcessor", 1, paramSpringFestivalRedpacketPopBannerConfBean.getMessage(), paramSpringFestivalRedpacketPopBannerConfBean);
      localObject1 = paramString;
      if (paramString != null)
      {
        paramString.version = paramInt1;
        paramString.taskId = paramInt3;
        paramString.peakVersion = paramInt2;
        paramString.delayList.clear();
        localObject1 = paramString;
        if (paramList != null)
        {
          paramString.delayList.addAll(paramList);
          localObject1 = paramString;
        }
      }
    }
    return localObject1;
  }
  
  @Nullable
  private EntryConfigBean a(SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    QLog.d("shua2021_SpringFestivalRedpacketConfProcessor", 1, "handleEmptyOrExceptionConfig !!!");
    if ((paramSpringFestivalRedpacketPopBannerConfBean != null) && (!paramSpringFestivalRedpacketPopBannerConfBean.a()))
    {
      EntryConfigBean localEntryConfigBean = new EntryConfigBean();
      localEntryConfigBean.onGetPopBannerConfig(paramSpringFestivalRedpacketPopBannerConfBean);
      return localEntryConfigBean;
    }
    a();
    return null;
  }
  
  private EntryConfigBean a(EntryConfigBean paramEntryConfigBean, int paramInt, List<Integer> paramList)
  {
    if (paramEntryConfigBean == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 2, String.format("handleUpdatePeakDelay pVer=%d delayList=%s", new Object[] { Integer.valueOf(paramInt), a(paramList) }));
    }
    if (paramEntryConfigBean != null)
    {
      paramEntryConfigBean.peakVersion = paramInt;
      paramEntryConfigBean.delayList.clear();
      if (paramList != null) {
        paramEntryConfigBean.delayList.addAll(paramList);
      }
    }
    return paramEntryConfigBean;
  }
  
  private String a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("config_md5_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = ((Context)localObject1).getSharedPreferences("spring_festival_redpacket2021_entry_config_sp", 0).getString((String)localObject2, "");
      return localObject1;
    }
    catch (Exception localException)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "getLocalConfigMD5FromSP fail.", localException);
    }
    return null;
  }
  
  private String a(List<Integer> paramList)
  {
    if (paramList == null) {
      return "null";
    }
    return Arrays.toString(paramList.toArray());
  }
  
  private void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("spring_festival_redpacket2021_entry_config_");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject1 = ((StringBuilder)localObject1).toString();
        QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 1, String.format("deleteLocalEntryConfig fileName=%s", new Object[] { localObject1 }));
        localObject1 = BaseApplicationImpl.getContext().getFileStreamPath((String)localObject1);
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        a(0, 0, "");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "deleteLocalEntryConfig fail.", localException);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 1, String.format("saveLocalConfigVersionToSP version=%s peakVersion=%s md5=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    try
    {
      BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("config_version_");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("peak_version_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("config_md5_");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject3 = ((StringBuilder)localObject3).toString();
      localBaseApplication.getSharedPreferences("spring_festival_redpacket2021_entry_config_sp", 0).edit().putInt((String)localObject1, paramInt1).putInt((String)localObject2, paramInt2).putString((String)localObject3, paramString).apply();
      return;
    }
    catch (Exception paramString)
    {
      SpringHbMonitorReporter.a(311, paramString, new String[0]);
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "saveLocalConfigInfoToSP fail.", paramString);
    }
  }
  
  private void a(EntryConfigBean paramEntryConfigBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean = paramEntryConfigBean;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    if (localSpringFestivalEntryManager != null) {
      localSpringFestivalEntryManager.a(paramEntryConfigBean);
    }
  }
  
  /* Error */
  private void b(EntryConfigBean paramEntryConfigBean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   21: astore_2
    //   22: new 136	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   29: astore 5
    //   31: aload 5
    //   33: ldc 184
    //   35: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 5
    //   41: aload_2
    //   42: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_2
    //   52: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: aload_2
    //   56: invokevirtual 197	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   59: astore 6
    //   61: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   64: astore 5
    //   66: new 136	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   73: astore 8
    //   75: aload 8
    //   77: aload_2
    //   78: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 8
    //   84: ldc_w 257
    //   87: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 5
    //   93: aload 8
    //   95: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 197	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   101: astore 8
    //   103: ldc 32
    //   105: iconst_1
    //   106: ldc_w 259
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   120: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 8
    //   125: invokevirtual 202	java/io/File:exists	()Z
    //   128: ifeq +9 -> 137
    //   131: aload 8
    //   133: invokevirtual 205	java/io/File:delete	()Z
    //   136: pop
    //   137: aload 8
    //   139: invokevirtual 262	java/io/File:createNewFile	()Z
    //   142: pop
    //   143: new 264	java/io/FileOutputStream
    //   146: dup
    //   147: aload 8
    //   149: invokespecial 267	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   152: astore 5
    //   154: new 269	java/io/BufferedOutputStream
    //   157: dup
    //   158: aload 5
    //   160: invokespecial 272	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   163: astore_3
    //   164: new 274	java/io/ObjectOutputStream
    //   167: dup
    //   168: aload_3
    //   169: invokespecial 275	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   172: astore_2
    //   173: aload_2
    //   174: aload_1
    //   175: invokevirtual 279	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   178: aload_2
    //   179: invokevirtual 282	java/io/ObjectOutputStream:flush	()V
    //   182: aload 5
    //   184: invokevirtual 283	java/io/FileOutputStream:flush	()V
    //   187: aload 6
    //   189: invokevirtual 202	java/io/File:exists	()Z
    //   192: ifeq +9 -> 201
    //   195: aload 6
    //   197: invokevirtual 205	java/io/File:delete	()Z
    //   200: pop
    //   201: aload 8
    //   203: aload 6
    //   205: invokevirtual 287	java/io/File:renameTo	(Ljava/io/File;)Z
    //   208: pop
    //   209: aload 6
    //   211: invokevirtual 290	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   214: invokestatic 296	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 4
    //   219: aload_0
    //   220: aload_1
    //   221: getfield 90	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:version	I
    //   224: aload_1
    //   225: getfield 96	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:peakVersion	I
    //   228: aload 4
    //   230: invokespecial 208	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(IILjava/lang/String;)V
    //   233: aload 5
    //   235: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   238: aload_3
    //   239: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   242: aload_2
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 301	java/io/ObjectOutputStream:close	()V
    //   248: goto +142 -> 390
    //   251: astore 4
    //   253: aload_2
    //   254: astore_1
    //   255: aload 4
    //   257: astore_2
    //   258: goto +36 -> 294
    //   261: astore 6
    //   263: aload_3
    //   264: astore 4
    //   266: aload_2
    //   267: astore_1
    //   268: aload 6
    //   270: astore_2
    //   271: goto +40 -> 311
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_1
    //   277: goto +17 -> 294
    //   280: astore_2
    //   281: aconst_null
    //   282: astore_1
    //   283: aload_3
    //   284: astore 4
    //   286: goto +25 -> 311
    //   289: astore_2
    //   290: aconst_null
    //   291: astore_3
    //   292: aload_3
    //   293: astore_1
    //   294: aload 5
    //   296: astore 4
    //   298: aload_3
    //   299: astore 5
    //   301: goto +101 -> 402
    //   304: astore_2
    //   305: aconst_null
    //   306: astore 4
    //   308: aload 4
    //   310: astore_1
    //   311: aload 5
    //   313: astore_3
    //   314: goto +20 -> 334
    //   317: astore_2
    //   318: aconst_null
    //   319: astore 5
    //   321: aload 5
    //   323: astore_1
    //   324: goto +78 -> 402
    //   327: astore_2
    //   328: aconst_null
    //   329: astore 4
    //   331: aload 4
    //   333: astore_1
    //   334: sipush 310
    //   337: aload_2
    //   338: iconst_0
    //   339: anewarray 45	java/lang/String
    //   342: invokestatic 77	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   345: ldc 32
    //   347: iconst_1
    //   348: ldc_w 303
    //   351: aload_2
    //   352: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   355: aload_0
    //   356: invokespecial 123	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()V
    //   359: aload_3
    //   360: ifnull +10 -> 370
    //   363: aload_3
    //   364: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   367: goto +3 -> 370
    //   370: aload 4
    //   372: ifnull +11 -> 383
    //   375: aload 4
    //   377: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   380: goto +3 -> 383
    //   383: aload_1
    //   384: ifnull +6 -> 390
    //   387: goto -143 -> 244
    //   390: aload 7
    //   392: monitorexit
    //   393: return
    //   394: astore_2
    //   395: aload 4
    //   397: astore 5
    //   399: aload_3
    //   400: astore 4
    //   402: aload 4
    //   404: ifnull +15 -> 419
    //   407: aload 4
    //   409: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   412: goto +7 -> 419
    //   415: astore_1
    //   416: goto +26 -> 442
    //   419: aload 5
    //   421: ifnull +11 -> 432
    //   424: aload 5
    //   426: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   429: goto +3 -> 432
    //   432: aload_1
    //   433: ifnull +7 -> 440
    //   436: aload_1
    //   437: invokevirtual 301	java/io/ObjectOutputStream:close	()V
    //   440: aload_2
    //   441: athrow
    //   442: aload 7
    //   444: monitorexit
    //   445: goto +5 -> 450
    //   448: aload_1
    //   449: athrow
    //   450: goto -2 -> 448
    //   453: astore_1
    //   454: goto -216 -> 238
    //   457: astore_1
    //   458: aload_2
    //   459: astore_1
    //   460: goto -216 -> 244
    //   463: astore_1
    //   464: goto -74 -> 390
    //   467: astore_2
    //   468: goto -98 -> 370
    //   471: astore_2
    //   472: goto -89 -> 383
    //   475: astore_3
    //   476: goto -57 -> 419
    //   479: astore_3
    //   480: goto -48 -> 432
    //   483: astore_1
    //   484: goto -44 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	SpringFestivalRedpacketConfProcessor
    //   0	487	1	paramEntryConfigBean	EntryConfigBean
    //   21	250	2	localObject1	Object
    //   274	1	2	localObject2	Object
    //   280	1	2	localException1	Exception
    //   289	1	2	localObject3	Object
    //   304	1	2	localException2	Exception
    //   317	1	2	localObject4	Object
    //   327	25	2	localException3	Exception
    //   394	65	2	localObject5	Object
    //   467	1	2	localException4	Exception
    //   471	1	2	localException5	Exception
    //   13	387	3	localObject6	Object
    //   475	1	3	localException6	Exception
    //   479	1	3	localException7	Exception
    //   10	219	4	str	String
    //   251	5	4	localObject7	Object
    //   264	144	4	localObject8	Object
    //   29	396	5	localObject9	Object
    //   59	151	6	localFile	File
    //   261	8	6	localException8	Exception
    //   4	439	7	arrayOfByte	byte[]
    //   73	129	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   173	201	251	finally
    //   201	233	251	finally
    //   173	201	261	java/lang/Exception
    //   201	233	261	java/lang/Exception
    //   164	173	274	finally
    //   164	173	280	java/lang/Exception
    //   154	164	289	finally
    //   154	164	304	java/lang/Exception
    //   14	137	317	finally
    //   137	154	317	finally
    //   14	137	327	java/lang/Exception
    //   137	154	327	java/lang/Exception
    //   334	359	394	finally
    //   233	238	415	finally
    //   238	242	415	finally
    //   244	248	415	finally
    //   363	367	415	finally
    //   375	380	415	finally
    //   390	393	415	finally
    //   407	412	415	finally
    //   424	429	415	finally
    //   436	440	415	finally
    //   440	442	415	finally
    //   442	445	415	finally
    //   233	238	453	java/lang/Exception
    //   238	242	457	java/lang/Exception
    //   244	248	463	java/lang/Exception
    //   363	367	467	java/lang/Exception
    //   375	380	471	java/lang/Exception
    //   407	412	475	java/lang/Exception
    //   424	429	479	java/lang/Exception
    //   436	440	483	java/lang/Exception
  }
  
  private int c()
  {
    int j = 0;
    int i = j;
    int k;
    try
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      i = j;
      Object localObject2 = new StringBuilder();
      i = j;
      ((StringBuilder)localObject2).append("config_version_");
      i = j;
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      i = j;
      localObject2 = ((StringBuilder)localObject2).toString();
      i = j;
      j = ((Context)localObject1).getSharedPreferences("spring_festival_redpacket2021_entry_config_sp", 0).getInt((String)localObject2, 0);
      i = j;
      k = j;
      if (QLog.isColorLevel())
      {
        i = j;
        localObject1 = new StringBuilder();
        i = j;
        ((StringBuilder)localObject1).append("getLocalConfigVersionFromSP version: ");
        i = j;
        ((StringBuilder)localObject1).append(j);
        i = j;
        QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 2, ((StringBuilder)localObject1).toString());
        return j;
      }
    }
    catch (Exception localException)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "getLocalConfigVersionFromSP fail.", localException);
      k = i;
    }
    return k;
  }
  
  private EntryConfigBean c()
  {
    try
    {
      EntryConfigBean localEntryConfigBean = d();
      return localEntryConfigBean;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "loadLocalEntryConfigQuiet load local config ex.", localThrowable);
    }
    return null;
  }
  
  /* Error */
  private EntryConfigBean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore_3
    //   17: new 136	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc 184
    //   28: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 7
    //   50: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   53: aload 7
    //   55: invokevirtual 197	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 202	java/io/File:exists	()Z
    //   63: ifeq +146 -> 209
    //   66: aload_0
    //   67: invokespecial 325	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()Ljava/lang/String;
    //   70: aload_1
    //   71: invokevirtual 290	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: invokestatic 296	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 331	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   80: ifeq +116 -> 196
    //   83: new 333	java/io/FileInputStream
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 334	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_1
    //   92: new 336	java/io/BufferedInputStream
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 339	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore_2
    //   101: new 341	java/io/ObjectInputStream
    //   104: dup
    //   105: aload_2
    //   106: invokespecial 342	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: astore 4
    //   111: aload 4
    //   113: invokevirtual 346	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   116: checkcast 60	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean
    //   119: astore_3
    //   120: aload 4
    //   122: astore 5
    //   124: aload_2
    //   125: astore 4
    //   127: aload_3
    //   128: astore_2
    //   129: goto +91 -> 220
    //   132: astore_3
    //   133: aload_1
    //   134: astore 5
    //   136: goto +226 -> 362
    //   139: astore_3
    //   140: aload_2
    //   141: astore 5
    //   143: aload 4
    //   145: astore_2
    //   146: goto +41 -> 187
    //   149: astore_3
    //   150: aload 5
    //   152: astore 4
    //   154: goto +211 -> 365
    //   157: astore_3
    //   158: aconst_null
    //   159: astore 4
    //   161: aload_2
    //   162: astore 5
    //   164: aload 4
    //   166: astore_2
    //   167: goto +20 -> 187
    //   170: astore_3
    //   171: aconst_null
    //   172: astore_2
    //   173: aload 5
    //   175: astore 4
    //   177: goto +188 -> 365
    //   180: astore_3
    //   181: aconst_null
    //   182: astore 5
    //   184: aload 5
    //   186: astore_2
    //   187: aload_1
    //   188: astore 4
    //   190: aload 5
    //   192: astore_1
    //   193: goto +104 -> 297
    //   196: ldc 32
    //   198: iconst_1
    //   199: ldc_w 348
    //   202: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: invokespecial 123	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()V
    //   209: aconst_null
    //   210: astore 4
    //   212: aload 4
    //   214: astore_1
    //   215: aload_1
    //   216: astore_2
    //   217: aload_3
    //   218: astore 5
    //   220: aload 5
    //   222: ifnull +11 -> 233
    //   225: aload 5
    //   227: invokevirtual 351	java/io/ObjectInputStream:close	()V
    //   230: goto +3 -> 233
    //   233: aload 4
    //   235: ifnull +11 -> 246
    //   238: aload 4
    //   240: invokevirtual 352	java/io/BufferedInputStream:close	()V
    //   243: goto +3 -> 246
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 353	java/io/FileInputStream:close	()V
    //   254: ldc 32
    //   256: iconst_1
    //   257: ldc_w 355
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 7
    //   268: aastore
    //   269: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   272: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload 6
    //   277: monitorexit
    //   278: aload_2
    //   279: areturn
    //   280: astore_3
    //   281: aconst_null
    //   282: astore_2
    //   283: aload_2
    //   284: astore_1
    //   285: aload 5
    //   287: astore 4
    //   289: goto +76 -> 365
    //   292: astore_3
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_1
    //   296: astore_2
    //   297: ldc 32
    //   299: iconst_1
    //   300: ldc_w 357
    //   303: aload_3
    //   304: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload_0
    //   308: invokespecial 123	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()V
    //   311: new 136	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   318: astore 5
    //   320: aload 5
    //   322: ldc_w 359
    //   325: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 5
    //   331: aload_3
    //   332: invokevirtual 81	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: new 361	java/lang/RuntimeException
    //   342: dup
    //   343: aload 5
    //   345: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokespecial 362	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   351: athrow
    //   352: astore_3
    //   353: aload 4
    //   355: astore 5
    //   357: aload_2
    //   358: astore 4
    //   360: aload_1
    //   361: astore_2
    //   362: aload 5
    //   364: astore_1
    //   365: aload 4
    //   367: ifnull +15 -> 382
    //   370: aload 4
    //   372: invokevirtual 351	java/io/ObjectInputStream:close	()V
    //   375: goto +7 -> 382
    //   378: astore_1
    //   379: goto +24 -> 403
    //   382: aload_2
    //   383: ifnull +10 -> 393
    //   386: aload_2
    //   387: invokevirtual 352	java/io/BufferedInputStream:close	()V
    //   390: goto +3 -> 393
    //   393: aload_1
    //   394: ifnull +7 -> 401
    //   397: aload_1
    //   398: invokevirtual 353	java/io/FileInputStream:close	()V
    //   401: aload_3
    //   402: athrow
    //   403: aload 6
    //   405: monitorexit
    //   406: aload_1
    //   407: athrow
    //   408: astore_3
    //   409: goto -176 -> 233
    //   412: astore_3
    //   413: goto -167 -> 246
    //   416: astore_1
    //   417: goto -163 -> 254
    //   420: astore 4
    //   422: goto -40 -> 382
    //   425: astore_2
    //   426: goto -33 -> 393
    //   429: astore_1
    //   430: goto -29 -> 401
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	SpringFestivalRedpacketConfProcessor
    //   24	341	1	localObject1	Object
    //   378	29	1	localObject2	Object
    //   416	1	1	localException1	Exception
    //   429	1	1	localException2	Exception
    //   100	287	2	localObject3	Object
    //   425	1	2	localException3	Exception
    //   16	112	3	localEntryConfigBean	EntryConfigBean
    //   132	1	3	localObject4	Object
    //   139	1	3	localException4	Exception
    //   149	1	3	localObject5	Object
    //   157	1	3	localException5	Exception
    //   170	1	3	localObject6	Object
    //   180	38	3	localException6	Exception
    //   280	1	3	localObject7	Object
    //   292	40	3	localException7	Exception
    //   352	50	3	localObject8	Object
    //   408	1	3	localException8	Exception
    //   412	1	3	localException9	Exception
    //   10	361	4	localObject9	Object
    //   420	1	4	localException10	Exception
    //   13	350	5	localObject10	Object
    //   4	400	6	arrayOfByte	byte[]
    //   48	219	7	str	String
    // Exception table:
    //   from	to	target	type
    //   111	120	132	finally
    //   111	120	139	java/lang/Exception
    //   101	111	149	finally
    //   101	111	157	java/lang/Exception
    //   92	101	170	finally
    //   92	101	180	java/lang/Exception
    //   17	92	280	finally
    //   196	209	280	finally
    //   17	92	292	java/lang/Exception
    //   196	209	292	java/lang/Exception
    //   297	352	352	finally
    //   225	230	378	finally
    //   238	243	378	finally
    //   250	254	378	finally
    //   254	278	378	finally
    //   370	375	378	finally
    //   386	390	378	finally
    //   397	401	378	finally
    //   401	403	378	finally
    //   403	406	378	finally
    //   225	230	408	java/lang/Exception
    //   238	243	412	java/lang/Exception
    //   250	254	416	java/lang/Exception
    //   370	375	420	java/lang/Exception
    //   386	390	425	java/lang/Exception
    //   397	401	429	java/lang/Exception
  }
  
  public int a()
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.version;
    }
    return c();
  }
  
  public SpringFestivalRedpacketPopBannerConfBean a()
  {
    return a(true);
  }
  
  public SpringFestivalRedpacketPopBannerConfBean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketPopBannerConfBean == null) && (paramBoolean)) {
      try
      {
        SpringFestivalRedpacketPopBannerConfBean localSpringFestivalRedpacketPopBannerConfBean = (SpringFestivalRedpacketPopBannerConfBean)QConfigManager.a().a(723);
        if (localSpringFestivalRedpacketPopBannerConfBean != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketPopBannerConfBean = localSpringFestivalRedpacketPopBannerConfBean;
        }
      }
      catch (Exception localException)
      {
        SpringHbMonitorReporter.a(306, localException, new String[0]);
        QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "getLocalPopBannerConfig fail.", localException);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketPopBannerConfBean;
  }
  
  public EntryConfigBean a()
  {
    return a(true);
  }
  
  public EntryConfigBean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean == null) && (paramBoolean)) {
      try
      {
        EntryConfigBean localEntryConfigBean = d();
        if (localEntryConfigBean != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean = localEntryConfigBean;
        }
      }
      catch (Exception localException)
      {
        SpringHbMonitorReporter.a(305, localException, new String[0]);
        QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "getLocalEntryConfig fail.", localException);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
  }
  
  public void a(int paramInt, SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    try
    {
      QLog.d("shua2021_SpringFestivalRedpacketConfProcessor", 1, String.format("onGetPopBannerConfig() ver=%d", new Object[] { Integer.valueOf(paramInt) }));
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketPopBannerConfBean = paramSpringFestivalRedpacketPopBannerConfBean;
      EntryConfigBean localEntryConfigBean2 = c();
      EntryConfigBean localEntryConfigBean1 = localEntryConfigBean2;
      if (localEntryConfigBean2 == null)
      {
        localEntryConfigBean1 = localEntryConfigBean2;
        if (paramSpringFestivalRedpacketPopBannerConfBean != null)
        {
          localEntryConfigBean1 = localEntryConfigBean2;
          if (!paramSpringFestivalRedpacketPopBannerConfBean.a()) {
            localEntryConfigBean1 = new EntryConfigBean();
          }
        }
      }
      if (localEntryConfigBean1 != null)
      {
        localEntryConfigBean1.onGetPopBannerConfig(paramSpringFestivalRedpacketPopBannerConfBean);
        b(localEntryConfigBean1);
        a(localEntryConfigBean1);
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 1, String.format("saveLastReqAdcodeToSP adcode=%s", new Object[] { Long.valueOf(paramLong) }));
    try
    {
      BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_req_adcode_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      localBaseApplication.getSharedPreferences("spring_festival_redpacket2021_entry_config_sp", 0).edit().putLong((String)localObject, paramLong).apply();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "saveLastReqAdcodeToSP fail.", localException);
    }
  }
  
  /* Error */
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString, List<Integer> paramList, int paramInt4, boolean paramBoolean3, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 14
    //   5: aconst_null
    //   6: astore 15
    //   8: iconst_0
    //   9: istore 12
    //   11: aload 14
    //   13: astore 13
    //   15: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +28 -> 46
    //   21: aload 14
    //   23: astore 13
    //   25: ldc 32
    //   27: iconst_2
    //   28: ldc_w 414
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload 6
    //   39: aastore
    //   40: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload 14
    //   48: astore 13
    //   50: aload_0
    //   51: invokespecial 392	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:c	()Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   54: astore 14
    //   56: aload 14
    //   58: ifnonnull +10 -> 68
    //   61: aload 15
    //   63: astore 13
    //   65: goto +10 -> 75
    //   68: aload 14
    //   70: getfield 100	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:delayList	Ljava/util/List;
    //   73: astore 13
    //   75: aload_0
    //   76: invokevirtual 416	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;
    //   79: astore 15
    //   81: ldc 32
    //   83: iconst_1
    //   84: ldc_w 418
    //   87: bipush 10
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload_1
    //   95: invokestatic 423	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_3
    //   102: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: iload_2
    //   109: invokestatic 423	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   112: aastore
    //   113: dup
    //   114: iconst_3
    //   115: iload 4
    //   117: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_4
    //   123: iload 5
    //   125: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: dup
    //   130: iconst_5
    //   131: iload 8
    //   133: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: aastore
    //   137: dup
    //   138: bipush 6
    //   140: aload_0
    //   141: aload 7
    //   143: invokespecial 43	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Ljava/util/List;)Ljava/lang/String;
    //   146: aastore
    //   147: dup
    //   148: bipush 7
    //   150: aload_0
    //   151: aload 13
    //   153: invokespecial 43	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Ljava/util/List;)Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: bipush 8
    //   160: iload 9
    //   162: invokestatic 423	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   165: aastore
    //   166: dup
    //   167: bipush 9
    //   169: lload 10
    //   171: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: aastore
    //   175: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +24 -> 208
    //   187: ldc 32
    //   189: iconst_2
    //   190: ldc_w 425
    //   193: iconst_1
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 15
    //   201: aastore
    //   202: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: iload 9
    //   210: ifeq +9 -> 219
    //   213: aload_0
    //   214: lload 10
    //   216: invokevirtual 427	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(J)V
    //   219: iload_1
    //   220: ifeq +83 -> 303
    //   223: aload 6
    //   225: invokestatic 431	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifeq +258 -> 486
    //   231: aload_0
    //   232: aload 15
    //   234: invokespecial 433	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   237: astore 6
    //   239: goto +242 -> 481
    //   242: aload_0
    //   243: iload_3
    //   244: iload 4
    //   246: iload 5
    //   248: aload 6
    //   250: aload 7
    //   252: aload 15
    //   254: invokespecial 435	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(IIILjava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   257: astore 6
    //   259: aload 6
    //   261: ifnonnull +33 -> 294
    //   264: aload 6
    //   266: astore 13
    //   268: ldc 32
    //   270: iconst_1
    //   271: ldc_w 437
    //   274: invokestatic 350	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: aload 6
    //   279: astore 13
    //   281: aload_0
    //   282: aload 15
    //   284: invokespecial 433	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   287: astore 6
    //   289: iconst_0
    //   290: istore_1
    //   291: goto +6 -> 297
    //   294: goto +187 -> 481
    //   297: iconst_1
    //   298: istore 4
    //   300: goto +33 -> 333
    //   303: iload_2
    //   304: ifeq +20 -> 324
    //   307: aload_0
    //   308: aload 14
    //   310: iload 4
    //   312: aload 7
    //   314: invokespecial 439	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;ILjava/util/List;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   317: pop
    //   318: iconst_1
    //   319: istore 4
    //   321: goto +6 -> 327
    //   324: iconst_0
    //   325: istore 4
    //   327: aload 14
    //   329: astore 6
    //   331: iconst_1
    //   332: istore_1
    //   333: aload 6
    //   335: ifnull +18 -> 353
    //   338: iload 4
    //   340: ifeq +13 -> 353
    //   343: aload 6
    //   345: astore 13
    //   347: aload_0
    //   348: aload 6
    //   350: invokespecial 394	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:b	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;)V
    //   353: goto +80 -> 433
    //   356: astore 6
    //   358: aload 14
    //   360: astore 13
    //   362: goto +10 -> 372
    //   365: astore 6
    //   367: goto +103 -> 470
    //   370: astore 6
    //   372: sipush 307
    //   375: aload 6
    //   377: iconst_0
    //   378: anewarray 45	java/lang/String
    //   381: invokestatic 77	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   384: new 136	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   391: astore 7
    //   393: aload 7
    //   395: ldc_w 441
    //   398: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 7
    //   404: aload 6
    //   406: invokevirtual 81	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc 32
    //   415: iconst_1
    //   416: aload 7
    //   418: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: aload 6
    //   423: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   426: iload 12
    //   428: istore_1
    //   429: aload 13
    //   431: astore 6
    //   433: aload_0
    //   434: aload 6
    //   436: invokespecial 395	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;)V
    //   439: aload 6
    //   441: ifnull +25 -> 466
    //   444: aload 6
    //   446: getfield 445	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:htmlOfflineCheckConfig	Lcom/tencent/mobileqq/activity/springfestival/entry/model/HtmlOfflineCheckConfig;
    //   449: ifnull +17 -> 466
    //   452: aload 6
    //   454: getfield 445	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:htmlOfflineCheckConfig	Lcom/tencent/mobileqq/activity/springfestival/entry/model/HtmlOfflineCheckConfig;
    //   457: getfield 451	com/tencent/mobileqq/activity/springfestival/entry/model/HtmlOfflineCheckConfig:bids	Ljava/lang/String;
    //   460: iload 5
    //   462: iload_3
    //   463: invokestatic 454	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:b	(Ljava/lang/String;II)V
    //   466: aload_0
    //   467: monitorexit
    //   468: iload_1
    //   469: ireturn
    //   470: aload_0
    //   471: monitorexit
    //   472: goto +6 -> 478
    //   475: aload 6
    //   477: athrow
    //   478: goto -3 -> 475
    //   481: iconst_1
    //   482: istore_1
    //   483: goto -186 -> 297
    //   486: iload_2
    //   487: ifeq +6 -> 493
    //   490: goto -248 -> 242
    //   493: aload 13
    //   495: astore 7
    //   497: goto -255 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	SpringFestivalRedpacketConfProcessor
    //   0	500	1	paramBoolean1	boolean
    //   0	500	2	paramBoolean2	boolean
    //   0	500	3	paramInt1	int
    //   0	500	4	paramInt2	int
    //   0	500	5	paramInt3	int
    //   0	500	6	paramString	String
    //   0	500	7	paramList	List<Integer>
    //   0	500	8	paramInt4	int
    //   0	500	9	paramBoolean3	boolean
    //   0	500	10	paramLong	long
    //   9	418	12	bool	boolean
    //   13	481	13	localObject	Object
    //   3	356	14	localEntryConfigBean	EntryConfigBean
    //   6	277	15	localSpringFestivalRedpacketPopBannerConfBean	SpringFestivalRedpacketPopBannerConfBean
    // Exception table:
    //   from	to	target	type
    //   68	75	356	java/lang/Exception
    //   75	208	356	java/lang/Exception
    //   213	219	356	java/lang/Exception
    //   223	239	356	java/lang/Exception
    //   242	259	356	java/lang/Exception
    //   307	318	356	java/lang/Exception
    //   15	21	365	finally
    //   25	46	365	finally
    //   50	56	365	finally
    //   68	75	365	finally
    //   75	208	365	finally
    //   213	219	365	finally
    //   223	239	365	finally
    //   242	259	365	finally
    //   268	277	365	finally
    //   281	289	365	finally
    //   307	318	365	finally
    //   347	353	365	finally
    //   372	426	365	finally
    //   433	439	365	finally
    //   444	466	365	finally
    //   15	21	370	java/lang/Exception
    //   25	46	370	java/lang/Exception
    //   50	56	370	java/lang/Exception
    //   268	277	370	java/lang/Exception
    //   281	289	370	java/lang/Exception
    //   347	353	370	java/lang/Exception
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.taskId;
    }
    return 0;
  }
  
  public EntryConfigBean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfProcessor
 * JD-Core Version:    0.7.0.1
 */