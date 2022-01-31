package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import qlq;
import rfp;
import rfs;
import rjn;

public class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  public VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4(rfp paramrfp, rfs paramrfs) {}
  
  public void run()
  {
    if ((!VideoFeedsPlayManager.a(this.jdField_a_of_type_Rfp.a, this.jdField_a_of_type_Rfs)) || (VideoFeedsPlayManager.a(this.jdField_a_of_type_Rfp.a, this.jdField_a_of_type_Rfs) == null)) {
      return;
    }
    Properties localProperties = this.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.a().getPlayDetailsTime();
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.f = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.g = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.h = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    if (1 == this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.a) {
      this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.i = Long.valueOf(localProperties.getProperty("vidtourlMS")).longValue();
    }
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.k = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    this.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.l = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */