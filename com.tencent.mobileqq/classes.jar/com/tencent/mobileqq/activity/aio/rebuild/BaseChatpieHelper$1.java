package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.ContactUtils;

class BaseChatpieHelper$1
  implements Runnable
{
  BaseChatpieHelper$1(BaseChatpieHelper paramBaseChatpieHelper, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label159:
    String str;
    Object localObject4;
    if (this.a == -1)
    {
      if (BaseChatpieHelper.a(this.this$0).a == 0)
      {
        if (this.b == 2)
        {
          localObject1 = (FriendsManager)BaseChatpieHelper.b(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (BaseChatpieHelper.a(this.this$0).a == 1008) {
            return;
          }
          localObject2 = ((FriendsManager)localObject1).m(BaseChatpieHelper.a(this.this$0).b);
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(OnlineStatusUtils.a((Friends)localObject2));
            localObject1 = ((StringBuilder)localObject1).toString();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(ContactUtils.a((Friends)localObject2, BaseChatpieHelper.b(this.this$0)));
            localObject2 = ((StringBuilder)localObject3).toString();
            break label159;
          }
        }
        localObject1 = "";
        localObject2 = localObject1;
        localObject3 = BaseChatpieHelper.b(this.this$0);
        str = BaseChatpieHelper.b(this.this$0).getAccount();
        localObject4 = BaseChatpieHelper.a(this.this$0).b;
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(this.b);
        ((StringBuilder)localObject5).append("");
        localObject5 = ((StringBuilder)localObject5).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(BaseChatpieHelper.c(this.this$0));
        localStringBuilder.append("");
        StatisticAssist.a((QQAppInterface)localObject3, "clt", str, (String)localObject4, "msg", (String)localObject5, "", "", (String)localObject1, (String)localObject2, localStringBuilder.toString());
        BaseChatpieHelper.a(this.this$0, 0);
      }
    }
    else
    {
      localObject1 = null;
      int i = BaseChatpieHelper.a(this.this$0).a;
      if (i != 0) {
        if (i != 1) {
          if (i != 3000) {
            break label342;
          }
        }
      }
      for (;;)
      {
        localObject1 = "discuss";
        continue;
        localObject1 = "grp";
        continue;
        localObject1 = "clt";
      }
      label342:
      if (localObject1 != null)
      {
        localObject2 = BaseChatpieHelper.b(this.this$0);
        localObject3 = BaseChatpieHelper.b(this.this$0).getAccount();
        str = BaseChatpieHelper.a(this.this$0).b;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.a);
        ((StringBuilder)localObject4).append("");
        StatisticAssist.a((QQAppInterface)localObject2, (String)localObject1, (String)localObject3, str, "pic", "", ((StringBuilder)localObject4).toString(), this.c, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper.1
 * JD-Core Version:    0.7.0.1
 */