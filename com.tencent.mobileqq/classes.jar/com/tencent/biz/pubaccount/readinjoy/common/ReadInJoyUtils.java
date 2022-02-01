package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.device.RIJDisplayStyleManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJCreateArticleInfoForBiu;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJSPUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStudyModeUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJLockScreenPushReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJMergeKanDianMessage;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog.DialogSettingInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class ReadInJoyUtils
{
  public static int a;
  public static String a;
  public static HashMap<Integer, ReadInJoyBaseViewController> a;
  public static volatile boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Int = -2;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a()
  {
    return RIJAppSetting.a();
  }
  
  public static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramInt2 != 0))
    {
      if (paramInt1 + 1 == paramInt2) {
        return 1;
      }
      return 0;
    }
    return -1;
  }
  
  public static int a(Context paramContext)
  {
    int j = NetworkUtil.a(paramContext);
    int i;
    if (j >= 1)
    {
      i = j;
      if (j <= 4) {}
    }
    else
    {
      i = 5;
    }
    return i;
  }
  
  public static long a()
  {
    return RIJQQAppInterfaceUtil.a();
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    return RIJTransMergeKanDianReport.a(paramQQAppInterface, paramDrawable);
  }
  
  public static ArticleInfo a(String paramString)
  {
    return RIJCreateArticleInfoForBiu.a(paramString);
  }
  
  public static Integer a(Context paramContext, String paramString)
  {
    return RIJJumpUtils.a(paramContext, paramString, null);
  }
  
  public static String a()
  {
    return RIJQQAppInterfaceUtil.a();
  }
  
  public static String a(int paramInt)
  {
    return BaseApplication.getContext().getResources().getString(paramInt);
  }
  
  public static String a(Bitmap paramBitmap)
  {
    return a(paramBitmap, Bitmap.CompressFormat.PNG, 100);
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: ifnull +210 -> 216
    //   9: new 92	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 95	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: aload_1
    //   26: iload_2
    //   27: aload 4
    //   29: invokevirtual 101	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   32: pop
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 105	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   41: iconst_2
    //   42: invokestatic 111	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   45: astore_0
    //   46: aload_0
    //   47: astore_1
    //   48: aload 4
    //   50: ifnull +15 -> 65
    //   53: aload 4
    //   55: invokevirtual 114	java/io/ByteArrayOutputStream:flush	()V
    //   58: aload 4
    //   60: invokevirtual 117	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_0
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   72: aload_0
    //   73: astore_1
    //   74: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -12 -> 65
    //   80: ldc 128
    //   82: iconst_2
    //   83: ldc 130
    //   85: aload_3
    //   86: invokestatic 134	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload_0
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore 4
    //   95: aload 4
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   102: aload 4
    //   104: astore_3
    //   105: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +15 -> 123
    //   111: aload 4
    //   113: astore_3
    //   114: ldc 128
    //   116: iconst_2
    //   117: ldc 130
    //   119: aload_0
    //   120: invokestatic 134	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload 5
    //   125: astore_1
    //   126: aload 4
    //   128: ifnull -63 -> 65
    //   131: aload 4
    //   133: invokevirtual 114	java/io/ByteArrayOutputStream:flush	()V
    //   136: aload 4
    //   138: invokevirtual 117	java/io/ByteArrayOutputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   148: aload 5
    //   150: astore_1
    //   151: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq -89 -> 65
    //   157: ldc 128
    //   159: iconst_2
    //   160: ldc 130
    //   162: aload_0
    //   163: invokestatic 134	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   166: aconst_null
    //   167: areturn
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_3
    //   172: ifnull +11 -> 183
    //   175: aload_3
    //   176: invokevirtual 114	java/io/ByteArrayOutputStream:flush	()V
    //   179: aload_3
    //   180: invokevirtual 117	java/io/ByteArrayOutputStream:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   190: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq -10 -> 183
    //   196: ldc 128
    //   198: iconst_2
    //   199: ldc 130
    //   201: aload_1
    //   202: invokestatic 134	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   205: goto -22 -> 183
    //   208: astore_0
    //   209: goto -38 -> 171
    //   212: astore_0
    //   213: goto -118 -> 95
    //   216: aconst_null
    //   217: astore 4
    //   219: aload_3
    //   220: astore_0
    //   221: goto -175 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramBitmap	Bitmap
    //   0	224	1	paramCompressFormat	Bitmap.CompressFormat
    //   0	224	2	paramInt	int
    //   4	32	3	localObject1	Object
    //   67	19	3	localIOException	java.io.IOException
    //   97	123	3	localObject2	Object
    //   19	199	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	148	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   53	63	67	java/io/IOException
    //   9	21	91	java/lang/Exception
    //   131	141	143	java/io/IOException
    //   9	21	168	finally
    //   175	183	185	java/io/IOException
    //   24	33	208	finally
    //   36	46	208	finally
    //   98	102	208	finally
    //   105	111	208	finally
    //   114	123	208	finally
    //   24	33	212	java/lang/Exception
    //   36	46	212	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    return RIJAppSetting.a(paramString);
  }
  
  public static AppRuntime a()
  {
    return RIJQQAppInterfaceUtil.a();
  }
  
  public static void a() {}
  
  public static void a(float paramFloat, Resources paramResources)
  {
    RIJDisplayStyleManager.a(paramFloat, paramResources);
  }
  
  public static void a(int paramInt)
  {
    RIJTransMergeKanDianReport.jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    RIJFrameworkReportManager.a(paramInt1, paramString1, paramString2, paramString3, paramString4, paramInt2);
  }
  
  public static void a(int paramInt, List<TopicInfo> paramList, String paramString)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TopicInfo localTopicInfo = (TopicInfo)paramList.next();
        if (localTopicInfo != null) {
          a("0X8009817", paramInt, localTopicInfo.a(), paramString);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    RIJJumpUtils.a(paramActivity, paramArticleInfo);
  }
  
  public static void a(Context paramContext, RIJUserLevelDialog.DialogSettingInfo paramDialogSettingInfo)
  {
    if (paramContext == null)
    {
      QLog.d("ReadInJoyUtils", 1, "showErrorDialog! context is null!");
      return;
    }
    paramContext = new RIJUserLevelDialog(paramContext);
    paramContext.a(paramDialogSettingInfo);
    paramContext.show();
  }
  
  public static void a(KandianRedDotInfo paramKandianRedDotInfo)
  {
    RIJLockScreenPushReport.a(paramKandianRedDotInfo);
  }
  
  public static void a(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, Intent paramIntent)
  {
    RIJLockScreenPushReport.a(paramQQMessageFacade, paramMessageRecord, paramIntent);
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    RIJAppSetting.a(paramBaseActivity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    RIJAppSetting.a(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    RIJKanDianTabReport.a(paramQQAppInterface, paramRedTypeInfo);
  }
  
  public static void a(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    String str = "-1";
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1)) {}
      try
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, String.valueOf(paramLong), str, paramString2, "", false);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("ReadInJoyUtils", 1, "reportSelectedTopic error:" + paramString1.toString());
      }
      str = "1";
      continue;
      str = "2";
      continue;
      str = "3";
    }
  }
  
  public static void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    RIJSPUtils.a(paramString, paramObject, paramBoolean);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    RIJStatisticCollectorReport.a(paramAppRuntime, paramBoolean, paramString, paramInt, paramLong);
  }
  
  public static boolean a()
  {
    return RIJAppSetting.d();
  }
  
  public static boolean a(Context paramContext)
  {
    return RIJAppSetting.a(paramContext);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    return RIJFeedsType.m(paramArticleInfo);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return RIJAppSetting.a(paramQQAppInterface);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    return RIJPushNotification.a(paramQQAppInterface, paramMessageRecord);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return RIJPushNotification.a(paramMessageRecord);
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return RIJMergeKanDianMessage.a(paramAbsStructMsg);
  }
  
  public static boolean a(String paramString)
  {
    return TextUtils.equals(AppConstants.WEISHI_UIN, paramString);
  }
  
  public static boolean a(String paramString, long paramLong, ArticleInfo paramArticleInfo)
  {
    return RIJFeedsType.a(paramString, paramLong, paramArticleInfo);
  }
  
  private static byte[] a(String paramString, int paramInt, Bundle paramBundle)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramString;
    localHttpNetReq.mHttpMethod = paramInt;
    if (paramBundle != null)
    {
      paramString = paramBundle.keySet().iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof String)) {
          localHttpNetReq.mReqProperties.put(str, (String)localObject);
        }
      }
    }
    return HttpEngineServiceImpl.transSync(localHttpNetReq).mRespData;
  }
  
  public static byte[] a(String paramString, int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    try
    {
      if (e()) {
        return a(paramString, paramInt, paramBundle2);
      }
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (paramInt == 0) {}
      for (String str = "get";; str = "post") {
        return HttpUtil.openUrlForByte(localBaseApplication, paramString, str, paramBundle1, paramBundle2);
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("ReadInJoyUtils", 1, "sendHttpRequest error! msg=" + paramString);
    }
  }
  
  public static int b()
  {
    return RIJMergeKanDianMessage.a();
  }
  
  public static Integer b(Context paramContext, String paramString)
  {
    return RIJJumpUtils.a(paramContext, paramString);
  }
  
  public static String b()
  {
    return RIJAppSetting.b();
  }
  
  public static void b()
  {
    RIJTransMergeKanDianReport.jdField_a_of_type_Int = -1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    RIJAppSetting.c(paramQQAppInterface);
  }
  
  public static boolean b()
  {
    return KandianOptUtils.a();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return RIJMergeKanDianMessage.c(paramQQAppInterface);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return RIJLockScreenPushReport.a(paramMessageRecord);
  }
  
  public static int c()
  {
    return RIJStudyModeUtils.a();
  }
  
  public static String c()
  {
    return RIJAppSetting.c();
  }
  
  public static void c() {}
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    RIJAppSetting.c(paramQQAppInterface);
  }
  
  public static boolean c()
  {
    return (((Boolean)ReadInJoyHelper.a("preload_controller", Boolean.valueOf(true))).booleanValue()) && (ReadInJoyHelper.o());
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return RIJMergeKanDianMessage.a(paramMessageRecord);
  }
  
  public static void d() {}
  
  public static boolean d()
  {
    return RIJPushNotification.a();
  }
  
  private static boolean e()
  {
    return Aladdin.getConfig(424).getIntegerFromString("use_new_http_engine", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils
 * JD-Core Version:    0.7.0.1
 */