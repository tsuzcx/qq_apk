package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQAvatarHandlerService
  extends IRuntimeService
{
  public abstract void getApolloHead(String paramString);
  
  public abstract void getApolloHead(String paramString, byte paramByte1, byte paramByte2, int paramInt);
  
  public abstract String getChoosedIP();
  
  public abstract String getChoosedStrangerGroupIP();
  
  public abstract void getCustomHead(String paramString);
  
  public abstract void getCustomHead(String paramString, byte paramByte1, byte paramByte2);
  
  public abstract void getMobileQQHead(String paramString);
  
  public abstract void getMobileQQHead(String paramString, byte paramByte);
  
  public abstract void getQCallHead(String paramString, int paramInt, byte paramByte1, byte paramByte2);
  
  public abstract void getStrangerHead(String paramString, int paramInt, byte paramByte1, byte paramByte2);
  
  public abstract void getTroopHead(String paramString);
  
  public abstract void getTroopHead(String paramString, byte paramByte);
  
  public abstract void notifySyncQQHead();
  
  public abstract void sendBroadCastHeadChanged(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
 * JD-Core Version:    0.7.0.1
 */