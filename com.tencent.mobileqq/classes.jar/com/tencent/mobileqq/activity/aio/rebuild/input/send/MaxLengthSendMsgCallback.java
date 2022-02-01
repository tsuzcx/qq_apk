package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public class MaxLengthSendMsgCallback
  implements ISendMessageCallback
{
  private static int a;
  
  public void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam) {}
  
  public boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    if (a == 0) {
      if (paramAIOContext.O().a == 10014) {
        a = paramAIOContext.b().getResources().getInteger(2131492889);
      } else {
        a = paramAIOContext.b().getResources().getInteger(2131492891);
      }
    }
    if (paramSendLogicParam.a().length() > a)
    {
      ChatActivityUtils.a(paramAIOContext.b(), 2131916265, 1);
      return true;
    }
    return false;
  }
  
  public boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.MaxLengthSendMsgCallback
 * JD-Core Version:    0.7.0.1
 */