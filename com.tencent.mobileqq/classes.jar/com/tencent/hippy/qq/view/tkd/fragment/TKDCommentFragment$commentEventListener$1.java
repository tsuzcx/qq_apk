package com.tencent.hippy.qq.view.tkd.fragment;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent.DefaultImpls;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/hippy/qq/view/tkd/fragment/TKDCommentFragment$commentEventListener$1", "Lcom/tencent/hippy/qq/utils/tkd/TKDCommentDispatcher$HippyCommentEvent;", "biuComment", "", "fetcher", "Lcom/tencent/hippy/qq/module/tkd/TKDBiuModule$ParamsFetcher;", "closeComment", "onCommentViewLayout", "onSubCommentClose", "onSubCommentOpen", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentFragment$commentEventListener$1
  implements TKDCommentDispatcher.HippyCommentEvent
{
  public void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher)
  {
    Intrinsics.checkParameterIsNotNull(paramParamsFetcher, "fetcher");
    QLog.d(TKDCommentFragment.Companion.getTAG(), 1, "biuComment");
    ArticleInfo localArticleInfo = this.this$0.getArticleInfo();
    if (localArticleInfo != null) {
      paramParamsFetcher.onGetParams(localArticleInfo, this.this$0.getAdTag(), this.this$0.getBiuType(), "");
    }
  }
  
  public void closeComment()
  {
    QLog.d(TKDCommentFragment.Companion.getTAG(), 1, "closeComment");
  }
  
  public void jScloseComment()
  {
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.jScloseComment(this);
  }
  
  public void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    Intrinsics.checkParameterIsNotNull(paramString3, "likeType");
    Intrinsics.checkParameterIsNotNull(paramString4, "seq");
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.onClickLike(this, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void onCommentViewLayout()
  {
    QLog.d(TKDCommentFragment.Companion.getTAG(), 1, "onCommentViewLayout");
    this.this$0.setGestureLayout();
  }
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    Intrinsics.checkParameterIsNotNull(paramString3, "commentContent");
    Intrinsics.checkParameterIsNotNull(paramString4, "level");
    Intrinsics.checkParameterIsNotNull(paramString5, "seq");
    Intrinsics.checkParameterIsNotNull(paramString6, "parentCommentId");
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.onCreateComment(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "commentId");
    Intrinsics.checkParameterIsNotNull(paramString3, "seq");
    Intrinsics.checkParameterIsNotNull(paramString4, "totalDeleteCount");
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.onDeleteComment(this, paramString1, paramString2, paramString3, paramString4);
  }
  
  public void onFontScaleChange(double paramDouble)
  {
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.onFontScaleChange(this, paramDouble);
  }
  
  public void onSubCommentClose()
  {
    QLog.d(TKDCommentFragment.Companion.getTAG(), 1, "closeSubComment");
    this.this$0.setCommentState(TKDCommentFragment.Companion.getFLAG_COMMENT_FIRST());
    this.this$0.setGestureLayout();
  }
  
  public void onSubCommentOpen()
  {
    QLog.d(TKDCommentFragment.Companion.getTAG(), 1, "openSubComment");
    this.this$0.setCommentState(TKDCommentFragment.Companion.getFLAG_COMMENT_SECOND());
    this.this$0.setGestureLayout();
  }
  
  public void openComment()
  {
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.openComment(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.fragment.TKDCommentFragment.commentEventListener.1
 * JD-Core Version:    0.7.0.1
 */