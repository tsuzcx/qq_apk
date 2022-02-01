package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.statistics.ReportController;

class PhotoListLogicDataline$1
  implements Runnable
{
  PhotoListLogicDataline$1(PhotoListLogicDataline paramPhotoListLogicDataline, Intent paramIntent, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, PhotoListLogicDataline.a(this.this$0).selectedPhotoList);
    ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicDataline.1
 * JD-Core Version:    0.7.0.1
 */