package com.tencent.biz.pubaccount.readinjoy.feedsinsert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModuleUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule;
import com.tencent.biz.pubaccount.readinjoy.popup.RIJPopupWindowUtil;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqBody;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqRecommendPara;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.RspBody;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.RspRecommendParaArticle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Landroid/os/Handler;)V", "feedsInsertInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "Lkotlin/collections/ArrayList;", "requestTimeMap", "addFeedsInsertInfo", "", "channelId", "rowKey", "articleInfoList", "", "addOrReplaceArticleInfoInList", "articleInfo", "addRequestAttributes", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "reqParams", "Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule$ReqParams;", "deleteFeedsInsertInfo", "getArticleInfoListLogInfo", "getFeedsInsertInfo", "handleMainTLFeedsInsertInfo", "req", "rspBody", "Ltencent/im/oidb/cmd0xebb/oidb_cmd0xebb$RspBody;", "result", "", "handleNativePopupInfo", "handleReceiveFeedsInsertInfo", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "isAbleToRequest", "", "followPuin", "onReceive", "removeInvalidArticleInfo", "requestFeedsInsertInfo", "requestFollowPopupInfo", "subscribeId", "reqSource", "unInitialize", "Companion", "ReqParams", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsInsertModule
  extends ReadInJoyEngineModule
{
  public static final RIJFeedsInsertModule.Companion a;
  private final ConcurrentHashMap<Long, ConcurrentHashMap<String, ArrayList<BaseArticleInfo>>> a;
  private final ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsinsertRIJFeedsInsertModule$Companion = new RIJFeedsInsertModule.Companion(null);
  }
  
  public RIJFeedsInsertModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a(List<? extends BaseArticleInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
      localStringBuilder.append("\n articleInfo[" + i + "] = " + localBaseArticleInfo + ' ');
      i += 1;
    }
    paramList = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "stringBuilder.toString()");
    return paramList;
  }
  
  private final void a(BaseArticleInfo paramBaseArticleInfo, ArrayList<BaseArticleInfo> paramArrayList)
  {
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (TextUtils.equals((CharSequence)((BaseArticleInfo)localIterator.next()).innerUniqueID, (CharSequence)paramBaseArticleInfo.innerUniqueID))
      {
        paramArrayList.set(i, paramBaseArticleInfo);
        QLog.i("RIJFeedsInsertModule", 1, "[addOrReplaceArticleInfoInList] replace old articleInfo, articleInfo = " + RIJFeedsInsertUtil.a.a(paramBaseArticleInfo) + ", index = " + i);
        return;
      }
      i += 1;
    }
    paramArrayList.add(0, paramBaseArticleInfo);
    QLog.i("RIJFeedsInsertModule", 1, "[addOrReplaceArticleInfoInList] add new articleInfo, articleInfo = " + RIJFeedsInsertUtil.a.a(paramBaseArticleInfo));
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, RIJFeedsInsertModule.ReqParams paramReqParams)
  {
    Object localObject = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
    ((Map)localObject).put("key_channel_id", Long.valueOf(paramReqParams.a()));
    localObject = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
    Map localMap = (Map)localObject;
    localObject = paramReqParams.a();
    if (localObject != null)
    {
      localObject = ((BaseArticleInfo)localObject).innerUniqueID;
      if (localObject == null) {}
    }
    for (;;)
    {
      localMap.put("key_article_rowKey", localObject);
      localObject = paramToServiceMsg.getAttributes();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
      ((Map)localObject).put("key_subscribe_id", paramReqParams.a());
      paramToServiceMsg = paramToServiceMsg.getAttributes();
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "request.attributes");
      ((Map)paramToServiceMsg).put("key_service_type", Integer.valueOf(0));
      return;
      localObject = "";
    }
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xebb.RspBody paramRspBody, int paramInt)
  {
    Object localObject1;
    long l;
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.msg_rsp_channel_article;
      if (paramRspBody.has()) {
        if (paramRspBody != null)
        {
          localObject1 = paramRspBody.uint64_channel_id;
          if (localObject1 != null)
          {
            l = ((PBUInt64Field)localObject1).get();
            if (paramRspBody == null) {
              break label253;
            }
            paramRspBody = paramRspBody.rpt_article_list;
            if (paramRspBody == null) {
              break label253;
            }
            paramRspBody = paramRspBody.get();
            label56:
            if (paramToServiceMsg == null) {
              break label264;
            }
            paramToServiceMsg = paramToServiceMsg.getAttribute("key_article_rowKey");
            if (paramToServiceMsg == null) {
              break label264;
            }
            if (!(paramToServiceMsg instanceof String)) {
              break label258;
            }
            paramToServiceMsg = (String)paramToServiceMsg;
            label83:
            localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
            if (localObject1 != null) {
              break label333;
            }
            localObject1 = new ConcurrentHashMap();
            ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(l), localObject1);
          }
        }
      }
    }
    label258:
    label264:
    label333:
    for (;;)
    {
      Object localObject2 = (ArrayList)((ConcurrentHashMap)localObject1).get(paramToServiceMsg);
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        ((Map)localObject1).put(paramToServiceMsg, localObject2);
      }
      for (localObject1 = localObject2;; localObject1 = localObject2)
      {
        a((ArrayList)localObject1);
        if (paramRspBody != null)
        {
          paramRspBody = CollectionsKt.asReversedMutable(paramRspBody).iterator();
          for (;;)
          {
            if (paramRspBody.hasNext())
            {
              localObject2 = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)paramRspBody.next(), (int)l, 0, null);
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "articleInfo");
              a((BaseArticleInfo)localObject2, (ArrayList)localObject1);
              continue;
              l = 0L;
              break;
              label253:
              paramRspBody = null;
              break label56;
              paramToServiceMsg = "";
              break label83;
              paramToServiceMsg = "";
              break label83;
            }
          }
        }
        QLog.i("RIJFeedsInsertModule", 1, "[handleMainTLFeedsInsertInfo], channelId = " + l + ", insertRowKey = " + paramToServiceMsg + ", articleInfoList = " + a((List)localObject1));
        return;
      }
    }
  }
  
  private final void a(ArrayList<BaseArticleInfo> paramArrayList)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (BaseArticleInfo)((Iterator)localObject2).next();
      if (!((BaseArticleInfo)localObject3).hasBeenInsertIntoList) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseArticleInfo)((Iterator)localObject1).next();
      paramArrayList.remove(localObject2);
      localObject3 = new StringBuilder().append("[removeInvalidArticleInfo], invalidArticleInfo = ");
      RIJFeedsInsertUtil localRIJFeedsInsertUtil = RIJFeedsInsertUtil.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "invalidArticleInfo");
      QLog.i("RIJFeedsInsertModule", 1, localRIJFeedsInsertUtil.a((BaseArticleInfo)localObject2));
    }
  }
  
  private final boolean a(String paramString)
  {
    Long localLong = (Long)this.b.get(paramString);
    if (localLong != null) {}
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(localLong, "requestTimeMap[followPuin] ?: 0L");
      long l1 = localLong.longValue();
      long l2 = System.currentTimeMillis();
      QLog.i("RIJFeedsInsertModule", 2, "[isAbleToRequest] followPuin = " + paramString + ", last request timeStamp = " + l1 + ", currentTimeStamp = " + l2);
      if (l2 - l1 <= 2000) {
        break;
      }
      return true;
      localLong = Long.valueOf(0L);
    }
    return false;
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xebb.RspBody localRspBody = new oidb_cmd0xebb.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = paramToServiceMsg.getAttribute("key_service_type", Integer.valueOf(0));
      if (paramFromServiceMsg == null) {}
    }
    for (;;)
    {
      QLog.i("RIJFeedsInsertModule", 1, "[handleReceiveFeedsInsertInfo], result = " + i + ", serviceType = " + paramFromServiceMsg);
      if (!Intrinsics.areEqual(paramFromServiceMsg, Integer.valueOf(0))) {
        break;
      }
      a(paramToServiceMsg, localRspBody, i);
      return;
      paramFromServiceMsg = Integer.valueOf(0);
    }
    if (Intrinsics.areEqual(paramFromServiceMsg, Integer.valueOf(1)))
    {
      b(paramToServiceMsg, localRspBody, i);
      return;
    }
    QLog.e("RIJFeedsInsertModule", 1, "[handleReceiveFeedsInsertInfo] do not handle this serviceType: " + paramFromServiceMsg);
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, oidb_cmd0xebb.RspBody paramRspBody, int paramInt)
  {
    int j = 0;
    Object localObject1;
    int i;
    label54:
    label81:
    label106:
    long l;
    if (paramInt == 0)
    {
      if (paramToServiceMsg == null) {
        break label343;
      }
      localObject1 = paramToServiceMsg.getAttribute("KEY_ACTIVITY_HASHCODE");
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof Integer)) {
        localObject2 = null;
      }
      localObject1 = (Integer)localObject2;
      if (localObject1 == null) {
        break label349;
      }
      i = ((Integer)localObject1).intValue();
      localObject1 = paramRspBody.msg_rsp_channel_article;
      if (paramToServiceMsg == null) {
        break label355;
      }
      paramToServiceMsg = paramToServiceMsg.getAttributes();
      if (paramToServiceMsg == null) {
        break label355;
      }
      paramToServiceMsg = paramToServiceMsg.get("KEY_REQ_SOURCE");
      paramRspBody = paramToServiceMsg;
      if (!(paramToServiceMsg instanceof Integer)) {
        paramRspBody = null;
      }
      paramToServiceMsg = (Integer)paramRspBody;
      if (paramToServiceMsg == null) {
        break label360;
      }
      paramInt = paramToServiceMsg.intValue();
      if (((oidb_cmd0xebb.RspRecommendParaArticle)localObject1).has())
      {
        if (localObject1 == null) {
          break label365;
        }
        paramToServiceMsg = ((oidb_cmd0xebb.RspRecommendParaArticle)localObject1).uint64_channel_id;
        if (paramToServiceMsg == null) {
          break label365;
        }
        l = paramToServiceMsg.get();
        label135:
        if (localObject1 == null) {
          break label371;
        }
        paramToServiceMsg = ((oidb_cmd0xebb.RspRecommendParaArticle)localObject1).rpt_article_list;
        if (paramToServiceMsg == null) {
          break label371;
        }
        paramToServiceMsg = paramToServiceMsg.get();
        label155:
        if (paramToServiceMsg != null)
        {
          if (paramToServiceMsg.size() <= 0) {
            break label386;
          }
          paramToServiceMsg = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)paramToServiceMsg.get(0), (int)l, 0, null);
          if (paramToServiceMsg != null)
          {
            paramRspBody = paramToServiceMsg.mRecommendFollowInfos;
            if (paramRspBody == null) {}
          }
          switch (paramInt)
          {
          default: 
            paramInt = 1;
            label226:
            paramRspBody.b = paramInt;
            paramRspBody = new StringBuilder().append("[handleNativePopupInfo], channelId = ").append(l).append(", recommend follow info list size = ");
            paramInt = j;
            if (paramToServiceMsg != null)
            {
              localObject1 = paramToServiceMsg.mRecommendFollowInfos;
              paramInt = j;
              if (localObject1 != null)
              {
                localObject1 = ((RecommendFollowInfos)localObject1).a;
                paramInt = j;
                if (localObject1 != null) {
                  paramInt = ((List)localObject1).size();
                }
              }
            }
            QLog.i("RIJFeedsInsertModule", 1, paramInt);
            paramRspBody = RIJPopupWindowUtil.a;
            localObject1 = (Context)BaseActivity.sTopActivity;
            Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "articleInfo");
            paramRspBody.a((Context)localObject1, paramToServiceMsg, i);
          }
        }
      }
    }
    for (;;)
    {
      return;
      label343:
      localObject1 = null;
      break;
      label349:
      i = 0;
      break label54;
      label355:
      paramToServiceMsg = null;
      break label81;
      label360:
      paramInt = 1;
      break label106;
      label365:
      l = 0L;
      break label135;
      label371:
      paramToServiceMsg = null;
      break label155;
      paramInt = 2;
      break label226;
      paramInt = 1;
      break label226;
      label386:
      QLog.i("RIJFeedsInsertModule", 1, "[handleNativePopupInfo], channelId = " + l + ", articleInfoList is empty.");
    }
  }
  
  @Nullable
  public final ConcurrentHashMap<String, ArrayList<BaseArticleInfo>> a(long paramLong)
  {
    return (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public final void a(long paramLong, @NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      Map.Entry localEntry;
      BaseArticleInfo localBaseArticleInfo;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
          localIterator = ((ArrayList)localEntry.getValue()).iterator();
        }
        localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
      } while (!TextUtils.equals((CharSequence)paramBaseArticleInfo.innerUniqueID, (CharSequence)localBaseArticleInfo.innerUniqueID));
      ((ArrayList)localEntry.getValue()).remove(localBaseArticleInfo);
      QLog.i("RIJFeedsInsertModule", 1, "[deleteFeedsInsertInfo] articleInfo = " + RIJFeedsInsertUtil.a.a(paramBaseArticleInfo));
    }
  }
  
  public final void a(long paramLong, @NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "subscribeId");
    if (!RIJFeedsInsertUtil.a.b(paramInt)) {
      return;
    }
    QLog.i("RIJFeedsInsertModule", 1, "[requestNativePopupInfo], channelId = " + paramLong + ", rowKey = " + paramString1 + ", subscribeId = " + paramString2);
    oidb_cmd0xebb.ReqRecommendPara localReqRecommendPara = new oidb_cmd0xebb.ReqRecommendPara();
    localReqRecommendPara.uint64_channel_id.set(paramLong);
    localReqRecommendPara.bytes_req_rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqRecommendPara.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    paramString1 = new oidb_cmd0xebb.ReqBody();
    paramString1.uint32_network_type.set(ArticleInfoModuleUtils.a());
    paramString1.uint32_os_type.set(2);
    paramString1.msg_req_recommend_para.set((MessageMicro)localReqRecommendPara);
    paramString1.uint32_req_source.set(paramInt);
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xebb", 3771, 1, paramString1.toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "ReadInJoyOidbHelper.make…E, reqBody.toByteArray())");
    paramString2 = paramString1.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "request.attributes");
    ((Map)paramString2).put("key_service_type", Integer.valueOf(1));
    paramString2 = paramString1.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "request.attributes");
    ((Map)paramString2).put("KEY_REQ_SOURCE", Integer.valueOf(paramInt));
    paramString2 = paramString1.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "request.attributes");
    ((Map)paramString2).put("KEY_ACTIVITY_HASHCODE", Integer.valueOf(BaseActivity.sTopActivity.hashCode()));
    a(paramString1);
  }
  
  public final void a(long paramLong, @Nullable String paramString, @Nullable List<? extends BaseArticleInfo> paramList)
  {
    if ((paramString == null) || (paramList == null)) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong))) {
      ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(paramLong), new ConcurrentHashMap());
    }
    Object localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if ((localObject1 == null) || (((ConcurrentHashMap)localObject1).containsKey(paramString) != true))
    {
      localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject1 != null) {
        ((Map)localObject1).put(paramString, new ArrayList());
      }
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      localObject1 = (BaseArticleInfo)paramList.next();
      Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localObject2 != null)
      {
        localObject2 = (ArrayList)((ConcurrentHashMap)localObject2).get(paramString);
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(localObject1);
        }
      }
    }
  }
  
  public final void a(@NotNull RIJFeedsInsertModule.ReqParams paramReqParams)
  {
    Intrinsics.checkParameterIsNotNull(paramReqParams, "reqParams");
    if (!RIJFeedsInsertUtil.a.a((int)paramReqParams.a())) {
      QLog.i("RIJFeedsInsertModule", 1, "[requestFeedsInsertInfo] do not request, channelId = " + paramReqParams.a());
    }
    while (!RIJFeedsInsertUtil.a.a()) {
      return;
    }
    if (!a(paramReqParams.a()))
    {
      QLog.i("RIJFeedsInsertModule", 1, "[requestFeedsInsertInfo] do not request twice in a short period of time...");
      return;
    }
    oidb_cmd0xebb.ReqRecommendPara localReqRecommendPara = new oidb_cmd0xebb.ReqRecommendPara();
    localReqRecommendPara.uint64_channel_id.set(paramReqParams.a());
    PBBytesField localPBBytesField = localReqRecommendPara.bytes_req_rowkey;
    Object localObject = paramReqParams.a();
    if (localObject != null)
    {
      localObject = ((BaseArticleInfo)localObject).innerUniqueID;
      if (localObject == null) {}
    }
    for (;;)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqRecommendPara.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(paramReqParams.a()));
      localReqRecommendPara.uint32_update_times.set(paramReqParams.a());
      localReqRecommendPara.uint32_req_recommend_flag.set(paramReqParams.b());
      localObject = new oidb_cmd0xebb.ReqBody();
      ((oidb_cmd0xebb.ReqBody)localObject).uint32_network_type.set(ArticleInfoModuleUtils.a());
      ((oidb_cmd0xebb.ReqBody)localObject).uint32_os_type.set(2);
      ((oidb_cmd0xebb.ReqBody)localObject).msg_req_recommend_para.set((MessageMicro)localReqRecommendPara);
      ((oidb_cmd0xebb.ReqBody)localObject).uint32_req_source.set(0);
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0xebb", 3771, 0, ((oidb_cmd0xebb.ReqBody)localObject).toByteArray());
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…T, reqBody.toByteArray())");
      a((ToServiceMsg)localObject, paramReqParams);
      a((ToServiceMsg)localObject);
      long l = System.currentTimeMillis();
      ((Map)this.b).put(paramReqParams.a(), Long.valueOf(l));
      QLog.i("RIJFeedsInsertModule", 1, "[requestFeedsInsertInfo], reqParams = " + paramReqParams + ", timeStamp = " + l);
      return;
      localObject = "";
    }
  }
  
  public void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    for (String str = paramFromServiceMsg.getServiceCmd();; str = null)
    {
      if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xebb")) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertModule
 * JD-Core Version:    0.7.0.1
 */