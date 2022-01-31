package com.google.android.exoplayer2.ext.audio;

import com.google.android.exoplayer2.ext.util.AudioUtil;

public class AudioLevel
{
  private static final short WEBRTC_SPL_WORD16_MAX = 32767;
  static final short kSizeOfShort = 2;
  private static final short kUpdateFrequency = 1;
  private short abs_max_ = 0;
  private short count_ = 0;
  private short current_level_full_range_ = 0;
  private double total_duration_ = 0.0D;
  private double total_energy_ = 0.0D;
  
  static short WebRtcSpl_MaxAbsValueW16J(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramInt <= 0)) {
      return -1;
    }
    int j = 0;
    if (j < paramInt)
    {
      int k = j * 2;
      k = Math.abs(AudioUtil.byteToShort(paramArrayOfByte[k], paramArrayOfByte[(k + 1)]));
      if (k <= i) {
        break label74;
      }
      i = k;
    }
    label74:
    for (;;)
    {
      j += 1;
      break;
      paramInt = i;
      if (i > 32767) {
        paramInt = 32767;
      }
      return (short)paramInt;
    }
  }
  
  void Clear()
  {
    this.abs_max_ = 0;
    this.count_ = 0;
    this.current_level_full_range_ = 0;
  }
  
  void ComputeLevel(AudioFrame paramAudioFrame, double paramDouble)
  {
    if (paramAudioFrame.muted()) {}
    for (short s = 0;; s = WebRtcSpl_MaxAbsValueW16J(paramAudioFrame.data(), paramAudioFrame.samples_per_channel_ * paramAudioFrame.num_channels_))
    {
      if (s > this.abs_max_) {
        this.abs_max_ = s;
      }
      int i = this.count_;
      this.count_ = ((short)(i + 1));
      if (i == 1)
      {
        this.current_level_full_range_ = this.abs_max_;
        this.count_ = 0;
        this.abs_max_ = ((short)(this.abs_max_ >> 2));
      }
      double d = this.current_level_full_range_ / 32767.0D;
      this.total_energy_ = (d * d * paramDouble + this.total_energy_);
      this.total_duration_ += paramDouble;
      return;
    }
  }
  
  short LevelFullRange()
  {
    return this.current_level_full_range_;
  }
  
  double TotalDuration()
  {
    return this.total_duration_;
  }
  
  double TotalEnergy()
  {
    return this.total_energy_;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.audio.AudioLevel
 * JD-Core Version:    0.7.0.1
 */