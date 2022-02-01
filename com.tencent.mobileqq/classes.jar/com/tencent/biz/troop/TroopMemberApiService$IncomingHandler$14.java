package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IVideoPublishCallback;

class TroopMemberApiService$IncomingHandler$14
  implements RIJUgcVideoPublishManager.IVideoPublishCallback
{
  TroopMemberApiService$IncomingHandler$14(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle) {}
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (paramUgcVideo.fromForReport == 4)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("video_cover_path", paramUgcVideo.coverUrl);
      TroopMemberApiService.IncomingHandler.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler, 161, this.jdField_a_of_type_AndroidOsBundle, 0, "success");
      RIJUgcVideoPublishManager.a(RIJQQAppInterfaceUtil.a()).b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.14
 * JD-Core Version:    0.7.0.1
 */