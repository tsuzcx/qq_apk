package com.tencent.mobileqq.apollo;

import android.widget.EditText;

final class ApolloRender$24
  implements Runnable
{
  ApolloRender$24(ApolloRender paramApolloRender, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.getText().toString().compareToIgnoreCase(this.jdField_a_of_type_JavaLangString) != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorPop.setSelection(this.jdField_a_of_type_JavaLangString.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.24
 * JD-Core Version:    0.7.0.1
 */