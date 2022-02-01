package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.AuthorCommentDeleteData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.AuthorCommentDeleteReq;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.AuthorCommentDeleteRsp;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/AuthorDeleteCommentHandler;", "", "authorDeleteCommentData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/AuthorCommentDeleteData;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/AuthorCommentDeleteData;)V", "getAuthorDeleteCommentData", "()Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/AuthorCommentDeleteData;", "onFailedCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isOverTimes", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function1;)V", "onSuccessCallback", "", "getOnSuccessCallback", "setOnSuccessCallback", "serviceType", "", "getServiceType", "()I", "generateRequestBody", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$ReqBody;", "handleAuthorCommentDeleteResult", "data", "", "onCommentOperationFailed", "errorCode", "errorMsg", "onCommentOperationSuccess", "send0xd1eRequest", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AuthorDeleteCommentHandler
{
  public static final AuthorDeleteCommentHandler.Companion a;
  @NotNull
  private final AuthorCommentDeleteData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanAuthorCommentDeleteData;
  @Nullable
  private Function1<? super String, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  @Nullable
  private Function1<? super Boolean, Unit> b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerAuthorDeleteCommentHandler$Companion = new AuthorDeleteCommentHandler.Companion(null);
  }
  
  public AuthorDeleteCommentHandler(@NotNull AuthorCommentDeleteData paramAuthorCommentDeleteData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanAuthorCommentDeleteData = paramAuthorCommentDeleteData;
  }
  
  private final void b(byte[] paramArrayOfByte)
  {
    oidb_0xd1e.AuthorCommentDeleteRsp localAuthorCommentDeleteRsp = new oidb_0xd1e.AuthorCommentDeleteRsp();
    localAuthorCommentDeleteRsp.mergeFrom(paramArrayOfByte);
    int i = localAuthorCommentDeleteRsp.over_times.get();
    if (i > 0)
    {
      paramArrayOfByte = this.b;
      if (paramArrayOfByte != null) {
        paramArrayOfByte = (Unit)paramArrayOfByte.invoke(Boolean.valueOf(true));
      }
      QLog.d("AuthorDeleteCommentHandler", 1, "handleAuthorCommentDeleteResult | delteTimes " + i);
    }
    do
    {
      return;
      paramArrayOfByte = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
    } while (paramArrayOfByte == null);
    paramArrayOfByte = (Unit)paramArrayOfByte.invoke("");
  }
  
  @NotNull
  public final oidb_0xd1e.ReqBody a()
  {
    oidb_0xd1e.ReqBody localReqBody = new oidb_0xd1e.ReqBody();
    oidb_0xd1e.AuthorCommentDeleteReq localAuthorCommentDeleteReq = new oidb_0xd1e.AuthorCommentDeleteReq();
    AuthorCommentDeleteData localAuthorCommentDeleteData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanAuthorCommentDeleteData;
    localAuthorCommentDeleteReq.article_id.set(localAuthorCommentDeleteData.a().d());
    localAuthorCommentDeleteReq.comment_type.set(localAuthorCommentDeleteData.a());
    localAuthorCommentDeleteReq.content_src.set(ReadInJoyCommentHelper.a(localAuthorCommentDeleteData.a().d()));
    localAuthorCommentDeleteReq.first_comment_id.set(localAuthorCommentDeleteData.a());
    localAuthorCommentDeleteReq.sub_comment_id.set(localAuthorCommentDeleteData.b());
    localAuthorCommentDeleteReq.src.set(localAuthorCommentDeleteData.a().c());
    localAuthorCommentDeleteReq.business_info.set(localAuthorCommentDeleteData.a().e());
    localReqBody.author_comment_delete_req.set((MessageMicro)localAuthorCommentDeleteReq);
    return localReqBody;
  }
  
  public final void a()
  {
    oidb_0xd1e.ReqBody localReqBody = a();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new AuthorDeleteCommentHandler.send0xd1eRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xd1e", 3358, 9);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    QLog.d("AuthorDeleteCommentHandler", 1, "onCommentOperationFailed | errCode " + paramInt + " ; errMsg " + paramString);
    paramString = this.b;
    if (paramString != null) {
      paramString = (Unit)paramString.invoke(Boolean.valueOf(false));
    }
  }
  
  public final void a(@Nullable Function1<? super String, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    b(paramArrayOfByte);
  }
  
  public final void b(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.b = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.AuthorDeleteCommentHandler
 * JD-Core Version:    0.7.0.1
 */