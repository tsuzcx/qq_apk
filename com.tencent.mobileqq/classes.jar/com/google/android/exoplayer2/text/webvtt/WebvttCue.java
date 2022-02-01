package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.text.Cue;

public final class WebvttCue
  extends Cue
{
  public final long endTime;
  public final long startTime;
  
  public WebvttCue(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this(paramLong1, paramLong2, paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }
  
  public WebvttCue(long paramLong1, long paramLong2, CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    super(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3);
    this.startTime = paramLong1;
    this.endTime = paramLong2;
  }
  
  public WebvttCue(CharSequence paramCharSequence)
  {
    this(0L, 0L, paramCharSequence);
  }
  
  public boolean isNormalCue()
  {
    return (this.line == 1.4E-45F) && (this.position == 1.4E-45F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttCue
 * JD-Core Version:    0.7.0.1
 */