package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic
{
  private static final int AMDF_FREQUENCY = 4000;
  private static final int MAXIMUM_PITCH = 400;
  private static final int MINIMUM_PITCH = 65;
  private final short[] downSampleBuffer;
  private short[] inputBuffer;
  private int inputBufferSize;
  private final int inputSampleRateHz;
  private int maxDiff;
  private final int maxPeriod;
  private final int maxRequired;
  private int minDiff;
  private final int minPeriod;
  private int newRatePosition;
  private final int numChannels;
  private int numInputSamples;
  private int numOutputSamples;
  private int numPitchSamples;
  private int oldRatePosition;
  private short[] outputBuffer;
  private int outputBufferSize;
  private final float pitch;
  private short[] pitchBuffer;
  private int pitchBufferSize;
  private int prevMinDiff;
  private int prevPeriod;
  private final float rate;
  private int remainingInputToCopy;
  private final float speed;
  
  public Sonic(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    this.inputSampleRateHz = paramInt1;
    this.numChannels = paramInt2;
    this.minPeriod = (paramInt1 / 400);
    this.maxPeriod = (paramInt1 / 65);
    this.maxRequired = (this.maxPeriod * 2);
    int i = this.maxRequired;
    this.downSampleBuffer = new short[i];
    this.inputBufferSize = i;
    this.inputBuffer = new short[i * paramInt2];
    this.outputBufferSize = i;
    this.outputBuffer = new short[i * paramInt2];
    this.pitchBufferSize = i;
    this.pitchBuffer = new short[i * paramInt2];
    this.oldRatePosition = 0;
    this.newRatePosition = 0;
    this.prevPeriod = 0;
    this.speed = paramFloat1;
    this.pitch = paramFloat2;
    this.rate = (paramInt1 / paramInt3);
  }
  
  private void adjustRate(float paramFloat, int paramInt)
  {
    if (this.numOutputSamples == paramInt) {
      return;
    }
    int i = this.inputSampleRateHz;
    int j = (int)(i / paramFloat);
    for (;;)
    {
      if ((j <= 16384) && (i <= 16384))
      {
        moveNewSamplesToPitchBuffer(paramInt);
        paramInt = 0;
        int k;
        for (;;)
        {
          k = this.numPitchSamples;
          boolean bool = true;
          if (paramInt >= k - 1) {
            break;
          }
          int m;
          for (;;)
          {
            k = this.oldRatePosition;
            m = this.newRatePosition;
            if ((k + 1) * j <= m * i) {
              break;
            }
            enlargeOutputBufferIfNeeded(1);
            k = 0;
            for (;;)
            {
              m = this.numChannels;
              if (k >= m) {
                break;
              }
              this.outputBuffer[(this.numOutputSamples * m + k)] = interpolate(this.pitchBuffer, m * paramInt + k, i, j);
              k += 1;
            }
            this.newRatePosition += 1;
            this.numOutputSamples += 1;
          }
          this.oldRatePosition = (k + 1);
          if (this.oldRatePosition == i)
          {
            this.oldRatePosition = 0;
            if (m != j) {
              bool = false;
            }
            Assertions.checkState(bool);
            this.newRatePosition = 0;
          }
          paramInt += 1;
        }
        removePitchSamples(k - 1);
        return;
      }
      j /= 2;
      i /= 2;
    }
  }
  
  private void changeSpeed(float paramFloat)
  {
    int k = this.numInputSamples;
    if (k < this.maxRequired) {
      return;
    }
    int j = 0;
    int i;
    do
    {
      if (this.remainingInputToCopy > 0) {
        i = copyInputToOutput(j);
      }
      for (;;)
      {
        i = j + i;
        break;
        i = findPitchPeriod(this.inputBuffer, j, true);
        if (paramFloat > 1.0D) {
          i += skipPitchPeriod(this.inputBuffer, j, paramFloat, i);
        } else {
          i = insertPitchPeriod(this.inputBuffer, j, paramFloat, i);
        }
      }
      j = i;
    } while (this.maxRequired + i <= k);
    removeProcessedInputSamples(i);
  }
  
  private int copyInputToOutput(int paramInt)
  {
    int i = Math.min(this.maxRequired, this.remainingInputToCopy);
    copyToOutput(this.inputBuffer, paramInt, i);
    this.remainingInputToCopy -= i;
    return i;
  }
  
  private void copyToOutput(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    enlargeOutputBufferIfNeeded(paramInt2);
    int i = this.numChannels;
    System.arraycopy(paramArrayOfShort, paramInt1 * i, this.outputBuffer, this.numOutputSamples * i, i * paramInt2);
    this.numOutputSamples += paramInt2;
  }
  
  private void downSampleInput(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int k = this.maxRequired / paramInt2;
    int m = this.numChannels;
    int n = paramInt2 * m;
    paramInt2 = 0;
    while (paramInt2 < k)
    {
      int i = 0;
      int j = 0;
      while (i < n)
      {
        j += paramArrayOfShort[(paramInt2 * n + paramInt1 * m + i)];
        i += 1;
      }
      i = j / n;
      this.downSampleBuffer[paramInt2] = ((short)i);
      paramInt2 += 1;
    }
  }
  
  private void enlargeInputBufferIfNeeded(int paramInt)
  {
    int i = this.numInputSamples;
    int j = this.inputBufferSize;
    if (i + paramInt > j)
    {
      this.inputBufferSize = (j + (j / 2 + paramInt));
      this.inputBuffer = Arrays.copyOf(this.inputBuffer, this.inputBufferSize * this.numChannels);
    }
  }
  
  private void enlargeOutputBufferIfNeeded(int paramInt)
  {
    int i = this.numOutputSamples;
    int j = this.outputBufferSize;
    if (i + paramInt > j)
    {
      this.outputBufferSize = (j + (j / 2 + paramInt));
      this.outputBuffer = Arrays.copyOf(this.outputBuffer, this.outputBufferSize * this.numChannels);
    }
  }
  
  private int findPitchPeriod(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    int i = this.inputSampleRateHz;
    if (i > 4000) {
      i /= 4000;
    } else {
      i = 1;
    }
    if ((this.numChannels == 1) && (i == 1))
    {
      paramInt = findPitchPeriodInRange(paramArrayOfShort, paramInt, this.minPeriod, this.maxPeriod);
    }
    else
    {
      downSampleInput(paramArrayOfShort, paramInt, i);
      int j = findPitchPeriodInRange(this.downSampleBuffer, 0, this.minPeriod / i, this.maxPeriod / i);
      if (i != 1)
      {
        j *= i;
        int k = i * 4;
        i = j - k;
        k = j + k;
        j = this.minPeriod;
        if (i < j) {
          i = j;
        }
        int m = this.maxPeriod;
        j = k;
        if (k > m) {
          j = m;
        }
        if (this.numChannels == 1)
        {
          paramInt = findPitchPeriodInRange(paramArrayOfShort, paramInt, i, j);
        }
        else
        {
          downSampleInput(paramArrayOfShort, paramInt, 1);
          paramInt = findPitchPeriodInRange(this.downSampleBuffer, 0, i, j);
        }
      }
      else
      {
        paramInt = j;
      }
    }
    if (previousPeriodBetter(this.minDiff, this.maxDiff, paramBoolean)) {
      i = this.prevPeriod;
    } else {
      i = paramInt;
    }
    this.prevMinDiff = this.minDiff;
    this.prevPeriod = paramInt;
    return i;
  }
  
  private int findPitchPeriodInRange(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i4 = paramInt1 * this.numChannels;
    int m = 1;
    int k = 0;
    int j = 0;
    int i2;
    for (int i = 255; paramInt2 <= paramInt3; i = i2)
    {
      int n = 0;
      paramInt1 = 0;
      while (n < paramInt2)
      {
        paramInt1 += Math.abs(paramArrayOfShort[(i4 + n)] - paramArrayOfShort[(i4 + paramInt2 + n)]);
        n += 1;
      }
      int i1 = m;
      n = k;
      if (paramInt1 * k < m * paramInt2)
      {
        n = paramInt2;
        i1 = paramInt1;
      }
      int i3 = j;
      i2 = i;
      if (paramInt1 * i > j * paramInt2)
      {
        i2 = paramInt2;
        i3 = paramInt1;
      }
      paramInt2 += 1;
      m = i1;
      k = n;
      j = i3;
    }
    this.minDiff = (m / k);
    this.maxDiff = (j / i);
    return k;
  }
  
  private int insertPitchPeriod(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    if (paramFloat < 0.5F)
    {
      i = (int)(paramInt2 * paramFloat / (1.0F - paramFloat));
    }
    else
    {
      this.remainingInputToCopy = ((int)(paramInt2 * (2.0F * paramFloat - 1.0F) / (1.0F - paramFloat)));
      i = paramInt2;
    }
    int j = paramInt2 + i;
    enlargeOutputBufferIfNeeded(j);
    int k = this.numChannels;
    System.arraycopy(paramArrayOfShort, paramInt1 * k, this.outputBuffer, this.numOutputSamples * k, k * paramInt2);
    overlapAdd(i, this.numChannels, this.outputBuffer, this.numOutputSamples + paramInt2, paramArrayOfShort, paramInt1 + paramInt2, paramArrayOfShort, paramInt1);
    this.numOutputSamples += j;
    return i;
  }
  
  private short interpolate(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramArrayOfShort[paramInt1];
    paramInt1 = paramArrayOfShort[(paramInt1 + this.numChannels)];
    int m = this.newRatePosition;
    int j = this.oldRatePosition;
    int k = (j + 1) * paramInt3;
    paramInt2 = k - m * paramInt2;
    paramInt3 = k - j * paramInt3;
    return (short)((i * paramInt2 + (paramInt3 - paramInt2) * paramInt1) / paramInt3);
  }
  
  private void moveNewSamplesToPitchBuffer(int paramInt)
  {
    int i = this.numOutputSamples - paramInt;
    int j = this.numPitchSamples;
    int k = this.pitchBufferSize;
    if (j + i > k)
    {
      this.pitchBufferSize = (k + (k / 2 + i));
      this.pitchBuffer = Arrays.copyOf(this.pitchBuffer, this.pitchBufferSize * this.numChannels);
    }
    short[] arrayOfShort = this.outputBuffer;
    j = this.numChannels;
    System.arraycopy(arrayOfShort, paramInt * j, this.pitchBuffer, this.numPitchSamples * j, j * i);
    this.numOutputSamples = paramInt;
    this.numPitchSamples += i;
  }
  
  private static void overlapAdd(int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2, int paramInt4, short[] paramArrayOfShort3, int paramInt5)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int k = paramInt4 * paramInt2 + i;
      int j = paramInt5 * paramInt2 + i;
      int n = paramInt3 * paramInt2 + i;
      int m = 0;
      while (m < paramInt1)
      {
        paramArrayOfShort1[n] = ((short)((paramArrayOfShort2[k] * (paramInt1 - m) + paramArrayOfShort3[j] * m) / paramInt1));
        n += paramInt2;
        k += paramInt2;
        j += paramInt2;
        m += 1;
      }
      i += 1;
    }
  }
  
  private boolean previousPeriodBetter(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 != 0)
    {
      if (this.prevPeriod == 0) {
        return false;
      }
      if (paramBoolean)
      {
        if (paramInt2 > paramInt1 * 3) {
          return false;
        }
        if (paramInt1 * 2 <= this.prevMinDiff * 3) {
          return false;
        }
      }
      else if (paramInt1 <= this.prevMinDiff)
      {
        return false;
      }
      return true;
    }
    return false;
  }
  
  private void processStreamInput()
  {
    int i = this.numOutputSamples;
    float f2 = this.speed;
    float f1 = this.pitch;
    f2 /= f1;
    f1 = this.rate * f1;
    double d = f2;
    if ((d <= 1.00001D) && (d >= 0.9999900000000001D))
    {
      copyToOutput(this.inputBuffer, 0, this.numInputSamples);
      this.numInputSamples = 0;
    }
    else
    {
      changeSpeed(f2);
    }
    if (f1 != 1.0F) {
      adjustRate(f1, i);
    }
  }
  
  private void removePitchSamples(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    short[] arrayOfShort = this.pitchBuffer;
    int i = this.numChannels;
    System.arraycopy(arrayOfShort, paramInt * i, arrayOfShort, 0, (this.numPitchSamples - paramInt) * i);
    this.numPitchSamples -= paramInt;
  }
  
  private void removeProcessedInputSamples(int paramInt)
  {
    int i = this.numInputSamples - paramInt;
    short[] arrayOfShort = this.inputBuffer;
    int j = this.numChannels;
    System.arraycopy(arrayOfShort, paramInt * j, arrayOfShort, 0, j * i);
    this.numInputSamples = i;
  }
  
  private int skipPitchPeriod(short[] paramArrayOfShort, int paramInt1, float paramFloat, int paramInt2)
  {
    int i;
    if (paramFloat >= 2.0F)
    {
      i = (int)(paramInt2 / (paramFloat - 1.0F));
    }
    else
    {
      this.remainingInputToCopy = ((int)(paramInt2 * (2.0F - paramFloat) / (paramFloat - 1.0F)));
      i = paramInt2;
    }
    enlargeOutputBufferIfNeeded(i);
    overlapAdd(i, this.numChannels, this.outputBuffer, this.numOutputSamples, paramArrayOfShort, paramInt1, paramArrayOfShort, paramInt1 + paramInt2);
    this.numOutputSamples += i;
    return i;
  }
  
  public void getOutput(ShortBuffer paramShortBuffer)
  {
    int i = Math.min(paramShortBuffer.remaining() / this.numChannels, this.numOutputSamples);
    paramShortBuffer.put(this.outputBuffer, 0, this.numChannels * i);
    this.numOutputSamples -= i;
    paramShortBuffer = this.outputBuffer;
    int j = this.numChannels;
    System.arraycopy(paramShortBuffer, i * j, paramShortBuffer, 0, this.numOutputSamples * j);
  }
  
  public int getSamplesAvailable()
  {
    return this.numOutputSamples;
  }
  
  public void queueEndOfStream()
  {
    int j = this.numInputSamples;
    float f2 = this.speed;
    float f1 = this.pitch;
    f2 /= f1;
    float f3 = this.rate;
    int k = this.numOutputSamples + (int)((j / f2 + this.numPitchSamples) / (f3 * f1) + 0.5F);
    enlargeInputBufferIfNeeded(this.maxRequired * 2 + j);
    int i = 0;
    int m;
    for (;;)
    {
      m = this.maxRequired;
      int n = this.numChannels;
      if (i >= m * 2 * n) {
        break;
      }
      this.inputBuffer[(n * j + i)] = 0;
      i += 1;
    }
    this.numInputSamples += m * 2;
    processStreamInput();
    if (this.numOutputSamples > k) {
      this.numOutputSamples = k;
    }
    this.numInputSamples = 0;
    this.remainingInputToCopy = 0;
    this.numPitchSamples = 0;
  }
  
  public void queueInput(ShortBuffer paramShortBuffer)
  {
    int j = paramShortBuffer.remaining();
    int i = this.numChannels;
    j /= i;
    enlargeInputBufferIfNeeded(j);
    paramShortBuffer.get(this.inputBuffer, this.numInputSamples * this.numChannels, i * j * 2 / 2);
    this.numInputSamples += j;
    processStreamInput();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.Sonic
 * JD-Core Version:    0.7.0.1
 */