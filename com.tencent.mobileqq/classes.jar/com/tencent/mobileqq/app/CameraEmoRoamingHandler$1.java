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
    ((ICameraEmoRoamingManagerService)this.this$0.a.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).updateListVersion(this.jdField_a_of_type_JavaLangString);
    ((ICameraEmotionRoamingDBManagerService)this.this$0.a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class, "")).updateLocalDBFromServer(this.jdField_a_of_type_JavaUtilList, this.b, this.c);
    EmoticonOperateReport.reportEmoticonOperateMonitorDeleteStatus("0", 2);
    this.this$0.a(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.1
 * JD-Core Version:    0.7.0.1
 */