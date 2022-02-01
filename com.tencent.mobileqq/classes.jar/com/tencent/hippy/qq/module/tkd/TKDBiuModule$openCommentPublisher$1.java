package com.tencent.hippy.qq.module.tkd;

import android.app.Activity;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDBiuModule$openCommentPublisher$1
  implements Runnable
{
  TKDBiuModule$openCommentPublisher$1(TKDBiuModule paramTKDBiuModule, HippyMap paramHippyMap) {}
  
  public final void run()
  {
    QLog.d("TKDBiuModule", 1, "openBiuPublisher() --> params:" + this.$params);
    if (TKDBiuModule.access$getActivity(this.this$0) == null)
    {
      QLog.e("TKDBiuModule", 1, "openCommentPublisher() --> activity is null");
      return;
    }
    try
    {
      TKDBiuModule localTKDBiuModule = this.this$0;
      HippyMap localHippyMap = this.$params;
      Activity localActivity = TKDBiuModule.access$getActivity(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "activity");
      TKDBiuModule.access$openBiuEditor(localTKDBiuModule, localHippyMap, localActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      QLog.e("TKDBiuModule", 1, "buildBiuEditorIntent() failed! " + localClassCastException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDBiuModule.openCommentPublisher.1
 * JD-Core Version:    0.7.0.1
 */