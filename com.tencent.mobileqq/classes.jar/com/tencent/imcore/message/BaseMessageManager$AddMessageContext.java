package com.tencent.imcore.message;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.TroopInfoManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseMessageManager$AddMessageContext
{
  public ConversationFacade a;
  public FriendsManager a;
  public RecentUserProxy a;
  public TroopInfoManager a;
  public Map<String, RecentUser> a;
  public Map<String, MessageRecord> b = new HashMap();
  public Map<String, MessageRecord> c = new HashMap();
  public Map<String, MessageRecord> d = new HashMap();
  public Map<String, MessageRecord> e = new HashMap();
  public Map<String, List<MessageRecord>> f = new HashMap();
  public Map<String, List<MessageRecord>> g = new HashMap();
  
  public BaseMessageManager$AddMessageContext(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = paramQQAppInterface.getProxyManager().a();
    this.jdField_a_of_type_ComTencentImcoreMessageConversationFacade = paramQQAppInterface.getConversationFacade();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.AddMessageContext
 * JD-Core Version:    0.7.0.1
 */