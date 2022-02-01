package com.tencent.biz.qqstory.playvideo.player;

class ProgressVideoViewWrapper$OnPreparedListenerWrapper
  implements IVideoView.OnPreparedListener
{
  public IVideoView.OnPreparedListener a;
  
  private ProgressVideoViewWrapper$OnPreparedListenerWrapper(ProgressVideoViewWrapper paramProgressVideoViewWrapper) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (ProgressVideoViewWrapper.a(this.b) != null) {
      ProgressVideoViewWrapper.a(this.b).a(0L, paramIVideoView.h(), paramIVideoView);
    }
    IVideoView.OnPreparedListener localOnPreparedListener = this.a;
    if (localOnPreparedListener != null) {
      localOnPreparedListener.a(paramIVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.OnPreparedListenerWrapper
 * JD-Core Version:    0.7.0.1
 */