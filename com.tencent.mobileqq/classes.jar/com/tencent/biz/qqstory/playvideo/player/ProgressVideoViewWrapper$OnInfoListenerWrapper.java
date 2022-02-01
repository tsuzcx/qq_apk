package com.tencent.biz.qqstory.playvideo.player;

class ProgressVideoViewWrapper$OnInfoListenerWrapper
  implements IVideoView.OnInfoListener
{
  public IVideoView.OnInfoListener a;
  
  private ProgressVideoViewWrapper$OnInfoListenerWrapper(ProgressVideoViewWrapper paramProgressVideoViewWrapper) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    if (ProgressVideoViewWrapper.a(this.b) != null) {
      if (paramInt == 2) {
        ProgressVideoViewWrapper.a(this.b).c(ProgressVideoViewWrapper.b(this.b));
      } else if (paramInt == 3) {
        ProgressVideoViewWrapper.a(this.b).b(ProgressVideoViewWrapper.b(this.b));
      }
    }
    IVideoView.OnInfoListener localOnInfoListener = this.a;
    if (localOnInfoListener != null) {
      return localOnInfoListener.a(paramIVideoView, paramInt, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.OnInfoListenerWrapper
 * JD-Core Version:    0.7.0.1
 */