package com.tencent.mobileqq.activity.recent.msgbox.api;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface ITempMsgBoxService
  extends QRouteApi
{
  public abstract void addNicknameToVideoMsg(int paramInt, String paramString, MsgSummary paramMsgSummary);
  
  public abstract int getAllFilterMsgUnreadNumOfQCall(AppInterface paramAppInterface, Message paramMessage);
  
  public abstract HashMap<String, ITempMsgBoxBusinessHandler> getBusinessHandlerMap();
  
  public abstract Map<Integer, String> getBusinessStringMap();
  
  public abstract ITempMsgBoxCallback getCallback();
  
  public abstract List<RecentUser> getFilterBoxRecentUsers(AppInterface paramAppInterface);
  
  public abstract String getFilterMsgBoxHandlerName();
  
  public abstract Map<Integer, Integer> getServiceIdMap();
  
  public abstract Map<Integer, Integer> getSummaryTextMap();
  
  public abstract int getTempMsgBoxUnread(AppInterface paramAppInterface);
  
  public abstract int getTempSettingStatus(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract ArrayList<Integer> getTempUinTypeList();
  
  public abstract String getTitleName(AppInterface paramAppInterface, RecentUser paramRecentUser);
  
  public abstract long getUpdateTime();
  
  public abstract ConversationInfo onGetUnreadCount(ConversationInfo paramConversationInfo);
  
  public abstract void removeFilterBoxIfNecessary(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void removeMsgBoxIfNecessary(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void reportTempMsgBoxExposure(AppInterface paramAppInterface, Object paramObject);
  
  public abstract void saveUpdateTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService
 * JD-Core Version:    0.7.0.1
 */