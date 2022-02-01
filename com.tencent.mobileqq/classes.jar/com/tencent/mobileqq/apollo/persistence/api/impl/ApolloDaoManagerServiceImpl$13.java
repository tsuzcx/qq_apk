package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

class ApolloDaoManagerServiceImpl$13
  implements Runnable
{
  ApolloDaoManagerServiceImpl$13(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (ApolloDaoManagerServiceImpl.access$700(this.this$0))
    {
      if ((ApolloDaoManagerServiceImpl.access$800(this.this$0) != null) && (this.a != null) && (ApolloDaoManagerServiceImpl.access$800(this.this$0).contains(this.a))) {
        ApolloDaoManagerServiceImpl.access$800(this.this$0).remove(this.a);
      }
      if (ApolloDaoManagerServiceImpl.access$900(this.this$0) != null)
      {
        ApolloDaoManagerServiceImpl.access$900(this.this$0).remove(this.a);
        ApolloDaoManagerServiceImpl.access$900(this.this$0).close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.13
 * JD-Core Version:    0.7.0.1
 */