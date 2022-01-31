package com.tencent.mobileqq.app;

import altm;
import awbw;
import awbx;
import com.tencent.mobileqq.data.ExtensionInfo;

public class PPCLoginAuthHandler$1
  implements Runnable
{
  public PPCLoginAuthHandler$1(altm paramaltm) {}
  
  public void run()
  {
    awbw localawbw = this.this$0.a.getEntityManagerFactory(this.this$0.a.getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localawbw.a(ExtensionInfo.class, this.this$0.a.getAccount());
    if (localExtensionInfo != null)
    {
      localExtensionInfo.commingRingId = 0L;
      localawbw.a(localExtensionInfo);
    }
    for (;;)
    {
      localawbw.a();
      return;
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = this.this$0.a.getAccount();
      localawbw.a(localExtensionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PPCLoginAuthHandler.1
 * JD-Core Version:    0.7.0.1
 */