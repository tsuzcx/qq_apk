package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import java.util.ArrayList;

public class MixedMsgSendCallback
  implements ISendMessageCallback
{
  private boolean a(BaseSessionInfo paramBaseSessionInfo)
  {
    int i = paramBaseSessionInfo.a;
    boolean bool = true;
    if (i != 1)
    {
      if (paramBaseSessionInfo.a == 3000) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    Object localObject1 = ((FullScreenInputHelper)paramAIOContext.a(24)).n();
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((MixedMsgInfo)localObject1).c();
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramAIOContext.p().d().f().a().toString();
    }
    paramSendLogicParam.a((String)localObject2);
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    Object localObject = (FullScreenInputHelper)paramAIOContext.a(24);
    MixedMsgInfo localMixedMsgInfo = ((FullScreenInputHelper)localObject).n();
    if ((!((FullScreenInputHelper)localObject).i()) && (localMixedMsgInfo != null) && (localMixedMsgInfo.d()))
    {
      MixedMsgManager localMixedMsgManager = (MixedMsgManager)paramAIOContext.a().getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      if (a(paramAIOContext.O())) {
        localMixedMsgManager.a(paramAIOContext.a(), paramAIOContext.n(), paramArrayList, localMixedMsgInfo, paramSendLogicParam.b().C);
      } else {
        localMixedMsgManager.a(paramAIOContext.a(), paramAIOContext.n(), paramArrayList, localMixedMsgInfo, false);
      }
      ((FullScreenInputHelper)localObject).j();
      return true;
    }
    int i = paramAIOContext.O().a;
    if ((i != 0) && (i != 1) && (i != 3000) && (i != 10014)) {
      return false;
    }
    localObject = (PhotoListPanel)paramAIOContext.q().d(4);
    if ((localObject != null) && (((PhotoListPanel)localObject).d(paramSendLogicParam.a())))
    {
      if (!((PhotoListPanel)localObject).a(true, paramAIOContext.n())) {
        ChatActivityFacade.a(paramAIOContext.a(), paramAIOContext.b(), (SessionInfo)paramAIOContext.O(), paramSendLogicParam.a(), paramArrayList, paramSendLogicParam.b());
      }
      ((PhotoListHelper)paramAIOContext.a(7)).b(paramAIOContext.hashCode());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.MixedMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */