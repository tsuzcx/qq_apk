package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import qbu;
import qqi;
import qql;
import qty;

public class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  public VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4(qqi paramqqi, qql paramqql) {}
  
  public void run()
  {
    if ((!VideoFeedsPlayManager.a(this.jdField_a_of_type_Qqi.a, this.jdField_a_of_type_Qql)) || (VideoFeedsPlayManager.a(this.jdField_a_of_type_Qqi.a, this.jdField_a_of_type_Qql) == null)) {
      return;
    }
    Properties localProperties = this.jdField_a_of_type_Qql.jdField_a_of_type_Qty.a().getPlayDetailsTime();
    this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.f = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.g = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.h = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    if (1 == this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.a) {
      this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.i = Long.valueOf(localProperties.getProperty("vidtourlMS")).longValue();
    }
    this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.k = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    this.jdField_a_of_type_Qql.jdField_a_of_type_Qbu.l = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */