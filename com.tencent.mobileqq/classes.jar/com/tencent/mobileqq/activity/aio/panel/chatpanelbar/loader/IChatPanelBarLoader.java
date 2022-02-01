package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.ITypeMatcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import java.util.List;

public abstract interface IChatPanelBarLoader
  extends ITypeMatcher
{
  public abstract List<AIOPanelIconItem> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
  
  public abstract List<int[]> b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.IChatPanelBarLoader
 * JD-Core Version:    0.7.0.1
 */