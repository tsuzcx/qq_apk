package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import android.os.Handler;
import aoan;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class PublicAccountChatPie$5
  implements Runnable
{
  public PublicAccountChatPie$5(aido paramaido) {}
  
  public void run()
  {
    Object localObject = (aoan)this.this$0.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null) {}
    for (localObject = ((aoan)localObject).b(this.this$0.sessionInfo.curFriendUin);; localObject = null)
    {
      if (localObject != null) {
        this.this$0.a.sendEmptyMessage(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.5
 * JD-Core Version:    0.7.0.1
 */