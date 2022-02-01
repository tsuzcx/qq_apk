package com.tencent.gdtad.basics.motivevideo.elements;

import android.view.View;

public class GdtMvAniDataAbs
  implements GdtMvAniData
{
  public float a;
  public float b;
  public View f;
  public View g;
  public View h;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" \nvideoViewScaleXby ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" videoViewScaleYby ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" videoViewXBy ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" videoViewYBy ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" btnTopMarginOffset ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" btnLeftMarginOffset ");
    localStringBuilder.append(this.k);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvAniDataAbs
 * JD-Core Version:    0.7.0.1
 */