package com.tencent.mobileqq.apollo;

import android.text.Editable;
import android.text.TextWatcher;

final class ApolloRender$16
  implements TextWatcher
{
  ApolloRender$16(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.runRenderTask(new ApolloRender.16.1(this, paramEditable));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.16
 * JD-Core Version:    0.7.0.1
 */