package com.tencent.biz.qqstory.playvideo.player;

class ProgressVideoViewWrapper$OnPreparedListenerWrapper
  implements IVideoView.OnPreparedListener
{
  public IVideoView.OnPreparedListener a;
  
  private ProgressVideoViewWrapper$OnPreparedListenerWrapper(ProgressVideoViewWrapper paramProgressVideoViewWrapper) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper) != null) {
      ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper).a(0L, paramIVideoView.b(), paramIVideoView);
    }
    IVideoView.OnPreparedListener localOnPreparedListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnPreparedListener;
    if (localOnPreparedListener != null) {
      localOnPreparedListener.a(paramIVideoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.OnPreparedListenerWrapper
 * JD-Core Version:    0.7.0.1
 */