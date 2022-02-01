package com.tencent.mobileqq.app;

import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmotionRoamingDBManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

class CameraEmoRoamingHandler$2
  implements Runnable
{
  CameraEmoRoamingHandler$2(CameraEmoRoamingHandler paramCameraEmoRoamingHandler, String paramString, List paramList1, List paramList2) {}
  
  public void run()
  {
    FileUtils.c(AppConstants.SDCARD_IMG_CAMERA_EMO + ".nomedia");
    ((CameraEmoRoamingManager)this.this$0.a.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    ((CameraEmotionRoamingDBManager)this.this$0.a.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER)).a(this.jdField_a_of_type_JavaUtilList, this.b, null);
    this.this$0.a(2, true, 0);
    EmoticonManager.e("0", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.2
 * JD-Core Version:    0.7.0.1
 */