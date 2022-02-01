package com.tencent.mobileqq.activity.aio.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;

public class ComboAnimation3
  extends AIOAnimationConatiner.AIOAnimator
{
  static final int jdField_b_of_type_Int = (int)(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density * 60.0F + 0.5F);
  float jdField_a_of_type_Float = 0.04166667F;
  long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  
  public ComboAnimation3(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean a(long paramLong)
  {
    int m = this.jdField_a_of_type_AndroidViewView.getLeft();
    int n = this.jdField_a_of_type_AndroidViewView.getWidth() / 2;
    int i = this.jdField_a_of_type_AndroidViewView.getTop();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() / 2;
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() / 2;
    m = i1 - (m + n);
    i = k - (i + j);
    if ((m != 0) || (i != 0))
    {
      this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(m);
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i);
      this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(m);
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
    }
    return true;
  }
  
  protected void a(int paramInt)
  {
    QQViewCompatUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, paramInt);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(this.jdField_a_of_type_Long);
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    int j = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_Long = ((Long)paramVarArgs[1]).longValue();
    if (j > 0)
    {
      int i1 = Integer.toString(j).length();
      int m;
      if (j > 99)
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[4];
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130837942);
        i = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3].getIntrinsicWidth();
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130838281);
        j = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2].getIntrinsicWidth();
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130838281);
        m = i + 0 + j + this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1].getIntrinsicWidth();
      }
      else
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[i1 + 1];
        int k = 0;
        i = 0;
        int n;
        do
        {
          paramVarArgs = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
          m = i1 - k;
          paramVarArgs[m] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(j % 10 + 2130838272);
          m = i + this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[m].getIntrinsicWidth();
          k += 1;
          n = j / 10;
          j = n;
          i = m;
        } while (n > 0);
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130838282);
      int i = m + this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0].getIntrinsicWidth();
      this.jdField_a_of_type_AndroidViewView = new ComboAnimation3.ComboView(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_b_of_type_AndroidViewView = new ComboAnimation3.ComboView(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      this.jdField_a_of_type_AndroidViewView.layout(0, 0, i, jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidViewView.layout(0, 0, i, jdField_b_of_type_Int);
      if (a(this.jdField_a_of_type_Long))
      {
        if (VersionUtils.e())
        {
          this.jdField_a_of_type_AndroidViewView.setLayerType(2, null);
          paramVarArgs = this.jdField_a_of_type_AndroidViewView;
          float f = i / 2;
          paramVarArgs.setPivotX(f);
          this.jdField_a_of_type_AndroidViewView.setPivotY(jdField_b_of_type_Int / 2);
          this.jdField_b_of_type_AndroidViewView.setLayerType(2, null);
          this.jdField_b_of_type_AndroidViewView.setPivotX(f);
          this.jdField_b_of_type_AndroidViewView.setPivotY(jdField_b_of_type_Int / 2);
          Object localObject1 = Keyframe.ofFloat(0.0F, 0.0F);
          Object localObject2 = Keyframe.ofFloat(this.jdField_a_of_type_Float * 11.0F, 1.0F);
          Object localObject3 = Keyframe.ofFloat(this.jdField_a_of_type_Float * 20.0F, 1.0F);
          Keyframe localKeyframe = Keyframe.ofFloat(1.0F, 0.0F);
          paramVarArgs = new Keyframe[4];
          paramVarArgs[0] = Keyframe.ofFloat(0.0F, 1.0F);
          paramVarArgs[1] = Keyframe.ofFloat(this.jdField_a_of_type_Float * 6.0F, 1.5F);
          paramVarArgs[2] = Keyframe.ofFloat(this.jdField_a_of_type_Float * 11.0F, 1.0F);
          paramVarArgs[3] = Keyframe.ofFloat(1.0F, 1.0F);
          localObject3 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject1, localObject2, localObject3, localKeyframe });
          localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", paramVarArgs);
          localObject2 = PropertyValuesHolder.ofKeyframe("scaleY", paramVarArgs);
          paramVarArgs = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { localObject3 }).setDuration(1000L);
          localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { localObject1 }).setDuration(1000L);
          localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { localObject2 }).setDuration(1000L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).addListener(new ComboAnimation3.1(this));
          ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
          ((AnimatorSet)localObject3).start();
          this.jdField_a_of_type_AndroidViewView.setTag(localObject3);
          this.jdField_b_of_type_AndroidViewView.setAlpha(0.0F);
          paramVarArgs = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.5F, 0.0F }).setDuration(333L);
          localObject1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleX", new float[] { 1.5F, 2.0F }).setDuration(333L);
          localObject2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleY", new float[] { 1.5F, 2.0F }).setDuration(333L);
          localObject3 = new AnimatorSet();
          ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
          ((AnimatorSet)localObject3).setStartDelay((this.jdField_a_of_type_Float * 5.0F * 1000.0F));
          ((AnimatorSet)localObject3).start();
          this.jdField_b_of_type_AndroidViewView.setTag(localObject3);
          return true;
        }
        paramVarArgs = new ComboAnimation3.2(this);
        paramVarArgs.setDuration(1000L);
        paramVarArgs.setFillAfter(true);
        this.jdField_a_of_type_AndroidViewView.setAnimation(paramVarArgs);
        paramVarArgs.setAnimationListener(new ComboAnimation3.3(this));
        paramVarArgs = new ComboAnimation3.4(this);
        paramVarArgs.setDuration(1000L);
        paramVarArgs.setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.setAnimation(paramVarArgs);
        return true;
      }
    }
    return false;
  }
  
  @TargetApi(11)
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
    if (VersionUtils.e())
    {
      Animator localAnimator1 = (Animator)this.jdField_a_of_type_AndroidViewView.getTag();
      Animator localAnimator2 = (Animator)this.jdField_b_of_type_AndroidViewView.getTag();
      if (localAnimator1 != null) {
        localAnimator1.cancel();
      }
      if (localAnimator2 != null) {
        localAnimator2.cancel();
      }
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.ComboAnimation3
 * JD-Core Version:    0.7.0.1
 */