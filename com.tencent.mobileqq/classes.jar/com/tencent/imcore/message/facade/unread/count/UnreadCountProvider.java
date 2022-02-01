package com.tencent.imcore.message.facade.unread.count;

import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;

public class UnreadCountProvider
  implements Provider<List<UnreadCountCalculateStrategy>>
{
  private final List<UnreadCountCalculateStrategy> a = new UnreadCountProvider.1(this);
  
  public List<UnreadCountCalculateStrategy> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.unread.count.UnreadCountProvider
 * JD-Core Version:    0.7.0.1
 */