package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.data.ChatMessage;

public class DevPTTSupplier
  extends ItemBuilderSupplier
{
  protected ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new DevicePttItemBuilder(this.b, paramBaseAdapter, this.a, this.c, this.e, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.DevPTTSupplier
 * JD-Core Version:    0.7.0.1
 */