package com.tencent.mobileqq.app;

import ajno;
import atmp;
import atmq;
import com.tencent.mobileqq.data.ExtensionInfo;

public class PPCLoginAuthHandler$1
  implements Runnable
{
  public PPCLoginAuthHandler$1(ajno paramajno) {}
  
  public void run()
  {
    atmp localatmp = this.this$0.a.getEntityManagerFactory(this.this$0.a.getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localatmp.a(ExtensionInfo.class, this.this$0.a.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localatmp.a(localExtensionInfo);
    }
    for (;;)
    {
      localatmp.a();
      return;
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.this$0.a.getAccount();
      localatmp.a(localExtensionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PPCLoginAuthHandler.1
 * JD-Core Version:    0.7.0.1
 */