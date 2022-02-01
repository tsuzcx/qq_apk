package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.tofumsg.TofuManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.manager.Manager;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$getItemView$1$1"}, k=3, mv={1, 1, 16})
final class TofuAskAnonymouslyItemBuilder$getItemView$$inlined$let$lambda$1
  implements Runnable
{
  TofuAskAnonymouslyItemBuilder$getItemView$$inlined$let$lambda$1(TofuAskAnonymouslyItemBuilder paramTofuAskAnonymouslyItemBuilder) {}
  
  public final void run()
  {
    Manager localManager = this.this$0.a.getManager(QQManagerFactory.TOFUMSG_MANAGER);
    if (localManager != null)
    {
      ((TofuManager)localManager).a(TofuAskAnonymouslyItemBuilder.a(this.this$0).a(), 3);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.TofuManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.getItemView..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */