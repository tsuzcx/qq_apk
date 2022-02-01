package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class ShapeableImageView
  extends AppCompatImageView
  implements Shapeable
{
  private static final int jdField_a_of_type_Int = R.style.G;
  @Dimension
  private float jdField_a_of_type_Float;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF;
  @Nullable
  private MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  private ShapeAppearanceModel jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  private final ShapeAppearancePathProvider jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider = ShapeAppearancePathProvider.a();
  private boolean jdField_a_of_type_Boolean = false;
  @Dimension
  private int jdField_b_of_type_Int;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF;
  @Dimension
  private int c;
  @Dimension
  private int d;
  @Dimension
  private int e;
  @Dimension
  private int f;
  @Dimension
  private int g;
  
  public ShapeableImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ShapeableImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShapeableImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aq, paramInt, jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, localTypedArray, R.styleable.ek);
    this.jdField_a_of_type_Float = localTypedArray.getDimensionPixelSize(R.styleable.el, 0);
    int i = localTypedArray.getDimensionPixelSize(R.styleable.ed, 0);
    this.jdField_b_of_type_Int = i;
    this.c = i;
    this.d = i;
    this.e = i;
    this.jdField_b_of_type_Int = localTypedArray.getDimensionPixelSize(R.styleable.eg, i);
    this.c = localTypedArray.getDimensionPixelSize(R.styleable.ej, i);
    this.d = localTypedArray.getDimensionPixelSize(R.styleable.eh, i);
    this.e = localTypedArray.getDimensionPixelSize(R.styleable.ee, i);
    this.f = localTypedArray.getDimensionPixelSize(R.styleable.ei, -2147483648);
    this.g = localTypedArray.getDimensionPixelSize(R.styleable.ef, -2147483648);
    localTypedArray.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int).a();
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new ShapeableImageView.OutlineProvider(this));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearancePathProvider.a(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel, 1.0F, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPath);
    this.jdField_b_of_type_AndroidGraphicsPath.rewind();
    this.jdField_b_of_type_AndroidGraphicsPath.addPath(this.jdField_a_of_type_AndroidGraphicsPath);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_b_of_type_AndroidGraphicsPath.addRect(this.jdField_b_of_type_AndroidGraphicsRectF, Path.Direction.CCW);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getDrawableState(), this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor());
    if ((this.jdField_a_of_type_Float > 0.0F) && (i != 0))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private boolean a()
  {
    return (this.f != -2147483648) || (this.g != -2147483648);
  }
  
  private boolean b()
  {
    return (Build.VERSION.SDK_INT >= 17) && (getLayoutDirection() == 1);
  }
  
  @Dimension
  public int a()
  {
    return this.e;
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel;
  }
  
  @Dimension
  public final int b()
  {
    int i = this.g;
    if (i != -2147483648) {
      return i;
    }
    if (b()) {
      return this.jdField_b_of_type_Int;
    }
    return this.d;
  }
  
  @Dimension
  public int c()
  {
    if (a())
    {
      int i;
      if (b())
      {
        i = this.g;
        if (i != -2147483648) {
          return i;
        }
      }
      if (!b())
      {
        i = this.f;
        if (i != -2147483648) {
          return i;
        }
      }
    }
    return this.jdField_b_of_type_Int;
  }
  
  @Dimension
  public int d()
  {
    if (a())
    {
      int i;
      if (b())
      {
        i = this.f;
        if (i != -2147483648) {
          return i;
        }
      }
      if (!b())
      {
        i = this.g;
        if (i != -2147483648) {
          return i;
        }
      }
    }
    return this.d;
  }
  
  @Dimension
  public final int e()
  {
    int i = this.f;
    if (i != -2147483648) {
      return i;
    }
    if (b()) {
      return this.d;
    }
    return this.jdField_b_of_type_Int;
  }
  
  @Dimension
  public int f()
  {
    return this.c;
  }
  
  @Dimension
  public int getPaddingBottom()
  {
    return super.getPaddingBottom() - a();
  }
  
  @Dimension
  public int getPaddingLeft()
  {
    return super.getPaddingLeft() - c();
  }
  
  @Dimension
  public int getPaddingRight()
  {
    return super.getPaddingRight() - d();
  }
  
  @Dimension
  public int getPaddingTop()
  {
    return super.getPaddingTop() - f();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setLayerType(2, null);
  }
  
  protected void onDetachedFromWindow()
  {
    setLayerType(0, null);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((Build.VERSION.SDK_INT > 19) && (!isLayoutDirectionResolved())) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if ((Build.VERSION.SDK_INT >= 21) && ((isPaddingRelative()) || (a())))
    {
      setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
      return;
    }
    setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public void setContentPadding(@Dimension int paramInt1, @Dimension int paramInt2, @Dimension int paramInt3, @Dimension int paramInt4)
  {
    this.f = -2147483648;
    this.g = -2147483648;
    super.setPadding(super.getPaddingLeft() - this.jdField_b_of_type_Int + paramInt1, super.getPaddingTop() - this.c + paramInt2, super.getPaddingRight() - this.d + paramInt3, super.getPaddingBottom() - this.e + paramInt4);
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
  }
  
  @RequiresApi(17)
  public void setContentPaddingRelative(@Dimension int paramInt1, @Dimension int paramInt2, @Dimension int paramInt3, @Dimension int paramInt4)
  {
    super.setPaddingRelative(super.getPaddingStart() - e() + paramInt1, super.getPaddingTop() - this.c + paramInt2, super.getPaddingEnd() - b() + paramInt3, super.getPaddingBottom() - this.e + paramInt4);
    int i;
    if (b()) {
      i = paramInt3;
    } else {
      i = paramInt1;
    }
    this.jdField_b_of_type_Int = i;
    this.c = paramInt2;
    if (!b()) {
      paramInt1 = paramInt3;
    }
    this.d = paramInt1;
    this.e = paramInt4;
  }
  
  public void setPadding(@Dimension int paramInt1, @Dimension int paramInt2, @Dimension int paramInt3, @Dimension int paramInt4)
  {
    super.setPadding(paramInt1 + c(), paramInt2 + f(), paramInt3 + d(), paramInt4 + a());
  }
  
  public void setPaddingRelative(@Dimension int paramInt1, @Dimension int paramInt2, @Dimension int paramInt3, @Dimension int paramInt4)
  {
    super.setPaddingRelative(paramInt1 + e(), paramInt2 + f(), paramInt3 + b(), paramInt4 + a());
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel = paramShapeAppearanceModel;
    MaterialShapeDrawable localMaterialShapeDrawable = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    if (localMaterialShapeDrawable != null) {
      localMaterialShapeDrawable.setShapeAppearanceModel(paramShapeAppearanceModel);
    }
    a(getWidth(), getHeight());
    invalidate();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  public void setStrokeColor(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    invalidate();
  }
  
  public void setStrokeColorResource(@ColorRes int paramInt)
  {
    setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setStrokeWidth(@Dimension float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      invalidate();
    }
  }
  
  public void setStrokeWidthResource(@DimenRes int paramInt)
  {
    setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.imageview.ShapeableImageView
 * JD-Core Version:    0.7.0.1
 */