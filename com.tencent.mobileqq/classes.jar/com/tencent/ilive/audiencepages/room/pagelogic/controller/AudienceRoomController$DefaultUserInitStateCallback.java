package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.accountengine.UserInitStateCallback;

class AudienceRoomController$DefaultUserInitStateCallback
  implements UserInitStateCallback
{
  public boolean a;
  
  AudienceRoomController$DefaultUserInitStateCallback(AudienceRoomController paramAudienceRoomController) {}
  
  public void onAvInitFail() {}
  
  public void onAvInitSucceed() {}
  
  public void onLoginFail(int paramInt)
  {
    this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.getLog().e("RoomController", "doEnterRoom -login busy -to-  login onFail-errCode=" + paramInt, new Object[0]);
    if (this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.isPageExit) {
      return;
    }
    if ((AudienceRoomController.access$700(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController) != null) && (!AudienceRoomController.access$700(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController).isLiteSdk)) {
      AudienceRoomController.access$900(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController, "进房失败：鉴权失败", AudienceRoomController.access$800(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController));
    }
    AudienceRoomController.access$1000(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController).reportLoginFail(paramInt);
  }
  
  public void onLoginSucceed()
  {
    this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.getLog().i("RoomController", "doEnterRoom -login busy -to- login success", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.isPageExit) {}
    do
    {
      return;
      AudienceRoomController.access$500(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController).reportLoginSuc();
    } while (!this.jdField_a_of_type_Boolean);
    AudienceRoomController.access$600(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.DefaultUserInitStateCallback
 * JD-Core Version:    0.7.0.1
 */