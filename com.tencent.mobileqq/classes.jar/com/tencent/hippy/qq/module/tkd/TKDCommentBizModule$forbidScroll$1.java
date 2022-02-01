package com.tencent.hippy.qq.module.tkd;

import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObservable;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$forbidScroll$1
  implements Runnable
{
  TKDCommentBizModule$forbidScroll$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    QLog.d("TKDCommentBizModule", 1, "onForbidScroll() --> params:" + this.$params);
    if (TKDCommentBizModule.access$getActivity(this.this$0) == null) {
      QLog.e("TKDCommentBizModule", 1, "onForbidScroll() --> activity is null");
    }
    boolean bool;
    ITKDTuWenHippyObservable localITKDTuWenHippyObservable;
    do
    {
      return;
      bool = this.$params.getBoolean("forbid");
      localITKDTuWenHippyObservable = TKDCommentBizModule.access$getTuWenHippyObservable$p(this.this$0);
    } while (localITKDTuWenHippyObservable == null);
    localITKDTuWenHippyObservable.forbidScroll(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.forbidScroll.1
 * JD-Core Version:    0.7.0.1
 */