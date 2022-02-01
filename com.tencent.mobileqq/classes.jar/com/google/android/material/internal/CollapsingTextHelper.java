package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper
{
  private static final boolean a;
  @NonNull
  private static final Paint b;
  @Nullable
  private CharSequence A;
  private boolean B;
  private boolean C;
  @Nullable
  private Bitmap D;
  private Paint E;
  private float F;
  private float G;
  private int[] H;
  private boolean I;
  @NonNull
  private final TextPaint J;
  @NonNull
  private final TextPaint K;
  private TimeInterpolator L;
  private TimeInterpolator M;
  private float N;
  private float O;
  private float P;
  private ColorStateList Q;
  private float R;
  private float S;
  private float T;
  private ColorStateList U;
  private float V;
  private float W;
  private StaticLayout X;
  private float Y;
  private float Z;
  private float aa;
  private CharSequence ab;
  private int ac = 1;
  private final View c;
  private boolean d;
  private float e;
  @NonNull
  private final Rect f;
  @NonNull
  private final Rect g;
  @NonNull
  private final RectF h;
  private int i = 16;
  private int j = 16;
  private float k = 15.0F;
  private float l = 15.0F;
  private ColorStateList m;
  private ColorStateList n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private Typeface u;
  private Typeface v;
  private Typeface w;
  private CancelableFontCallback x;
  private CancelableFontCallback y;
  @Nullable
  private CharSequence z;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
    b = null;
    Paint localPaint = b;
    if (localPaint != null)
    {
      localPaint.setAntiAlias(true);
      b.setColor(-65281);
    }
  }
  
  public CollapsingTextHelper(View paramView)
  {
    this.c = paramView;
    this.J = new TextPaint(129);
    this.K = new TextPaint(this.J);
    this.g = new Rect();
    this.f = new Rect();
    this.h = new RectF();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, @Nullable TimeInterpolator paramTimeInterpolator)
  {
    float f1 = paramFloat3;
    if (paramTimeInterpolator != null) {
      f1 = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    return AnimationUtils.a(paramFloat1, paramFloat2, f1);
  }
  
  private float a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (this.B) {
          return this.g.right - a();
        }
        return this.g.left;
      }
      if (this.B) {
        return this.g.left;
      }
      return this.g.right - a();
    }
    return paramInt1 / 2.0F - a() / 2.0F;
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f8 * f1 + f9 * paramFloat));
  }
  
  private StaticLayout a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      StaticLayout localStaticLayout = StaticLayoutBuilderCompat.a(this.z, this.J, (int)paramFloat).a(TextUtils.TruncateAt.END).b(paramBoolean).a(Layout.Alignment.ALIGN_NORMAL).a(false).a(paramInt).a();
    }
    catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException localStaticLayoutBuilderCompatException)
    {
      Log.e("CollapsingTextHelper", localStaticLayoutBuilderCompatException.getCause().getMessage(), localStaticLayoutBuilderCompatException);
      localObject = null;
    }
    return (StaticLayout)Preconditions.checkNotNull(localObject);
  }
  
  private void a(@NonNull Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    int i1 = this.J.getAlpha();
    paramCanvas.translate(paramFloat1, paramFloat2);
    Object localObject = this.J;
    paramFloat1 = this.Z;
    paramFloat2 = i1;
    ((TextPaint)localObject).setAlpha((int)(paramFloat1 * paramFloat2));
    this.X.draw(paramCanvas);
    this.J.setAlpha((int)(this.Y * paramFloat2));
    int i2 = this.X.getLineBaseline(0);
    localObject = this.ab;
    int i3 = ((CharSequence)localObject).length();
    paramFloat1 = i2;
    paramCanvas.drawText((CharSequence)localObject, 0, i3, 0.0F, paramFloat1, this.J);
    String str = this.ab.toString().trim();
    localObject = str;
    if (str.endsWith("…")) {
      localObject = str.substring(0, str.length() - 1);
    }
    this.J.setAlpha(i1);
    paramCanvas.drawText((String)localObject, 0, Math.min(this.X.getLineEnd(0), ((String)localObject).length()), 0.0F, paramFloat1, this.J);
  }
  
  private void a(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.k);
    paramTextPaint.setTypeface(this.v);
    if (Build.VERSION.SDK_INT >= 21) {
      paramTextPaint.setLetterSpacing(this.W);
    }
  }
  
  private static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  private static boolean a(@NonNull Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private float b(@NonNull RectF paramRectF, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (this.B) {
          return this.g.right;
        }
        return paramRectF.left + a();
      }
      if (this.B) {
        return paramRectF.left + a();
      }
      return this.g.right;
    }
    return paramInt1 / 2.0F + a() / 2.0F;
  }
  
  private void b(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.l);
    paramTextPaint.setTypeface(this.u);
    if (Build.VERSION.SDK_INT >= 21) {
      paramTextPaint.setLetterSpacing(this.V);
    }
  }
  
  private boolean b(@NonNull CharSequence paramCharSequence)
  {
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat;
    if (t()) {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    } else {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    }
    return localTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  @ColorInt
  private int c(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return 0;
    }
    int[] arrayOfInt = this.H;
    if (arrayOfInt != null) {
      return paramColorStateList.getColorForState(arrayOfInt, 0);
    }
    return paramColorStateList.getDefaultColor();
  }
  
  private void c(float paramFloat)
  {
    d(paramFloat);
    this.s = a(this.q, this.r, paramFloat, this.L);
    this.t = a(this.o, this.p, paramFloat, this.L);
    g(a(this.k, this.l, paramFloat, this.M));
    e(1.0F - a(0.0F, 1.0F, 1.0F - paramFloat, AnimationUtils.b));
    f(a(1.0F, 0.0F, paramFloat, AnimationUtils.b));
    if (this.n != this.m) {
      this.J.setColor(a(q(), k(), paramFloat));
    } else {
      this.J.setColor(k());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      float f1 = this.V;
      float f2 = this.W;
      if (f1 != f2) {
        this.J.setLetterSpacing(a(f2, f1, paramFloat, AnimationUtils.b));
      } else {
        this.J.setLetterSpacing(f1);
      }
    }
    this.J.setShadowLayer(a(this.R, this.N, paramFloat, null), a(this.S, this.O, paramFloat, null), a(this.T, this.P, paramFloat, null), a(c(this.U), c(this.Q), paramFloat));
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private void d(float paramFloat)
  {
    this.h.left = a(this.f.left, this.g.left, paramFloat, this.L);
    this.h.top = a(this.o, this.p, paramFloat, this.L);
    this.h.right = a(this.f.right, this.g.right, paramFloat, this.L);
    this.h.bottom = a(this.f.bottom, this.g.bottom, paramFloat, this.L);
  }
  
  private boolean d(Typeface paramTypeface)
  {
    CancelableFontCallback localCancelableFontCallback = this.y;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    if (this.u != paramTypeface)
    {
      this.u = paramTypeface;
      return true;
    }
    return false;
  }
  
  private void e(float paramFloat)
  {
    this.Y = paramFloat;
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private boolean e(Typeface paramTypeface)
  {
    CancelableFontCallback localCancelableFontCallback = this.x;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    if (this.v != paramTypeface)
    {
      this.v = paramTypeface;
      return true;
    }
    return false;
  }
  
  private void f(float paramFloat)
  {
    this.Z = paramFloat;
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private void g(float paramFloat)
  {
    h(paramFloat);
    boolean bool;
    if ((a) && (this.F != 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    this.C = bool;
    if (this.C) {
      u();
    }
    ViewCompat.postInvalidateOnAnimation(this.c);
  }
  
  private void h(float paramFloat)
  {
    if (this.z == null) {
      return;
    }
    float f2 = this.g.width();
    float f3 = this.f.width();
    boolean bool2 = a(paramFloat, this.l);
    boolean bool1 = false;
    int i3 = 1;
    float f1;
    Object localObject;
    Typeface localTypeface;
    int i1;
    if (bool2)
    {
      f1 = this.l;
      this.F = 1.0F;
      localObject = this.w;
      localTypeface = this.u;
      if (localObject != localTypeface)
      {
        this.w = localTypeface;
        i1 = 1;
        paramFloat = f2;
      }
      else
      {
        i1 = 0;
        paramFloat = f2;
      }
    }
    else
    {
      f1 = this.k;
      localObject = this.w;
      localTypeface = this.v;
      if (localObject != localTypeface)
      {
        this.w = localTypeface;
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if (a(paramFloat, this.k)) {
        this.F = 1.0F;
      } else {
        this.F = (paramFloat / this.k);
      }
      paramFloat = this.l / this.k;
      if (f3 * paramFloat > f2) {
        paramFloat = Math.min(f2 / paramFloat, f3);
      } else {
        paramFloat = f3;
      }
    }
    int i2 = i1;
    if (paramFloat > 0.0F)
    {
      if ((this.G == f1) && (!this.I) && (i1 == 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      this.G = f1;
      this.I = false;
      i2 = i1;
    }
    if ((this.A == null) || (i2 != 0))
    {
      this.J.setTextSize(this.G);
      this.J.setTypeface(this.w);
      localObject = this.J;
      if (this.F != 1.0F) {
        bool1 = true;
      }
      ((TextPaint)localObject).setLinearText(bool1);
      this.B = b(this.z);
      i1 = i3;
      if (s()) {
        i1 = this.ac;
      }
      this.X = a(i1, paramFloat, this.B);
      this.A = this.X.getText();
    }
  }
  
  private void p()
  {
    c(this.e);
  }
  
  @ColorInt
  private int q()
  {
    return c(this.m);
  }
  
  private void r()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean s()
  {
    return (this.ac > 1) && (!this.B) && (!this.C);
  }
  
  private boolean t()
  {
    return ViewCompat.getLayoutDirection(this.c) == 1;
  }
  
  private void u()
  {
    if ((this.D == null) && (!this.f.isEmpty()))
    {
      if (TextUtils.isEmpty(this.A)) {
        return;
      }
      c(0.0F);
      int i1 = this.X.getWidth();
      int i2 = this.X.getHeight();
      if (i1 > 0)
      {
        if (i2 <= 0) {
          return;
        }
        this.D = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.D);
        this.X.draw(localCanvas);
        if (this.E == null) {
          this.E = new Paint(3);
        }
      }
    }
  }
  
  private void v()
  {
    Bitmap localBitmap = this.D;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.D = null;
    }
  }
  
  public float a()
  {
    if (this.z == null) {
      return 0.0F;
    }
    b(this.K);
    TextPaint localTextPaint = this.K;
    CharSequence localCharSequence = this.z;
    return localTextPaint.measureText(localCharSequence, 0, localCharSequence.length());
  }
  
  public void a(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      l();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      l();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.f, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.f.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      d();
    }
  }
  
  public void a(TimeInterpolator paramTimeInterpolator)
  {
    this.M = paramTimeInterpolator;
    l();
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    if (this.n != paramColorStateList)
    {
      this.n = paramColorStateList;
      l();
    }
  }
  
  public void a(@NonNull Canvas paramCanvas)
  {
    int i3 = paramCanvas.save();
    if ((this.A != null) && (this.d))
    {
      float f1 = this.s;
      StaticLayout localStaticLayout = this.X;
      int i2 = 0;
      float f2 = localStaticLayout.getLineLeft(0);
      float f3 = this.aa;
      this.J.setTextSize(this.G);
      float f4 = this.s;
      float f5 = this.t;
      int i1 = i2;
      if (this.C)
      {
        i1 = i2;
        if (this.D != null) {
          i1 = 1;
        }
      }
      float f6 = this.F;
      if (f6 != 1.0F) {
        paramCanvas.scale(f6, f6, f4, f5);
      }
      if (i1 != 0)
      {
        paramCanvas.drawBitmap(this.D, f4, f5, this.E);
        paramCanvas.restoreToCount(i3);
        return;
      }
      if (s())
      {
        a(paramCanvas, f1 + f2 - f3 * 2.0F, f5);
      }
      else
      {
        paramCanvas.translate(f4, f5);
        this.X.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i3);
    }
  }
  
  public void a(@NonNull Rect paramRect)
  {
    a(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void a(@NonNull RectF paramRectF, int paramInt1, int paramInt2)
  {
    this.B = b(this.z);
    paramRectF.left = a(paramInt1, paramInt2);
    paramRectF.top = this.g.top;
    paramRectF.right = b(paramRectF, paramInt1, paramInt2);
    paramRectF.bottom = (this.g.top + c());
  }
  
  public void a(Typeface paramTypeface)
  {
    if (d(paramTypeface)) {
      l();
    }
  }
  
  public void a(@Nullable CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!TextUtils.equals(this.z, paramCharSequence)))
    {
      this.z = paramCharSequence;
      this.A = null;
      v();
      l();
    }
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    this.H = paramArrayOfInt;
    if (i())
    {
      l();
      return true;
    }
    return false;
  }
  
  public float b()
  {
    a(this.K);
    return -this.K.ascent();
  }
  
  public void b(float paramFloat)
  {
    paramFloat = MathUtils.clamp(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.e)
    {
      this.e = paramFloat;
      p();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      l();
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.g, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.g.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.I = true;
      d();
    }
  }
  
  public void b(TimeInterpolator paramTimeInterpolator)
  {
    this.L = paramTimeInterpolator;
    l();
  }
  
  public void b(ColorStateList paramColorStateList)
  {
    if (this.m != paramColorStateList)
    {
      this.m = paramColorStateList;
      l();
    }
  }
  
  public void b(@NonNull Rect paramRect)
  {
    b(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void b(Typeface paramTypeface)
  {
    if (e(paramTypeface)) {
      l();
    }
  }
  
  public float c()
  {
    b(this.K);
    return -this.K.ascent();
  }
  
  public void c(int paramInt)
  {
    TextAppearance localTextAppearance = new TextAppearance(this.c.getContext(), paramInt);
    if (localTextAppearance.a != null) {
      this.n = localTextAppearance.a;
    }
    if (localTextAppearance.n != 0.0F) {
      this.l = localTextAppearance.n;
    }
    if (localTextAppearance.d != null) {
      this.Q = localTextAppearance.d;
    }
    this.O = localTextAppearance.i;
    this.P = localTextAppearance.j;
    this.N = localTextAppearance.k;
    this.V = localTextAppearance.m;
    CancelableFontCallback localCancelableFontCallback = this.y;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    this.y = new CancelableFontCallback(new CollapsingTextHelper.1(this), localTextAppearance.a());
    localTextAppearance.a(this.c.getContext(), this.y);
    l();
  }
  
  public void c(Typeface paramTypeface)
  {
    boolean bool1 = d(paramTypeface);
    boolean bool2 = e(paramTypeface);
    if ((bool1) || (bool2)) {
      l();
    }
  }
  
  void d()
  {
    boolean bool;
    if ((this.g.width() > 0) && (this.g.height() > 0) && (this.f.width() > 0) && (this.f.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public void d(int paramInt)
  {
    TextAppearance localTextAppearance = new TextAppearance(this.c.getContext(), paramInt);
    if (localTextAppearance.a != null) {
      this.m = localTextAppearance.a;
    }
    if (localTextAppearance.n != 0.0F) {
      this.k = localTextAppearance.n;
    }
    if (localTextAppearance.d != null) {
      this.U = localTextAppearance.d;
    }
    this.S = localTextAppearance.i;
    this.T = localTextAppearance.j;
    this.R = localTextAppearance.k;
    this.W = localTextAppearance.m;
    CancelableFontCallback localCancelableFontCallback = this.x;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    this.x = new CancelableFontCallback(new CollapsingTextHelper.2(this), localTextAppearance.a());
    localTextAppearance.a(this.c.getContext(), this.x);
    l();
  }
  
  public int e()
  {
    return this.i;
  }
  
  public void e(int paramInt)
  {
    if (paramInt != this.ac)
    {
      this.ac = paramInt;
      v();
      l();
    }
  }
  
  public int f()
  {
    return this.j;
  }
  
  public Typeface g()
  {
    Typeface localTypeface = this.u;
    if (localTypeface != null) {
      return localTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public Typeface h()
  {
    Typeface localTypeface = this.v;
    if (localTypeface != null) {
      return localTypeface;
    }
    return Typeface.DEFAULT;
  }
  
  public final boolean i()
  {
    ColorStateList localColorStateList = this.n;
    if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
      localColorStateList = this.m;
    }
    return (localColorStateList != null) && (localColorStateList.isStateful());
  }
  
  public float j()
  {
    return this.e;
  }
  
  @ColorInt
  public int k()
  {
    return c(this.n);
  }
  
  public void l()
  {
    if ((this.c.getHeight() > 0) && (this.c.getWidth() > 0))
    {
      r();
      p();
    }
  }
  
  @Nullable
  public CharSequence m()
  {
    return this.z;
  }
  
  public int n()
  {
    return this.ac;
  }
  
  public ColorStateList o()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.CollapsingTextHelper
 * JD-Core Version:    0.7.0.1
 */