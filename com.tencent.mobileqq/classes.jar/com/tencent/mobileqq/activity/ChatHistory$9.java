package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistory$9
  implements View.OnClickListener
{
  ChatHistory$9(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (this.a.s > 1)
    {
      this.a.H.setEnabled(true);
      this.a.H.setImageResource(2130839236);
      ChatHistory localChatHistory = this.a;
      localChatHistory.s -= 1;
      if (this.a.s <= 1)
      {
        this.a.G.setEnabled(false);
        this.a.G.setImageResource(2130841331);
      }
      localChatHistory = this.a;
      localChatHistory.t = ((localChatHistory.s - 1) * 8);
      this.a.j.a(this.a.e, this.a.f, this.a.t);
      this.a.o.setText(String.valueOf(this.a.s));
      this.a.o.setSelection(this.a.o.getText().length());
      this.a.v();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.9
 * JD-Core Version:    0.7.0.1
 */