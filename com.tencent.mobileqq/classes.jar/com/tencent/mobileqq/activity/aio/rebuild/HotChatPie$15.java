package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;

class HotChatPie$15
  implements Runnable
{
  HotChatPie$15(HotChatPie paramHotChatPie, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (HotChatPie.i(this.this$0) == null)
    {
      localObject = this.this$0;
      HotChatPie.b((HotChatPie)localObject, new TroopFeedsCenterLogic(((HotChatPie)localObject).d, this.this$0.f, this.this$0.ah, HotChatPie.j(this.this$0), HotChatPie.k(this.this$0), this.this$0.bp, HotChatPie.l(this.this$0), null));
    }
    Object localObject = (IHotChatHandler)this.this$0.d.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
    if (this.a.userCreate == 1)
    {
      ((IHotChatHandler)localObject).getUserCreateHotChatAnnounce(this.a.troopUin);
      return;
    }
    if (this.a.uuid != null) {
      ((IHotChatHandler)localObject).getHotChatAnnounce(this.a.uuid.getBytes(), this.a.troopUin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.15
 * JD-Core Version:    0.7.0.1
 */