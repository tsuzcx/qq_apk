package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

class HotChatAnnounceActivity$3
  implements TextWatcher
{
  HotChatAnnounceActivity$3(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if ((paramEditable != null) && (paramEditable.trim().length() > 0))
    {
      this.a.b.setEnabled(true);
      return;
    }
    this.a.b.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity.3
 * JD-Core Version:    0.7.0.1
 */