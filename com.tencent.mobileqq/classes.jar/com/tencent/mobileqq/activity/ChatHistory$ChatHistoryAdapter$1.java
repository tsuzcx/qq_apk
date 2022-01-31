package com.tencent.mobileqq.activity;

import aarj;
import aart;
import android.widget.TextView;
import bbcl;
import bbet;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(aarj paramaarj, int paramInt, String paramString, aart paramaart, TextView paramTextView) {}
  
  public void run()
  {
    String str = bbcl.a(this.jdField_a_of_type_Aarj.a.app, this.jdField_a_of_type_Aarj.a.a, bbet.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Aart.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Aart.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Aarj.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */