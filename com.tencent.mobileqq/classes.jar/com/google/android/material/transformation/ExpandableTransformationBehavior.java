package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  @Nullable
  private AnimatorSet a;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @CallSuper
  protected boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool;
    if (this.a != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.a.cancel();
    }
    this.a = b(paramView1, paramView2, paramBoolean1, bool);
    this.a.addListener(new ExpandableTransformationBehavior.1(this));
    this.a.start();
    if (!paramBoolean2) {
      this.a.end();
    }
    return true;
  }
  
  @NonNull
  protected abstract AnimatorSet b(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.ExpandableTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */