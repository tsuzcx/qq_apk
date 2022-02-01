package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IConditionSearchManager
  extends IRuntimeService
{
  public abstract void addListener(IConditionSearchManager.IConfigListenerProxy paramIConfigListenerProxy);
  
  public abstract int checkUpdate();
  
  public abstract void removeListener(IConditionSearchManager.IConfigListenerProxy paramIConfigListenerProxy);
  
  public abstract int resultOk();
  
  public abstract int update(int paramInt, boolean paramBoolean);
  
  public abstract int updateOk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IConditionSearchManager
 * JD-Core Version:    0.7.0.1
 */