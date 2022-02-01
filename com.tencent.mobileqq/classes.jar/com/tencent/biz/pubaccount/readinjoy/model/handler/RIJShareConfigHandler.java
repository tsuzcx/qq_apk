package com.tencent.biz.pubaccount.readinjoy.model.handler;

import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf34.oidb_cmd0xf34.ReqBody;
import tencent.im.oidb.cmd0xf34.oidb_cmd0xf34.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/handler/RIJShareConfigHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/model/handler/RIJBaseArticleInfoHandler;", "articleInfoModule", "Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModule;", "mMainThreadHandler", "Landroid/os/Handler;", "mApp", "Lcom/tencent/common/app/AppInterface;", "mEntityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "mMSFService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "(Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModule;Landroid/os/Handler;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Ljava/util/concurrent/ExecutorService;)V", "getRespBody", "Ltencent/im/oidb/cmd0xf34/oidb_cmd0xf34$RspBody;", "handle0xf34GetShareConfig", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "refreshShareCount", "article", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "request0xf34ConfigShare", "uin", "", "opCop", "", "request0xf34ConfigShareForVideo", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJShareConfigHandler
  extends RIJBaseArticleInfoHandler
{
  public static final RIJShareConfigHandler.Companion a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelHandlerRIJShareConfigHandler$Companion = new RIJShareConfigHandler.Companion(null);
  }
  
  public RIJShareConfigHandler(@Nullable ArticleInfoModule paramArticleInfoModule, @Nullable Handler paramHandler, @Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  @VisibleForTesting
  @NotNull
  public final oidb_cmd0xf34.RspBody a()
  {
    return new oidb_cmd0xf34.RspBody();
  }
  
  public final void a(long paramLong, @NotNull VideoInfo paramVideoInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Object localObject = new oidb_cmd0xf34.ReqBody();
    ((oidb_cmd0xf34.ReqBody)localObject).bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramVideoInfo.g));
    ((oidb_cmd0xf34.ReqBody)localObject).uint64_uin.set(paramLong);
    ((oidb_cmd0xf34.ReqBody)localObject).uint64_op.set(paramInt);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xf34", 3892, 0, ((oidb_cmd0xf34.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("article", paramVideoInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b((ToServiceMsg)localObject);
  }
  
  public final void a(long paramLong, @NotNull BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "article");
    Object localObject = new oidb_cmd0xf34.ReqBody();
    ((oidb_cmd0xf34.ReqBody)localObject).bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramBaseArticleInfo.innerUniqueID));
    ((oidb_cmd0xf34.ReqBody)localObject).uint64_uin.set(paramLong);
    ((oidb_cmd0xf34.ReqBody)localObject).uint64_op.set(paramInt);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xf34", 3892, 0, ((oidb_cmd0xf34.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("article", paramBaseArticleInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.b((ToServiceMsg)localObject);
  }
  
  @VisibleForTesting
  public final void a(@NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "article");
    ThreadManager.getUIHandler().post((Runnable)new RIJShareConfigHandler.refreshShareCount.1(paramBaseArticleInfo));
  }
  
  public final void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @NotNull Object paramObject)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "res");
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    oidb_cmd0xf34.RspBody localRspBody = a();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyShareConfigUtil", 1, "handle0xf34GetShareConfig | retCode " + j);
    }
    paramToServiceMsg = paramToServiceMsg.getAttribute("article");
    int k;
    int m;
    if (j == 0)
    {
      if (!localRspBody.uint32_share_status.has()) {
        break label242;
      }
      k = localRspBody.uint32_share_status.get();
      if (localRspBody.uint64_num.has()) {
        i = (int)localRspBody.uint64_num.get();
      }
      if (!(paramToServiceMsg instanceof BaseArticleInfo)) {
        break label248;
      }
      j = i;
      if (i != 0)
      {
        ((BaseArticleInfo)paramToServiceMsg).mShareCount = i;
        a((BaseArticleInfo)paramToServiceMsg);
        j = i + 1;
      }
      ((BaseArticleInfo)paramToServiceMsg).shareCalcuPermission = k;
      m = j;
      if (k == 1)
      {
        ReadInJoyHelper.a("is_share_strike", Boolean.valueOf(true));
        m = j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyShareConfigUtil", 2, "handle0xf34GetShareConfig | shareStatus " + k + " | shareCount " + m);
      }
      return;
      label242:
      k = 0;
      break;
      label248:
      m = i;
      if ((paramToServiceMsg instanceof VideoInfo))
      {
        ReadInJoyLogicEngineEventDispatcher.a().c(((VideoInfo)paramToServiceMsg).g, k);
        m = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJShareConfigHandler
 * JD-Core Version:    0.7.0.1
 */