package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class MediaPlayer$1
  implements MediaCodecDecoder.OnDecoderEventListener
{
  MediaPlayer$1(MediaPlayer paramMediaPlayer) {}
  
  public void a(MediaCodecDecoder paramMediaCodecDecoder)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread != null) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$PlaybackThread.a()) && (!this.a.e) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.b() < 2000000L) && (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerDecoders.b()))
    {
      paramMediaCodecDecoder = this.a;
      paramMediaCodecDecoder.e = true;
      paramMediaCodecDecoder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.sendMessage(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerMediaPlayer$EventHandler.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */