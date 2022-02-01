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
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "MEDIA_PREPAREING ");
                    }
                    VideoPlayController.a(this.a, 2);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onPrepared  getAutoPlayFlag=" + this.a.a());
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
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
                    }
                  } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener == null);
                  this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.v();
                  return;
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
                } while (!QLog.isColorLevel());
                QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
                }
              } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
              this.a.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaPlayHelper.a(this.a.jdField_a_of_type_AndroidAppActivity);
            } while ((this.a.jdField_a_of_type_AndroidViewView == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
            VideoPlayController.a(this.a, this.a.jdField_a_of_type_AndroidAppActivity);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("carverW VideoPlayController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
            }
            this.a.a(paramMessage.arg1, paramMessage.arg2);
            return;
          } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener == null);
          if (paramMessage.arg1 == 929)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.d(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo);
            this.a.b(8);
            return;
          }
        } while (paramMessage.arg1 != 92);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo, paramMessage.arg2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onDownloading isClickToStart=" + VideoPlayController.a(this.a));
        }
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener == null) || (!VideoPlayController.a(this.a)));
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayController$VideoPlayerStateListener.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayMedioInfo, paramMessage.arg1);
    } while (VideoPlayController.a(this.a) == 4);
    this.a.b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayController.EventHandler
 * JD-Core Version:    0.7.0.1
 */