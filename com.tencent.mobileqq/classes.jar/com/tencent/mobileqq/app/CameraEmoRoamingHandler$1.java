package com.tencent.mobileqq.app;

import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmotionRoamingDBManager;
import com.tencent.mobileqq.model.EmoticonManager;
import java.util.List;

class CameraEmoRoamingHandler$1
  implements Runnable
{
  CameraEmoRoamingHandler$1(CameraEmoRoamingHandler paramCameraEmoRoamingHandler, String paramString, List paramList1, List paramList2, List paramList3) {}
  
  public void run()
  {
    ((CameraEmoRoamingManager)this.this$0.a.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    ((CameraEmotionRoamingDBManager)this.this$0.a.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER)).a(this.jdField_a_of_type_JavaUtilList, this.b, this.c);
    EmoticonManager.d("0", 2);
    this.this$0.a(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.1
 * JD-Core Version:    0.7.0.1
 */