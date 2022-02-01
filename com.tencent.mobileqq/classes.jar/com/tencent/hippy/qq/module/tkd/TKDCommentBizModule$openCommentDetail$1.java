package com.tencent.hippy.qq.module.tkd;

import com.tencent.hippy.qq.tuwen.callback.ITKDTuWenHippyObservable;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$openCommentDetail$1
  implements Runnable
{
  TKDCommentBizModule$openCommentDetail$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    QLog.d("TKDCommentBizModule", 1, "openCommentDetail() --> params:" + this.$params);
    if (TKDCommentBizModule.access$getActivity(this.this$0) == null) {
      QLog.e("TKDCommentBizModule", 1, "openCommentDetail() --> activity is null");
    }
    String str1;
    String str2;
    ITKDTuWenHippyObservable localITKDTuWenHippyObservable;
    do
    {
      return;
      str1 = this.$params.getString("commentId");
      str2 = this.$params.getString("anchorId");
      localITKDTuWenHippyObservable = TKDCommentBizModule.access$getTuWenHippyObservable$p(this.this$0);
    } while (localITKDTuWenHippyObservable == null);
    localITKDTuWenHippyObservable.openSubCommentPage(str1, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.openCommentDetail.1
 * JD-Core Version:    0.7.0.1
 */