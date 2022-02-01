package com.tencent.mobileqq.activity;

import ador;
import adpb;
import android.widget.TextView;
import bhfj;
import com.tencent.mobileqq.utils.ContactUtils;

public class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$1(ador paramador, int paramInt, String paramString, adpb paramadpb, TextView paramTextView) {}
  
  public void run()
  {
    String str = ContactUtils.getNicknameInSession(this.jdField_a_of_type_Ador.a.app, this.jdField_a_of_type_Ador.a.a, bhfj.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Adpb.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Adpb.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_Ador.a.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */