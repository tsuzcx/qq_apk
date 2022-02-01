package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IApolloActionUsedManagerService
  extends IRuntimeService
{
  public abstract List<Integer> getActionIdData(int paramInt);
  
  public abstract void getActionIdDataFromServer(int paramInt);
  
  public abstract boolean isDataExpired();
  
  public abstract void saveActionIdData(int paramInt1, int paramInt2);
  
  public abstract void saveApolloActionUsedRequestInterval(QQAppInterface paramQQAppInterface, long paramLong);
  
  public abstract void updateActionIdData(int paramInt, List<Integer> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloActionUsedManagerService
 * JD-Core Version:    0.7.0.1
 */