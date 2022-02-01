package com.tencent.biz.qqcircle.flutter;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostRouteUtils;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.activity.QCircleTransFragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCirclePersonEditUpdateEvent;
import com.tencent.biz.qqcircle.flutter.animation.QCircleFlutterAnimationLoader;
import com.tencent.biz.qqcircle.flutter.annotation.ChannelMethodName;
import com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterDanmakuLayer;
import com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterDoubleLikeLayer;
import com.tencent.biz.qqcircle.flutter.richtext.QcircleFlutterTextCellParser;
import com.tencent.biz.qqcircle.fragments.content.QCircleFlutterContentDetailTransFragment;
import com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeManager;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePushMergeReqInterceptor;
import com.tencent.biz.qqcircle.richframework.sender.iml.rsp.QCirclePushRspInterceptor;
import com.tencent.biz.qqcircle.richframework.util.FastClickUtils;
import com.tencent.biz.qqcircle.utils.QCircleTipsUtil;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.BaseCall;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter;
import cooperation.qqcircle.report.QCircleFlutterPluginQualityReporter.ReportData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleLpReportDc05507.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleEnvHub.Tips;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StImageBusiData;
import qqcircle.QQCircleFeedBase.StKuoliePasterData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class QQCircleMethodMine
{
  public static final String COMMENT_CLICK = "CommentClick";
  public static final String COMMENT_INPUT_CLICK = "CommentInputClick";
  public static final String PARAM_IS_POPUP = "param_is_popup";
  public static final String PARAM_LOCATION_CODE = "param_location";
  public static final String PARAM_LOCATION_DESC = "param_location_param";
  public static final String PARAM_REQ_TYPE = "param_req_type";
  public static final String PARAM_SKIP_ACTIVITY_EMPTY_CHECK = "param_skip_activity_empty_check";
  public static final String PRAISE_CLICK = "PraiseClick";
  public static final String SELECT_LOCATION_BROADCAST_CALLBACK = "select_location_broadcast_callback";
  public static final int SELECT_LOCATION_BROADCAST_CALLBACK_QCIRCLE = 2222;
  public static final String SHARE_CLICK = "ShareClick";
  public static final String TAG = "QQCircleMethodMine";
  public static final int TYPE_PORFILE_LOCATION = 2;
  private static FeedCloudMeta.StFeed currentFeed;
  private static Map<String, Object> currentReportParam;
  private static long feedBytesLength;
  private static final BroadcastReceiver flutterReciver = new QQCircleMethodMine.3();
  private static int hasClickCount;
  private static boolean isInitReceiver;
  private static List<String> mStringCache;
  private static QCircleFlutterDanmakuLayer qCircleFlutterDanmakuLayer;
  private static Map<String, FeedCloudMeta.StFeed> stFeedMap = new ConcurrentHashMap();
  private static int totalClickCount;
  
  static
  {
    feedBytesLength = 0L;
    mStringCache = new CopyOnWriteArrayList();
    isInitReceiver = false;
  }
  
  @ChannelMethodName(a="changeFollowState")
  public static void changeFollowState(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @ChannelMethodName(a="checkNetworkReachability")
  public static void checkNetwork(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    boolean bool = HostNetworkUtils.isNetworkAvailable();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[onMethodCall]checkNetworkReachability, network available=");
      paramContext.append(bool);
      QLog.d("QQCircleMethodMine", 1, paramContext.toString());
    }
    paramResult.success(Boolean.valueOf(bool));
  }
  
  @ChannelMethodName(a="removeCache")
  public static void clearCache(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (String)paramMethodCall.argument("key");
    int i;
    try
    {
      i = ((Integer)paramMethodCall.argument("type")).intValue();
    }
    catch (Exception paramView)
    {
      QLog.e("QQCircleMethodMine", 1, "[clearCache] ", paramView);
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("[clearCache] key=");
      paramView.append(paramContext);
      paramView.append(", type=");
      paramView.append(i);
      QLog.d("QQCircleMethodMine", 1, paramView.toString());
    }
    if (TextUtils.isEmpty(paramContext)) {
      QLog.e("QQCircleMethodMine", 1, "[clearCache] invalid key");
    }
    mStringCache.clear();
    paramContext = new File(QCircleApplication.APP.getCacheDir(), "flutter_cache");
    if (!paramContext.delete())
    {
      paramView = new StringBuilder();
      paramView.append("[clearCache] can not delete cache file, ");
      paramView.append(paramContext.getAbsolutePath());
      QLog.w("QQCircleMethodMine", 1, paramView.toString());
    }
    paramResult.success(Integer.valueOf(0));
  }
  
  @ChannelMethodName(a="clickPraise")
  public static void clickPraise(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    for (;;)
    {
      try
      {
        paramContext = (byte[])paramMethodCall.argument("feed");
        bool = ((Boolean)paramMethodCall.argument("isPraise")).booleanValue();
        paramView = new FeedCloudMeta.StFeed();
        paramView.mergeFrom(paramContext);
        if (!bool)
        {
          bool = true;
          QCirclePolyLikeManager.a(paramView, bool);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("QQCircleMethodMine", 1, "clickPraise", paramContext);
        return;
      }
      boolean bool = false;
    }
  }
  
  @ChannelMethodName(a="closeDanmu")
  public static void closeDanmu(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = qCircleFlutterDanmakuLayer;
    if (paramContext != null) {
      paramContext.u();
    }
  }
  
  @ChannelMethodName(a="doPushOperation")
  public static void doPushOperation(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    try
    {
      paramContext = (byte[])paramMethodCall.argument("feed");
      int i = ((Integer)paramMethodCall.argument("pushCount")).intValue();
      paramMethodCall = new FeedCloudMeta.StFeed();
      paramMethodCall.mergeFrom(paramContext);
      paramResult = new QQCircleFeedBase.StFeedBusiReqData();
      paramView = null;
      paramContext = paramView;
      try
      {
        paramResult.mergeFrom(paramMethodCall.busiData.get().toByteArray());
        paramContext = paramView;
        paramView = paramResult.pushList;
        paramContext = paramView;
        hasClickCount = paramView.hasClickCount.get();
        paramContext = paramView;
        totalClickCount = paramView.totalClickCount.get();
        paramContext = paramView;
      }
      catch (Exception paramView)
      {
        QLog.e("QQCircleMethodMine", 1, paramView.getMessage());
      }
      paramContext = new QCircleDoRecommendRequest(paramMethodCall, i, paramContext, 0);
      QCircleRequestSender.a().b().a(new QCirclePushMergeReqInterceptor()).a(new QCirclePushRspInterceptor()).a(paramContext).a(new QQCircleMethodMine.5(paramMethodCall, i)).a();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QQCircleMethodMine", 1, paramContext.getMessage());
    }
  }
  
  @ChannelMethodName(a="doubleClickPraise")
  public static void doubleClickPraise(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    try
    {
      paramContext = (byte[])paramMethodCall.argument("feed");
      paramMethodCall = (Map)paramMethodCall.argument("report_param");
      paramMethodCall = new FeedCloudMeta.StFeed();
      paramMethodCall.mergeFrom(paramContext);
      if (currentFeed != null)
      {
        if (!currentFeed.id.get().equals(paramMethodCall.id.get())) {
          currentFeed = paramMethodCall;
        }
      }
      else {
        currentFeed = paramMethodCall;
      }
      paramContext = (ViewGroup)paramView;
      paramView = new QCircleFlutterDoubleLikeLayer(QCircleSkinHelper.getInstance().getContext());
      paramView.setAnimationEndHandler(new QQCircleMethodMine.6(paramContext));
      paramMethodCall = new QCircleExtraTypeInfo();
      paramResult = new QCircleReportBean();
      paramResult.setPageId(57);
      paramMethodCall.mFeed = currentFeed;
      paramMethodCall.pageType = 57;
      paramView.a(paramMethodCall, paramResult, 0);
      paramContext.addView(paramView);
      paramView.b();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QQCircleMethodMine", 1, "[doubleClickPraise]", paramContext);
    }
  }
  
  public static FeedCloudMeta.StFeed findIdForFeed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Map localMap = stFeedMap;
    if (localMap == null) {
      return null;
    }
    return (FeedCloudMeta.StFeed)localMap.get(paramString);
  }
  
  @ChannelMethodName(a="floatLayerPicPosition")
  public static void floatLayerPicPosition(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramView = (byte[])paramMethodCall.argument("feed");
    paramContext = new FeedCloudMeta.StFeed();
    paramContext.mergeFrom(paramView);
    paramView = (Integer)paramMethodCall.argument("position");
    if (paramView == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("[floatLayerPicPosition] invalid position, ");
      paramContext.append(paramView);
      QLog.w("QQCircleMethodMine", 1, paramContext.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("[floatLayerPicPosition] feedId=");
      paramMethodCall.append(paramContext.id.get());
      paramMethodCall.append(", position=");
      paramMethodCall.append(paramView);
      QLog.d("QQCircleMethodMine", 2, paramMethodCall.toString());
    }
    QCircleFeedDataCenter.a().a(paramContext.id.get(), paramView.intValue());
  }
  
  /* Error */
  @ChannelMethodName(a="asyncGetValue")
  public static void getCache(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 189
    //   3: invokevirtual 195	io/flutter/plugin/common/MethodCall:argument	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 197	java/lang/String
    //   9: astore_0
    //   10: aload_2
    //   11: ldc 199
    //   13: invokevirtual 195	io/flutter/plugin/common/MethodCall:argument	(Ljava/lang/String;)Ljava/lang/Object;
    //   16: checkcast 201	java/lang/Integer
    //   19: invokevirtual 204	java/lang/Integer:intValue	()I
    //   22: istore 4
    //   24: goto +17 -> 41
    //   27: astore_1
    //   28: ldc 41
    //   30: iconst_1
    //   31: ldc_w 477
    //   34: aload_1
    //   35: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   38: iconst_0
    //   39: istore 4
    //   41: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +49 -> 93
    //   47: new 153	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   54: astore_1
    //   55: aload_1
    //   56: ldc_w 479
    //   59: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload_1
    //   64: aload_0
    //   65: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: ldc 214
    //   72: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_1
    //   77: iload 4
    //   79: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: ldc 41
    //   85: iconst_1
    //   86: aload_1
    //   87: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_0
    //   94: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: istore 5
    //   99: aconst_null
    //   100: astore_2
    //   101: aconst_null
    //   102: astore 6
    //   104: aconst_null
    //   105: astore 7
    //   107: iload 5
    //   109: ifeq +19 -> 128
    //   112: ldc 41
    //   114: iconst_1
    //   115: ldc_w 481
    //   118: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_3
    //   122: aconst_null
    //   123: invokeinterface 183 2 0
    //   128: getstatic 79	com/tencent/biz/qqcircle/flutter/QQCircleMethodMine:mStringCache	Ljava/util/List;
    //   131: invokeinterface 483 1 0
    //   136: ifeq +283 -> 419
    //   139: new 485	java/io/FileInputStream
    //   142: dup
    //   143: new 234	java/io/File
    //   146: dup
    //   147: getstatic 240	com/tencent/qcircle/application/QCircleApplication:APP	Landroid/app/Application;
    //   150: invokevirtual 246	android/app/Application:getCacheDir	()Ljava/io/File;
    //   153: ldc 248
    //   155: invokespecial 251	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   158: invokespecial 488	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   161: astore_0
    //   162: new 490	java/io/InputStreamReader
    //   165: dup
    //   166: aload_0
    //   167: ldc_w 492
    //   170: invokespecial 495	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   173: astore_1
    //   174: new 497	java/io/BufferedReader
    //   177: dup
    //   178: aload_1
    //   179: invokespecial 500	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 503	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   187: astore 6
    //   189: aload 6
    //   191: ifnull +17 -> 208
    //   194: getstatic 79	com/tencent/biz/qqcircle/flutter/QQCircleMethodMine:mStringCache	Ljava/util/List;
    //   197: aload 6
    //   199: invokeinterface 506 2 0
    //   204: pop
    //   205: goto -22 -> 183
    //   208: aload_2
    //   209: invokevirtual 509	java/io/BufferedReader:close	()V
    //   212: aload_1
    //   213: invokevirtual 510	java/io/InputStreamReader:close	()V
    //   216: aload_0
    //   217: invokevirtual 511	java/io/FileInputStream:close	()V
    //   220: goto +199 -> 419
    //   223: astore 6
    //   225: aload_0
    //   226: astore_3
    //   227: aload 6
    //   229: astore_0
    //   230: goto +147 -> 377
    //   233: astore 6
    //   235: goto +21 -> 256
    //   238: astore 7
    //   240: aload 6
    //   242: astore_2
    //   243: aload_0
    //   244: astore_3
    //   245: aload 7
    //   247: astore_0
    //   248: goto +129 -> 377
    //   251: astore 6
    //   253: aload 7
    //   255: astore_2
    //   256: aload_0
    //   257: astore 7
    //   259: aload_1
    //   260: astore_0
    //   261: aload 7
    //   263: astore_1
    //   264: goto +44 -> 308
    //   267: astore 7
    //   269: aconst_null
    //   270: astore_1
    //   271: aload 6
    //   273: astore_2
    //   274: aload_0
    //   275: astore_3
    //   276: aload 7
    //   278: astore_0
    //   279: goto +98 -> 377
    //   282: astore 6
    //   284: aload_0
    //   285: astore_1
    //   286: aconst_null
    //   287: astore_0
    //   288: goto +20 -> 308
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_1
    //   294: aload_1
    //   295: astore_3
    //   296: aload 6
    //   298: astore_2
    //   299: goto +78 -> 377
    //   302: astore 6
    //   304: aconst_null
    //   305: astore_0
    //   306: aload_0
    //   307: astore_1
    //   308: ldc 41
    //   310: iconst_1
    //   311: ldc_w 513
    //   314: aload 6
    //   316: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: aload_2
    //   320: ifnull +10 -> 330
    //   323: aload_2
    //   324: invokevirtual 509	java/io/BufferedReader:close	()V
    //   327: goto +3 -> 330
    //   330: aload_0
    //   331: ifnull +7 -> 338
    //   334: aload_0
    //   335: invokevirtual 510	java/io/InputStreamReader:close	()V
    //   338: aload_1
    //   339: ifnull +80 -> 419
    //   342: aload_1
    //   343: invokevirtual 511	java/io/FileInputStream:close	()V
    //   346: goto +73 -> 419
    //   349: ldc 41
    //   351: iconst_1
    //   352: ldc_w 513
    //   355: aload_0
    //   356: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   359: goto +60 -> 419
    //   362: astore 7
    //   364: aload_0
    //   365: astore_3
    //   366: aload_1
    //   367: astore 6
    //   369: aload 7
    //   371: astore_0
    //   372: aload_3
    //   373: astore_1
    //   374: aload 6
    //   376: astore_3
    //   377: aload_2
    //   378: ifnull +10 -> 388
    //   381: aload_2
    //   382: invokevirtual 509	java/io/BufferedReader:close	()V
    //   385: goto +3 -> 388
    //   388: aload_1
    //   389: ifnull +7 -> 396
    //   392: aload_1
    //   393: invokevirtual 510	java/io/InputStreamReader:close	()V
    //   396: aload_3
    //   397: ifnull +20 -> 417
    //   400: aload_3
    //   401: invokevirtual 511	java/io/FileInputStream:close	()V
    //   404: goto +13 -> 417
    //   407: ldc 41
    //   409: iconst_1
    //   410: ldc_w 513
    //   413: aload_1
    //   414: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   417: aload_0
    //   418: athrow
    //   419: new 515	java/util/ArrayList
    //   422: dup
    //   423: getstatic 79	com/tencent/biz/qqcircle/flutter/QQCircleMethodMine:mStringCache	Ljava/util/List;
    //   426: invokespecial 518	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   429: astore_0
    //   430: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +35 -> 468
    //   436: new 153	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   443: astore_1
    //   444: aload_1
    //   445: ldc_w 520
    //   448: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_1
    //   453: aload_0
    //   454: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: ldc 41
    //   460: iconst_1
    //   461: aload_1
    //   462: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_3
    //   469: aload_0
    //   470: invokeinterface 183 2 0
    //   475: return
    //   476: astore_0
    //   477: goto -128 -> 349
    //   480: astore_1
    //   481: goto -74 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramView	View
    //   0	484	2	paramMethodCall	MethodCall
    //   0	484	3	paramResult	MethodChannel.Result
    //   22	56	4	i	int
    //   97	11	5	bool	boolean
    //   102	96	6	str	String
    //   223	5	6	localObject1	Object
    //   233	8	6	localException1	Exception
    //   251	21	6	localException2	Exception
    //   282	15	6	localException3	Exception
    //   302	13	6	localException4	Exception
    //   367	8	6	localView	View
    //   105	1	7	localObject2	Object
    //   238	16	7	localObject3	Object
    //   257	5	7	localContext	Context
    //   267	10	7	localObject4	Object
    //   362	8	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   10	24	27	java/lang/Exception
    //   183	189	223	finally
    //   194	205	223	finally
    //   183	189	233	java/lang/Exception
    //   194	205	233	java/lang/Exception
    //   174	183	238	finally
    //   174	183	251	java/lang/Exception
    //   162	174	267	finally
    //   162	174	282	java/lang/Exception
    //   139	162	291	finally
    //   139	162	302	java/lang/Exception
    //   308	319	362	finally
    //   208	220	476	java/lang/Exception
    //   323	327	476	java/lang/Exception
    //   334	338	476	java/lang/Exception
    //   342	346	476	java/lang/Exception
    //   381	385	480	java/lang/Exception
    //   392	396	480	java/lang/Exception
    //   400	404	480	java/lang/Exception
  }
  
  public static FeedCloudMeta.StFeed getCurrentFeed()
  {
    return currentFeed;
  }
  
  public static Map<String, Object> getCurrentReportParam()
  {
    return currentReportParam;
  }
  
  @ChannelMethodName(a="getWnsConfig")
  public static void getWnsConfig(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramResult.success(QCircleConfigHelper.a((String)paramMethodCall.argument("mainKey"), (String)paramMethodCall.argument("spKey"), paramMethodCall.argument("defaultValue")));
  }
  
  @ChannelMethodName(a="openHomepage")
  public static void gotoMainPage(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (String)paramMethodCall.argument("pb_id");
    paramView = (Boolean)paramMethodCall.argument("isFromQQSearch");
    if (QLog.isColorLevel())
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("[gotoMainPage] uin");
      paramMethodCall.append(paramContext);
      QLog.d("QQCircleMethodMine", 2, paramMethodCall.toString());
    }
    paramMethodCall = new HashMap();
    paramMethodCall.put("uin", paramContext);
    if ((paramView != null) && (paramView.booleanValue()))
    {
      paramMethodCall.put("xsj_main_entrance", "qq_searchbar_results");
      paramMethodCall.put("xsj_sub_entrance", "more_users");
    }
    paramContext = new QCircleSchemeBean();
    paramContext.setSchemeAction("openmainpage");
    paramContext.setAttrs(paramMethodCall);
    QCircleSchemeLauncher.a(QCircleApplication.APP, paramContext);
    paramResult.success(Integer.valueOf(0));
  }
  
  @ChannelMethodName(a="handleUrl")
  public static void handleUrl(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramView = (String)paramMethodCall.argument("url");
    if (TextUtils.isEmpty(paramView))
    {
      QLog.d("QQCircleMethodMine", 1, "handleUrl empty");
      return;
    }
    QCircleLauncher.a(paramContext, paramView);
  }
  
  @ChannelMethodName(a="initDanmu")
  public static void initDanmu(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    try
    {
      if (!QCircleConfigHelper.s())
      {
        QLog.d("QQCircleMethodMine", 1, "[initDanmu] wns closed");
        return;
      }
      paramResult = (byte[])paramMethodCall.argument("feed");
      paramMethodCall = (Map)paramMethodCall.argument("report_param");
      paramContext = new FeedCloudMeta.StFeed();
      if (paramResult == null) {
        return;
      }
      paramContext.mergeFrom(paramResult);
      if ((currentFeed != null) && (currentFeed.id != null))
      {
        if (currentFeed.id.get().equals(paramContext.id.get())) {
          return;
        }
        currentFeed = paramContext;
      }
      else
      {
        currentFeed = paramContext;
      }
      paramResult = new StringBuilder();
      paramResult.append("[initDanmu] feed id=");
      paramResult.append(paramContext.id.get());
      QLog.d("QQCircleMethodMine", 1, paramResult.toString());
      if (!isInitReceiver)
      {
        QLog.d("QQCircleMethodMine", 4, "init danmu receiver");
        SimpleEventBus.getInstance().registerReceiver(QcircleFlutterEventReceiver.a());
        isInitReceiver = true;
        paramResult = new IntentFilter();
        paramResult.addAction("qcircle_flutter_activity_destroy");
        QCircleApplication.APP.registerReceiver(flutterReciver, paramResult);
      }
      if ((paramView != null) && (paramView.findViewWithTag("danmu") != null)) {
        ((ViewGroup)paramView).removeView(paramView.findViewWithTag("danmu"));
      }
      paramView.postDelayed(new QQCircleMethodMine.2(paramContext, paramMethodCall, paramView), 300L);
      if (QCirclePushInfoManager.a().a(paramContext.id.get()) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQCircleMethodMine", 2, "[initDanmu] update push info");
        }
        paramView = new QQCircleFeedBase.StFeedBusiReqData();
        paramView.mergeFrom(paramContext.busiData.get().toByteArray());
        QCirclePushInfoManager.a().a(paramContext.id.get(), paramView.pushList);
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.e("QQCircleMethodMine", 1, "initDanmu", paramContext);
    }
  }
  
  private static void launchFlutterTransparentPage(Context paramContext, HashMap<String, String> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, QCircleTransFragmentActivity.class);
    localIntent.addFlags(65536);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("public_fragment_class", QCircleFlutterContentDetailTransFragment.class.getName());
    localIntent.putExtra("type", (String)paramHashMap.get("type"));
    localIntent.putExtra("only_show_share", (String)paramHashMap.get("only_show_share"));
    localIntent.putExtra("contextHashCode", paramContext.hashCode());
    localIntent.putExtra("param_skip_activity_empty_check", true);
    QCircleApplication.APP.startActivity(localIntent);
  }
  
  private static void launchPage(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (!FastClickUtils.a("QQCircleMethodMinelaunchPage", 500L))
    {
      if (paramContext == null) {
        return;
      }
      launchFlutterTransparentPage(paramContext, paramHashMap);
    }
  }
  
  @ChannelMethodName(a="loadNoNetImgs")
  public static void loadNoNetworkImage(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramView = RFWDownloaderFactory.getDownloader(QCirclePluginConfig.e()).getDefaultSavePath("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_fullscreen_disconnect.png");
    paramContext = new HashMap();
    if (new File(paramView).exists())
    {
      paramContext.put("type", "preload");
      paramContext.put("imageFilePath", paramView);
    }
    else
    {
      paramContext.put("type", "local");
      paramContext.put("imageFilePath", "local");
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("[loadNoNetworkImage] map=");
      paramView.append(paramContext);
      QLog.d("QQCircleMethodMine", 2, paramView.toString());
    }
    paramResult.success(paramContext);
  }
  
  @ChannelMethodName(a="openCommentInputView")
  public static void openCommentInputView(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (!FastClickUtils.a("QQCircleMethodMineShowCommentInputView", 500L))
    {
      if (paramView.getContext() == null) {
        return;
      }
      if (paramMethodCall == null)
      {
        QLog.w("QQCircleMethodMine", 1, "[ShowCommentInputView] invalid map");
        return;
      }
      paramContext = (byte[])paramMethodCall.argument("feed");
      if (paramContext != null)
      {
        paramResult = new FeedCloudMeta.StFeed();
        try
        {
          paramResult.mergeFrom(paramContext);
          currentFeed = paramResult;
          currentReportParam = (Map)paramMethodCall.argument("report_param");
        }
        catch (InvalidProtocolBufferMicroException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext = new HashMap();
      paramContext.put("type", "CommentInputClick");
      launchPage(paramView.getContext(), paramContext);
    }
  }
  
  @ChannelMethodName(a="openCommentView")
  public static void openCommentView(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (!FastClickUtils.a("QQCircleMethodMineShowCommentView", 500L))
    {
      if (paramView.getContext() == null) {
        return;
      }
      if (paramMethodCall == null)
      {
        QLog.w("QQCircleMethodMine", 1, "[ShowCommentView] invalid map");
        return;
      }
      paramContext = (byte[])paramMethodCall.argument("feed");
      if (paramContext != null)
      {
        paramResult = new FeedCloudMeta.StFeed();
        try
        {
          paramResult.mergeFrom(paramContext);
          if (currentFeed != null)
          {
            if (!currentFeed.id.get().equals(paramResult.id.get())) {
              currentFeed = paramResult;
            }
          }
          else {
            currentFeed = paramResult;
          }
          currentReportParam = (Map)paramMethodCall.argument("report_param");
        }
        catch (InvalidProtocolBufferMicroException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext = new HashMap();
      paramContext.put("type", "CommentClick");
      launchPage(paramView.getContext(), paramContext);
    }
  }
  
  @ChannelMethodName(a="openDetailpage")
  public static void openDetailPage(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (String)paramMethodCall.argument("feedID");
    paramView = (String)paramMethodCall.argument("userID");
    String str1 = (String)paramMethodCall.argument("createTime");
    String str2 = (String)paramMethodCall.argument("shareentrance");
    String str3 = (String)paramMethodCall.argument("sharecategory");
    paramMethodCall = (Boolean)paramMethodCall.argument("isFromQQSearch");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[openDetailPage] feedid=");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(", userid=");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(", createtime=");
      ((StringBuilder)localObject).append(str1);
      QLog.d("QQCircleMethodMine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("feedid", paramContext);
    ((HashMap)localObject).put("uin", paramView);
    ((HashMap)localObject).put("createtime", str1);
    ((HashMap)localObject).put("issinglefeed", "1");
    ((HashMap)localObject).put("is_feed_detail", "1");
    if (str3 != null) {
      ((HashMap)localObject).put("sharecategory", str3);
    }
    if (str2 != null) {
      ((HashMap)localObject).put("shareentrance", str2);
    }
    if ((paramMethodCall != null) && (paramMethodCall.booleanValue()))
    {
      ((HashMap)localObject).put("xsj_main_entrance", "qq_searchbar_results");
      ((HashMap)localObject).put("xsj_sub_entrance", "more_feeds");
    }
    paramContext = new QCircleSchemeBean();
    paramContext.setSchemeAction("opendetail");
    paramContext.setAttrs((HashMap)localObject);
    QCircleSchemeLauncher.a(QCircleApplication.APP, paramContext);
    paramResult.success(Integer.valueOf(0));
  }
  
  @ChannelMethodName(a="openPage")
  public static void openPage(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (String)paramMethodCall.argument("scheme");
    if ("openpolymerize".equals(paramContext))
    {
      paramContext = (Integer)paramMethodCall.argument("source_type");
      if (16 == paramContext.intValue())
      {
        paramView = (byte[])paramMethodCall.argument("feed");
        if (paramView == null)
        {
          QLog.w("QQCircleMethodMine", 1, "[openPage] invalid feedBuffer");
          return;
        }
        paramContext = new FeedCloudMeta.StFeed();
        paramContext.mergeFrom(paramView);
        paramView = new QCirclePolymerizationBean();
        paramMethodCall = new QQCircleFeedBase.StFeedListBusiReqData();
        paramMethodCall.gpsInfo = paramContext.poiInfo.gps;
        paramView.setFeedListBusiReqData(paramMethodCall);
        paramView.setPolymerizationType(16);
        paramView.setExt1From(1);
        paramView.setPoiInfo(paramContext.poiInfo);
        QCircleLauncher.a(QCircleApplication.APP, paramView);
      }
      else if (20 == paramContext.intValue())
      {
        paramView = (byte[])paramMethodCall.argument("simulate_data");
        if (paramView == null)
        {
          QLog.w("QQCircleMethodMine", 1, "[openPage] invalid simulateDataBuffer");
          return;
        }
        paramContext = new QQCircleFeedBase.StSimulateData();
        paramContext.mergeFrom(paramView);
        paramView = new QCirclePolymerizationBean();
        paramView.setSimulateData(paramContext);
        paramView.setPolymerizationType(20);
        paramView.setExt1From(2);
        QCircleLauncher.a(QCircleApplication.APP, paramView);
      }
      else if (7 == paramContext.intValue())
      {
        paramView = (String)paramMethodCall.argument("tagID");
        paramContext = (String)paramMethodCall.argument("tagName");
        if (QLog.isColorLevel())
        {
          paramMethodCall = new StringBuilder();
          paramMethodCall.append("[openPage] tagId=");
          paramMethodCall.append(paramView);
          paramMethodCall.append(", tagName=");
          paramMethodCall.append(paramContext);
          QLog.d("QQCircleMethodMine", 2, paramMethodCall.toString());
        }
        paramView = new QCirclePolymerizationBean();
        paramMethodCall = new FeedCloudMeta.StTagInfo();
        paramMethodCall.tagName.set(paramContext);
        paramView.setTagInfo(paramMethodCall);
        paramView.setPolymerizationType(7);
        paramView.setExt1From(3);
        QCircleLauncher.a(QCircleApplication.APP, paramView);
      }
    }
    else if ("openmainpage".equals(paramContext))
    {
      paramContext = (String)paramMethodCall.argument("pb_id");
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("[openPage] main page, uin=");
        paramView.append(paramContext);
        QLog.d("QQCircleMethodMine", 2, paramView.toString());
      }
      paramView = new HashMap();
      paramView.put("uin", paramContext);
      paramContext = new QCircleSchemeBean();
      paramContext.setSchemeAction("openmainpage");
      paramContext.setAttrs(paramView);
      QCircleSchemeLauncher.a(QCircleApplication.APP, paramContext);
    }
    else if ("openfriendlist".equals(paramContext))
    {
      QCircleHostLauncher.startNewFriendList(QCircleApplication.APP);
    }
    else if ("openaddfriend".equals(paramContext))
    {
      paramContext = (String)paramMethodCall.argument("feed_id");
      paramView = (Integer)paramMethodCall.argument("photo_index");
      if ((paramView != null) && (!TextUtils.isEmpty(paramContext)))
      {
        if (QLog.isColorLevel())
        {
          paramMethodCall = new StringBuilder();
          paramMethodCall.append("[openPage] openaddfriend, feedId=");
          paramMethodCall.append(paramContext);
          paramMethodCall.append(", photoIndex=");
          paramMethodCall.append(paramView);
          QLog.d("QQCircleMethodMine", 2, paramMethodCall.toString());
        }
        paramContext = (FeedCloudMeta.StFeed)stFeedMap.get(paramContext);
        if (paramContext.type.get() == 2)
        {
          paramMethodCall = new QQCircleFeedBase.StImageBusiData();
          paramMethodCall.mergeFrom(((FeedCloudMeta.StImage)paramContext.images.get(paramView.intValue())).busiData.get().toByteArray());
          paramView = ((QQCircleFeedBase.StKuoliePasterData)paramMethodCall.kuolie_data.get()).trans_info.get().toByteArray();
          QCircleHostLauncher.startAddFriend(QCircleApplication.APP, paramContext.poster.id.get(), paramContext.poster.nick.get(), QCirclePluginUtil.c((FeedCloudMeta.StUser)paramContext.poster.get()), true, paramView);
        }
        else if (paramContext.type.get() == 3)
        {
          paramView = new QQCircleFeedBase.StVideoBusiData();
          paramView.mergeFrom(paramContext.video.busiData.get().toByteArray());
          paramView = ((QQCircleFeedBase.StKuoliePasterData)paramView.kuolie_data.get()).trans_info.get().toByteArray();
          QCircleHostLauncher.startAddFriend(QCircleApplication.APP, paramContext.poster.id.get(), paramContext.poster.nick.get(), QCirclePluginUtil.c((FeedCloudMeta.StUser)paramContext.poster.get()), true, paramView);
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("[openPage] openaddfriend, feed type not supported, type=");
          paramView.append(paramContext.type.get());
          QLog.w("QQCircleMethodMine", 1, paramView.toString());
        }
      }
      else
      {
        paramMethodCall = new StringBuilder();
        paramMethodCall.append("[openPage] openaddfriend, invalid params, feedId=");
        paramMethodCall.append(paramContext);
        paramMethodCall.append(", photoIndex=");
        paramMethodCall.append(paramView);
        QLog.w("QQCircleMethodMine", 1, paramMethodCall.toString());
      }
    }
    else
    {
      if (QCircleHostConstants._AppSetting.isDebugVersion()) {
        break label911;
      }
    }
    paramResult.success(Integer.valueOf(0));
    return;
    label911:
    paramView = new StringBuilder();
    paramView.append("scheme: ");
    paramView.append(paramContext);
    paramView.append(" not supported yet");
    throw new InvalidParameterException(paramView.toString());
  }
  
  @ChannelMethodName(a="openShareView")
  public static void openShareView(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (!FastClickUtils.a("QQCircleMethodMineShowShareView", 500L))
    {
      if (paramView.getContext() == null) {
        return;
      }
      if (paramMethodCall == null)
      {
        QLog.w("QQCircleMethodMine", 1, "[ShowShareView] invalid map");
        return;
      }
      paramContext = (Integer)paramMethodCall.argument("only_show_share");
      paramResult = (String)paramMethodCall.argument("feed_id");
      FeedCloudMeta.StFeed localStFeed;
      if ((!TextUtils.isEmpty(paramResult)) && (stFeedMap.containsKey(paramResult)))
      {
        currentFeed = (FeedCloudMeta.StFeed)stFeedMap.get(paramResult);
      }
      else
      {
        paramResult = (byte[])paramMethodCall.argument("feed");
        localStFeed = new FeedCloudMeta.StFeed();
      }
      try
      {
        localStFeed.mergeFrom(paramResult);
        if (currentFeed != null)
        {
          if (!currentFeed.id.get().equals(localStFeed.id.get())) {
            currentFeed = localStFeed;
          }
        }
        else {
          currentFeed = localStFeed;
        }
        currentReportParam = (Map)paramMethodCall.argument("report_param");
        paramMethodCall = new HashMap();
        paramMethodCall.put("type", "ShareClick");
        if (paramContext != null)
        {
          if (paramContext.intValue() == 1) {
            paramContext = "1";
          } else {
            paramContext = "0";
          }
          paramMethodCall.put("only_show_share", paramContext);
        }
        launchPage(paramView.getContext(), paramMethodCall);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QQCircleMethodMine", 1, "[openShareView]", paramContext);
      }
    }
  }
  
  @ChannelMethodName(a="openTagpage")
  public static void openTagPage(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramView = (String)paramMethodCall.argument("tagID");
    String str = (String)paramMethodCall.argument("tagName");
    paramMethodCall = (Boolean)paramMethodCall.argument("isFromQQSearch");
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[openTagPage] tagId=");
      paramContext.append(paramView);
      paramContext.append(", tagName=");
      paramContext.append(str);
      QLog.d("QQCircleMethodMine", 2, paramContext.toString());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("sourcetype", String.valueOf(7));
    paramContext = paramView;
    if (paramView == null) {
      paramContext = "";
    }
    localHashMap.put("tagid", paramContext);
    localHashMap.put("tagname", str);
    if ((paramMethodCall != null) && (paramMethodCall.booleanValue()))
    {
      localHashMap.put("xsj_main_entrance", "qq_searchbar_results");
      localHashMap.put("xsj_sub_entrance", "more_hashtag");
    }
    paramContext = new QCircleSchemeBean();
    paramContext.setSchemeAction("openpolymerize");
    paramContext.setAttrs(localHashMap);
    QCircleSchemeLauncher.a(QCircleApplication.APP, paramContext);
    paramResult.success(Integer.valueOf(0));
  }
  
  @ChannelMethodName(a="parseText")
  public static void parseText(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (String)paramMethodCall.argument("content");
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("[parseText] parseText content=");
      paramView.append(paramContext);
      QLog.d("QQCircleMethodMine", 1, paramView.toString());
    }
    if (TextUtils.isEmpty(paramContext)) {
      QLog.e("QQCircleMethodMine", 1, "[parseText] parseText invalid key");
    }
    if (TextUtils.isEmpty(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCircleMethodMine", 2, "[parseText] content is null");
      }
      return;
    }
    paramResult.success(QcircleFlutterTextCellParser.a(paramContext));
  }
  
  @ChannelMethodName(a="parseTextBatch")
  public static void parseTextBatch(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramView = (Map)paramMethodCall.argument("contentMap");
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCircleMethodMine", 2, "parseTextBatch content is null");
      }
      return;
    }
    paramContext = new HashMap();
    paramView = paramView.entrySet().iterator();
    while (paramView.hasNext())
    {
      paramMethodCall = (Map.Entry)paramView.next();
      paramContext.put(paramMethodCall.getKey(), QcircleFlutterTextCellParser.a((CharSequence)paramMethodCall.getValue()));
    }
    paramView = new HashMap();
    paramView.put("textListNodes", paramContext);
    paramResult.success(paramView);
  }
  
  @ChannelMethodName(a="preloadFeeds")
  public static void preloadFeeds(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramView = (List)paramMethodCall.argument("feeds");
    paramResult = new ArrayList();
    Iterator localIterator = paramView.iterator();
    for (paramView = null; localIterator.hasNext(); paramView = paramMethodCall)
    {
      paramMethodCall = (byte[])localIterator.next();
      FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
      localStFeed.mergeFrom(paramMethodCall);
      if ((localStFeed.images.get() != null) && (localStFeed.images.size() > 0))
      {
        paramMethodCall = localStFeed.images.get().iterator();
        while (paramMethodCall.hasNext())
        {
          FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)paramMethodCall.next();
          Option localOption = new Option();
          localOption.setPredecode(false).setUrl(localStImage.picUrl.get());
          QCircleFeedPicLoader.g().loadImage(localOption, null);
        }
      }
      if (localStFeed.cover.get() != null)
      {
        paramMethodCall = new Option();
        paramMethodCall.setUrl(((FeedCloudMeta.StImage)localStFeed.cover.get()).picUrl.get()).setPredecode(false);
        QCircleFeedPicLoader.g().loadImage(paramMethodCall, null);
      }
      paramMethodCall = paramView;
      if (localStFeed.video != null)
      {
        paramMethodCall = paramView;
        if (!TextUtils.isEmpty(localStFeed.video.playUrl.get()))
        {
          paramMethodCall = paramView;
          if (paramView == null)
          {
            if (paramContext != null) {
              paramView = Integer.valueOf(paramContext.hashCode());
            } else {
              paramView = null;
            }
            paramMethodCall = new QCircleVideoPreloadHelper(paramView.intValue());
          }
          paramMethodCall.a(localStFeed);
        }
      }
      paramResult.add(localStFeed);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[preloadFeeds] size=");
      paramContext.append(paramResult.size());
      QLog.d("QQCircleMethodMine", 2, paramContext.toString());
    }
  }
  
  @ChannelMethodName(a="preloadPushAnimResource")
  public static void preloadPushAnimResource(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    QCircleFlutterAnimationLoader.a().a(new QQCircleMethodMine.1(paramView, paramResult));
    QCircleFlutterAnimationLoader.a().b();
  }
  
  @ChannelMethodName(a="pushFeedbackTipsInfo")
  public static void pushFeedbackTipsInfo(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramView = new HashMap();
    if (QCircleTipsUtil.b())
    {
      paramMethodCall = QCircleTipsUtil.a(1);
      if (paramMethodCall == null) {
        paramContext = "";
      } else {
        paramContext = paramMethodCall.text.get();
      }
      paramView.put("title", paramContext);
      int i;
      if (paramMethodCall == null) {
        i = 0;
      } else {
        i = paramMethodCall.durationMs.get();
      }
      paramView.put("duration", Integer.valueOf(i));
      QCircleTipsUtil.a(HostDataTransUtils.getAccount(), paramMethodCall);
    }
    paramResult.success(paramView);
  }
  
  public static void putFeedInfo(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.d("QQCircleMethodMine", 1, "[putFeedInfo] feed should be not null.");
      return;
    }
    String str = paramStFeed.id.get();
    if (TextUtils.isEmpty(str))
    {
      QLog.d("QQCircleMethodMine", 1, "[putFeedInfo] feed id not is empty.");
      return;
    }
    if (stFeedMap.containsKey(str)) {
      return;
    }
    stFeedMap.put(str, paramStFeed);
  }
  
  @ChannelMethodName(a="reportAstEvent")
  public static void reportAstEvent(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (paramMethodCall == null)
    {
      QLog.w("QQCircleMethodMine", 1, "[reportAstEvent] invalid map");
      return;
    }
    for (;;)
    {
      try
      {
        paramContext = (HashMap)paramMethodCall.argument("event");
        paramView = (String)paramContext.get("event");
        int i = ((Integer)paramContext.get("timecost")).intValue();
        paramContext = (List)paramContext.get("steps");
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          paramContext = new QCircleFlutterPluginQualityReporter.ReportData().setEventId(paramView).setCheckCode(paramContext);
          paramView = new StringBuilder();
          paramView.append(i);
          paramView.append("");
          QCircleFlutterPluginQualityReporter.report(paramContext.setTimeCost(paramView.toString()).setRetCode(0L));
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("QQCircleMethodMine", 1, "reportAstEvent", paramContext);
        return;
      }
      paramContext = "";
    }
  }
  
  @ChannelMethodName(a="parseReportBatch")
  public static void reportBatch(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (List)paramMethodCall.argument("reportModels");
    if ((paramContext != null) && (!paramContext.isEmpty())) {
      try
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          paramView = (Map)paramContext.next();
          reportDC05504(((Integer)paramView.get("action")).intValue(), ((Integer)paramView.get("secondAction")).intValue(), ((Integer)paramView.get("thirdAction")).intValue(), (Map)paramView.get("extInfo"), ((Boolean)paramView.get("immediately")).booleanValue());
        }
        paramResult.success(Integer.valueOf(0));
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QQCircleMethodMine", 2, "reportBatch", paramContext);
        return;
      }
    }
    QLog.w("QQCircleMethodMine", 1, "[reportBatch] invalid list");
  }
  
  private static void reportDC05504(int paramInt1, int paramInt2, int paramInt3, Map<String, Object> paramMap, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onMethodCall]reportReadOp action=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", subAction=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", thirdAction=");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(", map=");
      ((StringBuilder)localObject1).append(paramMap);
      QLog.d("QQCircleMethodMine", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject4 = "";
    Object localObject2 = null;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    String str;
    Object localObject3;
    if (paramMap != null)
    {
      if (paramMap.get("uin") == null) {
        localObject1 = null;
      } else {
        localObject1 = String.valueOf(paramMap.get("uin"));
      }
      if (paramMap.get("touin") != null) {
        localObject1 = String.valueOf(paramMap.get("touin"));
      }
      if (paramMap.get("commExtReportInfo") == null) {
        arrayOfByte1 = null;
      } else {
        arrayOfByte1 = (byte[])paramMap.get("commExtReportInfo");
      }
      if (paramMap.get("msgReportInfo") == null) {
        arrayOfByte2 = null;
      } else {
        arrayOfByte2 = (byte[])paramMap.get("msgReportInfo");
      }
      if (paramMap.get("ext5") == null) {
        str = null;
      } else {
        str = String.valueOf(paramMap.get("ext5"));
      }
      if (paramMap.get("ext6") == null) {
        localObject3 = null;
      } else {
        localObject3 = String.valueOf(paramMap.get("ext6"));
      }
      if (paramMap.get("ext7") == null)
      {
        localObject4 = localObject1;
      }
      else
      {
        localObject2 = String.valueOf(paramMap.get("ext7"));
        localObject4 = localObject1;
      }
    }
    else
    {
      str = "";
      localObject1 = str;
      arrayOfByte1 = null;
      arrayOfByte2 = arrayOfByte1;
      localObject2 = localObject1;
      localObject3 = localObject1;
    }
    int j = -1;
    if (49 == paramInt1)
    {
      i = 28;
    }
    else if (50 == paramInt1)
    {
      i = 29;
    }
    else if (51 == paramInt1)
    {
      i = 30;
    }
    else
    {
      i = j;
      if (paramMap.get("page_id") == null) {}
    }
    try
    {
      i = Integer.parseInt(String.valueOf(paramMap.get("page_id")));
    }
    catch (Exception paramMap)
    {
      label436:
      break label436;
    }
    paramMap = new StringBuilder();
    paramMap.append("parse pageId error:");
    paramMap.append(-1);
    QLog.e("QQCircleMethodMine", 1, paramMap.toString());
    int i = j;
    paramMap = new QCircleLpReportDc05504.DataBuilder();
    paramMap.setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setToUin((String)localObject4).setExt5(str).setExt6((String)localObject3).setExt7((String)localObject2).setPageId(i).setMsgReportInfo(arrayOfByte2).setCommonReportInfo(arrayOfByte1);
    QCircleLpReportDc05504.report(paramMap);
  }
  
  private static void reportDC05507(int paramInt1, int paramInt2, int paramInt3, Map<String, Object> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onMethodCall]reportReadOp action=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", subAction=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", thirdAction=");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(", map=");
      ((StringBuilder)localObject1).append(paramMap);
      QLog.d("QQCircleMethodMine", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramMap.get("touin");
    String str4 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = String.valueOf(paramMap.get("touin"));
    }
    String str1;
    if (paramMap.get("ext1") == null) {
      str1 = null;
    } else {
      str1 = String.valueOf(paramMap.get("ext1"));
    }
    String str2;
    if (paramMap.get("ext2") == null) {
      str2 = null;
    } else {
      str2 = String.valueOf(paramMap.get("ext2"));
    }
    String str3;
    if (paramMap.get("ext3") == null) {
      str3 = null;
    } else {
      str3 = String.valueOf(paramMap.get("ext3"));
    }
    Object localObject2 = paramMap.get("photo_index");
    int k = 0;
    if (localObject2 == null) {
      paramInt3 = 0;
    } else {
      paramInt3 = ((Integer)paramMap.get("photo_index")).intValue();
    }
    int i;
    if (paramMap.get("current_index") == null) {
      i = 0;
    } else {
      i = ((Integer)paramMap.get("current_index")).intValue();
    }
    if (paramMap.get("feed_id") != null) {
      str4 = String.valueOf(paramMap.get("feed_id"));
    }
    int j;
    if (paramMap.get("from_page_id") == null) {
      j = 0;
    } else {
      j = ((Integer)paramMap.get("from_page_id")).intValue();
    }
    if (paramMap.get("video_play_time") != null) {
      k = ((Integer)paramMap.get("video_play_time")).intValue();
    }
    paramMap = (FeedCloudMeta.StFeed)stFeedMap.get(str4);
    if (paramMap != null) {
      QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(QCirclePluginReportUtil.d(paramMap).setActionType(paramInt1).setSubActionType(paramInt2).setToUin((String)localObject1)).setPosition(paramInt3).setExt1(str1).setExt2(str2).setExt3(str3).setPosition(i).setPlayScene(2).setVideoPlayTime(k).setPageId(57).setfpageid(j));
    }
  }
  
  @ChannelMethodName(a="reportReadOp")
  public static void reportReadOp(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    int i = ((Integer)paramMethodCall.argument("action")).intValue();
    int j = ((Integer)paramMethodCall.argument("secondAction")).intValue();
    int k = ((Integer)paramMethodCall.argument("thirdAction")).intValue();
    paramContext = (Map)paramMethodCall.argument("extInfo");
    boolean bool = ((Boolean)paramMethodCall.argument("immediately")).booleanValue();
    int m = ((Integer)paramMethodCall.argument("DC")).intValue();
    paramView = Integer.valueOf(0);
    if (m == 5507)
    {
      reportDC05507(i, j, k, paramContext, bool);
      paramResult.success(paramView);
      return;
    }
    if (m == 5504)
    {
      reportDC05504(i, j, k, paramContext, bool);
      paramResult.success(paramView);
    }
  }
  
  @ChannelMethodName(a="cacheData")
  public static void saveCache(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (String)paramMethodCall.argument("key");
    int i;
    try
    {
      i = ((Integer)paramMethodCall.argument("type")).intValue();
    }
    catch (Exception paramView)
    {
      QLog.e("QQCircleMethodMine", 1, "[saveCache] ", paramView);
      i = 0;
    }
    paramView = (List)paramMethodCall.argument("value");
    long l1 = -1L;
    try
    {
      long l2 = ((Long)paramMethodCall.argument("expireTime")).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      QLog.e("QQCircleMethodMine", 1, "[saveCache] ", localException);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[saveCache] key=");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(", type=");
      localStringBuilder.append(i);
      localStringBuilder.append(", value=");
      localStringBuilder.append(paramMethodCall.argument("value"));
      localStringBuilder.append(", expireTime=");
      localStringBuilder.append(l1);
      QLog.d("QQCircleMethodMine", 1, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramContext)) && (paramView != null))
    {
      mStringCache.clear();
      paramContext = paramView.iterator();
      while (paramContext.hasNext())
      {
        paramView = (String)paramContext.next();
        mStringCache.add(paramView);
      }
      RFThreadManager.execute(new QQCircleMethodMine.4(), RFThreadManager.FILE);
      paramResult.success(Integer.valueOf(0));
      return;
    }
    paramMethodCall = new StringBuilder();
    paramMethodCall.append("[saveCache] invalid params, key=");
    paramMethodCall.append(paramContext);
    paramMethodCall.append(", values=");
    paramMethodCall.append(paramView);
    QLog.w("QQCircleMethodMine", 1, paramMethodCall.toString());
  }
  
  @ChannelMethodName(a="saveProfile")
  public static void saveProfile(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    try
    {
      paramContext = new QCirclePersonEditUpdateEvent();
      if (paramMethodCall.hasArgument("nick")) {
        paramContext.setNick((String)paramMethodCall.argument("nick"));
      }
      if (paramMethodCall.hasArgument("gender")) {
        paramContext.setGender(((Integer)paramMethodCall.argument("gender")).intValue());
      }
      if (paramMethodCall.hasArgument("constellation")) {
        paramContext.setConstellation(((Integer)paramMethodCall.argument("constellation")).intValue());
      }
      if (paramMethodCall.hasArgument("school")) {
        paramContext.setSchool((String)paramMethodCall.argument("school"));
      }
      if (paramMethodCall.hasArgument("company")) {
        paramContext.setCompany((String)paramMethodCall.argument("company"));
      }
      if (paramMethodCall.hasArgument("location"))
      {
        paramContext.setLocation((String)paramMethodCall.argument("location"));
        if (paramMethodCall.hasArgument("location_code")) {
          paramContext.setLocationCode((String)paramMethodCall.argument("location_code"));
        }
      }
      if (paramMethodCall.hasArgument("desc")) {
        paramContext.setDesc((String)paramMethodCall.argument("desc"));
      }
      SimpleEventBus.getInstance().dispatchEvent(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QQCircleMethodMine", 1, "saveProfile", paramContext);
    }
  }
  
  @ChannelMethodName(a="selectLocation")
  public static void selectLocation(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramResult = (String)paramMethodCall.argument("location");
    paramMethodCall = (String)paramMethodCall.argument("location_code");
    Bundle localBundle = new Bundle();
    int i = 0;
    localBundle.putBoolean("param_is_popup", false);
    localBundle.putInt("param_req_type", 2);
    paramView = new String[4];
    paramView[0] = "0";
    paramView[1] = "0";
    paramView[2] = "0";
    paramView[3] = "0";
    if (!TextUtils.isEmpty(paramMethodCall))
    {
      paramMethodCall = paramMethodCall.split("-");
      for (;;)
      {
        paramView = paramMethodCall;
        if (i >= paramMethodCall.length) {
          break;
        }
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(paramMethodCall[i]);
          l1 = l2;
        }
        catch (NumberFormatException paramView)
        {
          QLog.e("QQCircleMethodMine", 1, "selectLocation", paramView);
        }
        paramMethodCall[i] = HostRouteUtils.decodeRemoteCode(l1);
        i += 1;
      }
    }
    localBundle.putStringArray("param_location", paramView);
    if (!TextUtils.isEmpty(paramResult)) {
      localBundle.putString("param_location_param", paramResult);
    }
    localBundle.putInt("select_location_broadcast_callback", 2222);
    HostRouteUtils.openLocationSelectActivity(paramContext, localBundle);
  }
  
  @ChannelMethodName(a="selectSchool")
  public static void selectSchool(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    try
    {
      paramMethodCall = (String)paramMethodCall.argument("school");
      paramView = "https://h5.qzone.qq.com/v2/wezone/schoolselect?_wv=16777218&_wwv=1";
      if (!TextUtils.isEmpty(paramMethodCall))
      {
        paramView = new StringBuilder();
        paramView.append("https://h5.qzone.qq.com/v2/wezone/schoolselect?_wv=16777218&_wwv=1");
        paramView.append("&school=");
        paramView.append(paramMethodCall);
        paramView = paramView.toString();
      }
      QCircleLauncher.a(paramContext, paramView, null, -1);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QQCircleMethodMine", 1, "selectSchool", paramContext);
    }
  }
  
  @ChannelMethodName(a="sendSsoRequest")
  public static void sendSsoRequest(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    paramContext = (String)paramMethodCall.argument("cmd");
    paramView = (byte[])paramMethodCall.argument("body");
    if (QLog.isColorLevel())
    {
      paramMethodCall = new StringBuilder();
      paramMethodCall.append("[sendSsoRequest] cmd=");
      paramMethodCall.append(paramContext);
      paramMethodCall.append(", result=");
      paramMethodCall.append(paramResult);
      QLog.d("QQCircleMethodMine", 2, paramMethodCall.toString());
    }
    paramContext = new QCircleFlutterRequest(paramContext, paramView);
    VSNetworkHelper.getInstance().sendRequest(paramContext, new QQCircleMethodMine.8(paramResult));
  }
  
  @ChannelMethodName(a="openPloyLikeView")
  public static void showPraiseView(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (!FastClickUtils.a("QQCircleMethodMineShowPraiseView", 500L))
    {
      if (paramView.getContext() == null) {
        return;
      }
      if (paramMethodCall == null)
      {
        QLog.w("QQCircleMethodMine", 1, "[ShowPraiseView] invalid map");
        return;
      }
      paramContext = (byte[])paramMethodCall.argument("feed");
      paramResult = new FeedCloudMeta.StFeed();
      try
      {
        paramResult.mergeFrom(paramContext);
        if (currentFeed != null)
        {
          if (!currentFeed.id.get().equals(paramResult.id.get())) {
            currentFeed = paramResult;
          }
        }
        else {
          currentFeed = paramResult;
        }
        currentReportParam = (Map)paramMethodCall.argument("report_param");
      }
      catch (InvalidProtocolBufferMicroException paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = new HashMap();
      paramContext.put("type", "PraiseClick");
      launchPage(paramView.getContext(), paramContext);
    }
  }
  
  public static void updateFollowStatus(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[updateFollowStatus] uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", followStatus=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQCircleMethodMine", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label194;
      }
      QLog.w("QQCircleMethodMine", 1, "[updateFollowStatus] invalid uin");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQCircleMethodMine", 1, "[updateFollowStatus]", paramString);
    }
    Object localObject = stFeedMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (paramString.equals(((FeedCloudMeta.StFeed)localEntry.getValue()).poster.id.get())) {
        ((FeedCloudMeta.StFeed)localEntry.getValue()).poster.followState.set(paramInt);
      }
    }
    for (;;)
    {
      paramString = new StringBuilder();
      paramString.append("[updateFollowStatus] invalid followStatus, followStatus=");
      paramString.append(paramInt);
      QLog.w("QQCircleMethodMine", 1, paramString.toString());
      return;
      return;
      label194:
      if (paramInt >= 0) {
        if (paramInt <= 3) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine
 * JD-Core Version:    0.7.0.1
 */