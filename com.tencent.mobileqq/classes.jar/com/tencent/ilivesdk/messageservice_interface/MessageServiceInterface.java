package com.tencent.ilivesdk.messageservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.messageservice_interface.model.MessageData;

public abstract interface MessageServiceInterface
  extends ServiceBaseInterface
{
  public static final int DEFAULT_SEND = 0;
  public static final int SEND_LOCAL_ONLY = 2;
  public static final int SEND_REMOTE_ONLY = 1;
  
  public abstract void addIllegalMessageListener(MessageServiceInterface.IllegalMessageListener paramIllegalMessageListener);
  
  public abstract void addReceiveMessageListener(MessageServiceInterface.ReceiveMessageListener paramReceiveMessageListener);
  
  public abstract void delIllegalMessageListener(MessageServiceInterface.IllegalMessageListener paramIllegalMessageListener);
  
  public abstract void delReceiveMessageListener(MessageServiceInterface.ReceiveMessageListener paramReceiveMessageListener);
  
  public abstract void fetchRecentMessage(long paramLong);
  
  public abstract void init(MessageServiceAdapter paramMessageServiceAdapter);
  
  public abstract void sendMessage(MessageData paramMessageData, MessageServiceInterface.OnSendMessageCallback paramOnSendMessageCallback);
  
  public abstract void sendMessage(MessageData paramMessageData, MessageServiceInterface.OnSendMessageCallback paramOnSendMessageCallback, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.messageservice_interface.MessageServiceInterface
 * JD-Core Version:    0.7.0.1
 */