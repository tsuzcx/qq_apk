package com.tencent.mobileqq.app;

import akby;
import aukn;
import auko;
import com.tencent.mobileqq.data.ExtensionInfo;

public class PPCLoginAuthHandler$1
  implements Runnable
{
  public PPCLoginAuthHandler$1(akby paramakby) {}
  
  public void run()
  {
    aukn localaukn = this.this$0.a.getEntityManagerFactory(this.this$0.a.getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localaukn.a(ExtensionInfo.class, this.this$0.a.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localaukn.a(localExtensionInfo);
    }
    for (;;)
    {
      localaukn.a();
      return;
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.this$0.a.getAccount();
      localaukn.a(localExtensionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PPCLoginAuthHandler.1
 * JD-Core Version:    0.7.0.1
 */