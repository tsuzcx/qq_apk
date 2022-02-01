package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.os.Bundle;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class GrayTipsReadConfirmCallback
  implements IReadConfirmCallback
{
  public void a(AIOContext paramAIOContext) {}
  
  public void a(AIOContext paramAIOContext, List<ChatMessage> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (ChatMessage)paramList.next();
      if ((localObject instanceof MessageForUniteGrayTip))
      {
        localObject = (MessageForUniteGrayTip)localObject;
        if (((MessageForUniteGrayTip)localObject).tipParam != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("graytips lgraymr.hasRead=");
            localStringBuilder.append(((MessageForUniteGrayTip)localObject).hasRead);
            localStringBuilder.append("grayTipId=");
            localStringBuilder.append(((MessageForUniteGrayTip)localObject).tipParam.i);
            localStringBuilder.append("subtype = ");
            localStringBuilder.append(((MessageForUniteGrayTip)localObject).subType);
            QLog.d("FriendReactive", 2, localStringBuilder.toString());
          }
          if ((((MessageForUniteGrayTip)localObject).tipParam.i == 2097153) && (((MessageForUniteGrayTip)localObject).hasRead == 0))
          {
            OldMutualMarkLogicHelper.a(paramAIOContext.a(), paramAIOContext.O(), (MessageForUniteGrayTip)localObject, paramAIOContext.g(), paramAIOContext.h(), ((MessageForUniteGrayTip)localObject).subType);
            ((MessageForUniteGrayTip)localObject).hasRead = 1;
            ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(paramAIOContext.a());
          }
        }
      }
    }
  }
  
  public void b(AIOContext paramAIOContext)
  {
    Object localObject1 = paramAIOContext.O();
    localObject1 = paramAIOContext.a().getMessageFacade().o(((BaseSessionInfo)localObject1).b, ((BaseSessionInfo)localObject1).a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
      if ((localObject2 instanceof MessageForUniteGrayTip))
      {
        localObject2 = (MessageForUniteGrayTip)localObject2;
        if (UniteGrayTipUtil.a((MessageForUniteGrayTip)localObject2, paramAIOContext.a()))
        {
          Message localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", ((MessageForUniteGrayTip)localObject2).uniseq);
          localMessage.setData(localBundle);
          localMessage.what = 78;
          localMessage.arg1 = 0;
          paramAIOContext.g().sendMessage(localMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.GrayTipsReadConfirmCallback
 * JD-Core Version:    0.7.0.1
 */