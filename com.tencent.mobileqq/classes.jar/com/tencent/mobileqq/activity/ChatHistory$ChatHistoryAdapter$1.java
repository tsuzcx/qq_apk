package com.tencent.mobileqq.activity;

import acyf;
import acyp;
import android.widget.TextView;
import bfwr;
import com.tencent.mobileqq.utils.ContactUtils;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(acyf paramacyf, int paramInt, String paramString, acyp paramacyp, TextView paramTextView) {}
  
  public void run()
  {
    String str = ContactUtils.getNicknameInSession(this.jdField_a_of_type_Acyf.a.app, this.jdField_a_of_type_Acyf.a.a, bfwr.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Acyp.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Acyp.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Acyf.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */