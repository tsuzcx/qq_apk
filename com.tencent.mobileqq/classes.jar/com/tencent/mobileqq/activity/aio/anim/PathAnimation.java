package com.tencent.mobileqq.activity.aio.anim;

import aepy;
import aeqi;
import aeqj;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import bhou;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class PathAnimation
  extends aepy
{
  private PathAnimation.Animator jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator;
  ArrayList<aeqj> jdField_a_of_type_JavaUtilArrayList;
  
  public PathAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  @TargetApi(11)
  void a(View paramView, aeqj paramaeqj)
  {
    if (!paramaeqj.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      int i = paramView.getLeft();
      int j = paramView.getWidth() / 2;
      int k = paramView.getTop();
      int m = paramView.getHeight() / 2;
      paramView.offsetTopAndBottom(paramaeqj.jdField_b_of_type_Int - (k + m));
      paramView.offsetLeftAndRight(paramaeqj.jdField_a_of_type_Int - (i + j));
    } while (!bhou.e());
    paramView.setAlpha(paramaeqj.f);
    paramView.setRotation(paramaeqj.jdField_a_of_type_Float);
    paramView.setScaleX(paramaeqj.d);
    paramView.setScaleY(paramaeqj.e);
    paramView.setRotationX(paramaeqj.jdField_b_of_type_Float);
    paramView.setRotationY(paramaeqj.c);
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  @TargetApi(11)
  public boolean a(Object... paramVarArgs)
  {
    try
    {
      Drawable[] arrayOfDrawable;
      long l1;
      aeqi localaeqi;
      int i;
      label82:
      View localView;
      int j;
      label159:
      aeqj localaeqj;
      if ((paramVarArgs[0] instanceof Drawable[]))
      {
        arrayOfDrawable = (Drawable[])paramVarArgs[0];
        int k = ((Integer)paramVarArgs[1]).intValue();
        l1 = ((Long)paramVarArgs[2]).longValue();
        localaeqi = (aeqi)AIOAnimationConatiner.a.loadClass((String)paramVarArgs[3]).newInstance();
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(k);
        long l2 = AnimationUtils.currentAnimationTimeMillis();
        i = 0;
        if (i >= k) {
          break label305;
        }
        localView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
        Drawable localDrawable = arrayOfDrawable[((int)(Math.random() * arrayOfDrawable.length))];
        localView.setBackgroundDrawable(localDrawable);
        localView.layout(-localDrawable.getIntrinsicWidth(), -localDrawable.getIntrinsicHeight(), 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(localView);
        if (i != 0) {
          break label272;
        }
        j = 0;
        localaeqj = new aeqj();
        localaeqj.jdField_a_of_type_Long = (j + l2);
        localaeqj.jdField_a_of_type_AndroidViewView = localView;
        if (i != 0) {
          break label284;
        }
        paramVarArgs = localaeqi;
        label192:
        localaeqj.jdField_a_of_type_Aeqi = paramVarArgs;
        if (!bhou.e()) {
          break label295;
        }
        localView.setLayerType(2, null);
        localView.setPivotX(localDrawable.getIntrinsicWidth() / 2);
        localView.setPivotY(localDrawable.getIntrinsicHeight() / 2);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localaeqj);
        i += 1;
        break label82;
        arrayOfDrawable = new Drawable[] { (Drawable)paramVarArgs[0] };
        break;
        label272:
        j = (int)(Math.random() * l1);
        break label159;
        label284:
        paramVarArgs = localaeqi.a();
        break label192;
        label295:
        localView.setTag(localaeqj);
      }
      label305:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator = new PathAnimation.Animator(this, null);
        this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator, 16L);
      }
      return true;
    }
    catch (Exception paramVarArgs) {}
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimPathAnimation$Animator = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation
 * JD-Core Version:    0.7.0.1
 */