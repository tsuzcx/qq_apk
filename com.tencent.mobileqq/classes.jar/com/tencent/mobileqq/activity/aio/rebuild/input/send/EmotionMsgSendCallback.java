package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.core.input.SendLogicParam;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import java.util.ArrayList;

public class EmotionMsgSendCallback
  implements ISendMessageCallback
{
  public void a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    AIOEmoticonPanelHelper localAIOEmoticonPanelHelper = (AIOEmoticonPanelHelper)paramAIOContext.a(104);
    if (localAIOEmoticonPanelHelper != null) {
      localAIOEmoticonPanelHelper.reportClassicAndSmallEmoticon(paramSendLogicParam.a(), false, paramAIOContext.a());
    }
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam)
  {
    return false;
  }
  
  public boolean a(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.EmotionMsgSendCallback
 * JD-Core Version:    0.7.0.1
 */