package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
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
import androidx.annotation.StyleableRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

public class BadgeDrawable
  extends Drawable
  implements TextDrawableHelper.TextDrawableDelegate
{
  @StyleRes
  private static final int a = R.style.t;
  @AttrRes
  private static final int b = R.attr.d;
  @NonNull
  private final WeakReference<Context> c;
  @NonNull
  private final MaterialShapeDrawable d;
  @NonNull
  private final TextDrawableHelper e;
  @NonNull
  private final Rect f;
  private final float g;
  private final float h;
  private final float i;
  @NonNull
  private final BadgeDrawable.SavedState j;
  private float k;
  private float l;
  private int m;
  private float n;
  private float o;
  private float p;
  @Nullable
  private WeakReference<View> q;
  @Nullable
  private WeakReference<FrameLayout> r;
  
  private BadgeDrawable(@NonNull Context paramContext)
  {
    this.c = new WeakReference(paramContext);
    ThemeEnforcement.b(paramContext);
    Resources localResources = paramContext.getResources();
    this.f = new Rect();
    this.d = new MaterialShapeDrawable();
    this.g = localResources.getDimensionPixelSize(R.dimen.I);
    this.i = localResources.getDimensionPixelSize(R.dimen.H);
    this.h = localResources.getDimensionPixelSize(R.dimen.M);
    this.e = new TextDrawableHelper(this);
    this.e.a().setTextAlign(Paint.Align.CENTER);
    this.j = new BadgeDrawable.SavedState(paramContext);
    h(R.style.g);
  }
  
  private static int a(Context paramContext, @NonNull TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    return MaterialResources.a(paramContext, paramTypedArray, paramInt).getDefaultColor();
  }
  
  @NonNull
  public static BadgeDrawable a(@NonNull Context paramContext)
  {
    return a(paramContext, null, b, a);
  }
  
  @NonNull
  private static BadgeDrawable a(@NonNull Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    BadgeDrawable localBadgeDrawable = new BadgeDrawable(paramContext);
    localBadgeDrawable.b(paramContext, paramAttributeSet, paramInt1, paramInt2);
    return localBadgeDrawable;
  }
  
  @NonNull
  static BadgeDrawable a(@NonNull Context paramContext, @NonNull BadgeDrawable.SavedState paramSavedState)
  {
    paramContext = new BadgeDrawable(paramContext);
    paramContext.a(paramSavedState);
    return paramContext;
  }
  
  private void a(@NonNull Context paramContext, @NonNull Rect paramRect, @NonNull View paramView)
  {
    int i1 = BadgeDrawable.SavedState.e(this.j);
    if ((i1 != 8388691) && (i1 != 8388693)) {
      this.l = (paramRect.top + BadgeDrawable.SavedState.g(this.j));
    } else {
      this.l = (paramRect.bottom - BadgeDrawable.SavedState.g(this.j));
    }
    float f1;
    if (d() <= 9)
    {
      if (!c()) {
        f1 = this.g;
      } else {
        f1 = this.h;
      }
      this.n = f1;
      f1 = this.n;
      this.p = f1;
      this.o = f1;
    }
    else
    {
      this.n = this.h;
      this.p = this.n;
      String str = k();
      this.o = (this.e.a(str) / 2.0F + this.i);
    }
    paramContext = paramContext.getResources();
    if (c()) {
      i1 = R.dimen.J;
    } else {
      i1 = R.dimen.G;
    }
    i1 = paramContext.getDimensionPixelSize(i1);
    int i2 = BadgeDrawable.SavedState.e(this.j);
    if ((i2 != 8388659) && (i2 != 8388691))
    {
      if (ViewCompat.getLayoutDirection(paramView) == 0) {
        f1 = paramRect.right + this.o - i1 - BadgeDrawable.SavedState.f(this.j);
      } else {
        f1 = paramRect.left - this.o + i1 + BadgeDrawable.SavedState.f(this.j);
      }
      this.k = f1;
      return;
    }
    if (ViewCompat.getLayoutDirection(paramView) == 0) {
      f1 = paramRect.left - this.o + i1 + BadgeDrawable.SavedState.f(this.j);
    } else {
      f1 = paramRect.right + this.o - i1 - BadgeDrawable.SavedState.f(this.j);
    }
    this.k = f1;
  }
  
  private void a(Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    String str = k();
    this.e.a().getTextBounds(str, 0, str.length(), localRect);
    paramCanvas.drawText(str, this.k, this.l + localRect.height() / 2, this.e.a());
  }
  
  private void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup == null) || (localViewGroup.getId() != R.id.H))
    {
      localObject = this.r;
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
    int i1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeViewAt(i1);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject).addView(paramView);
    localViewGroup.addView((View)localObject, i1);
    this.r = new WeakReference(localObject);
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
    a(BadgeDrawable.SavedState.h(paramSavedState));
  }
  
  private void a(@Nullable TextAppearance paramTextAppearance)
  {
    if (this.e.b() == paramTextAppearance) {
      return;
    }
    Context localContext = (Context)this.c.get();
    if (localContext == null) {
      return;
    }
    this.e.a(paramTextAppearance, localContext);
    j();
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.C, paramInt1, paramInt2, new int[0]);
    d(paramAttributeSet.getInt(R.styleable.H, 4));
    if (paramAttributeSet.hasValue(R.styleable.I)) {
      c(paramAttributeSet.getInt(R.styleable.I, 0));
    }
    a(a(paramContext, paramAttributeSet, R.styleable.D));
    if (paramAttributeSet.hasValue(R.styleable.F)) {
      b(a(paramContext, paramAttributeSet, R.styleable.F));
    }
    e(paramAttributeSet.getInt(R.styleable.E, 8388661));
    f(paramAttributeSet.getDimensionPixelOffset(R.styleable.G, 0));
    g(paramAttributeSet.getDimensionPixelOffset(R.styleable.J, 0));
    paramAttributeSet.recycle();
  }
  
  private static void b(View paramView)
  {
    paramView = (ViewGroup)paramView.getParent();
    paramView.setClipChildren(false);
    paramView.setClipToPadding(false);
  }
  
  private void h(@StyleRes int paramInt)
  {
    Context localContext = (Context)this.c.get();
    if (localContext == null) {
      return;
    }
    a(new TextAppearance(localContext, paramInt));
  }
  
  private void j()
  {
    Context localContext = (Context)this.c.get();
    Object localObject1 = this.q;
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
      localRect1.set(this.f);
      Rect localRect2 = new Rect();
      ((View)localObject1).getDrawingRect(localRect2);
      Object localObject2 = this.r;
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
      BadgeUtils.a(this.f, this.k, this.l, this.o, this.p);
      this.d.o(this.n);
      if (!localRect1.equals(this.f)) {
        this.d.setBounds(this.f);
      }
    }
  }
  
  @NonNull
  private String k()
  {
    if (d() <= this.m) {
      return NumberFormat.getInstance().format(d());
    }
    Context localContext = (Context)this.c.get();
    if (localContext == null) {
      return "";
    }
    return localContext.getString(R.string.v, new Object[] { Integer.valueOf(this.m), "+" });
  }
  
  private void l()
  {
    double d1 = e();
    Double.isNaN(d1);
    this.m = ((int)Math.pow(10.0D, d1 - 1.0D) - 1);
  }
  
  @NonNull
  public BadgeDrawable.SavedState a()
  {
    return this.j;
  }
  
  public void a(@ColorInt int paramInt)
  {
    BadgeDrawable.SavedState.a(this.j, paramInt);
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    if (this.d.M() != localColorStateList)
    {
      this.d.g(localColorStateList);
      invalidateSelf();
    }
  }
  
  public void a(@NonNull View paramView, @Nullable FrameLayout paramFrameLayout)
  {
    this.q = new WeakReference(paramView);
    if ((BadgeUtils.a) && (paramFrameLayout == null)) {
      a(paramView);
    } else {
      this.r = new WeakReference(paramFrameLayout);
    }
    if (!BadgeUtils.a) {
      b(paramView);
    }
    j();
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean)
  {
    setVisible(paramBoolean, false);
    BadgeDrawable.SavedState.a(this.j, paramBoolean);
    if ((BadgeUtils.a) && (b() != null) && (!paramBoolean)) {
      ((ViewGroup)b().getParent()).invalidate();
    }
  }
  
  @Nullable
  public FrameLayout b()
  {
    WeakReference localWeakReference = this.r;
    if (localWeakReference != null) {
      return (FrameLayout)localWeakReference.get();
    }
    return null;
  }
  
  public void b(@ColorInt int paramInt)
  {
    BadgeDrawable.SavedState.b(this.j, paramInt);
    if (this.e.a().getColor() != paramInt)
    {
      this.e.a().setColor(paramInt);
      invalidateSelf();
    }
  }
  
  public void c(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    if (BadgeDrawable.SavedState.b(this.j) != paramInt)
    {
      BadgeDrawable.SavedState.c(this.j, paramInt);
      this.e.a(true);
      j();
      invalidateSelf();
    }
  }
  
  public boolean c()
  {
    return BadgeDrawable.SavedState.b(this.j) != -1;
  }
  
  public int d()
  {
    if (!c()) {
      return 0;
    }
    return BadgeDrawable.SavedState.b(this.j);
  }
  
  public void d(int paramInt)
  {
    if (BadgeDrawable.SavedState.a(this.j) != paramInt)
    {
      BadgeDrawable.SavedState.d(this.j, paramInt);
      l();
      this.e.a(true);
      j();
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
      this.d.draw(paramCanvas);
      if (c()) {
        a(paramCanvas);
      }
    }
  }
  
  public int e()
  {
    return BadgeDrawable.SavedState.a(this.j);
  }
  
  public void e(int paramInt)
  {
    if (BadgeDrawable.SavedState.e(this.j) != paramInt)
    {
      BadgeDrawable.SavedState.e(this.j, paramInt);
      Object localObject = this.q;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        View localView = (View)this.q.get();
        localObject = this.r;
        if (localObject != null) {
          localObject = (FrameLayout)((WeakReference)localObject).get();
        } else {
          localObject = null;
        }
        a(localView, (FrameLayout)localObject);
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void f()
  {
    invalidateSelf();
  }
  
  public void f(int paramInt)
  {
    BadgeDrawable.SavedState.g(this.j, paramInt);
    j();
  }
  
  @Nullable
  public CharSequence g()
  {
    if (!isVisible()) {
      return null;
    }
    if (c())
    {
      if (BadgeDrawable.SavedState.j(this.j) > 0)
      {
        Context localContext = (Context)this.c.get();
        if (localContext == null) {
          return null;
        }
        if (d() <= this.m) {
          return localContext.getResources().getQuantityString(BadgeDrawable.SavedState.j(this.j), d(), new Object[] { Integer.valueOf(d()) });
        }
        return localContext.getString(BadgeDrawable.SavedState.k(this.j), new Object[] { Integer.valueOf(this.m) });
      }
      return null;
    }
    return BadgeDrawable.SavedState.l(this.j);
  }
  
  public void g(int paramInt)
  {
    BadgeDrawable.SavedState.h(this.j, paramInt);
    j();
  }
  
  public int getAlpha()
  {
    return BadgeDrawable.SavedState.i(this.j);
  }
  
  public int getIntrinsicHeight()
  {
    return this.f.height();
  }
  
  public int getIntrinsicWidth()
  {
    return this.f.width();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public int h()
  {
    return BadgeDrawable.SavedState.f(this.j);
  }
  
  public int i()
  {
    return BadgeDrawable.SavedState.g(this.j);
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
    BadgeDrawable.SavedState.f(this.j, paramInt);
    this.e.a().setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.badge.BadgeDrawable
 * JD-Core Version:    0.7.0.1
 */