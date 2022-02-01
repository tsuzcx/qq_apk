package com.tencent.mobileqq.activity;

import aede;
import aedo;
import android.widget.TextView;
import bhlg;
import bhnt;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(aede paramaede, int paramInt, String paramString, aedo paramaedo, TextView paramTextView) {}
  
  public void run()
  {
    String str = bhlg.a(this.jdField_a_of_type_Aede.a.app, this.jdField_a_of_type_Aede.a.a, bhnt.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Aedo.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Aedo.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Aede.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */