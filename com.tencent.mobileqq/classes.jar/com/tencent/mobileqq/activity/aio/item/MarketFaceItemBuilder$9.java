package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;

class MarketFaceItemBuilder$9
  implements DialogInterface.OnClickListener
{
  MarketFaceItemBuilder$9(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(this.b.d, this.b.A, this.b.f, this.a.a.getEmoticon(), this.a.q.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */