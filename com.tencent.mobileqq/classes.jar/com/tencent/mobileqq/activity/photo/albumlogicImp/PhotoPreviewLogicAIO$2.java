package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;
import java.util.ArrayList;

class PhotoPreviewLogicAIO$2
  implements Runnable
{
  PhotoPreviewLogicAIO$2(PhotoPreviewLogicAIO paramPhotoPreviewLogicAIO, boolean paramBoolean, Intent paramIntent, Pair paramPair, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, PhotoPreviewLogicAIO.a(this.this$0).b, PhotoPreviewLogicAIO.a(this.this$0).currentQualityType, true);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).setResult(-1);
      ((NewPhotoPreviewActivity)this.this$0.mActivity).finish();
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X8009AB1", "0X8009AB1", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
      com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.b = System.currentTimeMillis();
      return;
      PhotoUtils.sendPhoto(this.this$0.mActivity, this.jdField_a_of_type_AndroidContentIntent, (ArrayList)this.jdField_a_of_type_ComTencentUtilPair.first, PhotoPreviewLogicAIO.b(this.this$0).currentQualityType, PhotoPreviewLogicAIO.b(this.this$0).jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAIO.2
 * JD-Core Version:    0.7.0.1
 */