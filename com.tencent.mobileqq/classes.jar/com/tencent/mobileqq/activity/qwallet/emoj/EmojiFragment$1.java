package com.tencent.mobileqq.activity.qwallet.emoj;

import ahaa;
import android.text.Editable;
import android.widget.EditText;

class EmojiFragment$1
  extends ahaa
{
  EmojiFragment$1(EmojiFragment paramEmojiFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.this$0.mAmoutTxt != null) && (this.this$0.mAmoutTxt.getText() != null) && (EmojiFragment.access$000(this.this$0, this.this$0.mAmoutTxt.getText().toString()))) {
      this.this$0.freshConfirmBtn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.1
 * JD-Core Version:    0.7.0.1
 */