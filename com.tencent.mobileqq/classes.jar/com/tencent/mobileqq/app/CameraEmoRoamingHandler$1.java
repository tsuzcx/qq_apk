package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import java.util.List;

class CameraEmoRoamingHandler$1
  implements Runnable
{
  CameraEmoRoamingHandler$1(CameraEmoRoamingHandler paramCameraEmoRoamingHandler, String paramString, List paramList1, List paramList2, List paramList3) {}
  
  public void run()
  {
    ((ICameraEmoRoamingManagerService)this.this$0.b.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).updateListVersion(this.a);
    ((ICameraEmotionRoamingDBManagerService)this.this$0.b.getRuntimeService(ICameraEmotionRoamingDBManagerService.class, "")).updateLocalDBFromServer(this.b, this.c, this.d);
    EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("0", 2);
    this.this$0.a(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.1
 * JD-Core Version:    0.7.0.1
 */