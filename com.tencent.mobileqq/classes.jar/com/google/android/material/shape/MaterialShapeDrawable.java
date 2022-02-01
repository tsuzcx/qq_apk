package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R.attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.BitSet;

public class MaterialShapeDrawable
  extends Drawable
  implements TintAwareDrawable, Shapeable
{
  private static final String a = "MaterialShapeDrawable";
  private static final Paint b = new Paint(1);
  private MaterialShapeDrawable.MaterialShapeDrawableState c;
  private final ShapePath.ShadowCompatOperation[] d = new ShapePath.ShadowCompatOperation[4];
  private final ShapePath.ShadowCompatOperation[] e = new ShapePath.ShadowCompatOperation[4];
  private final BitSet f = new BitSet(8);
  private boolean g;
  private final Matrix h = new Matrix();
  private final Path i = new Path();
  private final Path j = new Path();
  private final RectF k = new RectF();
  private final RectF l = new RectF();
  private final Region m = new Region();
  private final Region n = new Region();
  private ShapeAppearanceModel o;
  private final Paint p = new Paint(1);
  private final Paint q = new Paint(1);
  private final ShadowRenderer r = new ShadowRenderer();
  @NonNull
  private final ShapeAppearancePathProvider.PathListener s;
  private final ShapeAppearancePathProvider t;
  @Nullable
  private PorterDuffColorFilter u;
  @Nullable
  private PorterDuffColorFilter v;
  @NonNull
  private final RectF w;
  private boolean x;
  
  public MaterialShapeDrawable()
  {
    this(new ShapeAppearanceModel());
  }
  
  public MaterialShapeDrawable(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    this(ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt1, paramInt2).a());
  }
  
  private MaterialShapeDrawable(@NonNull MaterialShapeDrawable.MaterialShapeDrawableState paramMaterialShapeDrawableState)
  {
    ShapeAppearancePathProvider localShapeAppearancePathProvider;
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      localShapeAppearancePathProvider = ShapeAppearancePathProvider.a();
    } else {
      localShapeAppearancePathProvider = new ShapeAppearancePathProvider();
    }
    this.t = localShapeAppearancePathProvider;
    this.w = new RectF();
    this.x = true;
    this.c = paramMaterialShapeDrawableState;
    this.q.setStyle(Paint.Style.STROKE);
    this.p.setStyle(Paint.Style.FILL);
    b.setColor(-1);
    b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    g();
    a(getState());
    this.s = new MaterialShapeDrawable.1(this);
  }
  
  public MaterialShapeDrawable(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this(new MaterialShapeDrawable.MaterialShapeDrawableState(paramShapeAppearanceModel, null));
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 * (paramInt2 + (paramInt2 >>> 7)) >>> 8;
  }
  
  @NonNull
  private PorterDuffColorFilter a(@Nullable ColorStateList paramColorStateList, @Nullable PorterDuff.Mode paramMode, @NonNull Paint paramPaint, boolean paramBoolean)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return a(paramColorStateList, paramMode, paramBoolean);
    }
    return a(paramPaint, paramBoolean);
  }
  
  @NonNull
  private PorterDuffColorFilter a(@NonNull ColorStateList paramColorStateList, @NonNull PorterDuff.Mode paramMode, boolean paramBoolean)
  {
    int i2 = paramColorStateList.getColorForState(getState(), 0);
    int i1 = i2;
    if (paramBoolean) {
      i1 = E(i2);
    }
    return new PorterDuffColorFilter(i1, paramMode);
  }
  
  @Nullable
  private PorterDuffColorFilter a(@NonNull Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i1 = paramPaint.getColor();
      int i2 = E(i1);
      if (i2 != i1) {
        return new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN);
      }
    }
    return null;
  }
  
  @NonNull
  public static MaterialShapeDrawable a(Context paramContext, float paramFloat)
  {
    int i1 = MaterialColors.a(paramContext, R.attr.t, MaterialShapeDrawable.class.getSimpleName());
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    localMaterialShapeDrawable.a(paramContext);
    localMaterialShapeDrawable.g(ColorStateList.valueOf(i1));
    localMaterialShapeDrawable.r(paramFloat);
    return localMaterialShapeDrawable;
  }
  
  private void a()
  {
    float f1 = W();
    this.c.r = ((int)Math.ceil(0.75F * f1));
    this.c.s = ((int)Math.ceil(f1 * 0.25F));
    g();
    b();
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if (!c()) {
      return;
    }
    paramCanvas.save();
    d(paramCanvas);
    if (!this.x)
    {
      e(paramCanvas);
      paramCanvas.restore();
      return;
    }
    int i1 = (int)(this.w.width() - getBounds().width());
    int i2 = (int)(this.w.height() - getBounds().height());
    if ((i1 >= 0) && (i2 >= 0))
    {
      Bitmap localBitmap = Bitmap.createBitmap((int)this.w.width() + this.c.r * 2 + i1, (int)this.w.height() + this.c.r * 2 + i2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      float f1 = getBounds().left - this.c.r - i1;
      float f2 = getBounds().top - this.c.r - i2;
      localCanvas.translate(-f1, -f2);
      e(localCanvas);
      paramCanvas.drawBitmap(localBitmap, f1, f2, null);
      localBitmap.recycle();
      paramCanvas.restore();
      return;
    }
    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
  }
  
  private void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint, @NonNull Path paramPath, @NonNull ShapeAppearanceModel paramShapeAppearanceModel, @NonNull RectF paramRectF)
  {
    if (paramShapeAppearanceModel.a(paramRectF))
    {
      float f1 = paramShapeAppearanceModel.g().a(paramRectF) * this.c.k;
      paramCanvas.drawRoundRect(paramRectF, f1, f1, paramPaint);
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    int i1;
    int i2;
    if (this.c.d != null)
    {
      i1 = this.p.getColor();
      i2 = this.c.d.getColorForState(paramArrayOfInt, i1);
      if (i1 != i2)
      {
        this.p.setColor(i2);
        bool1 = true;
        break label53;
      }
    }
    boolean bool1 = false;
    label53:
    boolean bool2 = bool1;
    if (this.c.e != null)
    {
      i1 = this.q.getColor();
      i2 = this.c.e.getColorForState(paramArrayOfInt, i1);
      bool2 = bool1;
      if (i1 != i2)
      {
        this.q.setColor(i2);
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private void b()
  {
    super.invalidateSelf();
  }
  
  private void b(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas, this.p, this.i, this.c.a, Q());
  }
  
  private void b(@NonNull RectF paramRectF, @NonNull Path paramPath)
  {
    a(paramRectF, paramPath);
    if (this.c.j != 1.0F)
    {
      this.h.reset();
      this.h.setScale(this.c.j, this.c.j, paramRectF.width() / 2.0F, paramRectF.height() / 2.0F);
      paramPath.transform(this.h);
    }
    paramPath.computeBounds(this.w, true);
  }
  
  private void c(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas, this.q, this.j, this.o, i());
  }
  
  private boolean c()
  {
    int i1 = this.c.q;
    boolean bool = true;
    if ((i1 != 1) && (this.c.r > 0))
    {
      if (this.c.q == 2) {
        return bool;
      }
      if (Y()) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private void d(@NonNull Canvas paramCanvas)
  {
    int i1 = Z();
    int i2 = aa();
    if ((Build.VERSION.SDK_INT < 21) && (this.x))
    {
      Rect localRect = paramCanvas.getClipBounds();
      localRect.inset(-this.c.r, -this.c.r);
      localRect.offset(i1, i2);
      paramCanvas.clipRect(localRect, Region.Op.REPLACE);
    }
    paramCanvas.translate(i1, i2);
  }
  
  private boolean d()
  {
    return (this.c.v == Paint.Style.FILL_AND_STROKE) || (this.c.v == Paint.Style.FILL);
  }
  
  private void e(@NonNull Canvas paramCanvas)
  {
    if (this.f.cardinality() > 0) {
      Log.w(a, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    }
    if (this.c.s != 0) {
      paramCanvas.drawPath(this.i, this.r.a());
    }
    int i1 = 0;
    while (i1 < 4)
    {
      this.d[i1].a(this.r, this.c.r, paramCanvas);
      this.e[i1].a(this.r, this.c.r, paramCanvas);
      i1 += 1;
    }
    if (this.x)
    {
      i1 = Z();
      int i2 = aa();
      paramCanvas.translate(-i1, -i2);
      paramCanvas.drawPath(this.i, b);
      paramCanvas.translate(i1, i2);
    }
  }
  
  private boolean e()
  {
    return ((this.c.v == Paint.Style.FILL_AND_STROKE) || (this.c.v == Paint.Style.STROKE)) && (this.q.getStrokeWidth() > 0.0F);
  }
  
  private void f()
  {
    float f1 = -h();
    this.o = getShapeAppearanceModel().a(new MaterialShapeDrawable.2(this, f1));
    this.t.a(this.o, this.c.k, i(), this.j);
  }
  
  private boolean g()
  {
    PorterDuffColorFilter localPorterDuffColorFilter1 = this.u;
    PorterDuffColorFilter localPorterDuffColorFilter2 = this.v;
    ColorStateList localColorStateList = this.c.g;
    PorterDuff.Mode localMode = this.c.h;
    Paint localPaint = this.p;
    boolean bool = true;
    this.u = a(localColorStateList, localMode, localPaint, true);
    this.v = a(this.c.f, this.c.h, this.q, false);
    if (this.c.u) {
      this.r.a(this.c.g.getColorForState(getState(), 0));
    }
    if (ObjectsCompat.equals(localPorterDuffColorFilter1, this.u))
    {
      if (!ObjectsCompat.equals(localPorterDuffColorFilter2, this.v)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private float h()
  {
    if (e()) {
      return this.q.getStrokeWidth() / 2.0F;
    }
    return 0.0F;
  }
  
  @NonNull
  private RectF i()
  {
    this.l.set(Q());
    float f1 = h();
    this.l.inset(f1, f1);
    return this.l;
  }
  
  public void D(int paramInt)
  {
    if (this.c.q != paramInt)
    {
      this.c.q = paramInt;
      b();
    }
  }
  
  @ColorInt
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected int E(@ColorInt int paramInt)
  {
    float f1 = W();
    float f2 = T();
    int i1 = paramInt;
    if (this.c.b != null) {
      i1 = this.c.b.a(paramInt, f1 + f2);
    }
    return i1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void F(int paramInt)
  {
    if (this.c.s != paramInt)
    {
      this.c.s = paramInt;
      b();
    }
  }
  
  public void G(int paramInt)
  {
    if (this.c.t != paramInt)
    {
      this.c.t = paramInt;
      b();
    }
  }
  
  public void H(int paramInt)
  {
    this.r.a(paramInt);
    this.c.u = false;
    b();
  }
  
  @Nullable
  public ColorStateList M()
  {
    return this.c.d;
  }
  
  @Nullable
  public ColorStateList N()
  {
    return this.c.e;
  }
  
  @Nullable
  public ColorStateList O()
  {
    return this.c.g;
  }
  
  public float P()
  {
    return this.c.l;
  }
  
  @NonNull
  protected RectF Q()
  {
    this.k.set(getBounds());
    return this.k;
  }
  
  public boolean R()
  {
    return (this.c.b != null) && (this.c.b.a());
  }
  
  public float S()
  {
    return this.c.k;
  }
  
  public float T()
  {
    return this.c.n;
  }
  
  public float U()
  {
    return this.c.o;
  }
  
  public float V()
  {
    return this.c.p;
  }
  
  public float W()
  {
    return U() + V();
  }
  
  public int X()
  {
    return this.c.r;
  }
  
  public boolean Y()
  {
    return (Build.VERSION.SDK_INT < 21) || ((!af()) && (!this.i.isConvex()) && (Build.VERSION.SDK_INT < 29));
  }
  
  public int Z()
  {
    double d1 = this.c.s;
    double d2 = Math.sin(Math.toRadians(this.c.t));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  public void a(float paramFloat, @ColorInt int paramInt)
  {
    n(paramFloat);
    h(ColorStateList.valueOf(paramInt));
  }
  
  public void a(float paramFloat, @Nullable ColorStateList paramColorStateList)
  {
    n(paramFloat);
    h(paramColorStateList);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.c.i == null) {
      this.c.i = new Rect();
    }
    this.c.i.set(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateSelf();
  }
  
  public void a(Context paramContext)
  {
    this.c.b = new ElevationOverlayProvider(paramContext);
    a();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint, @NonNull Path paramPath, @NonNull RectF paramRectF)
  {
    a(paramCanvas, paramPaint, paramPath, this.c.a, paramRectF);
  }
  
  public void a(Paint.Style paramStyle)
  {
    this.c.v = paramStyle;
    b();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected final void a(@NonNull RectF paramRectF, @NonNull Path paramPath)
  {
    this.t.a(this.c.a, this.c.k, paramRectF, this.s, paramPath);
  }
  
  public void a(@NonNull CornerSize paramCornerSize)
  {
    setShapeAppearanceModel(this.c.a.a(paramCornerSize));
  }
  
  public int aa()
  {
    double d1 = this.c.s;
    double d2 = Math.cos(Math.toRadians(this.c.t));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  public float ab()
  {
    return this.c.a.f().a(Q());
  }
  
  public float ac()
  {
    return this.c.a.g().a(Q());
  }
  
  public float ad()
  {
    return this.c.a.i().a(Q());
  }
  
  public float ae()
  {
    return this.c.a.h().a(Q());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean af()
  {
    return this.c.a.a(Q());
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.p.setColorFilter(this.u);
    int i1 = this.p.getAlpha();
    this.p.setAlpha(a(i1, this.c.m));
    this.q.setColorFilter(this.v);
    this.q.setStrokeWidth(this.c.l);
    int i2 = this.q.getAlpha();
    this.q.setAlpha(a(i2, this.c.m));
    if (this.g)
    {
      f();
      b(Q(), this.i);
      this.g = false;
    }
    a(paramCanvas);
    if (d()) {
      b(paramCanvas);
    }
    if (e()) {
      c(paramCanvas);
    }
    this.p.setAlpha(i1);
    this.q.setAlpha(i2);
  }
  
  public void g(@Nullable ColorStateList paramColorStateList)
  {
    if (this.c.d != paramColorStateList)
    {
      this.c.d = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void g(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.c;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.c.q == 2) {
      return;
    }
    if (af())
    {
      float f1 = ab();
      float f2 = this.c.k;
      paramOutline.setRoundRect(getBounds(), f1 * f2);
      return;
    }
    b(Q(), this.i);
    if ((this.i.isConvex()) || (Build.VERSION.SDK_INT >= 29)) {}
    try
    {
      paramOutline.setConvexPath(this.i);
      return;
    }
    catch (IllegalArgumentException paramOutline) {}
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (this.c.i != null)
    {
      paramRect.set(this.c.i);
      return true;
    }
    return super.getPadding(paramRect);
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.c.a;
  }
  
  public Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    this.m.set(localRect);
    b(Q(), this.i);
    this.n.setPath(this.i, this.m);
    this.m.op(this.n, Region.Op.DIFFERENCE);
    return this.m;
  }
  
  public void h(@Nullable ColorStateList paramColorStateList)
  {
    if (this.c.e != paramColorStateList)
    {
      this.c.e = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void invalidateSelf()
  {
    this.g = true;
    super.invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return (super.isStateful()) || ((this.c.g != null) && (this.c.g.isStateful())) || ((this.c.f != null) && (this.c.f.isStateful())) || ((this.c.e != null) && (this.c.e.isStateful())) || ((this.c.d != null) && (this.c.d.isStateful()));
  }
  
  @NonNull
  public Drawable mutate()
  {
    this.c = new MaterialShapeDrawable.MaterialShapeDrawableState(this.c);
    return this;
  }
  
  public void n(float paramFloat)
  {
    this.c.l = paramFloat;
    invalidateSelf();
  }
  
  public void o(float paramFloat)
  {
    setShapeAppearanceModel(this.c.a.a(paramFloat));
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.g = true;
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = a(paramArrayOfInt);
    boolean bool2 = g();
    if ((!bool1) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public void p(float paramFloat)
  {
    if (this.c.k != paramFloat)
    {
      this.c.k = paramFloat;
      this.g = true;
      invalidateSelf();
    }
  }
  
  public void q(float paramFloat)
  {
    if (this.c.n != paramFloat)
    {
      this.c.n = paramFloat;
      a();
    }
  }
  
  public void r(float paramFloat)
  {
    if (this.c.o != paramFloat)
    {
      this.c.o = paramFloat;
      a();
    }
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    if (this.c.m != paramInt)
    {
      this.c.m = paramInt;
      b();
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.c.c = paramColorFilter;
    b();
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.c.a = paramShapeAppearanceModel;
    invalidateSelf();
  }
  
  public void setTint(@ColorInt int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.c.g = paramColorStateList;
    g();
    b();
  }
  
  public void setTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.c.h != paramMode)
    {
      this.c.h = paramMode;
      g();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.MaterialShapeDrawable
 * JD-Core Version:    0.7.0.1
 */