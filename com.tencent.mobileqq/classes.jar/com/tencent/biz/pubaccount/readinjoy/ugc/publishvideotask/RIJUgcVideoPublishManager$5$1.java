package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;

class RIJUgcVideoPublishManager$5$1
  implements Runnable
{
  RIJUgcVideoPublishManager$5$1(RIJUgcVideoPublishManager.5 param5) {}
  
  public void run()
  {
    if (this.a.a.status == UgcVideo.STATUS_FINISH)
    {
      this.a.this$0.a(this.a.a);
      RIJUgcVideoPublishManager.a(this.a.this$0, this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.5.1
 * JD-Core Version:    0.7.0.1
 */