package com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert;

import android.os.Build;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertArticle;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModuleUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.Action;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.ReqBody;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.ReqRecommendPara;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.RspBody;
import tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.RspRecommendParaArticle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Landroid/os/Handler;)V", "callbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;", "callbackSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", "feedsInsertInfoMap", "", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/data/RIJFeedsInsertArticle;", "getFeedsInsertInfoMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "deleteFeedsDynamicInsertInfo", "", "reqSource", "rowKey", "deleteFeedsDynamicInsertInfoInServer", "getFeedsInsertInfo", "handle0xf30", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "makeDynamicInsertArticleParams", "actionType", "Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;", "isPreload", "", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;Z)Lcom/tencent/qphone/base/remote/ToServiceMsg;", "onReceive", "parseArticle", "insertArticle", "Ltencent/im/oidb/cmd0xf30/oidb_cmd0xf30$InsertArticle;", "feedsInsertArticle", "parseFeedsInserArticleFromPb", "rspBody", "Ltencent/im/oidb/cmd0xf30/oidb_cmd0xf30$RspBody;", "parseInsertAction", "action", "Ltencent/im/oidb/cmd0xf30/oidb_cmd0xf30$Action;", "parseInsertArticles", "insertArticleList", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "requestDynamicInsertArticle", "feedsDynamicInsertCallback", "progress", "watchTime", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertRecordAction$ActionType;ZLcom/tencent/biz/pubaccount/readinjoy/feedsdynamicinsert/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;II)V", "saveInsertArticleIfNecessary", "unInitialize", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertModule
  extends ReadInJoyEngineModule
{
  public static final RIJFeedsDynamicInsertModule.Companion a;
  @NotNull
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<String, RIJFeedsInsertArticle>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private final ConcurrentHashMap<Integer, RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedsdynamicinsertRIJFeedsDynamicInsertModule$Companion = new RIJFeedsDynamicInsertModule.Companion(null);
  }
  
  public RIJFeedsDynamicInsertModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private final RIJFeedsInsertArticle a(oidb_cmd0xf30.RspBody paramRspBody)
  {
    RIJFeedsInsertArticle localRIJFeedsInsertArticle = new RIJFeedsInsertArticle();
    if ((paramRspBody.msg_rsp_channel_article.has()) && (paramRspBody.msg_rsp_channel_article.insert_list.has()))
    {
      PBRepeatMessageField localPBRepeatMessageField = paramRspBody.msg_rsp_channel_article.insert_list;
      if (RIJPBFieldUtils.a(localPBRepeatMessageField))
      {
        Intrinsics.checkExpressionValueIsNotNull(localPBRepeatMessageField, "insertArticleList");
        a(localPBRepeatMessageField, localRIJFeedsInsertArticle);
      }
      localRIJFeedsInsertArticle.a(RIJPBFieldUtils.a(paramRspBody.msg_rsp_channel_article.seq_no));
    }
    paramRspBody = localRIJFeedsInsertArticle.a();
    if (paramRspBody != null) {}
    for (paramRspBody = MapsKt.toSortedMap((Map)paramRspBody);; paramRspBody = null)
    {
      localRIJFeedsInsertArticle.a(paramRspBody);
      return localRIJFeedsInsertArticle;
    }
  }
  
  private final void a(int paramInt, String paramString, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    if (paramInt != 1)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
        ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(paramInt), new ConcurrentHashMap());
      }
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if ((localConcurrentHashMap != null) && (!localConcurrentHashMap.containsKey(paramString)))
      {
        localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localConcurrentHashMap != null) {
          paramString = (RIJFeedsInsertArticle)localConcurrentHashMap.put(paramString, paramRIJFeedsInsertArticle);
        }
      }
    }
  }
  
  private final void a(PBRepeatMessageField<oidb_cmd0xf30.InsertArticle> paramPBRepeatMessageField, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
    while (paramPBRepeatMessageField.hasNext()) {
      a((oidb_cmd0xf30.InsertArticle)paramPBRepeatMessageField.next(), paramRIJFeedsInsertArticle);
    }
  }
  
  private final void a(oidb_cmd0xf30.Action paramAction, oidb_cmd0xf30.InsertArticle paramInsertArticle, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    Object localObject = null;
    RIJFeedsInsertAction localRIJFeedsInsertAction = new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.Companion.a(RIJPBFieldUtils.a(paramAction.action_type)), RIJPBFieldUtils.a(paramAction.progress), RIJPBFieldUtils.a(paramAction.priority), RIJPBFieldUtils.a(paramAction.watch_time));
    paramInsertArticle = ReadInJoyMSFHandlerUtils.a(null, paramInsertArticle.rpt_article_list.get(), 0, 0, 0);
    if (paramInsertArticle != null)
    {
      paramAction = paramRIJFeedsInsertArticle.a();
      if ((paramAction == null) || (paramAction.containsKey(localRIJFeedsInsertAction) != true))
      {
        paramAction = paramRIJFeedsInsertArticle.a();
        if (paramAction != null) {
          ((Map)paramAction).put(localRIJFeedsInsertAction, new ArrayList());
        }
      }
      paramAction = paramInsertArticle.iterator();
      while (paramAction.hasNext()) {
        ((ArticleInfo)paramAction.next()).isFeedsDynamicInsert = true;
      }
      paramRIJFeedsInsertArticle = paramRIJFeedsInsertArticle.a();
      paramAction = localObject;
      if (paramRIJFeedsInsertArticle != null) {
        paramAction = (ArrayList)paramRIJFeedsInsertArticle.get(localRIJFeedsInsertAction);
      }
      if (paramAction == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo>");
      }
      paramAction.addAll((Collection)paramInsertArticle);
    }
  }
  
  private final void a(oidb_cmd0xf30.InsertArticle paramInsertArticle, RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    if ((paramInsertArticle != null) && (RIJPBFieldUtils.a(paramInsertArticle.actions)) && (RIJPBFieldUtils.a(paramInsertArticle.rpt_article_list)))
    {
      Iterator localIterator = paramInsertArticle.actions.get().iterator();
      while (localIterator.hasNext())
      {
        oidb_cmd0xf30.Action localAction = (oidb_cmd0xf30.Action)localIterator.next();
        Intrinsics.checkExpressionValueIsNotNull(localAction, "action");
        a(localAction, paramInsertArticle, paramRIJFeedsInsertArticle);
      }
    }
  }
  
  @Nullable
  public final RIJFeedsInsertArticle a(int paramInt, @Nullable String paramString)
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((RIJFeedsInsertArticle)null);
    KotlinUtilKt.a(paramString, this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)), (Function2)new RIJFeedsDynamicInsertModule.getFeedsInsertInfo.1(localObjectRef));
    return (RIJFeedsInsertArticle)localObjectRef.element;
  }
  
  @NotNull
  public final ToServiceMsg a(@Nullable Integer paramInteger, @Nullable String paramString, @NotNull RIJFeedsDynamicInsertRecordAction.ActionType paramActionType, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActionType, "actionType");
    oidb_cmd0xf30.ReqBody localReqBody = new oidb_cmd0xf30.ReqBody();
    if (paramInteger != null) {
      localReqBody.uint32_req_source.set(paramInteger.intValue());
    }
    paramInteger = new oidb_cmd0xf30.ReqRecommendPara();
    paramInteger.bytes_req_rowkey.set(ByteStringMicro.copyFromUtf8(paramString));
    paramInteger.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(paramString));
    paramInteger.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
    paramInteger.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
    paramInteger.uint32_network_type.set(ArticleInfoModuleUtils.a());
    paramInteger.uint32_os_type.set(2);
    paramInteger.action_type.set(paramActionType.toPBInt());
    localReqBody.msg_req_recommend_para.set((MessageMicro)paramInteger);
    paramInteger = ReadInJoyOidbHelper.a("OidbSvc.0xf30", 3888, 0, localReqBody.toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(paramInteger, "ReadInJoyOidbHelper.make…0, reqBody.toByteArray())");
    return paramInteger;
  }
  
  public void a()
  {
    QLog.d("RIJFeedsDynamicInsertModule", 1, "unInitialize");
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    QLog.d("RIJFeedsDynamicInsertModule", 1, "deleteFeedsDynamicInsertInfo, reqSource: " + paramInt + ", rowKey:" + paramString);
    if (paramString == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 != null) {}
    for (localObject1 = (RIJFeedsInsertArticle)((ConcurrentHashMap)localObject1).get(paramString);; localObject1 = null)
    {
      KotlinUtilKt.a(paramString, localObject2, localObject1, (Function3)RIJFeedsDynamicInsertModule.deleteFeedsDynamicInsertInfo.1.INSTANCE);
      return;
    }
  }
  
  public void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    for (String str = paramFromServiceMsg.getServiceCmd();; str = null)
    {
      if (Intrinsics.areEqual(str, "OidbSvc.0xf30"))
      {
        QLog.d("RIJFeedsDynamicInsertModule", 1, "handle0xf30");
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
  }
  
  public final void a(@Nullable Integer paramInteger, @Nullable String paramString, @NotNull RIJFeedsDynamicInsertRecordAction.ActionType paramActionType, boolean paramBoolean, @Nullable RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback paramIFeedsDynamicInsertCallback, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramActionType, "actionType");
    QLog.d("RIJFeedsDynamicInsertModule", 1, "requestDynamicInsertArticle reqSource: " + paramInteger + ", rowKey: " + paramString + ", actionType: " + paramActionType + ", isPreload: " + paramBoolean + ", callback: " + paramIFeedsDynamicInsertCallback);
    Object localObject = (Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }
    if ((((Map)localObject).containsKey(paramInteger)) && (paramString != null))
    {
      localObject = (ConcurrentHashMap)((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).get(paramInteger);
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(paramString) == true))
      {
        QLog.d("RIJFeedsDynamicInsertModule", 1, "hasCache, return");
        if (paramIFeedsDynamicInsertCallback != null)
        {
          paramInteger = (ConcurrentHashMap)((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).get(paramInteger);
          if (paramInteger == null) {
            break label203;
          }
          paramInteger = (RIJFeedsInsertArticle)paramInteger.get(paramString);
          paramIFeedsDynamicInsertCallback.a(paramInteger);
        }
      }
    }
    label203:
    while (paramString == null) {
      for (;;)
      {
        return;
        paramInteger = null;
      }
    }
    paramActionType = a(paramInteger, paramString, paramActionType, paramBoolean);
    paramInt1 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    paramActionType.getAttributes().put("insert_callback", Integer.valueOf(paramInt1));
    paramActionType.getAttributes().put("insert_reqsource", paramInteger);
    paramActionType.getAttributes().put("insert_rowkey", paramString);
    if (paramIFeedsDynamicInsertCallback != null) {
      ((Map)this.b).put(Integer.valueOf(paramInt1), paramIFeedsDynamicInsertCallback);
    }
    a(paramActionType);
  }
  
  public final void a(@Nullable String paramString)
  {
    QLog.d("RIJFeedsDynamicInsertModule", 1, "deleteFeedsDynamicInsertInfo, rowKey:" + paramString);
    if (paramString == null) {
      return;
    }
    Iterator localIterator1 = ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Map)((Map.Entry)localIterator1.next()).getValue()).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Object localObject1 = ((RIJFeedsInsertArticle)((Map.Entry)localIterator2.next()).getValue()).a();
        if (localObject1 != null)
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ArrayList)((Map.Entry)((Iterator)localObject1).next()).getValue();
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator3 = ((ArrayList)localObject2).iterator();
            while (localIterator3.hasNext())
            {
              ArticleInfo localArticleInfo = (ArticleInfo)localIterator3.next();
              if (Intrinsics.areEqual(localArticleInfo.innerUniqueID, paramString)) {
                localArrayList.add(localArticleInfo);
              }
            }
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "articleList");
            localObject2 = (Collection)localObject2;
            if (localObject2 == null) {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            }
            TypeIntrinsics.asMutableCollection(localObject2).removeAll((Collection)localArrayList);
          }
        }
      }
    }
  }
  
  public final void b(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    Object localObject = null;
    oidb_cmd0xf30.RspBody localRspBody = new oidb_cmd0xf30.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    QLog.d("RIJFeedsDynamicInsertModule", 1, "resultCode: " + i);
    Integer localInteger;
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = paramToServiceMsg.getAttribute("insert_callback");
      paramObject = paramFromServiceMsg;
      if (!(paramFromServiceMsg instanceof Integer)) {
        paramObject = null;
      }
      localInteger = (Integer)paramObject;
      if (paramToServiceMsg == null) {
        break label297;
      }
      paramFromServiceMsg = paramToServiceMsg.getAttribute("insert_reqsource");
      label93:
      paramObject = paramFromServiceMsg;
      if (!(paramFromServiceMsg instanceof Integer)) {
        paramObject = null;
      }
      paramFromServiceMsg = (Integer)paramObject;
      if (paramToServiceMsg == null) {
        break label302;
      }
      paramToServiceMsg = paramToServiceMsg.getAttribute("insert_rowkey");
      label121:
      if ((paramToServiceMsg instanceof String)) {
        break label320;
      }
      paramToServiceMsg = localObject;
    }
    label297:
    label302:
    label320:
    for (;;)
    {
      paramToServiceMsg = (String)paramToServiceMsg;
      if (i == 0)
      {
        paramObject = a(localRspBody);
        QLog.d("RIJFeedsDynamicInsertModule", 1, "reqSource: " + paramFromServiceMsg + ", rowKey: " + paramToServiceMsg + ", feedsInserArticle parse result: " + paramObject);
        KotlinUtilKt.a(paramFromServiceMsg, paramToServiceMsg, paramObject, (Function3)new RIJFeedsDynamicInsertModule.handle0xf30.1(this));
        paramToServiceMsg = (RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback)((Map)this.b).get(localInteger);
        if (paramToServiceMsg != null)
        {
          QLog.d("RIJFeedsDynamicInsertModule", 1, "has callback: " + paramToServiceMsg);
          paramToServiceMsg.a(paramObject);
        }
      }
      paramToServiceMsg = (Map)this.b;
      if (paramToServiceMsg == null)
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        paramFromServiceMsg = null;
        break;
        paramFromServiceMsg = null;
        break label93;
        paramToServiceMsg = null;
        break label121;
      }
      TypeIntrinsics.asMutableMap(paramToServiceMsg).remove(localInteger);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertModule
 * JD-Core Version:    0.7.0.1
 */