package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RIJUgcVideoPublishManager$8$1
  implements Runnable
{
  RIJUgcVideoPublishManager$8$1(RIJUgcVideoPublishManager.8 param8, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
      if (!RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0).contains(localUgcVideo)) {
        RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0).add(localUgcVideo);
      }
    }
    RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0, true);
    localIterator = RIJUgcVideoPublishManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0).iterator();
    while (localIterator.hasNext()) {
      ((RIJUgcVideoPublishManager.ILoadDBCallback)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.8.1
 * JD-Core Version:    0.7.0.1
 */