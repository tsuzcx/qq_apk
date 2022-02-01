package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

final class MarketFaceItemBuilder$17
  implements DialogInterface.OnClickListener
{
  MarketFaceItemBuilder$17(Emoticon paramEmoticon, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool;
    if (this.a.jobType == 4) {
      bool = true;
    } else {
      bool = false;
    }
    EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.b, this.c.getAccount(), 8, this.a.epId, false, bool);
    if (MarketFaceItemBuilder.x != null)
    {
      paramInt = this.d;
      if (7 == paramInt)
      {
        MarketFaceItemBuilder.a(this.c, MarketFaceItemBuilder.x.frienduin, "ep_mall", "Clk_pkg_forward", 0);
        return;
      }
      if (6 == paramInt) {
        MarketFaceItemBuilder.a(this.c, MarketFaceItemBuilder.x.frienduin, "ep_mall", "Clk_collect_more", 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.17
 * JD-Core Version:    0.7.0.1
 */