package com.tencent.biz.qqstory.view.widget.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class BubbleTextView
  extends TextView
{
  public float a = UIUtils.a(BaseApplicationImpl.getContext(), 11.0F);
  public float b = UIUtils.a(BaseApplicationImpl.getContext(), 3.0F);
  public float c = UIUtils.a(BaseApplicationImpl.getContext(), 5.0F);
  public float d = 50.0F;
  public int e = getResources().getColor(2131167368);
  public int f = 3;
  public boolean g = true;
  public int h = 0;
  private BubbleDrawable i;
  
  public BubbleTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(0, paramInt1, 0, paramInt2);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i = new BubbleDrawable();
    this.i.a = new RectF(paramInt1, paramInt3, paramInt2, paramInt4);
    BubbleDrawable localBubbleDrawable = this.i;
    localBubbleDrawable.k = this.f;
    localBubbleDrawable.l = this.h;
    localBubbleDrawable.f = this.b;
    localBubbleDrawable.g = this.c;
    localBubbleDrawable.e = this.a;
    localBubbleDrawable.i = this.e;
    localBubbleDrawable.h = this.d;
    localBubbleDrawable.m = this.g;
  }
  
  private void c()
  {
    a(getWidth(), getHeight());
  }
  
  private void d()
  {
    int j = getPaddingLeft();
    int k = getPaddingRight();
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i1 = this.f;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3) {
            n = (int)(n + this.c);
          }
        }
        else {
          m = (int)(m + this.c);
        }
      }
      else {
        k = (int)(k + this.a);
      }
    }
    else {
      j = (int)(j + this.a);
    }
    setPadding(j, m, k, n);
  }
  
  public void a()
  {
    b();
    d();
  }
  
  protected void b() {}
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    BubbleDrawable localBubbleDrawable = this.i;
    if (localBubbleDrawable != null) {
      localBubbleDrawable.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      a(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView
 * JD-Core Version:    0.7.0.1
 */