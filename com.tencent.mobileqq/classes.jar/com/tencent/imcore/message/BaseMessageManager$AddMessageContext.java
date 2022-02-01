package com.tencent.imcore.message;

import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class BaseMessageManager$AddMessageContext
{
  public RecentUserProxy a;
  public IConversationFacade a;
  public Map<String, RecentUser> a;
  public Manager a;
  public Map<String, MessageRecord> b = new HashMap();
  public Map<String, MessageRecord> c = new HashMap();
  public Map<String, MessageRecord> d = new HashMap();
  public Map<String, MessageRecord> e = new HashMap();
  public Map<String, List<MessageRecord>> f = new HashMap();
  public Map<String, List<MessageRecord>> g = new HashMap();
  
  public BaseMessageManager$AddMessageContext(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_MqqManagerManager = BaseMessageManager.a.a(paramAppRuntime);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = ((IRecentUserProxyService)paramAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIConversationFacade = ((IConversationFacade)paramAppRuntime.getRuntimeService(IConversationFacade.class, ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.AddMessageContext
 * JD-Core Version:    0.7.0.1
 */