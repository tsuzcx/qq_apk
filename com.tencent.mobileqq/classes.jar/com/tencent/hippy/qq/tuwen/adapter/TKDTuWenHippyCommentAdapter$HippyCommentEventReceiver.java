package com.tencent.hippy.qq.tuwen.adapter;

import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import org.jetbrains.annotations.NotNull;

class TKDTuWenHippyCommentAdapter$HippyCommentEventReceiver
  implements TKDCommentDispatcher.HippyCommentEvent
{
  private TKDTuWenHippyCommentAdapter$HippyCommentEventReceiver(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter) {}
  
  public void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher)
  {
    paramParamsFetcher.onGetParams(this.this$0.mArticleInfo, TKDTuWenHippyCommentAdapter.access$400(this.this$0), TKDTuWenHippyCommentAdapter.access$500(this.this$0), "");
  }
  
  public void closeComment() {}
  
  public void jScloseComment() {}
  
  public void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4) {}
  
  public void onCommentViewLayout() {}
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6) {}
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4) {}
  
  public void onFontScaleChange(double paramDouble) {}
  
  public void onSubCommentClose() {}
  
  public void onSubCommentOpen() {}
  
  public void openComment() {}
  
  public void refreshNewAndHotData(@NotNull HippyMap paramHippyMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter.HippyCommentEventReceiver
 * JD-Core Version:    0.7.0.1
 */