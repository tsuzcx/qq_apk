package com.tencent.imcore.message.facade.msg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.ILastMsgGetter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.Map;

public class LastMsgGetterProvider
  implements Provider<Map<Integer, ILastMsgGetter<QQMessageFacade, QQAppInterface>>>
{
  private final Map<Integer, ILastMsgGetter<QQMessageFacade, QQAppInterface>> a = new LastMsgGetterProvider.1(this);
  
  public Map<Integer, ILastMsgGetter<QQMessageFacade, QQAppInterface>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.LastMsgGetterProvider
 * JD-Core Version:    0.7.0.1
 */