package com.tencent.biz.qqstory.playvideo.player;

class ProgressVideoViewWrapper$OnErrorListenerWrapper
  implements IVideoView.OnErrorListener
{
  public IVideoView.OnErrorListener a;
  
  private ProgressVideoViewWrapper$OnErrorListenerWrapper(ProgressVideoViewWrapper paramProgressVideoViewWrapper) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (ProgressVideoViewWrapper.a(this.b) != null) {
      ProgressVideoViewWrapper.a(this.b).c(ProgressVideoViewWrapper.b(this.b));
    }
    IVideoView.OnErrorListener localOnErrorListener = this.a;
    if (localOnErrorListener != null) {
      return localOnErrorListener.a(paramIVideoView, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.OnErrorListenerWrapper
 * JD-Core Version:    0.7.0.1
 */