package com.tencent.mobileqq.app;

import nfp;

class PublicAccountHandler$2
  implements Runnable
{
  PublicAccountHandler$2(PublicAccountHandler paramPublicAccountHandler) {}
  
  public void run()
  {
    nfp localnfp = (nfp)this.this$0.app.getManager(88);
    if (localnfp != null) {
      localnfp.a(null, "FollowList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.2
 * JD-Core Version:    0.7.0.1
 */