package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FlashPicItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  FlashPicItemBuilder$3(FlashPicItemBuilder paramFlashPicItemBuilder, MessageForPic paramMessageForPic, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      FlashPicItemBuilder.a(this.c, this.a);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */