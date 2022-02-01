package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import android.content.Context;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.AuthorDeleteCommentHandler;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.BlockUserCommentHandler;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateFirstCommentHandler;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateFirstCommentHandlerForHippy;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateSubCommentHandler;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.CreateSubCommentHandlerForHippy;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.FirstCommentSinkHandler;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.FirstCommentStickyHandler;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.AuthorCommentDeleteData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.BlockUserCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentStickyData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper;", "", "()V", "BUNDLE_KEY_CREATE_COMMENT_DATA", "", "BUNDLE_KEY_JS_OBJ", "TAG", "seqFactory", "Ljava/util/concurrent/atomic/AtomicLong;", "authorDeleteComment", "", "contentSrc", "", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "feedsType", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentObserver;", "blockUserComment", "checkErrorCode", "errorCode", "createFirstComment", "", "requestData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "isFeeds", "", "needBiuAfterComment", "createFirstCommentForHippy", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "extraParam", "createSubComment", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "createSubCommentForHippy", "doCreateCommentReport", "consumeTime", "sendIsCopyMessageTo0xdc8", "commentContent", "rowKey", "parentCommentId", "subCommentId", "commentId", "sinkComment", "commentSinkData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentSinkData;", "updateCommentStickyStatus", "commentStickyData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentStickyData;", "RIJCreateCommentForHippyObserver", "RIJCreateCommentObserver", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkHelper
{
  public static final RIJCommentNetworkHelper a;
  private static final AtomicLong a;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHelperRIJCommentNetworkHelper = new RIJCommentNetworkHelper();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    if (paramInt == -4096)
    {
      QQToast localQQToast = QQToast.a((Context)BaseApplicationImpl.sApplication, (CharSequence)HardCodeUtil.a(2131718145), 1);
      Intrinsics.checkExpressionValueIsNotNull(localQQToast, "QQToast.makeText(\n      …     QQToast.LENGTH_LONG)");
      localQQToast.b(1);
      localQQToast.a(QQToast.a(1));
      localQQToast.a();
    }
  }
  
  private final void a(int paramInt, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("retCode", paramInt);
    localJSONObject.put("os", 1);
    localJSONObject.put("consume_time", paramLong);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A35", "0X8009A35", 0, 0, "", "", "", localJSONObject.toString(), false);
    ReadinjoyReportUtils.a(paramInt, 7, paramLong, null);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (ReadInJoyCommentUtils.a((Context)BaseApplicationImpl.getContext(), paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJCommentNetworkHelper", 2, "commentSink commentContent: " + paramString1 + ", rowKey: " + paramString2 + ", parentCommentId: " + paramString3 + ", subCommentId: " + paramString4 + ", commentId: " + paramString5);
      }
      paramString1 = RIJQQAppInterfaceUtil.a();
      if (paramString1 != null) {}
      for (paramString1 = paramString1.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER); paramString1 == null; paramString1 = null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager");
      }
      paramString1 = ((ReadInJoyLogicManager)paramString1).a();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "logicManager.readInJoyLogicEngine");
      paramString1 = paramString1.a();
      if (paramString1 != null) {
        paramString1.a(paramString2, paramString3, paramString4, paramString5);
      }
    }
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "firstCommentCreateData: " + paramFirstCommentCreateData);
    }
    CreateFirstCommentHandler localCreateFirstCommentHandler = new CreateFirstCommentHandler(paramFirstCommentCreateData);
    localCreateFirstCommentHandler.a((Function2)new RIJCommentNetworkHelper.createFirstComment.1(paramBoolean2, paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, paramFirstCommentCreateData, l2));
    localCreateFirstCommentHandler.a((Function3)new RIJCommentNetworkHelper.createFirstComment.2(paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, l2));
    localCreateFirstCommentHandler.a();
    return l1;
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "subCommentCreateData: " + paramSubCommentCreateData);
    }
    CreateSubCommentHandler localCreateSubCommentHandler = new CreateSubCommentHandler(paramSubCommentCreateData);
    localCreateSubCommentHandler.a((Function2)new RIJCommentNetworkHelper.createSubComment.1(paramBoolean2, paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, paramSubCommentCreateData, l2));
    localCreateSubCommentHandler.a((Function3)new RIJCommentNetworkHelper.createSubComment.2(paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, l2));
    localCreateSubCommentHandler.a();
    return l1;
  }
  
  public final void a(int paramInt1, @NotNull CommentViewItem paramCommentViewItem, int paramInt2, @NotNull ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentObserver, "callback");
    BaseCommentData localBaseCommentData = paramCommentViewItem.a;
    SimpleCommentData localSimpleCommentData;
    Object localObject;
    String str;
    if (localBaseCommentData != null)
    {
      localSimpleCommentData = new SimpleCommentData(paramInt1, "");
      localObject = localBaseCommentData.rowKey;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "commentData.rowKey");
      localSimpleCommentData.c((String)localObject);
      localObject = "";
      if (localBaseCommentData.getCommentLevel() != 1) {
        break label159;
      }
      str = localBaseCommentData.commentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "commentData.commentId");
    }
    for (;;)
    {
      localObject = new AuthorDeleteCommentHandler(new AuthorCommentDeleteData(localSimpleCommentData, localBaseCommentData.getCommentLevel(), str, (String)localObject));
      ((AuthorDeleteCommentHandler)localObject).a((Function1)new RIJCommentNetworkHelper.authorDeleteComment.1(paramReadInJoyCommentObserver, paramCommentViewItem, paramInt2));
      ((AuthorDeleteCommentHandler)localObject).b((Function1)new RIJCommentNetworkHelper.authorDeleteComment.2(paramReadInJoyCommentObserver, paramCommentViewItem, paramInt2));
      ((AuthorDeleteCommentHandler)localObject).a();
      return;
      label159:
      if (localBaseCommentData == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData");
      }
      str = ((SubCommentData)localBaseCommentData).parentCommentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "(commentData as SubCommentData).parentCommentId");
      localObject = localBaseCommentData.commentId;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "commentData.commentId");
    }
  }
  
  public final void a(@NotNull CommentViewItem paramCommentViewItem, @NotNull ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    int i = 1;
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentObserver, "callback");
    Object localObject = paramCommentViewItem.a;
    String str;
    if (localObject != null)
    {
      if (((BaseCommentData)localObject).getCommentLevel() != 1) {
        break label116;
      }
      str = ((BaseCommentData)localObject).commentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "commentData.commentId");
      localObject = "";
    }
    for (;;)
    {
      localObject = new BlockUserCommentHandler(new BlockUserCommentData(str, (String)localObject, i));
      ((BlockUserCommentHandler)localObject).a((Function1)new RIJCommentNetworkHelper.blockUserComment.1(paramReadInJoyCommentObserver, paramCommentViewItem));
      ((BlockUserCommentHandler)localObject).a((Function2)new RIJCommentNetworkHelper.blockUserComment.2(paramReadInJoyCommentObserver, paramCommentViewItem));
      ((BlockUserCommentHandler)localObject).a();
      return;
      label116:
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData");
      }
      str = ((SubCommentData)localObject).parentCommentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "(commentData as SubCommentData).parentCommentId");
      localObject = ((BaseCommentData)localObject).commentId;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "commentData.commentId");
      i = 2;
    }
  }
  
  public final void a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "firstCommentCreateData: " + paramFirstCommentCreateData + ' ' + paramString);
    }
    paramString = new CreateFirstCommentHandlerForHippy(paramFirstCommentCreateData, paramString);
    paramString.a((Function2)new RIJCommentNetworkHelper.createFirstCommentForHippy.1(paramBoolean, paramRIJCreateCommentForHippyObserver, paramFirstCommentCreateData, l));
    paramString.b((Function2)new RIJCommentNetworkHelper.createFirstCommentForHippy.2(paramRIJCreateCommentForHippyObserver, l));
    paramString.a();
  }
  
  public final void a(@NotNull FirstCommentSinkData paramFirstCommentSinkData, @NotNull ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentSinkData, "commentSinkData");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentObserver, "callback");
    FirstCommentSinkHandler localFirstCommentSinkHandler = new FirstCommentSinkHandler(paramFirstCommentSinkData);
    localFirstCommentSinkHandler.a((Function1)new RIJCommentNetworkHelper.sinkComment.1(paramReadInJoyCommentObserver, paramFirstCommentSinkData));
    localFirstCommentSinkHandler.a((Function0)new RIJCommentNetworkHelper.sinkComment.2(paramReadInJoyCommentObserver, paramFirstCommentSinkData));
    localFirstCommentSinkHandler.a();
    QLog.d("RIJCommentNetworkHelper", 1, "sink comment, detail : " + paramFirstCommentSinkData);
  }
  
  public final void a(@NotNull FirstCommentStickyData paramFirstCommentStickyData, @NotNull ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentStickyData, "commentStickyData");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentObserver, "callback");
    FirstCommentStickyHandler localFirstCommentStickyHandler = new FirstCommentStickyHandler(paramFirstCommentStickyData);
    localFirstCommentStickyHandler.a((Function1)new RIJCommentNetworkHelper.updateCommentStickyStatus.1(paramReadInJoyCommentObserver, paramFirstCommentStickyData));
    localFirstCommentStickyHandler.a((Function0)new RIJCommentNetworkHelper.updateCommentStickyStatus.2(paramReadInJoyCommentObserver, paramFirstCommentStickyData));
    localFirstCommentStickyHandler.a();
    QLog.d("RIJCommentNetworkHelper", 1, "update comment setTop status, detail : " + paramFirstCommentStickyData);
  }
  
  public final void a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "subCommentCreateData: " + paramSubCommentCreateData + ' ' + paramString);
    }
    paramString = new CreateSubCommentHandlerForHippy(paramSubCommentCreateData, paramString);
    paramString.a((Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.1(paramBoolean, paramRIJCreateCommentForHippyObserver, paramSubCommentCreateData, l));
    paramString.b((Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.2(paramRIJCreateCommentForHippyObserver, l));
    paramString.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper
 * JD-Core Version:    0.7.0.1
 */