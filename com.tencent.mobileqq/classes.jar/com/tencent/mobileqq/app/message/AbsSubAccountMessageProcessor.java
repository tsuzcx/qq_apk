package com.tencent.mobileqq.app.message;

import PushNotifyPack.RequestPushNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

public abstract class AbsSubAccountMessageProcessor
  extends C2CMessageProcessor
{
  public AbsSubAccountMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    super(paramAppInterface, paramBaseMessageHandler);
  }
  
  public abstract void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList<String> paramArrayList);
  
  public abstract void a(RequestPushNotify paramRequestPushNotify);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(boolean paramBoolean, ArrayList<SimpleAccount> paramArrayList);
  
  public abstract boolean a(SubAccountInfo paramSubAccountInfo);
  
  public abstract void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor
 * JD-Core Version:    0.7.0.1
 */