package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentRptData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateSubCommentHandler;", "", "data", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "onFailedCallback", "Lkotlin/Function3;", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$SubCommentCreateRsp;", "", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function3;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function3;)V", "onSuccessCallback", "Lkotlin/Function2;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function2;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function2;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "getResponse", "", "onCommentOperationFailed", "response", "errorCode", "errorMsg", "onSubCommentCreateSuccess", "subCommentId", "parseSubCommentCreateData", "send0xd1eRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CreateSubCommentHandler
{
  @NotNull
  private final SubCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData;
  @Nullable
  private Function2<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function3<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction3;
  
  public CreateSubCommentHandler(@NotNull SubCommentCreateData paramSubCommentCreateData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData = paramSubCommentCreateData;
  }
  
  private final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.SubCommentCreateReq localSubCommentCreateReq = new oidb_0xd1e.SubCommentCreateReq();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData;
    localSubCommentCreateReq.rowkey.set(((SubCommentCreateData)localObject1).c());
    localSubCommentCreateReq.article_id.set(((SubCommentCreateData)localObject1).d());
    localSubCommentCreateReq.author_id.set(((SubCommentCreateData)localObject1).a());
    localSubCommentCreateReq.business_info.set(((SubCommentCreateData)localObject1).e());
    localSubCommentCreateReq.content_src.set(ReadInJoyCommentHelper.a(((SubCommentCreateData)localObject1).d()));
    localSubCommentCreateReq.src.set(((SubCommentCreateData)localObject1).c());
    localSubCommentCreateReq.scene.set(((SubCommentCreateData)localObject1).b());
    localSubCommentCreateReq.content.set(((SubCommentCreateData)localObject1).b());
    localSubCommentCreateReq.first_comment_id.set(((SubCommentCreateData)localObject1).a());
    localSubCommentCreateReq.replied_sub_author_id.set(((SubCommentCreateData)localObject1).b());
    localSubCommentCreateReq.replied_sub_comment_id.set(((SubCommentCreateData)localObject1).f());
    localSubCommentCreateReq.detect_dirty_word.set(1);
    Object localObject2 = ((SubCommentCreateData)localObject1).a();
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)((Iterator)localObject2).next();
        localSubCommentCreateReq.rpt_data.add((MessageMicro)Base0xd1eHandler.a.a(localCommentRptData));
      }
    }
    localObject1 = ((SubCommentCreateData)localObject1).b();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseCommentData.CommentLinkData)((Iterator)localObject1).next();
        localSubCommentCreateReq.link_data.add((MessageMicro)Base0xd1eHandler.a.a((BaseCommentData.CommentLinkData)localObject2));
      }
    }
    localReqBody.sub_comment_create_req.set((MessageMicro)localSubCommentCreateReq);
    return localReqBody;
  }
  
  private final oidb_0xd1e.SubCommentCreateRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new oidb_0xd1e.SubCommentCreateRsp();
    }
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = localRspBody.sub_comment_create_rsp;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "commentRsp.sub_comment_create_rsp");
    return paramArrayOfByte;
  }
  
  private final void a(oidb_0xd1e.SubCommentCreateRsp paramSubCommentCreateRsp, int paramInt)
  {
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramSubCommentCreateRsp = (Unit)localFunction2.invoke(paramSubCommentCreateRsp, Integer.valueOf(paramInt));
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    int j = 0;
    paramArrayOfByte = a(paramArrayOfByte);
    int k = paramArrayOfByte.sub_comment_id.get();
    if (paramArrayOfByte.link_comment_over_times.get() == 1) {}
    for (int i = 1;; i = 0)
    {
      if (paramArrayOfByte.dirty_word_show_toast.get() == 1) {
        j = 1;
      }
      if ((i != 0) || (j != 0)) {
        break;
      }
      a(paramArrayOfByte, k);
      return;
    }
    if (i != 0) {}
    for (i = -4096;; i = -1)
    {
      if (j != 0) {
        i = -4097;
      }
      a(paramArrayOfByte, i, "");
      return;
    }
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new CreateSubCommentHandler.send0xd1eRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 1);
  }
  
  public final void a(@Nullable Function2<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  public final void a(@Nullable Function3<? super oidb_0xd1e.SubCommentCreateRsp, ? super Integer, ? super String, Unit> paramFunction3)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction3 = paramFunction3;
  }
  
  public final void a(@NotNull oidb_0xd1e.SubCommentCreateRsp paramSubCommentCreateRsp, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function3 localFunction3 = this.jdField_a_of_type_KotlinJvmFunctionsFunction3;
    if (localFunction3 != null) {
      paramSubCommentCreateRsp = (Unit)localFunction3.invoke(paramSubCommentCreateRsp, Integer.valueOf(paramInt), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateSubCommentHandler
 * JD-Core Version:    0.7.0.1
 */