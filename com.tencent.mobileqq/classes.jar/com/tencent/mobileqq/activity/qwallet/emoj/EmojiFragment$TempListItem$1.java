package com.tencent.mobileqq.activity.qwallet.emoj;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

class EmojiFragment$TempListItem$1
  implements View.OnClickListener
{
  EmojiFragment$TempListItem$1(EmojiFragment.TempListItem paramTempListItem, EmojiFragment.TemplateInfo paramTemplateInfo) {}
  
  public void onClick(View paramView)
  {
    this.this$1.this$0.availableRight = 0;
    EmojiFragment.access$100(this.this$1.this$0).c("phiz.wrappacket.choosephiz");
    this.this$1.this$0.onTempSelected(this.val$data, EmojiFragment.TempListItem.access$200(this.this$1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.TempListItem.1
 * JD-Core Version:    0.7.0.1
 */