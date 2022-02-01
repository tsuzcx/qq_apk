package com.tencent.common.danmaku.tool;

public class DrawableParams
{
  private String a;
  private String b;
  private int c;
  private float d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DrawableParams{mUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDefaultUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShape=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mCornerRadius=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.tool.DrawableParams
 * JD-Core Version:    0.7.0.1
 */