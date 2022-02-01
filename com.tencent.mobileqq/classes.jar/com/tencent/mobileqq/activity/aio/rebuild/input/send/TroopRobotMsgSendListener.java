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
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<AtTroopMemberInfo> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public void a(AIOContext paramAIOContext)
  {
    ITroopRobotService localITroopRobotService = (ITroopRobotService)paramAIOContext.a().getRuntimeService(ITroopRobotService.class, "all");
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)paramAIOContext.a(52);
    AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
    }
    EditTextUI localEditTextUI = paramAIOContext.a().a().a();
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      localEditTextUI.a(AtTroopMemberSpan.a(paramAIOContext.a(), paramAIOContext.a(), localBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, false, localEditTextUI.a(), true));
      localEditTextUI.b(" ");
      localEditTextUI.c(localEditTextUI.a().length());
      ((TroopAIOContext)paramAIOContext).a(localITroopRobotService.getTalkingRobotUin(), localITroopRobotService.getTalkingNickName(), true, 0);
    }
    else
    {
      TroopPobingItemBuilder.a(paramAIOContext.a(), this.c, this.jdField_a_of_type_JavaUtilArrayList, localBaseSessionInfo.jdField_a_of_type_JavaLangString);
      paramAIOContext = this.c;
      if ((paramAIOContext == null) || (paramAIOContext.length() <= 3478)) {
        localEditTextUI.a("");
      }
      if (localAIOShortcutBarEvent.a().getBoolean("mIsShowRobotIcon")) {
        localAIOShortcutBarHelper.c(26);
      }
      localAIOShortcutBarEvent.a().putBoolean("mHasRobotOldFlag", false);
      localITroopRobotService.closeTalking();
    }
    localAIOShortcutBarEvent.a().putBoolean("isSending", false);
    localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
  }
  
  public boolean a(AIOContext paramAIOContext)
  {
    BaseSessionInfo localBaseSessionInfo = paramAIOContext.a();
    Object localObject1 = (AIOShortcutBarHelper)paramAIOContext.a(52);
    Object localObject2 = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
    ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject2).a().putBoolean("isSending", false);
    ITroopRobotService localITroopRobotService = (ITroopRobotService)paramAIOContext.a().getRuntimeService(ITroopRobotService.class, "all");
    this.jdField_a_of_type_Boolean = localITroopRobotService.isTalking();
    this.jdField_a_of_type_JavaLangString = localITroopRobotService.getTalkingRobotUin();
    this.jdField_b_of_type_JavaLangString = localITroopRobotService.getTalkingNickName();
    ((AIOShortcutBarHelper)localObject1).a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject2);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.c = AtTroopMemberSpan.a(paramAIOContext.a().a().a().b(), this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_Boolean = false;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (AtTroopMemberInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localITroopRobotService.isRobotUin(((AtTroopMemberInfo)localObject1).uin))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((AtTroopMemberInfo)localObject1).uin);
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramAIOContext.a(), localBaseSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        if (!this.jdField_a_of_type_Boolean)
        {
          paramAIOContext = this.c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((AtTroopMemberInfo)localObject1).uin);
          if (!localITroopRobotService.isTalkingMsg(paramAIOContext, ((StringBuilder)localObject2).toString(), localBaseSessionInfo.jdField_a_of_type_JavaLangString))
          {
            bool = false;
            break label304;
          }
        }
        boolean bool = true;
        label304:
        this.jdField_a_of_type_Boolean = bool;
        paramAIOContext = this.c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((AtTroopMemberInfo)localObject1).uin);
        this.jdField_b_of_type_Boolean = localITroopRobotService.isEndingMsg(paramAIOContext, ((StringBuilder)localObject2).toString(), localBaseSessionInfo.jdField_a_of_type_JavaLangString);
        return false;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopRobotMsgSendListener
 * JD-Core Version:    0.7.0.1
 */