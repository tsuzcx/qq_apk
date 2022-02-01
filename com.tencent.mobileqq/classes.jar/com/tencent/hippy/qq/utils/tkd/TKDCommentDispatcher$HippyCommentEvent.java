package com.tencent.hippy.qq.utils.tkd;

import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/hippy/qq/utils/tkd/TKDCommentDispatcher$HippyCommentEvent;", "", "biuComment", "", "fetcher", "Lcom/tencent/hippy/qq/module/tkd/TKDBiuModule$ParamsFetcher;", "closeComment", "jScloseComment", "onClickLike", "rowKey", "", "commentId", "likeType", "seq", "onCommentViewLayout", "onCreateComment", "commentContent", "level", "parentCommentId", "onDeleteComment", "totalDeleteCount", "onFontScaleChange", "scaleFactor", "", "onSubCommentClose", "onSubCommentOpen", "openComment", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface TKDCommentDispatcher$HippyCommentEvent
{
  public abstract void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher);
  
  public abstract void closeComment();
  
  public abstract void jScloseComment();
  
  public abstract void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4);
  
  public abstract void onCommentViewLayout();
  
  public abstract void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6);
  
  public abstract void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4);
  
  public abstract void onFontScaleChange(double paramDouble);
  
  public abstract void onSubCommentClose();
  
  public abstract void onSubCommentOpen();
  
  public abstract void openComment();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent
 * JD-Core Version:    0.7.0.1
 */