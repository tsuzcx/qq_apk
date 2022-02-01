package com.tencent.mobileqq.apollo.player.manager;

import amvk;
import amvq;
import amvz;
import amwb;
import android.content.Context;
import anis;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSAction.Companion.MODE;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
public final class CMSBornPlayerManager$recordActionByRecorder$2
  extends Lambda
  implements Function0<Unit>
{
  public CMSBornPlayerManager$recordActionByRecorder$2(amvz paramamvz, amvq paramamvq, amwb paramamwb)
  {
    super(0);
  }
  
  public final void invoke()
  {
    anis.a(this.$actionItem.a().a().toReportFeatureId(), CMSAction.a(this.$actionItem.a(), null, null, 3, null), 1);
    amvq localamvq = this.$recorder;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.getApplication()");
    localamvq.a((Context)localBaseApplicationImpl, this.$actionItem.a(), this.$actionItem.b(), this.$actionItem.a(), (amvk)this.$listenerWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.recordActionByRecorder.2
 * JD-Core Version:    0.7.0.1
 */