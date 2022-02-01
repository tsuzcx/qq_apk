package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable
  extends MaterialShapeDrawable
  implements Drawable.Callback, TintAwareDrawable, TextDrawableHelper.TextDrawableDelegate
{
  private static final int[] a = { 16842910 };
  private static final ShapeDrawable b = new ShapeDrawable(new OvalShape());
  @Nullable
  private MotionSpec A;
  private float B;
  private float C;
  private float D;
  private float E;
  private float F;
  private float G;
  private float H;
  private float I;
  @NonNull
  private final Context J;
  private final Paint K = new Paint(1);
  @Nullable
  private final Paint L;
  private final Paint.FontMetrics M = new Paint.FontMetrics();
  private final RectF N = new RectF();
  private final PointF O = new PointF();
  private final Path P = new Path();
  @NonNull
  private final TextDrawableHelper Q;
  @ColorInt
  private int R;
  @ColorInt
  private int S;
  @ColorInt
  private int T;
  @ColorInt
  private int U;
  @ColorInt
  private int V;
  @ColorInt
  private int W;
  private boolean X;
  @ColorInt
  private int Y;
  private int Z = 255;
  @Nullable
  private ColorFilter aa;
  @Nullable
  private PorterDuffColorFilter ab;
  @Nullable
  private ColorStateList ac;
  @Nullable
  private PorterDuff.Mode ad = PorterDuff.Mode.SRC_IN;
  private int[] ae;
  private boolean af;
  @Nullable
  private ColorStateList ag;
  @NonNull
  private WeakReference<ChipDrawable.Delegate> ah = new WeakReference(null);
  private TextUtils.TruncateAt ai;
  private boolean aj;
  private int ak;
  private boolean al;
  @Nullable
  private ColorStateList c;
  @Nullable
  private ColorStateList d;
  private float e;
  private float f = -1.0F;
  @Nullable
  private ColorStateList g;
  private float h;
  @Nullable
  private ColorStateList i;
  @Nullable
  private CharSequence j;
  private boolean k;
  @Nullable
  private Drawable l;
  @Nullable
  private ColorStateList m;
  private float n;
  private boolean o;
  private boolean p;
  @Nullable
  private Drawable q;
  @Nullable
  private Drawable r;
  @Nullable
  private ColorStateList s;
  private float t;
  @Nullable
  private CharSequence u;
  private boolean v;
  private boolean w;
  @Nullable
  private Drawable x;
  @Nullable
  private ColorStateList y;
  @Nullable
  private MotionSpec z;
  
  private ChipDrawable(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
    this.J = paramContext;
    this.Q = new TextDrawableHelper(this);
    this.j = "";
    this.Q.a().density = paramContext.getResources().getDisplayMetrics().density;
    this.L = null;
    paramContext = this.L;
    if (paramContext != null) {
      paramContext.setStyle(Paint.Style.STROKE);
    }
    setState(a);
    a(a);
    this.aj = true;
    if (RippleUtils.a) {
      b.setTint(-1);
    }
  }
  
  @NonNull
  public static ChipDrawable a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramContext = new ChipDrawable(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext.a(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  private void a(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (!this.al)
    {
      this.K.setColor(this.R);
      this.K.setStyle(Paint.Style.FILL);
      this.N.set(paramRect);
      paramCanvas.drawRoundRect(this.N, j(), j(), this.K);
    }
  }
  
  private void a(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if ((ag()) || (ah()))
    {
      float f1 = this.B + this.C;
      float f2 = ak();
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.left = (paramRect.left + f1);
        paramRectF.right = (paramRectF.left + f2);
      }
      else
      {
        paramRectF.right = (paramRect.right - f1);
        paramRectF.left = (paramRectF.right - f2);
      }
      f1 = al();
      paramRectF.top = (paramRect.exactCenterY() - f1 / 2.0F);
      paramRectF.bottom = (paramRectF.top + f1);
    }
  }
  
  private void a(@Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    TypedArray localTypedArray = ThemeEnforcement.a(this.J, paramAttributeSet, R.styleable.aI, paramInt1, paramInt2, new int[0]);
    this.al = localTypedArray.hasValue(R.styleable.bu);
    j(MaterialResources.a(this.J, localTypedArray, R.styleable.bh));
    a(MaterialResources.a(this.J, localTypedArray, R.styleable.aU));
    a(localTypedArray.getDimension(R.styleable.bc, 0.0F));
    if (localTypedArray.hasValue(R.styleable.aV)) {
      b(localTypedArray.getDimension(R.styleable.aV, 0.0F));
    }
    b(MaterialResources.a(this.J, localTypedArray, R.styleable.bf));
    c(localTypedArray.getDimension(R.styleable.bg, 0.0F));
    c(MaterialResources.a(this.J, localTypedArray, R.styleable.bt));
    a(localTypedArray.getText(R.styleable.aO));
    TextAppearance localTextAppearance = MaterialResources.c(this.J, localTypedArray, R.styleable.aJ);
    localTextAppearance.n = localTypedArray.getDimension(R.styleable.aK, localTextAppearance.n);
    a(localTextAppearance);
    paramInt1 = localTypedArray.getInt(R.styleable.aM, 0);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          a(TextUtils.TruncateAt.END);
        }
      }
      else {
        a(TextUtils.TruncateAt.MIDDLE);
      }
    }
    else {
      a(TextUtils.TruncateAt.START);
    }
    b(localTypedArray.getBoolean(R.styleable.bb, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)) {
      b(localTypedArray.getBoolean(R.styleable.aY, false));
    }
    a(MaterialResources.b(this.J, localTypedArray, R.styleable.aX));
    if (localTypedArray.hasValue(R.styleable.ba)) {
      d(MaterialResources.a(this.J, localTypedArray, R.styleable.ba));
    }
    d(localTypedArray.getDimension(R.styleable.aZ, -1.0F));
    c(localTypedArray.getBoolean(R.styleable.bo, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)) {
      c(localTypedArray.getBoolean(R.styleable.bj, false));
    }
    b(MaterialResources.b(this.J, localTypedArray, R.styleable.bi));
    e(MaterialResources.a(this.J, localTypedArray, R.styleable.bn));
    e(localTypedArray.getDimension(R.styleable.bl, 0.0F));
    d(localTypedArray.getBoolean(R.styleable.aP, false));
    e(localTypedArray.getBoolean(R.styleable.aT, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)) {
      e(localTypedArray.getBoolean(R.styleable.aR, false));
    }
    c(MaterialResources.b(this.J, localTypedArray, R.styleable.aQ));
    if (localTypedArray.hasValue(R.styleable.aS)) {
      f(MaterialResources.a(this.J, localTypedArray, R.styleable.aS));
    }
    a(MotionSpec.a(this.J, localTypedArray, R.styleable.bv));
    b(MotionSpec.a(this.J, localTypedArray, R.styleable.bq));
    f(localTypedArray.getDimension(R.styleable.be, 0.0F));
    g(localTypedArray.getDimension(R.styleable.bs, 0.0F));
    h(localTypedArray.getDimension(R.styleable.br, 0.0F));
    i(localTypedArray.getDimension(R.styleable.bx, 0.0F));
    j(localTypedArray.getDimension(R.styleable.bw, 0.0F));
    k(localTypedArray.getDimension(R.styleable.bm, 0.0F));
    l(localTypedArray.getDimension(R.styleable.bk, 0.0F));
    m(localTypedArray.getDimension(R.styleable.aW, 0.0F));
    C(localTypedArray.getDimensionPixelSize(R.styleable.aN, 2147483647));
    localTypedArray.recycle();
  }
  
  private static boolean a(@Nullable int[] paramArrayOfInt, @AttrRes int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfInt[i1] == paramInt) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(@NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    Object localObject = this.c;
    if (localObject != null) {
      i1 = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.R);
    } else {
      i1 = 0;
    }
    int i2 = E(i1);
    if (this.R != i2)
    {
      this.R = i2;
      bool1 = true;
    }
    localObject = this.d;
    if (localObject != null) {
      i1 = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.S);
    } else {
      i1 = 0;
    }
    int i1 = E(i1);
    if (this.S != i1)
    {
      this.S = i1;
      bool1 = true;
    }
    int i3 = MaterialColors.a(i2, i1);
    if (this.T != i3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (M() == null) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i1 | i2) != 0)
    {
      this.T = i3;
      g(ColorStateList.valueOf(this.T));
      bool1 = true;
    }
    localObject = this.g;
    if (localObject != null) {
      i1 = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.U);
    } else {
      i1 = 0;
    }
    if (this.U != i1)
    {
      this.U = i1;
      bool1 = true;
    }
    if ((this.ag != null) && (RippleUtils.a(paramArrayOfInt1))) {
      i1 = this.ag.getColorForState(paramArrayOfInt1, this.V);
    } else {
      i1 = 0;
    }
    boolean bool2 = bool1;
    if (this.V != i1)
    {
      this.V = i1;
      bool2 = bool1;
      if (this.af) {
        bool2 = true;
      }
    }
    if ((this.Q.b() != null) && (this.Q.b().a != null)) {
      i1 = this.Q.b().a.getColorForState(paramArrayOfInt1, this.W);
    } else {
      i1 = 0;
    }
    bool1 = bool2;
    if (this.W != i1)
    {
      this.W = i1;
      bool1 = true;
    }
    boolean bool3;
    if ((a(getState(), 16842912)) && (this.v)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    bool2 = bool1;
    if (this.X != bool3)
    {
      bool2 = bool1;
      if (this.x != null)
      {
        float f1 = c();
        this.X = bool3;
        if (f1 != c())
        {
          bool2 = true;
          i1 = 1;
          break label461;
        }
        bool2 = true;
      }
    }
    i1 = 0;
    label461:
    localObject = this.ac;
    if (localObject != null) {
      i2 = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.Y);
    } else {
      i2 = 0;
    }
    if (this.Y != i2)
    {
      this.Y = i2;
      this.ab = DrawableUtils.a(this, this.ac, this.ad);
      bool2 = true;
    }
    bool1 = bool2;
    if (d(this.l)) {
      bool1 = bool2 | this.l.setState(paramArrayOfInt1);
    }
    bool2 = bool1;
    if (d(this.x)) {
      bool2 = bool1 | this.x.setState(paramArrayOfInt1);
    }
    bool1 = bool2;
    if (d(this.q))
    {
      localObject = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
      System.arraycopy(paramArrayOfInt1, 0, localObject, 0, paramArrayOfInt1.length);
      System.arraycopy(paramArrayOfInt2, 0, localObject, paramArrayOfInt1.length, paramArrayOfInt2.length);
      bool1 = bool2 | this.q.setState((int[])localObject);
    }
    bool2 = bool1;
    if (RippleUtils.a)
    {
      bool2 = bool1;
      if (d(this.r)) {
        bool2 = bool1 | this.r.setState(paramArrayOfInt2);
      }
    }
    if (bool2) {
      invalidateSelf();
    }
    if (i1 != 0) {
      b();
    }
    return bool2;
  }
  
  private boolean ag()
  {
    return (this.k) && (this.l != null);
  }
  
  private boolean ah()
  {
    return (this.w) && (this.x != null) && (this.X);
  }
  
  private boolean ai()
  {
    return (this.p) && (this.q != null);
  }
  
  private boolean aj()
  {
    return (this.w) && (this.x != null) && (this.v);
  }
  
  private float ak()
  {
    Drawable localDrawable;
    if (this.X) {
      localDrawable = this.x;
    } else {
      localDrawable = this.l;
    }
    if ((this.n <= 0.0F) && (localDrawable != null)) {
      return localDrawable.getIntrinsicWidth();
    }
    return this.n;
  }
  
  private float al()
  {
    Drawable localDrawable;
    if (this.X) {
      localDrawable = this.x;
    } else {
      localDrawable = this.l;
    }
    if ((this.n <= 0.0F) && (localDrawable != null))
    {
      float f1 = (float)Math.ceil(ViewUtils.a(this.J, 24));
      if (localDrawable.getIntrinsicHeight() <= f1) {
        return localDrawable.getIntrinsicHeight();
      }
      return f1;
    }
    return this.n;
  }
  
  private float am()
  {
    this.Q.a().getFontMetrics(this.M);
    return (this.M.descent + this.M.ascent) / 2.0F;
  }
  
  @Nullable
  private ColorFilter an()
  {
    ColorFilter localColorFilter = this.aa;
    if (localColorFilter != null) {
      return localColorFilter;
    }
    return this.ab;
  }
  
  private void ao()
  {
    ColorStateList localColorStateList;
    if (this.af) {
      localColorStateList = RippleUtils.b(this.i);
    } else {
      localColorStateList = null;
    }
    this.ag = localColorStateList;
  }
  
  @TargetApi(21)
  private void ap()
  {
    this.r = new RippleDrawable(RippleUtils.b(m()), this.q, b);
  }
  
  private void b(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (!this.al)
    {
      this.K.setColor(this.S);
      this.K.setStyle(Paint.Style.FILL);
      this.K.setColorFilter(an());
      this.N.set(paramRect);
      paramCanvas.drawRoundRect(this.N, j(), j(), this.K);
    }
  }
  
  private void b(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (this.j != null)
    {
      float f1 = this.B + c() + this.E;
      float f2 = this.I + d() + this.F;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.left = (paramRect.left + f1);
        paramRectF.right = (paramRect.right - f2);
      }
      else
      {
        paramRectF.left = (paramRect.left + f2);
        paramRectF.right = (paramRect.right - f1);
      }
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    }
  }
  
  private static boolean b(@Nullable TextAppearance paramTextAppearance)
  {
    return (paramTextAppearance != null) && (paramTextAppearance.a != null) && (paramTextAppearance.a.isStateful());
  }
  
  private void c(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if ((this.h > 0.0F) && (!this.al))
    {
      this.K.setColor(this.U);
      this.K.setStyle(Paint.Style.STROKE);
      if (!this.al) {
        this.K.setColorFilter(an());
      }
      this.N.set(paramRect.left + this.h / 2.0F, paramRect.top + this.h / 2.0F, paramRect.right - this.h / 2.0F, paramRect.bottom - this.h / 2.0F);
      float f1 = this.f - this.h / 2.0F;
      paramCanvas.drawRoundRect(this.N, f1, f1, this.K);
    }
  }
  
  private void c(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (ai())
    {
      float f1 = this.I + this.H;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.right = (paramRect.right - f1);
        paramRectF.left = (paramRectF.right - this.t);
      }
      else
      {
        paramRectF.left = (paramRect.left + f1);
        paramRectF.right = (paramRectF.left + this.t);
      }
      paramRectF.top = (paramRect.exactCenterY() - this.t / 2.0F);
      paramRectF.bottom = (paramRectF.top + this.t);
    }
  }
  
  private void d(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    this.K.setColor(this.V);
    this.K.setStyle(Paint.Style.FILL);
    this.N.set(paramRect);
    if (!this.al)
    {
      paramCanvas.drawRoundRect(this.N, j(), j(), this.K);
      return;
    }
    a(new RectF(paramRect), this.P);
    super.a(paramCanvas, this.K, this.P, Q());
  }
  
  private void d(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.set(paramRect);
    if (ai())
    {
      float f1 = this.I + this.H + this.t + this.G + this.F;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.right = (paramRect.right - f1);
        return;
      }
      paramRectF.left = (paramRect.left + f1);
    }
  }
  
  private static boolean d(@Nullable Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful());
  }
  
  private void e(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (ag())
    {
      a(paramRect, this.N);
      float f1 = this.N.left;
      float f2 = this.N.top;
      paramCanvas.translate(f1, f2);
      this.l.setBounds(0, 0, (int)this.N.width(), (int)this.N.height());
      this.l.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void e(@NonNull Rect paramRect, @NonNull RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (ai())
    {
      float f1 = this.I + this.H + this.t + this.G + this.F;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramRectF.right = paramRect.right;
        paramRectF.left = (paramRectF.right - f1);
      }
      else
      {
        paramRectF.left = paramRect.left;
        paramRectF.right = (paramRect.left + f1);
      }
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    }
  }
  
  private void e(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void f(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (ah())
    {
      a(paramRect, this.N);
      float f1 = this.N.left;
      float f2 = this.N.top;
      paramCanvas.translate(f1, f2);
      this.x.setBounds(0, 0, (int)this.N.width(), (int)this.N.height());
      this.x.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void f(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setCallback(this);
    DrawableCompat.setLayoutDirection(paramDrawable, DrawableCompat.getLayoutDirection(this));
    paramDrawable.setLevel(getLevel());
    paramDrawable.setVisible(isVisible(), false);
    if (paramDrawable == this.q)
    {
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(g());
      }
      DrawableCompat.setTintList(paramDrawable, this.s);
      return;
    }
    if (paramDrawable.isStateful()) {
      paramDrawable.setState(getState());
    }
    Drawable localDrawable = this.l;
    if ((paramDrawable == localDrawable) && (this.o)) {
      DrawableCompat.setTintList(localDrawable, this.m);
    }
  }
  
  private void g(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (this.j != null)
    {
      Object localObject = a(paramRect, this.O);
      b(paramRect, this.N);
      if (this.Q.b() != null)
      {
        this.Q.a().drawableState = getState();
        this.Q.a(this.J);
      }
      this.Q.a().setTextAlign((Paint.Align)localObject);
      int i1 = Math.round(this.Q.a(n().toString()));
      int i3 = Math.round(this.N.width());
      int i2 = 0;
      if (i1 > i3) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        i2 = paramCanvas.save();
        paramCanvas.clipRect(this.N);
      }
      localObject = this.j;
      paramRect = (Rect)localObject;
      if (i1 != 0)
      {
        paramRect = (Rect)localObject;
        if (this.ai != null) {
          paramRect = TextUtils.ellipsize((CharSequence)localObject, this.Q.a(), this.N.width(), this.ai);
        }
      }
      paramCanvas.drawText(paramRect, 0, paramRect.length(), this.O.x, this.O.y, this.Q.a());
      if (i1 != 0) {
        paramCanvas.restoreToCount(i2);
      }
    }
  }
  
  private void h(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    if (ai())
    {
      c(paramRect, this.N);
      float f1 = this.N.left;
      float f2 = this.N.top;
      paramCanvas.translate(f1, f2);
      this.q.setBounds(0, 0, (int)this.N.width(), (int)this.N.height());
      if (RippleUtils.a)
      {
        this.r.setBounds(this.q.getBounds());
        this.r.jumpToCurrentState();
        this.r.draw(paramCanvas);
      }
      else
      {
        this.q.draw(paramCanvas);
      }
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void i(@NonNull Canvas paramCanvas, @NonNull Rect paramRect)
  {
    Paint localPaint = this.L;
    if (localPaint != null)
    {
      localPaint.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
      paramCanvas.drawRect(paramRect, this.L);
      if ((ag()) || (ah()))
      {
        a(paramRect, this.N);
        paramCanvas.drawRect(this.N, this.L);
      }
      if (this.j != null) {
        paramCanvas.drawLine(paramRect.left, paramRect.exactCenterY(), paramRect.right, paramRect.exactCenterY(), this.L);
      }
      if (ai())
      {
        c(paramRect, this.N);
        paramCanvas.drawRect(this.N, this.L);
      }
      this.L.setColor(ColorUtils.setAlphaComponent(-65536, 127));
      d(paramRect, this.N);
      paramCanvas.drawRect(this.N, this.L);
      this.L.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
      e(paramRect, this.N);
      paramCanvas.drawRect(this.N, this.L);
    }
  }
  
  private static boolean i(@Nullable ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  private void j(@Nullable ColorStateList paramColorStateList)
  {
    if (this.c != paramColorStateList)
    {
      this.c = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  @Nullable
  public ColorStateList A()
  {
    return this.y;
  }
  
  public void A(@DimenRes int paramInt)
  {
    l(this.J.getResources().getDimension(paramInt));
  }
  
  @Nullable
  public MotionSpec B()
  {
    return this.z;
  }
  
  public void B(@DimenRes int paramInt)
  {
    m(this.J.getResources().getDimension(paramInt));
  }
  
  @Nullable
  public MotionSpec C()
  {
    return this.A;
  }
  
  public void C(@Px int paramInt)
  {
    this.ak = paramInt;
  }
  
  public float D()
  {
    return this.B;
  }
  
  public float E()
  {
    return this.C;
  }
  
  public float F()
  {
    return this.D;
  }
  
  public float G()
  {
    return this.E;
  }
  
  public float H()
  {
    return this.F;
  }
  
  public float I()
  {
    return this.G;
  }
  
  public float J()
  {
    return this.H;
  }
  
  public float K()
  {
    return this.I;
  }
  
  boolean L()
  {
    return this.aj;
  }
  
  @NonNull
  Paint.Align a(@NonNull Rect paramRect, @NonNull PointF paramPointF)
  {
    paramPointF.set(0.0F, 0.0F);
    Paint.Align localAlign = Paint.Align.LEFT;
    if (this.j != null)
    {
      float f1 = this.B + c() + this.E;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        paramPointF.x = (paramRect.left + f1);
        localAlign = Paint.Align.LEFT;
      }
      else
      {
        paramPointF.x = (paramRect.right - f1);
        localAlign = Paint.Align.RIGHT;
      }
      paramPointF.y = (paramRect.centerY() - am());
    }
    return localAlign;
  }
  
  public void a(float paramFloat)
  {
    if (this.e != paramFloat)
    {
      this.e = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void a(@ColorRes int paramInt)
  {
    a(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public void a(@Nullable ColorStateList paramColorStateList)
  {
    if (this.d != paramColorStateList)
    {
      this.d = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void a(@NonNull RectF paramRectF)
  {
    e(getBounds(), paramRectF);
  }
  
  public void a(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = q();
    if (localDrawable != paramDrawable)
    {
      float f1 = c();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      this.l = paramDrawable;
      float f2 = c();
      e(localDrawable);
      if (ag()) {
        f(this.l);
      }
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public void a(@Nullable TextUtils.TruncateAt paramTruncateAt)
  {
    this.ai = paramTruncateAt;
  }
  
  public void a(@Nullable MotionSpec paramMotionSpec)
  {
    this.z = paramMotionSpec;
  }
  
  public void a(@Nullable ChipDrawable.Delegate paramDelegate)
  {
    this.ah = new WeakReference(paramDelegate);
  }
  
  public void a(@Nullable TextAppearance paramTextAppearance)
  {
    this.Q.a(paramTextAppearance, this.J);
  }
  
  public void a(@Nullable CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!TextUtils.equals(this.j, (CharSequence)localObject))
    {
      this.j = ((CharSequence)localObject);
      this.Q.a(true);
      invalidateSelf();
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.af != paramBoolean)
    {
      this.af = paramBoolean;
      ao();
      onStateChange(getState());
    }
  }
  
  public boolean a()
  {
    return this.af;
  }
  
  public boolean a(@NonNull int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.ae, paramArrayOfInt))
    {
      this.ae = paramArrayOfInt;
      if (ai()) {
        return a(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  protected void b()
  {
    ChipDrawable.Delegate localDelegate = (ChipDrawable.Delegate)this.ah.get();
    if (localDelegate != null) {
      localDelegate.a();
    }
  }
  
  @Deprecated
  public void b(float paramFloat)
  {
    if (this.f != paramFloat)
    {
      this.f = paramFloat;
      setShapeAppearanceModel(getShapeAppearanceModel().a(paramFloat));
    }
  }
  
  public void b(@DimenRes int paramInt)
  {
    a(this.J.getResources().getDimension(paramInt));
  }
  
  public void b(@Nullable ColorStateList paramColorStateList)
  {
    if (this.g != paramColorStateList)
    {
      this.g = paramColorStateList;
      if (this.al) {
        h(paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void b(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable = u();
    if (localDrawable != paramDrawable)
    {
      float f1 = d();
      if (paramDrawable != null) {
        paramDrawable = DrawableCompat.wrap(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      this.q = paramDrawable;
      if (RippleUtils.a) {
        ap();
      }
      float f2 = d();
      e(localDrawable);
      if (ai()) {
        f(this.q);
      }
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public void b(@Nullable MotionSpec paramMotionSpec)
  {
    this.A = paramMotionSpec;
  }
  
  public void b(@Nullable CharSequence paramCharSequence)
  {
    if (this.u != paramCharSequence)
    {
      this.u = BidiFormatter.getInstance().unicodeWrap(paramCharSequence);
      invalidateSelf();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.k != paramBoolean)
    {
      boolean bool = ag();
      this.k = paramBoolean;
      paramBoolean = ag();
      int i1;
      if (bool != paramBoolean) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (paramBoolean) {
          f(this.l);
        } else {
          e(this.l);
        }
        invalidateSelf();
        b();
      }
    }
  }
  
  float c()
  {
    if ((!ag()) && (!ah())) {
      return 0.0F;
    }
    return this.C + ak() + this.D;
  }
  
  public void c(float paramFloat)
  {
    if (this.h != paramFloat)
    {
      this.h = paramFloat;
      this.K.setStrokeWidth(paramFloat);
      if (this.al) {
        super.n(paramFloat);
      }
      invalidateSelf();
    }
  }
  
  @Deprecated
  public void c(@DimenRes int paramInt)
  {
    b(this.J.getResources().getDimension(paramInt));
  }
  
  public void c(@Nullable ColorStateList paramColorStateList)
  {
    if (this.i != paramColorStateList)
    {
      this.i = paramColorStateList;
      ao();
      onStateChange(getState());
    }
  }
  
  public void c(@Nullable Drawable paramDrawable)
  {
    if (this.x != paramDrawable)
    {
      float f1 = c();
      this.x = paramDrawable;
      float f2 = c();
      e(this.x);
      f(this.x);
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.p != paramBoolean)
    {
      boolean bool = ai();
      this.p = paramBoolean;
      paramBoolean = ai();
      int i1;
      if (bool != paramBoolean) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (paramBoolean) {
          f(this.q);
        } else {
          e(this.q);
        }
        invalidateSelf();
        b();
      }
    }
  }
  
  float d()
  {
    if (ai()) {
      return this.G + this.t + this.H;
    }
    return 0.0F;
  }
  
  public void d(float paramFloat)
  {
    if (this.n != paramFloat)
    {
      float f1 = c();
      this.n = paramFloat;
      paramFloat = c();
      invalidateSelf();
      if (f1 != paramFloat) {
        b();
      }
    }
  }
  
  public void d(@ColorRes int paramInt)
  {
    b(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public void d(@Nullable ColorStateList paramColorStateList)
  {
    this.o = true;
    if (this.m != paramColorStateList)
    {
      this.m = paramColorStateList;
      if (ag()) {
        DrawableCompat.setTintList(this.l, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.v != paramBoolean)
    {
      this.v = paramBoolean;
      float f1 = c();
      if ((!paramBoolean) && (this.X)) {
        this.X = false;
      }
      float f2 = c();
      invalidateSelf();
      if (f1 != f2) {
        b();
      }
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (!localRect.isEmpty())
    {
      if (getAlpha() == 0) {
        return;
      }
      int i1 = 0;
      if (this.Z < 255) {
        i1 = CanvasCompat.a(paramCanvas, localRect.left, localRect.top, localRect.right, localRect.bottom, this.Z);
      }
      a(paramCanvas, localRect);
      b(paramCanvas, localRect);
      if (this.al) {
        super.draw(paramCanvas);
      }
      c(paramCanvas, localRect);
      d(paramCanvas, localRect);
      e(paramCanvas, localRect);
      f(paramCanvas, localRect);
      if (this.aj) {
        g(paramCanvas, localRect);
      }
      h(paramCanvas, localRect);
      i(paramCanvas, localRect);
      if (this.Z < 255) {
        paramCanvas.restoreToCount(i1);
      }
    }
  }
  
  public void e(float paramFloat)
  {
    if (this.t != paramFloat)
    {
      this.t = paramFloat;
      invalidateSelf();
      if (ai()) {
        b();
      }
    }
  }
  
  public void e(@DimenRes int paramInt)
  {
    c(this.J.getResources().getDimension(paramInt));
  }
  
  public void e(@Nullable ColorStateList paramColorStateList)
  {
    if (this.s != paramColorStateList)
    {
      this.s = paramColorStateList;
      if (ai()) {
        DrawableCompat.setTintList(this.q, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.w != paramBoolean)
    {
      boolean bool = ah();
      this.w = paramBoolean;
      paramBoolean = ah();
      int i1;
      if (bool != paramBoolean) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        if (paramBoolean) {
          f(this.x);
        } else {
          e(this.x);
        }
        invalidateSelf();
        b();
      }
    }
  }
  
  public boolean e()
  {
    return d(this.q);
  }
  
  public void f()
  {
    b();
    invalidateSelf();
  }
  
  public void f(float paramFloat)
  {
    if (this.B != paramFloat)
    {
      this.B = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void f(@ColorRes int paramInt)
  {
    c(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public void f(@Nullable ColorStateList paramColorStateList)
  {
    if (this.y != paramColorStateList)
    {
      this.y = paramColorStateList;
      if (aj()) {
        DrawableCompat.setTintList(this.x, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  void f(boolean paramBoolean)
  {
    this.aj = paramBoolean;
  }
  
  public void g(float paramFloat)
  {
    if (this.C != paramFloat)
    {
      float f1 = c();
      this.C = paramFloat;
      paramFloat = c();
      invalidateSelf();
      if (f1 != paramFloat) {
        b();
      }
    }
  }
  
  public void g(@StyleRes int paramInt)
  {
    a(new TextAppearance(this.J, paramInt));
  }
  
  @NonNull
  public int[] g()
  {
    return this.ae;
  }
  
  public int getAlpha()
  {
    return this.Z;
  }
  
  @Nullable
  public ColorFilter getColorFilter()
  {
    return this.aa;
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return Math.min(Math.round(this.B + c() + this.E + this.Q.a(n().toString()) + this.F + d() + this.I), this.ak);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.al)
    {
      super.getOutline(paramOutline);
      return;
    }
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, this.f);
    } else {
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f);
    }
    paramOutline.setAlpha(getAlpha() / 255.0F);
  }
  
  @Nullable
  public ColorStateList h()
  {
    return this.d;
  }
  
  public void h(float paramFloat)
  {
    if (this.D != paramFloat)
    {
      float f1 = c();
      this.D = paramFloat;
      paramFloat = c();
      invalidateSelf();
      if (f1 != paramFloat) {
        b();
      }
    }
  }
  
  public void h(@BoolRes int paramInt)
  {
    b(this.J.getResources().getBoolean(paramInt));
  }
  
  public float i()
  {
    return this.e;
  }
  
  public void i(float paramFloat)
  {
    if (this.E != paramFloat)
    {
      this.E = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void i(@DrawableRes int paramInt)
  {
    a(AppCompatResources.getDrawable(this.J, paramInt));
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public boolean isStateful()
  {
    return (i(this.c)) || (i(this.d)) || (i(this.g)) || ((this.af) && (i(this.ag))) || (b(this.Q.b())) || (aj()) || (d(this.l)) || (d(this.x)) || (i(this.ac));
  }
  
  public float j()
  {
    if (this.al) {
      return ab();
    }
    return this.f;
  }
  
  public void j(float paramFloat)
  {
    if (this.F != paramFloat)
    {
      this.F = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void j(@ColorRes int paramInt)
  {
    d(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  @Nullable
  public ColorStateList k()
  {
    return this.g;
  }
  
  public void k(float paramFloat)
  {
    if (this.G != paramFloat)
    {
      this.G = paramFloat;
      invalidateSelf();
      if (ai()) {
        b();
      }
    }
  }
  
  public void k(@DimenRes int paramInt)
  {
    d(this.J.getResources().getDimension(paramInt));
  }
  
  public float l()
  {
    return this.h;
  }
  
  public void l(float paramFloat)
  {
    if (this.H != paramFloat)
    {
      this.H = paramFloat;
      invalidateSelf();
      if (ai()) {
        b();
      }
    }
  }
  
  public void l(@DrawableRes int paramInt)
  {
    b(AppCompatResources.getDrawable(this.J, paramInt));
  }
  
  @Nullable
  public ColorStateList m()
  {
    return this.i;
  }
  
  public void m(float paramFloat)
  {
    if (this.I != paramFloat)
    {
      this.I = paramFloat;
      invalidateSelf();
      b();
    }
  }
  
  public void m(@ColorRes int paramInt)
  {
    e(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  @Nullable
  public CharSequence n()
  {
    return this.j;
  }
  
  public void n(@DimenRes int paramInt)
  {
    e(this.J.getResources().getDimension(paramInt));
  }
  
  @Nullable
  public TextAppearance o()
  {
    return this.Q.b();
  }
  
  public void o(@BoolRes int paramInt)
  {
    d(this.J.getResources().getBoolean(paramInt));
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (ag()) {
      bool1 = bool2 | DrawableCompat.setLayoutDirection(this.l, paramInt);
    }
    bool2 = bool1;
    if (ah()) {
      bool2 = bool1 | DrawableCompat.setLayoutDirection(this.x, paramInt);
    }
    bool1 = bool2;
    if (ai()) {
      bool1 = bool2 | DrawableCompat.setLayoutDirection(this.q, paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (ag()) {
      bool1 = bool2 | this.l.setLevel(paramInt);
    }
    bool2 = bool1;
    if (ah()) {
      bool2 = bool1 | this.x.setLevel(paramInt);
    }
    bool1 = bool2;
    if (ai()) {
      bool1 = bool2 | this.q.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public boolean onStateChange(@NonNull int[] paramArrayOfInt)
  {
    if (this.al) {
      super.onStateChange(paramArrayOfInt);
    }
    return a(paramArrayOfInt, g());
  }
  
  public TextUtils.TruncateAt p()
  {
    return this.ai;
  }
  
  public void p(@BoolRes int paramInt)
  {
    e(this.J.getResources().getBoolean(paramInt));
  }
  
  @Nullable
  public Drawable q()
  {
    Drawable localDrawable = this.l;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  public void q(@DrawableRes int paramInt)
  {
    c(AppCompatResources.getDrawable(this.J, paramInt));
  }
  
  @Nullable
  public ColorStateList r()
  {
    return this.m;
  }
  
  public void r(@ColorRes int paramInt)
  {
    f(AppCompatResources.getColorStateList(this.J, paramInt));
  }
  
  public float s()
  {
    return this.n;
  }
  
  public void s(@AnimatorRes int paramInt)
  {
    a(MotionSpec.a(this.J, paramInt));
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.Z != paramInt)
    {
      this.Z = paramInt;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    if (this.aa != paramColorFilter)
    {
      this.aa = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.ac != paramColorStateList)
    {
      this.ac = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    if (this.ad != paramMode)
    {
      this.ad = paramMode;
      this.ab = DrawableUtils.a(this, this.ac, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (ag()) {
      bool1 = bool2 | this.l.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (ah()) {
      bool2 = bool1 | this.x.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (ai()) {
      bool1 = bool2 | this.q.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public void t(@AnimatorRes int paramInt)
  {
    b(MotionSpec.a(this.J, paramInt));
  }
  
  public boolean t()
  {
    return this.p;
  }
  
  @Nullable
  public Drawable u()
  {
    Drawable localDrawable = this.q;
    if (localDrawable != null) {
      return DrawableCompat.unwrap(localDrawable);
    }
    return null;
  }
  
  public void u(@DimenRes int paramInt)
  {
    f(this.J.getResources().getDimension(paramInt));
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  @Nullable
  public ColorStateList v()
  {
    return this.s;
  }
  
  public void v(@DimenRes int paramInt)
  {
    g(this.J.getResources().getDimension(paramInt));
  }
  
  public float w()
  {
    return this.t;
  }
  
  public void w(@DimenRes int paramInt)
  {
    h(this.J.getResources().getDimension(paramInt));
  }
  
  @Nullable
  public CharSequence x()
  {
    return this.u;
  }
  
  public void x(@DimenRes int paramInt)
  {
    i(this.J.getResources().getDimension(paramInt));
  }
  
  public void y(@DimenRes int paramInt)
  {
    j(this.J.getResources().getDimension(paramInt));
  }
  
  public boolean y()
  {
    return this.v;
  }
  
  @Nullable
  public Drawable z()
  {
    return this.x;
  }
  
  public void z(@DimenRes int paramInt)
  {
    k(this.J.getResources().getDimension(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.chip.ChipDrawable
 * JD-Core Version:    0.7.0.1
 */