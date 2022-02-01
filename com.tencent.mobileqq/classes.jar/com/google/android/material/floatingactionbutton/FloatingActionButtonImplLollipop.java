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
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(jdField_a_of_type_AndroidAnimationTimeInterpolator);
    return localAnimatorSet;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getElevation();
  }
  
  @NonNull
  BorderDrawable a(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getContext();
    BorderDrawable localBorderDrawable = new BorderDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel));
    localBorderDrawable.a(ContextCompat.getColor(localContext, R.color.f), ContextCompat.getColor(localContext, R.color.e), ContextCompat.getColor(localContext, R.color.c), ContextCompat.getColor(localContext, R.color.d));
    localBorderDrawable.a(paramInt);
    localBorderDrawable.a(paramColorStateList);
    return localBorderDrawable;
  }
  
  @NonNull
  MaterialShapeDrawable a()
  {
    return new FloatingActionButtonImplLollipop.AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeShapeAppearanceModel));
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.refreshDrawableState();
    }
    else
    {
      StateListAnimator localStateListAnimator = new StateListAnimator();
      localStateListAnimator.addState(jdField_a_of_type_ArrayOfInt, a(paramFloat1, paramFloat3));
      localStateListAnimator.addState(jdField_b_of_type_ArrayOfInt, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(jdField_c_of_type_ArrayOfInt, a(paramFloat1, paramFloat2));
      localStateListAnimator.addState(d, a(paramFloat1, paramFloat2));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, "elevation", new float[] { paramFloat1 }).setDuration(0L));
      if ((Build.VERSION.SDK_INT >= 22) && (Build.VERSION.SDK_INT <= 24)) {
        localArrayList.add(ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, View.TRANSLATION_Z, new float[] { this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getTranslationZ() }).setDuration(100L));
      }
      localArrayList.add(ObjectAnimator.ofFloat(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
      localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
      localAnimatorSet.setInterpolator(jdField_a_of_type_AndroidAnimationTimeInterpolator);
      localStateListAnimator.addState(e, localAnimatorSet);
      localStateListAnimator.addState(f, a(0.0F, 0.0F));
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setStateListAnimator(localStateListAnimator);
    }
    if (c()) {
      f();
    }
  }
  
  void a(ColorStateList paramColorStateList1, @Nullable PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable = a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTintList(paramColorStateList1);
    if (paramMode != null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.setTintMode(paramMode);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.getContext());
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable = a(paramInt, paramColorStateList1);
      paramColorStateList1 = new LayerDrawable(new Drawable[] { (Drawable)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable), (Drawable)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable) });
    }
    else
    {
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonBorderDrawable = null;
      paramColorStateList1 = this.jdField_a_of_type_ComGoogleAndroidMaterialShapeMaterialShapeDrawable;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new RippleDrawable(RippleUtils.b(paramColorStateList2), paramColorStateList1, null);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  void a(@NonNull Rect paramRect)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowViewDelegate.a())
    {
      super.a(paramRect);
      return;
    }
    if (!a())
    {
      int i = (this.jdField_a_of_type_Int - this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.b()) / 2;
      paramRect.set(i, i, i, i);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  void a(int[] paramArrayOfInt)
  {
    if (Build.VERSION.SDK_INT == 21)
    {
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.isEnabled())
      {
        this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setElevation(this.jdField_a_of_type_Float);
        if (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.isPressed())
        {
          this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setTranslationZ(this.jdField_c_of_type_Float);
          return;
        }
        if ((!this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.isFocused()) && (!this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.isHovered()))
        {
          this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setTranslationZ(0.0F);
          return;
        }
        this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setTranslationZ(this.jdField_b_of_type_Float);
        return;
      }
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setElevation(0.0F);
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButton.setTranslationZ(0.0F);
    }
  }
  
  void b() {}
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).setColor(RippleUtils.b(paramColorStateList));
      return;
    }
    super.b(paramColorStateList);
  }
  
  boolean c()
  {
    return (this.jdField_a_of_type_ComGoogleAndroidMaterialShadowShadowViewDelegate.a()) || (!a());
  }
  
  boolean d()
  {
    return false;
  }
  
  void e()
  {
    f();
  }
  
  void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop
 * JD-Core Version:    0.7.0.1
 */