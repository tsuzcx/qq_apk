package com.tencent.biz.qqstory.playvideo.player;

import android.view.View;

public class ProgressVideoViewWrapper
  implements IVideoView
{
  private IVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView;
  private ProgressVideoViewWrapper.OnErrorListenerWrapper jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$OnErrorListenerWrapper = new ProgressVideoViewWrapper.OnErrorListenerWrapper(this, null);
  private ProgressVideoViewWrapper.OnInfoListenerWrapper jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$OnInfoListenerWrapper = new ProgressVideoViewWrapper.OnInfoListenerWrapper(this, null);
  private ProgressVideoViewWrapper.OnPreparedListenerWrapper jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$OnPreparedListenerWrapper = new ProgressVideoViewWrapper.OnPreparedListenerWrapper(this, null);
  private ProgressVideoViewWrapper.ProgressListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$ProgressListener;
  
  public ProgressVideoViewWrapper(IVideoView paramIVideoView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = paramIVideoView;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
  
  public IVideoView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView;
  }
  
  public StoryPlayerTVKWrapper.ReportData a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(paramInt);
  }
  
  public void a(IVideoView.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(paramOnCompletionListener);
  }
  
  public void a(IVideoView.OnDownloadListener paramOnDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(paramOnDownloadListener);
  }
  
  public void a(IVideoView.OnErrorListener paramOnErrorListener)
  {
    ProgressVideoViewWrapper.OnErrorListenerWrapper localOnErrorListenerWrapper = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$OnErrorListenerWrapper;
    localOnErrorListenerWrapper.a = paramOnErrorListener;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(localOnErrorListenerWrapper);
  }
  
  public void a(IVideoView.OnInfoListener paramOnInfoListener)
  {
    ProgressVideoViewWrapper.OnInfoListenerWrapper localOnInfoListenerWrapper = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$OnInfoListenerWrapper;
    localOnInfoListenerWrapper.a = paramOnInfoListener;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(localOnInfoListenerWrapper);
  }
  
  public void a(IVideoView.OnPreparedListener paramOnPreparedListener)
  {
    ProgressVideoViewWrapper.OnPreparedListenerWrapper localOnPreparedListenerWrapper = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$OnPreparedListenerWrapper;
    localOnPreparedListenerWrapper.a = paramOnPreparedListener;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(localOnPreparedListenerWrapper);
  }
  
  public void a(ProgressVideoViewWrapper.ProgressListener paramProgressListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$ProgressListener = paramProgressListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(paramString1, paramString2, paramString3, paramLong, paramInt1, paramInt2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.b();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.b();
  }
  
  public void b()
  {
    ProgressVideoViewWrapper.ProgressListener localProgressListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$ProgressListener;
    if (localProgressListener != null) {
      localProgressListener.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.b();
  }
  
  public void c()
  {
    ProgressVideoViewWrapper.ProgressListener localProgressListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$ProgressListener;
    if (localProgressListener != null) {
      localProgressListener.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
  }
  
  public void d()
  {
    ProgressVideoViewWrapper.ProgressListener localProgressListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$ProgressListener;
    if (localProgressListener != null)
    {
      localProgressListener.a(0L, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.b(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper$ProgressListener.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper
 * JD-Core Version:    0.7.0.1
 */