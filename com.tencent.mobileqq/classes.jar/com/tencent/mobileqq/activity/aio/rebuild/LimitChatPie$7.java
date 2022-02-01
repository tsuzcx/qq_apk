package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class LimitChatPie$7
  implements Runnable
{
  LimitChatPie$7(LimitChatPie paramLimitChatPie) {}
  
  public void run()
  {
    IExpandManager localIExpandManager = (IExpandManager)this.this$0.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if ((localIExpandManager != null) && (!TextUtils.isEmpty(this.this$0.ah.b)))
    {
      LimitChatPie.b(this.this$0, ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).getMatchAlgorithmId(this.this$0.d, this.this$0.ah.b));
      List localList = this.this$0.d.getMessageFacade().a(this.this$0.ah.b, this.this$0.ah.a, null, 500);
      LimitChatPie.a(this.this$0, localList);
      this.this$0.d(localList);
      this.this$0.c(localList);
      ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).showIcebreakerTopic(this.this$0.d, this.this$0.ah.b, this.this$0.ah.a, LimitChatPie.b(this.this$0), this.this$0.bi);
      this.this$0.j(65536);
      LimitChatPie.a(this.this$0, localIExpandManager);
      if ((this.this$0.ah != null) && (this.this$0.ah.b != null)) {
        LimitChatPie.a(this.this$0, ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).getLastMatchChatGrayTipsSection(this.this$0.d, this.this$0.ah.b));
      }
      return;
    }
    QLog.e(this.this$0.c, 2, "getSubThreadHandler  extendFriendManager or sessionInfo.curFriendUin is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7
 * JD-Core Version:    0.7.0.1
 */