package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rps;

public class RIJUgcVideoPublishManager$8
  implements Runnable
{
  public RIJUgcVideoPublishManager$8(rps paramrps) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = rps.a(this.this$0).query(UgcVideo.class, UgcVideo.class.getSimpleName(), true, "", null, null, null, "insertTime desc", null);
      localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          UgcVideo localUgcVideo = (UgcVideo)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.i("RIJUGC.RIJUgcVideoPublishManager", 2, "ugcvideo id= " + localUgcVideo.seqId);
          }
          if (localUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
            localUgcVideo.status = UgcVideo.STATUS_IDLE;
          }
          localUgcVideo.compressProgress = 0;
          localArrayList.add(localUgcVideo);
        }
      }
    }
    catch (Exception localException)
    {
      ArrayList localArrayList;
      for (;;)
      {
        QLog.e("RIJUGC.RIJUgcVideoPublishManager", 1, "loadFromDB error," + localException.toString());
        Object localObject2 = null;
      }
      ThreadManagerV2.getUIHandlerV2().post(new RIJUgcVideoPublishManager.8.1(this, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.8
 * JD-Core Version:    0.7.0.1
 */