package com.tencent.mobileqq.bubble;

import android.graphics.Rect;
import java.util.Arrays;

public class BubbleInfo$CommonAttrs
{
  public int a;
  public int b = 1;
  public boolean c = true;
  public int d = 50;
  public String e = "";
  public Rect f = new Rect();
  public int g = -1;
  public boolean h = true;
  public int i = 1;
  public String j;
  public String[] k = new String[0];
  public AnimationConfig l;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonAttrs [key=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mRect=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", count=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", align=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mBigImgPath=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", repeatCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mAnimationPath=");
    localStringBuilder.append(Arrays.toString(this.k));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs
 * JD-Core Version:    0.7.0.1
 */