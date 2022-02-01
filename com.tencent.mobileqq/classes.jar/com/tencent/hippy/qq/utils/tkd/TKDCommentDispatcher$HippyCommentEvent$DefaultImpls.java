package com.tencent.hippy.qq.utils.tkd;

import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class TKDCommentDispatcher$HippyCommentEvent$DefaultImpls
{
  public static void biuComment(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent, @NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher)
  {
    Intrinsics.checkParameterIsNotNull(paramParamsFetcher, "fetcher");
  }
  
  public static void closeComment(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent) {}
  
  public static void jScloseComment(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent) {}
  
  public static void onClickLike(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    Intrinsics.checkParameterIsNotNull(paramString3, "likeType");
    Intrinsics.checkParameterIsNotNull(paramString4, "seq");
  }
  
  public static void onCommentViewLayout(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent) {}
  
  public static void onCreateComment(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    Intrinsics.checkParameterIsNotNull(paramString3, "commentContent");
    Intrinsics.checkParameterIsNotNull(paramString4, "level");
    Intrinsics.checkParameterIsNotNull(paramString5, "seq");
    Intrinsics.checkParameterIsNotNull(paramString6, "parentCommentId");
  }
  
  public static void onDeleteComment(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    Intrinsics.checkParameterIsNotNull(paramString3, "seq");
    Intrinsics.checkParameterIsNotNull(paramString4, "totalDeleteCount");
  }
  
  public static void onFontScaleChange(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent, double paramDouble) {}
  
  public static void onSubCommentClose(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent) {}
  
  public static void onSubCommentOpen(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent) {}
  
  public static void openComment(TKDCommentDispatcher.HippyCommentEvent paramHippyCommentEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */