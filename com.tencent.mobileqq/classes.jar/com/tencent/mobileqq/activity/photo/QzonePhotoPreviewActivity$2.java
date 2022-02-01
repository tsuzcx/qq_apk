package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzonePhotoPreviewActivity$2
  implements View.OnClickListener
{
  QzonePhotoPreviewActivity$2(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = QzonePhotoPreviewActivity.a(this.a);
    localIntent.putExtra("PhotoConst.send_changtu", true);
    localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    localIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    PhotoUtils.sendPhoto(this.a.getBaseActivity(), QzonePhotoPreviewActivity.a(this.a), this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_Int, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */