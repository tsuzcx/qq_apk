package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;

public class IndexBar
  extends View
{
  private IndexBar.OnIndexBarTouchListener a;
  private boolean b;
  private String[] c;
  private int d = -1;
  private Paint e;
  private Paint f;
  private float g;
  private float h;
  private int i;
  private int j;
  private int k;
  private int l;
  private float m;
  private float n;
  
  public IndexBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndexBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IndexBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    if (i1 == 1073741824) {
      return i2;
    }
    paramInt1 = paramInt2;
    if (i1 == -2147483648) {
      paramInt1 = Math.min(paramInt2, i2);
    }
    return paramInt1;
  }
  
  private void a()
  {
    this.e = new Paint();
    this.e.setTextSize(this.g);
    this.e.setColor(this.i);
    this.e.setTypeface(Typeface.DEFAULT);
    this.e.setTextAlign(Paint.Align.CENTER);
    this.e.setAntiAlias(true);
    this.f = new Paint();
    this.f.setTextSize(this.g);
    this.f.setTypeface(Typeface.DEFAULT);
    this.f.setTextAlign(Paint.Align.CENTER);
    this.f.setColor(this.j);
    this.f.setAntiAlias(true);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.i = paramContext.getResources().getColor(17170444);
    this.j = paramContext.getResources().getColor(17170444);
    this.g = paramContext.getResources().getDimensionPixelSize(2131297645);
    this.h = paramContext.getResources().getDimensionPixelSize(2131297646);
    this.m = paramContext.getResources().getDimension(2131297642);
    this.n = paramContext.getResources().getDimension(2131297644);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.IndexBar);
      this.i = paramContext.getColor(2, this.i);
      this.j = paramContext.getColor(3, this.j);
      this.g = paramContext.getDimension(5, this.g);
      this.h = paramContext.getDimension(6, this.h);
      this.m = paramContext.getDimension(1, this.m);
      this.n = paramContext.getDimension(4, this.n);
      paramContext.recycle();
    }
    a();
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    int i3 = localObject.length;
    if (i3 <= 0) {
      return;
    }
    int i4 = this.l / i3;
    int i2;
    for (int i1 = 0; i1 < i3; i1 = i2)
    {
      if (i1 == this.d) {
        localObject = this.f;
      } else {
        localObject = this.e;
      }
      float f1 = this.k / 2;
      i2 = i1 + 1;
      float f2 = i4 * i2;
      float f3 = ((Paint)localObject).measureText(this.c[i1]) / 2.0F;
      paramCanvas.drawText(this.c[i1], f1, f2 - f3, (Paint)localObject);
    }
  }
  
  public String[] getLetters()
  {
    return this.c;
  }
  
  public IndexBar.OnIndexBarTouchListener getListener()
  {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.k = getWidth();
    this.l = getHeight();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = new Rect();
    Paint localPaint = this.e;
    int i1 = 0;
    localPaint.getTextBounds("W", 0, 1, (Rect)localObject);
    int i2 = ((Rect)localObject).width();
    int i3 = (int)this.n;
    int i6 = ((Rect)localObject).height();
    int i7 = (int)this.n;
    int i4 = getPaddingLeft();
    int i5 = getPaddingRight();
    localObject = this.c;
    if (localObject != null) {
      i1 = (i6 + i7) * localObject.length;
    }
    i6 = getPaddingTop();
    i7 = getPaddingBottom();
    setMeasuredDimension(a(paramInt1, i4 + (i2 + i3) + i5), a(paramInt2, i6 + i1 + i7));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int i3 = this.d;
    Object localObject = this.c;
    int i1;
    if (localObject != null) {
      i1 = (int)(f1 / this.l * localObject.length);
    } else {
      i1 = -1;
    }
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 == 2) {
          break label101;
        }
        if (i2 != 3) {
          return false;
        }
      }
      this.b = false;
      paramMotionEvent = this.a;
      if (paramMotionEvent != null) {
        paramMotionEvent.c(false);
      }
      invalidate();
      return true;
    }
    label101:
    if (i3 != i1)
    {
      localObject = this.c;
      if ((localObject != null) && (i1 >= 0) && (i1 < localObject.length))
      {
        this.d = i1;
        if (this.a != null)
        {
          localObject = new Rect();
          Paint localPaint = this.e;
          String[] arrayOfString = this.c;
          i3 = this.d;
          localPaint.getTextBounds(arrayOfString[i3], 0, arrayOfString[i3].length(), (Rect)localObject);
          localObject = this.c;
          i3 = localObject.length;
          i3 = this.l / i3;
          int i4 = this.d;
          f1 = i3 * (i4 + 1);
          float f2 = this.e.measureText(localObject[i4]) / 2.0F;
          this.a.a(this.c[i1], i2, f1 - f2);
        }
      }
      invalidate();
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.b = true;
      paramMotionEvent = this.a;
      if (paramMotionEvent != null) {
        paramMotionEvent.c(true);
      }
      invalidate();
    }
    return true;
  }
  
  public void setChooseIndex(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setLetters(String[] paramArrayOfString)
  {
    this.c = paramArrayOfString;
    requestLayout();
    invalidate();
  }
  
  public void setOnIndexBarTouchListener(IndexBar.OnIndexBarTouchListener paramOnIndexBarTouchListener)
  {
    this.a = paramOnIndexBarTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.IndexBar
 * JD-Core Version:    0.7.0.1
 */