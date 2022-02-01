package com.tencent.mobileqq.apollo;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class ApolloRender$21
  implements Runnable
{
  ApolloRender$21(ApolloRender paramApolloRender, View paramView) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mShowEditWindow = true;
    try
    {
      ApolloRender.setVisiblePopEidtor(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("sava_ApolloRender", 1, "show editor err =" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.21
 * JD-Core Version:    0.7.0.1
 */