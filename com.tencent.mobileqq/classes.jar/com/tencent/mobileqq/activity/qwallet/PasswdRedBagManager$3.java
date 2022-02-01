package com.tencent.mobileqq.activity.qwallet;

import ajuk;
import ajul;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PasswdRedBagManager$3
  implements Runnable
{
  public PasswdRedBagManager$3(ajul paramajul, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = ajul.a(this.this$0).getMessageFacade().getMsgList(this.a.curFriendUin, this.a.curType);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForQQWalletMsg))
        {
          localObject2 = (MessageForQQWalletMsg)localObject2;
          if (((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg != null)
          {
            Object localObject3 = ((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg;
            localObject3 = this.this$0.a(((QQWalletRedPacketMsg)localObject3).redPacketId);
            if ((localObject3 != null) && (((ajuk)localObject3).a == 4) && (!((ajuk)localObject3).b)) {
              localArrayList.add(((MessageForQQWalletMsg)localObject2).mQQWalletRedPacketMsg.redPacketId);
            }
          }
        }
      }
    }
    this.this$0.a(this.a, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.3
 * JD-Core Version:    0.7.0.1
 */