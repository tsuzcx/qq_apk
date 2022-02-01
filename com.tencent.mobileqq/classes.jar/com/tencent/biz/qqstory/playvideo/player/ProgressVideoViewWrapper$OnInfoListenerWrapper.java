package com.tencent.biz.qqstory.playvideo.player;

class ProgressVideoViewWrapper$OnInfoListenerWrapper
  implements IVideoView.OnInfoListener
{
  public IVideoView.OnInfoListener a;
  
  private ProgressVideoViewWrapper$OnInfoListenerWrapper(ProgressVideoViewWrapper paramProgressVideoViewWrapper) {}
  
  public boolean a(IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    if (ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper) != null)
    {
      if (paramInt != 2) {
        break label54;
      }
      ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper).c(ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper));
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnInfoListener != null)
    {
      return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView$OnInfoListener.a(paramIVideoView, paramInt, paramObject);
      label54:
      if (paramInt == 3) {
        ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper).b(ProgressVideoViewWrapper.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerProgressVideoViewWrapper));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.OnInfoListenerWrapper
 * JD-Core Version:    0.7.0.1
 */