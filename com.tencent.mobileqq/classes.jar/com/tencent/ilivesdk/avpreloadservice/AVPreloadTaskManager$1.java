package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.utils.ThreadCenter;

class AVPreloadTaskManager$1
  implements Runnable
{
  AVPreloadTaskManager$1(AVPreloadTaskManager paramAVPreloadTaskManager, Context paramContext, AppGeneralInfoService paramAppGeneralInfoService, AVPreloadTaskManager.DLProxyInitCompletedListener paramDLProxyInitCompletedListener) {}
  
  public void run()
  {
    AVPreloadTaskManager.a(this.this$0).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.getTPPlatform(), this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.getTPPlayerGuid());
    ThreadCenter.postUITask(this.this$0, new AVPreloadTaskManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager.1
 * JD-Core Version:    0.7.0.1
 */