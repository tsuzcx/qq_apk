package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IVideoPublishCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;

class TroopMemberApiService$IncomingHandler$14
  implements IRIJUgcVideoPublishService.IVideoPublishCallback
{
  TroopMemberApiService$IncomingHandler$14(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle, QQAppInterface paramQQAppInterface) {}
  
  public void a(UgcVideo paramUgcVideo)
  {
    if (paramUgcVideo.fromForReport == 4)
    {
      this.jdField_a_of_type_AndroidOsBundle.putString("video_cover_path", paramUgcVideo.coverUrl);
      TroopMemberApiService.IncomingHandler.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler, 161, this.jdField_a_of_type_AndroidOsBundle, 0, "success");
      paramUgcVideo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramUgcVideo != null) {
        ((IRIJUgcVideoPublishService)paramUgcVideo.getRuntimeService(IRIJUgcVideoPublishService.class)).removeVideoPublishCallback(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.14
 * JD-Core Version:    0.7.0.1
 */