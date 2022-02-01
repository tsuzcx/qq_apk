package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R.color;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class FloatingActionButtonImplLollipop
  extends FloatingActionButtonImpl
{
  FloatingActionButtonImplLollipop(FloatingActionButton paramFloatingActionButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramFloatingActionButton, paramShadowViewDelegate);
  }
  
  @NonNull
  private Animator a(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.s, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(a);
    return localAnimatorSet;
  }
  
  public float a()
  {
    return this.s.getElevation();
  }
  
  @NonNull
  BorderDrawable a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.s.getContext();
    BorderDrawable localBorderDrawable = new BorderDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.b));
    localBorderDrawable.a(ContextCompat.getColor(localContext, R.color.f), ContextCompat.getColor(localContext, R.color.e), ContextCompat.getColor(localContext, R.color.c), ContextCompat.getColor(localContext, R.color.d));
    localBorderDrawable.a(paramInt);
    localBorderDrawable.a(paramColorStateList);
    return localBorderDrawable;
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      this.s.refreshDrawableState();
    }
    else
    {
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(m, a(paramFloat1, paramFloat3));
      localStateListAnimator.addState(n, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(o, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(p, a(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.s, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[] { this.s.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(a);
      localStateListAnimator.addState(q, localAnimatorSet);
      localStateListAnimator.addState(r, a(0.0F, 0.0F));
      this.s.setStateListAnimator(localStateListAnimator);
    }
    if (p()) {
      o();
    }
  }
  
  void a(ColorStateList paramColorStateList1, @Nullable PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.c = u();
    this.c.setTintList(paramColorStateList1);
    if (paramMode != null) {
      this.c.setTintMode(paramMode);
    }
    this.c.a(this.s.getContext());
    if (paramInt > 0)
    {
      this.e = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new LayerDrawable(new Drawable[] { (Drawable)Preconditions.checkNotNull(this.e), (Drawable)Preconditions.checkNotNull(this.c) });
    }
    else
    {
      this.e = null;
      paramColorStateList1 = this.c;
    }
    this.d = new RippleDrawable(RippleUtils.b(paramColorStateList2), paramColorStateList1, null);
    this.f = this.d;
  }
  
  void a(@NonNull Rect paramRect)
  {
    if (this.t.a())
    {
      super.a(paramRect);
      return;
    }
    if (!h())
    {
      int i = (this.l - this.s.getSizeDimension()) / 2;
      paramRect.set(i, i, i, i);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  void a(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      if (this.s.isEnabled())
      {
        this.s.setElevation(this.i);
        if (this.s.isPressed())
        {
          this.s.setTranslationZ(this.k);
          return;
        }
        if ((!this.s.isFocused()) && (!this.s.isHovered()))
        {
          this.s.setTranslationZ(0.0F);
          return;
        }
        this.s.setTranslationZ(this.j);
        return;
      }
      this.s.setElevation(0.0F);
      this.s.setTranslationZ(0.0F);
    }
  }
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    if ((this.d instanceof RippleDrawable))
    {
      ((RippleDrawable)this.d).setColor(RippleUtils.b(paramColorStateList));
      return;
    }
    super.b(paramColorStateList);
  }
  
  void j() {}
  
  void n()
  {
    o();
  }
  
  boolean p()
  {
    return (this.t.a()) || (!h());
  }
  
  boolean s()
  {
    return false;
  }
  
  @NonNull
  MaterialShapeDrawable u()
  {
    return new FloatingActionButtonImplLollipop.AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.b));
  }
  
  void x() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop
 * JD-Core Version:    0.7.0.1
 */