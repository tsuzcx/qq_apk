package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public abstract interface AudioRendererEventListener
{
  public abstract boolean isNeedAudioData();
  
  public abstract void onAudioDecoderInitialized(String paramString, long paramLong1, long paramLong2);
  
  public abstract void onAudioDisabled(DecoderCounters paramDecoderCounters);
  
  public abstract void onAudioEnabled(DecoderCounters paramDecoderCounters);
  
  public abstract void onAudioInputFormatChanged(Format paramFormat);
  
  public abstract void onAudioSessionId(int paramInt);
  
  public abstract void onAudioSinkUnderrun(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void onRenderAudioData(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioRendererEventListener
 * JD-Core Version:    0.7.0.1
 */