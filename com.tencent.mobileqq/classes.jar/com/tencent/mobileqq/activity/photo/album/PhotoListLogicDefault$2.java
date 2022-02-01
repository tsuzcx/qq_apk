package com.tencent.mobileqq.activity.photo.album;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class PhotoListLogicDefault$2
  implements Runnable
{
  PhotoListLogicDefault$2(PhotoListLogicDefault paramPhotoListLogicDefault, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.a.jdField_a_of_type_JavaUtilHashMap, this.this$0.mPhotoCommonData.currentQualityType, false);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.b = System.currentTimeMillis();
      return;
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, this.this$0.mPhotoCommonData.currentQualityType, this.this$0.a.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.2
 * JD-Core Version:    0.7.0.1
 */