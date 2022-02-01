package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.DigitLottieAnimation;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOAnimationConatiner
  extends ViewGroup
  implements View.OnLayoutChangeListener
{
  public static final ViewGroup.LayoutParams a;
  public static ClassLoader a;
  private int jdField_a_of_type_Int;
  private AIOAnimationConatiner.AIOAnimator jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
  public IAioAnimListener a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<AIOAnimationConatiner.AIOAnimator> jdField_a_of_type_JavaUtilList;
  
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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 7)
              {
                if (paramInt != 8)
                {
                  if (paramInt != 9) {
                    return null;
                  }
                  return new DigitLottieAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
                }
                return new BusinessEggsAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
              }
              return new LottieAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
            }
            return new BubbleInterActiveAnim(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
          }
          return new PathAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
        }
        return new FloorJumperSet(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
      }
      return new ComboAnimation3(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    }
    return new BubbleAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next()).jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = null;
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() == 0))
    {
      removeAllViewsInLayout();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationConatiner", 2, "[end] removeAllViews");
      }
    }
    invalidate();
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public void a()
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localAIOAnimator != null) {
      localAIOAnimator.c();
    }
    g();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject == null) || (i >= ((List)localObject).size())) {
        break;
      }
      localObject = (AIOAnimationConatiner.AIOAnimator)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localObject != null) && (paramInt == ((AIOAnimationConatiner.AIOAnimator)localObject).jdField_a_of_type_Int)) {
        break label61;
      }
      i += 1;
    }
    Object localObject = null;
    i = -1;
    label61:
    if (i != -1)
    {
      ((AIOAnimationConatiner.AIOAnimator)localObject).c();
      this.jdField_a_of_type_JavaUtilList.remove(i);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (((localObject == null) || (((List)localObject).size() == 0)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator == null))
    {
      removeAllViewsInLayout();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationConatiner", 2, "[stopConcurrentAnimation] removeAllViews");
      }
    }
    invalidate();
  }
  
  public void a(ListView paramListView)
  {
    AssertUtils.checkNotNull(paramListView);
    ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localListView == paramListView)
    {
      SLog.e("AIOAnimationConatiner", "attach the same listView!");
      return;
    }
    if (localListView != null)
    {
      SLog.e("AIOAnimationConatiner", "attach and override listView!");
      e();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentWidgetListView.addOnLayoutChangeListener(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    boolean bool1 = false;
    if ((localAIOAnimator != null) && (paramInt2 < localAIOAnimator.jdField_a_of_type_Int)) {
      return false;
    }
    localAIOAnimator = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if ((localAIOAnimator != null) && (paramInt2 == localAIOAnimator.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramInt1))) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(paramVarArgs);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) {
      a();
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = a(paramInt1);
    localAIOAnimator = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localAIOAnimator != null)
    {
      localAIOAnimator.jdField_a_of_type_Int = paramInt2;
      boolean bool2 = localAIOAnimator.a(paramVarArgs);
      bool1 = bool2;
      if (!bool2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator = null;
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void b()
  {
    f();
    a();
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null) && (paramInt == this.jdField_a_of_type_Int)) {
      a();
    }
  }
  
  public boolean b(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AIOAnimationConatiner.AIOAnimator localAIOAnimator = (AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next();
      if ((paramInt1 == localAIOAnimator.jdField_a_of_type_Int) && (localAIOAnimator.a(paramInt1)))
      {
        localAIOAnimator.a(paramVarArgs);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[concurrentStartAnimation] reuse animator, type: ");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("AIOAnimationConatiner", 2, ((StringBuilder)localObject).toString());
        }
        paramInt2 = 1;
        break label124;
      }
    }
    paramInt2 = 0;
    label124:
    if (paramInt2 == 0)
    {
      localObject = a(paramInt1);
      if (localObject == null) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      ((AIOAnimationConatiner.AIOAnimator)localObject).a(paramVarArgs);
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("[concurrentStartAnimation] create new animator, type: ");
        paramVarArgs.append(paramInt1);
        QLog.d("AIOAnimationConatiner", 2, paramVarArgs.toString());
      }
    }
    return true;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).a();
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next()).a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localAIOAnimator != null) {
      localAIOAnimator.a(paramInt);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localObject != null) {
      ((AIOAnimationConatiner.AIOAnimator)localObject).b();
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AIOAnimationConatiner.AIOAnimator)((Iterator)localObject).next()).b();
      }
    }
  }
  
  public void e()
  {
    ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localListView == null) {
      return;
    }
    localListView.removeOnLayoutChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    Object localObject = paramView.getTag();
    if ((VersionUtils.e()) && ((localObject instanceof AnimationPath.Values)))
    {
      localObject = (AnimationPath.Values)localObject;
      if (((AnimationPath.Values)localObject).b)
      {
        Matrix localMatrix = paramTransformation.getMatrix();
        localMatrix.reset();
        int i = paramView.getWidth() / 2;
        int j = paramView.getHeight() / 2;
        float f1 = ((AnimationPath.Values)localObject).a;
        float f2 = i;
        float f3 = j;
        localMatrix.preRotate(f1, f2, f3);
        localMatrix.preScale(((AnimationPath.Values)localObject).d, ((AnimationPath.Values)localObject).e, f3, f3);
        paramTransformation.setAlpha(((AnimationPath.Values)localObject).f);
        return true;
      }
    }
    return false;
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
    if (localListView != null) {
      localListView.removeOnLayoutChangeListener(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AIOAnimationConatiner.AIOAnimator localAIOAnimator = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator;
    if (localAIOAnimator != null) {
      localAIOAnimator.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator != null)
    {
      boolean bool;
      if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
        bool = false;
      } else {
        bool = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner$AIOAnimator.a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */