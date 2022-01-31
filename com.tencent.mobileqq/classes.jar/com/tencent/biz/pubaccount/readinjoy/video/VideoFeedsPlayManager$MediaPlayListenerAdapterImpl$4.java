package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import qbx;
import qql;
import qqo;
import qub;

public class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  public VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4(qql paramqql, qqo paramqqo) {}
  
  public void run()
  {
    if ((!VideoFeedsPlayManager.a(this.jdField_a_of_type_Qql.a, this.jdField_a_of_type_Qqo)) || (VideoFeedsPlayManager.a(this.jdField_a_of_type_Qql.a, this.jdField_a_of_type_Qqo) == null)) {
      return;
    }
    Properties localProperties = this.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.a().getPlayDetailsTime();
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.f = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.g = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.h = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    if (1 == this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.a) {
      this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.i = Long.valueOf(localProperties.getProperty("vidtourlMS")).longValue();
    }
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.k = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    this.jdField_a_of_type_Qqo.jdField_a_of_type_Qbx.l = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */