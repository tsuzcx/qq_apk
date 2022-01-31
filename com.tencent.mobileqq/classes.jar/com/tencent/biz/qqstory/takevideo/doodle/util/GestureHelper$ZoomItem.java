package com.tencent.biz.qqstory.takevideo.doodle.util;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleItem;

public abstract class GestureHelper$ZoomItem
  implements DoodleItem
{
  public ValueAnimator a;
  public PointF a;
  public boolean b = true;
  public boolean c;
  public boolean d;
  public int e;
  public float j = 1.0F;
  public float k;
  public float l;
  public float m;
  public float n;
  public float o;
  public float p = 1.0F;
  
  public GestureHelper$ZoomItem(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.a = new PointF(paramPointF.x, paramPointF.y);
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.l = paramFloat3;
    this.m = paramFloat4;
    this.n = paramFloat5;
    this.o = paramFloat6;
    this.b = paramBoolean;
  }
  
  public GestureHelper$ZoomItem(ZoomItem paramZoomItem, float paramFloat)
  {
    this.a = new PointF(paramZoomItem.a.x * paramFloat, paramZoomItem.a.y * paramFloat);
    paramZoomItem.j *= paramFloat;
    this.k = paramZoomItem.k;
    paramZoomItem.l *= paramFloat;
    paramZoomItem.m *= paramFloat;
    this.n = paramZoomItem.n;
    this.o = paramZoomItem.o;
    this.b = paramZoomItem.b;
  }
  
  public void a(Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem
 * JD-Core Version:    0.7.0.1
 */