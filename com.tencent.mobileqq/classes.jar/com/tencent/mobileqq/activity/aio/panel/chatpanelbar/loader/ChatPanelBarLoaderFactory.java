package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarContext;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.BizCrmExtTmpLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.BuluoLbsTmpLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.C2CPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.CmGameTmpPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.ConfessPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DataLineIPadLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DataLinePanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DataLinePcLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DatePanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DefaultPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DeviceMsgPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.DiscussionPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GameMsgPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GroupPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GuildPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.HotChatStrangerLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.MatchChatBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.MovieTicketTmpPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.PublicAccountLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.StrangerFriendLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.TmpPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.ValidationTmpPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.Wpa3PartyLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatPanelBarLoaderFactory
{
  List<IChatPanelBarLoader> a;
  private IChatPanelBarLoader b;
  private ChatPanelBarContext c;
  
  public ChatPanelBarLoaderFactory(ChatPanelBarContext paramChatPanelBarContext)
  {
    this.c = paramChatPanelBarContext;
    a();
  }
  
  private void a()
  {
    this.a = new ArrayList();
    this.a.add(new DiscussionPanelBarLoader(this.c));
    this.a.add(new GroupPanelBarLoader(this.c));
    this.a.add(new TmpPanelBarLoader(this.c));
    this.a.add(new DataLinePanelBarLoader(this.c));
    this.a.add(new ValidationTmpPanelBarLoader(this.c));
    this.a.add(new ConfessPanelBarLoader(this.c));
    this.a.add(new CmGameTmpPanelBarLoader(this.c));
    this.a.add(new MovieTicketTmpPanelBarLoader(this.c));
    this.a.add(new DeviceMsgPanelBarLoader(this.c));
    this.a.add(new HotChatStrangerLoader(this.c));
    this.a.add(new PublicAccountLoader(this.c));
    this.a.add(new StrangerFriendLoader(this.c));
    this.a.add(new DatePanelBarLoader(this.c));
    this.a.add(new BuluoLbsTmpLoader(this.c));
    this.a.add(new DataLinePcLoader(this.c));
    this.a.add(new DataLineIPadLoader(this.c));
    this.a.add(new Wpa3PartyLoader(this.c));
    this.a.add(new BizCrmExtTmpLoader(this.c));
    this.a.add(new MatchChatBarLoader(this.c));
    this.a.add(new GuildPanelBarLoader(this.c));
    this.a.add(new C2CPanelBarLoader(this.c));
    this.a.add(new GameMsgPanelBarLoader(this.c));
    this.b = new DefaultPanelBarLoader(this.c);
  }
  
  public IChatPanelBarLoader a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      IChatPanelBarLoader localIChatPanelBarLoader = (IChatPanelBarLoader)localIterator.next();
      if (localIChatPanelBarLoader.f(paramQQAppInterface, paramSessionInfo, paramBaseChatPie)) {
        return localIChatPanelBarLoader;
      }
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.ChatPanelBarLoaderFactory
 * JD-Core Version:    0.7.0.1
 */