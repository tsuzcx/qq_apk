package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.text.Editable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.core.input.MessageSignal;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class ConfessMessageSender
  extends BaseMessageSender
{
  public ConfessMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    if (this.a.p().d().f().a().length() == 0) {
      return;
    }
    String str = this.a.p().d().f().a().toString();
    if ((str != null) && (str.length() > BaseChatPie.bh))
    {
      ChatActivityUtils.a(this.a.b(), 2131916265, 1);
      return;
    }
    Object localObject = new ChatActivityFacade.SendMsgParams();
    this.a.p().b().a((ChatActivityFacade.SendMsgParams)localObject);
    ChatActivityFacade.a(this.b, this.a.b(), (SessionInfo)this.c, str, null, (ChatActivityFacade.SendMsgParams)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("SendMsgBtn", 2, ((StringBuilder)localObject).toString());
    }
    a(this.a);
    this.a.c().a(1002, new Object[] { str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.ConfessMessageSender
 * JD-Core Version:    0.7.0.1
 */