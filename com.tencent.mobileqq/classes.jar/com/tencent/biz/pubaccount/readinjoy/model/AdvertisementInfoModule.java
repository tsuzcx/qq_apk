package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ValueReference;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager;
import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeController;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.ext.AdRequestExtKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
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
import java.util.concurrent.ExecutorService;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdPosMap;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdReqInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PhoneInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;

public class AdvertisementInfoModule
  extends ReadInJoyEngineModule
{
  public static int a;
  public static int b;
  public static int c;
  private LinkedHashMap<Integer, Long> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, WeakReference<FixPosArticleInterface.FixPosArticleAsyncListener>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, Long> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, HashSet<String>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Integer, AdvertisementInfo>> c;
  private LinkedHashMap<Integer, Pair<Integer, Integer>> d;
  private LinkedHashMap<Integer, Boolean> e = new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_Int = 15;
    jdField_b_of_type_Int = 10;
    jdField_c_of_type_Int = 10;
  }
  
  public AdvertisementInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_d_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int a()
  {
    switch (NetworkUtil.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    Object localObject1 = new ArrayList();
    Object localObject2 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
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
          if (((AdvertisementInfo)localObject1).mAdKdPos <= 100) {
            if (!((AdvertisementInfo)localObject1).hasAddExposure) {
              break label132;
            }
          }
        }
      }
    }
    label132:
    for (paramInt = 1;; paramInt = 2) {
      return paramInt;
    }
  }
  
  private String a(String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    int i = (int)paramAdvertisementInfo.mChannelID;
    if (DailyModeConfigHandler.c(i)) {
      paramString = "RIJAdRefreshSceneDaily";
    }
    for (;;)
    {
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
  }
  
  /* Error */
  private List<AdvertisementInfo> a(int paramInt, ValueReference<Integer> paramValueReference, long paramLong1, ValueReference<Boolean> paramValueReference1, ValueReference<Boolean> paramValueReference2, long paramLong2, List<tencent.im.oidb.articlesummary.articlesummary.ArticleSummary> paramList)
  {
    // Byte code:
    //   0: new 80	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 81	java/util/ArrayList:<init>	()V
    //   7: astore 17
    //   9: aload 9
    //   11: invokeinterface 169 1 0
    //   16: astore 9
    //   18: iconst_0
    //   19: istore 10
    //   21: aload 9
    //   23: invokeinterface 109 1 0
    //   28: ifeq +670 -> 698
    //   31: aload 9
    //   33: invokeinterface 113 1 0
    //   38: checkcast 171	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary
    //   41: astore 19
    //   43: aload 19
    //   45: getfield 175	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   48: invokevirtual 180	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:has	()Z
    //   51: ifeq +653 -> 704
    //   54: aload 19
    //   56: getfield 175	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   59: invokevirtual 183	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   62: checkcast 177	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   65: getfield 187	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   68: invokevirtual 190	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:has	()Z
    //   71: ifeq +633 -> 704
    //   74: aload 19
    //   76: getfield 175	tencent/im/oidb/articlesummary/articlesummary$ArticleSummary:msg_feeds_info	Ltencent/im/oidb/articlesummary/articlesummary$FeedsInfo;
    //   79: invokevirtual 183	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: checkcast 177	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo
    //   85: getfield 187	tencent/im/oidb/articlesummary/articlesummary$FeedsInfo:msg_pos_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$PosAdInfo;
    //   88: invokevirtual 191	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 189	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo
    //   94: astore 18
    //   96: aload 18
    //   98: ifnull +606 -> 704
    //   101: aload 18
    //   103: getfield 195	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:int32_ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   106: invokevirtual 199	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   109: ifne +595 -> 704
    //   112: aload 18
    //   114: getfield 203	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:enum_pos_layout	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   117: invokevirtual 206	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   120: istore 11
    //   122: aload 18
    //   124: getfield 210	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:uint64_pos_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   127: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   130: lstore 12
    //   132: aload 18
    //   134: getfield 218	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:is_auto_play	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   137: invokevirtual 215	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   140: lstore 14
    //   142: aload 18
    //   144: getfield 222	tencent/im/oidb/articlesummary/articlesummary$PosAdInfo:msg_ad_info	Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;
    //   147: invokevirtual 225	tencent/im/oidb/articlesummary/articlesummary$AdInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   150: checkcast 224	tencent/im/oidb/articlesummary/articlesummary$AdInfo
    //   153: astore 18
    //   155: aload_0
    //   156: iload_1
    //   157: aload_2
    //   158: aload 18
    //   160: invokespecial 228	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(ILcom/tencent/biz/pubaccount/readinjoy/common/ValueReference;Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   163: new 115	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   166: dup
    //   167: aload 18
    //   169: invokespecial 231	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:<init>	(Ltencent/im/oidb/articlesummary/articlesummary$AdInfo;)V
    //   172: astore 18
    //   174: aload 18
    //   176: invokestatic 236	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdUtils:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   179: aload 19
    //   181: aload_2
    //   182: invokevirtual 240	com/tencent/biz/pubaccount/readinjoy/common/ValueReference:a	()Ljava/lang/Object;
    //   185: checkcast 83	java/lang/Integer
    //   188: invokevirtual 243	java/lang/Integer:intValue	()I
    //   191: iconst_0
    //   192: aload 18
    //   194: invokestatic 248	com/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFHandlerUtils:a	(Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;IILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   197: pop
    //   198: aload 18
    //   200: lload_3
    //   201: putfield 251	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdFetchTime	J
    //   204: aload 18
    //   206: iload 11
    //   208: putfield 254	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosLayout	I
    //   211: aload 18
    //   213: lload 12
    //   215: putfield 257	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdPosID	J
    //   218: aload 18
    //   220: lload 14
    //   222: putfield 260	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mADVideoAutoPlay	J
    //   225: ldc_w 262
    //   228: new 264	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 267
    //   238: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 18
    //   243: getfield 136	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   246: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 283	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: lload 7
    //   257: ldc2_w 284
    //   260: lcmp
    //   261: ifne +440 -> 701
    //   264: iload 10
    //   266: ifne +435 -> 701
    //   269: aload 18
    //   271: getfield 289	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   274: ifnull +427 -> 701
    //   277: aload 18
    //   279: getfield 289	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementExtInfo	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo;
    //   282: getfield 294	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdvertisementExtInfo:f	I
    //   285: ifle +416 -> 701
    //   288: aload_0
    //   289: aload_2
    //   290: aload 18
    //   292: invokespecial 297	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(Lcom/tencent/biz/pubaccount/readinjoy/common/ValueReference;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   295: iconst_1
    //   296: istore 10
    //   298: invokestatic 301	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyProteusFamilyUtil:a	()Z
    //   301: ifeq +13 -> 314
    //   304: invokestatic 304	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyProteusFamilyUtil:a	()Lcom/tencent/biz/pubaccount/readinjoy/common/ReadInJoyProteusFamilyUtil;
    //   307: aload 19
    //   309: aload 18
    //   311: invokevirtual 307	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyProteusFamilyUtil:a	(Ltencent/im/oidb/articlesummary/articlesummary$ArticleSummary;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   314: getstatic 312	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil;
    //   317: aload 18
    //   319: invokevirtual 313	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   322: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +61 -> 386
    //   328: ldc 60
    //   330: iconst_2
    //   331: new 264	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 315
    //   341: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 18
    //   346: getfield 136	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdKdPos	I
    //   349: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc_w 317
    //   355: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 18
    //   360: invokevirtual 318	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toString	()Ljava/lang/String;
    //   363: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 320
    //   369: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 18
    //   374: getfield 324	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   377: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 18
    //   388: getfield 324	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   391: invokestatic 330	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: istore 16
    //   396: iload 16
    //   398: ifne +154 -> 552
    //   401: new 332	org/json/JSONObject
    //   404: dup
    //   405: aload 18
    //   407: getfield 324	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdExtInfo	Ljava/lang/String;
    //   410: invokespecial 335	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   413: astore 19
    //   415: aload 19
    //   417: ldc_w 337
    //   420: invokevirtual 340	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   423: ifeq +33 -> 456
    //   426: aload 19
    //   428: ldc_w 337
    //   431: invokevirtual 344	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   434: iconst_2
    //   435: if_icmpne +21 -> 456
    //   438: aload 6
    //   440: iconst_1
    //   441: invokestatic 349	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   444: invokevirtual 352	com/tencent/biz/pubaccount/readinjoy/common/ValueReference:a	(Ljava/lang/Object;)V
    //   447: ldc 60
    //   449: iconst_1
    //   450: ldc_w 354
    //   453: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +33 -> 492
    //   462: ldc 60
    //   464: iconst_2
    //   465: new 264	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 356
    //   475: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload 19
    //   480: invokevirtual 357	org/json/JSONObject:toString	()Ljava/lang/String;
    //   483: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: getstatic 362	com/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskDataMgr:a	Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskDataMgr;
    //   495: aload 18
    //   497: invokevirtual 363	com/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskDataMgr:a	(Ljava/lang/Object;)V
    //   500: aload 18
    //   502: invokestatic 368	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyPatchAdUtils:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   505: ifeq +47 -> 552
    //   508: aload 5
    //   510: iconst_1
    //   511: invokestatic 349	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   514: invokevirtual 352	com/tencent/biz/pubaccount/readinjoy/common/ValueReference:a	(Ljava/lang/Object;)V
    //   517: goto -496 -> 21
    //   520: astore 19
    //   522: ldc 60
    //   524: iconst_1
    //   525: new 264	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 370
    //   535: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 19
    //   540: invokevirtual 373	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   543: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 375	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload_0
    //   553: aload 18
    //   555: invokespecial 376	com/tencent/biz/pubaccount/readinjoy/model/AdvertisementInfoModule:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Z
    //   558: ifne +100 -> 658
    //   561: aload 18
    //   563: aconst_null
    //   564: invokestatic 381	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/ReadInJoyAdSwitchUtil:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;Lcom/tencent/biz/pubaccount/VideoAdInfo;)Z
    //   567: ifeq +68 -> 635
    //   570: new 332	org/json/JSONObject
    //   573: dup
    //   574: invokespecial 382	org/json/JSONObject:<init>	()V
    //   577: astore 19
    //   579: aload 19
    //   581: ldc_w 384
    //   584: iconst_0
    //   585: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   588: pop
    //   589: aload 19
    //   591: ldc_w 390
    //   594: iconst_1
    //   595: invokevirtual 388	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   598: pop
    //   599: new 392	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData
    //   602: dup
    //   603: invokespecial 393	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:<init>	()V
    //   606: invokestatic 72	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   609: invokevirtual 396	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(Landroid/content/Context;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   612: bipush 80
    //   614: invokevirtual 399	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(I)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   617: bipush 12
    //   619: invokevirtual 401	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:b	(I)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   622: aload 18
    //   624: invokevirtual 404	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   627: aload 19
    //   629: invokevirtual 407	com/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData:b	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;
    //   632: invokestatic 412	com/tencent/biz/pubaccount/NativeAd/util/NativeAdUtils:a	(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;)V
    //   635: aload 17
    //   637: aload 18
    //   639: invokeinterface 413 2 0
    //   644: pop
    //   645: goto -624 -> 21
    //   648: astore 20
    //   650: aload 20
    //   652: invokevirtual 416	org/json/JSONException:printStackTrace	()V
    //   655: goto -56 -> 599
    //   658: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   661: ifeq +33 -> 694
    //   664: ldc 60
    //   666: iconst_2
    //   667: new 264	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   674: ldc_w 418
    //   677: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload 18
    //   682: invokevirtual 421	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:toSString	()Ljava/lang/String;
    //   685: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   694: goto -49 -> 645
    //   697: astore_2
    //   698: aload 17
    //   700: areturn
    //   701: goto -403 -> 298
    //   704: goto -59 -> 645
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	this	AdvertisementInfoModule
    //   0	707	1	paramInt	int
    //   0	707	2	paramValueReference	ValueReference<Integer>
    //   0	707	3	paramLong1	long
    //   0	707	5	paramValueReference1	ValueReference<Boolean>
    //   0	707	6	paramValueReference2	ValueReference<Boolean>
    //   0	707	7	paramLong2	long
    //   0	707	9	paramList	List<tencent.im.oidb.articlesummary.articlesummary.ArticleSummary>
    //   19	278	10	i	int
    //   120	87	11	j	int
    //   130	84	12	l1	long
    //   140	81	14	l2	long
    //   394	3	16	bool	boolean
    //   7	692	17	localArrayList	ArrayList
    //   94	587	18	localObject1	Object
    //   41	438	19	localObject2	Object
    //   520	19	19	localException	Exception
    //   577	51	19	localJSONObject	JSONObject
    //   648	3	20	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   386	396	520	java/lang/Exception
    //   579	599	648	org/json/JSONException
    //   401	456	697	java/lang/Exception
    //   456	492	697	java/lang/Exception
    //   492	517	697	java/lang/Exception
  }
  
  private void a(int paramInt, ValueReference<Integer> paramValueReference, articlesummary.AdInfo paramAdInfo)
  {
    if ((paramAdInfo != null) && (paramInt == 0))
    {
      paramValueReference.a(Integer.valueOf((int)paramAdInfo.uint64_channel_id.get()));
      ReadInJoyAdLog.a("AdDataLink", "handleAdvertisementResp channelID from AdInfo:" + paramValueReference.a());
    }
  }
  
  private void a(ValueReference<Integer> paramValueReference, long paramLong, ArrayList<AdvertisementInfo> paramArrayList)
  {
    if (paramArrayList.size() == 0) {
      paramArrayList = new JSONObject();
    }
    try
    {
      paramArrayList.put("svrresp_result", 1);
      paramArrayList.put("svrresp_fail_type", 1);
      NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(80).b(12).b(paramArrayList));
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + paramValueReference.a() + ", fetchTime=" + paramLong + " parsedAdvertisementList empty!");
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(ValueReference<Integer> paramValueReference, AdvertisementInfo paramAdvertisementInfo)
  {
    jdField_a_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.f;
    ReadInJoyAdLog.a("AdDataLink", "async handleAdvertisementResp refreshLastPosX= +" + jdField_a_of_type_Int);
    a(((Integer)paramValueReference.a()).intValue(), 0, jdField_a_of_type_Int);
    if (paramAdvertisementInfo.mAdvertisementExtInfo.h > 0)
    {
      jdField_b_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.h;
      ReadInJoyAdLog.a("AdDataLink", "async handleAdvertisementResp refreshLastPosZ= +" + jdField_b_of_type_Int);
    }
    if (paramAdvertisementInfo.mAdvertisementExtInfo.g > 0)
    {
      jdField_c_of_type_Int = paramAdvertisementInfo.mAdvertisementExtInfo.g;
      ReadInJoyAdLog.a("AdDataLink", "async handleAdvertisementResp refreshLastPosY= +" + jdField_c_of_type_Int);
    }
  }
  
  private void a(ValueReference<Integer> paramValueReference, ConcurrentHashMap<Integer, AdvertisementInfo> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements size = " + paramConcurrentHashMap.size());
    }
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
      ReadInJoyLogicEngine.a().a(((Integer)paramValueReference.a()).intValue(), localAdvertisementInfo);
    }
    paramConcurrentHashMap.clear();
  }
  
  private void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo, oidb_cmd0x68b.ReqAdvertisePara paramReqAdvertisePara)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("adPosType", paramInt2);
        localJSONObject.put("adStartPos", paramInt3);
        localJSONObject.put("adEndPos", paramInt4);
        localJSONObject.put("carrier_code", AdDeviceInfoUtil.b());
        if ((paramAdRequestData != null) && (paramAdRequestData.a()))
        {
          localJSONObject.put("MaterialId", paramAdRequestData.jdField_a_of_type_Int);
          localJSONObject.put("RepeatedReqFlag", paramAdRequestData.jdField_b_of_type_Int);
          localJSONObject.put("KdPos", paramAdRequestData.jdField_c_of_type_Int);
          localJSONObject.put("adPosId", paramAdRequestData.jdField_a_of_type_Long);
        }
        if (!FeedsPreloadHelper.b(paramRequest0x68bParams)) {
          break label356;
        }
        localJSONObject.put("adRequestFlag", a(paramInt1));
        if (this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) == null)
        {
          l = 0L;
          localJSONObject.put("lastRefreshTime", l);
          AdRequestExtKt.a(paramAdRequestData, localJSONObject, paramInt1, paramInt2);
          AdRequestExtKt.a(paramAdRequestData, localJSONObject, paramInt2);
          AdRequestExtKt.b(paramAdRequestData, localJSONObject, paramInt2);
          if (StudyModeManager.a()) {
            localJSONObject.put("reqLearningPatternFlag", 1);
          }
          AdRequestExtKt.a(paramAdRequestData, localJSONObject);
          localJSONObject.put("reqTimeVVAdload", 1);
          if (paramDeviceInfo != null) {
            localJSONObject.put("device_ext", paramDeviceInfo.device_ext.get());
          }
          if (!AdExposeFreshManager.a().a()) {
            break label379;
          }
          paramAdRequestData = AdReqFreshManager.a().a();
          paramRequest0x68bParams = new JSONArray();
          if ((paramAdRequestData == null) || (paramAdRequestData.size() <= 0)) {
            break;
          }
          paramAdRequestData = paramAdRequestData.iterator();
          if (!paramAdRequestData.hasNext()) {
            break;
          }
          paramRequest0x68bParams.put((Long)paramAdRequestData.next());
          continue;
        }
        long l = ((Long)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
      }
      catch (JSONException paramRequest0x68bParams)
      {
        paramRequest0x68bParams.printStackTrace();
        return;
      }
      continue;
      label356:
      localJSONObject.put("adRequestFlag", 0);
    }
    localJSONObject.put("noExposeList", paramRequest0x68bParams);
    label379:
    if (paramInt1 == 0)
    {
      localJSONObject.put("sceneTraceID", AdSessionManager.a().a());
      localJSONObject.put("sceneSeriesNum", AdSessionManager.a().b());
      localJSONObject.put("refreshSeriesNum", AdSessionManager.a().a());
    }
    paramReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
    QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo," + localJSONObject.toString());
  }
  
  private void a(ArrayList<AdvertisementInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      if (paramArrayList.size() > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleAdvertisementResp \n").append("[ ");
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramArrayList.next();
          localStringBuilder.append("channelId = ").append(localAdvertisementInfo.mChannelID).append(" title = ").append(localAdvertisementInfo.mTitle).append(" pos = ").append(localAdvertisementInfo.mAdKdPos);
        }
        ReadInJoyAdLog.a("AdDataLink", " ]");
      }
    }
    else {
      return;
    }
    ReadInJoyAdLog.a("AdDataLink", "handleAdvertisementResp no advertisementInfo");
  }
  
  private void a(List<AdvertisementInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    HashSet localHashSet1 = new HashSet(paramList.size());
    HashSet localHashSet2 = new HashSet();
    Object localObject2 = null;
    int i = 0;
    if (i < paramList.size())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramList.get(i);
      Object localObject1;
      if ((localAdvertisementInfo.mAdvertisementExtInfo != null) && (localAdvertisementInfo.mAdvertisementExtInfo.j != 32)) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject1;
        break;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = a((String)localObject2, localAdvertisementInfo);
        }
        localAdvertisementInfo.scene = ((String)localObject1);
        localObject2 = AdExposeFreshManager.a().a((String)localObject1, localAdvertisementInfo);
        paramList.set(i, localObject2);
        localHashSet1.add(Long.valueOf(((AdvertisementInfo)localObject2).mAdAid));
        localHashSet2.add(localObject2);
      }
    }
    if (localObject2 == null)
    {
      QLog.d("AdvertisementInfoModule", 2, "handleAdFreshness,scene is null");
      return;
    }
    AdReqFreshManager.a().a((String)localObject2, localHashSet1);
    AdExposeFreshManager.a().c((String)localObject2, localHashSet2);
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
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementInfoModule", 2, "makeReqAdvertisePara: deviceInfo: ma=" + paramPhoneInfo.string_androidid.get() + ", mm=" + paramPhoneInfo.string_mac.get() + ", oa=" + paramPhoneInfo.string_oaid.get() + ", ta=" + paramPhoneInfo.string_taid.get());
    }
  }
  
  private void a(oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (paramRspChannelArticle.msg_ad_pos_map.has())
    {
      paramRspChannelArticle = (oidb_cmd0x68b.AdPosMap)paramRspChannelArticle.msg_ad_pos_map.get();
      if (paramRspChannelArticle.bytes_ads_context.has())
      {
        NativeAdUtils.a(paramRspChannelArticle.bytes_ads_context.get().toStringUtf8());
        return;
      }
      NativeAdUtils.a("");
      return;
    }
    NativeAdUtils.a("");
  }
  
  private boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = false;
    if (paramAdvertisementInfo == null) {}
    while (TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) {
      return true;
    }
    if (ReadInJoyAdUtils.i(paramAdvertisementInfo))
    {
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "filterAdvertisementInfo: isSuperMaskNormalAdType");
      return true;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
    {
      if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)) || (TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl))) {
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    int k = ((Integer)paramToServiceMsg.getAttribute(h, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",repeatedreqFlag=" + k);
    }
    int j = ((Integer)paramToServiceMsg.getAttribute(i, Integer.valueOf(0))).intValue();
    ((Integer)paramToServiceMsg.getAttribute(j, Integer.valueOf(-1))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",asyncChannelId=" + j);
    }
    VideoAdTimeLoadManager.a(j);
    ReadInJoyAdLog.a("AdDataLink", "handle0x68bGetAdvertisementList result = " + i);
    if (i == 0) {
      if (!localRspBody.uint64_uin.has()) {
        break label801;
      }
    }
    label798:
    label801:
    for (long l = localRspBody.uint64_uin.get();; l = -1L)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        paramFromServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        i = (int)paramFromServiceMsg.uint64_channel_id.get();
        if ((i != 0) || (j == 0)) {
          break label798;
        }
        i = j;
      }
      for (;;)
      {
        ReadInJoyAdLog.a("AdDataLink", "handleAdvertisementResp 处理广告");
        boolean bool;
        if ((paramFromServiceMsg.rpt_advertise_list.has()) && (paramFromServiceMsg.rpt_advertise_list.get() != null))
        {
          ReadInJoyAdLog.a("AdDataLink", "handleAdvertisementResp in ad Request");
          paramObject = new ValueReference(Boolean.valueOf(false));
          a(paramToServiceMsg, paramFromServiceMsg, k, j, false, paramObject);
          bool = ((Boolean)paramObject.a()).booleanValue();
        }
        for (;;)
        {
          if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) && (!bool))
          {
            paramToServiceMsg = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
            {
              QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList listener = " + paramToServiceMsg.toString());
              ((FixPosArticleInterface.FixPosArticleAsyncListener)paramToServiceMsg.get()).a(i);
            }
          }
          return;
          if (k == 1)
          {
            ReadInJoyAdLog.a("AdDataLink", "handle0x68bGetAdvertisementList 重复曝光加载数据返回空");
            bool = true;
          }
          else
          {
            ReadInJoyAdLog.a("AdDataLink", "handleAdvertisementResp channelArticle.rpt_advertise_list.has() = " + paramFromServiceMsg.rpt_advertise_list.has() + " channelArticle.rpt_advertise_list.get() = " + paramFromServiceMsg.rpt_advertise_list.get() + " repeatedreqFlag = " + k);
            bool = true;
          }
        }
        ReadInJoyAdLog.a("AdDataLink", "handle0x68bGetAdvertisementList resp.rspChannelArticle.has() = " + localRspBody.rspChannelArticle.has() + " uin = " + l + " currentUin = " + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        return;
        j = ((Integer)paramToServiceMsg.getAttribute(f)).intValue();
        ReadInJoyAdLog.a("AdDataLink", "handle0x68bGetAdvertisementList Error result = " + i + " requestCount = " + j);
        if ((i == 154) && (j == 1))
        {
          paramToServiceMsg.getAttributes().put(f, Integer.valueOf(2));
          a(paramToServiceMsg);
          ReadInJoyAdLog.a("AdDataLink", "handle0x68bGetAdvertisementList timeout retry : requestCount = " + j);
          return;
        }
        paramToServiceMsg = new JSONObject();
        try
        {
          paramToServiceMsg.put("svrresp_result", 1);
          paramToServiceMsg.put("svrresp_fail_type", 2);
          paramToServiceMsg.put("svrresp_fail_code", i);
          NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(80).b(12).b(paramToServiceMsg));
          return;
        }
        catch (JSONException paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x886AdvertisementReportResp!");
    }
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (i != 0)
    {
      int j = ((Integer)paramToServiceMsg.getAttribute(g)).intValue();
      if ((i == 154) && (j == 1))
      {
        paramToServiceMsg.getAttributes().put(g, Integer.valueOf(2));
        a(paramToServiceMsg);
      }
    }
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    return (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (!a(paramInt1))
    {
      ReadInJoyAdLog.a("AdDataLink", "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "   !needRequestAdvertisement ");
      return null;
    }
    Pair localPair = (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localPair != null)
    {
      if (paramInt2 + jdField_c_of_type_Int <= ((Integer)localPair.second).intValue()) {
        return null;
      }
      int i = ((Integer)localPair.second).intValue();
      int j = jdField_b_of_type_Int + i;
      ReadInJoyAdLog.a("AdDataLink", "first = " + localPair.first + " second = " + localPair.second);
      ReadInJoyAdLog.a("AdDataLink", "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "  position=" + paramInt2 + "  startpos=" + i + "  endpos=" + j);
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
    }
    return null;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      ReadInJoyAdLog.a("AdVideoDataLink", "getAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      return null;
    }
    localObject = (AdvertisementInfo)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt2));
    if (localObject != null)
    {
      ReadInJoyAdLog.a("AdVideoDataLink", "getAdvertisementInfo channelId=" + paramInt1 + " advertisementInfo = " + ((AdvertisementInfo)localObject).mTitle + " pos = " + ((AdvertisementInfo)localObject).mAdKdPos);
      return localObject;
    }
    return null;
  }
  
  public ArrayList<BaseArticleInfo> a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPosArticleListSync channelId=" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramInt));
    return localArrayList;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "makeReqAdvertisePara channelID=" + paramInt1);
    }
    Object localObject1 = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject1).jdField_a_of_type_JavaLangString = "ce2d9f";
    Object localObject3 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject1);
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = ((GdtDeviceInfoHelper.Result)localObject3).a;
      localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(paramInt1, true);
      localObject2 = localReqAdvertisePara.uint64_last_time;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
        break label509;
      }
    }
    label258:
    label509:
    for (long l = 0L;; l = ((Long)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue())
    {
      ((PBUInt64Field)localObject2).set(l, true);
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
        int j = DeviceInfoUtil.f();
        i = j;
      }
      catch (Exception localException)
      {
        break label258;
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
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_ads_context.set(ByteStringMicro.copyFromUtf8(NativeAdUtils.a()));
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
      if (localObject1 != null) {
        a((qq_ad_get.QQAdGet.DeviceInfo)localObject1, (oidb_cmd0x68b.PhoneInfo)localObject2);
      }
      ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_wx_ver.set(ByteStringMicro.copyFrom(AdDeviceInfoUtil.a(BaseApplication.getContext()).getBytes()));
      localReqAdvertisePara.msg_phone_info.set((MessageMicro)localObject2, true);
      if (paramInt3 != paramInt4) {
        a(paramRequest0x68bParams, paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData, (qq_ad_get.QQAdGet.DeviceInfo)localObject1, localReqAdvertisePara);
      }
      paramRequest0x68bParams = new oidb_cmd0x68b.AdReqInfo();
      paramRequest0x68bParams.uint64_ad_channel_id.set(paramInt1);
      localReqAdvertisePara.msg_ad_req_info.set(paramRequest0x68bParams);
      return localReqAdvertisePara;
      localObject1 = null;
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitialize!");
    }
    this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    ReadInJoyPatchAdUtils.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "removeFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Pair localPair = (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localPair == null) {
      localPair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    for (;;)
    {
      int i = paramInt3;
      if (paramInt2 != 0)
      {
        i = paramInt3;
        if (paramInt3 < ((Integer)localPair.second).intValue()) {
          i = ((Integer)localPair.second).intValue();
        }
      }
      ReadInJoyAdLog.a("AdDataLink", "async setLocalAdvertisementRange channelid=" + paramInt1 + "  adStart=" + paramInt2 + "  adEnd=" + i);
      localPair = new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt1));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt1), localPair);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, AdRequestData paramAdRequestData)
  {
    ReadInJoyAdLog.a("AdDataLink", "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " adPosType = " + paramInt2 + " adStart = " + paramInt3 + " adEnd = " + paramInt4 + " 请求广告");
    if (paramInt1 == 0) {
      AdSessionManager.a().a();
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " not contained in mChannelID2FixPosArticleAsyncListener");
      ReadinjoyFixPosArticleManager.a().a(paramInt1);
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((WeakReference)localObject).get() == null))
      {
        QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " listener is null");
        ReadinjoyFixPosArticleManager.a().a(paramInt1);
      }
    }
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.req_advertise_para.set(a(null, paramInt1, paramInt2, paramInt3, paramInt4, paramAdRequestData));
    ToServiceMsg localToServiceMsg = ReadInJoyOidbHelper.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    localToServiceMsg.getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
    if ((paramAdRequestData != null) && (paramAdRequestData.jdField_b_of_type_Int == 1))
    {
      localToServiceMsg.getAttributes().put(h, Integer.valueOf(paramAdRequestData.jdField_b_of_type_Int));
      localToServiceMsg.getAttributes().put(f, Integer.valueOf(0));
    }
    for (;;)
    {
      localToServiceMsg.getAttributes().put("adpostype_0x68b", Integer.valueOf(paramInt2));
      if (!DailyModeConfigHandler.c(paramInt1))
      {
        localObject = localToServiceMsg;
        if (!ReadInJoyHelper.a(paramInt1)) {}
      }
      else
      {
        localReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(RealTimeController.a("default_feeds")));
        localObject = localToServiceMsg;
        if (ReadInJoyHelper.z())
        {
          localObject = ReadInJoyDailySettingModel.a(paramInt1);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
          }
          localObject = ReadInJoyOidbHelper.a("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray());
          ((ToServiceMsg)localObject).getAttributes().put("realTimeServiceKey", "default_feeds");
          ((ToServiceMsg)localObject).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
        }
      }
      if ((paramAdRequestData != null) && (paramAdRequestData.jdField_a_of_type_Boolean))
      {
        ((ToServiceMsg)localObject).getAttributes().put(i, Integer.valueOf(paramInt1));
        ((ToServiceMsg)localObject).getAttributes().put(j, Integer.valueOf(1));
        ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(0));
      }
      a((ToServiceMsg)localObject);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
      return;
      localToServiceMsg.getAttributes().put(f, Integer.valueOf(1));
    }
  }
  
  public void a(int paramInt, FixPosArticleInterface.FixPosArticleAsyncListener paramFixPosArticleAsyncListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "setFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new WeakReference(paramFixPosArticleAsyncListener));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "async setChannelNeedRequestAdvertisement channelid=" + paramInt + "  bNeed= " + paramBoolean);
    }
    this.e.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "doUninterestAdvertisement tagId=" + paramLong + ", channelId=" + paramAdvertisementInfo.mChannelID + ", pos=" + paramAdvertisementInfo.mAdKdPos + ", traceID=" + paramAdvertisementInfo.mAdTraceId);
      }
      localObject1 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
      if (localObject1 != null) {
        ((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramAdvertisementInfo.mAdKdPos));
      }
    } while (paramBoolean);
    String str1 = "";
    Object localObject1 = "";
    Object localObject2 = localObject1;
    String str2 = str1;
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      localObject2 = localObject1;
      str2 = str1;
      if (i < paramArrayList.size())
      {
        localObject2 = (DislikeInfo)paramArrayList.get(i);
        if (localObject2 == null) {
          break label412;
        }
        str1 = str1 + ((DislikeInfo)localObject2).jdField_a_of_type_Long;
        localObject1 = (String)localObject1 + ((DislikeInfo)localObject2).jdField_a_of_type_JavaLangString;
        if (i == paramArrayList.size() - 1) {
          break label415;
        }
        str1 = str1 + ",";
        localObject1 = (String)localObject1 + ",";
      }
    }
    label412:
    label415:
    for (;;)
    {
      i += 1;
      break;
      if (paramAdvertisementInfo.mChannelID == 56L)
      {
        NativeAdUtils.a(new AdReportData().a(paramContext).a(3).b(4).a(paramAdvertisementInfo).a((int)paramLong).a(str2).b((String)localObject2));
        return;
      }
      if (RIJFeedsType.a(paramAdvertisementInfo)) {}
      for (i = 11;; i = 3)
      {
        NativeAdUtils.a(new AdReportData().a(paramContext).a(3).b(i).a(paramAdvertisementInfo).a((int)paramLong).a(str2).b((String)localObject2));
        return;
      }
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
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "native object is null");
        }
      }
      else
      {
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
        localObject2 = ((JSONObject)localObject1).toString();
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "get ad app json: " + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
          localObject2 = new NewIntent(paramAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
          ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_native");
          ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          ((NewIntent)localObject2).setObserver(new AdvertisementInfoModule.3(this, paramAdvertisementInfo));
          paramAppInterface.startServlet((NewIntent)localObject2);
          return;
        }
      }
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ReadInJoyAdLog.a("AdDataLink", "onReceiveAD response cmd=" + paramFromServiceMsg.getServiceCmd() + " 广告回包");
    if ((paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) || (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, int paramInt1, int paramInt2, boolean paramBoolean, ValueReference<Boolean> paramValueReference)
  {
    if (paramRspChannelArticle == null)
    {
      paramValueReference.a(Boolean.valueOf(true));
      return;
    }
    ValueReference localValueReference1 = new ValueReference(Integer.valueOf((int)paramRspChannelArticle.uint64_channel_id.get()));
    if ((((Integer)localValueReference1.a()).intValue() == 0) && (paramInt2 != 0)) {
      localValueReference1.a(Integer.valueOf(paramInt2));
    }
    long l1 = paramRspChannelArticle.uint64_pos_ad_time.get();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ValueReference(Boolean.valueOf(false));
    ValueReference localValueReference2 = new ValueReference(Boolean.valueOf(false));
    long l2 = ((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue();
    if ((paramRspChannelArticle.rpt_advertise_list.has()) && (paramRspChannelArticle.rpt_advertise_list.get() != null))
    {
      List localList = paramRspChannelArticle.rpt_advertise_list.get();
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp resp.rpt_advertise_list size " + localList.size());
      }
      localList = a(paramInt2, localValueReference1, l1, (ValueReference)localObject, localValueReference2, l2, localList);
      a(localList);
      localArrayList.addAll(localList);
      a(localArrayList);
      if (((Boolean)((ValueReference)localObject).a()).booleanValue())
      {
        a(localValueReference1, l1, localArrayList);
        paramValueReference.a(Boolean.valueOf(true));
        return;
      }
      a(paramRspChannelArticle);
    }
    if (((Boolean)localValueReference2.a()).booleanValue()) {
      a(((Integer)localValueReference1.a()).intValue(), false);
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localValueReference1.a(), Long.valueOf(l1));
    if ((paramBoolean) && (l1 > 0L)) {
      this.jdField_b_of_type_JavaUtilLinkedHashMap.put(localValueReference1.a(), Long.valueOf(l1));
    }
    ReadInJoyAdLog.a("AdvertisementInfoModule", "async makeReqAdvertisePara adinfo, fromRefresh=" + paramBoolean + ", list.size()=" + localArrayList.size() + ",fetchTime=" + l1);
    paramRspChannelArticle = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(localValueReference1.a());
    if (paramRspChannelArticle == null)
    {
      paramRspChannelArticle = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilLinkedHashMap.put(localValueReference1.a(), paramRspChannelArticle);
    }
    for (;;)
    {
      paramValueReference = new ConcurrentHashMap();
      paramBoolean = FeedsPreloadHelper.a(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp beginSeq = " + l2 + ",isFeedsPreload=" + paramBoolean + ",advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + localValueReference1.a() + ", fetchTime=" + l1 + ",repeatedreqFlag=" + paramInt1);
      }
      if ((paramBoolean) && (localArrayList.size() <= 0)) {}
      for (paramToServiceMsg = paramValueReference;; paramToServiceMsg = paramRspChannelArticle)
      {
        VideoAdTimeLoadManager.a(((Integer)localValueReference1.a()).intValue(), localArrayList);
        a(localValueReference1, paramToServiceMsg);
        paramToServiceMsg = new StringBuilder("handleAdvertisementResp channelID=" + localValueReference1.a() + ", fetchTime=" + l1 + "\n");
        paramValueReference = localArrayList.iterator();
        while (paramValueReference.hasNext())
        {
          localObject = (AdvertisementInfo)paramValueReference.next();
          paramRspChannelArticle.put(Integer.valueOf(((AdvertisementInfo)localObject).mAdKdPos), localObject);
          paramToServiceMsg.append("[pos=").append(((AdvertisementInfo)localObject).mAdKdPos).append(", traceID=").append(((AdvertisementInfo)localObject).mAdTraceId).append("]\n");
          if ((((AdvertisementInfo)localObject).mAdJumpMode == 4) && (TextUtils.isEmpty(((AdvertisementInfo)localObject).mAdAppJson))) {
            a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (AdvertisementInfo)localObject);
          }
        }
        if (l2 != -1L) {
          break;
        }
      }
      localObject = localArrayList.iterator();
      for (;;)
      {
        paramToServiceMsg = paramValueReference;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramToServiceMsg = (AdvertisementInfo)((Iterator)localObject).next();
        if (paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)) != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements info = " + paramToServiceMsg.toSString());
          }
          paramValueReference.put(Integer.valueOf(paramToServiceMsg.mAdKdPos), paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)));
          paramRspChannelArticle.remove(Integer.valueOf(paramToServiceMsg.mAdKdPos));
        }
      }
      QLog.d("AdvertisementInfoModule", 1, paramToServiceMsg.toString());
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + localValueReference1.a());
      }
      if (localArrayList.size() != 0) {
        break;
      }
      paramToServiceMsg = new JSONObject();
      try
      {
        paramToServiceMsg.put("svrresp_result", 1);
        paramToServiceMsg.put("svrresp_fail_type", 1);
        NativeAdUtils.a(new AdReportData().a(BaseApplication.getContext()).a(80).b(12).b(paramToServiceMsg));
        ReadInJoyAdLog.a("AdDataLink", "handleAdvertisementResp channelID=" + localValueReference1.a() + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
        return;
      }
      catch (JSONException paramRspChannelArticle)
      {
        for (;;)
        {
          paramRspChannelArticle.printStackTrace();
        }
      }
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
    ArrayList localArrayList = b(paramInt);
    if (localArrayList.size() <= 0)
    {
      ReadInJoyAdLog.a("AdDataLink", "getFixPositionSync channelID=" + paramInt + " return empty!");
      return new int[0];
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((AdvertisementInfo)localArrayList.get(i)).mAdKdPos;
      localStringBuilder.append(arrayOfInt[i]);
      if (i != localArrayList.size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    ReadInJoyAdLog.a("AdDataLink", "getFixPositionSync channelID=" + paramInt + " return " + localStringBuilder.toString());
    return arrayOfInt;
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      ReadInJoyAdLog.a("AdVideoDataLink", "removeAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      return null;
    }
    localObject = (AdvertisementInfo)((ConcurrentHashMap)localObject).remove(Integer.valueOf(paramInt2));
    if (localObject != null)
    {
      ReadInJoyAdLog.a("AdVideoDataLink", "removeAdvertisementInfo channelId=" + paramInt1 + " advertisementInfo = " + ((AdvertisementInfo)localObject).mTitle + " pos = " + ((AdvertisementInfo)localObject).mAdKdPos);
      return localObject;
    }
    return null;
  }
  
  public ArrayList<AdvertisementInfo> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((AdvertisementInfo)((Iterator)localObject).next());
      }
      Collections.sort(localArrayList, new AdvertisementInfoModule.1(this));
    }
    if (!QLog.isColorLevel()) {
      return localArrayList;
    }
    localObject = new StringBuilder("\n");
    int i = 0;
    while (i < localArrayList.size())
    {
      AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localArrayList.get(i);
      ((StringBuilder)localObject).append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append(", title=").append(localAdvertisementInfo.mTitle).append("]");
      if (i != localArrayList.size() - 1) {
        ((StringBuilder)localObject).append("\n");
      }
      i += 1;
    }
    ReadInJoyAdLog.a("AdDataLink", "loadChannelAdvertisement channelId=" + paramInt + " return " + ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule
 * JD-Core Version:    0.7.0.1
 */