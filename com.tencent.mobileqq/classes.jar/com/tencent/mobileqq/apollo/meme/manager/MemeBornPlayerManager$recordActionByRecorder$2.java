package com.tencent.mobileqq.apollo.meme.manager;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MemeBornPlayerManager$recordActionByRecorder$2
  extends Lambda
  implements Function0<Unit>
{
  MemeBornPlayerManager$recordActionByRecorder$2(MemeBornPlayerManager.ActionItem paramActionItem, MemeBornPlayer paramMemeBornPlayer, MemeBornPlayerManager.recordActionByRecorder.listenerWrapper.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    TraceReportUtil.a(MemeHelper.a.a(this.$actionItem.c().i()), MemeAction.a(this.$actionItem.c(), null, null, 3, null), 1);
    MemeBornPlayer localMemeBornPlayer = this.$recorder;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
    localMemeBornPlayer.a((Context)localBaseApplicationImpl, this.$actionItem.a(), this.$actionItem.b(), this.$actionItem.c(), (InnerMemePlayerListener)this.$listenerWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager.recordActionByRecorder.2
 * JD-Core Version:    0.7.0.1
 */