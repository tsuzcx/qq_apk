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
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GameBuddyLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GroupPanelBarLoader;
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
  private ChatPanelBarContext jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext;
  private IChatPanelBarLoader jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader;
  List<IChatPanelBarLoader> jdField_a_of_type_JavaUtilList;
  
  public ChatPanelBarLoaderFactory(ChatPanelBarContext paramChatPanelBarContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext = paramChatPanelBarContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new DiscussionPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new GroupPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new TmpPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new DataLinePanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new ValidationTmpPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new ConfessPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new CmGameTmpPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new MovieTicketTmpPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new DeviceMsgPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new HotChatStrangerLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new PublicAccountLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new StrangerFriendLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new DatePanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new BuluoLbsTmpLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new DataLinePcLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new DataLineIPadLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new Wpa3PartyLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new BizCrmExtTmpLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new GameBuddyLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new MatchChatBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_JavaUtilList.add(new C2CPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader = new DefaultPanelBarLoader(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarChatPanelBarContext);
  }
  
  public IChatPanelBarLoader a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      IChatPanelBarLoader localIChatPanelBarLoader = (IChatPanelBarLoader)localIterator.next();
      if (localIChatPanelBarLoader.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie)) {
        return localIChatPanelBarLoader;
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarLoaderIChatPanelBarLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.ChatPanelBarLoaderFactory
 * JD-Core Version:    0.7.0.1
 */