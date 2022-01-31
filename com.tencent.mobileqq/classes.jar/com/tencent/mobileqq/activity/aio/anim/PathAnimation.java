package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import unt;

public class PathAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  public ArrayList a;
  private unt a;
  
  public PathAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  @TargetApi(11)
  public void a(View paramView, AnimationPath.Values paramValues)
  {
    if (!paramValues.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      int i = paramView.getLeft();
      int j = paramView.getWidth() / 2;
      int k = paramView.getTop();
      int m = paramView.getHeight() / 2;
      paramView.offsetTopAndBottom(paramValues.jdField_b_of_type_Int - (k + m));
      paramView.offsetLeftAndRight(paramValues.jdField_a_of_type_Int - (i + j));
    } while (!VersionUtils.e());
    paramView.setAlpha(paramValues.f);
    paramView.setRotation(paramValues.jdField_a_of_type_Float);
    paramView.setScaleX(paramValues.d);
    paramView.setScaleY(paramValues.e);
    paramView.setRotationX(paramValues.jdField_b_of_type_Float);
    paramView.setRotationY(paramValues.c);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    try
    {
      Drawable[] arrayOfDrawable;
      long l1;
      AnimationPath localAnimationPath;
      int i;
      label82:
      View localView;
      int j;
      label159:
      AnimationPath.Values localValues;
      if ((paramVarArgs[0] instanceof Drawable[]))
      {
        arrayOfDrawable = (Drawable[])paramVarArgs[0];
        int k = ((Integer)paramVarArgs[1]).intValue();
        l1 = ((Long)paramVarArgs[2]).longValue();
        localAnimationPath = (AnimationPath)AIOAnimationConatiner.a.loadClass((String)paramVarArgs[3]).newInstance();
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
        localValues = new AnimationPath.Values();
        localValues.jdField_a_of_type_Long = (j + l2);
        localValues.jdField_a_of_type_AndroidViewView = localView;
        if (i != 0) {
          break label284;
        }
        paramVarArgs = localAnimationPath;
        label192:
        localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath = paramVarArgs;
        if (!VersionUtils.e()) {
          break label295;
        }
        localView.setLayerType(2, null);
        localView.setPivotX(localDrawable.getIntrinsicWidth() / 2);
        localView.setPivotY(localDrawable.getIntrinsicHeight() / 2);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localValues);
        i += 1;
        break label82;
        arrayOfDrawable = new Drawable[] { (Drawable)paramVarArgs[0] };
        break;
        label272:
        j = (int)(Math.random() * l1);
        break label159;
        label284:
        paramVarArgs = localAnimationPath.a();
        break label192;
        label295:
        localView.setTag(localValues);
      }
      label305:
      if (this.jdField_a_of_type_Unt == null)
      {
        this.jdField_a_of_type_Unt = new unt(this, null);
        this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this.jdField_a_of_type_Unt, 16L);
      }
      return true;
    }
    catch (Exception paramVarArgs) {}
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Unt != null)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_Unt);
      this.jdField_a_of_type_Unt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation
 * JD-Core Version:    0.7.0.1
 */