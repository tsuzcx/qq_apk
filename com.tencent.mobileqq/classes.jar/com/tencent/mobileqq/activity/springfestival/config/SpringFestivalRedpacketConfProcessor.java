package com.tencent.mobileqq.activity.springfestival.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.HtmlOfflineCheckConfig;
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
  
  /* Error */
  private EntryConfigBean a(int paramInt1, int paramInt2, int paramInt3, String paramString, List<Integer> paramList, SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    // Byte code:
    //   0: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: ldc 32
    //   8: iconst_2
    //   9: ldc 34
    //   11: iconst_3
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_2
    //   25: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: aload_0
    //   32: aload 5
    //   34: invokespecial 43	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(Ljava/util/List;)Ljava/lang/String;
    //   37: aastore
    //   38: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   41: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aconst_null
    //   45: astore 7
    //   47: aload 4
    //   49: ifnull +105 -> 154
    //   52: new 55	org/json/JSONObject
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 58	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore 7
    //   63: new 60	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean
    //   66: dup
    //   67: invokespecial 61	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:<init>	()V
    //   70: astore 4
    //   72: aload 4
    //   74: aload 7
    //   76: invokevirtual 65	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:parseJson	(Lorg/json/JSONObject;)V
    //   79: aload 4
    //   81: aload 6
    //   83: invokevirtual 69	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:onGetPopBannerConfig	(Lcom/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketPopBannerConfBean;)V
    //   86: aload 4
    //   88: invokevirtual 72	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:validate	()V
    //   91: aload 4
    //   93: astore 7
    //   95: aload 4
    //   97: ifnull +57 -> 154
    //   100: aload 4
    //   102: iload_1
    //   103: putfield 76	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:version	I
    //   106: aload 4
    //   108: iload_3
    //   109: putfield 79	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:taskId	I
    //   112: aload 4
    //   114: iload_2
    //   115: putfield 82	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:peakVersion	I
    //   118: aload 4
    //   120: getfield 86	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:delayList	Ljava/util/List;
    //   123: invokeinterface 91 1 0
    //   128: aload 4
    //   130: astore 7
    //   132: aload 5
    //   134: ifnull +20 -> 154
    //   137: aload 4
    //   139: getfield 86	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:delayList	Ljava/util/List;
    //   142: aload 5
    //   144: invokeinterface 95 2 0
    //   149: pop
    //   150: aload 4
    //   152: astore 7
    //   154: aload 7
    //   156: areturn
    //   157: astore 6
    //   159: aconst_null
    //   160: astore 4
    //   162: sipush 308
    //   165: aload 6
    //   167: iconst_0
    //   168: anewarray 45	java/lang/String
    //   171: invokestatic 100	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   174: ldc 32
    //   176: iconst_1
    //   177: aload 6
    //   179: invokevirtual 104	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   182: aload 6
    //   184: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: goto -96 -> 91
    //   190: astore 6
    //   192: aconst_null
    //   193: astore 4
    //   195: sipush 309
    //   198: aload 6
    //   200: iconst_0
    //   201: anewarray 45	java/lang/String
    //   204: invokestatic 100	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   207: ldc 32
    //   209: iconst_1
    //   210: aload 6
    //   212: invokevirtual 109	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: aload 6
    //   217: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto -129 -> 91
    //   223: astore 6
    //   225: goto -30 -> 195
    //   228: astore 6
    //   230: goto -68 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	SpringFestivalRedpacketConfProcessor
    //   0	233	1	paramInt1	int
    //   0	233	2	paramInt2	int
    //   0	233	3	paramInt3	int
    //   0	233	4	paramString	String
    //   0	233	5	paramList	List<Integer>
    //   0	233	6	paramSpringFestivalRedpacketPopBannerConfBean	SpringFestivalRedpacketPopBannerConfBean
    //   45	110	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	72	157	org/json/JSONException
    //   52	72	190	java/lang/Exception
    //   72	91	223	java/lang/Exception
    //   72	91	228	org/json/JSONException
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
    EntryConfigBean localEntryConfigBean;
    if (paramEntryConfigBean == null) {
      localEntryConfigBean = null;
    }
    do
    {
      do
      {
        return localEntryConfigBean;
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 2, String.format("handleUpdatePeakDelay pVer=%d delayList=%s", new Object[] { Integer.valueOf(paramInt), a(paramList) }));
        }
        localEntryConfigBean = paramEntryConfigBean;
      } while (paramEntryConfigBean == null);
      paramEntryConfigBean.peakVersion = paramInt;
      paramEntryConfigBean.delayList.clear();
      localEntryConfigBean = paramEntryConfigBean;
    } while (paramList == null);
    paramEntryConfigBean.delayList.addAll(paramList);
    return paramEntryConfigBean;
  }
  
  private String a()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      String str = "config_md5_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject = ((Context)localObject).getSharedPreferences("spring_festival_redpacket2021_entry_config_sp", 0).getString(str, "");
      return localObject;
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
        Object localObject1 = "spring_festival_redpacket2021_entry_config_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
      String str1 = "config_version_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str2 = "peak_version_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str3 = "config_md5_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localBaseApplication.getSharedPreferences("spring_festival_redpacket2021_entry_config_sp", 0).edit().putInt(str1, paramInt1).putInt(str2, paramInt2).putString(str3, paramString).apply();
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
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 16	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   10: astore 6
    //   12: aload 6
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 255	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   22: astore_2
    //   23: new 136	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   30: ldc 184
    //   32: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_2
    //   43: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   46: aload_2
    //   47: invokevirtual 197	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   50: astore 7
    //   52: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   55: new 136	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 257
    //   69: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 197	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   78: astore 8
    //   80: ldc 32
    //   82: iconst_1
    //   83: ldc_w 259
    //   86: iconst_1
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_2
    //   93: aastore
    //   94: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   97: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload 8
    //   102: invokevirtual 202	java/io/File:exists	()Z
    //   105: ifeq +9 -> 114
    //   108: aload 8
    //   110: invokevirtual 205	java/io/File:delete	()Z
    //   113: pop
    //   114: aload 8
    //   116: invokevirtual 262	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: new 264	java/io/FileOutputStream
    //   123: dup
    //   124: aload 8
    //   126: invokespecial 267	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: astore_2
    //   130: new 269	java/io/BufferedOutputStream
    //   133: dup
    //   134: aload_2
    //   135: invokespecial 272	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   138: astore 4
    //   140: new 274	java/io/ObjectOutputStream
    //   143: dup
    //   144: aload 4
    //   146: invokespecial 275	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   149: astore_3
    //   150: aload_3
    //   151: aload_1
    //   152: invokevirtual 279	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   155: aload_3
    //   156: invokevirtual 282	java/io/ObjectOutputStream:flush	()V
    //   159: aload_2
    //   160: invokevirtual 283	java/io/FileOutputStream:flush	()V
    //   163: aload 7
    //   165: invokevirtual 202	java/io/File:exists	()Z
    //   168: ifeq +9 -> 177
    //   171: aload 7
    //   173: invokevirtual 205	java/io/File:delete	()Z
    //   176: pop
    //   177: aload 8
    //   179: aload 7
    //   181: invokevirtual 287	java/io/File:renameTo	(Ljava/io/File;)Z
    //   184: pop
    //   185: aload 7
    //   187: invokevirtual 290	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   190: invokestatic 296	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 5
    //   195: aload_0
    //   196: aload_1
    //   197: getfield 76	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:version	I
    //   200: aload_1
    //   201: getfield 82	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean:peakVersion	I
    //   204: aload 5
    //   206: invokespecial 208	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	(IILjava/lang/String;)V
    //   209: aload_2
    //   210: ifnull +7 -> 217
    //   213: aload_2
    //   214: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   217: aload 4
    //   219: ifnull +8 -> 227
    //   222: aload 4
    //   224: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 301	java/io/ObjectOutputStream:close	()V
    //   235: aload 6
    //   237: monitorexit
    //   238: return
    //   239: astore 5
    //   241: aconst_null
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_3
    //   245: aload 4
    //   247: astore_2
    //   248: aload 5
    //   250: astore 4
    //   252: sipush 310
    //   255: aload 4
    //   257: iconst_0
    //   258: anewarray 45	java/lang/String
    //   261: invokestatic 100	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   264: ldc 32
    //   266: iconst_1
    //   267: ldc_w 303
    //   270: aload 4
    //   272: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload_0
    //   276: invokespecial 123	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()V
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   295: aload_3
    //   296: ifnull -61 -> 235
    //   299: aload_3
    //   300: invokevirtual 301	java/io/ObjectOutputStream:close	()V
    //   303: goto -68 -> 235
    //   306: astore_1
    //   307: goto -72 -> 235
    //   310: astore_1
    //   311: aconst_null
    //   312: astore 4
    //   314: aconst_null
    //   315: astore_3
    //   316: aload 5
    //   318: astore_2
    //   319: aload_2
    //   320: ifnull +7 -> 327
    //   323: aload_2
    //   324: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   337: aload_3
    //   338: ifnull +7 -> 345
    //   341: aload_3
    //   342: invokevirtual 301	java/io/ObjectOutputStream:close	()V
    //   345: aload_1
    //   346: athrow
    //   347: astore_1
    //   348: aload 6
    //   350: monitorexit
    //   351: aload_1
    //   352: athrow
    //   353: astore_1
    //   354: goto -137 -> 217
    //   357: astore_1
    //   358: goto -131 -> 227
    //   361: astore_1
    //   362: goto -127 -> 235
    //   365: astore_2
    //   366: goto -79 -> 287
    //   369: astore_1
    //   370: goto -75 -> 295
    //   373: astore_2
    //   374: goto -47 -> 327
    //   377: astore_2
    //   378: goto -41 -> 337
    //   381: astore_2
    //   382: goto -37 -> 345
    //   385: astore_1
    //   386: aconst_null
    //   387: astore 4
    //   389: aconst_null
    //   390: astore_3
    //   391: goto -72 -> 319
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -78 -> 319
    //   400: astore_1
    //   401: goto -82 -> 319
    //   404: astore 5
    //   406: aload_1
    //   407: astore 4
    //   409: aload 5
    //   411: astore_1
    //   412: goto -93 -> 319
    //   415: astore 4
    //   417: aconst_null
    //   418: astore_3
    //   419: aconst_null
    //   420: astore_1
    //   421: goto -169 -> 252
    //   424: astore 5
    //   426: aload 4
    //   428: astore_1
    //   429: aconst_null
    //   430: astore_3
    //   431: aload 5
    //   433: astore 4
    //   435: goto -183 -> 252
    //   438: astore 5
    //   440: aload 4
    //   442: astore_1
    //   443: aload 5
    //   445: astore 4
    //   447: goto -195 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	SpringFestivalRedpacketConfProcessor
    //   0	450	1	paramEntryConfigBean	EntryConfigBean
    //   22	302	2	localObject1	Object
    //   365	1	2	localException1	Exception
    //   373	1	2	localException2	Exception
    //   377	1	2	localException3	Exception
    //   381	1	2	localException4	Exception
    //   149	282	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   4	404	4	localObject2	Object
    //   415	12	4	localException5	Exception
    //   433	13	4	localException6	Exception
    //   1	204	5	str	String
    //   239	78	5	localException7	Exception
    //   404	6	5	localObject3	Object
    //   424	8	5	localException8	Exception
    //   438	6	5	localException9	Exception
    //   10	339	6	arrayOfByte	byte[]
    //   50	136	7	localFile1	File
    //   78	100	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   15	114	239	java/lang/Exception
    //   114	130	239	java/lang/Exception
    //   299	303	306	java/lang/Exception
    //   15	114	310	finally
    //   114	130	310	finally
    //   213	217	347	finally
    //   222	227	347	finally
    //   231	235	347	finally
    //   235	238	347	finally
    //   283	287	347	finally
    //   291	295	347	finally
    //   299	303	347	finally
    //   323	327	347	finally
    //   332	337	347	finally
    //   341	345	347	finally
    //   345	347	347	finally
    //   348	351	347	finally
    //   213	217	353	java/lang/Exception
    //   222	227	357	java/lang/Exception
    //   231	235	361	java/lang/Exception
    //   283	287	365	java/lang/Exception
    //   291	295	369	java/lang/Exception
    //   323	327	373	java/lang/Exception
    //   332	337	377	java/lang/Exception
    //   341	345	381	java/lang/Exception
    //   130	140	385	finally
    //   140	150	394	finally
    //   150	177	400	finally
    //   177	209	400	finally
    //   252	279	404	finally
    //   130	140	415	java/lang/Exception
    //   140	150	424	java/lang/Exception
    //   150	177	438	java/lang/Exception
    //   177	209	438	java/lang/Exception
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
  private int d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore_2
    //   8: new 136	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   15: ldc 216
    //   17: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   27: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_2
    //   35: ldc 151
    //   37: iconst_0
    //   38: invokevirtual 157	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: aload_3
    //   42: iconst_0
    //   43: invokeinterface 316 3 0
    //   48: istore_1
    //   49: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +29 -> 81
    //   55: ldc 32
    //   57: iconst_2
    //   58: new 136	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 318
    //   68: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_1
    //   72: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: iload_1
    //   82: ireturn
    //   83: astore_2
    //   84: iconst_0
    //   85: istore_1
    //   86: ldc 32
    //   88: iconst_1
    //   89: ldc_w 323
    //   92: aload_2
    //   93: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: iload_1
    //   97: ireturn
    //   98: astore_2
    //   99: goto -13 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	SpringFestivalRedpacketConfProcessor
    //   48	49	1	i	int
    //   7	28	2	localBaseApplication	BaseApplication
    //   83	10	2	localException1	Exception
    //   98	1	2	localException2	Exception
    //   33	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	49	83	java/lang/Exception
    //   49	81	98	java/lang/Exception
  }
  
  /* Error */
  private EntryConfigBean d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 16	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: new 136	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   24: ldc 184
    //   26: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   33: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   36: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 6
    //   44: invokestatic 191	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   47: aload 6
    //   49: invokevirtual 197	com/tencent/qphone/base/util/BaseApplication:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 202	java/io/File:exists	()Z
    //   57: ifeq +129 -> 186
    //   60: aload_0
    //   61: invokespecial 325	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()Ljava/lang/String;
    //   64: aload_1
    //   65: invokevirtual 290	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokestatic 296	com/tencent/open/base/MD5Utils:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 331	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   74: ifeq +99 -> 173
    //   77: new 333	java/io/FileInputStream
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 334	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: astore_1
    //   86: new 336	java/io/BufferedInputStream
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 339	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_3
    //   95: new 341	java/io/ObjectInputStream
    //   98: dup
    //   99: aload_3
    //   100: invokespecial 342	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   103: astore_2
    //   104: aload_2
    //   105: invokevirtual 346	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   108: checkcast 60	com/tencent/mobileqq/activity/springfestival/entry/model/EntryConfigBean
    //   111: astore 5
    //   113: aload_2
    //   114: astore 4
    //   116: aload_1
    //   117: astore_2
    //   118: aload 5
    //   120: astore_1
    //   121: aload 4
    //   123: ifnull +8 -> 131
    //   126: aload 4
    //   128: invokevirtual 347	java/io/ObjectInputStream:close	()V
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 348	java/io/BufferedInputStream:close	()V
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 349	java/io/FileInputStream:close	()V
    //   147: ldc 32
    //   149: iconst_1
    //   150: ldc_w 351
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload 6
    //   161: aastore
    //   162: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   165: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload 7
    //   170: monitorexit
    //   171: aload_1
    //   172: areturn
    //   173: ldc 32
    //   175: iconst_1
    //   176: ldc_w 353
    //   179: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload_0
    //   183: invokespecial 123	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()V
    //   186: aconst_null
    //   187: astore_3
    //   188: aconst_null
    //   189: astore 5
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_2
    //   194: astore 4
    //   196: aload 5
    //   198: astore_2
    //   199: goto -78 -> 121
    //   202: astore_3
    //   203: aconst_null
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_2
    //   207: ldc 32
    //   209: iconst_1
    //   210: ldc_w 357
    //   213: aload_3
    //   214: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_0
    //   218: invokespecial 123	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:a	()V
    //   221: new 359	java/lang/RuntimeException
    //   224: dup
    //   225: new 136	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 361
    //   235: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_3
    //   239: invokevirtual 109	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokespecial 362	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   251: athrow
    //   252: astore 5
    //   254: aload 4
    //   256: astore_3
    //   257: aload_1
    //   258: astore 4
    //   260: aload_2
    //   261: astore_1
    //   262: aload 5
    //   264: astore_2
    //   265: aload 4
    //   267: ifnull +8 -> 275
    //   270: aload 4
    //   272: invokevirtual 347	java/io/ObjectInputStream:close	()V
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 348	java/io/BufferedInputStream:close	()V
    //   283: aload_1
    //   284: ifnull +7 -> 291
    //   287: aload_1
    //   288: invokevirtual 349	java/io/FileInputStream:close	()V
    //   291: aload_2
    //   292: athrow
    //   293: astore_1
    //   294: aload 7
    //   296: monitorexit
    //   297: aload_1
    //   298: athrow
    //   299: astore 4
    //   301: goto -170 -> 131
    //   304: astore_3
    //   305: goto -166 -> 139
    //   308: astore_2
    //   309: goto -162 -> 147
    //   312: astore 4
    //   314: goto -39 -> 275
    //   317: astore_3
    //   318: goto -35 -> 283
    //   321: astore_1
    //   322: goto -31 -> 291
    //   325: astore_2
    //   326: aconst_null
    //   327: astore_3
    //   328: aconst_null
    //   329: astore_1
    //   330: aload 5
    //   332: astore 4
    //   334: goto -69 -> 265
    //   337: astore_2
    //   338: aconst_null
    //   339: astore_3
    //   340: aload 5
    //   342: astore 4
    //   344: goto -79 -> 265
    //   347: astore_2
    //   348: aload 5
    //   350: astore 4
    //   352: goto -87 -> 265
    //   355: astore 5
    //   357: aload_2
    //   358: astore 4
    //   360: aload 5
    //   362: astore_2
    //   363: goto -98 -> 265
    //   366: astore_3
    //   367: aconst_null
    //   368: astore 5
    //   370: aload_1
    //   371: astore_2
    //   372: aload 5
    //   374: astore_1
    //   375: goto -168 -> 207
    //   378: astore 6
    //   380: aconst_null
    //   381: astore 5
    //   383: aload_3
    //   384: astore 4
    //   386: aload_1
    //   387: astore_2
    //   388: aload 6
    //   390: astore_3
    //   391: aload 5
    //   393: astore_1
    //   394: goto -187 -> 207
    //   397: astore 6
    //   399: aload_3
    //   400: astore 4
    //   402: aload_1
    //   403: astore 5
    //   405: aload 6
    //   407: astore_3
    //   408: aload_2
    //   409: astore_1
    //   410: aload 5
    //   412: astore_2
    //   413: goto -206 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	this	SpringFestivalRedpacketConfProcessor
    //   52	236	1	localObject1	Object
    //   293	5	1	localObject2	Object
    //   321	1	1	localException1	Exception
    //   329	81	1	localObject3	Object
    //   7	285	2	localObject4	Object
    //   308	1	2	localException2	Exception
    //   325	1	2	localObject5	Object
    //   337	1	2	localObject6	Object
    //   347	11	2	localObject7	Object
    //   362	51	2	localObject8	Object
    //   94	94	3	localBufferedInputStream	java.io.BufferedInputStream
    //   202	37	3	localException3	Exception
    //   256	24	3	localObject9	Object
    //   304	1	3	localException4	Exception
    //   317	1	3	localException5	Exception
    //   327	13	3	localObject10	Object
    //   366	18	3	localException6	Exception
    //   390	18	3	localException7	Exception
    //   1	270	4	localObject11	Object
    //   299	1	4	localException8	Exception
    //   312	1	4	localException9	Exception
    //   332	69	4	localObject12	Object
    //   4	193	5	localEntryConfigBean	EntryConfigBean
    //   252	97	5	localObject13	Object
    //   355	6	5	localObject14	Object
    //   368	43	5	localObject15	Object
    //   42	118	6	str	String
    //   378	11	6	localException10	Exception
    //   397	9	6	localException11	Exception
    //   12	283	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	86	202	java/lang/Exception
    //   173	186	202	java/lang/Exception
    //   207	252	252	finally
    //   126	131	293	finally
    //   135	139	293	finally
    //   143	147	293	finally
    //   147	171	293	finally
    //   270	275	293	finally
    //   279	283	293	finally
    //   287	291	293	finally
    //   291	293	293	finally
    //   294	297	293	finally
    //   126	131	299	java/lang/Exception
    //   135	139	304	java/lang/Exception
    //   143	147	308	java/lang/Exception
    //   270	275	312	java/lang/Exception
    //   279	283	317	java/lang/Exception
    //   287	291	321	java/lang/Exception
    //   17	86	325	finally
    //   173	186	325	finally
    //   86	95	337	finally
    //   95	104	347	finally
    //   104	113	355	finally
    //   86	95	366	java/lang/Exception
    //   95	104	378	java/lang/Exception
    //   104	113	397	java/lang/Exception
  }
  
  /* Error */
  private int e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore_2
    //   8: new 136	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   15: ldc 214
    //   17: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   27: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_2
    //   35: ldc 151
    //   37: iconst_0
    //   38: invokevirtual 157	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: aload_3
    //   42: iconst_0
    //   43: invokeinterface 316 3 0
    //   48: istore_1
    //   49: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +29 -> 81
    //   55: ldc 32
    //   57: iconst_2
    //   58: new 136	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 364
    //   68: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_1
    //   72: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: iload_1
    //   82: ireturn
    //   83: astore_2
    //   84: iconst_0
    //   85: istore_1
    //   86: ldc 32
    //   88: iconst_1
    //   89: ldc_w 366
    //   92: aload_2
    //   93: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: iload_1
    //   97: ireturn
    //   98: astore_2
    //   99: goto -13 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	SpringFestivalRedpacketConfProcessor
    //   48	49	1	i	int
    //   7	28	2	localBaseApplication	BaseApplication
    //   83	10	2	localException1	Exception
    //   98	1	2	localException2	Exception
    //   33	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	49	83	java/lang/Exception
    //   49	81	98	java/lang/Exception
  }
  
  public int a()
  {
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.version;
    }
    return e();
  }
  
  /* Error */
  public long a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: astore_3
    //   8: new 136	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 373
    //   18: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 18	com/tencent/mobileqq/activity/springfestival/config/SpringFestivalRedpacketConfProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   28: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload_3
    //   37: ldc 151
    //   39: iconst_0
    //   40: invokevirtual 157	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   43: aload 4
    //   45: lconst_0
    //   46: invokeinterface 377 4 0
    //   51: lstore_1
    //   52: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +29 -> 84
    //   58: ldc 32
    //   60: iconst_2
    //   61: new 136	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 379
    //   71: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: lload_1
    //   75: invokevirtual 382	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 53	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: lload_1
    //   85: lreturn
    //   86: astore_3
    //   87: lconst_0
    //   88: lstore_1
    //   89: ldc 32
    //   91: iconst_1
    //   92: ldc_w 384
    //   95: aload_3
    //   96: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: lload_1
    //   100: lreturn
    //   101: astore_3
    //   102: goto -13 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	SpringFestivalRedpacketConfProcessor
    //   51	49	1	l	long
    //   7	30	3	localBaseApplication	BaseApplication
    //   86	10	3	localException1	Exception
    //   101	1	3	localException2	Exception
    //   34	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	52	86	java/lang/Exception
    //   52	84	101	java/lang/Exception
  }
  
  public SpringFestivalRedpacketPopBannerConfBean a()
  {
    return a(true);
  }
  
  public SpringFestivalRedpacketPopBannerConfBean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketPopBannerConfBean == null) && (paramBoolean)) {}
    try
    {
      SpringFestivalRedpacketPopBannerConfBean localSpringFestivalRedpacketPopBannerConfBean = (SpringFestivalRedpacketPopBannerConfBean)QConfigManager.a().a(723);
      if (localSpringFestivalRedpacketPopBannerConfBean != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalConfigSpringFestivalRedpacketPopBannerConfBean = localSpringFestivalRedpacketPopBannerConfBean;
      }
    }
    catch (Exception localException)
    {
      for (;;)
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean == null) && (paramBoolean)) {}
    try
    {
      EntryConfigBean localEntryConfigBean = d();
      if (localEntryConfigBean != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean = localEntryConfigBean;
      }
    }
    catch (Exception localException)
    {
      for (;;)
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
      String str = "last_req_adcode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localBaseApplication.getSharedPreferences("spring_festival_redpacket2021_entry_config_sp", 0).edit().putLong(str, paramLong).apply();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "saveLastReqAdcodeToSP fail.", localException);
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString, List<Integer> paramList, int paramInt4, boolean paramBoolean3, long paramLong)
  {
    localEntryConfigBean = null;
    localObject = localEntryConfigBean;
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = localEntryConfigBean;
        QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 2, String.format("onGetEntryConfig configContent:%s", new Object[] { paramString }));
      }
      localObject = localEntryConfigBean;
      localEntryConfigBean = c();
      if (localEntryConfigBean == null) {
        localObject = null;
      }
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        SpringFestivalRedpacketPopBannerConfBean localSpringFestivalRedpacketPopBannerConfBean;
        label224:
        label227:
        label360:
        paramString = (String)localObject;
        label312:
        SpringHbMonitorReporter.a(307, paramList, new String[0]);
        QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "onGetEntryConfig fail." + paramList.getMessage(), paramList);
        paramBoolean2 = false;
        paramList = paramString;
      }
    }
    finally {}
    try
    {
      localSpringFestivalRedpacketPopBannerConfBean = a();
      QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 1, String.format("onGetEntryConfig() update=%s remoteVersion=%s peakUpdate=%s remotePeakVersion=%s taskId=%s reqOccasion=%s remoteDelayList=%s localDelayList=%s respSuc=%b adcode=%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), a(paramList), a((List)localObject), Boolean.valueOf(paramBoolean3), Long.valueOf(paramLong) }));
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_SpringFestivalRedpacketConfProcessor", 2, String.format("onGetEntryConfig() localPopBannerConfBean=%s", new Object[] { localSpringFestivalRedpacketPopBannerConfBean }));
      }
      if (paramBoolean3) {
        a(paramLong);
      }
      if (!paramBoolean1) {
        break label360;
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label484;
      }
      paramString = a(localSpringFestivalRedpacketPopBannerConfBean);
      paramBoolean1 = true;
    }
    catch (Exception paramList)
    {
      paramString = localEntryConfigBean;
      break label393;
      break label227;
      paramBoolean1 = true;
      break label224;
      if (!paramBoolean2) {
        break label312;
      }
      localObject = paramList;
      break label312;
    }
    paramInt2 = 1;
    for (;;)
    {
      for (;;)
      {
        paramBoolean2 = paramBoolean1;
        paramList = paramString;
        if (paramString != null)
        {
          paramBoolean2 = paramBoolean1;
          paramList = paramString;
          if (paramInt2 != 0)
          {
            localObject = paramString;
            b(paramString);
            paramList = paramString;
            paramBoolean2 = paramBoolean1;
          }
        }
        a(paramList);
        if ((paramList != null) && (paramList.htmlOfflineCheckConfig != null)) {
          SpringHbMonitorReporter.b(paramList.htmlOfflineCheckConfig.bids, paramInt3, paramInt1);
        }
        return paramBoolean2;
        localObject = localEntryConfigBean.delayList;
        break;
        paramString = a(paramInt1, paramInt2, paramInt3, paramString, (List)localObject, localSpringFestivalRedpacketPopBannerConfBean);
        if (paramString != null) {
          break label479;
        }
        try
        {
          QLog.e("shua2021_SpringFestivalRedpacketConfProcessor", 1, "onGetEntryConfig parse config fail.");
          paramList = a(localSpringFestivalRedpacketPopBannerConfBean);
          paramString = paramList;
          paramBoolean1 = false;
        }
        catch (Exception paramList)
        {
          break label393;
          paramInt2 = 0;
          paramString = localEntryConfigBean;
          paramBoolean1 = true;
        }
      }
      if (!paramBoolean2) {
        break label467;
      }
      a(localEntryConfigBean, paramInt2, paramList);
      paramInt2 = 1;
      paramString = localEntryConfigBean;
      paramBoolean1 = true;
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.peakVersion;
    }
    return d();
  }
  
  public EntryConfigBean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelEntryConfigBean.taskId;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfProcessor
 * JD-Core Version:    0.7.0.1
 */