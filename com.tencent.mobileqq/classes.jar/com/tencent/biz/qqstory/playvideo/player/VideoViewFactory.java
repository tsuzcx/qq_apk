package com.tencent.biz.qqstory.playvideo.player;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class VideoViewFactory
{
  static volatile VideoViewFactory a;
  Context b;
  VideoViewFactory.TVKSDKOnLogListener c;
  
  private VideoViewFactory(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  public static VideoViewFactory a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VideoViewFactory(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(null);
  }
  
  public VideoViewFactory.TVKSDKOnLogListener b()
  {
    if (this.c == null) {
      this.c = new VideoViewFactory.TVKSDKOnLogListener();
    }
    return this.c;
  }
  
  public void b(Context paramContext)
  {
    TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
  }
  
  public void c()
  {
    TVK_SDKMgr.setOnLogListener(b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewFactory
 * JD-Core Version:    0.7.0.1
 */