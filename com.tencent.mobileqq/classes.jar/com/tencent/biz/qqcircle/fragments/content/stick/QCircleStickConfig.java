package com.tencent.biz.qqcircle.fragments.content.stick;

import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;

public class QCircleStickConfig
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private FeedBlockData e = null;
  private int f = 0;
  private boolean g = false;
  private ImageView.ScaleType h;
  
  public static QCircleStickConfig a()
  {
    return new QCircleStickConfig();
  }
  
  public QCircleStickConfig a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public QCircleStickConfig a(ImageView.ScaleType paramScaleType)
  {
    this.h = paramScaleType;
    return this;
  }
  
  public QCircleStickConfig a(FeedBlockData paramFeedBlockData)
  {
    this.e = paramFeedBlockData;
    return this;
  }
  
  public QCircleStickConfig a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public QCircleStickConfig b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public QCircleStickConfig c(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public QCircleStickConfig d(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public QCircleStickConfig e(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public ImageView.ScaleType f()
  {
    return this.h;
  }
  
  public FeedBlockData g()
  {
    return this.e;
  }
  
  public int h()
  {
    return this.f;
  }
  
  public boolean i()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleStickConfig
 * JD-Core Version:    0.7.0.1
 */