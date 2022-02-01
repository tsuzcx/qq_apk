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
    AVPreloadTaskManager.a(this.this$0).a(this.a, this.b.getTPPlatform(), this.b.getTPPlayerGuid());
    ThreadCenter.postUITask(this.this$0, new AVPreloadTaskManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadTaskManager.1
 * JD-Core Version:    0.7.0.1
 */