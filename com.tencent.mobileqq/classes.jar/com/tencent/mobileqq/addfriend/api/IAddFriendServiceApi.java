package com.tencent.mobileqq.addfriend.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IAddFriendServiceApi
  extends IRuntimeService
{
  public abstract boolean hasSendAddFriendReq(String paramString);
  
  public abstract boolean hasSendAddFriendReq(String paramString, boolean paramBoolean);
  
  public abstract boolean hasSendAddFriendReq(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setAddFriendReqStatus(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi
 * JD-Core Version:    0.7.0.1
 */