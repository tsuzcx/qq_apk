package com.tencent.mobileqq.apollo.res.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IApolloResManager
  extends IRuntimeService
{
  public abstract void downloadJson(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.IApolloResManager
 * JD-Core Version:    0.7.0.1
 */