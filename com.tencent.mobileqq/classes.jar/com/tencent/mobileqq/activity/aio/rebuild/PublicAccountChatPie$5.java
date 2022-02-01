package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$5
  implements Runnable
{
  PublicAccountChatPie$5(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    Object localObject = (IPublicAccountDataManager)this.this$0.d.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null) {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(this.this$0.ah.b);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      this.this$0.ce.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.5
 * JD-Core Version:    0.7.0.1
 */