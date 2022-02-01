package com.tencent.biz.qqstory.playvideo.player;

class ProgressVideoViewWrapper$OnErrorListenerWrapper
  implements IVideoView.OnErrorListener
{
  public IVideoView.OnErrorListener a;
  
  private ProgressVideoViewWrapper$OnErrorListenerWrapper(ProgressVideoViewWrapper paramProgressVideoViewWrapper) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper) != null) {
      ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper).c(ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper));
    }
    IVideoView.OnErrorListener localOnErrorListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnErrorListener;
    if (localOnErrorListener != null) {
      return localOnErrorListener.a(paramIVideoView, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.OnErrorListenerWrapper
 * JD-Core Version:    0.7.0.1
 */