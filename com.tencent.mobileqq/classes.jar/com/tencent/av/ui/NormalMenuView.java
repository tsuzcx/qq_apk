package com.tencent.av.ui;

import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class NormalMenuView
{
  int jdField_a_of_type_Int;
  ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  NormalMenuView.ViewEvent jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent = null;
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  
  public NormalMenuView(RelativeLayout paramRelativeLayout, int paramInt, NormalMenuView.ViewEvent paramViewEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MenuView_");
    localStringBuilder.append(paramInt);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent = paramViewEvent;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  void a()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowMenuView, isShow[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], needAnimation[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], lastObjectAnimator[");
    boolean bool;
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    a();
    localObject = this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent;
    if (localObject != null) {
      ((NormalMenuView.ViewEvent)localObject).a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
    }
    if (paramBoolean)
    {
      int i = b();
      localObject = null;
      if (paramInt == 3) {
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "TranslationY", new float[] { i, 0.0F });
      } else if (paramInt == 4) {
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
      }
      if (localObject == null)
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "ShowMenuView, warning animator is null");
        return;
      }
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).addListener(new NormalMenuView.2(this, i, paramLong));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ((ObjectAnimator)localObject);
      ((ObjectAnimator)localObject).start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
    localObject = this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent;
    if (localObject != null) {
      ((NormalMenuView.ViewEvent)localObject).a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, QavPanel.OnDismissAnimationEndListener paramOnDismissAnimationEndListener)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i;
    if (localObject != null) {
      i = ((RelativeLayout)localObject).getVisibility();
    } else {
      i = 4;
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiddenMenuView, isShow[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], needAnimation[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], lastObjectAnimator[");
    boolean bool;
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    a();
    if (paramBoolean)
    {
      i = b();
      localObject = null;
      if (paramInt == 2) {
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "TranslationY", new float[] { 0.0F, i });
      }
      if (localObject == null)
      {
        if (!AudioHelper.a()) {
          return;
        }
        paramOnDismissAnimationEndListener = new StringBuilder();
        paramOnDismissAnimationEndListener.append(HardCodeUtil.a(2131708927));
        paramOnDismissAnimationEndListener.append(this.jdField_a_of_type_Boolean);
        paramOnDismissAnimationEndListener.append("], height[");
        paramOnDismissAnimationEndListener.append(i);
        paramOnDismissAnimationEndListener.append("], seq[");
        paramOnDismissAnimationEndListener.append(paramLong);
        paramOnDismissAnimationEndListener.append("]");
        paramOnDismissAnimationEndListener = paramOnDismissAnimationEndListener.toString();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, paramOnDismissAnimationEndListener, new Throwable("打印调用栈"));
        throw new IllegalArgumentException(paramOnDismissAnimationEndListener);
      }
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).addListener(new NormalMenuView.1(this, i, paramLong, paramOnDismissAnimationEndListener));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ((ObjectAnimator)localObject);
      ((ObjectAnimator)localObject).start();
      this.jdField_a_of_type_Boolean = false;
      paramOnDismissAnimationEndListener = this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent;
      if (paramOnDismissAnimationEndListener != null) {
        paramOnDismissAnimationEndListener.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      }
    }
    else
    {
      paramOnDismissAnimationEndListener = this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent;
      if (paramOnDismissAnimationEndListener != null) {
        paramOnDismissAnimationEndListener.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      }
      paramOnDismissAnimationEndListener = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (paramOnDismissAnimationEndListener != null)
      {
        paramOnDismissAnimationEndListener.setVisibility(8);
        this.jdField_a_of_type_Boolean = false;
      }
      paramOnDismissAnimationEndListener = this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent;
      if (paramOnDismissAnimationEndListener != null) {
        paramOnDismissAnimationEndListener.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      }
    }
  }
  
  int b()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i = 0;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.measure(0, 0);
      i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView
 * JD-Core Version:    0.7.0.1
 */