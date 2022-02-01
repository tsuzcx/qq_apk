package com.tencent.mobileqq.activity.aio.rebuild;

import ahiu;
import amxz;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class PublicAccountChatPie$5
  implements Runnable
{
  public PublicAccountChatPie$5(ahiu paramahiu) {}
  
  public void run()
  {
    Object localObject = (amxz)this.this$0.app.getManager(56);
    if (localObject != null) {}
    for (localObject = ((amxz)localObject).b(this.this$0.sessionInfo.curFriendUin);; localObject = null)
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