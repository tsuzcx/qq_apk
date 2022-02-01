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
    for (;;)
    {
      try
      {
        if (this.audioFrames == null) {
          this.audioFrames = new AudioFrame[paramArrayOfByte.length];
        }
        if (this.audioLevels != null) {
          continue;
        }
        this.audioLevels = new AudioLevel[paramArrayOfByte.length];
      }
      finally
      {
        Object localObject;
        AudioFrame localAudioFrame;
        int k;
        continue;
        throw paramArrayOfByte;
        continue;
        int i = 0;
        continue;
        int j = 0;
        continue;
      }
      if (i >= paramArrayOfByte.length) {
        continue;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("chan");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      if (this.audioFrames[i] == null) {
        this.audioFrames[i] = new AudioFrame((String)localObject);
      }
      if (this.audioLevels[i] != null) {
        continue;
      }
      this.audioLevels[i] = new AudioLevel();
      continue;
      if (j < paramArrayOfByte[i].length - 1)
      {
        localAudioFrame = this.audioFrames[i];
        k = paramArrayOfByte[i].length;
        k = localAudioFrame.UpdateFrameChunk(SystemClock.uptimeMillis(), paramArrayOfByte[i], j, k - j, paramFormat.sampleRate, (short)1);
        if (this.audioFrames[i].available() <= 0)
        {
          this.audioLevels[i].ComputeLevel(this.audioFrames[i], this.audioFrames[i].duration());
          this.audioFrames[i] = new AudioFrame((String)localObject);
        }
        j += k;
      }
      else
      {
        i += 1;
      }
    }
  }
  
  public void feedAudioData(byte[] paramArrayOfByte, Format paramFormat)
  {
    try
    {
      i1 = paramFormat.channelCount;
      if ((i1 <= 0) || (i1 > 2)) {
        break label120;
      }
      bool = true;
    }
    finally
    {
      for (;;)
      {
        int i1;
        byte[][] arrayOfByte;
        int j;
        int n;
        int m;
        for (;;)
        {
          throw paramArrayOfByte;
        }
        label120:
        boolean bool = false;
        continue;
        byte[] arrayOfByte1 = arrayOfByte[n];
        arrayOfByte1[m] = paramArrayOfByte[j];
        arrayOfByte1[(m + 1)] = paramArrayOfByte[(j + 1)];
        int i = n + 1;
        j += 2;
        int k = m;
      }
    }
    Assertions.checkArgument(bool);
    arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { i1, paramArrayOfByte.length / i1 });
    j = 0;
    i = 0;
    k = 0;
    if (j < paramArrayOfByte.length)
    {
      n = i;
      m = k;
      if (i > i1 - 1)
      {
        m = k + 2;
        n = 0;
      }
    }
    else
    {
      processAudioFrame(arrayOfByte, paramFormat);
      return;
    }
  }
  
  public double getAudioEnergy()
  {
    double d1 = 0.0D;
    try
    {
      if (this.audioLevels != null)
      {
        int i = 0;
        while (i < this.audioLevels.length)
        {
          d1 += this.audioLevels[i].TotalEnergy();
          i += 1;
        }
        i = this.audioLevels.length;
        double d2 = i;
        Double.isNaN(d2);
        d1 /= d2;
        return d1;
      }
      return 0.0D;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public double getDuration()
  {
    double d1 = 0.0D;
    try
    {
      if (this.audioLevels != null)
      {
        int i = 0;
        while (i < this.audioLevels.length)
        {
          d1 += this.audioLevels[i].TotalDuration();
          i += 1;
        }
        i = this.audioLevels.length;
        double d2 = i;
        Double.isNaN(d2);
        d1 /= d2;
        return d1;
      }
      return 0.0D;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.audio.AudioFrameManager
 * JD-Core Version:    0.7.0.1
 */