package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class MediaPlayer$1
  implements MediaCodecDecoder.OnDecoderEventListener
{
  MediaPlayer$1(MediaPlayer paramMediaPlayer) {}
  
  public void a(MediaCodecDecoder paramMediaCodecDecoder)
  {
    if ((this.a.p != null) && (!this.a.p.a()) && (!this.a.L) && (this.a.K.h() < 2000000L) && (!this.a.K.i()))
    {
      paramMediaCodecDecoder = this.a;
      paramMediaCodecDecoder.L = true;
      paramMediaCodecDecoder.w.sendMessage(this.a.w.obtainMessage(200, 701, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.1
 * JD-Core Version:    0.7.0.1
 */