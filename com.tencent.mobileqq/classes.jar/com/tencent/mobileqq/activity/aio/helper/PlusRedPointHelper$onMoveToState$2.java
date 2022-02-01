package com.tencent.mobileqq.activity.aio.helper;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/pluspanel/PluginData;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class PlusRedPointHelper$onMoveToState$2<T>
  implements Observer<ArrayList<PluginData>>
{
  PlusRedPointHelper$onMoveToState$2(PlusRedPointHelper paramPlusRedPointHelper) {}
  
  public final void a(ArrayList<PluginData> paramArrayList)
  {
    PlusRedPointHelper localPlusRedPointHelper = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "it");
    PlusRedPointHelper.a(localPlusRedPointHelper, paramArrayList);
    paramArrayList = PlusRedPointHelper.a(this.a);
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.a;
      if (paramArrayList != null) {
        paramArrayList.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper.onMoveToState.2
 * JD-Core Version:    0.7.0.1
 */