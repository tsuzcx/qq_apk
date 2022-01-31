package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Properties;
import pqb;
import qen;
import qeq;
import qhw;

public class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4
  implements Runnable
{
  public VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$4(qen paramqen, qeq paramqeq) {}
  
  public void run()
  {
    if ((!VideoFeedsPlayManager.a(this.jdField_a_of_type_Qen.a, this.jdField_a_of_type_Qeq)) || (VideoFeedsPlayManager.a(this.jdField_a_of_type_Qen.a, this.jdField_a_of_type_Qeq) == null)) {
      return;
    }
    Properties localProperties = this.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.a().getPlayDetailsTime();
    this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.f = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.g = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.h = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    if (1 == this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.a) {
      this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.i = Long.valueOf(localProperties.getProperty("vidtourlMS")).longValue();
    }
    this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.j = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.k = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    this.jdField_a_of_type_Qeq.jdField_a_of_type_Pqb.l = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.4
 * JD-Core Version:    0.7.0.1
 */