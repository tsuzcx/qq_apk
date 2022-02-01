package com.tencent.imcore.message.facade.unread.filter;

import java.util.ArrayList;

class UnreadMsgFilterProvider$1
  extends ArrayList<UnreadMsgFilter>
{
  UnreadMsgFilterProvider$1(UnreadMsgFilterProvider paramUnreadMsgFilterProvider)
  {
    add(new NullCheckFilter());
    add(new TroopNotificationFilter());
    add(new NotDisturbFilter());
    add(new HiddenChatFilter());
    add(new KanDianFilter());
    add(new LSBHelloFilter());
    add(new KanDianMergeFilter());
    add(new ServiceAccountPAFilter());
    add(new ConfessFilter());
    add(new MatchCampusFilter());
    add(new CMGameFilter());
    add(new MiniProgramNotShowInTabFilter());
    add(new SubAccountAssistantFilter());
    add(new MiniProgramFilter());
    add(new TempGameFilter());
    add(new KanDianPrivateMsgFilter());
    add(new PublicAccountFilter());
    add(new DefaultFilter());
    add(new GuildMsgFilter());
    add(new GameMsgUnreadFilter());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.UnreadMsgFilterProvider.1
 * JD-Core Version:    0.7.0.1
 */