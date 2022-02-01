package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.danmaku.tool.TouchPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewDanmakuRender$ViewHolder
{
  protected final View a;
  private RectF b = new RectF();
  private Paint c = new Paint();
  
  public ViewDanmakuRender$ViewHolder(View paramView)
  {
    if (paramView != null)
    {
      this.a = paramView;
      return;
    }
    throw new IllegalArgumentException("itemView may not be null");
  }
  
  private View a(View paramView, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF();
    Iterator localIterator = paramView.getTouchables().iterator();
    int i = 0;
    View localView1 = null;
    while (localIterator.hasNext())
    {
      View localView2 = (View)localIterator.next();
      float f1 = localView2.getX();
      float f2 = localView2.getY();
      localRectF.set(f1, f2, localView2.getMeasuredWidth() + f1, localView2.getMeasuredWidth() + f2);
      if (localRectF.contains(paramFloat1, paramFloat2)) {
        if (localView2.equals(paramView)) {
          i = 1;
        } else if ((localView2 instanceof ViewGroup)) {
          localView1 = a(paramView, paramFloat1 - f1, paramFloat2 - paramFloat1);
        } else {
          return localView2;
        }
      }
    }
    if ((i != 0) && (localView1 == null)) {
      return paramView;
    }
    return localView1;
  }
  
  public int a()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View a(TouchPoint paramTouchPoint)
  {
    return a(this.a, paramTouchPoint.a(), paramTouchPoint.b());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(Canvas paramCanvas)
  {
    this.b.set(0.0F, 0.0F, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
    this.c.setAlpha((int)(this.a.getAlpha() * 255.0F));
    int i = paramCanvas.saveLayer(this.b, this.c, 31);
    this.a.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int b()
  {
    return this.a.getMeasuredHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.ViewDanmakuRender.ViewHolder
 * JD-Core Version:    0.7.0.1
 */