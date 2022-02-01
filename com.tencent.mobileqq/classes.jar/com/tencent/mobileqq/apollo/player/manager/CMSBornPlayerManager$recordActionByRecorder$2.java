package com.tencent.mobileqq.apollo.player.manager;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CMSBornPlayerManager$recordActionByRecorder$2
  extends Lambda
  implements Function0<Unit>
{
  CMSBornPlayerManager$recordActionByRecorder$2(CMSBornPlayerManager.ActionItem paramActionItem, CMSBornPlayer paramCMSBornPlayer, CMSBornPlayerManager.recordActionByRecorder.listenerWrapper.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    TraceReportUtil.a(CMSHelper.a.a(this.$actionItem.a().a()), CMSAction.a(this.$actionItem.a(), null, null, 3, null), 1);
    CMSBornPlayer localCMSBornPlayer = this.$recorder;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
    localCMSBornPlayer.a((Context)localBaseApplicationImpl, this.$actionItem.a(), this.$actionItem.b(), this.$actionItem.a(), (ICMSPlayerListener)this.$listenerWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.recordActionByRecorder.2
 * JD-Core Version:    0.7.0.1
 */