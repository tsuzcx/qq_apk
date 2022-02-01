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
    QidianHandler localQidianHandler = (QidianHandler)this.this$0.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
    int j;
    Object localObject;
    if (!this.this$0.cC)
    {
      j = 0;
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("app", "QD");
      if (this.this$0.cx != null) {
        ((JSONObject)localObject).put("assignType", Long.parseLong(this.this$0.cx));
      }
      if (this.this$0.cy != null) {
        ((JSONObject)localObject).put("assignKey", Long.parseLong(this.this$0.cy));
      }
      i = j;
      if (this.this$0.cz == null) {
        break label134;
      }
      ((JSONObject)localObject).put("ext", this.this$0.cz);
      i = j;
    }
    catch (Exception localException)
    {
      int i;
      label132:
      String str1;
      String str2;
      String str3;
      String str4;
      break label132;
    }
    i = 1;
    label134:
    str1 = this.this$0.ah.b;
    str2 = this.this$0.cw;
    str3 = this.this$0.cv;
    str4 = this.this$0.cA;
    if (i != 0) {
      localObject = null;
    } else {
      localObject = ((JSONObject)localObject).toString();
    }
    localQidianHandler.a(str1, str2, str3, str4, (String)localObject);
    this.this$0.aX().runOnUiThread(new PublicAccountChatPie.57.1(this));
    localQidianHandler.a(this.this$0.ah.b, this.this$0.cw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.57
 * JD-Core Version:    0.7.0.1
 */