package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

public class BadgeDrawable
  extends Drawable
  implements TextDrawableHelper.TextDrawableDelegate
{
  @StyleRes
  private static final int jdField_a_of_type_Int = R.style.r;
  @AttrRes
  private static final int jdField_b_of_type_Int = R.attr.jdField_b_of_type_Int;
  private final float jdField_a_of_type_Float;
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  @NonNull
  private final BadgeDrawable.SavedState jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState;
  @NonNull
  private final TextDrawableHelper jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper;
  @NonNull
  private final MaterialShapeDrawable jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
  @NonNull
  private final WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private final float jdField_b_of_type_Float;
  @Nullable
  private WeakReference<View> jdField_b_of_type_JavaLangRefWeakReference;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  @Nullable
  private WeakReference<FrameLayout> jdField_c_of_type_JavaLangRefWeakReference;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  
  private BadgeDrawable(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    ThemeEnforcement.b(paramContext);
    Resources localResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = new MaterialShapeDrawable();
    this.jdField_a_of_type_Float = localResources.getDimensionPixelSize(R.dimen.I);
    this.jdField_c_of_type_Float = localResources.getDimensionPixelSize(R.dimen.H);
    this.jdField_b_of_type_Float = localResources.getDimensionPixelSize(R.dimen.M);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper = new TextDrawableHelper(this);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState = new BadgeDrawable.SavedState(paramContext);
    h(R.style.f);
  }
  
  @NonNull
  static BadgeDrawable a(@NonNull Context paramContext, @NonNull BadgeDrawable.SavedState paramSavedState)
  {
    paramContext = new BadgeDrawable(paramContext);
    paramContext.a(paramSavedState);
    return paramContext;
  }
  
  @NonNull
  private String a()
  {
    if (a() <= this.jdField_c_of_type_Int) {
      return NumberFormat.getInstance().format(a());
    }
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null) {
      return "";
    }
    return localContext.getString(R.string.v, new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), "+" });
  }
  
  private void a(@NonNull Context paramContext, @NonNull Rect paramRect, @NonNull View paramView)
  {
    int i = BadgeDrawable.SavedState.e(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
    if ((i != 8388691) && (i != 8388693)) {
      this.e = (paramRect.top + BadgeDrawable.SavedState.g(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState));
    } else {
      this.e = (paramRect.bottom - BadgeDrawable.SavedState.g(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState));
    }
    float f1;
    if (a() <= 9)
    {
      if (!a()) {
        f1 = this.jdField_a_of_type_Float;
      } else {
        f1 = this.jdField_b_of_type_Float;
      }
      this.f = f1;
      f1 = this.f;
      this.h = f1;
      this.g = f1;
    }
    else
    {
      this.f = this.jdField_b_of_type_Float;
      this.h = this.f;
      String str = a();
      this.g = (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(str) / 2.0F + this.jdField_c_of_type_Float);
    }
    paramContext = paramContext.getResources();
    if (a()) {
      i = R.dimen.J;
    } else {
      i = R.dimen.G;
    }
    i = paramContext.getDimensionPixelSize(i);
    int j = BadgeDrawable.SavedState.e(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
    if ((j != 8388659) && (j != 8388691))
    {
      if (ViewCompat.getLayoutDirection(paramView) == 0) {
        f1 = paramRect.right + this.g - i - BadgeDrawable.SavedState.f(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
      } else {
        f1 = paramRect.left - this.g + i + BadgeDrawable.SavedState.f(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
      }
      this.d = f1;
      return;
    }
    if (ViewCompat.getLayoutDirection(paramView) == 0) {
      f1 = paramRect.left - this.g + i + BadgeDrawable.SavedState.f(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
    } else {
      f1 = paramRect.right + this.g - i - BadgeDrawable.SavedState.f(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
    }
    this.d = f1;
  }
  
  private void a(Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    String str = a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().getTextBounds(str, 0, str.length(), localRect);
    paramCanvas.drawText(str, this.d, this.e + localRect.height() / 2, this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a());
  }
  
  private void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup == null) || (localViewGroup.getId() != R.id.H))
    {
      localObject = this.jdField_c_of_type_JavaLangRefWeakReference;
      if ((localObject == null) || (((WeakReference)localObject).get() != localViewGroup)) {}
    }
    else
    {
      return;
    }
    b(paramView);
    Object localObject = new FrameLayout(paramView.getContext());
    ((FrameLayout)localObject).setId(R.id.H);
    ((FrameLayout)localObject).setClipChildren(false);
    ((FrameLayout)localObject).setClipToPadding(false);
    ((FrameLayout)localObject).setLayoutParams(paramView.getLayoutParams());
    ((FrameLayout)localObject).setMinimumWidth(paramView.getWidth());
    ((FrameLayout)localObject).setMinimumHeight(paramView.getHeight());
    int i = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeViewAt(i);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject).addView(paramView);
    localViewGroup.addView((View)localObject, i);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
    ((FrameLayout)localObject).post(new BadgeDrawable.1(this, paramView, (FrameLayout)localObject));
  }
  
  private void a(@NonNull BadgeDrawable.SavedState paramSavedState)
  {
    d(BadgeDrawable.SavedState.a(paramSavedState));
    if (BadgeDrawable.SavedState.b(paramSavedState) != -1) {
      c(BadgeDrawable.SavedState.b(paramSavedState));
    }
    a(BadgeDrawable.SavedState.c(paramSavedState));
    b(BadgeDrawable.SavedState.d(paramSavedState));
    e(BadgeDrawable.SavedState.e(paramSavedState));
    f(BadgeDrawable.SavedState.f(paramSavedState));
    g(BadgeDrawable.SavedState.g(paramSavedState));
    a(BadgeDrawable.SavedState.a(paramSavedState));
  }
  
  private void a(@Nullable TextAppearance paramTextAppearance)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a() == paramTextAppearance) {
      return;
    }
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null) {
      return;
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(paramTextAppearance, localContext);
    b();
  }
  
  private void b()
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
    FrameLayout localFrameLayout = null;
    if (localObject1 != null) {
      localObject1 = (View)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localContext != null)
    {
      if (localObject1 == null) {
        return;
      }
      Rect localRect1 = new Rect();
      localRect1.set(this.jdField_a_of_type_AndroidGraphicsRect);
      Rect localRect2 = new Rect();
      ((View)localObject1).getDrawingRect(localRect2);
      Object localObject2 = this.jdField_c_of_type_JavaLangRefWeakReference;
      if (localObject2 != null) {
        localFrameLayout = (FrameLayout)((WeakReference)localObject2).get();
      }
      if ((localFrameLayout != null) || (BadgeUtils.a))
      {
        localObject2 = localFrameLayout;
        if (localFrameLayout == null) {
          localObject2 = (ViewGroup)((View)localObject1).getParent();
        }
        ((ViewGroup)localObject2).offsetDescendantRectToMyCoords((View)localObject1, localRect2);
      }
      a(localContext, localRect2, (View)localObject1);
      BadgeUtils.a(this.jdField_a_of_type_AndroidGraphicsRect, this.d, this.e, this.g, this.h);
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.o(this.f);
      if (!localRect1.equals(this.jdField_a_of_type_AndroidGraphicsRect)) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      }
    }
  }
  
  private static void b(View paramView)
  {
    paramView = (ViewGroup)paramView.getParent();
    paramView.setClipChildren(false);
    paramView.setClipToPadding(false);
  }
  
  private void c()
  {
    double d1 = b();
    Double.isNaN(d1);
    this.jdField_c_of_type_Int = ((int)Math.pow(10.0D, d1 - 1.0D) - 1);
  }
  
  private void h(@StyleRes int paramInt)
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null) {
      return;
    }
    a(new TextAppearance(localContext, paramInt));
  }
  
  public int a()
  {
    if (!a()) {
      return 0;
    }
    return BadgeDrawable.SavedState.b(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
  }
  
  @Nullable
  public FrameLayout a()
  {
    WeakReference localWeakReference = this.jdField_c_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (FrameLayout)localWeakReference.get();
    }
    return null;
  }
  
  @NonNull
  public BadgeDrawable.SavedState a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState;
  }
  
  @Nullable
  public CharSequence a()
  {
    if (!isVisible()) {
      return null;
    }
    if (a())
    {
      if (BadgeDrawable.SavedState.i(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState) > 0)
      {
        Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localContext == null) {
          return null;
        }
        if (a() <= this.jdField_c_of_type_Int) {
          return localContext.getResources().getQuantityString(BadgeDrawable.SavedState.i(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState), a(), new Object[] { Integer.valueOf(a()) });
        }
        return localContext.getString(BadgeDrawable.SavedState.j(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState), new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      }
      return null;
    }
    return BadgeDrawable.SavedState.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void a()
  {
    invalidateSelf();
  }
  
  public void a(@ColorInt int paramInt)
  {
    BadgeDrawable.SavedState.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.b() != localColorStateList)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.g(localColorStateList);
      invalidateSelf();
    }
  }
  
  public void a(@NonNull View paramView, @Nullable FrameLayout paramFrameLayout)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    if ((BadgeUtils.a) && (paramFrameLayout == null)) {
      a(paramView);
    } else {
      this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramFrameLayout);
    }
    if (!BadgeUtils.a) {
      b(paramView);
    }
    b();
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean)
  {
    setVisible(paramBoolean, false);
    BadgeDrawable.SavedState.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramBoolean);
    if ((BadgeUtils.a) && (a() != null) && (!paramBoolean)) {
      ((ViewGroup)a().getParent()).invalidate();
    }
  }
  
  public boolean a()
  {
    return BadgeDrawable.SavedState.b(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState) != -1;
  }
  
  public int b()
  {
    return BadgeDrawable.SavedState.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
  }
  
  public void b(@ColorInt int paramInt)
  {
    BadgeDrawable.SavedState.b(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().getColor() != paramInt)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public int c()
  {
    return BadgeDrawable.SavedState.f(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
  }
  
  public void c(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    if (BadgeDrawable.SavedState.b(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState) != paramInt)
    {
      BadgeDrawable.SavedState.c(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(true);
      b();
      invalidateSelf();
    }
  }
  
  public int d()
  {
    return BadgeDrawable.SavedState.g(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
  }
  
  public void d(int paramInt)
  {
    if (BadgeDrawable.SavedState.a(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState) != paramInt)
    {
      BadgeDrawable.SavedState.d(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
      c();
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a(true);
      b();
      invalidateSelf();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if ((!getBounds().isEmpty()) && (getAlpha() != 0))
    {
      if (!isVisible()) {
        return;
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.draw(paramCanvas);
      if (a()) {
        a(paramCanvas);
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (BadgeDrawable.SavedState.e(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState) != paramInt)
    {
      BadgeDrawable.SavedState.e(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
      Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        View localView = (View)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        localObject = this.jdField_c_of_type_JavaLangRefWeakReference;
        if (localObject != null) {
          localObject = (FrameLayout)((WeakReference)localObject).get();
        } else {
          localObject = null;
        }
        a(localView, (FrameLayout)localObject);
      }
    }
  }
  
  public void f(int paramInt)
  {
    BadgeDrawable.SavedState.g(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
    b();
  }
  
  public void g(int paramInt)
  {
    BadgeDrawable.SavedState.h(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
    b();
  }
  
  public int getAlpha()
  {
    return BadgeDrawable.SavedState.h(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState);
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.height();
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.width();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return false;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    BadgeDrawable.SavedState.f(this.jdField_a_of_type_ComGoogleAndroidMaterialBadgeBadgeDrawable$SavedState, paramInt);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalTextDrawableHelper.a().setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.badge.BadgeDrawable
 * JD-Core Version:    0.7.0.1
 */