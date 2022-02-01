package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.pz.a;
import com.tencent.mm.plugin.appbrand.widget.base.d;

public final class q
  extends z
{
  final ah<q> a = new ah(this);
  private final InputFilter b = new q.4(this);
  private float c;
  private float d = 0.0F;
  private float e = 1.2F;
  private float f = getTextSize();
  private a g;
  private boolean h = false;
  private MotionEvent i;
  private boolean j = false;
  
  public q(Context paramContext)
  {
    super(paramContext);
    super.setSingleLine(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setVerticalScrollbarPosition(2);
    super.setSpannableFactory(new q.1(this));
    super.a(new q.2(this));
    super.setOnLongClickListener(new q.3(this));
    this.c = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setAutoHeight(false);
    a(0.0F, false);
  }
  
  private void a(float paramFloat, boolean paramBoolean)
  {
    float f1 = paramFloat;
    if (paramFloat <= 0.0F) {
      f1 = this.e * this.f + this.d;
    }
    a locala = this.g;
    if ((locala != null) && (!locala.a(f1))) {
      return;
    }
    locala = this.g;
    if (locala == null) {
      this.g = new a(f1, 17);
    } else {
      locala.b(f1);
    }
    if (!paramBoolean) {
      return;
    }
    if (hasFocus())
    {
      invalidate();
      return;
    }
    k();
  }
  
  private void f()
  {
    a(0.0F, true);
  }
  
  private void q()
  {
    this.j = false;
    MotionEvent localMotionEvent = this.i;
    if (localMotionEvent != null)
    {
      localMotionEvent.recycle();
      this.i = null;
    }
  }
  
  protected void A_()
  {
    if (this.h)
    {
      if (getMeasuredHeight() > getMaxHeight())
      {
        setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
        return;
      }
      if ((getMeasuredHeight() < getMinHeight()) && (getMinHeight() > 0)) {
        setMeasuredDimension(getMeasuredWidth(), getMinHeight());
      }
    }
  }
  
  Editable a(Editable paramEditable)
  {
    paramEditable = super.a(paramEditable);
    if ((this.g != null) && (!TextUtils.isEmpty(paramEditable))) {
      paramEditable.setSpan(this.g, 0, paramEditable.length(), 18);
    }
    return paramEditable;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (!isEnabled()) {
      return;
    }
    if (a())
    {
      int k = ak.a.a(this, paramFloat1 + getScrollX(), paramFloat2 + getScrollY());
      if (k >= 0) {
        setSelection(k);
      }
    }
    super.performClick();
  }
  
  public boolean a()
  {
    if (!this.h)
    {
      g();
      getMeasuredHeight();
    }
    return (!isFocusable()) && (!b());
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    if (g() <= getHeight()) {
      return false;
    }
    return super.canScrollVertically(paramInt);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e()
  {
    ak.a(this).restartInput(this);
  }
  
  public View getInputPanel()
  {
    return x.c(this);
  }
  
  public int getLineHeight()
  {
    a locala = this.g;
    if (locala != null) {
      return locala.a();
    }
    return super.getLineHeight();
  }
  
  @Deprecated
  public float getLineSpacingExtra()
  {
    return super.getLineSpacingExtra();
  }
  
  @Deprecated
  public float getLineSpacingMultiplier()
  {
    return super.getLineSpacingMultiplier();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((a()) && ((getParent() instanceof d)))
    {
      if ((paramMotionEvent.getActionMasked() == 0) && (!((d)getParent()).a(paramMotionEvent))) {
        return false;
      }
      return this.a.a(paramMotionEvent);
    }
    int k = paramMotionEvent.getActionMasked();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3) {
            break label263;
          }
        }
        else
        {
          if (!this.j) {
            break label263;
          }
          MotionEvent localMotionEvent = this.i;
          float f1 = localMotionEvent.getX(localMotionEvent.getActionIndex());
          localMotionEvent = this.i;
          float f2 = localMotionEvent.getY(localMotionEvent.getActionIndex());
          float f3 = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
          float f4 = paramMotionEvent.getY(paramMotionEvent.getActionIndex());
          if ((Math.abs(f1 - f3) <= this.c) && (Math.abs(f2 - f4) <= this.c)) {
            break label263;
          }
          cancelLongPress();
          setPressed(false);
          this.j = false;
          break label263;
        }
      }
      q();
      if (this.j)
      {
        k = ak.a.a(this, paramMotionEvent.getX(paramMotionEvent.getActionIndex()), paramMotionEvent.getY(paramMotionEvent.getActionIndex()));
        if (k >= 0) {
          setSelection(k);
        }
      }
      if (getParent() == null) {
        return true;
      }
    }
    else
    {
      this.i = MotionEvent.obtain(paramMotionEvent);
      this.j = true;
    }
    label263:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performHapticFeedback(int paramInt1, int paramInt2)
  {
    return super.performHapticFeedback(paramInt1, paramInt2);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    super.scrollBy(paramInt1, paramInt2);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setAutoHeight(boolean paramBoolean)
  {
    this.h = paramBoolean;
    setVerticalScrollBarEnabled(this.h ^ true);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    InputFilter[] arrayOfInputFilter = paramArrayOfInputFilter;
    if (this.b != null)
    {
      int k = 0;
      arrayOfInputFilter = paramArrayOfInputFilter;
      if (paramArrayOfInputFilter == null) {
        arrayOfInputFilter = new InputFilter[0];
      }
      paramArrayOfInputFilter = new InputFilter[arrayOfInputFilter.length + 1];
      while (k < arrayOfInputFilter.length)
      {
        paramArrayOfInputFilter[k] = arrayOfInputFilter[k];
        k += 1;
      }
      paramArrayOfInputFilter[k] = this.b;
      arrayOfInputFilter = paramArrayOfInputFilter;
    }
    super.setFilters(arrayOfInputFilter);
  }
  
  public void setGravity(int paramInt)
  {
    super.setGravity(paramInt & 0xFFFFFFAF & 0xFFFFFFEF | 0x30);
  }
  
  public final void setInputType(int paramInt)
  {
    super.setInputType(paramInt | 0x20000);
  }
  
  @MainThread
  public void setLineHeight(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    a(paramFloat, true);
  }
  
  @MainThread
  public void setLineSpace(float paramFloat)
  {
    setLineSpacing(paramFloat, this.e);
  }
  
  public void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
    f();
  }
  
  public void setSingleLine(boolean paramBoolean) {}
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.f = TypedValue.applyDimension(paramInt, paramFloat, getResources().getDisplayMetrics());
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.q
 * JD-Core Version:    0.7.0.1
 */