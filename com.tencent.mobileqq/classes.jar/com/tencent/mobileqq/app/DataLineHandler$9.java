package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.service.message.MessageCache;

class DataLineHandler$9
  extends MessageObserver
{
  DataLineHandler$9(DataLineHandler paramDataLineHandler) {}
  
  protected void onSelfIpadOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.j()))
    {
      this.a.b(true);
      DataLineHandler.b(this.a, MessageCache.c());
      this.a.i.getMessageFacade().d(1).c();
    }
  }
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.a.i()))
    {
      this.a.a(true);
      DataLineHandler.a(this.a, MessageCache.c());
      this.a.i.getMessageFacade().d(0).c();
    }
    this.a.e.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.9
 * JD-Core Version:    0.7.0.1
 */