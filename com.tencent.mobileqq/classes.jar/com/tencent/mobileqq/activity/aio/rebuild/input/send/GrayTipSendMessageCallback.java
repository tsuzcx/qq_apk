package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import java.util.ArrayList;

public class GrayTipSendMessageCallback
  implements ISendMessageCallback
{
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    UniteGrayTipUtil.a();
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.GrayTipSendMessageCallback
 * JD-Core Version:    0.7.0.1
 */