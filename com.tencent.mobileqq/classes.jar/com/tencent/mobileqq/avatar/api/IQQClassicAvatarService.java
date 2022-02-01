package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQClassicAvatarService
  extends IRuntimeService
{
  public abstract void handleGetHeadError(String paramString);
  
  public abstract boolean isClassicHeadActivityActivate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQClassicAvatarService
 * JD-Core Version:    0.7.0.1
 */