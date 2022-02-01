package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.ERROR_TIME_OUT;
import com.tencent.mobileqq.apollo.meme.RECORD_COMPLETE;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import com.tencent.mobileqq.cmshow.engine.action.START;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import com.tencent.mobileqq.cmshow.engine.statistic.IActionStatistic;
import com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "newStatus", "invoke", "com/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$doPlayAction$playAction$1$1"}, k=3, mv={1, 1, 16})
final class MemeBornPlayer$doPlayAction$$inlined$apply$lambda$1
  extends Lambda
  implements Function2<ActionStatus, ActionStatus, Unit>
{
  MemeBornPlayer$doPlayAction$$inlined$apply$lambda$1(PlayActionScript paramPlayActionScript, MemeAction paramMemeAction)
  {
    super(2);
  }
  
  public final void invoke(@NotNull ActionStatus paramActionStatus1, @NotNull ActionStatus paramActionStatus2)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus1, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramActionStatus2, "newStatus");
    paramActionStatus1 = this.$this_apply.d().i().a();
    if ((Intrinsics.areEqual(paramActionStatus2, START.a)) && (paramActionStatus1 != null)) {
      paramActionStatus1.a(this.$this_apply.f().c(), this.$this_apply.f().m());
    }
    if ((Intrinsics.areEqual(paramActionStatus2, RECORD_COMPLETE.a)) || (Intrinsics.areEqual(paramActionStatus2, ERROR_TIME_OUT.a)))
    {
      paramActionStatus2 = this.$this_apply.c();
      QLog.i("[cmshow][MemePlayer]MemeBornPlayer", 1, this.$this_apply.a(paramActionStatus2));
      if (paramActionStatus1 != null) {
        paramActionStatus1.a(this.$this_apply.f().c(), this.$this_apply.f().m(), paramActionStatus2, new Object[] { this.$action$inlined });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.doPlayAction..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */