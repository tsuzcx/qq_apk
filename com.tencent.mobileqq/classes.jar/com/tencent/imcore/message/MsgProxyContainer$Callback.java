package com.tencent.imcore.message;

import java.util.List;

public abstract interface MsgProxyContainer$Callback
{
  public abstract BaseMsgProxy a(int paramInt, MsgProxyContainer paramMsgProxyContainer);
  
  public abstract List<MsgProxyContainer.SessionKey> a(MsgProxyContainer paramMsgProxyContainer);
  
  public abstract void a(long paramLong, MsgProxyContainer.SessionKey paramSessionKey, MsgProxyContainer paramMsgProxyContainer);
  
  public abstract void a(MsgProxyContainer paramMsgProxyContainer);
  
  public abstract void b(long paramLong, MsgProxyContainer.SessionKey paramSessionKey, MsgProxyContainer paramMsgProxyContainer);
  
  public abstract void b(MsgProxyContainer paramMsgProxyContainer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyContainer.Callback
 * JD-Core Version:    0.7.0.1
 */