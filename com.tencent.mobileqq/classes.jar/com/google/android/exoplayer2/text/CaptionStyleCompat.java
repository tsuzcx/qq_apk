package com.google.android.exoplayer2.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.util.Util;

public final class CaptionStyleCompat
{
  public static final CaptionStyleCompat DEFAULT = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, null);
  public static final int EDGE_TYPE_DEPRESSED = 4;
  public static final int EDGE_TYPE_DROP_SHADOW = 2;
  public static final int EDGE_TYPE_NONE = 0;
  public static final int EDGE_TYPE_OUTLINE = 1;
  public static final int EDGE_TYPE_RAISED = 3;
  public static final int USE_TRACK_COLOR_SETTINGS = 1;
  public final int backgroundColor;
  public final int edgeColor;
  public final int edgeType;
  public final int foregroundColor;
  public final Typeface typeface;
  public final int windowColor;
  
  public CaptionStyleCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Typeface paramTypeface)
  {
    this.foregroundColor = paramInt1;
    this.backgroundColor = paramInt2;
    this.windowColor = paramInt3;
    this.edgeType = paramInt4;
    this.edgeColor = paramInt5;
    this.typeface = paramTypeface;
  }
  
  @TargetApi(19)
  public static CaptionStyleCompat createFromCaptionStyle(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    if (Util.SDK_INT >= 21) {
      return createFromCaptionStyleV21(paramCaptionStyle);
    }
    return createFromCaptionStyleV19(paramCaptionStyle);
  }
  
  @TargetApi(19)
  private static CaptionStyleCompat createFromCaptionStyleV19(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    return new CaptionStyleCompat(paramCaptionStyle.foregroundColor, paramCaptionStyle.backgroundColor, 0, paramCaptionStyle.edgeType, paramCaptionStyle.edgeColor, paramCaptionStyle.getTypeface());
  }
  
  @TargetApi(21)
  private static CaptionStyleCompat createFromCaptionStyleV21(CaptioningManager.CaptionStyle paramCaptionStyle)
  {
    int i;
    if (paramCaptionStyle.hasForegroundColor()) {
      i = paramCaptionStyle.foregroundColor;
    } else {
      i = DEFAULT.foregroundColor;
    }
    int j;
    if (paramCaptionStyle.hasBackgroundColor()) {
      j = paramCaptionStyle.backgroundColor;
    } else {
      j = DEFAULT.backgroundColor;
    }
    int k;
    if (paramCaptionStyle.hasWindowColor()) {
      k = paramCaptionStyle.windowColor;
    } else {
      k = DEFAULT.windowColor;
    }
    int m;
    if (paramCaptionStyle.hasEdgeType()) {
      m = paramCaptionStyle.edgeType;
    } else {
      m = DEFAULT.edgeType;
    }
    int n;
    if (paramCaptionStyle.hasEdgeColor()) {
      n = paramCaptionStyle.edgeColor;
    } else {
      n = DEFAULT.edgeColor;
    }
    return new CaptionStyleCompat(i, j, k, m, n, paramCaptionStyle.getTypeface());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.CaptionStyleCompat
 * JD-Core Version:    0.7.0.1
 */