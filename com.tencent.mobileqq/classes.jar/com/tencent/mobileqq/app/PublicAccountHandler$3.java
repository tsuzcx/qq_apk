package com.tencent.mobileqq.app;

import ofx;

class PublicAccountHandler$3
  implements Runnable
{
  PublicAccountHandler$3(PublicAccountHandler paramPublicAccountHandler) {}
  
  public void run()
  {
    ofx localofx = (ofx)this.this$0.app.getManager(88);
    if (localofx != null) {
      localofx.a(null, "FollowList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.3
 * JD-Core Version:    0.7.0.1
 */