package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;
import java.util.ArrayList;

class PhotoListPanel$5
  implements Runnable
{
  PhotoListPanel$5(PhotoListPanel paramPhotoListPanel, Pair paramPair, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((!((ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first).isEmpty()) || (!((ArrayList)this.jdField_a_of_type_ComTencentUtilPair.second).isEmpty()))
    {
      this.this$0.a(this.jdField_a_of_type_ComTencentUtilPair, this.jdField_a_of_type_Boolean);
      com.tencent.mobileqq.shortvideo.SVBusiUtil.b = System.currentTimeMillis();
    }
    String str = this.jdField_a_of_type_JavaLangString;
    ReportController.b(null, "CliOper", "", "", str, str, 0, 0, this.b, this.c, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.5
 * JD-Core Version:    0.7.0.1
 */