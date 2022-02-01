package com.tencent.biz.pubaccount.Advertisement.view;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class VideoCoverView$6
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  VideoCoverView$6(VideoCoverView paramVideoCoverView) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverView", 2, "is prepare");
    }
    if (VideoCoverView.a(this.a) == 1) {
      com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    ReportController.a(null, "dc00898", "", VideoCoverView.a(this.a).a.jdField_a_of_type_JavaLangString, "0X8008F64", "0X8008F64", 0, 0, VideoCoverView.a(this.a).a.c, "", this.a.jdField_a_of_type_JavaLangString, VideoCoverView.a(this.a).a.b);
    AdvertisementStatistics.a().b(this.a.jdField_a_of_type_JavaLangString, VideoCoverView.a(this.a));
    this.a.jdField_a_of_type_Long = VideoCoverView.a(this.a).getDuration();
    if ((this.a.jdField_a_of_type_Int == 3) || (this.a.jdField_a_of_type_Int == 4))
    {
      VideoCoverView.a(this.a).start();
      this.a.jdField_a_of_type_Int = 4;
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.6
 * JD-Core Version:    0.7.0.1
 */