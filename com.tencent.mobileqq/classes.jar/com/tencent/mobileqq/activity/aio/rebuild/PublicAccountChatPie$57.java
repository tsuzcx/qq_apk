package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.controller.QidianHandler;
import org.json.JSONObject;

class PublicAccountChatPie$57
  implements Runnable
{
  PublicAccountChatPie$57(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    QidianHandler localQidianHandler = (QidianHandler)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
    if (!this.this$0.ai) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("app", "QD");
      if (this.this$0.j != null) {
        ((JSONObject)localObject).put("assignType", Long.parseLong(this.this$0.j));
      }
      if (this.this$0.k != null) {
        ((JSONObject)localObject).put("assignKey", Long.parseLong(this.this$0.k));
      }
      if (this.this$0.l != null) {
        ((JSONObject)localObject).put("ext", this.this$0.l);
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        String str4;
        int i = 1;
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
    str1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    str2 = this.this$0.i;
    str3 = this.this$0.h;
    str4 = this.this$0.m;
    if (i != 0)
    {
      localObject = null;
      localQidianHandler.a(str1, str2, str3, str4, (String)localObject);
      this.this$0.a().runOnUiThread(new PublicAccountChatPie.57.1(this));
      localQidianHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.57
 * JD-Core Version:    0.7.0.1
 */