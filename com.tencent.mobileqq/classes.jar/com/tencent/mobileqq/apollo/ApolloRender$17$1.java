package com.tencent.mobileqq.apollo;

import aitd;
import android.text.Editable;

public class ApolloRender$17$1
  extends IApolloRunnableTask
{
  public ApolloRender$17$1(aitd paramaitd, Editable paramEditable) {}
  
  public String a()
  {
    return "afterTextChanged";
  }
  
  public void run()
  {
    ApolloRender localApolloRender = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender();
    if ((localApolloRender != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorAddr != 0L)) {
      localApolloRender.getSavaWrapper().a(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorAddr, this.a.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.17.1
 * JD-Core Version:    0.7.0.1
 */