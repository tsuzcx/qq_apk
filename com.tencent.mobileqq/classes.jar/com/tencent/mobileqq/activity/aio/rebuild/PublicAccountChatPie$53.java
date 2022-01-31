package com.tencent.mobileqq.activity.aio.rebuild;

import aert;
import bdvn;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class PublicAccountChatPie$53
  implements Runnable
{
  public PublicAccountChatPie$53(aert paramaert) {}
  
  public void run()
  {
    bdvn localbdvn = (bdvn)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
    if (!this.this$0.ao) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("app", "QD");
      if (this.this$0.k != null) {
        ((JSONObject)localObject).put("assignType", Long.parseLong(this.this$0.k));
      }
      if (this.this$0.l != null) {
        ((JSONObject)localObject).put("assignKey", Long.parseLong(this.this$0.l));
      }
      if (this.this$0.m != null) {
        ((JSONObject)localObject).put("ext", this.this$0.m);
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
    str2 = this.this$0.j;
    str3 = this.this$0.i;
    str4 = this.this$0.n;
    if (i != 0)
    {
      localObject = null;
      localbdvn.a(str1, str2, str3, str4, (String)localObject);
      this.this$0.a().runOnUiThread(new PublicAccountChatPie.53.1(this));
      localbdvn.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.53
 * JD-Core Version:    0.7.0.1
 */