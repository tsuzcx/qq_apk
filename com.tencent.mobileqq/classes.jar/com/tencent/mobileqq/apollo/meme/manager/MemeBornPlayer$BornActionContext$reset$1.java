package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.ERROR_TIME_OUT;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MemeBornPlayer$BornActionContext$reset$1
  implements Runnable
{
  MemeBornPlayer$BornActionContext$reset$1(MemeBornPlayer.BornActionContext paramBornActionContext) {}
  
  public final void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.this$0.k().h());
    ((StringBuilder)localObject).append(" timeout(");
    ((StringBuilder)localObject).append(MemeBornPlayer.a.a());
    ((StringBuilder)localObject).append("ms)!! callback timeout");
    QLog.e("[cmshow][MemePlayer]MemeBornPlayer", 1, ((StringBuilder)localObject).toString());
    MemeBornPlayer.Companion.a(MemeBornPlayer.a, this.this$0, (ActionStatus)ERROR_TIME_OUT.a);
    localObject = this.this$0.d();
    if (localObject != null) {
      ((PlayActionScript)localObject).a((ActionStatus)ERROR_TIME_OUT.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.BornActionContext.reset.1
 * JD-Core Version:    0.7.0.1
 */