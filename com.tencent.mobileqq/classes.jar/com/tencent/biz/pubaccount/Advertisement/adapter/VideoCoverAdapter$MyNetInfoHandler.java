package com.tencent.biz.pubaccount.Advertisement.adapter;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class VideoCoverAdapter$MyNetInfoHandler
  implements INetInfoHandler
{
  private VideoCoverAdapter$MyNetInfoHandler(VideoCoverAdapter paramVideoCoverAdapter) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "net from mobile to none");
    }
    VideoCoverAdapter.d(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "net from mobile to wifi");
    }
    VideoCoverAdapter.a(this.a, false);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "net from none to mobile");
    }
    if (!VideoCoverAdapter.c(this.a))
    {
      paramString = this.a.e();
      if ((paramString != null) && (paramString.isPlaying()))
      {
        this.a.c();
        this.a.d();
      }
      VideoCoverAdapter.a(this.a, true);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "net from none to wifi");
    }
    VideoCoverAdapter.a(this.a, false);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "net from wifi to mobile");
    }
    if (!VideoCoverAdapter.c(this.a))
    {
      paramString = this.a.e();
      if ((paramString != null) && (paramString.isPlaying()))
      {
        this.a.c();
        this.a.d();
      }
      VideoCoverAdapter.a(this.a, true);
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCoverAdapter", 2, "net from wifi to none");
    }
    VideoCoverAdapter.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */