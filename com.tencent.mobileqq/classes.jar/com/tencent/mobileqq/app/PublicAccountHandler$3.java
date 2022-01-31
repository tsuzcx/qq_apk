package com.tencent.mobileqq.app;

import nqq;

class PublicAccountHandler$3
  implements Runnable
{
  PublicAccountHandler$3(PublicAccountHandler paramPublicAccountHandler) {}
  
  public void run()
  {
    nqq localnqq = (nqq)this.this$0.app.getManager(88);
    if (localnqq != null) {
      localnqq.a(null, "FollowList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.3
 * JD-Core Version:    0.7.0.1
 */