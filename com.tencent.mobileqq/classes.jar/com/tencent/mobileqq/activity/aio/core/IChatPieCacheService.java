package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IChatPieCacheService
  extends IRuntimeService
{
  public abstract ChatPieCache getChatPieCache();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.IChatPieCacheService
 * JD-Core Version:    0.7.0.1
 */