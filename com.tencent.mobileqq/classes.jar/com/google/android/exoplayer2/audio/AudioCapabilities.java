package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class AudioCapabilities
{
  public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[] { 2 }, 2);
  private final int maxChannelCount;
  private final int[] supportedEncodings;
  
  AudioCapabilities(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      this.supportedEncodings = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.supportedEncodings);
    }
    for (;;)
    {
      this.maxChannelCount = paramInt;
      return;
      this.supportedEncodings = new int[0];
    }
  }
  
  public static AudioCapabilities getCapabilities(Context paramContext)
  {
    return getCapabilities(paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
  }
  
  @SuppressLint({"InlinedApi"})
  static AudioCapabilities getCapabilities(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0)) {
      return DEFAULT_AUDIO_CAPABILITIES;
    }
    return new AudioCapabilities(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AudioCapabilities)) {
        return false;
      }
      paramObject = (AudioCapabilities)paramObject;
    } while ((Arrays.equals(this.supportedEncodings, paramObject.supportedEncodings)) && (this.maxChannelCount == paramObject.maxChannelCount));
    return false;
  }
  
  public int getMaxChannelCount()
  {
    return this.maxChannelCount;
  }
  
  public int hashCode()
  {
    return this.maxChannelCount + Arrays.hashCode(this.supportedEncodings) * 31;
  }
  
  public boolean supportsEncoding(int paramInt)
  {
    return Arrays.binarySearch(this.supportedEncodings, paramInt) >= 0;
  }
  
  public String toString()
  {
    return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioCapabilities
 * JD-Core Version:    0.7.0.1
 */