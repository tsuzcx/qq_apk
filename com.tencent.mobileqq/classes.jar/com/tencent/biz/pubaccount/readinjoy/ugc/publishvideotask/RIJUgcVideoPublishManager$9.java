package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.persistence.EntityManager;

class RIJUgcVideoPublishManager$9
  implements Runnable
{
  RIJUgcVideoPublishManager$9(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    RIJUgcVideoPublishManager.a(this.this$0).persistOrReplace(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.9
 * JD-Core Version:    0.7.0.1
 */