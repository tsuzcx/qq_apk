package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShortVideoPTVItemBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoPTVItemBuilder$1(ShortVideoPTVItemBuilder paramShortVideoPTVItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoPTVItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (this.a.uiOperatorFlag == 2) {
        this.d.b(this.a, this.b);
      } else {
        this.d.a(this.a, this.b);
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */