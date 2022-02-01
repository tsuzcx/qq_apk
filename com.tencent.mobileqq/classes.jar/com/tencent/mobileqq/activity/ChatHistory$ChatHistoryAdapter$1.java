package com.tencent.mobileqq.activity;

import aduc;
import adum;
import android.widget.TextView;
import bglf;
import bgnr;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(aduc paramaduc, int paramInt, String paramString, adum paramadum, TextView paramTextView) {}
  
  public void run()
  {
    String str = bglf.a(this.jdField_a_of_type_Aduc.a.app, this.jdField_a_of_type_Aduc.a.a, bgnr.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Adum.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Adum.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Aduc.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */