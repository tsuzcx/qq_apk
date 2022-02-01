package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MarketFaceItemBuilder$11
  implements ActionSheet.OnButtonClickListener
{
  MarketFaceItemBuilder$11(MarketFaceItemBuilder paramMarketFaceItemBuilder, IPicEmoticonInfo paramIPicEmoticonInfo, ActionSheet paramActionSheet, MessageForMarketFace paramMessageForMarketFace) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ChatActivityFacade.a(this.d.d, this.d.A, this.d.f, this.a.getEmoticon(), this.c.uniseq);
      this.b.cancel();
      return;
    }
    boolean bool1;
    if (this.a.getEmoticon().jobType == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (this.a.getEmoticon().jobType == 3) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.d.A, this.d.d.getAccount(), 8, this.a.getEmoticon().epId, bool1, bool2);
    this.b.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */