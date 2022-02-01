package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.IReloadFilter;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.utils.StartupTracker;
import java.util.List;

public class StickerReloadFilter
  implements IReloadFilter
{
  public List<ChatMessage> a(AIOContext paramAIOContext, List<ChatMessage> paramList)
  {
    StartupTracker.a(null, "AIO_BaseChatPie_Remove_Sticker_Cost");
    EmojiStickerManager.a().a((BaseChatPie)paramAIOContext.a(), paramList);
    StartupTracker.a("AIO_BaseChatPie_Remove_Sticker_Cost", null);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.StickerReloadFilter
 * JD-Core Version:    0.7.0.1
 */