package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.activity.aio.item.AutoReplyTextItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

public class AutoReplySupplier
  extends ItemBuilderSupplier
{
  protected ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new AutoReplyTextItemBuilder(this.b, paramBaseAdapter, this.a, this.c, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.AutoReplySupplier
 * JD-Core Version:    0.7.0.1
 */