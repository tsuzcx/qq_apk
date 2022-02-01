package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class BusinessEggsElement
{
  public long a;
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private BusinessEggsElement.IPathStrategy jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsElement$IPathStrategy;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  private Point b;
  private Point c;
  
  public BusinessEggsElement(AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.c = new Point(ViewUtils.a(), ViewUtils.b());
  }
  
  private View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable == null)
      {
        QLog.e("BusinessEggsElement", 1, "[createEggsView] drawable is null, cannot create view");
        return null;
      }
      this.jdField_a_of_type_AndroidViewView = a(localDrawable);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  private View a(Drawable paramDrawable)
  {
    View localView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
    localView.setBackgroundDrawable(paramDrawable);
    Rect localRect = paramDrawable.getBounds();
    if (localRect.isEmpty()) {
      localView.layout(0, 0, paramDrawable.getIntrinsicWidth() / 2, paramDrawable.getIntrinsicHeight() / 2);
    } else {
      localView.layout(0, 0, localRect.width() / 2, localRect.height() / 2);
    }
    localView.setScaleX(1.0F);
    localView.setScaleY(1.0F);
    localView.setLayerType(2, null);
    return localView;
  }
  
  private void a(float paramFloat)
  {
    BusinessEggsElement.IPathStrategy localIPathStrategy = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsElement$IPathStrategy;
    if (localIPathStrategy != null)
    {
      this.b = localIPathStrategy.a(this.jdField_a_of_type_AndroidGraphicsPoint, this.c, paramFloat);
      a(this.b);
    }
  }
  
  private void a(Point paramPoint)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (paramPoint == null) {
        return;
      }
      int i = localView.getLeft();
      int j = this.jdField_a_of_type_AndroidViewView.getWidth() / 2;
      int k = this.jdField_a_of_type_AndroidViewView.getBottom();
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramPoint.y - k);
      this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(paramPoint.x - (i + j));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      d();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new BusinessEggsElement.1(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessEggsElement", 2, "[start] eggs animating, return");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsElement$IPathStrategy;
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessEggsElement", 2, "[start] mEggsView is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout((View)localObject, -1, AIOAnimationConatiner.a, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsElement$IPathStrategy.a(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    this.jdField_a_of_type_AndroidGraphicsPoint = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsElement$IPathStrategy.a(this.c);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[start] start eggs: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      QLog.d("BusinessEggsElement", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    c();
    this.jdField_a_of_type_AndroidViewView = a();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(BusinessEggsElement.IPathStrategy paramIPathStrategy)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsElement$IPathStrategy = paramIPathStrategy;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[stop] stop eggs: ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.d("BusinessEggsElement", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsElement
 * JD-Core Version:    0.7.0.1
 */