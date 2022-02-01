package com.tencent.imcore.message.core.codec;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import msf.msgsvc.msg_svc.RoutingHead;

public abstract interface RoutingType<T extends AppInterface>
{
  public abstract int a();
  
  public abstract boolean a();
  
  public abstract boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, T paramT);
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.RoutingType
 * JD-Core Version:    0.7.0.1
 */