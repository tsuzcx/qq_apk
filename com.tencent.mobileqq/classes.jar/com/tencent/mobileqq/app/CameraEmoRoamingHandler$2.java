package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

class CameraEmoRoamingHandler$2
  implements Runnable
{
  CameraEmoRoamingHandler$2(CameraEmoRoamingHandler paramCameraEmoRoamingHandler, String paramString, List paramList1, List paramList2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_IMG_CAMERA_EMO);
    localStringBuilder.append(".nomedia");
    FileUtils.createFileIfNotExits(localStringBuilder.toString());
    ((ICameraEmoRoamingManagerService)this.this$0.a.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).updateListVersion(this.jdField_a_of_type_JavaLangString);
    ((ICameraEmotionRoamingDBManagerService)this.this$0.a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class, "")).updateLocalDBFromServer(this.jdField_a_of_type_JavaUtilList, this.b, null);
    this.this$0.a(2, true, 0);
    EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus("0", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.2
 * JD-Core Version:    0.7.0.1
 */