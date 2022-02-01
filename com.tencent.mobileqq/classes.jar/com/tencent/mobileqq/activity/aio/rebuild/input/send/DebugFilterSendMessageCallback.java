package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class DebugFilterSendMessageCallback
  implements ISendMessageCallback
{
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    paramSendLogicParam = paramAIOContext.a();
    EditTextUI localEditTextUI = paramAIOContext.a().a().a();
    FunBtnUI localFunBtnUI = paramAIOContext.a().a().a();
    if (paramSendLogicParam.l)
    {
      BaseChatpieHelper.a(paramSendLogicParam, localEditTextUI, localFunBtnUI, true);
      paramAIOContext.a().a().b(131075);
      paramAIOContext.a().a().a(paramAIOContext.a().a().b());
      return true;
    }
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.DebugFilterSendMessageCallback
 * JD-Core Version:    0.7.0.1
 */