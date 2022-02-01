package com.tencent.mobileqq.activity.aio.rebuild;

import ahiu;
import bing;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;

public class PublicAccountChatPie$57
  implements Runnable
{
  public PublicAccountChatPie$57(ahiu paramahiu) {}
  
  public void run()
  {
    bing localbing = (bing)this.this$0.app.getBusinessHandler(85);
    if (!this.this$0.w) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("app", "QD");
      if (this.this$0.f != null) {
        ((JSONObject)localObject).put("assignType", Long.parseLong(this.this$0.f));
      }
      if (this.this$0.g != null) {
        ((JSONObject)localObject).put("assignKey", Long.parseLong(this.this$0.g));
      }
      if (this.this$0.h != null) {
        ((JSONObject)localObject).put("ext", this.this$0.h);
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
    str1 = this.this$0.sessionInfo.curFriendUin;
    str2 = this.this$0.e;
    str3 = this.this$0.d;
    str4 = this.this$0.i;
    if (i != 0)
    {
      localObject = null;
      localbing.a(str1, str2, str3, str4, (String)localObject);
      this.this$0.getActivity().runOnUiThread(new PublicAccountChatPie.57.1(this));
      localbing.a(this.this$0.sessionInfo.curFriendUin, this.this$0.e);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.57
 * JD-Core Version:    0.7.0.1
 */