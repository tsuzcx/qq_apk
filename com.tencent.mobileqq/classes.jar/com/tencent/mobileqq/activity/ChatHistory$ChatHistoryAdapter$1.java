package com.tencent.mobileqq.activity;

import acms;
import acnc;
import android.widget.TextView;
import bdgc;
import bdil;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(acms paramacms, int paramInt, String paramString, acnc paramacnc, TextView paramTextView) {}
  
  public void run()
  {
    String str = bdgc.a(this.jdField_a_of_type_Acms.a.app, this.jdField_a_of_type_Acms.a.a, bdil.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Acnc.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Acnc.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Acms.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */