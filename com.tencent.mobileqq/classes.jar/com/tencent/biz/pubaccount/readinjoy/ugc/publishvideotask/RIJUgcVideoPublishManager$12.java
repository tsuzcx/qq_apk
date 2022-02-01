package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.IUploadActionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class RIJUgcVideoPublishManager$12
  implements RIJUgcUtils.IUploadActionCallback
{
  RIJUgcVideoPublishManager$12(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
        if (localUgcVideo.pauseBySwitchNet)
        {
          localUgcVideo.pauseBySwitchNet = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager.a(localUgcVideo, true);
        }
      }
    }
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "showMobileNetworkDialog, isContinue=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.12
 * JD-Core Version:    0.7.0.1
 */