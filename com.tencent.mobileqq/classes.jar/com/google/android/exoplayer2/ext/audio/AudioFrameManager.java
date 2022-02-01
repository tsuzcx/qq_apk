package com.google.android.exoplayer2.ext.audio;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.reflect.Array;

public class AudioFrameManager
{
  private AudioFrame[] audioFrames = null;
  private AudioLevel[] audioLevels = null;
  
  private void processAudioFrame(byte[][] paramArrayOfByte, Format paramFormat)
  {
    int i;
    String str;
    try
    {
      if (this.audioFrames == null) {
        this.audioFrames = new AudioFrame[paramArrayOfByte.length];
      }
      if (this.audioLevels != null) {
        break label239;
      }
      this.audioLevels = new AudioLevel[paramArrayOfByte.length];
    }
    finally {}
    if (i < paramArrayOfByte.length)
    {
      str = "chan" + i;
      if (this.audioFrames[i] == null) {
        this.audioFrames[i] = new AudioFrame(str);
      }
      if (this.audioLevels[i] != null) {
        break label244;
      }
      this.audioLevels[i] = new AudioLevel();
    }
    for (;;)
    {
      int j;
      if (j < paramArrayOfByte[i].length - 1)
      {
        AudioFrame localAudioFrame = this.audioFrames[i];
        int k = paramArrayOfByte[i].length;
        k = localAudioFrame.UpdateFrameChunk(SystemClock.uptimeMillis(), paramArrayOfByte[i], j, k - j, paramFormat.sampleRate, (short)1);
        if (this.audioFrames[i].available() <= 0)
        {
          this.audioLevels[i].ComputeLevel(this.audioFrames[i], this.audioFrames[i].duration());
          this.audioFrames[i] = new AudioFrame(str);
        }
        j += k;
      }
      else
      {
        i += 1;
        break;
        return;
        label239:
        i = 0;
        break;
        label244:
        j = 0;
      }
    }
  }
  
  public void feedAudioData(byte[] paramArrayOfByte, Format paramFormat)
  {
    for (;;)
    {
      byte[][] arrayOfByte;
      int j;
      int m;
      int n;
      try
      {
        int i1 = paramFormat.channelCount;
        if ((i1 <= 0) || (i1 > 2)) {
          break label160;
        }
        bool = true;
        Assertions.checkArgument(bool);
        i = paramArrayOfByte.length / i1;
        arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i1, i });
        j = 0;
        i = 0;
        k = 0;
        if (j < paramArrayOfByte.length)
        {
          m = i;
          n = k;
          if (i > i1 - 1)
          {
            n = k + 2;
            m = 0;
          }
        }
        else
        {
          processAudioFrame(arrayOfByte, paramFormat);
          return;
        }
      }
      finally {}
      byte[] arrayOfByte1 = arrayOfByte[m];
      arrayOfByte1[n] = paramArrayOfByte[j];
      arrayOfByte1[(n + 1)] = paramArrayOfByte[(j + 1)];
      j += 2;
      int i = m + 1;
      int k = n;
      continue;
      label160:
      boolean bool = false;
    }
  }
  
  public double getAudioEnergy()
  {
    double d = 0.0D;
    try
    {
      if (this.audioLevels != null)
      {
        d = 0.0D;
        int i = 0;
        while (i < this.audioLevels.length)
        {
          d += this.audioLevels[i].TotalEnergy();
          i += 1;
        }
        i = this.audioLevels.length;
        d /= i;
      }
      return d;
    }
    finally {}
  }
  
  public double getDuration()
  {
    double d = 0.0D;
    try
    {
      if (this.audioLevels != null)
      {
        d = 0.0D;
        int i = 0;
        while (i < this.audioLevels.length)
        {
          d += this.audioLevels[i].TotalDuration();
          i += 1;
        }
        i = this.audioLevels.length;
        d /= i;
      }
      return d;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.audio.AudioFrameManager
 * JD-Core Version:    0.7.0.1
 */