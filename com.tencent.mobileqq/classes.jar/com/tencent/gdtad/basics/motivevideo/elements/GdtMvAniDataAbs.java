package com.tencent.gdtad.basics.motivevideo.elements;

import android.view.View;

public class GdtMvAniDataAbs
  implements GdtMvAniData
{
  public View o;
  public int p;
  public int q;
  public View r;
  public float s;
  public float t;
  public int u;
  public int v;
  public int w;
  public int x;
  public View y;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" \nvideoViewScaleXby ");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" videoViewScaleYby ");
    localStringBuilder.append(this.t);
    localStringBuilder.append(" videoViewXBy ");
    localStringBuilder.append(this.u);
    localStringBuilder.append(" videoViewYBy ");
    localStringBuilder.append(this.v);
    localStringBuilder.append(" btnTopMarginOffset ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" btnLeftMarginOffset ");
    localStringBuilder.append(this.q);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAniDataAbs
 * JD-Core Version:    0.7.0.1
 */