package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class QWalletMsgSendCallback
  implements ISendMessageCallback
{
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    paramAIOContext = (QWalletAIOLifeCycleHelper)paramAIOContext.a(27);
    if (paramAIOContext != null) {
      paramAIOContext.a(paramSendLogicParam.a(), paramSendLogicParam.a(), 0);
    }
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.QWalletMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */