package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PlusRedPointHelper$onMoveToState$block$1
  extends Lambda
  implements Function0<Unit>
{
  PlusRedPointHelper$onMoveToState$block$1(PlusRedPointHelper paramPlusRedPointHelper)
  {
    super(0);
  }
  
  public final void invoke()
  {
    PlusPanelViewModel localPlusPanelViewModel = PlusRedPointHelper.b(this.this$0);
    if (localPlusPanelViewModel != null) {
      localPlusPanelViewModel.a(PlusRedPointHelper.a(this.this$0));
    }
    localPlusPanelViewModel = PlusRedPointHelper.b(this.this$0);
    if (localPlusPanelViewModel != null) {
      localPlusPanelViewModel.b(PlusRedPointHelper.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper.onMoveToState.block.1
 * JD-Core Version:    0.7.0.1
 */