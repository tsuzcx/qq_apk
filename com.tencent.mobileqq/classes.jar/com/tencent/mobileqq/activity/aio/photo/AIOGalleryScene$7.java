package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import java.util.Locale;

class AIOGalleryScene$7
  implements MessageQueue.IdleHandler
{
  AIOGalleryScene$7(AIOGalleryScene paramAIOGalleryScene) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localObject != null) && (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).a;
      if ((localAIOImageData != null) && (localAIOImageData.a(4)) && (localAIOImageData.a(4) == null))
      {
        this.a.d(true);
        this.a.u();
      }
    }
    if ((localObject != null) && (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).a)))
    {
      localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).a;
      if ((localObject != null) && (((AIOFilePicData)localObject).a(20)) && (((AIOFilePicData)localObject).a(20) == null))
      {
        if ((((AIOFilePicData)localObject).d) && (MessageRecordInfo.a(((AIOFilePicData)localObject).b)))
        {
          this.a.d(true);
          this.a.c(false);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
        }
        else if (((AIOFilePicData)localObject).e)
        {
          this.a.d(false);
        }
        else
        {
          this.a.d(true);
        }
        if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, AIOGalleryScene.d(this.a).getString(2131694999), new Object[] { FileUtil.a(((AIOFilePicData)localObject).a) }));
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.7
 * JD-Core Version:    0.7.0.1
 */