package com.tencent.biz.qqstory.playvideo.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

public class VideoViewTextureImpl
  implements IVideoView
{
  StoryPlayerTVKWrapper.ReportData jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData = new StoryPlayerTVKWrapper.ReportData();
  TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private String jdField_a_of_type_JavaLangString = "VideoViewTextureImpl";
  
  public VideoViewTextureImpl(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = new TextureVideoView(paramContext.getApplicationContext());
    paramContext = new StringBuilder();
    paramContext.append(this.jdField_a_of_type_JavaLangString);
    paramContext.append(paramString);
    this.jdField_a_of_type_JavaLangString = paramContext.toString();
  }
  
  public int a()
  {
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  }
  
  public StoryPlayerTVKWrapper.ReportData a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData;
  }
  
  public void a()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "stopPlayback");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
  }
  
  @TargetApi(14)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(paramInt);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramOnCompletionListener == null) {
      paramOnCompletionListener = null;
    } else {
      paramOnCompletionListener = new VideoViewTextureImpl.1(this, paramOnCompletionListener);
    }
    localTextureVideoView.setOnCompletionListener(paramOnCompletionListener);
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener) {}
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    Object localObject = null;
    if (paramOnErrorListener == null) {
      paramOnErrorListener = localObject;
    } else {
      paramOnErrorListener = new VideoViewTextureImpl.2(this, paramOnErrorListener, null);
    }
    localTextureVideoView.setOnErrorListener(paramOnErrorListener);
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramOnInfoListener == null) {
      paramOnInfoListener = null;
    } else {
      paramOnInfoListener = new VideoViewTextureImpl.3(this, paramOnInfoListener);
    }
    localTextureVideoView.setOnInfoListener(paramOnInfoListener);
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    TextureVideoView localTextureVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
    if (paramOnPreparedListener == null) {
      paramOnPreparedListener = null;
    } else {
      paramOnPreparedListener = new VideoViewTextureImpl.4(this, paramOnPreparedListener);
    }
    localTextureVideoView.setOnPreparedListener(paramOnPreparedListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    StoryPlayerTVKWrapper.ReportData localReportData = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData;
    localReportData.jdField_a_of_type_JavaLangString = paramString1;
    localReportData.jdField_a_of_type_Boolean = true;
    if ((TextUtils.isEmpty(paramString2)) || (!FileCacheUtils.a(new File(paramString2)))) {
      paramString2 = paramString3;
    }
    SLog.d(this.jdField_a_of_type_JavaLangString, "setVideoPath");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(paramString2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying();
  }
  
  public int b()
  {
    return 1;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration();
  }
  
  public void b()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "start");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
  }
  
  public void c()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "pause");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
  }
  
  public void d()
  {
    SLog.d(this.jdField_a_of_type_JavaLangString, "restart");
    b();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTextureImpl
 * JD-Core Version:    0.7.0.1
 */