package com.tencent.biz.qqstory.playvideo.player;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class VideoViewFactory
{
  static volatile VideoViewFactory jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory = null;
  Context jdField_a_of_type_AndroidContentContext;
  VideoViewFactory.TVKSDKOnLogListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory$TVKSDKOnLogListener;
  
  private VideoViewFactory(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static VideoViewFactory a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory == null) {
        jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory = new VideoViewFactory(paramContext);
      }
      return jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory;
    }
    finally {}
  }
  
  public VideoViewFactory.TVKSDKOnLogListener a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory$TVKSDKOnLogListener == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory$TVKSDKOnLogListener = new VideoViewFactory.TVKSDKOnLogListener();
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory$TVKSDKOnLogListener;
  }
  
  public void a()
  {
    TVK_SDKMgr.setOnLogListener(a());
  }
  
  public void a(Context paramContext)
  {
    TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
  }
  
  public boolean a()
  {
    return TVK_SDKMgr.isInstalled(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewFactory
 * JD-Core Version:    0.7.0.1
 */