package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RingView
  extends View
{
  protected RectF o = new RectF();
  protected List<RingView.DrawInfo> p = new ArrayList();
  
  public RingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected static void a()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      return;
    }
    throw new IllegalStateException("not main thread !");
  }
  
  public void a(RingView.DrawInfo paramDrawInfo)
  {
    
    if (paramDrawInfo != null)
    {
      if (!this.o.isEmpty()) {
        paramDrawInfo.a((int)this.o.centerX(), (int)this.o.centerY(), (int)this.o.height() / 2);
      }
      this.p.add(paramDrawInfo);
      return;
    }
    throw new NullPointerException("drawInfo should not be NULL");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    Iterator localIterator = this.p.iterator();
    while (localIterator.hasNext())
    {
      RingView.DrawInfo localDrawInfo = (RingView.DrawInfo)localIterator.next();
      localDrawInfo.a((int)this.o.centerX(), (int)this.o.centerY(), (int)this.o.height() / 2);
      localDrawInfo.a(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = super.getWidth();
    paramInt3 = super.getHeight();
    paramInt2 = super.getPaddingLeft();
    int j = super.getPaddingRight();
    paramInt1 = super.getPaddingTop();
    paramInt4 = super.getPaddingBottom();
    i = i - paramInt2 - j;
    paramInt4 = paramInt3 - paramInt1 - paramInt4;
    paramInt3 = Math.min(i, paramInt4);
    paramInt2 += (i - paramInt3) / 2;
    paramInt1 += (paramInt4 - paramInt3) / 2;
    Object localObject = this.o;
    ((RectF)localObject).left = paramInt2;
    ((RectF)localObject).right = (paramInt2 + paramInt3);
    ((RectF)localObject).top = paramInt1;
    ((RectF)localObject).bottom = (paramInt3 + paramInt1);
    localObject = this.p.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RingView.DrawInfo)((Iterator)localObject).next()).a((int)this.o.centerX(), (int)this.o.centerY(), (int)this.o.height() / 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.RingView
 * JD-Core Version:    0.7.0.1
 */