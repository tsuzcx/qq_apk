package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FabTransformationScrimBehavior
  extends ExpandableTransformationBehavior
{
  private final MotionTiming a = new MotionTiming(75L, 150L);
  private final MotionTiming b = new MotionTiming(0L, 150L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(@NonNull View paramView, boolean paramBoolean1, boolean paramBoolean2, @NonNull List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (paramBoolean1) {
      paramList1 = this.a;
    } else {
      paramList1 = this.b;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView.setAlpha(0.0F);
      }
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F });
    }
    else
    {
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F });
    }
    paramList1.a(paramView);
    paramList.add(paramView);
  }
  
  @NonNull
  protected AnimatorSet b(@NonNull View paramView1, @NonNull View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramView1 = new ArrayList();
    a(paramView2, paramBoolean1, paramBoolean2, paramView1, new ArrayList());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    AnimatorSetCompat.a(localAnimatorSet, paramView1);
    localAnimatorSet.addListener(new FabTransformationScrimBehavior.1(this, paramBoolean1, paramView2));
    return localAnimatorSet;
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }
  
  public boolean onTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, @NonNull MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationScrimBehavior
 * JD-Core Version:    0.7.0.1
 */