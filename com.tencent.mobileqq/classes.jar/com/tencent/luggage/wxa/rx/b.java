package com.tencent.luggage.wxa.rx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import com.tencent.neattextview.textview.layout.NeatLayout;
import com.tencent.neattextview.textview.layout.c;

public class b
  extends View
  implements a
{
  private static final LruCache<String, b.d> a = new LruCache(800);
  private static final HandlerThread b = new HandlerThread("PreMeasuredThread", -8);
  private static Handler c;
  private int A;
  private TextUtils.TruncateAt B;
  private float C;
  private boolean D;
  private b.c E;
  private com.tencent.neattextview.textview.layout.a F;
  private c d;
  private boolean e;
  private TextView f;
  private b.a g;
  private TextPaint h;
  private ColorStateList i;
  private ColorStateList j;
  private ColorStateList k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private float s;
  private CharSequence t;
  private TextView.BufferType u;
  private Spannable.Factory v;
  private CharSequence w;
  private d x;
  private boolean y;
  private b.b z;
  
  static
  {
    b.start();
    Looper localLooper = b.getLooper();
    if (localLooper != null) {
      c = new Handler(localLooper);
    }
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append(this.h.getTextSize());
    return localStringBuilder.toString();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    Object localObject1;
    if (TextUtils.isEmpty(this.t)) {
      localObject1 = this.w;
    } else {
      localObject1 = this.t;
    }
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    int i1 = 0;
    if (!bool)
    {
      localObject3 = (b.d)a.get(a(((CharSequence)localObject1).toString()));
      if (localObject3 != null)
      {
        localObject2 = ((b.d)localObject3).b;
      }
      else
      {
        localObject3 = this.E;
        if (localObject3 != null) {
          localObject2 = ((b.c)localObject3).a(this.h);
        }
        i1 = 1;
      }
    }
    else
    {
      localObject1 = "";
      localObject2 = localObject3;
    }
    this.d = new NeatLayout((CharSequence)localObject1, (float[])localObject2);
    this.d.a(getPaint(), paramFloat1, paramFloat2, getPaddingLeft(), getPaddingTop(), this.s, this.n, this.B, this.C, this.D, this.A);
    if (i1 != 0) {
      a.put(a(this.d.b()), new b.d(this.e, this.d.c()));
    }
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    b.d locald = (b.d)a.get(a(paramCharSequence));
    if (locald == null)
    {
      boolean bool = paramCharSequence.matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$") ^ true;
      a.put(a(paramCharSequence), new b.d(bool, null));
      return bool;
    }
    return locald.a;
  }
  
  private void d()
  {
    getWrappedTextView().setEllipsize(this.B);
  }
  
  private void e()
  {
    this.d = null;
    Handler localHandler = c;
    if (localHandler != null)
    {
      if (this.t == null)
      {
        localObject = this.w;
        if (localObject != null)
        {
          localObject = new b.c(((CharSequence)localObject).toString(), this.h);
          this.E = ((b.c)localObject);
          localHandler.post((Runnable)localObject);
          break label107;
        }
      }
      Object localObject = this.t;
      if (localObject != null)
      {
        localHandler = c;
        localObject = new b.c(((CharSequence)localObject).toString(), this.h);
        this.E = ((b.c)localObject);
        localHandler.post((Runnable)localObject);
      }
      else
      {
        return;
      }
    }
    label107:
    requestLayout();
    invalidate();
  }
  
  private void f()
  {
    int i1 = this.i.getColorForState(getDrawableState(), 0);
    if (i1 != this.l)
    {
      this.l = i1;
      i2 = 1;
    }
    else
    {
      i2 = 0;
    }
    Object localObject = this.k;
    i1 = i2;
    int i3;
    if (localObject != null)
    {
      i3 = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
      i1 = i2;
      if (i3 != this.h.linkColor)
      {
        this.h.linkColor = i3;
        i1 = 1;
      }
    }
    localObject = this.j;
    int i2 = i1;
    if (localObject != null)
    {
      i3 = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
      i2 = i1;
      if (i3 != this.m)
      {
        this.m = i3;
        localObject = this.t;
        if (localObject != null)
        {
          i2 = i1;
          if (((CharSequence)localObject).length() != 0) {}
        }
        else
        {
          i2 = 1;
        }
      }
    }
    if (i2 != 0) {
      invalidate();
    }
  }
  
  private Layout getWrappedTxtLayout()
  {
    TextView localTextView = getWrappedTextView();
    if (localTextView != null) {
      return localTextView.getLayout();
    }
    return null;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.h.getTextSize())
    {
      this.h.setTextSize(paramFloat);
      if (this.d != null)
      {
        e();
        requestLayout();
        invalidate();
      }
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
  
  public void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.u = paramBufferType;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (paramBufferType == TextView.BufferType.NORMAL)
    {
      paramCharSequence = TextUtils.stringOrSpannedString((CharSequence)localObject);
    }
    else
    {
      paramCharSequence = (CharSequence)localObject;
      if (paramBufferType == TextView.BufferType.SPANNABLE) {
        paramCharSequence = this.v.newSpannable((CharSequence)localObject);
      }
    }
    this.t = paramCharSequence;
    boolean bool;
    if ((c()) && (!a(paramCharSequence))) {
      bool = false;
    } else {
      bool = true;
    }
    this.e = bool;
    if (this.e)
    {
      if (getLayoutParams() != null) {
        getWrappedTextView().setLayoutParams(getLayoutParams());
      }
      getWrappedTextView().setText(paramCharSequence, paramBufferType);
      this.t = getWrappedTextView().getText();
      requestLayout();
      invalidate();
    }
    else
    {
      e();
    }
    paramBufferType = this.t;
    if ((paramBufferType instanceof Spannable)) {
      ((Spannable)paramBufferType).setSpan(this.g, 0, paramCharSequence.length(), 18);
    }
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public CharSequence b()
  {
    CharSequence localCharSequence = this.t;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public boolean c()
  {
    return this.y;
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.j != null) {
      return this.m;
    }
    return this.l;
  }
  
  public final int getCurrentTextColor()
  {
    return this.l;
  }
  
  public CharSequence getHint()
  {
    return this.w;
  }
  
  public float getHorizontalOffset()
  {
    if (((this.A & 0x7) != 3) && (this.d != null)) {
      return (getMeasuredWidth() - this.d.e()[0]) / 2.0F;
    }
    return getPaddingLeft();
  }
  
  public com.tencent.neattextview.textview.layout.a getLayout()
  {
    Object localObject = this.F;
    if (localObject != null) {
      return localObject;
    }
    localObject = new b.1(this);
    this.F = ((com.tencent.neattextview.textview.layout.a)localObject);
    return localObject;
  }
  
  public int getLineCount()
  {
    c localc = this.d;
    if (localc != null) {
      return localc.g();
    }
    return 0;
  }
  
  public int getLineHeight()
  {
    return Math.round(this.h.getFontMetricsInt(null) + this.s);
  }
  
  public int getMaxHeight()
  {
    return this.p;
  }
  
  public int getMaxLines()
  {
    return this.n;
  }
  
  public int getMaxWidth()
  {
    return this.o;
  }
  
  public b.b getOnDoubleClickListener()
  {
    return this.z;
  }
  
  public TextPaint getPaint()
  {
    return this.h;
  }
  
  public int getTextGravity()
  {
    return this.A;
  }
  
  public float getTextSize()
  {
    return getPaint().getTextSize();
  }
  
  public float getVerticalOffset()
  {
    if (((this.A & 0x70) != 48) && (this.d != null)) {
      return (getMeasuredHeight() - this.d.e()[1]) / 2.0F;
    }
    return getPaddingTop();
  }
  
  public TextView getWrappedTextView()
  {
    return this.f;
  }
  
  public void invalidate()
  {
    super.invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = this.l;
    int i1 = i2;
    if (!TextUtils.isEmpty(this.w))
    {
      i1 = i2;
      if (TextUtils.isEmpty(this.t))
      {
        i1 = i2;
        if (this.j != null) {
          i1 = this.m;
        }
      }
    }
    this.h.setColor(i1);
    this.h.drawableState = getDrawableState();
    if (this.e)
    {
      paramCanvas.save();
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      localObject = getWrappedTextView().getLayout();
      if (localObject != null) {
        ((Layout)localObject).draw(paramCanvas);
      } else {
        Log.e("NeatTextView", "[onDraw] isSpecialText, layout == null");
      }
      paramCanvas.restore();
      return;
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((c)localObject).f() != null) {
        this.d.f().set(this.h);
      }
      this.d.a(paramCanvas, getPaddingLeft(), getVerticalOffset());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e)
    {
      getWrappedTextView().measure(paramInt1, paramInt2);
      setMeasuredDimension(getWrappedTextView().getMeasuredWidth(), getWrappedTextView().getMeasuredHeight());
      return;
    }
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = i1;
    if (i1 <= 0)
    {
      paramInt2 = i1;
      if (i3 == 0) {
        paramInt2 = getResources().getDisplayMetrics().widthPixels;
      }
    }
    i1 = paramInt1;
    if (paramInt1 <= 0)
    {
      i1 = paramInt1;
      if (i3 == 0) {
        i1 = 2147483647;
      }
    }
    int i2 = this.o;
    paramInt1 = paramInt2;
    if (i2 > 0)
    {
      paramInt1 = paramInt2;
      if (i2 < paramInt2) {
        paramInt1 = i2;
      }
    }
    i2 = this.p;
    paramInt2 = i1;
    if (i2 > 0)
    {
      paramInt2 = i1;
      if (i2 < i1) {
        paramInt2 = i2;
      }
    }
    i1 = getPaddingLeft();
    i2 = getPaddingRight();
    int i5 = getPaddingTop();
    int i6 = getPaddingBottom();
    a(paramInt1 - i1 - i2, paramInt2 - i5 - i6);
    this.g.a(this.d);
    float[] arrayOfFloat = this.d.e();
    if (i4 != 1073741824) {
      paramInt1 = (int)Math.min(arrayOfFloat[0] + getPaddingLeft() + getPaddingRight(), this.o);
    }
    if (i3 != 1073741824) {
      paramInt2 = (int)Math.min(arrayOfFloat[1] + getPaddingTop() + getPaddingBottom(), this.p);
    }
    setMeasuredDimension(Math.max(paramInt1, this.q), Math.max(paramInt2, this.r));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    d locald = this.x;
    if ((locald != null) && (locald.onTouch(this, paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.B != paramTruncateAt)
    {
      this.B = paramTruncateAt;
      d();
      if (this.d != null)
      {
        this.d = null;
        requestLayout();
        invalidate();
      }
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.p = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
  }
  
  public final void setHint(@StringRes int paramInt)
  {
    setHint(getContext().getResources().getText(paramInt));
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    this.w = TextUtils.stringOrSpannedString(paramCharSequence);
    getWrappedTextView().setHint(this.w);
    if (TextUtils.isEmpty(this.t)) {
      e();
    }
  }
  
  public final void setHintTextColor(@ColorInt int paramInt)
  {
    this.j = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setHintTextColor(paramInt);
    f();
  }
  
  public void setLines(int paramInt)
  {
    this.n = paramInt;
    getWrappedTextView().setLines(paramInt);
    requestLayout();
    invalidate();
  }
  
  public final void setLinkTextColor(@ColorInt int paramInt)
  {
    this.k = ColorStateList.valueOf(paramInt);
    f();
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.p = paramInt;
    getWrappedTextView().setMaxHeight(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMaxLines(int paramInt)
  {
    this.n = paramInt;
    getWrappedTextView().setMaxLines(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.o = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMinHeight(int paramInt)
  {
    this.r = paramInt;
    getWrappedTextView().setMinHeight(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setMinWidth(int paramInt)
  {
    this.q = paramInt;
    getWrappedTextView().setMinWidth(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setNeatEnable(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }
  
  public void setOnDoubleClickListener(b.b paramb)
  {
    this.z = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      this.d = null;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    getWrappedTextView().setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
  }
  
  public void setSmartLetterEnable(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void setSpacingAdd(int paramInt)
  {
    float f1 = paramInt;
    this.s = f1;
    getWrappedTextView().setLineSpacing(f1, 1.0F);
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(@ColorInt int paramInt)
  {
    this.i = ColorStateList.valueOf(paramInt);
    getWrappedTextView().setTextColor(paramInt);
    f();
  }
  
  public void setTextGravity(int paramInt)
  {
    getWrappedTextView().setGravity(paramInt);
    int i1 = paramInt;
    if ((0x800007 & paramInt) == 0) {
      i1 = paramInt | 0x800003;
    }
    paramInt = i1;
    if ((i1 & 0x70) == 0) {
      paramInt = i1 | 0x30;
    }
    this.A = paramInt;
    if (paramInt != this.A) {
      invalidate();
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    a(2, paramFloat);
  }
  
  public void setWidth(int paramInt)
  {
    this.o = paramInt;
    getWrappedTextView().setMaxWidth(paramInt);
    requestLayout();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rx.b
 * JD-Core Version:    0.7.0.1
 */