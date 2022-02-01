package com.tencent.biz.qqstory.takevideo.tools.audio;

import android.media.AudioTrack;
import com.tencent.mobileqq.richmedia.capture.audio.AudioDataCache;

class GameAudioMuxer$OnMixedDataListener
  implements AudioCombiner.OnMixedDataListener
{
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      if ((this.a.a) && (GameAudioMuxer.a(this.a) != null)) {
        GameAudioMuxer.a(this.a).write(paramArrayOfByte, 0, paramArrayOfByte.length);
      }
    } while ((GameAudioMuxer.a(this.a) == null) || (!GameAudioMuxer.a(this.a)));
    GameAudioMuxer.a(this.a).a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.GameAudioMuxer.OnMixedDataListener
 * JD-Core Version:    0.7.0.1
 */