package com.tencent.imcore.message.facade;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.Map;
import mqq.app.AppRuntime;

public class MsgManagerProvider
  implements Provider<Map<Integer, BaseMessageManager>>
{
  private final Map<Integer, BaseMessageManager> a;
  
  public MsgManagerProvider(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    this.a = new MsgManagerProvider.1(this, paramAppRuntime, paramMsgPool);
  }
  
  public Map<Integer, BaseMessageManager> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.MsgManagerProvider
 * JD-Core Version:    0.7.0.1
 */