package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel.Builder;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TooltipDrawable
  extends MaterialShapeDrawable
  implements TextDrawableHelper.TextDrawableDelegate
{
  @StyleRes
  private static final int a = R.style.N;
  @AttrRes
  private static final int b = R.attr.ae;
  @Nullable
  private CharSequence c;
  @NonNull
  private final Context d;
  @Nullable
  private final Paint.FontMetrics e = new Paint.FontMetrics();
  @NonNull
  private final TextDrawableHelper f = new TextDrawableHelper(this);
  @NonNull
  private final View.OnLayoutChangeListener g = new TooltipDrawable.1(this);
  @NonNull
  private final Rect h = new Rect();
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private float o = 1.0F;
  private float p = 1.0F;
  private final float q = 0.5F;
  private float r = 0.5F;
  private float s = 1.0F;
  
  private TooltipDrawable(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.d = paramContext;
    this.f.a().density = paramContext.getResources().getDisplayMetrics().density;
    this.f.a().setTextAlign(Paint.Align.CENTER);
  }
  
  private float a()
  {
    if (this.h.right - getBounds().right - this.n - this.l < 0) {}
    for (int i1 = this.h.right - getBounds().right - this.n - this.l;; i1 = this.h.left - getBounds().left - this.n + this.l)
    {
      return i1;
      if (this.h.left - getBounds().left - this.n + this.l <= 0) {
        break;
      }
    }
    return 0.0F;
  }
  
  private float a(@NonNull Rect paramRect)
  {
    return paramRect.centerY() - d();
  }
  
  @NonNull
  public static TooltipDrawable a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramContext = new TooltipDrawable(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext.a(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    if (this.c == null) {
      return;
    }
    Rect localRect = getBounds();
    int i1 = (int)a(localRect);
    if (this.f.b() != null)
    {
      this.f.a().drawableState = getState();
      this.f.a(this.d);
      this.f.a().setAlpha((int)(this.s * 255.0F));
    }
    CharSequence localCharSequence = this.c;
    paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect.centerX(), i1, this.f.a());
  }
  
  private void a(@Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = ThemeEnforcement.a(this.d, paramAttributeSet, R.styleable.jq, paramInt1, paramInt2, new int[0]);
    this.m = this.d.getResources().getDimensionPixelSize(R.dimen.av);
    setShapeAppearanceModel(getShapeAppearanceModel().n().b(b()).a());
    a(paramAttributeSet.getText(R.styleable.jw));
    a(MaterialResources.c(this.d, paramAttributeSet, R.styleable.jr));
    paramInt1 = MaterialColors.a(this.d, R.attr.p, TooltipDrawable.class.getCanonicalName());
    paramInt1 = MaterialColors.a(ColorUtils.setAlphaComponent(MaterialColors.a(this.d, 16842801, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(paramInt1, 153));
    g(ColorStateList.valueOf(paramAttributeSet.getColor(R.styleable.jx, paramInt1)));
    h(ColorStateList.valueOf(MaterialColors.a(this.d, R.attr.t, TooltipDrawable.class.getCanonicalName())));
    this.i = paramAttributeSet.getDimensionPixelSize(R.styleable.js, 0);
    this.j = paramAttributeSet.getDimensionPixelSize(R.styleable.ju, 0);
    this.k = paramAttributeSet.getDimensionPixelSize(R.styleable.jv, 0);
    this.l = paramAttributeSet.getDimensionPixelSize(R.styleable.jt, 0);
    paramAttributeSet.recycle();
  }
  
  private EdgeTreatment b()
  {
    float f1 = -a();
    double d1 = getBounds().width();
    double d2 = this.m;
    double d3 = Math.sqrt(2.0D);
    Double.isNaN(d2);
    Double.isNaN(d1);
    float f2 = (float)(d1 - d2 * d3) / 2.0F;
    f1 = Math.min(Math.max(f1, -f2), f2);
    return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.m), f1);
  }
  
  private float c()
  {
    CharSequence localCharSequence = this.c;
    if (localCharSequence == null) {
      return 0.0F;
    }
    return this.f.a(localCharSequence.toString());
  }
  
  private void c(@NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.n = arrayOfInt[0];
    paramView.getWindowVisibleDisplayFrame(this.h);
  }
  
  private float d()
  {
    this.f.a().getFontMetrics(this.e);
    return (this.e.descent + this.e.ascent) / 2.0F;
  }
  
  public void a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.r = 1.2F;
    this.o = paramFloat;
    this.p = paramFloat;
    this.s = AnimationUtils.a(0.0F, 1.0F, 0.19F, 1.0F, paramFloat);
    invalidateSelf();
  }
  
  public void a(@Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    c(paramView);
    paramView.addOnLayoutChangeListener(this.g);
  }
  
  public void a(@Nullable TextAppearance paramTextAppearance)
  {
    this.f.a(paramTextAppearance, this.d);
  }
  
  public void a(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(this.c, paramCharSequence))
    {
      this.c = paramCharSequence;
      this.f.a(true);
      invalidateSelf();
    }
  }
  
  public void b(@Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.removeOnLayoutChangeListener(this.g);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    float f1 = a();
    double d1 = this.m;
    double d2 = Math.sqrt(2.0D);
    Double.isNaN(d1);
    double d3 = this.m;
    Double.isNaN(d3);
    float f2 = (float)-(d1 * d2 - d3);
    paramCanvas.scale(this.o, this.p, getBounds().left + getBounds().width() * 0.5F, getBounds().top + getBounds().height() * this.r);
    paramCanvas.translate(f1, f2);
    super.draw(paramCanvas);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void f()
  {
    invalidateSelf();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)Math.max(this.f.a().getTextSize(), this.k);
  }
  
  public int getIntrinsicWidth()
  {
    return (int)Math.max(this.i * 2 + c(), this.j);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    setShapeAppearanceModel(getShapeAppearanceModel().n().b(b()).a());
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tooltip.TooltipDrawable
 * JD-Core Version:    0.7.0.1
 */