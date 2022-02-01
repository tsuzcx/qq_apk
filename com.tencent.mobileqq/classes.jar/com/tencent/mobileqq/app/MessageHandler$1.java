package com.tencent.mobileqq.app;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler.Callback;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class MessageHandler$1
  implements RegisterProxyHandler.Callback
{
  MessageHandler$1(MessageHandler paramMessageHandler) {}
  
  public HashMap<Integer, String[]> a(int paramInt)
  {
    return this.a.n.getTroopListUin(paramInt);
  }
  
  public List<String> a()
  {
    Object localObject = ((DiscussionManager)this.a.n.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((DiscussionInfo)((Iterator)localObject).next()).uin);
    }
    return localArrayList;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -1035) && ((paramMessageRecord instanceof MessageForMixedMsg))) {
      this.a.n.msgFacade.a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, 32768, paramMessageRecord.sendFailCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.1
 * JD-Core Version:    0.7.0.1
 */