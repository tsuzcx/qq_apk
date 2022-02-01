package com.tencent.mobileqq.activity.recent.msgbox.api;

import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConfigData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITempMsgBoxManager
  extends IRuntimeService
{
  public abstract void addToFilterList(String paramString);
  
  public abstract void addToWhiteList(String paramString);
  
  public abstract boolean configContains(int paramInt);
  
  public abstract List<RecentUser> getMsgBoxRecentUsers();
  
  public abstract boolean hasFilter(String paramString);
  
  public abstract boolean isBelongToFilterBox(String paramString, int paramInt);
  
  public abstract boolean isBelongToMsgBox(String paramString, int paramInt);
  
  public abstract boolean isMsgBoxRead();
  
  public abstract boolean msgBoxSwitch();
  
  public abstract void removeFromFilterList(String paramString);
  
  public abstract void removeFromWhiteList(String paramString);
  
  public abstract void setMsgBoxRead(boolean paramBoolean);
  
  public abstract void setTempMsgBoxConfigData(TempMsgBoxConfigData paramTempMsgBoxConfigData);
  
  public abstract void updateIsTop(String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager
 * JD-Core Version:    0.7.0.1
 */