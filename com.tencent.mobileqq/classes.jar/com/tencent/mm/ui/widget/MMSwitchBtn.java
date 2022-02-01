package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;
import com.tencent.mm.ui.g;

public class MMSwitchBtn
  extends View
{
  private String A;
  private MMSwitchBtn.SlideAnimation B = new MMSwitchBtn.SlideAnimation(this, null);
  private MMSwitchBtn.ISwitch C;
  private float a;
  private float b;
  private long c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private boolean i = false;
  private boolean j = false;
  private int k;
  private int l;
  private float m;
  private float n;
  private int o;
  private int p;
  private int q;
  private int r;
  private boolean s = false;
  private Paint t = new Paint(1);
  private RectF u = new RectF();
  private RectF v = new RectF();
  private int w;
  private int x;
  private int y;
  private String z;
  
  public MMSwitchBtn(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MMSwitchBtn));
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MMSwitchBtn));
  }
  
  private void a()
  {
    this.l = getResources().getDimensionPixelSize(2131296409);
    this.m = getResources().getDimensionPixelSize(2131296414);
    this.n = getResources().getDimensionPixelSize(2131296413);
    this.o = getResources().getColor(2131165364);
    this.p = getResources().getColor(2131168251);
    this.q = getResources().getColor(2131168252);
    this.r = getResources().getColor(2131165571);
    this.x = this.q;
    this.w = this.p;
    this.y = this.o;
    this.k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void a(float paramFloat)
  {
    RectF localRectF = this.v;
    localRectF.left += paramFloat;
    c();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    this.x = paramTypedArray.getColor(R.styleable.MMSwitchBtn_on_color, this.q);
    this.w = paramTypedArray.getColor(R.styleable.MMSwitchBtn_off_color, this.p);
    this.y = paramTypedArray.getColor(R.styleable.MMSwitchBtn_slide_color, this.o);
    this.z = paramTypedArray.getString(R.styleable.MMSwitchBtn_on_text);
    this.A = paramTypedArray.getString(R.styleable.MMSwitchBtn_off_text);
    paramTypedArray.recycle();
  }
  
  private void a(boolean paramBoolean)
  {
    this.i = true;
    this.B.reset();
    if (paramBoolean)
    {
      this.B.c = (this.e - this.v.left + this.l);
      this.B.a = 1;
    }
    else
    {
      this.B.c = (this.v.left);
      this.B.a = 0;
    }
    this.B.b = this.v.left;
    MMSwitchBtn.SlideAnimation localSlideAnimation = this.B;
    localSlideAnimation.setDuration(localSlideAnimation.c * 80L / this.e);
    startAnimation(this.B);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat1) < this.k / 10.0F) {
      return false;
    }
    float f1 = paramFloat2;
    if (paramFloat2 == 0.0F) {
      f1 = 1.0F;
    }
    return Math.abs(paramFloat1 / f1) > 3.0F;
  }
  
  private void b()
  {
    int i2 = this.h;
    int i1 = this.g;
    if (i2 < i1)
    {
      localRectF = this.v;
      localRectF.top = ((i1 - i2) / 2 + this.l);
      localRectF.bottom = (localRectF.top + this.h - this.l * 2);
    }
    else
    {
      localRectF = this.v;
      i2 = this.l;
      localRectF.top = i2;
      localRectF.bottom = (i1 - i2);
    }
    if (this.s)
    {
      localRectF = this.v;
      i1 = this.e;
      i2 = this.l;
      localRectF.left = (i1 + i2);
      localRectF.right = (this.f - i2);
      return;
    }
    RectF localRectF = this.v;
    i1 = this.l;
    localRectF.left = i1;
    localRectF.right = ((int)(this.n * 2.0F) + i1);
  }
  
  private void b(boolean paramBoolean)
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void c()
  {
    float f1 = this.v.left;
    int i1 = this.l;
    if (f1 < i1) {
      this.v.left = i1;
    }
    f1 = this.v.left;
    i1 = this.e;
    int i2 = this.l;
    if (f1 > i1 + i2) {
      this.v.left = (i1 + i2);
    }
    RectF localRectF = this.v;
    localRectF.right = (localRectF.left + (int)(this.n * 2.0F));
  }
  
  private void d()
  {
    if (this.v.left > this.d)
    {
      a(true);
      return;
    }
    a(false);
  }
  
  public boolean isCheck()
  {
    return this.s;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1;
    if (!isEnabled())
    {
      i1 = this.r;
      this.t.setAlpha(38);
    }
    else
    {
      i1 = this.w;
      this.t.setAlpha(255);
    }
    this.t.setColor(i1);
    Object localObject = this.u;
    float f1 = this.m;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.t);
    this.t.setColor(this.x);
    this.t.setAlpha(Math.min(255, (int)((this.v.left - this.l) / this.e * 255.0F)));
    localObject = this.u;
    f1 = this.m;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.t);
    this.t.setColor(this.y);
    localObject = this.v;
    f1 = this.n;
    paramCanvas.drawRoundRect((RectF)localObject, f1, f1, this.t);
    if ((this.z != null) && (this.A != null))
    {
      localObject = new Paint();
      ((Paint)localObject).setTextSize(getResources().getDimension(2131296405));
      ((Paint)localObject).setTextAlign(Paint.Align.CENTER);
      ((Paint)localObject).setColor(getResources().getColor(2131168471));
      ((Paint)localObject).setAntiAlias(true);
      i1 = Math.min(255, (int)((this.v.left - this.l) / this.e * 255.0F));
      Rect localRect = new Rect();
      String str = this.z;
      ((Paint)localObject).getTextBounds(str, 0, str.length(), localRect);
      ((Paint)localObject).setAlpha(i1);
      float f2 = (this.u.left + this.u.right) / 2.0F;
      float f3 = this.n;
      float f4 = g.a(getContext(), 1);
      f1 = (this.u.top + this.u.bottom) / 2.0F + localRect.height() / 2.0F - g.a(getContext(), 1);
      paramCanvas.drawText(this.z, f2 - f3 + f4, f1, (Paint)localObject);
      f2 = (this.u.left + this.u.right) / 2.0F;
      f3 = this.n;
      f4 = g.a(getContext(), 1);
      ((Paint)localObject).setAlpha(255 - i1);
      paramCanvas.drawText(this.A, f2 + f3 - f4, f1, (Paint)localObject);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = (paramInt3 - paramInt1);
    this.g = (paramInt4 - paramInt2);
    this.e = (this.f - (int)(this.n * 2.0F) - this.l * 2);
    this.d = (this.e / 2);
    this.h = getResources().getDimensionPixelSize(2131296412);
    paramInt1 = this.h;
    paramInt2 = this.g;
    if (paramInt1 < paramInt2)
    {
      localRectF = this.u;
      localRectF.top = ((paramInt2 - paramInt1) / 2);
      localRectF.bottom = (localRectF.top + this.h);
    }
    else
    {
      localRectF = this.u;
      localRectF.top = 0.0F;
      localRectF.bottom = paramInt2;
    }
    RectF localRectF = this.u;
    localRectF.left = 0.0F;
    localRectF.right = this.f;
    b();
    this.t.setStyle(Paint.Style.FILL);
    this.t.setColor(this.p);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.i) {
      return true;
    }
    if (!isEnabled()) {
      return true;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            if (this.j) {
              d();
            }
            b(false);
            this.j = false;
          }
        }
        else
        {
          if (this.j)
          {
            b(true);
            a(paramMotionEvent.getX() - this.a);
          }
          else if (a(paramMotionEvent.getX() - this.a, paramMotionEvent.getY() - this.b))
          {
            this.j = true;
            b(true);
          }
          this.a = paramMotionEvent.getX();
          this.b = paramMotionEvent.getY();
        }
      }
      else
      {
        if (SystemClock.elapsedRealtime() - this.c < 300L) {
          a(this.s ^ true);
        } else {
          d();
        }
        b(false);
        this.j = false;
      }
    }
    else
    {
      clearAnimation();
      this.a = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      this.c = SystemClock.elapsedRealtime();
      this.j = false;
    }
    if (this.j) {
      invalidate();
    }
    return true;
  }
  
  public void setCheck(boolean paramBoolean)
  {
    if (this.s != paramBoolean)
    {
      clearAnimation();
      this.s = paramBoolean;
      b();
      this.i = false;
      invalidate();
    }
    updateDescription(paramBoolean);
  }
  
  public void setSwitchListener(MMSwitchBtn.ISwitch paramISwitch)
  {
    this.C = paramISwitch;
  }
  
  public void updateDescription(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = getContext().getString(2131916954);
    } else {
      str = getContext().getString(2131916958);
    }
    setContentDescription(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMSwitchBtn
 * JD-Core Version:    0.7.0.1
 */