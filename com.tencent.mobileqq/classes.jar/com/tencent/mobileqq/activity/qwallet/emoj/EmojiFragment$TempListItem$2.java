package com.tencent.mobileqq.activity.qwallet.emoj;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import aywn;
import com.tencent.image.URLDrawable;

class EmojiFragment$TempListItem$2
  extends aywn
{
  EmojiFragment$TempListItem$2(EmojiFragment.TempListItem paramTempListItem, EmojiFragment.TemplateInfo paramTemplateInfo) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    EmojiFragment.TempListItem.access$200(this.this$1).setImageDrawable(null);
    EmojiFragment.TempListItem.access$300(this.this$1).setBackgroundDrawable(this.this$1.getResources().getDrawable(2130842933));
    EmojiFragment.TempListItem.access$400(this.this$1).setVisibility(8);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    EmojiFragment.TempListItem.access$300(this.this$1).setBackgroundDrawable(null);
    EmojiFragment.TempListItem.access$400(this.this$1).setVisibility(0);
    this.this$1.this$0.handleDrawableSucc(paramURLDrawable, this.val$data.isSelected, this.val$data.rId, EmojiFragment.TempListItem.access$200(this.this$1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment.TempListItem.2
 * JD-Core Version:    0.7.0.1
 */