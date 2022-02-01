package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.Locale;

class AIOGalleryScene$25
  implements AIOGalleryAdapter.OnTroopThumbListener
{
  AIOGalleryScene$25(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void a(AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a instanceof AIOImageData)))
    {
      AIOImageData localAIOImageData = (AIOImageData)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a;
      if ((!paramBoolean) && (TextUtils.equals(localAIOImageData.jdField_h_of_type_JavaLangString, paramAIOImageData.jdField_h_of_type_JavaLangString)))
      {
        if (localAIOImageData.jdField_h_of_type_Long <= 0L) {
          break label127;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, AIOGalleryScene.N(this.a).getString(2131695009), new Object[] { FileUtil.a(localAIOImageData.jdField_h_of_type_Long) }));
      }
    }
    for (;;)
    {
      this.a.c(true);
      return;
      label127:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.25
 * JD-Core Version:    0.7.0.1
 */