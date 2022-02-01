package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.os.Bundle;
import android.text.Editable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopRobot2MsgSendListener
  implements IMsgSendListener
{
  private boolean a;
  
  public boolean a(AIOContext paramAIOContext)
  {
    this.a = false;
    paramAIOContext = (AIOShortcutBarHelper)paramAIOContext.a(52);
    AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
    if (paramAIOContext != null) {
      paramAIOContext.a(localAIOShortcutBarEvent);
    }
    boolean bool = localAIOShortcutBarEvent.a().getBoolean("isSending");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickSendTextButton. isSending:");
      localStringBuilder.append(bool);
      QLog.d("TroopRobot2MsgSendListener", 2, localStringBuilder.toString());
    }
    if (!bool)
    {
      localAIOShortcutBarEvent.a().putBoolean("isSending", true);
      if (paramAIOContext != null) {
        paramAIOContext.a(localAIOShortcutBarEvent);
      }
      this.a = true;
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext)
  {
    if (!this.a) {
      return;
    }
    EditTextUI localEditTextUI = paramAIOContext.p().d().f();
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.O();
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)paramAIOContext.a(52);
    AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
    localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobot2MsgSendListener", 2, "clickSendTextButton process talking state");
    }
    ITroopRobotService localITroopRobotService = (ITroopRobotService)localQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    boolean bool1 = localITroopRobotService.isTalking();
    Object localObject = localITroopRobotService.getTalkingRobotUin();
    String str1 = localITroopRobotService.getTalkingNickName();
    ArrayList localArrayList = new ArrayList();
    String str2 = AtTroopMemberSpan.a(localEditTextUI.c(), localArrayList);
    int i = 0;
    while (i < localArrayList.size())
    {
      AtTroopMemberInfo localAtTroopMemberInfo = (AtTroopMemberInfo)localArrayList.get(i);
      if (localITroopRobotService.isRobotUin(localAtTroopMemberInfo.uin))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(localAtTroopMemberInfo.uin);
        localObject = ((StringBuilder)localObject).toString();
        str1 = ContactUtils.b(localQQAppInterface, localBaseSessionInfo.b, (String)localObject);
        if (!bool1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(localAtTroopMemberInfo.uin);
          if (!localITroopRobotService.isTalkingMsg(str2, localStringBuilder.toString(), localBaseSessionInfo.b))
          {
            bool1 = false;
            break label286;
          }
        }
        bool1 = true;
        label286:
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(localAtTroopMemberInfo.uin);
        bool2 = localITroopRobotService.isEndingMsg(str2, localStringBuilder.toString(), localBaseSessionInfo.b);
        break label348;
      }
      i += 1;
    }
    boolean bool2 = false;
    label348:
    if ((bool1) && (!bool2))
    {
      localEditTextUI.a(AtTroopMemberSpan.a(localQQAppInterface, paramAIOContext.b(), localBaseSessionInfo.b, (String)localObject, str1, false, localEditTextUI.b(), true));
      localEditTextUI.b(" ");
      localEditTextUI.d(localEditTextUI.a().length());
      ((TroopAIOContext)paramAIOContext).a(localITroopRobotService.getTalkingRobotUin(), localITroopRobotService.getTalkingNickName(), true, 0);
    }
    else
    {
      TroopPobingItemBuilder.a(localQQAppInterface, str2, localArrayList, localBaseSessionInfo.b);
      if ((str2 == null) || (str2.length() <= 3478)) {
        localEditTextUI.a("");
      }
      if (localAIOShortcutBarEvent.a().getBoolean("mIsShowRobotIcon")) {
        localAIOShortcutBarHelper.d(26);
      }
      localAIOShortcutBarEvent.a().putBoolean("mHasRobotOldFlag", false);
      localITroopRobotService.closeTalking();
    }
    localAIOShortcutBarEvent.a().putBoolean("isSending", false);
    localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopRobot2MsgSendListener
 * JD-Core Version:    0.7.0.1
 */