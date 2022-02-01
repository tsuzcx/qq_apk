package com.tencent.ilive.audiencepages.room.pagelogic.controller;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.accountengine.UserInitStateCallback;

class AudienceRoomController$DefaultUserInitStateCallback
  implements UserInitStateCallback
{
  public boolean a;
  public boolean b;
  
  AudienceRoomController$DefaultUserInitStateCallback(AudienceRoomController paramAudienceRoomController) {}
  
  public void onAvInitFail() {}
  
  public void onAvInitSucceed() {}
  
  public void onLoginFail(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doEnterRoom -login busy -to-  login onFail-errCode=");
    localStringBuilder.append(paramInt);
    ((LogInterface)localObject).e("RoomController", localStringBuilder.toString(), new Object[0]);
    if (this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.isPageExit) {
      return;
    }
    if ((AudienceRoomController.access$800(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController) != null) && (!AudienceRoomController.access$800(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController).isLiteSdk))
    {
      localObject = this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController;
      AudienceRoomController.access$1000((AudienceRoomController)localObject, "进房失败：鉴权失败", AudienceRoomController.access$900((AudienceRoomController)localObject));
    }
    AudienceRoomController.access$1100(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController).reportLoginFail(paramInt);
  }
  
  public void onLoginSucceed()
  {
    this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.getLog().i("RoomController", "doEnterRoom -login busy -to- login success", new Object[0]);
    if (this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController.isPageExit) {
      return;
    }
    AudienceRoomController.access$600(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController).reportLoginSuc();
    if (this.jdField_a_of_type_Boolean) {
      AudienceRoomController.access$700(this.jdField_a_of_type_ComTencentIliveAudiencepagesRoomPagelogicControllerAudienceRoomController, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.controller.AudienceRoomController.DefaultUserInitStateCallback
 * JD-Core Version:    0.7.0.1
 */