package com.tencent.mobileqq.app;

import anrf;
import aseg;
import asen;
import awyr;
import java.util.List;

public class CameraEmoRoamingHandler$1
  implements Runnable
{
  public CameraEmoRoamingHandler$1(anrf paramanrf, String paramString, List paramList1, List paramList2, List paramList3) {}
  
  public void run()
  {
    ((aseg)this.this$0.app.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    ((asen)this.this$0.app.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER)).a(this.jdField_a_of_type_JavaUtilList, this.b, this.c);
    awyr.d("0", 2);
    this.this$0.a(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.1
 * JD-Core Version:    0.7.0.1
 */