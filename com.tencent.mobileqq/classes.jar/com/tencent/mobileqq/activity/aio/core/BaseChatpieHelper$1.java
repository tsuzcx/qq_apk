package com.tencent.mobileqq.activity.aio.core;

import anvk;
import bdlq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;

class BaseChatpieHelper$1
  implements Runnable
{
  BaseChatpieHelper$1(BaseChatpieHelper paramBaseChatpieHelper, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    String str2;
    String str3;
    String str1;
    Object localObject;
    if (this.jdField_a_of_type_Int == -1) {
      if (BaseChatpieHelper.a(this.this$0).curType == 0)
      {
        str2 = "";
        str3 = "";
        str1 = str2;
        localObject = str3;
        if (this.b != 2) {
          break label156;
        }
        localObject = (anvk)BaseChatpieHelper.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (BaseChatpieHelper.a(this.this$0).curType != 1008) {
          break label75;
        }
      }
    }
    for (;;)
    {
      return;
      label75:
      Friends localFriends = ((anvk)localObject).e(BaseChatpieHelper.a(this.this$0).curFriendUin);
      str1 = str2;
      localObject = str3;
      if (localFriends != null)
      {
        str1 = "" + ContactUtils.getFriendStatus(localFriends);
        localObject = "" + ContactUtils.getFriendTermType(localFriends, BaseChatpieHelper.a(this.this$0));
      }
      label156:
      bdlq.a(BaseChatpieHelper.a(this.this$0), "clt", BaseChatpieHelper.a(this.this$0).getAccount(), BaseChatpieHelper.a(this.this$0).curFriendUin, "msg", this.b + "", "", "", str1, (String)localObject, BaseChatpieHelper.a(this.this$0) + "");
      BaseChatpieHelper.a(this.this$0, 0);
      return;
      localObject = null;
      switch (BaseChatpieHelper.a(this.this$0).curType)
      {
      }
      while (localObject != null)
      {
        bdlq.a(BaseChatpieHelper.a(this.this$0), (String)localObject, BaseChatpieHelper.a(this.this$0).getAccount(), BaseChatpieHelper.a(this.this$0).curFriendUin, "pic", "", this.jdField_a_of_type_Int + "", this.jdField_a_of_type_JavaLangString, "", "", "");
        return;
        localObject = "clt";
        continue;
        localObject = "grp";
        continue;
        localObject = "discuss";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatpieHelper.1
 * JD-Core Version:    0.7.0.1
 */