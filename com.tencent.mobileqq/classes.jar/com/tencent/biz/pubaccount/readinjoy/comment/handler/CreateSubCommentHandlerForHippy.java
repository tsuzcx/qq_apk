package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import androidx.annotation.VisibleForTesting;
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
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.ReqBody;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspBody;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.RspResult;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.SubCommentCreateReq;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.SubCommentCreateRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/CreateSubCommentHandlerForHippy;", "", "createCommentData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "extraParam", "", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;Ljava/lang/String;)V", "onFailedCallback", "Lkotlin/Function2;", "", "", "getOnFailedCallback", "()Lkotlin/jvm/functions/Function2;", "setOnFailedCallback", "(Lkotlin/jvm/functions/Function2;)V", "onSuccessCallback", "getOnSuccessCallback", "setOnSuccessCallback", "generateRequestBody", "Ltencent/im/oidb/oidb_0xefd/oidb_0xefd$ReqBody;", "onCommentOperationFailed", "errorCode", "errorMsg", "onSubCommentCreateSuccess", "comment", "commentId", "parseSubCommentCreateData", "data", "", "send0xefdRequest", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CreateSubCommentHandlerForHippy
{
  private final SubCommentCreateData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData;
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private Function2<? super String, ? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction2;
  @Nullable
  private Function2<? super Integer, ? super String, Unit> b;
  
  public CreateSubCommentHandlerForHippy(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData = paramSubCommentCreateData;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @VisibleForTesting
  @NotNull
  public final oidb_0xefd.ReqBody a()
  {
    oidb_0xefd.SubCommentCreateReq localSubCommentCreateReq = new oidb_0xefd.SubCommentCreateReq();
    localSubCommentCreateReq.rowkey.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.c());
    localSubCommentCreateReq.article_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.d());
    localSubCommentCreateReq.author_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.a());
    localSubCommentCreateReq.business_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.e());
    localSubCommentCreateReq.content_src.set(ReadInJoyCommentHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.d()));
    localSubCommentCreateReq.src.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.c());
    localSubCommentCreateReq.scene.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.b());
    localSubCommentCreateReq.content.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.b());
    localSubCommentCreateReq.first_comment_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.a());
    localSubCommentCreateReq.replied_sub_author_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.b());
    localSubCommentCreateReq.replied_sub_comment_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.f());
    localSubCommentCreateReq.detect_dirty_word.set(1);
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.b();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseCommentData.CommentLinkData)((Iterator)localObject1).next();
        localSubCommentCreateReq.link_data.add((MessageMicro)Base0xefdHandler.a.a((BaseCommentData.CommentLinkData)localObject2));
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSubCommentCreateData.a();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BaseCommentData.CommentRptData)((Iterator)localObject1).next();
        localSubCommentCreateReq.rpt_data.add((MessageMicro)Base0xefdHandler.a.a((BaseCommentData.CommentRptData)localObject2));
      }
    }
    localSubCommentCreateReq.extra_param.set(this.jdField_a_of_type_JavaLangString);
    localObject1 = new oidb_0xefd.ReqBody();
    ((oidb_0xefd.ReqBody)localObject1).sub_comment_create_req.set((MessageMicro)localSubCommentCreateReq);
    return localObject1;
  }
  
  public final void a()
  {
    oidb_0xefd.ReqBody localReqBody = a();
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new CreateSubCommentHandlerForHippy.send0xefdRequest.1(this), localReqBody.toByteArray(), "OidbSvc.0xefd", 3837, 1);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    Function2 localFunction2 = this.b;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(Integer.valueOf(paramInt), paramString);
    }
  }
  
  @VisibleForTesting
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "comment");
    Function2 localFunction2 = this.jdField_a_of_type_KotlinJvmFunctionsFunction2;
    if (localFunction2 != null) {
      paramString = (Unit)localFunction2.invoke(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public final void a(@Nullable Function2<? super String, ? super Integer, Unit> paramFunction2)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction2 = paramFunction2;
  }
  
  @VisibleForTesting
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    int k = 1;
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Object localObject = new oidb_0xefd.RspBody();
    ((oidb_0xefd.RspBody)localObject).mergeFrom(paramArrayOfByte);
    int i = ((oidb_0xefd.RspBody)localObject).retcode.get();
    paramArrayOfByte = (oidb_0xefd.RspResult)((oidb_0xefd.RspBody)localObject).result.get();
    if ((i == 0) && (paramArrayOfByte != null))
    {
      localObject = paramArrayOfByte.sub_comment_create_rsp.str_comment.get();
      i = paramArrayOfByte.sub_comment_create_rsp.sub_comment_id.get();
      int j;
      if (paramArrayOfByte.sub_comment_create_rsp.link_comment_over_times.get() == 1)
      {
        j = 1;
        if (paramArrayOfByte.sub_comment_create_rsp.dirty_word_show_toast.get() != 1) {
          break label138;
        }
      }
      for (;;)
      {
        if ((j != 0) || (k != 0)) {
          break label144;
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject, "comment");
        a((String)localObject, i);
        return;
        j = 0;
        break;
        label138:
        k = 0;
      }
      label144:
      i = -1;
      if (j != 0) {
        i = -4096;
      }
      if (k != 0) {
        i = -4097;
      }
      a(i, "");
      return;
    }
    a(i, "create sub comment failed");
  }
  
  public final void b(@Nullable Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    this.b = paramFunction2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateSubCommentHandlerForHippy
 * JD-Core Version:    0.7.0.1
 */