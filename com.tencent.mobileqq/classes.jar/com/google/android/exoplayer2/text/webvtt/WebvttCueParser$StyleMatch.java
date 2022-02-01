package com.google.android.exoplayer2.text.webvtt;

import android.support.annotation.NonNull;

final class WebvttCueParser$StyleMatch
  implements Comparable<StyleMatch>
{
  public final int score;
  public final WebvttCssStyle style;
  
  public WebvttCueParser$StyleMatch(int paramInt, WebvttCssStyle paramWebvttCssStyle)
  {
    this.score = paramInt;
    this.style = paramWebvttCssStyle;
  }
  
  public int compareTo(@NonNull StyleMatch paramStyleMatch)
  {
    return this.score - paramStyleMatch.score;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch
 * JD-Core Version:    0.7.0.1
 */