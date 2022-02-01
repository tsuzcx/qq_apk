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
  
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    Object localObject1 = ((FullScreenInputHelper)paramAIOContext.a(24)).a();
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((MixedMsgInfo)localObject1).b();
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramAIOContext.a().a().a().a().toString();
    }
    paramSendLogicParam.a((String)localObject2);
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    Object localObject = (FullScreenInputHelper)paramAIOContext.a(24);
    MixedMsgInfo localMixedMsgInfo = ((FullScreenInputHelper)localObject).a();
    if ((!((FullScreenInputHelper)localObject).d()) && (localMixedMsgInfo != null) && (localMixedMsgInfo.a()))
    {
      MixedMsgManager localMixedMsgManager = (MixedMsgManager)paramAIOContext.a().getManager(QQManagerFactory.MIXED_MSG_MANAGER);
      if (a(paramAIOContext.a())) {
        localMixedMsgManager.a(paramAIOContext.a(), paramAIOContext.a(), paramArrayList, localMixedMsgInfo, paramSendLogicParam.a().k);
      } else {
        localMixedMsgManager.a(paramAIOContext.a(), paramAIOContext.a(), paramArrayList, localMixedMsgInfo, false);
      }
      ((FullScreenInputHelper)localObject).d();
      return true;
    }
    int i = paramAIOContext.a().a;
    if ((i != 0) && (i != 1) && (i != 3000)) {
      return false;
    }
    localObject = (PhotoListPanel)paramAIOContext.a().b(4);
    if ((localObject != null) && (((PhotoListPanel)localObject).a(paramSendLogicParam.a())))
    {
      if (!((PhotoListPanel)localObject).a(true, paramAIOContext.a())) {
        ChatActivityFacade.a(paramAIOContext.a(), paramAIOContext.a(), (SessionInfo)paramAIOContext.a(), paramSendLogicParam.a(), paramArrayList, paramSendLogicParam.a());
      }
      ((PhotoListHelper)paramAIOContext.a(7)).a(paramAIOContext.hashCode());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.MixedMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */