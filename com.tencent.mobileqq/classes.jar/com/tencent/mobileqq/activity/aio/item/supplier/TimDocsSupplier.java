package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

public class TimDocsSupplier
  extends ItemBuilderSupplier
{
  protected boolean a()
  {
    return false;
  }
  
  protected ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new FileTimDocGrayTipsItemBuilder(this.b, paramBaseAdapter, this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.TimDocsSupplier
 * JD-Core Version:    0.7.0.1
 */