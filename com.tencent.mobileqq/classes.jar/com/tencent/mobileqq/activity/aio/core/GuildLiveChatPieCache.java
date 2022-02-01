package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.core.chatpiecreator.GuildLiveChatPieCreatorFactory;
import com.tencent.mobileqq.activity.aio.core.chatpiecreator.IChatPieCreator;

public class GuildLiveChatPieCache
  extends ChatPieCache
{
  protected IChatPieCreator a(int paramInt)
  {
    return GuildLiveChatPieCreatorFactory.b().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.GuildLiveChatPieCache
 * JD-Core Version:    0.7.0.1
 */