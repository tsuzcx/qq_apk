package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

public class VideoDrawableHandler$DecodeFrameTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  
  public VideoDrawableHandler$DecodeFrameTask(VideoDrawableHandler paramVideoDrawableHandler, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @TargetApi(10)
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_Int);
    int i;
    if (localBitmap == null)
    {
      localBitmap = VideoDrawableHandler.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler);
      if (localBitmap == null) {
        i = 2;
      }
    }
    for (;;)
    {
      if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap != localBitmap)) {}
      for (;;)
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.b = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0).sendToTarget();
          if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener.a(this.jdField_a_of_type_Int, i);
          }
          if (QLog.isColorLevel()) {
            QLog.i("VideoDrawableHandler", 2, "task run at:" + this.jdField_a_of_type_Int + " bmp:" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0).sendToTarget();
      }
      i = 1;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.DecodeFrameTask
 * JD-Core Version:    0.7.0.1
 */