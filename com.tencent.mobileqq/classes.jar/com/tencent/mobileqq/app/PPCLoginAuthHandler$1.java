package com.tencent.mobileqq.app;

import akbx;
import aukp;
import aukq;
import com.tencent.mobileqq.data.ExtensionInfo;

public class PPCLoginAuthHandler$1
  implements Runnable
{
  public PPCLoginAuthHandler$1(akbx paramakbx) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.a.getEntityManagerFactory(this.this$0.a.getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localaukp.a(ExtensionInfo.class, this.this$0.a.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localaukp.a(localExtensionInfo);
    }
    for (;;)
    {
      localaukp.a();
      return;
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.this$0.a.getAccount();
      localaukp.a(localExtensionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PPCLoginAuthHandler.1
 * JD-Core Version:    0.7.0.1
 */