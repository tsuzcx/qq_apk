package com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo;

import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mtt.hippy.common.HippyMap;
import org.jetbrains.annotations.NotNull;

class ViolaCommentManager$8
  implements TKDCommentDispatcher.HippyCommentEvent
{
  ViolaCommentManager$8(ViolaCommentManager paramViolaCommentManager) {}
  
  public void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher) {}
  
  public void closeComment()
  {
    ViolaCommentManager.a(this.a);
  }
  
  public void jScloseComment() {}
  
  public void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4) {}
  
  public void onCommentViewLayout() {}
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6) {}
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4) {}
  
  public void onFontScaleChange(double paramDouble) {}
  
  public void onSubCommentClose() {}
  
  public void onSubCommentOpen() {}
  
  public void openComment() {}
  
  public void refreshNewAndHotData(HippyMap paramHippyMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaCommentManager.8
 * JD-Core Version:    0.7.0.1
 */