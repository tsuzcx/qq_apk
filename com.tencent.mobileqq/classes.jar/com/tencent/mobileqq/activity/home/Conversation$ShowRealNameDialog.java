package com.tencent.mobileqq.activity.home;

import android.app.Dialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;

class Conversation$ShowRealNameDialog
{
  private final String jdField_a_of_type_JavaLangString;
  private final String b;
  private final String c;
  
  public Conversation$ShowRealNameDialog(Conversation paramConversation, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public void a()
  {
    Conversation.ShowRealNameDialog.1 local1 = new Conversation.ShowRealNameDialog.1(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), 230, this.jdField_a_of_type_JavaLangString, this.b, HardCodeUtil.a(2131702633), HardCodeUtil.a(2131702637), local1, local1);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.ShowRealNameDialog
 * JD-Core Version:    0.7.0.1
 */