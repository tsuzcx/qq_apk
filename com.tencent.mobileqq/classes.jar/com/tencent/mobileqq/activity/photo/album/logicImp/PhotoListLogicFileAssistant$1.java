package com.tencent.mobileqq.activity.photo.album.logicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.statistics.ReportController;

class PhotoListLogicFileAssistant$1
  implements Runnable
{
  PhotoListLogicFileAssistant$1(PhotoListLogicFileAssistant paramPhotoListLogicFileAssistant, Intent paramIntent, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.this$0.a(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, PhotoListLogicFileAssistant.a(this.this$0).selectedPhotoList);
    ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicFileAssistant.1
 * JD-Core Version:    0.7.0.1
 */