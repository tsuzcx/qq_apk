package com.tencent.biz.qqcircle.fragments.content.stick;

import android.graphics.Rect;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;

public class QCircleExpandStickView$QCircleLoadStickParam
{
  private FeedBlockData a;
  private Rect b;
  private Rect c;
  private Rect d;
  private int e;
  private int f;
  private boolean g;
  private ImageView.ScaleType h;
  private boolean i;
  
  public static QCircleLoadStickParam a()
  {
    return new QCircleLoadStickParam();
  }
  
  public QCircleLoadStickParam a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public QCircleLoadStickParam a(Rect paramRect)
  {
    this.b = paramRect;
    return this;
  }
  
  public QCircleLoadStickParam a(ImageView.ScaleType paramScaleType)
  {
    this.h = paramScaleType;
    return this;
  }
  
  public QCircleLoadStickParam a(FeedBlockData paramFeedBlockData)
  {
    this.a = paramFeedBlockData;
    return this;
  }
  
  public QCircleLoadStickParam a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public QCircleLoadStickParam b(Rect paramRect)
  {
    this.c = paramRect;
    return this;
  }
  
  public QCircleLoadStickParam b(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public FeedBlockData c()
  {
    return this.a;
  }
  
  public QCircleLoadStickParam c(Rect paramRect)
  {
    this.d = paramRect;
    return this;
  }
  
  public Rect d()
  {
    return this.b;
  }
  
  public Rect e()
  {
    return this.c;
  }
  
  public Rect f()
  {
    return this.d;
  }
  
  public int g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public ImageView.ScaleType i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView.QCircleLoadStickParam
 * JD-Core Version:    0.7.0.1
 */