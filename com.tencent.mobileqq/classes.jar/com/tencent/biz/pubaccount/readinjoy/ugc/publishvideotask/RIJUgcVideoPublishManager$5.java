package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import rps;

public class RIJUgcVideoPublishManager$5
  implements Runnable
{
  public RIJUgcVideoPublishManager$5(rps paramrps, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "Publish steps hav all finished. video status =" + this.a.status);
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcVideoPublishManager.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.5
 * JD-Core Version:    0.7.0.1
 */