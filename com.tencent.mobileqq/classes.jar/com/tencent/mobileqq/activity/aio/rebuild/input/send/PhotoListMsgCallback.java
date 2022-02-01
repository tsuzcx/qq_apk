package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class PhotoListMsgCallback
  implements ISendMessageCallback
{
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)paramAIOContext.a().b(4);
    int i;
    if (localPhotoListPanel != null) {
      i = localPhotoListPanel.b();
    } else {
      i = 0;
    }
    int j;
    if (localPhotoListPanel != null) {
      j = localPhotoListPanel.c();
    } else {
      j = 0;
    }
    ChatActivityFacade.a(localQQAppInterface, paramAIOContext.a(), (SessionInfo)localBaseSessionInfo, paramSendLogicParam.a(), paramArrayList, paramSendLogicParam.a());
    if ((i + j > 0) && (localPhotoListPanel != null))
    {
      localPhotoListPanel.a(false, null);
      ((PhotoListHelper)paramAIOContext.a(7)).a(paramAIOContext.hashCode());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.PhotoListMsgCallback
 * JD-Core Version:    0.7.0.1
 */