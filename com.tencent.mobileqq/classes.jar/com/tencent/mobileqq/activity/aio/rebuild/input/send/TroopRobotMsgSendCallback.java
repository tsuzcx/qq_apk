package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class TroopRobotMsgSendCallback
  implements ISendMessageCallback
{
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    paramAIOContext = (AIOShortcutBarHelper)paramAIOContext.a(52);
    if (paramAIOContext != null)
    {
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(18);
      localAIOShortcutBarEvent.a().putBoolean("isSendToRobotServer", false);
      paramAIOContext.a(localAIOShortcutBarEvent);
      paramSendLogicParam.b().y = localAIOShortcutBarEvent.a().getBoolean("result", false);
    }
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopRobotMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */