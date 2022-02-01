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
  public Map<String, RecentUser> a = new HashMap();
  public Map<String, MessageRecord> b = new HashMap();
  public Map<String, MessageRecord> c = new HashMap();
  public Map<String, MessageRecord> d = new HashMap();
  public Map<String, MessageRecord> e = new HashMap();
  public Map<String, List<MessageRecord>> f = new HashMap();
  public Map<String, List<MessageRecord>> g = new HashMap();
  public Map<String, MessageRecord> h = new HashMap();
  public Manager i;
  public Manager j;
  public RecentUserProxy k;
  public IConversationFacade l;
  
  public BaseMessageManager$AddMessageContext(AppRuntime paramAppRuntime)
  {
    this.i = BaseMessageManager.e.a(paramAppRuntime);
    this.j = BaseMessageManager.e.b(paramAppRuntime);
    this.k = ((IRecentUserProxyService)paramAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    this.l = ((IConversationFacade)paramAppRuntime.getRuntimeService(IConversationFacade.class, ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.AddMessageContext
 * JD-Core Version:    0.7.0.1
 */