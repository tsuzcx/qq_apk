package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;

public class AIOAnimationConatiner
  extends ViewGroup
{
  public static final ViewGroup.LayoutParams a;
  public static ClassLoader a;
  private int jdField_a_of_type_Int;
  private AIOAnimationConatiner.AIOAnimator jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
  public IAioAnimListener a;
  public ListView a;
  
  static
  {
    jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, -2);
    jdField_a_of_type_JavaLangClassLoader = AIOAnimationConatiner.class.getClassLoader();
  }
  
  public AIOAnimationConatiner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AIOAnimationConatiner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private AIOAnimationConatiner.AIOAnimator a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return null;
    case 2: 
      return new FloorJumperSet(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 1: 
      return new ComboAnimation3(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 0: 
      return new BubbleAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 4: 
      return new PathAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    }
    return new BubbleInterActiveAnim(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = null;
    removeAllViewsInLayout();
    invalidate();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.c();
    }
    d();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) && (paramInt == this.jdField_a_of_type_Int)) {
      a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) && (paramInt2 < this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.jdField_a_of_type_Int)) {}
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) && (paramInt2 == this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramInt1)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramVarArgs);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
          a();
        }
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = a(paramInt1);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.jdField_a_of_type_Int = paramInt2;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramVarArgs));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramInt);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.b();
    }
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    Object localObject = paramView.getTag();
    if ((VersionUtils.e()) && ((localObject instanceof AnimationPath.Values)) && (((AnimationPath.Values)localObject).b))
    {
      localObject = (AnimationPath.Values)localObject;
      Matrix localMatrix = paramTransformation.getMatrix();
      localMatrix.reset();
      int i = paramView.getWidth() / 2;
      int j = paramView.getHeight() / 2;
      localMatrix.preRotate(((AnimationPath.Values)localObject).a, i, j);
      localMatrix.preScale(((AnimationPath.Values)localObject).d, ((AnimationPath.Values)localObject).e, j, j);
      paramTransformation.setAlpha(((AnimationPath.Values)localObject).f);
      return true;
    }
    return false;
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */