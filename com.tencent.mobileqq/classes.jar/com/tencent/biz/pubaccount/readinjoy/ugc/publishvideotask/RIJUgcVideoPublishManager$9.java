package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.persistence.EntityManager;
import rno;

public class RIJUgcVideoPublishManager$9
  implements Runnable
{
  public RIJUgcVideoPublishManager$9(rno paramrno, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    rno.a(this.this$0).persistOrReplace(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.9
 * JD-Core Version:    0.7.0.1
 */