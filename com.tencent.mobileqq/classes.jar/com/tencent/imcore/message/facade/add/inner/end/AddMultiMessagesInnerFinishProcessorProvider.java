package com.tencent.imcore.message.facade.add.inner.end;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.List;

public class AddMultiMessagesInnerFinishProcessorProvider
  implements Provider<List<IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>>>
{
  private final List<IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>> a = new AddMultiMessagesInnerFinishProcessorProvider.1(this);
  
  public List<IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.AddMultiMessagesInnerFinishProcessorProvider
 * JD-Core Version:    0.7.0.1
 */