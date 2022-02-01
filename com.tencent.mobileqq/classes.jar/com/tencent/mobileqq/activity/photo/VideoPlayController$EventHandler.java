package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VideoPlayController$EventHandler
  extends Handler
{
  private VideoPlayController$EventHandler(VideoPlayController paramVideoPlayController) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    StringBuilder localStringBuilder;
    if (i != 100)
    {
      if (i != 200)
      {
        switch (i)
        {
        default: 
          return;
        case 7: 
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDownloading isClickToStart=");
            localStringBuilder.append(VideoPlayController.a(this.a));
            QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener != null) && (VideoPlayController.a(this.a)))
          {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo, paramMessage.arg1);
            if (VideoPlayController.a(this.a) != 4) {
              this.a.b(8);
            }
          }
          return;
        case 6: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
          }
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper != null) && (this.a.jdField_a_of_type_AndroidAppActivity != null))
          {
            paramMessage = this.a;
            paramMessage.jdField_a_of_type_AndroidViewView = paramMessage.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(this.a.jdField_a_of_type_AndroidAppActivity);
            if ((this.a.jdField_a_of_type_AndroidViewView != null) && (this.a.jdField_a_of_type_AndroidAppActivity != null))
            {
              paramMessage = this.a;
              VideoPlayController.a(paramMessage, paramMessage.jdField_a_of_type_AndroidAppActivity);
            }
          }
          return;
        case 5: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
          }
          return;
        case 4: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.v();
          }
        case 3: 
          return;
        case 2: 
          if (QLog.isColorLevel()) {
            QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
          }
          VideoPlayController.a(this.a, true);
          this.a.a(0);
          this.a.b(0);
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo);
          }
          VideoPlayController.a(this.a, 0);
          return;
        case 1: 
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("onPrepared  getAutoPlayFlag=");
            paramMessage.append(this.a.a());
            QLog.d("carverW VideoPlayController", 2, paramMessage.toString());
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo, this.a.b());
          }
          if (this.a.a())
          {
            this.a.l();
            this.a.a(false);
            return;
          }
          VideoPlayController.a(this.a, 3);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "MEDIA_PREPAREING ");
        }
        VideoPlayController.a(this.a, 2);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener != null)
      {
        if (paramMessage.arg1 == 929)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo);
          this.a.b(8);
          return;
        }
        if (paramMessage.arg1 == 92) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo, paramMessage.arg2);
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error (");
      localStringBuilder.append(paramMessage.arg1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramMessage.arg2);
      localStringBuilder.append(")");
      QLog.d("carverW VideoPlayController", 2, localStringBuilder.toString());
    }
    this.a.a(paramMessage.arg1, paramMessage.arg2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayController.EventHandler
 * JD-Core Version:    0.7.0.1
 */