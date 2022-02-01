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
import java.util.ArrayList;

public class TroopRobotMsgSendListener
  implements IMsgSendListener
{
  private boolean a;
  private boolean b;
  private String c;
  private String d;
  private String e;
  private ArrayList<AtTroopMemberInfo> f;
  
  public boolean a(AIOContext paramAIOContext)
  {
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.O();
    Object localObject1 = (AIOShortcutBarHelper)paramAIOContext.a(52);
    Object localObject2 = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
    ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject2).a().putBoolean("isSending", false);
    ITroopRobotService localITroopRobotService = (ITroopRobotService)paramAIOContext.a().getRuntimeService(ITroopRobotService.class, "all");
    this.a = localITroopRobotService.isTalking();
    this.c = localITroopRobotService.getTalkingRobotUin();
    this.d = localITroopRobotService.getTalkingNickName();
    ((AIOShortcutBarHelper)localObject1).a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject2);
    this.f = new ArrayList();
    this.e = AtTroopMemberSpan.a(paramAIOContext.p().d().f().c(), this.f);
    this.b = false;
    int i = 0;
    while (i < this.f.size())
    {
      localObject1 = (AtTroopMemberInfo)this.f.get(i);
      if (localITroopRobotService.isRobotUin(((AtTroopMemberInfo)localObject1).uin))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((AtTroopMemberInfo)localObject1).uin);
        this.c = ((StringBuilder)localObject2).toString();
        this.d = ContactUtils.b(paramAIOContext.a(), localBaseSessionInfo.b, this.c);
        if (!this.a)
        {
          paramAIOContext = this.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((AtTroopMemberInfo)localObject1).uin);
          if (!localITroopRobotService.isTalkingMsg(paramAIOContext, ((StringBuilder)localObject2).toString(), localBaseSessionInfo.b))
          {
            bool = false;
            break label304;
          }
        }
        boolean bool = true;
        label304:
        this.a = bool;
        paramAIOContext = this.e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((AtTroopMemberInfo)localObject1).uin);
        this.b = localITroopRobotService.isEndingMsg(paramAIOContext, ((StringBuilder)localObject2).toString(), localBaseSessionInfo.b);
        return false;
      }
      i += 1;
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext)
  {
    ITroopRobotService localITroopRobotService = (ITroopRobotService)paramAIOContext.a().getRuntimeService(ITroopRobotService.class, "all");
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)paramAIOContext.a(52);
    AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
    }
    EditTextUI localEditTextUI = paramAIOContext.p().d().f();
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.O();
    if ((this.a) && (!this.b))
    {
      localEditTextUI.a(AtTroopMemberSpan.a(paramAIOContext.a(), paramAIOContext.b(), localBaseSessionInfo.b, this.c, this.d, false, localEditTextUI.b(), true));
      localEditTextUI.b(" ");
      localEditTextUI.d(localEditTextUI.a().length());
      ((TroopAIOContext)paramAIOContext).a(localITroopRobotService.getTalkingRobotUin(), localITroopRobotService.getTalkingNickName(), true, 0);
    }
    else
    {
      TroopPobingItemBuilder.a(paramAIOContext.a(), this.e, this.f, localBaseSessionInfo.b);
      paramAIOContext = this.e;
      if ((paramAIOContext == null) || (paramAIOContext.length() <= 3478)) {
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopRobotMsgSendListener
 * JD-Core Version:    0.7.0.1
 */