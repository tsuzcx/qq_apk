package com.tencent.mobileqq.apollo.view;

import amje;
import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import java.lang.ref.WeakReference;

@TargetApi(11)
public class InputGlobalLayoutListener
  implements View.OnLayoutChangeListener, Runnable
{
  public int a;
  private WeakReference<BaseChatPie> a;
  
  public InputGlobalLayoutListener(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt2 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramInt2;
      paramView.post(this);
    }
    paramInt1 = 0;
    paramView = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramView != null)
    {
      if (paramView.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        paramInt1 = paramView.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight();
      }
      if (paramView.jdField_a_of_type_Amje != null) {
        paramView.jdField_a_of_type_Amje.a(paramInt1);
      }
    }
  }
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_Amje == null)) {
      return;
    }
    localBaseChatPie.jdField_a_of_type_Amje.c(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener
 * JD-Core Version:    0.7.0.1
 */