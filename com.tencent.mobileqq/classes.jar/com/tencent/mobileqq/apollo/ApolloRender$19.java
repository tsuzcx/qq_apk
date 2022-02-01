package com.tencent.mobileqq.apollo;

import android.view.View;
import android.widget.PopupWindow;

final class ApolloRender$19
  implements Runnable
{
  ApolloRender$19(ApolloRender paramApolloRender, View paramView, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.showAtLocation(this.jdField_a_of_type_AndroidViewView.getRootView(), 0, 0, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.update(0, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getWidth(), this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditWindow.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.19
 * JD-Core Version:    0.7.0.1
 */