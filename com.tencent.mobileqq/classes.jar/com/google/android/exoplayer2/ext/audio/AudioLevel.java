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
    if ((paramArrayOfByte != null) && (paramInt > 0))
    {
      int j = 0;
      int k;
      for (int i = 0; j < paramInt; i = k)
      {
        k = j * 2;
        int m = Math.abs(AudioUtil.byteToShort(paramArrayOfByte[k], paramArrayOfByte[(k + 1)]));
        k = i;
        if (m > i) {
          k = m;
        }
        j += 1;
      }
      paramInt = 32767;
      if (i > 32767) {
        i = paramInt;
      }
      return (short)i;
    }
    return -1;
  }
  
  void Clear()
  {
    this.abs_max_ = 0;
    this.count_ = 0;
    this.current_level_full_range_ = 0;
  }
  
  void ComputeLevel(AudioFrame paramAudioFrame, double paramDouble)
  {
    short s;
    if (paramAudioFrame.muted()) {
      s = 0;
    } else {
      s = WebRtcSpl_MaxAbsValueW16J(paramAudioFrame.data(), paramAudioFrame.samples_per_channel_ * paramAudioFrame.num_channels_);
    }
    if (s > this.abs_max_) {
      this.abs_max_ = s;
    }
    int i = this.count_;
    this.count_ = ((short)(i + 1));
    if (i == 1)
    {
      s = this.abs_max_;
      this.current_level_full_range_ = s;
      this.count_ = 0;
      this.abs_max_ = ((short)(s >> 2));
    }
    double d = this.current_level_full_range_;
    Double.isNaN(d);
    d /= 32767.0D;
    this.total_energy_ += d * d * paramDouble;
    this.total_duration_ += paramDouble;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.audio.AudioLevel
 * JD-Core Version:    0.7.0.1
 */