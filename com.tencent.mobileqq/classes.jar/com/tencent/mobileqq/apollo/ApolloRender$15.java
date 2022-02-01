package com.tencent.mobileqq.apollo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ApolloRender$15
  implements View.OnClickListener
{
  ApolloRender$15(ApolloRender paramApolloRender, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.getText().toString();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setText("");
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.runRenderTask(new ApolloRender.15.1(this, str));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.15
 * JD-Core Version:    0.7.0.1
 */