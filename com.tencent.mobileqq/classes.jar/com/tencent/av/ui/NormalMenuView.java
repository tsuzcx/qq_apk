package com.tencent.av.ui;

import android.animation.ObjectAnimator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
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
    this.jdField_a_of_type_JavaLangString = ("MenuView_" + paramInt);
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
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    label195:
    label226:
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("ShowMenuView, isShow[").append(this.jdField_a_of_type_Boolean).append("], needAnimation[").append(paramBoolean).append("], lastObjectAnimator[");
      boolean bool;
      int i;
      if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
      {
        bool = true;
        QLog.w((String)localObject, 1, bool + "], visibility[" + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() + "], seq[" + paramLong + "]");
        a();
        if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent != null) {
          this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
        }
        if (!paramBoolean) {
          break label268;
        }
        i = b();
        localObject = null;
        if (paramInt != 3) {
          break label195;
        }
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "TranslationY", new float[] { i, 0.0F });
      }
      for (;;)
      {
        if (localObject != null) {
          break label226;
        }
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "ShowMenuView, warning animator is null");
        return;
        bool = false;
        break;
        if (paramInt == 4) {
          localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
        }
      }
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).addListener(new NormalMenuView.2(this, i, paramLong));
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ((ObjectAnimator)localObject);
      ((ObjectAnimator)localObject).start();
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent == null);
    label268:
    this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.a(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, QavPanel.OnDismissAnimationEndListener paramOnDismissAnimationEndListener)
  {
    int i = 4;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("HiddenMenuView, isShow[").append(this.jdField_a_of_type_Boolean).append("], needAnimation[").append(paramBoolean).append("], visibility[").append(i).append("], lastObjectAnimator[");
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "], seq[" + paramLong + "]");
      a();
      if (!paramBoolean) {
        break label320;
      }
      i = b();
      localObject = null;
      if (paramInt == 2) {
        localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "TranslationY", new float[] { 0.0F, i });
      }
      if (localObject != null) {
        break;
      }
      if (!AudioHelper.d()) {
        break label319;
      }
      paramOnDismissAnimationEndListener = HardCodeUtil.a(2131708921) + this.jdField_a_of_type_Boolean + "], height[" + i + "], seq[" + paramLong + "]";
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, paramOnDismissAnimationEndListener, new Throwable("打印调用栈"));
      throw new IllegalArgumentException(paramOnDismissAnimationEndListener);
    }
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).addListener(new NormalMenuView.1(this, i, paramLong, paramOnDismissAnimationEndListener));
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ((ObjectAnimator)localObject);
    ((ObjectAnimator)localObject).start();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent != null) {
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
    }
    label319:
    label320:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent != null) {
        this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_Boolean = false;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent == null);
    this.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.b(paramLong, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
  }
  
  int b()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.measure(0, 0);
      i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView
 * JD-Core Version:    0.7.0.1
 */