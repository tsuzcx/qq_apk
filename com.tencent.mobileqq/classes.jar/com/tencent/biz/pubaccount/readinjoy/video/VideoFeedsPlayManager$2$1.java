package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import rfs;
import rjn;

class VideoFeedsPlayManager$2$1
  implements Runnable
{
  VideoFeedsPlayManager$2$1(VideoFeedsPlayManager.2 param2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Rfs.jdField_a_of_type_AndroidViewView != null)) {
      this.a.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.a((IVideoViewBase)this.a.jdField_a_of_type_Rfs.jdField_a_of_type_AndroidViewView);
    }
    VideoFeedsPlayManager.b(this.a.this$0, this.a.jdField_a_of_type_Rfs, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.2.1
 * JD-Core Version:    0.7.0.1
 */