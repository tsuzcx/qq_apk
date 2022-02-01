package com.google.android.exoplayer2.audio;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

public abstract interface AudioSink
{
  public static final long CURRENT_POSITION_NOT_SET = -9223372036854775808L;
  
  public abstract void configure(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt, int paramInt5, int paramInt6);
  
  public abstract void disableTunneling();
  
  public abstract void enableTunnelingV21(int paramInt);
  
  public abstract long getCurrentPositionUs(boolean paramBoolean);
  
  public abstract PlaybackParameters getPlaybackParameters();
  
  public abstract boolean handleBuffer(ByteBuffer paramByteBuffer, long paramLong);
  
  public abstract void handleDiscontinuity();
  
  public abstract boolean hasPendingData();
  
  public abstract boolean isEncodingSupported(int paramInt);
  
  public abstract boolean isEnded();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void playToEndOfStream();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void setAudioAttributes(AudioAttributes paramAudioAttributes);
  
  public abstract void setAudioSessionId(int paramInt);
  
  public abstract void setListener(AudioSink.Listener paramListener);
  
  public abstract PlaybackParameters setPlaybackParameters(PlaybackParameters paramPlaybackParameters);
  
  public abstract void setVolume(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioSink
 * JD-Core Version:    0.7.0.1
 */