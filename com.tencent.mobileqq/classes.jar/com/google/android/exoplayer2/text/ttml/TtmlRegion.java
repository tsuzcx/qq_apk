package com.google.android.exoplayer2.text.ttml;

final class TtmlRegion
{
  public final String id;
  public final float line;
  public final int lineAnchor;
  public final int lineType;
  public final float position;
  public final float width;
  
  public TtmlRegion(String paramString)
  {
    this(paramString, 1.4E-45F, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F);
  }
  
  public TtmlRegion(String paramString, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    this.id = paramString;
    this.position = paramFloat1;
    this.line = paramFloat2;
    this.lineType = paramInt1;
    this.lineAnchor = paramInt2;
    this.width = paramFloat3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ttml.TtmlRegion
 * JD-Core Version:    0.7.0.1
 */