package com.tencent.hippy.qq.module.tkd;

import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver;
import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObservable;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/hippy/qq/module/tkd/TKDCommentBizModule$handleOnActivityResult$observer$1", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "onCreateCommentResult", "", "success", "", "errorCode", "", "comment", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentBizModule$handleOnActivityResult$observer$1
  implements RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver
{
  public void onCreateCommentResult(boolean paramBoolean, int paramInt, @Nullable String paramString)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      Promise localPromise = TKDCommentBizModule.access$getCommentPublisherPromise$p(this.this$0);
      if (localPromise != null) {
        localPromise.resolve(TKDCommentBizModule.access$buildCallbackInfo(this.this$0, i, Integer.valueOf(paramInt), paramString));
      }
      QLog.d("TKDCommentBizModule", 1, "onCreateCommentResult() --> retCode:" + i + " errorCode:" + paramInt + " comment:" + paramString);
      paramString = TKDCommentBizModule.access$getTuWenHippyObservable$p(this.this$0);
      if (paramString != null) {
        paramString.scrollToNew();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.handleOnActivityResult.observer.1
 * JD-Core Version:    0.7.0.1
 */