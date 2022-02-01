package com.tencent.biz.subscribe;

import com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil.ResultListener;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.videostory.support.VSReporter;

class SubscribeJsPlugin$1
  implements SubscribeFollowUserUtil.ResultListener
{
  SubscribeJsPlugin$1(SubscribeJsPlugin paramSubscribeJsPlugin, String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      this.c.callJs(this.a, new String[] { "{\"result\":0}" });
      if (SubscribeJsPlugin.a(this.c) == null)
      {
        SubscribeJsPlugin.a(this.c, TroopMemberApiClient.a());
        SubscribeJsPlugin.a(this.c).e();
      }
      SubscribeJsPlugin.a(this.c).i(paramString, this.b);
      VSReporter.a(paramString, "auth_follow", "clk_unfollow", 0, 0, new String[] { "", "", this.b });
      return;
    }
    VSReporter.a(paramString, "auth_follow", "clk_cancel", 0, 0, new String[] { "", "", this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */