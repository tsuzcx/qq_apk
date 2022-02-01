package com.tencent.imcore.message.facade.unread.filter;

import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;

public class UnreadMsgFilterProvider
  implements Provider<List<UnreadMsgFilter>>
{
  private final List<UnreadMsgFilter> a = new UnreadMsgFilterProvider.1(this);
  
  public List<UnreadMsgFilter> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.filter.UnreadMsgFilterProvider
 * JD-Core Version:    0.7.0.1
 */