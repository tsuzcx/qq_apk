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
    int i = this.samples_per_channel_;
    i = this.num_channels_ * i;
    if (i < kMaxDataSizeSamples) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      if (paramAudioFrame.muted()) {
        break;
      }
      System.arraycopy(paramAudioFrame.data(), 0, this.data_, 0, i * kSizeOfShort);
      this.muted_ = false;
      return;
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
    if (paramInt < kMaxDataSizeSamples) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      if (paramArrayOfByte == null) {
        break;
      }
      System.arraycopy(paramArrayOfByte, 0, this.data_, 0, kSizeOfShort * paramInt);
      this.muted_ = false;
      return;
    }
    this.muted_ = true;
  }
  
  int UpdateFrameChunk(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, short paramShort)
  {
    boolean bool2 = true;
    if (this.timestamp_ == -9223372036854775807L) {
      this.timestamp_ = paramLong;
    }
    if (paramInt3 > 0)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if ((this.sample_rate_hz_ != 0) && (this.sample_rate_hz_ != paramInt3)) {
        break label238;
      }
      bool1 = true;
      label51:
      Assertions.checkArgument(bool1);
      this.sample_rate_hz_ = paramInt3;
      if (paramShort <= 0) {
        break label244;
      }
      bool1 = true;
      label70:
      Assertions.checkArgument(bool1);
      if ((this.num_channels_ != 0) && (this.num_channels_ != paramShort)) {
        break label250;
      }
      bool1 = true;
      label94:
      Assertions.checkArgument(bool1);
      this.num_channels_ = paramShort;
      paramInt3 = kMaxDataSizeBytes - this.offset_;
      paramInt2 = Math.min(paramInt2, paramInt3);
      if ((paramInt2 > 0) && (paramArrayOfByte != null))
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.data_, this.offset_, paramInt2);
        this.muted_ = false;
        if (paramInt3 % kSizeOfShort != 0) {
          break label256;
        }
        bool1 = true;
        label166:
        Assertions.checkArgument(bool1);
        this.samples_per_channel_ = ((short)(this.samples_per_channel_ + paramInt2 / kSizeOfShort / this.num_channels_));
        this.offset_ += paramInt2;
      }
      if (paramInt3 <= 0) {
        break label262;
      }
    }
    label256:
    label262:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      if (paramInt3 - paramInt2 == 0) {
        onFrameAvailable();
      }
      return paramInt2;
      bool1 = false;
      break;
      label238:
      bool1 = false;
      break label51;
      label244:
      bool1 = false;
      break label70;
      label250:
      bool1 = false;
      break label94;
      bool1 = false;
      break label166;
    }
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
    return this.samples_per_channel_ / this.sample_rate_hz_;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.audio.AudioFrame
 * JD-Core Version:    0.7.0.1
 */