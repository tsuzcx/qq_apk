package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.BlockUserCommentData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.BlockUserReq;
import tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.BlockUserRsp;
import tencent.im.oidb.cmd0xf35.oidb_cmd0xf35.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/BlockUserCommentHandler;", "", "data", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/BlockUserCommentData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/BlockUserCommentData;)V", "getData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/BlockUserCommentData;", "onFailedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isOverTimes", "", "errorMsg", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "Lkotlin/Function1;", "getOnSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "generateRequestBody", "Ltencent/im/oidb/cmd0xf35/oidb_cmd0xf35$ReqBody;", "handleBlockUserCommentResult", "", "onCommentOperationFailed", "errorCode", "", "onCommentOperationSuccess", "send0xf35Request", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BlockUserCommentHandler
{
  public static final BlockUserCommentHandler.Companion a;
  @NotNull
  private final BlockUserCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanBlockUserCommentData;
  @Nullable
  private Function1<? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function2<? super Boolean, ? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBlockUserCommentHandler$Companion = new BlockUserCommentHandler.Companion(null);
  }
  
  public BlockUserCommentHandler(@NotNull BlockUserCommentData paramBlockUserCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanBlockUserCommentData = paramBlockUserCommentData;
  }
  
  @NotNull
  public final oidb_cmd0xf35.ReqBody a()
  {
    oidb_cmd0xf35.ReqBody localReqBody = new oidb_cmd0xf35.ReqBody();
    oidb_cmd0xf35.BlockUserReq localBlockUserReq = new oidb_cmd0xf35.BlockUserReq();
    BlockUserCommentData localBlockUserCommentData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanBlockUserCommentData;
    localBlockUserReq.first_comment_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanBlockUserCommentData.a());
    localBlockUserReq.sub_comment_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanBlockUserCommentData.b());
    localBlockUserReq.comment_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanBlockUserCommentData.a());
    localBlockUserReq.comment_source.set(0);
    localReqBody.block_user_req.set((MessageMicro)localBlockUserReq);
    return localReqBody;
  }
  
  public final void a()
  {
    oidb_cmd0xf35.ReqBody localReqBody = a();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new BlockUserCommentHandler.send0xf35Request.1(this), localReqBody.toByteArray(), "OidbSvc.0xf35", 3893, 1);
  }
  
  public final void a(int paramInt, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    QLog.d("BlockUserCommentHandler", 1, "onCommentOperationFailed | errCode " + paramInt + " ; errMsg " + paramString);
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(Boolean.valueOf(paramBoolean), paramString);
    }
  }
  
  public final void a(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@Nullable Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Object localObject = new oidb_cmd0xf35.BlockUserRsp();
    ((oidb_cmd0xf35.BlockUserRsp)localObject).mergeFrom(paramArrayOfByte);
    int i = ((oidb_cmd0xf35.BlockUserRsp)localObject).over_times.get();
    int j = ((oidb_cmd0xf35.BlockUserRsp)localObject).ret.get();
    localObject = ((oidb_cmd0xf35.BlockUserRsp)localObject).err_message.get();
    if (i > 0)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "errorMsg");
      a(j, (String)localObject, true);
      QLog.d("BlockUserCommentHandler", 1, "handleBlockUserCommentResult | errorMsg " + (String)localObject);
      return;
    }
    b(paramArrayOfByte);
  }
  
  public final void b(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    paramArrayOfByte = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    if (paramArrayOfByte != null) {
      paramArrayOfByte = (Unit)paramArrayOfByte.invoke("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.BlockUserCommentHandler
 * JD-Core Version:    0.7.0.1
 */