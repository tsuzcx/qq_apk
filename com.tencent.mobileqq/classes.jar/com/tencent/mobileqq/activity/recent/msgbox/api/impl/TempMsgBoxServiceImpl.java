package com.tencent.mobileqq.activity.recent.msgbox.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxHandler;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxUtil;
import com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxUtil;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TempMsgBoxServiceImpl
  implements ITempMsgBoxService
{
  public void addNicknameToVideoMsg(int paramInt, String paramString, MsgSummary paramMsgSummary)
  {
    TempMsgBoxUtil.a(paramInt, paramString, paramMsgSummary);
  }
  
  public int getAllFilterMsgUnreadNumOfQCall(AppInterface paramAppInterface, Message paramMessage)
  {
    return FilterMsgBoxUtil.a(paramAppInterface, paramMessage);
  }
  
  public HashMap<String, ITempMsgBoxBusinessHandler> getBusinessHandlerMap()
  {
    return TempMsgBoxUtil.d();
  }
  
  public Map<Integer, String> getBusinessStringMap()
  {
    return TempMsgBoxUtil.c();
  }
  
  public ITempMsgBoxCallback getCallback()
  {
    return TempMsgBoxUtil.a;
  }
  
  public List<RecentUser> getFilterBoxRecentUsers(AppInterface paramAppInterface)
  {
    return FilterMsgBoxUtil.a(paramAppInterface);
  }
  
  public String getFilterMsgBoxHandlerName()
  {
    return FilterMsgBoxHandler.class.getName();
  }
  
  public Map<Integer, Integer> getServiceIdMap()
  {
    return TempMsgBoxUtil.b();
  }
  
  public Map<Integer, Integer> getSummaryTextMap()
  {
    return TempMsgBoxUtil.a();
  }
  
  public int getTempMsgBoxUnread(AppInterface paramAppInterface)
  {
    return TempMsgBoxUtil.a(paramAppInterface);
  }
  
  public int getTempSettingStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    return TempMsgBoxUtil.a(paramBoolean1, paramBoolean2);
  }
  
  public ArrayList<Integer> getTempUinTypeList()
  {
    return TempChatPluginManagerImpl.getTempUinTypeList();
  }
  
  public String getTitleName(AppInterface paramAppInterface, RecentUser paramRecentUser)
  {
    return TempMsgBoxUtil.a(paramAppInterface, paramRecentUser);
  }
  
  public long getUpdateTime()
  {
    return FilterMsgBoxUtil.a();
  }
  
  public ConversationInfo onGetUnreadCount(ConversationInfo paramConversationInfo)
  {
    return TempMsgBoxUtil.a(paramConversationInfo);
  }
  
  public void removeFilterBoxIfNecessary(AppInterface paramAppInterface, boolean paramBoolean)
  {
    FilterMsgBoxUtil.a(paramAppInterface, paramBoolean);
  }
  
  public void removeMsgBoxIfNecessary(AppInterface paramAppInterface, boolean paramBoolean)
  {
    TempMsgBoxUtil.a(paramAppInterface, paramBoolean);
  }
  
  public void reportTempMsgBoxExposure(AppInterface paramAppInterface, Object paramObject)
  {
    TempMsgBoxUtil.a(paramAppInterface, paramObject);
  }
  
  public void saveUpdateTime(long paramLong)
  {
    FilterMsgBoxUtil.a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.api.impl.TempMsgBoxServiceImpl
 * JD-Core Version:    0.7.0.1
 */