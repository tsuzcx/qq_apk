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
  private static final int jdField_a_of_type_Int = R.style.L;
  @AttrRes
  private static final int jdField_b_of_type_Int = R.attr.T;
  private float jdField_a_of_type_Float = 1.0F;
  @NonNull
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private final Paint.FontMetrics jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = new Paint.FontMetrics();
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  @NonNull
  private final View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new TooltipDrawable.1(this);
  @NonNull
  private final TextDrawableHelper jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper = new TextDrawableHelper(this);
  @Nullable
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private float jdField_b_of_type_Float = 1.0F;
  private final float jdField_c_of_type_Float = 0.5F;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float = 0.5F;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float = 1.0F;
  private int jdField_e_of_type_Int;
  private int f;
  private int g;
  private int h;
  
  private TooltipDrawable(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().density = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().setTextAlign(Paint.Align.CENTER);
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect.right - getBounds().right - this.h - this.f < 0) {}
    for (int i = this.jdField_a_of_type_AndroidGraphicsRect.right - getBounds().right - this.h - this.f;; i = this.jdField_a_of_type_AndroidGraphicsRect.left - getBounds().left - this.h + this.f)
    {
      return i;
      if (this.jdField_a_of_type_AndroidGraphicsRect.left - getBounds().left - this.h + this.f <= 0) {
        break;
      }
    }
    return 0.0F;
  }
  
  private float a(@NonNull Rect paramRect)
  {
    return paramRect.centerY() - c();
  }
  
  private EdgeTreatment a()
  {
    float f1 = -a();
    double d1 = getBounds().width();
    double d2 = this.g;
    double d3 = Math.sqrt(2.0D);
    Double.isNaN(d2);
    Double.isNaN(d1);
    float f2 = (float)(d1 - d2 * d3) / 2.0F;
    f1 = Math.min(Math.max(f1, -f2), f2);
    return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.g), f1);
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
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      return;
    }
    Rect localRect = getBounds();
    int i = (int)a(localRect);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a() != null)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().drawableState = getState();
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().setAlpha((int)(this.jdField_e_of_type_Float * 255.0F));
    }
    CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
    paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect.centerX(), i, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a());
  }
  
  private void a(@Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = ThemeEnforcement.a(this.jdField_a_of_type_AndroidContentContext, paramAttributeSet, R.styleable.aC, paramInt1, paramInt2, new int[0]);
    this.g = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(R.dimen.av);
    setShapeAppearanceModel(a().b().b(a()).a());
    a(paramAttributeSet.getText(R.styleable.gL));
    a(MaterialResources.a(this.jdField_a_of_type_AndroidContentContext, paramAttributeSet, R.styleable.gG));
    paramInt1 = MaterialColors.a(this.jdField_a_of_type_AndroidContentContext, R.attr.k, TooltipDrawable.class.getCanonicalName());
    paramInt1 = MaterialColors.a(ColorUtils.setAlphaComponent(MaterialColors.a(this.jdField_a_of_type_AndroidContentContext, 16842801, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(paramInt1, 153));
    g(ColorStateList.valueOf(paramAttributeSet.getColor(R.styleable.gM, paramInt1)));
    h(ColorStateList.valueOf(MaterialColors.a(this.jdField_a_of_type_AndroidContentContext, R.attr.n, TooltipDrawable.class.getCanonicalName())));
    this.jdField_c_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.gH, 0);
    this.jdField_d_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.gJ, 0);
    this.jdField_e_of_type_Int = paramAttributeSet.getDimensionPixelSize(R.styleable.gK, 0);
    this.f = paramAttributeSet.getDimensionPixelSize(R.styleable.gI, 0);
    paramAttributeSet.recycle();
  }
  
  private float b()
  {
    CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
    if (localCharSequence == null) {
      return 0.0F;
    }
    return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(localCharSequence.toString());
  }
  
  private float c()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().getFontMetrics(this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics);
    return (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.descent + this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.ascent) / 2.0F;
  }
  
  private void c(@NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.h = arrayOfInt[0];
    paramView.getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  public void a()
  {
    invalidateSelf();
  }
  
  public void a(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_d_of_type_Float = 1.2F;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_e_of_type_Float = AnimationUtils.a(0.0F, 1.0F, 0.19F, 1.0F, paramFloat);
    invalidateSelf();
  }
  
  public void a(@Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    c(paramView);
    paramView.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
  }
  
  public void a(@Nullable TextAppearance paramTextAppearance)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(paramTextAppearance, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangCharSequence, paramCharSequence))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(true);
      invalidateSelf();
    }
  }
  
  public void b(@Nullable View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    float f1 = a();
    double d1 = this.g;
    double d2 = Math.sqrt(2.0D);
    Double.isNaN(d1);
    double d3 = this.g;
    Double.isNaN(d3);
    float f2 = (float)-(d1 * d2 - d3);
    paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, getBounds().left + getBounds().width() * 0.5F, getBounds().top + getBounds().height() * this.jdField_d_of_type_Float);
    paramCanvas.translate(f1, f2);
    super.draw(paramCanvas);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getIntrinsicHeight()
  {
    return (int)Math.max(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().getTextSize(), this.jdField_e_of_type_Int);
  }
  
  public int getIntrinsicWidth()
  {
    return (int)Math.max(this.jdField_c_of_type_Int * 2 + b(), this.jdField_d_of_type_Int);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    setShapeAppearanceModel(a().b().b(a()).a());
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tooltip.TooltipDrawable
 * JD-Core Version:    0.7.0.1
 */