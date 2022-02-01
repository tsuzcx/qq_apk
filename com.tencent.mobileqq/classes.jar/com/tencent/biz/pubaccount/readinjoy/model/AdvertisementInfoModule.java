package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
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
  private LinkedHashMap<Integer, Long> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, WeakReference<FixPosArticleInterface.FixPosArticleAsyncListener>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, Long> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, HashSet<String>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Integer, AdvertisementInfo>> c = new LinkedHashMap();
  private LinkedHashMap<Integer, Pair<Integer, Integer>> d = new LinkedHashMap();
  private LinkedHashMap<Integer, Boolean> e = new LinkedHashMap();
  
  public AdvertisementInfoModule()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int a()
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
  
  private int a(int paramInt)
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
    //   0: new 75	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 76	java/util/ArrayList:<init>	()V
    //   7: astore 17
    //   9: aload 9
    //   11: invokeinterface 172 1 0
    //   16: astore 9
    //   18: iconst_0
    //   19: istore 10
    //   21: aload 9
    //   23: invokeinterface 104 1 0
    //   28: ifeq +825 -> 853
    //   31: aload 9
    //   33: invokeinterface 108 1 0
    //   38: checkcast 174	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary
    //   41: astore 19
    //   43: aload 19
    //   45: getfield 178	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   48: invokevirtual 183	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:has	()Z
    //   51: ifeq +799 -> 850
    //   54: aload 19
    //   56: getfield 178	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   59: invokevirtual 186	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   62: checkcast 180	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   65: getfield 190	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   68: invokevirtual 193	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:has	()Z
    //   71: ifeq +779 -> 850
    //   74: aload 19
    //   76: getfield 178	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   79: invokevirtual 186	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 180	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   85: getfield 190	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   88: invokevirtual 194	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 192	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo
    //   94: astore 18
    //   96: aload 18
    //   98: ifnull +752 -> 850
    //   101: aload 18
    //   103: getfield 198	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:int32_ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   106: invokevirtual 202	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   109: ifne +741 -> 850
    //   112: aload 18
    //   114: getfield 206	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:enum_pos_layout	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   117: invokevirtual 209	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   120: istore 11
    //   122: aload 18
    //   124: getfield 213	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:uint64_pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   127: invokevirtual 218	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   130: lstore 12
    //   132: aload 18
    //   134: getfield 221	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:is_auto_play	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   137: invokevirtual 218	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   140: lstore 14
    //   142: aload 18
    //   144: getfield 225	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:msg_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;
    //   147: invokevirtual 228	tencent/im/oidb/articlesummary/articlesummary$AdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 227	tencent/im/oidb/articlesummary/articlesummary$AdInfo
    //   153: astore 18
    //   155: aload_0
    //   156: iload_1
    //   157: aload_2
    //   158: aload 18
    //   160: invokespecial 231	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(ILcom/tencent/mobileqq/kandian/base/utils/ValueReference;Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   163: new 110	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   166: dup
    //   167: aload 18
    //   169: invokespecial 234	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:<init>	(Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   172: astore 18
    //   174: ldc 236
    //   176: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   179: checkcast 236	com/tencent/mobileqq/kandian/ad/api/IRIJAdUtilService
    //   182: aload 18
    //   184: invokeinterface 240 2 0
    //   189: ldc 242
    //   191: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   194: checkcast 242	com/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyMSFHandlerUtils
    //   197: aload 19
    //   199: aload_2
    //   200: invokevirtual 246	com/tencent/mobileqq/kandian/base/utils/ValueReference:a	()Ljava/lang/Object;
    //   203: checkcast 78	java/lang/Integer
    //   206: invokevirtual 249	java/lang/Integer:intValue	()I
    //   209: iconst_0
    //   210: aload 18
    //   212: invokeinterface 253 5 0
    //   217: pop
    //   218: aload 18
    //   220: lload_3
    //   221: putfield 256	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdFetchTime	J
    //   224: aload 18
    //   226: iload 11
    //   228: putfield 259	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosLayout	I
    //   231: aload 18
    //   233: lload 12
    //   235: putfield 262	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   238: aload 18
    //   240: lload 14
    //   242: putfield 265	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mADVideoAutoPlay	J
    //   245: ldc_w 267
    //   248: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   251: checkcast 267	com/tencent/mobileqq/kandian/ad/api/IRIJAdLogService
    //   254: astore 20
    //   256: new 269	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   263: astore 21
    //   265: aload 21
    //   267: ldc_w 272
    //   270: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 21
    //   276: aload 18
    //   278: getfield 132	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   281: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 20
    //   287: ldc_w 281
    //   290: aload 21
    //   292: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokeinterface 288 3 0
    //   300: lload 7
    //   302: ldc2_w 289
    //   305: lcmp
    //   306: ifne +40 -> 346
    //   309: iload 10
    //   311: ifne +35 -> 346
    //   314: aload 18
    //   316: getfield 294	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   319: ifnull +27 -> 346
    //   322: aload 18
    //   324: getfield 294	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   327: getfield 299	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:f	I
    //   330: ifle +16 -> 346
    //   333: aload_0
    //   334: aload_2
    //   335: aload 18
    //   337: invokespecial 302	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(Lcom/tencent/mobileqq/kandian/base/utils/ValueReference;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   340: iconst_1
    //   341: istore 10
    //   343: goto +3 -> 346
    //   346: ldc_w 304
    //   349: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   352: checkcast 304	com/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusFamilyUtil
    //   355: invokeinterface 307 1 0
    //   360: ifeq +21 -> 381
    //   363: ldc_w 304
    //   366: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   369: checkcast 304	com/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyProteusFamilyUtil
    //   372: aload 19
    //   374: aload 18
    //   376: invokeinterface 311 3 0
    //   381: getstatic 316	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil;
    //   384: aload 18
    //   386: invokevirtual 318	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   389: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +83 -> 475
    //   395: new 269	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   402: astore 19
    //   404: aload 19
    //   406: ldc_w 320
    //   409: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 19
    //   415: aload 18
    //   417: getfield 132	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   420: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 19
    //   426: ldc_w 322
    //   429: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 19
    //   435: aload 18
    //   437: invokevirtual 323	java/lang/Object:toString	()Ljava/lang/String;
    //   440: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 19
    //   446: ldc_w 325
    //   449: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 19
    //   455: aload 18
    //   457: getfield 329	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   460: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: ldc 53
    //   466: iconst_2
    //   467: aload 19
    //   469: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload 18
    //   477: getfield 329	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   480: invokestatic 335	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   483: istore 16
    //   485: iload 16
    //   487: ifne +146 -> 633
    //   490: new 337	org/json/JSONObject
    //   493: dup
    //   494: aload 18
    //   496: getfield 329	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   499: invokespecial 340	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   502: astore 19
    //   504: aload 19
    //   506: ldc_w 342
    //   509: invokevirtual 345	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   512: ifeq +348 -> 860
    //   515: aload 19
    //   517: ldc_w 342
    //   520: invokevirtual 349	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   523: iconst_2
    //   524: if_icmpne +336 -> 860
    //   527: aload 6
    //   529: iconst_1
    //   530: invokestatic 354	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   533: invokevirtual 357	com/tencent/mobileqq/kandian/base/utils/ValueReference:a	(Ljava/lang/Object;)V
    //   536: ldc 53
    //   538: iconst_1
    //   539: ldc_w 359
    //   542: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: goto +3 -> 548
    //   548: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   551: ifeq +43 -> 594
    //   554: new 269	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   561: astore 20
    //   563: aload 20
    //   565: ldc_w 361
    //   568: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload 20
    //   574: aload 19
    //   576: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   579: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: ldc 53
    //   585: iconst_2
    //   586: aload 20
    //   588: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: ldc_w 364
    //   597: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   600: checkcast 364	com/tencent/mobileqq/kandian/ad/api/IRIJSuperMaskService
    //   603: aload 18
    //   605: invokeinterface 367 2 0
    //   610: aload 18
    //   612: invokestatic 372	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyPatchAdUtils:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   615: ifeq +15 -> 630
    //   618: aload 5
    //   620: iconst_1
    //   621: invokestatic 354	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   624: invokevirtual 357	com/tencent/mobileqq/kandian/base/utils/ValueReference:a	(Ljava/lang/Object;)V
    //   627: goto +223 -> 850
    //   630: goto +48 -> 678
    //   633: goto +45 -> 678
    //   636: astore 19
    //   638: new 269	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   645: astore 20
    //   647: aload 20
    //   649: ldc_w 374
    //   652: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload 20
    //   658: aload 19
    //   660: invokevirtual 377	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   663: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: ldc 53
    //   669: iconst_1
    //   670: aload 20
    //   672: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: aload_0
    //   679: aload 18
    //   681: invokespecial 380	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   684: ifne +117 -> 801
    //   687: aload 18
    //   689: aconst_null
    //   690: invokestatic 385	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdSwitchUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lcom/tencent/mobileqq/kandian/biz/ad/entity/VideoAdInfo;)Z
    //   693: ifeq +95 -> 788
    //   696: new 337	org/json/JSONObject
    //   699: dup
    //   700: invokespecial 386	org/json/JSONObject:<init>	()V
    //   703: astore 19
    //   705: aload 19
    //   707: ldc_w 388
    //   710: iconst_0
    //   711: invokevirtual 392	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   714: pop
    //   715: aload 19
    //   717: ldc_w 394
    //   720: iconst_1
    //   721: invokevirtual 392	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   724: pop
    //   725: goto +13 -> 738
    //   728: astore 20
    //   730: goto +3 -> 733
    //   733: aload 20
    //   735: invokevirtual 397	org/json/JSONException:printStackTrace	()V
    //   738: ldc_w 399
    //   741: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   744: checkcast 399	com/tencent/mobileqq/kandian/ad/api/IRIJAdService
    //   747: new 401	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData
    //   750: dup
    //   751: invokespecial 402	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:<init>	()V
    //   754: invokestatic 66	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   757: invokevirtual 405	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(Landroid/content/Context;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   760: bipush 80
    //   762: invokevirtual 408	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(I)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   765: bipush 12
    //   767: invokevirtual 410	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:b	(I)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   770: aload 18
    //   772: invokevirtual 413	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   775: aload 19
    //   777: invokevirtual 416	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:b	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   780: invokeinterface 420 2 0
    //   785: goto +3 -> 788
    //   788: aload 17
    //   790: aload 18
    //   792: invokeinterface 421 2 0
    //   797: pop
    //   798: goto +49 -> 847
    //   801: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   804: ifeq +43 -> 847
    //   807: new 269	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   814: astore 19
    //   816: aload 19
    //   818: ldc_w 423
    //   821: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 19
    //   827: aload 18
    //   829: invokevirtual 426	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toSString	()Ljava/lang/String;
    //   832: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: ldc 53
    //   838: iconst_2
    //   839: aload 19
    //   841: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: goto +3 -> 850
    //   850: goto -829 -> 21
    //   853: aload 17
    //   855: areturn
    //   856: astore_2
    //   857: aload 17
    //   859: areturn
    //   860: goto -312 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	this	AdvertisementInfoModule
    //   0	863	1	paramInt	int
    //   0	863	2	paramValueReference	ValueReference<Integer>
    //   0	863	3	paramLong1	long
    //   0	863	5	paramValueReference1	ValueReference<Boolean>
    //   0	863	6	paramValueReference2	ValueReference<Boolean>
    //   0	863	7	paramLong2	long
    //   0	863	9	paramList	List<articlesummary.ArticleSummary>
    //   19	323	10	i	int
    //   120	107	11	j	int
    //   130	104	12	l1	long
    //   140	101	14	l2	long
    //   483	3	16	bool	boolean
    //   7	851	17	localArrayList	ArrayList
    //   94	734	18	localObject1	Object
    //   41	534	19	localObject2	Object
    //   636	23	19	localException	Exception
    //   703	137	19	localObject3	Object
    //   254	417	20	localObject4	Object
    //   728	6	20	localJSONException	JSONException
    //   263	28	21	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   475	485	636	java/lang/Exception
    //   705	725	728	org/json/JSONException
    //   490	545	856	java/lang/Exception
    //   548	594	856	java/lang/Exception
    //   594	627	856	java/lang/Exception
  }
  
  private List<AbsBaseArticleInfo> a(List<articlesummary.ArticleSummary> paramList)
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
    RIJAdConstants.AdvertisementInfoModule.jdField_a_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.f;
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("async handleAdvertisementResp refreshLastPosX= +");
    localStringBuilder.append(RIJAdConstants.AdvertisementInfoModule.jdField_a_of_type_Int);
    ((IRIJAdLogService)localObject).d("AdDataLink", localStringBuilder.toString());
    a(((Integer)paramValueReference.a()).intValue(), 0, RIJAdConstants.AdvertisementInfoModule.jdField_a_of_type_Int);
    if (paramAdvertisementInfo.mAdvertisementExtInfo.h > 0)
    {
      RIJAdConstants.AdvertisementInfoModule.b = paramAdvertisementInfo.mAdvertisementExtInfo.h;
      paramValueReference = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("async handleAdvertisementResp refreshLastPosZ= +");
      ((StringBuilder)localObject).append(RIJAdConstants.AdvertisementInfoModule.b);
      paramValueReference.d("AdDataLink", ((StringBuilder)localObject).toString());
    }
    if (paramAdvertisementInfo.mAdvertisementExtInfo.g > 0)
    {
      RIJAdConstants.AdvertisementInfoModule.c = paramAdvertisementInfo.mAdvertisementExtInfo.g;
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
      localJSONObject.put("carrier_code", AdDeviceInfoUtil.b());
      if ((paramAdRequestData != null) && (paramAdRequestData.a()))
      {
        localJSONObject.put("MaterialId", paramAdRequestData.jdField_a_of_type_Int);
        localJSONObject.put("RepeatedReqFlag", paramAdRequestData.b);
        localJSONObject.put("KdPos", paramAdRequestData.c);
        localJSONObject.put("adPosId", paramAdRequestData.jdField_a_of_type_Long);
      }
      boolean bool = ((IFeedsPreloadHelper)QRoute.api(IFeedsPreloadHelper.class)).isFeedsPreloadRequest(paramRequest0x68bParams);
      if (bool)
      {
        localJSONObject.put("adRequestFlag", a(paramInt1));
        long l;
        if (this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) == null) {
          l = 0L;
        } else {
          l = ((Long)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
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
      if (StudyModeManager.a()) {
        localJSONObject.put("reqLearningPatternFlag", 1);
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).fillTimeLoadParams(paramAdRequestData, localJSONObject);
      localJSONObject.put("reqTimeVVAdload", 1);
      if (paramDeviceInfo != null) {
        localJSONObject.put("device_ext", paramDeviceInfo.device_ext.get());
      }
      if (AdExposeFreshManager.a().a())
      {
        paramAdRequestData = AdReqFreshManager.a().a();
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
        localJSONObject.put("scene_trace_id", AdSessionManager.a().a());
        localJSONObject.put("scene_series_num", AdSessionManager.a().b());
        localJSONObject.put("refresh_series_num", AdSessionManager.a().a());
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
        if ((localAdvertisementInfo.mAdvertisementExtInfo == null) || (localAdvertisementInfo.mAdvertisementExtInfo.j == 32))
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
    if (ReadInJoyAdUtils.t(paramAdvertisementInfo)) {
      return false;
    }
    if (TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) {
      return true;
    }
    if (ReadInJoyAdUtils.i(paramAdvertisementInfo))
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
        if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) && (!bool))
        {
          paramToServiceMsg = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
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
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a().a(paramToServiceMsg);
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
        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a().a(paramToServiceMsg);
      }
    }
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    return (Pair)this.d.get(Integer.valueOf(paramInt));
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (!a(paramInt1))
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
    ((GdtDeviceInfoHelper.Params)localObject1).jdField_a_of_type_JavaLangString = "ce2d9f";
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
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) == null) {
      l1 = 0L;
    } else {
      l1 = ((Long)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
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
      int j = DeviceInfoUtil.g();
      i = j;
    }
    catch (Exception localException)
    {
      label304:
      break label304;
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_carrier.set(i);
    localObject3 = DeviceInfoUtil.e();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    localObject3 = DeviceInfoUtil.c();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    i = AppSetting.a();
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
  
  public ArrayList<AbsBaseArticleInfo> a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFixPosArticleListSync channelId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AdvertisementInfoModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(b(paramInt));
    return localObject;
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
        return a(paramInsertArticle.rpt_ad_list.get());
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
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    ReadInJoyPatchAdUtils.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFixPosArticleAsyncListener channelID=");
      localStringBuilder.append(paramInt);
      QLog.d("AdvertisementInfoModule", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
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
      AdSessionManager.a().a();
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshChannelAdvertisementFormServer channelId=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" not contained in mChannelID2FixPosArticleAsyncListener");
      QLog.d("AdvertisementInfoModule", 1, ((StringBuilder)localObject1).toString());
      ((IReadInJoyFixPosArticleManager)QRoute.api(IReadInJoyFixPosArticleManager.class)).registerReommendADListener(paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
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
    localReqBody.uint32_network_type.set(a());
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
    if ((paramAdRequestData != null) && (paramAdRequestData.jdField_a_of_type_Boolean))
    {
      ((ToServiceMsg)localObject1).getAttributes().put("asyncRequestChannelFlag", Integer.valueOf(paramInt1));
      ((ToServiceMsg)localObject1).getAttributes().put("asyncAdRequestFlag", Integer.valueOf(1));
      ((ToServiceMsg)localObject1).getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(0));
    }
    ((ToServiceMsg)localObject1).getAttributes().put("isRetryRequest", Boolean.valueOf(a((ToServiceMsg)localObject1)));
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a().a((ToServiceMsg)localObject1);
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
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new WeakReference(paramFixPosArticleAsyncListener));
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
          ((StringBuilder)localObject3).append(localDislikeInfo.jdField_a_of_type_Long);
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(localDislikeInfo.jdField_a_of_type_JavaLangString);
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
    if ((!ReadInJoyAdUtils.s(paramAdvertisementInfo)) && (!ReadInJoyAdUtils.r(paramAdvertisementInfo)))
    {
      if (ReadInJoyAdUtils.t(paramAdvertisementInfo)) {
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
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramObject2.a(), Long.valueOf(l1));
    if ((paramBoolean) && (l1 > 0L)) {
      this.jdField_b_of_type_JavaUtilLinkedHashMap.put(paramObject2.a(), Long.valueOf(l1));
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
  
  public boolean a(int paramInt)
  {
    if (this.e.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.e.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return true;
  }
  
  public int[] a(int paramInt)
  {
    Object localObject2 = b(paramInt);
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
  
  public ArrayList<AdvertisementInfo> b(int paramInt)
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule
 * JD-Core Version:    0.7.0.1
 */