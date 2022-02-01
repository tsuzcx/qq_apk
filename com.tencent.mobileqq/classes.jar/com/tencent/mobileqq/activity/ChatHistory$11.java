package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class ChatHistory$11
  implements TextWatcher
{
  ChatHistory$11(ChatHistory paramChatHistory) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {}
    try
    {
      paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
    }
    catch (Exception localException1)
    {
      label29:
      break label29;
    }
    paramInt1 = this.a.r;
    if ((paramCharSequence.length() > 1) && (paramCharSequence.charAt(0) == '0')) {}
    for (paramCharSequence = String.valueOf(paramInt1);; paramCharSequence = String.valueOf(paramInt1))
    {
      for (;;)
      {
        paramInt2 = 1;
        break label71;
        paramInt2 = 0;
        label71:
        if ((paramInt1 < 1) || (paramInt1 > this.a.r) || (paramInt2 != 0)) {}
        try
        {
          this.a.o.setSelection(Math.max(0, paramCharSequence.length() - 1));
        }
        catch (Exception localException2)
        {
          label119:
          StringBuilder localStringBuilder;
          break label119;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("current s:");
        localStringBuilder.append(paramCharSequence);
        QLog.e("ChatHistory", 1, localStringBuilder.toString());
        this.a.o.setText(paramCharSequence.toString());
        paramCharSequence = this.a;
        if (paramInt1 >= paramCharSequence.r) {
          paramInt1 = this.a.r;
        }
        paramCharSequence.s = paramInt1;
        if (this.a.s >= this.a.r)
        {
          this.a.H.setEnabled(false);
          this.a.H.setImageResource(2130851647);
        }
        else
        {
          this.a.H.setEnabled(true);
          this.a.H.setImageResource(2130839236);
        }
        if (this.a.s <= 1)
        {
          this.a.G.setEnabled(false);
          this.a.G.setImageResource(2130841331);
          break label381;
        }
        this.a.G.setEnabled(true);
        this.a.G.setImageResource(2130839235);
        break label381;
        paramCharSequence = paramCharSequence.subSequence(0, paramCharSequence.length() - 1).toString();
        try
        {
          paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
        }
        catch (Exception paramCharSequence)
        {
          label365:
          break label365;
        }
      }
      paramInt1 = this.a.r;
    }
    label381:
    paramCharSequence = this.a;
    paramCharSequence.t = ((paramCharSequence.s - 1) * 8);
    this.a.j.a(this.a.e, this.a.f, this.a.t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.11
 * JD-Core Version:    0.7.0.1
 */