package com.google.android.material.slider;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>>
  extends View
{
  static final int a = R.style.J;
  private static final String b = "BaseSlider";
  private int A;
  private int B;
  private int C;
  private float D;
  private MotionEvent E;
  private LabelFormatter F;
  private boolean G = false;
  private float H;
  private float I;
  private ArrayList<Float> J = new ArrayList();
  private int K = -1;
  private int L = -1;
  private float M = 0.0F;
  private float[] N;
  private boolean O = true;
  private int P;
  private boolean Q;
  private boolean R = false;
  private boolean S;
  @NonNull
  private ColorStateList T;
  @NonNull
  private ColorStateList U;
  @NonNull
  private ColorStateList V;
  @NonNull
  private ColorStateList W;
  @NonNull
  private ColorStateList Z;
  @NonNull
  private final MaterialShapeDrawable aa = new MaterialShapeDrawable();
  private float ab;
  private int ac = 0;
  @NonNull
  private final Paint c;
  @NonNull
  private final Paint d;
  @NonNull
  private final Paint e;
  @NonNull
  private final Paint f;
  @NonNull
  private final Paint g;
  @NonNull
  private final Paint h;
  @NonNull
  private final BaseSlider.AccessibilityHelper i;
  private final AccessibilityManager j;
  private BaseSlider<S, L, T>.AccessibilityEventSender k;
  @NonNull
  private final BaseSlider.TooltipDrawableFactory l;
  @NonNull
  private final List<TooltipDrawable> m = new ArrayList();
  @NonNull
  private final List<L> n = new ArrayList();
  @NonNull
  private final List<T> o = new ArrayList();
  private boolean p = false;
  private ValueAnimator q;
  private ValueAnimator r;
  private final int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public BaseSlider(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.P);
  }
  
  public BaseSlider(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.c = new Paint();
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    this.d = new Paint();
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeCap(Paint.Cap.ROUND);
    this.e = new Paint(1);
    this.e.setStyle(Paint.Style.FILL);
    this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.f = new Paint(1);
    this.f.setStyle(Paint.Style.FILL);
    this.g = new Paint();
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeCap(Paint.Cap.ROUND);
    this.h = new Paint();
    this.h.setStyle(Paint.Style.STROKE);
    this.h.setStrokeCap(Paint.Cap.ROUND);
    a(paramContext.getResources());
    this.l = new BaseSlider.1(this, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setClickable(true);
    this.aa.D(2);
    this.s = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.i = new BaseSlider.AccessibilityHelper(this);
    ViewCompat.setAccessibilityDelegate(this, this.i);
    this.j = ((AccessibilityManager)getContext().getSystemService("accessibility"));
  }
  
  private static float a(ValueAnimator paramValueAnimator, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramValueAnimator != null)
    {
      f1 = paramFloat;
      if (paramValueAnimator.isRunning())
      {
        f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
        paramValueAnimator.cancel();
      }
    }
    return f1;
  }
  
  @ColorInt
  private int a(@NonNull ColorStateList paramColorStateList)
  {
    return paramColorStateList.getColorForState(getDrawableState(), paramColorStateList.getDefaultColor());
  }
  
  private static int a(float[] paramArrayOfFloat, float paramFloat)
  {
    return Math.round(paramFloat * (paramArrayOfFloat.length / 2 - 1));
  }
  
  private ValueAnimator a(boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    Object localObject;
    if (paramBoolean) {
      localObject = this.r;
    } else {
      localObject = this.q;
    }
    float f3 = a((ValueAnimator)localObject, f1);
    float f1 = f2;
    if (paramBoolean) {
      f1 = 1.0F;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 });
    long l1;
    if (paramBoolean) {
      l1 = 83L;
    } else {
      l1 = 117L;
    }
    localValueAnimator.setDuration(l1);
    if (paramBoolean) {
      localObject = AnimationUtils.e;
    } else {
      localObject = AnimationUtils.c;
    }
    localValueAnimator.setInterpolator((TimeInterpolator)localObject);
    localValueAnimator.addUpdateListener(new BaseSlider.2(this));
    return localValueAnimator;
  }
  
  private Boolean a(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (paramInt != 61)
    {
      if (paramInt != 66)
      {
        if (paramInt != 81) {
          if (paramInt != 69) {
            if (paramInt == 70) {
              break label91;
            }
          }
        }
        switch (paramInt)
        {
        default: 
          return null;
        case 22: 
          d(1);
          return Boolean.valueOf(true);
        case 21: 
          d(-1);
          return Boolean.valueOf(true);
          c(-1);
          return Boolean.valueOf(true);
          label91:
          c(1);
          return Boolean.valueOf(true);
        }
      }
      this.K = this.L;
      postInvalidate();
      return Boolean.valueOf(true);
    }
    if (paramKeyEvent.hasNoModifiers()) {
      return Boolean.valueOf(c(1));
    }
    if (paramKeyEvent.isShiftPressed()) {
      return Boolean.valueOf(c(-1));
    }
    return Boolean.valueOf(false);
  }
  
  private void a(int paramInt)
  {
    this.P = Math.max(paramInt - this.y * 2, 0);
    l();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.gs, paramInt, a, new int[0]);
    this.H = localTypedArray.getFloat(R.styleable.gv, 0.0F);
    this.I = localTypedArray.getFloat(R.styleable.gw, 1.0F);
    setValues(new Float[] { Float.valueOf(this.H) });
    this.M = localTypedArray.getFloat(R.styleable.gu, 0.0F);
    boolean bool = localTypedArray.hasValue(R.styleable.gK);
    if (bool) {
      paramInt = R.styleable.gK;
    } else {
      paramInt = R.styleable.gM;
    }
    int i1;
    if (bool) {
      i1 = R.styleable.gK;
    } else {
      i1 = R.styleable.gL;
    }
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.k);
    }
    setTrackInactiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, i1);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.h);
    }
    setTrackActiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, R.styleable.gB);
    this.aa.g(paramAttributeSet);
    if (localTypedArray.hasValue(R.styleable.gE)) {
      setThumbStrokeColor(MaterialResources.a(paramContext, localTypedArray, R.styleable.gE));
    }
    setThumbStrokeWidth(localTypedArray.getDimension(R.styleable.gF, 0.0F));
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, R.styleable.gx);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.i);
    }
    setHaloTintList(paramAttributeSet);
    this.O = localTypedArray.getBoolean(R.styleable.gJ, true);
    bool = localTypedArray.hasValue(R.styleable.gG);
    if (bool) {
      paramInt = R.styleable.gG;
    } else {
      paramInt = R.styleable.gI;
    }
    if (bool) {
      i1 = R.styleable.gG;
    } else {
      i1 = R.styleable.gH;
    }
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet == null) {
      paramAttributeSet = AppCompatResources.getColorStateList(paramContext, R.color.j);
    }
    setTickInactiveTintList(paramAttributeSet);
    paramAttributeSet = MaterialResources.a(paramContext, localTypedArray, i1);
    if (paramAttributeSet != null) {
      paramContext = paramAttributeSet;
    } else {
      paramContext = AppCompatResources.getColorStateList(paramContext, R.color.g);
    }
    setTickActiveTintList(paramContext);
    setThumbRadius(localTypedArray.getDimensionPixelSize(R.styleable.gD, 0));
    setHaloRadius(localTypedArray.getDimensionPixelSize(R.styleable.gy, 0));
    setThumbElevation(localTypedArray.getDimension(R.styleable.gC, 0.0F));
    setTrackHeight(localTypedArray.getDimensionPixelSize(R.styleable.gN, 0));
    this.w = localTypedArray.getInt(R.styleable.gz, 0);
    if (!localTypedArray.getBoolean(R.styleable.gt, true)) {
      setEnabled(false);
    }
    localTypedArray.recycle();
  }
  
  private void a(@NonNull Resources paramResources)
  {
    this.v = paramResources.getDimensionPixelSize(R.dimen.ao);
    this.t = paramResources.getDimensionPixelOffset(R.dimen.am);
    this.y = this.t;
    this.u = paramResources.getDimensionPixelSize(R.dimen.al);
    this.z = paramResources.getDimensionPixelOffset(R.dimen.an);
    this.C = paramResources.getDimensionPixelSize(R.dimen.ak);
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if (this.O)
    {
      if (this.M <= 0.0F) {
        return;
      }
      float[] arrayOfFloat = getActiveRange();
      int i2 = a(this.N, arrayOfFloat[0]);
      int i1 = a(this.N, arrayOfFloat[1]);
      arrayOfFloat = this.N;
      i2 *= 2;
      paramCanvas.drawPoints(arrayOfFloat, 0, i2, this.g);
      arrayOfFloat = this.N;
      i1 *= 2;
      paramCanvas.drawPoints(arrayOfFloat, i2, i1 - i2, this.h);
      arrayOfFloat = this.N;
      paramCanvas.drawPoints(arrayOfFloat, i1, arrayOfFloat.length - i1, this.g);
    }
  }
  
  private void a(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = getActiveRange();
    int i1 = this.y;
    float f2 = i1;
    float f3 = arrayOfFloat[1];
    float f1 = paramInt1;
    f2 += f3 * f1;
    if (f2 < i1 + paramInt1)
    {
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, i1 + paramInt1, f3, this.c);
    }
    paramInt1 = this.y;
    f1 = paramInt1 + arrayOfFloat[0] * f1;
    if (f1 > paramInt1)
    {
      f2 = paramInt1;
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, f1, f3, this.c);
    }
  }
  
  private void a(TooltipDrawable paramTooltipDrawable)
  {
    paramTooltipDrawable.a(ViewUtils.f(this));
  }
  
  private void a(TooltipDrawable paramTooltipDrawable, float paramFloat)
  {
    paramTooltipDrawable.a(g(paramFloat));
    int i1 = this.y + (int)(b(paramFloat) * this.P) - paramTooltipDrawable.getIntrinsicWidth() / 2;
    int i2 = n() - (this.C + this.A);
    paramTooltipDrawable.setBounds(i1, i2 - paramTooltipDrawable.getIntrinsicHeight(), paramTooltipDrawable.getIntrinsicWidth() + i1, i2);
    Rect localRect = new Rect(paramTooltipDrawable.getBounds());
    DescendantOffsetUtils.a(ViewUtils.f(this), this, localRect);
    paramTooltipDrawable.setBounds(localRect);
    ViewUtils.g(this).a(paramTooltipDrawable);
  }
  
  private boolean a(float paramFloat)
  {
    double d1 = new BigDecimal(Float.toString(paramFloat)).subtract(new BigDecimal(Float.toString(this.H))).divide(new BigDecimal(Float.toString(this.M)), MathContext.DECIMAL64).doubleValue();
    double d2 = Math.round(d1);
    Double.isNaN(d2);
    return Math.abs(d2 - d1) < 0.0001D;
  }
  
  private boolean a(int paramInt, float paramFloat)
  {
    if (Math.abs(paramFloat - ((Float)this.J.get(paramInt)).floatValue()) < 0.0001D) {
      return false;
    }
    paramFloat = b(paramInt, paramFloat);
    this.J.set(paramInt, Float.valueOf(paramFloat));
    this.L = paramInt;
    b(paramInt);
    return true;
  }
  
  private float b(float paramFloat)
  {
    float f1 = this.H;
    paramFloat = (paramFloat - f1) / (this.I - f1);
    if (c()) {
      return 1.0F - paramFloat;
    }
    return paramFloat;
  }
  
  private float b(int paramInt, float paramFloat)
  {
    float f2 = this.M;
    float f1 = 0.0F;
    if (f2 == 0.0F) {
      f1 = getMinSeparation();
    }
    f2 = f1;
    if (this.ac == 0) {
      f2 = e(f1);
    }
    f1 = f2;
    if (c()) {
      f1 = -f2;
    }
    int i1 = paramInt + 1;
    if (i1 >= this.J.size()) {
      f2 = this.I;
    } else {
      f2 = ((Float)this.J.get(i1)).floatValue() - f1;
    }
    paramInt -= 1;
    if (paramInt < 0) {
      f1 = this.H;
    } else {
      f1 = ((Float)this.J.get(paramInt)).floatValue() + f1;
    }
    return MathUtils.clamp(paramFloat, f1, f2);
  }
  
  @NonNull
  private static TooltipDrawable b(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray)
  {
    return TooltipDrawable.a(paramContext, null, 0, paramTypedArray.getResourceId(R.styleable.gA, R.style.N));
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.n.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseOnChangeListener)((Iterator)localObject).next()).a(this, ((Float)this.J.get(paramInt)).floatValue(), true);
    }
    localObject = this.j;
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled())) {
      h(paramInt);
    }
  }
  
  private void b(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = getActiveRange();
    int i1 = this.y;
    float f1 = i1;
    float f2 = arrayOfFloat[1];
    float f3 = paramInt1;
    float f4 = i1;
    float f5 = arrayOfFloat[0];
    float f6 = paramInt2;
    paramCanvas.drawLine(f4 + f5 * f3, f6, f1 + f2 * f3, f6, this.d);
  }
  
  private void b(TooltipDrawable paramTooltipDrawable)
  {
    ViewOverlayImpl localViewOverlayImpl = ViewUtils.g(this);
    if (localViewOverlayImpl != null)
    {
      localViewOverlayImpl.b(paramTooltipDrawable);
      paramTooltipDrawable.b(ViewUtils.f(this));
    }
  }
  
  private double c(float paramFloat)
  {
    float f1 = this.M;
    if (f1 > 0.0F)
    {
      int i1 = (int)((this.I - this.H) / f1);
      double d1 = Math.round(paramFloat * i1);
      double d2 = i1;
      Double.isNaN(d1);
      Double.isNaN(d2);
      return d1 / d2;
    }
    return paramFloat;
  }
  
  private void c(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Float localFloat;
    if (!isEnabled())
    {
      localIterator = this.J.iterator();
      while (localIterator.hasNext())
      {
        localFloat = (Float)localIterator.next();
        paramCanvas.drawCircle(this.y + b(localFloat.floatValue()) * paramInt1, paramInt2, this.A, this.e);
      }
    }
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext())
    {
      localFloat = (Float)localIterator.next();
      paramCanvas.save();
      int i1 = this.y;
      int i2 = (int)(b(localFloat.floatValue()) * paramInt1);
      int i3 = this.A;
      paramCanvas.translate(i1 + i2 - i3, paramInt2 - i3);
      this.aa.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private boolean c(int paramInt)
  {
    int i1 = this.L;
    this.L = ((int)MathUtils.clamp(i1 + paramInt, 0L, this.J.size() - 1));
    paramInt = this.L;
    if (paramInt == i1) {
      return false;
    }
    if (this.K != -1) {
      this.K = paramInt;
    }
    m();
    postInvalidate();
    return true;
  }
  
  private void d()
  {
    int i1 = Math.max(this.A - this.u, 0);
    this.y = (this.t + i1);
    if (ViewCompat.isLaidOut(this)) {
      a(getWidth());
    }
  }
  
  private void d(@NonNull Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (o())
    {
      paramInt1 = (int)(this.y + b(((Float)this.J.get(this.L)).floatValue()) * paramInt1);
      if (Build.VERSION.SDK_INT < 28)
      {
        int i1 = this.B;
        paramCanvas.clipRect(paramInt1 - i1, paramInt2 - i1, paramInt1 + i1, i1 + paramInt2, Region.Op.UNION);
      }
      paramCanvas.drawCircle(paramInt1, paramInt2, this.B, this.f);
    }
  }
  
  private boolean d(float paramFloat)
  {
    return a(this.K, paramFloat);
  }
  
  private boolean d(int paramInt)
  {
    int i1 = paramInt;
    if (c()) {
      if (paramInt == -2147483648) {
        i1 = 2147483647;
      } else {
        i1 = -paramInt;
      }
    }
    return c(i1);
  }
  
  private float e(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    paramFloat = (paramFloat - this.y) / this.P;
    float f1 = this.H;
    return paramFloat * (f1 - this.I) + f1;
  }
  
  private Float e(int paramInt)
  {
    float f1;
    if (this.R) {
      f1 = f(20);
    } else {
      f1 = x();
    }
    if (paramInt != 21)
    {
      if (paramInt != 22)
      {
        if (paramInt != 69)
        {
          if ((paramInt != 70) && (paramInt != 81)) {
            return null;
          }
          return Float.valueOf(f1);
        }
        return Float.valueOf(-f1);
      }
      float f2 = f1;
      if (c()) {
        f2 = -f1;
      }
      return Float.valueOf(f2);
    }
    if (!c()) {
      f1 = -f1;
    }
    return Float.valueOf(f1);
  }
  
  private void e()
  {
    float f1 = this.H;
    if (f1 < this.I) {
      return;
    }
    throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[] { Float.toString(f1), Float.toString(this.I) }));
  }
  
  private float f(float paramFloat)
  {
    return b(paramFloat) * this.P + this.y;
  }
  
  private float f(int paramInt)
  {
    float f1 = x();
    float f2 = (this.I - this.H) / f1;
    float f3 = paramInt;
    if (f2 <= f3) {
      return f1;
    }
    return Math.round(f2 / f3) * f1;
  }
  
  private void f()
  {
    float f1 = this.I;
    if (f1 > this.H) {
      return;
    }
    throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[] { Float.toString(f1), Float.toString(this.H) }));
  }
  
  private String g(float paramFloat)
  {
    if (a()) {
      return this.F.a(paramFloat);
    }
    String str;
    if ((int)paramFloat == paramFloat) {
      str = "%.0f";
    } else {
      str = "%.2f";
    }
    return String.format(str, new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void g()
  {
    if (this.M > 0.0F)
    {
      if (a(this.I)) {
        return;
      }
      throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(this.M), Float.toString(this.H), Float.toString(this.I) }));
    }
  }
  
  private void g(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 66) {
            return;
          }
          d(-2147483648);
          return;
        }
        d(2147483647);
        return;
      }
      c(-2147483648);
      return;
    }
    c(2147483647);
  }
  
  private float[] getActiveRange()
  {
    float f2 = ((Float)Collections.max(getValues())).floatValue();
    float f1 = ((Float)Collections.min(getValues())).floatValue();
    if (this.J.size() == 1) {
      f1 = this.H;
    }
    f1 = b(f1);
    f2 = b(f2);
    if (c()) {
      return new float[] { f2, f1 };
    }
    return new float[] { f1, f2 };
  }
  
  private float getValueOfTouchPosition()
  {
    double d2 = c(this.ab);
    double d1 = d2;
    if (c()) {
      d1 = 1.0D - d2;
    }
    float f1 = this.I;
    float f2 = this.H;
    d2 = f1 - f2;
    Double.isNaN(d2);
    double d3 = f2;
    Double.isNaN(d3);
    return (float)(d1 * d2 + d3);
  }
  
  private float getValueOfTouchPositionAbsolute()
  {
    float f2 = this.ab;
    float f1 = f2;
    if (c()) {
      f1 = 1.0F - f2;
    }
    f2 = this.I;
    float f3 = this.H;
    return f1 * (f2 - f3) + f3;
  }
  
  private void h()
  {
    Iterator localIterator = this.J.iterator();
    while (localIterator.hasNext())
    {
      Float localFloat = (Float)localIterator.next();
      if ((localFloat.floatValue() >= this.H) && (localFloat.floatValue() <= this.I))
      {
        if ((this.M > 0.0F) && (!a(localFloat.floatValue()))) {
          throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[] { Float.toString(localFloat.floatValue()), Float.toString(this.H), Float.toString(this.M), Float.toString(this.M) }));
        }
      }
      else {
        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[] { Float.toString(localFloat.floatValue()), Float.toString(this.H), Float.toString(this.I) }));
      }
    }
  }
  
  private void h(int paramInt)
  {
    BaseSlider.AccessibilityEventSender localAccessibilityEventSender = this.k;
    if (localAccessibilityEventSender == null) {
      this.k = new BaseSlider.AccessibilityEventSender(this, null);
    } else {
      removeCallbacks(localAccessibilityEventSender);
    }
    this.k.a(paramInt);
    postDelayed(this.k, 200L);
  }
  
  private void i()
  {
    float f1 = this.M;
    if (f1 == 0.0F) {
      return;
    }
    if ((int)f1 != f1) {
      Log.w(b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "stepSize", Float.valueOf(f1) }));
    }
    f1 = this.H;
    if ((int)f1 != f1) {
      Log.w(b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueFrom", Float.valueOf(f1) }));
    }
    f1 = this.I;
    if ((int)f1 != f1) {
      Log.w(b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[] { "valueTo", Float.valueOf(f1) }));
    }
  }
  
  private void j()
  {
    if (this.S)
    {
      e();
      f();
      g();
      h();
      i();
      this.S = false;
    }
  }
  
  private void k()
  {
    if (this.m.size() > this.J.size())
    {
      localObject = this.m.subList(this.J.size(), this.m.size());
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        TooltipDrawable localTooltipDrawable = (TooltipDrawable)localIterator.next();
        if (ViewCompat.isAttachedToWindow(this)) {
          b(localTooltipDrawable);
        }
      }
      ((List)localObject).clear();
    }
    while (this.m.size() < this.J.size())
    {
      localObject = this.l.a();
      this.m.add(localObject);
      if (ViewCompat.isAttachedToWindow(this)) {
        a((TooltipDrawable)localObject);
      }
    }
    int i2 = this.m.size();
    int i1 = 1;
    if (i2 == 1) {
      i1 = 0;
    }
    Object localObject = this.m.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TooltipDrawable)((Iterator)localObject).next()).n(i1);
    }
  }
  
  private void l()
  {
    if (this.M <= 0.0F) {
      return;
    }
    j();
    int i2 = Math.min((int)((this.I - this.H) / this.M + 1.0F), this.P / (this.x * 2) + 1);
    float[] arrayOfFloat = this.N;
    if ((arrayOfFloat == null) || (arrayOfFloat.length != i2 * 2)) {
      this.N = new float[i2 * 2];
    }
    float f1 = this.P / (i2 - 1);
    int i1 = 0;
    while (i1 < i2 * 2)
    {
      arrayOfFloat = this.N;
      arrayOfFloat[i1] = (this.y + i1 / 2 * f1);
      arrayOfFloat[(i1 + 1)] = n();
      i1 += 2;
    }
  }
  
  private void m()
  {
    if ((!o()) && (getMeasuredWidth() > 0))
    {
      Drawable localDrawable = getBackground();
      if ((localDrawable instanceof RippleDrawable))
      {
        int i1 = (int)(b(((Float)this.J.get(this.L)).floatValue()) * this.P + this.y);
        int i2 = n();
        int i3 = this.B;
        DrawableCompat.setHotspotBounds(localDrawable, i1 - i3, i2 - i3, i1 + i3, i2 + i3);
      }
    }
  }
  
  private int n()
  {
    int i2 = this.z;
    int i3 = this.w;
    int i1 = 0;
    if (i3 == 1) {
      i1 = ((TooltipDrawable)this.m.get(0)).getIntrinsicHeight();
    }
    return i2 + i1;
  }
  
  private boolean o()
  {
    return (this.Q) || (Build.VERSION.SDK_INT < 21) || (!(getBackground() instanceof RippleDrawable));
  }
  
  private boolean p()
  {
    return d(getValueOfTouchPosition());
  }
  
  private void q()
  {
    if (this.p)
    {
      this.p = false;
      this.r = a(false);
      this.q = null;
      this.r.addListener(new BaseSlider.3(this));
      this.r.start();
    }
  }
  
  private void r()
  {
    if (this.w == 2) {
      return;
    }
    if (!this.p)
    {
      this.p = true;
      this.q = a(true);
      this.r = null;
      this.q.start();
    }
    Object localObject = this.m.iterator();
    int i1 = 0;
    while ((i1 < this.J.size()) && (((Iterator)localObject).hasNext()))
    {
      if (i1 != this.L) {
        a((TooltipDrawable)((Iterator)localObject).next(), ((Float)this.J.get(i1)).floatValue());
      }
      i1 += 1;
    }
    if (((Iterator)localObject).hasNext())
    {
      a((TooltipDrawable)((Iterator)localObject).next(), ((Float)this.J.get(this.L)).floatValue());
      return;
    }
    localObject = new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[] { Integer.valueOf(this.m.size()), Integer.valueOf(this.J.size()) }));
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private void s()
  {
    this.c.setStrokeWidth(this.x);
    this.d.setStrokeWidth(this.x);
    this.g.setStrokeWidth(this.x / 2.0F);
    this.h.setStrokeWidth(this.x / 2.0F);
  }
  
  private void setValuesInternal(@NonNull ArrayList<Float> paramArrayList)
  {
    if (!paramArrayList.isEmpty())
    {
      Collections.sort(paramArrayList);
      if ((this.J.size() == paramArrayList.size()) && (this.J.equals(paramArrayList))) {
        return;
      }
      this.J = paramArrayList;
      this.S = true;
      this.L = 0;
      m();
      k();
      u();
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("At least one value must be set");
  }
  
  private boolean t()
  {
    for (ViewParent localViewParent = getParent();; localViewParent = localViewParent.getParent())
    {
      boolean bool = localViewParent instanceof ViewGroup;
      int i1 = 0;
      if (!bool) {
        break;
      }
      ViewGroup localViewGroup = (ViewGroup)localViewParent;
      if ((localViewGroup.canScrollVertically(1)) || (localViewGroup.canScrollVertically(-1))) {
        i1 = 1;
      }
      if ((i1 != 0) && (localViewGroup.shouldDelayChildPressedState())) {
        return true;
      }
    }
    return false;
  }
  
  private void u()
  {
    Iterator localIterator1 = this.n.iterator();
    while (localIterator1.hasNext())
    {
      BaseOnChangeListener localBaseOnChangeListener = (BaseOnChangeListener)localIterator1.next();
      Iterator localIterator2 = this.J.iterator();
      while (localIterator2.hasNext()) {
        localBaseOnChangeListener.a(this, ((Float)localIterator2.next()).floatValue(), false);
      }
    }
  }
  
  private void v()
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext()) {
      ((BaseOnSliderTouchListener)localIterator.next()).a(this);
    }
  }
  
  private void w()
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext()) {
      ((BaseOnSliderTouchListener)localIterator.next()).b(this);
    }
  }
  
  private float x()
  {
    float f2 = this.M;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    return f1;
  }
  
  void a(int paramInt, Rect paramRect)
  {
    paramInt = this.y + (int)(b(((Float)getValues().get(paramInt)).floatValue()) * this.P);
    int i1 = n();
    int i2 = this.A;
    paramRect.set(paramInt - i2, i1 - i2, paramInt + i2, i1 + i2);
  }
  
  public boolean a()
  {
    return this.F != null;
  }
  
  protected boolean b()
  {
    if (this.K != -1) {
      return true;
    }
    float f4 = getValueOfTouchPositionAbsolute();
    float f5 = f(f4);
    this.K = 0;
    float f1 = Math.abs(((Float)this.J.get(this.K)).floatValue() - f4);
    int i1 = 1;
    while (i1 < this.J.size())
    {
      float f3 = Math.abs(((Float)this.J.get(i1)).floatValue() - f4);
      float f6 = f(((Float)this.J.get(i1)).floatValue());
      if (Float.compare(f3, f1) > 1) {
        break;
      }
      int i2;
      if (c() ? f6 - f5 > 0.0F : f6 - f5 < 0.0F) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (Float.compare(f3, f1) < 0)
      {
        this.K = i1;
      }
      else
      {
        f2 = f1;
        if (Float.compare(f3, f1) != 0) {
          break label228;
        }
        if (Math.abs(f6 - f5) < this.s)
        {
          this.K = -1;
          return false;
        }
        f2 = f1;
        if (i2 == 0) {
          break label228;
        }
        this.K = i1;
      }
      float f2 = f3;
      label228:
      i1 += 1;
      f1 = f2;
    }
    return this.K != -1;
  }
  
  final boolean c()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  public boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    return (this.i.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.c.setColor(a(this.Z));
    this.d.setColor(a(this.W));
    this.g.setColor(a(this.V));
    this.h.setColor(a(this.U));
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      TooltipDrawable localTooltipDrawable = (TooltipDrawable)localIterator.next();
      if (localTooltipDrawable.isStateful()) {
        localTooltipDrawable.setState(getDrawableState());
      }
    }
    if (this.aa.isStateful()) {
      this.aa.setState(getDrawableState());
    }
    this.f.setColor(a(this.T));
    this.f.setAlpha(63);
  }
  
  @NonNull
  public CharSequence getAccessibilityClassName()
  {
    return SeekBar.class.getName();
  }
  
  @VisibleForTesting
  final int getAccessibilityFocusedVirtualViewId()
  {
    return this.i.getAccessibilityFocusedVirtualViewId();
  }
  
  public int getActiveThumbIndex()
  {
    return this.K;
  }
  
  public int getFocusedThumbIndex()
  {
    return this.L;
  }
  
  @Dimension
  public int getHaloRadius()
  {
    return this.B;
  }
  
  @NonNull
  public ColorStateList getHaloTintList()
  {
    return this.T;
  }
  
  public int getLabelBehavior()
  {
    return this.w;
  }
  
  protected float getMinSeparation()
  {
    return 0.0F;
  }
  
  public float getStepSize()
  {
    return this.M;
  }
  
  public float getThumbElevation()
  {
    return this.aa.U();
  }
  
  @Dimension
  public int getThumbRadius()
  {
    return this.A;
  }
  
  public ColorStateList getThumbStrokeColor()
  {
    return this.aa.N();
  }
  
  public float getThumbStrokeWidth()
  {
    return this.aa.P();
  }
  
  @NonNull
  public ColorStateList getThumbTintList()
  {
    return this.aa.M();
  }
  
  @NonNull
  public ColorStateList getTickActiveTintList()
  {
    return this.U;
  }
  
  @NonNull
  public ColorStateList getTickInactiveTintList()
  {
    return this.V;
  }
  
  @NonNull
  public ColorStateList getTickTintList()
  {
    if (this.V.equals(this.U)) {
      return this.U;
    }
    throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
  }
  
  @NonNull
  public ColorStateList getTrackActiveTintList()
  {
    return this.W;
  }
  
  @Dimension
  public int getTrackHeight()
  {
    return this.x;
  }
  
  @NonNull
  public ColorStateList getTrackInactiveTintList()
  {
    return this.Z;
  }
  
  @Dimension
  public int getTrackSidePadding()
  {
    return this.y;
  }
  
  @NonNull
  public ColorStateList getTrackTintList()
  {
    if (this.Z.equals(this.W)) {
      return this.W;
    }
    throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
  }
  
  @Dimension
  public int getTrackWidth()
  {
    return this.P;
  }
  
  public float getValueFrom()
  {
    return this.H;
  }
  
  public float getValueTo()
  {
    return this.I;
  }
  
  @NonNull
  List<Float> getValues()
  {
    return new ArrayList(this.J);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      a((TooltipDrawable)localIterator.next());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = this.k;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
    this.p = false;
    localObject = this.m.iterator();
    while (((Iterator)localObject).hasNext()) {
      b((TooltipDrawable)((Iterator)localObject).next());
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    if (this.S)
    {
      j();
      l();
    }
    super.onDraw(paramCanvas);
    int i1 = n();
    a(paramCanvas, this.P, i1);
    if (((Float)Collections.max(getValues())).floatValue() > this.H) {
      b(paramCanvas, this.P, i1);
    }
    a(paramCanvas);
    if (((this.G) || (isFocused())) && (isEnabled()))
    {
      d(paramCanvas, this.P, i1);
      if (this.K != -1) {
        r();
      }
    }
    c(paramCanvas, this.P, i1);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      this.K = -1;
      q();
      this.i.clearKeyboardFocusForVirtualView(this.L);
      return;
    }
    g(paramInt);
    this.i.requestKeyboardFocusForVirtualView(this.L);
  }
  
  public boolean onKeyDown(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (!isEnabled()) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if (this.J.size() == 1) {
      this.K = 0;
    }
    if (this.K == -1)
    {
      localObject = a(paramInt, paramKeyEvent);
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    this.R |= paramKeyEvent.isLongPress();
    Object localObject = e(paramInt);
    if (localObject != null)
    {
      if (d(((Float)this.J.get(this.K)).floatValue() + ((Float)localObject).floatValue()))
      {
        m();
        postInvalidate();
      }
      return true;
    }
    if (paramInt != 23) {
      if (paramInt != 61)
      {
        if (paramInt != 66) {
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return c(1);
        }
        if (paramKeyEvent.isShiftPressed()) {
          return c(-1);
        }
        return false;
      }
    }
    this.K = -1;
    q();
    postInvalidate();
    return true;
  }
  
  public boolean onKeyUp(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    this.R = false;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = this.v;
    int i2 = this.w;
    paramInt2 = 0;
    if (i2 == 1) {
      paramInt2 = ((TooltipDrawable)this.m.get(0)).getIntrinsicHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i1 + paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (BaseSlider.SliderState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.H = paramParcelable.a;
    this.I = paramParcelable.b;
    setValuesInternal(paramParcelable.c);
    this.M = paramParcelable.d;
    if (paramParcelable.e) {
      requestFocus();
    }
    u();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    BaseSlider.SliderState localSliderState = new BaseSlider.SliderState(super.onSaveInstanceState());
    localSliderState.a = this.H;
    localSliderState.b = this.I;
    localSliderState.c = new ArrayList(this.J);
    localSliderState.d = this.M;
    localSliderState.e = hasFocus();
    return localSliderState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1);
    m();
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    this.ab = ((f1 - this.y) / this.P);
    this.ab = Math.max(0.0F, this.ab);
    this.ab = Math.min(1.0F, this.ab);
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          if (!this.G)
          {
            if ((t()) && (Math.abs(f1 - this.D) < this.s)) {
              return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            v();
          }
          if (b())
          {
            this.G = true;
            p();
            m();
            invalidate();
          }
        }
      }
      else
      {
        this.G = false;
        MotionEvent localMotionEvent = this.E;
        if ((localMotionEvent != null) && (localMotionEvent.getActionMasked() == 0) && (Math.abs(this.E.getX() - paramMotionEvent.getX()) <= this.s) && (Math.abs(this.E.getY() - paramMotionEvent.getY()) <= this.s) && (b())) {
          v();
        }
        if (this.K != -1)
        {
          p();
          this.K = -1;
          w();
        }
        q();
        invalidate();
      }
    }
    else
    {
      this.D = f1;
      if (!t())
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (b())
        {
          requestFocus();
          this.G = true;
          p();
          m();
          invalidate();
          v();
        }
      }
    }
    setPressed(this.G);
    this.E = MotionEvent.obtain(paramMotionEvent);
    return true;
  }
  
  protected void setActiveThumbIndex(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 2;
    }
    setLayerType(i1, null);
  }
  
  public void setFocusedThumbIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.J.size()))
    {
      this.L = paramInt;
      this.i.requestKeyboardFocusForVirtualView(this.L);
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("index out of range");
  }
  
  public void setHaloRadius(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (paramInt == this.B) {
      return;
    }
    this.B = paramInt;
    Drawable localDrawable = getBackground();
    if ((!o()) && ((localDrawable instanceof RippleDrawable)))
    {
      DrawableUtils.a((RippleDrawable)localDrawable, this.B);
      return;
    }
    postInvalidate();
  }
  
  public void setHaloRadiusResource(@DimenRes int paramInt)
  {
    setHaloRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setHaloTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.T)) {
      return;
    }
    this.T = paramColorStateList;
    Drawable localDrawable = getBackground();
    if ((!o()) && ((localDrawable instanceof RippleDrawable)))
    {
      ((RippleDrawable)localDrawable).setColor(paramColorStateList);
      return;
    }
    this.f.setColor(a(paramColorStateList));
    this.f.setAlpha(63);
    invalidate();
  }
  
  public void setLabelBehavior(int paramInt)
  {
    if (this.w != paramInt)
    {
      this.w = paramInt;
      requestLayout();
    }
  }
  
  public void setLabelFormatter(@Nullable LabelFormatter paramLabelFormatter)
  {
    this.F = paramLabelFormatter;
  }
  
  protected void setSeparationUnit(int paramInt)
  {
    this.ac = paramInt;
  }
  
  public void setStepSize(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      if (this.M != paramFloat)
      {
        this.M = paramFloat;
        this.S = true;
        postInvalidate();
      }
      return;
    }
    throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.toString(paramFloat), Float.toString(this.H), Float.toString(this.I) }));
  }
  
  public void setThumbElevation(float paramFloat)
  {
    this.aa.r(paramFloat);
  }
  
  public void setThumbElevationResource(@DimenRes int paramInt)
  {
    setThumbElevation(getResources().getDimension(paramInt));
  }
  
  public void setThumbRadius(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (paramInt == this.A) {
      return;
    }
    this.A = paramInt;
    d();
    this.aa.setShapeAppearanceModel(ShapeAppearanceModel.a().a(0, this.A).a());
    MaterialShapeDrawable localMaterialShapeDrawable = this.aa;
    paramInt = this.A;
    localMaterialShapeDrawable.setBounds(0, 0, paramInt * 2, paramInt * 2);
    postInvalidate();
  }
  
  public void setThumbRadiusResource(@DimenRes int paramInt)
  {
    setThumbRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setThumbStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    this.aa.h(paramColorStateList);
    postInvalidate();
  }
  
  public void setThumbStrokeColorResource(@ColorRes int paramInt)
  {
    if (paramInt != 0) {
      setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setThumbStrokeWidth(float paramFloat)
  {
    this.aa.n(paramFloat);
    postInvalidate();
  }
  
  public void setThumbStrokeWidthResource(@DimenRes int paramInt)
  {
    if (paramInt != 0) {
      setThumbStrokeWidth(getResources().getDimension(paramInt));
    }
  }
  
  public void setThumbTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.aa.M())) {
      return;
    }
    this.aa.g(paramColorStateList);
    invalidate();
  }
  
  public void setTickActiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.U)) {
      return;
    }
    this.U = paramColorStateList;
    this.h.setColor(a(this.U));
    invalidate();
  }
  
  public void setTickInactiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.V)) {
      return;
    }
    this.V = paramColorStateList;
    this.g.setColor(a(this.V));
    invalidate();
  }
  
  public void setTickTintList(@NonNull ColorStateList paramColorStateList)
  {
    setTickInactiveTintList(paramColorStateList);
    setTickActiveTintList(paramColorStateList);
  }
  
  public void setTickVisible(boolean paramBoolean)
  {
    if (this.O != paramBoolean)
    {
      this.O = paramBoolean;
      postInvalidate();
    }
  }
  
  public void setTrackActiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.W)) {
      return;
    }
    this.W = paramColorStateList;
    this.d.setColor(a(this.W));
    invalidate();
  }
  
  public void setTrackHeight(@Dimension @IntRange(from=0L) int paramInt)
  {
    if (this.x != paramInt)
    {
      this.x = paramInt;
      s();
      postInvalidate();
    }
  }
  
  public void setTrackInactiveTintList(@NonNull ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.Z)) {
      return;
    }
    this.Z = paramColorStateList;
    this.c.setColor(a(this.Z));
    invalidate();
  }
  
  public void setTrackTintList(@NonNull ColorStateList paramColorStateList)
  {
    setTrackInactiveTintList(paramColorStateList);
    setTrackActiveTintList(paramColorStateList);
  }
  
  public void setValueFrom(float paramFloat)
  {
    this.H = paramFloat;
    this.S = true;
    postInvalidate();
  }
  
  public void setValueTo(float paramFloat)
  {
    this.I = paramFloat;
    this.S = true;
    postInvalidate();
  }
  
  void setValues(@NonNull List<Float> paramList)
  {
    setValuesInternal(new ArrayList(paramList));
  }
  
  void setValues(@NonNull Float... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramVarArgs);
    setValuesInternal(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.BaseSlider
 * JD-Core Version:    0.7.0.1
 */