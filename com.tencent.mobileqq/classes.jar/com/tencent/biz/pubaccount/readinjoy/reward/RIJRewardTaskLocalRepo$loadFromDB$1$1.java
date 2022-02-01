package com.tencent.biz.pubaccount.readinjoy.reward;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qxt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskLocalRepo$loadFromDB$1$1
  implements Runnable
{
  RIJRewardTaskLocalRepo$loadFromDB$1$1(RIJRewardTaskLocalRepo.loadFromDB.1 param1, List paramList) {}
  
  public final void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RedPacketTaskData)localIterator.next();
      qxt localqxt = this.this$0.this$0;
      localObject = ((RedPacketTaskData)localObject).rowKey;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "taskData.rowKey");
      qxt.a(localqxt, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo.loadFromDB.1.1
 * JD-Core Version:    0.7.0.1
 */