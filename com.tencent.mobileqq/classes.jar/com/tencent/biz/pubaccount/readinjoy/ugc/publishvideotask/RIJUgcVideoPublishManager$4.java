package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;

class RIJUgcVideoPublishManager$4
  implements IPublishTaskCallback
{
  RIJUgcVideoPublishManager$4(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.getProgress();
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 2, "uploadCallback: taskType = " + paramInt + ",isSuccess = " + paramBoolean1 + "isFinish = " + paramBoolean2 + "errorMsg = " + paramString + "progress = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.4
 * JD-Core Version:    0.7.0.1
 */