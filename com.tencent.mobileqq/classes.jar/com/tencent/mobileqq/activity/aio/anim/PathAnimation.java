package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class PathAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private PathAnimation.Animator jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator;
  ArrayList<AnimationPath.Values> jdField_a_of_type_JavaUtilArrayList;
  
  public PathAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  @TargetApi(11)
  void a(View paramView, AnimationPath.Values paramValues)
  {
    if (!paramValues.jdField_b_of_type_Boolean) {
      return;
    }
    int i = paramView.getLeft();
    int j = paramView.getWidth() / 2;
    int k = paramView.getTop();
    int m = paramView.getHeight() / 2;
    paramView.offsetTopAndBottom(paramValues.jdField_b_of_type_Int - (k + m));
    paramView.offsetLeftAndRight(paramValues.jdField_a_of_type_Int - (i + j));
    if (VersionUtils.e())
    {
      paramView.setAlpha(paramValues.f);
      paramView.setRotation(paramValues.jdField_a_of_type_Float);
      paramView.setScaleX(paramValues.d);
      paramView.setScaleY(paramValues.e);
      paramView.setRotationX(paramValues.jdField_b_of_type_Float);
      paramView.setRotationY(paramValues.c);
    }
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        Drawable[] arrayOfDrawable;
        if ((paramVarArgs[0] instanceof Drawable[]))
        {
          arrayOfDrawable = (Drawable[])paramVarArgs[0];
        }
        else
        {
          arrayOfDrawable = new Drawable[1];
          arrayOfDrawable[0] = ((Drawable)paramVarArgs[0]);
        }
        int k = ((Integer)paramVarArgs[1]).intValue();
        long l1 = ((Long)paramVarArgs[2]).longValue();
        localAnimationPath = (AnimationPath)AIOAnimationConatiner.a.loadClass((String)paramVarArgs[3]).newInstance();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(k);
        l2 = AnimationUtils.currentAnimationTimeMillis();
        i = 0;
        j = 0;
        if (i < k)
        {
          localView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
          double d1 = Math.random();
          int m = arrayOfDrawable.length;
          double d2 = m;
          Double.isNaN(d2);
          m = (int)(d1 * d2);
          localDrawable = arrayOfDrawable[m];
          localView.setBackgroundDrawable(localDrawable);
          localView.layout(-localDrawable.getIntrinsicWidth(), -localDrawable.getIntrinsicHeight(), 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(localView);
          if (i != 0)
          {
            d1 = Math.random();
            d2 = l1;
            Double.isNaN(d2);
            j = (int)(d1 * d2);
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        AnimationPath localAnimationPath;
        long l2;
        int i;
        int j;
        View localView;
        Drawable localDrawable;
        AnimationPath.Values localValues;
        return false;
      }
      try
      {
        localValues = new AnimationPath.Values();
        localValues.jdField_a_of_type_Long = (j + l2);
        localValues.jdField_a_of_type_AndroidViewView = localView;
        if (i == 0) {
          paramVarArgs = localAnimationPath;
        } else {
          paramVarArgs = localAnimationPath.a();
        }
        localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath = paramVarArgs;
        if (VersionUtils.e())
        {
          localView.setLayerType(2, null);
          localView.setPivotX(localDrawable.getIntrinsicWidth() / 2);
          localView.setPivotY(localDrawable.getIntrinsicHeight() / 2);
        }
        else
        {
          localView.setTag(localValues);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localValues);
        i += 1;
      }
      catch (Exception paramVarArgs) {}
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator = new PathAnimation.Animator(this, null);
      this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator, 16L);
    }
    return true;
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation
 * JD-Core Version:    0.7.0.1
 */