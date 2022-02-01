package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

class ServiceAccountFolderManager$5
  implements Runnable
{
  ServiceAccountFolderManager$5(ServiceAccountFolderManager paramServiceAccountFolderManager, ArrayList paramArrayList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      RecentUtil.b(this.b, str, 1008);
      this.b.getMessageFacade().a(str, 1008);
      this.b.getConversationFacade().a(str, 1008, true);
    }
    this.this$0.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.5
 * JD-Core Version:    0.7.0.1
 */