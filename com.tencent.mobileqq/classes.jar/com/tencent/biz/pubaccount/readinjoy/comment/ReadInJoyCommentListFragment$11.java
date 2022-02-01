package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import org.jetbrains.annotations.NotNull;

class ReadInJoyCommentListFragment$11
  implements TKDCommentDispatcher.HippyCommentEvent
{
  ReadInJoyCommentListFragment$11(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher) {}
  
  public void closeComment() {}
  
  public void jScloseComment() {}
  
  public void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4) {}
  
  public void onCommentViewLayout() {}
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null) {
      ReadInJoyCommentUtils.a(ReadInJoyCommentListFragment.a(this.a).mRecommendSeq, true);
    }
  }
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    if (ReadInJoyCommentListFragment.a(this.a) != null) {
      ReadInJoyCommentUtils.a(ReadInJoyCommentListFragment.a(this.a).mRecommendSeq, false);
    }
  }
  
  public void onFontScaleChange(double paramDouble) {}
  
  public void onSubCommentClose() {}
  
  public void onSubCommentOpen() {}
  
  public void openComment() {}
  
  public void refreshNewAndHotData(HippyMap paramHippyMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment.11
 * JD-Core Version:    0.7.0.1
 */