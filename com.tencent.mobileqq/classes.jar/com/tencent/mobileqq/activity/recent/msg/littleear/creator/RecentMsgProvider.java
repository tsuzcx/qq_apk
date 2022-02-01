package com.tencent.mobileqq.activity.recent.msg.littleear.creator;

import com.tencent.mobileqq.activity.recent.msg.AbstructRecentUserMsg;
import com.tencent.mobileqq.activity.recent.msg.RecentMsgProxy;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class RecentMsgProvider
  implements Provider<RecentMsgProxy>
{
  private AbstructRecentUserMsg a;
  
  RecentMsgProvider(AbstructRecentUserMsg paramAbstructRecentUserMsg)
  {
    this.a = paramAbstructRecentUserMsg;
  }
  
  public RecentMsgProxy<AbstructRecentUserMsg> a()
  {
    return new RecentMsgProvider.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.littleear.creator.RecentMsgProvider
 * JD-Core Version:    0.7.0.1
 */