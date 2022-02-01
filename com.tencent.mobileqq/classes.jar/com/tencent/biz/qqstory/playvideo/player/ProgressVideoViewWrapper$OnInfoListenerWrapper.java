package com.tencent.biz.qqstory.playvideo.player;

class ProgressVideoViewWrapper$OnInfoListenerWrapper
  implements IVideoView.OnInfoListener
{
  public IVideoView.OnInfoListener a;
  
  private ProgressVideoViewWrapper$OnInfoListenerWrapper(ProgressVideoViewWrapper paramProgressVideoViewWrapper) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    if (ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper) != null) {
      if (paramInt == 2) {
        ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper).c(ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper));
      } else if (paramInt == 3) {
        ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper).b(ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper));
      }
    }
    IVideoView.OnInfoListener localOnInfoListener = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnInfoListener;
    if (localOnInfoListener != null) {
      return localOnInfoListener.a(paramIVideoView, paramInt, paramObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.OnInfoListenerWrapper
 * JD-Core Version:    0.7.0.1
 */