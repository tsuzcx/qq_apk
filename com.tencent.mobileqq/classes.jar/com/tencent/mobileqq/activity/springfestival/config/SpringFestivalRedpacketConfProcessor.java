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
  private QQAppInterface a;
  private volatile EntryConfigBean b;
  private volatile SpringFestivalRedpacketPopBannerConfBean c;
  private final byte[] d = new byte[0];
  
  public SpringFestivalRedpacketConfProcessor(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
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
    f();
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
  
  private String a(List<Integer> paramList)
  {
    if (paramList == null) {
      return "null";
    }
    return Arrays.toString(paramList.toArray());
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 1, String.format("saveLocalConfigVersionToSP version=%s peakVersion=%s md5=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    try
    {
      BaseApplication localBaseApplication = this.a.getApp();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("config_version_");
      ((StringBuilder)localObject1).append(this.a.getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("peak_version_");
      ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("config_md5_");
      ((StringBuilder)localObject3).append(this.a.getCurrentAccountUin());
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
    this.b = paramEntryConfigBean;
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)this.a.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    if (localSpringFestivalEntryManager != null) {
      localSpringFestivalEntryManager.a(paramEntryConfigBean);
    }
  }
  
  /* Error */
  private void b(EntryConfigBean paramEntryConfigBean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:d	[B
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 21	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   18: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   21: astore_2
    //   22: new 155	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   29: astore 5
    //   31: aload 5
    //   33: ldc 224
    //   35: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 5
    //   41: aload_2
    //   42: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 5
    //   48: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_2
    //   52: invokestatic 229	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: aload_2
    //   56: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   59: astore 6
    //   61: invokestatic 229	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   64: astore 5
    //   66: new 155	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   73: astore 8
    //   75: aload 8
    //   77: aload_2
    //   78: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 8
    //   84: ldc 237
    //   86: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 5
    //   92: aload 8
    //   94: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   100: astore 8
    //   102: ldc 35
    //   104: iconst_1
    //   105: ldc 239
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_2
    //   114: aastore
    //   115: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 8
    //   123: invokevirtual 244	java/io/File:exists	()Z
    //   126: ifeq +9 -> 135
    //   129: aload 8
    //   131: invokevirtual 247	java/io/File:delete	()Z
    //   134: pop
    //   135: aload 8
    //   137: invokevirtual 250	java/io/File:createNewFile	()Z
    //   140: pop
    //   141: new 252	java/io/FileOutputStream
    //   144: dup
    //   145: aload 8
    //   147: invokespecial 255	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   150: astore 5
    //   152: new 257	java/io/BufferedOutputStream
    //   155: dup
    //   156: aload 5
    //   158: invokespecial 260	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   161: astore_3
    //   162: new 262	java/io/ObjectOutputStream
    //   165: dup
    //   166: aload_3
    //   167: invokespecial 263	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   170: astore_2
    //   171: aload_2
    //   172: aload_1
    //   173: invokevirtual 267	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   176: aload_2
    //   177: invokevirtual 270	java/io/ObjectOutputStream:flush	()V
    //   180: aload 5
    //   182: invokevirtual 271	java/io/FileOutputStream:flush	()V
    //   185: aload 6
    //   187: invokevirtual 244	java/io/File:exists	()Z
    //   190: ifeq +9 -> 199
    //   193: aload 6
    //   195: invokevirtual 247	java/io/File:delete	()Z
    //   198: pop
    //   199: aload 8
    //   201: aload 6
    //   203: invokevirtual 275	java/io/File:renameTo	(Ljava/io/File;)Z
    //   206: pop
    //   207: aload 6
    //   209: invokevirtual 278	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   212: invokestatic 284	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore 4
    //   217: aload_0
    //   218: aload_1
    //   219: getfield 92	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:version	I
    //   222: aload_1
    //   223: getfield 98	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:peakVersion	I
    //   226: aload 4
    //   228: invokespecial 286	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(IILjava/lang/String;)V
    //   231: aload 5
    //   233: invokevirtual 289	java/io/FileOutputStream:close	()V
    //   236: aload_3
    //   237: invokevirtual 290	java/io/BufferedOutputStream:close	()V
    //   240: aload_2
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 291	java/io/ObjectOutputStream:close	()V
    //   246: goto +142 -> 388
    //   249: astore 4
    //   251: aload_2
    //   252: astore_1
    //   253: aload 4
    //   255: astore_2
    //   256: goto +36 -> 292
    //   259: astore 6
    //   261: aload_3
    //   262: astore 4
    //   264: aload_2
    //   265: astore_1
    //   266: aload 6
    //   268: astore_2
    //   269: goto +40 -> 309
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_1
    //   275: goto +17 -> 292
    //   278: astore_2
    //   279: aconst_null
    //   280: astore_1
    //   281: aload_3
    //   282: astore 4
    //   284: goto +25 -> 309
    //   287: astore_2
    //   288: aconst_null
    //   289: astore_3
    //   290: aload_3
    //   291: astore_1
    //   292: aload 5
    //   294: astore 4
    //   296: aload_3
    //   297: astore 5
    //   299: goto +101 -> 400
    //   302: astore_2
    //   303: aconst_null
    //   304: astore 4
    //   306: aload 4
    //   308: astore_1
    //   309: aload 5
    //   311: astore_3
    //   312: goto +20 -> 332
    //   315: astore_2
    //   316: aconst_null
    //   317: astore 5
    //   319: aload 5
    //   321: astore_1
    //   322: goto +78 -> 400
    //   325: astore_2
    //   326: aconst_null
    //   327: astore 4
    //   329: aload 4
    //   331: astore_1
    //   332: sipush 310
    //   335: aload_2
    //   336: iconst_0
    //   337: anewarray 48	java/lang/String
    //   340: invokestatic 80	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   343: ldc 35
    //   345: iconst_1
    //   346: ldc_w 293
    //   349: aload_2
    //   350: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_0
    //   354: invokespecial 126	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:f	()V
    //   357: aload_3
    //   358: ifnull +10 -> 368
    //   361: aload_3
    //   362: invokevirtual 289	java/io/FileOutputStream:close	()V
    //   365: goto +3 -> 368
    //   368: aload 4
    //   370: ifnull +11 -> 381
    //   373: aload 4
    //   375: invokevirtual 290	java/io/BufferedOutputStream:close	()V
    //   378: goto +3 -> 381
    //   381: aload_1
    //   382: ifnull +6 -> 388
    //   385: goto -143 -> 242
    //   388: aload 7
    //   390: monitorexit
    //   391: return
    //   392: astore_2
    //   393: aload 4
    //   395: astore 5
    //   397: aload_3
    //   398: astore 4
    //   400: aload 4
    //   402: ifnull +15 -> 417
    //   405: aload 4
    //   407: invokevirtual 289	java/io/FileOutputStream:close	()V
    //   410: goto +7 -> 417
    //   413: astore_1
    //   414: goto +26 -> 440
    //   417: aload 5
    //   419: ifnull +11 -> 430
    //   422: aload 5
    //   424: invokevirtual 290	java/io/BufferedOutputStream:close	()V
    //   427: goto +3 -> 430
    //   430: aload_1
    //   431: ifnull +7 -> 438
    //   434: aload_1
    //   435: invokevirtual 291	java/io/ObjectOutputStream:close	()V
    //   438: aload_2
    //   439: athrow
    //   440: aload 7
    //   442: monitorexit
    //   443: goto +5 -> 448
    //   446: aload_1
    //   447: athrow
    //   448: goto -2 -> 446
    //   451: astore_1
    //   452: goto -216 -> 236
    //   455: astore_1
    //   456: aload_2
    //   457: astore_1
    //   458: goto -216 -> 242
    //   461: astore_1
    //   462: goto -74 -> 388
    //   465: astore_2
    //   466: goto -98 -> 368
    //   469: astore_2
    //   470: goto -89 -> 381
    //   473: astore_3
    //   474: goto -57 -> 417
    //   477: astore_3
    //   478: goto -48 -> 430
    //   481: astore_1
    //   482: goto -44 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	SpringFestivalRedpacketConfProcessor
    //   0	485	1	paramEntryConfigBean	EntryConfigBean
    //   21	248	2	localObject1	Object
    //   272	1	2	localObject2	Object
    //   278	1	2	localException1	Exception
    //   287	1	2	localObject3	Object
    //   302	1	2	localException2	Exception
    //   315	1	2	localObject4	Object
    //   325	25	2	localException3	Exception
    //   392	65	2	localObject5	Object
    //   465	1	2	localException4	Exception
    //   469	1	2	localException5	Exception
    //   13	385	3	localObject6	Object
    //   473	1	3	localException6	Exception
    //   477	1	3	localException7	Exception
    //   10	217	4	str	String
    //   249	5	4	localObject7	Object
    //   262	144	4	localObject8	Object
    //   29	394	5	localObject9	Object
    //   59	149	6	localFile	File
    //   259	8	6	localException8	Exception
    //   4	437	7	arrayOfByte	byte[]
    //   73	127	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   171	199	249	finally
    //   199	231	249	finally
    //   171	199	259	java/lang/Exception
    //   199	231	259	java/lang/Exception
    //   162	171	272	finally
    //   162	171	278	java/lang/Exception
    //   152	162	287	finally
    //   152	162	302	java/lang/Exception
    //   14	135	315	finally
    //   135	152	315	finally
    //   14	135	325	java/lang/Exception
    //   135	152	325	java/lang/Exception
    //   332	357	392	finally
    //   231	236	413	finally
    //   236	240	413	finally
    //   242	246	413	finally
    //   361	365	413	finally
    //   373	378	413	finally
    //   388	391	413	finally
    //   405	410	413	finally
    //   422	427	413	finally
    //   434	438	413	finally
    //   438	440	413	finally
    //   440	443	413	finally
    //   231	236	451	java/lang/Exception
    //   236	240	455	java/lang/Exception
    //   242	246	461	java/lang/Exception
    //   361	365	465	java/lang/Exception
    //   373	378	469	java/lang/Exception
    //   405	410	473	java/lang/Exception
    //   422	427	477	java/lang/Exception
    //   434	438	481	java/lang/Exception
  }
  
  private void f()
  {
    try
    {
      synchronized (this.d)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("spring_festival_redpacket2021_entry_config_");
        ((StringBuilder)localObject1).append(this.a.getCurrentAccountUin());
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
  
  private EntryConfigBean g()
  {
    try
    {
      EntryConfigBean localEntryConfigBean = h();
      return localEntryConfigBean;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "loadLocalEntryConfigQuiet load local config ex.", localThrowable);
    }
    return null;
  }
  
  /* Error */
  private EntryConfigBean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:d	[B
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore_3
    //   17: new 155	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc 224
    //   28: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload_0
    //   34: getfield 21	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 165	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   40: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 7
    //   50: invokestatic 229	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   53: aload 7
    //   55: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 244	java/io/File:exists	()Z
    //   63: ifeq +146 -> 209
    //   66: aload_0
    //   67: invokespecial 310	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:i	()Ljava/lang/String;
    //   70: aload_1
    //   71: invokevirtual 278	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   74: invokestatic 284	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokestatic 316	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   80: ifeq +116 -> 196
    //   83: new 318	java/io/FileInputStream
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore_1
    //   92: new 321	java/io/BufferedInputStream
    //   95: dup
    //   96: aload_1
    //   97: invokespecial 324	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore_2
    //   101: new 326	java/io/ObjectInputStream
    //   104: dup
    //   105: aload_2
    //   106: invokespecial 327	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: astore 4
    //   111: aload 4
    //   113: invokevirtual 331	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   116: checkcast 63	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean
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
    //   196: ldc 35
    //   198: iconst_1
    //   199: ldc_w 333
    //   202: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_0
    //   206: invokespecial 126	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:f	()V
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
    //   227: invokevirtual 336	java/io/ObjectInputStream:close	()V
    //   230: goto +3 -> 233
    //   233: aload 4
    //   235: ifnull +11 -> 246
    //   238: aload 4
    //   240: invokevirtual 337	java/io/BufferedInputStream:close	()V
    //   243: goto +3 -> 246
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 338	java/io/FileInputStream:close	()V
    //   254: ldc 35
    //   256: iconst_1
    //   257: ldc_w 340
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload 7
    //   268: aastore
    //   269: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   272: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   297: ldc 35
    //   299: iconst_1
    //   300: ldc_w 342
    //   303: aload_3
    //   304: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: aload_0
    //   308: invokespecial 126	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:f	()V
    //   311: new 155	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   318: astore 5
    //   320: aload 5
    //   322: ldc_w 344
    //   325: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 5
    //   331: aload_3
    //   332: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: new 346	java/lang/RuntimeException
    //   342: dup
    //   343: aload 5
    //   345: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokespecial 347	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
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
    //   372: invokevirtual 336	java/io/ObjectInputStream:close	()V
    //   375: goto +7 -> 382
    //   378: astore_1
    //   379: goto +24 -> 403
    //   382: aload_2
    //   383: ifnull +10 -> 393
    //   386: aload_2
    //   387: invokevirtual 337	java/io/BufferedInputStream:close	()V
    //   390: goto +3 -> 393
    //   393: aload_1
    //   394: ifnull +7 -> 401
    //   397: aload_1
    //   398: invokevirtual 338	java/io/FileInputStream:close	()V
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
  
  private String i()
  {
    try
    {
      Object localObject1 = this.a.getApp();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("config_md5_");
      ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
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
  
  private int j()
  {
    int j = 0;
    int i = j;
    int k;
    try
    {
      Object localObject1 = this.a.getApp();
      i = j;
      Object localObject2 = new StringBuilder();
      i = j;
      ((StringBuilder)localObject2).append("config_version_");
      i = j;
      ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
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
  
  public EntryConfigBean a()
  {
    return a(true);
  }
  
  public EntryConfigBean a(boolean paramBoolean)
  {
    if ((this.b == null) && (paramBoolean)) {
      try
      {
        EntryConfigBean localEntryConfigBean = h();
        if (localEntryConfigBean != null) {
          this.b = localEntryConfigBean;
        }
      }
      catch (Exception localException)
      {
        SpringHbMonitorReporter.a(305, localException, new String[0]);
        QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "getLocalEntryConfig fail.", localException);
      }
    }
    return this.b;
  }
  
  public void a(int paramInt, SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    try
    {
      QLog.d("shua2021_SpringFestivalRedpacketConfProcessor", 1, String.format("onGetPopBannerConfig() ver=%d", new Object[] { Integer.valueOf(paramInt) }));
      this.c = paramSpringFestivalRedpacketPopBannerConfBean;
      EntryConfigBean localEntryConfigBean2 = g();
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
      BaseApplication localBaseApplication = this.a.getApp();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_req_adcode_");
      ((StringBuilder)localObject).append(this.a.getCurrentAccountUin());
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
    //   15: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +28 -> 46
    //   21: aload 14
    //   23: astore 13
    //   25: ldc 35
    //   27: iconst_2
    //   28: ldc_w 400
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload 6
    //   39: aastore
    //   40: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload 14
    //   48: astore 13
    //   50: aload_0
    //   51: invokespecial 378	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:g	()Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   54: astore 14
    //   56: aload 14
    //   58: ifnonnull +10 -> 68
    //   61: aload 15
    //   63: astore 13
    //   65: goto +10 -> 75
    //   68: aload 14
    //   70: getfield 102	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:delayList	Ljava/util/List;
    //   73: astore 13
    //   75: aload_0
    //   76: invokevirtual 403	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:c	()Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;
    //   79: astore 15
    //   81: ldc 35
    //   83: iconst_1
    //   84: ldc_w 405
    //   87: bipush 10
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload_1
    //   95: invokestatic 410	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_3
    //   102: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: iload_2
    //   109: invokestatic 410	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   112: aastore
    //   113: dup
    //   114: iconst_3
    //   115: iload 4
    //   117: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   120: aastore
    //   121: dup
    //   122: iconst_4
    //   123: iload 5
    //   125: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: dup
    //   130: iconst_5
    //   131: iload 8
    //   133: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: aastore
    //   137: dup
    //   138: bipush 6
    //   140: aload_0
    //   141: aload 7
    //   143: invokespecial 46	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Ljava/util/List;)Ljava/lang/String;
    //   146: aastore
    //   147: dup
    //   148: bipush 7
    //   150: aload_0
    //   151: aload 13
    //   153: invokespecial 46	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Ljava/util/List;)Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: bipush 8
    //   160: iload 9
    //   162: invokestatic 410	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   165: aastore
    //   166: dup
    //   167: bipush 9
    //   169: lload 10
    //   171: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: aastore
    //   175: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +24 -> 208
    //   187: ldc 35
    //   189: iconst_2
    //   190: ldc_w 412
    //   193: iconst_1
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 15
    //   201: aastore
    //   202: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: invokestatic 56	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: iload 9
    //   210: ifeq +9 -> 219
    //   213: aload_0
    //   214: lload 10
    //   216: invokevirtual 414	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(J)V
    //   219: iload_1
    //   220: ifeq +83 -> 303
    //   223: aload 6
    //   225: invokestatic 418	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   228: ifeq +258 -> 486
    //   231: aload_0
    //   232: aload 15
    //   234: invokespecial 420	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   237: astore 6
    //   239: goto +242 -> 481
    //   242: aload_0
    //   243: iload_3
    //   244: iload 4
    //   246: iload 5
    //   248: aload 6
    //   250: aload 7
    //   252: aload 15
    //   254: invokespecial 422	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(IIILjava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
    //   257: astore 6
    //   259: aload 6
    //   261: ifnonnull +33 -> 294
    //   264: aload 6
    //   266: astore 13
    //   268: ldc 35
    //   270: iconst_1
    //   271: ldc_w 424
    //   274: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: aload 6
    //   279: astore 13
    //   281: aload_0
    //   282: aload 15
    //   284: invokespecial 420	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
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
    //   314: invokespecial 426	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;ILjava/util/List;)Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;
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
    //   350: invokespecial 380	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:b	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;)V
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
    //   378: anewarray 48	java/lang/String
    //   381: invokestatic 80	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   384: new 155	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   391: astore 7
    //   393: aload 7
    //   395: ldc_w 428
    //   398: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 7
    //   404: aload 6
    //   406: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: ldc 35
    //   415: iconst_1
    //   416: aload 7
    //   418: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: aload 6
    //   423: invokestatic 203	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   426: iload 12
    //   428: istore_1
    //   429: aload 13
    //   431: astore 6
    //   433: aload_0
    //   434: aload 6
    //   436: invokespecial 381	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Lcom/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean;)V
    //   439: aload 6
    //   441: ifnull +25 -> 466
    //   444: aload 6
    //   446: getfield 432	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:htmlOfflineCheckConfig	Lcom/tencent/mobileqq/activity/springfestival/entry/model/HtmlOfflineCheckConfig;
    //   449: ifnull +17 -> 466
    //   452: aload 6
    //   454: getfield 432	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:htmlOfflineCheckConfig	Lcom/tencent/mobileqq/activity/springfestival/entry/model/HtmlOfflineCheckConfig;
    //   457: getfield 438	com/tencent/mobileqq/activity/springfestival/entry/model/HtmlOfflineCheckConfig:bids	Ljava/lang/String;
    //   460: iload 5
    //   462: iload_3
    //   463: invokestatic 441	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:b	(Ljava/lang/String;II)V
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
  
  public SpringFestivalRedpacketPopBannerConfBean b(boolean paramBoolean)
  {
    if ((this.c == null) && (paramBoolean)) {
      try
      {
        SpringFestivalRedpacketPopBannerConfBean localSpringFestivalRedpacketPopBannerConfBean = (SpringFestivalRedpacketPopBannerConfBean)QConfigManager.b().b(723);
        if (localSpringFestivalRedpacketPopBannerConfBean != null) {
          this.c = localSpringFestivalRedpacketPopBannerConfBean;
        }
      }
      catch (Exception localException)
      {
        SpringHbMonitorReporter.a(306, localException, new String[0]);
        QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "getLocalPopBannerConfig fail.", localException);
      }
    }
    return this.c;
  }
  
  public EntryConfigBean b()
  {
    return this.b;
  }
  
  public SpringFestivalRedpacketPopBannerConfBean c()
  {
    return b(true);
  }
  
  public int d()
  {
    a();
    if (this.b != null) {
      return this.b.version;
    }
    return j();
  }
  
  public int e()
  {
    if (this.b != null) {
      return this.b.taskId;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfProcessor
 * JD-Core Version:    0.7.0.1
 */