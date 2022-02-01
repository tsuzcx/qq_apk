package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.TextView;

class HotChatAnnounceActivity$2
  implements TextWatcher
{
  HotChatAnnounceActivity$2(HotChatAnnounceActivity paramHotChatAnnounceActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    int i;
    if (!TextUtils.isEmpty(paramEditable)) {
      i = paramEditable.getBytes().length / 3;
    } else {
      i = 0;
    }
    if (i <= 40) {
      this.a.a.setTextColor(this.a.getResources().getColor(2131167138));
    } else {
      this.a.a.setTextColor(-65536);
    }
    paramEditable = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(40 - i);
    paramEditable.setText(localStringBuilder.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity.2
 * JD-Core Version:    0.7.0.1
 */