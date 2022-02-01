package com.tencent.hippy.qq.module.tkd;

import android.content.Intent;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import junit.framework.AssertionFailedError;
import kotlin.Metadata;
import pcp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TKDCommentBizModule$openCommentPublisher$1
  implements Runnable
{
  TKDCommentBizModule$openCommentPublisher$1(TKDCommentBizModule paramTKDCommentBizModule, HippyMap paramHippyMap, Promise paramPromise) {}
  
  public final void run()
  {
    QLog.d("TKDCommentBizModule", 1, "openCommentPublisher() --> params:" + this.$params);
    if (TKDCommentBizModule.access$getActivity(this.this$0) == null)
    {
      QLog.e("TKDCommentBizModule", 1, "openCommentPublisher() --> activity is null");
      return;
    }
    TKDCommentBizModule.access$setCommentPublisherPromise$p(this.this$0, this.$promise);
    TKDCommentBizModule.access$setExtraParams$p(this.this$0, this.$params.getString("extraParam"));
    try
    {
      Intent localIntent = TKDCommentBizModule.access$buildCommentEditorIntent(this.this$0, this.$params);
      pcp.a(TKDCommentBizModule.access$getActivity(this.this$0), localIntent, 117);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      TKDCommentBizModule.access$handleError(this.this$0, "buildCommentEditorIntent() failed!", (Throwable)localClassCastException);
      return;
    }
    catch (AssertionFailedError localAssertionFailedError)
    {
      TKDCommentBizModule.access$handleError(this.this$0, "buildCommentEditorIntent() failed!", (Throwable)localAssertionFailedError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDCommentBizModule.openCommentPublisher.1
 * JD-Core Version:    0.7.0.1
 */