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
  private static final int a = R.style.I;
  private final ShapeAppearancePathProvider b = ShapeAppearancePathProvider.a();
  private final RectF c;
  private final RectF d;
  private final Paint e;
  private final Paint f;
  private final Path g = new Path();
  @Nullable
  private ColorStateList h;
  @Nullable
  private MaterialShapeDrawable i;
  private ShapeAppearanceModel j;
  @Dimension
  private float k;
  private Path l;
  @Dimension
  private int m;
  @Dimension
  private int n;
  @Dimension
  private int o;
  @Dimension
  private int p;
  @Dimension
  private int q;
  @Dimension
  private int r;
  private boolean s = false;
  
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
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setColor(-1);
    this.f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.c = new RectF();
    this.d = new RectF();
    this.l = new Path();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.gi, paramInt, a);
    this.h = MaterialResources.a(paramContext, localTypedArray, R.styleable.gq);
    this.k = localTypedArray.getDimensionPixelSize(R.styleable.gr, 0);
    int i1 = localTypedArray.getDimensionPixelSize(R.styleable.gj, 0);
    this.m = i1;
    this.n = i1;
    this.o = i1;
    this.p = i1;
    this.m = localTypedArray.getDimensionPixelSize(R.styleable.gm, i1);
    this.n = localTypedArray.getDimensionPixelSize(R.styleable.gp, i1);
    this.o = localTypedArray.getDimensionPixelSize(R.styleable.gn, i1);
    this.p = localTypedArray.getDimensionPixelSize(R.styleable.gk, i1);
    this.q = localTypedArray.getDimensionPixelSize(R.styleable.go, -2147483648);
    this.r = localTypedArray.getDimensionPixelSize(R.styleable.gl, -2147483648);
    localTypedArray.recycle();
    this.e = new Paint();
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setAntiAlias(true);
    this.j = ShapeAppearanceModel.a(paramContext, paramAttributeSet, paramInt, a).a();
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new ShapeableImageView.OutlineProvider(this));
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.c.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
    this.b.a(this.j, 1.0F, this.c, this.g);
    this.l.rewind();
    this.l.addPath(this.g);
    this.d.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.l.addRect(this.d, Path.Direction.CCW);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.h == null) {
      return;
    }
    this.e.setStrokeWidth(this.k);
    int i1 = this.h.getColorForState(getDrawableState(), this.h.getDefaultColor());
    if ((this.k > 0.0F) && (i1 != 0))
    {
      this.e.setColor(i1);
      paramCanvas.drawPath(this.g, this.e);
    }
  }
  
  private boolean a()
  {
    return (this.q != -2147483648) || (this.r != -2147483648);
  }
  
  private boolean b()
  {
    return (Build.VERSION.SDK_INT >= 17) && (getLayoutDirection() == 1);
  }
  
  @Dimension
  public int getContentPaddingBottom()
  {
    return this.p;
  }
  
  @Dimension
  public final int getContentPaddingEnd()
  {
    int i1 = this.r;
    if (i1 != -2147483648) {
      return i1;
    }
    if (b()) {
      return this.m;
    }
    return this.o;
  }
  
  @Dimension
  public int getContentPaddingLeft()
  {
    if (a())
    {
      int i1;
      if (b())
      {
        i1 = this.r;
        if (i1 != -2147483648) {
          return i1;
        }
      }
      if (!b())
      {
        i1 = this.q;
        if (i1 != -2147483648) {
          return i1;
        }
      }
    }
    return this.m;
  }
  
  @Dimension
  public int getContentPaddingRight()
  {
    if (a())
    {
      int i1;
      if (b())
      {
        i1 = this.q;
        if (i1 != -2147483648) {
          return i1;
        }
      }
      if (!b())
      {
        i1 = this.r;
        if (i1 != -2147483648) {
          return i1;
        }
      }
    }
    return this.o;
  }
  
  @Dimension
  public final int getContentPaddingStart()
  {
    int i1 = this.q;
    if (i1 != -2147483648) {
      return i1;
    }
    if (b()) {
      return this.o;
    }
    return this.m;
  }
  
  @Dimension
  public int getContentPaddingTop()
  {
    return this.n;
  }
  
  @Dimension
  public int getPaddingBottom()
  {
    return super.getPaddingBottom() - getContentPaddingBottom();
  }
  
  @Dimension
  public int getPaddingEnd()
  {
    return super.getPaddingEnd() - getContentPaddingEnd();
  }
  
  @Dimension
  public int getPaddingLeft()
  {
    return super.getPaddingLeft() - getContentPaddingLeft();
  }
  
  @Dimension
  public int getPaddingRight()
  {
    return super.getPaddingRight() - getContentPaddingRight();
  }
  
  @Dimension
  public int getPaddingStart()
  {
    return super.getPaddingStart() - getContentPaddingStart();
  }
  
  @Dimension
  public int getPaddingTop()
  {
    return super.getPaddingTop() - getContentPaddingTop();
  }
  
  @NonNull
  public ShapeAppearanceModel getShapeAppearanceModel()
  {
    return this.j;
  }
  
  @Nullable
  public ColorStateList getStrokeColor()
  {
    return this.h;
  }
  
  @Dimension
  public float getStrokeWidth()
  {
    return this.k;
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
    paramCanvas.drawPath(this.l, this.f);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.s) {
      return;
    }
    if ((Build.VERSION.SDK_INT > 19) && (!isLayoutDirectionResolved())) {
      return;
    }
    this.s = true;
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
    this.q = -2147483648;
    this.r = -2147483648;
    super.setPadding(super.getPaddingLeft() - this.m + paramInt1, super.getPaddingTop() - this.n + paramInt2, super.getPaddingRight() - this.o + paramInt3, super.getPaddingBottom() - this.p + paramInt4);
    this.m = paramInt1;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
  }
  
  @RequiresApi(17)
  public void setContentPaddingRelative(@Dimension int paramInt1, @Dimension int paramInt2, @Dimension int paramInt3, @Dimension int paramInt4)
  {
    super.setPaddingRelative(super.getPaddingStart() - getContentPaddingStart() + paramInt1, super.getPaddingTop() - this.n + paramInt2, super.getPaddingEnd() - getContentPaddingEnd() + paramInt3, super.getPaddingBottom() - this.p + paramInt4);
    int i1;
    if (b()) {
      i1 = paramInt3;
    } else {
      i1 = paramInt1;
    }
    this.m = i1;
    this.n = paramInt2;
    if (!b()) {
      paramInt1 = paramInt3;
    }
    this.o = paramInt1;
    this.p = paramInt4;
  }
  
  public void setPadding(@Dimension int paramInt1, @Dimension int paramInt2, @Dimension int paramInt3, @Dimension int paramInt4)
  {
    super.setPadding(paramInt1 + getContentPaddingLeft(), paramInt2 + getContentPaddingTop(), paramInt3 + getContentPaddingRight(), paramInt4 + getContentPaddingBottom());
  }
  
  public void setPaddingRelative(@Dimension int paramInt1, @Dimension int paramInt2, @Dimension int paramInt3, @Dimension int paramInt4)
  {
    super.setPaddingRelative(paramInt1 + getContentPaddingStart(), paramInt2 + getContentPaddingTop(), paramInt3 + getContentPaddingEnd(), paramInt4 + getContentPaddingBottom());
  }
  
  public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.j = paramShapeAppearanceModel;
    MaterialShapeDrawable localMaterialShapeDrawable = this.i;
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
    this.h = paramColorStateList;
    invalidate();
  }
  
  public void setStrokeColorResource(@ColorRes int paramInt)
  {
    setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setStrokeWidth(@Dimension float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      invalidate();
    }
  }
  
  public void setStrokeWidthResource(@DimenRes int paramInt)
  {
    setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.imageview.ShapeableImageView
 * JD-Core Version:    0.7.0.1
 */