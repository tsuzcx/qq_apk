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
  private static final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private static final String jdField_a_of_type_JavaLangString = "MaterialShapeDrawable";
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  @Nullable
  private PorterDuffColorFilter jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private final Region jdField_a_of_type_AndroidGraphicsRegion = new Region();
  private final ShadowRenderer jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowRenderer = new ShadowRenderer();
  private MaterialShapeDrawable.MaterialShapeDrawableState jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState;
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  @NonNull
  private final ShapeAppearancePathProvider.PathListener jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider$PathListener;
  private final ShapeAppearancePathProvider jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider;
  private final BitSet jdField_a_of_type_JavaUtilBitSet = new BitSet(8);
  private boolean jdField_a_of_type_Boolean;
  private final ShapePath.ShadowCompatOperation[] jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath$ShadowCompatOperation = new ShapePath.ShadowCompatOperation[4];
  private final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  private final Path jdField_b_of_type_AndroidGraphicsPath = new Path();
  @Nullable
  private PorterDuffColorFilter jdField_b_of_type_AndroidGraphicsPorterDuffColorFilter;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private final Region jdField_b_of_type_AndroidGraphicsRegion = new Region();
  private boolean jdField_b_of_type_Boolean;
  private final ShapePath.ShadowCompatOperation[] jdField_b_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath$ShadowCompatOperation = new ShapePath.ShadowCompatOperation[4];
  private final Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
  @NonNull
  private final RectF jdField_c_of_type_AndroidGraphicsRectF;
  
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider = localShapeAppearancePathProvider;
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState = paramMaterialShapeDrawableState;
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    d();
    a(getState());
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider$PathListener = new MaterialShapeDrawable.1(this);
  }
  
  public MaterialShapeDrawable(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this(new MaterialShapeDrawable.MaterialShapeDrawableState(paramShapeAppearanceModel, null));
  }
  
  private float a()
  {
    if (c()) {
      return this.jdField_c_of_type_AndroidGraphicsPaint.getStrokeWidth() / 2.0F;
    }
    return 0.0F;
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
    int j = paramColorStateList.getColorForState(getState(), 0);
    int i = j;
    if (paramBoolean) {
      i = a(j);
    }
    return new PorterDuffColorFilter(i, paramMode);
  }
  
  @Nullable
  private PorterDuffColorFilter a(@NonNull Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = paramPaint.getColor();
      int j = a(i);
      if (j != i) {
        return new PorterDuffColorFilter(j, PorterDuff.Mode.SRC_IN);
      }
    }
    return null;
  }
  
  @NonNull
  public static MaterialShapeDrawable a(Context paramContext, float paramFloat)
  {
    int i = MaterialColors.a(paramContext, R.attr.n, MaterialShapeDrawable.class.getSimpleName());
    MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
    localMaterialShapeDrawable.a(paramContext);
    localMaterialShapeDrawable.g(ColorStateList.valueOf(i));
    localMaterialShapeDrawable.r(paramFloat);
    return localMaterialShapeDrawable;
  }
  
  private void a()
  {
    float f = m();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int = ((int)Math.ceil(0.75F * f));
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Int = ((int)Math.ceil(f * 0.25F));
    d();
    b();
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if (!a()) {
      return;
    }
    paramCanvas.save();
    d(paramCanvas);
    if (!this.jdField_b_of_type_Boolean)
    {
      e(paramCanvas);
      paramCanvas.restore();
      return;
    }
    int i = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.width() - getBounds().width());
    int j = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.height() - getBounds().height());
    if ((i >= 0) && (j >= 0))
    {
      Bitmap localBitmap = Bitmap.createBitmap((int)this.jdField_c_of_type_AndroidGraphicsRectF.width() + this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int * 2 + i, (int)this.jdField_c_of_type_AndroidGraphicsRectF.height() + this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int * 2 + j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      float f1 = getBounds().left - this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int - i;
      float f2 = getBounds().top - this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int - j;
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
      float f = paramShapeAppearanceModel.b().a(paramRectF) * this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Float;
      paramCanvas.drawRoundRect(paramRectF, f, f, paramPaint);
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private boolean a()
  {
    int i = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Int;
    boolean bool = true;
    if ((i != 1) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int > 0))
    {
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Int == 2) {
        return bool;
      }
      if (g()) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    int i;
    int j;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidContentResColorStateList != null)
    {
      i = this.jdField_b_of_type_AndroidGraphicsPaint.getColor();
      j = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramArrayOfInt, i);
      if (i != j)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(j);
        bool1 = true;
        break label53;
      }
    }
    boolean bool1 = false;
    label53:
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_AndroidContentResColorStateList != null)
    {
      i = this.jdField_c_of_type_AndroidGraphicsPaint.getColor();
      j = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_AndroidContentResColorStateList.getColorForState(paramArrayOfInt, i);
      bool2 = bool1;
      if (i != j)
      {
        this.jdField_c_of_type_AndroidGraphicsPaint.setColor(j);
        bool2 = true;
      }
    }
    return bool2;
  }
  
  @NonNull
  private RectF b()
  {
    this.jdField_b_of_type_AndroidGraphicsRectF.set(a());
    float f = a();
    this.jdField_b_of_type_AndroidGraphicsRectF.inset(f, f);
    return this.jdField_b_of_type_AndroidGraphicsRectF;
  }
  
  private void b()
  {
    super.invalidateSelf();
  }
  
  private void b(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, a());
  }
  
  private void b(@NonNull RectF paramRectF, @NonNull Path paramPath)
  {
    a(paramRectF, paramPath);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Float != 1.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Float, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Float, paramRectF.width() / 2.0F, paramRectF.height() / 2.0F);
      paramPath.transform(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
    paramPath.computeBounds(this.jdField_c_of_type_AndroidGraphicsRectF, true);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPaint$Style == Paint.Style.FILL_AND_STROKE) || (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPaint$Style == Paint.Style.FILL);
  }
  
  private void c()
  {
    float f = -a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = a().a(new MaterialShapeDrawable.2(this, f));
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Float, b(), this.jdField_b_of_type_AndroidGraphicsPath);
  }
  
  private void c(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_c_of_type_AndroidGraphicsPaint, this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, b());
  }
  
  private boolean c()
  {
    return ((this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPaint$Style == Paint.Style.FILL_AND_STROKE) || (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPaint$Style == Paint.Style.STROKE)) && (this.jdField_c_of_type_AndroidGraphicsPaint.getStrokeWidth() > 0.0F);
  }
  
  private void d(@NonNull Canvas paramCanvas)
  {
    int i = b();
    int j = c();
    if ((Build.VERSION.SDK_INT < 21) && (this.jdField_b_of_type_Boolean))
    {
      Rect localRect = paramCanvas.getClipBounds();
      localRect.inset(-this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int, -this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int);
      localRect.offset(i, j);
      paramCanvas.clipRect(localRect, Region.Op.REPLACE);
    }
    paramCanvas.translate(i, j);
  }
  
  private boolean d()
  {
    PorterDuffColorFilter localPorterDuffColorFilter1 = this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter;
    PorterDuffColorFilter localPorterDuffColorFilter2 = this.jdField_b_of_type_AndroidGraphicsPorterDuffColorFilter;
    ColorStateList localColorStateList = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_AndroidContentResColorStateList;
    PorterDuff.Mode localMode = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode;
    Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
    boolean bool = true;
    this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter = a(localColorStateList, localMode, localPaint, true);
    this.jdField_b_of_type_AndroidGraphicsPorterDuffColorFilter = a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode, this.jdField_c_of_type_AndroidGraphicsPaint, false);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowRenderer.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_AndroidContentResColorStateList.getColorForState(getState(), 0));
    }
    if (ObjectsCompat.equals(localPorterDuffColorFilter1, this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter))
    {
      if (!ObjectsCompat.equals(localPorterDuffColorFilter2, this.jdField_b_of_type_AndroidGraphicsPorterDuffColorFilter)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void e(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaUtilBitSet.cardinality() > 0) {
      Log.w(jdField_a_of_type_JavaLangString, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Int != 0) {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowRenderer.a());
    }
    int i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath$ShadowCompatOperation[i].a(this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowRenderer, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int, paramCanvas);
      this.jdField_b_of_type_ArrayOfComGoogleAndroidMaterialShapeShapePath$ShadowCompatOperation[i].a(this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowRenderer, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int, paramCanvas);
      i += 1;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      i = b();
      int j = c();
      paramCanvas.translate(-i, -j);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.translate(i, j);
    }
  }
  
  public void D(int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Int = paramInt;
      b();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void E(int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Int = paramInt;
      b();
    }
  }
  
  public void F(int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_e_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_e_of_type_Int = paramInt;
      b();
    }
  }
  
  public void G(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowRenderer.a(paramInt);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Boolean = false;
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Int;
  }
  
  @ColorInt
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected int a(@ColorInt int paramInt)
  {
    float f1 = m();
    float f2 = j();
    int i = paramInt;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider != null) {
      i = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider.a(paramInt, f1 + f2);
    }
    return i;
  }
  
  @NonNull
  protected RectF a()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(getBounds());
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
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
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateSelf();
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider = new ElevationOverlayProvider(paramContext);
    a();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint, @NonNull Path paramPath, @NonNull RectF paramRectF)
  {
    a(paramCanvas, paramPaint, paramPath, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, paramRectF);
  }
  
  public void a(Paint.Style paramStyle)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPaint$Style = paramStyle;
    b();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected final void a(@NonNull RectF paramRectF, @NonNull Path paramPath)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Float, paramRectF, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider$PathListener, paramPath);
  }
  
  public void a(@NonNull CornerSize paramCornerSize)
  {
    setShapeAppearanceModel(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(paramCornerSize));
  }
  
  public int b()
  {
    double d1 = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Int;
    double d2 = Math.sin(Math.toRadians(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_e_of_type_Int));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  @Nullable
  public ColorStateList b()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidContentResColorStateList;
  }
  
  public int c()
  {
    double d1 = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Int;
    double d2 = Math.cos(Math.toRadians(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_e_of_type_Int));
    Double.isNaN(d1);
    return (int)(d1 * d2);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColorFilter(this.jdField_a_of_type_AndroidGraphicsPorterDuffColorFilter);
    int i = this.jdField_b_of_type_AndroidGraphicsPaint.getAlpha();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(a(i, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Int));
    this.jdField_c_of_type_AndroidGraphicsPaint.setColorFilter(this.jdField_b_of_type_AndroidGraphicsPorterDuffColorFilter);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Float);
    int j = this.jdField_c_of_type_AndroidGraphicsPaint.getAlpha();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(a(j, this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Int));
    if (this.jdField_a_of_type_Boolean)
    {
      c();
      b(a(), this.jdField_a_of_type_AndroidGraphicsPath);
      this.jdField_a_of_type_Boolean = false;
    }
    a(paramCanvas);
    if (b()) {
      b(paramCanvas);
    }
    if (c()) {
      c(paramCanvas);
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(i);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(j);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialElevationElevationOverlayProvider.a());
  }
  
  public void g(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void g(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean g()
  {
    return (Build.VERSION.SDK_INT < 21) || ((!h()) && (!this.jdField_a_of_type_AndroidGraphicsPath.isConvex()) && (Build.VERSION.SDK_INT < 29));
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Int == 2) {
      return;
    }
    if (h())
    {
      float f1 = n();
      float f2 = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Float;
      paramOutline.setRoundRect(getBounds(), f1 * f2);
      return;
    }
    b(a(), this.jdField_a_of_type_AndroidGraphicsPath);
    if ((this.jdField_a_of_type_AndroidGraphicsPath.isConvex()) || (Build.VERSION.SDK_INT >= 29)) {}
    try
    {
      paramOutline.setConvexPath(this.jdField_a_of_type_AndroidGraphicsPath);
      return;
    }
    catch (IllegalArgumentException paramOutline) {}
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      paramRect.set(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsRect);
      return true;
    }
    return super.getPadding(paramRect);
  }
  
  public Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    this.jdField_a_of_type_AndroidGraphicsRegion.set(localRect);
    b(a(), this.jdField_a_of_type_AndroidGraphicsPath);
    this.jdField_b_of_type_AndroidGraphicsRegion.setPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsRegion);
    this.jdField_a_of_type_AndroidGraphicsRegion.op(this.jdField_b_of_type_AndroidGraphicsRegion, Region.Op.DIFFERENCE);
    return this.jdField_a_of_type_AndroidGraphicsRegion;
  }
  
  public void h(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean h()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(a());
  }
  
  public float i()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Float;
  }
  
  public void invalidateSelf()
  {
    this.jdField_a_of_type_Boolean = true;
    super.invalidateSelf();
  }
  
  public boolean isStateful()
  {
    return (super.isStateful()) || ((this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_AndroidContentResColorStateList.isStateful())) || ((this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_AndroidContentResColorStateList.isStateful())) || ((this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_AndroidContentResColorStateList.isStateful())) || ((this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidContentResColorStateList.isStateful()));
  }
  
  public float j()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Float;
  }
  
  public float k()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_e_of_type_Float;
  }
  
  public float l()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.f;
  }
  
  public float m()
  {
    return k() + l();
  }
  
  @NonNull
  public Drawable mutate()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState = new MaterialShapeDrawable.MaterialShapeDrawableState(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState);
    return this;
  }
  
  public float n()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a().a(a());
  }
  
  public void n(float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_c_of_type_Float = paramFloat;
    invalidateSelf();
  }
  
  public float o()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.b().a(a());
  }
  
  public void o(float paramFloat)
  {
    setShapeAppearanceModel(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.a(paramFloat));
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_Boolean = true;
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool1 = a(paramArrayOfInt);
    boolean bool2 = d();
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
  
  public float p()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.d().a(a());
  }
  
  public void p(float paramFloat)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_b_of_type_Float = paramFloat;
      this.jdField_a_of_type_Boolean = true;
      invalidateSelf();
    }
  }
  
  public float q()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel.c().a(a());
  }
  
  public void q(float paramFloat)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_Float = paramFloat;
      a();
    }
  }
  
  public void r(float paramFloat)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_e_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_e_of_type_Float = paramFloat;
      a();
    }
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_Int = paramInt;
      b();
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    b();
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
    invalidateSelf();
  }
  
  public void setTint(@ColorInt int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_d_of_type_AndroidContentResColorStateList = paramColorStateList;
    d();
    b();
  }
  
  public void setTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode != paramMode)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable$MaterialShapeDrawableState.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = paramMode;
      d();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.MaterialShapeDrawable
 * JD-Core Version:    0.7.0.1
 */