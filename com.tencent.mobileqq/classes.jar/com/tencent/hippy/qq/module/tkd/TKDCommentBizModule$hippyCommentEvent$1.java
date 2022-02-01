package com.tencent.hippy.qq.module.tkd;

import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent.DefaultImpls;
import com.tencent.mtt.hippy.common.HippyMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/hippy/qq/module/tkd/TKDCommentBizModule$hippyCommentEvent$1", "Lcom/tencent/hippy/qq/utils/tkd/TKDCommentDispatcher$HippyCommentEvent;", "jScloseComment", "", "onFontScaleChange", "scaleFactor", "", "refreshNewAndHotData", "hippyMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentBizModule$hippyCommentEvent$1
  implements TKDCommentDispatcher.HippyCommentEvent
{
  public void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher)
  {
    Intrinsics.checkParameterIsNotNull(paramParamsFetcher, "fetcher");
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.biuComment(this, paramParamsFetcher);
  }
  
  public void closeComment()
  {
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.closeComment(this);
  }
  
  public void jScloseComment()
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("direction", "right");
    this.this$0.sendEventToJs("@comment:swipe", localHippyMap);
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
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.onCommentViewLayout(this);
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
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushDouble("scaleFactor", paramDouble);
    this.this$0.sendEventToJs("@comment:onFontScaleChange", localHippyMap);
  }
  
  public void onSubCommentClose()
  {
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.onSubCommentClose(this);
  }
  
  public void onSubCommentOpen()
  {
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.onSubCommentOpen(this);
  }
  
  public void openComment()
  {
    TKDCommentDispatcher.HippyCommentEvent.DefaultImpls.openComment(this);
  }
  
  public void refreshNewAndHotData(@NotNull HippyMap paramHippyMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHippyMap, "hippyMap");
    this.this$0.sendEventToJs("@comment:refreshNewAndHot", paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.hippyCommentEvent.1
 * JD-Core Version:    0.7.0.1
 */