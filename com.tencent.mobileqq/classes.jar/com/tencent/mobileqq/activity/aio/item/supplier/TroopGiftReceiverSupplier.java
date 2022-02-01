package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgItemRecieverBuilder;
import com.tencent.mobileqq.data.ChatMessage;

public class TroopGiftReceiverSupplier
  extends ItemBuilderSupplier
{
  protected ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new TroopGiftMsgItemBuilder.TroopGiftMsgItemRecieverBuilder(this.b, paramBaseAdapter, this.a, this.c, this.e, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.TroopGiftReceiverSupplier
 * JD-Core Version:    0.7.0.1
 */