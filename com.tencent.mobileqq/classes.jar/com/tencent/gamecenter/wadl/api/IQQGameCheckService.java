package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQGameCheckService
  extends IRuntimeService
{
  public abstract void checkGameCenter();
  
  public abstract void handlePushTgpa(String paramString);
  
  public abstract boolean hasAppointTask();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameCheckService
 * JD-Core Version:    0.7.0.1
 */