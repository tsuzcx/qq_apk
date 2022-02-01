package com.tencent.mobileqq.activity.aio.item;

import ahjx;
import ahjz;
import bejk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.manager.Manager;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$getItemView$1$1"}, k=3, mv={1, 1, 16})
public final class TofuAskAnonymouslyItemBuilder$getItemView$$inlined$let$lambda$1
  implements Runnable
{
  public TofuAskAnonymouslyItemBuilder$getItemView$$inlined$let$lambda$1(ahjx paramahjx) {}
  
  public final void run()
  {
    Manager localManager = this.this$0.a.getManager(QQManagerFactory.TOFUMSG_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.tofumsg.TofuManager");
    }
    ((bejk)localManager).a(ahjx.a(this.this$0).a(), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.getItemView..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */