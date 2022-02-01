package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;

public class WebvttCue$Builder
{
  private static final String TAG = "WebvttCueBuilder";
  private long endTime;
  private float line;
  private int lineAnchor;
  private int lineType;
  private float position;
  private int positionAnchor;
  private long startTime;
  private SpannableStringBuilder text;
  private Layout.Alignment textAlignment;
  private float width;
  
  public WebvttCue$Builder()
  {
    reset();
  }
  
  private Builder derivePositionAnchorFromAlignment()
  {
    if (this.textAlignment == null)
    {
      this.positionAnchor = -2147483648;
      return this;
    }
    int i = WebvttCue.1.$SwitchMap$android$text$Layout$Alignment[this.textAlignment.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized alignment: ");
          localStringBuilder.append(this.textAlignment);
          Log.w("WebvttCueBuilder", localStringBuilder.toString());
          this.positionAnchor = 0;
          return this;
        }
        this.positionAnchor = 2;
        return this;
      }
      this.positionAnchor = 1;
      return this;
    }
    this.positionAnchor = 0;
    return this;
  }
  
  public WebvttCue build()
  {
    if ((this.position != 1.4E-45F) && (this.positionAnchor == -2147483648)) {
      derivePositionAnchorFromAlignment();
    }
    return new WebvttCue(this.startTime, this.endTime, this.text, this.textAlignment, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width);
  }
  
  public void reset()
  {
    this.startTime = 0L;
    this.endTime = 0L;
    this.text = null;
    this.textAlignment = null;
    this.line = 1.4E-45F;
    this.lineType = -2147483648;
    this.lineAnchor = -2147483648;
    this.position = 1.4E-45F;
    this.positionAnchor = -2147483648;
    this.width = 1.4E-45F;
  }
  
  public Builder setEndTime(long paramLong)
  {
    this.endTime = paramLong;
    return this;
  }
  
  public Builder setLine(float paramFloat)
  {
    this.line = paramFloat;
    return this;
  }
  
  public Builder setLineAnchor(int paramInt)
  {
    this.lineAnchor = paramInt;
    return this;
  }
  
  public Builder setLineType(int paramInt)
  {
    this.lineType = paramInt;
    return this;
  }
  
  public Builder setPosition(float paramFloat)
  {
    this.position = paramFloat;
    return this;
  }
  
  public Builder setPositionAnchor(int paramInt)
  {
    this.positionAnchor = paramInt;
    return this;
  }
  
  public Builder setStartTime(long paramLong)
  {
    this.startTime = paramLong;
    return this;
  }
  
  public Builder setText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    this.text = paramSpannableStringBuilder;
    return this;
  }
  
  public Builder setTextAlignment(Layout.Alignment paramAlignment)
  {
    this.textAlignment = paramAlignment;
    return this;
  }
  
  public Builder setWidth(float paramFloat)
  {
    this.width = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder
 * JD-Core Version:    0.7.0.1
 */