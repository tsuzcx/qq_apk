package com.tencent.mobileqq.app;

import anrf;
import aseg;
import asen;
import awyr;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

public class CameraEmoRoamingHandler$2
  implements Runnable
{
  public CameraEmoRoamingHandler$2(anrf paramanrf, String paramString, List paramList1, List paramList2) {}
  
  public void run()
  {
    FileUtils.createFileIfNotExits(AppConstants.SDCARD_IMG_CAMERA_EMO + ".nomedia");
    ((aseg)this.this$0.app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    ((asen)this.this$0.app.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER)).a(this.jdField_a_of_type_JavaUtilList, this.b, null);
    this.this$0.a(2, true, 0);
    awyr.e("0", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.2
 * JD-Core Version:    0.7.0.1
 */