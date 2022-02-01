package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.NativeAd.report.AdRefreshReportManager;
import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.constant.RIJAdConstants.AdvertisementInfoModule;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdvertisementInfoModule;
import com.tencent.mobileqq.kandian.base.msf.api.IReadInJoyEngineModuleConstants;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.ValueReference;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.biz.ad.IRIJAdvertisementRequestProxy;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.daily.api.IReadInJoyDailySettingModel;
import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface.FixPosArticleAsyncListener;
import com.tencent.mobileqq.kandian.biz.feeds.api.IFeedsPreloadHelper;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFeedsType;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyProteusFamilyUtil;
import com.tencent.mobileqq.kandian.biz.pts.api.IRealTimeController;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.api.IFeedsRefreshUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PosAdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdPosMap;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdReqInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PhoneInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle;

public class AdvertisementInfoModule
  implements IRIJAdvertisementInfoModule, IReadInJoyEngineModuleConstants
{
  private LinkedHashMap<Integer, Long> a = new LinkedHashMap();
  private LinkedHashMap<Integer, Long> b = new LinkedHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Integer, AdvertisementInfo>> c = new LinkedHashMap();
  private LinkedHashMap<Integer, Pair<Integer, Integer>> d = new LinkedHashMap();
  private LinkedHashMap<Integer, Boolean> e = new LinkedHashMap();
  private ConcurrentHashMap<Integer, WeakReference<FixPosArticleInterface.FixPosArticleAsyncListener>> f = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, HashSet<String>> g = new ConcurrentHashMap();
  
  public AdvertisementInfoModule()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private String a(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    int i = (int)paramAdvertisementInfo.mChannelID;
    if (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(i)) {
      paramString = "RIJAdRefreshSceneDaily";
    }
    if (i == 0) {
      paramString = "RIJAdRefreshSceneMainFeeds";
    }
    if (56 == i) {
      paramString = "RIJAdRefreshSceneVideoTab";
    }
    if ((78888888 == i) || (78888889 == i) || (88888888 == i)) {
      paramString = "RIJAdRefreshSceneFloatVideo";
    }
    return paramString;
  }
  
  /* Error */
  private List<AdvertisementInfo> a(int paramInt, ValueReference<Integer> paramValueReference, long paramLong1, ValueReference<Boolean> paramValueReference1, ValueReference<Boolean> paramValueReference2, long paramLong2, List<articlesummary.ArticleSummary> paramList)
  {
    // Byte code:
    //   0: new 98	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 99	java/util/ArrayList:<init>	()V
    //   7: astore 17
    //   9: aload 9
    //   11: invokeinterface 105 1 0
    //   16: astore 9
    //   18: iconst_0
    //   19: istore 10
    //   21: aload 9
    //   23: invokeinterface 110 1 0
    //   28: ifeq +820 -> 848
    //   31: aload 9
    //   33: invokeinterface 114 1 0
    //   38: checkcast 116	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary
    //   41: astore 19
    //   43: aload 19
    //   45: getfield 120	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   48: invokevirtual 125	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:has	()Z
    //   51: ifeq +794 -> 845
    //   54: aload 19
    //   56: getfield 120	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   59: invokevirtual 129	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   62: checkcast 122	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   65: getfield 133	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   68: invokevirtual 136	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:has	()Z
    //   71: ifeq +774 -> 845
    //   74: aload 19
    //   76: getfield 120	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   79: invokevirtual 129	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 122	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   85: getfield 133	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   88: invokevirtual 137	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 135	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo
    //   94: astore 18
    //   96: aload 18
    //   98: ifnull +747 -> 845
    //   101: aload 18
    //   103: getfield 141	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:int32_ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   106: invokevirtual 146	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   109: ifne +736 -> 845
    //   112: aload 18
    //   114: getfield 150	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:enum_pos_layout	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   117: invokevirtual 153	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   120: istore 11
    //   122: aload 18
    //   124: getfield 157	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:uint64_pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   127: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   130: lstore 12
    //   132: aload 18
    //   134: getfield 165	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:is_auto_play	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   137: invokevirtual 162	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   140: lstore 14
    //   142: aload 18
    //   144: getfield 169	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:msg_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;
    //   147: invokevirtual 172	tencent/im/oidb/articlesummary/articlesummary$AdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 171	tencent/im/oidb/articlesummary/articlesummary$AdInfo
    //   153: astore 18
    //   155: aload_0
    //   156: iload_1
    //   157: aload_2
    //   158: aload 18
    //   160: invokespecial 175	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(ILcom/tencent/mobileqq/kandian/base/utils/ValueReference;Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   163: new 64	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   166: dup
    //   167: aload 18
    //   169: invokespecial 178	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:<init>	(Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   172: astore 18
    //   174: ldc 180
    //   176: invokestatic 76	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   179: checkcast 180	com/tencent/mobileqq/kandian/ad/api/IRIJAdUtilService
    //   182: aload 18
    //   184: invokeinterface 184 2 0
    //   189: ldc 186
    //   191: invokestatic 76	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   194: checkcast 186	com/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyMSFHandlerUtils
    //   197: aload 19
    //   199: aload_2
    //   200: invokevirtual 190	com/tencent/mobileqq/kandian/base/utils/ValueReference:a	()Ljava/lang/Object;
    //   203: checkcast 192	java/lang/Integer
    //   206: invokevirtual 195	java/lang/Integer:intValue	()I
    //   209: iconst_0
    //   210: aload 18
    //   212: invokeinterface 199 5 0
    //   217: pop
    //   218: aload 18
    //   220: lload_3
    //   221: putfield 202	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdFetchTime	J
    //   224: aload 18
    //   226: iload 11
    //   228: putfield 206	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosLayout	I
    //   231: aload 18
    //   233: lload 12
    //   235: putfield 209	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   238: aload 18
    //   240: lload 14
    //   242: putfield 212	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mADVideoAutoPlay	J
    //   245: ldc 214
    //   247: invokestatic 76	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   250: checkcast 214	com/tencent/mobileqq/kandian/ad/api/IRIJAdLogService
    //   253: astore 20
    //   255: new 216	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   262: astore 21
    //   264: aload 21
    //   266: ldc 219
    //   268: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 21
    //   274: aload 18
    //   276: getfield 226	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   279: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 20
    //   285: ldc 231
    //   287: aload 21
    //   289: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokeinterface 238 3 0
    //   297: lload 7
    //   299: ldc2_w 239
    //   302: lcmp
    //   303: ifne +40 -> 343
    //   306: iload 10
    //   308: ifne +35 -> 343
    //   311: aload 18
    //   313: getfield 244	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   316: ifnull +27 -> 343
    //   319: aload 18
    //   321: getfield 244	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   324: getfield 248	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:g	I
    //   327: ifle +16 -> 343
    //   330: aload_0
    //   331: aload_2
    //   332: aload 18
    //   334: invokespecial 251	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(Lcom/tencent/mobileqq/kandian/base/utils/ValueReference;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   337: iconst_1
    //   338: istore 10
    //   340: goto +3 -> 343
    //   343: ldc 253
    //   345: invokestatic 76	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   348: checkcast 253	com/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusFamilyUtil
    //   351: invokeinterface 256 1 0
    //   356: ifeq +20 -> 376
    //   359: ldc 253
    //   361: invokestatic 76	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   364: checkcast 253	com/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusFamilyUtil
    //   367: aload 19
    //   369: aload 18
    //   371: invokeinterface 260 3 0
    //   376: getstatic 265	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil;
    //   379: aload 18
    //   381: invokevirtual 267	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   384: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +83 -> 470
    //   390: new 216	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   397: astore 19
    //   399: aload 19
    //   401: ldc_w 269
    //   404: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 19
    //   410: aload 18
    //   412: getfield 226	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   415: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 19
    //   421: ldc_w 271
    //   424: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 19
    //   430: aload 18
    //   432: invokevirtual 272	java/lang/Object:toString	()Ljava/lang/String;
    //   435: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload 19
    //   441: ldc_w 274
    //   444: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 19
    //   450: aload 18
    //   452: getfield 278	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   455: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: ldc 55
    //   461: iconst_2
    //   462: aload 19
    //   464: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: aload 18
    //   472: getfield 278	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   475: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   478: istore 16
    //   480: iload 16
    //   482: ifne +146 -> 628
    //   485: new 286	org/json/JSONObject
    //   488: dup
    //   489: aload 18
    //   491: getfield 278	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   494: invokespecial 289	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   497: astore 19
    //   499: aload 19
    //   501: ldc_w 291
    //   504: invokevirtual 294	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   507: ifeq +348 -> 855
    //   510: aload 19
    //   512: ldc_w 291
    //   515: invokevirtual 298	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   518: iconst_2
    //   519: if_icmpne +336 -> 855
    //   522: aload 6
    //   524: iconst_1
    //   525: invokestatic 304	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   528: invokevirtual 307	com/tencent/mobileqq/kandian/base/utils/ValueReference:a	(Ljava/lang/Object;)V
    //   531: ldc 55
    //   533: iconst_1
    //   534: ldc_w 309
    //   537: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: goto +3 -> 543
    //   543: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +43 -> 589
    //   549: new 216	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   556: astore 20
    //   558: aload 20
    //   560: ldc_w 311
    //   563: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 20
    //   569: aload 19
    //   571: invokevirtual 312	org/json/JSONObject:toString	()Ljava/lang/String;
    //   574: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: ldc 55
    //   580: iconst_2
    //   581: aload 20
    //   583: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: ldc_w 314
    //   592: invokestatic 76	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   595: checkcast 314	com/tencent/mobileqq/kandian/ad/api/IRIJSuperMaskService
    //   598: aload 18
    //   600: invokeinterface 317 2 0
    //   605: aload 18
    //   607: invokestatic 322	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyPatchAdUtils:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   610: ifeq +15 -> 625
    //   613: aload 5
    //   615: iconst_1
    //   616: invokestatic 304	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   619: invokevirtual 307	com/tencent/mobileqq/kandian/base/utils/ValueReference:a	(Ljava/lang/Object;)V
    //   622: goto +223 -> 845
    //   625: goto +48 -> 673
    //   628: goto +45 -> 673
    //   631: astore 19
    //   633: new 216	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   640: astore 20
    //   642: aload 20
    //   644: ldc_w 324
    //   647: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 20
    //   653: aload 19
    //   655: invokevirtual 327	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   658: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: ldc 55
    //   664: iconst_1
    //   665: aload 20
    //   667: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_0
    //   674: aload 18
    //   676: invokespecial 330	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   679: ifne +117 -> 796
    //   682: aload 18
    //   684: aconst_null
    //   685: invokestatic 335	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdSwitchUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lcom/tencent/mobileqq/kandian/biz/ad/entity/VideoAdInfo;)Z
    //   688: ifeq +95 -> 783
    //   691: new 286	org/json/JSONObject
    //   694: dup
    //   695: invokespecial 336	org/json/JSONObject:<init>	()V
    //   698: astore 19
    //   700: aload 19
    //   702: ldc_w 338
    //   705: iconst_0
    //   706: invokevirtual 342	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   709: pop
    //   710: aload 19
    //   712: ldc_w 344
    //   715: iconst_1
    //   716: invokevirtual 342	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   719: pop
    //   720: goto +13 -> 733
    //   723: astore 20
    //   725: goto +3 -> 728
    //   728: aload 20
    //   730: invokevirtual 347	org/json/JSONException:printStackTrace	()V
    //   733: ldc_w 349
    //   736: invokestatic 76	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   739: checkcast 349	com/tencent/mobileqq/kandian/ad/api/IRIJAdService
    //   742: new 351	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData
    //   745: dup
    //   746: invokespecial 352	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:<init>	()V
    //   749: invokestatic 358	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   752: invokevirtual 361	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(Landroid/content/Context;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   755: bipush 80
    //   757: invokevirtual 364	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(I)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   760: bipush 12
    //   762: invokevirtual 366	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:b	(I)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   765: aload 18
    //   767: invokevirtual 369	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   770: aload 19
    //   772: invokevirtual 372	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:b	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   775: invokeinterface 376 2 0
    //   780: goto +3 -> 783
    //   783: aload 17
    //   785: aload 18
    //   787: invokeinterface 380 2 0
    //   792: pop
    //   793: goto +49 -> 842
    //   796: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   799: ifeq +43 -> 842
    //   802: new 216	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 217	java/lang/StringBuilder:<init>	()V
    //   809: astore 19
    //   811: aload 19
    //   813: ldc_w 382
    //   816: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 19
    //   822: aload 18
    //   824: invokevirtual 385	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toSString	()Ljava/lang/String;
    //   827: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: ldc 55
    //   833: iconst_2
    //   834: aload 19
    //   836: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: goto +3 -> 845
    //   845: goto -824 -> 21
    //   848: aload 17
    //   850: areturn
    //   851: astore_2
    //   852: aload 17
    //   854: areturn
    //   855: goto -312 -> 543
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	this	AdvertisementInfoModule
    //   0	858	1	paramInt	int
    //   0	858	2	paramValueReference	ValueReference<Integer>
    //   0	858	3	paramLong1	long
    //   0	858	5	paramValueReference1	ValueReference<Boolean>
    //   0	858	6	paramValueReference2	ValueReference<Boolean>
    //   0	858	7	paramLong2	long
    //   0	858	9	paramList	List<articlesummary.ArticleSummary>
    //   19	320	10	i	int
    //   120	107	11	j	int
    //   130	104	12	l1	long
    //   140	101	14	l2	long
    //   478	3	16	bool	boolean
    //   7	846	17	localArrayList	ArrayList
    //   94	729	18	localObject1	Object
    //   41	529	19	localObject2	Object
    //   631	23	19	localException	Exception
    //   698	137	19	localObject3	Object
    //   253	413	20	localObject4	Object
    //   723	6	20	localJSONException	JSONException
    //   262	26	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   470	480	631	java/lang/Exception
    //   700	720	723	org/json/JSONException
    //   485	540	851	java/lang/Exception
    //   543	589	851	java/lang/Exception
    //   589	622	851	java/lang/Exception
  }
  
  private void a(int paramInt, ValueReference<Integer> paramValueReference, articlesummary.AdInfo paramAdInfo)
  {
    if ((paramAdInfo != null) && (paramInt == 0))
    {
      paramValueReference.a(Integer.valueOf((int)paramAdInfo.uint64_channel_id.get()));
      paramAdInfo = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAdvertisementResp channelID from AdInfo:");
      localStringBuilder.append(paramValueReference.a());
      paramAdInfo.d("AdDataLink", localStringBuilder.toString());
    }
  }
  
  private void a(ValueReference<Integer> paramValueReference, long paramLong, ArrayList<AdvertisementInfo> paramArrayList)
  {
    if (paramArrayList.size() == 0)
    {
      paramArrayList = new JSONObject();
      try
      {
        paramArrayList.put("svrresp_result", 1);
        paramArrayList.put("svrresp_fail_type", 1);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(80).b(12).b(paramArrayList));
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("handleAdvertisementResp channelID=");
        paramArrayList.append(paramValueReference.a());
        paramArrayList.append(", fetchTime=");
        paramArrayList.append(paramLong);
        paramArrayList.append(" parsedAdvertisementList empty!");
        QLog.d("AdvertisementInfoModule", 1, paramArrayList.toString());
      }
    }
  }
  
  private void a(ValueReference<Integer> paramValueReference, AdvertisementInfo paramAdvertisementInfo)
  {
    RIJAdConstants.AdvertisementInfoModule.a = paramAdvertisementInfo.mAdvertisementExtInfo.g;
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("async handleAdvertisementResp refreshLastPosX= +");
    localStringBuilder.append(RIJAdConstants.AdvertisementInfoModule.a);
    ((IRIJAdLogService)localObject).d("AdDataLink", localStringBuilder.toString());
    a(((Integer)paramValueReference.a()).intValue(), 0, RIJAdConstants.AdvertisementInfoModule.a);
    if (paramAdvertisementInfo.mAdvertisementExtInfo.i > 0)
    {
      RIJAdConstants.AdvertisementInfoModule.b = paramAdvertisementInfo.mAdvertisementExtInfo.i;
      paramValueReference = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("async handleAdvertisementResp refreshLastPosZ= +");
      ((StringBuilder)localObject).append(RIJAdConstants.AdvertisementInfoModule.b);
      paramValueReference.d("AdDataLink", ((StringBuilder)localObject).toString());
    }
    if (paramAdvertisementInfo.mAdvertisementExtInfo.h > 0)
    {
      RIJAdConstants.AdvertisementInfoModule.c = paramAdvertisementInfo.mAdvertisementExtInfo.h;
      paramValueReference = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      paramAdvertisementInfo = new StringBuilder();
      paramAdvertisementInfo.append("async handleAdvertisementResp refreshLastPosY= +");
      paramAdvertisementInfo.append(RIJAdConstants.AdvertisementInfoModule.c);
      paramValueReference.d("AdDataLink", paramAdvertisementInfo.toString());
    }
  }
  
  private void a(ValueReference<Integer> paramValueReference, ConcurrentHashMap<Integer, AdvertisementInfo> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleAdvertisementResp dropAdvertisements size = ");
      ((StringBuilder)localObject).append(paramConcurrentHashMap.size());
      QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramConcurrentHashMap.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)((Iterator)localObject).next();
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(((Integer)paramValueReference.a()).intValue(), localAdvertisementInfo);
    }
    paramConcurrentHashMap.clear();
  }
  
  private void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo, oidb_cmd0x68b.ReqAdvertisePara paramReqAdvertisePara)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("adPosType", paramInt2);
      localJSONObject.put("adStartPos", paramInt3);
      localJSONObject.put("adEndPos", paramInt4);
      localJSONObject.put("carrier_code", AdDeviceInfoUtil.f());
      if ((paramAdRequestData != null) && (paramAdRequestData.a()))
      {
        localJSONObject.put("MaterialId", paramAdRequestData.a);
        localJSONObject.put("RepeatedReqFlag", paramAdRequestData.b);
        localJSONObject.put("KdPos", paramAdRequestData.c);
        localJSONObject.put("adPosId", paramAdRequestData.d);
      }
      boolean bool = ((IFeedsPreloadHelper)QRoute.api(IFeedsPreloadHelper.class)).isFeedsPreloadRequest(paramRequest0x68bParams);
      long l;
      if (bool)
      {
        localJSONObject.put("adRequestFlag", g(paramInt1));
        if (this.b.get(Integer.valueOf(paramInt1)) == null) {
          l = 0L;
        } else {
          l = ((Long)this.b.get(Integer.valueOf(paramInt1))).longValue();
        }
        localJSONObject.put("lastRefreshTime", l);
      }
      else
      {
        localJSONObject.put("adRequestFlag", 0);
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).fillSuperMaskParams(paramAdRequestData, localJSONObject, paramInt1, paramInt2);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).fillPatchParams(paramAdRequestData, localJSONObject, paramInt2);
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).fillSocialParams(paramAdRequestData, localJSONObject, paramInt2);
      if (StudyModeManager.h()) {
        localJSONObject.put("reqLearningPatternFlag", 1);
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).fillTimeLoadParams(paramAdRequestData, localJSONObject);
      localJSONObject.put("reqTimeVVAdload", 1);
      if (paramDeviceInfo != null) {
        localJSONObject.put("device_ext", paramDeviceInfo.device_ext.get());
      }
      if (AdExposeFreshManager.a().b())
      {
        paramAdRequestData = AdReqFreshManager.a().c();
        paramRequest0x68bParams = new JSONArray();
        if ((paramAdRequestData != null) && (paramAdRequestData.size() > 0))
        {
          paramAdRequestData = paramAdRequestData.iterator();
          while (paramAdRequestData.hasNext()) {
            paramRequest0x68bParams.put((Long)paramAdRequestData.next());
          }
        }
        localJSONObject.put("noExposeList", paramRequest0x68bParams);
      }
      if (paramInt1 == 0)
      {
        localJSONObject.put("scene_trace_id", AdSessionManager.a().b());
        localJSONObject.put("scene_series_num", AdSessionManager.a().e());
        localJSONObject.put("refresh_series_num", AdSessionManager.a().c());
        paramInt1 = ((IFeedsRefreshUtil)QRoute.api(IFeedsRefreshUtil.class)).getContentFlushNumDay(System.currentTimeMillis()) + 1;
        paramInt2 = ((IFeedsRefreshUtil)QRoute.api(IFeedsRefreshUtil.class)).getContentFlushNumProcess(System.currentTimeMillis()) + 1;
        l = System.currentTimeMillis();
        AdRefreshReportManager.a().a(0, l);
        paramRequest0x68bParams = new StringBuilder();
        paramRequest0x68bParams.append(paramInt1);
        paramRequest0x68bParams.append("");
        localJSONObject.put("content_flush_num_day", paramRequest0x68bParams.toString());
        paramRequest0x68bParams = new StringBuilder();
        paramRequest0x68bParams.append(paramInt2);
        paramRequest0x68bParams.append("");
        localJSONObject.put("content_flush_num_process", paramRequest0x68bParams.toString());
        localJSONObject.put("ad_flush_num_day", AdRefreshReportManager.a().a(l));
        paramRequest0x68bParams = new StringBuilder();
        paramRequest0x68bParams.append(AdRefreshReportManager.a().b(l));
        paramRequest0x68bParams.append("");
        localJSONObject.put("ad_flush_num_process", paramRequest0x68bParams.toString());
        paramRequest0x68bParams = new StringBuilder();
        paramRequest0x68bParams.append("content_flush_num_day:");
        paramRequest0x68bParams.append(paramInt1);
        paramRequest0x68bParams.append("    content_flush_num_process:");
        paramRequest0x68bParams.append(paramInt2);
        paramRequest0x68bParams.append("      ad_flush_num_day:");
        paramRequest0x68bParams.append(AdRefreshReportManager.a().a(l));
        paramRequest0x68bParams.append("    ad_flush_num_proces:");
        paramRequest0x68bParams.append(AdRefreshReportManager.a().b(l));
        QLog.i("AdRefreshReportManager", 1, paramRequest0x68bParams.toString());
      }
      paramReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
      paramRequest0x68bParams = new StringBuilder();
      paramRequest0x68bParams.append("async makeReqAdvertisePara adinfo,");
      paramRequest0x68bParams.append(localJSONObject.toString());
      QLog.d("AdvertisementInfoModule", 1, paramRequest0x68bParams.toString());
      return;
    }
    catch (JSONException paramRequest0x68bParams)
    {
      paramRequest0x68bParams.printStackTrace();
    }
  }
  
  private void a(ArrayList<AdvertisementInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      if (paramArrayList.size() > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleAdvertisementResp \n");
        localStringBuilder.append("[ ");
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.next();
          localStringBuilder.append("channelId = ");
          localStringBuilder.append(localAdvertisementInfo.mChannelID);
          localStringBuilder.append(" title = ");
          localStringBuilder.append(localAdvertisementInfo.mTitle);
          localStringBuilder.append(" pos = ");
          localStringBuilder.append(localAdvertisementInfo.mAdKdPos);
        }
        paramArrayList = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        localStringBuilder.append(" ]");
        paramArrayList.d("AdDataLink", localStringBuilder.toString());
        return;
      }
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdDataLink", "handleAdvertisementResp no advertisementInfo");
    }
  }
  
  private void a(List<AdvertisementInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      HashSet localHashSet1 = new HashSet(paramList.size());
      HashSet localHashSet2 = new HashSet();
      Object localObject2 = null;
      int i = 0;
      while (i < paramList.size())
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramList.get(i);
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = a((String)localObject2, localAdvertisementInfo);
        }
        localAdvertisementInfo.scene = ((String)localObject1);
        if ((localAdvertisementInfo.mAdvertisementExtInfo == null) || (localAdvertisementInfo.mAdvertisementExtInfo.o == 32))
        {
          localObject2 = AdExposeFreshManager.a().a((String)localObject1, localAdvertisementInfo);
          paramList.set(i, localObject2);
          localHashSet1.add(Long.valueOf(((AdvertisementInfo)localObject2).mAdAid));
          localHashSet2.add(localObject2);
        }
        i += 1;
        localObject2 = localObject1;
      }
      if (localObject2 == null)
      {
        QLog.d("AdvertisementInfoModule", 2, "handleAdFreshness,scene is null");
        return;
      }
      AdReqFreshManager.a().a((String)localObject2, localHashSet1);
      AdExposeFreshManager.a().c((String)localObject2, localHashSet2);
    }
  }
  
  private void a(qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo, oidb_cmd0x68b.PhoneInfo paramPhoneInfo)
  {
    if (paramDeviceInfo.qadid.has()) {
      paramPhoneInfo.string_qadid.set(paramDeviceInfo.qadid.get());
    }
    if (paramDeviceInfo.md5_android_id.has()) {
      paramPhoneInfo.string_androidid.set(paramDeviceInfo.md5_android_id.get());
    }
    if (paramDeviceInfo.md5_mac.has()) {
      paramPhoneInfo.string_mac.set(paramDeviceInfo.md5_mac.get());
    }
    if (paramDeviceInfo.aid_ticket.has()) {
      paramPhoneInfo.string_oaid.set(paramDeviceInfo.aid_ticket.get());
    }
    if (paramDeviceInfo.taid_ticket.has()) {
      paramPhoneInfo.string_taid.set(paramDeviceInfo.taid_ticket.get());
    }
    if (paramDeviceInfo.client_ipv4.has()) {
      paramPhoneInfo.string_client_ipv4.set(paramDeviceInfo.client_ipv4.get());
    }
    if (QLog.isColorLevel())
    {
      paramDeviceInfo = new StringBuilder();
      paramDeviceInfo.append("makeReqAdvertisePara: deviceInfo: ma=");
      paramDeviceInfo.append(paramPhoneInfo.string_androidid.get());
      paramDeviceInfo.append(", mm=");
      paramDeviceInfo.append(paramPhoneInfo.string_mac.get());
      paramDeviceInfo.append(", oa=");
      paramDeviceInfo.append(paramPhoneInfo.string_oaid.get());
      paramDeviceInfo.append(", ta=");
      paramDeviceInfo.append(paramPhoneInfo.string_taid.get());
      QLog.i("AdvertisementInfoModule", 2, paramDeviceInfo.toString());
    }
  }
  
  private void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (paramRspChannelArticle.msg_ad_pos_map.has())
    {
      paramRspChannelArticle = (oidb_cmd0x68b.AdPosMap)paramRspChannelArticle.msg_ad_pos_map.get();
      if (paramRspChannelArticle.bytes_ads_context.has())
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).saveAdCookie(paramRspChannelArticle.bytes_ads_context.get().toStringUtf8());
        return;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).saveAdCookie("");
      return;
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).saveAdCookie("");
  }
  
  private boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = true;
    if (paramAdvertisementInfo == null) {
      return true;
    }
    if (ReadInJoyAdUtils.v(paramAdvertisementInfo)) {
      return false;
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) {
      return true;
    }
    if (ReadInJoyAdUtils.m(paramAdvertisementInfo))
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "filterAdvertisementInfo: isSuperMaskNormalAdType");
      return true;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
    {
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName))
        {
          if (TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    int i;
    int k;
    if (paramToServiceMsg.getAttribute("CountOfRequest_0x68b") != null)
    {
      i = ((Integer)paramToServiceMsg.getAttribute("CountOfRequest_0x68b")).intValue();
      if (i == 2) {
        k = 1;
      } else {
        k = 0;
      }
      QLog.d("AdvertisementInfoModule", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(k), ", retryTimes = ", Integer.valueOf(i) });
    }
    else
    {
      k = 0;
    }
    int m = k;
    if (paramToServiceMsg.getAttribute("retryIndex") != null)
    {
      int j = ((Integer)paramToServiceMsg.getAttribute("retryIndex")).intValue();
      if (j > 0) {
        i = 1;
      } else {
        i = 0;
      }
      m = k | i;
      QLog.d("AdvertisementInfoModule", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(m), ", fastResendRetryIndex = ", Integer.valueOf(j) });
    }
    if (m != 0) {
      QLog.d("AdvertisementInfoModule", 1, " isRetryRequest | 68b Retry");
    }
    return m;
  }
  
  private List<AbsBaseArticleInfo> b(List<articlesummary.ArticleSummary> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (articlesummary.ArticleSummary)paramList.next();
      if ((((articlesummary.ArticleSummary)localObject2).msg_feeds_info.has()) && (((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get()).msg_pos_ad_info.has()))
      {
        Object localObject1 = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get()).msg_pos_ad_info.get();
        if ((localObject1 != null) && (((articlesummary.PosAdInfo)localObject1).int32_ret.get() == 0))
        {
          int i = ((articlesummary.PosAdInfo)localObject1).enum_pos_layout.get();
          long l1 = ((articlesummary.PosAdInfo)localObject1).uint64_pos_id.get();
          long l2 = ((articlesummary.PosAdInfo)localObject1).is_auto_play.get();
          Object localObject3 = (articlesummary.AdInfo)((articlesummary.PosAdInfo)localObject1).msg_ad_info.get();
          localObject1 = new AdvertisementInfo((articlesummary.AdInfo)localObject3);
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).preLoadAdForMiniProgram((AdvertisementInfo)localObject1);
          String str1 = RIJPBFieldUtils.a(((articlesummary.AdInfo)localObject3).bytes_txt, "");
          String str2 = RIJPBFieldUtils.a(((articlesummary.AdInfo)localObject3).bytes_img, "");
          String str3 = RIJPBFieldUtils.a(((articlesummary.AdInfo)localObject3).bytes_rl, "");
          localObject3 = RIJPBFieldUtils.a(((articlesummary.AdInfo)localObject3).bytes_desc, "");
          ((IReadInJoyMSFHandlerUtils)QRoute.api(IReadInJoyMSFHandlerUtils.class)).convertArticleInfo((articlesummary.ArticleSummary)localObject2, 0, 0, (AbsBaseArticleInfo)localObject1);
          ((AdvertisementInfo)localObject1).mAdPosLayout = i;
          ((AdvertisementInfo)localObject1).mAdPosID = l1;
          ((AdvertisementInfo)localObject1).mADVideoAutoPlay = l2;
          IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("parseAdvertisementInfoList kd_pos= ");
          localStringBuilder.append(((AdvertisementInfo)localObject1).mAdKdPos);
          localIRIJAdLogService.d("AdDataLink", localStringBuilder.toString());
          if (((IReadInJoyProteusFamilyUtil)QRoute.api(IReadInJoyProteusFamilyUtil.class)).checkPermission()) {
            ((IReadInJoyProteusFamilyUtil)QRoute.api(IReadInJoyProteusFamilyUtil.class)).recordAdArticleInfo((articlesummary.ArticleSummary)localObject2, (AbsBaseArticleInfo)localObject1);
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("async handleAdvertisementResp adinfo pos= +");
            ((StringBuilder)localObject2).append(((AdvertisementInfo)localObject1).mAdKdPos);
            ((StringBuilder)localObject2).append("info=");
            ((StringBuilder)localObject2).append(localObject1.toString());
            ((StringBuilder)localObject2).append("info.mAdExtInfo= +");
            ((StringBuilder)localObject2).append(((AdvertisementInfo)localObject1).mAdExtInfo);
            QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject2).toString());
          }
          ((AdvertisementInfo)localObject1).mTitle = str1;
          ((AdvertisementInfo)localObject1).mFirstPagePicUrl = str2;
          ((AdvertisementInfo)localObject1).mArticleContentUrl = str3;
          ((AdvertisementInfo)localObject1).mSummary = ((String)localObject3);
          if (!a((AdvertisementInfo)localObject1))
          {
            localArrayList.add(localObject1);
          }
          else if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("filterAdvertisementInfo info = ");
            ((StringBuilder)localObject2).append(((AdvertisementInfo)localObject1).toSString());
            QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = Integer.valueOf(0);
    int m = ((Integer)paramToServiceMsg.getAttribute("repeatedReqFlag", paramFromServiceMsg)).intValue();
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handle0x68bGetAdvertisementList! result=");
      paramObject.append(i);
      paramObject.append(",repeatedreqFlag=");
      paramObject.append(m);
      QLog.d("AdvertisementInfoModule", 2, paramObject.toString());
    }
    int j = ((Integer)paramToServiceMsg.getAttribute("asyncRequestChannelFlag", paramFromServiceMsg)).intValue();
    ((Integer)paramToServiceMsg.getAttribute("asyncAdRequestFlag", Integer.valueOf(-1))).intValue();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x68bGetAdvertisementList! result=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",asyncChannelId=");
      paramFromServiceMsg.append(j);
      QLog.d("AdvertisementInfoModule", 2, paramFromServiceMsg.toString());
    }
    VideoAdTimeLoadManager.a(j);
    paramFromServiceMsg = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramObject = new StringBuilder();
    paramObject.append("handle0x68bGetAdvertisementList result = ");
    paramObject.append(i);
    paramFromServiceMsg.d("AdDataLink", paramObject.toString());
    if (i == 0)
    {
      long l;
      if (localRspBody.uint64_uin.has()) {
        l = localRspBody.uint64_uin.get();
      } else {
        l = -1L;
      }
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getCurrentAccountUin())))
      {
        paramFromServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        int k = (int)paramFromServiceMsg.uint64_channel_id.get();
        i = k;
        if (k == 0)
        {
          i = k;
          if (j != 0) {
            i = j;
          }
        }
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdDataLink", "handleAdvertisementResp 处理广告");
        boolean bool;
        if ((paramFromServiceMsg.rpt_advertise_list.has()) && (paramFromServiceMsg.rpt_advertise_list.get() != null))
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdDataLink", "handleAdvertisementResp in ad Request");
          paramObject = new ValueReference(Boolean.valueOf(false));
          a(paramToServiceMsg, paramFromServiceMsg, m, j, false, paramObject);
          bool = ((Boolean)paramObject.a()).booleanValue();
        }
        else
        {
          if (m == 1)
          {
            ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdDataLink", "handle0x68bGetAdvertisementList 重复曝光加载数据返回空");
          }
          else
          {
            paramToServiceMsg = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            paramObject = new StringBuilder();
            paramObject.append("handleAdvertisementResp channelArticle.rpt_advertise_list.has() = ");
            paramObject.append(paramFromServiceMsg.rpt_advertise_list.has());
            paramObject.append(" channelArticle.rpt_advertise_list.get() = ");
            paramObject.append(paramFromServiceMsg.rpt_advertise_list.get());
            paramObject.append(" repeatedreqFlag = ");
            paramObject.append(m);
            paramToServiceMsg.d("AdDataLink", paramObject.toString());
          }
          bool = true;
        }
        if ((this.f.containsKey(Integer.valueOf(i))) && (!bool))
        {
          paramToServiceMsg = (WeakReference)this.f.get(Integer.valueOf(i));
          if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle0x68bGetAdvertisementList listener = ");
            paramFromServiceMsg.append(paramToServiceMsg.toString());
            QLog.d("AdvertisementInfoModule", 1, paramFromServiceMsg.toString());
            ((FixPosArticleInterface.FixPosArticleAsyncListener)paramToServiceMsg.get()).a(i);
          }
        }
      }
      else
      {
        paramToServiceMsg = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handle0x68bGetAdvertisementList resp.rspChannelArticle.has() = ");
        paramFromServiceMsg.append(localRspBody.rspChannelArticle.has());
        paramFromServiceMsg.append(" uin = ");
        paramFromServiceMsg.append(l);
        paramFromServiceMsg.append(" currentUin = ");
        paramFromServiceMsg.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getCurrentAccountUin());
        paramToServiceMsg.d("AdDataLink", paramFromServiceMsg.toString());
      }
    }
    else
    {
      j = ((Integer)paramToServiceMsg.getAttribute("CountOfRequest_0x68b")).intValue();
      paramFromServiceMsg = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      paramObject = new StringBuilder();
      paramObject.append("handle0x68bGetAdvertisementList Error result = ");
      paramObject.append(i);
      paramObject.append(" requestCount = ");
      paramObject.append(j);
      paramFromServiceMsg.d("AdDataLink", paramObject.toString());
      if ((i == 154) && (j == 1))
      {
        paramToServiceMsg.getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(2));
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().N().a(paramToServiceMsg);
        paramToServiceMsg = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handle0x68bGetAdvertisementList timeout retry : requestCount = ");
        paramFromServiceMsg.append(j);
        paramToServiceMsg.d("AdDataLink", paramFromServiceMsg.toString());
        return;
      }
      paramToServiceMsg = new JSONObject();
      try
      {
        paramToServiceMsg.put("svrresp_result", 1);
        paramToServiceMsg.put("svrresp_fail_type", 2);
        paramToServiceMsg.put("svrresp_fail_code", i);
      }
      catch (JSONException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(80).b(12).b(paramToServiceMsg));
    }
  }
  
  private int c()
  {
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    int i = 0;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j != 5) {
                return 0;
              }
            }
            else {
              return 3;
            }
          }
          else {
            return 2;
          }
        }
        else {
          return 1;
        }
      }
      i = 4;
    }
    return i;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x886AdvertisementReportResp!");
    }
    oidb_cmd0x886.RspBody localRspBody = new oidb_cmd0x886.RspBody();
    int i = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i != 0)
    {
      int j = ((Integer)paramToServiceMsg.getAttribute("CountOfRequest_0x886")).intValue();
      if ((i == 154) && (j == 1))
      {
        paramToServiceMsg.getAttributes().put("CountOfRequest_0x886", Integer.valueOf(2));
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().N().a(paramToServiceMsg);
      }
    }
  }
  
  private int g(int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt));
    int i = 1;
    paramInt = i;
    if (localObject2 != null)
    {
      paramInt = i;
      if (((ConcurrentHashMap)localObject2).size() > 0)
      {
        localObject2 = ((ConcurrentHashMap)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((AdvertisementInfo)((Iterator)localObject2).next());
        }
        Collections.sort((List)localObject1, new AdvertisementInfoModule.2(this));
        localObject1 = (AdvertisementInfo)((ArrayList)localObject1).get(0);
        paramInt = i;
        if (localObject1 != null)
        {
          paramInt = i;
          if (((AdvertisementInfo)localObject1).mAdKdPos <= 100)
          {
            if (((AdvertisementInfo)localObject1).hasAddExposure) {
              return 1;
            }
            paramInt = 2;
          }
        }
      }
    }
    return paramInt;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt1));
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAdvertisementInfo channelId=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" map is null!");
      ((IRIJAdLogService)localObject1).d("AdVideoDataLink", ((StringBuilder)localObject2).toString());
      return null;
    }
    localObject1 = (AdvertisementInfo)((ConcurrentHashMap)localObject1).get(Integer.valueOf(paramInt2));
    if (localObject1 != null)
    {
      localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAdvertisementInfo channelId=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" advertisementInfo = ");
      localStringBuilder.append(((AdvertisementInfo)localObject1).mTitle);
      localStringBuilder.append(" pos = ");
      localStringBuilder.append(((AdvertisementInfo)localObject1).mAdKdPos);
      ((IRIJAdLogService)localObject2).d("AdVideoDataLink", localStringBuilder.toString());
      return localObject1;
    }
    return null;
  }
  
  public Object a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("makeReqAdvertisePara channelID=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).a = "ce2d9f";
    Object localObject3 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    if (localObject3 != null) {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject3).a;
    } else {
      localObject1 = null;
    }
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
    Object localObject2 = localReqAdvertisePara.uint64_channel_id;
    long l2 = paramInt1;
    ((PBUInt64Field)localObject2).set(l2, true);
    localObject2 = localReqAdvertisePara.uint64_last_time;
    long l1;
    if (this.a.get(Integer.valueOf(paramInt1)) == null) {
      l1 = 0L;
    } else {
      l1 = ((Long)this.a.get(Integer.valueOf(paramInt1))).longValue();
    }
    ((PBUInt64Field)localObject2).set(l1, true);
    localObject2 = new oidb_cmd0x68b.PhoneInfo();
    if ((localObject3 != null) && (((GdtDeviceInfoHelper.Result)localObject3).a != null) && (((GdtDeviceInfoHelper.Result)localObject3).a.muid != null) && (((GdtDeviceInfoHelper.Result)localObject3).a.muid_type != null))
    {
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_muid.set(ByteStringMicro.copyFromUtf8(((GdtDeviceInfoHelper.Result)localObject3).a.muid.get()));
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_muid_type.set(((GdtDeviceInfoHelper.Result)localObject3).a.muid_type.get());
    }
    localObject3 = AdDeviceInfoUtil.b();
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      ((oidb_cmd0x68b.PhoneInfo)localObject2).string_imei.set((String)localObject3);
    }
    int i = PublicAccountAdUtil.a();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_conn.set(i);
    i = 0;
    try
    {
      int j = AdDeviceInfoUtil.e();
      i = j;
    }
    catch (Exception localException)
    {
      label304:
      break label304;
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_carrier.set(i);
    localObject3 = DeviceInfoUtil.g();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    localObject3 = DeviceInfoUtil.e();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    i = AppSetting.d();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
    localObject3 = DatalineMathUtil.a(DatalineMathUtil.a());
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_os_type.set(2);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint64_func_flag.set(1L);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_ads_context.set(ByteStringMicro.copyFromUtf8(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getAdCookie()));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
    if (localObject1 != null) {
      a((qq_ad_get.QQAdGet.DeviceInfo)localObject1, (oidb_cmd0x68b.PhoneInfo)localObject2);
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_wx_ver.set(ByteStringMicro.copyFrom(AdDeviceInfoUtil.a(BaseApplication.getContext()).getBytes()));
    localReqAdvertisePara.msg_phone_info.set((MessageMicro)localObject2, true);
    if (paramInt3 != paramInt4) {
      a((ReadInJoyRequestParams.Request0x68bParams)paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData, (qq_ad_get.QQAdGet.DeviceInfo)localObject1, localReqAdvertisePara);
    }
    paramObject = new oidb_cmd0x68b.AdReqInfo();
    paramObject.uint64_ad_channel_id.set(l2);
    localReqAdvertisePara.msg_ad_req_info.set(paramObject);
    return localReqAdvertisePara;
  }
  
  public List<AbsBaseArticleInfo> a(oidb_cmd0xf30.InsertArticle paramInsertArticle)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInsertArticle != null)
    {
      if (paramInsertArticle.rpt_ad_list == null) {
        return localArrayList;
      }
      if ((paramInsertArticle.rpt_ad_list.has()) && (paramInsertArticle.rpt_ad_list.get() != null)) {
        return b(paramInsertArticle.rpt_ad_list.get());
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitialize!");
    }
    this.c.clear();
    this.a.clear();
    this.b.clear();
    this.f.clear();
    this.g.clear();
    ReadInJoyPatchAdUtils.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = (Pair)this.d.get(Integer.valueOf(paramInt1));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    int i = paramInt3;
    if (paramInt2 != 0)
    {
      i = paramInt3;
      if (paramInt3 < ((Integer)((Pair)localObject1).second).intValue()) {
        i = ((Integer)((Pair)localObject1).second).intValue();
      }
    }
    localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("async setLocalAdvertisementRange channelid=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("  adStart=");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("  adEnd=");
    ((StringBuilder)localObject2).append(i);
    ((IRIJAdLogService)localObject1).d("AdDataLink", ((StringBuilder)localObject2).toString());
    localObject1 = new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
    this.d.remove(Integer.valueOf(paramInt1));
    this.d.put(Integer.valueOf(paramInt1), localObject1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    Object localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("refreshChannelAdvertisementFormServer channelId=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" adPosType = ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(" adStart = ");
    ((StringBuilder)localObject2).append(paramInt3);
    ((StringBuilder)localObject2).append(" adEnd = ");
    ((StringBuilder)localObject2).append(paramInt4);
    ((StringBuilder)localObject2).append(" 请求广告");
    ((IRIJAdLogService)localObject1).d("AdDataLink", ((StringBuilder)localObject2).toString());
    if (paramInt1 == 0) {
      AdSessionManager.a().d();
    }
    if (!this.f.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshChannelAdvertisementFormServer channelId=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" not contained in mChannelID2FixPosArticleAsyncListener");
      QLog.d("AdvertisementInfoModule", 1, ((StringBuilder)localObject1).toString());
      ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).registerReommendADListener(paramInt1);
    }
    if (this.f.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject1 = (WeakReference)this.f.get(Integer.valueOf(paramInt1));
      if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("refreshChannelAdvertisementFormServer channelId=");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" listener is null");
        QLog.d("AdvertisementInfoModule", 1, ((StringBuilder)localObject1).toString());
        ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).registerReommendADListener(paramInt1);
      }
    }
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAccount()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(c());
    localReqBody.req_advertise_para.set((oidb_cmd0x68b.ReqAdvertisePara)a(null, paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData));
    localObject2 = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).makeOIDBPkg("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    localObject1 = ((ToServiceMsg)localObject2).getAttributes();
    l = paramInt3;
    ((HashMap)localObject1).put("BeginSeq", Long.valueOf(l));
    if ((paramAdRequestData != null) && (paramAdRequestData.b == 1))
    {
      ((ToServiceMsg)localObject2).getAttributes().put("repeatedReqFlag", Integer.valueOf(paramAdRequestData.b));
      ((ToServiceMsg)localObject2).getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(0));
    }
    else
    {
      ((ToServiceMsg)localObject2).getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(1));
    }
    ((ToServiceMsg)localObject2).getAttributes().put("adpostype_0x68b", Integer.valueOf(paramInt2));
    if (!((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(paramInt1))
    {
      localObject1 = localObject2;
      if (!((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isDailyChildFeeds(paramInt1)) {}
    }
    else
    {
      localReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(((IRealTimeController)QRoute.api(IRealTimeController.class)).getRealTimeLocalVersion("default_feeds")));
      localObject1 = localObject2;
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).use0xcbaRefreshCmd())
      {
        localObject1 = ((IReadInJoyDailySettingModel)QRoute.api(IReadInJoyDailySettingModel.class)).getKvResult(paramInt1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        }
        localObject1 = ((IReadInJoyOidbHelper)QRoute.api(IReadInJoyOidbHelper.class)).makeOIDBPkg("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray());
        ((ToServiceMsg)localObject1).getAttributes().put("realTimeServiceKey", "default_feeds");
        ((ToServiceMsg)localObject1).getAttributes().put("BeginSeq", Long.valueOf(l));
      }
    }
    if ((paramAdRequestData != null) && (paramAdRequestData.e))
    {
      ((ToServiceMsg)localObject1).getAttributes().put("asyncRequestChannelFlag", Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject1).getAttributes().put("asyncAdRequestFlag", Integer.valueOf(1));
      ((ToServiceMsg)localObject1).getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(0));
    }
    ((ToServiceMsg)localObject1).getAttributes().put("isRetryRequest", Boolean.valueOf(a((ToServiceMsg)localObject1)));
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().N().a((ToServiceMsg)localObject1);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFixPosArticleAsyncListener channelID=");
      localStringBuilder.append(paramInt);
      QLog.d("AdvertisementInfoModule", 2, localStringBuilder.toString());
    }
    this.f.put(Integer.valueOf(paramInt), new WeakReference(paramFixPosArticleAsyncListener));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("async setChannelNeedRequestAdvertisement channelid=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  bNeed= ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AdvertisementInfoModule", 2, localStringBuilder.toString());
    }
    this.e.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doUninterestAdvertisement tagId=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", channelId=");
      ((StringBuilder)localObject1).append(paramAdvertisementInfo.mChannelID);
      ((StringBuilder)localObject1).append(", pos=");
      ((StringBuilder)localObject1).append(paramAdvertisementInfo.mAdKdPos);
      ((StringBuilder)localObject1).append(", traceID=");
      ((StringBuilder)localObject1).append(paramAdvertisementInfo.mAdTraceId);
      QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (ConcurrentHashMap)this.c.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
    if (localObject1 != null) {
      ((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramAdvertisementInfo.mAdKdPos));
    }
    if (paramBoolean) {
      return;
    }
    Object localObject2 = "";
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      localObject1 = "";
      for (;;)
      {
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (i >= paramArrayList.size()) {
          break;
        }
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(i);
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (localDislikeInfo != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(localDislikeInfo.e);
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(localDislikeInfo.c);
          localObject1 = ((StringBuilder)localObject3).toString();
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (i != paramArrayList.size() - 1)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(",");
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",");
            localObject4 = ((StringBuilder)localObject2).toString();
          }
        }
        i += 1;
        localObject1 = localObject4;
        localObject2 = localObject3;
      }
    }
    Object localObject4 = "";
    Object localObject3 = localObject2;
    if (paramAdvertisementInfo.mChannelID == 56L)
    {
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(3).b(4).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject3).b((String)localObject4));
      return;
    }
    if ((!ReadInJoyAdUtils.u(paramAdvertisementInfo)) && (!ReadInJoyAdUtils.t(paramAdvertisementInfo)))
    {
      if (ReadInJoyAdUtils.v(paramAdvertisementInfo)) {
        return;
      }
      if (((IRIJFeedsType)QRoute.api(IRIJFeedsType.class)).isVideoArticle(paramAdvertisementInfo)) {
        i = 11;
      } else {
        i = 3;
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(paramContext).a(3).b(i).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject3).b((String)localObject4));
    }
  }
  
  public void a(AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      Object localObject2 = new JSONObject(paramAdvertisementInfo.mAdExt);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("traceid", paramAdvertisementInfo.mAdTraceId);
      ((JSONObject)localObject1).put("rl", paramAdvertisementInfo.mAdRl);
      ((JSONObject)localObject1).put("productid", paramAdvertisementInfo.mAdProductId);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoUrl", paramAdvertisementInfo.mVideoVid);
      localJSONObject.put("coverUrl", paramAdvertisementInfo.mVideoCoverUrl);
      localJSONObject.put("duration", paramAdvertisementInfo.mVideoDuration);
      ((JSONObject)localObject1).put("video", localJSONObject);
      ((JSONObject)localObject1).put("native", ((JSONObject)localObject2).getJSONObject("native"));
      localObject2 = new JSONArray();
      ((JSONArray)localObject2).put(localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("uin", paramAppInterface.getAccount());
      ((JSONObject)localObject1).put("type", 3);
      ((JSONObject)localObject1).put("ads", localObject2);
      localObject1 = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get ad app json: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject2).data.set((String)localObject1);
        localObject1 = new NewIntent(paramAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        ((NewIntent)localObject1).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_native");
        ((NewIntent)localObject1).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject2).toByteArray());
        ((NewIntent)localObject1).setObserver(new AdvertisementInfoModule.3(this, paramAdvertisementInfo));
        paramAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveAD response cmd=");
    localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
    localStringBuilder.append(" 广告回包");
    localIRIJAdLogService.d("AdDataLink", localStringBuilder.toString());
    if ((!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) && (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba")))
    {
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, Object paramObject1, int paramInt1, int paramInt2, boolean paramBoolean, Object paramObject2)
  {
    Object localObject3 = (ValueReference)paramObject2;
    Object localObject4 = (oidb_cmd0x68b.RspChannelArticle)paramObject1;
    Boolean localBoolean = Boolean.valueOf(true);
    if (localObject4 == null)
    {
      ((ValueReference)localObject3).a(localBoolean);
      return;
    }
    paramObject2 = new ValueReference(Integer.valueOf((int)((oidb_cmd0x68b.RspChannelArticle)localObject4).uint64_channel_id.get()));
    if ((((Integer)paramObject2.a()).intValue() == 0) && (paramInt2 != 0)) {
      paramObject2.a(Integer.valueOf(paramInt2));
    }
    long l1 = ((oidb_cmd0x68b.RspChannelArticle)localObject4).uint64_pos_ad_time.get();
    paramObject1 = new ArrayList();
    ValueReference localValueReference = new ValueReference(Boolean.valueOf(false));
    Object localObject2 = new ValueReference(Boolean.valueOf(false));
    long l2 = ((Long)paramToServiceMsg.getAttribute("BeginSeq")).longValue();
    if ((((oidb_cmd0x68b.RspChannelArticle)localObject4).rpt_advertise_list.has()) && (((oidb_cmd0x68b.RspChannelArticle)localObject4).rpt_advertise_list.get() != null))
    {
      List localList = ((oidb_cmd0x68b.RspChannelArticle)localObject4).rpt_advertise_list.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleAdvertisementResp resp.rpt_advertise_list size ");
        ((StringBuilder)localObject1).append(localList.size());
        QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = paramObject1;
      localList = a(paramInt2, paramObject2, l1, localValueReference, (ValueReference)localObject2, l2, localList);
      a(localList);
      ((ArrayList)localObject1).addAll(localList);
      a((ArrayList)localObject1);
      if (((Boolean)localValueReference.a()).booleanValue())
      {
        a(paramObject2, l1, (ArrayList)localObject1);
        ((ValueReference)localObject3).a(localBoolean);
        return;
      }
      a((oidb_cmd0x68b.RspChannelArticle)localObject4);
    }
    Object localObject1 = paramObject1;
    if (((Boolean)((ValueReference)localObject2).a()).booleanValue()) {
      a(((Integer)paramObject2.a()).intValue(), false);
    }
    this.a.put(paramObject2.a(), Long.valueOf(l1));
    if ((paramBoolean) && (l1 > 0L)) {
      this.b.put(paramObject2.a(), Long.valueOf(l1));
    }
    paramObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("async makeReqAdvertisePara adinfo, fromRefresh=");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(", list.size()=");
    ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
    ((StringBuilder)localObject2).append(",fetchTime=");
    ((StringBuilder)localObject2).append(l1);
    paramObject1.d("AdvertisementInfoModule", ((StringBuilder)localObject2).toString());
    localObject2 = (ConcurrentHashMap)this.c.get(paramObject2.a());
    paramObject1 = localObject2;
    if (localObject2 == null)
    {
      paramObject1 = new ConcurrentHashMap();
      this.c.put(paramObject2.a(), paramObject1);
    }
    localObject2 = new ConcurrentHashMap();
    paramBoolean = ((IFeedsPreloadHelper)QRoute.api(IFeedsPreloadHelper.class)).isFeedsPreloadRequest(paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleAdvertisementResp beginSeq = ");
      paramToServiceMsg.append(l2);
      paramToServiceMsg.append(",isFeedsPreload=");
      paramToServiceMsg.append(paramBoolean);
      paramToServiceMsg.append(",advertisementInfoMap size ");
      paramToServiceMsg.append(paramObject1.size());
      paramToServiceMsg.append(", channelId=");
      paramToServiceMsg.append(paramObject2.a());
      paramToServiceMsg.append(", fetchTime=");
      paramToServiceMsg.append(l1);
      paramToServiceMsg.append(",repeatedreqFlag=");
      paramToServiceMsg.append(paramInt1);
      QLog.d("AdvertisementInfoModule", 2, paramToServiceMsg.toString());
    }
    if ((paramBoolean) && (((ArrayList)localObject1).size() <= 0))
    {
      paramToServiceMsg = (ToServiceMsg)localObject2;
    }
    else if (l2 == -1L)
    {
      paramToServiceMsg = paramObject1;
    }
    else
    {
      localObject3 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        paramToServiceMsg = (ToServiceMsg)localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramToServiceMsg = (AdvertisementInfo)((Iterator)localObject3).next();
        if (paramObject1.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)) != null)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("handleAdvertisementResp dropAdvertisements info = ");
            ((StringBuilder)localObject4).append(paramToServiceMsg.toSString());
            QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject4).toString());
          }
          ((ConcurrentHashMap)localObject2).put(Integer.valueOf(paramToServiceMsg.mAdKdPos), paramObject1.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)));
          paramObject1.remove(Integer.valueOf(paramToServiceMsg.mAdKdPos));
        }
      }
    }
    VideoAdTimeLoadManager.a(((Integer)paramObject2.a()).intValue(), (ArrayList)localObject1);
    a(paramObject2, paramToServiceMsg);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleAdvertisementResp channelID=");
    paramToServiceMsg.append(paramObject2.a());
    paramToServiceMsg.append(", fetchTime=");
    paramToServiceMsg.append(l1);
    paramToServiceMsg.append("\n");
    paramToServiceMsg = new StringBuilder(paramToServiceMsg.toString());
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AdvertisementInfo)((Iterator)localObject2).next();
      paramObject1.put(Integer.valueOf(((AdvertisementInfo)localObject3).mAdKdPos), localObject3);
      paramToServiceMsg.append("[pos=");
      paramToServiceMsg.append(((AdvertisementInfo)localObject3).mAdKdPos);
      paramToServiceMsg.append(", traceID=");
      paramToServiceMsg.append(((AdvertisementInfo)localObject3).mAdTraceId);
      paramToServiceMsg.append("]\n");
      if ((((AdvertisementInfo)localObject3).mAdJumpMode == 4) && (TextUtils.isEmpty(((AdvertisementInfo)localObject3).mAdAppJson))) {
        a((AppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime(), (AdvertisementInfo)localObject3);
      }
    }
    QLog.d("AdvertisementInfoModule", 1, paramToServiceMsg.toString());
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleAdvertisementResp advertisementInfoMap size ");
      paramToServiceMsg.append(paramObject1.size());
      paramToServiceMsg.append(", channelId=");
      paramToServiceMsg.append(paramObject2.a());
      QLog.d("AdvertisementInfoModule", 2, paramToServiceMsg.toString());
    }
    if (((ArrayList)localObject1).size() == 0)
    {
      paramToServiceMsg = new JSONObject();
      try
      {
        paramToServiceMsg.put("svrresp_result", 1);
        paramToServiceMsg.put("svrresp_fail_type", 1);
      }
      catch (JSONException paramObject1)
      {
        paramObject1.printStackTrace();
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(BaseApplication.getContext()).a(80).b(12).b(paramToServiceMsg));
      paramToServiceMsg = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      paramObject1 = new StringBuilder();
      paramObject1.append("handleAdvertisementResp channelID=");
      paramObject1.append(paramObject2.a());
      paramObject1.append(", fetchTime=");
      paramObject1.append(l1);
      paramObject1.append(" parsedAdvertisementList empty!");
      paramToServiceMsg.d("AdDataLink", paramObject1.toString());
    }
  }
  
  public int[] a(int paramInt)
  {
    Object localObject2 = d(paramInt);
    int j = ((ArrayList)localObject2).size();
    int i = 0;
    if (j <= 0)
    {
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getFixPositionSync channelID=");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append(" return empty!");
      ((IRIJAdLogService)localObject1).d("AdDataLink", localStringBuilder1.toString());
      return new int[0];
    }
    Object localObject1 = new int[((ArrayList)localObject2).size()];
    StringBuilder localStringBuilder1 = new StringBuilder("[");
    while (i < ((ArrayList)localObject2).size())
    {
      localObject1[i] = ((AdvertisementInfo)((ArrayList)localObject2).get(i)).mAdKdPos;
      localStringBuilder1.append(localObject1[i]);
      if (i != ((ArrayList)localObject2).size() - 1) {
        localStringBuilder1.append(", ");
      }
      i += 1;
    }
    localStringBuilder1.append("]");
    localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("getFixPositionSync channelID=");
    localStringBuilder2.append(paramInt);
    localStringBuilder2.append(" return ");
    localStringBuilder2.append(localStringBuilder1.toString());
    ((IRIJAdLogService)localObject2).d("AdDataLink", localStringBuilder2.toString());
    return localObject1;
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    Object localObject1 = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt1));
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("removeAdvertisementInfo channelId=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" map is null!");
      ((IRIJAdLogService)localObject1).d("AdVideoDataLink", ((StringBuilder)localObject2).toString());
      return null;
    }
    localObject1 = (AdvertisementInfo)((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramInt2));
    if (localObject1 != null)
    {
      localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeAdvertisementInfo channelId=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" advertisementInfo = ");
      localStringBuilder.append(((AdvertisementInfo)localObject1).mTitle);
      localStringBuilder.append(" pos = ");
      localStringBuilder.append(((AdvertisementInfo)localObject1).mAdKdPos);
      ((IRIJAdLogService)localObject2).d("AdVideoDataLink", localStringBuilder.toString());
      return localObject1;
    }
    return null;
  }
  
  public ArrayList<AbsBaseArticleInfo> b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFixPosArticleListSync channelId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(d(paramInt));
    return localObject;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
  }
  
  public Pair<Integer, Integer> c(int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (!f(paramInt1))
    {
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("async getPreloadAdvertisementAtPostion channelid=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("   !needRequestAdvertisement ");
      ((IRIJAdLogService)localObject1).d("AdDataLink", ((StringBuilder)localObject2).toString());
      return null;
    }
    Object localObject1 = (Pair)this.d.get(Integer.valueOf(paramInt1));
    if (localObject1 != null)
    {
      if (RIJAdConstants.AdvertisementInfoModule.c + paramInt2 <= ((Integer)((Pair)localObject1).second).intValue()) {
        return null;
      }
      int i = ((Integer)((Pair)localObject1).second).intValue();
      int j = RIJAdConstants.AdvertisementInfoModule.b + i;
      localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("first = ");
      localStringBuilder.append(((Pair)localObject1).first);
      localStringBuilder.append(" second = ");
      localStringBuilder.append(((Pair)localObject1).second);
      ((IRIJAdLogService)localObject2).d("AdDataLink", localStringBuilder.toString());
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("async getPreloadAdvertisementAtPostion channelid=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("  position=");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("  startpos=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("  endpos=");
      ((StringBuilder)localObject2).append(j);
      ((IRIJAdLogService)localObject1).d("AdDataLink", ((StringBuilder)localObject2).toString());
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
    }
    return null;
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFixPosArticleAsyncListener channelID=");
      localStringBuilder.append(paramInt);
      QLog.d("AdvertisementInfoModule", 2, localStringBuilder.toString());
    }
    this.f.remove(Integer.valueOf(paramInt));
  }
  
  public ArrayList<AdvertisementInfo> d(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt));
    if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).size() > 0))
    {
      localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add((AdvertisementInfo)((Iterator)localObject1).next());
      }
      Collections.sort(localArrayList, new AdvertisementInfoModule.1(this));
    }
    if (!QLog.isColorLevel()) {
      return localArrayList;
    }
    localObject1 = new StringBuilder("\n");
    int i = 0;
    while (i < localArrayList.size())
    {
      localObject2 = (AdvertisementInfo)localArrayList.get(i);
      ((StringBuilder)localObject1).append("[pos=");
      ((StringBuilder)localObject1).append(((AdvertisementInfo)localObject2).mAdKdPos);
      ((StringBuilder)localObject1).append(", traceID=");
      ((StringBuilder)localObject1).append(((AdvertisementInfo)localObject2).mAdTraceId);
      ((StringBuilder)localObject1).append(", title=");
      ((StringBuilder)localObject1).append(((AdvertisementInfo)localObject2).mTitle);
      ((StringBuilder)localObject1).append("]");
      if (i != localArrayList.size() - 1) {
        ((StringBuilder)localObject1).append("\n");
      }
      i += 1;
    }
    Object localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadChannelAdvertisement channelId=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" return ");
    localStringBuilder.append(((StringBuilder)localObject1).toString());
    ((IRIJAdLogService)localObject2).d("AdDataLink", localStringBuilder.toString());
    return localArrayList;
  }
  
  public Pair<Integer, Integer> e(int paramInt)
  {
    return (Pair)this.d.get(Integer.valueOf(paramInt));
  }
  
  public boolean f(int paramInt)
  {
    if (this.e.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.e.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule
 * JD-Core Version:    0.7.0.1
 */