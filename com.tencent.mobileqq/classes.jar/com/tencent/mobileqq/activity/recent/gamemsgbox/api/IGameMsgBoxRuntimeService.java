package com.tencent.mobileqq.activity.recent.gamemsgbox.api;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IGameMsgBoxRuntimeService
  extends IRuntimeService
{
  public static final String DT_ELEMENT_ID = "em_gb_box";
  public static final String DT_PAGE_ID = "pg_gb_entrance";
  public static final String MR_EXT_SHOW_TIME = "mr_ext_show_time";
  
  public abstract void addAuthorizeShow(String paramString);
  
  public abstract void buildGameBox();
  
  public abstract boolean getBoxIsRead();
  
  public abstract int getBoxUnReadCnt();
  
  public abstract boolean getDataReady();
  
  public abstract List<RecentUser> getGameRecentUser();
  
  public abstract boolean getGameTop();
  
  public abstract Long getLastAuthTime();
  
  public abstract boolean isAuthorizeShow(String paramString);
  
  public abstract boolean isCurMsgNeedShowRed(MessageRecord paramMessageRecord);
  
  public abstract boolean isMsgAuthorizeShow(String paramString);
  
  public abstract void processGameMsg(RecentUserProxy paramRecentUserProxy, MessageRecord paramMessageRecord);
  
  public abstract void reportItemEvent(String paramString1, String paramString2, String paramString3);
  
  public abstract void reportItemExp(AppInterface paramAppInterface, View paramView, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, Object paramObject, int[] paramArrayOfInt);
  
  public abstract void setBoxRead(boolean paramBoolean);
  
  public abstract void setDataReady();
  
  public abstract void setGameTop(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService
 * JD-Core Version:    0.7.0.1
 */