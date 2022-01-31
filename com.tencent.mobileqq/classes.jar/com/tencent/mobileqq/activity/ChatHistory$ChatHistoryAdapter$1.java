package com.tencent.mobileqq.activity;

import aahr;
import aaib;
import android.widget.TextView;
import babh;
import bado;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(aahr paramaahr, int paramInt, String paramString, aaib paramaaib, TextView paramTextView) {}
  
  public void run()
  {
    String str = babh.a(this.jdField_a_of_type_Aahr.a.app, this.jdField_a_of_type_Aahr.a.a, bado.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Aaib.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Aaib.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Aahr.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */