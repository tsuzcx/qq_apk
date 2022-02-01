package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PlusRedPointHelper$onMoveToState$1$1
  implements Runnable
{
  PlusRedPointHelper$onMoveToState$1$1(PlusRedPointHelper.onMoveToState.1 param1, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Object localObject = this.this$0.a;
    ArrayList localArrayList = this.a;
    Intrinsics.checkExpressionValueIsNotNull(localArrayList, "it");
    PlusRedPointHelper.a((PlusRedPointHelper)localObject, localArrayList);
    localObject = PlusRedPointHelper.a(this.this$0.a).a;
    if (localObject != null) {
      ((PanelIconLinearLayout)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper.onMoveToState.1.1
 * JD-Core Version:    0.7.0.1
 */