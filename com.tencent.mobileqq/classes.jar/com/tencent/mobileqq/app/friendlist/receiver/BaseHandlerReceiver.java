package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract class BaseHandlerReceiver
{
  protected QQAppInterface a;
  protected FriendListHandler b;
  
  public BaseHandlerReceiver(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    this.a = paramQQAppInterface;
    this.b = paramFriendListHandler;
  }
  
  protected final void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    this.b.notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (a(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public abstract boolean a(String paramString);
  
  protected abstract void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.BaseHandlerReceiver
 * JD-Core Version:    0.7.0.1
 */