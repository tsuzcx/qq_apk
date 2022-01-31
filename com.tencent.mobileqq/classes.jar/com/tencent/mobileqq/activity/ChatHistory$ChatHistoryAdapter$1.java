package com.tencent.mobileqq.activity;

import acid;
import acin;
import android.widget.TextView;
import bdbt;
import bdec;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(acid paramacid, int paramInt, String paramString, acin paramacin, TextView paramTextView) {}
  
  public void run()
  {
    String str = bdbt.a(this.jdField_a_of_type_Acid.a.app, this.jdField_a_of_type_Acid.a.a, bdec.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Acin.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Acin.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Acid.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */