package com.tencent.biz.pubaccount.readinjoy.comment.helper;

import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkWrapper;", "", "()V", "TAG", "", "createFirstComment", "", "requestData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "feedsType", "", "isFeeds", "", "needBiuAfterComment", "createFirstCommentForHippy", "", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "extraParam", "createSubComment", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "createSubCommentForHippy", "wrapCallback", "com/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkWrapper$wrapCallback$1", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentUtils$CustomDialogClickListener;", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentObserver;Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentUtils$CustomDialogClickListener;)Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkWrapper$wrapCallback$1;", "wrapHippyCallback", "com/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkWrapper$wrapHippyCallback$1", "(Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentUtils$CustomDialogClickListener;)Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkWrapper$wrapHippyCallback$1;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkWrapper
{
  public static final RIJCommentNetworkWrapper a = new RIJCommentNetworkWrapper();
  
  private final RIJCommentNetworkWrapper.wrapCallback.1 a(RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    return new RIJCommentNetworkWrapper.wrapCallback.1(paramCustomDialogClickListener, paramRIJCreateCommentObserver);
  }
  
  private final RIJCommentNetworkWrapper.wrapHippyCallback.1 a(RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    return new RIJCommentNetworkWrapper.wrapHippyCallback.1(paramCustomDialogClickListener, paramRIJCreateCommentForHippyObserver);
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return a(paramFirstCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean, false);
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    paramRIJCreateCommentObserver = a(paramRIJCreateCommentObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createFirstComment.mCallback.1(paramFirstCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2));
    return RIJCommentNetworkHelper.a.a(paramFirstCommentCreateData, (RIJCommentNetworkHelper.RIJCreateCommentObserver)paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return a(paramSubCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean, false);
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    paramRIJCreateCommentObserver = a(paramRIJCreateCommentObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createSubComment.mCallback.1(paramSubCommentCreateData, paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2));
    return RIJCommentNetworkHelper.a.a(paramSubCommentCreateData, (RIJCommentNetworkHelper.RIJCreateCommentObserver)paramRIJCreateCommentObserver, paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public final void a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    paramRIJCreateCommentForHippyObserver = a(paramRIJCreateCommentForHippyObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createFirstCommentForHippy.mCallback.1(paramFirstCommentCreateData, paramRIJCreateCommentForHippyObserver, paramBoolean, paramString));
    RIJCommentNetworkHelper.a.a(paramFirstCommentCreateData, (RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver)paramRIJCreateCommentForHippyObserver, paramBoolean, paramString);
  }
  
  public final void a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    paramRIJCreateCommentForHippyObserver = a(paramRIJCreateCommentForHippyObserver, (ReadInJoyCommentUtils.CustomDialogClickListener)new RIJCommentNetworkWrapper.createSubCommentForHippy.mCallback.1(paramSubCommentCreateData, paramRIJCreateCommentForHippyObserver, paramBoolean, paramString));
    RIJCommentNetworkHelper.a.a(paramSubCommentCreateData, (RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver)paramRIJCreateCommentForHippyObserver, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkWrapper
 * JD-Core Version:    0.7.0.1
 */