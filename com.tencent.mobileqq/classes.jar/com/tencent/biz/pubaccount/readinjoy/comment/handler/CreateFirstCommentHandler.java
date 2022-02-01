package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentRptData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.pb.MessageMicro;
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
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateFirstCommentHandler;", "", "data", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "onFailedCallback", "Lkotlin/Function3;", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$FirstCommentCreateRsp;", "", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function3;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function3;)V", "onSuccessCallback", "Lkotlin/Function2;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function2;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function2;)V", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "getResponse", "", "onCommentOperationFailed", "response", "errorCode", "errorMsg", "onFirstCommentCreateSuccess", "commentId", "parseFirstCommentCreateData", "send0xd1eRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CreateFirstCommentHandler
{
  @NotNull
  private final FirstCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData;
  @Nullable
  private Function2<? super oidb_0xd1e.FirstCommentCreateRsp, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function3<? super oidb_0xd1e.FirstCommentCreateRsp, ? super Integer, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction3;
  
  public CreateFirstCommentHandler(@NotNull FirstCommentCreateData paramFirstCommentCreateData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData = paramFirstCommentCreateData;
  }
  
  private final oidb_0xd1e.FirstCommentCreateRsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new oidb_0xd1e.FirstCommentCreateRsp();
    }
    oidb_0xd1e.RspBody localRspBody = new oidb_0xd1e.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = localRspBody.first_comment_create_rsp;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "commentRsp.first_comment_create_rsp");
    return paramArrayOfByte;
  }
  
  private final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.FirstCommentCreateReq localFirstCommentCreateReq = new oidb_0xd1e.FirstCommentCreateReq();
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentCreateData;
    localFirstCommentCreateReq.rowkey.set(((FirstCommentCreateData)localObject1).c());
    localFirstCommentCreateReq.article_id.set(((FirstCommentCreateData)localObject1).d());
    localFirstCommentCreateReq.author_id.set(((FirstCommentCreateData)localObject1).a());
    localFirstCommentCreateReq.business_info.set(((FirstCommentCreateData)localObject1).e());
    localFirstCommentCreateReq.content_src.set(ReadInJoyCommentHelper.a(((FirstCommentCreateData)localObject1).d()));
    localFirstCommentCreateReq.src.set(((FirstCommentCreateData)localObject1).c());
    localFirstCommentCreateReq.scene.set(((FirstCommentCreateData)localObject1).b());
    localFirstCommentCreateReq.content.set(((FirstCommentCreateData)localObject1).a());
    Object localObject2 = ((FirstCommentCreateData)localObject1).a();
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)((Iterator)localObject2).next();
        localFirstCommentCreateReq.rpt_data.add((MessageMicro)Base0xd1eHandler.a.a(localCommentRptData));
      }
    }
    localFirstCommentCreateReq.detect_dirty_word.set(1);
    localObject1 = ((FirstCommentCreateData)localObject1).b();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseCommentData.CommentLinkData)((Iterator)localObject1).next();
        localFirstCommentCreateReq.link_data.add((MessageMicro)Base0xd1eHandler.a.a((BaseCommentData.CommentLinkData)localObject2));
      }
    }
    localReqBody.first_comment_create_req.set((MessageMicro)localFirstCommentCreateReq);
    return localReqBody;
  }
  
  private final void a(oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp, String paramString)
  {
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramFirstCommentCreateRsp = (Unit)localFunction2.invoke(paramFirstCommentCreateRsp, paramString);
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    int i = 1;
    paramArrayOfByte = a(paramArrayOfByte);
    int j;
    int k;
    label35:
    String str;
    if (paramArrayOfByte.link_comment_over_times.get() == 1)
    {
      j = 1;
      if (paramArrayOfByte.dirty_word_show_toast.get() != 1) {
        break label91;
      }
      k = 1;
      str = paramArrayOfByte.comment_id.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "commentId");
      if (((CharSequence)str).length() <= 0) {
        break label97;
      }
    }
    for (;;)
    {
      if ((i == 0) || (j != 0) || (k != 0)) {
        break label102;
      }
      a(paramArrayOfByte, str);
      return;
      j = 0;
      break;
      label91:
      k = 0;
      break label35;
      label97:
      i = 0;
    }
    label102:
    i = -1;
    if (j != 0) {
      i = -4096;
    }
    if (k != 0) {
      i = -4097;
    }
    a(paramArrayOfByte, i, "CommentId is empty.");
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new CreateFirstCommentHandler.send0xd1eRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 4);
  }
  
  public final void a(@Nullable Function2<? super oidb_0xd1e.FirstCommentCreateRsp, ? super String, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  public final void a(@Nullable Function3<? super oidb_0xd1e.FirstCommentCreateRsp, ? super Integer, ? super String, Unit> paramFunction3)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction3 = paramFunction3;
  }
  
  public final void a(@NotNull oidb_0xd1e.FirstCommentCreateRsp paramFirstCommentCreateRsp, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateRsp, "response");
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function3 localFunction3 = this.jdField_a_of_type_KotlinJvmFunctionsFunction3;
    if (localFunction3 != null) {
      paramFirstCommentCreateRsp = (Unit)localFunction3.invoke(paramFirstCommentCreateRsp, Integer.valueOf(paramInt), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateFirstCommentHandler
 * JD-Core Version:    0.7.0.1
 */