package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DotAnimationView
  extends View
{
  private static String a = "DotAnimationView";
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private Paint j;
  private List<DotAnimationView.Dot> k = new ArrayList(3);
  private boolean l = false;
  
  public DotAnimationView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public DotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public DotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      DotAnimationView.Dot localDot = (DotAnimationView.Dot)localIterator.next();
      paramCanvas.drawCircle(getWidth() / 2 + localDot.b, getHeight() / 2, localDot.a, this.j);
    }
  }
  
  private void b()
  {
    this.b = UIUtils.a(getContext(), -20.0F);
    this.c = UIUtils.a(getContext(), -50.0F);
    this.d = UIUtils.a(getContext(), -70.0F);
    this.e = UIUtils.a(getContext(), -95.0F);
    this.f = UIUtils.a(getContext(), 3.0F);
    this.g = UIUtils.a(getContext(), 6.0F);
    this.h = UIUtils.a(getContext(), 30.0F);
    this.i = UIUtils.a(getContext(), -20.0F);
    this.j = new Paint();
    this.j.setColor(Color.parseColor("#DDDEE2"));
    this.j.setStyle(Paint.Style.FILL);
    this.j.setStrokeWidth(0.1F);
    int m = 0;
    while (m < 3)
    {
      this.k.add(new DotAnimationView.Dot(this, null));
      m += 1;
    }
  }
  
  public void a()
  {
    if (this.l) {
      return;
    }
    this.l = true;
    int m = 0;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      DotAnimationView.Dot localDot = (DotAnimationView.Dot)localIterator.next();
      if ((localDot.a != 0.0F) || (localDot.b != 0.0F)) {
        m = 1;
      }
      localDot.a = 0.0F;
      localDot.b = 0.0F;
    }
    if (m != 0)
    {
      setTranslationY(0.0F);
      invalidate();
    }
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return;
    }
    int m = 0;
    this.l = false;
    int n = this.b;
    Object localObject;
    DotAnimationView.Dot localDot;
    if (paramFloat > n)
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDot = (DotAnimationView.Dot)((Iterator)localObject).next();
        localDot.a = 0.0F;
        localDot.b = 0.0F;
      }
      ((DotAnimationView.Dot)this.k.get(1)).a = (this.g * (Math.abs(paramFloat) / Math.abs(this.b)));
    }
    else
    {
      int i1 = this.c;
      if (paramFloat > i1)
      {
        paramFloat = (n - paramFloat) / (n - i1);
        while (m < this.k.size())
        {
          ((DotAnimationView.Dot)this.k.get(m)).b = (((DotAnimationView.Dot)this.k.get(m)).c * paramFloat);
          if (m == 1)
          {
            localObject = (DotAnimationView.Dot)this.k.get(m);
            n = this.g;
            ((DotAnimationView.Dot)localObject).a = (n - (n - this.f) * paramFloat);
          }
          else
          {
            ((DotAnimationView.Dot)this.k.get(m)).a = this.f;
          }
          m += 1;
        }
      }
      if (paramFloat > this.d)
      {
        localObject = this.k.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDot = (DotAnimationView.Dot)((Iterator)localObject).next();
          localDot.a = this.f;
          localDot.b = localDot.c;
        }
      }
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDot = (DotAnimationView.Dot)((Iterator)localObject).next();
        localDot.b = localDot.c;
      }
      m = this.d;
      n = this.e;
      float f1 = (n - m) / 2 + m;
      float f2 = n;
      if (paramFloat > f1)
      {
        paramFloat = (m - paramFloat) / (m - f1);
        localObject = (DotAnimationView.Dot)this.k.get(0);
        localDot = (DotAnimationView.Dot)this.k.get(2);
        m = this.f;
        paramFloat = m - m * paramFloat;
        localDot.a = paramFloat;
        ((DotAnimationView.Dot)localObject).a = paramFloat;
        ((DotAnimationView.Dot)this.k.get(1)).a = this.f;
      }
      else if (paramFloat > f2)
      {
        paramFloat = (f1 - paramFloat) / (f1 - f2);
        localObject = (DotAnimationView.Dot)this.k.get(0);
        ((DotAnimationView.Dot)this.k.get(2)).a = 0.0F;
        ((DotAnimationView.Dot)localObject).a = 0.0F;
        localObject = (DotAnimationView.Dot)this.k.get(1);
        m = this.f;
        ((DotAnimationView.Dot)localObject).a = (m - m * paramFloat);
      }
      else
      {
        localObject = this.k.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((DotAnimationView.Dot)((Iterator)localObject).next()).a = 0.0F;
        }
      }
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      DotAnimationView.Dot localDot = (DotAnimationView.Dot)localIterator.next();
      localDot.a = 0.0F;
      localDot.b = 0.0F;
      localDot.c = 0.0F;
    }
    paramInt1 = this.h;
    ((DotAnimationView.Dot)this.k.get(0)).c = this.i;
    ((DotAnimationView.Dot)this.k.get(1)).c = 0.0F;
    ((DotAnimationView.Dot)this.k.get(2)).c = (-((DotAnimationView.Dot)this.k.get(0)).c);
    this.l = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.DotAnimationView
 * JD-Core Version:    0.7.0.1
 */