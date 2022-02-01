package com.tencent.imcore.message.facade.add.inner;

import com.tencent.imcore.message.facade.IAddMultiMessagesInnerProcessor;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;

public class AddMultiMsgProcessorProvider
  implements Provider<List<IAddMultiMessagesInnerProcessor>>
{
  private final List<IAddMultiMessagesInnerProcessor> a = new AddMultiMsgProcessorProvider.1(this);
  
  public List<IAddMultiMessagesInnerProcessor> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.AddMultiMsgProcessorProvider
 * JD-Core Version:    0.7.0.1
 */