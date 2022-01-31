package com.tencent.mobileqq.activity;

import aarf;
import aarp;
import android.widget.TextView;
import bbcz;
import bbfh;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(aarf paramaarf, int paramInt, String paramString, aarp paramaarp, TextView paramTextView) {}
  
  public void run()
  {
    String str = bbcz.a(this.jdField_a_of_type_Aarf.a.app, this.jdField_a_of_type_Aarf.a.a, bbfh.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Aarp.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Aarp.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Aarf.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */