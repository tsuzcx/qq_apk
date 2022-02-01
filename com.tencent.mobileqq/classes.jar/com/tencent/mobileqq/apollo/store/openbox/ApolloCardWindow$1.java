package com.tencent.mobileqq.apollo.store.openbox;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class ApolloCardWindow$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ApolloCardWindow$1(ApolloCardWindow paramApolloCardWindow, TextView paramTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (localTextView == ApolloCardWindow.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ApolloBoxData.c(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == ApolloCardWindow.b(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ApolloBoxData.b(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
        return;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == ApolloCardWindow.c(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ApolloBoxData.a(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.1
 * JD-Core Version:    0.7.0.1
 */