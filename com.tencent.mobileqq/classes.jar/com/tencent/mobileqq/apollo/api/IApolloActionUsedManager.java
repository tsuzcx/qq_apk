package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IApolloActionUsedManager
  extends IRuntimeService
{
  public abstract List<Integer> getActionIdData(int paramInt);
  
  public abstract void getActionIdDataFromServer(int paramInt);
  
  public abstract boolean isDataExpired();
  
  public abstract void saveActionIdData(int paramInt1, int paramInt2);
  
  public abstract void saveApolloActionUsedRequestInterval(AppRuntime paramAppRuntime, long paramLong);
  
  public abstract void updateActionIdData(int paramInt, List<Integer> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloActionUsedManager
 * JD-Core Version:    0.7.0.1
 */