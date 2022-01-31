package com.tencent.biz.qqstory.playvideo.player;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import nny;

public class VideoViewFactory
{
  static volatile VideoViewFactory jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewFactory;
  Context jdField_a_of_type_AndroidContentContext;
  TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  public boolean a;
  
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
  
  public static void a(Context paramContext)
  {
    TVK_SDKMgr.setOnLogListener(new nny(null));
    TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
  }
  
  public IVideoView a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Boolean = false;
      return new VideoViewTextureImpl(this.jdField_a_of_type_AndroidContentContext);
    case 1: 
      this.jdField_a_of_type_Boolean = false;
      return new VideoViewTextureImpl(this.jdField_a_of_type_AndroidContentContext);
    }
    if (!TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext)) {
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_Boolean = true;
      return new VideoViewTVKImpl(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_Boolean = false;
    return new VideoViewTextureImpl(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(20161223);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewFactory
 * JD-Core Version:    0.7.0.1
 */