package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qun;
import quw;

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
      if (!qun.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0).contains(localUgcVideo)) {
        qun.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0).add(localUgcVideo);
      }
    }
    qun.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0, true);
    localIterator = qun.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcPublishvideotaskRIJUgcVideoPublishManager$8.this$0).iterator();
    while (localIterator.hasNext()) {
      ((quw)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.8.1
 * JD-Core Version:    0.7.0.1
 */