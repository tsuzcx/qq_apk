package com.tencent.imcore.message.facade.add.inner.end;

import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IAddMultiMessagesInnerEndProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DecodeMsgProcessor
  implements IAddMultiMessagesInnerEndProcessor<QQMessageFacade, QQAppInterface>
{
  public void a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, BaseMessageManager.AddMessageContext paramAddMessageContext, boolean paramBoolean)
  {
    paramQQAppInterface = paramAddMessageContext.d.keySet().iterator();
    while (paramQQAppInterface.hasNext())
    {
      paramList = (String)paramQQAppInterface.next();
      Object localObject = (MessageRecord)paramAddMessageContext.d.get(paramList);
      if (localObject != null)
      {
        paramList = paramQQMessageFacade.getLastMessage(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
        paramQQMessageFacade.a(paramList);
        if ((localObject instanceof MessageForPic))
        {
          localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic((MessageForPic)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramList.msg = ((String)localObject);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addMessage decodeMsg uin = ");
          ((StringBuilder)localObject).append(paramList.frienduin);
          ((StringBuilder)localObject).append(" , type = ");
          ((StringBuilder)localObject).append(paramList.istroop);
          ((StringBuilder)localObject).append(" ,msgType:");
          ((StringBuilder)localObject).append(paramList.msgtype);
          ((StringBuilder)localObject).append(", con = ");
          ((StringBuilder)localObject).append(paramList.getLogColorContent());
          QLog.d("DecodeMsgProcessor", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.inner.end.DecodeMsgProcessor
 * JD-Core Version:    0.7.0.1
 */