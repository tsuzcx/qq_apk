package com.google.android.exoplayer2.ext.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public class AudioFrame
{
  private static int kMaxDataSizeBytes = kMaxDataSizeSamples * kSizeOfShort;
  private static int kMaxDataSizeSamples = 5292;
  private static short kSizeOfShort = 2;
  private byte[] data_ = new byte[kMaxDataSizeBytes];
  private boolean isDebug_ = true;
  private boolean muted_ = true;
  short num_channels_ = 0;
  private int offset_ = 0;
  private int sample_rate_hz_ = 0;
  short samples_per_channel_ = 0;
  private String tag_ = "";
  private long timestamp_ = -9223372036854775807L;
  
  AudioFrame(String paramString)
  {
    this.tag_ = paramString;
  }
  
  static byte[] empty_data()
  {
    return new byte[kMaxDataSizeBytes];
  }
  
  private void onFrameAvailable() {}
  
  void CopyFrom(AudioFrame paramAudioFrame)
  {
    if (paramAudioFrame.equals(this)) {
      return;
    }
    this.timestamp_ = paramAudioFrame.timestamp_;
    this.muted_ = paramAudioFrame.muted();
    this.samples_per_channel_ = paramAudioFrame.samples_per_channel_;
    this.sample_rate_hz_ = paramAudioFrame.sample_rate_hz_;
    this.num_channels_ = paramAudioFrame.num_channels_;
    this.offset_ = paramAudioFrame.offset_;
    int i = this.samples_per_channel_ * this.num_channels_;
    boolean bool;
    if (i < kMaxDataSizeSamples) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    if (!paramAudioFrame.muted())
    {
      System.arraycopy(paramAudioFrame.data(), 0, this.data_, 0, i * kSizeOfShort);
      this.muted_ = false;
    }
  }
  
  void Mute()
  {
    this.muted_ = true;
  }
  
  void ResetWithoutMuting()
  {
    this.timestamp_ = -9223372036854775807L;
    this.samples_per_channel_ = 0;
    this.sample_rate_hz_ = 0;
    this.num_channels_ = 0;
    this.offset_ = 0;
  }
  
  void UpdateFrame(long paramLong, byte[] paramArrayOfByte, short paramShort1, int paramInt, short paramShort2)
  {
    this.timestamp_ = paramLong;
    this.samples_per_channel_ = paramShort1;
    this.sample_rate_hz_ = paramInt;
    this.num_channels_ = paramShort2;
    paramInt = paramShort1 * paramShort2;
    boolean bool;
    if (paramInt < kMaxDataSizeSamples) {
      bool = true;
    } else {
      bool = false;
    }
    Assertions.checkArgument(bool);
    if (paramArrayOfByte != null)
    {
      System.arraycopy(paramArrayOfByte, 0, this.data_, 0, paramInt * kSizeOfShort);
      this.muted_ = false;
      return;
    }
    this.muted_ = true;
  }
  
  int UpdateFrameChunk(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, short paramShort)
  {
    if (this.timestamp_ == -9223372036854775807L) {
      this.timestamp_ = paramLong;
    }
    boolean bool2 = true;
    boolean bool1;
    if (paramInt3 > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    int i = this.sample_rate_hz_;
    if ((i != 0) && (i != paramInt3)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Assertions.checkArgument(bool1);
    this.sample_rate_hz_ = paramInt3;
    if (paramShort > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    paramInt3 = this.num_channels_;
    if ((paramInt3 != 0) && (paramInt3 != paramShort)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Assertions.checkArgument(bool1);
    this.num_channels_ = paramShort;
    paramInt3 = kMaxDataSizeBytes - this.offset_;
    paramInt2 = Math.min(paramInt2, paramInt3);
    if ((paramInt2 > 0) && (paramArrayOfByte != null))
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.data_, this.offset_, paramInt2);
      this.muted_ = false;
      if (paramInt3 % kSizeOfShort == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Assertions.checkArgument(bool1);
      this.samples_per_channel_ = ((short)(this.samples_per_channel_ + paramInt2 / kSizeOfShort / this.num_channels_));
      this.offset_ += paramInt2;
    }
    if (paramInt3 > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    if (paramInt3 - paramInt2 == 0) {
      onFrameAvailable();
    }
    return paramInt2;
  }
  
  int available()
  {
    return kMaxDataSizeBytes - this.offset_;
  }
  
  byte[] data()
  {
    if (this.muted_) {
      return empty_data();
    }
    return this.data_;
  }
  
  double duration()
  {
    double d1 = this.samples_per_channel_;
    double d2 = this.sample_rate_hz_;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  byte[] mutable_data()
  {
    if (this.muted_)
    {
      Arrays.fill(this.data_, 0, kMaxDataSizeBytes - 1, (byte)0);
      this.muted_ = false;
    }
    return this.data_;
  }
  
  boolean muted()
  {
    return this.muted_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.audio.AudioFrame
 * JD-Core Version:    0.7.0.1
 */