package com.tencent.luggage.wxa.i;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class c
{
  public static final c a = new c(new int[] { 2 }, 2);
  private final int[] b;
  private final int c;
  
  c(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      this.b = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.b);
    }
    else
    {
      this.b = new int[0];
    }
    this.c = paramInt;
  }
  
  public static c a(Context paramContext)
  {
    return a(paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
  }
  
  @SuppressLint({"InlinedApi"})
  static c a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0)) {
      return new c(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }
    return a;
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.b, paramInt) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return (Arrays.equals(this.b, paramObject.b)) && (this.c == paramObject.c);
  }
  
  public int hashCode()
  {
    return this.c + Arrays.hashCode(this.b) * 31;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioCapabilities[maxChannelCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", supportedEncodings=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.i.c
 * JD-Core Version:    0.7.0.1
 */