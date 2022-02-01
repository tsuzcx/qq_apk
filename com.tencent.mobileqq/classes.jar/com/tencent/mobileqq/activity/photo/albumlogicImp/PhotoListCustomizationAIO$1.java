package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class PhotoListCustomizationAIO$1
  implements Runnable
{
  PhotoListCustomizationAIO$1(PhotoListCustomizationAIO paramPhotoListCustomizationAIO, boolean paramBoolean, Intent paramIntent, ArrayList paramArrayList, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      ((IAlbumUtils)QRoute.api(IAlbumUtils.class)).sendPhoto(PhotoListCustomizationAIO.a(this.this$0), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, PhotoListCustomizationAIO.a(this.this$0).jdField_a_of_type_JavaUtilHashMap, ((PhotoOtherData)this.this$0.a).jdField_a_of_type_Int, false);
    } else {
      PhotoUtils.sendPhoto(PhotoListCustomizationAIO.b(this.this$0), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, ((PhotoOtherData)this.this$0.a).jdField_a_of_type_Int, PhotoListCustomizationAIO.b(this.this$0).jdField_a_of_type_Boolean);
    }
    ReportController.b(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, this.b, "", "");
    com.tencent.mobileqq.shortvideo.SVBusiUtil.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO.1
 * JD-Core Version:    0.7.0.1
 */