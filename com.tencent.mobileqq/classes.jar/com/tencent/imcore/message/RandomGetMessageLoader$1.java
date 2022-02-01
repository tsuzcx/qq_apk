package com.tencent.imcore.message;

import android.os.Handler;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;

class RandomGetMessageLoader$1
  implements Runnable
{
  RandomGetMessageLoader$1(RandomGetMessageLoader paramRandomGetMessageLoader, RefreshMessageContext paramRefreshMessageContext, int paramInt1, String paramString, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3) {}
  
  public void run()
  {
    this.this$0.a.b(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("RandomGetMessageLoader", 2, "refreshTroopUnreadMessage begin");
    }
    RefreshMessageContext localRefreshMessageContext = this.a;
    int j = this.b;
    localRefreshMessageContext.r = j;
    localRefreshMessageContext.l = 0;
    this.this$0.a(this.c, this.d, this.e, j, this.f, localRefreshMessageContext, this.g);
    boolean bool = RandomGetMessageLoader.a(this.this$0, this.c, this.d, this.e, this.f, this.b);
    QLog.d("RandomGetMessageLoader", 1, new Object[] { "refreshTroopUnreadMessage isSuccess:", Boolean.valueOf(bool) });
    if ((bool) && (this.h)) {
      this.this$0.a.a(this.d, this.c, this.i, this.this$0.a.a(this.c, this.d));
    }
    this.a.i = bool;
    if (this.g) {
      this.this$0.a.b.setChangeAndNotify(this.a);
    }
    this.this$0.a.b.getFacadeHandler().post(new RandomGetMessageLoader.1.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("RandomGetMessageLoader", 2, "refreshTroopUnreadMessage end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.RandomGetMessageLoader.1
 * JD-Core Version:    0.7.0.1
 */