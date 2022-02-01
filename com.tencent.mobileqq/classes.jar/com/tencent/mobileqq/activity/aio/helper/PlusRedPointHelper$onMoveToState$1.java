package com.tencent.mobileqq.activity.aio.helper;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/pluspanel/PluginData;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class PlusRedPointHelper$onMoveToState$1<T>
  implements Observer<ArrayList<PluginData>>
{
  PlusRedPointHelper$onMoveToState$1(PlusRedPointHelper paramPlusRedPointHelper) {}
  
  public final void a(ArrayList<PluginData> paramArrayList)
  {
    Object localObject = PlusRedPointHelper.a(this.a);
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).d;
      if (localObject != null) {
        ((QQAppInterface)localObject).runOnUiThread((Runnable)new PlusRedPointHelper.onMoveToState.1.1(this, paramArrayList));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusRedPointHelper.onMoveToState.1
 * JD-Core Version:    0.7.0.1
 */