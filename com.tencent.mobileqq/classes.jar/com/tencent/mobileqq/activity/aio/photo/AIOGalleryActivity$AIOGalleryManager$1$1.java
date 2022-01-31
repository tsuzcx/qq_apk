package com.tencent.mobileqq.activity.aio.photo;

import aegg;
import aegh;
import aegs;
import aeid;
import com.tencent.qphone.base.util.QLog;

public class AIOGalleryActivity$AIOGalleryManager$1$1
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$1(aegh paramaegh, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (aegg.a(this.jdField_a_of_type_Aegh.a) != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("peak_pgjpeg", 4, "IAIOImageProviderCallBack.notifyImageResult():isPart " + this.jdField_a_of_type_Boolean);
      }
      ((aegs)aegg.b(this.jdField_a_of_type_Aegh.a)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Aegh.a.a != null) {
      ((aeid)this.jdField_a_of_type_Aegh.a.a).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.1
 * JD-Core Version:    0.7.0.1
 */